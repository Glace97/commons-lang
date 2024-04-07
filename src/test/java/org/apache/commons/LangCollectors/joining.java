import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class joiningTest {

    @Test
    void testJoining() {
        Collector<Object, ?, String> collector = LangCollectors.joining();
        String result = List.of("a", "b", "c").stream().collect(collector);
        assertEquals("abc", result);
    }

    @Test
    void testJoiningWithDelimiter() {
        Collector<Object, ?, String> collector = LangCollectors.joining(",");
        String result = List.of("a", "b", "c").stream().collect(collector);
        assertEquals("a,b,c", result);
    }

    @Test
    void testJoiningWithPrefixAndSuffix() {
        Collector<Object, ?, String> collector = LangCollectors.joining(",", "[", "]");
        String result = List.of("a", "b", "c").stream().collect(collector);
        assertEquals("[a,b,c]", result);
    }

    @Test
    void testJoiningWithToStringFunction() {
        Collector<Object, ?, String> collector = LangCollectors.joining(",", "[", "]", Object::toString);
        String result = List.of(1, 2, 3).stream().collect(collector);
        assertEquals("[1,2,3]", result);
    }
}