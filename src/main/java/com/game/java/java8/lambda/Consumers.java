package com.game.java.java8.lambda;

import java.util.function.Consumer;

class Movie{
    String name;
    Movie(String name){
        this.name = name;
    }
}
public class Consumers {
    public static void main(String[] args) {
        Movie movie = new Movie("Love Story 2021");
        Consumer<Movie> c1 = m-> System.out.println(m.name+" is releasing soon...");
        Consumer<Movie> c2 = m-> System.out.println(m.name+" is released !!");
        Consumer<Movie> c3 = m-> System.out.println(m.name+" is SUPERHIT!!");
        Consumer<Movie> cc=c1.andThen(c2).andThen(c3);

        cc.accept(movie);
    }
}
