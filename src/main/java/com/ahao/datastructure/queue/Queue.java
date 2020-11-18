package com.ahao.datastructure.queue;

import java.util.LinkedList;

/**
 * TODO
 *
 * @author ahao 2020-09-17
 */
public class Queue<E>{
    private LinkedList<E> linkedList = new LinkedList<>();
    public int size() {
        return linkedList.size();
    }
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public void enQueue(E e) {
        linkedList.add(e);
    }

    public E deQueue() {
        return linkedList.remove(0);
    }

    public E front() {
        return linkedList.get(0);
    }

}
