import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class endOfPeriodTest {

    private TimedSemaphore timedSemaphore;

    @Mock
    private ScheduledExecutorService executorService;

    @Mock
    private ScheduledFuture<?> task;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        timedSemaphore = new TimedSemaphore(executorService, 1000, TimeUnit.MILLISECONDS, 5);
        timedSemaphore.task = task;
    }

    @AfterEach
    void tearDown() {
        timedSemaphore.shutdown();
    }

    @Test
    void testEndOfPeriod() {
        timedSemaphore.acquireCount = 3;
        timedSemaphore.endOfPeriod();

        assertEquals(3, timedSemaphore.lastCallsPerPeriod);
        assertEquals(3, timedSemaphore.totalAcquireCount);
        assertEquals(1, timedSemaphore.periodCount);
        assertEquals(0, timedSemaphore.acquireCount);
    }
}