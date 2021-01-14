package com.kpakozdi.ea4.threading;

// Másik módszer: Runnable interfész megvalósítása
class MyRunnableImpl implements Runnable {
    private String name;

    public MyRunnableImpl(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (; ; ) {
            System.out.println("Hello " + this.name + "!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}