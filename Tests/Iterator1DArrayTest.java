import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Iterator1DArrayTest {

    Object[] array = new Object[]{1,2,3,4,5,6,7,8,9};
    Iterator1DArray<Object> loop;

    @Test
    void testVorwaerts(){
        System.out.println("_________test vorwaerts_________");
        loop = new Iterator1DArray<>(array);

        int i = 0;
        while (loop.hasNext()){
            assertEquals(array[i],loop.next(),"oops something went wrong ");
            i++;
        }
        System.out.println("test passed");
    }

    @Test
    void testStartpunkt(){
        System.out.println("_________test von einem startindex_________");
        loop = new Iterator1DArray<>(array,5);

        int i = 5;
        while (loop.hasNext()){
            assertEquals(array[i],loop.next(),"oops something went wrong ");
            i++;
        }
        System.out.println("test passed");
    }

    @Test
    void testEndPunkt(){
        System.out.println("_________test bis einem endindex_________");
        loop = new Iterator1DArray<>(array,1,5);

        int i = 1;
        while (loop.hasNext()){
            assertEquals(array[i],loop.next(),"oops something went wrong ");
            i++;
            if (i == 5)
                break;
        }
        System.out.println("test passed");
    }
}