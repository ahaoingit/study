package com.juc.classlayout;

import org.openjdk.jol.info.ClassLayout;

/**
 * TODO
 *
 * @author ahao 2020-09-15
 */
public class ClassLayoutTest {
    public static void main(String[] args) throws InterruptedException {
        User u = new User();
        System.out.println(ClassLayout.parseInstance(u).toPrintable());
        System.out.println("=========================================");
        synchronized (u) {
            System.out.println(ClassLayout.parseInstance(u).toPrintable());
        }
    }
}
