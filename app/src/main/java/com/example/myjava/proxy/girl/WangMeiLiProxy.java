package com.example.myjava.proxy.girl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class WangMeiLiProxy implements InvocationHandler {

    private IGirl mGirl;

    public WangMeiLiProxy(IGirl girl) {
        mGirl = girl;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        doSomeThingBefore();
        Object object = method.invoke(mGirl, args);
        doSomeThingAfter();

        return object;
    }

    private void doSomeThingBefore() {
        System.out.println("mGirl doSomeThingBefore");
    }

    private void doSomeThingAfter() {
        System.out.println("mGirl doSomeThingAfter");
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(mGirl.getClass().getClassLoader(),
                mGirl.getClass().getInterfaces(), this);
    }

}
