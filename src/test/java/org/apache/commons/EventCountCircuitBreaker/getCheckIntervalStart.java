import org.junit.jupiter.api.*;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class getCheckIntervalStartTest {

    private EventCountCircuitBreaker circuitBreaker;

    @BeforeEach
    void setUp() {
        circuitBreaker = new EventCountCircuitBreaker(10, 1, TimeUnit.SECONDS);
    }

    @Test
    void testGetCheckIntervalStart() {
        long start = circuitBreaker.getCheckIntervalStart();
        long currentTime = circuitBreaker.nanoTime();

        assertNotEquals(start, currentTime);
    }
}