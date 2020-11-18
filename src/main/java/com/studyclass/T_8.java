package com.studyclass;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * TODO
 *
 * @author ahao 2020-09-27
 */
public class T_8 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Properties properties = new Properties();
        properties.load(new FileInputStream(new File("src/main/java/com/studyclass/bean.properties")));
        String aClassName = (String)properties.get("class");
        String name =(String) properties.get("name");
        String age =(String) properties.get("age");
        //获取数据
        Class<?> aClass = Class.forName(aClassName);
        Method setName = aClass.getMethod("setName", String.class);
        Teacher o = (Teacher)aClass.newInstance();
        setName.invoke(o,name);
        Method setAge = aClass.getMethod("setAge", int.class);
        setAge.invoke(o,18);

    }
}
