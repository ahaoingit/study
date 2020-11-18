package com.ahao.javacoretechnology.chapter4class;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author ahao
 */
public class Employee {
    public  static  int id = 1;
    private String name;
    private double salary;
    private Date hireDay;

    public Employee(String name, double salary, Date hireDay) {
        this.name = name;
        this.salary = salary;
        this.hireDay = hireDay;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        return (Date) hireDay.clone();
    }
    public void raiseSalary(double byPercent){
        double raise =salary * byPercent /10 ;
        salary += raise;
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Employee.id = id;
    }
}
