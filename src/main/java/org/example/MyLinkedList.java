package org.example;

import java.util.Iterator;

public class MyLinkedList<T> implements MyList<T> {
    private class MyNode {
        T data;
        MyNode next;
        MyNode prev;

        MyNode(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    private MyNode head;
    private MyNode tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void add(T element) {
        MyNode newNode = new MyNode(element);
        if (head == null) {
            head = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
        }
        tail = newNode;
        size++;
    }

    @Override
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        MyNode current = getNode(index);
        if (current.prev == null) {
            head = current.next;
        } else {
            current.prev.next = current.next;
        }
        if (current.next == null) {
            tail = current.prev;
        } else {
            current.next.prev = current.prev;
        }
        size--;
    }

    private MyNode getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }
        MyNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public T get(int index) {
        MyNode current = getNode(index);
        return current.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        while (head != null) {
            MyNode temp = head;
            head = head.next;
            temp.next = null;
            temp.prev = null;
        }
        tail = null;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new MyLinkedListIterator<>(this);
    }

    private class MyLinkedListIterator<T> implements Iterator<T> {
        private MyLinkedList<T> list;
        private MyLinkedList<T>.MyNode current;

        public MyLinkedListIterator(MyLinkedList<T> list) {
            this.list = list;
            this.current = list.head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new RuntimeException("No such element");
            }
            T data = current.data;
            current = current.next;
            return data;
        }
    }

    @Override
    public void sort() {
        if (head == null || head.next == null) {
            return;
        }
        boolean swapped;
        do {
            swapped = false;
            MyNode current = head;
            MyNode next = head.next;
            while (next != null) {
                if (current.data.compareTo(next.data) > 0) {
                    T temp = current.data;
                    current.data = next.data;
                    next.data = temp;
                    swapped = true;
                }
                current = next;
                next = next.next;
            }
        } while (swapped);
    }
}