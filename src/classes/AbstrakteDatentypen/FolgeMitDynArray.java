import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class FolgeMitDynArray<T> implements Folge<T> {

    private final DynArray<T> folgeMitDynArray = new DynArray<>();

    /**
     * Mit der Methode wird e an der spezifizierten Position pos eingefügt. Das Element, das momentan
     * an der Position steht und die folgenden (wenn vorhanden) werden nach rechts verschoben
     * (die Indizes sind dann jeweils um eins erhöht).
     *
     * @param pos Die Position in der Menge
     * @param e   Data
     */
    @Override
    public void insert(int pos, T e) {
        folgeMitDynArray.insert(e, pos);

    }

    /**
     * Die Methode überschreibt das Element an Index pos und gibt den alten Wert zurück
     *
     * @param pos Die Position in der Menge
     * @param e   Data
     * @return Das alte Element
     */
    @Override
    public T set(int pos, T e) {
        return folgeMitDynArray.set(pos, e);
    }

    /**
     * Beim Entfernen von Elementen mit der Methode soll das Element am Index pos
     * entfernt werden und alle darauf folgenden Elemente nachrutschen.
     *
     * @param pos Die Position in der Menge
     * @return Das Element, das entfernt wurde.
     */
    @Override
    public T remove(int pos) {
        return folgeMitDynArray.remove(pos);
    }

    /**
     * Die Methode holt das Element von der übergebenen Position und gibt es zurück
     *
     * @param pos Die Position in der Menge
     * @return Das Element in der Position
     */
    @Override
    public T get(int pos) {
        return folgeMitDynArray.get(pos);
    }

    /**
     * Fügt ein Element e der Menge werden hinzu
     *
     * @param e data
     */
    @Override
    public void insert(T e) {
        folgeMitDynArray.addLast(e);
    }

    /**
     * @return Das Element, das Entfernt wurde.
     */
    @Override
    public T remove() {
        throw new UnsupportedOperationException("This operation is not permitted");
    }

    /**
     * @return Anazhl der Elemente in der Menge
     */
    @Override
    public int size() {
        return folgeMitDynArray.size();
    }

    /**
     * @return True, wenn die Menge leer ist.
     */
    @Override
    public boolean isEmpty() {
        return 0 == size();
    }


    @NotNull
    @Override
    public Iterator<T> iterator() {
        return folgeMitDynArray.iterator();
    }

    public void addAll(Puffer<T> puffer) {
        for (T element : puffer) {
            insert(element);
        }
    }

    public Puffer<T> addAllTo(Puffer<T> puffer) {
        for (T element : folgeMitDynArray) {
            puffer.insert(element);
        }
        return puffer;
    }
    

}
