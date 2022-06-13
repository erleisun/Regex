package com.example.myjava.Factory.absractFactory;

import com.example.myjava.Factory.NormalFactory.ISender;
import com.example.myjava.Factory.NormalFactory.SmsSender;

public class AbstractSmsFactory extends AbstractFactory {
    @Override
    ISender getSender(String type) {
        return new SmsSender();
    }
}
