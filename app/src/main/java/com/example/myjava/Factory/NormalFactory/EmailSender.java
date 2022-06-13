package com.example.myjava.Factory.NormalFactory;

public class EmailSender implements ISender {
    @Override
    public void sender() {
        System.out.println("sms sender");
    }
}
