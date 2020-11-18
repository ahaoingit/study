package com.studyclass;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * TODO
 *
 * @author ahao 2020-09-27
 */
public class TestStudent {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class c;
        Class<?> aClass = Class.forName("com.studyclass.Worker");
        Worker worker = (Worker)aClass.newInstance();
        //set
        Method setName = aClass.getMethod("setName", String.class);
        Method setAge = aClass.getMethod("setAge", int.class);
        Method setSalary = aClass.getMethod("setSalary", double.class);
        setName.invoke(worker,"Tom");
        setAge.invoke(worker,18);
        setSalary.invoke(worker,2500.0);
        //无参 work
        Method work = aClass.getMethod("work");
        work.invoke(worker);
        //有参 work
        Method work1 = aClass.getMethod("work", int.class);
        work1.invoke(worker,8);

    }
}
