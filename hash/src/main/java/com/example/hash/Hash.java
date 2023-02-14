package com.example.hash;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

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

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof HashElement<?, ?> that)) {
                return false;
            }
            return Objects.equals(key, that.key) && Objects.equals(value, that.value);
        }
    }

    private final int DEFAULT_TABLE_SIZE = 20;
    private int numElements;
    private int tableSize;
    private double maxLoadFactor;
    private LinkedList<HashElement<K, V>>[] hashArray;

    public Hash() {
        this.tableSize = DEFAULT_TABLE_SIZE;
        this.maxLoadFactor = 0.75;
        this.numElements = 0;
        this.hashArray = new LinkedList[tableSize];
        for (int i = 0; i < tableSize; i++) {
            hashArray[i] = new LinkedList<>();
        }
    }

    public Hash(int tableSize) {
        if (tableSize < 1)
            tableSize = 1;
        this.tableSize = tableSize;
        this.maxLoadFactor = 0.75;
        this.numElements = 0;
        this.hashArray = new LinkedList[tableSize];
        for (int i = 0; i < tableSize; i++) {
            hashArray[i] = new LinkedList<>();
        }
    }

    @Override
    public boolean add(K key, V value) {
        if (loadFactor() > maxLoadFactor) {
            resize(tableSize * 2);
        }

        int hash = hashCode(key);
        hashArray[hash].add(new HashElement(key, value));
        numElements++;
        return true;
    }

    private float loadFactor(){
        float v = (float) numElements / tableSize;
        return v;
    }

    @Override
    public boolean remove(K key, V value) {
        int hash = hashCode(key);

        HashElement<K, V> hashElement = new HashElement<>(key, value);
        hashArray[hash].remove(hashElement);
        numElements--;
        return true;
    }

    private void resize(int newSize) {
        // new ChainHash
        LinkedList<HashElement<K, V>>[] new_array = new LinkedList[newSize];
        for (int i = 0; i < newSize; i++) {
            new_array[i] = new LinkedList<>();
        }

        // ReHashing
        for (K key : keyIterator()) {
            V val = get(key);

            HashElement<K, V> he = new HashElement<>(key, val);
            int hashVal = hashCode(key, newSize);
            new_array[hashVal].add(he);
        }

        hashArray = new_array;
        tableSize = newSize;
    }


    @Override
    public V get(K key){
        int hash = hashCode(key);

        for (HashElement<K, V> he : hashArray[hash]){
            if (((Comparable<K>)key).compareTo(he.key) == 0){
                return he.value;
            }
        }
        return null;
    }

    private int hashCode(K key){
        int hash = key.hashCode();
        hash = hash & 0x7FFFFFFF;
        return hash % tableSize;
    }

    private int hashCode(K key, int tableSize){
        int hash = key.hashCode();
        hash = hash & 0x7FFFFFFF;
        return hash % tableSize;
    }

    @Override
    public int size() {
        return numElements;
    }

    private K[] keyIterator(){
        return new IteratorHelper<K>().keys;
    }

    class IteratorHelper<T> implements Iterator<T> {
        private T[] keys;
        private int position;
        public IteratorHelper(){
            keys = (T[]) new Object[numElements];
            int p=0;
            for (int i=0; i<tableSize; i++) {
                LinkedList<HashElement<K, V>> hashElements = hashArray[i];
                for (HashElement<K, V> hashElement : hashElements)
                    keys[p++] = (T) hashElement.key;
            }
            position=0;
        }
        @Override
        public boolean hasNext(){
            return position < keys.length;
        }

        @Override
        public T next() {
            if (!hasNext())
                return null;
            return keys[position++];
        }
    }
}