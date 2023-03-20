package com.game.java.threading;
class EvenOddPrintClass{
    private int target;
    private int number= 0;
    EvenOddPrintClass(int target){
        this.target = target;
    }
    public void printEven() throws InterruptedException {
        synchronized (this){
            while(number<target){
                while(number%2!=0)wait();
                System.out.println(number);
                number++;
                notifyAll();
                Thread.sleep(100);
            }
        }
    }
    public void printOdd() throws InterruptedException {
        synchronized (this){
            while(number<target){
                while(number%2 == 0) wait();
                System.out.println(number);
                number++;
                notifyAll();
                Thread.sleep(100);
            }
        }
    }
}
public class EvenOddPrint {
    public static void main(String[] args) {
        EvenOddPrintClass evenOddPrintClass = new EvenOddPrintClass(100);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    evenOddPrintClass.printEven();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    evenOddPrintClass.printOdd();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
