package com.kpakozdi;

public class Stack<T> {
    private final LinkedList<T> container;

    public Stack() {
        this.container = new LinkedList<>();
    }

    public void push(T element) {
        container.addFirst(element);
    }

    public T pop() {
        T top = peek();
        container.removeFirst();
        return top;
    }

    public T peek() {
        return container.getHead().value;
    }
}
