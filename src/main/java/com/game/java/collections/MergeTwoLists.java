package com.game.java.collections;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoLists {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        list1.add(4);
        list1.add(15);
        System.out.println(list1);
        list1.addAll(list);
        System.out.println(list1);
        list1.remove(Integer.valueOf(15));
        System.out.println(list1);
    }
}
