package com.basicknowledge;

import java.io.FileInputStream;

/**
 * TODO
 *
 * @author ahao 2020-08-27
 */
public class Test {
    static int i = 0;
    public static void main(String[] args) {
        String  s = "abcd";
        System.out.println(mystery(s));

    }


    public static String mystery(String s) {
        int length = s.length();
        if (length <= 1) {
            return s;
        }
        String a = s.substring(0,length/2);
        String b = s.substring(length/2,length);
        return mystery(b) + mystery(a);
    }
}
