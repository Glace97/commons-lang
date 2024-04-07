import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ofTest {

    ImmutablePair<String, Integer> pair;

    @BeforeEach
    void setUp() {
        pair = null;
    }

    @Test
    void testOfWithNonNullValues() {
        String left = "left";
        Integer right = 10;

        pair = ImmutablePair.of(left, right);

        assertNotNull(pair);
        assertEquals(left, pair.left);
        assertEquals(right, pair.right);
    }

    @Test
    void testOfWithNullValues() {
        pair = ImmutablePair.of(null, null);

        assertNotNull(pair);
        assertNull(pair.left);
        assertNull(pair.right);
    }

    @Test
    void testOfWithLeftNull() {
        String right = "right";

        pair = ImmutablePair.of(null, right);

        assertNotNull(pair);
        assertNull(pair.left);
        assertEquals(right, pair.right);
    }

    @Test
    void testOfWithRightNull() {
        String left = "left";

        pair = ImmutablePair.of(left, null);

        assertNotNull(pair);
        assertEquals(left, pair.left);
        assertNull(pair.right);
    }

    @Test
    void testOfWithMapEntry() {
        Map.Entry<String, Integer> entry = Map.entry("key", 100);

        pair = ImmutablePair.of(entry);

        assertNotNull(pair);
        assertEquals(entry.getKey(), pair.left);
        assertEquals(entry.getValue(), pair.right);
    }

    @Test
    void testOfWithNullMapEntry() {
        pair = ImmutablePair.of((Map.Entry<String, Integer>) null);

        assertNotNull(pair);
        assertNull(pair.left);
        assertNull(pair.right);
    }
}