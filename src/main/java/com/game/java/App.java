package com.game.java;

import java.util.ArrayList;
import java.util.List;

class ProducerConsumer{
    List<Integer> list = new ArrayList<>();
    int capacity;
    int value =0;

    ProducerConsumer(int capacity){
        this.capacity = capacity;
    }
    public void produce() throws InterruptedException {
        while(true){
            synchronized (this){
                while(list.size()==capacity) {
                    System.out.println("Capacity exceeded!!!");
                    wait();
                }
                System.out.println(Thread.currentThread().getName()+" added value:"+value);
                list.add(value++);
                notifyAll();
                Thread.sleep(1000);
            }
        }
    }
    public void consume() throws InterruptedException {
        while(true){
            synchronized (this){
                while(list.size()==0){
                    System.out.println("List is empty... Wait for some time!");
                    wait();
                }
                System.out.println(Thread.currentThread().getName()+" consuming value "+list.get(0));
                list.remove(0);
                notifyAll();
                Thread.sleep(1000);
            }
        }
    }
}

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        ProducerConsumer producerConsumer = new ProducerConsumer(2);
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumer.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();

    }
}
