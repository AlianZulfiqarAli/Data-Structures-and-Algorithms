import java.util.NoSuchElementException;

public class IntSuchbaum extends Binaerbaum<Integer> {

    public IntSuchbaum(){
        super();
    }

    public boolean contains(Integer i){
        //alle elemente sind vom null verschieden
        if (i == null)
            throw new NullPointerException();
        // Bereitensuche im Baum
        Schlange<IntSuchbaum.BaumEl> queue = new SchlangeMitEVL<>();
        queue.insert(root);
        while (!queue.isEmpty()) {
            BaumEl element = queue.remove();
            if (i.equals(element.data))         //return true, wenn das element gufunden wird
                return true;
            if (element.links != null)
                queue.insert(element.links);
            if (element.rechts != null)
                queue.insert(element.rechts);
        }
        return false;
    }


    public void remove(Integer i){
        if (null == i)
            throw new NullPointerException();
        if (!contains(i))
            throw new NoSuchElementException("Der Baum enthaelt dieses Element nicht");
        if (size() == 1)
            root.data = null;
        else
            deleteNode(root,i);

    }

    private BaumEl deleteNode(BaumEl root, int data) {
        if(root == null) return root;
        if(data > root.data){ //move right
            root.rechts = deleteNode(root.rechts, data);
        }else if(data < root.data){ //move left
            root.links = deleteNode(root.links, data);
        }else{ //found it
            if(root.links == null && root.rechts == null){ //es gibt keine Teilbaueme
                root = null;
            }else if(root.rechts != null){ // Teilbaum rechts muss nach oben hochgezogen
                root.data = successor(root);
                root.rechts = deleteNode(root.rechts, root.data);
            }else{ // Teilbaum links muss nach oben hochgezogen
                root.data = predecessor(root);
                root.links = deleteNode(root.links, root.data);
            }
        }
        return root;
    }
    /**
     * @param root
     * @return node's successor value
     */
    private Integer successor(BaumEl root){
        root = root.rechts;
        while(root.links != null){
            root = root.links;
        }
        return root.data;
    }
    /**
     * @param root
     * @return node's predecessor value
     */
    private Integer predecessor(BaumEl root){
        root = root.links;
        while(root.rechts != null){
            root = root.rechts;
        }
        return root.data;
    }


    public void insert(Integer i){
        if (null == i)
            throw new NullPointerException();
        if (contains(i))
            throw new IllegalStateException("Value is already in the tree");
        if (isEmpty())
            root.data = i;
        else
            insert(root,i);

    }

    private void insert(BaumEl root, Integer i) {
        //suche um linken Teilbaum, falls i < als der Wurzel ist
        if (i.compareTo(root.data)<0) {
            if (null == root.links) {
                root.links = new BaumEl(i);
            } else
                insert(root.links, i);
        }//suche im rechten Teilbaum, falls i nicht < der wurzel ist
        else {
            if (null == root.rechts) {
                root.rechts = new BaumEl(i);
            } else
                insert(root.rechts, i);
        }
    }



}
