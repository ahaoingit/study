package com.ahao.algorithm.utils;

import java.util.Arrays;

/**
 * TODO
 *
 * @author ahao 2020-10-29
 */
public class Print {
    public static void print(int[] arr) {
        Arrays.stream(arr).forEach(num -> {
            System.out.print(num+"  ");
        });
    }
}
