import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getMessageTest {

    @Test
    void testGetMessage_NullInput_ReturnsEmptyString() {
        Throwable th = null;
        String expected = "";
        String actual = ExceptionUtils.getMessage(th);
        assertEquals(expected, actual);
    }

    @Test
    void testGetMessage_WithThrowable_ReturnsFormattedMessage() {
        Throwable th = new Throwable("Test Exception");
        String expected = "Throwable: Test Exception";
        String actual = ExceptionUtils.getMessage(th);
        assertEquals(expected, actual);
    }

    @Test
    void testGetMessage_WithException_ReturnsFormattedMessage() {
        Exception ex = new Exception("Test Exception");
        String expected = "Exception: Test Exception";
        String actual = ExceptionUtils.getMessage(ex);
        assertEquals(expected, actual);
    }

    @Test
    void testGetMessage_WithRuntimeException_ReturnsFormattedMessage() {
        RuntimeException ex = new RuntimeException("Test Exception");
        String expected = "RuntimeException: Test Exception";
        String actual = ExceptionUtils.getMessage(ex);
        assertEquals(expected, actual);
    }

    @Test
    void testGetMessage_WithUndeclaredThrowableException_ReturnsFormattedMessage() {
        Throwable th = new UndeclaredThrowableException(new Exception("Test Exception"));
        String expected = "UndeclaredThrowableException: Test Exception";
        String actual = ExceptionUtils.getMessage(th);
        assertEquals(expected, actual);
    }

    @Test
    void testGetMessage_WithInvocationTargetException_ReturnsFormattedMessage() {
        Throwable th = new InvocationTargetException(new Exception("Test Exception"));
        String expected = "InvocationTargetException: Test Exception";
        String actual = ExceptionUtils.getMessage(th);
        assertEquals(expected, actual);
    }

    @Test
    void testGetMessage_WithWrappedException_ReturnsFormattedMessage() {
        Throwable wrapped = new Exception("Wrapped Exception");
        Throwable th = new Exception("Test Exception", wrapped);
        String expected = "Exception: Test Exception [wrapped] Wrapped Exception";
        String actual = ExceptionUtils.getMessage(th);
        assertEquals(expected, actual);
    }
}