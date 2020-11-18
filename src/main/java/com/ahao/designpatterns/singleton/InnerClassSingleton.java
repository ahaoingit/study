package com.ahao.designpatterns.singleton;

/**
 * TODO
 *此方法有jvm 保证单例 jvm加载类仅有一次 当使用到内部类时才加载
 * @author ahao 2020-11-17
 */
public class InnerClassSingleton {
    private InnerClassSingleton(){}

    private static class SingletonHolder{
        private final static InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
