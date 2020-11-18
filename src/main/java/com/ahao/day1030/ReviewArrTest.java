package com.ahao.day1030;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * @author ahao
 */
public class ReviewArrTest {
    @Test
    public void createArr(){
        //三种方式
        int[] arr = new int[]{1,3,4,6,4};
        int[] arr2 = new int[3];
        int[] arr3 = {1,2,3,4,3};
        change(arr[0],arr[1]);
        for (int i : arr) {
            System.out.println(i);
        }

    }
    public void change(int a , int b){
        a = 1;
        b = 2;
    }
}
