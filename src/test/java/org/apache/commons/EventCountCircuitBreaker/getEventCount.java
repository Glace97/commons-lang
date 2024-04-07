import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

class getEventCountTest {

    private EventCountCircuitBreaker circuitBreaker;

    @BeforeEach
    void setUp() {
        circuitBreaker = new EventCountCircuitBreaker(10, 1, TimeUnit.SECONDS);
    }

    @Test
    void testGetEventCount() {
        assertEquals(0, circuitBreaker.getEventCount());

        for (int i = 1; i <= 5; i++) {
            circuitBreaker.incrementEventCount();
            assertEquals(i, circuitBreaker.getEventCount());
        }
    }

    @Test
    void testGetEventCountWithZeroDelta() {
        assertEquals(0, circuitBreaker.getEventCount());

        circuitBreaker.incrementEventCount(0);
        assertEquals(0, circuitBreaker.getEventCount());
    }

    @Test
    void testGetEventCountWithPositiveDelta() {
        assertEquals(0, circuitBreaker.getEventCount());

        circuitBreaker.incrementEventCount(5);
        assertEquals(5, circuitBreaker.getEventCount());
    }

    @Test
    void testGetEventCountWithNegativeDelta() {
        assertEquals(0, circuitBreaker.getEventCount());

        circuitBreaker.incrementEventCount(5);
        assertEquals(5, circuitBreaker.getEventCount());

        circuitBreaker.incrementEventCount(-3);
        assertEquals(2, circuitBreaker.getEventCount());
    }
}