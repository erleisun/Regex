package com.example.myjava.Factory.absractFactory;

import com.example.myjava.Factory.NormalFactory.EmailSender;
import com.example.myjava.Factory.NormalFactory.ISender;

public class AbstractEmailFactory extends AbstractFactory {
    @Override
    ISender getSender(String type) {
        return new EmailSender();
    }
}
