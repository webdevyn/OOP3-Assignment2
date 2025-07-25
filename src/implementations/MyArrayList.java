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
        elements = Arrays.copyOf(elements, newCapacity);
    }

    @Override
    public int size() {
        System.out.println("The size is: " + size);
        return size;
    }

    @Override
    public void clear() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (toAdd == null) {
            throw new NullPointerException();
        }
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
        }
        //Insert the element at the index
        elements[index] = toAdd;
        size++;
        return true;
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException();
        }
        if (size == elements.length) {
            resize();
        }
        elements[size] = toAdd;
        size++;
        return true;
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new NullPointerException();
        }

        Iterator<? extends E> iterator = toAdd.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
        }

        return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return elements[index];
    }

    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        if  (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E removedElement = elements[index];

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return removedElement;
    }

    @Override
    public E remove(E toRemove) throws NullPointerException {
        E removedElement;
        if (toRemove == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < size; i++) {
            if (toRemove.equals(elements[i])) {
                removedElement = elements[i];
                //need to shift elements
                for (int j = i; j < size - 1; j++) {
                    elements[j] = elements[j + 1];
                }
                elements[size - 1] = null;
                size--;
                return  removedElement;
            }
        }
        return null;
    }

    @Override
    public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (toChange == null) {
            throw new NullPointerException();
        }
        E previousElement = elements[index];
        elements[index] = toChange;

        return previousElement;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if  (toFind == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(toFind)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        if  (toHold == null) {
            throw new NullPointerException();
        }

        if (toHold.length < size) {
            return (E[]) Arrays.copyOf(elements, size, toHold.getClass());
        }

        System.arraycopy(elements, 0, toHold, 0, size);

        if  (toHold.length > size) {
            toHold[size] = null;
        }

        return toHold;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[size];
        System.arraycopy(elements, 0, newArray, 0, size);
        return newArray;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
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
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if(currentIndex < size) {
                E element = (E) elements[currentIndex];
                currentIndex++;
                return element;
            }
            return null;
        }
    }
}
