package com.example.myjava.Factory.decorator;

/**
 *圆形实现类
 */
public class Circle implements Sharp {
    @Override
    public void draw() {
        System.out.println("circle draw");
    }
}
