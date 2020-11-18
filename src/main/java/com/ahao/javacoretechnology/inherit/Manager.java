package com.ahao.javacoretechnology.inherit;

import java.util.Date;

/**
 * @author ahao
 */
public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double salary, Date hireDay, double bonus) {
        super(name, salary, hireDay);
        this.bonus = bonus;
    }

    public Manager() {
        super();
    }

    public static void main(String[] args) {
        Manager manager = new Manager("ahao",200,new Date(),3333);
    }
}
