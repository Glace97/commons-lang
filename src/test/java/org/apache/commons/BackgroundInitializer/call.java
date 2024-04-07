import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class CallTest {
    private BackgroundInitializer<Integer> initializer;

    @BeforeEach
    void setUp() {
        initializer = new BackgroundInitializer<>();
    }

    @Test
    void testInitialize() throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        initializer.setExternalExecutor(executor);

        Future<Integer> future = initializer.start();
        Integer result = future.get();

        assertNotNull(result);
        assertEquals(0, result);
        assertFalse(initializer.isFailed());
        assertTrue(initializer.isStarted());
        assertTrue(initializer.isInitialized());
    }

    @Test
    void testInitializeWithException() throws Exception {
        FailableSupplier<Integer, ConcurrentException> initializerFunction = () -> {
            throw new ConcurrentException("Initialization failed");
        };
        initializer = new BackgroundInitializer<>(initializerFunction, null, null);

        Future<Integer> future = initializer.start();

        assertNotNull(future);
        assertThrows(ExecutionException.class, () -> future.get());
        assertTrue(initializer.isFailed());
        assertTrue(initializer.isStarted());
        assertFalse(initializer.isInitialized());
    }

    @Test
    void testInitializeWithoutExternalExecutor() throws Exception {
        Future<Integer> future = initializer.start();
        Integer result = future.get();

        assertNotNull(result);
        assertEquals(0, result);
        assertFalse(initializer.isFailed());
        assertTrue(initializer.isStarted());
        assertTrue(initializer.isInitialized());
    }

    @Test
    void testInitializeWithExternalExecutorShutdown() throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        initializer.setExternalExecutor(executor);

        initializer.start();

        assertTrue(executor.isShutdown());
    }

    @Test
    void testInitializeWithExternalExecutorNull() throws Exception {
        initializer.setExternalExecutor(null);

        Future<Integer> future = initializer.start();
        Integer result = future.get();

        assertNotNull(result);
        assertEquals(0, result);
        assertFalse(initializer.isFailed());
        assertTrue(initializer.isStarted());
        assertTrue(initializer.isInitialized());
    }
}