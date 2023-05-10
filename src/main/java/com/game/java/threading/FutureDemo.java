package com.game.java.threading;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureDemo {
    public static void main(String[] args) throws InterruptedException {
        Future future = Executors.newSingleThreadExecutor().submit(()->{
            System.out.println(Thread.currentThread().getName()+" is running ");
            for(int i = 0 ;i<10;i++){

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
//                System.out.print(i+"  ");

            }
        });
        while(!future.isDone()){
            System.out.println("Thread is still running..");
            Thread.sleep(1000);
        }
        System.out.println("Completed execution!");
    }
}
