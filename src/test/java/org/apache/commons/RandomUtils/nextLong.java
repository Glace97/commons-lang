import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class nextLongTest {

    @Test
    void testNextLong() {
        long result = RandomUtils.nextLong();
        assertTrue(result >= 0 && result < Long.MAX_VALUE, "Generated value is out of range.");
    }

    @Test
    void testNextLongInRange() {
        long startInclusive = 10;
        long endExclusive = 20;
        long result = RandomUtils.nextLong(startInclusive, endExclusive);
        assertTrue(result >= startInclusive && result < endExclusive, "Generated value is out of range.");
    }

    @Test
    void testNextLongEqualRange() {
        long startInclusive = 10;
        long endExclusive = 10;
        long result = RandomUtils.nextLong(startInclusive, endExclusive);
        assertEquals(startInclusive, result, "Generated value is not equal to startInclusive.");
    }

    @Test
    void testNextLongInvalidRange() {
        long startInclusive = 20;
        long endExclusive = 10;
        assertThrows(IllegalArgumentException.class, () -> RandomUtils.nextLong(startInclusive, endExclusive), "IllegalArgumentException not thrown for invalid range.");
    }
    
    @Test
    void testNextLongHighCoverage() {
        long startInclusive = 0;
        long endExclusive = Long.MAX_VALUE;
        long result = RandomUtils.nextLong(startInclusive, endExclusive);
        assertTrue(result >= startInclusive && result < endExclusive, "Generated value is out of range.");
    }
}