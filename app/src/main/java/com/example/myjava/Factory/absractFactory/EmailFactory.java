package com.example.myjava.Factory.absractFactory;

import com.example.myjava.Factory.NormalFactory.EmailSender;
import com.example.myjava.Factory.NormalFactory.ISender;

public class EmailFactory implements IProvider {

    @Override
    public ISender getProduct() {
        return new EmailSender();
    }
}
