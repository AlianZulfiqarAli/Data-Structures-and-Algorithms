import java.nio.BufferUnderflowException;
/**
 * Fifo ist eine Klasse, die von der Klasse AbstractIntegerBuffer erbt und eine First-In-First-Out (LIFO) Datenstruktur implementiert.
 * Es ermöglicht, dass Elemente in FIFO-Manier zu dem Array hinzugefügt und entfernt werden, wobei das erste Element, das zu dem Array hinzugefügt wurde,
 * das erste Element ist, das entfernt wird.
 * @see AbstractIntegerBuffer
 */
public class Fifo extends AbstractIntegerBuffer {

    /**
     * Erzeugt ein neues Fifo-Array mit maximal maxSize Elementen.
     *<p>
     * @param maxSize Die maximale Anzahl an Elementen im Array.
     */
    public Fifo(int maxSize) {
        super(maxSize);
    }
    /**
     * Erzeugt ein neues Fifo-Array mit einer zufälligen Anzahl an Elementen.
     * Die genaue Anzahl der Elemente wird zur Laufzeit bestimmt und durch
     * den Konstruktor von AbstractIntegerBuffer() festgelegt.
     */
    public Fifo(){
        super();
    }
    /**
     * Entfernt das erste Element aus dem Array und gibt es als Integer-Wert zurück.
     * Wenn das Array leer ist, wird eine BufferUnderflowException geworfen.
     *
     * @return Das erste Element des Arrays als Integer.
     * @throws BufferUnderflowException wenn das Array leer ist.
     */
    @Override
    public Integer pop(){
        // Wenn die Warteschlange leer ist, wird eine Exception geworfen
        if (size() == 0) {
            throw new BufferUnderflowException();
        }
        // Das erste Element wird in einer lokalen Variablen gespeichert
        int poppedElement = array[0];
        // Anschließend werden alle Elemente im Array um eine Position nach vorne verschoben
        for (int i = 1; i < capacity(); i++) {
            array[i - 1] = array[i];
        }
        // Das entfernte Element wird zurückgegeben
        return poppedElement;
    }

}
