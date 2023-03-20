package com.game.java.threading;

import java.util.LinkedList;

class ProducerConsumerClass{
    LinkedList<Integer> list = new LinkedList<>();
    final int CAPACITY = 5;
    int value = 0;

    public void produce() throws InterruptedException {
        while(true){
            synchronized (this){
                while(list.size() == CAPACITY){
                    System.out.println("Capacity fulled!");
                    wait();
                }

                System.out.println("Producer produced: "+value);
                list.add(value++);

                notifyAll();

                Thread.sleep(1000);

            }
        }
    }
    public void consume() throws InterruptedException {
        while(true){
            synchronized (this){
                while(list.size() == 0) {
                    System.out.println("Consumer is hungry");
                    wait();
                }
                System.out.println("Consumer consumed: "+list.get(0));
                list.removeFirst();
                notifyAll();
                Thread.sleep(1000);
            }
        }
    }
}
public class ProducerConsumer {
    public static void main(String[] args) {
        ProducerConsumerClass producerConsumerClass = new ProducerConsumerClass();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumerClass.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    producerConsumerClass.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}
