import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class getMessageTest {

    private ContextedException exception;

    @BeforeEach
    void setUp() {
        exception = new ContextedException();
    }

    @Test
    void testGetMessageWithoutMessage() {
        assertNull(exception.getMessage());
    }

    @Test
    void testGetMessageWithMessage() {
        exception = new ContextedException("Test Message");
        assertEquals("Test Message", exception.getMessage());
    }

    @Test
    void testGetMessageWithCause() {
        Throwable cause = new NullPointerException();
        exception = new ContextedException(cause);
        assertEquals(cause.toString(), exception.getMessage());
    }

    @Test
    void testGetMessageWithCauseAndMessage() {
        Throwable cause = new NullPointerException();
        exception = new ContextedException("Test Message", cause);
        assertEquals("Test Message\n" + cause.toString(), exception.getMessage());
    }

    @Test
    void testGetMessageWithNullContext() {
        exception = new ContextedException("Test Message", null, null);
        assertEquals("Test Message", exception.getMessage());
    }

    @Test
    void testGetMessageWithCustomContext() {
        ExceptionContext context = new DefaultExceptionContext();
        context.addContextValue("Key1", "Value1");
        context.addContextValue("Key2", "Value2");
        exception = new ContextedException("Test Message", null, context);
        assertEquals("Test Message\nContext:\nKey1=Value1\nKey2=Value2", exception.getMessage());
    }

    @Test
    void testGetMessageWithFormattedExceptionMessage() {
        exception = new ContextedException("Test Message");
        assertEquals("Formatted: Test Message", exception.getMessage());
    }
}