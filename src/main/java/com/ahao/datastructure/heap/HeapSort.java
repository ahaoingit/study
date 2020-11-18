package com.ahao.datastructure.heap;

/**
 * TODO
 *
 * @author ahao 2020-11-05
 */
public class HeapSort {
    public static void heapSort(int[] arr) throws Exception {
        //先调成大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }
        //开始往下过滤
        int limit = arr.length;
        swap(arr,0,--limit);
        while (limit > 0) {
            heapfiy(arr,limit,0);
            swap(arr,0,--limit);
        }
    }

    public static void heapInsert(int[] arr,int index) {
        if (index == 0) return;
        while (arr[index] > arr[(index-1) / 2]) {
            swap(arr,index,(index-1) / 2);
            index = (index-1) / 2;
        }
    }
    public static void heapfiy(int[] arr,int limit,int index) {
        //获取左孩子
        int leftChild =(index << 1) + 1;
        while (leftChild < limit) {
            //对比右孩子
            int largest = leftChild + 1 < limit && arr[leftChild] < arr[leftChild+1] ? leftChild + 1 :leftChild;
            largest = arr[index] > arr[largest] ? index : largest;
            if (largest == index) break;
            swap(arr,index,largest);
            index = largest;
            leftChild = (index << 1) + 1;
        }
    }
    public static void swap(int[] arr , int index1,int index2) {
        int tem = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tem;
    }


    public static void main(String[] args) throws Exception {
        int[] arr = {1,32,56,44,0,3,56,12,46587,11};
        heapSort(arr);
        for (int i : arr) {
            System.out.print(i + "  ");
        }
    }
}
