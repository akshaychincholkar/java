package com.game.java.threading;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServices {
    public static void main(String[] args) {
        ExecutorService executors = Executors.newSingleThreadExecutor();
        executors.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("Single thread execution...");
            }
        });

        // future with Runnable will return null as shown below
        Future future = executors.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable with submit methods");
            }
        });
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        executors.shutdown();
    }
}
