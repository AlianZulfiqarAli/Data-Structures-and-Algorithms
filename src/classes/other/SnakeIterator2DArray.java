import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Ein Iterator, der das gegebene zweidimensionale Array in Schlangenlinienform durchläuft.
 *
 * @param <T> der Typ der Elemente im Array
 */
public class SnakeIterator2DArray<T> implements Iterator<T> {

    private T[][] array;
    private int zeile;
    private int spalte;

    /**
     * Erstellt einen neuen SnakeIterator2DArray für das gegebene Array.
     *
     * @param array das zu durchlaufende Array
     */
    public SnakeIterator2DArray(T[][] array){
        this.array = array;
        zeile = spalte = 0;
    }

    /**
     * Prüft, ob es noch weitere Elemente im Array gibt, die iteriert werden können.
     *
     * @return true, wenn es noch weitere Elemente im Array gibt, andernfalls false
     */
    public boolean hasNext() {
        return zeile < array.length && spalte < array[zeile].length;
    }

    /**
     * Gibt das nächste Element im Array zurück.
     *
     * @return das nächste Element im Array
     * @throws NoSuchElementException wenn es keine weiteren Elemente im Array gibt
     */
    public T next() {
        if(!(hasNext())) {
            throw new NoSuchElementException();
        }
        T element;
        if(zeile % 2 == 0) {
            element = array[zeile][spalte++];
            if(spalte >= array[zeile].length) {
                zeile++;
                if(zeile < array.length) {
                    spalte = array[zeile].length-1;
                }
            }
        } else {
            element = array[zeile][spalte--];
            if(spalte < 0) {
                zeile++;
                spalte =  0;
            }
        }
        return element;
    }

}
