import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ResumeTest {

    private StopWatch stopWatch;

    @BeforeEach
    void setUp() {
        stopWatch = new StopWatch();
    }

    @Nested
    @DisplayName("When StopWatch is in SUSPENDED state")
    class WhenStopWatchIsSuspended {

        @BeforeEach
        void setUp() {
            stopWatch.resume();
            stopWatch.resume();
            stopWatch.suspend();
        }

        @Test
        @DisplayName("resume should change the state to RUNNING")
        void resumeChangesStateToRunning() {
            stopWatch.resume();
            assertEquals(StopWatch.State.RUNNING, stopWatch.getRunningState());
        }

        @Test
        @DisplayName("resume should update the start time in nanoseconds")
        void resumeUpdatesStartTimeInNanos() {
            long originalStartTimeNanos = stopWatch.getStartTimeNanos();
            stopWatch.resume();
            assertNotEquals(originalStartTimeNanos, stopWatch.getStartTimeNanos());
        }

        @Test
        @DisplayName("resume should not update the start time in milliseconds")
        void resumeDoesNotUpdateStartTimeInMillis() {
            long originalStartTimeMillis = stopWatch.getStartTimeMillis();
            stopWatch.resume();
            assertEquals(originalStartTimeMillis, stopWatch.getStartTimeMillis());
        }

        @Test
        @DisplayName("resume should not update the stop time in nanoseconds")
        void resumeDoesNotUpdateStopTimeInNanos() {
            long originalStopTimeNanos = stopWatch.getStopTimeNanos();
            stopWatch.resume();
            assertEquals(originalStopTimeNanos, stopWatch.getStopTimeNanos());
        }

        @Test
        @DisplayName("resume should not update the stop time in milliseconds")
        void resumeDoesNotUpdateStopTimeInMillis() {
            long originalStopTimeMillis = stopWatch.getStopTimeMillis();
            stopWatch.resume();
            assertEquals(originalStopTimeMillis, stopWatch.getStopTimeMillis());
        }

        @Test
        @DisplayName("resume should throw IllegalStateException if called again")
        void resumeThrowsExceptionIfCalledAgain() {
            assertThrows(IllegalStateException.class, () -> stopWatch.resume());
        }
    }

    @Nested
    @DisplayName("When StopWatch is in RUNNING state")
    class WhenStopWatchIsRunning {

        @BeforeEach
        void setUp() {
            stopWatch.start();
        }

        @Test
        @DisplayName("resume should throw IllegalStateException")
        void resumeThrowsException() {
            assertThrows(IllegalStateException.class, () -> stopWatch.resume());
        }
    }

    @Nested
    @DisplayName("When StopWatch is in STOPPED state")
    class WhenStopWatchIsStopped {

        @BeforeEach
        void setUp() {
            stopWatch.start();
            stopWatch.stop();
        }

        @Test
        @DisplayName("resume should throw IllegalStateException")
        void resumeThrowsException() {
            assertThrows(IllegalStateException.class, () -> stopWatch.resume());
        }
    }

    @Nested
    @DisplayName("When StopWatch is in UNSTARTED state")
    class WhenStopWatchIsUnstarted {

        @Test
        @DisplayName("resume should throw IllegalStateException")
        void resumeThrowsException() {
            assertThrows(IllegalStateException.class, () -> stopWatch.resume());
        }
    }
}