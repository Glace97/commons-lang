package org.apache.commons.lang3.concurrent;

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

public class ThresholdCircuitBreakerTest {
    ThresholdCircuitBreaker circuitBreaker;

    @BeforeEach
    void setUp() {
        circuitBreaker = new ThresholdCircuitBreaker(10);
    }

    @Test
    void testCheckStateReturnsTrueWhenThresholdNotExceeded() {
        boolean result = circuitBreaker.checkState();
        assertTrue(result);
    }
//    @Test
//    void testCheckStateReturnsFalseWhenThresholdExceeded() {
//        circuitBreaker = new ThresholdCircuitBreaker(10);
//        circuitBreaker.used.set(11);
//        boolean result = circuitBreaker.checkState();
//        Assertions.assertFalse(result);
//    }
//
//    @Test
//    void testCheckStateReturnsTrueWhenThresholdEqualsUsed() {
//        circuitBreaker = new ThresholdCircuitBreaker(10);
//        circuitBreaker.used.set(10);
//        boolean result = circuitBreaker.checkState();
//        Assertions.assertTrue(result);
//    }

    @Test
    void testCheckStateReturnsTrueWhenThresholdSetToZero() {
        circuitBreaker = new ThresholdCircuitBreaker(0);
        boolean result = circuitBreaker.checkState();
        assertTrue(result);
    }

    @Test
    void testCheckStateReturnsTrueWhenThresholdSetToNegativeValue() {
        circuitBreaker = new ThresholdCircuitBreaker(-10);
        boolean result = circuitBreaker.checkState();
        assertTrue(result);
    }

    //    @Test
//    void testClose() {
//        // Create a ThresholdCircuitBreaker instance with a threshold of 10
//        ThresholdCircuitBreaker circuitBreaker = new ThresholdCircuitBreaker(10);
//
//        // Invoke the close method
//        circuitBreaker.close();
//
//        // Assert that the internal counter is reset to its initial value (zero)
//        assertEquals(0, circuitBreaker.used.get());
//    }
//
//    @Test
//    void testCloseMultipleTimes() {
//        // Create a ThresholdCircuitBreaker instance with a threshold of 10
//        ThresholdCircuitBreaker circuitBreaker = new ThresholdCircuitBreaker(10);
//
//        // Invoke the close method multiple times
//        for (int i = 0; i < 5; i++) {
//            circuitBreaker.close();
//        }
//
//        // Assert that the internal counter is reset to its initial value (zero) after each invocation
//        assertEquals(0, circuitBreaker.used.get());
//    }
//
//    @Test
//    void testCloseWithNonZeroInitialCount() {
//        // Create a ThresholdCircuitBreaker instance with a threshold of 10 and non-zero initial count
//        ThresholdCircuitBreaker circuitBreaker = new ThresholdCircuitBreaker(10);
//        circuitBreaker.used.set(5);
//
//        // Invoke the close method
//        circuitBreaker.close();
//
//        // Assert that the internal counter is reset to its initial value (zero)
//        assertEquals(0, circuitBreaker.used.get());
//    }
//
//    @Test
//    void testCloseWithThresholdReached() {
//        // Create a ThresholdCircuitBreaker instance with a threshold of 10
//        ThresholdCircuitBreaker circuitBreaker = new ThresholdCircuitBreaker(10);
//
//        // Set the internal counter to the threshold value
//        circuitBreaker.used.set(10);
//
//        // Invoke the close method
//        circuitBreaker.close();
//
//        // Assert that the internal counter is reset to its initial value (zero)
//        assertEquals(0, circuitBreaker.used.get());
//    }
////
//    @Test
//    void testCloseWithNegativeThreshold() {
//        // Create a ThresholdCircuitBreaker instance with a negative threshold
//        ThresholdCircuitBreaker circuitBreaker = new ThresholdCircuitBreaker(-10);
//
//        // Invoke the close method
//        circuitBreaker.close();
//
//        // Assert that the internal counter is reset to its initial value (zero)
//        assertEquals(0, circuitBreaker.used.get());
//    }
//
//    @Test
//    void testCloseWithMaxThreshold() {
//        // Create a ThresholdCircuitBreaker instance with the maximum threshold value
//        ThresholdCircuitBreaker circuitBreaker = new ThresholdCircuitBreaker(Long.MAX_VALUE);
//
//        // Invoke the close method
//        circuitBreaker.close();
//
//        // Assert that the internal counter is reset to its initial value (zero)
//        assertEquals(0, circuitBreaker.used.get());
//    }
    @Test
    void shouldOpenCircuitBreakerWhenThresholdIsZero() {
        circuitBreaker = new ThresholdCircuitBreaker(0L);
        circuitBreaker.incrementAndCheckState(5L);
        assertTrue(circuitBreaker.isOpen());
    }

    @Test
    void shouldNotOpenCircuitBreakerWhenThresholdIsNotZero() {
        circuitBreaker.incrementAndCheckState(5L);
        assertFalse(circuitBreaker.isOpen());
    }

    //@Test
    void shouldOpenCircuitBreakerWhenThresholdIsExceeded() {
        circuitBreaker.incrementAndCheckState(10L);
        assertTrue(circuitBreaker.isOpen());
    }

    @Test
    void shouldNotOpenCircuitBreakerWhenThresholdIsNotExceeded() {
        circuitBreaker.incrementAndCheckState(5L);
        assertFalse(circuitBreaker.isOpen());
    }

    //@Test
    void shouldReturnTrueWhenCircuitBreakerIsOpen() {
        circuitBreaker.open();

        boolean result = circuitBreaker.incrementAndCheckState(5L);

        assertTrue(result);
    }

    //@Test
    void shouldReturnFalseWhenCircuitBreakerIsClosed() {
        boolean result = circuitBreaker.incrementAndCheckState(5L);

        assertFalse(result);
    }

    @Test
    @DisplayName("should return the correct threshold value")
    void shouldReturnCorrectThreshold() {
        long threshold = circuitBreaker.getThreshold();
        assertEquals(10L, threshold);
    }

}