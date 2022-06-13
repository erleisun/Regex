package com.example.myjava.Factory.moreFactory;

import com.example.myjava.Factory.NormalFactory.EmailSender;
import com.example.myjava.Factory.NormalFactory.ISender;
import com.example.myjava.Factory.NormalFactory.SmsSender;

/**
 * 多个工厂模式
 */
public class MoreFactory {

    public ISender SmsSender(){
        return new SmsSender();
    }

    public ISender EmailSender(){
        return new EmailSender();
    }
}
