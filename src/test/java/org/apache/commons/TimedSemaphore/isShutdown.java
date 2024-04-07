import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import static org.junit.jupiter.api.Assertions.*;

class isShutdownTest {
    private TimedSemaphore timedSemaphore;

    @BeforeEach
    void setUp() {
        ScheduledExecutorService executorService = new ScheduledThreadPoolExecutor(1);
        timedSemaphore = new TimedSemaphore(executorService, 1000, TimeUnit.MILLISECONDS, 10);
    }

    @Test
    void testIsShutdown_ShouldReturnFalse_WhenNotShutdown() {
        assertFalse(timedSemaphore.isShutdown());
    }

    @Test
    void testIsShutdown_ShouldReturnTrue_WhenShutdown() {
        timedSemaphore.shutdown();
        assertTrue(timedSemaphore.isShutdown());
    }

    @Test
    void testIsShutdown_ShouldReturnFalse_WhenRestarted() {
        timedSemaphore.shutdown();
        timedSemaphore = new TimedSemaphore(1000, TimeUnit.MILLISECONDS, 10);
        assertFalse(timedSemaphore.isShutdown());
    }
}