import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class fetchCheckIntervalTest {

    private EventCountCircuitBreaker circuitBreaker;

    @BeforeEach
    void setUp() {
        circuitBreaker = new EventCountCircuitBreaker(5, 1, TimeUnit.SECONDS);
    }

    @Test
    void testFetchCheckInterval() {
        assertEquals(1000000000, circuitBreaker.fetchCheckInterval(circuitBreaker));
    }
}