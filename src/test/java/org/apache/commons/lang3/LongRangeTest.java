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


import org.junit.jupiter.api.*;

public class LongRangeTest {
    @Test
    void testOfWithLongs() {
        LongRange range = LongRange.of(1L, 10L);
        Assertions.assertEquals(1L, range.getMinimum());
        Assertions.assertEquals(10L, range.getMaximum());
    }
    
    @Test
    void testOfWithLongObjects() {
        LongRange range = LongRange.of(Long.valueOf(1L), Long.valueOf(10L));
        Assertions.assertEquals(1L, range.getMinimum());
        Assertions.assertEquals(10L, range.getMaximum());
    }

    @Test
    void testOfWithReversedOrder() {
        LongRange range = LongRange.of(10L, 1L);
        Assertions.assertEquals(1L, range.getMinimum());
        Assertions.assertEquals(10L, range.getMaximum());
    }

}