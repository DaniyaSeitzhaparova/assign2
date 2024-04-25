package org.example;

public interface MyList {
        void add(T element);
        void remove(int index);
        T get(int index);
        int size();
        boolean isEmpty();
        void clear();
        Iterator<T> iterator();
}
