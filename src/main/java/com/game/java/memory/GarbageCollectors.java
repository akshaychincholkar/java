package com.game.java.memory;

public class GarbageCollectors {
    public void finalize(){
        System.out.println("Object is garbage collected..");
    }
    public static void main(String[] args) {
        GarbageCollectors g1= new GarbageCollectors();
        GarbageCollectors g2= new GarbageCollectors();

        g1=null;
        g2 = null;
        System.gc();
    }
}
