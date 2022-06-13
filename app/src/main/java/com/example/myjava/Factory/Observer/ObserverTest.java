package com.example.myjava.Factory.Observer;

import com.example.myjava.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ObserverTest {

    public static void main(String[] args) {

        Subject subject = new Subject();
        BinaryObserver binaryObserver = new BinaryObserver(subject);
        OctalObserver octalObserver = new OctalObserver(subject);
        subject.setState(0);

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("112");

        String s = threadLocal.get();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService1 = Executors.newFixedThreadPool(4);
        ExecutorService executorService2 = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);

        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {

            }
        },1000, TimeUnit.SECONDS);

    }

    class Task implements Runnable {
        boolean flag = false;
        Object a = new Object();
        Object b = new Object();

        @Override
        public void run() {
            if (flag) {
                synchronized (a) {
                    //....
                    synchronized (b) {
                    }
                }
            } else {
                synchronized (b) {
                    //....
                    synchronized (a) {
                    }
                }
            }
        }
    }

    private void classT() throws ClassNotFoundException {
        Class<?> aClass = Class.forName("com.example.myjava.Factory.Observe.ObserveTest");
    }

}
