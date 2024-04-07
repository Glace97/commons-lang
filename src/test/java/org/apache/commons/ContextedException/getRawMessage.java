import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getRawMessageTest {

    @Test
    void testGetRawMessage_WithoutMessageAndCause_ReturnsNull() {
        ContextedException exception = new ContextedException();
        assertNull(exception.getRawMessage());
    }

    @Test
    void testGetRawMessage_WithMessageButWithoutCause_ReturnsMessage() {
        String message = "Test message";
        ContextedException exception = new ContextedException(message);
        assertEquals(message, exception.getRawMessage());
    }

    @Test
    void testGetRawMessage_WithMessageAndCause_ReturnsMessage() {
        String message = "Test message";
        Throwable cause = new Throwable("Test cause");
        ContextedException exception = new ContextedException(message, cause);
        assertEquals(message, exception.getRawMessage());
    }

    @Test
    void testGetRawMessage_WithMessageCauseAndContext_ReturnsMessage() {
        String message = "Test message";
        Throwable cause = new Throwable("Test cause");
        ExceptionContext context = new DefaultExceptionContext();
        ContextedException exception = new ContextedException(message, cause, context);
        assertEquals(message, exception.getRawMessage());
    }

    @Test
    void testGetRawMessage_WithCauseButWithoutMessage_ReturnsCauseMessage() {
        Throwable cause = new Throwable("Test cause");
        ContextedException exception = new ContextedException(cause);
        assertEquals(cause.getMessage(), exception.getRawMessage());
    }
}