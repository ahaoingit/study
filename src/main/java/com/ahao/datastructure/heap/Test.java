package com.ahao.datastructure.heap;


import java.util.Comparator;

/**
 * TODO
 *
 * @author ahao 2020-11-05
 */
public class Test {
    @org.junit.Test
    public void compareTest() throws Exception {
        BinaryHeap<Integer> integerBinaryHeap = new BinaryHeap<>();
        integerBinaryHeap.add(1);
        integerBinaryHeap.add(20);
        integerBinaryHeap.add(40);
//        integerBinaryHeap.add(3);
//        integerBinaryHeap.add(4);
        System.out.println(integerBinaryHeap.remove());
        integerBinaryHeap.print();
    }
}
