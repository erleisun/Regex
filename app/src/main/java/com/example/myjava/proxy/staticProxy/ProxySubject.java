package com.example.myjava.proxy.staticProxy;

public class ProxySubject implements ISubject{

    private ISubject mSubject;

    ProxySubject(ISubject subject){
        mSubject = subject;
    }

    @Override
    public void sayHello() {
        //功能增强
        System.out.println("begin sayHello");
        mSubject.sayHello();
        System.out.println("end sayHello");
    }

    @Override
    public void sayGoodBye() {
        mSubject.sayGoodBye();
    }
}
