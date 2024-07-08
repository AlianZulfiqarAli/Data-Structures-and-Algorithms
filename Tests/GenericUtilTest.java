import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class GenericUtilTest {

    @Test
    void gambling() {
        String str1 = "foo";
        String str2 = "bar";
        // Test that gambling returns str1 with probability 0.55
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < 100; i++) {
            if (GenericUtil.gambling(str1, str2) == str1) {
                count1++;
            } else {
                count2++;
            }
        }
        assertTrue(count1 > 30 && count1 < 70, "gambling does not return str1 with probability 0.55");
        assertTrue(count2 > 30 && count2 < 70, "gambling does not return str2 with probability 0.45");

        // Test that gambling throws a NullPointerException when given null arguments
        assertThrows(NullPointerException.class, () -> GenericUtil.gambling(null, str2));
        assertThrows(NullPointerException.class, () -> GenericUtil.gambling(str1, null));
    }

    @Test
    void arrayToSchlange() {
        Integer[] array = {1, 2, 3, 4, 5};
        Schlange<Integer> queue = GenericUtil.arrayToSchlange(array);
        assertEquals(1, queue.remove(), "arrayToSchlange did not correctly add elements to the queue");
        assertEquals(2, queue.remove(), "arrayToSchlange did not correctly add elements to the queue");
        assertEquals(3, queue.remove(), "arrayToSchlange did not correctly add elements to the queue");
        assertEquals(4, queue.remove(), "arrayToSchlange did not correctly add elements to the queue");
        assertEquals(5, queue.remove(), "arrayToSchlange did not correctly add elements to the queue");
        assertTrue(queue.isEmpty(), "arrayToSchlange did not correctly add elements to the queue");
    }

    @Test
    void printAll() {
        Schlange<String> queue = new SchlangeMitEVL<>();
        queue.insert("foo");
        queue.insert("bar");
        queue.insert("baz");
        GenericUtil.printAll(queue);
    }

    @Test
    void insertInto() {
        Schlange<String> queue1 = new SchlangeMitEVL<>();
        Schlange<String> queue2 = new SchlangeMitEVL<>();
        queue2.insert("foo");
        queue2.insert("bar");
        GenericUtil.insertInto(queue1, queue2);
        assertEquals("foo", queue1.remove(), "insertInto did not correctly insert elements into the buffer");
        assertEquals("bar", queue1.remove(), "insertInto did not correctly insert elements into the buffer");
        assertTrue(queue1.isEmpty(), "insertInto did not correctly insert elements into queue1");
        String[] array = {"baz", "qux"};
        GenericUtil.insertInto(queue1, array);
        assertEquals("baz", queue1.remove(), "insertInto did not correctly insert elements into the buffer");
        assertEquals("qux", queue1.remove(), "insertInto did not correctly insert elements into the buffer");
        assertTrue(queue1.isEmpty(), "insertInto did not correctly insert elements into the buffer");
    }

    @Test
    void getMinima() {
        SchlangeMitEVL<Integer> puffer6 = new SchlangeMitEVL<>(); // 1 55 3 4
        SchlangeMitEVL<Integer> puffer7 = new SchlangeMitEVL<>(); // 5 2  5 4 5
        puffer6.insert(1);
        puffer7.insert(5);
        puffer6.insert(55);
        puffer7.insert(2);
        puffer6.insert(3);
        puffer7.insert(5);
        puffer6.insert(4);
        puffer7.insert(4);
        puffer7.insert(5);

        //insert to buffers into a dynarray
        Folge<Integer> minima = GenericUtil.getMinima(puffer6, puffer7); //1 2 3 4 5

        int[] expected = {1, 2, 3, 4, 5};
        for (int element : expected) {
            assertEquals(element, minima.remove(0), "getMinima did not return the expected minimum element");
        }
        assertTrue(minima.isEmpty(), "getMinima did not return the expected number of minimum elements");
        assertThrows(NoSuchElementException.class,
                () -> GenericUtil.getMinima(new SchlangeMitEVL<Integer>(),
                        new SchlangeMitEVL<>()));


        // Create a Comparator that compares Integer objects
        Comparator<Integer> comparator = (i1, i2) -> i1 - i2;
        // Call the getMinima method and store the result in a Folge object
        Folge<Integer> result = GenericUtil.getMinima(puffer6, puffer7, comparator);
        for (int i = 1; i < 5; i++) {
            assertEquals(i, result.remove(0), "oops");
        }

        assertThrows(NoSuchElementException.class,
                () -> GenericUtil.getMinima(new SchlangeMitEVL<Integer>(),
                        new SchlangeMitEVL<>(), comparator));

    }

    @Test
    void testGetMaximum() {
        // Create two empty buffers
        Puffer<Integer> buffer1 = new SchlangeMitEVL<>();
        Puffer<Integer> buffer2 = new SchlangeMitEVL<>();
        // Check that getMaximum throws an exception when both buffers are empty
        assertThrows(NoSuchElementException.class, () -> GenericUtil.getMaximum(buffer1, buffer2));

        // Insert some elements into the first buffer
        buffer1.insert(1);
        buffer1.insert(2);
        buffer1.insert(3);
        // Insert some elements into the second buffer
        buffer2.insert(4);
        buffer2.insert(55);
        buffer2.insert(6);
        // Test the getMaximum method using the default comparator
        assertEquals(55, GenericUtil.getMaximum(buffer1, buffer2).intValue());

        // Test the getMaximum method using a custom comparator
        Comparator<Integer> comparator = (a, b) -> b - a;
        assertEquals(1, GenericUtil.getMaximum(buffer1, buffer2, comparator));


        Boxer boxer = new Boxer("foo", "bar", 123);
        Student student = new Student("me", "you", 321);
        Puffer<Student> pufferStudent = new SchlangeMitEVL<>();
        pufferStudent.insert(student);
        Puffer<Boxer> pufferBoxer = new SchlangeMitEVL<>();
        pufferBoxer.insert(boxer);
        assertEquals(student,GenericUtil.getMaximum(pufferStudent,pufferBoxer));

    }
}