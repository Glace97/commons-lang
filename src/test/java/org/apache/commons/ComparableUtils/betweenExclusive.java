import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class betweenExclusiveTest {

    @Test
    void testBetweenExclusive() {
        ComparableUtils comparableUtils = new ComparableUtils();

        // Test when a is between b and c (exclusive)
        assertTrue(comparableUtils.betweenExclusive(5, 10, 15));
        assertTrue(comparableUtils.betweenExclusive(15, 10, 5));

        // Test when a is not between b and c (exclusive)
        assertFalse(comparableUtils.betweenExclusive(5, 15, 10));
        assertFalse(comparableUtils.betweenExclusive(15, 5, 10));

        // Test when a is equal to b or c
        assertFalse(comparableUtils.betweenExclusive(10, 10, 15));
        assertFalse(comparableUtils.betweenExclusive(15, 10, 10));

        // Test when b and c are equal
        assertFalse(comparableUtils.betweenExclusive(5, 10, 10));
        assertFalse(comparableUtils.betweenExclusive(10, 10, 5));

        // Test when a is less than b and c
        assertFalse(comparableUtils.betweenExclusive(5, 10, 15));
        assertFalse(comparableUtils.betweenExclusive(15, 10, 5));

        // Test when a is greater than b and c
        assertFalse(comparableUtils.betweenExclusive(15, 10, 5));
        assertFalse(comparableUtils.betweenExclusive(5, 10, 15));
    }
}