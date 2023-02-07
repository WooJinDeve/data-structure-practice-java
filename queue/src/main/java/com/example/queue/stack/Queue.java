package com.example.queue.stack;

import com.example.queue.QueueI;

import java.util.Stack;

public class Queue<E> implements QueueI<E> {

    private Stack<E> stackNewest;
    private Stack<E> stackOldest;

    public Queue() {
        this.stackNewest = new Stack<>();
        this.stackOldest = new Stack<>();
    }

    @Override
    public void add(final E obj) {
        stackNewest.add(obj);
    }

    @Override
    public void offer(final E obj) {
        add(obj);
    }

    @Override
    public E peek() {
        if (isEmpty())
            return null;
        shiftStacks();
        return stackOldest.peek();
    }

    @Override
    public E remove() {
        if (isEmpty())
            return null;
        shiftStacks();
        return stackOldest.pop();
    }

    @Override
    public E poll() {
        return remove();
    }

    private void shiftStacks(){
        while (!stackNewest.isEmpty()) {
            final E item = stackNewest.pop();
            stackOldest.push(item);
        }
    }

    @Override
    public boolean isEmpty() {
        return stackNewest.isEmpty() && stackOldest.isEmpty();
    }

    public int size(){
        return stackNewest.size() + stackOldest.size();
    }
}
