import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class instancesOfTest {

    private List<Object> collection;

    @BeforeEach
    void setUp() {
        collection = new ArrayList<>();
    }

    @Test
    void testInstancesOf_WithNullCollection_ShouldReturnEmptyStream() {
        Stream<Object> stream = Streams.instancesOf(String.class, null);

        assertTrue(stream.isEmpty());
    }

    @Test
    void testInstancesOf_WithEmptyCollection_ShouldReturnEmptyStream() {
        Stream<Object> stream = Streams.instancesOf(String.class, collection);

        assertTrue(stream.isEmpty());
    }

    @Test
    void testInstancesOf_WithCollectionContainingNoInstancesOfGivenClass_ShouldReturnEmptyStream() {
        collection.add(1);
        collection.add(2);
        collection.add(3);

        Stream<Object> stream = Streams.instancesOf(String.class, collection);

        assertTrue(stream.isEmpty());
    }

    @Test
    void testInstancesOf_WithCollectionContainingInstancesOfGivenClass_ShouldReturnStreamWithOnlyInstancesOfGivenClass() {
        String str1 = "Hello";
        String str2 = "World";
        collection.add(str1);
        collection.add(1);
        collection.add(str2);

        Stream<String> stream = Streams.instancesOf(String.class, collection);

        assertEquals(Arrays.asList(str1, str2), stream.collect(Collectors.toList()));
    }
}