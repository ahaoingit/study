package com.leetcode.链表;

import org.junit.Test;

import javax.swing.*;
import java.util.ArrayList;

/**
 * TODO
 *https://leetcode-cn.com/problems/delete-node-in-a-linked-list/
 * @author ahao 2020-06-11
 */
public class _237_删除链表中的节点 {
    public void deleteNode(ListNode node) {

        node.val = node.next.val;
        node.next = node.next.next;
    }
    public void printList(ListNode node) {

         while ( node!= null) {
             System.out.println(node.val);
             node = node.next;
         }
    }
    @Test
    public void test() {
         ListNode one = new ListNode(1);
         ListNode tow = new ListNode(3);
         ListNode three = new ListNode(5);
         ListNode four = new ListNode(2);
         one.next = tow;
         tow.next = three;
         three.next = four;
         deleteNode(tow);
         printList(one);
    }
}
