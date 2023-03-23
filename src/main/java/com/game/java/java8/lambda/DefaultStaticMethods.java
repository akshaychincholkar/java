package com.game.java.java8.lambda;

@FunctionalInterface
interface DefaultStaticMethodsInterface{
    public void m1();           //by default is abstract in interface
//    public void m2();         //can't have two abstract methods in functional interface
    public static void m2(){    // can have any number of static methods
        System.out.println("static method m2()");
    }
    public default void m3(){   // can have any number of default methods
        System.out.println("default method m3()");
    }
}
class childClass implements DefaultStaticMethodsInterface{
    @Override
    public void m1() {

    }
    public void m2(){

    }
    public void m3(){

    }
}
public class DefaultStaticMethods {
    public static void main(String[] args) {
        DefaultStaticMethodsInterface defaultStaticMethodsInterface = new DefaultStaticMethodsInterface() {
            @Override
            public void m1() {
                System.out.println("SAM: m1()");
            }
        };
        defaultStaticMethodsInterface.m1();
        DefaultStaticMethodsInterface.m2();
        defaultStaticMethodsInterface.m3();
    }
}
