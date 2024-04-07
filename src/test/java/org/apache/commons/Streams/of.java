import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ofTest {

    @Test
    @DisplayName("Test of(Collection<E> collection) - Collection is null")
    void testOfCollectionIsNull() {
        List<String> collection = null;
        Stream<String> stream = Streams.of(collection);
        Assertions.assertEquals(0, stream.count());
    }

    @Test
    @DisplayName("Test of(Collection<E> collection) - Collection is not null")
    void testOfCollectionIsNotNull() {
        List<String> collection = Arrays.asList("a", "b", "c");
        Stream<String> stream = Streams.of(collection);
        List<String> result = stream.collect(Collectors.toList());
        Assertions.assertEquals(collection, result);
    }

    @Test
    @DisplayName("Test of(Enumeration<E> enumeration) - Enumeration is null")
    void testOfEnumerationIsNull() {
        Enumeration<String> enumeration = null;
        Stream<String> stream = Streams.of(enumeration);
        Assertions.assertEquals(0, stream.count());
    }

    @Test
    @DisplayName("Test of(Enumeration<E> enumeration) - Enumeration is not null")
    void testOfEnumerationIsNotNull() {
        Enumeration<String> enumeration = Collections.enumeration(Arrays.asList("a", "b", "c"));
        Stream<String> stream = Streams.of(enumeration);
        List<String> result = stream.collect(Collectors.toList());
        Assertions.assertEquals(Arrays.asList("a", "b", "c"), result);
    }

    @Test
    @DisplayName("Test of(Iterable<E> iterable) - Iterable is null")
    void testOfIterableIsNull() {
        Iterable<String> iterable = null;
        Stream<String> stream = Streams.of(iterable);
        Assertions.assertEquals(0, stream.count());
    }

    @Test
    @DisplayName("Test of(Iterable<E> iterable) - Iterable is not null")
    void testOfIterableIsNotNull() {
        Iterable<String> iterable = Arrays.asList("a", "b", "c");
        Stream<String> stream = Streams.of(iterable);
        List<String> result = stream.collect(Collectors.toList());
        Assertions.assertEquals(Arrays.asList("a", "b", "c"), result);
    }

    @Test
    @DisplayName("Test of(Iterator<E> iterator) - Iterator is null")
    void testOfIteratorIsNull() {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        Iterator<String> iterator = null;
        Stream<String> stream = Streams.of(iterator);
        Assertions.assertEquals(0, stream.count());
    }

    @Test
    @DisplayName("Test of(Iterator<E> iterator) - Iterator is not null")
    void testOfIteratorIsNotNull() {
        List<String> list = new ArrayList<>(Arrays.asList("a", "b", "c"));
        Iterator<String> iterator = list.iterator();
        Stream<String> stream = Streams.of(iterator);
        List<String> result = stream.collect(Collectors.toList());
        Assertions.assertEquals(list, result);
    }

    @Test
    @DisplayName("Test of(T... values) - Values is null")
    void testOfValuesIsNull() {
        String[] values = null;
        Stream<String> stream = Streams.of(values);
        Assertions.assertEquals(0, stream.count());
    }

    @Test
    @DisplayName("Test of(T... values) - Values is not null")
    void testOfValuesIsNotNull() {
        String[] values = {"a", "b", "c"};
        Stream<String> stream = Streams.of(values);
        List<String> result = stream.collect(Collectors.toList());
        Assertions.assertEquals(Arrays.asList("a", "b", "c"), result);
    }
}