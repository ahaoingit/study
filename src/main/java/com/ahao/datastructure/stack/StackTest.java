package com.ahao.datastructure.stack;

import java.util.Stack;

/**
 * TODO
 *
 * @author ahao 2020-09-17
 */
public class StackTest {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(23);
        stack.push(25);
        stack.push(26);
        stack.push(27);
        stack.push(28);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
