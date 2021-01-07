package com.kpakozdi.ea1;

public class LinkedList<T> implements List<T> {
    // legelső elem, innen kezdődik a lista
    private Node<T> head;

    @Override
    public void addFirst(T value) {
        Node<T> newNode = new Node<T>(value, null);
        newNode.next = head;
        head = newNode;
        // shortcut:
        // head = new Link(value, head);
    }

    @Override
    public void addLast(T value) {
        Node<T> newNode = new Node<T>(value, null);
        if (head == null) { // üres-e a lista
            head = newNode;
        } else {
            Node<T> l = head;

            while (l.next != null) {
                l = l.next;
            }
            // a while után az l a legutolsó elem lesz
            l.next = newNode;
        }
    }

    @Override
    public void addAfter(T element, int count) {
        Node<T> iter = head;
        for (int i = 0; i < count - 1; i++) {
            iter = iter.next;
        }
        Node<T> newNode = new Node<>(element, null);

        newNode.next = iter.next;
        iter.next = newNode;
    }

    @Override
    public void removeFirst() {
        head = head.next;
    }

    @Override
    public void remove(int index) {
        if (index == 0) {
            removeFirst();
            return;
        }
        Node<T> iter = head;
        for (int i = 0; i < index - 1; i++) {
            iter = iter.next;
        }
        iter.next = iter.next.next;
    }

    @Override
    public int find(T element) {
        Node<T> l = head;
        int index = 0;
        while (l != null) {
            if (l.value.equals(element)) {
                return index;
            }
            index++;
            l = l.next;
        }
        return -1;
    }

    public void print() {
        Node<T> l = head;
        while (l != null) {
            System.out.println(l.value);
            l = l.next;
        }
    }

    public Node<T> getHead() {
        return head;
    }
}

class Node<T> {
    public T value;
    public Node<T> next;

    public Node(T value, Node<T> next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    // TODO: getter, setter
}
