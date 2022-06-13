package com.example.myjava;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Hashtable;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyTest1 {

    static final Object object = new Object();
    static boolean b = true;

    public static void main(String[] args) {

        //替代 object的 wait  notify
        Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();

        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(1, 3, 6 * 1000, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(10));

        new Thread() {

        }.start();


        try {
            lock.tryLock(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Hashtable<String, String> hashtable = new Hashtable<>();
        //使用分段锁
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();


        reflection();
    }

    private static void reflection() {
        System.out.println("classLoader = " + Student.class.getClassLoader());

        try {
            Class<?> aClass = Class.forName("com.example.myjava.Student");
            System.out.println(aClass.toString());


            Object o = aClass.getConstructor(new Class[]{}).newInstance();

            Field name = aClass.getField("name");
            System.out.println("name = " +  name.get(o));

            Field age = aClass.getDeclaredField("age");
            age.setAccessible(true);
            System.out.println("age = " + age.get(o));

            Method getName = aClass.getDeclaredMethod("getName");
            getName.setAccessible(true);

            System.out.println("name1 = " + getName.invoke(o));

            Method setName = aClass.getDeclaredMethod("setName", String.class);
            setName.setAccessible(true);
            setName.invoke(o,"mary");

            System.out.println("name2 = " + getName.invoke(o));


        } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
