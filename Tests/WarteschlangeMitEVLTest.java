import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarteschlangeMitEVLTest {
    static Object[] arrayOfObjects = new Object[]{5116.98598,"lasuhd",5,1,6,4};

    WarteschlangeMitEVL<Object> wsMitEvl;

    @BeforeEach
    void setUp() {
        wsMitEvl = new WarteschlangeMitEVL<>();
    }

    @AfterEach
    void tearDown() {
        wsMitEvl = null;
    }

    @Test
    void isEmpty() {
        assertTrue(wsMitEvl.isEmpty(),"something went wrong");
        for (Object element :arrayOfObjects) {
            wsMitEvl.push(element);
        }
        assertFalse(wsMitEvl.isEmpty(),"something went wrong");
    }

    @Test
    void size() {
        assertEquals(wsMitEvl.size(),0,"something went wrong");
        for (Object element: arrayOfObjects) {
            wsMitEvl.push(element);
        }
        assertEquals(wsMitEvl.size(),6,"something went wrong");
    }

    @Test
    void capacity() {
        assertEquals(wsMitEvl.capacity(),Integer.MAX_VALUE,"something went wrong");
    }

    @Test
    void pushPop() {
        for (Object element: arrayOfObjects) {
            wsMitEvl.push(element);
            assertEquals(wsMitEvl.pop(),element,"something went wrong");
        }
    }

    @Test
    void front() {
        for (Object element: arrayOfObjects) {
            wsMitEvl.push(element);
        }
        for (int i = arrayOfObjects.length - 1; i <= 0 ; i--) {
            assertEquals(wsMitEvl.pop(),wsMitEvl.front());
        }
    }

    @Test
    void testEquals(){
        for (Object element: arrayOfObjects) {
            wsMitEvl.push(element);
        }
        for (int i = arrayOfObjects.length - 1; i <= 0 ; i--) {
            assertEquals(wsMitEvl, arrayOfObjects[i]);
        }
        wsMitEvl.pop();
    }
}