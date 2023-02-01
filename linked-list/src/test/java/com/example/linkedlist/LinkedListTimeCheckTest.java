package com.example.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class LinkedListTimeCheckTest {

    private static final int SIZE = 10_000_000;

    @Test
    void linked_list_delete_time_check(){
        //given
        final LinkedList list = new LinkedList();
        IntStream.range(1, SIZE + 1)
                .forEach(list::addLast);

        //when & then
        checkTime(() -> list.remove(SIZE / 2));
    }

    @Test
    void java_utils_liked_list_middle_delete_time_check(){
        //given
        java.util.LinkedList<Integer> list = new java.util.LinkedList<>();
        IntStream.range(1, SIZE + 1)
                .forEach(list::add);

        //when & then
        checkTime(() -> list.remove(SIZE / 2));
    }

    @Test
    void array_list_delete_time_check(){
        //given
        final ArrayList<Integer> list = new ArrayList<>();
        IntStream.range(1, SIZE + 1)
                .forEach(list::add);

        //when & then
        checkTime(() -> list.remove(SIZE / 2));
    }

    @Test
    void linked_list_middle_add_time_check(){
        //given
        final LinkedList list = new LinkedList();
        IntStream.range(1, SIZE + 1)
                .forEach(list::addLast);

        //when & then
        checkTime(() -> list.add(SIZE / 2, 0));
    }

    @Test
    void java_utils_liked_list_middle_add_time_check(){
        //given
        java.util.LinkedList<Integer> list = new java.util.LinkedList<>();
        IntStream.range(1, SIZE + 1)
                .forEach(list::add);

        //when & then
        checkTime(() -> list.add(SIZE / 2, 0));
    }

    @Test
    void array_list_middle_add_time_check(){
        //given
        final ArrayList<Integer> list = new ArrayList<>();
        IntStream.range(1, SIZE + 1)
                .forEach(list::add);

        //when & then
        checkTime(() -> list.add(SIZE / 2, 0));
    }


    private void checkTime(Runnable consumer) {
        long before = System.currentTimeMillis();

        consumer.run();

        long after = System.currentTimeMillis();

        System.out.println(after - before);
    }
}
