package com.example.myjava.Factory.decorator;

/**
 * 扩展Sharp装饰类
 */
public class RedSharpDecorator extends SharpDecorator {

    public RedSharpDecorator(Sharp sharp) {
        super(sharp);
    }

    @Override
    public void draw() {
        mDecoratorSharp.draw();
        setRedBorder();
    }

    /**
     * 扩展方法
     */
    private void setRedBorder() {
        System.out.println("setRedBorder");
    }
}
