public interface IntegerBuffer {
    /**
     * Fügt ein Integer-Element in den Puffer ein.
     *
     * @param i Das Integer-Element, das hinzugefügt werden soll.
     * @throws Exception wenn der Puffer voll ist.
     */
    void push (Integer i) throws Exception;

    /**
     * Entfernt das oberste Element aus dem Puffer und gibt es zurück.
     *
     * @return Das oberste Element im Puffer.
     */
    Integer pop();

    /**
     * Gibt die Anzahl der Elemente im Puffer zurück.
     *
     * @return Die Anzahl der Elemente im Puffer.
     */
    int size();

    /**
     * Gibt die Kapazität des Puffers zurück.
     *
     * @return Die Kapazität des Puffers.
     */
    int capacity();
}
