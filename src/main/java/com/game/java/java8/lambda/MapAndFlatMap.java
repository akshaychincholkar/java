package com.game.java.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    String email;
    List<String> phonenumbers;

    public Employee(int id, String name, String email, List<String> phonenumbers) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phonenumbers = phonenumbers;
    }
}

public class MapAndFlatMap {
    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1, "Akshay", "akshaychincholkar@gmail.com", new ArrayList<String>(Arrays.asList("2124234", "23242"))));
        list.add(new Employee(2, "Bittu", "b@gmail.com", new ArrayList<String>(Arrays.asList("123", "232343242"))));
        list.add(new Employee(3, "Manu", "c@gmail.com", new ArrayList<String>(Arrays.asList("5345", "34"))));

        System.out.println("Email ids: " + list.stream().map(employee -> employee.email).collect(Collectors.toList()));
        System.out.println("Phone numbers: " + list.stream().map(employee -> employee.phonenumbers).collect(Collectors.toList()));
        System.out.println("Flattened numbers: " + list.stream().flatMap(employee -> employee.phonenumbers.stream()).collect(Collectors.toList()));

    }
}
