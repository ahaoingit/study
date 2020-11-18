package com.juc.creat;

/**
 * TODO
 * 线程创建的三种方法一 : 继承Thread
 * @author ahao 2020-07-15
 */

public class Method1 {
    static class ThreadTest extends Thread{
        @Override
        public void run() {
            super.run();
            System.out.println("继承创建线程对象有以下优点");
            System.out.println("获取当前线程直接使用this 没有必要使用Thread.currentThread");
            System.out.println("缺点: 任务代码没有办法复用 扩展性不高 无返回值");
        }
    }
}
