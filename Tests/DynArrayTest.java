import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.BufferUnderflowException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class DynArrayTest {

    static Object[] elements = new Object[]{1,2,3,4,5,6,7,8,9};
    DynArray<Object> arr;

    @BeforeEach
    void setUp() {
        arr = new DynArray<>();
    }

    @AfterEach
    void tearDown(){
        arr = null;
    }
    @Test
    void testSize() {
        System.out.println("______________________________________");
        System.out.println("running: testSize");
        assertEquals(arr.size(),0,"Number of elements should be 0");
        int i = 0;
        for (Object x : elements) {
            assertEquals(i,arr.size(),"something is wrong");
            arr.addLast(x);
            i++;
        }
    }

    @Test
    void testCapacity(){
        System.out.println("______________________________________");
        System.out.println("running: testCapacity");
        assertEquals(arr.capacity(),1,"Array size should be 1");
    }

    @Test
    void testAddFirst(){
        System.out.println("______________________________________");
        System.out.println("running: testAddFirst");
        arr.addFirst(1);
        assertEquals(arr.capacity(),1,"Array size should be 1");
        arr.addFirst(2);
        assertEquals(arr.capacity(),2,"Array size should be 1");
        arr.addFirst(3);
        assertEquals(arr.capacity(),4,"Array size should be 1");
        for (Object element: elements) {
            arr.addFirst(element);
        }
    }

    @Test
    void testAddLast(){
        System.out.println("______________________________________");
        System.out.println("running: testAddLast");
        arr.addLast(1);
        assertEquals(arr.capacity(),1,"Array size should be 1");
        arr.addLast(2);
        assertEquals(arr.capacity(),2,"Array size should be 1");
        arr.addLast(3);
        assertEquals(arr.capacity(),4,"Array size should be 1");
        for (Object element: elements) {
            arr.addLast(element);
        }
    }

    @Test
    void testRemoveFirst(){
        System.out.println("______________________________________");
        System.out.println("running: testRemoveFirst");
        System.out.println("test 1");
        arr.addFirst(1);
        assertEquals(arr.capacity(),1,"Array size should be 1");
        assertEquals(arr.removeFirst(),1,"we just want the first Element");
        assertEquals(arr.size(),0,"something is seriously wrong");
        System.out.println("done: test 1");
        System.out.println("test 2");
        arr.addFirst(1);
        arr.addFirst(2);
        assertEquals(arr.capacity(),2,"Array size should be 1");
        assertEquals(arr.removeFirst(),2,"we just want the first Element");
        assertEquals(arr.size(),1,"something is seriously wrong");
        arr.removeFirst();
        System.out.println("done: test 2");
        System.out.println("test 3");
        arr.addFirst(1);
        arr.addFirst(2);
        arr.addFirst(3);
        assertEquals(arr.capacity(),4,"Array size should be 1");
        assertEquals(arr.removeFirst(),3,"we just want the first Element");
        assertEquals(arr.size(),2,"something is seriously wrong");
        assertEquals(arr.capacity(),4,"Array size should be 1");
        arr.removeFirst();
        arr.removeFirst();
        System.out.println("done: test 3");
        System.out.println("test 4");
        for (Object element: elements) {
            arr.addFirst(element);
        }
        for (int i = elements.length -1; i >= 0 ; i--) {
            assertEquals(arr.removeFirst(),elements[i],"That should have not happened");
        }
        assertEquals(arr.size(),0,"something is seriously wrong");
        assertEquals(arr.capacity(),1,"Array size should be 1");
        System.out.println("done test 4");
    }

    @Test
    void testRemoveLast(){
        System.out.println("______________________________________");
        System.out.println("running: testRemoveLast");
        System.out.println("test 1");
        arr.addFirst(1);
        assertEquals(arr.capacity(),1,"Array size should be 1");
        assertEquals(arr.removeLast(),1,"we just want the first Element");
        assertEquals(arr.size(),0,"something is seriously wrong");
        System.out.println("done: test 1");
        System.out.println("test 2");
        arr.addFirst(1);
        arr.addFirst(2);
        assertEquals(arr.capacity(),2,"Array size should be 1");
        assertEquals(arr.removeLast(),1,"we just want the first Element");
        assertEquals(arr.size(),1,"something is seriously wrong");
        arr.removeLast();
        System.out.println("done: test 2");
        System.out.println("test 3");
        arr.addFirst(1);
        arr.addFirst(2);
        arr.addFirst(3);
        assertEquals(arr.capacity(),4,"Array size should be 1");
        assertEquals(arr.removeLast(),1,"we just want the first Element");
        assertEquals(arr.size(),2,"something is seriously wrong");
        assertEquals(arr.capacity(),4,"Array size should be 1");
        arr.removeLast();
        arr.removeLast();
        System.out.println("done: test 3");
        System.out.println("test 4");
        for (Object element: elements) {
            arr.addFirst(element);
        }
        for (Object element: elements) {
            assertEquals(arr.removeLast(),element,"That should have not happened");
        }
        assertEquals(arr.size(),0,"something is seriously wrong");
        assertEquals(arr.capacity(),1,"Array size should be 1");
        System.out.println("done test 4");
    }

    @Test
    void testGetAndSet(){
        System.out.println("______________________________________");
        System.out.println("running: testGetAndSet");
        for (Object element: elements) {
            arr.addFirst(element);
        }
        assertEquals(arr.get(0),9);
        assertEquals(arr.get(8),1);
        assertEquals(arr.set(1,50),8);
        assertEquals(arr.get(1),50);
    }



    @Test
    void testExeptions(){
        System.out.println("______________________________________");
        System.out.println("running: testExeptions");
        assertThrows(BufferUnderflowException.class,()->arr.get(-1));
        arr.addFirst(2);
        arr.addFirst(1241);
        assertThrows(IllegalArgumentException.class,()->arr.set(0,null));
        arr.removeLast();
        arr.removeLast();
        assertThrows(NoSuchElementException.class,()->arr.removeLast());
    }


    @Test
    void testInsert(){
        System.out.println("______________________________________");
        System.out.println("running: testInsert");
        assertThrows(IndexOutOfBoundsException.class,()->arr.insert(50,0));
        arr.addFirst(1);
        arr.insert(0,0);
        assertEquals(arr.get(0),0,"insert is not working!");
        assertEquals(arr.size(), 2, "size is not working");
        assertEquals(arr.capacity(),arr.size(),"this should not have happend");
        arr.insert(55,1);
        assertEquals(arr.capacity(),4);
        assertEquals(arr.size(),3);
        assertEquals(arr.get(0),0);
        assertEquals(arr.get(1),55);
        assertEquals(arr.get(2),1);
    }


    @Test
    void testRemove(){
        System.out.println("______________________________________");
        System.out.println("running: testRemove With pos");
        assertThrows(BufferUnderflowException.class,()->arr.remove(1));
        arr.addFirst(5);
        assertThrows(IndexOutOfBoundsException.class,()->arr.remove(-1));
        assertThrows(IndexOutOfBoundsException.class,()->arr.remove(2));
        assertEquals(arr.remove(0),5,"hmm something went wrong!");
        arr.addFirst(84);
        arr.addLast(6);
        arr.addLast(9);
        arr.addLast(109);
        assertEquals(arr.remove(3),109,"oops, something went wrong");
        assertEquals(arr.remove(0),84,"oops, something went wrong");
        assertEquals(arr.remove(0),6,"oops, something went wrong");
        assertEquals(arr.remove(0),9,"oops, something went wrong");
        assertEquals(arr.capacity(),1, "the array is still too big");
    }

    @Test
    void testIterator(){
        System.out.println("______________________________________");
        System.out.println("running: testIterator");
        for (Object x : elements) {
            arr.addLast(x);
        }
        int i = 0;
        for (Object x : arr) {
            assertEquals(elements[i],x,"something went wrong");
            i++;
        }
    }
}
