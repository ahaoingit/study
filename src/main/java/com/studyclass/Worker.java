package com.studyclass;

/**
 * TODO
 *
 * @author ahao 2020-09-27
 */

public class Worker {
    private String name;
    private int age;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void work(){
        System.out.println(name + " is working");
    }
    public void work(int hour){
        System.out.println(name +  "is working for"
        + hour + "hours");
    }
}
