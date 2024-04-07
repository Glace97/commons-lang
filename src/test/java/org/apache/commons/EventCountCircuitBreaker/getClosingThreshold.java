import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class getClosingThresholdTest {

    @Test
    void testGetClosingThreshold() {
        EventCountCircuitBreaker circuitBreaker = new EventCountCircuitBreaker(5, 10, TimeUnit.SECONDS);

        int closingThreshold = circuitBreaker.getClosingThreshold();

        assertEquals(5, closingThreshold);
    }
}