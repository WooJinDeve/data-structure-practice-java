package com.example.heap;

import java.util.Arrays;
import java.util.Comparator;

public class Heap<E> implements HeapI<E> {
    private static final int DEFAULT_INITIAL_CAPACITY = 11;
    private int lastPosition;
    private E[] array;

    private final Comparator<? super E> comparator;

    public Heap(int capacity, Comparator<? super E> comparator) {
        this.array = (E[]) new Object[capacity];
        this.comparator = comparator;
    }

    public Heap() {
        this(DEFAULT_INITIAL_CAPACITY, null);
    }

    public Heap(Comparator<? super E> comparator) {
        this(DEFAULT_INITIAL_CAPACITY, comparator);
    }

    public Heap(int capacity) {
        this(capacity, null);
    }


    @Override
    public void add(E obj) {
        if (array.length == lastPosition) {
            grow(array.length * 2);
        }

        array[lastPosition] = obj;

        if (comparator == null) {
            trickleUp(lastPosition, obj);
        } else {
            trickleUpComparator(lastPosition, obj, comparator);
        }

        lastPosition++;
    }

    private void grow(int size) {
        if (array.length != 0) {
            int newCapacity = this.array.length * 2;
            this.array = Arrays.copyOf(array, newCapacity);
        } else {
            this.array = (E[]) new Object[Math.max(DEFAULT_INITIAL_CAPACITY, size)];
        }
    }

    private void swap(int from, int to) {
        E tmp = array[from];
        array[from] = array[to];
        array[to] = tmp;
    }

    private void trickleUp(int position, E obj) {
        if (position == 0) {
            return;
        }

        Comparable<? super E> key = (Comparable<? super E>) obj;
        int parent = (position - 1) >>> 1;
        E e = array[parent];

        if (key.compareTo(e) > 0) {
            swap(position, parent);
            trickleUp(parent, e);
        }
    }

    private void trickleUpComparator(int position, E obj, Comparator<? super E> cmp) {
        if (position == 0) {
            return;
        }

        int parent = (position - 1) >>> 1;
        E e = array[parent];

        if (cmp.compare(obj, e) > 0) {
            swap(position, parent);
            trickleUpComparator(parent, e, cmp);
        }
    }

    @Override
    public E remove() {
        E tmp = array[0];
        swap(0, --lastPosition);
        array[lastPosition] = null;
        if (comparator == null) {
            trickleDown(0);
        } else {
            trickleDownComparator(0, comparator);
        }
        return tmp;
    }

    private void trickleDown(int parent) {
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;
        // 마지막에 왼쪽 자식이 클 때
        if (array[left] != null && left == lastPosition &&
                ((Comparable<E>) array[parent]).compareTo(array[left]) < 0) {
            swap(parent, left);
            return;
        }
        // 마지막에 오른쪽 자식이 클 때
        if (array[right] != null && right == lastPosition
                && ((Comparable<E>) array[parent]).compareTo(array[right]) < 0) {
            swap(parent, right);
            return;
        }
        // 범위를 초과할 경우 재귀 종료
        if (left >= lastPosition || right >= lastPosition) {
            return;
        }

        // 오른쪽 자식이 경우 swap
        if (array[right] != null && ((Comparable<E>) array[right]).compareTo(array[left]) > 0 &&
                ((Comparable<E>) array[parent]).compareTo(array[right]) < 0) {
            swap(parent, right);
            trickleDown(right);
        }

        // 왼쪽 자식이 경우 swap
        else if (array[left] != null && ((Comparable<E>) array[parent]).compareTo(array[left]) < 0) {
            swap(parent, left);
            trickleDown(left);
        }
    }

    private void trickleDownComparator(int parent, Comparator<? super E> cmp) {
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;

        if (array[left] != null && left == lastPosition && cmp.compare(array[left], array[parent]) > 0) {
            swap(parent, left);
            return;
        }

        if (array[right] != null && right == lastPosition && cmp.compare(array[left], array[parent]) > 0) {
            swap(parent, right);
            return;
        }

        if (left > lastPosition || right > lastPosition) {
            return;
        }

        if (array[right] != null && cmp.compare(array[right], array[parent]) > 0 &&
                cmp.compare(array[right], array[left]) > 0) {
            swap(parent, right);
            trickleDownComparator(right, cmp);
        } else if ((array[left] != null && cmp.compare(array[left], array[parent]) > 0)) {
            swap(parent, left);
            trickleDownComparator(left, cmp);
        }
    }


    @Override
    public int size() {
        return this.lastPosition;
    }
}

