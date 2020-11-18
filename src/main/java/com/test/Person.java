package com.test;

/**
 * TODO
 *
 * @author ahao 2020-09-24
 */
public class Person<T extends Info> {
    T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public static void main(String[] args) {
        try {
            return;
        } finally {
            System.out.println("123");
        }

    }
}
