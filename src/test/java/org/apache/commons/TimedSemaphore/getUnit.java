import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getUnitTest {

    TimedSemaphore timedSemaphore;

    @BeforeEach
    void setUp() {
        timedSemaphore = new TimedSemaphore(1, TimeUnit.SECONDS, 5);
    }

    @Test
    void testGetUnit() {
        assertEquals(TimeUnit.SECONDS, timedSemaphore.getUnit());
    }
    
    @Test
    void testGetUnitWithDifferentTimeUnit() {
        timedSemaphore = new TimedSemaphore(1, TimeUnit.MINUTES, 5);
        assertEquals(TimeUnit.MINUTES, timedSemaphore.getUnit());
    }
}