import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FolgeMitDynArrayTest {
    static Object[] elements = new Object[]{1,2,3,4,5,6,7,8,9};
    FolgeMitDynArray<Object> folgedynarr;
    @BeforeEach
    void setUo(){
        folgedynarr = new FolgeMitDynArray<>();
    }

    @AfterEach
    void tearDown(){
        folgedynarr = null;
    }

    @Test
    void remove() {
        assertThrows(UnsupportedOperationException.class,()->folgedynarr.remove(),"something is wrong");
    }

    @Test
    void get() {
        System.out.println("______________________________________");
        System.out.println("running: testGetAndSet");
        for (Object element: elements) {
            folgedynarr.insert(element);
        }
        assertEquals(folgedynarr.get(0),1);
        assertEquals(folgedynarr.get(8),9);
        assertEquals(folgedynarr.set(1,50),2);
        assertEquals(folgedynarr.get(1),50);
    }

    @Test
    void testInsertRemove() {
        System.out.println("______________________________________");
        System.out.println("running: testInsertRemove");
        for (Object element: elements) {
            folgedynarr.insert(element);
        }

        for (Object element: elements) {
            assertEquals(element,folgedynarr.remove(0));
        }
    }


    @Test
    void size() {
        System.out.println("______________________________________");
        System.out.println("running: testSize");
        assertEquals(folgedynarr.size(),0,"Number of elements should be 0");
        int i = 0;
        for (Object x : elements) {
            assertEquals(i,folgedynarr.size(),"something is wrong");
            folgedynarr.insert(x);
            i++;
        }
    }

    @Test
    void isEmpty() {
        System.out.println("______________________________________");
        System.out.println("running: testIsEmpty");
        assertTrue(folgedynarr.isEmpty());
        folgedynarr.insert(55);
        assertFalse(folgedynarr.isEmpty());
        folgedynarr.remove(0);
        assertTrue(folgedynarr.isEmpty());

    }

    @Test
    void iterator() {
        System.out.println("______________________________________");
        System.out.println("running: iterator");
        for (Object element: elements) {
            folgedynarr.insert(element);
        }
        int i = 0;
        for (Object element :folgedynarr) {
            assertEquals(elements[i],folgedynarr.remove(0));
            i++;
        }
    }

    @Test
    void addAll(){
        System.out.println("______________________________________");
        System.out.println("running: addAll");
        folgedynarr.insert(1);
        folgedynarr.insert(2);
        folgedynarr.insert(3);
        FolgeMitDynArray<Object> newFolge = new FolgeMitDynArray<>();
        newFolge.insert(4);
        newFolge.insert(5);
        newFolge.insert(6);
        folgedynarr.addAll(newFolge);
        for (int i = 1; i < 7; i++) {
            assertEquals(i,folgedynarr.remove(0),"something went wrong");
        }
    }

    @Test
    void addAllTo(){
        System.out.println("______________________________________");
        System.out.println("running: addAllTo");
        folgedynarr.insert(4);
        folgedynarr.insert(5);
        folgedynarr.insert(6);
        FolgeMitDynArray<Object> newFolge = new FolgeMitDynArray<>();
        newFolge.insert(1);
        newFolge.insert(2);
        newFolge.insert(3);
        FolgeMitDynArray<Object> folge = (FolgeMitDynArray<Object>) folgedynarr.addAllTo(newFolge);
        for (int i = 1; i < 7; i++) {
            assertEquals(i,folge.remove(0),"something went wrong");
        }
    }
}