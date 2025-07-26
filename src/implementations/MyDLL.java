package implementations;

import utilities.Iterator;
import utilities.ListADT;

import java.util.NoSuchElementException;

public class MyDLL<E> implements ListADT<E> {
    private int size;
    private MyDLLNode<E> head;
    private MyDLLNode<E> tail;

    public MyDLL() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (toAdd == null) {
            throw new  NullPointerException();
        }

        //Create new node
        MyDLLNode<E> newNode = new MyDLLNode<>(toAdd);

        //If inserting at beginning
        if (index == 0) {
            //insert the new node in beginning and point it towards the current head
            newNode.setNext(head);
            //need to check if current head is holding a value
            if (head != null) {
                //point current head back to new node
                head.setPrev(newNode);
            }
            //update the head value to newnode
            head = newNode;

            //check if list is empty (empty list will have a null tail) if it is empty the tail will also have to be the newnode
            if (tail == null) {
                tail = newNode;
            }
        }
        //If inserting at end
        else if (index == size) {
            newNode.setPrev(tail);
            if (tail != null) {
                tail.setNext(newNode);
            }
            tail = newNode;
            if (head == null) {
                head = newNode;
            }
        }
        //If inserting in middle
        else {
            MyDLLNode<E> currentNode = head;
            //go through all the elements until you hit the current index
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.getNext();
            }
            //get previous node so we know where to point the newly inserted node
            MyDLLNode<E> previousNode = currentNode.getPrev();
            newNode.setPrev(previousNode);
            newNode.setNext(currentNode);

            if  (previousNode != null) {
                previousNode.setNext(newNode);
            }
            currentNode.setPrev(newNode);
        }
        size++;
        return true;
    }

    @Override
    public boolean add(E toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new  NullPointerException();
        }
        return add(size, toAdd);
    }

    @Override
    public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
        if (toAdd == null) {
            throw new  NullPointerException();
        }
        Iterator<? extends E> iterator = toAdd.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
        }
        return true;
    }

    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        if  (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        MyDLLNode<E> currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        return currentNode.getElement();
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
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (toChange == null) {
            throw new  NullPointerException();
        }

        MyDLLNode<E> currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        E replacedElement = currentNode.getElement();
        currentNode.setElement(toChange);

        return replacedElement;
    }

    @Override
    public boolean isEmpty() {
        return tail == null;
    }

    @Override
    public boolean contains(E toFind) throws NullPointerException {
        if (toFind == null) {
            throw new  NullPointerException();
        }
        MyDLLNode<E> currentNode = head;

        while (currentNode != null) {

            if (toFind.equals(currentNode.getElement())) {
                return true;
            }
            currentNode =  currentNode.getNext();
        }
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
        return new DLLIterator();
    }

    private class DLLIterator implements Iterator<E> {
        private MyDLLNode<E> currentNode =  head;

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() throws NoSuchElementException {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E element = currentNode.getElement();
            currentNode = currentNode.getNext();
            return element;
        }
    }

}
