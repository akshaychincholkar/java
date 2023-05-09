package com.game.java;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        StaticMethodCall.m1();
        StaticMethodCall obj = new StaticMethodCall();
        StaticMethodCall obj2 = null;
        obj2.m1();
        obj.m1();
    }
}
class StaticMethodCall{
    public static void m1(){
        System.out.println("static method m1() is called");
    }
}
