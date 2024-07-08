import java.util.NoSuchElementException;

public interface Kellerspeicher<T> extends Speicher<T>{
    /**
     * @return das aktuell oberste Element auf dem Stapel
     * @throws NoSuchElementException wenn der Stapel leer ist
     */
    T top() throws NoSuchElementException;

}
