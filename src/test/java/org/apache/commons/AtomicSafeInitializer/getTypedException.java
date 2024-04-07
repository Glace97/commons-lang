import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.atomic.AtomicReference;

class getTypedExceptionTest {

    private AtomicSafeInitializer<Object> initializer;

    @BeforeEach
    void setUp() {
        initializer = new AtomicSafeInitializer<>();
    }

    @Test
    void testGetTypedException() {
        Exception exception = new Exception("Test Exception");
        ConcurrentException concurrentException = initializer.getTypedException(exception);
        Assertions.assertEquals(exception, concurrentException.getCause());
    }
}