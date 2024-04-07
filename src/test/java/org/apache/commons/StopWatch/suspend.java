import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SuspendTest {
    private StopWatch stopWatch;

    @BeforeEach
    void setUp() {
        stopWatch = new StopWatch();
    }

    @Test
    void suspend_WhenStopWatchIsNotRunning_ShouldThrowIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> {
            stopWatch.suspend();
        });
    }

    @Test
    void suspend_WhenStopWatchIsRunning_ShouldSetStopTimeNanos() {
        stopWatch.start();
        stopWatch.suspend();
        long stopTimeNanos = stopWatch.getStopTimeNanos();
        assertEquals(System.nanoTime(), stopTimeNanos);
    }

    @Test
    void suspend_WhenStopWatchIsRunning_ShouldSetStopTimeMillis() {
        stopWatch.start();
        stopWatch.suspend();
        long stopTimeMillis = stopWatch.getStopTimeMillis();
        assertEquals(System.currentTimeMillis(), stopTimeMillis);
    }

    @Test
    void suspend_WhenStopWatchIsRunning_ShouldSetRunningStateToSuspended() {
        stopWatch.start();
        stopWatch.suspend();
        assertEquals(StopWatch.State.SUSPENDED, stopWatch.getRunningState());
    }
}