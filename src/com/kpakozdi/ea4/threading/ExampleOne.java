package com.kpakozdi.ea4.threading;

import java.util.Date;
import java.util.Scanner;

public class ExampleOne {
    public static void main(String[] args) {
        MyThread t1 = new MyThread(); // polimorfizmus (objektumok többalakúsága)
        t1.start();

        System.out.printf("[%s] Kilépéshez nyomj entert...%n", Thread.currentThread().getName());
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        t1.terminate();
    }
}



