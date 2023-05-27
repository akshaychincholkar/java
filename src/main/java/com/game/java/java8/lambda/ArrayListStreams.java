package com.game.java.java8.lambda;

import java.util.*;
import java.util.Comparator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ArrayListStreams {
    public static void main(String[] args) {
        var arrayList = List.of(1,2,3);
        arrayList.forEach(x-> {
            x = x + 10;
            System.out.println(x);
        });

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

        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"Akshay",99));
        students.add(new Student(2,"Bittu",91));
        students.add(new Student(3,"Manu",89));
        students.add(new Student(4,"Chetan",98));
        students.add(new Student(4,"Akshay",100));

        List<Integer> marks = students.stream().map(s->s.marks).sorted().collect(Collectors.toList());
        System.out.println("Sorted marks: "+marks);

        Map<String,Integer> lambda = new HashMap<>();
        lambda.put("Akshay",98);
        lambda.put("Bittu",84);
        lambda.put("Manu",91);
        lambda.put("Akshay",45);
        lambda.put("Chetan",78);

        List<Integer> marks2 = lambda.values().stream().filter(v->v>50).collect(Collectors.toList());
        System.out.println("Map to list (marks more than 50): "+marks2);

        Map<Student,Integer> mapConversion = students.stream().collect(Collectors.toMap(student -> student,student -> student.marks,(old,newValue)->newValue));
        System.out.println("List of student converted to map: "+mapConversion);

        Map<Student,Integer> concurrentHashMap = students.stream().collect(Collectors.toMap(student -> student,student -> student.marks,(old,newValue)->newValue,ConcurrentHashMap<Student,Integer>::new));
        System.out.println("List of student converted to concurrent map: "+concurrentHashMap);

        Map<Student,Integer> linkedHashMap = students.stream().collect(Collectors.toMap(student -> student,student -> student.marks,(old,newValue)->newValue, LinkedHashMap<Student,Integer>::new));
        System.out.println("List of student converted to concurrent map: "+concurrentHashMap);

        Map<Student,Integer> treeMap = students.stream().collect(Collectors.toMap(student -> student,student -> student.marks,(old,newValue)->newValue,TreeMap<Student,Integer>::new));
        System.out.println("List of student converted to concurrent map: "+concurrentHashMap);
    }
}
class Student implements Comparator<Student> {
    int id;
    String name;
    int marks;

    public Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    @Override
    public int compare(Student s1,Student s2) {
        return s1.name.compareTo(s2.name);
    }

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(((Student)obj).name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }

    @Override
    public String toString() {
        return "\nStudent{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }
}