package com.game.java.java8.lambda;

import java.util.ArrayList;
import java.util.List;

public class ArrayListStreams {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("akshay");
        list.add("darshana");
        list.add("manu");
        list.add("subhash");
        list.add("nita");
        list.add("akshita");
        list.add("ashish");
        list.add("kavita");
        list.add("rucha");

        System.out.println("1. Names starting with 'a':");
        list.stream().filter((s)->s.startsWith("a")).forEach(System.out::println);

        System.out.println("2. Names starting with 'a' in upper case:");
        list.stream().filter(s->s.startsWith("a")).map(s->s.toUpperCase()).forEach(System.out::println);

        System.out.println("3. Names NOT starting with 'a' in a sorted manner in upper case: ");
        list.stream().filter(s->!s.startsWith("a")).sorted().map(s->s.toUpperCase()).forEach(System.out::println);

        System.out.println("4. Names in a descending order");
        list.stream().sorted((a,b)->b.compareTo(a)).forEach(System.out::println);

        System.out.println("5. Is any name starts with m?: "+list.stream().anyMatch(s->s.startsWith("m")));
        System.out.println("6. Are all names starts with a?: "+list.stream().allMatch(s->s.startsWith("a")));
        System.out.println("7. Check whether none of names starts with b? "+list.stream().noneMatch(s->s.startsWith("b")));
        System.out.println("8. Count of names starts with a: "+list.stream().filter(s->s.startsWith("a")).count());

    }
}
