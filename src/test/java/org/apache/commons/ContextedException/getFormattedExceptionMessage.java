
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getFormattedExceptionMessageTest {

    private ContextedException exception;

    @BeforeEach
    void setUp() {
        exception = new ContextedException();
    }

    @Test
    @DisplayName("Test getFormattedExceptionMessage with baseMessage")
    void testGetFormattedExceptionMessageWithBaseMessage() {
        String baseMessage = "Base Message";
        String formattedMessage = exception.getFormattedExceptionMessage(baseMessage);
        assertEquals(baseMessage, formattedMessage);
    }

    @Test
    @DisplayName("Test getFormattedExceptionMessage without baseMessage")
    void testGetFormattedExceptionMessageWithoutBaseMessage() {
        String formattedMessage = exception.getFormattedExceptionMessage(null);
        assertEquals("", formattedMessage);
    }

    @Test
    @DisplayName("Test getFormattedExceptionMessage with cause")
    void testGetFormattedExceptionMessageWithCause() {
        Throwable cause = new Throwable("Cause");
        exception = new ContextedException(cause);
        String formattedMessage = exception.getFormattedExceptionMessage(null);
        assertEquals("", formattedMessage);
    }

    @Test
    @DisplayName("Test getFormattedExceptionMessage with message and cause")
    void testGetFormattedExceptionMessageWithMessageAndCause() {
        String message = "Exception Message";
        Throwable cause = new Throwable("Cause");
        exception = new ContextedException(message, cause);
        String formattedMessage = exception.getFormattedExceptionMessage(null);
        assertEquals(message, formattedMessage);
    }

    @Test
    @DisplayName("Test getFormattedExceptionMessage with message, cause, and context")
    void testGetFormattedExceptionMessageWithMessageCauseAndContext() {
        String message = "Exception Message";
        Throwable cause = new Throwable("Cause");
        ExceptionContext context = new DefaultExceptionContext();
        exception = new ContextedException(message, cause, context);
        String formattedMessage = exception.getFormattedExceptionMessage(null);
        assertEquals(message, formattedMessage);
    }

}
