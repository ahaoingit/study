package com.leetcode.链表;
/**
 * TODO
 *
 * @author ahao 2020-07-03
 */
public class ListNodeUtils {
    public static void printList(ListNode node) {
        while ( node!= null) {
            if (node.next != null) {
                System.out.print(node.val + "->");
            }else {
                System.out.print(node.val);
            }
            node = node.next;
        }
    }

    public static  ListNode reverseListByRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListByRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static ListNode reverseListByIteration(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = null;
        while (head!= null) {
            ListNode nextListNode = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = nextListNode;
        }
        return newHead.next;
    }
    /***.
     *@param head: 头节点
     *@author ahao
     *@date 2020-08-10 10:35
     *@return {@link java.lang.Boolean}
     *判断一个链表是否有环 快慢指针
     */
    public static Boolean judgmentRing(ListNode head) {
        if (head == null || head.next == null ) {
            return false;
        }
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            if (fast == slow) {
                return true;
            }else {
                fast = fast.next.next;
                slow = slow.next;
            }
        }
        return false;
    }
}
