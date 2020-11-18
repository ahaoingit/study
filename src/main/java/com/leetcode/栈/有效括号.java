package com.leetcode.栈;

import org.junit.Test;

import java.util.Stack;

/**
 * TODO
 *
 * @author ahao 2020-09-17
 */
public class 有效括号 {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == '{' || aChar == '[' || aChar =='(') {
                stack.push(aChar);
                continue;
            }
            if (!stack.isEmpty()) {
                boolean flag = (aChar == '}' && stack.peek() == '{')||(aChar == ']' && stack.peek() == '[')||(aChar == ')' && stack.peek() == '(');
                if (flag) {
                    stack.pop();
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
        return stack.isEmpty();
    }
    @Test
    public void test() {
        boolean valid = isValid("])");
        System.out.println(valid);
    }
}
