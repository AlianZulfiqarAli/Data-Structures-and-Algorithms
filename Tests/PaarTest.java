import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PaarTest {
    Paar<Object,Object> paar1;
    Paar<Object,Object> paar2;
    Paar<Object,Object> paar12;
    @BeforeEach
    void setUp() {
        paar1 = new Paar<>(0,"foo");
        paar2 = new Paar<>(1,"bar");
        paar12 = new Paar<>(0,"foo");
    }
    @AfterEach
    void tearDown() {
        paar1 = null;
        paar2 = null;
        paar12 = null;
    }
    @Test
    void setBeide() {
        System.out.println("_________test setBeide_________");
        paar1.setErstes(2);
        paar1.setZweites("hoo");
        assertEquals(paar1.getErstes(),2);
        assertEquals(paar1.getZweites(),"hoo");
        paar2.setBeide(0.565,"AAAAAA");
        assertEquals(paar2.getErstes(),0.565);
        assertEquals(paar2.getZweites(),"AAAAAA");
    }
    @Test
    void testEquals() {

        System.out.println("_________test Equals_________");
        assertTrue(paar1.equals(paar12));
    }
    @Test
    void testToString() {
        System.out.println("_________test toString_________");
        assertEquals(paar1.toString(),"(0,foo)");
        assertEquals(paar2.toString(),"(1,bar)");
    }
}