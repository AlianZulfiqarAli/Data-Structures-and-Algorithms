import org.jetbrains.annotations.NotNull;

import java.util.Comparator;

public class ComparatorBoxerGewicht implements Comparator<Boxer> {

    public int compare(@NotNull Boxer o1, @NotNull Boxer o2) {
        return o1.getGewicht() - o2.getGewicht();
    }
}
