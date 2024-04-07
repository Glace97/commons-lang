import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class throwableOfThrowableTest {

    @Test
    void testThrowableOfThrowable() {
        // Test with null throwable
        assertNull(ExceptionUtils.throwableOfThrowable(null, Exception.class));
        
        // Test with null class
        assertNull(ExceptionUtils.throwableOfThrowable(new RuntimeException(), null));
        
        // Test with no match in the chain
        assertNull(ExceptionUtils.throwableOfThrowable(new RuntimeException(), IllegalArgumentException.class));
        
        // Test with matching throwable in the chain
        RuntimeException exception = new RuntimeException(new IllegalStateException());
        assertSame(exception, ExceptionUtils.throwableOfThrowable(exception, RuntimeException.class));
        
        // Test with matching throwable in the chain and start index
        assertSame(exception, ExceptionUtils.throwableOfThrowable(exception, RuntimeException.class, 1));
        
        // Test with start index greater than chain size
        assertNull(ExceptionUtils.throwableOfThrowable(exception, RuntimeException.class, 2));
        
        // Test with negative start index
        assertSame(exception, ExceptionUtils.throwableOfThrowable(exception, RuntimeException.class, -1));
    }
}