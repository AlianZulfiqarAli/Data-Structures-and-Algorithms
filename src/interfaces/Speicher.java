import java.util.NoSuchElementException;

public interface Speicher<T> {
    /**
     * @return True, wenn der Speicher leer ist.
     */
    boolean isEmpty();

    /**
     * @return Die Anzahl der Elemente im Speicher
     */
    int size();

    /**
     * @return Anzahl der Speicherplaetze die im speicher zur verfuegungn stehen.
     */
    int capacity();

    /**
     * @param element das, in das Speicher hinzugefuegt wird
     * @throws IllegalStateException wenn der Speicher voll ist.
     */
    void push(T element) throws IllegalStateException;

    /**
     * @return das Element das vom speicher entfernt werden muss
     * @throws NoSuchElementException wenn der Speicher leer ist.
     */
    T pop() throws NoSuchElementException;

}
