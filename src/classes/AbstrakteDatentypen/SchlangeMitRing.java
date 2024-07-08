import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

/**
 * Wird nicht meht getestet da alles in RingpufferTest getestet wurde
 */
public class SchlangeMitRing <T> implements Schlange <T>{

    private final Ringpuffer<T> ringMitSchlange;

    public SchlangeMitRing(int capacity){
        ringMitSchlange = new Ringpuffer<>(capacity);
    }


    /**
     * Die Methode liefert das erste Element der Schlange, entfernt es allerdings nicht.
     */
    @Override
    public T first() {
        return ringMitSchlange.get(0);
    }

    /**
     * Die Methode fügt e am Ende der Schlange ein.
     *
     * @param e Data
     */
    @Override
    public void insert(T e) {
        ringMitSchlange.addLast(e);
    }

    /**
     * Die Methode entfernt das erste Element in der Schlange.
     *
     * @return Das erste Element
     */
    @Override
    public T remove() {
        return ringMitSchlange.removeFirst();
    }

    /**
     * @return Anazhl der Elemente in der Menge
     */
    @Override
    public int size() {
        return ringMitSchlange.size();
    }

    /**
     * @return True, wenn die Menge leer ist.
     */
    @Override
    public boolean isEmpty() {
        return ringMitSchlange.size() == 0;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }
}
