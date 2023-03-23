package com.game.java.java8.lambda;

import java.util.Arrays;
@FunctionalInterface
interface Sum{
public int calculate(int a,int b);
}
public class StringSort {
    public static void main(String[] args) {
        String[] array = {"mn","pq","ab","pl","xy","gh"};
        Arrays.sort(array,(a,b)->a.compareTo(b));
        for(String s:array) System.out.println("\t"+s);

        Sum sum1 = new Sum() {
            @Override
            public int calculate(int a, int b) {
                return a+b;
            }
        };
        System.out.println("Addition of 3 & 4 using lambda is "+sum1.calculate(3,4));

        Sum sum2 = (a,b) -> a+b;
        System.out.println("Addition using lambda expression of 3 & 4 is "+sum2.calculate(3,4));
    }
}
