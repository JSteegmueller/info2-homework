package main;

import java.util.*;

public class GenericList<E> implements List<E> {

    int firstEmptyIdx;
    E[] data;


    private boolean indexOutOfBounds(int idx) {
        return (idx >= firstEmptyIdx || idx < 0);
    }

    public GenericList() {
        // TODO constructor initializes data with 4 elements!
        // Hint: You can create a generic array as Object array, which is casted to type E:
        data = (E[]) new Object[4];
        firstEmptyIdx = 0;
    }

    // Check the documentation of the List interface for descriptions of the following Methods:

    @Override
    public boolean add(E arg0) {
        if (firstEmptyIdx >= data.length) {
            E[] newData = (E[]) new Object[data.length * 2];
            for(int i = 0 ; i < firstEmptyIdx ; i++){
                newData[i] = data[i];
            }
            data = newData;
        }
        data[firstEmptyIdx] = arg0;
        firstEmptyIdx++;
        return true;
    }

    @Override
    public void add(int arg0, E arg1) {
        if (indexOutOfBounds(arg0)) throw new IndexOutOfBoundsException("idx");
        int firstEmptySafe = firstEmptyIdx;
        if (indexOutOfBounds(firstEmptyIdx + 1)) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        while (firstEmptySafe >= arg0) {
            data[firstEmptySafe + 1] = data[firstEmptySafe];
            firstEmptySafe--;
        }
        data[arg0] = arg1;
        firstEmptyIdx++;
    }

    @Override
    public boolean addAll(Collection<? extends E> arg0) {
        for (E val :
                arg0) {
            add(val);
        }
        return true;
    }

    @Override
    public boolean addAll(int arg0, Collection<? extends E> arg1) {
        // Bonus (2 Punkte)
        for (E val :
                arg1) {
            add(arg0, val);
            arg0++;
        }
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i <= firstEmptyIdx; i++) {
            data[i] = null;
        }
        firstEmptyIdx = 0;
    }

    @Override
    public boolean contains(Object arg0) {
        for(int i = 0 ; i < firstEmptyIdx ; i++){
            if(data[i].equals(arg0)) return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> arg0) {
        for (Object var:
             arg0) {
            if (!contains(var)) return false;
        }
        return true;
    }

    @Override
    public E get(int arg0) {
        if (indexOutOfBounds(arg0)) throw new IndexOutOfBoundsException("idx");
        return data[arg0];
    }

    @Override
    public int indexOf(Object arg0) {
        // TODO
        return 0;
    }

    @Override
    public boolean isEmpty() {
        // TODO
        return false;
    }


    @Override
    public int lastIndexOf(Object arg0) {
        // TODO
        return 0;
    }


    @Override
    public boolean remove(Object arg0) {
        // TODO
        return false;
    }

    @Override
    public E remove(int arg0) {
        // TODO
        return null;
    }

    @Override
    public boolean removeAll(Collection<?> arg0) {
        // TODO
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> arg0) {
        // Bonus
        throw new UnsupportedOperationException();
    }

    @Override
    public E set(int arg0, E arg1) {
        // TODO
        return null;
    }

    @Override
    public int size() {
        return firstEmptyIdx ;
    }

    @Override
    public List<E> subList(int arg0, int arg1) {
        // TODO
        // Hint you can use subList method from Array.asList(data)
        return null;
    }

    @Override
    public Object[] toArray() {
        // TODO
        return null;
    }

    @Override
    public <T> T[] toArray(T[] arg0) {
        // TODO
        return null;
    }

    ////////////////////// You dont have to touch the following code ///////////////


    /**
     * The GenericListIterator implements the ListIterator interface, which allows
     * us to use Java Iterators, and all their features on the Generic list.
     * For example you can use the foreach loop to iterate over all elements in a GenericList:
     * for (E elt : list)
     * See the printList Method in Generics.java for an example.
     *
     * @param <E> Type of the GnereicList elements.
     */
    @SuppressWarnings("hiding")
    class GenericListIterator<E> implements ListIterator<E> {

        private GenericList<E> list;
        private int position;

        /**
         * Creates a GenericListIterator at position 0 in the list.
         *
         * @param list The list which is iterated.
         */
        GenericListIterator(GenericList<E> list) {
            this.list = list;
            position = 0;
        }

        /**
         * Creates a GenericListIterator at the given position in the list.
         *
         * @param list     The list which is iterated.
         * @param position Start position of the iterator.
         */
        GenericListIterator(GenericList<E> list, int position) {
            this.list = list;
            this.position = position;
        }

        // For descriptions of the overwritten methods see the JavaDocs of the @see(ListIterator) interface.
        @Override
        public void add(E arg0) {
            list.add(arg0);
        }

        @Override
        public boolean hasNext() {
            return position < list.size();
        }

        @Override
        public boolean hasPrevious() {
            return position > 0;
        }

        @Override
        public E next() {
            if (position >= list.size()) {
                throw new NoSuchElementException();
            }
            E e = list.get(position);
            position += 1;
            return e;
        }

        @Override
        public int nextIndex() {
            return position;
        }

        @Override
        public E previous() {
            if (position <= 0) {
                throw new NoSuchElementException();
            }
            position -= 1;
            E e = list.get(position);
            return e;
        }

        @Override
        public int previousIndex() {
            return position - 1;
        }

        @Override
        public void remove() {
            list.remove(position);
        }

        @Override
        public void set(E arg0) {
            list.set(position, arg0);
        }

    }

    // The Iterator related methods just return a GenericListIterator of this list.
    // For detailed explanation see the documentation of the List and Iterator interface.
    @Override
    public Iterator<E> iterator() {
        return listIterator();
    }

    @Override
    public ListIterator<E> listIterator() {
        return new GenericListIterator<E>(this);
    }

    @Override
    public ListIterator<E> listIterator(int arg0) {
        if (arg0 < 0 || arg0 >= firstEmptyIdx) {
            throw new IndexOutOfBoundsException(arg0);
        }
        return new GenericListIterator<E>(this, arg0);
    }

}
