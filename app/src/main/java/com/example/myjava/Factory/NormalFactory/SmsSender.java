package com.example.myjava.Factory.NormalFactory;

public class SmsSender implements ISender{
    @Override
    public void sender() {
        System.out.println("sms sender");
    }
}
