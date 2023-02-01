package com.example.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    public void addFirst(Object d) {
        Node newNode = new Node(d);
        newNode.next = head;
        head = newNode;
        size++;
        if (head.next == null) {
            tail = head;
        }
    }

    public void addLast(Object d) {
        Node newNode = new Node(d);
        if (size == 0) {
            addFirst(d);
        }else {
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    private Node node(int index) {
        Node x = head;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public void add(int idx, Object d) {
        if (idx == 0) {
            addFirst(d);
            return;
        }
        final Node pre = node(idx - 1);
        final Node next = pre.next;
        final Node newNode = new Node(d);

        pre.next = newNode;
        newNode.next = next;
        size++;

        if (newNode.next == null) {
            tail = newNode;
        }
    }

    public Object remove(int idx){
        if (idx == 0)
            return removeFirst();

        final Node pre = node(idx - 1);
        final Node deleted = pre.next;
        pre.next = deleted.next;

        if (deleted == tail) {
            tail = pre;
        }
        size--;
        return deleted.data;
    }

    public Object removeFirst(){
        Node temp = head;
        head = head.next;
        size--;

        return temp.data;
    }

    public Object removeLast(){
        return remove(size - 1);
    }

    public int size() {
        return this.size;
    }

    public Object get(int idx) {
        final Node node = node(idx);
        return node.data;
    }


    public String toString(){
        if (head == null) {
            return "[]";
        }
        Node temp = head;

        StringBuilder str = new StringBuilder("[");
        while (temp.next != null) {
            str.append(temp).append(", ");
            temp = temp.next;
        }
        str.append(temp.data).append("]");

        return str.toString();
    }
}
