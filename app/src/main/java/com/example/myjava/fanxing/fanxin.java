package com.example.myjava.fanxing;

import android.util.ArrayMap;
import android.util.SparseArray;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class fanxin {

    public static void main(String[] args) {

        Person<String> person = new Person<>();
        person.setWeight("123");
        ArrayList<String> a;
        Thread b = null;
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
    }

    Thread t;

    private void startThread() {

        t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (!t.isInterrupted()) {
                        System.out.println("running");
                        Thread.sleep(100);
                    }

                } catch (InterruptedException e) {
                    t.interrupt();
                }
            }
        });
        t.start();

        t.interrupt();

    }

    private void countDownLatch() {
        CountDownLatch downLatch = new CountDownLatch(0);
        CountDownLatch downLatch1 = new CountDownLatch(1);
        CountDownLatch downLatch2 = new CountDownLatch(2);
        try {
            downLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void reentrantLockTest() {
        ReentrantLock reentrantLock = new ReentrantLock();
        System.out.println("lock");
        reentrantLock.lock();
        try {
            //可重入锁，拿锁最多等等100ms
            if (reentrantLock.tryLock(100, TimeUnit.MILLISECONDS)) {
                System.out.println("get lock");
            }
        } catch (Exception e) {

        } finally {
            reentrantLock.unlock();
        }

        System.out.println("unlock");

    }

    private void threadPoolTest() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10), Executors.defaultThreadFactory());

        threadPoolExecutor.shutdown();

        SparseArray<String> sparseArray = new SparseArray<>();
        sparseArray.put(0, "00");

        ArrayMap<String ,String > map = new ArrayMap<>();

        HashMap<String,String> hashMap;
    }
}
