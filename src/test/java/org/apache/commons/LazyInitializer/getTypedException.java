import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class getTypedExceptionTest {

    private LazyInitializer lazyInitializer;

    @BeforeEach
    void setUp() {
        lazyInitializer = new LazyInitializer<>();
    }

    @Test
    void testGetTypedException() {
        Exception exception = new Exception("Test exception");
        ConcurrentException concurrentException = lazyInitializer.getTypedException(exception);
        assertNotNull(concurrentException);
        assertEquals(exception, concurrentException.getCause());
    }
}