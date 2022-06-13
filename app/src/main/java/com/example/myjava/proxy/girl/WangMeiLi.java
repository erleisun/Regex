package com.example.myjava.proxy.girl;

public class WangMeiLi implements IGirl {
    @Override
    public void watchMovie() {
        System.out.println("WangMeiLi watchMovie");
    }

    @Override
    public void getWeight(String type) {
        System.out.println("WangMeiLi getWeight " + type);
    }
}
