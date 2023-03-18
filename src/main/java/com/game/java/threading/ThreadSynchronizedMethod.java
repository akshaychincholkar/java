package com.game.java.threading;

public class ThreadSynchronizedMethod {
    public static int counter = 0;
    public static synchronized void increment(){
        counter++;
    }
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++)increment();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<100;i++)counter++;
            }
        });
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("Value of counter: "+counter);
    }
}
