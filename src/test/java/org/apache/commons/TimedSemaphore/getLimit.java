import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getLimitTest {

    private TimedSemaphore semaphore;

    @BeforeEach
    void setUp() {
        semaphore = new TimedSemaphore(1, TimeUnit.SECONDS, 5);
    }

    @Test
    void testGetLimit() {
        assertEquals(5, semaphore.getLimit());
    }
}