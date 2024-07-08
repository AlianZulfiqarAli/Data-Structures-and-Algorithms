import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person1;
    Person person2;
    Person personx;


    @BeforeEach
    void setUp() {
        person1 = new Person("foo","boo");
        person2 = new Person("bar","baz");
        personx = new Person("foo","boo");
    }

    @AfterEach
    void tearDown() {
        person1 = person2 = personx = null;
    }

    @Test
    void testToString() {
        assertEquals("name=foo, vorname=boo",person1.toString(),"something went wrong!");
        assertEquals("name=bar, vorname=baz",person2.toString(),"something went wrong!");
    }

    @Test
    void testEquals() {
        assertTrue(person1.equals(personx),"this should have not happend");
        assertFalse(person2.equals(person1),"this should have not happend");
    }
}