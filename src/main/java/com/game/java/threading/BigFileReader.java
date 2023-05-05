package com.game.java.threading;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BigFileReader {
    public static void main(String[] args) {
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
                        map.put(word.toLowerCase(),map.get(word.toLowerCase())+1);
                    }
                    else map.put(word,1);
                }
            }
            System.out.println(run);
        };
        return task;
    }
}
