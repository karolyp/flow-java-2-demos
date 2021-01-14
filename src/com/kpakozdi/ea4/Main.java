package com.kpakozdi.ea4;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private Counter counter = new Counter();

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        new Main().doStuff();
        long stop = System.currentTimeMillis() - start;
        System.out.println("Finshed: " + stop + " ms");
    }

    private void doStuff2() {
        int c = 0;
        for (int i = 0; i < 10E6; i++) {
            c++;
        }
        for (int i = 0; i < 10E6; i++) {
            c--;
        }
        System.out.println(c);
    }

    private void doStuff() {
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10E6; i++) {
                counter.increment();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10E6; i++) {
                counter.decrement();
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
            System.out.println(counter.value());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Counter {
    private int c = 0;

    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public int value() {
        return c;
    }

}