import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class KellerspeicherMitArrayTest {

    static Integer[] arrayOfNumbers = new Integer[]{1,2,3,4,5,6,7,8,9,10};
    static String[] arrayOfStrings = new String[]{"boo","bar","foo","baz"};
    static Object[] arrayOfObjects = new Object[]{"hello",0,87687,254,878,"error"};
    KellerspeicherMitArray<Integer> ksmaMitInteger;
    KellerspeicherMitArray<String> ksmaMitStrings;
    KellerspeicherMitArray<Object> ksmaMitObjekts;

    @BeforeEach
    void setUp() {
        ksmaMitInteger = new KellerspeicherMitArray<>(10);
        ksmaMitStrings = new KellerspeicherMitArray<>(5);
        ksmaMitObjekts = new KellerspeicherMitArray<>(100);
    }

    @AfterEach
    void tearDown() {
        ksmaMitInteger = null;
        ksmaMitStrings = null;
        ksmaMitObjekts = null;
    }

    @Test
    void testIsEmpty(){

        assertTrue(ksmaMitInteger.isEmpty(),"ksma it is actually empty!");
        Integer testElement = 0xc0ffee;
        ksmaMitInteger.push(testElement);
        assertFalse(ksmaMitInteger.isEmpty(),"ksma it is actually empty!");

        assertTrue(ksmaMitStrings.isEmpty(),"ksma it is actually empty!");
        ksmaMitStrings.push("testElement");
        assertFalse(ksmaMitStrings.isEmpty(),"ksma it is actually empty!");

        assertTrue(ksmaMitObjekts.isEmpty(),"ksma it is actually empty!");
        ksmaMitObjekts.push("testElement");
        assertFalse(ksmaMitObjekts.isEmpty(),"ksma it is actually empty!");
    }

    @Test
    void testSize(){
        int i = 0;
        for (Integer testElement:
                arrayOfNumbers) {
            ksmaMitInteger.push(testElement);
            assertEquals(++i, ksmaMitInteger.size(), "Something is wrong with size.");
        }

    }

    @Test
    void testCapacity(){
        assertEquals(10, ksmaMitInteger.capacity(),"what? capacity is not the same!");
    }

    @Test
    void testPushPop(){
        for (Integer testElement:
            arrayOfNumbers) {
            ksmaMitInteger.push(testElement);
        }

        for (int i = arrayOfNumbers.length - 1; i >= 0 ; i--) {
            assertEquals(arrayOfNumbers[i], ksmaMitInteger.pop(),"something is wrong with pop");
        }

        for (String testElement:
                arrayOfStrings) {
            ksmaMitStrings.push(testElement);
        }

        for (int i = arrayOfStrings.length - 1; i >= 0 ; i--) {
            assertEquals(arrayOfStrings[i], ksmaMitStrings.pop(),"something is wrong with pop");
        }
    }

    @Test
    void testFront(){
        for (Integer testElement:
             arrayOfNumbers) {
            ksmaMitInteger.push(testElement);
            assertEquals(testElement, ksmaMitInteger.front(),"something is wrong with front");
        }

        for (String testElement:
                arrayOfStrings) {
            ksmaMitStrings.push(testElement);
            assertEquals(testElement, ksmaMitStrings.front(),"something is wrong with front");
        }

        for (Object testElement:
                arrayOfObjects) {
            ksmaMitObjekts.push(testElement);
            assertEquals(testElement, ksmaMitObjekts.front(),"something is wrong with front");
        }
    }

    @Test
    void testExeptions(){
        assertThrows(IllegalArgumentException.class,()-> ksmaMitInteger.push(null),"IllegalArgumentException is not thrown");
        for (Integer testElement:
             arrayOfNumbers) {
            ksmaMitInteger.push(testElement);
        }
        assertThrows(IllegalStateException.class,()-> ksmaMitInteger.push(0),"IllegalStateException is not thrown");

        while(!ksmaMitInteger.isEmpty())
            ksmaMitInteger.pop();
        assertThrows(NoSuchElementException.class,()-> ksmaMitInteger.pop(),"IllegalStateException is not thrown");
        assertThrows(NoSuchElementException.class,()-> ksmaMitInteger.front(),"IllegalStateException is not thrown");
    }
}