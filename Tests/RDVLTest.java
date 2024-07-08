import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class RDVLTest {

    static Object[] array = new Object[]{"hi", 654, 1.65484, 354654,5445};
    RDVL<Object> rdvl;
    @BeforeEach
    void setUp() {
        rdvl = new RDVL<>();
    }

    @AfterEach
    void tearDown() {
        rdvl = null;
    }

    @Test
    void testSize(){
        int sizeTest = 0;
        assertEquals(rdvl.size(),sizeTest, "size is not working");
        for (Object element: array) {
            rdvl.add(element);
            assertEquals(rdvl.size(),++sizeTest);
        }
        System.out.println("size test passed ☑");
    }
    @Test
    void testAdd(){
        //test if entry not changed for two elements
        rdvl.add(array[0]);
        assertEquals(rdvl.element(), array[0]);

        rdvl.add(array[1]);
        assertEquals(rdvl.entry.prev.data, array[1]);

        System.out.println("add test passed ☑");
    }

    @Test
    void testElementPrevAndNext(){
        assertThrows(NoSuchElementException.class, ()->rdvl.element(),"somethoing went wrong!");
        rdvl.add(585);
        assertEquals(585,rdvl.element(),"oops something went wrong!");
        rdvl.add(88);
        rdvl.add(66);
        rdvl.next(2);
        assertEquals(66,rdvl.element(),"oops something went wrong!");

        rdvl.prev(1);
        assertEquals(88,rdvl.element(),"oops something went wrong!");
        System.out.println("element(), next() and prev() test passed ☑");
    }

    @Test
    void testRemove(){
        assertThrows(NoSuchElementException.class,()->rdvl.remove(),"something went wrong!");
        for (Object element: array) {
            rdvl.add(element);
        }
        for (Object element: array) {
            assertEquals(element,rdvl.remove(),"something went wrong!");
        }
        System.out.println("remove() test passed ☑");
    }


}