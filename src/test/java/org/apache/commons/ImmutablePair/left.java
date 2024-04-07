import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class leftTest {

    @Test
    void testLeft() {
        // Test with non-null left value
        Integer leftValue = 10;
        ImmutablePair<Integer, String> pair = ImmutablePair.left(leftValue);
        assertEquals(leftValue, pair.left);
        assertNull(pair.right);

        // Test with null left value
        pair = ImmutablePair.left(null);
        assertNull(pair.left);
        assertNull(pair.right);
    }
}