package com.kpakozdi;

public class DoublyLinkedList<T> implements List<T> {
    private Node<T> head;

    static class Node<T> {
        public T data;
        public Node<T> next;
        public Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }

    @Override
    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            head = newNode;
        } else {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    @Override
    public void addLast(T element) {

    }

    @Override
    public void addAfter(T element, int i) {

    }

    @Override
    public void removeFirst() {

    }

    @Override
    public void remove(int count) {

    }

    @Override
    public void print() {
        Node<T> l = head;
        while (l != null) {
            System.out.println(l.data);
            l = l.next;
        }
    }

    @Override
    public int find(T element) {
        return 0;
    }
}
