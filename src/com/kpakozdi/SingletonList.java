package com.kpakozdi;

// K - key, V - value, T - type, E - element

public class SingletonList<T> {
    private T element;

    public SingletonList(T element) {
        this.element = element;
    }

    public void print() {
        System.out.println(element);
    }
}
