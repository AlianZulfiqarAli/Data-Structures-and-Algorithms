import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

public class GenericUtil {
    public static <T> T gambling(T o1, T o2) {
        if (o1 == null || o2 == null)
            throw new NullPointerException();
        //generate random numbers between 1 and 100
        return new Random().nextInt(100) + 1 > 55 ? o1 : o2;
    }

    public static <T> Schlange<T> arrayToSchlange(T[] array) {
        Schlange<T> queue = new SchlangeMitEVL<>();
        for (T element : array) {
            queue.insert(element);
        }
        return queue;
    }

    public static <T> void printAll(Iterable<T> elementsToPrint) {
        for (T elements : elementsToPrint) {
            System.out.println(elements);
        }
    }

    public static <U> void insertInto(Puffer<U> puffer, U[] source) {
        for (U element : source) {
            puffer.insert(element);
        }
    }

    public static <U> void insertInto(Puffer<? super U> sink, Puffer<? extends U> source) {
        while (!source.isEmpty()) {
            sink.insert(source.remove());
        }
    }

    //    _____________________von Blatt 10____________________________
    //              siehe unten fuer Aufgaben aus Blatt 9
    public static <T> Folge<T> getMinima(Puffer<T> puffer1, Puffer<T> puffer2, Comparator<? super T> comparator) {
        if (puffer1.isEmpty() && puffer2.isEmpty())
            throw new NoSuchElementException("Buffers are empty!");


        // Erstelle eine neue Folge
        Folge<T> folge = new FolgeMitDynArray<>();
        // Erstelle Iteratoren für die beiden Puffer
        Iterator<T> iterator1 = puffer1.iterator();
        Iterator<T> iterator2 = puffer2.iterator();

        // Solange beide Puffer noch Elemente haben...
        while (iterator1.hasNext() && iterator2.hasNext()) {
            // Hole das nächste Element aus beiden Puffern
            T element1 = iterator1.next();
            T element2 = iterator2.next();
            // Vergleiche die Elemente mithilfe des Comparators
            if (comparator.compare(element1, element2) < 0) {
                // Wenn element1 kleiner ist, füge es zur Folge hinzu
                folge.insert(element1);
            } else if (comparator.compare(element1, element2) > 0) {
                // Wenn element2 kleiner ist, füge es zur Folge hinzu
                folge.insert(element2);
            } else {
                // Wenn die Elemente gleich sind, füge beide zur Folge hinzu
                folge.insert(element1);
                folge.insert(element2);
            }
        }
        // Wenn einer der Puffer noch Elemente hat, füge sie alle zur Folge hinzu
        if (iterator1.hasNext()) {
            while (iterator1.hasNext()) {
                folge.insert(iterator1.next());
            }
        } else {
            while (iterator2.hasNext()) {
                folge.insert(iterator2.next());
            }
        }
        // Gebe die Folge zurück
        return folge;
    }

    /**
     * Vergleicht die Inhalte der beiden Puffer elementweise mithilfe der compareTo-Methode und
     * fügt das kleinere Element einer neuen Folge hinzu. Gibt die Folge schlussendlich zurück.
     * Sobald eine der beiden Puffer keine Elemente mehr beinhaltet, werden die verbleibenden
     * Elemente der anderen Puffer der Folge hinzugefügt. Sollten beide Puffer leer sein, wird
     * eine NoSuchElementException geworfen.
     *
     * @param puffer1 der erste Puffer
     * @param puffer2 der zweite Puffer
     * @return die Folge der minimalen Elemente aus den beiden Puffern
     */
    public static <T extends Comparable<T>> Folge<T> getMinima(Puffer<T> puffer1, Puffer<T> puffer2) {
        if (puffer1.isEmpty() && puffer2.isEmpty())
            throw new NoSuchElementException("Buffers are empty!");

        Folge<T> folge = new FolgeMitDynArray<>();

        Iterator<T> iterator1 = puffer1.iterator();
        Iterator<T> iterator2 = puffer2.iterator();

        while (iterator1.hasNext() && iterator2.hasNext()) {
            T element1 = iterator1.next();
            T element2 = iterator2.next();
            folge.insert(element1.compareTo(element2) < 0 ? element1 : element2);
        }

        // Check if either iterator still has elements left
        if (iterator1.hasNext()) {
            // Add remaining elements from iterator1 to folge
            while (iterator1.hasNext()) {
                folge.insert(iterator1.next());
            }
        } else if (iterator2.hasNext()) {
            // Add remaining elements from iterator2 to folge
            while (iterator2.hasNext()) {
                folge.insert(iterator2.next());
            }
        }

        return folge;
    }

    //    _____________________von Blatt 10____________________________

    /**
     * Returns the maximum element from the two input buffers, using the provided comparator to
     * compare the elements. If both buffers are empty, a NoSuchElementException is thrown.
     *
     * @param puffer1    the first buffer
     * @param puffer2    the second buffer
     * @param comparator the comparator to use for comparing the elements
     * @return the maximum element from the two input buffers
     */
    public static <T> T getMaximum(Puffer<? extends T> puffer1, Puffer<? extends T> puffer2, Comparator<? super T> comparator) {
        if (puffer1.isEmpty() && puffer2.isEmpty())
            throw new NoSuchElementException("Buffers are empty!");

        T largestInPuffer1 = null;
        T largestInPuffer2 = null;

        for (T x : puffer1) {
            if (largestInPuffer1 == null || comparator.compare(x, largestInPuffer1) > 0) {
                largestInPuffer1 = x;
            }
        }

        for (T x : puffer2) {
            if (largestInPuffer2 == null || comparator.compare(x, largestInPuffer2) > 0) {
                largestInPuffer2 = x;
            }
        }

        if (largestInPuffer1 == null) {
            return largestInPuffer2;
        } else if (largestInPuffer2 == null) {
            return largestInPuffer1;
        } else {
            // Vergleicht die beiden Elemente largestInPuffer1 und largestInPuffer2 mithilfe des Comparators
            // und gibt das größere Element zurück.
            return comparator.compare(largestInPuffer1, largestInPuffer2) > 0 ? largestInPuffer1 : largestInPuffer2;
        }
    }
    /**
     * Returns the maximum element from the two input buffers, using the provided comparator to
     * compare the elements. If both buffers are empty, a NoSuchElementException is thrown.
     *
     * @param puffer1 the first buffer
     * @param puffer2 the second buffer
     * @return the maximum element from the two input buffers
     */
    public static <T extends Comparable<? super T>> T getMaximum(Puffer<? extends T> puffer1, Puffer<? extends  T> puffer2){
        if (puffer1.isEmpty() && puffer2.isEmpty())
            throw new NoSuchElementException("Buffers are empty!");
        T largestInPuffer1 = null;
        T largestInPuffer2 = null;

        for (T x : puffer1) {
            if (largestInPuffer1 == null || x.compareTo(largestInPuffer1) > 0) {
                largestInPuffer1 = x;
            }
        }
        for (T x : puffer2) {
            if (largestInPuffer2 == null || x.compareTo(largestInPuffer2) > 0) {
                largestInPuffer2 = x;
            }
        }

        if (largestInPuffer1 == null) {
            return largestInPuffer2;
        } else if (largestInPuffer2 == null) {
            return largestInPuffer1;
        } else {
            return largestInPuffer1.compareTo(largestInPuffer2) > 0 ? largestInPuffer1 : largestInPuffer2;
        }
    }
}
