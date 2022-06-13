package com.example.myjava.Factory.Observer;

import java.util.ArrayList;

/**
 * subject类，统筹管理
 */
public class Subject {
    //多个对象监听此参数
    private int state;
    private ArrayList<Observer> observers = new ArrayList<>();

    public void attachObserver(Observer observer) {
        observers.add(observer);
    }

    public void setState(int ste) {
        state = ste;
        for (Observer ob : observers) {
            ob.update();
        }
    }

}
