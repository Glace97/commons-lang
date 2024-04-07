import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class getNanoTimeTest {

    private StopWatch stopWatch;

    @BeforeEach
    void setUp() {
        stopWatch = new StopWatch();
    }

    @Test
    void testGetNanoTimeWhenNotStarted() {
        assertEquals(0, stopWatch.getNanoTime());
    }

    @Test
    void testGetNanoTimeWhenStopped() {
        stopWatch.start();
        stopWatch.stop();
        assertTrue(stopWatch.getNanoTime() >= 0);
    }

    @Test
    void testGetNanoTimeWhenSuspended() {
        stopWatch.start();
        stopWatch.suspend();
        assertTrue(stopWatch.getNanoTime() >= 0);
    }

    @Test
    void testGetNanoTimeWhenRunning() throws InterruptedException {
        stopWatch.start();
        Thread.sleep(1000);
        assertTrue(stopWatch.getNanoTime() >= 1000000000);
    }

    @Test
    void testGetNanoTimeThrowsExceptionWhenIllegalState() {
        assertThrows(IllegalStateException.class, () -> {
            stopWatch.getNanoTime();
        });
    }
}