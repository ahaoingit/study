package com.ahao.algorithm.find;

import org.junit.Test;

/**
 * TODO
 *
 * @author ahao 2020-08-28
 */
public class BinarySearch {
    public int binarySearch(int[] arr , int key) throws Exception {
        if (!checkSort(arr)) {
            throw new Exception("数组无序");
        }
        int lo = 0;
        int hi = arr.length-1;
        int mid;
        while (lo <= hi ) {
            mid = lo + (hi - lo)/2;
            if (key < arr[mid]) {
                hi = mid - 1;
            }else if(key > arr[mid]) {
                lo = mid +1;
            }else {
                return mid;
            }
        }
        return -1;
    }

    public Boolean checkSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i] <= arr[i+1]) {
                continue;
            }else {
                return false;
            }
        }
        return true;
    }

    @Test
    public void test() throws Exception {
        int[] arr = {1,3,6,5,7};
        System.out.println(binarySearch(arr,3));
    }

}
