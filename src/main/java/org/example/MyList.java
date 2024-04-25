package org.example;

import java.util.Iterator;

public interface MyList<T> {
        void add(T element);
        void remove(int index);
        T get(int index);
        int size();
        boolean isEmpty();
        void clear();
        Iterator<T> iterator();
}
