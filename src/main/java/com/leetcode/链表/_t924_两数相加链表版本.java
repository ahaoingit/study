package com.leetcode.链表;

import org.junit.Test;

/**
 * TODO
 * https://leetcode-cn.com/problems/add-two-numbers/
 *
 * @author ahao 2020-09-24
 */
public class _t924_两数相加链表版本 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //进位标识
        boolean flag = false;
        //答案链表
        ListNode result = new ListNode(-1);
        ListNode first = result;
        //俩个链表都为null 结束循环
        while (l1 != null || l2 != null) {
            //判断是否有进位
            //有进位时
            if (flag) {
                int l1val = l1!=null?l1.val:0;
                int l2val = l2!=null?l2.val:0;
                result.next =new ListNode (( l1val+l2val+1) % 10);
                //为下次循环设置flag
                flag = l1val + l2val + 1 >= 10;
            }else {
                int l1val = l1!=null?l1.val:0;
                int l2val = l2!=null?l2.val:0;
                result.next =new ListNode (( l1val+l2val) % 10);
                //为下次循环设置flag
                flag = l1val + l2val >= 10;
            }
            l1 = l1==null?null:l1.next;
            l2 = l2==null?null:l2.next;
            result = result.next;
        }
        if (flag) {
            result.next = new ListNode(1);
        }
        return first.next;
    }
    @Test
    public void text() {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        ListNode listNode = addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.print(listNode.val+"->");
            listNode = listNode.next;
        }
    }
}
