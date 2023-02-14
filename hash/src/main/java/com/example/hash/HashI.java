package com.example.hash;

public interface HashI<K, V> {

    boolean add(K key, V value);

    boolean remove(K key, V value);

    V get(K key);
    int size();
}
