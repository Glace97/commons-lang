import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;

class getPeriodTest {
    private TimedSemaphore timedSemaphore;

    @BeforeEach
    void setUp() {
        timedSemaphore = new TimedSemaphore(10, TimeUnit.SECONDS, 5);
    }

    @Test
    void testGetPeriod() {
        assertEquals(10, timedSemaphore.getPeriod());
    }
}