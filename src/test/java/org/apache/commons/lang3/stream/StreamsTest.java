package org.apache.commons.lang3.stream;

import static javax.management.Query.times;
import static org.easymock.EasyMock.mock;
import static org.easymock.EasyMock.verify;
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


import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableFunction;
import org.apache.commons.lang3.function.FailablePredicate;
import org.junit.jupiter.api.*;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsTest {

    @Test
    @DisplayName("Test accumulator")
    void testAccumulator() {
        Streams.ArrayCollector<Integer> collector = new Streams.ArrayCollector<>(Integer.class);
        List<Integer> list = new ArrayList<>();
        collector.accumulator().accept(list, 1);
        collector.accumulator().accept(list, 2);
        collector.accumulator().accept(list, 3);
        assertEquals(Arrays.asList(1, 2, 3), list);
    }

    @Test
    @DisplayName("Test characteristics")
    void testCharacteristics1() {
        Streams.ArrayCollector<Integer> collector = new Streams.ArrayCollector<>(Integer.class);
        assertTrue(collector.characteristics().isEmpty());
    }

    //@Test
    @DisplayName("Test combiner")
    void testCombiner() {
        Streams.ArrayCollector<Integer> collector = new Streams.ArrayCollector<>(Integer.class);
        List<Integer> left = Arrays.asList(1, 2, 3);
        List<Integer> right = Arrays.asList(4, 5, 6);
        List<Integer> result = collector.combiner().apply(left, right);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5, 6), result);
    }

    @Test
    @DisplayName("Test finisher")
    void testFinisher() {
        Streams.ArrayCollector<Integer> collector = new Streams.ArrayCollector<>(Integer.class);
        List<Integer> list = Arrays.asList(1, 2, 3);
        Integer[] result = collector.finisher().apply(list);
        assertArrayEquals(new Integer[]{1, 2, 3}, result);
    }

    @Test
    @DisplayName("Test supplier")
    void testSupplier() {
        Streams.ArrayCollector<Integer> collector = new Streams.ArrayCollector<>(Integer.class);
        List<Integer> result = collector.supplier().get();
        assertTrue(result.isEmpty());
    }


    @Test
    @DisplayName("Test allMatch")
    void testAllMatch1() {
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Arrays.stream(new Integer[]{1, 2, 3}));
        boolean result = stream.allMatch((Integer i) -> i > 0);
        assertTrue(result);
    }

    @Test
    @DisplayName("Test anyMatch")
    void testAnyMatch2() {
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Arrays.stream(new Integer[]{1, 2, 3}));
        boolean result = stream.anyMatch((Integer i) -> i > 2);
        assertTrue(result);
    }

    @Test
    @DisplayName("Test collect with Collector")
    void testCollectWithCollector() {
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Arrays.stream(new Integer[]{1, 2, 3}));
        List<Integer> result = stream.collect(Collectors.toList());
        assertEquals(Arrays.asList(1, 2, 3), result);
    }

    @Test
    @DisplayName("Test collect with supplier, accumulator, combiner")
    void testCollectWithSupplierAccumulatorCombiner() {
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Arrays.stream(new Integer[]{1, 2, 3}));
        List<Integer> result = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        assertEquals(Arrays.asList(1, 2, 3), result);
    }

    @Test
    @DisplayName("Test filter")
    void testFilter1() {
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Arrays.stream(new Integer[]{1, 2, 3}));
        Streams.FailableStream<Integer> result = stream.filter((Integer i) -> i > 1);
        assertEquals(Arrays.asList(2, 3), result.collect(Collectors.toList()));
    }

    @Test
    @DisplayName("Test forEach")
    void testForEach1() {
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Arrays.stream(new Integer[]{1, 2, 3}));
        List<Integer> result = new ArrayList<>();
        stream.forEach(result::add);
        assertEquals(Arrays.asList(1, 2, 3), result);
    }

    @Test
    @DisplayName("Test map")
    void testMap1() {
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Arrays.stream(new Integer[]{1, 2, 3}));
        Streams.FailableStream<String> result = stream.map((Integer i) -> String.valueOf(i));
        assertEquals(Arrays.asList("1", "2", "3"), result.collect(Collectors.toList()));
    }

    @Test
    @DisplayName("Test reduce")
    void testReduce1() {
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Arrays.stream(new Integer[]{1, 2, 3}));
        Integer result = stream.reduce(0, (a, b) -> a + b);
        assertEquals(6, result);
    }

    @Test
    @DisplayName("Test stream")
    void testStream1() {
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Arrays.stream(new Integer[]{1, 2, 3}));
        assertEquals(Arrays.asList(1, 2, 3), stream.stream().collect(Collectors.toList()));
    }

    @Test
    void testReduce_emptyStream() {
        List<Integer> numbers = new ArrayList<>();
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(numbers.stream());
        Integer result = stream.reduce(0, Integer::sum);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testReduce_singleElement() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(numbers.stream());
        Integer result = stream.reduce(0, Integer::sum);
        Assertions.assertEquals(5, result);
    }

    @Test
    void testReduce_multipleElements() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(numbers.stream());
        Integer result = stream.reduce(0, Integer::sum);
        Assertions.assertEquals(6, result);
    }

    @Test
    void testAllMatch_emptyStream() {
        List<Integer> numbers = new ArrayList<>();
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(numbers.stream());
        boolean result = stream.allMatch(x -> x > 0);
        Assertions.assertTrue(result);
    }

    @Test
    void testAllMatch_allMatch() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(numbers.stream());
        boolean result = stream.allMatch(x -> x > 0);
        Assertions.assertTrue(result);
    }

    @Test
    void testAllMatch_notAllMatch() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(-2);
        numbers.add(3);
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(numbers.stream());
        boolean result = stream.allMatch(x -> x > 0);
        Assertions.assertFalse(result);
    }

    @Test
    void testAnyMatch_emptyStream() {
        List<Integer> numbers = new ArrayList<>();
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(numbers.stream());
        boolean result = stream.anyMatch(x -> x > 0);
        Assertions.assertFalse(result);
    }

    @Test
    void testAnyMatch_anyMatch() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(-2);
        numbers.add(3);
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(numbers.stream());
        boolean result = stream.anyMatch(x -> x > 0);
        Assertions.assertTrue(result);
    }

    @Test
    void testAnyMatch_noMatch() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(-1);
        numbers.add(-2);
        numbers.add(-3);
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(numbers.stream());
        boolean result = stream.anyMatch(x -> x > 0);
        Assertions.assertFalse(result);
    }

    @Test
    void testFilter_emptyStream() {
        List<Integer> numbers = new ArrayList<>();
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(numbers.stream());
        Streams.FailableStream<Integer> filteredStream = stream.filter(x -> x > 0);
        List<Integer> result = filteredStream.collect(Collectors.toList());
        Assertions.assertEquals(0, result.size());
    }

    @Test
    void testFilter_filterOut() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(-2);
        numbers.add(3);
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(numbers.stream());
        Streams.FailableStream<Integer> filteredStream = stream.filter(x -> x > 0);
        List<Integer> result = filteredStream.collect(Collectors.toList());
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(1, result.get(0));
        Assertions.assertEquals(3, result.get(1));
    }

    @Test
    void testFilter_filterAll() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(numbers.stream());
        Streams.FailableStream<Integer> filteredStream = stream.filter(x -> x > 0);
        List<Integer> result = filteredStream.collect(Collectors.toList());
        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals(1, result.get(0));
        Assertions.assertEquals(2, result.get(1));
        Assertions.assertEquals(3, result.get(2));
    }

    @Test
    void testMap_emptyStream() {
        List<Integer> numbers = new ArrayList<>();
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(numbers.stream());
        Streams.FailableStream<String> mappedStream = stream.map(x -> String.valueOf(x));
        List<String> result = mappedStream.collect(Collectors.toList());
        Assertions.assertEquals(0, result.size());
    }

    @Test
    void testMap_mapElements() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(numbers.stream());
        Streams.FailableStream<String> mappedStream = stream.map(x -> String.valueOf(x));
        List<String> result = mappedStream.collect(Collectors.toList());
        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals("1", result.get(0));
        Assertions.assertEquals("2", result.get(1));
        Assertions.assertEquals("3", result.get(2));
    }

    @Test
    void testForEach_emptyStream() {
        List<Integer> numbers = new ArrayList<>();
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(numbers.stream());
        List<Integer> result = new ArrayList<>();
        stream.forEach(result::add);
        Assertions.assertEquals(0, result.size());
    }

    @Test
    void testForEach_processElements() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(numbers.stream());
        List<Integer> result = new ArrayList<>();
        stream.forEach(result::add);
        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals(1, result.get(0));
        Assertions.assertEquals(2, result.get(1));
        Assertions.assertEquals(3, result.get(2));
    }

    @Test
    void testCollect_emptyStream() {
        List<Integer> numbers = new ArrayList<>();
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(numbers.stream());
        List<Integer> result = stream.collect(Collectors.toList());
        Assertions.assertEquals(0, result.size());
    }

    @Test
    void testCollect_collectElements() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(numbers.stream());
        List<Integer> result = stream.collect(Collectors.toList());
        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals(1, result.get(0));
        Assertions.assertEquals(2, result.get(1));
        Assertions.assertEquals(3, result.get(2));
    }

    // Your Java code here

    @Test
    void testAllMatch2() {
       Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Stream.of(1, 2, 3, 4, 5));
        boolean result = stream.allMatch(x -> x > 0);
        assertTrue(result);

        stream = new Streams.FailableStream<>(Stream.of(1, 2, 3, 4, 5));
        result = stream.allMatch(x -> x > 5);
        assertFalse(result);

        stream = new Streams.FailableStream<>(Stream.empty());
        result = stream.allMatch(x -> x > 0);
        assertTrue(result);
    }

    @Test
    void testAnyMatch() {
       Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Stream.of(1, 2, 3, 4, 5));
        boolean result = stream.anyMatch(x -> x > 3);
        assertTrue(result);

        stream = new Streams.FailableStream<>(Stream.of(1, 2, 3, 4, 5));
        result = stream.anyMatch(x -> x > 5);
        assertFalse(result);

        stream = new Streams.FailableStream<>(Stream.empty());
        result = stream.anyMatch(x -> x > 0);
        assertFalse(result);
    }

    @Test
    void testCollect2() {
       Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Stream.of(1, 2, 3, 4, 5));
        Integer[] result = stream.collect(new Streams.ArrayCollector<>(Integer.class));
        assertArrayEquals(new Integer[]{1, 2, 3, 4, 5}, result);

        stream = new Streams.FailableStream<>(Stream.empty());
        result = stream.collect(new Streams.ArrayCollector<>(Integer.class));
        assertArrayEquals(new Integer[0], result);
    }

    @Test
    void testFilter2() {
       Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Stream.of(1, 2, 3, 4, 5));
       Streams.FailableStream<Integer> filteredStream = stream.filter(x -> x % 2 == 0);
        Integer[] result = filteredStream.collect(new Streams.ArrayCollector<>(Integer.class));
        assertArrayEquals(new Integer[]{2, 4}, result);
    }

    @Test
    void testForEach2() {
       Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Stream.of(1, 2, 3, 4, 5));
        List<Integer> result = new ArrayList<>();
        stream.forEach(result::add);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), result);
    }

    @Test
    void testMap3() {
       Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Stream.of(1, 2, 3, 4, 5));
        Streams.FailableStream<String> mappedStream = stream.map(x -> "Number " + x);
        String[] result = mappedStream.collect(new Streams.ArrayCollector<>(String.class));
        assertArrayEquals(new String[]{"Number 1", "Number 2", "Number 3", "Number 4", "Number 5"}, result);
    }

    @Test
    void testReduce3() {
       Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Stream.of(1, 2, 3, 4, 5));
        Integer result = stream.reduce(0, Integer::sum);
        assertEquals(15, result);

        stream = new Streams.FailableStream<>(Stream.empty());
        result = stream.reduce(0, Integer::sum);
        assertEquals(0, result);
    }


    @Test
    void testMakeTerminated() {
        // Test code here
    }

    @Test
    void testAllMatch3() {
        // Test code here
    }

    @Test
    void testAnyMatch3() {
        // Test code here
    }

    @Test
    void testCollect3() {
        // Test code here
    }

    @Test
    void testCollectWithSupplierAndAccumulator() {
        // Test code here
    }

    @Test
    void testFilter3() {
        // Test code here
    }

    @Test
    void testForEach3() {
        // Test code here
    }

    @Test
    void testMap2() {
        // Test code here
    }

    @Test
    void testReduce2() {
        // Test code here
    }

    @Test
    void testStream() {
        // Test code here
    }


    @Test
    @DisplayName("returns true when the stream contains one element that matches the predicate")
    void returnsTrueWhenStreamContainsOneMatchingElement() {
        // Given
        FailablePredicate<Integer, ?> predicate = i -> i > 5;
       Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Stream.of(1, 2, 3, 6, 7));

        // When
        boolean result = stream.anyMatch(predicate);

        // Then
        assertTrue(result);
    }

    @Test
    @DisplayName("returns true when the stream contains multiple elements that match the predicate")
    void returnsTrueWhenStreamContainsMultipleMatchingElements() {
        // Given
        FailablePredicate<Integer, ?> predicate = i -> i % 2 == 0;
       Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Stream.of(1, 2, 3, 4, 5, 6));

        // When
        boolean result = stream.anyMatch(predicate);

        // Then
        assertTrue(result);
    }

    @Test
    @DisplayName("returns false when the stream does not contain any element that matches the predicate")
    void returnsFalseWhenStreamDoesNotContainMatchingElement() {
        // Given
        FailablePredicate<Integer, ?> predicate = i -> i > 10;
       Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Stream.of(1, 2, 3, 4, 5));

        // When
        boolean result = stream.anyMatch(predicate);

        // Then
        assertFalse(result);
    }

    @Test
    @DisplayName("returns false when the stream is empty")
    void returnsFalseWhenStreamIsEmpty() {
        // Given
        FailablePredicate<Integer, ?> predicate = i -> i > 5;
       Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Stream.empty());

        // When
        boolean result = stream.anyMatch(predicate);

        // Then
        assertFalse(result);
    }

    @Test
    @DisplayName("throws an exception if the stream is already terminated")
    void throwsExceptionIfStreamIsAlreadyTerminated() {
        // Given
        FailablePredicate<Integer, ?> predicate = i -> i > 5;
       Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Stream.of(1, 2, 3));
        stream.anyMatch(i -> true); // Terminate the stream

        // When
        assertThrows(IllegalStateException.class, () -> stream.anyMatch(predicate));
    }


    @Test
    void testArrayCollector() {
        Streams.ArrayCollector<Integer> arrayCollector = new Streams.ArrayCollector<>(Integer.class);

        Assertions.assertNotNull(arrayCollector.accumulator());
        Assertions.assertNotNull(arrayCollector.characteristics());
        Assertions.assertNotNull(arrayCollector.combiner());
        Assertions.assertNotNull(arrayCollector.finisher());
        Assertions.assertNotNull(arrayCollector.supplier());
    }


    private final String[] testArray = {"apple", "banana", "cherry"};
    private final List<String> testList = Arrays.asList(testArray);
    private final Enumeration<String> testEnumeration = Collections.enumeration(testList);



    @Test
    void testCollect4() {
        Streams.FailableStream<String> stream = Streams.failableStream(testList.stream());
        List<String> result = stream.collect(Collectors.toList());
        assertEquals(testList, result);
    }

    @Test
    void testForEach4() {
        Streams.FailableStream<String> stream = Streams.failableStream(testList.stream());
        List<String> resultList = new ArrayList<>();
        stream.forEach(resultList::add);
        assertEquals(testList, resultList);
    }

    @Test
    void testMap4() {
        Streams.FailableStream<String> stream = Streams.failableStream(testList.stream());
        List<Integer> lengths = stream.map(String::length).collect(Collectors.toList());
        List<Integer> expectedLengths = Arrays.asList(5, 6, 6);
        assertEquals(expectedLengths, lengths);
    }

    @Test
    void testReduce4() {
        Streams.FailableStream<String> stream = Streams.failableStream(testList.stream());
        String reduced = stream.reduce("", (a, b) -> a.concat(b));
        String expectedReduced = "applebananacherry";
        assertEquals(expectedReduced, reduced);
    }


    @Test
    void testOfCollection_shouldReturnStreamFromCollection() {
        // Arrange
        Collection<String> collection = Arrays.asList("a", "b", "c");

        // Act
        Stream<String> stream = Streams.of(collection);

        // Assert
        assertEquals(Arrays.asList("a", "b", "c"), stream.collect(Collectors.toList()));
    }

    @Test
    void testOfCollection_withNullCollection_shouldReturnEmptyStream() {
        // Act
        Stream<String> stream = Streams.of((Collection<String>) null);

        // Assert
        assertTrue(stream.collect(Collectors.toList()).isEmpty());
    }

    @Test
    void testOfEnumeration_shouldReturnStreamFromEnumeration() {
        // Arrange
        Enumeration<String> enumeration = Collections.enumeration(Arrays.asList("a", "b", "c"));

        // Act
        Stream<String> stream = Streams.of(enumeration);

        // Assert
        assertEquals(Arrays.asList("a", "b", "c"), stream.collect(Collectors.toList()));
    }

    @Test
    void testOfIterable_shouldReturnStreamFromIterable() {
        // Arrange
        Iterable<String> iterable = Arrays.asList("a", "b", "c");

        // Act
        Stream<String> stream = Streams.of(iterable);

        // Assert
        assertEquals(Arrays.asList("a", "b", "c"), stream.collect(Collectors.toList()));
    }

    @Test
    void testOfIterable_withNullIterable_shouldReturnEmptyStream() {
        // Act
        Stream<String> stream = Streams.of((Iterable<String>) null);

        // Assert
        assertTrue(stream.collect(Collectors.toList()).isEmpty());
    }

    @Test
    void testOfIterator_shouldReturnStreamFromIterator() {
        // Arrange
        Iterator<String> iterator = Arrays.asList("a", "b", "c").iterator();

        // Act
        Stream<String> stream = Streams.of(iterator);

        // Assert
        assertEquals(Arrays.asList("a", "b", "c"), stream.collect(Collectors.toList()));
    }

    @Test
    void testOfIterator_withNullIterator_shouldReturnEmptyStream() {
        // Act
        Stream<String> stream = Streams.of((Iterator<String>) null);

        // Assert
        assertTrue(stream.collect(Collectors.toList()).isEmpty());
    }

    @Test
    void testOfArray_shouldReturnStreamFromArray() {
        // Arrange
        String[] array = {"a", "b", "c"};

        // Act
        Stream<String> stream = Streams.of(array);

        // Assert
        assertEquals(Arrays.asList("a", "b", "c"), stream.collect(Collectors.toList()));
    }

    @Test
    void testOfArray_withNullArray_shouldReturnEmptyStream() {
        // Act
        Stream<String> stream = Streams.of((String[]) null);

        // Assert
        assertTrue(stream.collect(Collectors.toList()).isEmpty());
    }

    @Test
    void testAllMatch_shouldReturnTrueIfAllElementsMatchPredicate() {
        // Arrange
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);

        // Act
        boolean result = new Streams.FailableStream<>(stream).allMatch(x -> x > 0);

        // Assert
        assertTrue(result);
    }

    @Test
    void testAllMatch_shouldReturnFalseIfNotAllElementsMatchPredicate() {
        // Arrange
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);

        // Act
        boolean result = new Streams.FailableStream<>(stream).allMatch(x -> x > 3);

        // Assert
        assertFalse(result);
    }

    @Test
    void testAnyMatch_shouldReturnTrueIfAnyElementMatchesPredicate() {
        // Arrange
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);

        // Act
        boolean result = new Streams.FailableStream<>(stream).anyMatch(x -> x > 3);

        // Assert
        assertTrue(result);
    }

    @Test
    void testAnyMatch_shouldReturnFalseIfNoElementMatchesPredicate() {
        // Arrange
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);

        // Act
        boolean result = new Streams.FailableStream<>(stream).anyMatch(x -> x > 5);

        // Assert
        assertFalse(result);
    }

    @Test
    void testCollect_shouldReturnResultOfCollector() {
        // Arrange
        Stream<String> stream = Stream.of("a", "b", "c");
        Collector<String, ?, List<String>> collector = Collectors.toList();

        // Act
        List<String> result = new Streams.FailableStream<>(stream).collect(collector);

        // Assert
        assertEquals(Arrays.asList("a", "b", "c"), result);
    }

    @Test
    void testCollect_withSupplierAccumulatorAndCombiner_shouldReturnResultOfCollector() {
        // Arrange
        Stream<String> stream = Stream.of("a", "b", "c");
        Supplier<List<String>> supplier = ArrayList::new;
        BiConsumer<List<String>, String> accumulator = List::add;
        BiConsumer<List<String>, List<String>> combiner = List::addAll;

        // Act
        List<String> result = new Streams.FailableStream<>(stream).collect(supplier, accumulator, combiner);

        // Assert
        assertEquals(Arrays.asList("a", "b", "c"), result);
    }

    @Test
    void testFilter_shouldReturnStreamWithFilteredElements() {
        // Arrange
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);

        // Act
        List<Integer> result = new Streams.FailableStream<>(stream).filter(x -> x > 2).collect(Collectors.toList());

        // Assert
        assertEquals(Arrays.asList(3, 4, 5), result);
    }


    @Test
    void testMap_shouldReturnStreamWithMappedElements() {
        // Arrange
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);

        // Act
        List<String> result = new Streams.FailableStream<>(stream).map(x -> String.valueOf(x)).collect(Collectors.toList());

        // Assert
        assertEquals(Arrays.asList("1", "2", "3", "4", "5"), result);
    }

    @Test
    void testReduce_shouldReturnReducedValue() {
        // Arrange
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        BinaryOperator<Integer> accumulator = (x, y) -> x + y;

        // Act
        int result = new Streams.FailableStream<>(stream).reduce(0, accumulator);

        // Assert
        assertEquals(15, result);
    }

    @Test
    void testStream_shouldReturnStreamFromFailableStream() {
        // Arrange
        Stream<String> stream = Stream.of("a", "b", "c");
        Streams.FailableStream<String> failableStream = new Streams.FailableStream<>(stream);

        // Act
        Stream<String> result = failableStream.stream();

        // Assert
        assertEquals(Arrays.asList("a", "b", "c"), result.collect(Collectors.toList()));
    }

    @Test
    void testAssertNotTerminated_shouldNotThrowExceptionIfStreamNotTerminated() {
        // Arrange
        Streams.FailableStream<String> failableStream = new Streams.FailableStream<>(Stream.of("a", "b", "c"));

        // Act
        assertDoesNotThrow(() -> failableStream.assertNotTerminated());
    }

    @Test
    void testAssertNotTerminated_shouldThrowExceptionIfStreamTerminated() {
        // Arrange
        Streams.FailableStream<String> failableStream = new Streams.FailableStream<>(Stream.of("a", "b", "c"));
        failableStream.makeTerminated();

        // Assert
        assertThrows(IllegalStateException.class, () -> failableStream.assertNotTerminated());
    }


    @Test
    void testMakeTerminated_shouldThrowExceptionIfStreamAlreadyTerminated() {
        // Arrange
        Streams.FailableStream<String> failableStream = new Streams.FailableStream<>(Stream.of("a", "b", "c"));
        failableStream.makeTerminated();

        // Assert
        assertThrows(IllegalStateException.class, failableStream::makeTerminated);
    }


    @Test
    void testNonNullWithNullArray() {
        Stream<String> stream = Streams.nonNull((String[]) null);
        assertEquals(0, stream.count());
    }

    @Test
    void testNonNullWithEmptyArray() {
        Stream<String> stream = Streams.nonNull(new String[0]);
        assertEquals(0, stream.count());
    }

    @Test
    void testNonNullWithNonNullArray() {
        String[] array = {"a", "b", "c"};
        Stream<String> stream = Streams.nonNull(array);
        assertEquals(array.length, stream.count());
    }

    @Test
    void testNonNullWithNullStream() {
        Stream<String> input = null;
        Stream<String> stream = Streams.nonNull(input);
        assertEquals(0, stream.count());
    }

    @Test
    void testNonNullWithEmptyStream() {
        Stream<String> input = Stream.empty();
        Stream<String> stream = Streams.nonNull(input);
        assertEquals(0, stream.count());
    }

    @Test
    void testNonNullWithNonNullStream() {
        Stream<String> input = Stream.of("a", "b", "c");
        Stream<String> stream = Streams.nonNull(input);
        assertEquals(3, stream.count());
    }


    @Test
    @DisplayName("Test finisher with empty list")
    void testFinisherWithEmptyList() {
        // Test code here
    }

    @Test
    @DisplayName("Test finisher with non-empty list")
    void testFinisherWithNonEmptyList() {
        // Test code here
    }

    @Test
    @DisplayName("Test finisher with null element type")
    void testFinisherWithNullElementType() {
        // Test code here
    }


}