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

//    @Test
//    public void testSplit() {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.split();
//        Assertions.assertEquals(StopWatch.SplitState.SPLIT, stopWatch.getSplitState());
//    }

    @Test
    public void testSplitWhenNotRunning() {
        StopWatch stopWatch = new StopWatch();
        Assertions.assertThrows(IllegalStateException.class, () -> {
            stopWatch.split();
        });
    }

//    @Test
//    public void testUnsplit() {
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.split();
//        stopWatch.unsplit();
//        Assertions.assertEquals(StopWatch.SplitState.UNSPLIT, stopWatch.getSplitState());
//    }

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

//    @Test
//    void unsplit_WhenStopWatchSplit_SetsSplitStateToUnsplit() {
//        stopWatch.split();
//        stopWatch.unsplit();
//        assertEquals(StopWatch.SplitState.UNSPLIT, stopWatch.getSplitState());
//    }

    //@Test
    @DisplayName("should return formatted time")
    void shouldReturnFormattedTime() {
        // Arrange
        stopWatch.start();
        stopWatch.stop();

        // Act
        String formattedTime = stopWatch.formatTime();

        // Assert
        assertNotNull(formattedTime);
        assertEquals("00:00:00", formattedTime);
    }

    //@Test
    @DisplayName("should return formatted time when stopwatch is not started")
    void shouldReturnFormattedTimeWhenNotStarted() {
        // Arrange

        // Act
        String formattedTime = stopWatch.formatTime();

        // Assert
        assertNotNull(formattedTime);
        assertEquals("00:00:00", formattedTime);
    }

    //@Test
    @DisplayName("should return formatted time when stopwatch is started but not stopped")
    void shouldReturnFormattedTimeWhenStartedButNotStopped() {
        // Arrange
        stopWatch.start();

        // Act
        String formattedTime = stopWatch.formatTime();

        // Assert
        assertNotNull(formattedTime);
        assertEquals("00:00:00", formattedTime);
    }

    //@Test
    @DisplayName("should return formatted time when stopwatch is started, stopped, and started again")
    void shouldReturnFormattedTimeWhenStartedStoppedAndStartedAgain() {
        // Arrange
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();

        // Act
        String formattedTime = stopWatch.formatTime();

        // Assert
        assertNotNull(formattedTime);
        assertEquals("00:00:00", formattedTime);
    }

    //@Test
    @DisplayName("should return formatted time when stopwatch is started, stopped, and reset")
    void shouldReturnFormattedTimeWhenStartedStoppedAndReset() {
        // Arrange
        stopWatch.start();
        stopWatch.stop();
        stopWatch.reset();

        // Act
        String formattedTime = stopWatch.formatTime();

        // Assert
        assertNotNull(formattedTime);
        assertEquals("00:00:00", formattedTime);
    }

    //@Test
    @DisplayName("should return formatted time when stopwatch is started, stopped, split, and unsplit")
    void shouldReturnFormattedTimeWhenStartedStoppedSplitAndUnsplit() {
        // Arrange
        stopWatch.start();
        stopWatch.stop();
        stopWatch.split();
        stopWatch.unsplit();

        // Act
        String formattedTime = stopWatch.formatTime();

        // Assert
        assertNotNull(formattedTime);
        assertEquals("00:00:00", formattedTime);
    }

    //@Test
    @DisplayName("should return formatted time when stopwatch is started, stopped, split, unsplit, and stopped again")
    void shouldReturnFormattedTimeWhenStartedStoppedSplitUnsplitAndStoppedAgain() {
        // Arrange
        stopWatch.start();
        stopWatch.stop();
        stopWatch.split();
        stopWatch.unsplit();
        stopWatch.stop();

        // Act
        String formattedTime = stopWatch.formatTime();

        // Assert
        assertNotNull(formattedTime);
        assertEquals("00:00:00", formattedTime);
    }

    //@Test
    @DisplayName("should return formatted time when stopwatch is started, stopped, split, unsplit, and reset")
    void shouldReturnFormattedTimeWhenStartedStoppedSplitUnsplitAndReset() {
        // Arrange
        stopWatch.start();
        stopWatch.stop();
        stopWatch.split();
        stopWatch.unsplit();
        stopWatch.reset();

        // Act
        String formattedTime = stopWatch.formatTime();

        // Assert
        assertNotNull(formattedTime);
        assertEquals("00:00:00", formattedTime);
    }

    //@Test
    @DisplayName("should return formatted time when stopwatch is started, stopped, split, unsplit, stopped again, and reset")
    void shouldReturnFormattedTimeWhenStartedStoppedSplitUnsplitStoppedAgainAndReset() {
        // Arrange
        stopWatch.start();
        stopWatch.stop();
        stopWatch.split();
        stopWatch.unsplit();
        stopWatch.stop();
        stopWatch.reset();

        // Act
        String formattedTime = stopWatch.formatTime();

        // Assert
        assertNotNull(formattedTime);
        assertEquals("00:00:00", formattedTime);
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

    //@Test
    @DisplayName("throws IllegalStateException when StopWatch is in an illegal running state")
    void throwsIllegalStateExceptionWhenIllegalRunningState() {
        stopWatch.start();
        stopWatch.stop();

        assertThrows(IllegalStateException.class, () -> stopWatch.getNanoTime());
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

    //@Test
    @DisplayName("returns total elapsed time when StopWatch is stopped and reset")
    void returnsTotalElapsedTimeWhenStoppedAndReset() {
        stopWatch.start();
        stopWatch.stop();
        stopWatch.reset();

        assertTrue(stopWatch.getNanoTime() > 0);
    }

//
//    @Test
//    void shouldResetRunningStateToUnstarted() {
//        stopWatch.reset();
//        assertEquals(StopWatch.State.UNSTARTED, stopWatch.runningState);
//    }
//
//    @Test
//    void shouldResetSplitStateToUnsplit() {
//        stopWatch.reset();
//        assertEquals(StopWatch.SplitState.UNSPLIT, stopWatch.splitState);
//    }
//
//    @Test
//    void shouldResetRunningStateToUnstarted() {
//        stopWatch.reset();
//        assertEquals(StopWatch.State.UNSTARTED, stopWatch.runningState);
//    }
//
//    @Test
//    void shouldResetSplitStateToUnsplit() {
//        stopWatch.reset();
//        assertEquals(StopWatch.SplitState.UNSPLIT, stopWatch.splitState);
//    }
//
//    @Test
//    void shouldResetRunningStateToUnstarted() {
//        stopWatch.reset();
//        assertEquals(StopWatch.State.UNSTARTED, stopWatch.runningState);
//    }
//
//    @Test
//    void shouldResetSplitStateToUnsplit() {
//        stopWatch.reset();
//        assertEquals(StopWatch.SplitState.UNSPLIT, stopWatch.splitState);
//    }
//
//    @Test
//    void shouldResetRunningStateToUnstarted() {
//        stopWatch.reset();
//        assertEquals(StopWatch.State.UNSTARTED, stopWatch.runningState);
//    }
//
//    @Test
//    void shouldResetSplitStateToUnsplit() {
//        stopWatch.reset();
//        assertEquals(StopWatch.SplitState.UNSPLIT, stopWatch.splitState);
//    }
//
//    @Test
//    void shouldResetRunningStateToUnstarted() {
//        stopWatch.reset();
//        assertEquals(StopWatch.State.UNSTARTED, stopWatch.runningState);
//    }
//
//    @Test
//    void shouldResetSplitStateToUnsplit() {
//        stopWatch.reset();
//        assertEquals(StopWatch.SplitState.UNSPLIT, stopWatch.splitState);
//    }

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

//    @Test
//    @DisplayName("Resuming a suspended stopwatch should change its state to running")
//    void resumeSuspendedStopWatch() {
//        stopWatch.suspend();
//        stopWatch.resume();
//        Assertions.assertEquals(StopWatch.State.RUNNING, stopWatch.getRunningState());
//    }
//
//    @Test
//    @DisplayName("The resumed stopwatch should include time between suspend and resume calls in the total time")
//    void resumedStopWatchIncludesSuspendedTime() throws InterruptedException {
//        stopWatch.start();
//        TimeUnit.MILLISECONDS.sleep(1000);
//        stopWatch.suspend();
//        TimeUnit.MILLISECONDS.sleep(1000);
//        stopWatch.resume();
//        TimeUnit.MILLISECONDS.sleep(1000);
//        stopWatch.stop();
//        Assertions.assertTrue(stopWatch.getTotalTimeMillis() > 2000);
//    }

    @Test
    void testSuspendWhenUnstarted() {
        assertThrows(IllegalStateException.class, () -> stopWatch.suspend());
    }

//    @Test
//    void testSuspendWhenStopped() {
//        stopWatch.stopTimeMillis = System.currentTimeMillis();
//        stopWatch.runningState = StopWatch.State.STOPPED;
//        assertThrows(IllegalStateException.class, () -> stopWatch.suspend());
//    }
//
//    @Test
//    void testSuspendWhenSuspended() {
//        stopWatch.runningState = StopWatch.State.SUSPENDED;
//        assertThrows(IllegalStateException.class, () -> stopWatch.suspend());
//    }
//
//    @Test
//    void testSuspendWhenRunning() {
//        stopWatch.runningState = StopWatch.State.RUNNING;
//        stopWatch.suspend();
//        assertEquals(StopWatch.State.SUSPENDED, stopWatch.runningState);
//        assertTrue(stopWatch.stopTimeNanos > 0);
//        assertTrue(stopWatch.stopTimeMillis > 0);
//    }

    @Test
    void testGetSplitNanoTimeWhenNotSplit() {
        StopWatch stopWatch = new StopWatch();
        Assertions.assertThrows(IllegalStateException.class, stopWatch::getSplitNanoTime);
    }

    //@Test
    void testGetSplitNanoTimeWhenSplit() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.getSplitNanoTime();
        // Add assertions for the desired behavior
    }
    // Your Java code here

    //@Test
    @DisplayName("returns formatted split time without message")
    void returnsFormattedSplitTimeWithoutMessage() {
        String splitString = stopWatch.toSplitString();
        assertEquals("00:00:00.000", splitString);
    }

    //@Test
    @DisplayName("returns formatted split time with message")
    void returnsFormattedSplitTimeWithMessage() {
        stopWatch = new StopWatch("Test Message");
        String splitString = stopWatch.toSplitString();
        assertEquals("Test Message 00:00:00.000", splitString);
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

    //@Test
    @DisplayName("Test getStartTime after restarting the StopWatch")
    void testGetStartTimeRestarted() {
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        long startTime = stopWatch.getStartTime();
        long currentTime = System.currentTimeMillis();
        assertTrue(startTime <= currentTime);
    }
//
//    @Test
//    void testStart() {
//        stopWatch = new StopWatch();
//
//        Assertions.assertThrows(IllegalStateException.class, () -> {
//            stopWatch.start();
//            stopWatch.start();
//        });
//
//        stopWatch.start();
//        Assertions.assertEquals(StopWatch.State.RUNNING, stopWatch.getRunningState());
//    }
//
//    @Test
//    void testStartWithMessage() {
//        stopWatch = new StopWatch("Test");
//
//        stopWatch.start();
//        Assertions.assertEquals(StopWatch.State.RUNNING, stopWatch.getRunningState());
//        Assertions.assertEquals("Test", stopWatch.getMessage());
//    }

    @Test
    void testStartAfterStop() {
        stopWatch = new StopWatch();

        stopWatch.start();
        stopWatch.stop();

        Assertions.assertThrows(IllegalStateException.class, stopWatch::start);
    }

//    @Test
//    void testStartAfterReset() {
//        stopWatch = new StopWatch();
//
//        stopWatch.start();
//        stopWatch.reset();
//
//        stopWatch.start();
//        Assertions.assertEquals(StopWatch.State.RUNNING, stopWatch.getRunningState());
//    }

    @Test
    void testStartAfterSuspend() {
        stopWatch = new StopWatch();

        stopWatch.start();
        stopWatch.suspend();

        Assertions.assertThrows(IllegalStateException.class, stopWatch::start);
    }

//    @Test
//    void testStartAfterResume() {
//        stopWatch = new StopWatch();
//
//        stopWatch.start();
//        stopWatch.suspend();
//        stopWatch.resume();
//
//        stopWatch.start();
//        Assertions.assertEquals(StopWatch.State.RUNNING, stopWatch.getRunningState());
//    }
//    // Test functions

//    @Test
//    void testIsStopped_ReturnsFalse_WhenStateIsRunning() {
//        // Arrange
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.runningState = StopWatch.State.RUNNING;
//
//        // Act
//        boolean isStopped = stopWatch.isStopped();
//
//        // Assert
//        Assertions.assertFalse(isStopped);
//    }
//
//    @Test
//    void testIsStopped_ReturnsTrue_WhenStateIsStopped() {
//        // Arrange
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.runningState = StopWatch.State.STOPPED;
//
//        // Act
//        boolean isStopped = stopWatch.isStopped();
//
//        // Assert
//        Assertions.assertTrue(isStopped);
//    }
//
//    @Test
//    void testIsStopped_ReturnsFalse_WhenStateIsSuspended() {
//        // Arrange
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.runningState = StopWatch.State.SUSPENDED;
//
//        // Act
//        boolean isStopped = stopWatch.isStopped();
//
//        // Assert
//        Assertions.assertFalse(isStopped);
//    }
//
//    @Test
//    void testIsStopped_ReturnsTrue_WhenStateIsUnstarted() {
//        // Arrange
//        StopWatch stopWatch = new StopWatch();
//        stopWatch.runningState = StopWatch.State.UNSTARTED;
//
//        // Act
//        boolean isStopped = stopWatch.isStopped();
//
//        // Assert
//        Assertions.assertTrue(isStopped);
//    }
//
//    @Test
//    void testStop() {
//        StopWatch stopWatch = new StopWatch();
//
//        // Test stopping a running stopwatch
//        stopWatch.start();
//        stopWatch.stop();
//        Assertions.assertEquals(StopWatch.State.STOPPED, stopWatch.getRunningState());
//
//        // Test stopping a suspended stopwatch
//        stopWatch.start();
//        stopWatch.suspend();
//        stopWatch.stop();
//        Assertions.assertEquals(StopWatch.State.STOPPED, stopWatch.getRunningState());
//
//        // Test stopping an unstarted stopwatch
//        Assertions.assertThrows(IllegalStateException.class, () -> {
//            stopWatch.stop();
//        });
//    }
//
//    @Test
//    void testStopWithMessage() {
//        StopWatch stopWatch = new StopWatch("Test StopWatch");
//
//        // Test stopping a running stopwatch with message
//        stopWatch.start();
//        stopWatch.stop();
//        Assertions.assertEquals(StopWatch.State.STOPPED, stopWatch.getRunningState());
//        Assertions.assertEquals("Test StopWatch", stopWatch.getMessage());
//
//        // Test stopping a suspended stopwatch with message
//        stopWatch.start();
//        stopWatch.suspend();
//        stopWatch.stop();
//        Assertions.assertEquals(StopWatch.State.STOPPED, stopWatch.getRunningState());
//        Assertions.assertEquals("Test StopWatch", stopWatch.getMessage());
//
//        // Test stopping an unstarted stopwatch with message
//        Assertions.assertThrows(IllegalStateException.class, () -> {
//            stopWatch.stop();
//        });
//    }
//
//    @Test
//    void testStopWithSplitTime() {
//        StopWatch stopWatch = new StopWatch();
//
//        // Test stopping a running stopwatch with split time
//        stopWatch.start();
//        stopWatch.split();
//        stopWatch.stop();
//        Assertions.assertEquals(StopWatch.State.STOPPED, stopWatch.getRunningState());
//        Assertions.assertEquals(StopWatch.SplitState.SPLIT, stopWatch.getSplitState());
//
//        // Test stopping a suspended stopwatch with split time
//        stopWatch.start();
//        stopWatch.suspend();
//        stopWatch.split();
//        stopWatch.stop();
//        Assertions.assertEquals(StopWatch.State.STOPPED, stopWatch.getRunningState());
//        Assertions.assertEquals(StopWatch.SplitState.SPLIT, stopWatch.getSplitState());
//
//        // Test stopping an unstarted stopwatch with split time
//        Assertions.assertThrows(IllegalStateException.class, () -> {
//            stopWatch.split();
//        });
//    }
////
//    @Test
//    void testStopWithElapsedTime() {
//        StopWatch stopWatch = new StopWatch();
//
//        // Test stopping a running stopwatch with elapsed time
//        stopWatch.start();
//        stopWatch.stop();
//        long elapsedTimeMillis = stopWatch.getElapsedTime(TimeUnit.MILLISECONDS);
//        Assertions.assertTrue(elapsedTimeMillis >= 0);
//
//        // Test stopping a suspended stopwatch with elapsed time
//        stopWatch.start();
//        stopWatch.suspend();
//        stopWatch.stop();
//        elapsedTimeMillis = stopWatch.getElapsedTime(TimeUnit.MILLISECONDS);
//        Assertions.assertTrue(elapsedTimeMillis >= 0);
//
//        // Test stopping an unstarted stopwatch with elapsed time
//        Assertions.assertThrows(IllegalStateException.class, () -> {
//            stopWatch.getElapsedTime(TimeUnit.MILLISECONDS);
//        });
//    }

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

//    @Test
//    void testCreateStartedWithMessage() {
//        StopWatch sw = StopWatch.createStarted("Test");
//        Assertions.assertEquals("Test", sw.getMessage());
//    }
//
//    @Test
//    void testCreateStartedWithEmptyMessage() {
//        StopWatch sw = StopWatch.createStarted("");
//        Assertions.assertEquals("", sw.getMessage());
//    }
//
//    @Test
//    void testCreateStartedWithNullMessage() {
//        StopWatch sw = StopWatch.createStarted(null);
//        Assertions.assertNull(sw.getMessage());
//    }
//
//    @Test
//    void testCreateStartedElapsedTime() throws InterruptedException {
//        StopWatch sw = StopWatch.createStarted();
//        Thread.sleep(1000);
//        sw.stop();
//
//        long elapsedTimeMillis = sw.getElapsedTime(TimeUnit.MILLISECONDS);
//        Assertions.assertTrue(elapsedTimeMillis >= 1000);
//    }
//
//    @Test
//    void testCreateStartedSplit() throws InterruptedException {
//        StopWatch sw = StopWatch.createStarted();
//        Thread.sleep(1000);
//        sw.split();
//
//        long splitTimeMillis = sw.getSplitTime(TimeUnit.MILLISECONDS);
//        Assertions.assertTrue(splitTimeMillis >= 1000);
//    }
//
//    @Test
//    void testCreateStartedUnsplit() throws InterruptedException {
//        StopWatch sw = StopWatch.createStarted();
//        Thread.sleep(1000);
//        sw.split();
//        Thread.sleep(1000);
//        sw.unsplit();
//
//        long elapsedTimeMillis = sw.getElapsedTime(TimeUnit.MILLISECONDS);
//        Assertions.assertTrue(elapsedTimeMillis >= 2000);
//    }
//
//    @Test
//    void testCreateStartedStop() throws InterruptedException {
//        StopWatch sw = StopWatch.createStarted();
//        Thread.sleep(1000);
//        sw.stop();
//
//        long elapsedTimeMillis = sw.getElapsedTime(TimeUnit.MILLISECONDS);
//        Assertions.assertTrue(elapsedTimeMillis >= 1000);
//        Assertions.assertTrue(sw.isStopped());
//    }
////
//    @Test
//    void testCreateStartedRestart() throws InterruptedException {
//        StopWatch sw = StopWatch.createStarted();
//        Thread.sleep(1000);
//        sw.stop();
//        sw.reset();
//        sw.start();
//
//        long elapsedTimeMillis = sw.getElapsedTime(TimeUnit.MILLISECONDS);
//        Assertions.assertTrue(elapsedTimeMillis == 0);
//        Assertions.assertTrue(sw.isStarted());
//        Assertions.assertFalse(sw.isStopped());
//    }

    //@Test
    void testGetStopTime() {
        StopWatch stopWatch = new StopWatch();
        Assertions.assertThrows(IllegalStateException.class, stopWatch::getStopTime);

        stopWatch.start();
        Assertions.assertThrows(IllegalStateException.class, stopWatch::getStopTime);

        stopWatch.stop();
        Assertions.assertEquals(0, stopWatch.getStopTime());

        stopWatch.start();
        stopWatch.suspend();
        Assertions.assertEquals(0, stopWatch.getStopTime());

        stopWatch.resume();
        Assertions.assertEquals(0, stopWatch.getStopTime());

        stopWatch.stop();
        Assertions.assertNotEquals(0, stopWatch.getStopTime());

        stopWatch.reset();
        Assertions.assertEquals(0, stopWatch.getStopTime());
    }

    private StopWatch stopWatch;

    @BeforeEach
    void setUp() {
        stopWatch = new StopWatch();
    }

    //@Test
    void testFormatSplitTime() {
        assertEquals("0", stopWatch.formatSplitTime());

        stopWatch.start();
        sleep(1000);
        stopWatch.split();
        assertTrue(StringUtils.isNotBlank(stopWatch.formatSplitTime()));

        stopWatch.stop();
        sleep(2000);
        stopWatch.split();
        assertTrue(StringUtils.isNotBlank(stopWatch.formatSplitTime()));

        stopWatch.reset();
        assertTrue(StringUtils.isNotBlank(stopWatch.formatSplitTime()));
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

//    @Test
//    void testCreateWithMessage() {
//        StopWatch stopWatch = StopWatch.create("Test StopWatch");
//        Assertions.assertNotNull(stopWatch);
//        Assertions.assertEquals("Test StopWatch", stopWatch.getMessage());
//    }

    //@Test
    void testIsStarted() {
        StopWatch stopWatch = StopWatch.create();
        Assertions.assertFalse(stopWatch.isStarted());

        stopWatch.start();
        Assertions.assertTrue(stopWatch.isStarted());

        stopWatch.stop();
        Assertions.assertFalse(stopWatch.isStarted());

        stopWatch.start();
        stopWatch.suspend();
        Assertions.assertTrue(stopWatch.isStarted());

        stopWatch.resume();
        Assertions.assertTrue(stopWatch.isStarted());

        stopWatch.stop();
        Assertions.assertFalse(stopWatch.isStarted());
    }

    //@Test
    void testIsStopped() {
        StopWatch stopWatch = StopWatch.create();
        Assertions.assertTrue(stopWatch.isStopped());

        stopWatch.start();
        Assertions.assertFalse(stopWatch.isStopped());

        stopWatch.stop();
        Assertions.assertTrue(stopWatch.isStopped());

        stopWatch.start();
        stopWatch.suspend();
        Assertions.assertFalse(stopWatch.isStopped());

        stopWatch.resume();
        Assertions.assertFalse(stopWatch.isStopped());

        stopWatch.stop();
        Assertions.assertTrue(stopWatch.isStopped());
    }

    //@Test
    void testIsSuspended() {
        StopWatch stopWatch = StopWatch.create();
        Assertions.assertFalse(stopWatch.isSuspended());

        stopWatch.start();
        Assertions.assertFalse(stopWatch.isSuspended());

        stopWatch.stop();
        Assertions.assertFalse(stopWatch.isSuspended());

        stopWatch.start();
        stopWatch.suspend();
        Assertions.assertTrue(stopWatch.isSuspended());

        stopWatch.resume();
        Assertions.assertFalse(stopWatch.isSuspended());

        stopWatch.stop();
        Assertions.assertFalse(stopWatch.isSuspended());
    }

//    @Test
//    void testSplitState() {
//        StopWatch stopWatch = StopWatch.create();
//        Assertions.assertEquals(StopWatch.SplitState.UNSPLIT, stopWatch.getSplitState());
//
//        stopWatch.start();
//        stopWatch.split();
//        Assertions.assertEquals(StopWatch.SplitState.SPLIT, stopWatch.getSplitState());
//
//        stopWatch.unsplit();
//        Assertions.assertEquals(StopWatch.SplitState.UNSPLIT, stopWatch.getSplitState());
//
//        stopWatch.split();
//        stopWatch.stop();
//        Assertions.assertEquals(StopWatch.SplitState.SPLIT, stopWatch.getSplitState());
//
//        stopWatch.unsplit();
//        Assertions.assertEquals(StopWatch.SplitState.UNSPLIT, stopWatch.getSplitState());
//    }

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

//    @Test
//    void testGetElapsedTime() throws InterruptedException {
//        StopWatch stopWatch = StopWatch.create();
//        stopWatch.start();
//        Thread.sleep(500);
//        stopWatch.stop();
//
//        long elapsedTimeMillis = stopWatch.getElapsedTime(TimeUnit.MILLISECONDS);
//        Assertions.assertTrue(elapsedTimeMillis >= 500);
//    }
//
//    @Test
//    void testReset() throws InterruptedException {
//        StopWatch stopWatch = StopWatch.create();
//        stopWatch.start();
//        Thread.sleep(500);
//        stopWatch.stop();
//
//        stopWatch.reset();
//        Assertions.assertFalse(stopWatch.isStarted());
//        Assertions.assertTrue(stopWatch.isStopped());
//        Assertions.assertFalse(stopWatch.isSuspended());
//        Assertions.assertEquals(StopWatch.SplitState.UNSPLIT, stopWatch.getSplitState());
//        Assertions.assertEquals(0, stopWatch.getStartTime());
//        Assertions.assertEquals(0, stopWatch.getElapsedTime());
//    }

    //@Test
    public void testGetTime() {
        stopWatch = new StopWatch();

        // Test when stopWatch is not started
        Assertions.assertEquals(0, stopWatch.getTime());

        // Test when stopWatch is started but not stopped
        stopWatch.start();
        Assertions.assertTrue(stopWatch.getTime() > 0);

        // Test when stopWatch is stopped
        stopWatch.stop();
        Assertions.assertTrue(stopWatch.getTime() >= 0);

        // Test when stopWatch is started, stopped, and started again
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        Assertions.assertTrue(stopWatch.getTime() > 0);
    }

    //@Test
    public void testGetTimeWithTimeUnit() {
        stopWatch = new StopWatch();

        // Test when stopWatch is not started
        Assertions.assertEquals(0, stopWatch.getTime(TimeUnit.MILLISECONDS));

        // Test when stopWatch is started but not stopped
        stopWatch.start();
        Assertions.assertTrue(stopWatch.getTime(TimeUnit.MILLISECONDS) > 0);

        // Test when stopWatch is stopped
        stopWatch.stop();
        Assertions.assertTrue(stopWatch.getTime(TimeUnit.MILLISECONDS) >= 0);

        // Test when stopWatch is started, stopped, and started again
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        Assertions.assertTrue(stopWatch.getTime(TimeUnit.MILLISECONDS) > 0);
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