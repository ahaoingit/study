package com.studyclass;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;

/**
 * TODO
 *
 * @author ahao 2020-11-20
 */
public class _反射获取参数名称 {
    //Preferences->Build,Execution,Deployment->Compiler->java Compiler 加上-parameters参数
    public static void main(String[] args) {
        Class<Address> aClass = Address.class;

        Method[] methods = aClass.getMethods();

        Arrays.stream(methods).forEach(method -> {
            String name = method.getName();
            Parameter[] parameters = method.getParameters();
            Arrays.stream(parameters).forEach(parameter -> System.out.println(parameter.getName() + "  :  "+parameter.getType()));
        });
    }
}
