import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isStoppedTest {

    private StopWatch stopWatch;

    @BeforeEach
    void setUp() {
        stopWatch = new StopWatch();
    }

    @Test
    void testIsStoppedWhenUnstarted() {
        assertFalse(stopWatch.isStopped());
    }

    @Test
    void testIsStoppedWhenStarted() {
        stopWatch.start();
        assertFalse(stopWatch.isStopped());
    }

    @Test
    void testIsStoppedWhenStopped() {
        stopWatch.start();
        stopWatch.stop();
        assertTrue(stopWatch.isStopped());
    }

    @Test
    void testIsStoppedWhenSuspended() {
        stopWatch.start();
        stopWatch.suspend();
        assertFalse(stopWatch.isStopped());
    }

    @Test
    void testIsStoppedWhenUnstartedAndStopped() {
        stopWatch.stop();
        assertTrue(stopWatch.isStopped());
    }

    @Test
    void testIsStoppedWhenSuspendedAndStopped() {
        stopWatch.start();
        stopWatch.suspend();
        stopWatch.stop();
        assertTrue(stopWatch.isStopped());
    }
}