package com.studyclass;

/**
 * TODO
 *
 * @author ahao 2020-09-27
 */
public class Teacher implements Person {
    @Override
    public void setName(String name) {
        System.out.println("name"+name);
    }

    @Override
    public void setAge(int age) {

    }

    @Override
    public void work() {
        System.out.println("teacher");
    }
}
