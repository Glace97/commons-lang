import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class getFutureTest {

    private BackgroundInitializer<String, String> initializer;
    private ExecutorService executor;

    @BeforeEach
    void setUp() {
        executor = Executors.newFixedThreadPool(1);
        initializer = new BackgroundInitializer<>(() -> {
            // Initialization logic
            return "Initialized";
        }, null, executor);
    }

    @Test
    void testGetFuture() {
        Future<String> future = initializer.getFuture();
        assertNotNull(future);
    }

    @Test
    void testGetFuture_ThrowsIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> initializer.getFuture());
    }
}