package com.example.myjava.Factory.decorator;

/**
 * 接口的抽象装饰类
 */
public abstract class SharpDecorator implements Sharp {

    public final Sharp mDecoratorSharp;

    public SharpDecorator(Sharp decoratorSharp) {
        this.mDecoratorSharp = decoratorSharp;
    }

    @Override
    public void draw() {
        mDecoratorSharp.draw();
    }
}
