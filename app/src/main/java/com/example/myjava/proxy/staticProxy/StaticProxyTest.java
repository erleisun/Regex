package com.example.myjava.proxy.staticProxy;


public class StaticProxyTest {
    public static void main(String[] args) {

        RealSubject realSubject = new RealSubject();
        ProxySubject test = new ProxySubject(realSubject);
        test.sayGoodBye();
        test.sayHello();

    }

}
