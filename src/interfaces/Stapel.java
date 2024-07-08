public interface Stapel<T> extends Folge <T>{

    /**  liefert das letzte Element des Stapels, entfernt es allerdings nicht.
     * @return das letzte Element
     */
    T top();

    /** Die Methode fügt e am Ende des Stapels ein.
     * @param e Data
     */
    void insert(T e);

    /** Di Methode entfernt das letzte Element des Stapels.
     * @return das letzte Element
     */
    T remove();

}
