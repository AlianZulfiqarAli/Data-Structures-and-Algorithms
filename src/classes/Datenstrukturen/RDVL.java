import java.util.NoSuchElementException;

/**
 * Eine doppelt verkettete, geschlossene Liste, die sich selbst als Kreis verhält.
 * Die Liste speichert Elemente vom Typ T.
 */
public class RDVL<T> {
    // Der Zähler, der die Anzahl der Elemente in der Liste speichert
    private int counter;
    // Das aktuelle entry-Element
    ListenElement entry;

    /**
     * Innere Klasse, die ein Element der Liste darstellt.
     * Enthält ein Feld für die Daten und Felder für den vorherigen und nächsten Nachbarn.
     */
    class ListenElement {
        // Das nächste Element in der Liste
        ListenElement next;
        // Das vorherige Element in der Liste
        ListenElement prev;
        // Die Daten, die das Element speichert
        T data;

        /**
         * Erstellt ein neues ListenElement mit den gegebenen Daten.
         *
         * @param data Die Daten, die das Element speichern soll.
         */
        public ListenElement(T data) {
            this.data = data;
            // Setze prev und next auf null, da das Element noch nicht Teil der Liste ist
            prev = next = null;
        }
    }


    /**
     * Gibt einen Wahrheitswert zurück, ob die Liste leer ist.
     *
     * @return True, wenn die Liste leer ist.
     */
    public boolean isEmpty() {
        return entry == null;
    }

    /**
     * Die Methode gibt einen ganzzahligen Wert zurück, der angibt, wieviele Listenelemente
     * momentan enthalten sind.
     *
     * @return Anzahl den Elementen in der Liste.
     */
    public int size() {
        return counter;
    }

    /**
     * Fügt ein Element an das Ende der Liste hinzu.
     *
     * @param e Das Element, das hinzugefügt werden soll.
     */
    public void add(T e) {
        // Erstelle ein neues ListenElement mit dem gegebenen Wert
        ListenElement element = new ListenElement(e);

        // Wenn die Liste leer ist, setze das entry-Feld auf das neue Element und setze next und prev auf das Element selbst
        if (isEmpty()) {
            entry = element;
            entry.next = element;
            entry.prev = element;
            // Wenn die Liste nicht leer ist, füge das Element vor dem aktuellen entry-Element ein und setze prev und next entsprechend
        } else {
            element.next = entry;
            element.prev = entry.prev;
            entry.prev.next = element;
            entry.prev = element;
        }

        // Erhöhe den Zähler um 1
        counter++;
    }

    /**
     * Der Inhalt des aktuellen Listenelements (entry) wird zurückgegeben.
     * Wenn die Liste leer ist, wird eine NoSuchElementException geworfen.
     *
     * @return Inhalt des aktuellen Listenelements
     * @throws NoSuchElementException Wenn die Liste leer ist.
     */
    public T element() {
        if (isEmpty())
            throw new NoSuchElementException("Speicher ist leer!");
        return entry.data;
    }

    /**
     * Verschiebt das aktuelle Element (entry) um s Schritte nach vorne.
     *
     * @param s anzahl an Schritte
     */
    public void next(int s) {
        for (int i = 0; i < s; i++) {
            entry = entry.next;
        }
    }

    /**
     * Verschiebt das aktuelle Element (entry) um s Schritte nach hinten.
     *
     * @param s anzahl an Schritte
     */
    public void prev(int s) {
        for (int i = 0; i < s; i++) {
            entry = entry.prev;
        }
    }

    /**
     * Entfernt das aktuelle Element aus der Liste und gibt dessen Wert zurück.
     * Wenn die Liste leer ist, wird eine NoSuchElementException geworfen.
     *
     * @return Der Wert des entfernten Elements.
     * @throws NoSuchElementException Wenn die Liste leer ist.
     */
    public T remove() {
        if (isEmpty())
            throw new NoSuchElementException("Speicher ist leer!");
        // Speichere den Wert des aktuellen Elements in einer Variablen, um es später zurückzugeben.
        T removedData = entry.data;

        // Aktualisiere die Verknüpfungen zwischen dem vorherigen und nächsten Element und dem aktuellen Element, um es aus der Liste zu entfernen.
        entry.prev.next = entry.next;
        entry.next.prev = entry.prev;

        // Setze das entry-Feld auf das nächste Element, damit es das aktuelle Element ist.
        entry = entry.next;

        if (size() == 1) {
            entry = null;
        }
        counter--;
        return removedData;
    }

}