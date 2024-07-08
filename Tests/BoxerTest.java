import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoxerTest {

    Boxer boxer1;
    Boxer boxer2;
    Boxer boxerx;

    @BeforeEach
    void setUp(){
        boxer1 = new Boxer("Mustermann","Max",1);
        boxer2 = new Boxer("Musterfrau","boo",2);
        boxerx = new Boxer("Mustermann","Max",1);
    }

    @AfterEach
    void tearDown(){
        boxer1 = null;
        boxer2 = null;
        boxerx = null;

    }

    @Test
    void testToString() {
        assertEquals("name=Mustermann, vorname=Max, gewicht=1", boxer1.toString(),"Something went wrong!");
        assertEquals("name=Musterfrau, vorname=boo, gewicht=2", boxer2.toString(),"Something went wrong!");
    }

    @Test
    void testEquals() {
        assertTrue(boxer1.equals(boxerx));
        assertFalse(boxer2.equals(boxerx));
    }
}