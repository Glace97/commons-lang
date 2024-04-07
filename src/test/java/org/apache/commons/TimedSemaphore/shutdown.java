import org.junit.jupiter.api.*;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class shutdownTest {

    @Test
    void testShutdownWhenExecutorServiceIsNullAndTaskIsNull() {
        // Setup
        ScheduledExecutorService executorService = null;
        long timePeriod = 1000;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        int limit = 10;
        TimedSemaphore timedSemaphore = new TimedSemaphore(executorService, timePeriod, timeUnit, limit);

        // Test
        timedSemaphore.shutdown();

        // Verify
        assertTrue(timedSemaphore.isShutdown());
    }

    @Test
    void testShutdownWhenExecutorServiceIsNotNullAndTaskIsNull() {
        // Setup
        ScheduledExecutorService executorService = mock(ScheduledExecutorService.class);
        long timePeriod = 1000;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        int limit = 10;
        TimedSemaphore timedSemaphore = new TimedSemaphore(executorService, timePeriod, timeUnit, limit);

        // Test
        timedSemaphore.shutdown();

        // Verify
        assertTrue(timedSemaphore.isShutdown());
        verify(executorService).shutdownNow();
    }

    @Test
    void testShutdownWhenExecutorServiceIsNullAndTaskIsNotNull() {
        // Setup
        ScheduledExecutorService executorService = null;
        long timePeriod = 1000;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        int limit = 10;
        TimedSemaphore timedSemaphore = new TimedSemaphore(executorService, timePeriod, timeUnit, limit);
        ScheduledFuture<?> task = mock(ScheduledFuture.class);
        timedSemaphore.setTask(task);

        // Test
        timedSemaphore.shutdown();

        // Verify
        assertTrue(timedSemaphore.isShutdown());
        verify(task).cancel(false);
    }

    @Test
    void testShutdownWhenExecutorServiceIsNotNullAndTaskIsNotNull() {
        // Setup
        ScheduledExecutorService executorService = mock(ScheduledExecutorService.class);
        long timePeriod = 1000;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        int limit = 10;
        TimedSemaphore timedSemaphore = new TimedSemaphore(executorService, timePeriod, timeUnit, limit);
        ScheduledFuture<?> task = mock(ScheduledFuture.class);
        timedSemaphore.setTask(task);

        // Test
        timedSemaphore.shutdown();

        // Verify
        assertTrue(timedSemaphore.isShutdown());
        verify(executorService).shutdownNow();
        verify(task).cancel(false);
    }

    @Test
    void testShutdownMultipleTimes() {
        // Setup
        ScheduledExecutorService executorService = mock(ScheduledExecutorService.class);
        long timePeriod = 1000;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        int limit = 10;
        TimedSemaphore timedSemaphore = new TimedSemaphore(executorService, timePeriod, timeUnit, limit);

        // Test
        timedSemaphore.shutdown();
        timedSemaphore.shutdown();

        // Verify
        assertTrue(timedSemaphore.isShutdown());
        verify(executorService, times(1)).shutdownNow();
    }
}