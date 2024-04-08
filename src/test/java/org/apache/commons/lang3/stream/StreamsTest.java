package org.apache.commons.lang3.stream;

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


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class StreamsTest {
    // Test case 1
    @Test
    void testForEach() {
        // Test case 1
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);
        Streams stream1 = new Streams(list1.stream());
        List<Integer> result1 = stream1.forEach(i -> System.out.print(i + " "))
                                      .collect(Collectors.toList());
        assertEquals(list1, result1);
    
        // Test case 2
        List<Integer> list2 = Arrays.asList();
        Streams stream2 = new Streams(list2.stream());
        List<Integer> result2 = stream2.forEach(i -> System.out.print(i + " "))
                                      .collect(Collectors.toList());
        assertEquals(list2, result2);
    
        // Test case 3
        List<Integer> list3 = Arrays.asList(1, 2, 3, 4, 5);
        Streams stream3 = new Streams(list3.stream());
        List<Integer> result3 = stream3.filter(i -> i > 3)
                                      .forEach(i -> System.out.print(i + " "))
                                      .collect(Collectors.toList());
        assertEquals(Arrays.asList(4, 5), result3);
    
        // Test case 4
        List<Integer> list4 = Arrays.asList(1, 2, 3, 4, 5);
        Streams stream4 = new Streams(list4.stream());
        List<Integer> result4 = stream4.map(i -> i * i)
                                      .forEach(i -> System.out.print(i + " "))
                                      .collect(Collectors.toList());
        assertEquals(Arrays.asList(1, 4, 9, 16, 25), result4);
    }
    // Test functions
    
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
    void testCharacteristics() {
        Streams.ArrayCollector<Integer> collector = new Streams.ArrayCollector<>(Integer.class);
        assertTrue(collector.characteristics().isEmpty());
    }
    
    @Test
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
        assertArrayEquals(new Integer[] { 1, 2, 3 }, result);
    }
    
    @Test
    @DisplayName("Test supplier")
    void testSupplier() {
        Streams.ArrayCollector<Integer> collector = new Streams.ArrayCollector<>(Integer.class);
        List<Integer> result = collector.supplier().get();
        assertTrue(result.isEmpty());
    }
    
    @Test
    @DisplayName("Test forEachRemaining")
    void testForEachRemaining() {
        Streams.EnumerationSpliterator<Integer> spliterator = new Streams.EnumerationSpliterator<>(3, 0, Collections.enumeration(Arrays.asList(1, 2, 3)));
        List<Integer> result = new ArrayList<>();
        spliterator.forEachRemaining(result::add);
        assertEquals(Arrays.asList(1, 2, 3), result);
    }
    
    @Test
    @DisplayName("Test tryAdvance")
    void testTryAdvance() {
        Streams.EnumerationSpliterator<Integer> spliterator = new Streams.EnumerationSpliterator<>(3, 0, Collections.enumeration(Arrays.asList(1, 2, 3)));
        List<Integer> result = new ArrayList<>();
        assertTrue(spliterator.tryAdvance(result::add));
        assertTrue(spliterator.tryAdvance(result::add));
        assertTrue(spliterator.tryAdvance(result::add));
        assertFalse(spliterator.tryAdvance(result::add));
        assertEquals(Arrays.asList(1, 2, 3), result);
    }
    
    @Test
    @DisplayName("Test allMatch")
    void testAllMatch() {
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Arrays.stream(new Integer[] { 1, 2, 3 }));
        boolean result = stream.allMatch((Integer i) -> i > 0);
        assertTrue(result);
    }
    
    @Test
    @DisplayName("Test anyMatch")
    void testAnyMatch() {
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Arrays.stream(new Integer[] { 1, 2, 3 }));
        boolean result = stream.anyMatch((Integer i) -> i > 2);
        assertTrue(result);
    }
    
    @Test
    @DisplayName("Test collect with Collector")
    void testCollectWithCollector() {
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Arrays.stream(new Integer[] { 1, 2, 3 }));
        List<Integer> result = stream.collect(Collectors.toList());
        assertEquals(Arrays.asList(1, 2, 3), result);
    }
    
    @Test
    @DisplayName("Test collect with supplier, accumulator, combiner")
    void testCollectWithSupplierAccumulatorCombiner() {
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Arrays.stream(new Integer[] { 1, 2, 3 }));
        List<Integer> result = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        assertEquals(Arrays.asList(1, 2, 3), result);
    }
    
    @Test
    @DisplayName("Test filter")
    void testFilter() {
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Arrays.stream(new Integer[] { 1, 2, 3 }));
        Streams.FailableStream<Integer> result = stream.filter((Integer i) -> i > 1);
        assertEquals(Arrays.asList(2, 3), result.collect(Collectors.toList()));
    }
    
    @Test
    @DisplayName("Test forEach")
    void testForEach() {
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Arrays.stream(new Integer[] { 1, 2, 3 }));
        List<Integer> result = new ArrayList<>();
        stream.forEach(result::add);
        assertEquals(Arrays.asList(1, 2, 3), result);
    }
    
    @Test
    @DisplayName("Test map")
    void testMap() {
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Arrays.stream(new Integer[] { 1, 2, 3 }));
        Streams.FailableStream<String> result = stream.map((Integer i) -> String.valueOf(i));
        assertEquals(Arrays.asList("1", "2", "3"), result.collect(Collectors.toList()));
    }
    
    @Test
    @DisplayName("Test reduce")
    void testReduce() {
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Arrays.stream(new Integer[] { 1, 2, 3 }));
        Integer result = stream.reduce(0, (a, b) -> a + b);
        assertEquals(6, result);
    }
    
    @Test
    @DisplayName("Test stream")
    void testStream() {
        Streams.FailableStream<Integer> stream = new Streams.FailableStream<>(Arrays.stream(new Integer[] { 1, 2, 3 }));
        assertEquals(Arrays.asList(1, 2, 3), stream.stream().collect(Collectors.toList()));
    }
    @Test
    void testToArray_EmptyStream_ReturnsEmptyArray() {
        FailableStream<String> stream = new FailableStream<>(Stream.empty());
        String[] result = stream.toArray(String.class);
        assertEquals(0, result.length);
    }
    
    @Test
    void testToArray_SingleElementStream_ReturnsArrayWithSingleElement() {
        FailableStream<String> stream = new FailableStream<>(Stream.of("element"));
        String[] result = stream.toArray(String.class);
        assertEquals(1, result.length);
        assertEquals("element", result[0]);
    }
    
    @Test
    void testToArray_MultipleElementStream_ReturnsArrayWithAllElements() {
        FailableStream<String> stream = new FailableStream<>(Stream.of("element1", "element2", "element3"));
        String[] result = stream.toArray(String.class);
        assertEquals(3, result.length);
        assertEquals("element1", result[0]);
        assertEquals("element2", result[1]);
        assertEquals("element3", result[2]);
    }
    // Your Java code here
    
    @Test
    void testReduce_emptyStream() {
        List<Integer> numbers = new ArrayList<>();
        FailableStream<Integer> stream = new FailableStream<>(numbers.stream());
        Integer result = stream.reduce(0, Integer::sum);
        Assertions.assertEquals(0, result);
    }
    
    @Test
    void testReduce_singleElement() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        FailableStream<Integer> stream = new FailableStream<>(numbers.stream());
        Integer result = stream.reduce(0, Integer::sum);
        Assertions.assertEquals(5, result);
    }
    
    @Test
    void testReduce_multipleElements() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        FailableStream<Integer> stream = new FailableStream<>(numbers.stream());
        Integer result = stream.reduce(0, Integer::sum);
        Assertions.assertEquals(6, result);
    }
    
    @Test
    void testAllMatch_emptyStream() {
        List<Integer> numbers = new ArrayList<>();
        FailableStream<Integer> stream = new FailableStream<>(numbers.stream());
        boolean result = stream.allMatch(x -> x > 0);
        Assertions.assertTrue(result);
    }
    
    @Test
    void testAllMatch_allMatch() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        FailableStream<Integer> stream = new FailableStream<>(numbers.stream());
        boolean result = stream.allMatch(x -> x > 0);
        Assertions.assertTrue(result);
    }
    
    @Test
    void testAllMatch_notAllMatch() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(-2);
        numbers.add(3);
        FailableStream<Integer> stream = new FailableStream<>(numbers.stream());
        boolean result = stream.allMatch(x -> x > 0);
        Assertions.assertFalse(result);
    }
    
    @Test
    void testAnyMatch_emptyStream() {
        List<Integer> numbers = new ArrayList<>();
        FailableStream<Integer> stream = new FailableStream<>(numbers.stream());
        boolean result = stream.anyMatch(x -> x > 0);
        Assertions.assertFalse(result);
    }
    
    @Test
    void testAnyMatch_anyMatch() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(-2);
        numbers.add(3);
        FailableStream<Integer> stream = new FailableStream<>(numbers.stream());
        boolean result = stream.anyMatch(x -> x > 0);
        Assertions.assertTrue(result);
    }
    
    @Test
    void testAnyMatch_noMatch() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(-1);
        numbers.add(-2);
        numbers.add(-3);
        FailableStream<Integer> stream = new FailableStream<>(numbers.stream());
        boolean result = stream.anyMatch(x -> x > 0);
        Assertions.assertFalse(result);
    }
    
    @Test
    void testFilter_emptyStream() {
        List<Integer> numbers = new ArrayList<>();
        FailableStream<Integer> stream = new FailableStream<>(numbers.stream());
        FailableStream<Integer> filteredStream = stream.filter(x -> x > 0);
        List<Integer> result = filteredStream.collect(Collectors.toList());
        Assertions.assertEquals(0, result.size());
    }
    
    @Test
    void testFilter_filterOut() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(-2);
        numbers.add(3);
        FailableStream<Integer> stream = new FailableStream<>(numbers.stream());
        FailableStream<Integer> filteredStream = stream.filter(x -> x > 0);
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
        FailableStream<Integer> stream = new FailableStream<>(numbers.stream());
        FailableStream<Integer> filteredStream = stream.filter(x -> x > 0);
        List<Integer> result = filteredStream.collect(Collectors.toList());
        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals(1, result.get(0));
        Assertions.assertEquals(2, result.get(1));
        Assertions.assertEquals(3, result.get(2));
    }
    
    @Test
    void testMap_emptyStream() {
        List<Integer> numbers = new ArrayList<>();
        FailableStream<Integer> stream = new FailableStream<>(numbers.stream());
        FailableStream<String> mappedStream = stream.map(x -> String.valueOf(x));
        List<String> result = mappedStream.collect(Collectors.toList());
        Assertions.assertEquals(0, result.size());
    }
    
    @Test
    void testMap_mapElements() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        FailableStream<Integer> stream = new FailableStream<>(numbers.stream());
        FailableStream<String> mappedStream = stream.map(x -> String.valueOf(x));
        List<String> result = mappedStream.collect(Collectors.toList());
        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals("1", result.get(0));
        Assertions.assertEquals("2", result.get(1));
        Assertions.assertEquals("3", result.get(2));
    }
    
    @Test
    void testForEach_emptyStream() {
        List<Integer> numbers = new ArrayList<>();
        FailableStream<Integer> stream = new FailableStream<>(numbers.stream());
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
        FailableStream<Integer> stream = new FailableStream<>(numbers.stream());
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
        FailableStream<Integer> stream = new FailableStream<>(numbers.stream());
        List<Integer> result = stream.collect(Collectors.toList());
        Assertions.assertEquals(0, result.size());
    }
    
    @Test
    void testCollect_collectElements() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        FailableStream<Integer> stream = new FailableStream<>(numbers.stream());
        List<Integer> result = stream.collect(Collectors.toList());
        Assertions.assertEquals(3, result.size());
        Assertions.assertEquals(1, result.get(0));
        Assertions.assertEquals(2, result.get(1));
        Assertions.assertEquals(3, result.get(2));
    }
    
    // Your Java code here
    
    @Test
    void testAllMatch() {
        FailableStream<Integer> stream = new FailableStream<>(Stream.of(1, 2, 3, 4, 5));
        boolean result = stream.allMatch(x -> x > 0);
        assertTrue(result);
    
        stream = new FailableStream<>(Stream.of(1, 2, 3, 4, 5));
        result = stream.allMatch(x -> x > 5);
        assertFalse(result);
    
        stream = new FailableStream<>(Stream.empty());
        result = stream.allMatch(x -> x > 0);
        assertTrue(result);
    }
    
    @Test
    void testAnyMatch() {
        FailableStream<Integer> stream = new FailableStream<>(Stream.of(1, 2, 3, 4, 5));
        boolean result = stream.anyMatch(x -> x > 3);
        assertTrue(result);
    
        stream = new FailableStream<>(Stream.of(1, 2, 3, 4, 5));
        result = stream.anyMatch(x -> x > 5);
        assertFalse(result);
    
        stream = new FailableStream<>(Stream.empty());
        result = stream.anyMatch(x -> x > 0);
        assertFalse(result);
    }
    
    @Test
    void testCollect() {
        FailableStream<Integer> stream = new FailableStream<>(Stream.of(1, 2, 3, 4, 5));
        Integer[] result = stream.collect(new ArrayCollector<>(Integer.class));
        assertArrayEquals(new Integer[] { 1, 2, 3, 4, 5 }, result);
    
        stream = new FailableStream<>(Stream.empty());
        result = stream.collect(new ArrayCollector<>(Integer.class));
        assertArrayEquals(new Integer[0], result);
    }
    
    @Test
    void testFilter() {
        FailableStream<Integer> stream = new FailableStream<>(Stream.of(1, 2, 3, 4, 5));
        FailableStream<Integer> filteredStream = stream.filter(x -> x % 2 == 0);
        Integer[] result = filteredStream.collect(new ArrayCollector<>(Integer.class));
        assertArrayEquals(new Integer[] { 2, 4 }, result);
    }
    
    @Test
    void testForEach() {
        FailableStream<Integer> stream = new FailableStream<>(Stream.of(1, 2, 3, 4, 5));
        List<Integer> result = new ArrayList<>();
        stream.forEach(result::add);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), result);
    }
    
    @Test
    void testMap() {
        FailableStream<Integer> stream = new FailableStream<>(Stream.of(1, 2, 3, 4, 5));
        FailableStream<String> mappedStream = stream.map(x -> "Number " + x);
        String[] result = mappedStream.collect(new ArrayCollector<>(String.class));
        assertArrayEquals(new String[] { "Number 1", "Number 2", "Number 3", "Number 4", "Number 5" }, result);
    }
    
    @Test
    void testReduce() {
        FailableStream<Integer> stream = new FailableStream<>(Stream.of(1, 2, 3, 4, 5));
        Integer result = stream.reduce(0, Integer::sum);
        assertEquals(15, result);
    
        stream = new FailableStream<>(Stream.empty());
        result = stream.reduce(0, Integer::sum);
        assertEquals(0, result);
    }
    @Test
    void testAllMatchEmptyStream() {
      Streams<String> streams = new Streams<>(Stream.empty());
      boolean result = streams.allMatch(s -> s.length() > 5);
      assertTrue(result);
    }
    
    @Test
    void testAllMatchTrueCondition() {
      Streams<String> streams = new Streams<>(Stream.of("apple", "banana", "cherry"));
      boolean result = streams.allMatch(s -> s.length() > 2);
      assertTrue(result);
    }
    
    @Test
    void testAllMatchFalseCondition() {
      Streams<String> streams = new Streams<>(Stream.of("apple", "banana", "cherry"));
      boolean result = streams.allMatch(s -> s.length() > 5);
      assertFalse(result);
    }
    
    @Test
    void testAllMatchFailingCondition() {
      Streams<String> streams = new Streams<>(Stream.of("apple", "banana", "cherry"));
      boolean result = streams.allMatch(s -> { throw new RuntimeException(); });
      assertFalse(result);
    }
    
    @Test
    void testAllMatchMixedCondition() {
      Streams<String> streams = new Streams<>(Stream.of("apple", "banana", "cherry"));
      boolean result = streams.allMatch(s -> s.length() > 2 && s.charAt(0) == 'b');
      assertFalse(result);
    }
    // Your Java code here
    
    import org.junit.jupiter.api.Test;
    
    class StreamsTest {
    
        @Test
        void testMakeTerminated() {
            // Test code here
        }
    
        @Test
        void testAllMatch() {
            // Test code here
        }
    
        @Test
        void testAnyMatch() {
            // Test code here
        }
    
        @Test
        void testCollect() {
            // Test code here
        }
    
        @Test
        void testCollectWithSupplierAndAccumulator() {
            // Test code here
        }
    
        @Test
        void testFilter() {
            // Test code here
        }
    
        @Test
        void testForEach() {
            // Test code here
        }
    
        @Test
        void testMap() {
            // Test code here
        }
    
        @Test
        void testReduce() {
            // Test code here
        }
    
        @Test
        void testStream() {
            // Test code here
        }
    }
    // Your Java code here
    
    @Test
    @DisplayName("Test filter method")
    void testFilter() {
        List<Integer> filteredNumbers = new Streams(numbers.stream())
                .filter(number -> number % 2 == 0)
                .collect(Collectors.toList());
    
        assertEquals(Arrays.asList(2, 4), filteredNumbers);
    }
    
    @Test
    @DisplayName("Test map method")
    void testMap() {
        List<String> mappedStrings = new Streams(strings.stream())
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    
        assertEquals(Arrays.asList("APPLE", "BANANA", "CHERRY"), mappedStrings);
    }
    
    @Test
    @DisplayName("Test allMatch method")
    void testAllMatch() {
        boolean allMatch = new Streams(numbers.stream())
                .allMatch(number -> number > 0);
    
        assertTrue(allMatch);
    }
    
    @Test
    @DisplayName("Test anyMatch method")
    void testAnyMatch() {
        boolean anyMatch = new Streams(numbers.stream())
                .anyMatch(number -> number == 3);
    
        assertTrue(anyMatch);
    }
    
    @Test
    @DisplayName("Test reduce method")
    void testReduce() {
        int sum = new Streams(numbers.stream())
                .reduce(0, Integer::sum);
    
        assertEquals(15, sum);
    }
    
    @Test
    @DisplayName("Test collect method")
    void testCollect() {
        List<Integer> collectedNumbers = new Streams(numbers.stream())
                .collect(ArrayList::new, List::add, List::addAll);
    
        assertEquals(numbers, collectedNumbers);
    }
    @Test
    @DisplayName("should consume next element and return true")
    void shouldConsumeNextElementAndReturnTrue() {
        List<Integer> result = new ArrayList<>();
        assertTrue(streams.tryAdvance(result::add));
        assertEquals(1, result.size());
        assertEquals(1, result.get(0));
    }
    
    @Test
    @DisplayName("should not consume next element and return false")
    void shouldNotConsumeNextElementAndReturnFalse() {
        streams.tryAdvance(i -> {});
        streams.tryAdvance(i -> {});
        streams.tryAdvance(i -> {});
        assertFalse(streams.tryAdvance(i -> {}));
    }
    
    @Test
    @DisplayName("should throw NoSuchElementException when no more elements")
    void shouldThrowNoSuchElementExceptionWhenNoMoreElements() {
        streams.tryAdvance(i -> {});
        streams.tryAdvance(i -> {});
        streams.tryAdvance(i -> {});
        assertThrows(NoSuchElementException.class, () -> streams.tryAdvance(i -> {}));
    }
    @Test
    void testCombiner_shouldCombineTwoLists() {
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> result = combiner(list1, list2);
        assertEquals(expected, result);
    }
    
    @Test
    void testCombiner_shouldCombineMultipleLists() {
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> result = combiner(list1, list2, list3);
        assertEquals(expected, result);
    }
    
    @Test
    void testCombiner_shouldReturnOriginalList_whenCombiningWithEmptyList() {
        List<Integer> expected = list1;
        List<Integer> result = combiner(list1, emptyList);
        assertEquals(expected, result);
    }
    
    @Test
    void testCombiner_shouldReturnOriginalList_whenCombiningEmptyLists() {
        List<Integer> expected = emptyList;
        List<Integer> result = combiner(emptyList, emptyList);
        assertEquals(expected, result);
    }
    
    @Test
    void testCombiner_shouldReturnEmptyList_whenCombiningEmptyListWithNonEmptyList() {
        List<Integer> expected = emptyList;
        List<Integer> result = combiner(emptyList, list1);
        assertEquals(expected, result);
    }
    
    @Test
    void testCombiner_shouldReturnEmptyList_whenCombiningEmptyListsWithNonEmptyList() {
        List<Integer> expected = emptyList;
        List<Integer> result = combiner(emptyList, emptyList, list1);
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("returns true when the stream contains one element that matches the predicate")
    void returnsTrueWhenStreamContainsOneMatchingElement() {
        // Given
        FailablePredicate<Integer, ?> predicate = i -> i > 5;
        FailableStream<Integer> stream = new FailableStream<>(Stream.of(1, 2, 3, 6, 7));
        
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
        FailableStream<Integer> stream = new FailableStream<>(Stream.of(1, 2, 3, 4, 5, 6));
        
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
        FailableStream<Integer> stream = new FailableStream<>(Stream.of(1, 2, 3, 4, 5));
        
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
        FailableStream<Integer> stream = new FailableStream<>(Stream.empty());
        
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
        FailableStream<Integer> stream = new FailableStream<>(Stream.of(1, 2, 3));
        stream.anyMatch(i -> true); // Terminate the stream
        
        // When
        assertThrows(IllegalStateException.class, () -> stream.anyMatch(predicate));
    }
    @Test
    void testCharacteristics() {
        Streams streams = new Streams();
        Set<Characteristics> characteristics = streams.characteristics();
    
        Assertions.assertNotNull(characteristics);
        Assertions.assertTrue(characteristics.isEmpty());
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
    
    @Test
    void testEnumerationSpliterator() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Streams.EnumerationSpliterator<Integer> enumerationSpliterator = new Streams.EnumerationSpliterator<>(list.size(), 0, list.elements());
    
        List<Integer> result = new ArrayList<>();
        enumerationSpliterator.forEachRemaining(result::add);
    
        Assertions.assertEquals(list, result);
    }
    
    @Test
    void testFailableStream() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        Streams.FailableStream<Integer> failableStream = new Streams.FailableStream<>(list.stream());
    
        Assertions.assertTrue(failableStream.allMatch((FailablePredicate<Integer, ?>) Objects::nonNull));
        Assertions.assertTrue(failableStream.anyMatch((FailablePredicate<Integer, ?>) Objects::nonNull));
    
        Assertions.assertNotNull(failableStream.collect(Collectors.toList()));
        Assertions.assertNotNull(failableStream.collect(() -> new ArrayList<>(), List::add, List::addAll));
    
        failableStream.forEach((FailableConsumer<Integer, ?>) System.out::println);
    
        Assertions.assertNotNull(failableStream.map((FailableFunction<Integer, String, ?>) String::valueOf));
    
        Assertions.assertNotNull(failableStream.reduce(0, Integer::sum));
    
        Assertions.assertNotNull(failableStream.stream());
    }
    @Test
    void testAllMatch_whenEmptyStream_shouldReturnTrue() {
        boolean result = streams.allMatch(element -> false);
        assertTrue(result);
    }
    
    @Test
    void testAllMatch_whenAllElementsMatchPredicate_shouldReturnTrue() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean result = streams.of(numbers).allMatch(number -> number > 0);
        assertTrue(result);
    }
    
    @Test
    void testAllMatch_whenNotAllElementsMatchPredicate_shouldReturnFalse() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean result = streams.of(numbers).allMatch(number -> number > 3);
        assertFalse(result);
    }
    
    @Test
    void testAnyMatch_whenEmptyStream_shouldReturnFalse() {
        boolean result = streams.anyMatch(element -> true);
        assertFalse(result);
    }
    
    @Test
    void testAnyMatch_whenAtLeastOneElementMatchesPredicate_shouldReturnTrue() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean result = streams.of(numbers).anyMatch(number -> number > 3);
        assertTrue(result);
    }
    
    @Test
    void testAnyMatch_whenNoElementMatchesPredicate_shouldReturnFalse() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        boolean result = streams.of(numbers).anyMatch(number -> number > 5);
        assertFalse(result);
    }
    
    @Test
    void testCollect_whenEmptyStream_shouldReturnEmptyResult() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> result = streams.of(numbers).collect(Collectors.toList());
        assertTrue(result.isEmpty());
    }
    
    @Test
    void testCollect_whenStreamHasElements_shouldReturnResultList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = streams.of(numbers).collect(Collectors.toList());
        assertEquals(numbers, result);
    }
    
    @Test
    void testCollectWithSupplierAccumulatorCombiner_whenEmptyStream_shouldReturnEmptyResult() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> result = streams.of(numbers).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        assertTrue(result.isEmpty());
    }
    
    @Test
    void testCollectWithSupplierAccumulatorCombiner_whenStreamHasElements_shouldReturnResultList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = streams.of(numbers).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        assertEquals(numbers, result);
    }
    
    @Test
    void testFilter_whenEmptyStream_shouldReturnEmptyStream() {
        List<Integer> numbers = new ArrayList<>();
        FailableStream<Integer> resultStream = streams.of(numbers).filter(number -> number > 0);
        assertTrue(resultStream.stream().count() == 0);
    }
    
    @Test
    void testFilter_whenSomeElementsMatchPredicate_shouldReturnFilteredStream() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        FailableStream<Integer> resultStream = streams.of(numbers).filter(number -> number > 3);
        List<Integer> expectedResult = Arrays.asList(4, 5);
        assertEquals(expectedResult, resultStream.collect(Collectors.toList()));
    }
    
    @Test
    void testForEach_whenEmptyStream_shouldNotExecuteAction() {
        List<Integer> numbers = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        streams.of(numbers).forEach(result::add);
        assertTrue(result.isEmpty());
    }
    
    @Test
    void testForEach_whenNonEmptyStream_shouldExecuteActionForAllElements() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = new ArrayList<>();
        streams.of(numbers).forEach(result::add);
        assertEquals(numbers, result);
    }
    
    @Test
    void testMap_whenEmptyStream_shouldReturnEmptyStream() {
        List<Integer> numbers = new ArrayList<>();
        FailableStream<String> resultStream = streams.of(numbers).map(Object::toString);
        assertTrue(resultStream.stream().count() == 0);
    }
    
    @Test
    void testMap_whenStreamHasElements_shouldReturnMappedStream() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        FailableStream<String> resultStream = streams.of(numbers).map(Object::toString);
        List<String> expectedResult = Arrays.asList("1", "2", "3", "4", "5");
        assertEquals(expectedResult, resultStream.collect(Collectors.toList()));
    }
    
    @Test
    void testReduce_whenEmptyStream_shouldReturnIdentity() {
        List<Integer> numbers = new ArrayList<>();
        Integer result = streams.of(numbers).reduce(0, Integer::sum);
        assertEquals(0, result);
    }
    
    @Test
    void testReduce_whenStreamHasElements_shouldReturnReducedValue() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer result = streams.of(numbers).reduce(0, Integer::sum);
        assertEquals(15, result);
    }
    
    @Test
    void testMap_whenStreamHasElements_shouldReturnMappedStreamOfDifferentType() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        FailableStream<Boolean> resultStream = streams.of(numbers).map(number -> number % 2 == 0);
        List<Boolean> expectedResult = Arrays.asList(false, true, false, true, false);
        assertEquals(expectedResult, resultStream.collect(Collectors.toList()));
    }
    // Filter out only the @Test test functions
    import static org.junit.jupiter.api.Assertions.*;
    
    import java.util.ArrayList;
    import java.util.List;
    import java.util.function.Supplier;
    
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Nested;
    import org.junit.jupiter.api.Test;
    
    @DisplayName("Supplier Test Suite")
    class SupplierTestSuite {
        
        @Nested
        @DisplayName("When calling supplier()")
        class WhenCallingSupplier {
            
            @Test
            @DisplayName("Should return a non-null instance of ArrayList")
            void shouldReturnNonNullArrayList() {
                Supplier<List<Object>> supplier = new Streams().supplier();
                assertNotNull(supplier.get());
            }
            
            @Test
            @DisplayName("Should return a new instance of ArrayList each time")
            void shouldReturnNewArrayListInstance() {
                Supplier<List<Object>> supplier = new Streams().supplier();
                List<Object> list1 = supplier.get();
                List<Object> list2 = supplier.get();
                assertNotSame(list1, list2);
            }
            
            @Test
            @DisplayName("Should return an empty ArrayList")
            void shouldReturnEmptyArrayList() {
                Supplier<List<Object>> supplier = new Streams().supplier();
                List<Object> list = supplier.get();
                assertTrue(list.isEmpty());
            }
        }
    }
    // Your Java code here
    
    import static org.junit.jupiter.api.Assertions.*;
    import org.junit.jupiter.api.Test;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.Collections;
    import java.util.Enumeration;
    import java.util.List;
    import java.util.stream.Collectors;
    
    class StreamsTest {
        private final String[] testArray = {"apple", "banana", "cherry"};
        private final List<String> testList = Arrays.asList(testArray);
        private final Enumeration<String> testEnumeration = Collections.enumeration(testList);
    
        @Test
        void testAllMatch() {
            FailableStream<String> stream = Streams.failableStream(testList.stream());
            assertTrue(stream.allMatch(s -> s.length() > 0));
            assertFalse(stream.allMatch(s -> s.length() > 5));
        }
    
        @Test
        void testAnyMatch() {
            FailableStream<String> stream = Streams.failableStream(testList.stream());
            assertTrue(stream.anyMatch(s -> s.equals("banana")));
            assertFalse(stream.anyMatch(s -> s.equals("grape")));
        }
    
        @Test
        void testCollect() {
            FailableStream<String> stream = Streams.failableStream(testList.stream());
            List<String> result = stream.collect(Collectors.toList());
            assertEquals(testList, result);
        }
    
        @Test
        void testFilter() {
            FailableStream<String> stream = Streams.failableStream(testList.stream());
            List<String> filtered = stream.filter(s -> s.length() > 5).collect(Collectors.toList());
            assertEquals(Collections.emptyList(), filtered);
        }
    
        @Test
        void testForEach() {
            FailableStream<String> stream = Streams.failableStream(testList.stream());
            List<String> resultList = new ArrayList<>();
            stream.forEach(resultList::add);
            assertEquals(testList, resultList);
        }
    
        @Test
        void testMap() {
            FailableStream<String> stream = Streams.failableStream(testList.stream());
            List<Integer> lengths = stream.map(String::length).collect(Collectors.toList());
            List<Integer> expectedLengths = Arrays.asList(5, 6, 6);
            assertEquals(expectedLengths, lengths);
        }
    
        @Test
        void testReduce() {
            FailableStream<String> stream = Streams.failableStream(testList.stream());
            String reduced = stream.reduce("", (a, b) -> a.concat(b));
            String expectedReduced = "applebananacherry";
            assertEquals(expectedReduced, reduced);
        }
    
        @Test
        void testFailableStream() {
            FailableStream<String> stream = Streams.failableStream(testEnumeration);
            List<String> resultList = new ArrayList<>();
            stream.forEach(resultList::add);
            assertEquals(testList, resultList);
        }
    
        @Test
        void testFailableStreamArray() {
            FailableStream<String> stream = Streams.failableStream(testArray);
            List<String> resultList = new ArrayList<>();
            stream.forEach(resultList::add);
            assertEquals(testList, resultList);
        }
    }
    @Test
    void testInstancesOf_withNullCollection_shouldReturnEmptyStream() {}
    
    @Test
    void testInstancesOf_withEmptyCollection_shouldReturnEmptyStream() {}
    
    @Test
    void testInstancesOf_withNonEmptyCollection_shouldReturnStreamWithInstancesOfGivenClass() {}
    
    @Test
    void testInstancesOf_withEmptyStream_shouldReturnEmptyStream() {}
    
    @Test
    void testInstancesOf_withNonEmptyStream_shouldReturnStreamWithInstancesOfGivenClass() {}
    @Test
    void testAllMatch() {
        FailablePredicate<Integer, ?> predicate = num -> num > 0;
        assertFalse(streams.of(1, 2, 3).allMatch(predicate));
        assertTrue(streams.of(1, 2, 3).allMatch(predicate));
        assertFalse(streams.of(-1, -2, -3).allMatch(predicate));
        assertTrue(streams.of(0).allMatch(predicate));
        assertTrue(streams.of().allMatch(predicate));
    }
    
    @Test
    void testAnyMatch() {
        FailablePredicate<Integer, ?> predicate = num -> num > 0;
        assertTrue(streams.of(1, 2, 3).anyMatch(predicate));
        assertFalse(streams.of(-1, -2, -3).anyMatch(predicate));
        assertFalse(streams.of(0).anyMatch(predicate));
        assertFalse(streams.of().anyMatch(predicate));
    }
    
    @Test
    void testCollect() {
        Collector<Integer, ?, Integer[]> collector = new ArrayCollector<>(Integer.class);
        Integer[] expected = {1, 2, 3};
        Integer[] result = streams.of(1, 2, 3).collect(collector);
        assertArrayEquals(expected, result);
    }
    
    @Test
    void testFilter() {
        FailablePredicate<Integer, ?> predicate = num -> num > 0;
        Integer[] expected = {1, 2, 3};
        Integer[] result = streams.of(-1, 0, 1, 2, 3).filter(predicate).collect(Collectors.toList()).toArray(new Integer[0]);
        assertArrayEquals(expected, result);
    }
    
    @Test
    void testForEach() {
        List<Integer> list = new ArrayList<>();
        FailableConsumer<Integer, ?> consumer = list::add;
        streams.of(1, 2, 3).forEach(consumer);
        assertEquals(3, list.size());
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(3));
    }
    
    @Test
    void testMap() {
        FailableFunction<Integer, String, ?> mapper = Object::toString;
        String[] expected = {"1", "2", "3"};
        String[] result = streams.of(1, 2, 3).map(mapper).collect(Collectors.toList()).toArray(new String[0]);
        assertArrayEquals(expected, result);
    }
    
    @Test
    void testReduce() {
        BinaryOperator<Integer> accumulator = Integer::sum;
        int expected = 6;
        int result = streams.of(1, 2, 3).reduce(0, accumulator);
        assertEquals(expected, result);
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
    void testOfEnumeration_withNullEnumeration_shouldReturnEmptyStream() {
        // Act
        Stream<String> stream = Streams.of((Enumeration<String>) null);
        
        // Assert
        assertTrue(stream.collect(Collectors.toList()).isEmpty());
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
    void testForEach_shouldPerformActionOnEachElement() {
        // Arrange
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5);
        FailableConsumer<Integer, ?> action = mock(FailableConsumer.class);
        
        // Act
        new Streams.FailableStream<>(stream).forEach(action);
        
        // Assert
        verify(action, times(5)).accept(any());
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
    void testMakeTerminated_shouldMarkStreamAsTerminated() {
        // Arrange
        Streams.FailableStream<String> failableStream = new Streams.FailableStream<>(Stream.of("a", "b", "c"));
        
        // Act
        failableStream.makeTerminated();
        
        // Assert
        assertTrue(failableStream.isTerminated());
    }
    
    @Test
    void testMakeTerminated_shouldThrowExceptionIfStreamAlreadyTerminated() {
        // Arrange
        Streams.FailableStream<String> failableStream = new Streams.FailableStream<>(Stream.of("a", "b", "c"));
        failableStream.makeTerminated();
        
        // Assert
        assertThrows(IllegalStateException.class, failableStream::makeTerminated);
    }
    import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.*;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.stream.Collectors;
    
    class StreamsTest {
    
      @Test
      void testFilter() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        
        // Test case 1: filter out even numbers
        List<Integer> expected1 = List.of(1, 3, 5);
        List<Integer> result1 = new Streams(numbers.stream())
            .filter(n -> n % 2 != 0)
            .stream()
            .collect(Collectors.toList());
        assertEquals(expected1, result1);
        
        // Test case 2: filter out odd numbers
        List<Integer> expected2 = List.of(2, 4);
        List<Integer> result2 = new Streams(numbers.stream())
            .filter(n -> n % 2 == 0)
            .stream()
            .collect(Collectors.toList());
        assertEquals(expected2, result2);
        
        // Test case 3: filter out numbers greater than 3
        List<Integer> expected3 = List.of(1, 2, 3);
        List<Integer> result3 = new Streams(numbers.stream())
            .filter(n -> n <= 3)
            .stream()
            .collect(Collectors.toList());
        assertEquals(expected3, result3);
        
        // Test case 4: filter out numbers less than 3
        List<Integer> expected4 = List.of(3, 4, 5);
        List<Integer> result4 = new Streams(numbers.stream())
            .filter(n -> n >= 3)
            .stream()
            .collect(Collectors.toList());
        assertEquals(expected4, result4);
        
        // Test case 5: filter out numbers equal to 3
        List<Integer> expected5 = List.of(1, 2, 4, 5);
        List<Integer> result5 = new Streams(numbers.stream())
            .filter(n -> n != 3)
            .stream()
            .collect(Collectors.toList());
        assertEquals(expected5, result5);
        
        // Test case 6: filter out all numbers
        List<Integer> expected6 = new ArrayList<>();
        List<Integer> result6 = new Streams(numbers.stream())
            .filter(n -> n > 5)
            .stream()
            .collect(Collectors.toList());
        assertEquals(expected6, result6);
      }
    }
    @Test
    void testNonNullWithNullCollection() {
        Stream<String> stream = Streams.nonNull(NULL_LIST);
        assertEquals(0, stream.count());
    }
    
    @Test
    void testNonNullWithEmptyCollection() {
        Stream<String> stream = Streams.nonNull(EMPTY_LIST);
        assertEquals(0, stream.count());
    }
    
    @Test
    void testNonNullWithNonNullCollection() {
        Stream<String> stream = Streams.nonNull(NON_NULL_LIST);
        assertEquals(NON_NULL_LIST.size(), stream.count());
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
    void testNonNullFiltersOutNullElements() {
        List<String> input = Arrays.asList(NULL_STRING, NON_NULL_STRING, NULL_STRING, NON_NULL_STRING);
        Stream<String> stream = Streams.nonNull(input);
        assertEquals(2, stream.count());
        assertTrue(stream.allMatch(Objects::nonNull));
    }
    import static org.junit.jupiter.api.Assertions.*;
    
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Test;
    
    class StreamsTest {
    
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
    @Test
    void forEachRemaining_emptyEnumeration_shouldNotInvokeAction() {
        // Arrange
        Enumeration<Object> enumeration = new EmptyEnumeration<>();
        List<Object> invokedElements = new ArrayList<>();
    
        // Act
        Streams.forEachRemaining(enumeration, invokedElements::add);
    
        // Assert
        assertTrue(invokedElements.isEmpty());
    }
    
    @Test
    void forEachRemaining_nonEmptyEnumeration_shouldInvokeActionForEachElement() {
        // Arrange
        List<String> elements = Arrays.asList("a", "b", "c");
        Enumeration<String> enumeration = new ListEnumeration<>(elements);
        List<String> invokedElements = new ArrayList<>();
    
        // Act
        Streams.forEachRemaining(enumeration, invokedElements::add);
    
        // Assert
        assertEquals(elements, invokedElements);
    }
    
    @Test
    void forEachRemaining_emptyIterator_shouldNotInvokeAction() {
        // Arrange
        Iterator<Object> iterator = new ArrayList<>().iterator();
        List<Object> invokedElements = new ArrayList<>();
    
        // Act
        Streams.forEachRemaining(iterator, invokedElements::add);
    
        // Assert
        assertTrue(invokedElements.isEmpty());
    }
    
    @Test
    void forEachRemaining_nonEmptyIterator_shouldInvokeActionForEachElement() {
        // Arrange
        List<String> elements = Arrays.asList("a", "b", "c");
        Iterator<String> iterator = elements.iterator();
        List<String> invokedElements = new ArrayList<>();
    
        // Act
        Streams.forEachRemaining(iterator, invokedElements::add);
    
        // Assert
        assertEquals(elements, invokedElements);
    }
    
    @Test
    void forEachRemaining_emptySpliterator_shouldNotInvokeAction() {
        // Arrange
        Spliterator<Object> spliterator = new ArrayList<>().spliterator();
        List<Object> invokedElements = new ArrayList<>();
    
        // Act
        Streams.forEachRemaining(spliterator, invokedElements::add);
    
        // Assert
        assertTrue(invokedElements.isEmpty());
    }
    
    @Test
    void forEachRemaining_nonEmptySpliterator_shouldInvokeActionForEachElement() {
        // Arrange
        List<String> elements = Arrays.asList("a", "b", "c");
        Spliterator<String> spliterator = elements.spliterator();
        List<String> invokedElements = new ArrayList<>();
    
        // Act
        Streams.forEachRemaining(spliterator, invokedElements::add);
    
        // Assert
        assertEquals(elements, invokedElements);
    }
    
    @Test
    void forEachRemaining_nullConsumer_shouldThrowNullPointerException() {
        // Arrange
        Enumeration<Object> enumeration = new EmptyEnumeration<>();
    
        // Act & Assert
        assertThrows(NullPointerException.class, () -> Streams.forEachRemaining(enumeration, null));
    }
    
    @Test
    void forEachRemaining_emptyEnumerationWithNullElement_shouldInvokeActionWithNull() {
        // Arrange
        Enumeration<Object> enumeration = new ListEnumeration<>(Arrays.asList(null));
        List<Object> invokedElements = new ArrayList<>();
    
        // Act
        Streams.forEachRemaining(enumeration, invokedElements::add);
    
        // Assert
        assertEquals(Arrays.asList(null), invokedElements);
    }
    
    @Test
    void forEachRemaining_emptyIteratorWithNullElement_shouldInvokeActionWithNull() {
        // Arrange
        Iterator<Object> iterator = Arrays.asList(null).iterator();
        List<Object> invokedElements = new ArrayList<>();
    
        // Act
        Streams.forEachRemaining(iterator, invokedElements::add);
    
        // Assert
        assertEquals(Arrays.asList(null), invokedElements);
    }
    
    @Test
    void forEachRemaining_emptySpliteratorWithNullElement_shouldInvokeActionWithNull() {
        // Arrange
        Spliterator<Object> spliterator = Arrays.asList(null).spliterator();
        List<Object> invokedElements = new ArrayList<>();
    
        // Act
        Streams.forEachRemaining(spliterator, invokedElements::add);
    
        // Assert
        assertEquals(Arrays.asList(null), invokedElements);
    }
    
    @Test
    void forEachRemaining_emptyEnumerationWithExceptionInAction_shouldThrowException() {
        // Arrange
        Enumeration<Object> enumeration = new ListEnumeration<>(Arrays.asList("a"));
        RuntimeException exception = new RuntimeException();
        Consumer<Object> action = e -> { throw exception; };
    
        // Act & Assert
        assertThrows(RuntimeException.class, () -> Streams.forEachRemaining(enumeration, action));
    }
    
    @Test
    void forEachRemaining_emptyIteratorWithExceptionInAction_shouldThrowException() {
        // Arrange
        Iterator<Object> iterator = Arrays.asList("a").iterator();
        RuntimeException exception = new RuntimeException();
        Consumer<Object> action = e -> { throw exception; };
    
        // Act & Assert
        assertThrows(RuntimeException.class, () -> Streams.forEachRemaining(iterator, action));
    }
    
    @Test
    void forEachRemaining_emptySpliteratorWithExceptionInAction_shouldThrowException() {
        // Arrange
        Spliterator<Object> spliterator = Arrays.asList("a").spliterator();
        RuntimeException exception = new RuntimeException();
        Consumer<Object> action = e -> { throw exception; };
    
        // Act & Assert
        assertThrows(RuntimeException.class, () -> Streams.forEachRemaining(spliterator, action));
    }
    
    @Test
    void forEachRemaining_nonEmptyEnumerationWithExceptionInAction_shouldThrowException() {
        // Arrange
        Enumeration<Object> enumeration = new ListEnumeration<>(Arrays.asList("a", "b", "c"));
        RuntimeException exception = new RuntimeException();
        Consumer<Object> action = e -> { if (e.equals("b")) throw exception; };
    
        // Act & Assert
        assertThrows(RuntimeException.class, () -> Streams.forEachRemaining(enumeration, action));
    }
    
    @Test
    void forEachRemaining_nonEmptyIteratorWithExceptionInAction_shouldThrowException() {
        // Arrange
        Iterator<Object> iterator = Arrays.asList("a", "b", "c").iterator();
        RuntimeException exception = new RuntimeException();
        Consumer<Object> action = e -> { if (e.equals("b")) throw exception; };
    
        // Act & Assert
        assertThrows(RuntimeException.class, () -> Streams.forEachRemaining(iterator, action));
    }
    
    @Test
    void forEachRemaining_nonEmptySpliteratorWithExceptionInAction_shouldThrowException() {
        // Arrange
        Spliterator<Object> spliterator = Arrays.asList("a", "b", "c").spliterator();
        RuntimeException exception = new RuntimeException();
        Consumer<Object> action = e -> { if (e.equals("b")) throw exception; };
    
        // Act & Assert
        assertThrows(RuntimeException.class, () -> Streams.forEachRemaining(spliterator, action));
    }

}