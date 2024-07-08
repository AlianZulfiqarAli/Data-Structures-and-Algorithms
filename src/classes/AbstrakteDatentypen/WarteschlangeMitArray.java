import java.util.NoSuchElementException;

public class WarteschlangeMitArray<T> implements Kellerspeicher<T>{
    private int size;
    private final T[] array;
    /**
     * Konstruiert eine neue Warteschlange mit einer maximalen Größe von maxGroesse.
     *
     * @param maxGroesse Die maximale Größe der Warteschlange. Muss größer als 0 sein.
     * @throws IllegalArgumentException falls maxGroesse nicht größer als 0 ist.
     */
    @SuppressWarnings("unchecked")
    public WarteschlangeMitArray(int maxGroesse) {
        if (maxGroesse <= 0) {
            throw new IllegalArgumentException("maxGroesse must be greater than 0");
        }
        array = (T[]) new Object[maxGroesse];
    }
    /**
     * Prüft, ob der Speicher der Warteschlange leer ist.
     *
     * @return true, wenn der Speicher leer ist, false andernfalls.
     */
    @Override
    public boolean isEmpty() {
        return 0 == size;
    }
    /**
     * Gibt die Anzahl der Elemente im Speicher der Warteschlange zurück.
     *
     * @return Die Anzahl der Elemente im Speicher.
     */
    @Override
    public int size() {
        return this.size;
    }
    /**
     * Gibt die Kapazität des Speichers der Warteschlange zurück.
     *
     * @return Die Kapazität des Speichers der Warteschlange.
     */
    @Override
    public int capacity() {
        return array.length;
    }
    /**
     * Fügt den angegebenen Integer am Ende des Arrays Liste der Elemente hinzu.
     * <p>
     * Wenn das Array voll ist (d.h. ihre Kapazität erreicht ist), wird
     * diese Methode eine IndexOutOfBoundsException werfen. Wenn das
     * angegebene Element null ist, wird diese Methode eine
     * @param element element
     * @throws IllegalArgumentException werfen.
     */
    @Override
    public void push(T element) {
        if (capacity() == size())
            throw new IllegalStateException("Der Speicher ist voll");
        else if (element == null)
            throw new IllegalArgumentException("Null ist kein Element");
        array[size++] = element;
    }
    /**
     * Entfernt das nächste Element aus dem Speicher der Warteschlange und gibt es zurück.
     *
     * @return Das erste Element im Speicher der Warteschlange.
     * @throws NoSuchElementException wenn der Speicher der Warteschlange leer ist.
     */
    @Override
    public T pop() {
        // Wenn die Warteschlange leer ist, wird eine Exception geworfen
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        // Das erste Element wird in einer lokalen Variablen gespeichert
        T poppedElement = array[0];
        // Anschließend werden alle Elemente im Array um eine Position nach vorne verschoben
        for (int i = 1; i < size(); i++) {
            array[i - 1] = array[i];
        }
        size--;
        // Das entfernte Element wird zurückgegeben
        return poppedElement;
    }
    /**
     * Gibt das aktuell oberste Element im Speicher der Warteschlange zurück, ohne es zu entfernen.
     *
     * @return Das aktuell oberste Element im Speicher der Warteschlange.
     * @throws NoSuchElementException wenn der Speicher der Warteschlange leer ist.
     */
    @Override
    public T top() {
        if (isEmpty())
            throw new NoSuchElementException("Der Speicher ist leer;");
        return array[0];
    }
}
