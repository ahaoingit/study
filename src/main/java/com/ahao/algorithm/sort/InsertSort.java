package com.ahao.algorithm.sort;

import java.util.Arrays;

/**
 * TODO
 *
 * @author ahao 2020-10-14
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {8,6,14,4,2,3};
        for (int i = 1 ; i < arr.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (arr[j+1] < arr[j]) {
                    arr[j+1] = arr[j+1] ^ arr[j];
                    arr[j] = arr[j+1] ^ arr[j];
                    arr[j+1] = arr[j+1] ^ arr[j];
                }else {
                    break;
                }
            }
        }
        Arrays.stream(arr).forEach(System.out::print);
    }

}
