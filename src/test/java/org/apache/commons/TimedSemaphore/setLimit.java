import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class setLimitTest {
    
    private TimedSemaphore semaphore;
    
    @BeforeEach
    void setUp() {
        semaphore = new TimedSemaphore(1, TimeUnit.SECONDS, 5);
    }
    
    @Test
    void testSetLimitWithPositiveLimit() {
        semaphore.setLimit(10);
        assertEquals(10, semaphore.getLimit());
    }
    
    @Test
    void testSetLimitWithZeroLimit() {
        semaphore.setLimit(0);
        assertEquals(0, semaphore.getLimit());
    }
    
    @Test
    void testSetLimitWithNegativeLimit() {
        semaphore.setLimit(-5);
        assertEquals(-5, semaphore.getLimit());
    }
    
    @Test
    void testSetLimitWithNoLimit() {
        semaphore.setLimit(TimedSemaphore.NO_LIMIT);
        assertEquals(TimedSemaphore.NO_LIMIT, semaphore.getLimit());
    }
    
    @Test
    void testSetLimitWithMultipleThreads() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            semaphore.setLimit(10);
        });
        Thread t2 = new Thread(() -> {
            semaphore.setLimit(5);
        });
        Thread t3 = new Thread(() -> {
            semaphore.setLimit(3);
        });
        
        t1.start();
        t2.start();
        t3.start();
        
        t1.join();
        t2.join();
        t3.join();
        
        assertEquals(3, semaphore.getLimit());
    }
    
    @Test
    void testSetLimitAfterShutdown() {
        semaphore.shutdown();
        
        assertThrows(IllegalStateException.class, () -> {
            semaphore.setLimit(10);
        });
    }
    
    @Test
    void testSetLimitWithNoLimitAfterShutdown() {
        semaphore.shutdown();
        
        assertThrows(IllegalStateException.class, () -> {
            semaphore.setLimit(TimedSemaphore.NO_LIMIT);
        });
    }
    
    @Test
    void testSetLimitWithZeroLimitAfterShutdown() {
        semaphore.shutdown();
        
        assertThrows(IllegalStateException.class, () -> {
            semaphore.setLimit(0);
        });
    }
    
    @Test
    void testSetLimitWithNegativeLimitAfterShutdown() {
        semaphore.shutdown();
        
        assertThrows(IllegalStateException.class, () -> {
            semaphore.setLimit(-5);
        });
    }
    
    @Test
    void testSetLimitWithInvalidLimit() {
        assertThrows(IllegalArgumentException.class, () -> {
            semaphore.setLimit(-10);
        });
    }
    
}