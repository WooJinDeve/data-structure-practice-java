package com.example.stack.linkedlist;

public interface StackI<E> {

    E pop();

    void push(E obj);

    E peek();

    boolean isEmpty();

    int size();
}
