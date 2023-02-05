package com.example.linkedlist2;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class LinkedList<E> implements ListI<E> {
    private static class Node<E> {
        E data;
        Node<E> next;

        public Node(E obj) {
            data = obj;
            next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int currentSize;

    public LinkedList() {
        head = null;
        tail = null;
        currentSize = 0;
    }

    @Override
    public void addFirst(final E obj) {
        Node<E> node = new Node<>(obj); // 1
        node.next = head;
        head = node;
        currentSize++;
        if (head.next == null) {
            tail = head;
        }
    }

    @Override
    public void addLast(E obj) {
        Node<E> node = new Node<E>(obj);
        if (head == null) {
            head = tail = node;
            currentSize++;
            return;
        }
        tail.next = node;
        tail = node;
        currentSize++;
    }


    @Override
    public E removeFirst() {
        if (head == null)
            return null;

        E tmp = head.data;

        if (head == tail)
            head = tail = null;
	    else
            head = head.next;
        currentSize--;

        return tmp;
    }

    @Override
    public E removeLast() {
        if (head == null)
            return null;

        if (head == tail)
            return removeFirst();

        Node<E> current = head;
        Node<E> previous = null;
        while (current != tail) {
            previous = current;
            current = current.next;
        }
        previous.next = null;
        tail = previous;
        currentSize--;
        return current.data;
    }

    @Override
    public boolean contains(E obj){
        Node<E> current = head;
        while(current != null) {
            if (obj.equals(current.data))
                return true;
            current = current.next;
        }
        return false;
    }

    @Override
    public E remove(E obj){
        Node<E> current = head;
        Node<E> previous = null;

        while(current != null) {
            if (obj.equals(current.data)) {
                if (current==head) // 노드가 1개 or 첫 번째 노드 제거
                    return removeFirst();
                if (current==tail) // 마지막 노드 제거
                    return removeLast();
                currentSize--;
                previous.next=current.next; // 2. remove
                return current.data;
            }
            previous = current;
            current = current.next;
        }
        return null;
    }


    @Override
    public E peekFirst() {
        if (head == null)
            return null;
        return head.data;
    }

    @Override
    public E peekLast() {
        if (tail == null)
            return null;
        return tail.data;
    }

    @Override
    public int size() {
        return currentSize;
    }

    @Override
    public Iterator<E> iterator(){
        return new IteratorHelper();
    }

    private class IteratorHelper implements Iterator<E> {
        Node<E> index;
		public IteratorHelper(){
            index = head;
        }

        @Override
        public boolean hasNext(){
            return (index != null);
        }

        @Override
        public E next(){
            if (!hasNext())
                throw new NoSuchElementException();
            E val = index.data;
            index = index.next;
            return val;
        }
    }
}
