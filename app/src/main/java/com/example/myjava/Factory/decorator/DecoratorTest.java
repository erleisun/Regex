package com.example.myjava.Factory.decorator;

public class DecoratorTest {

    public static void main(String[] args) {

        Circle circle = new Circle();
        RedSharpDecorator redSharpDecorator = new RedSharpDecorator(circle);
        redSharpDecorator.draw();

    }
}
