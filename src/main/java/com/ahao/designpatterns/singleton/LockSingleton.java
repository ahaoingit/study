package com.ahao.designpatterns.singleton;

/**
 * TODO
 *效率低
 * @author ahao 2020-11-17
 */
public class LockSingleton {
    private static LockSingleton instance;
    private LockSingleton(){}
    public synchronized LockSingleton getInstance() {
        if (instance == null) {
            instance = new LockSingleton();
        }
        return instance;
    }
}
