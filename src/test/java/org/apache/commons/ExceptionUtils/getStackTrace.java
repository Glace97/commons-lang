import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.io.IOException;

class getStackTraceTest {

    @Test
    void testGetStackTrace_NullInput_ReturnsEmptyString() {
        String stackTrace = ExceptionUtils.getStackTrace(null);
        assertEquals("", stackTrace);
    }

    @Test
    void testGetStackTrace_IOException_ReturnsStackTraceAsString() {
        IOException exception = new IOException("Test exception");
        String expectedStackTrace = exception.toString() + "\n" +
                "\tat org.example.ExceptionUtils.getStackTrace(ExceptionUtils.java:42)\n" +
                "\tat org.example.getStackTraceTest.testGetStackTrace_IOException_ReturnsStackTraceAsString(getStackTraceTest.java:20)";
        String stackTrace = ExceptionUtils.getStackTrace(exception);
        assertEquals(expectedStackTrace, stackTrace);
    }

    @Test
    void testGetStackTrace_UndeclaredThrowableException_ReturnsStackTraceAsString() {
        RuntimeException cause = new RuntimeException("Cause exception");
        UndeclaredThrowableException exception = new UndeclaredThrowableException(cause);
        String expectedStackTrace = exception.toString() + "\n" +
                "\tat org.example.ExceptionUtils.getStackTrace(ExceptionUtils.java:42)\n" +
                "\tat org.example.getStackTraceTest.testGetStackTrace_UndeclaredThrowableException_ReturnsStackTraceAsString(getStackTraceTest.java:30)" + "\n" +
                "Caused by: " + cause.toString() + "\n" +
                "\tat org.example.getStackTraceTest.testGetStackTrace_UndeclaredThrowableException_ReturnsStackTraceAsString(getStackTraceTest.java:29)";
        String stackTrace = ExceptionUtils.getStackTrace(exception);
        assertEquals(expectedStackTrace, stackTrace);
    }

    @Test
    void testGetStackTrace_MethodNotFoundException_ReturnsEmptyString() {
        MethodNotFoundException exception = new MethodNotFoundException("Method not found");
        String expectedStackTrace = exception.toString();
        String stackTrace = ExceptionUtils.getStackTrace(exception);
        assertEquals(expectedStackTrace, stackTrace);
    }

    @Test
    void testGetStackTrace_EmptyStackTrace_ReturnsEmptyString() {
        EmptyStackTraceException exception = new EmptyStackTraceException("Empty stack trace");
        String expectedStackTrace = exception.toString();
        String stackTrace = ExceptionUtils.getStackTrace(exception);
        assertEquals(expectedStackTrace, stackTrace);
    }

    @Test
    void testGetStackTrace_LongStackTrace_ReturnsStackTraceAsString() {
        RuntimeException exception = new RuntimeException("Test exception");
        for (int i = 0; i < 100; i++) {
            exception = new RuntimeException("Wrapper exception", exception);
        }
        String stackTrace = ExceptionUtils.getStackTrace(exception);
        assertEquals(101, stackTrace.split("\n").length);
    }
}

class MethodNotFoundException extends Exception {
    public MethodNotFoundException(String message) {
        super(message);
    }
}

class EmptyStackTraceException extends Exception {
    public EmptyStackTraceException(String message) {
        super(message);
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}