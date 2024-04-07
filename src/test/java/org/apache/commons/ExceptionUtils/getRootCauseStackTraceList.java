import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class getRootCauseStackTraceListTest {

    private ExceptionUtils exceptionUtils;

    @BeforeEach
    void setUp() {
        exceptionUtils = new ExceptionUtils();
    }

    @Test
    @DisplayName("Test getRootCauseStackTraceList with null input")
    void testGetRootCauseStackTraceListWithNull() {
        List<String> result = exceptionUtils.getRootCauseStackTraceList(null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("Test getRootCauseStackTraceList with single throwable")
    void testGetRootCauseStackTraceListWithSingleThrowable() {
        Throwable throwable = new NullPointerException("Null Pointer Exception");
        List<String> result = exceptionUtils.getRootCauseStackTraceList(throwable);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(1, result.size());
        assertEquals(throwable.toString(), result.get(0));
    }

    @Test
    @DisplayName("Test getRootCauseStackTraceList with wrapped exception")
    void testGetRootCauseStackTraceListWithWrappedException() {
        Throwable cause = new IllegalArgumentException("Illegal Argument Exception");
        Throwable throwable = new UndeclaredThrowableException(cause);
        List<String> result = exceptionUtils.getRootCauseStackTraceList(throwable);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(3, result.size());
        assertEquals(throwable.toString(), result.get(0));
        assertEquals(ExceptionUtils.WRAPPED_MARKER + cause.toString(), result.get(1));
        assertEquals(cause.toString(), result.get(2));
    }

    @Test
    @DisplayName("Test getRootCauseStackTraceList with multiple wrapped exceptions")
    void testGetRootCauseStackTraceListWithMultipleWrappedExceptions() {
        Throwable cause1 = new IllegalArgumentException("Illegal Argument Exception");
        Throwable cause2 = new NullPointerException("Null Pointer Exception");
        Throwable throwable = new InvocationTargetException(cause1, cause2);
        List<String> result = exceptionUtils.getRootCauseStackTraceList(throwable);
        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(5, result.size());
        assertEquals(throwable.toString(), result.get(0));
        assertEquals(ExceptionUtils.WRAPPED_MARKER + cause1.toString(), result.get(1));
        assertEquals(cause1.toString(), result.get(2));
        assertEquals(ExceptionUtils.WRAPPED_MARKER + cause2.toString(), result.get(3));
        assertEquals(cause2.toString(), result.get(4));
    }
}