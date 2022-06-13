package com.example.myjava.proxy.girl;

public class ProxyTest {

    public static void main(String[] args) {

        IGirl girl = new WangMeiLi();

        IGirl girl1 = new MissWu();

        WangMeiLiProxy wangMeiLiProxy = new WangMeiLiProxy(girl1);
        IGirl proxyInstance = (IGirl) wangMeiLiProxy.getProxyInstance();
        proxyInstance.watchMovie();
        proxyInstance.getWeight("type");

    }

}
