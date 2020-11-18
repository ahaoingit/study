package com.studyclass;

import lombok.Data;

import java.time.LocalDate;

/**
 * TODO
 *
 * @author ahao 2020-09-25
 */
@Data
public class Student {
    private String name;
    private Integer age;
    private Address address;
    private int score;

    public String getLevel() {
        if (score > 60) {
            return "合格";
        } else {
            return "不合格";
        }
    }

    public Student(String name, Integer age, int score ,Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.score = score;
    }

    public Student() {
    }
}
