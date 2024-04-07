import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class CombinerTest {

    @Test
    void testCombiner() {
        Supplier<StringJoiner> supplier = () -> new StringJoiner("-");
        BiConsumer<StringJoiner, String> accumulator = (stringJoiner, s) -> stringJoiner.add(s);
        BinaryOperator<StringJoiner> combiner = (stringJoiner1, stringJoiner2) -> stringJoiner1.merge(stringJoiner2);
        Function<StringJoiner, String> finisher = StringJoiner::toString;
        Set<Collector.Characteristics> characteristics = Collections.emptySet();

        Collector<String, StringJoiner, String> collector = new SimpleCollector<>(supplier, accumulator, combiner, finisher, characteristics);

        List<String> strings = Arrays.asList("Hello", "World", "JUnit", "5");
        String result = strings.stream().collect(collector);

        String expected = "Hello-World-JUnit-5";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testEmptyCombiner() {
        Supplier<StringJoiner> supplier = () -> new StringJoiner("-");
        BiConsumer<StringJoiner, String> accumulator = (stringJoiner, s) -> stringJoiner.add(s);
        BinaryOperator<StringJoiner> combiner = (stringJoiner1, stringJoiner2) -> stringJoiner1.merge(stringJoiner2);
        Function<StringJoiner, String> finisher = StringJoiner::toString;
        Set<Collector.Characteristics> characteristics = Collections.emptySet();

        Collector<String, StringJoiner, String> collector = new SimpleCollector<>(supplier, accumulator, combiner, finisher, characteristics);

        List<String> strings = Collections.emptyList();
        String result = strings.stream().collect(collector);

        String expected = "";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testParallelCombiner() {
        Supplier<StringJoiner> supplier = () -> new StringJoiner("-");
        BiConsumer<StringJoiner, String> accumulator = (stringJoiner, s) -> stringJoiner.add(s);
        BinaryOperator<StringJoiner> combiner = (stringJoiner1, stringJoiner2) -> stringJoiner1.merge(stringJoiner2);
        Function<StringJoiner, String> finisher = StringJoiner::toString;
        Set<Collector.Characteristics> characteristics = Collections.singleton(Collector.Characteristics.UNORDERED);

        Collector<String, StringJoiner, String> collector = new SimpleCollector<>(supplier, accumulator, combiner, finisher, characteristics);

        List<String> strings = Arrays.asList("Hello", "World", "JUnit", "5");
        String result = strings.parallelStream().collect(collector);

        String expected = "Hello-World-JUnit-5";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void testCombinerWithDuplicates() {
        Supplier<StringJoiner> supplier = () -> new StringJoiner("-");
        BiConsumer<StringJoiner, String> accumulator = (stringJoiner, s) -> stringJoiner.add(s);
        BinaryOperator<StringJoiner> combiner = (stringJoiner1, stringJoiner2) -> stringJoiner1.merge(stringJoiner2);
        Function<StringJoiner, String> finisher = StringJoiner::toString;
        Set<Collector.Characteristics> characteristics = Collections.emptySet();

        Collector<String, StringJoiner, String> collector = new SimpleCollector<>(supplier, accumulator, combiner, finisher, characteristics);

        List<String> strings = Arrays.asList("Hello", "World", "Hello", "JUnit", "5");
        String result = strings.stream().collect(collector);

        String expected = "Hello-World-Hello-JUnit-5";
        Assertions.assertEquals(expected, result);
    }
}