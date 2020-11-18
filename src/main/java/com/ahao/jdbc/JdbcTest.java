package com.ahao.jdbc;

import com.ahao.javacoretechnology.inherit.Employee;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

/**
 * @author ahao
 */
public class JdbcTest {
    public static void main(String[] args) throws ClassNotFoundException {
//    instanceof 判断类型
        String a = "21";
        System.out.println(a instanceof String);
        Class<?> forName = Class.forName("com.ahao.day1030.ReviewArrTest");
        String name = forName.getName();
        Method[] declaredMethods = forName.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method.getName());
        }
        System.out.println(name);

    }
}
