import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class WarteschlangeMitArrayTest {

    static Integer[] arrayOfNumbers = new Integer[]{1,2,3,4,5,6,7,8,9,10};
    static String[] arrayOfStrings = new String[]{"boo","bar","foo","baz"};
    static Object[] arrayOfObjects = new Object[]{"hello",0,87687,254,878,"error"};
    WarteschlangeMitArray<Integer> wsmaMitInteger;
    WarteschlangeMitArray<String> wsmaMitString;
    WarteschlangeMitArray<Object> wsmaMitObjekt;

    @BeforeEach
    void setUp() {
        wsmaMitInteger = new WarteschlangeMitArray<>(10);
        wsmaMitString = new WarteschlangeMitArray<>(6);
        wsmaMitObjekt = new WarteschlangeMitArray<>(6);

    }

    @AfterEach
    void tearDown() {
        wsmaMitInteger = null;
        wsmaMitString = null;
        wsmaMitObjekt = null;

    }

    @Test
    void testIsEmpty(){
        System.out.println("_________test isEmpty_________");

        assertTrue(wsmaMitInteger.isEmpty(),"ksma it is actually empty!");
        Integer testElement = 0xc0ffee;
        wsmaMitInteger.push(testElement);
        assertFalse(wsmaMitInteger.isEmpty(),"ksma it is actually empty!");

        assertTrue(wsmaMitString.isEmpty(),"ksma it is actually empty!");
        wsmaMitString.push("testElement");
        assertFalse(wsmaMitString.isEmpty(),"ksma it is actually empty!");

        assertTrue(wsmaMitObjekt.isEmpty(),"ksma it is actually empty!");
        wsmaMitObjekt.push("testElement");
        assertFalse(wsmaMitObjekt.isEmpty(),"ksma it is actually empty!");
    }

    @Test
    void testSize(){
        System.out.println("_________test size_________");
        int i = 0;
        for (Integer testElement:
                arrayOfNumbers) {
            wsmaMitInteger.push(testElement);
            assertEquals(++i, wsmaMitInteger.size(), "Something is wrong with size.");
        }
        for (Integer testElement:
                arrayOfNumbers) {
            wsmaMitInteger.pop();
            assertEquals(--i, wsmaMitInteger.size(), "Something is wrong with size.");
        }
    }

    @Test
    void testCapacity(){

        System.out.println("_________test capacity_________");
        assertEquals(10, wsmaMitInteger.capacity(),"what? capacity is not the same!");
    }

    @Test
    void testPushPop(){
        System.out.println("_________test push & pop_________");
        for (Integer testElement:
                arrayOfNumbers) {
            wsmaMitInteger.push(testElement);
        }

        for (Integer testElement:
             arrayOfNumbers) {
            assertEquals(testElement, wsmaMitInteger.pop(),"something is wrong in pop!");
        }

        for (String testElement:
                arrayOfStrings) {
            wsmaMitString.push(testElement);
        }

        for (String testElement:
                arrayOfStrings) {
            assertEquals(testElement, wsmaMitString.pop(),"something is wrong in pop!");
        }

        for (Object testElement:
                arrayOfObjects) {
            wsmaMitObjekt.push(testElement);
        }

        for (Object testElement:
                arrayOfObjects) {
            assertEquals(testElement, wsmaMitObjekt.pop(),"something is wrong in pop!");
        }

    }

    @Test
    void testTop(){
        System.out.println("_________test top_________");
        for (Integer testElement:
                arrayOfNumbers) {
            wsmaMitInteger.push(testElement);
        }
        while (!wsmaMitInteger.isEmpty()){
            assertEquals(wsmaMitInteger.top(), wsmaMitInteger.pop(),"something is wrong with top!");
        }

        for (String testElement:
                arrayOfStrings) {
            wsmaMitString.push(testElement);
        }
        while (!wsmaMitString.isEmpty()){
            assertEquals(wsmaMitString.top(), wsmaMitString.pop(),"something is wrong with top!");
        }

        for (Object testElement:
                arrayOfObjects) {
            wsmaMitObjekt.push(testElement);
        }
        while (!wsmaMitObjekt.isEmpty()){
            assertEquals(wsmaMitObjekt.top(), wsmaMitObjekt.pop(),"something is wrong with top!");
        }
    }

    @Test
    void testExeptions(){
        System.out.println("_________test Exeptions_________");
        assertThrows(IllegalArgumentException.class,()-> wsmaMitInteger.push(null),"IllegalArgumentException is not thrown");
        for (Integer testElement:
                arrayOfNumbers) {
            wsmaMitInteger.push(testElement);
        }
        assertThrows(IllegalStateException.class,()-> wsmaMitInteger.push(0),"IllegalStateException is not thrown");
        while(!wsmaMitInteger.isEmpty())
            wsmaMitInteger.pop();
        assertThrows(NoSuchElementException.class,()-> wsmaMitInteger.pop(),"IllegalStateException is not thrown");
        assertThrows(NoSuchElementException.class,()-> wsmaMitInteger.top(),"IllegalStateException is not thrown");
    }

}