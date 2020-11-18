package com.ahao.designpatterns.singleton;

/**
 * TODO
 *存在多线程问题
 * @author ahao 2020-11-17
 */
public class LasySingleton {
    private static LasySingleton instance;
    private LasySingleton() {}
    public static LasySingleton getInstance() {
        if (instance == null) {
            instance = new LasySingleton();
        }
        return instance;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()->{
                System.out.println(LasySingleton.getInstance().hashCode());
            }).start();
        }
    }
}
