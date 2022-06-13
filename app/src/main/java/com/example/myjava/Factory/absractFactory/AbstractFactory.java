package com.example.myjava.Factory.absractFactory;

import com.example.myjava.Factory.NormalFactory.ISender;

public abstract class AbstractFactory  {

    abstract ISender getSender(String type);
}
