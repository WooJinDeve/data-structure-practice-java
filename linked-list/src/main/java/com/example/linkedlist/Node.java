package com.example.linkedlist;

public class Node {

    public Object data;
    public Node next;

    public Node(final Object data) {
        this.data = data;
        this.next = null;
    }

    public String toString(){
        return String.valueOf(this.data);
    }
}
