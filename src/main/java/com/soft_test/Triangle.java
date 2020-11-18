package com.soft_test;

import javax.swing.*;
import java.util.Scanner;

/**
 * TODO
 *
 * @author ahao 2020-07-01
 */
public class Triangle {
    public static void judgment(int a, int b, int c){ //1
        int perimeter = 0;                   //2
        if (a > 0 && b > 0 && c > 0) {      //3,4,5
            if ( a + b > c && a + c > b && b + c > a){// 6 , 7 , 8
                if (a == b && b == c) {               // 9, 10
                    System.out.println("等边三角形");   // 11
                }else if (a == b || b == c || c == a){ // 12,13,14
                    System.out.println("等腰三角型");//15
                }
                perimeter = a + b + c ;//16
                System.out.println("周长:"+perimeter);//17
            }else {//18
                System.out.println("不能构成三角型");//19
            }
        }else {//20
            System.out.println("输入错误");//21
        }
    }
    public void ruinian(int year) {
        if (year >= 1000 && year<=2001) { //1 , 2
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 ==0){ // 3,4,5
                System.out.println("瑞年");//6
            }else {
                System.out.println("平年");//7
            }
        }else {//8
            System.out.println("输人范围错误");//9
        }
    }
    public static void main(String[] args) {
        final Person p = new Person();
        p.setName("haoa");
        System.out.println(p.getName());
        Person p1 = p;
        p1.setName("ahao");
        System.out.println(p.getName());
    }
}
