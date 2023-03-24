package com.game.java.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class DataTypesStreamCreationAndConversion {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(21);
        list.add(3);
        Stream<Integer> stream = list.stream();                 // created Integer stream
        Stream<Integer> stream2 = Stream.of(1,2,3,21);  // using .of()
        Stream<Integer> stream3 = Stream.of(new Integer[]{1,2,3});
                                                                // by passing Integer array

        List<String> listString = new ArrayList<>();
        listString.add("Ganesh");
        listString.add("Mahalakshmi");
        Stream<String> streamOfString = listString.stream();    // created String stream

    }
}
