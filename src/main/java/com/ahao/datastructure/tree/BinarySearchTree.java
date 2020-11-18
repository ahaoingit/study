package com.ahao.datastructure.tree;


import com.ahao.datastructure.printer.BinaryTreeInfo;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Queue;
import java.util.Stack;

/**
 * TODO
 *
 * @author ahao 2020-10-01
 */
public class BinarySearchTree<E> implements BinaryTreeInfo {
    private  int size;
    Node<E> root;
    /**
     *解决比较问题 组合 策略模式
     */
    private Comparator<E> comparator;

    /**
     * who is the root node
     */
    @Override
    public Object root() {
        return root;
    }

    /**
     * how to get the left child of the node
     *
     * @param node
     */
    @Override
    public Object left(Object node) {
        return ((Node<E>)node).left;
    }

    /**
     * how to get the right child of the node
     *
     * @param node
     */
    @Override
    public Object right(Object node) {
        return ((Node<E>)node).right;
    }

    /**
     * how to print the node
     *
     * @param node
     */
    @Override
    public Object string(Object node) {
        Node<E> myNode = (Node<E>)node;
        String parentString = "null";
        if (myNode.parent != null) {
            parentString = myNode.parent.element.toString();
        }
        return myNode.element + "_p(" + parentString + ")";
    }

    private static class Node<E> {
        E element;
        Node<E> left;
        Node<E> right;
        Node<E> parent;

        public Node(E element,Node<E> parent) {
            this.element = element;
            this.parent = parent;
        }

        /**
         * 获取节点的度
         * @return
         */
        public int nodeDegree() {
            int degree = 0;
            if (right != null) {
                degree++;
            }
            if (left != null) {
                degree++;
            }
            return degree;
        }
    }
    //添加一个比较器
    public BinarySearchTree(Comparator comparator) {
        this.comparator = comparator;
    }
    /***.
     *@param element: 
     *@author ahao 
     *@date 2020-10-01 14:37
     *@return 
     *
     */
    public void add(E element) {
        //判断第一个数据
        if (root == null) {
            root = new Node<>(element,null);
            return;
        }

        //从root开始找到需要加入添加位置的父节点
        Node<E> node = root;
        Node<E> parent = root;
        int flag = 0;
        while (node != null) {
            parent = node;
            flag = compared(node.element, element);
            //node大 说明此节点位于node 左边
            if (flag > 0) {
                node = node.left;
            }else if (flag < 0 ) {
                node = node.right;
            }else {
                node = new Node<>(element,node.parent);
            }
        }
        //在父节点左边
        if (flag > 0) {
            parent.left = new Node<>(element,parent);
        }else {
            parent.right = new Node<>(element,parent);
        }
        size++;
    }

    private int compared(E e1 ,E e2) {
        return comparator.compare(e1,e2);
    }

    /**
     * 获取树的节点数
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 前序递归遍历
     */
    public void preTraverse() {
        if (root == null) {
            return;
        }
        preTraverse(root);
    }

    private void preTraverse(Node<E> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.element+" ");
        preTraverse(node.left);
        preTraverse(node.right);
    }

    public void postTraverse() {
        if (root == null) {
            return;
        }
        postTraverse(root);
    }

    private void postTraverse(Node<E> node) {
        if (node == null) {
            return;
        }
        postTraverse(node.left);
        postTraverse(node.right);
        System.out.println(node.element);
    }
    public void levelTraverse() {
        if (root == null) {
            return;
        }
        levelTraverse(root);
    }

    private void levelTraverse(Node<E> node) {
        Queue<Node<E>> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node<E> poll = queue.poll();
            System.out.println(poll.element);
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
    }

    public int height() {
        return height(root);
    }

    public void remove(E element) {
        //获取节点
        Node<E> node = getNode(element);
        if (node == null) {
            return;
        }
        size--;
        //获取节点的度
        int degree = node.nodeDegree();
        //先处理度为2的节点
        if (degree == 2) {
            //获取后继节点
            Node<E> successorNode = successorNode(element);
            node.element = successorNode.element;
            //赋值给node  准备删除
            node = successorNode;
        }
        //统一处理度为0 与 1 的节点
        Node<E> replaceNode = node.left != null ? node.left:node.right;

        if (replaceNode != null) {
            //处理代替节点的parent 指针
            replaceNode.parent = node.parent;
            //处理删除节点父节点的指针
            //说明是 root
            if (node.parent == null) {
                root = replaceNode;
            }else if (node == node.parent.left) {
                node.parent.left = replaceNode;
            }else{
                node.parent.right = replaceNode;
            }
        }else {
            //度为0
            if (node == node.parent.left) {
                node.parent.left = null;
            }else {
                node.parent.right = null;
            }
        }
    }

    public int height(Node<E> node) {
        if (node == null) {
            return 0;
        }
        int height = 0;
        int leverNum = 1;
        Queue<Node<E>> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node<E> poll = queue.poll();
            leverNum --;
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
            if (leverNum == 0) {
                height++;
                leverNum =queue.size();
            }
        }
        return height;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return toString(root,sb,"");
    }

    private String toString(Node<E> node,StringBuilder sb,String prefix) {
        if (node == null) {
            return "";
        }
        toString(node.left,sb,prefix+"{L}");
        sb.append(prefix).append(node.element).append("\n");
        toString(node.right,sb,prefix+"{R}");
        return sb.toString();
    }
    public void flip() {
        flip(root);
    }
    private Node<E> flip(Node<E> node) {
        if (node == null) {
            return null;
        }
        Node<E> tmp = node.left;
        node.left = node.right;
        node.right = tmp;

        flip(node.left);
        flip(node.right);
        return node;
    }
    public E getPredecessor(E element) {
        return predecessorNode(element).element;
    }
    public E getSuccessor(E element) {
        return successorNode(element).element;
    }

    private Node<E> successorNode(E element) {
        Node<E> node = getNode(element);
        if (node == null) {
            return null;
        }
        //后继 右子树的最左边那个元素
        Node<E> successor = node.right;
        if (successor != null) {
            while (successor.left != null) {
                successor = successor.left;
            }
            return successor;
        }
        while (node.parent != null && node != node.parent.left) {
            node = node.parent;
        }
        return node.parent;
    }


    /**
     * 获取前驱节点
     * @param element
     * @return
     */
    private Node<E> predecessorNode(E element) {
        //获取节点
        Node<E> node = getNode(element);
        if (node == null) {
            return null;
        }
        //第一种情况 此节点有 左子树
        Node<E> preNode = node.left;
        if (preNode != null) {
            while (preNode.right != null) {
                preNode = preNode.right;
            }
            return preNode;
        }
        //没有左子树时
        while (node.parent != null && node == node.parent.left) {
         node = node.parent;
        }
        return node.parent;
    }



    /**
     * 获取某一个节点
     * @param element
     * @return
     */
    private  Node<E> getNode(E element) {
        Node<E> node = root;
        while (node != null){
            if (compared(node.element,element) > 0) {
                node = node.left;
            }else if (compared(node.element, element) < 0) {
                node =node.right;
            }else {
                return node;
            }
        }
        return null;
    }
    /**
     * 非递归打印
     * 先序
     * 头 左 右
     */

    public void pre() {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (stack.size()!=0) {
            Node pop = stack.pop();
            System.out.print(pop.element + " ");
            if (pop.right!=null) {
                stack.push(pop.right);
            }
            if (pop.left!=null) {
                stack.push(pop.left);
            }
        }
    }

    /**
     * 后序打印
     * 头 右 左的逆序打印即为 后序 需要两个栈
     */
    public void post() {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Stack<Node> help = new Stack<>();
        stack.push(root);
        while (stack.size() != 0) {
            Node<E> node = stack.pop();
            help.push(node);
            if (node.left != null) {
                stack.push(node.left);
            }
            if (node.right != null) {
                stack.push(node.right);
            }
        }
        while (help.size() != 0) {
            System.out.println(help.pop().element);
        }
    }

    public void in() {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node node = this.root;
        stack.push(node);

        while (!stack.isEmpty()) {
            if (node!=null) {
                stack.push(node);
                node = node.left;
            }else {
                Node pop = stack.pop();
                System.out.print(pop.element +" ");
                node = pop.right;
            }
        }
    }
}
