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

//    private Streams<String> stream;
//    @BeforeEach
//    void setUp() {
//        List<String> list = Arrays.asList("apple", "banana", "cherry");
//        stream = new Streams(list.stream());
//    }
//    @Test
//    void testForEach() {
//        List<Integer> result = new ArrayList<>();
//        stream.forEach(result::add);
//        assertEquals(list, result);
//    }
//
//    @Test
//    void testForEach_emptyStream() {
//        List<Integer> emptyList = new ArrayList<>();
//        Streams emptyStream = new Streams(emptyList.stream());
//        List<Integer> result = new ArrayList<>();
//        emptyStream.forEach(result::add);
//        assertEquals(emptyList, result);
//    }
//
//    @Test
//    void testForEach_multipleActions() {
//        List<Integer> result = new ArrayList<>();
//        stream.forEach(result::add);
//        stream.forEach(result::add);
//        assertEquals(list.size() * 2, result.size());
//    }
//
//    @Test
//    void testForEach_terminatedStream() {
//        stream.collect(Collectors.toList());
//        assertThrows(IllegalStateException.class, () -> stream.forEach(System.out::println));
//    }
//
//    @Test
//    void testCollectToList() {
//        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
//        List<Integer> result = numberStream()
//                .collect(Collectors.toList());
//        assertEquals(expected, result);
//    }
//
//    @Test
//    void testCollectToSet() {
//        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
//        List<Integer> result = numberStream()
//                .collect(Collectors.toSet())
//                .stream()
//                .sorted()
//                .collect(Collectors.toList());
//        assertEquals(expected, result);
//    }
//
//    @Test
//    void testCollectToCustomList() {
//        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
//        List<Integer> result = numberStream()
//                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
//        assertEquals(expected, result);
//    }
//
//    @Test
//    void testCollectorCharacteristics(Streams.Characteristics characteristic) {
//        Collector<Integer, ?, ?> collector = Collectors.toList();
//        boolean hasCharacteristic = collector.characteristics().contains(characteristic);
//        assertEquals(hasCharacteristic, characteristic.test(collector));
//    }
//
//    @Test
//    void testCollectWithCustomCollector() {
//        Integer[] expected = {1, 2, 3, 4, 5};
//        Integer[] result = numberStream()
//                .collect(new Streams.ArrayCollector<>(Integer.class));
//        assertEquals(expected, result);
//    }
//
//    @Test
//    void testCollectWithCustomCollectorAndSupplier() {
//        Integer[] expected = {1, 2, 3, 4, 5};
//        Integer[] result = numberStream()
//                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll)
//                .toArray(new Integer[0]);
//        assertEquals(expected, result);
//    }
//
//    @Test
//    void testCollectWithEmptyStream() {
//        List<Integer> expected = new ArrayList<>();
//        List<Integer> result = emptyStringStream()
//                .collect(Collectors.toList());
//        assertEquals(expected, result);
//    }
//
//    @Test
//    void testCollectWithParallelStream() {
//        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
//        List<Integer> result = numberStream()
//                .parallel()
//                .collect(Collectors.toList());
//        assertEquals(expected, result);
//    }
//
//    @Test
//    void testCollectWithParallelStreamAndUnorderedCollector() {
//        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);
//        List<Integer> result = numberStream()
//                .parallel()
//                .unordered()
//                .collect(Collectors.toList());
//        assertEquals(expected, result);
//    }
//
//    @Test
//    void testToArray() {
//        List<String> inputList = Arrays.asList("a", "b", "c");
//        String[] expectedArray = {"a", "b", "c"};
//
//        // Test toArray() with List type
//        String[] result1 = Streams.toArray(String.class).collect(inputList.stream());
//        assertArrayEquals(expectedArray, result1);
//
//        // Test toArray() with Stream type
//        String[] result2 = inputList.stream().collect(Streams.toArray(String.class));
//        assertArrayEquals(expectedArray, result2);
//
//        // Test toArray() with empty list
//        List<String> emptyList = new ArrayList<>();
//        String[] result3 = Streams.toArray(String.class).collect(emptyList.stream());
//        assertEquals(0, result3.length);
//
//        // Test toArray() with list containing null value
//        List<String> listWithNull = Arrays.asList("a", null, "c");
//        String[] expectedArrayWithNull = {"a", null, "c"};
//        String[] result4 = Streams.toArray(String.class).collect(listWithNull.stream());
//        assertArrayEquals(expectedArrayWithNull, result4);
//    }
//
//    @Test
//    public void testReduceWithEmptyList() {
//        List<Integer> numbers = new ArrayList<>();
//        Integer result = Streams.reduce(numbers, 0, Integer::sum);
//        assertEquals(0, result);
//    }
//
//    @Test
//    public void testReduceWithSingleElement() {
//        List<Integer> numbers = List.of(5);
//        Integer result = Streams.reduce(numbers, 0, Integer::sum);
//        assertEquals(5, result);
//    }
//
//    @Test
//    public void testReduceWithMultipleElements() {
//        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
//        Integer result = Streams.reduce(numbers, 0, Integer::sum);
//        assertEquals(15, result);
//    }
//    // Your Java code here
//
//
//    @Test
//    void testAssertNotTerminated_NotTerminated() {
//        Streams streams = new Streams();
//        assertDoesNotThrow(() -> streams.assertNotTerminated());
//    }
//
//    @Test
//    void testAssertNotTerminated_Terminated() {
//        Streams streams = new Streams();
//        streams.makeTerminated();
//        assertThrows(IllegalStateException.class, () -> streams.assertNotTerminated());
//    }
//
//    @Test
//    void testAllMatch() {
//        Streams streams = new Streams(Stream.of(1, 2, 3));
//        boolean result = streams.allMatch(val -> val > 0);
//        assertTrue(result);
//    }
//
//    @Test
//    void testAllMatch6() {
//        Streams streams = new Streams(Stream.of(1, 2, 3));
//        boolean result = streams.anyMatch(val -> val > 2);
//        assertTrue(result);
//    }
//
//    @Test
//    void testCollect() {
//        Streams streams = new Streams(Stream.of(1, 2, 3));
//        List<Integer> result = streams.collect(Collectors.toList());
//        assertEquals(Arrays.asList(1, 2, 3), result);
//    }
//
//    @Test
//    void testCollect_WithCollector() {
//        Streams streams = new Streams(Stream.of(1, 2, 3));
//        Collector<Integer, ?, List<Integer>> collector = Collectors.toList();
//        List<Integer> result = streams.collect(collector);
//        assertEquals(Arrays.asList(1, 2, 3), result);
//    }
//
//    @Test
//    void testCollect_WithSupplierAndAccumulatorAndCombiner() {
//        Streams streams = new Streams(Stream.of(1, 2, 3));
//        Supplier<List<Integer>> supplier = ArrayList::new;
//        BiConsumer<List<Integer>, Integer> accumulator = List::add;
//        BiConsumer<List<Integer>, List<Integer>> combiner = List::addAll;
//        List<Integer> result = streams.collect(supplier, accumulator, combiner);
//        assertEquals(Arrays.asList(1, 2, 3), result);
//    }
//
//    @Test
//    void testFilter() {
//        Streams streams = new Streams(Stream.of(1, 2, 3));
//        streams.filter(val -> val > 1);
//        List<Integer> result = streams.collect(Collectors.toList());
//        assertEquals(Arrays.asList(2, 3), result);
//    }
//
//    @Test
//    void testForEach() {
//        Streams streams = new Streams(Stream.of(1, 2, 3));
//        List<Integer> result = new ArrayList<>();
//        streams.forEach(result::add);
//        assertEquals(Arrays.asList(1, 2, 3), result);
//    }
//
//    @Test
//    void testMap() {
//        Streams streams = new Streams(Stream.of(1, 2, 3));
//        FailableStream<String> mappedStream = streams.map(Object::toString);
//        List<String> result = mappedStream.collect(Collectors.toList());
//        assertEquals(Arrays.asList("1", "2", "3"), result);
//    }
//
//    @Test
//    void testReduce() {
//        Streams streams = new Streams(Stream.of(1, 2, 3));
//        Integer result = streams.reduce(0, Integer::sum);
//        assertEquals(6, result);
//    }
//
//    @Test
//    void testStream() {
//        Streams streams = new Streams(Stream.of(1, 2, 3));
//        Stream<Integer> result = streams.stream();
//        assertNotNull(result);
//    }
//
//    @Test
//    void testAllMatch_emptyStream() {
//        boolean result = streams.allMatch(o -> true);
//        assertTrue(result);
//    }
//
//    @Test
//    void testAllMatch_allMatchPredicate() {
//        boolean result = streams.allMatch(o -> o instanceof String);
//        assertTrue(result);
//    }
//
//    @Test
//    void testAllMatch_notAllMatchPredicate() {
//        boolean result = streams.allMatch(o -> o instanceof Integer);
//        assertFalse(result);
//    }
    // Your Java code here

//    @Test
//    void testMakeTerminated() {
//        Streams streams = new Streams();
//        streams.makeTerminated();
//        assertThrows(IllegalStateException.class, streams::makeTerminated);
//    }

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

//    @Test
//    void testAllMatch2() {
//        List<String> strings = Arrays.asList("apple", "banana", "cherry");
//        FailableStream<String> stream = Streams.stream(strings);
//
//        // Test if all strings contain the letter 'a'
//        boolean result = stream.allMatch(s -> s.contains("a"));
//
//        Assertions.assertTrue(result);
//    }

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

// Your Java code here
//
//
//    @Test
//    void testCombiner_EmptyLists_ReturnsEmptyList() {
//        List<String> list1 = new ArrayList<>();
//        List<String> list2 = new ArrayList<>();
//
//        BinaryOperator<List<String>> combiner = new Streams().combiner();
//        List<String> combinedList = combiner.apply(list1, list2);
//
//        assertEquals(0, combinedList.size());
//    }
//
//    @Test
//    void testCombiner_ListsWithElements_ReturnsCombinedList() {
//        List<String> list1 = Arrays.asList("A", "B", "C");
//        List<String> list2 = Arrays.asList("D", "E", "F");
//
//        BinaryOperator<List<String>> combiner = new Streams().combiner();
//        List<String> combinedList = combiner.apply(list1, list2);
//
//        assertEquals(6, combinedList.size());
//        assertTrue(combinedList.containsAll(list1));
//        assertTrue(combinedList.containsAll(list2));
//    }
//
//    @Test
//    void testCombiner_ListsWithDuplicateElements_ReturnsCombinedList() {
//        List<String> list1 = Arrays.asList("A", "B", "C");
//        List<String> list2 = Arrays.asList("B", "C", "D");
//
//        BinaryOperator<List<String>> combiner = new Streams().combiner();
//        List<String> combinedList = combiner.apply(list1, list2);
//
//        assertEquals(5, combinedList.size());
//        assertTrue(combinedList.containsAll(list1));
//        assertTrue(combinedList.containsAll(list2));
//    }
//
//
//    @Test
//    void shouldReturnTrueWhenAnyElementMatchesPredicate() {
//        assertTrue(stream.anyMatch(s -> s.startsWith("a")));
//    }
//
//    @Test
//    void shouldReturnFalseWhenNoElementMatchesPredicate() {
//        assertFalse(stream.anyMatch(s -> s.startsWith("d")));
//    }
//
//    @Test
//    void shouldReturnFalseWhenStreamIsEmpty() {
//        stream = new Streams<>(Stream.empty());
//        assertFalse(stream.anyMatch(s -> s.startsWith("a")));
//    }
//
//    @Test
//    void shouldThrowExceptionWhenPredicateThrowsException() {
//        assertThrows(Exception.class, () -> stream.anyMatch(s -> {
//            throw new Exception("Error");
//        }));
//    }
//
//
//
//    @Test
//    void shouldReturnTrueWhenAnyElementMatchesPredicate() {
//        assertTrue(stream.anyMatch(s -> s.startsWith("a")));
//    }
//
//    @Test
//    void shouldReturnFalseWhenNoElementMatchesPredicate() {
//        assertFalse(stream.anyMatch(s -> s.startsWith("d")));
//    }
//
//    @Test
//    void shouldReturnFalseWhenStreamIsEmpty() {
//        stream = new Streams<>(Stream.empty());
//        assertFalse(stream.anyMatch(s -> s.startsWith("a")));
//    }
//
//
//
//
//    @Test
//    void shouldReturnTrueWhenPredicateAlwaysReturnsTrue() {
//        assertTrue(stream.anyMatch(s -> true));
//    }
//
//    @Test
//    void shouldReturnFalseWhenPredicateAlwaysReturnsFalse() {
//        assertFalse(stream.anyMatch(s -> false));
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"apple", "banana", "cherry"})
//    void shouldReturnTrueWhenPredicateMatchesAllElements(String element) {
//        assertTrue(stream.anyMatch(s -> s.equals(element)));
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"orange", "mango", "melon"})
//    void shouldReturnFalseWhenPredicateDoesNotMatchAnyElement(String element) {
//        assertFalse(stream.anyMatch(s -> s.equals(element)));
//    }
//
//    @Test
//    void shouldThrowExceptionWhenPredicateThrowsException() {
//        assertThrows(Exception.class, () -> stream.anyMatch(s -> {
//            throw new Exception("Error");
//        }));
//    }
//
//
//    @Test
//    void shouldReturnTrueWhenPredicateAlwaysReturnsTrue() {
//        assertTrue(stream.anyMatch(s -> true));
//    }
//
//    @Test
//    void shouldReturnFalseWhenPredicateAlwaysReturnsFalse() {
//        assertFalse(stream.anyMatch(s -> false));
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"apple", "banana", "cherry"})
//    void shouldReturnTrueWhenPredicateMatchesAllElements(String element) {
//        assertTrue(stream.anyMatch(s -> s.equals(element)));
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"orange", "mango", "melon"})
//    void shouldReturnFalseWhenPredicateDoesNotMatchAnyElement(String element) {
//        assertFalse(stream.anyMatch(s -> s.equals(element)));
//    }


    @Test
    void testArrayCollector2() {
        org.apache.commons.lang3.stream.Streams.ArrayCollector<Integer> collector = new org.apache.commons.lang3.stream.Streams.ArrayCollector<>(Integer.class);
        assertNotNull(collector.accumulator());
        assertNotNull(collector.characteristics());
        assertNotNull(collector.combiner());
        assertNotNull(collector.finisher());
        assertNotNull(collector.supplier());
    }

    //@Test
    void testFailableStream2() {
        org.apache.commons.lang3.stream.Streams.FailableStream<Integer> stream = new org.apache.commons.lang3.stream.Streams.FailableStream<>(Stream.of(1, 2, 3));
        assertTrue(stream.allMatch(n -> n > 0));
        assertTrue(stream.anyMatch(n -> n < 4));
        assertNotNull(stream.collect(Collectors.toList()));
        assertNotNull(stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll));
        assertNotNull(stream.filter(n -> n % 2 == 0));
        stream.forEach(n -> assertTrue(n > 0));
        assertNotNull(stream.map(n -> n * 2));
        assertNotNull(stream.reduce(0, Integer::sum));
        assertNotNull(stream.stream());
    }

//    @Test
//    void testMap() {
//        // Test with null mapper
//        org.apache.commons.lang3.stream.Streams.FailableStream<Integer> stream = new org.apache.commons.lang3.stream.Streams.FailableStream<>(Stream.of(1, 2, 3));
//        assertThrows(NullPointerException.class, () -> stream.map(null));
//
//        // Test with identity mapper
//        stream = new org.apache.commons.lang3.stream.Streams.FailableStream<>(Stream.of(1, 2, 3));
//        org.apache.commons.lang3.stream.Streams.FailableStream<Integer> mappedStream = stream.map(Function.identity());
//        List<Integer> expected = Arrays.asList(1, 2, 3);
//        List<Integer> actual = mappedStream.collect(Collectors.toList());
//        assertEquals(expected, actual);
//
//        // Test with mapper that adds 1 to each element
//        stream = new org.apache.commons.lang3.stream.Streams.FailableStream<>(Stream.of(1, 2, 3));
//        mappedStream = stream.map(i -> i + 1);
//        expected = Arrays.asList(2, 3, 4);
//        actual = mappedStream.collect(Collectors.toList());
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testSupplier() {
//        Streams streams = new Streams();
//        Supplier<List<O>> supplier = streams.supplier();
//        assertNotNull(supplier);
//        List<O> list = supplier.get();
//        assertNotNull(list);
//        assertTrue(list.isEmpty());
//    }
//
//    @Test
//    void testArrayCollector() {
//        Streams.ArrayCollector<O> arrayCollector = new Streams.ArrayCollector<>(O.class);
//        assertNotNull(arrayCollector);
//
//        List<O> input = new ArrayList<>();
//        input.add(new O());
//        input.add(new O());
//        input.add(new O());
//
//        BiConsumer<List<O>, O> accumulator = arrayCollector.accumulator();
//        assertNotNull(accumulator);
//        List<O> list = new ArrayList<>();
//        input.forEach(o -> accumulator.accept(list, o));
//        assertEquals(input, list);
//
//        Set<Characteristics> characteristics = arrayCollector.characteristics();
//        assertNotNull(characteristics);
//        assertTrue(characteristics.isEmpty());
//
//        BinaryOperator<List<O>> combiner = arrayCollector.combiner();
//        assertNotNull(combiner);
//        List<O> list1 = new ArrayList<>();
//        List<O> list2 = new ArrayList<>();
//        list1.add(new O());
//        list2.add(new O());
//        combiner.apply(list1, list2);
//        assertEquals(2, list1.size());
//
//        Function<List<O>, O[]> finisher = arrayCollector.finisher();
//        assertNotNull(finisher);
//        O[] array = finisher.apply(list);
//        assertNotNull(array);
//        assertEquals(list.size(), array.length);
//
//        Supplier<List<O>> supplier = arrayCollector.supplier();
//        assertNotNull(supplier);
//        List<O> newList = supplier.get();
//        assertNotNull(newList);
//        assertTrue(newList.isEmpty());
//    }
//
//    @Test
//    void testFailableStream() {
//        Streams.FailableStream<O> failableStream = new Streams.FailableStream<>(Stream.empty());
//        assertNotNull(failableStream);
//
//        FailablePredicate<O, ?> predicate = o -> true;
//
//        boolean allMatch = failableStream.allMatch(predicate);
//        assertFalse(allMatch);
//
//        boolean anyMatch = failableStream.anyMatch(predicate);
//        assertFalse(anyMatch);
//
//        assertThrows(IllegalStateException.class, failableStream::assertNotTerminated);
//
//        Collector<O, List<O>, O[]> collector = new Streams.ArrayCollector<>(O.class);
//        R result = failableStream.collect(collector);
//        assertNotNull(result);
//
//        Supplier<R> supplier = ArrayList::new;
//        BiConsumer<R, ? super O> accumulator = List::add;
//        BiConsumer<R, R> combiner = (left, right) -> left.addAll(right);
//        result = failableStream.collect(supplier, accumulator, combiner);
//        assertNotNull(result);
//
//        FailableConsumer<O, ?> action = o -> {
//        };
//        failableStream.forEach(action);
//
//        FailableFunction<O, R, ?> mapper = o -> (R) o;
//        FailableStream<R> mappedStream = failableStream.map(mapper);
//        assertNotNull(mappedStream);
//
//        O identity = new O();
//        BinaryOperator<O> reduceAccumulator = (o1, o2) -> o1;
//        O reduced = failableStream.reduce(identity, reduceAccumulator);
//        assertNotNull(reduced);
//
//        Stream<O> stream = failableStream.stream();
//        assertNotNull(stream);
//    }
//
//    @Test
//    void testAccumulator() {
//        BiConsumer<List<Integer>, Integer> accumulator = new Streams().accumulator();
//        List<Integer> resultList = List.of();
//        list.forEach(e -> accumulator.accept(resultList, e));
//        assertEquals(list, resultList);
//    }
//
//    @Test
//    void testCollector() {
//        Collector<Integer, List<Integer>, Integer[]> collector = new Streams.ArrayCollector<>(Integer.class);
//        Integer[] result = list.stream().collect(collector);
//        for (int i = 0; i < list.size(); i++) {
//            assertEquals(list.get(i), result[i]);
//        }
//    }
//
//    @Test
//    void testAllMatch3() {
//        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(list.stream());
//        boolean result = stream.allMatch(e -> e > 0);
//        assertTrue(result);
//    }
//
//    @Test
//    void testAllMatch5() {
//        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(list.stream());
//        boolean result = stream.anyMatch(e -> e == 5);
//        assertTrue(result);
//    }
//
//    @Test
//    void testFilter() {
//        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(list.stream());
//        stream = stream.filter(e -> e % 2 == 0);
//        List<Integer> resultList = stream.stream().collect(Collectors.toList());
//        assertEquals(List.of(2, 4), resultList);
//    }
//
//    @Test
//    void testMap() {
//        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(list.stream());
//        stream = stream.map(e -> e * e);
//        List<Integer> resultList = stream.stream().collect(Collectors.toList());
//        assertEquals(List.of(1, 4, 9, 16, 25), resultList);
//    }
//
//    @Test
//    void testForEach() {
//        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(list.stream());
//        stream.forEach(System.out::println);
//    }


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

    //@Test
    void testFilter_withException() {
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Stream.of(1, 2, 3, 4, 5));
        Streams.FailableStream<Integer> filteredStream = stream.filter(x -> {
            if (x == 3) {
                throw new RuntimeException("Exception");
            }
            return x % 2 == 0;
        });
        assertThrows(RuntimeException.class, filteredStream::stream);
    }

    // @Test test functions:
//
//    @Test
//    void finisher_EmptyList_ReturnsEmptyArray() {
//        List<Integer> list = new ArrayList<>();
//
//        Integer[] result = finisher.apply(list);
//
//        assertEquals(0, result.length);
//    }
//
//    @Test
//    void finisher_ListWithElements_ReturnsArrayWithSameElements() {
//        List<Integer> list = new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        Integer[] result = finisher.apply(list);
//
//        assertEquals(3, result.length);
//        assertEquals(1, result[0]);
//        assertEquals(2, result[1]);
//        assertEquals(3, result[2]);
//    }
//
//    @Test
//    void finisher_NullList_ThrowsNullPointerException() {
//        assertThrows(NullPointerException.class, () -> finisher.apply(null));
//    }

}