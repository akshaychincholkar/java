package com.game.java.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SingleThreadExecutors {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Running the thread!!");
            }
        };

        try {
            executor.submit(runnable);
            System.out.println("Shutingdown executor");
            executor.shutdown();
            executor.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.err.println(e);
        } finally {

            if (!executor.isTerminated()) {
                System.err.println("cancel  tasks");
            }
            executor.shutdownNow();
            System.out.println(" finished");
        }
    }
}
