package com.juc.creat;

/**
 * TODO
 *实现 Runnable 接口
 * @author ahao 2020-07-15
 */
public class Method2 {
     static class RunnableImpl implements Runnable {

        /**
         * When an object implementing interface <code>Runnable</code> is used
         * to create a thread, starting the thread causes the object's
         * <code>run</code> method to be called in that separately executing
         * thread.
         * <p>
         * The general contract of the method <code>run</code> is that it may
         * take any action whatsoever.
         *
         * @see Thread#run()
         */
        @Override
        public void run() {
            System.out.println("线程创建第二种");
            System.out.println("优点 扩展性高");
            System.out.println("缺点 无返回值");
        }
    }
}
