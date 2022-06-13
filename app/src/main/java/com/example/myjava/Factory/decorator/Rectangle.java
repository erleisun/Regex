package com.example.myjava.Factory.decorator;

/**
 * sharp的实现类 rectangle 矩形
 */
public class Rectangle implements Sharp {
    @Override
    public void draw() {
        System.out.println("rectangle draw");
    }
}
