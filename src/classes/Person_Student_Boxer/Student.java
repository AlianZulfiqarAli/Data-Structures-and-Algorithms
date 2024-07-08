import org.jetbrains.annotations.NotNull;

public class Student extends Person{
    private int matNummer;

    public Student(String name, String vorname, Integer matNummer){
        super(name, vorname);
        this.matNummer = matNummer;
    }

    public int getMatNummer() {
        return matNummer;
    }

    @Override
    public String toString() {
        return super.toString() + ", matNummer=" + matNummer ;
    }

    /**
     * Bestimmen, ob dieses Student-Objekt einem anderen Objekt gleich ist.
     * Zwei Student-Objekte gelten als gleich, wenn und nur wenn sie die gleiche Matrikelnummer und die gleichen Namen und Vornamen haben.
     *
     * @param o das zu vergleichende Objekt mit diesem Student-Objekt
     * @return true, wenn das gegebene Objekt ein Student mit der gleichen Matrikelnummer und den gleichen Namen und Vornamen wie dieses Objekt ist, false sonst
     */
    @Override
    public boolean equals(@NotNull Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return getMatNummer() == student.getMatNummer() &&
                super.getName().equals(student.getName()) &&
                super.getVorname().equals(student.getVorname());
    }


    public int compareTo(@NotNull Student o) {
        // Vergleicht den Namen und den Vornamen des Students mit dem Namen und dem Vornamen des übergebenen Students.
        // Gibt den Vergleichswert des Namens und des Vornamens zurück, falls dieser ungleich 0 ist.
        // Andernfalls wird Die MatNummer der Boxer verglichen und der Vergleichswert zurückgegeben.
        String thisName = this.getName() + " " + this.getVorname();
        String otherName = o.getName() + " " + o.getVorname();
        int namecomp = thisName.compareTo(otherName);

        if (namecomp != 0)
            return namecomp;

        if (this.matNummer == o.matNummer)
            return 0;
        else return this.matNummer > o.matNummer ? 1: -1;
    }
}
