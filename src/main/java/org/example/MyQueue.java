package org.example;

public class MyQueue<T> {
    private MyList<T> list;

    public MyQueue() {
        this.list = new MyLinkedList<>();
    }

    public void enqueue(T element) {
        list.add(element);
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Empty");
        }
        T element = list.get(0);
        list.remove(0);
        return element;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Empty");
        }
        return list.get(0);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int size() {
        return list.size();
    }

    public void sort() {
        throw new UnsupportedOperationException("Not supported");
    }
}



