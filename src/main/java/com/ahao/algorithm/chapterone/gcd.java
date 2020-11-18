package com.ahao.algorithm.chapterone;

/**
 * 欧几里得算法 求两个数的最大公约数
 * @author ahao
 */
public class gcd {
    public static void main(String[] args) {
        int i = gcdAlgorithm(6, 9);
        System.out.println(i);
    }
    public static int gcdAlgorithm(int p , int q){
        if (q == 0){
            return p;
        }
        int r = p % q;
        return gcdAlgorithm(q , r);
    }
}
