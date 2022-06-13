package com.example.myjava.proxy.girl;

public class MissWu implements IGirl{
    @Override
    public void watchMovie() {
        System.out.println("missWu watch Movie");
    }

    @Override
    public void getWeight(String type) {
        System.out.println("missWu getWeight ");
    }
}
