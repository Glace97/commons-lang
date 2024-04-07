import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class nextIntTest {

    @Test
    @DisplayName("Test nextInt() method with default range")
    void testNextInt() {
        int result = RandomUtils.nextInt();
        assertTrue(result >= 0 && result < Integer.MAX_VALUE,
                "Returned value should be within the range of 0 (inclusive) to Integer.MAX_VALUE (exclusive).");
    }

    @Test
    @DisplayName("Test nextInt(startInclusive, endExclusive) method with valid range")
    void testNextIntInRange() {
        int startInclusive = 5;
        int endExclusive = 10;
        int result = RandomUtils.nextInt(startInclusive, endExclusive);
        assertTrue(result >= startInclusive && result < endExclusive,
                "Returned value should be within the specified range.");
    }

    @Test
    @DisplayName("Test nextInt(startInclusive, endExclusive) method with invalid range")
    void testNextIntInvalidRange() {
        int startInclusive = 10;
        int endExclusive = 5;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                RandomUtils.nextInt(startInclusive, endExclusive));
        assertEquals("Start value must be smaller or equal to end value.", exception.getMessage(),
                "Exception message should match the expected error message.");
    }

    @Test
    @DisplayName("Test nextInt(startInclusive, endExclusive) method with negative range values")
    void testNextIntNegativeRange() {
        int startInclusive = -5;
        int endExclusive = -2;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                RandomUtils.nextInt(startInclusive, endExclusive));
        assertEquals("Both range values must be non-negative.", exception.getMessage(),
                "Exception message should match the expected error message.");
    }

    @Test
    @DisplayName("Test nextInt(startInclusive, startInclusive) method with equal start and end values")
    void testNextIntEqualRange() {
        int startInclusive = 5;
        int endExclusive = 5;
        int result = RandomUtils.nextInt(startInclusive, endExclusive);
        assertEquals(startInclusive, result,
                "Returned value should be equal to the startInclusive value when startInclusive and endExclusive are equal.");
    }
}