package com.game.java.java8.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

class EmployeeFunction{
    int id;
    String name;

    public EmployeeFunction(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Id: "+id+" name: "+name;
    }
}
public class Functions {
    public static void main(String[] args) {
        BiFunction<Integer,String,EmployeeFunction> f = (id,name)->new EmployeeFunction(id,name);
        List<EmployeeFunction> list = new ArrayList<>();
        list.add(f.apply(1,"Akshay"));
        list.add(f.apply(2,"Darshana"));
        list.add(f.apply(3,"Chetan"));

        list.forEach(System.out::println);

    }
}
