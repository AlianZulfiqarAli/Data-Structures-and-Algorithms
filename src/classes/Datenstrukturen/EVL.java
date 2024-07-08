import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * Eine einfach verkettete Liste, die Elemente vom Typ T speichert.
 * Implementiert das Iterable-Interface, um das Durchlaufen der Elemente zu ermöglichen.
 */
public class EVL<T> implements Iterable<T> {

    // Der Zähler, der die Anzahl der Elemente in der Liste speichert
    private int counter;
    // Das erste Element in der Liste
    private ListenElement first;

    /**
     * Innere Klasse, die ein Element der Liste darstellt.
     * Enthält ein Feld für die Daten und ein Feld für das nächste Element in der Liste.
     */
    class ListenElement {
        // Das nächste Element in der Liste
        ListenElement next;
        // Die Daten, die das Element speichert
        T data;

        /**
         * Erstellt ein neues ListenElement mit den gegebenen Daten.
         *
         * @param data Die Daten, die das Element speichern soll.
         */
        public ListenElement(T data) {
            this.data = data;
        }
    }

    /**
     * Innere Klasse, die einen Iterator für die EVL-Liste implementiert.
     * Ermöglicht das Durchlaufen der Elemente in der Liste.
     */
    private class EVLIterator implements Iterator<T> {
        // Das aktuelle Element, das von next() zurückgegeben wird
        private ListenElement tmp;

        /**
         * Erstellt einen neuen EVLIterator, der beim ersten Element der Liste startet.
         */
        private EVLIterator() {
            tmp = first;
        }

        /**
         * Gibt zurück, ob es noch weitere Elemente in der Liste gibt.
         *
         * @return true, wenn es noch weitere Elemente gibt, false wenn nicht.
         */
        @Override
        public boolean hasNext() {
            return tmp != null;
        }

        /**
         * Gibt das nächste Element in der Liste zurück und verschiebt den Iterator zum nächsten Element.
         *
         * @return Das nächste Element in der Liste.
         * @throws NullPointerException Wenn es keine weiteren Elemente in der Liste gibt.
         */
        @Override
        public T next() {
            if (!hasNext())
                throw new NullPointerException("there are no elements here");
            T element = tmp.data;
            tmp = tmp.next;
            return element;
        }
    }

    /**
     * Fügt ein neues Element mit dem gegebenen Wert am Anfang der Liste hinzu.
     *
     * @param e Der Wert des Elements, das hinzugefügt werden soll.
     * @throws IllegalArgumentException wenn e null ist.
     */
    public void addFirst(T e) {
        // Wirf eine IllegalArgumentException, wenn e null ist
        if (null == e)
            throw new IllegalArgumentException("Null ist kein Element");

        // Wenn die Liste leer ist, füge das neue Element als erstes Element hinzu
        if (null == first) {
            first = new ListenElement(e);
            counter++;
            return;
        }

        // Füge das neue Element am Anfang der Liste ein und setze das nächste Element auf das bisherige erste Element
        ListenElement tmp = first;
        first = new ListenElement(e);
        first.next = tmp;
        counter++;
    }

    /**
     * Fügt ein neues Element mit dem gegebenen Wert am Ende der Liste hinzu.
     *
     * @param e Der Wert des Elements, das hinzugefügt werden soll.
     * @throws IllegalArgumentException wenn e null ist.
     */
    public void addLast(T e) {
        // Wirf eine IllegalArgumentException, wenn e null ist
        if (null == e)
            throw new IllegalArgumentException("Null ist kein Element");

        // Wenn die Liste leer ist, füge das neue Element als erstes Element hinzu
        if (null == first) {
            first = new ListenElement(e);
            counter++;
            return;
        }

        // Suche das letzte Element in der Liste
        ListenElement tmp = first;
        while (tmp.next != null)
            tmp = tmp.next;

        // Füge das neue Element am Ende der Liste hinzu
        tmp.next = new ListenElement(e);
        counter++;
    }
    /**
     * @return Gibt den Inhalt des erstenElement zurueck.
     */
    public T getFirst() {
        //falls die Liste noch leer ist.
        if (first == null)
            throw new NoSuchElementException("Die Liste ist noch leer!");
        return first.data;
    }
    /**
     * Gibt den Wert des letzten Elements der Liste zurück.
     *
     * @return Der Wert des letzten Elements.
     * @throws NoSuchElementException wenn die Liste leer ist.
     */
    public T getLast() {
        // Initialisiere den Iterator auf das erste Element der Liste
        Iterator<T> iterator = iterator();

        // Iteriere solange, bis der Iterator auf das letzte Element zeigt
        while (iterator.hasNext()) {
            T element = iterator.next();
            if (!iterator.hasNext()) {
                // Gib den Wert des letzten Elements zurück
                return element;
            }
        }

        // Die Liste ist leer, also wirf eine NoSuchElementException
        throw new NoSuchElementException("Die Liste ist noch leer!");
    }
    /**
     * Entfernt das letzte Element der Liste und gibt dessen Wert zurück.
     *
     * @return Der Wert des entfernten Elements.
     * @throws NoSuchElementException wenn die Liste leer ist.
     */
    public T removeLast() {
        // Wirf eine NoSuchElementException, wenn die Liste leer ist
        if (first == null) {
            throw new NoSuchElementException("Die Liste ist noch leer!");
        }

        // Speichere das erste Element in einer temporären Variablen
        ListenElement tmp = first;
        T removedElement;

        // Wenn tmp das einzige Element in der Liste ist, entferne es und setze first auf null
        if (tmp.next == null) {
            removedElement = tmp.data;
            first = null;
            return removedElement;
        }

        // Iteriere solange, bis tmp das zweite zuletzt Element in der Liste ist
        while (tmp.next.next != null) {
            tmp = tmp.next;
        }

        // Speichere den Wert des letzten Elements in removedElement und entferne es aus der Liste
        removedElement = tmp.next.data;
        tmp.next = null;

        // Setze first auf null, wenn die Liste leer ist
        if (size() == 0)
            this.first = null;

        // Decrement the counter
        counter--;

        // Gib den Wert des entfernten Elements zurück
        return removedElement;
    }
    /**
     * Prüft, ob das gegebene Element in der Liste enthalten ist.
     *
     * @param e Das Element, das gesucht wird.
     * @return true, wenn das Element in der Liste enthalten ist, false wenn nicht.
     * @throws NoSuchElementException Wenn die Liste leer ist.
     */
    public boolean contains(T e) {
        // Erstelle einen Iterator für die Liste

        // Durchlaufe die Elemente der Liste mit dem Iterator
        for (T t : this) {
            // Prüfe, ob das aktuelle Element gleich dem gesuchten Element ist
            if (t.equals(e))
                return true;
        }

        // Falls das Element nicht gefunden wurde, gib false zurück
        return false;
    }
    /**
     * @return Anzahl der Elemente in der Liste.
     */
    public int size() {
        return counter;
    }
    /**
     * Entfernt das erste Element der Liste und gibt dessen Wert zurück.
     *
     * @return Der Wert des entfernten Elements.
     * @throws NoSuchElementException wenn die Liste leer ist.
     */
    public T removeFirst() {
        // Wirf eine NoSuchElementException, wenn die Liste leer ist
        if (first == null)
            throw new NoSuchElementException("Die Liste ist noch leer!");

        // Speichere das erste Element in einer temporären Variable und setze das erste Element auf das nächste Element
        ListenElement tmp = first;
        first = first.next;

        // Decrement the counter
        counter--;

        // Gib den Wert des entfernten Elements zurück
        return tmp.data;
    }
    /**
     * Verknüpft die gegebene Liste mit der aktuellen Liste, indem sie die Elemente abwechselnd einfügt.
     * Beispiel: Wenn die aktuelle Liste [1, 2, 3] und die gegebene Liste [a, b, c] sind,
     * wird die resultierende Liste [1, a, 2, b, 3, c] sein.
     *
     * @param other Die Liste, die verknüpft werden soll.
     * @throws NullPointerException wenn other null ist.
     */
    public void zip(EVL<T> other) {
        // Wirf eine NullPointerException, wenn other null ist
        if (null == other)
            throw new NullPointerException("Die Liste darf nicht null sein");

        // Initialisiere Iteratoren für die aktuelle Liste und die gegebene Liste
        ListenElement thisTmp = first;
        ListenElement otherTmp = other.first;
        ListenElement thisNext, otherNext;

        // Wenn die aktuelle Liste leer ist, setze das erste Element auf das erste Element der gegebenen Liste
        if (first == null) {
            first = other.first;
        }

        // Iteriere solange beide Listen nicht leer sind
        while (thisTmp != null && otherTmp != null) {
            // Speichere die nächsten Elemente der Listen
            thisNext = thisTmp.next;
            otherNext = otherTmp.next;

            // Verknüpfe thisTmp und otherTmp
            otherTmp.next = thisNext;
            thisTmp.next = otherTmp;

            // Füge eventuell verbleibende Elemente einer der Listen hinzu
            if (thisNext == null && otherNext != null) {
                otherTmp.next = otherNext;
            }
            if (otherNext == null && thisNext != null) {
                thisTmp.next = thisNext;
            }

            // Setze Iteratoren für die nächste Iteration
            thisTmp = thisNext;
            otherTmp = otherNext;
        }

        // Erhöhe den Zähler um die Anzahl der Elemente in der gegebenen Liste und setze den Zähler der gegebenen Liste auf 0
        counter += other.counter;
        other.counter = 0;
        other.first = null;
    }
    /**
     * Erstellt einen neuen EVLIterator, der beim ersten Element der Liste startet.
     *
     * @return Der neu erstellte EVLIterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new EVLIterator();
    }

}
