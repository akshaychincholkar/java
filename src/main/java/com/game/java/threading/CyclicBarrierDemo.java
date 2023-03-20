package com.game.java.threading;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class CyclicBarrierClass implements Runnable{
    CyclicBarrier barrier;
    CyclicBarrierClass(CyclicBarrier barrier){
        this.barrier = barrier;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            System.out.println("Thread "+Thread.currentThread().getName()+" started .. ");
            if(barrier.await()==0){
                System.out.println("Awaiting for thread to finish task");
            }
            System.out.println("Thread "+Thread.currentThread().getName()+" completed");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}
public class CyclicBarrierDemo {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(2);
        CyclicBarrierClass runnable = new CyclicBarrierClass(barrier);
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

