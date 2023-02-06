package com.example.stack.linkedlist;

import java.util.NoSuchElementException;

public class Stack<E> implements StackI<E> {

    static class Node<E>{
        private final E data;
        private Node<E> next;

        public Node(final E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> top;
    private int currentSize;

    public Stack() {
        this.top = null;
        this.currentSize = 0;
    }

    @Override
    public E pop() {
        if (isEmpty())
            throw new NoSuchElementException();

        E item = top.data;
        top = top.next;
        currentSize--;
        return item;
    }

    @Override
    public void push(final E obj) {
        Node<E> n = new Node<>(obj);
        n.next = top;
        top = n;
        currentSize++;
    }

    @Override
    public E peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return top.data;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int size() {
        return currentSize;
    }
}
