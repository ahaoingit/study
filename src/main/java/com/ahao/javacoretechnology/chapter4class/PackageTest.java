package com.ahao.javacoretechnology.chapter4class;

import java.time.LocalDate;
import java.util.Date;
import java.util.logging.SimpleFormatter;

/**
 * @author ahao
 */
public class PackageTest {
    public static void main(String[] args) {
        //可变数据域，要返回此可变数据的拷贝 clone  注意
        SimpleFormatter simpleFormatter = new SimpleFormatter();
        Employee em = new Employee("ahao",200.00,new Date());
        System.out.println(em.getHireDay());
        Date hireDay = em.getHireDay();
        hireDay.setTime(2000000);
        System.out.println(em.getHireDay());
        //final 只是指引用不会再改变 但是 对像本身可以改变
        //基本类型不可以改变
        final int i = 0;
        //引用类型 引用的地址不会发生改变 但是引用的对象的值可以改变
        final  Employee eb = new Employee("test",1313,new Date());
        eb.raiseSalary(100);
        //静态域 属于类 是所有对象共享的 只有一份
        System.out.println(Employee.getId());
    }
}
