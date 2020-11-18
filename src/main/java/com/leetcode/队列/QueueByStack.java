package com.leetcode.队列;


import java.util.Stack;

/**
 * TODO
 *用栈实现队列
 * @author ahao 2020-09-17
 */
public class QueueByStack<E> {
    private Stack<E> inStack = new Stack<>();
    private Stack<E> outStack = new Stack<>();

    public int size() {
        return inStack.size()+outStack.size();
    }
    public void enQueue(E e) {
        inStack.push(e);
    }
    public E deQueue() {
        if (outStack.isEmpty()){
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.pop();
    }

    public boolean isEmpty() {
        return inStack.isEmpty()&&outStack.isEmpty();
    }

    public static void main(String[] args) {
        QueueByStack<Integer> queueByStack = new QueueByStack<>();

        queueByStack.enQueue(12);
        queueByStack.enQueue(13);
        queueByStack.deQueue();
        queueByStack.enQueue(14);
        queueByStack.enQueue(15);
        queueByStack.enQueue(16);

        while (!queueByStack.isEmpty()) {
            Integer integer = queueByStack.deQueue();
            System.out.println(integer);
        }
    }
}
