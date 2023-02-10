package com.example.arraylist;

import java.util.Arrays;
import java.util.Objects;

public class ArrayList<E> implements ArrayListI<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int size;

    public ArrayList() {
        this.size = 0;
        this.data = new Object[this.size];
    }

    @Override
    public boolean add(E obj) {
        add(obj, data, size);
        this.size++;
        return true;
    }

    private void add(E obj, Object[] data, int size) {
        if (data.length == size) {
            this.data = doubling(size + 1);
        }
        this.data[size] = obj;
    }

    private Object[] doubling(int size) {
        if (data.length != 0) {
            int newCapacity = this.data.length * 2;
            return Arrays.copyOf(data, newCapacity);
        } else {
            return new Object[Math.max(DEFAULT_CAPACITY, size)];
        }
    }

    @Override
    public E get(int i) {
        Objects.checkIndex(i, size);
        return (E) this.data[i];
    }

    @Override
    public void remove(int i) {
        Objects.checkIndex(i, size);
        for (int x = i; x < size - 1; x++) {
            data[x] = data[x + 1];
        }
        size--;
    }

    public int size() {
        return size;
    }
}
