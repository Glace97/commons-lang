import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class checkStateTest {

    private ThresholdCircuitBreaker circuitBreaker;

    @BeforeEach
    void setUp() {
        circuitBreaker = new ThresholdCircuitBreaker(10L);
    }

    @Test
    void testCheckState_InitiallyClosed() {
        assertTrue(circuitBreaker.checkState());
    }

    @Test
    void testCheckState_OpenAfterThresholdExceeded() {
        for (int i = 0; i < 11; i++) {
            assertFalse(circuitBreaker.checkState());
        }
    }

    @Test
    void testCheckState_ClosedAfterThresholdReset() {
        for (int i = 0; i < 10; i++) {
            assertFalse(circuitBreaker.checkState());
        }
        assertTrue(circuitBreaker.checkState());
    }

    @Test
    void testCheckState_OpenAfterThresholdReset() {
        for (int i = 0; i < 11; i++) {
            assertFalse(circuitBreaker.checkState());
        }
        assertFalse(circuitBreaker.checkState());
    }
}