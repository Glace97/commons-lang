import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.assertEquals;

class getOpeningIntervalTest {

    private EventCountCircuitBreaker circuitBreaker;

    @BeforeEach
    void setUp() {
        circuitBreaker = new EventCountCircuitBreaker(5, 1, TimeUnit.SECONDS);
    }

    @Test
    void testGetOpeningInterval() {
        long expectedInterval = TimeUnit.SECONDS.toNanos(1);
        long actualInterval = circuitBreaker.getOpeningInterval();
        assertEquals(expectedInterval, actualInterval);
    }
}