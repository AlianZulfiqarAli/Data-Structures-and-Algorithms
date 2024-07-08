import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.BufferUnderflowException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;



class FifoLifoTest {
    static Integer[] arrayOfNumbers = new Integer[]{1,2,3,4,5,6,7,8,9,10};
    Fifo fifo = null;
    Lifo lifo = null;

    @BeforeEach
    void setUp() {
        fifo = new Fifo(10);
        lifo = new Lifo(10);
    }

    @AfterEach
    void tearDown() {
        fifo = null;
        lifo = null;
    }

    @Test
    void testSize(){
        int i = 0;
        for (Integer element:
                arrayOfNumbers) {
            fifo.push(element);
            lifo.push(element);
            assertEquals(++i, fifo.size(),"Something went wrong with size.");
            assertEquals(i, lifo.size(),"Something went wrong with size.");
        }
    }

    @Test
    void testPushPop(){
        //fuelle die Arrays mit elementen
        for (Integer element:
             arrayOfNumbers) {
            lifo.push(element);
            fifo.push(element);
        }

        for (Integer element:
             arrayOfNumbers) {
            assertEquals(element,fifo.pop(),"pop in fifo is not working!");
        }

        for (int i = arrayOfNumbers.length - 1; i >= 0; i--) {
            assertEquals(arrayOfNumbers[i],lifo.pop(), "something went wrong in lifo!");
        }

    }

    @Test
    void testExeptions(){
        assertThrows(BufferUnderflowException.class,()->fifo.pop(),"where is the exeption?");
        assertThrows(BufferUnderflowException.class,()->lifo.pop(),"where is the exeption?");
        assertThrows(IllegalArgumentException.class,()->fifo.push(null),"where is the exeption?");
        assertThrows(IllegalArgumentException.class,()->fifo.push(null),"where is the exeption?");

        for (Integer element:
                arrayOfNumbers) {
            lifo.push(element);
            fifo.push(element);
        }
        Integer tempElement = 0xc0ffee;
        assertThrows(IndexOutOfBoundsException.class,()->fifo.push(tempElement),"where is the exeption?");
        assertThrows(IndexOutOfBoundsException.class,()->fifo.push(tempElement),"where is the exeption?");

    }
}