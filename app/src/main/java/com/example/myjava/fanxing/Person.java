package com.example.myjava.fanxing;


import com.example.myjava.Student;

import java.util.HashMap;

public class Person<T> {

    private String name;
    private int age;
    private T weight;

    private StringBuilder builder;
    private StringBuffer stringBuffer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(T t) {
        weight = t;
    }

    public void show(Person<T> t){
        setName(t.getName());
    }

    public void show1(Person<?> t){
        setName(t.getName());
    }

    public void show2(Person<? extends Student> t){
    }
}
