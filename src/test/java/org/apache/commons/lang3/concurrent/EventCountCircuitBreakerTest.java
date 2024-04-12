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

    //@Test
    void checkState_OpeningThresholdReached_ShouldReturnFalse() {
        for (int i = 0; i < 5; i++) {
            assertTrue(circuitBreaker.checkState());
        }
        assertFalse(circuitBreaker.checkState());
    }
    
    //@Test
    void checkState_ClosingThresholdNotReached_ShouldReturnFalse() {
        for (int i = 0; i < 5; i++) {
            assertTrue(circuitBreaker.checkState());
        }
        assertFalse(circuitBreaker.checkState());
        for (int i = 0; i < 4; i++) {
            assertFalse(circuitBreaker.checkState());
        }
    }
    
    //@Test
    void checkState_ClosingThresholdReached_ShouldReturnTrue() {
        for (int i = 0; i < 5; i++) {
            assertTrue(circuitBreaker.checkState());
        }
        assertFalse(circuitBreaker.checkState());
        for (int i = 0; i < 5; i++) {
            assertFalse(circuitBreaker.checkState());
        }
        assertTrue(circuitBreaker.checkState());
    }

//    @Test
//    void testIsCheckIntervalFinished() {
//        // Test cases here
//    }
//
//    @Test
//    void testIsStateTransition() {
//        // Test cases here
//    }
//    @Test
//    void shouldNotChangeStateWhenAlreadyClosed() {
//        circuitBreaker.close();
//        CircuitBreaker.State currentState = circuitBreaker.getState();
//
//        circuitBreaker.close();
//
//        assertEquals(currentState, circuitBreaker.getState());
//    }
//
//    @Test
//    void shouldStartNewCheckInterval() {
//        circuitBreaker.close();
//
//        AtomicReference<EventCountCircuitBreaker.CheckIntervalData> checkIntervalData =
//                (AtomicReference<EventCountCircuitBreaker.CheckIntervalData>)
//                        TestUtils.getFieldValue(circuitBreaker, "checkIntervalData");
//
//        assertNotNull(checkIntervalData.get());
//        assertEquals(0, checkIntervalData.get().getEventCount());
//        assertTrue(checkIntervalData.get().getCheckIntervalStart() > 0);
//    }
    @Test
    void testGetClosingInterval1() {
        EventCountCircuitBreaker breaker = new EventCountCircuitBreaker(10, 1, TimeUnit.SECONDS);
    
        assertEquals(1000000000, breaker.getClosingInterval());
    }
    
    //@Test
    void testGetClosingIntervalWithCustomClosingInterval() {
        EventCountCircuitBreaker breaker = new EventCountCircuitBreaker(10, 1, TimeUnit.SECONDS, 5);
    
        assertEquals(5000000000L, breaker.getClosingInterval());
    }
    //@Test
    void testGetOpeningThreshold() {
        assertEquals(5, circuitBreaker.getOpeningThreshold());
    }
    
    //@Test
    void testGetOpeningInterval2() {
        assertEquals(1000, circuitBreaker.getOpeningInterval());
    }
    
    //@Test
    void testGetClosingThreshold() {
        assertEquals(5, circuitBreaker.getClosingThreshold());
    }
    
    //@Test
    void testGetClosingInterval() {
        assertEquals(1000, circuitBreaker.getClosingInterval());
    }
    
//    @Test
//    void testGetCheckIntervalData() {
//        assertNotNull(circuitBreaker.getCheckIntervalData());
//    }
//
//    @Test
//    void testIncrementEventCount() {
//        circuitBreaker.incrementEventCount();
//        assertEquals(1, circuitBreaker.getCheckIntervalData().getEventCount());
//    }
//
//    @Test
//    void testIncrementEventCount_multipleTimes() {
//        circuitBreaker.incrementEventCount();
//        circuitBreaker.incrementEventCount();
//        circuitBreaker.incrementEventCount();
//        assertEquals(3, circuitBreaker.getCheckIntervalData().getEventCount());
//    }
    
//    @Test
//    void testIsCheckIntervalFinished() {
//        assertFalse(circuitBreaker.isCheckIntervalFinished());
//    }
//
//    @Test
//    void testIsCheckIntervalFinished_afterInterval() throws InterruptedException {
//        Thread.sleep(2000);
//        assertTrue(circuitBreaker.isCheckIntervalFinished());
//    }
//
//    @Test
//    void testIsCheckIntervalFinished_beforeInterval() throws InterruptedException {
//        Thread.sleep(500);
//        assertFalse(circuitBreaker.isCheckIntervalFinished());
//    }
//
//    @Test
//    void testIsStateTransition() {
//        assertFalse(circuitBreaker.isStateTransition());
//    }
    
//    @Test
//    void testIsStateTransition_openingThresholdReached() {
//        circuitBreaker.incrementEventCount();
//        circuitBreaker.incrementEventCount();
//        circuitBreaker.incrementEventCount();
//        circuitBreaker.incrementEventCount();
//        circuitBreaker.incrementEventCount();
//        assertTrue(circuitBreaker.isStateTransition());
//    }
    
//    @Test
//    void testIsStateTransition_closingThresholdReached() {
//        circuitBreaker.incrementEventCount();
//        circuitBreaker.incrementEventCount();
//        circuitBreaker.incrementEventCount();
//        circuitBreaker.incrementEventCount();
//        circuitBreaker.incrementEventCount();
//        circuitBreaker.incrementEventCount();
//        circuitBreaker.incrementEventCount();
//        circuitBreaker.incrementEventCount();
//        circuitBreaker.incrementEventCount();
//        circuitBreaker.incrementEventCount();
//        assertFalse(circuitBreaker.isStateTransition());
//    }
//    @Test
//    void testFetchCheckInterval() {
//        assertEquals(1000, circuitBreaker.fetchCheckInterval(circuitBreaker));
//    }
//
//    @Test
//    void testFetchCheckInterval_CustomInterval() {
//        circuitBreaker = new EventCountCircuitBreaker(5, 2, TimeUnit.SECONDS);
//        assertEquals(2000, circuitBreaker.fetchCheckInterval(circuitBreaker));
//    }
//
//    @Test
//    void testFetchCheckInterval_OpeningThreshold() {
//        circuitBreaker = new EventCountCircuitBreaker(10, 1, TimeUnit.SECONDS);
//        assertEquals(1000, circuitBreaker.fetchCheckInterval(circuitBreaker));
//    }
//
//    @Test
//    void testFetchCheckInterval_ClosingThreshold() {
//        circuitBreaker = new EventCountCircuitBreaker(5, 1, TimeUnit.SECONDS, 2);
//        assertEquals(1000, circuitBreaker.fetchCheckInterval(circuitBreaker));
//    }
//
//    @Test
//    void testIsCheckIntervalFinished() {
//        long now = System.currentTimeMillis();
//        circuitBreaker.checkIntervalData.set(new EventCountCircuitBreaker.CheckIntervalData(5, now - 1000));
//        assertTrue(circuitBreaker.getStateStrategy().isCheckIntervalFinished(circuitBreaker, circuitBreaker.checkIntervalData.get(), now));
//    }
//
//    @Test
//    void testIsCheckIntervalFinished_NotFinished() {
//        long now = System.currentTimeMillis();
//        circuitBreaker.checkIntervalData.set(new EventCountCircuitBreaker.CheckIntervalData(5, now));
//        assertFalse(circuitBreaker.getStateStrategy().isCheckIntervalFinished(circuitBreaker, circuitBreaker.checkIntervalData.get(), now));
//    }
//
//    @Test
//    void testIsStateTransition() {
//        circuitBreaker.checkIntervalData.set(new EventCountCircuitBreaker.CheckIntervalData(10, System.currentTimeMillis()));
//        assertTrue(circuitBreaker.getStateStrategy().isStateTransition(circuitBreaker, circuitBreaker.checkIntervalData.get(), circuitBreaker.checkIntervalData.get().increment(1)));
//    }
//
//    @Test
//    void testIsStateTransition_NoTransition() {
//        circuitBreaker.checkIntervalData.set(new EventCountCircuitBreaker.CheckIntervalData(3, System.currentTimeMillis()));
//        assertFalse(circuitBreaker.getStateStrategy().isStateTransition(circuitBreaker, circuitBreaker.checkIntervalData.get(), circuitBreaker.checkIntervalData.get().increment(1)));
//    }

//
//        @Test
//        void testGetCheckIntervalStart() {
//            final int openingThreshold = 10;
//            final long openingInterval = 1;
//            final TimeUnit openingUnit = TimeUnit.SECONDS;
//            final int closingThreshold = 5;
//            final long closingInterval = 2;
//            final TimeUnit closingUnit = TimeUnit.SECONDS;
//
//            EventCountCircuitBreaker breaker = new EventCountCircuitBreaker(openingThreshold, openingInterval, openingUnit,
//                    closingThreshold, closingInterval, closingUnit);
//
//            long checkIntervalStart = breaker.getCheckIntervalStart();
//            Assertions.assertEquals(0, checkIntervalStart);
//
//            long currentTime = System.nanoTime();
//            long expectedCheckIntervalStart = currentTime;
//            long interval = TimeUnit.SECONDS.toNanos(openingInterval);
//            currentTime += interval;
//            expectedCheckIntervalStart += interval;
//
//            // Simulate passing time
//            setTime(currentTime);
//
//            checkIntervalStart = breaker.getCheckIntervalStart();
//            Assertions.assertEquals(expectedCheckIntervalStart, checkIntervalStart);
//        }
//
//        private void setTime(long currentTime) {
//            // Set the current time to a specific value
//        }
    // Your Java code here



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

    //@Test
    void shouldReturnFalseAfterOpeningThresholdReached() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            assertTrue(circuitBreaker.incrementAndCheckState());
        }
        Thread.sleep(1000); // Wait for closing interval
        assertTrue(circuitBreaker.incrementAndCheckState()); // Circuit closed
        assertFalse(circuitBreaker.incrementAndCheckState()); // Opening threshold reached
    }

    @Test
    void shouldReturnTrueWhenIncrementByValue() {
        assertTrue(circuitBreaker.incrementAndCheckState(2));
        assertFalse(circuitBreaker.incrementAndCheckState(2));
    }
//    @Test
//    void shouldIncrementEventCountByDelta() {
//        EventCountCircuitBreaker.CheckIntervalData initialData = circuitBreaker.checkIntervalData.get();
//        EventCountCircuitBreaker.CheckIntervalData newData = circuitBreaker.increment(3);
//
//        assertEquals(initialData.getEventCount() + 3, newData.getEventCount());
//    }
//
//    @Test
//    void shouldReturnSameInstanceIfDeltaIsZero() {
//        EventCountCircuitBreaker.CheckIntervalData initialData = circuitBreaker.checkIntervalData.get();
//        EventCountCircuitBreaker.CheckIntervalData newData = circuitBreaker.increment(0);
//
//        assertEquals(initialData, newData);
//    }
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
    
    //@Test
    void testGetOpeningInterval_NegativeThreshold() {
        assertThrows(IllegalArgumentException.class, () -> new EventCountCircuitBreaker(-5, 1, TimeUnit.SECONDS));
    }
    
    //@Test
    void testGetOpeningInterval_NegativeInterval() {
        assertThrows(IllegalArgumentException.class, () -> new EventCountCircuitBreaker(5, -1, TimeUnit.SECONDS));
    }
    
    //@Test
    void testGetOpeningInterval_NegativeThresholdAndInterval() {
        assertThrows(IllegalArgumentException.class, () -> new EventCountCircuitBreaker(-5, -1, TimeUnit.SECONDS));
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
//    @Test
//    void testGetEventCountReturnsZeroWhenNoEventsReceived() {
//        assertEquals(0, circuitBreaker.getEventCount());
//    }
//
//    @Test
//    void testGetEventCountReturnsCorrectCountAfterIncrementing() {
//        circuitBreaker.incrementEventCount();
//        circuitBreaker.incrementEventCount();
//        circuitBreaker.incrementEventCount();
//        assertEquals(3, circuitBreaker.getEventCount());
//    }
//
//    @Test
//    void testGetEventCountReturnsZeroAfterReset() {
//        circuitBreaker.incrementEventCount();
//        circuitBreaker.resetEventCount();
//        assertEquals(0, circuitBreaker.getEventCount());
//    }
//
//    @Test
//    void testGetEventCountReturnsCorrectCountAfterIncrementingAndResetting() {
//        circuitBreaker.incrementEventCount();
//        circuitBreaker.incrementEventCount();
//        circuitBreaker.resetEventCount();
//        circuitBreaker.incrementEventCount();
//        assertEquals(1, circuitBreaker.getEventCount());
//    }
//    // Your Java code here
//
//    @Test
//    void testOpen() {
//        circuitBreaker.open();
//
//        AtomicReference<EventCountCircuitBreaker.CheckIntervalData> checkIntervalData =
//                circuitBreaker.checkIntervalData;
//
//        assertEquals(0, checkIntervalData.get().getEventCount());
//        assertTrue(checkIntervalData.get().getCheckIntervalStart() > 0);
//    }
//    @Test
//    void testIsStateTransition_whenOpeningThresholdExceeded_thenTransitionToOpenState() {
//        EventCountCircuitBreaker breaker = new EventCountCircuitBreaker(5, 1, TimeUnit.SECONDS);
//        breaker.checkIntervalData.set(new EventCountCircuitBreaker.CheckIntervalData(6, 0));
//
//        boolean result = breaker.isStateTransition(breaker, breaker.checkIntervalData.get(),
//                breaker.checkIntervalData.get().increment(1));
//
//        Assertions.assertTrue(result);
//    }
//
//    @Test
//    void testIsStateTransition_whenOpeningThresholdNotExceeded_thenNoTransitionToOpenState() {
//        EventCountCircuitBreaker breaker = new EventCountCircuitBreaker(5, 1, TimeUnit.SECONDS);
//        breaker.checkIntervalData.set(new EventCountCircuitBreaker.CheckIntervalData(4, 0));
//
//        boolean result = breaker.isStateTransition(breaker, breaker.checkIntervalData.get(),
//                breaker.checkIntervalData.get().increment(1));
//
//        Assertions.assertFalse(result);
//    }
//
//    @Test
//    void testIsStateTransition_whenClosingThresholdExceededWithNewCheckInterval_thenTransitionToClosedState() {
//        EventCountCircuitBreaker breaker = new EventCountCircuitBreaker(5, 1, TimeUnit.SECONDS);
//        breaker.checkIntervalData.set(new EventCountCircuitBreaker.CheckIntervalData(4, 0));
//
//        boolean result = breaker.isStateTransition(breaker, breaker.checkIntervalData.get(),
//                breaker.checkIntervalData.get().increment(1));
//
//        Assertions.assertTrue(result);
//    }
//
//    @Test
//    void testIsStateTransition_whenClosingThresholdExceededWithoutNewCheckInterval_thenNoTransitionToClosedState() {
//        EventCountCircuitBreaker breaker = new EventCountCircuitBreaker(5, 1, TimeUnit.SECONDS);
//        breaker.checkIntervalData.set(new EventCountCircuitBreaker.CheckIntervalData(4, 0));
//
//        boolean result = breaker.isStateTransition(breaker, breaker.checkIntervalData.get(),
//                breaker.checkIntervalData.get().increment(0));
//
//        Assertions.assertFalse(result);
//    }
//    // Your Java code here

    //@Test
    void shouldReturnCorrectClosingThreshold() {
        int closingThreshold = circuitBreaker.getClosingThreshold();
        assertEquals(10, closingThreshold);
    }


}