package com.kpakozdi.ea4;

public class SynchronizedStatement {
    public static void main(String[] args) throws InterruptedException {
        Adder a = new Adder();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                a.inc1();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                a.inc2();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(a.getC1());
        System.out.println(a.getC2());

    }
}

class Adder {
    private long c1 = 0;
    private long c2 = 0;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void inc1() {
        synchronized (lock1) {
            c1++;
        }
    }

    public void inc2() {
        synchronized (lock2) {
            c2++;
        }
    }

    public long getC1() {
        return c1;
    }

    public long getC2() {
        return c2;
    }
}