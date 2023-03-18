package com.game.java.threading;
class PriorityRunnable implements Runnable{

    @Override
    public void run() {
        for(int i=1;i<=10;i++){
            System.out.println(i);
        }
    }
}
public class ThreadPriority {
    public static void main(String[] args) {
        System.out.println("Started thread...");
        PriorityRunnable priorityRunnable = new PriorityRunnable();
        Thread thread1 = new Thread(priorityRunnable);
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        System.out.println("Program ending...");
    }
}
