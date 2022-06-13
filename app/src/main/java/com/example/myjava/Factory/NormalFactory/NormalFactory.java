package com.example.myjava.Factory.NormalFactory;

/**
 * 普通工厂模式
 */
public class NormalFactory {

    public ISender getSender(String type){

        if("Email".equals(type)){
            return new EmailSender();
        }else if("SMS".equals(type)){
            return new SmsSender();
        }
        return null;
    }
}
