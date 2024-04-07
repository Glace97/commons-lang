import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ofTest {

    @Test
    void testOfWithNullValues() {
        MutablePair<String, Integer> pair = MutablePair.of(null, null);
        assertNull(pair.left);
        assertNull(pair.right);
    }

    @Test
    void testOfWithNonNullValues() {
        MutablePair<String, Integer> pair = MutablePair.of("Hello", 123);
        assertEquals("Hello", pair.left);
        assertEquals(123, pair.right);
    }

    @Test
    void testOfWithMapEntry() {
        Map.Entry<String, Integer> entry = Map.entry("Key", 456);
        MutablePair<String, Integer> pair = MutablePair.of(entry);
        assertEquals("Key", pair.left);
        assertEquals(456, pair.right);
    }

    @Test
    void testOfWithNullMapEntry() {
        MutablePair<String, Integer> pair = MutablePair.of(null);
        assertNull(pair.left);
        assertNull(pair.right);
    }
}