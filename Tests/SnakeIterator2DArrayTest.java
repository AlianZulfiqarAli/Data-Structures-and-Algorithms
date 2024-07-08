import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SnakeIterator2DArrayTest {

    static Object[][] array;
    SnakeIterator2DArray<Object> snakeIterator2DArray;
    @BeforeEach
    void setUp(){
        array = new Object[][]{{1 ,2 ,3 ,4} ,{5 ,6 ,7 ,8} ,{9 ,10 ,11 ,12}};
        snakeIterator2DArray = new SnakeIterator2DArray<>(array);
    }
    @Test
    void next() {
        while (snakeIterator2DArray.hasNext()) {
            System.out.print(snakeIterator2DArray.next()+ " ");
        }
    }
}