package com.ahao.algorithm.sort;

import java.util.Arrays;

/**
 * TODO
 *关于冒泡排序:冒泡是大的往后排 或者 小的往后排
 * @author ahao 2020-08-03
 */
public class Sort {

    public static void main(String[] args) {
        Integer[] nums = {3,5,64,123,8,1,20};

//        for (int i = 0; i < nums.length; i++) {
//            for (int j = 0; j < nums.length - i -1; j++) {
//                if (nums[j] > nums[j+1]){
//                    nums[j] = nums[j] + nums[j+1];
//                    nums[j+1] = nums[j] - nums[j+1];
//                    nums[j] = nums[j] - nums[j+1];
//                }
//            }
//        }
//        //选择
//        for (int i = 0; i < nums.length; i++) {
//            int flag = i;
//            for (int j = i + 1;j< nums.length;++j){
//                if (nums[j] < nums[flag]){
//                    flag = j;
//                }
//            }
//            if (flag != i) {
//                swap(nums,i,flag);
//            }
//        }
        //插入
        for (int i = 0; i < nums.length; i++) {
            for (int j = i ; j > 0;--j) {
                if (nums[j-1] > nums[j]) {
                    swap(nums,j-1,j);
                }else {
                    break;
                }
            }
        }
        print(nums);
    }

    public static void swap(Integer[] arr, int num1, int num2) {
            arr[num1] = arr[num1] + arr[num2];
            arr[num2] = arr[num1] - arr[num2];
            arr[num1] = arr[num1] - arr[num2];
    }
    public static void print(Integer[] arr) {
        Arrays.stream(arr).forEach(num -> {
            System.out.print(num+"  ");
        });
    }
}
