import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuchbaumTest {
    Suchbaum<Boxer> serchTree;
    Boxer boxer1;
    Boxer boxer2;
    Boxer boxerx;

    @BeforeEach
    void setUp() {
//        serchTree = new Suchbaum<>(Integer::compareTo);
        serchTree = new Suchbaum<>(new ComparatorBoxerGewicht());
        boxer1 = new Boxer("Mustermann","Max",1);
        boxer2 = new Boxer("Musterfrau","boo",2);
        boxerx = new Boxer("Mustermann","Max",11);

    }

    @AfterEach
    void tearDown() {
        serchTree = null;
    }
    @Test
    void contains() {
        serchTree.insert(boxer1);
        serchTree.insert(boxer2);
        serchTree.insert(boxerx);
        assertTrue(serchTree.contains(boxer1));
        assertTrue(serchTree.contains(boxer2));
        assertTrue(serchTree.contains(boxerx));
    }

    @Test
    void insert() {
        serchTree.insert(boxer1);
        serchTree.insert(boxer2);
        serchTree.insert(boxerx);
        System.out.println(serchTree.toString());;
    }

    @Test
    void deleteNode() {
        serchTree.insert(boxer1);
        serchTree.insert(boxer2);
        serchTree.insert(boxerx);
        System.out.println(serchTree.toString());;
        serchTree.remove(boxer2);
        System.out.println(serchTree.toString());;
        serchTree.remove(boxerx);
        System.out.println(serchTree.toString());;
    }
}