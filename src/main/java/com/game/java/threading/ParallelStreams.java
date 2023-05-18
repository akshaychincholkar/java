package com.game.java.threading;

import java.util.stream.LongStream;

public class ParallelStreams {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        long sum = sum(2000000000);
        System.out.println("Sum: "+sum+" & time taken (sequential sum): "+(System.currentTimeMillis()-startTime));

        startTime = System.currentTimeMillis();
        long psum = paralleSum(2000000000);
        System.out.println("Sum: "+psum+" & time taken (sequential sum): "+(System.currentTimeMillis()-startTime));

    }
    public static long sum(long n){
        return  LongStream.rangeClosed(1,n).reduce(0L,Long::sum);
    }
    public static long paralleSum(int n){
        return LongStream.rangeClosed(1,n).parallel().reduce(0L,Long::sum);
    }
}
