import org.jetbrains.annotations.NotNull;

import java.util.Iterator;

public class Iterator1DArray<T> implements Iterator<T> {
    private int vorne;
    private int hinten;
    private T[] array;

    public Iterator1DArray(T @NotNull [] array){
        this.array =array;
        vorne = 0;
        hinten = array.length;
    }

    public Iterator1DArray(T[] array, int start){
        this(array);
        vorne = start;

        if (start < 0)
            throw new IndexOutOfBoundsException("provided index is out of bounds");
    }

    public Iterator1DArray(T[] array, int start, int ende ){
        this(array,start);
        hinten = ende;

        if (ende > array.length)
            throw new IndexOutOfBoundsException("provided index is out of bounds");
    }

    @Override
    public boolean hasNext() {
        return vorne < hinten;
    }

    @Override
    public T next() {
        if (!hasNext())
            throw new IndexOutOfBoundsException();
        return array[vorne++];

    }


}
