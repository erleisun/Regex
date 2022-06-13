package com.example.myjava.Factory.absractFactory;

import com.example.myjava.Factory.NormalFactory.ISender;

/**
 * 创建工厂类统一接口
 */
public interface IProvider {

    public ISender getProduct();
}
