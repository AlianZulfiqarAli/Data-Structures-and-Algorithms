import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EVLTest {
    static Integer[] arrayOfNumbers = new Integer[]{1,2,3,4,5,6,7,8,9};
    EVL<Integer> evl;

    @BeforeEach
    void setUp() {
        evl = new EVL<>();
    }

    @AfterEach
    void tearDown() {
        evl = null;
    }

    @Test
    void addUndGetFirst() {
        for (Integer element: arrayOfNumbers) {
            evl.addFirst(element);
            assertEquals(evl.getFirst(),element,"something went wrong!");
        }
        assertEquals(evl.getFirst(),arrayOfNumbers[arrayOfNumbers.length-1],"What is this??");
        System.out.println("add and get first test passed ☑");
    }

    @Test
    void addUndGitLast() {
        for (Integer element: arrayOfNumbers) {
            evl.addLast(element);
            assertEquals(evl.getLast(),element,"something went wrong");
        }
        assertEquals(evl.getLast(),arrayOfNumbers[arrayOfNumbers.length-1]);
        //test fuer ein element
        EVL<Integer> x = new EVL<>();
        x.addFirst(5);
        assertEquals(x.getLast(),5);
        System.out.println("add and get last test passed ☑");
    }


    @Test
    void removeLast() {
        for (Integer element: arrayOfNumbers) {
            evl.addLast(element);
        }
        for (int i = arrayOfNumbers.length-1; i >= 0; i--) {
            assertEquals(evl.removeLast(),arrayOfNumbers[i],"something went wrong");
        }
        assertThrows(NoSuchElementException.class,()->evl.removeLast(),"something went wrong");
        //test feur ein element
        EVL<Integer> x = new EVL<>();
        x.addFirst(5);
        assertEquals(x.removeLast(),5);
        System.out.println("removeLast test passed ☑");
    }

    @Test
    void contains() {
        for (Integer element: arrayOfNumbers) {
            evl.addLast(element);
        }
        for (Integer element: arrayOfNumbers) {
            assertTrue(evl.contains(element),"something went wrong");

        }
        assertFalse(evl.contains(null));
        System.out.println("contains test passed ☑");
    }

    @Test
    void size() {
        int size = 0;
        for (Integer element: arrayOfNumbers) {
            evl.addLast(element);
            assertEquals(evl.size(),++size,"something went wrong");
        }
        System.out.println("size test passed ☑");
    }

    @Test
    void testExeptions(){
        assertThrows(NoSuchElementException.class,()->evl.getFirst(),"Not as expected.");
        assertThrows(IllegalArgumentException.class,()->evl.addLast(null),"Not as expected.");
        assertThrows(NoSuchElementException.class,()->evl.removeLast(),"Not as expected.");
        System.out.println("exeptions test passed ☑");

    }
    @Test
    void testZip(){
        Object[] arrayTest = new Object[]{4,1,7,3,5,2,8,6};
        Object[] test = new Object[]{4,3,1,5,7,2,8,6};
        EVL<Object> list1= new EVL<>();
        for (int i = 0; i < 3; i++) {
            list1.addLast(arrayTest[i]);
        }
        EVL<Object> list2 = new EVL<>();
        for (int i = 3; i < arrayTest.length; i++) {
            list2.addLast(arrayTest[i]);
        }

        list1.zip(list2);
        for (Object x: test) {
            assertEquals(x,list1.removeFirst(),"something went wrong!");
        }
        System.out.println("zip test passed ☑");

    }

    @Test
    void testIterator(){
        for (Integer element: arrayOfNumbers) {
            evl.addLast(element);
        }
        int i = 0;
        for (Object x: evl) {
            assertEquals(arrayOfNumbers[i],x,"something went wrong!");
            i++;
        }

    }
}