import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

class isCheckIntervalFinishedTest {

    private EventCountCircuitBreaker breaker;

    @BeforeEach
    void setUp() {
        breaker = new EventCountCircuitBreaker(5, 1, TimeUnit.SECONDS);
    }

    @Test
    void testCheckIntervalFinished() {
        long now = System.nanoTime();
        EventCountCircuitBreaker.CheckIntervalData data = new EventCountCircuitBreaker.CheckIntervalData(0, now);
        assertTrue(breaker.isCheckIntervalFinished(data, now + TimeUnit.MILLISECONDS.toNanos(100)));
        assertFalse(breaker.isCheckIntervalFinished(data, now + TimeUnit.MILLISECONDS.toNanos(900)));
    }

    @Test
    void testCheckIntervalFinishedWithThreshold() {
        long now = System.nanoTime();
        EventCountCircuitBreaker.CheckIntervalData data = new EventCountCircuitBreaker.CheckIntervalData(4, now);
        assertFalse(breaker.isCheckIntervalFinished(data, now + TimeUnit.MILLISECONDS.toNanos(100)));
        assertTrue(breaker.isCheckIntervalFinished(data, now + TimeUnit.MILLISECONDS.toNanos(900)));
    }

    @Test
    void testCheckIntervalFinishedWithZeroDelta() {
        long now = System.nanoTime();
        EventCountCircuitBreaker.CheckIntervalData data = new EventCountCircuitBreaker.CheckIntervalData(0, now);
        assertFalse(breaker.isCheckIntervalFinished(data, now));
    }
}