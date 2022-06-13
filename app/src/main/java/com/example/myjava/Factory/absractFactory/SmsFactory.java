package com.example.myjava.Factory.absractFactory;

import com.example.myjava.Factory.NormalFactory.ISender;
import com.example.myjava.Factory.NormalFactory.SmsSender;

public class SmsFactory implements IProvider {

    @Override
    public ISender getProduct() {
        return new SmsSender();
    }
}
