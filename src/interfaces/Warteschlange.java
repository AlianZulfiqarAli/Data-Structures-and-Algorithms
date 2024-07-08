import java.util.NoSuchElementException;

public interface Warteschlange<T> extends Speicher<T> {
    /**
     * @return das aktuell vorderste Element in der Schlange
     * @throws NoSuchElementException wenn die Schlange leer ist
     */
    T front() throws NoSuchElementException;
}
