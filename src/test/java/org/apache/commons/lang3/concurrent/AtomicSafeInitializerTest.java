package org.apache.commons.lang3.concurrent;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AtomicSafeInitializerTest {

    @Test
    void testGetTwice() throws ConcurrentException {
        AtomicSafeInitializer<Object> initializer = new AtomicSafeInitializer<>();

        Object obj1 = initializer.get();
        Object obj2 = initializer.get();

        assertSame(obj1, obj2);
    }

    @Test
    void testGetConcurrent() throws ConcurrentException, InterruptedException {
        AtomicSafeInitializer<Object> initializer = new AtomicSafeInitializer<>();

        Thread t1 = new Thread(() -> {
            try {
                Object obj1 = initializer.get();
                Thread.sleep(1000);
                Object obj2 = initializer.get();
                assertSame(obj1, obj2);
            } catch (ConcurrentException | InterruptedException e) {
                fail("Exception occurred: " + e.getMessage());
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(500);
                Object obj1 = initializer.get();
                Thread.sleep(500);
                Object obj2 = initializer.get();
                assertSame(obj1, obj2);
            } catch (ConcurrentException | InterruptedException e) {
                fail("Exception occurred: " + e.getMessage());
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    @Test
    void testBuilder() {
        AtomicSafeInitializer.Builder<AtomicSafeInitializer<Object>, Object> builder = AtomicSafeInitializer.builder();
        assertNotNull(builder);
    }

    @Test
    void testGetTypedException() {
        AtomicSafeInitializer initializer = new AtomicSafeInitializer();
        Exception exception = new Exception("Test exception");

        ConcurrentException concurrentException = initializer.getTypedException(exception);

        assertNotNull(concurrentException);
        assertEquals(exception, concurrentException.getCause());
    }

}