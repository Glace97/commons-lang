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
    void testOf_withNullValues_shouldThrowIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            DoubleRange.of(null, 10.0);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            DoubleRange.of(1.0, null);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            DoubleRange.of(null, null);
        });
    }
    
    @Test
    void testConstructor_withNullValues_shouldThrowNullPointerException() {
        assertThrows(NullPointerException.class, () -> {
            new DoubleRange(null, 10.0);
        });
        assertThrows(NullPointerException.class, () -> {
            new DoubleRange(1.0, null);
        });
        assertThrows(NullPointerException.class, () -> {
            new DoubleRange(null, null);
        });
    }
    
    @Test
    void testGetMinimum_withRangeInAscendingOrder_shouldReturnCorrectValue() {
        assertEquals(1.0, range.getMinimum());
    }
    
    @Test
    void testGetMinimum_withRangeInDescendingOrder_shouldReturnCorrectValue() {
        range = new DoubleRange(10.0, 1.0);
        assertEquals(1.0, range.getMinimum());
    }
    
    @Test
    void testGetMaximum_withRangeInAscendingOrder_shouldReturnCorrectValue() {
        assertEquals(10.0, range.getMaximum());
    }
    
    @Test
    void testGetMaximum_withRangeInDescendingOrder_shouldReturnCorrectValue() {
        range = new DoubleRange(10.0, 1.0);
        assertEquals(10.0, range.getMaximum());
    }

}