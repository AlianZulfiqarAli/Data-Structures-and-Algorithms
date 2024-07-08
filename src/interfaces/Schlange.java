public interface Schlange <T> extends Puffer <T>{

    /**
     * Die Methode liefert das erste Element der Schlange, entfernt es allerdings nicht.
     */
    T first();

    /** Die Methode fügt e am Ende der Schlange ein.
     * @param e Data
     */
    void insert(T e);

    /** Die Methode entfernt das erste Element in der Schlange.
     * @return Das erste Element
     */
    T remove();
}
