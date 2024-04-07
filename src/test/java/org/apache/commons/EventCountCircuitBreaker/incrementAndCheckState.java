import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class incrementAndCheckStateTest {

    private EventCountCircuitBreaker circuitBreaker;

    @BeforeEach
    void setUp() {
        circuitBreaker = new EventCountCircuitBreaker(5, 1, TimeUnit.SECONDS);
    }

    @Test
    void testIncrementAndCheckState_WhenBelowThreshold_ReturnsFalse() {
        boolean result = circuitBreaker.incrementAndCheckState(3);
        
        assertFalse(result);
    }

    @Test
    void testIncrementAndCheckState_WhenAtThreshold_ReturnsTrue() {
        boolean result = circuitBreaker.incrementAndCheckState(5);
        
        assertTrue(result);
    }

    @Test
    void testIncrementAndCheckState_WhenAboveThreshold_ReturnsTrue() {
        boolean result = circuitBreaker.incrementAndCheckState(7);
        
        assertTrue(result);
    }

    @Test
    void testIncrementAndCheckState_WhenIncrementByZero_ReturnsFalse() {
        boolean result = circuitBreaker.incrementAndCheckState(0);
        
        assertFalse(result);
    }

    @Test
    void testIncrementAndCheckState_WhenIncrementByNegativeNumber_ReturnsFalse() {
        boolean result = circuitBreaker.incrementAndCheckState(-3);
        
        assertFalse(result);
    }

    @Test
    void testIncrementAndCheckState_WhenMultipleCallsBelowThreshold_ReturnsFalse() {
        boolean result1 = circuitBreaker.incrementAndCheckState(1);
        boolean result2 = circuitBreaker.incrementAndCheckState(2);
        boolean result3 = circuitBreaker.incrementAndCheckState(3);
        
        assertFalse(result1);
        assertFalse(result2);
        assertFalse(result3);
    }

    @Test
    void testIncrementAndCheckState_WhenMultipleCallsAtThreshold_ReturnsTrue() {
        boolean result1 = circuitBreaker.incrementAndCheckState(2);
        boolean result2 = circuitBreaker.incrementAndCheckState(3);
        
        assertFalse(result1);
        assertTrue(result2);
    }

    @Test
    void testIncrementAndCheckState_WhenMultipleCallsAboveThreshold_ReturnsTrue() {
        boolean result1 = circuitBreaker.incrementAndCheckState(3);
        boolean result2 = circuitBreaker.incrementAndCheckState(5);
        
        assertFalse(result1);
        assertTrue(result2);
    }
}