package com.ahao.algorithm.chapterone;

/**
 * @author ahao
 */
public class BinaryRecursion {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,8,9};
        System.out.println(binary(arr,5,0,arr.length));
        System.out.printf("%50d",feiber(20));
    }
    public static int binary(int[] arr, int key , int low , int high){
        if (low > high){
            return -1;
        }
        int mid = low + (high - low)/2;
        if (key < arr[mid]){
            return binary(arr,key,low,mid-1);
        } else if (key>arr[mid]){
            return binary(arr,key,mid+1,high);
        }else {
            return mid;
        }
    }
    public static int binaryByFor(int key , int []arr){
        int low = 0;
        int high = arr.length-1;
        while (low>=high){
            int mid = low + (high - low)/2;
            if (key > arr[mid]){
                low = mid + 1;
            } else if (key < arr[mid]){
                high = mid - 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    /**
     * feiber数列
     */
    public static int feiber(int num){
        if (num < 0){
            throw new LessThanZeroException("不能小于0");
        }
        if (num == 1){
            return 1;
        } else if (num == 2){
            return 1;
        }  else {
            return feiber(num -1) + feiber(num -2);
        }
    }
}
