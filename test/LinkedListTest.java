import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    List<Integer> getList0to9(){
        List<Integer> list = new LinkedList<Integer>();
        for(int i = 0; i < 10; i++){
            list.add(i);
        }
        return list;
    }

    List<Integer> getListFromTo(int from, int to){
        List<Integer> list = new LinkedList<Integer>();
        for(int i = from; i < to; i++){
            list.add(i);
        }
        return list;
    }

    @Test
    void newListIsEmpty() {
        List<Integer> emptyList = new LinkedList<Integer>();

        Assertions.assertTrue(emptyList.isEmpty());
    }

    @Test
    void nonEmptyListIsNotEmpty() {
        List<Integer> list = new LinkedList<Integer>();

        list.add(12);

        Assertions.assertFalse(list.isEmpty());
    }

    @Test
    void addElement() {
        List<Integer> testList = new LinkedList();

        boolean isSuccesful = testList.add(12);

        Assertions.assertTrue(isSuccesful && !testList.isEmpty());
    }

    @ParameterizedTest
    @ValueSource (ints = {0,1,2})
    void hasCorrectSize(int length){
        List<Integer> list = new LinkedList<Integer>();

        for(int i = 0; i < length; i++){
            list.add(123);
        }

        assertEquals(length, list.size());
    }

    @Test
    void isIterable(){
        List<Integer> list = new LinkedList<Integer>();

        for(int i = 0; i < 5; i++){
            list.add(123);
        }
        int counter = 0;
        for(Integer integer: list){
            counter++;
            if(integer != 123) counter--;
        }

        Assertions.assertEquals(5, counter);
    }

    @Test
    void containsFindsValue(){
        List<Integer> list = new LinkedList<Integer>();
        list.add(123);
        list.add(567);
        int gibberish = 9999;

        Assertions.assertTrue(list.contains(567) && !list.contains(gibberish));
    }

    @Test
    void toArrayWorks(){
        List<Integer> list = new LinkedList<Integer>();
        list.add(123);
        list.add(567);

        Integer[] ints = list.toArray(new Integer[2]);


        Assertions.assertTrue(ints[0] == 123 && ints[1] == 567);
    }

    @Test
    void removeIndexFirstElementFromList(){
        List<Integer> list = new LinkedList<Integer>();
        list.add(123);
        list.add(567);


        list.remove(0);
        Assertions.assertFalse(list.contains(123));
    }

    @Test
    void removeIndexMiddleElementFromList(){
        List<Integer> list = new LinkedList<Integer>();
        list.add(123);
        list.add(567);
        list.add(8910);

        int value = list.remove(1);

        Assertions.assertEquals(567, value);
        Assertions.assertEquals(2, list.size());
        Assertions.assertTrue(list.contains(123));
        Assertions.assertTrue(list.contains(8910));
    }

    @Test
    void removeIndexLastElementFromList(){
        List<Integer> list = new LinkedList<Integer>();
        list.add(123);
        list.add(567);
        list.add(8910);

        int value = list.remove(2);

        Assertions.assertEquals(8910, value);
        Assertions.assertEquals(2, list.size());
        Assertions.assertTrue(list.contains(123));
        Assertions.assertTrue(list.contains(567));
    }

    @Test
    void removeFirstObjectFromList(){
        List<Integer> list = getList0to9();

        boolean isRemoved = list.remove(Integer.valueOf(0));

        Assertions.assertTrue(isRemoved, "Element didn't get removed");
        Assertions.assertEquals(9, list.size(),"List is not one smaller than the start list");
        Assertions.assertFalse(list.contains(0), "List still contains the removed Value");
    }

    @Test
    void removeLastObjectFromList(){
        List<Integer> list = getList0to9();

        boolean isRemoved = list.remove(Integer.valueOf(9));

        Assertions.assertTrue(isRemoved, "Element didn't get removed");
        Assertions.assertEquals(9, list.size(),"List is not one smaller than the start list");
        Assertions.assertFalse(list.contains(9), "List still contains the removed Value");

    }
    @Test
    void removeMiddleObjectFromList(){
        List<Integer> list = getList0to9();

        boolean isRemoved = list.remove(Integer.valueOf(1));

        Assertions.assertTrue(isRemoved, "Element didn't get removed");
        Assertions.assertEquals(9, list.size(),"List is not one smaller than the start list");
        Assertions.assertFalse(list.contains(1), "List still contains the removed Value");
    }

    @Test
    void removeFailsIfValueDoesNotExist(){
        List<Integer> list = getList0to9();

        boolean isRemoved = list.remove(Integer.valueOf(10));

        Assertions.assertFalse(isRemoved);
        Assertions.assertEquals(10, list.size());
    }


    @Test
    void findExistingValueInList(){
        List<Integer> list = new LinkedList<Integer>();
        list.add(123);
        list.add(567);


        int index = list.indexOf(567);

        Assertions.assertEquals(1, index);
    }

    @Test
    void failOnFindNonExistingNumber(){
        List<Integer> list = new LinkedList<Integer>();
        list.add(123);
        list.add(567);


        int index = list.indexOf(56789);

        Assertions.assertEquals(-1, index);
    }


    @ParameterizedTest
    @ValueSource (ints = {-1, 10, 20, 30})
    void throwErrorOnGetOutOfBounds(int testValues){
        List<Integer> list = getList0to9();

        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.get(testValues));
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2})
    void getValuesFromList(int index){
        List<Integer> list = getList0to9();

        Assertions.assertEquals(index, list.get(index));
    }

    @Test
    void containsAllIsTrue(){
        List<Integer> list = getList0to9();
        List<Integer> sublist = new LinkedList<>();
        sublist.add(2);
        sublist.add(3);
        sublist.add(4);

        Assertions.assertTrue(list.containsAll(sublist));
    }

    @Test
    void sublistFailsContainsAll(){
        List<Integer> list = getList0to9();
        List<Integer> sublist = new LinkedList<>();
        sublist.add(2);
        sublist.add(20);
        sublist.add(4);

        Assertions.assertFalse(list.contains(sublist));
    }

    @Test
    void addAllContainsAllSubitems(){
        List<Integer> list = getList0to9();
        List<Integer> sublist = new LinkedList<>();
        sublist.add(35);
        sublist.add(20);
        sublist.add(4);

        list.addAll(sublist);
        int totalElements = 13;

        Assertions.assertTrue(list.containsAll(sublist), "Endlist has all Elements of the inserted List");
        Assertions.assertEquals(totalElements, list.size(), "Endlist ist as long as both separate combined");
    }

    @Test
    void addElementOnIndex(){
        List<Integer> list = getList0to9();

        list.add(2, 100);

        Assertions.assertEquals(100, list.get(2));
    }

    @Test
    void addElementAsFirstElement(){
        List<Integer> list = getList0to9();

        list.add(0, 100);

        Assertions.assertEquals(100, list.get(0));
        Assertions.assertEquals(11, list.size());
    }

    @Test
    void addElementAsLastElement(){
        List<Integer> list = getList0to9();

        list.add(9, 100);

        Assertions.assertEquals(100, list.get(9));
        Assertions.assertEquals(11, list.size());

    }

    @Test
    void setFirstElement(){
        List<Integer> list = getList0to9();

        list.set(0, 100);

        Assertions.assertEquals(100, list.get(0));
    }

    @Test
    void setLastElement(){
        List<Integer> list = getList0to9();

        list.set(9, 100);

        Assertions.assertEquals(100, list.get(9));

    }

    @Test
    void lastIndexOf(){
        List<Integer> list = getList0to9();

        list.add(2);

        Assertions.assertEquals(10, list.lastIndexOf(2));
    }

    @Test
    void sublistAtStart(){
        List<Integer> list = getList0to9();
        List<Integer> listgoal = getListFromTo(0,3);

        assertIterableEquals(listgoal, list.subList(0,3));
        assertTrue(listgoal.containsAll(list.subList(0,3)));
        assertTrue(list.subList(0,3).containsAll(listgoal));
    }

    @Test
    void sublistOnEnd(){
        List<Integer> list = getList0to9();
        List<Integer> listGoal = getListFromTo(6,9);
        List<Integer> sublist = list.subList(6,9);



    }

    @Test
    void sublistWrongIndexThrowsError(){
        List<Integer> list = getList0to9();


        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> list.subList(5,20));
    }

    @Test
    void clearEmptysList(){
        List<Integer> list = getList0to9();

        list.clear();

        Assertions.assertEquals(0, list.size());
    }
}