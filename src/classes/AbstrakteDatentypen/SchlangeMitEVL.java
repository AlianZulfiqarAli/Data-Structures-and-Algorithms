import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class SchlangeMitEVL <T> implements Schlange <T>{

    private final EVL<T> evlMitSchlang;

    public SchlangeMitEVL (){
        evlMitSchlang = new EVL<>();
    }

    /**
     * Die Methode liefert das erste Element der Schlange, entfernt es allerdings nicht.
     */
    @Override
    public T first() {
        return evlMitSchlang.getFirst();
    }

    /**
     * Die Methode fügt e am Ende der Schlange ein.
     *
     * @param e Data
     */
    @Override
    public void insert(T e) {
        evlMitSchlang.addLast(e);
    }

    /**
     * Die Methode entfernt das erste Element in der Schlange.
     *
     * @return Das erste Element
     */
    @Override
    public T remove() {
        return evlMitSchlang.removeFirst();
    }

    /**
     * @return Anazhl der Elemente in der Menge
     */
    @Override
    public int size() {
        return evlMitSchlang.size();
    }

    /**
     * @return True, wenn die Menge leer ist.
     */
    @Override
    public boolean isEmpty() {
        return evlMitSchlang.size() == 0;
    }


    @NotNull
    @Override
    public Iterator<T> iterator() {
        return evlMitSchlang.iterator();
    }
}
