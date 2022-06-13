package com.example.myjava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;

public class MyTest {

    static final Object object = new Object();
    static boolean b = true;

    public static void main(String[] args) {

        String c= new String("123");
        System.out.println(c.getClass().getClassLoader());

        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();

        HashMap<String,String> hashMap = new HashMap<>();
        ConcurrentHashMap<String,String > concurrentHashMap = new ConcurrentHashMap<>();


        A a= new A();
        System.out.println(a.getClass().getClassLoader());;

        System.out.println("xxxxxx");
        if (b) {
            new Thread(new MyRunable1(object)).start();
            new Thread(new MyRunable(object)).start();
        } else {
            new Thread(new OutputThread(1, object), "threadName1").start();
            new Thread(new OutputThread(2, object), "threadName2").start();
        }
    }

    static class A{

        }

    static class MyRunable1 implements Runnable {

        public MyRunable1(Object o) {
        }

        @Override
        public void run() {
            System.out.println("call");
            synchronized (object) {
                System.out.println("thread sleep");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("notify");

                try {
                    object.notifyAll();
                    object.wait();// wait 会释放锁
                    object.notifyAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    static class MyRunable implements Runnable {

        public MyRunable(Object o) {
        }

        @Override
        public void run() {
            System.out.println("in runnable");

            synchronized (object) {
                try {
                    System.out.println("in wait");
                    Thread.sleep(2000);
                    object.notifyAll();
                    object.wait();
                    System.out.println("in wait end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("runnable i= ");
            }
        }

    }

    public static class OutputThread implements Runnable {
        private int num;
        private Object lock;

        public OutputThread(int num, Object lock) {
            super();
            this.num = num;
            this.lock = lock;
        }

        public void run() {
            try {
//                while(true){
                if (num == 1) {
                    Thread.sleep(2000);
                }

                System.out.println(Thread.currentThread().getName() + " synchronized before");
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + " notifyAll");
                    if (num == 2) {
                        Thread.sleep(4000);
                    }
//                    lock.notifyAll();
                    System.out.println(Thread.currentThread().getName() + " wait");
                    lock.wait();
                    System.out.println(num);
                }
//                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

}
