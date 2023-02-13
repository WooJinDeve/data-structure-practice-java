package com.example.hash;

import java.util.LinkedList;

public class Hash<K, V> implements HashI<K, V> {
    private static class HashElement<K, V> implements Comparable<HashElement<K, V>> {
        private K key;
        private V value;

        public HashElement(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(HashElement<K, V> h) {
            return (((Comparable<K>) h.key).compareTo(this.key));
        }
    }

    private int numElements;
    private int tableSize;
    private double maxLoadFactor;
    private LinkedList<HashElement<K, V>>[] hashArray;

    public Hash(int tableSize) {
        this.tableSize = tableSize;
        this.maxLoadFactor = 0.75;
        this.numElements = 0;
        this.hashArray = new LinkedList[tableSize];
        for (int i = 0; i < tableSize; i++) {
            hashArray[i] = new LinkedList<>();
        }
    }
}