package com.example.myjava.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;

public class Reflection {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        Class<?> aClass = Class.forName("com.example.myjava.reflect.Student");

        Class<?> superclass = aClass.getSuperclass();
        Object o1 = aClass.newInstance();

        Constructor<?> constructor = aClass.getConstructor();
        Object o = constructor.newInstance();
        Method hello = aClass.getDeclaredMethod("hello", String.class);
        hello.setAccessible(true);
        hello.invoke(o,"123");


        LinkedHashMap<String,String> linkedHashMap = new LinkedHashMap();

    }
}
