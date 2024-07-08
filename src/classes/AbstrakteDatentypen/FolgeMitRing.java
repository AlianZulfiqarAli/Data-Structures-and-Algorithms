import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Für diese Klasse gibt es keien Test da alles im RingpufferTest getestet wurde.
 */
public class FolgeMitRing <T> implements Folge <T>{
    private final Ringpuffer<T> folgeMitRing = new Ringpuffer<>(10);

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
        folgeMitRing.insert(e, pos);
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
        return folgeMitRing.set(e,pos);
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
        return folgeMitRing.remove(pos);
    }

    /**
     * Die Methode holt das Element von der übergebenen Position und gibt es zurück
     *
     * @param pos Die Position in der Menge
     * @return Das Element in der Position
     */
    @Override
    public T get(int pos) {
        return folgeMitRing.get(pos);
    }

    /**
     * Fügt ein Element e der Menge werden hinzu
     *
     * @param e data
     */
    @Override
    public void insert(T e) {
        folgeMitRing.addLast(e);
    }
    /**
     * @return Das Element, das entfernt wurde.
     */
    @Override
    public T remove() throws UnsupportedOperationException{
        throw new UnsupportedOperationException("This operation is not permited");
    }
    /**
     * @return Anazhl der Elemente in der Menge
     */
    @Override
    public int size() {
        return folgeMitRing.size();
    }
    /**
     * @return True, wenn die Menge leer ist.
     */
    @Override
    public boolean isEmpty() {
        return folgeMitRing.size() == 0;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }
}
