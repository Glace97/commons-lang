import org.junit.jupiter.api.Test;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class tryAcquireTest {

    @Test
    void tryAcquire_whenLimitNotReached_returnsTrue() {
        // given
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);
        long period = 1;
        TimeUnit unit = TimeUnit.SECONDS;
        int limit = 2;
        TimedSemaphore timedSemaphore = new TimedSemaphore(executorService, period, unit, limit);

        // when
        boolean result = timedSemaphore.tryAcquire();

        // then
        assertTrue(result);
    }

    @Test
    void tryAcquire_whenLimitReached_returnsFalse() {
        // given
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);
        long period = 1;
        TimeUnit unit = TimeUnit.SECONDS;
        int limit = 1;
        TimedSemaphore timedSemaphore = new TimedSemaphore(executorService, period, unit, limit);
        timedSemaphore.tryAcquire();

        // when
        boolean result = timedSemaphore.tryAcquire();

        // then
        assertFalse(result);
    }

    @Test
    void tryAcquire_whenShutdownCalled_throwsIllegalStateException() {
        // given
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);
        long period = 1;
        TimeUnit unit = TimeUnit.SECONDS;
        int limit = 2;
        TimedSemaphore timedSemaphore = new TimedSemaphore(executorService, period, unit, limit);
        timedSemaphore.shutdown();

        // then
        assertThrows(IllegalStateException.class, () -> {
            // when
            timedSemaphore.tryAcquire();
        });
    }
}