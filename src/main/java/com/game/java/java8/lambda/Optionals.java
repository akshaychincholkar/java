package com.game.java.java8.lambda;

import java.util.Optional;

public class Optionals {
    public static void main(String[] args) {
//        String s = "This is the intitialized string";
        String s = null;
        Optional<String> stringOptional = Optional.ofNullable(s);
        System.out.println("Whether string is present or not :" + stringOptional.isPresent());
        System.out.println("String is null or initialized?:" + stringOptional.orElse("The string is null"));
        System.out.println("String is empty?:" + stringOptional.isEmpty());

//        String[] words = {"test","waste","rest"};
        String[] words = new String[10];
        Optional<String> checkNulls = Optional.ofNullable(words[1]);
        System.out.println("is present: " + checkNulls.isPresent());
    }
}
