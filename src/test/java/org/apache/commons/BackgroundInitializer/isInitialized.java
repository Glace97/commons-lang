import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.lang3.concurrent.ConcurrentException;
import org.apache.commons.lang3.function.FailableConsumer;
import org.apache.commons.lang3.function.FailableSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class isInitializedTest {

    private BackgroundInitializer<String, isInitializedTest.BackgroundInitializer<String>> initializer;
    private ExecutorService executor;

    @BeforeEach
    void setUp() {
        executor = Executors.newSingleThreadExecutor();
        initializer = new BackgroundInitializer<>(this::initialize, this::close, executor);
    }

    @Test
    void testIsInitialized() {
        assertFalse(initializer.isInitialized());

        initializer.start();

        try {
            Thread.sleep(100); // Wait for initialization to complete
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(initializer.isInitialized());
    }

    private String initialize() throws ConcurrentException {
        return "Initialized";
    }

    private void close(String value) throws ConcurrentException {
        // Close resources
    }

    static class BackgroundInitializer<I extends BackgroundInitializer<T>, T> {

        private FailableSupplier<T, ConcurrentException> initializer;
        private FailableConsumer<T, ConcurrentException> closer;
        private ExecutorService externalExecutor;
        private ExecutorService executor;
        private Future<T> future;

        BackgroundInitializer(FailableSupplier<T, ConcurrentException> initializer,
                FailableConsumer<T, ConcurrentException> closer, ExecutorService exec) {
            this.initializer = initializer;
            this.closer = closer;
            setExternalExecutor(exec);
        }

        boolean isInitialized() {
            if (future == null || !future.isDone()) {
                return false;
            }

            try {
                future.get();
                return true;
            } catch (CancellationException | ExecutionException | InterruptedException e) {
                return false;
            }
        }

        void start() {
            if (future == null) {
                Callable<T> task = new InitializationTask<>(executor);
                future = executor.submit(task);
            }
        }

        void setExternalExecutor(ExecutorService externalExecutor) {
            this.externalExecutor = externalExecutor;
            if (externalExecutor != null) {
                executor = externalExecutor;
            } else {
                executor = Executors.newSingleThreadExecutor();
            }
        }

        private static class InitializationTask<T> implements Callable<T> {
            private final ExecutorService execFinally;

            InitializationTask(ExecutorService exec) {
                execFinally = exec;
            }

            @Override
            public T call() throws Exception {
                try {
                    return initialize();
                } finally {
                    if (execFinally != null) {
                        execFinally.shutdown();
                    }
                }
            }

            private T initialize() throws ConcurrentException {
                // Initialize object
                return null;
            }
        }
    }
}