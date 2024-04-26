package org.example;

public class MyStack<T extends Comparable<T>>  {
        private MyList<T> list;

        public MyStack() {
            this.list = new MyArrayList<>();
        }

        public void push(T element) {
            list.add(element);
        }

        public T pop() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            int lastIndex = list.size() - 1;
            T element = list.get(lastIndex);
            list.remove(lastIndex);
            return element;
        }

        public T peek() {
            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return list.get(list.size() - 1);
        }

        public boolean isEmpty() {
            return list.isEmpty();
        }

        public int size() {
            return list.size();
        }

        public void sort() {
            list.sort();
        }
}

