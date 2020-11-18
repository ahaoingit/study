package com.ahao.datastructure.heap;

/**
 * TODO
 *
 * @author ahao 2020-11-01
 */
public interface Heap<E> {
    int size();	// 元素的数量
    boolean isEmpty();	// 是否为空
    void clear();	// 清空
    void add(E element) throws Exception;	 // 添加元素
    E get();	// 获得堆顶元素
    E remove() throws Exception; // 删除堆顶元素
    E replace(E element); // 删除堆顶元素的同时插入一个新元素
}
 