package com.ahao.algorithm.chapterone;

/**
 * @author ahao
 */
public class Prime {
    public static void main(String[] args) {
        System.out.println(isPrime(6));
    }
    public static Boolean isPrime(int num){
        int boundary = 2;
        if (num < boundary){
            return false;
        }
        for (int i = boundary;i*i<=num;i++){
            if (num % i == 0){
                return false;
            }
        }
        return true;
    }
}
