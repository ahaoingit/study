package com.ahao.datastructure.heap;
import java.util.Comparator;

/**
 * TODO
 *
 * @author ahao 2020-11-05
 */
public class BinaryHeap<E> implements Heap<E> {
    /**
     * 插入的数据数量
     */
    private int limit;
    /**
     * 用户自定义的比较规则
     */
    private Comparator<E> comparator;
    /**
     * 默认的容量
     */
    private static final Integer DEFAULT_CAPACITY = 16;
    /**
     * 数组
     */
    private E[] elements;
    /**
     * 容量
     */
    private Integer capacity;

    public BinaryHeap() {
        elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    public BinaryHeap(Comparator<E> comparator , Integer capacity){
        this.comparator = comparator;
        this.capacity = capacity;
        elements = (E[])new Object[capacity];
    }

    public BinaryHeap(Comparator<E> comparator) {
        this.comparator = comparator;
        this.elements = (E[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public int size() {
        return limit;
    }

    @Override
    public boolean isEmpty() {
        return limit == 0;
    }

    @Override
    public void clear() {
        limit = 0;
    }

    @Override
    public void add(E element) throws Exception {
        judgeNull(element);
        ensureCapacity(limit + 1);
        heapInert(element,limit++);
    }

    private void heapInert(E element, int i) {
        elements[i] = element;
        //任意 i位置的父节点 为 (i - 1) / 2
        while ( compare(elements[i] , elements[(i-1) / 2] ) > 0){
            swap(elements,i,(i-1) / 2);
            i = (i-1) / 2;
        }
    }

    /**
     * 重新排堆
     * @param elements
     * @param index
     * @param limit
     */
    private void heapify(E[] elements, int index, int limit) {
        int leftChildIndex = index * 2 + 1;
        //在有效区内进行判断
        while (leftChildIndex < limit) {
            //取最大孩子的坐标
            int largest = leftChildIndex + 1 < limit && compare(elements[leftChildIndex],elements[leftChildIndex+1]) < 0
                    ? leftChildIndex+1 : leftChildIndex ;
            //与现在的index 做比较
            largest = compare(elements[index],elements[largest]) > 0 ? index : largest;
            //退出循环
            if (largest == index) {
                break;
            }
            //交换
            swap(elements,index,largest);
            //更新变量
            index = largest;
            leftChildIndex = index * 2 + 1;
        }
    }

    private void swap(E[] elements, int i, int i1) {
        E tmp = elements[i];
        elements[i] = elements[i1];
        elements[i1] = tmp;
    }

    @Override
    public E get() {
        return null;
    }

    /**
     * 移除最大值 保持大根堆状态
     * @return 最大节点
     */
    @Override
    public E remove() throws Exception {
        judgeNull(elements[limit - 1]);
        E maxElement = elements[0];
        //最后一个 与第一个交换 删除最前面的一个 limit--
        swap(elements,0, --limit);
        heapify(elements,0,limit);
        return maxElement;
    }

    @Override
    public E replace(E element) {
        return null;
    }

    public void print() {
        for (int i = 0; i < limit; ++i) {
            System.out.println(elements[i]);
        }
    }
    /**
     * 数据比较
     * @param e1
     * @param e2
     * @return
     */
    private int compare(E e1,E e2) {
        return comparator == null?((Comparable)e1).compareTo(e2) : comparator.compare(e1,e2);
    }

    /**
     *
     * @param nextIndex 下一个要插入的位置索引
     */
    private void ensureCapacity(int nextIndex) {
        int oldArrLength = elements.length;
        if (nextIndex > oldArrLength) {
            //扩1.5倍
            int newArrLength = oldArrLength + (oldArrLength >> 1);
            E[] newArr = (E[]) new Object[newArrLength];
            //数组拷贝
            System.arraycopy(elements,0,newArr,0,oldArrLength);
            //赋值
            elements = newArr;
        }
    }

    /**
     * null值判断
     * @param e
     * @throws Exception
     */
    private void judgeNull(E e) throws Exception {
        if (e == null) {
            throw new Exception("不能插入空值");
        }
    }



}
