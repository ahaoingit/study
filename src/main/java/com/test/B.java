package com.test;

/**
 * TODO
 *
 * @author ahao 2020-11-20
 */
public class B extends A{
    int sum = 10;
    public B(){ }
    @Override
    public void print() {
        System.out.println("BBB");
    }
    public static void main(String[] args) {
        A a = new B();

        System.out.println(a.sum);
        a.print();
    }
}
