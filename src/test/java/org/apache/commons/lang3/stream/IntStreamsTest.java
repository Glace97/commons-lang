package org.apache.commons.lang3.stream;

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

public class IntStreamsTest {
    @Test
    void testRangeClosedWithPositiveNumber() {
        int endInclusive = 5;
        IntStream result = IntStreams.rangeClosed(endInclusive);
        assertNotNull(result);
        assertEquals(endInclusive + 1, result.count());
        assertTrue(result.allMatch(n -> n >= 0 && n <= endInclusive));
    }
    
    @Test
    void testRangeClosedWithZero() {
        int endInclusive = 0;
        IntStream result = IntStreams.rangeClosed(endInclusive);
        assertNotNull(result);
        assertEquals(endInclusive + 1, result.count());
        assertTrue(result.allMatch(n -> n >= 0 && n <= endInclusive));
    }
    
    @Test
    void testRangeClosedWithNegativeNumber() {
        int endInclusive = -5;
        IntStream result = IntStreams.rangeClosed(endInclusive);
        assertNotNull(result);
        assertEquals(Math.abs(endInclusive) + 1, result.count());
        assertTrue(result.allMatch(n -> n >= endInclusive && n <= 0));
    }
    
    @Test
    void testRangeClosedWithMaxInt() {
        int endInclusive = Integer.MAX_VALUE;
        IntStream result = IntStreams.rangeClosed(endInclusive);
        assertNotNull(result);
        assertEquals(endInclusive + 1, result.count());
        assertTrue(result.allMatch(n -> n >= 0 && n <= endInclusive));
    }
    
    @Test
    void testRangeClosedWithMinInt() {
        int endInclusive = Integer.MIN_VALUE;
        IntStream result = IntStreams.rangeClosed(endInclusive);
        assertNotNull(result);
        assertEquals(Math.abs(endInclusive) + 1, result.count());
        assertTrue(result.allMatch(n -> n >= endInclusive && n <= 0));
    }
    @Test
    @DisplayName("Testing range method with endExclusive = 0")
    void testRangeWithZeroEndExclusive() {
        IntStream result = IntStreams.range(0);
        assertEquals(0, result.count());
    }
    
    @Test
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    @DisplayName("Testing range method with positive endExclusive")
    void testRangeWithPositiveEndExclusive(int endExclusive) {
        IntStream result = IntStreams.range(endExclusive);
        assertEquals(endExclusive, result.count());
    }
    
    @Test
    @ParameterizedTest
    @ValueSource(ints = {-10, -1})
    @DisplayName("Testing range method with negative endExclusive")
    void testRangeWithNegativeEndExclusive(int endExclusive) {
        assertThrows(IllegalArgumentException.class, () -> IntStreams.range(endExclusive));
    }

}