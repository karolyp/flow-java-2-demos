package com.kpakozdi;

public class Main {
    public static void main(String[] args) {
        List<Integer> myList = new DoublyLinkedList<>();

        myList.addFirst(789);
        myList.addFirst(1566);
        myList.addFirst(1566123);
        myList.addFirst(1123123566);

        myList.print();

    }
}

