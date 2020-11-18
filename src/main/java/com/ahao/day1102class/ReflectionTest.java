package com.ahao.day1102class;

import java.util.ArrayList;

/**
 * @author ahao
 */
public class ReflectionTest {
    public void getClassTest() throws ClassNotFoundException {
        //获取Class文件
        Class<?> aClass = Class.forName("java.util.ArrayList");
        //2
        ArrayList arrayList = new ArrayList();
        Class<? extends ArrayList> aClass1 = arrayList.getClass();
        //3
        Class<ArrayList> arrayListClass = ArrayList.class;
    }
    public void getInstance() throws IllegalAccessException, InstantiationException {
        ArrayList arrayList = ArrayList.class.newInstance();

    }
}
