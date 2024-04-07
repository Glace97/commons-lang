import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

class openTest {

    private EventCountCircuitBreaker circuitBreaker;

    @BeforeEach
    void setUp() {
        circuitBreaker = new EventCountCircuitBreaker(10, 1, TimeUnit.SECONDS);
    }

    @Test
    void testOpen() {
        circuitBreaker.open();
        assertTrue(circuitBreaker.isOpen());
    }

    @Test
    void testOpenMultipleTimes() {
        circuitBreaker.open();
        circuitBreaker.open();
        assertTrue(circuitBreaker.isOpen());
    }

    @Test
    void testClose() {
        circuitBreaker.open();
        circuitBreaker.close();
        assertFalse(circuitBreaker.isOpen());
    }

    @Test
    void testCloseWithoutOpening() {
        circuitBreaker.close();
        assertFalse(circuitBreaker.isOpen());
    }

    @Test
    void testOpenThresholdReached() {
        for (int i = 0; i < 10; i++) {
            circuitBreaker.incrementEventCount();
        }
        circuitBreaker.incrementEventCount();
        assertTrue(circuitBreaker.isOpen());
    }

    @Test
    void testOpenThresholdNotReached() {
        for (int i = 0; i < 9; i++) {
            circuitBreaker.incrementEventCount();
        }
        circuitBreaker.incrementEventCount();
        assertFalse(circuitBreaker.isOpen());
    }

    @Test
    void testClosingThresholdReached() {
        circuitBreaker.open();
        circuitBreaker.incrementEventCount();
        circuitBreaker.incrementEventCount();
        circuitBreaker.close();
        assertFalse(circuitBreaker.isOpen());
    }

    @Test
    void testClosingThresholdNotReached() {
        circuitBreaker.open();
        circuitBreaker.incrementEventCount();
        circuitBreaker.close();
        assertTrue(circuitBreaker.isOpen());
    }

    @Test
    void testIncrementEventCount() {
        circuitBreaker.incrementEventCount();
        assertEquals(1, circuitBreaker.getEventCount());
    }

    @Test
    void testIncrementEventCountMultipleTimes() {
        for (int i = 0; i < 10; i++) {
            circuitBreaker.incrementEventCount();
        }
        assertEquals(10, circuitBreaker.getEventCount());
    }

    @Test
    void testIncrementEventCountAfterOpening() {
        circuitBreaker.open();
        circuitBreaker.incrementEventCount();
        assertEquals(1, circuitBreaker.getEventCount());
    }

    @Test
    void testIncrementEventCountAfterClosing() {
        circuitBreaker.open();
        circuitBreaker.incrementEventCount();
        circuitBreaker.close();
        circuitBreaker.incrementEventCount();
        assertEquals(2, circuitBreaker.getEventCount());
    }
}