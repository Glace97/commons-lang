import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class getTest {
    private BackgroundInitializer<Object, Object> initializer;
    private ExecutorService externalExecutor;

    @BeforeEach
    void setUp() {
        externalExecutor = Executors.newSingleThreadExecutor();
        initializer = new BackgroundInitializer<>(null, null, externalExecutor);
    }

    @Test
    void testGet() {
        try {
            Object result = initializer.get();
            assertNull(result);
        } catch (ConcurrentException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testGetWithInitializedObject() {
        Object initializedObject = new Object();
        initializer.initialize(initializedObject);

        try {
            Object result = initializer.get();
            assertEquals(initializedObject, result);
        } catch (ConcurrentException e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void testGetWithInitializationException() {
        initializer.setInitializer(() -> {
            throw new ConcurrentException("Initialization exception");
        });

        try {
            initializer.get();
            fail("ConcurrentException not thrown");
        } catch (ConcurrentException e) {
            assertEquals("Initialization exception", e.getMessage());
        }
    }

    @Test
    void testGetWithExecutionException() {
        Future<Object> future = externalExecutor.submit(() -> {
            throw new RuntimeException("Execution exception");
        });

        initializer.setFuture(future);

        try {
            initializer.get();
            fail("ConcurrentException not thrown");
        } catch (ConcurrentException e) {
            assertEquals("Execution exception", e.getMessage());
        }
    }

    @Test
    void testGetWithInterruptedException() {
        Thread.currentThread().interrupt();

        try {
            initializer.get();
            fail("ConcurrentException not thrown");
        } catch (ConcurrentException e) {
            assertTrue(e.getCause() instanceof InterruptedException);
        }
    }
}