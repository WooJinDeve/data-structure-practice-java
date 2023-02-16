package com.example.heap;

public interface HeapI<E> {

    void add(E obj);

    int size();

    E remove();
}
