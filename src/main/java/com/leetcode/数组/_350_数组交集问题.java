package com.leetcode.数组;


import java.util.HashMap;
import java.util.Map;

/**
 * TODO
 *给定俩个数组输出他俩的交集
 * @author ahao 2020-08-23
 */
public class _350_数组交集问题 {


    public Object[] Intersection(int[] arr1 , int[] arr2) {
        Map<Integer , Integer> map = new HashMap<>();
        for (int num : arr1) {
            if (map.get(num) == null) {
                map.put(num,1);
            }else {

            }
        }
        return null;
    }


}
