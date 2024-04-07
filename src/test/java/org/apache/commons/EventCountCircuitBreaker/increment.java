import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

class incrementTest {

    private EventCountCircuitBreaker circuitBreaker;

    @BeforeEach
    void setUp() {
        circuitBreaker = new EventCountCircuitBreaker(5, 1, TimeUnit.SECONDS);
    }

    @Test
    void testIncrement() {
        CheckIntervalData initialData = circuitBreaker.checkIntervalData.get();
        CheckIntervalData newData = circuitBreaker.increment(1);
        assertEquals(initialData.getEventCount() + 1, newData.getEventCount());
        assertEquals(initialData.getCheckIntervalStart(), newData.getCheckIntervalStart());
    }

    @Test
    void testIncrementWithZeroDelta() {
        CheckIntervalData initialData = circuitBreaker.checkIntervalData.get();
        CheckIntervalData newData = circuitBreaker.increment(0);
        assertSame(initialData, newData);
    }

    @Test
    void testIncrementWithNegativeDelta() {
        CheckIntervalData initialData = circuitBreaker.checkIntervalData.get();
        CheckIntervalData newData = circuitBreaker.increment(-1);
        assertEquals(initialData.getEventCount() - 1, newData.getEventCount());
        assertEquals(initialData.getCheckIntervalStart(), newData.getCheckIntervalStart());
    }
}