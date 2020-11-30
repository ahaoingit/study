package com.test;

/**
 * TODO
 *
 * @author ahao 2020-11-20
 */
public class _溢出测试 {
    public static void main(String[] args) {
        int maxNum = Integer.MAX_VALUE;
        int minNum = Integer.MIN_VALUE;
        System.out.println(minNum-1);

        float a = 12.66464f;
        int i = 0;
        int result = (int)(a *= 100);
        a = result / 100f;
        System.out.println(a);
    }
}
