package com.example.heap;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import java.util.Comparator;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HeapTest {

    @Test
    void construct(){
        assertThatCode(() -> new Heap<Integer>()).doesNotThrowAnyException();
        assertThatCode(() -> new Heap<>(10)).doesNotThrowAnyException();
        assertThatCode(() -> new Heap<Integer>((o1, o2) -> o2 - o1)).doesNotThrowAnyException();
        assertThatCode(() -> new Heap<Integer>(10, (o1, o2) -> o2 - o1)).doesNotThrowAnyException();
    }

    @Test
    void add() {
        //given
        HeapI<Integer> heap = new Heap<>();

        //when
        heap.add(1);
        heap.add(2);
        heap.add(3);

        Assertions.assertAll(() ->{
            assertThat(heap.size()).isEqualTo(3);
            assertThat(heap.remove()).isEqualTo(3);
        });
    }

    @Test
    void add_reversed() {
        //given
        HeapI<Integer> heap = new Heap<>(Comparator.reverseOrder());

        //when
        heap.add(1);
        heap.add(2);
        heap.add(3);

        Assertions.assertAll(() ->{
            assertThat(heap.size()).isEqualTo(3);
            assertThat(heap.remove()).isEqualTo(1);
        });
    }

    @Test
    void remove() {
        //given
        HeapI<Integer> heap = new Heap<>();
        heap.add(1);
        heap.add(2);
        heap.add(3);

        //when & then
        Assertions.assertAll(() ->{
            assertThat(heap.size()).isEqualTo(3);
            assertThat(heap.remove()).isEqualTo(3);
            assertThat(heap.remove()).isEqualTo(2);
            assertThat(heap.remove()).isEqualTo(1);
            assertThat(heap.size()).isEqualTo(0);
        });
    }

    @Test
    void remove_reversed() {
        //given
        HeapI<Integer> heap = new Heap<>(Comparator.reverseOrder());
        heap.add(1);
        heap.add(2);
        heap.add(3);

        //when & then
        Assertions.assertAll(() ->{
            assertThat(heap.size()).isEqualTo(3);
            assertThat(heap.remove()).isEqualTo(1);
            assertThat(heap.remove()).isEqualTo(2);
            assertThat(heap.remove()).isEqualTo(3);
            assertThat(heap.size()).isEqualTo(0);
        });
    }

    @Test
    void grow(){
        //given
        Heap<Object> heap = new Heap<>(1);

        //given
        assertThatCode(() -> IntStream.range(0, 20).forEach(heap::add))
                .doesNotThrowAnyException();
    }
}