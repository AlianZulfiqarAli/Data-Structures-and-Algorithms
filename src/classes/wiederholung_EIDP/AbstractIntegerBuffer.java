import java.util.Random;

public abstract class AbstractIntegerBuffer implements IntegerBuffer {
    protected int size = 0;
    protected Integer[] array;
    /**
     * AbstractIntegerBuffer Konstruktor.
     * <p>
     * Nimmt ein Integer Argument namens maxSize entgegen, welches die maximale Größe
     * des Array-Feldes in der AbstractIntegerBuffer Klasse festlegt. Wenn dieser Konstruktor
     * aufgerufen wird, erstellt er ein neues Integer-Array mit der Größe, die durch das
     * maxSize Argument festgelegt wurde.
     *
     * @param maxSize die maximale Größe des Array-Feldes in der AbstractIntegerBuffer Klasse
     * @throws IllegalArgumentException wenn maxSize kleiner als 0 ist
     */
    public AbstractIntegerBuffer(int maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException("maxSize must be non-negative");
        }
        array = new Integer[maxSize];
    }

    /**
     * AbstractIntegerBuffer Konstruktor.
     * <p>
     * Erstellt eine zufällige Arraysgröße im Bereich von 3 bis 100, inklusive.
     * Die Arraysgröße wird mit der nextInt() Methode aus der Random Klasse erstellt,
     * mit einem Argument von 97, was zu einem möglichen Bereich von 0 bis 97 führt.
     * Der Wert wird dann um 3 erhöht, um den endgültigen Bereich von 3 bis 100 zu erhalten.
     */
    public AbstractIntegerBuffer() {
        Random randomNumber = new Random();
        int randomArraySize = 3 + randomNumber.nextInt(97);
        array = new Integer[randomArraySize];
    }
    /**
     * Fügt den angegebenen Integer am Ende der Liste der Elemente hinzu.
     * <p>
     * Wenn die Liste voll ist (d.h. ihre Kapazität erreicht ist), wird
     * diese Methode eine IndexOutOfBoundsException werfen. Wenn der
     * angegebene Integer null ist, wird diese Methode eine
     * @throws IllegalArgumentException werfen.
     */
    @Override
    public void push(Integer i) {
       if (i == null) {
            throw new IllegalArgumentException("Null is not an element!");
       }else if (size() == capacity()) {
           throw new IndexOutOfBoundsException("Der Speicher ist voll");
       }
       array[size++] = i;
    }
    /**
     * Gibt die Anzahl der Elemente in der Liste zurück.
     *
     * @return Die Anzahl der Elemente in der Liste, oder 0, wenn das Array leer ist.
     */
    @Override
    public int size() {
        return size;
    }
    /**
     * Gibt die Kapazität der Liste zurück.
     * <p>
     * Die Kapazität ist die maximale Anzahl von Elementen, die in
     * der Liste gespeichert werden können, bevor die Liste erweitert
     * werden muss.
     *
     * @return Die Kapazität der Liste, oder 0, wenn die Liste null ist.
     */
    @Override
    public int capacity() {
        return array.length;
    }
}
