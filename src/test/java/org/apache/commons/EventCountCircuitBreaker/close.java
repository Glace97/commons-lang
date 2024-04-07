import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class closeTest {
    private EventCountCircuitBreaker circuitBreaker;

    @BeforeEach
    void setUp() {
        // Create a new instance of EventCountCircuitBreaker before each test
        circuitBreaker = new EventCountCircuitBreaker(10, 1, TimeUnit.SECONDS);
    }

    @Test
    void testClose() {
        // Perform the close operation
        circuitBreaker.close();

        // Assert that the circuit breaker is closed
        assertFalse(circuitBreaker.isOpen());
    }

    @Test
    void testCloseMultipleTimes() {
        // Perform the close operation multiple times
        circuitBreaker.close();
        circuitBreaker.close();
        circuitBreaker.close();

        // Assert that the circuit breaker is closed
        assertFalse(circuitBreaker.isOpen());
    }

    @Test
    void testCloseAfterOpen() {
        // Open the circuit breaker
        circuitBreaker.open();

        // Perform the close operation
        circuitBreaker.close();

        // Assert that the circuit breaker is closed
        assertFalse(circuitBreaker.isOpen());
    }

    @Test
    void testCloseWithEvents() {
        // Simulate some events received by the circuit breaker
        for (int i = 0; i < 5; i++) {
            circuitBreaker.incrementEventCount();
        }

        // Perform the close operation
        circuitBreaker.close();

        // Assert that the circuit breaker is closed
        assertFalse(circuitBreaker.isOpen());
    }

    @Test
    void testCloseWithThreshold() {
        // Simulate events received by the circuit breaker exceeding the opening threshold
        for (int i = 0; i < 15; i++) {
            circuitBreaker.incrementEventCount();
        }

        // Perform the close operation
        circuitBreaker.close();

        // Assert that the circuit breaker is closed
        assertFalse(circuitBreaker.isOpen());
    }
}