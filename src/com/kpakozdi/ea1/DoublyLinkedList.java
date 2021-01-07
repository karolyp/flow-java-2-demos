package com.kpakozdi.ea1;

public class DoublyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;

    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        if (head == null) {
            tail = newNode;
        } else {
            head.prev = newNode;
        }
        newNode.next = head;
        head = newNode;
    }

    static class Node<T> {
        public T data;
        public Node<T> next;
        public Node<T> prev;

        public Node(T data) {
            this.data = data;
        }
    }
}
