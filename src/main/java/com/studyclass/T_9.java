package com.studyclass;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * TODO
 *
 * @author ahao 2020-09-27
 */
public class T_9 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Address addr = new Address("beijing", "100000");
        Student stu = new Student("tom", 18, 75, addr);
        System.out.println(toJson(stu));
    }


    public static String toJson(Object o) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        Class<?> aClass = o.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        Arrays.stream(declaredFields).forEach(field -> {
            //处理字段
            String filedName = field.getName().substring(0,1).toUpperCase()+field.getName().substring(1);
            //调用每个字段的get
            try {
                Method method = aClass.getMethod("get" + filedName);
                Object invoke = method.invoke(o);
                if (invoke instanceof Address){
                    sb.append(toJson(invoke));
                }else {
                    sb.append("\"" + field.getName()+"\":"+invoke+",\t");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        if (  !(o instanceof Address)) {
            sb.append("\"level:\""+"\""+aClass.getMethod("getLevel").invoke(o)+"\"");
        }
        sb.append("}");
        return sb.toString();
    }
}
