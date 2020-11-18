package com.ahao.datastructure.sparsearray;

import java.nio.file.Path;

/**
 * @author ahao
 */
public class Sparsearray {
    /**
     [args]
     *@author ahao
     *@data 2020-05-11 7:54
     *@return void
     *
     */
    public static void main(final String[] args) {
        int[][] arr = {
                {0, 0, 2, 0, 3},
                {0, 0, 0, 3, 1},
                {0, 0, 1, 3, 5},
                {0, 3, 0, 0, 0}
        };

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    count++;
                }
            }
        }

        int[][] sparseArray = new int[count+1][3];
        //稀疏数组的第一行 记录 二维数组的 列 行 不是零的总数
        sparseArray[0][0] = arr.length;
        sparseArray[0][1] = arr[0].length;
        sparseArray[0][2] = count;
        int sparseArrayBelow = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0) {
                    sparseArray[sparseArrayBelow][0] = i;
                    sparseArray[sparseArrayBelow][1] = j;
                    sparseArray[sparseArrayBelow][2] = arr[i][j];
                    sparseArrayBelow++;
                }
            }
        }
        for (int i = 0; i < sparseArray.length; i++) {
            for (int j = 0; j < sparseArray[0].length; j++) {
                System.out.print(sparseArray[i][j]);
            }
            System.out.println();
        }
    }
    /**
     * 序列化
     * @param arr 序列化的数组
     */
   public void serializationArr(final int[][] arr) {
       Path path;
   }
}
