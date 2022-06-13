package com.example.myjava.proxy.dynamic;

public class DynamicRealSubject implements IDynaSubject {
    @Override
    public void dynaSayHello() {
        System.out.println("DynamicRealSubject dynaSayHello");
    }

    @Override
    public void dynaSayGoodBye() {
        System.out.println("DynamicRealSubject dynaSayGoodBye");
    }
}
