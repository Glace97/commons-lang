
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

class failableStreamTest {

    @Test
    void testFailableStream_withCollection() {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
        FailableStream<Integer> stream = Streams.failableStream(values);

        assertEquals(values, stream.stream().collect(Collectors.toList()));
    }

    @Test
    void testFailableStream_withStream() {
        Stream<Integer> values = Stream.of(1, 2, 3, 4, 5);
        FailableStream<Integer> stream = Streams.failableStream(values);

        assertEquals(values.collect(Collectors.toList()), stream.stream().collect(Collectors.toList()));
    }

    @Test
    void testFailableStream_withArray() {
        Integer[] values = {1, 2, 3, 4, 5};
        FailableStream<Integer> stream = Streams.failableStream(values);

        assertEquals(Arrays.asList(values), stream.stream().collect(Collectors.toList()));
    }

    @Test
    void testFilter() {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
        FailableStream<Integer> stream = Streams.failableStream(values);

        FailablePredicate<Integer, ?> predicate = (n) -> n % 2 == 0;
        List<Integer> filteredValues = values.stream().filter(predicate).collect(Collectors.toList());
        List<Integer> filteredStreamValues = stream.filter(predicate).stream().collect(Collectors.toList());

        assertEquals(filteredValues, filteredStreamValues);
    }

    @Test
    void testMap() {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
        FailableStream<Integer> stream = Streams.failableStream(values);

        FailableFunction<Integer, String, ?> mapper = (n) -> n.toString();
        List<String> mappedValues = values.stream().map(mapper).collect(Collectors.toList());
        List<String> mappedStreamValues = stream.map(mapper).stream().collect(Collectors.toList());

        assertEquals(mappedValues, mappedStreamValues);
    }

    @Test
    void testCollect() {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
        FailableStream<Integer> stream = Streams.failableStream(values);

        Collector<Integer, ?, List<Integer>> collector = Collectors.toList();
        List<Integer> collectedValues = values.stream().collect(collector);
        List<Integer> collectedStreamValues = stream.collect(collector);

        assertEquals(collectedValues, collectedStreamValues);
    }

    @Test
    void testForEach() {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
        FailableStream<Integer> stream = Streams.failableStream(values);

        List<Integer> result = new ArrayList<>();
        FailableConsumer<Integer, ?> consumer = (n) -> result.add(n);
        values.stream().forEach(consumer);
        stream.forEach(consumer);

        assertEquals(values, result);
    }

    @Test
    void testAnyMatch() {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
        FailableStream<Integer> stream = Streams.failableStream(values);

        FailablePredicate<Integer, ?> predicate = (n) -> n > 3;
        boolean anyMatch = values.stream().anyMatch(predicate);
        boolean streamAnyMatch = stream.anyMatch(predicate);

        assertEquals(anyMatch, streamAnyMatch);
    }

    @Test
    void testAllMatch() {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
        FailableStream<Integer> stream = Streams.failableStream(values);

        FailablePredicate<Integer, ?> predicate = (n) -> n <= 5;
        boolean allMatch = values.stream().allMatch(predicate);
        boolean streamAllMatch = stream.allMatch(predicate);

        assertEquals(allMatch, streamAllMatch);
    }

    @Test
    void testReduce() {
        List<Integer> values = Arrays.asList(1, 2, 3, 4, 5);
        FailableStream<Integer> stream = Streams.failableStream(values);

        BinaryOperator<Integer> accumulator = (a, b) -> a + b;
        Integer reduce = values.stream().reduce(0, accumulator);
        Integer streamReduce = stream.reduce(0, accumulator);

        assertEquals(reduce, streamReduce);
    }
}
