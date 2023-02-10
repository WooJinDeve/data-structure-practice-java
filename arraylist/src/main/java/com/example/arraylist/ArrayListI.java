package com.example.arraylist;

public interface ArrayListI<E> {
    boolean add(E e);

    E get(int i);

    void remove(int i);

    int size();
}
