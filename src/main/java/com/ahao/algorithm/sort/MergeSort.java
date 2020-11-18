package com.ahao.algorithm.sort;

import java.util.Arrays;

/**
 * TODO
 *
 * @author ahao 2020-10-19
 */
public class MergeSort {
    public static void mergeByRecursion(Integer[] nums,int L,int R){
        if (L == R) {
            return;
        }
        int mid = L+((R-L)>>1);
        mergeByRecursion(nums,L,mid);
        mergeByRecursion(nums,mid+1,R);
        merge(nums,mid,L,R);
    }

    private static void merge(Integer[] nums, int mid, int l, int r) {
        Integer[] help =new Integer[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            if (nums[p1] < nums[p2]) {
                help[i++] = nums[p1++];
            }else {
                help[i++] = nums[p2++];
            }
        }
        while (p1 <= mid) {
            help[i++] = nums[p1++];
        }
        while (p2 <= r) {
            help[i++] = nums[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            nums[l + j] = help[j];
        }
    }


    public static void merge(Integer[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        int N = nums.length;
        int mergeSize = 1;
        while (mergeSize < N) {
            int L = 0;

            while (L < N) {
                int M = L + mergeSize - 1;
                if (M >= N) {
                    break;
                }
                int R = Math.min(M + mergeSize , N - 1);
                merge(nums,M,L,R);
                L = R + 1;
            }
            if (mergeSize > (N >> 1)) {
                break;
            }
            mergeSize <<= 1;
        }
    }
    public static void main(String[] args) {
        Integer[] nums = {3,5,64,123,8,1,20};
        merge(nums);
        Arrays.stream(nums).forEach(num->{
            System.out.print(num + " ");
        });


    }
}
