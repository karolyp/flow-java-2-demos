package com.kpakozdi.ea4.threading;

import java.util.Date;

// Egy módszer thread létrehozására: Thread osztályból öröklődés és a run() override-olása
class MyThread extends Thread {
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("[" + Thread.currentThread().getName() + "] " + new Date().toString() + "\r");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void terminate() {
        this.running = false;
    }
}
