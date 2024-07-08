import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HelperTest {

    static Integer[] arrayOfNumbers = new Integer[]{1,2,3,4,5,6,7,8,9,10};
    Fifo fifo = null;
    Lifo lifo = null;
    AbstractIntegerBuffer toCompare;

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
    void testMove() throws Exception {
        for (Integer element:
                arrayOfNumbers) {
            lifo.push(element);
        }
        toCompare = lifo;
        Helper.move(fifo,lifo);

        assertEquals(toCompare,lifo,"something went wrong!");
    }

}