import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaerbaumTest {

    Binaerbaum<Integer> baumleer = null;
    Binaerbaum<Integer> bll = null;
    Binaerbaum<Integer> brl = null;
    Binaerbaum<Integer> brr = null;
    Binaerbaum<Integer> bl = null;
    Binaerbaum<Integer> br = null;
    Binaerbaum<Integer> baum = null;
    Binaerbaum<Integer> bro = null;
    Binaerbaum<Integer> beispielBaum = null;

    @BeforeEach
    void setUp() {
        baumleer = new Binaerbaum<>();                                 //      (   )

        bll = new Binaerbaum<>(4, baumleer, baumleer);              //      ( 4 )
        brl = new Binaerbaum<>(6, baumleer, baumleer);              //      ( 6 )
        bro = new Binaerbaum<>(55,baumleer,baumleer);
        brr = new Binaerbaum<>(7, baumleer, bro);
                                    //      ( 7 )
                                    //         \
                                    //        ( 55 )


        bl = new Binaerbaum<>(2, bll,baumleer);                     //      ( 2 )
                                                                       //       /
                                                                       //      /
                                                                       //   ( 4 )


        br = new Binaerbaum<>(3, brl,brr);                          //         ( 3 )
                                                                       //         /   \
                                                                       //        /     \
                                                                       //      ( 6 )  ( 7 )
                                                                       //                \
                                                                       //              ( 55 )


        //beispiel baum aus dem übungsblatt
        beispielBaum = new Binaerbaum<>(1, bl,new Binaerbaum<>(3, brl,bro ));

                                                                       //         ( 1 )
                                                                       //          / \
                                                                       //      ( 2 ) ( 3 )
                                                                       //       /    /   \
                                                                       //      /    /     \
                                                                       //   ( 4 ) ( 6 )  ( 7 )



        baum = new Binaerbaum<>(1, bl,br);                          //         ( 1 )
                                                                       //          / \
                                                                       //      ( 2 ) ( 3 )
                                                                       //       /    /   \
                                                                       //      /    /     \
                                                                       //   ( 4 ) ( 6 )  ( 7 )
                                                                       //                   \
                                                                       //                 ( 55 )


    }

    @AfterEach
    void tearDown() {
        baumleer = null;
        bll = null;
        brl = null;
        brr = null;
        bl = null;
        br = null;
        beispielBaum = null;
        baum = null;
    }

    @Test
    void isEmpty() {
        System.out.println("_________test isEmpty_________");
        assertTrue(baumleer.isEmpty());
        System.out.println("test passed ☑");
        assertFalse(bll.isEmpty());
        System.out.println("test passed ☑");
        assertFalse(brl.isEmpty());
        System.out.println("test passed ☑");
        assertFalse(brr.isEmpty());
        System.out.println("test passed ☑");
        assertFalse(bl.isEmpty());
        System.out.println("test passed ☑");
        assertFalse(br.isEmpty());
        System.out.println("test passed ☑");
        assertFalse(beispielBaum.isEmpty());
        System.out.println("test passed ☑");
        assertFalse(baum.isEmpty());
        System.out.println("test passed ☑");
    }

    @Test
    void testHohe(){
        System.out.println("_________test hohe_________");
        assertEquals(0, baumleer.hohe(),"not possiable because the tree is still empty");
        System.out.println("test passed ☑");
        assertEquals(1, bll.hohe(),"not possiable because the tree has an element");
        System.out.println("test passed ☑");
        assertEquals(1, brl.hohe(),"not possiable because the tree has an element");
        System.out.println("test passed ☑");
        assertEquals(2, brr.hohe(),"not possiable because the tree has an element");
        System.out.println("test passed ☑");
        assertEquals(2, bl.hohe(),"not possiable because the tree more than an element");
        System.out.println("test passed ☑");
        assertEquals(3, br.hohe(),"not possiable because the tree more than an element");
        System.out.println("test passed ☑");
        assertEquals(1, bro.hohe(),"not possiable because the tree more than an element");
        System.out.println("test passed ☑");
        assertEquals(4, baum.hohe(),"not possiable because the tree more than 2 elements");
        System.out.println("test passed ☑");
        assertEquals(1, bro.hohe(),"not possiable because the tree more than an element");
        System.out.println("test passed ☑");

    }

    @Test
    void testSize(){
        System.out.println("_________test size_________");

        assertEquals(0, baumleer.size(),"there are no element in the tree");
        System.out.println("test passed ☑");
        assertEquals(1, bll.size(),"there is only one element here");
        System.out.println("test passed ☑");
        assertEquals(1, brl.size(),"there is only one element here");
        System.out.println("test passed ☑");
        assertEquals(2,brr.size(),"there are two elements");
        System.out.println("test passed ☑");
        assertEquals(2,bl.size(),"there are two elements");
        System.out.println("test passed ☑");
        assertEquals(4,br.size(),"there are 4 elements here");
        System.out.println("test passed ☑");
        assertEquals(6, beispielBaum.size(),"not possiable because the tree has only 6 elements");
        System.out.println("test passed ☑");
        assertEquals(7,baum.size(),"there are 7 elements here");
        System.out.println("test passed ☑");
    }

    @Test
    void testToString(){
        System.out.println("_________test toString_________");


        assertEquals("", baumleer.toString(),"oops something went wrong");
        System.out.println("test passed ☑");
        assertEquals("(4)", bll.toString(),"oops something went wrong");
        System.out.println("test passed ☑");
        assertEquals("(6)", brl.toString(),"oops something went wrong");
        System.out.println("test passed ☑");
        assertEquals("(55)",bro.toString(),"oops something went wrong");
        System.out.println("test passed ☑");
        assertEquals("(7(55))",brr.toString(),"oops something went wrong");
        System.out.println("test passed ☑");
        assertEquals("((4)2)",bl.toString(),"oops something went wrong");
        System.out.println("test passed ☑");
        assertEquals("((6)3(7(55)))",br.toString(),"oops something went wrong");
        System.out.println("test passed ☑");
        assertEquals("(((4)2)1((6)3(55)))",beispielBaum.toString(),"oops something went wrong");
        System.out.println("test passed ☑");
        assertEquals("(((4)2)1((6)3(7(55))))",baum.toString(),"oops something went wrong");
        System.out.println("test passed ☑");



    }

    @Test
    void testPreorder(){
        System.out.println("__________test preorder__________");
        baumleer.preorder();
        System.out.println();
        System.out.println("test passed ☑");
        bll.preorder();
        System.out.println();
        System.out.println("test passed ☑");
        brl.preorder();
        System.out.println();
        System.out.println("test passed ☑");
        brr.preorder();
        System.out.println();
        System.out.println("test passed ☑");
        bl.preorder();
        System.out.println();
        System.out.println("test passed ☑");
        br.preorder();
        System.out.println();
        System.out.println("test passed ☑");
        beispielBaum.preorder();
        System.out.println();
        System.out.println("test passed ☑");
        baum.preorder();
        System.out.println();
        System.out.println("test passed ☑");



    }

    @Test
    void testInorder(){
        System.out.println("__________test inorder__________");
        baumleer.inorder();
        System.out.println();
        System.out.println("test passed ☑");
        bll.inorder();
        System.out.println();
        System.out.println("test passed ☑");
        brl.inorder();
        System.out.println();
        System.out.println("test passed ☑");
        brr.inorder();
        System.out.println();
        System.out.println("test passed ☑");
        bl.inorder();
        System.out.println();
        System.out.println("test passed ☑");
        br.inorder();
        System.out.println();
        System.out.println("test passed ☑");
        beispielBaum.inorder();
        System.out.println();
        System.out.println("test passed ☑");
        baum.inorder();
        System.out.println();
        System.out.println("test passed ☑");
    }


    @Test
    void testPostorder(){
        System.out.println("__________test postorder__________");
        baumleer.postorder();
        System.out.println();
        System.out.println("test passed ☑");
        bll.postorder();
        System.out.println();
        System.out.println("test passed ☑");
        brl.postorder();
        System.out.println();
        System.out.println("test passed ☑");
        brr.postorder();
        System.out.println();
        System.out.println("test passed ☑");
        bl.postorder();
        System.out.println();
        System.out.println("test passed ☑");
        br.postorder();
        System.out.println();
        System.out.println("test passed ☑");
        beispielBaum.postorder();
        System.out.println();
        System.out.println("test passed ☑");
        baum.postorder();
        System.out.println();
        System.out.println("test passed ☑");
    }

    @Test
    void testBereitensuche(){
        System.out.println("__________test bereitenSuche__________");
        baumleer.bereitenSuche();
        System.out.println();
        System.out.println("test passed ☑");
        bll.bereitenSuche();
        System.out.println();
        System.out.println("test passed ☑");
        brl.bereitenSuche();
        System.out.println();
        System.out.println("test passed ☑");
        brr.bereitenSuche();
        System.out.println();
        System.out.println("test passed ☑");
        bl.bereitenSuche();
        System.out.println();
        System.out.println("test passed ☑");
        br.bereitenSuche();
        System.out.println();
        System.out.println("test passed ☑");
        beispielBaum.bereitenSuche();
        System.out.println();
        System.out.println("test passed ☑");
        baum.bereitenSuche();
        System.out.println();
        System.out.println("test passed ☑");
    }

}