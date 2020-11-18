package com.leetcode.链表;

import org.junit.Test;

/**
 * TODO
 *
 * @author ahao 2020-08-10
 */
public class ListTest {

    @Test
    public void test() {
        ListNode one = new ListNode(1);
        ListNode tow = new ListNode(3);
        ListNode three = new ListNode(5);
        ListNode four = new ListNode(2);
        one.next = tow;
        tow.next = three;
        three.next = four;
        four.next = one;
        System.out.println(ListNodeUtils.judgmentRing(one));
        int a = 0111_111;
        System.out.println(a);
        int i = Math.floorMod(-5, 2);
        System.out.println(Byte.MAX_VALUE);
        System.out.println(-5 % 2);
    }
}
