package com.game.java.threading;

class JoinRunnable implements Runnable{
    @Override
    public void run() {
        for(int i=1;i<=10;i++){
            System.out.println(+i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class JoinThreads {
    public static void main(String[] args) throws InterruptedException {
        JoinRunnable joinRunnable = new JoinRunnable();
        Thread thread1 = new Thread(joinRunnable);
        Thread thread2 = new Thread(joinRunnable);

        System.out.println("Threads execution started ...");
        thread1.start();
        thread1.join();
        thread2.start();
        thread2.join();

        System.out.println("Threads execution completed...");
    }
}
