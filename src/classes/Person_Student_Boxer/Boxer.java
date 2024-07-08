import org.jetbrains.annotations.NotNull;

public class Boxer extends Person{
    private int gewicht;
    public Boxer(String name, String vorName, Integer gewicht){
        super(name, vorName);
        this.gewicht = gewicht;
    }

    public int getGewicht() {
        return gewicht;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", gewicht=" + gewicht ;
    }

    public void setGewicht(int gewicht) {
        this.gewicht = gewicht;
    }

    /**
     * Bestimmen, ob dieses Boxer-Objekt einem anderen Objekt gleich ist.
     * Zwei Boxer-Objekte gelten als gleich, wenn und nur wenn sie das gleiche Gewicht haben.
     *
     * @param o das zu vergleichende Objekt mit diesem Student-Objekt
     * @return true, wenn das gegebene Objekt ein Student mit der gleichen Matrikelnummer und den gleichen Namen und Vornamen wie dieses Objekt ist, false sonst
     */@Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Boxer boxer)) return false;
        return gewicht == boxer.gewicht;
    }



    public int compareTo(@NotNull Boxer o) {
        // Vergleicht den Namen und den Vornamen des Boxers mit dem Namen und dem Vornamen des übergebenen Boxers.
        // Gibt den Vergleichswert des Namens und des Vornamens zurück, falls dieser ungleich 0 ist.
        // Andernfalls wird das Gewicht der Boxer verglichen und der Vergleichswert zurückgegeben.
        String thisName = this.getName() + " " + this.getVorname();
        String otherName = o.getName() + " " + o.getVorname();
        int namecomp = thisName.compareTo(otherName);

        if (namecomp != 0)
            return namecomp;
        if (this.gewicht == o.gewicht)
            return 0;
        else return this.gewicht > o.gewicht ? 1: -1;
    }
}

