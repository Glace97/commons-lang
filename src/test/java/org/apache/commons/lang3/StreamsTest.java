package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;


import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.mockito.internal.util.Supplier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {

    @Test
    void testAllMatch1() {
        Streams streams = new Streams();
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        Streams.FailableStream<Integer> failableStream = new Streams.FailableStream<>(integerStream);
        boolean result = failableStream.allMatch(x -> x > 0);
        assertTrue(result);
    }

    @Test
    void testAllMatch4() {
        Streams streams = new Streams();
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        Streams.FailableStream<Integer> failableStream = new Streams.FailableStream<>(integerStream);
        boolean result = failableStream.anyMatch(x -> x > 2);
        assertTrue(result);
    }

    @Test
    void testCollect() {
        Streams streams = new Streams();
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        Streams.FailableStream<Integer> failableStream = new Streams.FailableStream<>(integerStream);
        Integer[] result = failableStream.collect(new Streams.ArrayCollector<>(Integer.class));
        assertArrayEquals(new Integer[]{1, 2, 3}, result);
    }

    @Test
    void testFilter() {
        Streams streams = new Streams();
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        Streams.FailableStream<Integer> failableStream = new Streams.FailableStream<>(integerStream);
        Streams.FailableStream<Integer> filteredStream = failableStream.filter(x -> x > 1);
        assertEquals(2, filteredStream.stream().count());
    }

    @Test
    void testForEach1() {
        Streams streams = new Streams();
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        Streams.FailableStream<Integer> failableStream = new Streams.FailableStream<>(integerStream);
        failableStream.forEach(x -> System.out.println(x));
        // Manual inspection of console output
    }

    @Test
    void testMap2() {
        Streams streams = new Streams();
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        Streams.FailableStream<Integer> failableStream = new Streams.FailableStream<>(integerStream);
        Streams.FailableStream<String> mappedStream = failableStream.map(x -> String.valueOf(x));
        assertEquals(3, mappedStream.stream().count());
    }

    @Test
    void testReduce3() {
        Streams streams = new Streams();
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        Streams.FailableStream<Integer> failableStream = new Streams.FailableStream<>(integerStream);
        Integer result = failableStream.reduce(0, Integer::sum);
        assertEquals(6, result);
    }


    @Test
    void testAllMatch6() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        Streams.FailableStream<String> stream = Streams.stream(strings);

        // Test if any string contains the letter 'b'
        boolean result = stream.anyMatch(s -> s.contains("b"));

        Assertions.assertTrue(result);
    }

    @Test
    void testCollect2() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        Streams.FailableStream<String> stream = Streams.stream(strings);

        // Collect the strings into a new list
        List<String> result = stream.collect(Collectors.toList());

        Assertions.assertEquals(strings, result);
    }

    @Test
    void testFilter3() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        Streams.FailableStream<String> stream = Streams.stream(strings);

        // Filter out strings that start with 'a'
        Streams.FailableStream<String> filteredStream = stream.filter(s -> !s.startsWith("a"));

        List<String> result = filteredStream.collect(Collectors.toList());

        List<String> expected = Arrays.asList("banana", "cherry");
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testForEach3() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        Streams.FailableStream<String> stream = Streams.stream(strings);

        // Print each string
        List<String> result = new ArrayList<>();
        stream.forEach(result::add);

        Assertions.assertEquals(strings, result);
    }

    @Test
    void testMap() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        Streams.FailableStream<String> stream = Streams.stream(strings);

        // Map each string to its length
        Streams.FailableStream<Integer> mappedStream = stream.map(String::length);

        List<Integer> result = mappedStream.collect(Collectors.toList());

        List<Integer> expected = Arrays.asList(5, 6, 6);
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testReduce() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Streams.FailableStream<Integer> stream = Streams.stream(numbers);

        // Calculate the sum of the numbers
        int sum = stream.reduce(0, Integer::sum);

        Assertions.assertEquals(15, sum);
    }

    @Test
    void testStream() {
        List<String> strings = Arrays.asList("apple", "banana", "cherry");
        Stream<String> stream = strings.stream();

        Streams.FailableStream<String> failableStream = Streams.stream(stream);

        List<String> result = failableStream.collect(Collectors.toList());

        Assertions.assertEquals(strings, result);
    }


    @Test
    void testArrayCollector2() {
        org.apache.commons.lang3.stream.Streams.ArrayCollector<Integer> collector = new org.apache.commons.lang3.stream.Streams.ArrayCollector<>(Integer.class);
        assertNotNull(collector.accumulator());
        assertNotNull(collector.characteristics());
        assertNotNull(collector.combiner());
        assertNotNull(collector.finisher());
        assertNotNull(collector.supplier());
    }


    @Test
    void testFilter_emptyStream() {
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Stream.empty());
        Streams.FailableStream<Integer> filteredStream = stream.filter(x -> x % 2 == 0);
        assertTrue(filteredStream.stream().count() == 0);
    }

    @Test
    void testFilter_noMatch() {
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Stream.of(1, 3, 5, 7, 9));
        Streams.FailableStream<Integer> filteredStream = stream.filter(x -> x % 2 == 0);
        assertTrue(filteredStream.stream().count() == 0);
    }

    @Test
    void testFilter_allMatch() {
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Stream.of(2, 4, 6, 8, 10));
        Streams.FailableStream<Integer> filteredStream = stream.filter(x -> x % 2 == 0);
        assertTrue(filteredStream.stream().count() == 5);
    }

    @Test
    void testFilter_someMatch() {
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Stream.of(1, 2, 3, 4, 5));
        Streams.FailableStream<Integer> filteredStream = stream.filter(x -> x % 2 == 0);
        assertTrue(filteredStream.stream().count() == 2);
    }


}