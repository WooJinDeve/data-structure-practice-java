package com.example.stack.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    void push(){
        //given
        Stack<Integer> item = new Stack<>();

        //when
        item.push(1);
        item.push(2);
        item.push(3);

        //then
        assertEquals(3, item.size());
    }


    @Test
    void pop(){
        //given
        Stack<Integer> item = new Stack<>();
        item.push(1);
        item.push(2);

        //when
        final Integer actual = item.pop();

        //then
        assertAll(() -> {
            assertEquals(1, item.size());
            assertEquals(2, actual);
        });
    }

    @Test
    void emptyPop(){
        //given
        Stack<Integer> item = new Stack<>();

        //when & them
        assertThatThrownBy(item::pop)
                .isInstanceOf(NoSuchElementException.class);
    }


    @Test
    void peek(){
        //given
        Stack<Integer> item = new Stack<>();
        item.push(1);
        item.push(2);

        //when
        final Integer actual = item.peek();

        //then
        assertAll(() -> {
            assertEquals(2, item.size());
            assertEquals(2, actual);
        });
    }

    @Test
    void emptyPeek(){
        //given
        Stack<Integer> item = new Stack<>();

        //when & them
        assertThatThrownBy(item::peek)
                .isInstanceOf(NoSuchElementException.class);
    }

    @Test
    void isEmpty(){
        //given
        Stack<Integer> item = new Stack<>();

        //when & then
        assertAll(() -> {
            assertEquals(0, item.size());
            assertTrue(item.isEmpty());
        });
    }

    @Test
    void IsNotEmpty(){
        //given
        Stack<Integer> item = new Stack<>();
        item.push(1);

        //when & then
        assertAll(() -> {
            assertEquals(1, item.size());
            assertFalse(item.isEmpty());
        });
    }

}