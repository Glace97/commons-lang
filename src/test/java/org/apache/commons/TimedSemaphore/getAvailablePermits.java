import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getAvailablePermitsTest {

    private TimedSemaphore timedSemaphore;

    @BeforeEach
    void setUp() {
        timedSemaphore = new TimedSemaphore(1, TimeUnit.SECONDS, 3);
    }

    @Test
    void testGetAvailablePermits() {
        assertEquals(3, timedSemaphore.getAvailablePermits());
    }

    @Test
    void testGetAvailablePermitsAfterAcquire() throws InterruptedException {
        timedSemaphore.acquire();
        assertEquals(2, timedSemaphore.getAvailablePermits());
    }

    @Test
    void testGetAvailablePermitsAfterMultipleAcquires() throws InterruptedException {
        timedSemaphore.acquire();
        timedSemaphore.acquire();
        assertEquals(1, timedSemaphore.getAvailablePermits());
    }

    @Test
    void testGetAvailablePermitsWithNoLimit() {
        timedSemaphore.setLimit(0);
        assertEquals(0, timedSemaphore.getAvailablePermits());
    }

    @Test
    void testGetAvailablePermitsWithNoAcquires() {
        assertEquals(3, timedSemaphore.getAvailablePermits());
    }

    @Test
    void testGetAvailablePermitsAfterShutdown() {
        timedSemaphore.shutdown();
        assertEquals(0, timedSemaphore.getAvailablePermits());
    }

    @Test
    void testGetAvailablePermitsAfterMultipleShutdowns() {
        timedSemaphore.shutdown();
        timedSemaphore.shutdown();
        assertEquals(0, timedSemaphore.getAvailablePermits());
    }
}