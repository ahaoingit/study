package com.ahao.datastructure.tree;
import java.util.Comparator;

/**
 * TODO
 *接口
 *int size
 *boolean isEmpty
 *void clear
 *void add(E element)
 *void remove(E element)
 *boolean contain(E element)
 *@author ahao 2020-10-01
 */
public class Tree {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>((Comparator<Integer>) (o1, o2) -> o1 - o2);
        binarySearchTree.add(4);
        binarySearchTree.add(1);
        binarySearchTree.add(3);
        binarySearchTree.add(6);
        binarySearchTree.add(7);
        binarySearchTree.add(5);
        binarySearchTree.add(2);
        System.out.println();
        binarySearchTree.in();
    }
}
