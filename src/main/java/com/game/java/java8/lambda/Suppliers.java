package com.game.java.java8.lambda;

import java.util.Date;
import java.util.function.Supplier;

public class Suppliers {
    public static void main(String[] args) {
        Supplier<Date> currentDateSupplier = ()->new Date();
        System.out.println("Current date: "+currentDateSupplier.get());

        //OTP generation
        Supplier<String> otpSupplier = ()->{
          String otp = "";
          for(int i=0;i<6;i++){
              int random = (int) (Math.random()*10);
              otp = otp + random;
          }
          return otp;
        };
        System.out.println("OTP generated: "+otpSupplier.get());
    }
}
