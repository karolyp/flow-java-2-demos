package com.kpakozdi.ea4.threading;

import java.util.concurrent.atomic.AtomicInteger;

public class ExampleTwo {
    private Counter counter = new Counter();

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        new ExampleTwo().doStuff();

        long duration = System.currentTimeMillis() - start;
        System.out.println("A futtatás " + duration + " ms ideig tartott");
    }

    private void doStuff() throws InterruptedException {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10E7; i++) {
                    counter.increment();
                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10E7; i++) { // 10^7 E - exponens
                    counter.decrement();
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("A counter értéke: " + counter.value());
    }
}

class Counter {
    private Integer c = 0;

    // intrinsic/monitor lock: lock (1 db van minden egyes Java objectnek)
    public synchronized void increment() {
        c++; // c = c + 1 nem atomi ha nem szinkronizált
    }
    // intrinsic/monitor lock: unlock

    // ugyanazt az intrinsic lockot használja
    public synchronized void decrement() {
        c--;
    }

    public int value() {
        return c;
    }
}

class Counter2 {
    // AtomicBoolean, AtomicDouble, stb...
    private AtomicInteger c = new AtomicInteger(0);

    public void increment() {
        c.getAndIncrement(); // prefix ++c
        // c.incrementAndGet() postfix c++
    }

    public void decrement() {
        c.getAndDecrement();
    }

    public int value() {
        return c.get();
    }
}
