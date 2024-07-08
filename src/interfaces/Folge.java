public interface Folge <T> extends Puffer <T>{

    /** Mit der Methode wird e an der spezifizierten Position pos eingefügt. Das Element, das momentan
     * an der Position steht und die folgenden (wenn vorhanden) werden nach rechts verschoben
     * (die Indizes sind dann jeweils um eins erhöht).
     * @param pos Die Position in der Menge
     * @param e Data
     */
    void insert(int pos, T e);

    /** Die Methode überschreibt das Element an Index pos und gibt den alten Wert zurück
     * @param pos Die Position in der Menge
     * @param e Data
     * @return Das alte Element
     */
    T set(int pos, T e);


    /** Beim Entfernen von Elementen mit der Methode soll das Element am Index pos
     * entfernt werden und alle darauf folgenden Elemente nachrutschen.
     * @param pos Die Position in der Menge
     * @return Das Element, das entfernt wurde.
     */
    T remove(int pos);

    /** Die Methode holt das Element von der übergebenen Position und gibt es zurück
     * @param pos Die Position in der Menge
     * @return Das Element in der Position
     */
    T get(int pos);
}
