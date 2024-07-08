import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SchlangeMitEVLTest {


    static Object[] elements = new Object[]{1,2,3,4,5,6,7,8,9};
    SchlangeMitEVL<Object> listAsQ;

    @BeforeEach
    void setUp() {
        listAsQ = new SchlangeMitEVL<>();
    }

    @AfterEach
    void tearDown(){
        listAsQ = null;
    }

    @Test
    void first() {
        System.out.println("______________________________________");
        System.out.println("running: first()");
        for (Object element: elements) {
            listAsQ.insert(element);
        }
        for (Object element:elements) {
            assertEquals(element,listAsQ.first(),"oops, something went wrong");
            listAsQ.remove();
        }
        System.out.println("first() test passed ☑");
    }

    @Test
    void insertUndRemove() {
        System.out.println("______________________________________");
        System.out.println("running: insert() und remove()");
        for (Object element: elements) {
            listAsQ.insert(element);
        }
        for (Object element:elements) {
            assertEquals(element,listAsQ.remove(),"oops, something went wrong");
        }
        for (Object element: elements) {
            listAsQ.insert(element);
            assertEquals(element,listAsQ.remove(),"oops, something went wrong");
        }
        System.out.println("insert() and remove() test passed ☑");
    }

    @Test
    void size() {
        System.out.println("______________________________________");
        System.out.println("running: size()");
        int size = 0;
        for (Object element: elements) {
            listAsQ.insert(element);
            assertEquals(listAsQ.size(),++size,"something went wrong");
        }
        System.out.println("size() test passed ☑");
    }

    @Test
    void isEmpty() {
        System.out.println("______________________________________");
        System.out.println("running: isEmpty()");
        assertTrue(listAsQ.isEmpty(),"oops something wnet wrong");
        for (Object element: elements) {
            listAsQ.insert(element);
            assertFalse(listAsQ.isEmpty());
            assertEquals(element,listAsQ.remove(),"oops, something went wrong");
        }
        assertTrue(listAsQ.isEmpty());
        System.out.println("isEmpty() test passed ☑");

    }

    @Test
    void iterator() {
        System.out.println("______________________________________");
        System.out.println("running: iterator()");
        for (Object element: elements) {
            listAsQ.insert(element);
        }
        int i = 0;
        for (Object element : listAsQ) {
            assertEquals(elements[i++], element,"oops something went wrong");
            listAsQ.remove();
        }
        System.out.println("iterator() test passed ☑");
    }
}