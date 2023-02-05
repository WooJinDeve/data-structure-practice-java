package com.example.linkedlist2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void addFirst(){
        //given
        ListI<Integer> list = new LinkedList<>();

        //when
        list.addFirst(1);
        list.addFirst(2);

        //then
        assertEquals(2, list.size());
    }

    @Test
    void addFirst_null(){
        //given
        ListI<Integer> list = new LinkedList<>();

        //when
        list.addFirst(null);
        list.addFirst(null);

        //then
        assertEquals(2, list.size());
    }

    @Test
    void addLast(){
        //given
        ListI<Integer> list = new LinkedList<>();

        //when
        list.addLast(1);
        list.addLast(2);

        //then
        assertEquals(2, list.size());
    }

    @Test
    void addLast_null(){
        //given
        ListI<Integer> list = new LinkedList<>();

        //when
        list.addLast(null);
        list.addLast(null);

        //then
        assertEquals(2, list.size());
    }

    @Test
    void removeFirst(){
        //given
        ListI<Integer> list = new LinkedList<>();
        list.addLast(1);

        //when
        final Integer actual = list.removeFirst();

        //then
        assertEquals(0, list.size());
        assertEquals(1, actual);
    }

    @Test
    void emptyRemoveFirst(){
        //given
        ListI<Integer> list = new LinkedList<>();

        //when
        final Integer actual = list.removeFirst();

        //then
        assertEquals(0, list.size());
        assertNull(actual);
    }

    @Test
    void removeLast(){
        //given
        ListI<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);

        //when
        final Integer actual = list.removeLast();

        //then
        assertEquals(1, list.size());
        assertEquals(2, actual);
    }

    @Test
    void listSizeIsOne_removeLastSameRemoveFirst(){
        //given
        ListI<Integer> list = new LinkedList<>();
        list.addLast(1);

        //when
        final Integer actual = list.removeLast();

        //then
        assertEquals(0, list.size());
        assertEquals(1, actual);
    }

    @Test
    void emptyRemoveLast(){
        //given
        ListI<Integer> list = new LinkedList<>();

        //when
        final Integer actual = list.removeFirst();

        //then
        assertEquals(0, list.size());
        assertNull(actual);
    }

    @Test
    void contain(){
        //given
        ListI<Integer> list = new LinkedList<>();
        list.addFirst(1);

        //when & then
        assertTrue(list.contains(1));
    }

    @Test
    void emptyListIsContainNotNull(){
        //given
        ListI<Integer> list = new LinkedList<>();

        //when & then
        assertFalse(list.contains(null));
    }

    @Test
    void remove(){
        //given
        ListI<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);

        //when
        final Integer actual = list.remove(2);

        //then
        Assertions.assertAll(() -> {
            assertEquals(list.size(), 2);
            assertEquals(2, actual);
        });
    }

    @Test
    void emptyRemove() {
        //given
        ListI<Integer> list = new LinkedList<>();

        //when
        final Integer actual = list.remove(2);

        //then
        Assertions.assertAll(() -> {
            assertEquals(list.size(), 0);
            assertNull(actual);
        });
    }


    @Test
    void peekFirst(){
        //given
        ListI<Integer> list = new LinkedList<>();
        list.addFirst(1);

        //when
        final Integer actual = list.peekFirst();

        //then
        Assertions.assertAll(() -> {
            assertEquals(list.size(), 1);
            assertEquals(1, actual);
        });
    }

    @Test
    void emptyPeekFirst(){
        //given
        ListI<Integer> list = new LinkedList<>();

        //when
        final Integer actual = list.peekFirst();

        //then
        Assertions.assertAll(() -> {
            assertEquals(list.size(), 0);
            assertNull(actual);
        });
    }

    @Test
    void peekLast(){
        //given
        ListI<Integer> list = new LinkedList<>();
        list.addFirst(1);
        list.addFirst(2);

        //when
        final Integer actual = list.peekLast();

        //then
        Assertions.assertAll(() -> {
            assertEquals(list.size(), 2);
            assertEquals(1, actual);
        });
    }

    @Test
    void emptyPeekLast(){
        //given
        ListI<Integer> list = new LinkedList<>();

        //when
        final Integer actual = list.peekLast();

        //then
        Assertions.assertAll(() -> {
            assertEquals(list.size(), 0);
            assertNull(actual);
        });
    }
}