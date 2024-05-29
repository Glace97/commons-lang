
package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class LongRangeTest {
    @Test
    void of_WhenBothArgumentsArePositiveLongs_ShouldReturnCorrectRange() {
        LongRange range = LongRange.of(5L, 10L);
        assertEquals(Long.valueOf(5L), range.getMinimum());
        assertEquals(Long.valueOf(10L), range.getMaximum());
    }

    @Test
    void of_WhenBothArgumentsAreNegativeLongs_ShouldReturnCorrectRange() {
        LongRange range = LongRange.of(-5L, -10L);
        assertEquals(Long.valueOf(-10L), range.getMinimum());
        assertEquals(Long.valueOf(-5L), range.getMaximum());
    }

    @Test
    void of_WhenArgumentsAreSwapped_ShouldReturnCorrectRange() {
        LongRange range = LongRange.of(10L, 5L);
        assertEquals(Long.valueOf(5L), range.getMinimum());
        assertEquals(Long.valueOf(10L), range.getMaximum());
    }

    @Test
    void of_WhenBothArgumentsAreSameLongs_ShouldReturnCorrectRange() {
        LongRange range = LongRange.of(5L, 5L);
        assertEquals(Long.valueOf(5L), range.getMinimum());
        assertEquals(Long.valueOf(5L), range.getMaximum());
    }

    //@Test
    void of_WhenFirstArgumentIsNull_ShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> LongRange.of(null, 10L));
    }

    //@Test
    void of_WhenSecondArgumentIsNull_ShouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> LongRange.of(5L, null));
    }
}
