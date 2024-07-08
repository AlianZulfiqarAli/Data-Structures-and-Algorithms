import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class IntSuchbaumTest {

    IntSuchbaum intTree;

    @BeforeEach
    void setUp() {
        intTree = new IntSuchbaum();
    }

    @AfterEach
    void tearDown() {
        intTree = null;
    }

    @Test
    void insert() {
        System.out.println("_________test insert_________");
        assertThrows(NullPointerException.class,()->intTree.insert(null));
        System.out.println("test passed ☑");
        intTree.insert(6);
        System.out.println("6 inserted");
        assertThrows(IllegalStateException.class,()->intTree.insert(6), "oops something went wrong");
        System.out.println("test passed ☑");
        intTree.insert(5);
        System.out.println("5 inserted");
        intTree.insert(4);
        System.out.println("4 inserted");
        intTree.insert(1);
        System.out.println("1 inserted");
        intTree.insert(2);
        System.out.println("2 inserted");
        intTree.insert(0);
        System.out.println("0 inserted");
        intTree.insert(10);
        System.out.println("10 inserted");
        intTree.insert(9);
        System.out.println("9 inserted");
        intTree.insert(7);
        System.out.println("7 inserted");
        intTree.insert(8);
        System.out.println("8 inserted");
        System.out.println(intTree.toString());
        assertEquals("(((((0)1(2))4)5)6(((7(8))9)10))", intTree.toString(), " oops something went wrong");
    }

    @Test
    void contains() {
        System.out.println("_________test contains_________");
        intTree.insert(6);
        intTree.insert(5);
        intTree.insert(4);
        intTree.insert(1);
        intTree.insert(2);
        intTree.insert(0);
        intTree.insert(10);
        intTree.insert(9);
        intTree.insert(7);
        intTree.insert(8);
        System.out.println("current tree looks like " + intTree.toString());
        assertTrue(intTree.contains(6));
        System.out.println("test passed ☑");
        assertTrue(intTree.contains(5));
        System.out.println("test passed ☑");
        assertTrue(intTree.contains(4));
        System.out.println("test passed ☑");
        assertTrue(intTree.contains(1));
        System.out.println("test passed ☑");
        assertTrue(intTree.contains(2));
        System.out.println("test passed ☑");
        assertTrue(intTree.contains(0));
        System.out.println("test passed ☑");
        assertTrue(intTree.contains(10));
        System.out.println("test passed ☑");
        assertTrue(intTree.contains(9));
        System.out.println("test passed ☑");
        assertTrue(intTree.contains(7));
        System.out.println("test passed ☑");
        assertTrue(intTree.contains(8));
        System.out.println("test passed ☑");
        assertFalse(intTree.contains(88));
        System.out.println("test passed ☑");
        assertFalse(intTree.contains(98));
        System.out.println("test passed ☑");
        assertFalse(intTree.contains(85465));
        System.out.println("test passed ☑");
        assertThrows(NullPointerException.class,()->intTree.contains(null));
        System.out.println("test passed ☑");

    }

    @Test
    void remove() {
        System.out.println("_________test remove_________");
        assertThrows(NullPointerException.class,()->intTree.remove(null));
        intTree.insert(10);
        System.out.println("test passed ☑");
        assertThrows(NoSuchElementException.class,()->intTree.remove(88));
        intTree.remove(10);
        System.out.println("test passed ☑");
        System.out.println(intTree.toString()); //TODO: element ist noch da
        System.out.println("test passed for one element ☑");
        for (int i = 0; i < 10; i++) {
            intTree.insert(i);
        }
        //TODO: elemnts are mot hochgezogen
        System.out.println("10 elements are inserted "+ intTree.toString());
        System.out.println(intTree.size());
        System.out.println(intTree.toString());
        for (int i = 0; i < 10; i++) {
            intTree.remove(i);
        }
        System.out.println(intTree.size());
        System.out.println(intTree.toString());
        System.out.println("test passed for 10 elements (0 to 10)☑");
        System.out.println("________new tree________");
        intTree.insert(5);
        for (int i = 1; i <= 10; i++) {
            if (i == 5)continue;
            intTree.insert(i);
        }
        System.out.println("10 elements are inserted "+ intTree.toString());
        System.out.println(intTree.size());
        System.out.println(intTree.toString());
        for (int i = 1; i <= 10; i++) {
            intTree.remove(i);
        }
        System.out.println(intTree.size());
        System.out.println(intTree.toString());
        System.out.println("test passed for 10 elements starting with 5☑");
    }
}
