package com.game.java.threading;

import java.util.stream.LongStream;

public class PrimeNumbersWithParallelStreams {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long count = LongStream.rangeClosed(1,Integer.MAX_VALUE/100).filter(PrimeNumbersWithParallelStreams::isPrime).count();
        System.out.println(count+" is the count (sequential) with total time "+(System.currentTimeMillis()-start));

        start = System.currentTimeMillis();
        count = LongStream.rangeClosed(1,Integer.MAX_VALUE/100).parallel().filter(PrimeNumbersWithParallelStreams::isPrime).count();
        System.out.println(count+" is the count (parallel) with total time "+(System.currentTimeMillis()-start));
    }
    public static boolean isPrime(long num){
        if(num <= 1) return false;
        if(num == 2) return true;
        if(num%2 == 0) return false;

        // get the max divisor
        long maxDivisor = (long)Math.sqrt(num);
        for(int i = 3;i<=maxDivisor ; i+=2){
            if(num%i==0) return false;
        }
        return true;
    }
}
