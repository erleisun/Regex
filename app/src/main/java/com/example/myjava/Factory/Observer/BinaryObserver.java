package com.example.myjava.Factory.Observer;

/**
 * 实体观察者类
 */
public class BinaryObserver extends Observer {

    public BinaryObserver(Subject subject) {
        this.subject = subject;
        subject.attachObserver(this);
    }

    @Override
    void update() {
        System.out.println("BinaryObserver update");
    }
}
