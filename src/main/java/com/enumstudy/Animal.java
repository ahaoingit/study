package com.enumstudy;

import java.util.Hashtable;

/**
 * TODO
 *
 * @author ahao 2020-09-27
 */
public enum Animal implements Info{
    /*

     */
    DOG("dog") {

    },CAT("cat");
    private String name;
    Animal() {}
    Animal(String s) {
        this.name = s;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getInfo() {
        return name;
    }
}
