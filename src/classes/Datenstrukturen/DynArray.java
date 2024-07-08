import org.jetbrains.annotations.NotNull;

import java.nio.BufferUnderflowException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class DynArray<T> implements Iterable<T>{

    private T[] array;
    private int size;
    @SuppressWarnings("unchecked")
    public DynArray() {
        array = (T[]) new Object[1];
    }

    private class DynArrayIterator implements Iterator<T>{

        private int i;
        private DynArrayIterator(){
            i = 0;
        }

        @Override
        public boolean hasNext() {
            return i < size;
        }
        @Override
        public T next() {
            if (!hasNext())
                throw new IndexOutOfBoundsException("index out of bounds");
            return array[i++];
        }

    }

    public int size(){
        return size;
    }

    public int capacity(){
        return array.length;
    }

    public T get(int pos) throws IndexOutOfBoundsException{
        if (size() == 0)
            throw new BufferUnderflowException();
        if(!(pos >= 0 && pos < capacity()))
            throw new IndexOutOfBoundsException("index out of bounds");
        else if (null == array[pos])
            throw new NoSuchElementException("There is no element there!");
        return array[pos];
    }

    public T set(int pos, T e) throws IndexOutOfBoundsException{
        if (null == e)
            throw new IllegalArgumentException("There is no element there!");
        T alterWert = get(pos);
        array[pos] = e;
        return alterWert;
    }


    public void addFirst(T e){
        if(null == e)
            throw new IllegalArgumentException("null can not be an element");
        //wenn das array voll ist
        if (size() == capacity())
            increase();
        //normalfall: verschiebe die elemente ein Mal nach rechts, sodass index 0 frei bleibt
        for(int i = array.length-1; i>0; i--)
            array[i] = array[i-1];
        //füge das neue element hinzu
        array[0] = e;
        size++;
    }

    public void addLast(T e){
        if(null == e)
            throw new IllegalArgumentException("null can not be an element");
        //wenn das array voll ist
        if (size() == capacity())
           increase();
        // füge das letzte Element hinzu:
        array[size++] = e;
    }

    public T removeFirst() throws NoSuchElementException{
        if(size() == 0)
            throw new NoSuchElementException("Memory is empty");
        T tmp = array[0];
        //wenn das Array nur noch zu einem Viertel gefüllt ist, dann halbiere die Größe
        //normalfall: verschiebe die elemente ein Mal nach rechts, sodass index 0 nicht frei bleibt
        for(int i = 0; i< array.length-1; i++)
            array[i] = array[i+1];
        size--;
        if (size() == (capacity()/4))
            decrease();
//        System.out.println(Arrays.toString(array));
        return tmp;
    }

    public T removeLast() throws NoSuchElementException{
        if(size() == 0)
            throw new NoSuchElementException("Memory is empty");
        T tmp = array[size -1];
        array[--size] = null;
        if (size() == (capacity()/4))
            decrease();
//        System.out.println(Arrays.toString(array));
        return tmp;
    }

    public void insert(T e,int pos){
        //fehler behandlung
        if (pos < 0 || pos >= size())
            throw new ArrayIndexOutOfBoundsException("Position not found in the array");
        if (pos == 0) {
            addFirst(e);
            return;
        }
        //falls der Speicher voll ist, dann vergroessere den Speicher
        if (size() == capacity())
            increase();
        //finde den passenden index
        for (int i = size(); i> 0; i--) {
            //fuege das Element an der position, wenn gefunden
            if (pos == i) {
                array[pos] = e;
                size++;
                break;
            }
            //sonst verschiebe die elemente einmal nach rechts
            array[i] = array[i -1];
        }
    }

    public T remove(int pos) {
        if (size() == 0)
            throw new BufferUnderflowException();
        if (pos < 0 || pos >= size())
            throw new ArrayIndexOutOfBoundsException("Position not found in the array");
        // store the element in tmp and write null in the position
        T tmp = array[pos];
        array[pos] = null;
        for (int i = pos; i < size() - 1; i++) {
            array[i] = array[i+1];
        }
        size--;
        if (size() == (capacity()/4))
            decrease();
        return tmp;
    }


    private void decrease(){
        @SuppressWarnings("unchecked")
        // create an array with the half size of array, but it should be at least 1
        T [] tmpArray = (T[]) new Object[(array.length/2>0? array.length/2:1)];
        // kopiere die elemente von dem kleinen in das grosse array
        for (int i = 0; i < array.length/2; i++)
            tmpArray[i] = array[i];
        array = tmpArray;
    }

    private void increase(){
        @SuppressWarnings("unchecked")
        //erstelle ein array mit doppelter Größe
        T [] tmpArray = (T[]) new Object[(array.length * 2)];
        // kopiere die elemente von dem kleinen in das grosse array
        for (int i = 0; i < array.length; i++)
            tmpArray[i] = array[i];
        array = tmpArray;
    }

    @NotNull
    @Override
    public Iterator<T> iterator() {
        return new DynArrayIterator();
    }

}
