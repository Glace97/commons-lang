package org.apache.commons.lang3.time;

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


import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

public class StopWatchTest {

    @Test
    public void testSplitWhenNotRunning() {
        StopWatch stopWatch = new StopWatch();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            stopWatch.split();
        });
    }

    @Test
    public void testUnsplitWhenNotSplit() {
        StopWatch stopWatch = new StopWatch();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            stopWatch.unsplit();
        });
    }

    @Test
    void unsplit_WhenStopWatchNotSplit_ThrowsIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> stopWatch.unsplit());
    }

    @Test
    void testIsStarted_WhenStopWatchIsNotStarted_ShouldReturnFalse() {
        stopWatch = new StopWatch();
        assertFalse(stopWatch.isStarted());
    }

    @Test
    void testIsStarted_WhenStopWatchIsStarted_ShouldReturnTrue() {
        stopWatch = new StopWatch();
        stopWatch.start();
        assertTrue(stopWatch.isStarted());
    }

    @Test
    void testIsStarted_WhenStopWatchIsStopped_ShouldReturnFalse() {
        stopWatch = new StopWatch();
        stopWatch.start();
        stopWatch.stop();
        assertFalse(stopWatch.isStarted());
    }

    @Test
    void testIsStarted_WhenStopWatchIsSuspended_ShouldReturnTrue() {
        stopWatch = new StopWatch();
        stopWatch.start();
        stopWatch.suspend();
        assertTrue(stopWatch.isStarted());
    }

    @Test
    @DisplayName("returns 0 when StopWatch is unstarted")
    void returnsZeroWhenUnstarted() {
        assertEquals(0, stopWatch.getNanoTime());
    }

    @Test
    @DisplayName("returns elapsed time when StopWatch is stopped")
    void returnsElapsedTimeWhenStopped() {
        stopWatch.start();
        stopWatch.stop();

        assertTrue(stopWatch.getNanoTime() > 0);
    }

    @Test
    @DisplayName("returns elapsed time when StopWatch is suspended")
    void returnsElapsedTimeWhenSuspended() {
        stopWatch.start();
        stopWatch.suspend();

        assertTrue(stopWatch.getNanoTime() > 0);
    }

    @Test
    @DisplayName("returns elapsed time since start when StopWatch is running")
    void returnsElapsedTimeSinceStartWhenRunning() {
        stopWatch.start();

        assertTrue(stopWatch.getNanoTime() > 0);
    }


    @Test
    @DisplayName("returns 0 after reset")
    void returnsZeroAfterReset() {
        stopWatch.start();
        stopWatch.stop();
        stopWatch.reset();

        assertEquals(0, stopWatch.getNanoTime());
    }

    @Test
    @DisplayName("returns elapsed time since last split when StopWatch is split")
    void returnsElapsedTimeSinceLastSplitWhenSplit() {
        stopWatch.start();
        stopWatch.split();

        assertTrue(stopWatch.getNanoTime() > 0);
    }

    @Test
    @DisplayName("Resuming a stopped stopwatch should throw an IllegalStateException")
    void resumeStoppedStopWatch() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            stopWatch.resume();
        });
    }

    @Test
    @DisplayName("Resuming an unstarted stopwatch should throw an IllegalStateException")
    void resumeUnstartedStopWatch() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            stopWatch.resume();
        });
    }

    @Test
    void testSuspendWhenUnstarted() {
        assertThrows(IllegalStateException.class, () -> stopWatch.suspend());
    }

    @Test
    void testGetSplitNanoTimeWhenNotSplit() {
        StopWatch stopWatch = new StopWatch();
        Assertions.assertThrows(IllegalStateException.class, stopWatch::getSplitNanoTime);
    }

    @Test
    @DisplayName("Test getStartTime when StopWatch is unstarted")
    void testGetStartTimeUnstarted() {
        assertThrows(IllegalStateException.class, () -> stopWatch.getStartTime());
    }

    @Test
    @DisplayName("Test getStartTime when StopWatch is started")
    void testGetStartTimeStarted() {
        stopWatch.start();
        long startTime = stopWatch.getStartTime();
        long currentTime = System.currentTimeMillis();
        assertTrue(startTime <= currentTime);
    }

    @Test
    @DisplayName("Test getStartTime when StopWatch is stopped")
    void testGetStartTimeStopped() {
        stopWatch.start();
        stopWatch.stop();
        long startTime = stopWatch.getStartTime();
        long currentTime = System.currentTimeMillis();
        assertTrue(startTime <= currentTime);
    }

    @Test
    @DisplayName("Test getStartTime when StopWatch is suspended")
    void testGetStartTimeSuspended() {
        stopWatch.start();
        stopWatch.suspend();
        long startTime = stopWatch.getStartTime();
        long currentTime = System.currentTimeMillis();
        assertTrue(startTime <= currentTime);
    }

    @Test
    void testStartAfterStop() {
        stopWatch = new StopWatch();

        stopWatch.start();
        stopWatch.stop();

        Assertions.assertThrows(IllegalStateException.class, stopWatch::start);
    }

    @Test
    void testStartAfterSuspend() {
        stopWatch = new StopWatch();

        stopWatch.start();
        stopWatch.suspend();

        Assertions.assertThrows(IllegalStateException.class, stopWatch::start);
    }

    @Test
    void testIsSuspended_WhenStopWatchIsRunning_ThenReturnFalse() {
        stopWatch = new StopWatch();
        stopWatch.start();
        assertFalse(stopWatch.isSuspended());
    }

    @Test
    void testIsSuspended_WhenStopWatchIsStopped_ThenReturnFalse() {
        stopWatch = new StopWatch();
        stopWatch.start();
        stopWatch.stop();
        assertFalse(stopWatch.isSuspended());
    }

    @Test
    void testIsSuspended_WhenStopWatchIsSuspended_ThenReturnTrue() {
        stopWatch = new StopWatch();
        stopWatch.start();
        stopWatch.suspend();
        assertTrue(stopWatch.isSuspended());
    }

    @Test
    void testIsSuspended_WhenStopWatchIsUnstarted_ThenReturnFalse() {
        stopWatch = new StopWatch();
        assertFalse(stopWatch.isSuspended());
    }

    @Test
    @DisplayName("Should return split time in milliseconds")
    void shouldReturnSplitTimeInMillis() {
        stopWatch.start();
        sleep(1000);
        stopWatch.split();
        sleep(1000);
        long splitTime = stopWatch.getSplitTime();
        Assertions.assertTrue(splitTime >= 1000 && splitTime < 2000);
    }

    @Test
    @DisplayName("Should throw IllegalStateException if StopWatch has not been split")
    void shouldThrowIllegalStateExceptionIfNotSplit() {
        Assertions.assertThrows(IllegalStateException.class, () -> stopWatch.getSplitTime());
    }

    @Test
    @DisplayName("Should return split time in milliseconds after multiple splits")
    void shouldReturnSplitTimeAfterMultipleSplits() {
        stopWatch.start();
        sleep(1000);
        stopWatch.split();
        sleep(1000);
        stopWatch.split();
        sleep(1000);
        long splitTime = stopWatch.getSplitTime();
        Assertions.assertTrue(splitTime >= 2000 && splitTime < 3000);
    }

    @Test
    void testCreateStarted() {
        StopWatch sw = StopWatch.createStarted();
        Assertions.assertTrue(sw.isStarted());
        Assertions.assertFalse(sw.isStopped());
        Assertions.assertFalse(sw.isSuspended());
    }

    private StopWatch stopWatch;

    @BeforeEach
    void setUp() {
        stopWatch = new StopWatch();
    }

    private void sleep(long millis) {
        try {
            TimeUnit.MILLISECONDS.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testToStringWithNoMessage() {
        // test code here
    }

    @Test
    void testToStringWithMessage() {
        // test code here
    }

    @Test
    void testToStringWithHours() {
        // test code here
    }

    @Test
    void testToStringWithMinutes() {
        // test code here
    }

    @Test
    void testToStringWithSeconds() {
        // test code here
    }

    @Test
    void testToStringWithMilliseconds() {
        // test code here
    }

    @Test
    void testCreate() {
        StopWatch stopWatch = StopWatch.create();
        Assertions.assertNotNull(stopWatch);
    }

    @Test
    void testGetStartTime() throws InterruptedException {
        StopWatch stopWatch = StopWatch.create();

        long startTimeMillis = System.currentTimeMillis();
        stopWatch.start();
        Thread.sleep(500);
        long endTimeMillis = System.currentTimeMillis();
        Assertions.assertTrue(stopWatch.getStartTime() >= startTimeMillis);
        Assertions.assertTrue(stopWatch.getStartTime() <= endTimeMillis);
    }


    @Test
    void testGetMessage_NullMessage_ReturnsNull() {
        assertNull(stopWatch.getMessage());
    }

    @Test
    void testGetMessage_EmptyMessage_ReturnsEmptyString() {
        stopWatch = new StopWatch("");
        assertEquals("", stopWatch.getMessage());
    }

    @Test
    void testGetMessage_NonEmptyMessage_ReturnsMessage() {
        stopWatch = new StopWatch("Test message");
        assertEquals("Test message", stopWatch.getMessage());
    }

}