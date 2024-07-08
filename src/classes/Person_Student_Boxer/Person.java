import org.jetbrains.annotations.NotNull;

public class Person implements Comparable<Person> {
    private String name;
    private String vorname;

    public Person(String name, String vorname){
        this.name = name;
        this.vorname = vorname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    @Override
    public String toString() {
        return "name=" + name +
                ", vorname=" + vorname;
    }

    /**
     * Die Methode bestimmt, ob dieses Person-Objekt einem anderen Objekt gleich ist.
     * Zwei Person-Objekte gelten als gleich, wenn und nur wenn sie denselben Namen und Vornamen haben.
     *
     * @param o das zu vergleichende Objekt mit diesem Person-Objekt
     * @return true, wenn das gegebene Objekt eine Person mit demselben Namen und Vornamen wie dieses Objekt ist, false sonst
     */
    public boolean equals(Object o) {
        if (o == null)
            return false;
        else if (o instanceof Person person) {
            return getName().equals(person.getName()) &&
                    getVorname().equals(person.getVorname());
        }
        else return false;
    }


    @Override
    public int compareTo(@NotNull Person o) {
        String thisname = this.vorname + this.name;
        String othername = o.vorname + o.name;
        return thisname.compareTo(othername);
    }
}
