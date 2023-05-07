package com.game.java.threading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BigFileReader {
 /*   public static void main(String[] args) {
        Map<String,Integer> map = new ConcurrentHashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/game/java/threading/file.txt"))) {
            String line;
            ExecutorService pool = Executors.newFixedThreadPool(10);
            while ((line = br.readLine()) != null) {
                pool.execute(getRunnable(line,map));
            }
            pool.shutdown();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BigFileReader.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BigFileReader.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            System.out.println("Completed the finally..");
        }
        System.out.println("Completed entire program..."+map.size());
    }


    private static Runnable getRunnable(String run, Map<String, Integer> map){
        Runnable task = () -> {
            String[] words = run.split(" ");
            for(String word:words){
                if(word!=null){
                    if(word.toLowerCase()!=null && map.containsKey(word.toLowerCase())) {
                        map.getOrDefault(word.toLowerCase(),map.get(word.toLowerCase())+1);
                    }
                    else map.put(word,1);
                }
            }
            System.out.println(run);
        };
        return task;
    }*/
/* public static void main(String[] args) throws ExecutionException, InterruptedException {
     ExecutorService executorService = Executors.newFixedThreadPool(5);
     Map<String,Integer> map = new ConcurrentHashMap<>();
     Future<Map<String,Integer>> completableFuture = (Future<Map<String, Integer>>) executorService.submit(()->{
         try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/game/java/threading/file.txt"))) {
             String line;
             while ((line = br.readLine()) != null) {
                 System.out.println(Thread.currentThread().getName()+" "+line);
                 String[] words = line.split(" ");
                 for(String word:words){
                     word = word.toLowerCase();
                     if(word!=null){
                         if(word!=null && map.containsKey(word)) {
                             map.put(word,map.get(word)+1);
                         }
                         else map.put(word,1);
                     }
                 }
             }
//             System.out.println("Map: "+map);
             return map;
         } catch (
                 FileNotFoundException e) {
             throw new RuntimeException(e);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }

     });

     executorService.shutdown();
     System.out.println(completableFuture.get());
 }*/
/* public static void main(String[] args) throws ExecutionException, InterruptedException {
     CompletableFuture<Map<String,Integer>> completableFuture = CompletableFuture.supplyAsync(()->{
         try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/com/game/java/threading/file.txt"))) {
             String line;
             Map<String,Integer> map = new ConcurrentHashMap<>();
             while ((line = br.readLine()) != null) {
                 System.out.println(Thread.currentThread().getName()+" "+line);
                 String[] words = line.split(" ");
                 for(String word:words){
                     word = word.toLowerCase();
                     if(word!=null){
                         if(word!=null && map.containsKey(word)) {
                             map.put(word,map.get(word)+1);
                         }
                         else map.put(word,1);
                     }
                 }
             }
//             System.out.println("Map: "+map);
             return map;
         } catch (
                 FileNotFoundException e) {
             throw new RuntimeException(e);
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
     });
     System.out.println(completableFuture.get());
 }*/
 static class Printer{
     private int target;
     private int noOfThreads;
     private Map<String,Integer> map ;
     private BufferedReader br;
     int number = 1;

     public Printer(int target, int noOfThreads) {
         super();
         this.target = target;
         this.noOfThreads = noOfThreads;
         try {
             br = new BufferedReader(new FileReader("src/main/java/com/game/java/threading/file.txt"));
         } catch (FileNotFoundException e) {
             throw new RuntimeException(e);
         }
         map = new ConcurrentHashMap<>();
     }
     public Map<String,Integer> print(int current) throws IOException {
//         synchronized (this){
             String line;
             while ((line = br.readLine()) != null) {
                 System.out.println(Thread.currentThread().getName()+" "+line);
                 String[] words = line.split(" ");
                 for(String word:words){
                     word = word.toLowerCase();
                     if(word!=null){
                         if(word!=null && map.containsKey(word)) {
                             map.put(word,map.get(word)+1);
                         }
                         else map.put(word,1);
                     }
                 }
             }
             return map;
//         }
     }
     public void printFrequency(){
         System.out.println(map);
     }
 }
    static class Manager implements Callable{
        Printer printer;
        int sequenceNumber;

        public Manager(Printer printer, int sequenceNumber) {
            super();
            this.printer = printer;
            this.sequenceNumber = sequenceNumber;
        }

        @Override
        public Map<String,Integer> call() {
            try {
                return printer.print(sequenceNumber);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
//    public class PrintNumbersUsingExecutors {
        public static void main(String[] args) throws ExecutionException, InterruptedException {
            int NUMBER_OF_THREADS = 3;
            int TARGET = 100;
            ExecutorService executorService = null;
            Printer printer =new Printer(TARGET,NUMBER_OF_THREADS);

            executorService = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
            Future<Map<String,Integer>> future = executorService.submit(new Manager(printer,1));
            Future<Map<String,Integer>> future1 =executorService.submit(new Manager(printer,2));
            Future<Map<String,Integer>> future2 =executorService.submit(new Manager(printer,0));


            executorService.shutdown();
            printer.printFrequency();
            System.out.println(""+future.get()+"\nfuture 2: "+future1.get()+" \nfuture 3: "+future2.get());
        }
}
