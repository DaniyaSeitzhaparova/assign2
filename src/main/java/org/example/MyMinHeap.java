package org.example;

public class MyMinHeap<T extends Comparable<T>> {
    private MyList<T> list;

    public MyMinHeap() {
        this.list = new MyArrayList<>();
    }

    public void insert(T element) {
        list.add(element);
        heapifyUp();
    }

    private void heapifyUp() {
        int index = list.size() - 1;
        while (index > 0) {
            int parentIndex = (index - 1) / 2;
            T parent = list.get(parentIndex);
            T current = list.get(index);
            if (current.compareTo(parent) >= 0) {
                break;
            }
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    private void swap(int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public T extractMin() {
        if (isEmpty()) {
            throw new RuntimeException("Heap is empty");
        }
        T min = list.get(0);
        int lastIndex = list.size() - 1;
        list.set(0, list.get(lastIndex));
        list.remove(lastIndex);
        heapifyDown();
        return min;
    }

    private void heapifyDown() {
        int index = 0;
        int size = list.size();
        while (true) {
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;
            int smallestIndex = index;

            if (leftChildIndex < size && list.get(leftChildIndex).compareTo(list.get(smallestIndex)) < 0) {
                smallestIndex = leftChildIndex;
            }

            if (rightChildIndex < size && list.get(rightChildIndex).compareTo(list.get(smallestIndex)) < 0) {
                smallestIndex = rightChildIndex;
            }

            if (smallestIndex == index) {
                break;
            }

            swap(index, smallestIndex);
            index = smallestIndex;
        }
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

