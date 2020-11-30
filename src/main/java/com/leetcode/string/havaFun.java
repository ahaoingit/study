package com.leetcode.string;

/**
 * TODO
 *
 * @author ahao 2020-11-21
 */
public class havaFun {
    volatile int alfa = 5,beta,gamma;

    synchronized void mA() {
        beta = alfa * 5;
        alfa = beta;
    }
    synchronized void mB() {
        gamma = alfa + 32;
        alfa = gamma;
    }

    public static void main(String[] args) throws InterruptedException {
        havaFun havaFun = new havaFun();
        new Thread(()->havaFun.mB()).start();
        System.out.println(havaFun.alfa);
        new Thread(()->havaFun.mA()).start();
        Thread.sleep(1000);
        System.out.println(havaFun.alfa);
    }
}
