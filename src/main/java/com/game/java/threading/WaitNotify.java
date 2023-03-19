package com.game.java.threading;

class WaitNotifyClass{
    volatile private boolean isEntry = false;
    synchronized public void m1(){
        System.out.println("Thread -1 started");
            System.out.println("Thread 1 is about to loose its control..");
            notify();

    }
    synchronized public void m2(){
            System.out.println("Thread 2 started and waiting...");
            try {
                while(!isEntry){
                    wait();
                    System.out.println("Thread 2 again got the control");
                    isEntry = true;/**/
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread 2 ended!");

    }
}
public class WaitNotify {
    public static void main(String[] args) {
        WaitNotifyClass waitNotifyClass = new WaitNotifyClass();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                waitNotifyClass.m1();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                waitNotifyClass.m2();
            }
        });

        thread2.start();
        thread1.start();
    }
}
