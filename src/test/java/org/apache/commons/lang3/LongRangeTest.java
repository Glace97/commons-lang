package org.apache.commons.lang3;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

public class LongRangeTest {

    @Test
    public void testOf_withLongParameters_shouldReturnRangeObject() {
        // Instantiate all necessary variables here
        long fromInclusive = 0;
        long toInclusive = 10;

        // Write the test code here following the given rules
        LongRange range = LongRange.of(fromInclusive, toInclusive);

        assertNotNull(range);
        assertEquals(fromInclusive, range.getMinimum());
        assertEquals(toInclusive, range.getMaximum());
    }

    @Test
    public void testOf_withLongWrapperParameters_shouldReturnRangeObject() {
        // Instantiate all necessary variables here
        Long fromInclusive = Long.valueOf(0);
        Long toInclusive = Long.valueOf(10);

        // Write the test code here following the given rules
        LongRange range = LongRange.of(fromInclusive, toInclusive);

        assertNotNull(range);
        assertEquals(fromInclusive, range.getMinimum());
        assertEquals(toInclusive, range.getMaximum());
    }
}