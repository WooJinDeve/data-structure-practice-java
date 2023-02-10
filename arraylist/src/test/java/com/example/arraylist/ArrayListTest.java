package com.example.arraylist;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.IntStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ArrayListTest {

    @Test
    void add(){
        //given
        ArrayListI<Integer> list = new ArrayList<>();

        //when
        boolean actual = list.add(1);

        //then
        assertAll(() -> {
            assertTrue(actual);
            assertEquals(1, list.size());
        });
    }

    @Test
    void add_10000_element(){
        //given
        ArrayListI<Integer> list = new ArrayList<>();

        //when
        IntStream.range(0, 100_000)
                .forEach(list::add);

        //then
        assertEquals(list.size(), 100_000);
    }

    @Test
    void get(){
        //given
        ArrayListI<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        //when
        Integer actual = list.get(2);


        //then
        assertAll(() -> {
            assertEquals(3, actual);
            assertEquals(3, list.size());
        });
    }

    @Test
    void getIndexOutOfLange(){
        //given
        ArrayListI<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        //when && then
        assertThatCode(() -> list.get(3))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void remove(){
        //given
        ArrayListI<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        //when
        list.remove(0);
        list.remove(1);


        //then
        assertAll(() -> {
            assertEquals(1, list.size());
            assertEquals(2, list.get(0));
        });
    }

    @Test
    void getRemoveOutOfRange(){
        //given
        ArrayListI<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        //when && then
        assertThatCode(() -> list.remove(3))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }
}