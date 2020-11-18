package com.test;

import java.util.PriorityQueue;

/**
 * TODO
 *
 * @author ahao 2020-09-24
 */
public class Msg implements Info {
    String content;
    @Override
    public void info() {
        System.out.println("msg");
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public static void main(String[] args) {
    }

    @Override
    public String toString() {
        return "Msg{" +
                "content='" + content + '\'' +
                '}';
    }
}
