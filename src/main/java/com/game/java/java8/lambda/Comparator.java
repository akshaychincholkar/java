package com.game.java.java8.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Product{
    int id;
    String name;
    int price;
    Product(int id,String name,int price){
        super();
        this.id = id;
        this.name= name;
        this.price = price;
    }
}
public class Comparator {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();
        list.add(new Product(1,"Headphones",2000));
        list.add(new Product(2,"Apple Macbook",150000));
        list.add(new Product(3,"Zebronics keyboard",4000));

        Collections.sort(list,(p1,p2)->{
            return p1.name.compareTo(p2.name);
        });
        list.forEach((n)-> System.out.println("\t"+n.name));
    }
}
