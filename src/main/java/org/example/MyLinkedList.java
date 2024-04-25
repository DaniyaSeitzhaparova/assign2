package org.example;

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

        private MyNode head;
        private MyNode tail;
        private int size;
    }
