package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class DoubleRangeTest {
    @Test
    void testOf_withDoubleValues_shouldCreateDoubleRange() {
        DoubleRange result = DoubleRange.of(5.0, 15.0);
        assertNotNull(result);
        assertEquals(5.0, result.getMinimum());
        assertEquals(15.0, result.getMaximum());
    }

    @Test
    void testCreationFromInclusive() {
        DoubleRange range = DoubleRange.of(1.0, 5.0);
        assertAll(
                () -> assertEquals(1.0, range.getMinimum()),
                () -> assertEquals(5.0, range.getMaximum())
        );
    }

    @Test
    void testEquality() {
        DoubleRange range1 = DoubleRange.of(1.0, 5.0);
        DoubleRange range2 = DoubleRange.of(1.0, 5.0);
        assertEquals(range1, range2);
    }

    @Test
    void testInequality() {
        DoubleRange range1 = DoubleRange.of(1.0, 5.0);
        DoubleRange range2 = DoubleRange.of(2.0, 6.0);
        assertNotEquals(range1, range2);
    }

    @Test
    void testBoundaryValuesInclusive() {
        DoubleRange range = DoubleRange.of(1.0, 5.0);
        assertTrue(range.contains(1.0));
        assertTrue(range.contains(5.0));
    }

    @Test
    void testBoundaryValuesExclusive() {
        DoubleRange range = DoubleRange.of(1.0, 5.0);
        assertFalse(range.contains(0.9));
        assertFalse(range.contains(5.1));
    }
}