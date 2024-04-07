import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class getStopTimeTest {

    private StopWatch stopWatch;

    @BeforeEach
    void setUp() {
        stopWatch = new StopWatch();
    }

    @Test
    void testGetStopTime_WhenStopWatchNotStarted_ThrowsIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> {
            stopWatch.getStopTime();
        });
    }

    @Test
    void testGetStopTime_WhenStopWatchStarted_ReturnsStopTime() {
        stopWatch.start();
        long expectedStopTime = System.currentTimeMillis();
        assertEquals(expectedStopTime, stopWatch.getStopTime());
    }

    @Test
    void testGetStopTime_WhenStopWatchStopped_ReturnsStopTime() {
        stopWatch.start();
        stopWatch.stop();
        long expectedStopTime = System.currentTimeMillis();
        assertEquals(expectedStopTime, stopWatch.getStopTime());
    }

    @Test
    void testGetStopTime_WhenStopWatchSuspended_ReturnsStopTime() {
        stopWatch.start();
        stopWatch.suspend();
        long expectedStopTime = System.currentTimeMillis();
        assertEquals(expectedStopTime, stopWatch.getStopTime());
    }

    @Test
    void testGetStopTime_WhenStopWatchResumed_ReturnsStopTime() {
        stopWatch.start();
        stopWatch.suspend();
        stopWatch.resume();
        long expectedStopTime = System.currentTimeMillis();
        assertEquals(expectedStopTime, stopWatch.getStopTime());
    }

    @Test
    void testGetStopTime_WhenStopWatchSplit_ReturnsStopTime() {
        stopWatch.start();
        stopWatch.split();
        long expectedStopTime = System.currentTimeMillis();
        assertEquals(expectedStopTime, stopWatch.getStopTime());
    }

    @Test
    void testGetStopTime_WhenStopWatchUnsplit_ReturnsStopTime() {
        stopWatch.start();
        stopWatch.split();
        stopWatch.unsplit();
        long expectedStopTime = System.currentTimeMillis();
        assertEquals(expectedStopTime, stopWatch.getStopTime());
    }

    @Test
    void testGetStopTime_WhenStopWatchReset_ReturnsStopTime() {
        stopWatch.start();
        stopWatch.reset();
        long expectedStopTime = System.currentTimeMillis();
        assertEquals(expectedStopTime, stopWatch.getStopTime());
    }
}