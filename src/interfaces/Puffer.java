public interface Puffer <T> extends Iterable<T>{
    /**
     * Fügt ein Element e der Menge werden hinzu
     * @param e data
     */
    void insert(T e);
    /**
     * @return Das Element, das Entfernt wurde.
     */
    T remove();
    /**
     * @return Anazhl der Elemente in der Menge
     */
    int size();
    /**
     * @return True, wenn die Menge leer ist.
     */
    boolean isEmpty();
}
