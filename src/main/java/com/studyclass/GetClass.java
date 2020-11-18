package com.studyclass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * TODO
 *
 * @author ahao 2020-09-25
 */
public class GetClass {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Student stu = new Student();
        //获取类对象 法一
        Class<?> aClass = Class.forName("com.studyclass.Student");
        //法二
        Class<? extends Student> aClass1 = stu.getClass();
        //法三
        Class<Student> studentClass = Student.class;

        // 反射获取所有属性操作
        //获取 public的
        Field[] fields = aClass.getFields();
        Arrays.stream(fields).forEach(field -> {
            System.out.println(field.getName());
        });
        System.out.println("----------------------所有字段-------------------------------");
        //获取所有字段
        Field[] declaredFields = aClass.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(field -> System.out.println(field.getName()));
        //获取指定设置字段
        Field age = aClass.getDeclaredField("age");
        System.out.println(age.getName());
        //设置字段 私有字段要给权限
        age.setAccessible(true);
        age.set(stu,11);

        System.out.println("+++++++++++++++++类创建+++++++++++++++++++");
        //无参构造
        Constructor<?> constructor = aClass.getConstructor();
        Object o = constructor.newInstance();
        System.out.println(o);
        //有参构造
        Constructor<?> constructor1 = aClass.getConstructor(String.class, Integer.class);
        Object o1 = constructor1.newInstance("fdsf", 12);
        System.out.println(o1);
        System.out.println("+++++++++++++++++++++++方法执行+++++++++++++++++++++++++==");
        //函数执行 无参
        Method privateTest = aClass.getDeclaredMethod("privateTest");
        privateTest.setAccessible(true);
        privateTest.invoke(o1);
        //有参

    }
}
