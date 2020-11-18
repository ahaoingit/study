package com.ahao.algorithm.utils;

/**
 * TODO
 *
 * @author ahao 2020-10-29
 */
public class SwapUtil {
    /**
     *可以对同一位置进行替换
     * @param arr
     * @param num1
     * @param num2
     */
    public static void swap(int[] arr, int num1, int num2) {
        int tem = arr[num1];
        arr[num1] = arr[num2];
        arr[num2] =tem;
    }

    /**
     * 效率最高 但是不能对同一位置进行替换,不能对相同数据进行替换
     * @param arr
     * @param num1
     * @param num2
     */
    public static void swapByXor(Integer[] arr, int num1, int num2) {
        arr[num1] = arr[num1] ^ arr[num2];
        arr[num2] = arr[num1] ^ arr[num2];
        arr[num1] = arr[num1] ^ arr[num2];
    }

    /**
     * 不需要第三个变量进行辅助 也是不能对同一位置进行替换 但是可以对相同数据进行替换
     * @param arr
     * @param num1
     * @param num2
     */
    public static void swapByAddAndSub(Integer[] arr, int num1, int num2) {
        arr[num1] = arr[num1] + arr[num2];
        arr[num2] = arr[num1] - arr[num2];
        arr[num1] = arr[num1] - arr[num2];
    }
}
