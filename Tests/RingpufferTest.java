import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RingpufferTest {
    static Object[] elements = new Object[]{1,2,3,"foo","bar",6.789};
    Ringpuffer<Object> ring;

    @BeforeEach
    void setUp() {
        ring = new Ringpuffer<>(6);
    }

    @AfterEach
    void tearDown() {
        ring = null;
    }

    @Test
    void testSize(){
        assertEquals(0,ring.size(),"how is this even possible?");
        int i = 0;
        while (i < elements.length -1) {
            ring.addLast(elements);
            assertEquals(++i, ring.size(),"something went wrong!");
        }
        while (i < elements.length -1) {
            ring.removeLast();
            assertEquals(--i, ring.size(),"something went wrong!");
        }
    }

    @Test
    void testCapacity(){
        assertEquals(6,ring.capacity(),"how is this even possible?");
    }

    @Test
    void testGetAndSet(){
        ring.addLast(6);
        ring.addLast(3);
        ring.addLast(5);
        ring.addLast(8);
        assertEquals(6,ring.get(0));
        assertEquals(3,ring.get(1));
        assertEquals(5,ring.get(2));
        assertEquals(8,ring.get(3));
        assertEquals(6,ring.removeFirst());
        ring.addLast(9);
        ring.addLast(11);
        assertEquals(3,ring.set(55,0));
        assertEquals(55,ring.get(0));
        ring.addLast(9);

        assertEquals(9,ring.set("9908945",5));
        assertEquals("9908945",ring.get(5));
    }

    @Test
    void testAddLastAndRemoveLast(){
        for (int i = 0; i < 5; i++)
            ring.addLast(elements[i]);

        assertEquals(elements[4],ring.removeLast());
        assertEquals(elements[3],ring.removeLast());
        for (int i = 0; i < 3; i++)
            ring.addLast(elements[i]);
        while (ring.size() != 1)
            ring.removeFirst();
        System.out.println(ring.getEntryPosition());
        ring.addLast(65);
        ring.addLast(44);
        ring.addLast(335);
        assertEquals(335,ring.removeLast());
        assertEquals(44,ring.removeLast());
        assertEquals(65,ring.removeLast());
        assertEquals(3,ring.removeLast());


    }

    @Test
    void testAddFirstAndRemoveFirst(){
        for (int i = 0; i < 6; i++)
            ring.addFirst(elements[i]);
        for (int i = 0; i < 6; i++)
            ring.removeFirst();
        for (int i = 0; i < 6; i++)
            ring.addFirst(elements[i]);
    }

    @Test
    void testBeispielVorlesung(){
        System.out.println("____skript____");
        ring = new Ringpuffer<>(8);
        ring.addLast(6);
        ring.addLast(3);
        ring.addLast(5);
        ring.addLast(8);
        assertEquals(6,ring.removeFirst());
        assertEquals(3,ring.removeFirst());
        ring.addLast(10);
        ring.addLast(13);
        ring.addLast(15);
        ring.addLast(18);
        ring.addLast(21);
        ring.addLast(11);
        assertEquals(5,ring.removeFirst());
        ring.addLast(42);
        System.out.println("____Folien____");
        tearDown();
        ring = new Ringpuffer<>(4);
        ring.addLast(3);
        ring.addLast(7);
        ring.addLast(5);
        assertEquals(3,ring.removeFirst());
        ring.addLast(9);
        ring.addLast(11);
        assertEquals(7,ring.removeFirst());
    }

    @Test
    void testExeptions(){
        System.out.println("____Exeptions____");

        assertThrows(BufferUnderflowException.class,()->ring.removeFirst());
        assertThrows(BufferUnderflowException.class,()->ring.removeLast());
        for (int i = 0; i < 6; i++)
            ring.addLast(elements[i]);
        assertThrows(IndexOutOfBoundsException.class,()->ring.addLast(5));
        tearDown();
        setUp();
        assertThrows(NullPointerException.class,()->ring.addLast(null));
        assertThrows(NullPointerException.class,()->ring.addFirst(null));
        for (int i = 0; i < 6; i++)
            ring.addLast(elements[i]);

        assertThrows(BufferOverflowException.class,()->ring.addFirst(5));
        assertThrows(IndexOutOfBoundsException.class,()->ring.get(564));
        assertThrows(NullPointerException.class,()->ring.set(null,-5));
        assertThrows(NullPointerException.class,()->ring.insert(null,0));


    }

    @Test
    void testInsert(){
        System.out.println("____Insert with pos____");

        assertThrows(IndexOutOfBoundsException.class,()->ring.insert("heeeyyy",1),"oops something went wrong");
        ring.addLast(5);
        ring.addLast(66);
        ring.addLast(777);
        System.out.println("test insert in the middel");
        ring.insert(6.555,2);
        ring.addLast(8888);
        ring.addLast(999);
        assertThrows(BufferOverflowException.class,()->ring.insert(1000,3),"memory should be full by now");
        ring.removeFirst();
        System.out.println("test insert in the middel with array looking like [null,e,e,e,e,e]");
        ring.insert(1000,3);
        System.out.println("test insert at pos = 0 with array looking like [e,e,e,e,e,null]");
        ring.removeLast();
        ring.insert(2000,0);
        System.out.println(ring.size());
    }

    @Test
    void testRemoveWithPos(){
        assertThrows(BufferUnderflowException.class, ()->ring.remove(0), "oops something went wromg");
        ring.addLast(4);
        assertThrows(IndexOutOfBoundsException.class,()->ring.remove(1),"oops something went wrong");
        assertEquals(4,ring.remove(0),"oops something went wromg");
        ring.addLast(10);
        ring.addLast(13);
        ring.addLast(15);
        ring.addLast(18);
        ring.addLast(21);
        assertEquals(0,ring.getEntryPosition(),"something went wrong");
        assertEquals(4,ring.getEndPosition(),"something went wrong");
        assertEquals(13,ring.remove(1),"something went wrong");
        assertEquals(15,ring.remove(1),"something went wrong");
        assertEquals(18,ring.remove(1),"something went wrong");
        assertEquals(21,ring.remove(1),"something went wrong");
        assertEquals(10,ring.remove(0),"something went wrong");
        assertEquals(-1,ring.getEntryPosition(),"something went wrong");
        assertEquals(-1,ring.getEndPosition(),"something went wrong");
        ring.addLast(15);
        ring.addLast(15);
        ring.addLast(15);
        ring.addLast(15);
        ring.addLast(15);
        ring.addLast(15);
        ring.removeFirst();
        ring.removeFirst();
        ring.removeFirst();
        ring.removeFirst();
        ring.addLast(14);
        ring.addLast(16);
        assertEquals(16,ring.remove(3),"something went wrong");
        assertEquals(14,ring.remove(2),"something went wrong");
        assertEquals(15,ring.remove(1),"something went wrong");
        assertEquals(4,ring.getEntryPosition(),"something went wrong");
        assertEquals(4,ring.getEndPosition(),"something went wrong");
        assertEquals(15,ring.remove(0),"something went wrong");
        assertEquals(-1,ring.getEndPosition(),"something went wrong");
        assertEquals(-1,ring.getEndPosition(),"something went wrong");
    }
}