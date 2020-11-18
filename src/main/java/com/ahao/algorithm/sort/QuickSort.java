package com.ahao.algorithm.sort;

import com.ahao.algorithm.utils.Print;
import com.ahao.algorithm.utils.SwapUtil;

/**
 * TODO
 *快排 基于荷兰国旗划分的解决 递归
 * @author ahao 2020-10-28
 */
public class QuickSort {
    public static void quickSort(int[] nums) {
        sort(nums,-1,nums.length);
    }

    /**
     * @param num
     * @param l 左边界的前一个当作l
     * @param r 以及右边界的后一个当作r
     */
    private static void sort(int[] num ,int l,int r) {
        if (l==r ||num==null || num.length == 1 || r==0) {
            return;
        }
        int compareNum = num[r-1];
        int i = l+1;
        while (i < r) {
            if (num[i] < compareNum) {
                SwapUtil.swap(num,++l,i++);
            }else if (num[i] > compareNum) {
                SwapUtil.swap(num,--r,i);
            }else {
                i++;
            }
        }
        //排左边
        sort(num,-1,l+1);
        //排右边
        sort(num,r-1,num.length);
    }

    public static void main(String[] args) {
        int[] nums = {1,3,56,3546,78,445,0,124,65,3,246,546,12,54,3,5};
        quickSort(nums);
        Print.print(nums);
    }
}
