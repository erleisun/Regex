package com.example.javalib;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyClass {

    private static Lock lock = new ReentrantLock();
    private static Condition conditionA = lock.newCondition();
    private static Condition conditionB = lock.newCondition();
    private static Condition conditionC = lock.newCondition();

    private static volatile int flag = 1;

    public static void main(String[] args) {
//        conditionB.await();
        System.out.print("MyClass Main\n");
        MyThreadA threadA = new MyThreadA("threadA");
        MyThreadB threadB = new MyThreadB("threadB");
        MyThreadC threadC = new MyThreadC("threadC");
        Thread thread1 = new Thread(new MyRunnable());
        thread1.start();

        Thread thread2 = new Thread(new MyRunnable());
        thread2.start();


        try {
//            threadA.start();
//            threadA.join();

//            threadB.start();
//            threadB.join();

//            threadC.start();
//            threadC.join();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class MyThreadA extends Thread {
        String threadName;

        public MyThreadA(String name) {
            super(name);
            threadName = name;
        }

        @Override
        public void run() {
            super.run();
            lock.lock();
            System.out.print("flag:" + flag + "\n");
            try {
                if (flag != 1) {
                    conditionA.await();
                }
//                threadName = Thread.currentThread().getName();
                System.out.print("MyClass Main:" + threadName + "\n");
                if (flag == 1) {
                    conditionB.signal();
                }
                flag = 2;
            } catch (Exception e) {
                e.printStackTrace();
            }
            lock.unlock();
        }
    }

    private static class MyThreadB extends Thread {
        String threadName;

        public MyThreadB(String name) {
            super(name);
            threadName = name;
        }

        @Override
        public void run() {
            super.run();
            lock.lock();
            System.out.print("flag:" + flag + "\n");
            try {
                if (flag != 2) {
                    conditionB.await();
                }
                System.out.print("MyClass Main:" + threadName + "\n");
                if (flag == 2) {
                    conditionC.signal();
                }
                flag = 3;
            } catch (Exception e) {
                e.printStackTrace();
            }
            lock.unlock();
        }
    }

    private static class MyThreadC extends Thread {
        String threadName;

        public MyThreadC(String name) {
            super(name);
            threadName = name;
        }

        @Override
        public void run() {
            super.run();
            lock.lock();
            System.out.print("flag:" + flag + "\n");
            try {
                if (flag != 3) {
                    conditionC.await();
                }
                System.out.print("MyClass Main:" + threadName + "\n");
                if (flag == 3) {
                    conditionA.signal();
                }
                flag = 1;
            } catch (Exception e) {
                e.printStackTrace();
            }
            lock.unlock();
        }
    }

    static ReentrantLock reentrantLock = new ReentrantLock();
    static class MyRunnable implements Runnable {
        static int a = 0;
        @Override
        public void run() {
//            conditionA.
//            reentrantLock.lock();
            lock.lock();
            try{
                for (int i = 0; i < 10; i++) {
                    a = a + 1;
                    Thread.sleep(200);
                    System.out.print(" a = " + a);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
//                reentrantLock.unlock();
                lock.unlock();
            }
        }
    }

}
