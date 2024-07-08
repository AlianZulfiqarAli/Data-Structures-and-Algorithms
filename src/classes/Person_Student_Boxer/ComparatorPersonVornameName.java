import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class ComparatorPersonVornameName implements Comparator<Person> {

    @Override
    public int compare(@NotNull Person o1, @NotNull Person o2) {
        String thisName = o1.getName() + " " + o1.getVorname();
        String otherName = o2.getName() + " " + o2.getVorname();
        return thisName.compareTo(otherName);
    }
}
