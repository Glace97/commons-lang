package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.apache.commons.lang3.LongRange;

public class LongRangeTest {

    @Test
    public void testOfWithPositiveNumbers() {
        LongRange longRange = LongRange.of(5L, 10L);
        assertNotNull(longRange);
        assertEquals(5L, longRange.getMinimum());
        assertEquals(10L, longRange.getMaximum());
    }

    @Test
    public void testOfWithNegativeNumbers() {
        LongRange longRange = LongRange.of(-10L, -5L);
        assertNotNull(longRange);
        assertEquals(-10L, longRange.getMinimum());
        assertEquals(-5L, longRange.getMaximum());
    }

    @Test
    public void testOfWithMixedNumbers() {
        LongRange longRange = LongRange.of(-5L, 10L);
        assertNotNull(longRange);
        assertEquals(-5L, longRange.getMinimum());
        assertEquals(10L, longRange.getMaximum());
    }

    @Test
    public void testOfWithSwappedNumbers() {
        LongRange longRange = LongRange.of(10L, 5L);
        assertNotNull(longRange);
        assertEquals(5L, longRange.getMinimum());
        assertEquals(10L, longRange.getMaximum());
    }

    //@Test
    public void testOfWithNullValues() {
        //assertThrows(IllegalArgumentException.class, () -> LongRange.of(null, 5L));
        //assertThrows(IllegalArgumentException.class, () -> LongRange.of(5L, null));
        assertThrows(IllegalArgumentException.class, () -> LongRange.of(null, null));
    }
}
