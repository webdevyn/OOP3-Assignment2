package implementations;

import exceptions.EmptyQueueException;
import utilities.Iterator;
import utilities.QueueADT;

import java.util.Collection;

public class MyQueue<E> implements QueueADT<E> {
    private MyDLL<E> myDLLlist;

    public MyQueue() {
        myDLLlist = new MyDLL<>();
    }

    @Override
    public void enqueue(E toAdd) throws NullPointerException {

    }

    @Override
    public E dequeue() throws EmptyQueueException {
        return null;
    }

    @Override
    public E peek() throws EmptyQueueException {
        return null;
    }

    @Override
    public void dequeueAll() {

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
    public int search(E toFind) {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public boolean equals(QueueADT<E> that) {
        return false;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public E[] toArray(E[] toHold) throws NullPointerException {
        return null;
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }
}
