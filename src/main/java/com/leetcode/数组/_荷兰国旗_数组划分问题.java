package com.leetcode.数组;

import java.util.Arrays;

/**
 * TODO
 *
 * @author ahao 2020-10-19
 */
public class _荷兰国旗_数组划分问题 {

    /**
     * 划分一个数组 为 >num  =num   <num 的三个部分 并返回 =num的范围
     * @param args
     */
    public static void main(String[] args) {
        int[] nums = { 54  ,12};

        int less = -1;
        int more = nums.length;
        int i = 0;
        int r = nums[nums.length-1];
        while (i < more) {
            if (nums[i] < r) {
                swap(nums,++less,i++);
            }else if (nums[i] > r) {
                swap(nums,--more,i);
            }else {
                i++;
            }
            print(nums);
            System.out.println();
            System.out.println(less);
            System.out.println(more);
        }
    }

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
    public static void print(int[] arr) {
        Arrays.stream(arr).forEach(num -> {
            System.out.print(num+"  ");
        });
    }
}
