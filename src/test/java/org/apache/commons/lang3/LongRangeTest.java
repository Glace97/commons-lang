package org.apache.commons.lang3;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LongRangeTest {

    @Test
    public void testOfWithNormalOrder() {
        // Test normal order (min, max)
        Long min = 1L;
        Long max = 10L;
        LongRange range = LongRange.of(min, max);

        assertEquals(min, range.getMinimum());
        assertEquals(max, range.getMaximum());
    }

    @Test
    public void testOfWithReverseOrder() {
        // Test reverse order (max, min)
        Long min = 1L;
        Long max = 10L;
        LongRange range = LongRange.of(max, min);

        assertEquals(min, range.getMinimum());
        assertEquals(max, range.getMaximum());
    }

    @Test
    public void testOfWithEqualValues() {
        // Test with equal min and max values
        Long value = 5L;
        LongRange range = LongRange.of(value, value);

        assertEquals(value, range.getMinimum());
        assertEquals(value, range.getMaximum());
    }

    @Test
    public void testOfWithNullFirstArgument() {
        // Test passing null as the first argument
        Long max = 10L;
        assertThrows(NullPointerException.class, () -> {
            LongRange.of(null, max);
        });
    }

    @Test
    public void testOfWithNullSecondArgument() {
        // Test passing null as the second argument
        Long min = 1L;
        assertThrows(NullPointerException.class, () -> {
            LongRange.of(min, null);
        });
    }

    @Test
    public void testOfWithBothArgumentsNull() {
        // Test passing null for both arguments
        assertThrows(NullPointerException.class, () -> {
            LongRange.of(null, null);
        });
    }

    @Test
    public void testOfWithExtremes() {
        // Test with extreme long values
        Long min = Long.MIN_VALUE;
        Long max = Long.MAX_VALUE;
        LongRange range = LongRange.of(min, max);

        assertEquals(min, range.getMinimum());
        assertEquals(max, range.getMaximum());
    }
}
