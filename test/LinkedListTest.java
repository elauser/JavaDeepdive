import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
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
}