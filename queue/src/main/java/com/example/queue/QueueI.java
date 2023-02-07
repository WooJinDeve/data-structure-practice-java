package com.example.queue;

public interface QueueI<E> {

    void add(E obj);
    void offer(E obj);
    E peek();
    E remove();
    E poll();
    boolean isEmpty();
}
