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

import java.util.concurrent.TimeUnit;

public class EventCountCircuitBreakerTest {

    EventCountCircuitBreaker circuitBreaker;

    @BeforeEach
    void setUp() {
        circuitBreaker = new EventCountCircuitBreaker(3, 1, TimeUnit.SECONDS);
    }
    @Test
    void checkState_InitialState_ShouldReturnTrue() {
        assertTrue(circuitBreaker.checkState());
    }
    
    @Test
    void checkState_OpeningThresholdNotReached_ShouldReturnTrue() {
        for (int i = 0; i < 4; i++) {
            assertTrue(circuitBreaker.checkState());
        }
    }

    @Test
    void testGetClosingInterval1() {
        EventCountCircuitBreaker breaker = new EventCountCircuitBreaker(10, 1, TimeUnit.SECONDS);
    
        assertEquals(1000000000, breaker.getClosingInterval());
    }
    
    @Test
    void shouldReturnTrueWhenThresholdNotReached() {
        for (int i = 0; i < 2; i++) {
            assertTrue(circuitBreaker.incrementAndCheckState());
        }
    }

    @Test
    void shouldReturnFalseWhenThresholdReached() {
        for (int i = 0; i < 3; i++) {
            assertTrue(circuitBreaker.incrementAndCheckState());
        }
        assertFalse(circuitBreaker.incrementAndCheckState());
    }

    @Test
    void shouldReturnTrueAfterClosingThresholdReached() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            assertTrue(circuitBreaker.incrementAndCheckState());
        }
        Thread.sleep(1000); // Wait for closing interval
        assertTrue(circuitBreaker.incrementAndCheckState());
    }

    @Test
    void shouldReturnTrueWhenIncrementByValue() {
        assertTrue(circuitBreaker.incrementAndCheckState(2));
        assertFalse(circuitBreaker.incrementAndCheckState(2));
    }
    @Test
    void testGetOpeningInterval() {
        assertEquals(1000000000, circuitBreaker.getOpeningInterval());
    }
    
    @Test
    void testGetOpeningInterval_CustomInterval() {
        EventCountCircuitBreaker customCircuitBreaker = new EventCountCircuitBreaker(5, 2, TimeUnit.SECONDS);
        assertEquals(2000000000, customCircuitBreaker.getOpeningInterval());
    }
    
    @Test
    void testGetOpeningInterval_SameOpeningAndClosingInterval() {
        EventCountCircuitBreaker customCircuitBreaker = new EventCountCircuitBreaker(5, 1, TimeUnit.SECONDS, 3);
        assertEquals(1000000000, customCircuitBreaker.getOpeningInterval());
    }
    
    @Test
    void testGetOpeningInterval_CustomOpeningAndClosingInterval() {
        EventCountCircuitBreaker customCircuitBreaker = new EventCountCircuitBreaker(5, 2, TimeUnit.SECONDS, 3, 2, TimeUnit.SECONDS);
        assertEquals(2000000000, customCircuitBreaker.getOpeningInterval());
    }
    
    @Test
    void testGetOpeningInterval_ZeroThreshold() {
        EventCountCircuitBreaker customCircuitBreaker = new EventCountCircuitBreaker(0, 1, TimeUnit.SECONDS);
        assertEquals(1000000000, customCircuitBreaker.getOpeningInterval());
    }
    
    @Test
    void testGetOpeningInterval_ZeroInterval() {
        EventCountCircuitBreaker customCircuitBreaker = new EventCountCircuitBreaker(5, 0, TimeUnit.SECONDS);
        assertEquals(0, customCircuitBreaker.getOpeningInterval());
    }
    
    @Test
    void testGetOpeningInterval_ZeroThresholdAndInterval() {
        EventCountCircuitBreaker customCircuitBreaker = new EventCountCircuitBreaker(0, 0, TimeUnit.SECONDS);
        assertEquals(0, customCircuitBreaker.getOpeningInterval());
    }
    
    @Test
    void testGetOpeningInterval_CustomCheckUnit() {
        EventCountCircuitBreaker customCircuitBreaker = new EventCountCircuitBreaker(5, 1, TimeUnit.MINUTES);
        assertEquals(60000000000L, customCircuitBreaker.getOpeningInterval());
    }

}