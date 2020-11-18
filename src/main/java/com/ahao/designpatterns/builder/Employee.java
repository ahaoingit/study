package com.ahao.designpatterns.builder;

import lombok.*;

/**
 * @author ahao
 */

@Data
public class Employee {
    private String firstName;
    private String lastName;
    private int age;
    private boolean gender;
    private String houseSno;
    private String street;
    private int building;
    private String email;
    private String phone;
    private  int type;
    private String company;
    private double salary;

    public Employee() {
    }

    public static EmployeeBuilder builder() {
        return new EmployeeBuilder();
    }

    protected boolean canEqual(final Object other) {
        return other instanceof Employee;
    }

    public static class EmployeeBuilder {
        private String firstName;
        private String lastName;
        private int age;
        private boolean gender;
        private String houseSno;
        private String street;
        private int building;
        private String email;
        private String phone;
        private int type;
        private String company;
        private double salary;

        EmployeeBuilder() {
        }

        public EmployeeBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public EmployeeBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public EmployeeBuilder age(int age) {
            this.age = age;
            return this;
        }

        public EmployeeBuilder gender(boolean gender) {
            this.gender = gender;
            return this;
        }

        public EmployeeBuilder houseSno(String houseSno) {
            this.houseSno = houseSno;
            return this;
        }

        public EmployeeBuilder street(String street) {
            this.street = street;
            return this;
        }

        public EmployeeBuilder building(int building) {
            this.building = building;
            return this;
        }

        public EmployeeBuilder email(String email) {
            this.email = email;
            return this;
        }

        public EmployeeBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public EmployeeBuilder type(int type) {
            this.type = type;
            return this;
        }

        public EmployeeBuilder company(String company) {
            this.company = company;
            return this;
        }

        public EmployeeBuilder salary(double salary) {
            this.salary = salary;
            return this;
        }

        @Override
        public String toString() {
            return "Employee.EmployeeBuilder(firstName=" + this.firstName + ", lastName=" + this.lastName + ", age=" + this.age + ", gender=" + this.gender + ", houseSno=" + this.houseSno + ", street=" + this.street + ", building=" + this.building + ", email=" + this.email + ", phone=" + this.phone + ", type=" + this.type + ", company=" + this.company + ", salary=" + this.salary + ")";
        }
    }
}
