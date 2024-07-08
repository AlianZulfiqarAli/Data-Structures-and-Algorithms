import java.nio.BufferOverflowException;
import java.nio.BufferUnderflowException;
import java.util.NoSuchElementException;

public class Ringpuffer<T> {
    private int size;
    private int entryPosition;
    private int endPosition;
    private final T[] array;

    /**
     * Konstruktor für Ringpuffer. Erstellt einen Ringpuffer mit der gegebenen Kapazität.
     *
     * @param capacity Kapazität des Ringpuffers
     */
    @SuppressWarnings("unchecked")
    public Ringpuffer(int capacity) {
        array = (T[]) new Object[capacity];
        entryPosition = -1;
        endPosition = -1;
    }

    /**
     * Gibt die Größe des Ringpuffers zurück.
     *
     * @return Größe des Ringpuffers
     */
    public int size() {
        return size;
    }

    /**
     * Gibt die Kapazität des Ringpuffers zurück.
     *
     * @return Kapazität des Ringpuffers
     */
    public int capacity() {
        return array.length;
    }

    /**
     * Gibt das Element an der gegebenen Position im Ringpuffer zurück.
     *
     * @param pos Position des Elements im Ringpuffer
     * @return Element an der gegebenen Position
     * @throws IndexOutOfBoundsException wenn die gegebene Position außerhalb des gültigen Bereichs liegt
     */
    public T get(int pos) throws IndexOutOfBoundsException {
        if (pos > size())
            throw new IndexOutOfBoundsException("provided pos is out of bounds");
        return array[(entryPosition + pos) % capacity()];
    }

    /**
     * Setzt das Element an der gegebenen Position im Ringpuffer auf den gegebenen Wert und gibt das alte Element zurück.
     *
     * @param e   neuer Wert für das Element
     * @param pos Position des Elements im Ringpuffer
     * @return das alte Element an der gegebenen Position
     * @throws NoSuchElementException    wenn das Element null ist
     * @throws IndexOutOfBoundsException wenn die gegebene Position außerhalb des gültigen Bereichs liegt
     */
    public T set(T e, int pos) throws NoSuchElementException {
        if (null == e)
            throw new NullPointerException("element can not be null");
        if (pos >= size())
            throw new IndexOutOfBoundsException("provided pos is outmof bounds");
        T tmp = get(pos);
        array[(entryPosition + pos) % capacity()] = e;
        return tmp;
    }

    /**
     * Fügt das gegebene Element als erstes Element in den Ringpuffer ein.
     *
     * @param e Element, das eingefügt werden soll
     * @throws IndexOutOfBoundsException wenn der Ringpuffer voll ist
     */
    public void addFirst(T e) throws IndexOutOfBoundsException {
        // Wirf eine Exception, wenn das Element null ist
        if (null == e)
            throw new NullPointerException("the element can not be null");
        // Wirf eine Exception, wenn der Ringpuffer voll ist
        if (size() == capacity())
            throw new BufferOverflowException();
        // Wenn der Ringpuffer leer ist, setze entryPosition und endPosition auf 0 und füge das Element hinzu
        if (size() == 0) {
            entryPosition = 0;
            endPosition = 0;
            array[entryPosition] = e;
            size++;
            return;
        }
        // Decrementiere entryPosition und moduliere den Wert mit der Kapazität, um ihn innerhalb des gültigen Bereichs zu halten
        entryPosition = (--entryPosition) % capacity();
        // Wenn der Wert kleiner als 0 ist, setze ihn auf capacity() - 1
        if (entryPosition < 0)
            entryPosition = capacity() - 1;
        // Setze das Element an der neuen entryPosition
        array[entryPosition] = e;
        // Incrementiere die Größe des Ringpuffers
        size++;

    }

    /**
     * Fügt das gegebene Element als letztes Element in den Ringpuffer ein.
     *
     * @param e Element, das eingefügt werden soll
     * @throws IndexOutOfBoundsException wenn der Ringpuffer voll ist
     */
    public void addLast(T e) throws IndexOutOfBoundsException {
        // Wirf eine Exception, wenn das Element null ist
        if (null == e)
            throw new NullPointerException("element can not be null");
        // Wirf eine Exception, wenn der Ringpuffer voll ist
        if (size() == capacity())
            throw new IndexOutOfBoundsException("there is no more place in the ringbuffer");
        // Wenn der Ringpuffer noch leer ist, incrementiere entryPosition und endPosition und füge das Element hinzu
        if (0 == size()) {
            entryPosition++;
            endPosition++;
            size++;
            array[endPosition] = e;
            return;
        }
        // Incrementiere endPosition und moduliere den Wert mit der Kapazität, um ihn innerhalb des gültigen Bereichs zu halten
        endPosition = (++endPosition) % capacity();
        // Füge das Element an der neuen endPosition hinzu
        array[endPosition] = e;
        // Incrementiere die Größe des Ringpuffers
        size++;
    }

    /**
     * Entfernt das erste Element aus dem Ringpuffer und gibt es zurück.
     *
     * @return das entfernte Element
     * @throws NoSuchElementException wenn der Ringpuffer leer ist
     */
    public T removeFirst() throws NoSuchElementException {
        // Wirf eine Exception, wenn der Ringpuffer leer ist
        if (size() == 0)
            throw new BufferUnderflowException();
        // Speichere das erste Element in einer temporären Variablen
        T tmp = array[entryPosition];
        // Setze das Element an der aktuellen entryPosition auf null
        array[entryPosition++] = null;
        // Moduliere entryPosition mit der Kapazität, um es innerhalb des gültigen Bereichs zu halten
        entryPosition %= capacity();
        // Decrementiere die Größe des Ringpuffers
        size--;
        // Wenn der Ringpuffer jetzt leer ist, setze entryPosition und endPosition auf -1
        if (size() == 0) {
            entryPosition = -1;
            endPosition = -1;
        }
        // Wenn endPosition kleiner als 0 ist, setze es auf capacity() - 1
        else if (endPosition < 0) {
            endPosition = capacity() - 1;
        }
        // Gib das entfernte Element zurück
        return tmp;
    }

    /**
     * Entfernt das letzte Element aus dem Ringpuffer und gibt es zurück.
     *
     * @return das entfernte Element
     * @throws NoSuchElementException wenn der Ringpuffer leer ist
     */
    public T removeLast() throws NoSuchElementException {
        // Wirf eine Exception, wenn der Ringpuffer leer ist
        if (size() == 0)
            throw new BufferUnderflowException();
        // Speichere das letzte Element in einer temporären Variablen
        T tmp = array[endPosition];
        // Setze das Element an der aktuellen endPosition auf null
        array[endPosition] = null;
        // Decrementiere endPosition und moduliere den Wert mit der Kapazität, um ihn innerhalb des gültigen Bereichs zu halten
        endPosition = endPosition - 1 % capacity();
        // Decrementiere die Größe des Ringpuffers
        size--;
        // Wenn der Ringpuffer jetzt leer ist, setze entryPosition und endPosition auf -1
        if (size() == 0) {
            entryPosition = -1;
            endPosition = -1;
        }
        // Wenn endPosition kleiner als 0 ist, setze es auf capacity() - 1
        else if (endPosition < 0) {
            endPosition = capacity() - 1;
        }
        // Gib das entfernte Element zurück
        return tmp;
    }

    /**
     * Entfernt das Element an der gegebenen Position aus dem Ringpuffer und gibt es zurück.
     *
     * @param pos Position des zu entfernenden Elements
     * @return das entfernte Element
     * @throws BufferUnderflowException  wenn der Ringpuffer leer ist
     * @throws IndexOutOfBoundsException wenn die gegebene Position außerhalb des gültigen Bereichs liegt
     */
    public T remove(int pos) {
        if (size() == 0)
            throw new BufferUnderflowException();
        if (pos < 0 || pos >= size())
            throw new IndexOutOfBoundsException("provided index is out of bounds");
        // Wenn das zu entfernende Element das erste Element ist, verwende removeFirst()
        if (pos == 0) {
            return removeFirst();
        }
        // Wenn das zu entfernende Element das letzte Element ist, verwende removeLast()
        else if (pos == size() - 1) {
            return removeLast();
        }
        // Ansonsten entferne das Element wie bisher
        T tmp = get(pos);
        array[(pos + entryPosition) % capacity()] = null;
        for (int i = (pos + entryPosition) % capacity(); i != endPosition; i++) {
            array[i] = array[(i + 1) % capacity()];
        }
        array[endPosition--] = null;
        size--;
        if (size() == 0) {
            entryPosition = -1;
            endPosition = -1;
        }
        return tmp;
    }
    /**
     * Fügt das gegebene Element an der gegebenen Position in den Ringpuffer ein.
     *
     * @param e   Element, das eingefügt werden soll
     * @param pos Position, an der das Element eingefügt werden soll
     * @throws NullPointerException      wenn das gegebene Element null ist
     * @throws BufferOverflowException   wenn der Ringpuffer voll ist
     * @throws IndexOutOfBoundsException wenn die gegebene Position außerhalb des gültigen Bereichs liegt
     */
    public void insert(T e, int pos) {
        // Wirf eine Exception, wenn das gegebene Element null ist
        if (null == e)
            throw new NullPointerException("elements can not be null");
        // Wirf eine Exception, wenn der Ringpuffer voll ist
        if (size() == capacity())
            throw new BufferOverflowException();
        // Wirf eine Exception, wenn die gegebene Position außerhalb des gültigen Bereichs liegt
        if (pos < 0 || pos >= size())
            throw new IndexOutOfBoundsException("provided index is out of bounds");
        // Speichere das Element an der gegebenen Position in einer temporären Variablen
        T tmp = set(e, pos);
        // Shift alle Elemente von der gegebenen Position bis zum Ende eins nach rechts
        for (int i = pos + 1; i < size(); i++) {
            //das nächste Element
            T move = get(i);
            //füge das alte Element ein
            set(tmp, i);
            //temp wird das nächste Element
            tmp = move;
        }
        //setze das bisher letzte Element am Ende ein
        addLast(tmp);

    }

    public int getEntryPosition() {
        return entryPosition;
    }

    public int getEndPosition() {
        return endPosition;
    }
}
