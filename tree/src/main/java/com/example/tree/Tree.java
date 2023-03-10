package com.example.tree;

import java.util.TreeMap;

public class Tree<E> implements TreeI<E>{

    static class Node<E> {
        private E data;
        private Node <E> left, right;
        public Node(E obj) {
            this.data = obj;
            left=right=null;
        }
    }

    private Node<E> root;
    private int currentSize = 0;


    private void add(E obj, Node<E> node) {
        if (((Comparable<E>) obj).compareTo(node.data) >= 0){
            if(node.right == null) {
                node.right = new Node<>(obj);
                return;
            }
            add(obj, node.right);
            return;
        }

        if(node.left == null) {
            node.left = new Node<>(obj);
            return;
        }
        add(obj, node.left);
    }

    @Override
    public void add(E obj) {
        if (root==null)
            root = new Node<>(obj);
        else
            add(obj, root);
        currentSize++;
    }

    private boolean contains(E obj, Node<E> node) {
        if (node==null)
            return false;

        if (((Comparable<E>) obj).compareTo(node.data) == 0)
            return true;

        return ((Comparable<E>) obj).compareTo(node.data) > 0 ?
                contains(obj, node.right) : contains(obj, node.left);
    }

    @Override
    public boolean contains(E obj) {
        return contains(obj, root);
    }

    @Override
    public int size() {
        return currentSize;
    }

    private Node<E> rightRotate(Node<E> node){
        Node<E> tmp = node.right;
        node.right = tmp.left;
        tmp.left = node;
        return tmp;
    }

    private Node<E> leftRotate (Node<E> node){
        Node<E> tmp = node.left;
        node.left = tmp.right;
        tmp.right = node;
        return tmp;
    }

    private Node<E> rightLeftRotate(Node<E> node){
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    private Node<E> leftRightRotate(Node<E> node){
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }
}
