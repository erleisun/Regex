package com.example.myjava.proxy.staticProxy;

public class RealSubject implements ISubject {
    @Override
    public void sayHello() {
        System.out.println("realSubject sayHello");
    }

    @Override
    public void sayGoodBye() {
        System.out.println("realSubject sayGoodBye");
    }
}
