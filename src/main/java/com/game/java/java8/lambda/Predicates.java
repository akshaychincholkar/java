package com.game.java.java8.lambda;

import java.util.function.Predicate;

public class Predicates {
    public static void main(String[] args) {
        //Even numbers
        Predicate<Integer> even = n->n%2==0;
        System.out.println("Is 5 even number? "+even.test(5));
        System.out.println("Is 10 even number? "+even.test(10));

        Predicate<String> containsA = s-> s.contains("a");
        System.out.println("Does akshay contains a? "+containsA.test("ram"));
        System.out.println("Does bittu contains a? "+containsA.test("bittu"));

        Predicate<Integer> greaterThan10 = n->n>10;
        //methods of predicate
        System.out.println("Is number 30 even and string contains a? "+even.and(greaterThan10).test(30));
        System.out.println("Is number 21 even or greater than 10 "+even.or(greaterThan10).test(21));
        System.out.println("Is number 3 smaller than 10 and odd? "+even.negate().and(greaterThan10.negate()).test(3));
    }
}
