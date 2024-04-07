import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.lang.reflect.UndeclaredThrowableException;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class wrapAndThrowTest {

    private ExceptionUtils exceptionUtils;

    @BeforeEach
    void setUp() {
        exceptionUtils = new ExceptionUtils();
    }

    @Test
    void wrapAndThrow_shouldThrowUndeclaredThrowableException_whenThrowableIsCheckedException() {
        Exception checkedException = new Exception("Checked Exception");

        assertThrows(UndeclaredThrowableException.class, () -> exceptionUtils.wrapAndThrow(checkedException));
    }

    @Test
    void wrapAndThrow_shouldThrowRuntimeException_whenThrowableIsRuntimeException() {
        RuntimeException runtimeException = new RuntimeException("Runtime Exception");

        assertThrows(RuntimeException.class, () -> exceptionUtils.wrapAndThrow(runtimeException));
    }

    @Test
    void wrapAndThrow_shouldThrowError_whenThrowableIsError() {
        Error error = new Error("Error");

        assertThrows(Error.class, () -> exceptionUtils.wrapAndThrow(error));
    }

    @Test
    void wrapAndThrow_shouldThrowUndeclaredThrowableExceptionWithWrappedThrowable_whenThrowableIsCheckedException() {
        Exception checkedException = new Exception("Checked Exception");

        UndeclaredThrowableException exception = assertThrows(UndeclaredThrowableException.class, () -> exceptionUtils.wrapAndThrow(checkedException));
        assertEquals(checkedException, exception.getCause());
    }

    @Test
    void wrapAndThrow_shouldThrowRuntimeExceptionWithWrappedThrowable_whenThrowableIsRuntimeException() {
        RuntimeException runtimeException = new RuntimeException("Runtime Exception");

        RuntimeException exception = assertThrows(RuntimeException.class, () -> exceptionUtils.wrapAndThrow(runtimeException));
        assertEquals(runtimeException, exception.getCause());
    }

    @Test
    void wrapAndThrow_shouldThrowErrorWithWrappedThrowable_whenThrowableIsError() {
        Error error = new Error("Error");

        Error exception = assertThrows(Error.class, () -> exceptionUtils.wrapAndThrow(error));
        assertEquals(error, exception.getCause());
    }
}