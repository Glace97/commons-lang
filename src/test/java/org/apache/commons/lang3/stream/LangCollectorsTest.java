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

public class LangCollectorsTest {
    @Test
    void testCombiner() {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
    
        BinaryOperator<List<Integer>> combiner = new LangCollectors().combiner();
    
        List<Integer> result = combiner.apply(list1, list2);
        assertEquals(expected, result);
    }
    
    @Test
    void testAccumulator() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
    
        Supplier<List<Integer>> supplier = ArrayList::new;
        BiConsumer<List<Integer>, Integer> accumulator = (list1, integer) -> list1.add(integer);
        BinaryOperator<List<Integer>> combiner = (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
        Function<List<Integer>, List<Integer>> finisher = Function.identity();
    
        LangCollectors.SimpleCollector<Integer, List<Integer>, List<Integer>> collector = new LangCollectors.SimpleCollector<>(supplier, accumulator, combiner, finisher, Collections.emptySet());
    
        List<Integer> result = Arrays.asList(4, 5, 6);
        list.stream().collect(collector);
        assertEquals(expected, result);
    }
    
    @Test
    void testFinisher() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        List<Integer> expected = Arrays.asList(1, 2, 3);
    
        Supplier<List<Integer>> supplier = ArrayList::new;
        BiConsumer<List<Integer>, Integer> accumulator = (list1, integer) -> list1.add(integer);
        BinaryOperator<List<Integer>> combiner = (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
        Function<List<Integer>, List<Integer>> finisher = Function.identity();
    
        LangCollectors.SimpleCollector<Integer, List<Integer>, List<Integer>> collector = new LangCollectors.SimpleCollector<>(supplier, accumulator, combiner, finisher, Collections.emptySet());
    
        List<Integer> result = list.stream().collect(collector);
        assertEquals(expected, result);
    }
    @Test
    void testJoining_noDelimiter() {
        Collector<Object, ?, String> collector = LangCollectors.joining();
        String result = List.of("a", "b", "c").stream().collect(collector);
        assertEquals("abc", result);
    }
    
    @Test
    void testJoining_withDelimiter() {
        Collector<Object, ?, String> collector = LangCollectors.joining(",");
        String result = List.of("a", "b", "c").stream().collect(collector);
        assertEquals("a,b,c", result);
    }
    
    @Test
    void testJoining_withDelimiterAndPrefixSuffix() {
        Collector<Object, ?, String> collector = LangCollectors.joining(",", "[", "]");
        String result = List.of("a", "b", "c").stream().collect(collector);
        assertEquals("[a,b,c]", result);
    }
    
    @Test
    void testJoining_withDelimiterAndPrefixSuffixAndToString() {
        Collector<Object, ?, String> collector = LangCollectors.joining(",", "[", "]", Object::toString);
        String result = List.of(1, 2, 3).stream().collect(collector);
        assertEquals("[1,2,3]", result);
    }
    
    @Test
    void testJoining_emptyList() {
        Collector<Object, ?, String> collector = LangCollectors.joining(",", "[", "]");
        String result = Collections.emptyList().stream().collect(collector);
        assertEquals("[]", result);
    }
    
    @Test
    void testJoining_singleElementList() {
        Collector<Object, ?, String> collector = LangCollectors.joining(",", "[", "]");
        String result = List.of("a").stream().collect(collector);
        assertEquals("[a]", result);
    }
    
    @Test
    void testJoining_nullElementList() {
        Collector<Object, ?, String> collector = LangCollectors.joining(",", "[", "]");
        String result = List.of("a", null, "c").stream().collect(collector);
        assertEquals("[a,null,c]", result);
    }
    
    @Test
    void testJoining_nullDelimiter() {
        Collector<Object, ?, String> collector = LangCollectors.joining(null);
        String result = List.of("a", "b", "c").stream().collect(collector);
        assertEquals("abc", result);
    }
    
    @Test
    void testJoining_emptyDelimiter() {
        Collector<Object, ?, String> collector = LangCollectors.joining("");
        String result = List.of("a", "b", "c").stream().collect(collector);
        assertEquals("abc", result);
    }
    
    @Test
    void testJoining_nullPrefixSuffix() {
        Collector<Object, ?, String> collector = LangCollectors.joining(",", null, null);
        String result = List.of("a", "b", "c").stream().collect(collector);
        assertEquals("a,b,c", result);
    }
    
    @Test
    void testJoining_emptyPrefixSuffix() {
        Collector<Object, ?, String> collector = LangCollectors.joining(",", "", "");
        String result = List.of("a", "b", "c").stream().collect(collector);
        assertEquals("a,b,c", result);
    }
    
    @Test
    void testJoining_singleElementPrefixSuffix() {
        Collector<Object, ?, String> collector = LangCollectors.joining(",", "[", "]");
        String result = List.of("a").stream().collect(collector);
        assertEquals("[a]", result);
    }
    
    @Test
    void testJoining_nullToString() {
        Collector<Object, ?, String> collector = LangCollectors.joining(",", "[", "]", null);
        String result = List.of(1, 2, 3).stream().collect(collector);
        assertEquals("[1,2,3]", result);
    }
    
    @Test
    void testJoining_customToString() {
        Collector<Object, ?, String> collector = LangCollectors.joining(",", "[", "]", Object::toString);
        String result = List.of(1, 2, 3).stream().collect(collector);
        assertEquals("[1,2,3]", result);
    }
    
    @Test
    void testJoining_customToStringWithNullElement() {
        Collector<Object, ?, String> collector = LangCollectors.joining(",", "[", "]", Object::toString);
        String result = List.of(1, null, 3).stream().collect(collector);
        assertEquals("[1,null,3]", result);
    }
    @Test
    void testCharacteristics() {
        Set<Collector.Characteristics> expectedCharacteristics = Collections.emptySet();
        Set<Collector.Characteristics> actualCharacteristics = LangCollectors.characteristics();
        assertEquals(expectedCharacteristics, actualCharacteristics);
    }
    
    @Test
    void testSimpleCollectorConstructor() {
        Supplier<String> supplier = String::new;
        BiConsumer<String, Character> accumulator = String::concat;
        BinaryOperator<String> combiner = (s1, s2) -> s1 + s2;
        Function<String, Integer> finisher = String::length;
        Set<Collector.Characteristics> characteristics = Collections.emptySet();
    
        LangCollectors.SimpleCollector<Character, String, Integer> collector = new LangCollectors.SimpleCollector<>(supplier, accumulator, combiner, finisher, characteristics);
    
        assertEquals(supplier, collector.supplier());
        assertEquals(accumulator, collector.accumulator());
        assertEquals(combiner, collector.combiner());
        assertEquals(finisher, collector.finisher());
        assertEquals(characteristics, collector.characteristics());
    }
    @Test
    void testSupplier() {
        LangCollectors lc = new LangCollectors();
        Supplier<Integer> supplier = lc.supplier();
        
        assertNotNull(supplier);
    }
    
    @Test
    void testSimpleCollectorConstructor() {
        Supplier<Integer> supplier = () -> 0;
        BiConsumer<Integer, String> accumulator = (a, b) -> {};
        BinaryOperator<Integer> combiner = (a, b) -> 0;
        Function<Integer, String> finisher = Objects::toString;
        Set<Collector.Characteristics> characteristics = Collections.emptySet();
        
        LangCollectors.SimpleCollector<String, Integer, String> collector = new LangCollectors.SimpleCollector<>(supplier, accumulator, combiner, finisher, characteristics);
        
        assertNotNull(collector);
    }
    
    @Test
    void testSimpleCollectorAccumulator() {
        Supplier<Integer> supplier = () -> 0;
        BiConsumer<Integer, String> accumulator = (a, b) -> {};
        BinaryOperator<Integer> combiner = (a, b) -> 0;
        Function<Integer, String> finisher = Objects::toString;
        Set<Collector.Characteristics> characteristics = Collections.emptySet();
        
        LangCollectors.SimpleCollector<String, Integer, String> collector = new LangCollectors.SimpleCollector<>(supplier, accumulator, combiner, finisher, characteristics);
        
        BiConsumer<Integer, String> actualAccumulator = collector.accumulator();
        
        assertNotNull(actualAccumulator);
    }
    
    @Test
    void testSimpleCollectorCharacteristics() {
        Supplier<Integer> supplier = () -> 0;
        BiConsumer<Integer, String> accumulator = (a, b) -> {};
        BinaryOperator<Integer> combiner = (a, b) -> 0;
        Function<Integer, String> finisher = Objects::toString;
        Set<Collector.Characteristics> characteristics = Collections.emptySet();
        
        LangCollectors.SimpleCollector<String, Integer, String> collector = new LangCollectors.SimpleCollector<>(supplier, accumulator, combiner, finisher, characteristics);
        
        Set<Collector.Characteristics> actualCharacteristics = collector.characteristics();
        
        assertNotNull(actualCharacteristics);
    }
    
    @Test
    void testSimpleCollectorCombiner() {
        Supplier<Integer> supplier = () -> 0;
        BiConsumer<Integer, String> accumulator = (a, b) -> {};
        BinaryOperator<Integer> combiner = (a, b) -> 0;
        Function<Integer, String> finisher = Objects::toString;
        Set<Collector.Characteristics> characteristics = Collections.emptySet();
        
        LangCollectors.SimpleCollector<String, Integer, String> collector = new LangCollectors.SimpleCollector<>(supplier, accumulator, combiner, finisher, characteristics);
        
        BinaryOperator<Integer> actualCombiner = collector.combiner();
        
        assertNotNull(actualCombiner);
    }
    
    @Test
    void testSimpleCollectorFinisher() {
        Supplier<Integer> supplier = () -> 0;
        BiConsumer<Integer, String> accumulator = (a, b) -> {};
        BinaryOperator<Integer> combiner = (a, b) -> 0;
        Function<Integer, String> finisher = Objects::toString;
        Set<Collector.Characteristics> characteristics = Collections.emptySet();
        
        LangCollectors.SimpleCollector<String, Integer, String> collector = new LangCollectors.SimpleCollector<>(supplier, accumulator, combiner, finisher, characteristics);
        
        Function<Integer, String> actualFinisher = collector.finisher();
        
        assertNotNull(actualFinisher);
    }
    @Test
    void testAccumulator_EmptyInput() {
        SimpleCollector<String, StringBuilder, String> collector = new SimpleCollector<>(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append,
                StringBuilder::toString,
                Collections.emptySet()
        );
    
        StringBuilder result = collector.accumulator().apply(new StringBuilder(), "");
    
        assertEquals("", result.toString());
    }
    
    @Test
    void testAccumulator_NonEmptyInput() {
        SimpleCollector<String, StringBuilder, String> collector = new SimpleCollector<>(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append,
                StringBuilder::toString,
                Collections.emptySet()
        );
    
        StringBuilder result = collector.accumulator().apply(new StringBuilder(), "Hello");
    
        assertEquals("Hello", result.toString());
    }
    
    @Test
    void testAccumulator_Combiner() {
        SimpleCollector<String, StringBuilder, String> collector = new SimpleCollector<>(
                StringBuilder::new,
                StringBuilder::append,
                (s1, s2) -> s1.append(", ").append(s2),
                StringBuilder::toString,
                Collections.emptySet()
        );
    
        StringBuilder result = collector.combiner().apply(new StringBuilder("Hello"), new StringBuilder("World"));
    
        assertEquals("Hello, World", result.toString());
    }
    
    @Test
    void testAccumulator_Finisher() {
        SimpleCollector<String, StringBuilder, String> collector = new SimpleCollector<>(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append,
                StringBuilder::toString,
                Collections.emptySet()
        );
    
        String result = collector.finisher().apply(new StringBuilder("Hello"));
    
        assertEquals("Hello", result);
    }
    
    @Test
    void testAccumulator_Characteristics() {
        Set<Collector.Characteristics> characteristics = Collections.singleton(Collector.Characteristics.IDENTITY_FINISH);
        SimpleCollector<String, StringBuilder, String> collector = new SimpleCollector<>(
                StringBuilder::new,
                StringBuilder::append,
                StringBuilder::append,
                StringBuilder::toString,
                characteristics
        );
    
        Set<Collector.Characteristics> result = collector.characteristics();
    
        assertEquals(characteristics, result);
    }
    import org.junit.jupiter.api.Test;
    
    class LangCollectorsTest {
    
        @Test
        void testAccumulator() {
            // test code here
        }
    
        @Test
        void testCombiner() {
            // test code here
        }
    
        @Test
        void testFinisher() {
            // test code here
        }
    
        @Test
        void testSupplier() {
            // test code here
        }
    
        @Test
        void testCharacteristics() {
            // test code here
        }
    }

}