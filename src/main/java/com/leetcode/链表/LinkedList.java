package com.leetcode.链表;


import java.util.Vector;

/**
 * TODO
 *
 * @author ahao 2020-09-02
 */
public class LinkedList<E> {
    /**
     * 链表大小
     */
    private int size;

    /**
     * 链表first节点
     * @param <E>
     */
    Node<E> first;

    /**
     * 链表最后一个节点
     * @param <E>
     */
    Node<E> last;

    public LinkedList() {

    }

    private class Node<E>{
        E e;
        Node<E> next;
        Node<E> pre;

        public Node(E e, Node<E> next, Node<E> pre) {
            this.e = e;
            this.next = next;
            this.pre = pre;
        }
    }

}
