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

public class IntegerRangeTest {
    @Test
    void testOf_withValidRange_shouldCreateRangeObject() {
        IntegerRange range = IntegerRange.of(1, 10);
        Assertions.assertNotNull(range);
    }
    
    @Test
    void testOf_withNullValues_shouldThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IntegerRange.of(null, 10);
        });
        
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IntegerRange.of(1, null);
        });
    }
    
    @Test
    void testOf_withEqualValues_shouldCreateRangeObjectWithSameMinimumAndMaximum() {
        IntegerRange range = IntegerRange.of(5, 5);
        Assertions.assertEquals(5, range.getMinimum());
        Assertions.assertEquals(5, range.getMaximum());
    }
    
    @Test
    void testOf_withReverseOrder_shouldCreateRangeObjectWithCorrectMinimumAndMaximum() {
        IntegerRange range1 = IntegerRange.of(10, 1);
        Assertions.assertEquals(1, range1.getMinimum());
        Assertions.assertEquals(10, range1.getMaximum());
    
        IntegerRange range2 = IntegerRange.of(1, 10);
        Assertions.assertEquals(1, range2.getMinimum());
        Assertions.assertEquals(10, range2.getMaximum());
    }
    
    @Test
    void testOf_withMaxIntValues_shouldCreateRangeObject() {
        IntegerRange range = IntegerRange.of(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Assertions.assertNotNull(range);
        Assertions.assertEquals(Integer.MAX_VALUE, range.getMinimum());
        Assertions.assertEquals(Integer.MAX_VALUE, range.getMaximum());
    }
    
    @Test
    void testOf_withMinIntValues_shouldCreateRangeObject() {
        IntegerRange range = IntegerRange.of(Integer.MIN_VALUE, Integer.MIN_VALUE);
        Assertions.assertNotNull(range);
        Assertions.assertEquals(Integer.MIN_VALUE, range.getMinimum());
        Assertions.assertEquals(Integer.MIN_VALUE, range.getMaximum());
    }
    
    @Test
    void testOf_withMixedValues_shouldCreateRangeObjectWithCorrectMinimumAndMaximum() {
        IntegerRange range1 = IntegerRange.of(Integer.MIN_VALUE, Integer.MAX_VALUE);
        Assertions.assertEquals(Integer.MIN_VALUE, range1.getMinimum());
        Assertions.assertEquals(Integer.MAX_VALUE, range1.getMaximum());
    
        IntegerRange range2 = IntegerRange.of(Integer.MAX_VALUE, Integer.MIN_VALUE);
        Assertions.assertEquals(Integer.MIN_VALUE, range2.getMinimum());
        Assertions.assertEquals(Integer.MAX_VALUE, range2.getMaximum());
    }
    
    @Test
    void testOf_withNegativeValues_shouldCreateRangeObjectWithCorrectMinimumAndMaximum() {
        IntegerRange range = IntegerRange.of(-10, -1);
        Assertions.assertEquals(-10, range.getMinimum());
        Assertions.assertEquals(-1, range.getMaximum());
    }
    
    @Test
    void testOf_withZeroValues_shouldCreateRangeObjectWithCorrectMinimumAndMaximum() {
        IntegerRange range = IntegerRange.of(0, 0);
        Assertions.assertEquals(0, range.getMinimum());
        Assertions.assertEquals(0, range.getMaximum());
    }

}