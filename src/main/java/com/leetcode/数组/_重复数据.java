package com.leetcode.数组;

import java.util.Arrays;
import java.util.HashSet;

/**
 * TODO
 *从一个数组中删除重复元素；
 * @author ahao 2020-09-29
 */
public class _重复数据 {
    public static <T> Object[] removeDuplicates(T[] arr) {
        return  new HashSet<>(Arrays.asList(arr)).toArray();
    }

    public static void main(String[] args) {
        Integer[] arr= {1,33,33,33,1,33,33};
        for (Object integer : removeDuplicates(arr)) {
            System.out.println(integer);
        }
    }
}
