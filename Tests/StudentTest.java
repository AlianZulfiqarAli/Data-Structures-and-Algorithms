import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    Student student1;
    Student student2;
    Student student3;
    Student studentx;

    @BeforeEach
    void setUp(){
        student1 = new Student("Mustermann","Max",1);
        student2 = new Student("Musterfrau","boo",2);
        student3 = new Student("Mustermann","Max",2);
        studentx = new Student("Mustermann","Max",1);
    }

    @AfterEach
    void tearDown(){
        student1 = null;
        student2 = null;
        studentx = null;

    }

    @Test
    void testToString() {
        assertEquals("name=Mustermann, vorname=Max, matNummer=1",student1.toString(),"Something went wrong!");
        assertEquals("name=Musterfrau, vorname=boo, matNummer=2",student2.toString(),"Something went wrong!");
    }

    @Test
    void testEquals() {
        assertEquals(student1, studentx);
        assertNotEquals(student2, studentx);
    }

    @Test
    void testcompareTo(){
        assertEquals(7,student1.compareTo(student2));
        assertEquals(0,student1.compareTo(studentx));
        assertEquals(1,student3.compareTo(student1));
    }

}