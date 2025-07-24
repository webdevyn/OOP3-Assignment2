package implementations;

import utilities.Iterator;
import utilities.ListADT;

import java.util.Arrays;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class MyArrayList<E> implements ListADT<E> {
    //Constants
    private static final int DEFAULT_CAPACITY = 10;

    //Fields
    private E[] elements;
    private int size;

    //Now we create the array using Object[] and casting it to type E[]
    public MyArrayList() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    //Resize method to use when necessary
    private void resize() {
        int newCapacity = elements.length * 2;
        E[] biggerArray = (E[]) new Object[newCapacity];
        Arrays.copyOf(elements, newCapacity);
        elements = biggerArray;
    }

    @Override
    public int size() {
        System.out.println("The size is: " + size);
        return size;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == elements.length) {
            resize();
        }

        //Start at end of list and decrement until you hit the index you want to insert at
        for (int i = size; i  > index; i-- ) {
            //Shift the elements by taking the elements and moving them one position up
            elements[i] = elements[i-1];
            elements[index] = toAdd;
            size++;
        }

        return false;
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException {
        elements[size] = toAdd;
        size++;
        return false;
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        return false;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        return null;
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        return false;
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    //Implement Iterator class
    private class ArrayListIterator implements Iterator<E> {
        private int currentIndex;

        @Override
        public boolean hasNext() {
            if(currentIndex < size) {
                return true;
            }
            return false;
        }

        @Override
        public E next() throws NoSuchElementException {
            if(currentIndex < size) {
                E element = (E) elements[currentIndex];
                currentIndex++;
                return element;
            }
            return null;
        }
    }
}
