import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class getThresholdTest {

    @Test
    void testGetThreshold() {
        // Test case 1: threshold = 0
        ThresholdCircuitBreaker circuitBreaker1 = new ThresholdCircuitBreaker(0);
        assertEquals(0, circuitBreaker1.getThreshold());

        // Test case 2: threshold = 100
        ThresholdCircuitBreaker circuitBreaker2 = new ThresholdCircuitBreaker(100);
        assertEquals(100, circuitBreaker2.getThreshold());

        // Test case 3: threshold = -100
        ThresholdCircuitBreaker circuitBreaker3 = new ThresholdCircuitBreaker(-100);
        assertEquals(-100, circuitBreaker3.getThreshold());
    }
}