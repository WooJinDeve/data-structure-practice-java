package com.example.queue.linkedlist;

import com.example.queue.QueueI;

import java.util.LinkedList;

public class Queue<E> implements QueueI<E> {

    static class Node<E> {
        private E data;
        private Node<E> next;

        public Node(final E data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<E> head;
    private Node<E> last;
    private int currentSize;

    public Queue() {
        this.head = null;
        this.last = null;
        this.currentSize = 0;
    }

    @Override
    public void add(E obj) {
        Node<E> n = new Node<>(obj);
        if (last == null){
            last = n;
            head = n;
            currentSize++;
            return;
        }

        last.next = n;
        last = n;
        currentSize++;
    }

    @Override
    public void offer(final E obj) {
        add(obj);
    }

    @Override
    public E peek() {
        if (head == null)
            return null;
        return head.data;
    }

    @Override
    public E remove() {
        if (head == null)
            return null;

        final E item = head.data;
        if (head == last) {
            head = null;
            last = null;
            currentSize--;
            return item;
        }

        head = head.next;
        currentSize--;
        return item;
    }

    @Override
    public E poll() {
        return (isEmpty()) ? null : remove();
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    public int size(){
        return currentSize;
    }
}
