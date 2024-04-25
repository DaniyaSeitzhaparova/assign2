package org.example;

import java.util.Iterator;


public abstract class MyArrayList<T> implements MyList<T> {
        private static final int capacity = 10;
        private Object[] elements;
        private int size;

        public MyArrayList() {
            this.elements = new Object[capacity];
            this.size = 0;
        }

        @Override
        public void add(T element) {
            if (size == elements.length) {
                increaseCapacity();
            }
            elements[size++] = element;
        }

        private void increaseCapacity() {
            Object[] newElements = new Object[elements.length * 2];
            System.arraycopy(elements, 0, newElements, 0, elements.length);
            elements = newElements;
        }

        @Override
        public void remove(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException(index);
            }
            for (int i = index; i < size - 1; i++) {
                elements[i] = elements[i + 1];
            }
            elements[--size] = null;
        }

        @Override
        public T get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException(index);
            }
            return (T) elements[index];
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
            for (int i = 0; i < size; i++) {
                elements[i] = null;
            }
            size = 0;
        }

        @Override
        public Iterator<T> iterator() {
            return (Iterator<T>) new MyArrayListIterator<T>(this);
        }


    }

