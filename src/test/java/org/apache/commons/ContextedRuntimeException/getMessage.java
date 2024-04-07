import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.tuple.Pair;

class getMessageTest {
    private ContextedRuntimeException exception;

    @BeforeEach
    void setUp() {
        exception = new ContextedRuntimeException();
    }

    @Test
    @DisplayName("Test getMessage() with no message")
    void testGetMessageWithNoMessage() {
        String expected = "";
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test getMessage() with message")
    void testGetMessageWithMessage() {
        String expected = "Test message";
        exception = new ContextedRuntimeException(expected);
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test getMessage() with cause")
    void testGetMessageWithCause() {
        String causeMessage = "Test cause";
        Throwable cause = new Throwable(causeMessage);
        exception = new ContextedRuntimeException(cause);
        String expected = causeMessage;
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test getMessage() with message and cause")
    void testGetMessageWithMessageAndCause() {
        String expected = "Test message";
        String causeMessage = "Test cause";
        Throwable cause = new Throwable(causeMessage);
        exception = new ContextedRuntimeException(expected, cause);
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test getMessage() with message, cause, and context")
    void testGetMessageWithMessageCauseAndContext() {
        String expected = "Test message";
        String causeMessage = "Test cause";
        Throwable cause = new Throwable(causeMessage);
        ExceptionContext context = new DefaultExceptionContext();
        exception = new ContextedRuntimeException(expected, cause, context);
        String actual = exception.getMessage();
        assertEquals(expected, actual);
    }
}