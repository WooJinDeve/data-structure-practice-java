package com.example.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {



    @Test
    void addFirst(){
        //given
        LinkedList list = new LinkedList();

        //when & then
        assertEquals(list.size(), 0);
        list.addFirst(1);
        assertEquals(list.size(), 1);
    }

    @Test
    void addLast(){
        //given
        LinkedList list = new LinkedList();

        //when
        list.addLast(1);
        list.addLast(2);

        //then
        assertEquals(list.get(0), 1);
        assertEquals(list.get(1), 2);
    }

    @Test
    void add(){
        //given
        LinkedList list = new LinkedList();

        //when
        list.add(0, 2);
        list.add(0, 1);

        //then
        assertEquals(list.get(0), 1);
        assertEquals(list.get(1), 2);
    }

    @Test
    void add_throw(){
        //given
        LinkedList list = new LinkedList();

        //when & then
        assertThrows(NullPointerException.class, () -> list.add(1, 2));
    }

    @Test
    void remove(){
        //given
        LinkedList list = new LinkedList();
        list.addFirst(1);

        //when
        final Object actual = list.remove(0);

        //then
        assertEquals(list.size(), 0);
        assertEquals(actual, 1);
    }


    @Test
    void remove_throw(){
        //given
        LinkedList list = new LinkedList();

        //when & then
        assertThrows(NullPointerException.class, () -> list.remove(1));
    }

    @Test
    void removeFirst(){
        //given
        LinkedList list = new LinkedList();
        list.addFirst(1);
        list.addFirst(2);

        //when
        final Object actual = list.removeFirst();

        //then
        assertEquals(list.size(), 1);
        assertEquals(actual, 2);
    }


    @Test
    void removeFirst_throw(){
        //given
        LinkedList list = new LinkedList();

        //when & then
        assertThrows(NullPointerException.class, list::removeFirst);
    }

    @Test
    void removeLast(){
        //given
        LinkedList list = new LinkedList();
        list.addFirst(1);
        list.addFirst(2);

        //when
        final Object actual = list.removeLast();

        //then
        assertEquals(list.size(), 1);
        assertEquals(actual, 1);
    }

    @Test
    void removeLast_throw(){
        //given
        LinkedList list = new LinkedList();

        //when & then
        assertThrows(NullPointerException.class, list::removeLast);
    }

    @Test
    void get(){
        //given
        LinkedList list = new LinkedList();
        list.addFirst(1);

        //when
        final Object actual = list.get(0);

        //then
        assertEquals(actual, 1);
    }

    @Test
    void get_throw(){
        //given
        LinkedList list = new LinkedList();

        //when & then
        assertThrows(NullPointerException.class, () -> list.get(0));
    }

    @Test
    void size(){
        //given
        LinkedList list = new LinkedList();

        //when
        final int actual = list.size();

        //then
        assertEquals(actual, 0);
    }
}