package com.game.java.threading;

import java.util.concurrent.CountDownLatch;

public class CountdownlatchDemo {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        Thread thread1 = new Thread(new latchDemo(1000,countDownLatch));
        Thread thread2 = new Thread(new latchDemo(2000,countDownLatch));
        Thread thread3 = new Thread(new latchDemo(3000,countDownLatch));
        Thread thread4 = new Thread(new latchDemo(4000,countDownLatch));

        System.out.println("Started the main()");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        countDownLatch.await();
        System.out.println("Completed the main()");
        Thread thread = new Thread(new latchDemo(6000,countDownLatch));
        thread.start();
        countDownLatch.await();
        System.out.println("Testing");
    }

}
class latchDemo implements Runnable{
    private int delay;
    private CountDownLatch latch;

    public latchDemo(int delay, CountDownLatch latch) {
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            latch.countDown();
            System.out.println(Thread.currentThread().getName()+" executed...");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}