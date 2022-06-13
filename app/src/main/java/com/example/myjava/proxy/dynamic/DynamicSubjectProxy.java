package com.example.myjava.proxy.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicSubjectProxy implements InvocationHandler {

    private Object mDynaSubject;

    public DynamicSubjectProxy(Object subject){
        mDynaSubject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("DynamicSubjectProxy invoke begin ");
        Object invoke = method.invoke(mDynaSubject, args);
        System.out.println("DynamicSubjectProxy invoke end");
        return invoke;
    }


    public Object getProxyInstance(){
        return Proxy.newProxyInstance(mDynaSubject.getClass().getClassLoader(),
                mDynaSubject.getClass().getInterfaces(),this);
    }

}
