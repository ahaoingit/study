package com.studyclass;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *-----------------改写下面代码-----------
        *List list=new ArrayList();
        *list.add(“hello”);
        *list.add(“world”);
        *String str=list.get(0);
        * //--------------------------------------
        *System.out.println(str);
 * @author ahao 2020-09-27
 */
public class T_7 {
    public static void main(String[] args) throws Exception {
        Class<ArrayList> arrayListClass = ArrayList.class;
        ArrayList arrayList = arrayListClass.newInstance();
        Method add = arrayListClass.getMethod("add", Object.class);
        add.invoke(arrayList,"hello");
        add.invoke(arrayList,"world");
        Method get = arrayListClass.getMethod("get", int.class);
        System.out.println(get.invoke(arrayList,0));
    }
}
