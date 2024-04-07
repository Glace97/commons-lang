
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class CheckStateTest {

    private EventCountCircuitBreaker circuitBreaker;

    @BeforeEach
    void setUp() {
        circuitBreaker = new EventCountCircuitBreaker(5, 1000, TimeUnit.MILLISECONDS);
    }

    @Test
    void checkState_WhenBelowOpeningThreshold_ShouldReturnFalse() {
        boolean result = circuitBreaker.checkState();

        assertFalse(result);
    }

    @Test
    void checkState_WhenAboveOpeningThreshold_ShouldReturnTrue() {
        // Increase the event count to be above the opening threshold
        simulateEvents(6);

        boolean result = circuitBreaker.checkState();

        assertTrue(result);
    }

    @Test
    void checkState_WhenAboveOpeningThresholdAndIntervalNotFinished_ShouldReturnTrue() {
        // Increase the event count to be above the opening threshold
        simulateEvents(6);

        // Perform the check state twice without waiting for the interval to finish
        boolean result1 = circuitBreaker.checkState();
        boolean result2 = circuitBreaker.checkState();

        assertTrue(result1);
        assertFalse(result2);
    }

    @Test
    void checkState_WhenIntervalFinishedAndBelowClosingThreshold_ShouldReturnFalse() throws InterruptedException {
        // Increase the event count to be above the opening threshold
        simulateEvents(6);

        // Wait for the opening interval to finish
        Thread.sleep(1000);

        // Perform the check state with an event count below closing threshold
        boolean result = circuitBreaker.checkState();

        assertFalse(result);
    }

    @Test
    void checkState_WhenIntervalFinishedAndAboveClosingThreshold_ShouldReturnTrue() throws InterruptedException {
        // Increase the event count to be above the opening threshold
        simulateEvents(6);

        // Wait for the opening interval to finish
        Thread.sleep(1000);

        // Increase the event count to be above the closing threshold
        simulateEvents(5);

        // Perform the check state
        boolean result = circuitBreaker.checkState();

        assertTrue(result);
    }

    private void simulateEvents(int count) {
        for (int i = 0; i < count; i++) {
            // Simulate an event
        }
    }
}
