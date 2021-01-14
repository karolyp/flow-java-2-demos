package com.kpakozdi.ea4.threading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExampleThree {
    CounterWithLocks counter = new CounterWithLocks();

    static class CounterWithLocks {
        private int c;
        private Lock lock = new ReentrantLock();

        public void increment() {
            lock.lock();
            c++; // kritikus szekció
            lock.unlock();
        }

        public void decrement() {
            lock.lock();
            c--;
            lock.unlock();
        }

        public int value() {
            return c;
        }
    }

    static class Counter {
        private int c;
        private final Object o = new Object();

        public void increment() {
            synchronized (this) {
                c++;
            }
        }

//        public synchronized void increment() { // this a lockját fogja használni
//            c++;
//        }

        public void decrement() {
            synchronized (this) {
                c--;
            }
        }

        public int value() {
            return c;
        }

    }

    public static void main(String[] args) throws InterruptedException {
        new ExampleThree().doStuff();
    }

    private void doStuff() throws InterruptedException {
//        Runnable r = new Runnable() { // anonim osztály + funkcionális interfész (1 db metódusa van)
//            @Override
//            public void run() {
//                System.out.println("hello");
//            }
//        };
//
//        Runnable r1 = () -> { // lambda
//            System.out.println("hello");
//        };

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10E7; i++) {
                    counter.increment();
                }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10E7; i++) {
                counter.decrement();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("A c = " + counter.value());
    }
}
