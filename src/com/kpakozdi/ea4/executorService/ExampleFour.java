package com.kpakozdi.ea4.executorService;

import java.util.concurrent.*;

public class ExampleFour {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(8);

        Callable<Long> sum = new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                System.out.println("Running task on thread: " + Thread.currentThread().getName());
                long counter = 0;
                for (int i = 0; i < 10E7; i++) {
                    counter += i;
                }
                return counter;
            }
        };

        Future<Long> result = executorService.submit(sum); // azonnal visszatér

        try {
            Long sumResult = result.get();
            System.out.println(sumResult);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

    }

}
