package com.ahao.designpatterns.singleton;

/**
 * TODO
 *为什么要检侧两个null 锁的获取很耗费时间
 * @author ahao 2020-11-17
 */
public class DoubleLockSingleton {
    private volatile DoubleLockSingleton  instance;
    private DoubleLockSingleton(){}
    private DoubleLockSingleton getInstance() {
        if (instance == null) {
            synchronized(this){
                if (instance == null) {
                    instance = new DoubleLockSingleton();
                }
            }
        }
        return instance;
    }
}
