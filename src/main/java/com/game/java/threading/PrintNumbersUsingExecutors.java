package com.game.java.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Printer{
    private int target;
    private int noOfThreads;
    int number = 1;

    public Printer(int target, int noOfThreads) {
        super();
        this.target = target;
        this.noOfThreads = noOfThreads;
    }
    public void print(int current){
        synchronized (this){
            while(number<target-1){
                while(number%noOfThreads!=current){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(number++);
                notifyAll();
            }
        }
    }
}
class Manager implements Runnable{
    Printer printer;
    int sequenceNumber;

    public Manager(Printer printer, int sequenceNumber) {
        super();
        this.printer = printer;
        this.sequenceNumber = sequenceNumber;
    }

    @Override
    public void run() {
        printer.print(sequenceNumber);
    }
}
public class PrintNumbersUsingExecutors {
    public static void main(String[] args) {
        int NUMBER_OF_THREADS = 3;
        int TARGET = 100;
        ExecutorService executorService = null;
        Printer printer =new Printer(TARGET,NUMBER_OF_THREADS);

            executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
            executorService.submit(new Manager(printer,1));
            executorService.submit(new Manager(printer,2));
            executorService.submit(new Manager(printer,0));


        if(executorService!=null)executorService.shutdown();

    }
}
/*
public class PrintNumbersUsingExecutors {

    private static final int TOTAL_NUMBER_IN_SEQUENCE = 20;
    private static final int TOTAL_NUMBER_OF_THREADS = 3;

    public static void main(String[] args) {

        NumbersGenerator numbersGenerator = new NumbersGenerator(TOTAL_NUMBER_OF_THREADS, TOTAL_NUMBER_IN_SEQUENCE);

        ExecutorService executorService = null;
        try {
            executorService = Executors.newFixedThreadPool(TOTAL_NUMBER_OF_THREADS);
            executorService.submit(new SequenceGeneratorTask(numbersGenerator, 1));
            executorService.submit(new SequenceGeneratorTask(numbersGenerator, 2));
            executorService.submit(new SequenceGeneratorTask(numbersGenerator, 0));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if(executorService != null)
                executorService.shutdown();
        }

    }
}
class SequenceGeneratorTask implements Runnable {

    private NumbersGenerator numbersGenerator;
    private int result;

    public SequenceGeneratorTask(NumbersGenerator numbersGenerator, int result) {
        super();
        this.numbersGenerator = numbersGenerator;
        this.result = result;
    }

    @Override
    public void run() {
        numbersGenerator.printNumbers(result);
    }

}
class NumbersGenerator {

    private int number = 1;
    private int numberOfThreads;
    private int totalNumbersInSequence;

    public NumbersGenerator(int numberOfThreads, int totalNumbersInSequence) {
        super();
        this.numberOfThreads = numberOfThreads;
        this.totalNumbersInSequence = totalNumbersInSequence;
    }

    public void printNumbers(int result) {
        synchronized (this) {
            while (number < totalNumbersInSequence-1) {
                while (number % numberOfThreads != result) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName()+" "+number++);
                notifyAll();
            }
        }
    }
}*/
