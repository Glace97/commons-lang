import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class getTest {

    private LazyInitializer<Object, Object> lazyInitializer;

    @BeforeEach
    void setUp() {
        // Initialize the LazyInitializer with a test initializer and closer
        lazyInitializer = new LazyInitializer<>(() -> "Initialized", System.out::println);
    }

    @Test
    void testGet() throws ConcurrentException {
        // Test the get() method when the object is not yet initialized
        Object result1 = lazyInitializer.get();
        assertEquals("Initialized", result1);

        // Test the get() method when the object is already initialized
        Object result2 = lazyInitializer.get();
        assertEquals("Initialized", result2);
    }

    @Test
    void testGetConcurrent() {
        // Test the get() method in concurrent access scenario
        Runnable concurrentAccess = () -> {
            try {
                Object result = lazyInitializer.get();
                assertEquals("Initialized", result);
            } catch (ConcurrentException e) {
                fail("Unexpected exception: " + e.getMessage());
            }
        };

        // Run the concurrent access test with multiple threads
        int numOfThreads = 10;
        Thread[] threads = new Thread[numOfThreads];
        for (int i = 0; i < numOfThreads; i++) {
            threads[i] = new Thread(concurrentAccess);
            threads[i].start();
        }

        // Wait for all threads to finish
        for (int i = 0; i < numOfThreads; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                fail("Unexpected exception: " + e.getMessage());
            }
        }
    }

}