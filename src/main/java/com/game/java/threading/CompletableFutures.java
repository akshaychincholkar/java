package com.game.java.threading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

public class CompletableFutures {
    public static void main(String[] args) {
        CompletableFuture<String> completableFuture1 = new CompletableFuture<>();
        CompletableFuture<Void> completableFuture2 ;
        CompletableFuture<String> completableFuture3 = new CompletableFuture<>();

        completableFuture1.complete("complete called...");
        completableFuture2 = CompletableFuture.runAsync(()->{
            System.out.println("Running runAsync");
        });
        completableFuture3 = CompletableFuture.supplyAsync(()->"supplyAsync ...");

        // Now using the executors
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        CompletableFuture<String> completableFuture4 = CompletableFuture.supplyAsync(()->Thread.currentThread().getName(),executorService);

        CompletableFuture<String> completableFuture5 = CompletableFuture.supplyAsync(()->"Shree").thenApply((a)->a+" Swami").thenApply((a)->a+ " Samartha");
        try {
            System.out.println("complete(): "+completableFuture1.get());
            System.out.println("runAsync(): "+completableFuture2.get());
            System.out.println("supplyAsync(): "+completableFuture3.get());
            System.out.println("supplyAsync() with executor service: "+completableFuture4.get());
            System.out.println("supplyAsync() with thenSupply(): "+completableFuture5.get());
            System.out.println("");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
