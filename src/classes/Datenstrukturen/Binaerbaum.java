public class Binaerbaum<T> {
    protected BaumEl root;

    class BaumEl {
        BaumEl rechts, links;
        T data;

        public BaumEl() {
        }

        public BaumEl(T e) {
            data = e;
        }
    }

    public Binaerbaum() {
        root = new BaumEl();
    }

    public Binaerbaum(T e, Binaerbaum<T> rechts, Binaerbaum<T> links) {
        if (null == e || null == rechts || null == links)
            throw new IllegalArgumentException("Data can not be null");

        root = new BaumEl(e);
        root.links = rechts.root;
        root.rechts = links.root;
    }

    /**
     * @return True, wenn der Baum leer ist. Also hat keinen Inhalt
     */
    public boolean isEmpty() {
        return null == root.data;
    }

    /**
     * @return die Höhe des Baumes → Rekursiv
     */
    public int hohe() {
        return hohe(root);
    }

    /**
     * @return Anzahl der Werte im Baum als → Rekursiv
     */
    public int size() {
        return size(root);
    }

    /**
     * @return der Baum als Zeichenkette der Form
     * ((<links>)<wurzel>(<rechts>)) (ohne Leerzeichen)
     */
    @Override
    public String toString() {
        return toString(root);
    }

    /**
     * Recursive function to perform preorder traversal on the tree
     */
    public void preorder() {
        preorder(root);
    }

    /**
     * Recursive function to perform inorder traversal on the tree
     */
    public void inorder() {
        inorder(root);
    }

    /**
     * Recursive function to perform postorder traversal on the tree
     */
    public void postorder() {
        postorder(root);
    }


    public void bereitenSuche() {
        if (isEmpty())
            return;

        Schlange<BaumEl> breitenSuche = new SchlangeMitEVL<>();
        breitenSuche.insert(root);
        while (!breitenSuche.isEmpty()) {
            BaumEl element = breitenSuche.remove();
            if (element.data != null)
                System.out.print(element.data + " ");
            if (element.links != null)
                breitenSuche.insert(element.links);
            if (element.rechts != null)
                breitenSuche.insert(element.rechts);
        }
    }


    //____________________ Hilfsmethoden ____________________
    private int hohe(BaumEl root) {
        //if the tree is empty then no need to count
        if (isEmpty())
            return 0;

        // right and left counter count the nodes that the tree has
        int rightcounter = 0;
        int leftcounter = 0;

        // count nodes on the right side
        if (root.rechts != null && root.rechts.data != null)
            rightcounter += hohe(root.rechts) + 1;

        // count nodes on the left side
        if (root.links != null && root.links.data != null)
            leftcounter += hohe(root.links) + 1;

        // if there are no elements other than the root, the method will return 1. otherwise the height of the tree
        return 1 > (rightcounter > leftcounter ? rightcounter : leftcounter) ? 1 : ((rightcounter > leftcounter) ? rightcounter : leftcounter);
    }

    private int size(BaumEl root) {
        int counter = 0;
        if (root != null && root.data != null) {
            //increse counter by one because the root is not empty and has data
            counter++;
            // count nodes on the right side
            counter += size(root.rechts);
            counter += size(root.links);
        }
        return counter;
    }

    private String toString(BaumEl root) {
        String str = "";
        if (root != null && root.data != null) {
            str += "(";
            //get the data from the left side of the tree
            if (null != root.links)
                str += toString(root.links);
            //get data
            str += root.data;
            //get the data from the right side of the tree
            if (null != root.rechts)
                str += toString(root.rechts);
            str += ")";
        }
        return str;
    }

    private void preorder(BaumEl root) {
        if (isEmpty())
            return;
        if (root.data != null) {
            System.out.print(root.data + " ");
            // Traverse the left subtree
            preorder(root.links);
            // Traverse the right subtree
            preorder(root.rechts);
        }
    }

    private void inorder(BaumEl root) {
        if (isEmpty())
            return;
        if (root.data != null) {
            //Traverse the left subtree
            inorder(root.links);
            System.out.print(root.data + " ");
            //Traverse the right subtree
            inorder(root.rechts);
        }
    }

    private void postorder(BaumEl root) {
        if (isEmpty())
            return;
        if (root.data != null) {
            //Traverse the left subtree
            postorder(root.links);
            //Traverse the right subtree
            postorder(root.rechts);
            System.out.print(root.data + " ");
        }
    }


}
