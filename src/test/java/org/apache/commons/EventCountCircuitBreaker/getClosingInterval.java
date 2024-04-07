import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getClosingIntervalTest {
    
    @Test
    void testClosingInterval() {
        EventCountCircuitBreaker breaker = new EventCountCircuitBreaker(10, 1, TimeUnit.SECONDS);
        long closingInterval = breaker.getClosingInterval();
        assertEquals(1000000000, closingInterval);
    }
    
    @Test
    void testClosingIntervalWithCustomUnit() {
        EventCountCircuitBreaker breaker = new EventCountCircuitBreaker(10, 1, TimeUnit.MINUTES);
        long closingInterval = breaker.getClosingInterval();
        assertEquals(60000000000, closingInterval);
    }
    
    @Test
    void testClosingIntervalWithCustomThreshold() {
        EventCountCircuitBreaker breaker = new EventCountCircuitBreaker(20, 1, TimeUnit.SECONDS, 5);
        long closingInterval = breaker.getClosingInterval();
        assertEquals(1000000000, closingInterval);
    }
    
    @Test
    void testClosingIntervalWithCustomThresholdAndUnit() {
        EventCountCircuitBreaker breaker = new EventCountCircuitBreaker(20, 1, TimeUnit.MINUTES, 5);
        long closingInterval = breaker.getClosingInterval();
        assertEquals(60000000000, closingInterval);
    }
}