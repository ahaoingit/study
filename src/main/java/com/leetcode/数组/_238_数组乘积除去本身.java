package com.leetcode.数组;

import com.leetcode.链表.ListNode;
import groovy.lang.GroovyClassLoader;
import org.junit.Test;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * TODO
 *https://leetcode-cn.com/problems/product-of-array-except-self/
 * @author ahao 2020-07-02
 */
public class _238_数组乘积除去本身<E> {
    public int[] solution(int[] nums){
        //前缀之积
        int[] L = new int[nums.length];
        //后缀之积
        int[] R = new int[nums.length];
        //答案
        int[] answer = new int[nums.length];
        L[0] = 1;
        R[R.length-1] = 1;
        for (int i = 1; i < nums.length; ++i) {
            L[i] = nums[i - 1] * L[i - 1];
        }
        for (int i = nums.length - 2; i >= 0; --i) {
            R[i] = nums[i + 1] * R[i + 1];
        }
        for (int i = 0; i < nums.length; ++i) {
            answer[i] = L[i] * R[i];
        }
        return answer;
    }
    @Test
    public void solutionTest() {
        int[] num = new int[]{1,2,3,4};
        int[] answer = solution(num);
        for (int i : answer) {
            System.out.print(i+" ");
        }
    }
    @Test
    public void testGroovyClasses() throws Exception {
//        List<Map<String, List<E>>> mapList = new ArrayList<>();
//        //groovy提供了一种将字符串文本代码直接转换成Java Class对象的功能
//        GroovyClassLoader groovyClassLoader = new GroovyClassLoader();
//        //里面的文本是Java代码,但是我们可以看到这是一个字符串我们可以直接生成对应的Class<?>对象,而不需要我们写一个.java文件
//        Class<?> clazz = groovyClassLoader.parseClass("package com.xxl.job.core.glue;\n" +
//                "\n" +
//                "public class Person {\n" +
//                "\n" +
//                "    public int age = 22;\n" +
//                "    \n" +
//                "    public void sayHello() {\n" +
//                "        System.out.println(\"年龄是:\" + age);\n" +
//                "    }\n" +
//                "}\n");
//        Object obj = clazz.newInstance();
//        Method method = clazz.getDeclaredMethod("sayHello");
//        method.invoke(obj);
//
//        Object val = method.getDefaultValue();
//        System.out.println(obj.toString());
//        System.out.println(val);

    }
}
