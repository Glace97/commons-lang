import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class getExecutorServiceTest {

    @Test
    void testGetExecutorService() {
        TimedSemaphore timedSemaphore = new TimedSemaphore(1, TimeUnit.SECONDS, 5);
        ScheduledExecutorService executorService = timedSemaphore.getExecutorService();
        assertNotNull(executorService);
    }
    
    @Test
    void testGetExecutorService_CustomService() {
        ScheduledExecutorService customService = Executors.newSingleThreadScheduledExecutor();
        TimedSemaphore timedSemaphore = new TimedSemaphore(customService, 1, TimeUnit.SECONDS, 5);
        ScheduledExecutorService executorService = timedSemaphore.getExecutorService();
        assertEquals(customService, executorService);
    }
    
    @Test
    void testGetExecutorService_NullService() {
        TimedSemaphore timedSemaphore = new TimedSemaphore(null, 1, TimeUnit.SECONDS, 5);
        ScheduledExecutorService executorService = timedSemaphore.getExecutorService();
        assertNotNull(executorService);
    }
    
}