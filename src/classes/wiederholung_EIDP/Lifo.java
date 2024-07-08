import java.nio.BufferUnderflowException;
/**
 * Lifo ist eine Klasse, die von der Klasse AbstractIntegerBuffer erbt und eine Last-In-First-Out (LIFO) Datenstruktur implementiert.
 * Es ermöglicht, dass Elemente in LIFO-Manier zu dem Array hinzugefügt und entfernt werden, wobei das letzte Element, das zu dem Array hinzugefügt wurde,
 * das erste Element ist, das entfernt wird.
 * @see AbstractIntegerBuffer
 */
public class Lifo extends AbstractIntegerBuffer {

    /**
     * Erzeugt ein neues Lifo-Array mit maximal maxSize Elementen.
     *<p>
     * @param maxSize Die maximale Anzahl an Elementen im Array.
     */
    public Lifo(int maxSize) {
       super(maxSize);
    }
    /**
     * Erzeugt ein neues Fifo-Array mit einer zufälligen Anzahl an Elementen.
     * Die genaue Anzahl der Elemente wird zur Laufzeit bestimmt und durch
     * den Konstruktor von AbstractIntegerBuffer() festgelegt.
     */
    public Lifo() {
      super();
    }

    /**
     * Removes and returns the last element of the array.
     *
     * @return the last element of the array
     * @throws BufferUnderflowException if the array is empty
     */
    @Override
    public Integer pop(){
        if (size() == 0)
            throw new BufferUnderflowException();
        return array[--size];
    }

}
