import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getAcquireCountTest {

    private TimedSemaphore timedSemaphore;

    @BeforeEach
    void setUp() {
        timedSemaphore = new TimedSemaphore(1, TimeUnit.SECONDS, 5);
    }

    @Test
    void testGetAcquireCount() {
        assertEquals(0, timedSemaphore.getAcquireCount());
    }

    @Test
    void testGetAcquireCountAfterAcquire() throws InterruptedException {
        timedSemaphore.acquire();
        assertEquals(1, timedSemaphore.getAcquireCount());
    }

    @Test
    void testGetAcquireCountAfterMultipleAcquire() throws InterruptedException {
        timedSemaphore.acquire();
        timedSemaphore.acquire();
        timedSemaphore.acquire();
        assertEquals(3, timedSemaphore.getAcquireCount());
    }

    @Test
    void testGetAcquireCountAfterRelease() throws InterruptedException {
        timedSemaphore.acquire();
        timedSemaphore.acquire();
        timedSemaphore.acquire();
        timedSemaphore.release();
        assertEquals(2, timedSemaphore.getAcquireCount());
    }

    @Test
    void testGetAcquireCountAfterShutdown() throws InterruptedException {
        timedSemaphore.shutdown();
        assertThrows(IllegalStateException.class, () -> timedSemaphore.getAcquireCount());
    }
}