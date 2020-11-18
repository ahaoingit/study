package com.juc;

import lombok.SneakyThrows;
import sun.awt.windows.ThemeReader;

/**
 * TODO
 *
 * @author ahao 2020-06-27
 */
public class ThreadJoin {
    private static class T1 extends Thread{
        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 10; i++) {
                System.out.println("T1");
            }
        }
    }
    private static class T2 implements Runnable{

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
        @SneakyThrows
        @Override
        public void run() {
            T1 t1 = new T1();
            t1.join();
            for (int i = 0; i < 10; i++) {
                System.out.println("T2");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("t1");
            }
        });
        Thread t2 = new Thread(()->{
            try {
                t1.join();
                for (int i = 0; i < 5; i++) {
                    System.out.println("t2");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t2.start();
        t1.start();
    }
}
