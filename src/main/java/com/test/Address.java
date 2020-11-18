package com.test;

import sun.misc.Launcher;

/**
 * TODO
 *
 * @author ahao 2020-09-24
 */
public class Address implements Info {
    private String info;

    @Override
    public void info() {
        System.out.println("address");
    }

    @Override
    public String toString() {
        return "Address{" +
                "info='" + info + '\'' +
                '}';
    }

    public static void main(String[] args) {
        String.class.getClassLoader();

    }
}
