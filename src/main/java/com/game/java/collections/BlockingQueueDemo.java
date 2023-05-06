package com.game.java.collections;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class BlockingQueueDemo {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue< String > alph
                = new LinkedBlockingDeque< String >(5 ) ;
        // adding the elements to the BlockingQueue using add( ) method
        alph.add( " A " ) ;
        alph.add( " B " ) ;
        alph.add( " C " ) ;
        alph.add( " D " ) ;
        alph.add( " E " ) ;
        // printing the elements of the blocking queue
        System.out.println(
                " The content of LinkedBlockingDeque is : " ) ;
        System.out.println( alph ) ;
        // removing the elements from the queue using the remove( ) function
        alph.remove( " C " ) ;
        alph.remove( " E " ) ;
        // let us see what will happen if we try to remove an element that actually does not exist in the queue
        alph.remove( " Y " ) ;
        // Print the elements of the alph object of BlockingQueue
        System.out.println(
                " The content of the LinkedBlockingDeque after removing elements is : " ) ;
        System.out.println( alph ) ;
        alph.put("Y");
        alph.put("Z");
        System.out.println(alph);
        alph.remove("Y");
        alph.put("X");
        System.out.println(alph);
    }
}
