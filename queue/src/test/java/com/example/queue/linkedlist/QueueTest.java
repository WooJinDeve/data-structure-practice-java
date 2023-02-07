package com.example.queue.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    void add(){
        //given
        Queue<Integer> queue = new Queue<>();

        //when
        queue.add(1);
        queue.add(2);
        queue.add(3);

        //then
        assertAll(() -> {
            assertEquals(3, queue.size());
            assertFalse(queue.isEmpty());
        });
    }

    @Test
    void addCouldIsNull() {
        //given
        Queue<Integer> queue = new Queue<>();

        //when
        queue.add(null);

        //then
        assertAll(() -> {
            assertEquals(1, queue.size());
            assertFalse(queue.isEmpty());
        });
    }

    @Test
    void offer(){
        //given
        Queue<Integer> queue = new Queue<>();

        //when
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        //then
        assertAll(() -> {
            assertEquals(3, queue.size());
            assertFalse(queue.isEmpty());
        });
    }

    @Test
    void offerCouldIsNull() {
        //given
        Queue<Integer> queue = new Queue<>();

        //when
        queue.offer(null);

        //then
        assertAll(() -> {
            assertEquals(1, queue.size());
            assertFalse(queue.isEmpty());
        });
    }

    @Test
    void peek() {
        //given
        Queue<Integer> queue = new Queue<>();
        queue.add(1);

        //when
        final Integer actual = queue.peek();

        //then
        assertAll(() -> {
            assertEquals(1, actual);
            assertEquals(1, queue.size());
            assertFalse(queue.isEmpty());
        });
    }

    @Test
    void peekIsNullWhereEmptyQueue() {
        //given
        Queue<Integer> queue = new Queue<>();

        //when
        final Integer actual = queue.peek();

        //then
        assertAll(() -> {
            assertNull(actual);
            assertEquals(0, queue.size());
            assertTrue(queue.isEmpty());
        });
    }

    @Test
    void peekIsNull() {
        //given
        Queue<Integer> queue = new Queue<>();
        queue.add(null);

        //when
        final Integer actual = queue.peek();

        //then
        assertAll(() -> {
            assertNull(actual);
            assertEquals(1, queue.size());
            assertFalse(queue.isEmpty());
        });
    }

    @Test
    void remove(){
        //given
        Queue<Integer> queue = new Queue<>();
        queue.add(1);

        //when
        final Integer actual = queue.remove();

        //then
        assertAll(() -> {
            assertEquals(1, actual);
            assertEquals(0, queue.size());
            assertTrue(queue.isEmpty());
        });
    }

    @Test
    void remove2(){
        //given
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);

        //when
        final Integer actual = queue.remove();

        //then
        assertAll(() -> {
            assertEquals(1, actual);
            assertEquals(1, queue.size());
            assertFalse(queue.isEmpty());
        });
    }

    @Test
    void removeIsNullWhereEmptyQueue() {
        //given
        Queue<Integer> queue = new Queue<>();

        //when
        final Integer actual = queue.remove();

        //then
        assertAll(() -> {
            assertNull(actual);
            assertEquals(0, queue.size());
            assertTrue(queue.isEmpty());
        });
    }

    @Test
    void removeIsNull() {
        //given
        Queue<Integer> queue = new Queue<>();
        queue.add(null);

        //when
        final Integer actual = queue.remove();

        //then
        assertAll(() -> {
            assertNull(actual);
            assertEquals(0, queue.size());
            assertTrue(queue.isEmpty());
        });
    }

    @Test
    void poll(){
        //given
        Queue<Integer> queue = new Queue<>();
        queue.add(1);

        //when
        final Integer actual = queue.poll();

        //then
        assertAll(() -> {
            assertEquals(1, actual);
            assertEquals(0, queue.size());
            assertTrue(queue.isEmpty());
        });
    }

    @Test
    void poll2(){
        //given
        Queue<Integer> queue = new Queue<>();
        queue.add(1);
        queue.add(2);

        //when
        final Integer actual = queue.poll();

        //then
        assertAll(() -> {
            assertEquals(1, actual);
            assertEquals(1, queue.size());
            assertFalse(queue.isEmpty());
        });
    }

    @Test
    void pollIsNullWhereEmptyQueue() {
        //given
        Queue<Integer> queue = new Queue<>();

        //when
        final Integer actual = queue.poll();

        //then
        assertAll(() -> {
            assertNull(actual);
            assertEquals(0, queue.size());
            assertTrue(queue.isEmpty());
        });
    }

    @Test
    void pollIsNull() {
        //given
        Queue<Integer> queue = new Queue<>();
        queue.add(null);

        //when
        final Integer actual = queue.poll();

        //then
        assertAll(() -> {
            assertNull(actual);
            assertEquals(0, queue.size());
            assertTrue(queue.isEmpty());
        });
    }
}