import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class getAverageCallsPerPeriodTest {

    private TimedSemaphore semaphore;

    @BeforeEach
    void setUp() {
        semaphore = new TimedSemaphore(1, TimeUnit.SECONDS, 5);
    }

    @Test
    void testGetAverageCallsPerPeriod_noCalls() {
        double averageCalls = semaphore.getAverageCallsPerPeriod();
        assertEquals(0, averageCalls);
    }

    @Test
    void testGetAverageCallsPerPeriod_singleCall() throws InterruptedException {
        semaphore.acquire();
        Thread.sleep(1000);
        double averageCalls = semaphore.getAverageCallsPerPeriod();
        assertEquals(1, averageCalls);
    }

    @Test
    void testGetAverageCallsPerPeriod_multipleCalls() throws InterruptedException {
        semaphore.acquire();
        semaphore.acquire();
        semaphore.acquire();
        Thread.sleep(1000);
        double averageCalls = semaphore.getAverageCallsPerPeriod();
        assertEquals(3, averageCalls);
    }

    @Test
    void testGetAverageCallsPerPeriod_resetCounters() throws InterruptedException {
        semaphore.acquire();
        semaphore.acquire();
        semaphore.acquire();
        Thread.sleep(1000);
        double averageCalls = semaphore.getAverageCallsPerPeriod();
        assertEquals(3, averageCalls);

        semaphore.acquire();
        Thread.sleep(1000);
        averageCalls = semaphore.getAverageCallsPerPeriod();
        assertEquals(1, averageCalls);
    }
}