package com.leetcode.链表;

import java.util.Stack;

/**
 * TODO
 *1 - 2 - 3 - 2 -1
 *
 * @author ahao 2020-11-18
 */
public class _回文链表 {
    public static void main(String[] args) {
        ListNode one = new ListNode(1);
        ListNode tow = new ListNode(3);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(2);
        one.next = tow;
        tow.next = three;
        three.next = four;
        Stack<ListNode> stack = new Stack<>();
        //进栈输出做对比
         ListNode tmp = one;
         while (one != null) {
             stack.push(one);
             one = one.next;
         }
        one = tmp;
         while (!stack.isEmpty()) {
             if (stack.pop().val != one.val) {
                 System.out.println("不是回文");
                 return;
             }
             one = one.next;
         }

         System.out.println("是回文");
         one = tmp;
    }
}
