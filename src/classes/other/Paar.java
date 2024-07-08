import org.jetbrains.annotations.NotNull;

/**
 * Paar ist eine Klasse, die zwei Objekte vom Typ E und Z enthält.
 * Diese Objekte können mithilfe der Methoden getErstes und getZweites abgefragt werden.
 * Die Objekte können mithilfe der Methoden setErstes und setZweites gesetzt werden.
 * Die Methoden setBeide setzt beide Objekte auf einmal.
 * Die equals-Methode vergleicht zwei Paare und gibt true zurück, wenn sie gleich sind, ansonsten false.
 * Die toString-Methode gibt die beiden Objekte in Klammern als String zurück.
 */
public class Paar<E,Z>{
    private E erstes;
    private Z zweites;

    /**
     * Erstellt ein neues Paar aus den beiden Objekten el1 und el2.
     * @param el1 Das erste Objekt vom Typ E.
     * @param el2 Das zweite Objekt vom Typ Z.
     */
    public Paar(@NotNull E el1,@NotNull  Z el2){
        erstes = el1;
        zweites = el2;
    }

    /**
     * Gibt das erste Objekt vom Typ E zurück.
     * @return Das erste Objekt vom Typ E.
     */
    public E getErstes() {
        return erstes;
    }

    /**
     * Setzt das erste Objekt vom Typ E auf den gegebenen Wert.
     * @param erstes Das neue erste Objekt vom Typ E.
     */
    public void setErstes(@NotNull E erstes) {
        this.erstes = erstes;
    }

    /**
     * Gibt das zweite Objekt vom Typ Z zurück.
     * @return Das zweite Objekt vom Typ Z.
     */
    public Z getZweites() {
        return zweites;
    }

    /**
     * Setzt das zweite Objekt vom Typ Z auf den gegebenen Wert.
     * @param zweites Das neue zweite Objekt vom Typ Z.
     */
    public void setZweites(@NotNull Z zweites) {
        this.zweites = zweites;
    }

    /**
     * Setzt beide Objekte auf einmal auf die gegebenen Werte.
     * @param e Das neue erste Objekt vom Typ E.
     * @param z Das neue zweite Objekt vom Typ Z.
     */
    public void setBeide(@NotNull E e, @NotNull Z z) {
        this.erstes = e;
        this.zweites = z;
    }

    /**
     * Bestimmt, ob dieses Paar dem anderen Objekt gleich ist. Zwei Paare gelten als gleich,
     * wenn und nur wenn beide ihre ersten und zweiten Elemente gleich sind.
     *
     * @param p das Objekt, das mit diesem Paar verglichen werden soll
     * @return true, wenn die Objekte gleich sind, false andernfalls
     *
     */
    public boolean equals(Paar<E, Z> p) {
        if (this == p) return true;
        if (p == null) return false;
        return this.erstes.equals(p.erstes) && this.zweites.equals(p.zweites);
    }

    /**
     * Gibt eine Zeichenkettendarstellung dieses Paars im Format (erstes,zweites) zurück.
     *
     * @return eine Zeichenkettendarstellung dieses Paars
     */
    @Override
    public String toString() {
        return "(" + erstes +
                "," + zweites +
                ")";
    }
}