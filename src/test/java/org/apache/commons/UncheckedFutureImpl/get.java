import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.apache.commons.lang3.exception.UncheckedInterruptedException;

class getTest {

    private UncheckedFutureImpl future;

    @BeforeEach
    void setUp() {
        future = new UncheckedFutureImpl(new Future<V>() {
            @Override
            public boolean cancel(boolean mayInterruptIfRunning) {
                return false;
            }

            @Override
            public boolean isCancelled() {
                return false;
            }

            @Override
            public boolean isDone() {
                return false;
            }

            @Override
            public V get() throws InterruptedException, ExecutionException {
                return null;
            }

            @Override
            public V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
                return null;
            }
        });
    }

    @Test
    void testGet() {
        assertThrows(UncheckedInterruptedException.class, () -> future.get());

        assertThrows(UncheckedExecutionException.class, () -> {
            future.get();
            throw new ExecutionException(new Exception());
        });
    }

    @Test
    void testGetWithTimeout() {
        assertThrows(UncheckedInterruptedException.class, () -> future.get(1, TimeUnit.SECONDS));

        assertThrows(UncheckedExecutionException.class, () -> {
            future.get(1, TimeUnit.SECONDS);
            throw new ExecutionException(new Exception());
        });

        assertThrows(UncheckedTimeoutException.class, () -> {
            future.get(1, TimeUnit.SECONDS);
            throw new TimeoutException();
        });
    }
}