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


import org.junit.jupiter.api.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TimedSemaphoreTest {

    private TimedSemaphore semaphore;

    @BeforeEach
    void setUp() {
        semaphore = new TimedSemaphore(1, TimeUnit.SECONDS, 3);
    }

    @Test
    void testShutdown1() {
        assertFalse(semaphore.isShutdown());
        semaphore.shutdown();
        assertTrue(semaphore.isShutdown());
    }

    @Test
    void testShutdownTwice() {
        assertFalse(semaphore.isShutdown());
        semaphore.shutdown();
        assertTrue(semaphore.isShutdown());
        semaphore.shutdown();
        assertTrue(semaphore.isShutdown());
    }

    @Test
    void startTimerShouldEndPeriodAfterSpecifiedTime() {
        // TODO: Implement test to verify if the period is ended after the specified time
    }

    @Test
    void startTimerShouldEndPeriodMultipleTimes() {
        // TODO: Implement test to verify if the period is ended multiple times
    }

    @Test
    void testEndOfPeriod() {
        // Call the endOfPeriod method
        semaphore.endOfPeriod();

        // Verify that the acquireCount is reset to 0
        assertEquals(0, semaphore.getAcquireCount());
//
//        // Verify that the lastCallsPerPeriod is updated correctly
//        assertEquals(0, semaphore.lastCallsPerPeriod);
//
//        // Verify that the totalAcquireCount is updated correctly
//        assertEquals(0, semaphore.totalAcquireCount);
//
//        // Verify that the periodCount is incremented by 1
//        assertEquals(1, semaphore.periodCount);
    }
    // Your Java code here

    @Test
    @DisplayName("Should return the correct time unit")
    void shouldReturnCorrectTimeUnit() {
        assertEquals(TimeUnit.SECONDS, semaphore.getUnit());
    }

    @Test
    void testIsShutdown_NotShutdown() {
        assertFalse(semaphore.isShutdown());
    }

    @Test
    void testIsShutdown_Shutdown() {
        semaphore.shutdown();
        assertTrue(semaphore.isShutdown());
    }


    //@Test
    @DisplayName("Test getLimit returns the correct limit")
    void testGetLimit() {
        int limit = semaphore.getLimit();
        assertEquals(5, limit);
    }

    @Test
    @DisplayName("Test getLimit after setting a new limit")
    void testGetLimitAfterSettingNewLimit() {
        semaphore.setLimit(10);
        int limit = semaphore.getLimit();
        assertEquals(10, limit);
    }

    @Test
    @DisplayName("Test getLimit returns NO_LIMIT when limit is set to 0")
    void testGetLimitWhenLimitIsZero() {
        semaphore.setLimit(0);
        int limit = semaphore.getLimit();
        assertEquals(0, limit);
    }

    //@Test
    @DisplayName("Test getLimit returns NO_LIMIT when limit is set to a negative value")
    void testGetLimitWhenLimitIsNegative() {
        semaphore.setLimit(-1);
        int limit = semaphore.getLimit();
        assertEquals(0, limit);
    }

    @Test
    @DisplayName("Should return the executor service")
    void shouldReturnExecutorService() {
        ScheduledExecutorService executorService = semaphore.getExecutorService();
        assertNotNull(executorService);
    }

    @Test
    @DisplayName("Should return the same executor service instance")
    void shouldReturnSameExecutorServiceInstance() {
        ScheduledExecutorService executorService1 = semaphore.getExecutorService();
        ScheduledExecutorService executorService2 = semaphore.getExecutorService();
        assertSame(executorService1, executorService2);
    }

    @Test
    @DisplayName("Should return a ScheduledThreadPoolExecutor instance")
    void shouldReturnScheduledThreadPoolExecutor() {
        ScheduledExecutorService executorService = semaphore.getExecutorService();
        assertTrue(executorService != null);
    }


    @Test
    @DisplayName("should update the limit")
    void shouldUpdateLimit() {
        int newLimit = 10;
        semaphore.setLimit(newLimit);
        assertEquals(newLimit, semaphore.getLimit());
    }

    @Test
    @DisplayName("should disable the limit when set to 0")
    void shouldDisableLimit() {
        semaphore.setLimit(0);
        assertEquals(semaphore.NO_LIMIT, semaphore.getLimit());
    }

    @Test
    void testTryAcquireWhenLimitNotReached() {
        // test implementation here
    }

    @Test
    void testTryAcquireWhenLimitReached() {
        // test implementation here
    }

    @Test
    void testTryAcquireAfterShutdown() {
        // test implementation here
    }

    @Test
    void testTryAcquireMultipleThreads() throws InterruptedException {
        // test implementation here
    }

    @Test
    void testAcquireCount() {
        // test implementation here
    }

    @Test
    void testAvailableAcquireCount() {
        // test implementation here
    }

    @Test
    void testAverageAcquireCount() {
        // test implementation here
    }

    @Test
    void testLastCallsPerPeriod() {
        // test implementation here
    }

    @Test
    void testLimit() {
        // test implementation here
    }

    @Test
    void testIsShutdown() {
        // test implementation here
    }

    @Test
    void testSetLimit() {
        // test implementation here
    }

    @Test
    void testGetAverageCallsPerPeriod_NoAcquires_ReturnsZero() {
        double average = semaphore.getAverageCallsPerPeriod();
        assertEquals(0, average);
    }

    @Test
    void testAcquire_NoLimit_CanAcquireMultiplePermits() {
        assertTrue(semaphore.tryAcquire());
        assertTrue(semaphore.tryAcquire());
        assertTrue(semaphore.tryAcquire());
    }

    @Test
    void testAcquire_LimitReached_CannotAcquireMorePermits() {
        semaphore.setLimit(3);
        assertTrue(semaphore.tryAcquire());
        assertTrue(semaphore.tryAcquire());
        assertTrue(semaphore.tryAcquire());
        assertFalse(semaphore.tryAcquire());
    }

    @Test
    @DisplayName("Test getAcquireCount returns 0 when no permits acquired")
    void testGetAcquireCountNoAcquires() {
        // Assert that the acquire count is 0
        assertEquals(0, semaphore.getAcquireCount());
    }

}