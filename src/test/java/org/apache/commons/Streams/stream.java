import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StreamTest {

    @Test
    void testAllMatch() {
        // Test when the stream is empty
        FailableStream<Integer> stream = Failable.stream(Collections.emptyList().stream());
        assertTrue(stream.allMatch(i -> i > 0));

        // Test when all elements match the predicate
        stream = Failable.stream(Stream.of(1, 2, 3, 4));
        assertTrue(stream.allMatch(i -> i > 0));

        // Test when some elements do not match the predicate
        stream = Failable.stream(Stream.of(1, 2, -3, 4));
        assertFalse(stream.allMatch(i -> i > 0));
    }

    @Test
    void testAnyMatch() {
        // Test when the stream is empty
        FailableStream<Integer> stream = Failable.stream(Collections.emptyList().stream());
        assertFalse(stream.anyMatch(i -> i > 0));

        // Test when some elements match the predicate
        stream = Failable.stream(Stream.of(1, 2, -3, 4));
        assertTrue(stream.anyMatch(i -> i > 0));

        // Test when no elements match the predicate
        stream = Failable.stream(Stream.of(-1, -2, -3, -4));
        assertFalse(stream.anyMatch(i -> i > 0));
    }

    @Test
    void testFilter() {
        // Test when the stream is empty
        FailableStream<Integer> stream = Failable.stream(Collections.emptyList().stream());
        FailableStream<Integer> filtered = stream.filter(i -> i > 0);
        assertTrue(filtered.stream().count() == 0);

        // Test when some elements match the predicate
        stream = Failable.stream(Stream.of(1, 2, -3, 4));
        filtered = stream.filter(i -> i > 0);
        assertTrue(filtered.stream().count() == 3);
        assertTrue(filtered.stream().allMatch(i -> i > 0));

        // Test when no elements match the predicate
        stream = Failable.stream(Stream.of(-1, -2, -3, -4));
        filtered = stream.filter(i -> i > 0);
        assertTrue(filtered.stream().count() == 0);
    }

    @Test
    void testForEach() {
        // Test when the stream is empty
        FailableStream<Integer> stream = Failable.stream(Collections.emptyList().stream());
        stream.forEach(i -> {
            fail("Should not be called");
        });

        // Test when the stream has elements
        stream = Failable.stream(Stream.of(1, 2, 3, 4));
        List<Integer> result = new ArrayList<>();
        stream.forEach(i -> {
            result.add(i);
        });
        assertEquals(Arrays.asList(1, 2, 3, 4), result);
    }

    @Test
    void testMap() {
        // Test when the stream is empty
        FailableStream<Integer> stream = Failable.stream(Collections.emptyList().stream());
        FailableStream<String> mapped = stream.map(Object::toString);
        assertTrue(mapped.stream().count() == 0);

        // Test when the stream has elements
        stream = Failable.stream(Stream.of(1, 2, 3, 4));
        mapped = stream.map(Object::toString);
        List<String> result = mapped.collect(Collectors.toList());
        assertEquals(Arrays.asList("1", "2", "3", "4"), result);
    }

    @Test
    void testReduce() {
        // Test when the stream is empty
        FailableStream<Integer> stream = Failable.stream(Collections.emptyList().stream());
        Integer result = stream.reduce(0, Integer::sum);
        assertEquals(0, result);

        // Test when the stream has elements
        stream = Failable.stream(Stream.of(1, 2, 3, 4));
        result = stream.reduce(0, Integer::sum);
        assertEquals(10, result);
    }
}