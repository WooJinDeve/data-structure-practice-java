package com.example.tree;


public interface TreeI<E> {

    void add(E obj);

    boolean contains(E obj);

    int size();
}
