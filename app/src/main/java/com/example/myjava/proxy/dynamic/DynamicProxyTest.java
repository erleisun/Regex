package com.example.myjava.proxy.dynamic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DynamicProxyTest {

    public static void main(String[] args) {

        IDynaSubject subject = new DynamicRealSubject();
        DynamicSubjectProxy proxy = new DynamicSubjectProxy(subject);
        IDynaSubject proxyInstance = (IDynaSubject)proxy.getProxyInstance();
        proxyInstance.dynaSayGoodBye();
        proxyInstance.dynaSayHello();


    }


    ReentrantLock lock = new ReentrantLock();

    public void add(){
        lock.lock();
        Condition condition = lock.newCondition();
//        condition.signal();
//        condition.signalAll();
//        condition.await();
//        condition.await(10, TimeUnit.SECONDS);

        try {
//            num++;
        }catch (Exception e){
            lock.unlock();
        }

        AtomicInteger atomicInteger = new AtomicInteger(0);
        atomicInteger.incrementAndGet();

    }


    private void consumer() throws InterruptedException {

    }



}