import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    void removeElementFromList(){
        List<Integer> list = new LinkedList<Integer>();
        list.add(123);
        list.add(567);

        Integer i = 567;
        list.remove(i);

        Assertions.assertFalse(list.contains(567));
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
    @ValueSource (ints = {-1, 20, 30})
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

}