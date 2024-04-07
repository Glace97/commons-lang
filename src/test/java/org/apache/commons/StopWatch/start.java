import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;

class startTest {

    @Test
    void testStart() {
        StopWatch stopWatch = new StopWatch();

        // Test starting a new timing session
        stopWatch.start();
        assertEquals(StopWatch.State.RUNNING, stopWatch.getRunningState());
        assertTrue(stopWatch.getStartTimeNanos() > 0);
        assertTrue(stopWatch.getStartTimeMillis() > 0);

        // Test starting a stopped StopWatch
        assertThrows(IllegalStateException.class, () -> {
            stopWatch.stop();
            stopWatch.start();
        });

        // Test starting an already started StopWatch
        assertThrows(IllegalStateException.class, () -> {
            stopWatch.start();
            stopWatch.start();
        });
    }
}