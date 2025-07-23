package implementations;

import utilities.Iterator;
import utilities.ListADT;

public class MyDLL<E> implements ListADT {

    private MyDLLNode<E> head;
    private MyDLLNode<E> tail;
    private MyDLLNode<E> current;
    private int size;

    public MyDLL() {
        head = null;
        tail = null;
        current = null;
        size = 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean add(int index, Object toAdd) throws NullPointerException, IndexOutOfBoundsException {
        return false;
    }

    @Override
    public boolean add(Object toAdd) throws NullPointerException {
        return false;
    }

    @Override
    public boolean addAll(ListADT toAdd) throws NullPointerException {
        return false;
    }

    @Override
    public Object get(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public Object remove(int index) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public Object remove(Object toRemove) throws NullPointerException {
        return null;
    }

    @Override
    public Object set(int index, Object toChange) throws NullPointerException, IndexOutOfBoundsException {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object toFind) throws NullPointerException {
        return false;
    }

    @Override
    public Object[] toArray(Object[] toHold) throws NullPointerException {
        return new Object[0];
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Iterator iterator() {
        return null;
    }


}
