import java.util.NoSuchElementException;

public class KellerspeicherMitArray<T> implements Warteschlange<T>{
    private int size;
    private final T [] array;
    /**
     * Konstruiert ein neuer Kellerspeicher mit einer maximalen Größe von maxGroesse.
     *
     * @param maxGroesse Die maximale Größe der Warteschlange. Muss größer als 0 sein.
     * @throws IllegalArgumentException falls maxGroesse nicht größer als 0 ist.
     */
    @SuppressWarnings("unchecked")
    public KellerspeicherMitArray(int maxGroesse) {
        if (maxGroesse <= 0) {
            throw new IllegalArgumentException("maxGroesse must be greater than 0");
        }
        array = (T[]) new Object[maxGroesse];
    }
    /**
     * @return True, wenn der Speicher leer ist.
     */
    @Override
    public boolean isEmpty() {
        return 0 == size();
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
     * Fügt den angegebenen Integer am Ende des Arrays der Elemente hinzu.
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
            throw new IllegalStateException("Speicher ist leer!");
        else if (element == null)
            throw new IllegalArgumentException("Elemente koennen nicht null sein");
        array[size++] = element;
    }
    /**
     * Entfernt das nächste Element aus dem Speicher des Kellerspeichers und gibt es zurück.
     *
     * @return Das nächste Element im Speicher des Kellerspeichers.
     * @throws NoSuchElementException wenn der Speicher des Kellerspeichers leer ist.
     */
    @Override
    public T pop() {
        if (isEmpty())
            throw new NoSuchElementException("Der Speicher ist leer!");
        return array[--size];
    }
    /**
     * Gibt das aktuell oberste Element im Speicher des Kellerspeichers zurück, ohne es zu entfernen.
     *
     * @return Das aktuell oberste Element im Speicher des Kellerspeichers.
     * @throws NoSuchElementException wenn der Speicher des Kellerspeichers leer ist.
     */
    @Override
    public T front() {
        if (isEmpty())
            throw new NoSuchElementException("Der Speicher ist leer!");
        return array[size()-1];
    }
}
