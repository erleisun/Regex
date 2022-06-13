package com.example.myjava.Factory.absractFactory;

public class FactoryImp {

    public static AbstractFactory getAbstractFactory(String type){
        if(type.equals("email")){
            return new AbstractEmailFactory();
        }else {
            return new AbstractEmailFactory();
        }
    }
}
