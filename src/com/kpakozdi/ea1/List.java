package com.kpakozdi.ea1;

public interface List<T> {
    void addFirst(T element);

    void addLast(T element);

    void addAfter(T element, int i);

    void removeFirst();

    void remove(int count);

    void print();

    int find(T element);
}
