import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

class closeTest {

    private ThresholdCircuitBreaker circuitBreaker;

    @BeforeEach
    void setUp() {
        circuitBreaker = new ThresholdCircuitBreaker(10L);
    }

    @Test
    void testClose() {
        circuitBreaker.close();
        assertEquals(0L, circuitBreaker.used.get());
    }
}