import java.util.Comparator;
import java.util.NoSuchElementException;

public class Suchbaum<T> extends Binaerbaum<T>{

    // Comparator, der für Vergleiche von Elementen verwendet wird
    Comparator<T> comp;

    // Konstruktor ohne Comparator
    public Suchbaum() {
        super();
        comp = null;
    }

    // Konstruktor mit Comparator
    public Suchbaum(Comparator<T> comp) {
        super();
        this.comp = comp;
    }

    // Gibt an, ob das angegebene Element im Baum enthalten ist
    // Durchläuft den Baum breitensuchend und gibt true zurück, wenn das Element gefunden wird
    public boolean contains(T i){
        // Alle Elemente sind vom null verschieden
        if (i == null)
            throw new NullPointerException();

        // Bereitensuche im Baum
        Schlange<BaumEl> queue = new SchlangeMitEVL<>();
        queue.insert(root);
        while (!queue.isEmpty()) {
            BaumEl element = queue.remove();
            if (i.equals(element.data))         // Gib true zurück, wenn das Element gefunden wird
                return true;
            else if (element.links != null)
                queue.insert(element.links);
            else if (element.rechts != null)
                queue.insert(element.rechts);
        }
        return false;
    }

    // Fügt das angegebene Element in den Baum ein
    // Durchläuft den Baum rekursiv und fügt das Element an der entsprechenden Stelle ein
    public void insert(T i){
        if (null == i)
            throw new NullPointerException();
        if (contains(i))
            throw new IllegalStateException("Value is already in the tree");
        if (isEmpty())
            root.data = i;
        else
            insert(root,i);

    }

    // Fügt das Element rekursiv an der entsprechenden Stelle ein
    private void insert(BaumEl root, T i) {
        // Suche im linken Teilbaum, falls i < als der Wurzel ist
        if (comp.compare(i,root.data)<0) {
            if (null == root.links) {
                root.links = new BaumEl(i);
            } else
                insert(root.links, i);
        }
        // Suche im rechten Teilbaum, falls i nicht < der wurzel ist
        else {
            if (null == root.rechts) {
                root.rechts = new BaumEl(i);
            } else
                insert(root.rechts, i);
        }
    }
    /**
     * Entfernt das angegebene Element aus dem Baum.
     *
     * @param i das zu entfernende Element
     * @throws NullPointerException wenn das Element null ist
     * @throws NoSuchElementException wenn der Baum das Element nicht enthält
     */
    public void remove(T i){
        if (null == i) //prüfe, ob Element null ist
            throw new NullPointerException();
        if (!contains(i)) //prüfe, ob Baum das Element enthält
            throw new NoSuchElementException("Der Baum enthaelt dieses Element nicht");
        if (size() == 1) //falls dies das einzige Element im Baum ist, setze den Wurzelknoten auf null
            root.data = null;
        else
            deleteNode(root,i); //ansonsten lösche den Knoten aus dem Baum

    }

    /**
     * Hilfsmethode zum rekursiven Löschen eines Knotens aus dem Baum.
     *
     * @param root der Wurzelknoten des Baums/Teilbaums, in dem der Knoten gelöscht werden soll
     * @param data die Daten des zu löschenden Knotens
     * @return der modifizierte Baum ohne den entfernten Knoten
     */
    private BaumEl deleteNode(BaumEl root, T data) {
        if(root == null) return root; //Sonderfall: Baum ist leer
        if(comp.compare(data,root.data) > 0){ //gehe nach rechts
            root.rechts = deleteNode(root.rechts, data);
        }else if(comp.compare(data,root.data) < 0){ //gehe nach links
            root.links = deleteNode(root.links, data);
        }else{ //gefunden
            if(root.links == null && root.rechts == null){ //es gibt keine Teilbäume
                root = null;
            }else if(root.rechts != null){ // Teilbaum rechts muss nach oben hochgezogen werden
                root.data = successor(root);
                root.rechts = deleteNode(root.rechts, root.data);
            }else{ // Teilbaum links muss nach oben hochgezogen werden
                root.data = predecessor(root);
                root.links = deleteNode(root.links, root.data);
            }
        }
        return root;
    }
    /**
     * Findet den Nachfolger eines Knotens im Baum.
     *
     * @param root der Wurzelknoten des Baums/Teilbaums, in dem gesucht wird
     * @return der Nachfolgerwert des Knotens
     */
    private T successor(BaumEl root){
        root = root.rechts;
        while(root.links != null){
            root = root.links;
        }
        return root.data;
    }
    /**
     * Findet den Vorgänger eines Knotens im Baum.
     *
     * @param root der Wurzelknoten des Baums/Teilbaums, in dem gesucht wird
     * @return der Nachfolgerwert des Knotens
     */
    private T predecessor(BaumEl root){
        root = root.links;
        while(root.rechts != null){
            root = root.rechts;
        }
        return root.data;
    }
}
