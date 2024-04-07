import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class hasCauseTest {

    @Test
    void testHasCause_ImmediateException() {
        IllegalArgumentException exception = new IllegalArgumentException("Test");
        assertTrue(ExceptionUtils.hasCause(exception, IllegalArgumentException.class));
    }

    @Test
    void testHasCause_CausalChainException() {
        IllegalArgumentException exception1 = new IllegalArgumentException("Test");
        NullPointerException exception2 = new NullPointerException("Test");
        exception1.initCause(exception2);

        assertTrue(ExceptionUtils.hasCause(exception1, NullPointerException.class));
    }

    @Test
    void testHasCause_WrappedException() {
        IllegalArgumentException exception1 = new IllegalArgumentException("Test");
        NullPointerException exception2 = new NullPointerException("Test");
        exception1.initCause(exception2);

        assertTrue(ExceptionUtils.hasCause(exception1, IllegalArgumentException.class));
    }

    @Test
    void testHasCause_UndeclaredThrowableException() {
        IllegalArgumentException exception = new IllegalArgumentException("Test");
        UndeclaredThrowableException undeclaredException = new UndeclaredThrowableException(exception);

        assertTrue(ExceptionUtils.hasCause(undeclaredException, IllegalArgumentException.class));
    }

    @Test
    void testHasCause_NoCause() {
        IllegalArgumentException exception = new IllegalArgumentException("Test");
        assertFalse(ExceptionUtils.hasCause(exception, NullPointerException.class));
    }
}