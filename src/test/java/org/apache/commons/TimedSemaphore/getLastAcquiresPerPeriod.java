import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class getLastAcquiresPerPeriodTest {

    private TimedSemaphore timedSemaphore;

    @BeforeEach
    void setUp() {
        // Initialize TimedSemaphore with a time period of 1 second and limit of 5
        timedSemaphore = new TimedSemaphore(1, TimeUnit.SECONDS, 5);
    }

    @Test
    void testGetLastAcquiresPerPeriod_WhenNoAcquires_ReturnsZero() {
        assertEquals(0, timedSemaphore.getLastAcquiresPerPeriod());
    }

    @Test
    void testGetLastAcquiresPerPeriod_WhenOneAcquire_ReturnsOne() {
        timedSemaphore.acquire();
        assertEquals(1, timedSemaphore.getLastAcquiresPerPeriod());
    }

    @Test
    void testGetLastAcquiresPerPeriod_WhenMultipleAcquires_ReturnsCorrectCount() {
        timedSemaphore.acquire();
        timedSemaphore.acquire();
        timedSemaphore.acquire();
        assertEquals(3, timedSemaphore.getLastAcquiresPerPeriod());
    }

    @Test
    void testGetLastAcquiresPerPeriod_WhenLimitReached_ReturnsLimit() {
        for (int i = 0; i < 5; i++) {
            timedSemaphore.acquire();
        }
        assertEquals(5, timedSemaphore.getLastAcquiresPerPeriod());
    }

    @Test
    void testGetLastAcquiresPerPeriod_WhenLimitExceeded_ReturnsLimit() {
        for (int i = 0; i < 10; i++) {
            timedSemaphore.acquire();
        }
        assertEquals(5, timedSemaphore.getLastAcquiresPerPeriod());
    }

    @Test
    void testGetLastAcquiresPerPeriod_WhenShutdown_ReturnsZero() {
        timedSemaphore.shutdown();
        assertEquals(0, timedSemaphore.getLastAcquiresPerPeriod());
    }
}