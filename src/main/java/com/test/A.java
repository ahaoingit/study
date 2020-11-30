package com.test;

/**
 * TODO
 *
 * @author ahao 2020-11-20
 */
public class A {
    int sum = 20;
    static {
        System.out.println("A");
    }
    {
        System.out.println("aa");
    }
    public A(){
        System.out.println("aaaaaaa");
    }

    public void print() {
        System.out.println("AAAA");
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public static void main(String[] args) {
        A a = new A();
    }
}
