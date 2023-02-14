package com.example.hash;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HashTest {

    @Test
    void add(){
        //given
        HashI<Integer, Integer> hash = new Hash<>();

        //when
        hash.add(1, 2);
        hash.add(3, 2);
        hash.add(4, 1);

        //then
        assertThat(hash.size()).isEqualTo(3);
    }

    @Test
    void addDuplicateKey(){
        //given
        HashI<Integer, Integer> hash = new Hash<>();

        //when
        hash.add(1, 2);
        hash.add(1, 3);

        //then
        assertThat(hash.size()).isEqualTo(2);
        assertThat(hash.get(1)).isEqualTo(2);
    }


    @Test
    void addReSizing(){
        //given
        HashI<Integer, Integer> hash = new Hash<>(1);

        //when
        hash.add(1, 2);
        hash.add(2, 3);
        hash.add(3, 4);
        hash.add(4, 4);
        hash.add(5, 4);

        //then
        assertThat(hash.size()).isEqualTo(5);
    }


    @Test
    void remove(){
        //given
        HashI<Integer, Integer> hash = new Hash<>();
        hash.add(1, 2);

        //when
        hash.remove(1, 2);

        //then
        assertAll(() -> {
            assertThat(hash.size()).isEqualTo(0);
            assertThat(hash.get(1)).isNull();
        });
    }

    @Test
    void removeDuplicateHash(){
        //given
        HashI<Integer, Integer> hash = new Hash<>();
        hash.add(1, 2);
        hash.add(1, 2);

        //when
        hash.remove(1, 2);

        //then
        assertAll(() -> {
            assertThat(hash.size()).isEqualTo(1);
            assertThat(hash.get(1)).isEqualTo(2);
        });
    }
}