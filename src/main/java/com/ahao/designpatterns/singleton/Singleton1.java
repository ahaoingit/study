package com.ahao.designpatterns.singleton;

/**
 * TODO
 *饿汉式
 *
 *
 * @author ahao 2020-11-17
 */
public class Singleton1 {
    private static final Singleton1 SINGLETON = new Singleton1();
    private Singleton1(){}

    private Singleton1 getInstance() {
        return SINGLETON;
    }
}
