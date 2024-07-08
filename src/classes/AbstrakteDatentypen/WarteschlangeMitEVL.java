import java.util.NoSuchElementException;
public class WarteschlangeMitEVL<T> implements Warteschlange<T> {
    private final EVL<T> evl;

    public WarteschlangeMitEVL(){
        evl = new EVL<>();
    }


    /**
     * @return True, wenn der Speicher leer ist.
     */
    @Override
    public boolean isEmpty() {
        return evl.size() == 0;
    }

    /**
     * @return Die Anzahl der Elemente im Speicher
     */
    @Override
    public int size() {
        return evl.size();
    }

    /**
     * @return Anzahl der Speicherplaetze die im speicher zur verfuegungn stehen.
     */
    @Override
    public int capacity() {
        return Integer.MAX_VALUE;
    }

    /**
     * @param element das, in das Speicher hinzugefuegt wird
     * @throws IllegalStateException wenn der Speicher voll ist.
     */
    @Override
    public void push(T element) throws IllegalStateException {
        evl.addLast(element);
    }

    /**
     * @return das Element das vom speicher entfernt werden muss
     * @throws NoSuchElementException wenn der Speicher leer ist.
     */
    @Override
    public T pop() throws NoSuchElementException {
        return evl.removeLast();
    }

    /**
     * @return das aktuell vorderste Element in der Schlange
     * @throws NoSuchElementException wenn die Schlange leer ist
     */
    @Override
    public T front() throws NoSuchElementException {
        return evl.getFirst();
    }
}
