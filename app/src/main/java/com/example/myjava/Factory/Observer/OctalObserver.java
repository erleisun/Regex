package com.example.myjava.Factory.Observer;

/**
 * 八进制
 */
public class OctalObserver extends Observer{

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attachObserver(this);
    }

    @Override
    void update() {
        System.out.println("update");
    }
}
