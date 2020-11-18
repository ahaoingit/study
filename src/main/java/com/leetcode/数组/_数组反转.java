package com.leetcode.数组;

import java.util.Arrays;

/**
 * TODO
 *
 * @author ahao 2020-09-29
 */
public class _数组反转 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int i = 0;
        int j = arr.length-1;
        while (i < j) {
             arr[i] = arr[i] ^ arr[j];
             arr[j] = arr[i] ^ arr[j];
             arr[i] = arr[i] ^ arr[j];
             ++i;
             --j;
        }
        Arrays.stream(arr).forEach(System.out::print);
    }
}
