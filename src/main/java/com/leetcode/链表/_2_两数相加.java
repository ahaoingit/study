package com.leetcode.链表;

import org.junit.Test;

import java.util.LinkedList;

/**
 * TODO
 *https://leetcode-cn.com/problems/add-two-numbers/
 * @author ahao 2020-07-03
 */
public class _2_两数相加 {
    public ListNode solution(ListNode lOne, ListNode lTwo){
        int carry = 0;
        //虚拟头节点
        ListNode dummyHead = new ListNode(0);
        ListNode sum = dummyHead;

        while (lOne != null || lTwo != null || carry == 1){
            if (lOne != null) {
                carry += lOne.val;
                lOne = lOne.next;
            }
            if (lTwo != null) {
                carry += lTwo.val;
                lTwo = lTwo.next;
            }
            sum.next =new ListNode(carry % 10);
            sum = sum.next;
            carry = carry / 10;
        }
        return dummyHead.next;
    }
    @Test
    public void solutionTest() {
        LinkedList linkedList = new LinkedList();
        ListNode n1 = new ListNode(0);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        ListNodeUtils.reverseListByIteration(n1);
        ListNodeUtils.printList(n5);

    }
}
