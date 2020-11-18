package com.ahao.algorithm.utils;

/**
 * TODO
 *
 * @author ahao 2020-08-03
 */
public class NumberUtils {
    /**
     * 交换数据
     * @param comparables
     * @param index1
     * @param index2
     */
    public static  void swap(Comparable[] comparables ,Integer index1 , Integer index2) {
        Comparable tmp = comparables[index1];
        comparables[index1] = comparables[index2];
        comparables[index2] = tmp;

    }
    /***.
     *@param v:
    * @param w:
     *@author ahao
     *@date 2020-08-04 12:16
     *@return {@link Boolean}
     *判断大小
     */
    public static Boolean less(Comparable v , Comparable w) {
        return v.compareTo(w) < 0;
    }
    /***.
     *@param arr:
     *@author ahao
     *@date 2020-08-04 12:13
     *@return {@link Boolean}
     *针对升序
     */
    public static Boolean isSort(Comparable[] arr) {
        for (int i = 0; i < arr.length - 1; ++i) {
            if (less(arr[i+1],arr[i])) {
                return false;
            }
        }
        return true;
    }
    /***.
     *@param dates:
     *@author ahao
     *@date 2020-08-04 12:17
     *@return
     *展示数据
     */
    public static <E> void showDate(E[] dates) {
        for (E date : dates) {
            System.out.print(date + " ,");
        }
    }

    /**
     * 经典冒泡
     * @param arr
     */
    public static void bubbleSort(Comparable[] arr) {
        for (int i = 0; i < arr.length; ++i) {
            for (int j = 0 ; j < arr.length - i - 1; ++j) {
                if (!less(arr[j], arr[j+1])) {
                    NumberUtils.swap(arr,j,j+1);
                }
            }
        }
    }
    /***.
     *@param arr:
     *@author ahao
     *@date 2020-08-06 19:36
     *@return
     *选择
     */
    public static void selectionSort(Comparable[] arr) {
        int currMinFlag ;
        for (int i = 0 ; i < arr.length; ++i) {
            currMinFlag = i;
            for(int j = i+1; j < arr.length;++j) {
                if (less(arr[j] , arr[currMinFlag])) {
                    currMinFlag = j;
                }
            }
            if (i != currMinFlag) {
                swap(arr, currMinFlag,i);
            }
        }
    }
}
