import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class finisherTest {

    @Test
    void testFinisher() {
        // Test case 1: finisher returns null when input is null
        LangCollectors.SimpleCollector<Object, Object, Object> collector = new LangCollectors.SimpleCollector<>(Object::new, null, null, null, null);
        Function<Object, Object> finisher = collector.finisher();
        assertNull(finisher.apply(null));

        // Test case 2: finisher returns the input object when input is not null
        Object input = new Object();
        assertEquals(input, finisher.apply(input));

        // Test case 3: finisher returns a concatenated string when input is a set of strings
        Set<String> stringSet = Set.of("Hello", "World");
        LangCollectors.SimpleCollector<String, StringJoiner, String> stringCollector = new LangCollectors.SimpleCollector<>(StringJoiner::new, StringJoiner::add, StringJoiner::merge, StringJoiner::toString, null);
        Function<StringJoiner, String> stringFinisher = stringCollector.finisher();
        String expectedString = stringSet.stream().collect(stringCollector);
        assertEquals(expectedString, stringFinisher.apply(stringSet.stream().collect(stringCollector)));
    }
}