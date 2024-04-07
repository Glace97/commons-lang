import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import java.util.concurrent.atomic.AtomicReference;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableSupplier;

@TestInstance(Lifecycle.PER_CLASS)
class getTest {
    private AtomicSafeInitializer<Object> initializer;

    @BeforeEach
    void setUp() {
        initializer = new AtomicSafeInitializer<>();
    }

    @Test
    void testGetInitializedObject() throws ConcurrentException {
        Object obj = new Object();
        AtomicSafeInitializer<Object> initializer = new AtomicSafeInitializer<>(() -> obj, null);
        assertEquals(obj, initializer.get());
    }

    @Test
    void testGetLazyInitialization() throws ConcurrentException {
        AtomicSafeInitializer<Object> initializer = new AtomicSafeInitializer<>(() -> new Object(), null);
        assertNotNull(initializer.get());
    }

    @Test
    void testGetMultipleThreads() throws InterruptedException {
        AtomicSafeInitializer<Object> initializer = new AtomicSafeInitializer<>(() -> new Object(), null);
        AtomicReference<Object> result1 = new AtomicReference<>();
        AtomicReference<Object> result2 = new AtomicReference<>();

        Thread thread1 = new Thread(() -> {
            try {
                result1.set(initializer.get());
            } catch (ConcurrentException e) {
                fail("Exception occurred in thread1: " + e.getMessage());
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                result2.set(initializer.get());
            } catch (ConcurrentException e) {
                fail("Exception occurred in thread2: " + e.getMessage());
            }
        });

        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        assertSame(result1.get(), result2.get());
    }

    @Test
    void testGetException() {
        AtomicSafeInitializer<Object> initializer = new AtomicSafeInitializer<>(() -> {
            throw new ConcurrentException("Initialization exception");
        }, null);

        assertThrows(ConcurrentException.class, () -> initializer.get());
    }
}