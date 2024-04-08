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

public class TimedSemaphoreTest {
    @Test
    void testShutdown() {
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
    void testShutdownWithAcquire() throws InterruptedException {
        semaphore.acquire();
        assertFalse(semaphore.tryAcquire());
        assertFalse(semaphore.tryAcquire(1, TimeUnit.MILLISECONDS));
        semaphore.shutdown();
        assertTrue(semaphore.isShutdown());
        assertFalse(semaphore.tryAcquire());
        assertFalse(semaphore.tryAcquire(1, TimeUnit.MILLISECONDS));
    }
    @Test
    void startTimerShouldReturnNonNullFuture() {
        ScheduledFuture<?> future = timedSemaphore.startTimer();
        assertNotNull(future);
    }
    
    @Test
    void startTimerShouldScheduleTaskAtFixedRate() {
        ScheduledFuture<?> future = timedSemaphore.startTimer();
    
        // TODO: Verify if the task is scheduled at fixed rate
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
        timedSemaphore.endOfPeriod();
    
        // Verify that the acquireCount is reset to 0
        assertEquals(0, timedSemaphore.acquireCount);
    
        // Verify that the lastCallsPerPeriod is updated correctly
        assertEquals(0, timedSemaphore.lastCallsPerPeriod);
    
        // Verify that the totalAcquireCount is updated correctly
        assertEquals(0, timedSemaphore.totalAcquireCount);
    
        // Verify that the periodCount is incremented by 1
        assertEquals(1, timedSemaphore.periodCount);
    }
    // Your Java code here
    
    import static org.junit.jupiter.api.Assertions.*;
    
    import java.util.concurrent.TimeUnit;
    
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Nested;
    import org.junit.jupiter.api.Test;
    
    class TimedSemaphoreTest {
        private TimedSemaphore semaphore;
    
        @BeforeEach
        void setUp() {
            semaphore = new TimedSemaphore(1, TimeUnit.SECONDS, 3);
        }
    
        @Nested
        @DisplayName("getUnit method")
        class GetUnitMethod {
            @Test
            @DisplayName("Should return the correct time unit")
            void shouldReturnCorrectTimeUnit() {
                assertEquals(TimeUnit.SECONDS, semaphore.getUnit());
            }
        }
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
    @Test
        void testGetAvailablePermits_NoAcquire() {
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(5, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterAcquire() {
            timedSemaphore.acquire();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(4, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterMultipleAcquire() {
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(2, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AtLimit() {
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(0, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterRelease() {
            timedSemaphore.acquire();
            timedSemaphore.release();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(5, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdown() {
            timedSemaphore.shutdown();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(0, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdownAndRelease() {
            timedSemaphore.shutdown();
            timedSemaphore.release();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(0, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdownAndAcquire() {
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(0, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdownAndMultipleAcquire() {
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(0, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdownAndReleaseAndAcquire() {
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.acquire();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(0, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdownAndReleaseAndMultipleAcquire() {
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(0, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdownAndReleaseAndShutdown() {
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.shutdown();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(0, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdownAndMultipleRelease() {
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(0, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdownAndMultipleReleaseAndAcquire() {
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.acquire();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(0, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdownAndMultipleReleaseAndMultipleAcquire() {
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(0, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdownAndMultipleReleaseAndShutdown() {
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.shutdown();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(0, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdownAndMultipleReleaseAndShutdownAndAcquire() {
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(0, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdownAndMultipleReleaseAndShutdownAndMultipleAcquire() {
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(0, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdownAndMultipleReleaseAndShutdownAndMultipleAcquireAndRelease() {
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.release();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(1, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdownAndMultipleReleaseAndShutdownAndMultipleAcquireAndMultipleRelease() {
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(2, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdownAndMultipleReleaseAndShutdownAndMultipleAcquireAndMultipleReleaseAndAcquire() {
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.acquire();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(1, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdownAndMultipleReleaseAndShutdownAndMultipleAcquireAndMultipleReleaseAndAcquireAndShutdown() {
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.acquire();
            timedSemaphore.shutdown();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(0, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdownAndMultipleReleaseAndShutdownAndMultipleAcquireAndMultipleReleaseAndAcquireAndShutdownAndRelease() {
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.acquire();
            timedSemaphore.shutdown();
            timedSemaphore.release();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(1, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdownAndMultipleReleaseAndShutdownAndMultipleAcquireAndMultipleReleaseAndAcquireAndShutdownAndReleaseAndShutdown() {
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.acquire();
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.shutdown();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(0, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdownAndMultipleReleaseAndShutdownAndMultipleAcquireAndMultipleReleaseAndAcquireAndShutdownAndReleaseAndShutdownAndAcquire() {
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.acquire();
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(0, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdownAndMultipleReleaseAndShutdownAndMultipleAcquireAndMultipleReleaseAndAcquireAndShutdownAndReleaseAndShutdownAndAcquireAndShutdown() {
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.acquire();
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
            timedSemaphore.shutdown();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(0, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdownAndMultipleReleaseAndShutdownAndMultipleAcquireAndMultipleReleaseAndAcquireAndShutdownAndReleaseAndShutdownAndAcquireAndShutdownAndRelease() {
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.acquire();
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.acquire();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(1, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdownAndMultipleReleaseAndShutdownAndMultipleAcquireAndMultipleReleaseAndAcquireAndShutdownAndReleaseAndShutdownAndAcquireAndShutdownAndReleaseAndAcquire() {
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.acquire();
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.acquire();
            timedSemaphore.shutdown();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(1, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdownAndMultipleReleaseAndShutdownAndMultipleAcquireAndMultipleReleaseAndAcquireAndShutdownAndReleaseAndShutdownAndAcquireAndShutdownAndReleaseAndAcquireAndShutdown() {
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.acquire();
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.acquire();
            timedSemaphore.shutdown();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(0, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdownAndMultipleReleaseAndShutdownAndMultipleAcquireAndMultipleReleaseAndAcquireAndShutdownAndReleaseAndShutdownAndAcquireAndShutdownAndReleaseAndAcquireAndShutdownAndRelease() {
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.acquire();
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.acquire();
            timedSemaphore.shutdown();
            timedSemaphore.release();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(1, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdownAndMultipleReleaseAndShutdownAndMultipleAcquireAndMultipleReleaseAndAcquireAndShutdownAndReleaseAndShutdownAndAcquireAndShutdownAndReleaseAndAcquireAndShutdownAndReleaseAndShutdown() {
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.acquire();
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.acquire();
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.shutdown();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(0, availablePermits);
        }
    
        @Test
        void testGetAvailablePermits_AfterShutdownAndMultipleReleaseAndShutdownAndMultipleAcquireAndMultipleReleaseAndAcquireAndShutdownAndReleaseAndShutdownAndAcquireAndShutdownAndReleaseAndAcquireAndShutdownAndReleaseAndShutdownAndAcquire() {
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.acquire();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.release();
            timedSemaphore.acquire();
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.acquire();
            timedSemaphore.shutdown();
            timedSemaphore.release();
            timedSemaphore.shutdown();
            timedSemaphore.acquire();
    
            int availablePermits = timedSemaphore.getAvailablePermits();
    
            assertEquals(0, availablePermits);
        }
    // The @Test test functions
    
    @Test
    void testAcquire() throws InterruptedException {
        ...
    }
    
    @Test
    void testAcquire_withLimit() throws InterruptedException {
        ...
    }
    
    @Test
    void testAcquire_multipleThreads() throws InterruptedException {
        ...
    }
    
    @Test
    void testAcquire_noLimit() throws InterruptedException {
        ...
    }
    
    @Test
    void testAcquire_interrupted() throws InterruptedException {
        ...
    }
    
    @Test
    void testGetTotalAcquireCount() throws InterruptedException {
        ...
    }
    
    @Test
    void testGetAcquireCount() throws InterruptedException {
        ...
    }
    
    @Test
    void testGetRemainingCallsPerPeriod() throws InterruptedException {
        ...
    }
    
    @Test
    void testGetLastCallsPerPeriod() throws InterruptedException {
        ...
    }
    
    @Test
    void testGetAverageCallsPerTimeUnit() throws InterruptedException {
        ...
    }
    
    @Test
    void testShutdown() {
        ...
    }
    
    @Test
    void testTryAcquire() throws InterruptedException {
        ...
    }
    @Test
    @DisplayName("Test getLimit returns the correct limit")
    void testGetLimit() {
        int limit = timedSemaphore.getLimit();
        assertEquals(5, limit);
    }
    
    @Test
    @DisplayName("Test getLimit after setting a new limit")
    void testGetLimitAfterSettingNewLimit() {
        timedSemaphore.setLimit(10);
        int limit = timedSemaphore.getLimit();
        assertEquals(10, limit);
    }
    
    @Test
    @DisplayName("Test getLimit returns NO_LIMIT when limit is set to 0")
    void testGetLimitWhenLimitIsZero() {
        timedSemaphore.setLimit(0);
        int limit = timedSemaphore.getLimit();
        assertEquals(0, limit);
    }
    
    @Test
    @DisplayName("Test getLimit returns NO_LIMIT when limit is set to a negative value")
    void testGetLimitWhenLimitIsNegative() {
        timedSemaphore.setLimit(-1);
        int limit = timedSemaphore.getLimit();
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
        assertTrue(executorService instanceof ScheduledThreadPoolExecutor);
    }
    
    @Test
    @DisplayName("Should return an executor service with the correct thread pool size")
    void shouldReturnExecutorServiceWithCorrectThreadPoolSize() {
        ScheduledExecutorService executorService = semaphore.getExecutorService();
        int expectedThreadPoolSize = 1;
        assertEquals(expectedThreadPoolSize, executorService.getCorePoolSize());
    }
    @Test
    void testGetPeriod() {
        assertEquals(1000, timedSemaphore.getPeriod());
    }
    // Your Java code here
    
    @Test
    @DisplayName("should update the limit")
    void shouldUpdateLimit() {
        int newLimit = 10;
        timedSemaphore.setLimit(newLimit);
        assertEquals(newLimit, timedSemaphore.getLimit());
    }
    
    @Test
    @DisplayName("should disable the limit when set to 0")
    void shouldDisableLimit() {
        timedSemaphore.setLimit(0);
        assertEquals(TimedSemaphore.NO_LIMIT, timedSemaphore.getLimit());
    }
    
    @Test
    @DisplayName("should throw IllegalArgumentException when set to a negative value")
    void shouldThrowIllegalArgumentExceptionForNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> timedSemaphore.setLimit(-1));
    }
    
    @Test
    @DisplayName("should throw IllegalStateException when called after shutdown")
    void shouldThrowIllegalStateExceptionAfterShutdown() {
        timedSemaphore.shutdown();
        assertThrows(IllegalStateException.class, () -> timedSemaphore.setLimit(10));
    }
    import org.junit.jupiter.api.Test;
    
    class TimedSemaphoreTest {
        
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
    }
    @Test
    void testGetAverageCallsPerPeriod_NoAcquires_ReturnsZero() {
        double average = semaphore.getAverageCallsPerPeriod();
        assertEquals(0, average);
    }
    
    @Test
    void testGetAverageCallsPerPeriod_SingleAcquire_ReturnsOne() throws InterruptedException {
        semaphore.acquire();
        
        Thread.sleep(1000);
        
        double average = semaphore.getAverageCallsPerPeriod();
        assertEquals(1, average);
    }
    
    @Test
    void testGetAverageCallsPerPeriod_MultipleAcquires_ReturnsCorrectAverage() throws InterruptedException {
        semaphore.acquire();
        semaphore.acquire();
        semaphore.acquire();
        
        Thread.sleep(1000);
        
        semaphore.acquire();
        semaphore.acquire();
        
        Thread.sleep(1000);
        
        double average = semaphore.getAverageCallsPerPeriod();
        assertEquals(2, average);
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
    void testAcquire_LimitReached_ThenResets_AcquiresPermitsAgain() {
        semaphore.setLimit(3);
        assertTrue(semaphore.tryAcquire());
        assertTrue(semaphore.tryAcquire());
        assertTrue(semaphore.tryAcquire());
        assertFalse(semaphore.tryAcquire());
        
        semaphore.setLimit(5);
        assertTrue(semaphore.tryAcquire());
        assertTrue(semaphore.tryAcquire());
        assertTrue(semaphore.tryAcquire());
        assertTrue(semaphore.tryAcquire());
        assertTrue(semaphore.tryAcquire());
        assertFalse(semaphore.tryAcquire());
    }
    
    @Test
    void testShutdown_CannotAcquirePermitsAfterShutdown() {
        semaphore.shutdown();
        assertFalse(semaphore.tryAcquire());
    }
    import static org.junit.jupiter.api.Assertions.*;
    import java.util.concurrent.TimeUnit;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;
    
    class TimedSemaphoreTest {
    
        private TimedSemaphore semaphore;
    
        @BeforeEach
        void setUp() {
            semaphore = new TimedSemaphore(1, TimeUnit.SECONDS, 10);
        }
    
        @Test
        void testGetLastAcquiresPerPeriod() {
            assertEquals(0, semaphore.getLastAcquiresPerPeriod());
            semaphore.acquire();
            assertEquals(1, semaphore.getLastAcquiresPerPeriod());
            semaphore.acquire();
            semaphore.acquire();
            assertEquals(3, semaphore.getLastAcquiresPerPeriod());
            semaphore.tryAcquire();
            semaphore.tryAcquire();
            assertEquals(5, semaphore.getLastAcquiresPerPeriod());
        }
    
        @Test
        void testGetLastAcquiresPerPeriod_WithLimit() {
            semaphore.setLimit(3);
            semaphore.acquire();
            assertEquals(1, semaphore.getLastAcquiresPerPeriod());
            semaphore.acquire();
            semaphore.acquire();
            assertEquals(3, semaphore.getLastAcquiresPerPeriod());
            semaphore.tryAcquire();
            semaphore.tryAcquire();
            assertEquals(3, semaphore.getLastAcquiresPerPeriod());
        }
    
        @Test
        void testGetLastAcquiresPerPeriod_Shutdown() {
            semaphore.acquire();
            semaphore.shutdown();
            assertThrows(IllegalStateException.class, () -> {
                semaphore.getLastAcquiresPerPeriod();
            });
        }
    
        @Test
        void testGetLastAcquiresPerPeriod_Average() {
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            assertEquals(4, semaphore.getLastAcquiresPerPeriod());
            assertEquals(4, semaphore.getAverageAcquiresPerPeriod());
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            assertEquals(4, semaphore.getLastAcquiresPerPeriod());
            assertEquals(8, semaphore.getAverageAcquiresPerPeriod());
        }
    
        @Test
        void testGetLastAcquiresPerPeriod_EdgeCases() {
            semaphore.setLimit(0);
            semaphore.acquire();
            assertEquals(1, semaphore.getLastAcquiresPerPeriod());
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            assertEquals(4, semaphore.getLastAcquiresPerPeriod());
            semaphore.shutdown();
            assertThrows(IllegalStateException.class, () -> {
                semaphore.getLastAcquiresPerPeriod();
            });
            semaphore.setLimit(10);
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            semaphore.acquire();
            assertEquals(10, semaphore.getLastAcquiresPerPeriod());
        }
    }
    @Test
    @DisplayName("Test getAcquireCount returns the correct count")
    void testGetAcquireCount() throws InterruptedException {
        // Acquire permits
        semaphore.acquire();
        semaphore.acquire();
        semaphore.acquire();
    
        // Sleep for 2 seconds to allow the time period to end
        Thread.sleep(2000);
    
        // Acquire more permits
        semaphore.acquire();
        semaphore.acquire();
    
        // Assert that the acquire count is 5
        assertEquals(5, semaphore.getAcquireCount());
    }
    
    @Test
    @DisplayName("Test getAcquireCount returns 0 when no permits acquired")
    void testGetAcquireCountNoAcquires() {
        // Assert that the acquire count is 0
        assertEquals(0, semaphore.getAcquireCount());
    }
    
    @Test
    @DisplayName("Test getAcquireCount returns the correct count after multiple periods")
    void testGetAcquireCountMultiplePeriods() throws InterruptedException {
        // Acquire permits
        semaphore.acquire();
        semaphore.acquire();
        semaphore.acquire();
    
        // Sleep for 2 seconds to allow the first time period to end
        Thread.sleep(2000);
    
        // Acquire more permits
        semaphore.acquire();
        semaphore.acquire();
    
        // Sleep for 2 seconds to allow the second time period to end
        Thread.sleep(2000);
    
        // Acquire more permits
        semaphore.acquire();
    
        // Assert that the acquire count is 6
        assertEquals(6, semaphore.getAcquireCount());
    }

}