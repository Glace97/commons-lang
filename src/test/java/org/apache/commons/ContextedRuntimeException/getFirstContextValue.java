import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.NoSuchElementException;

class getFirstContextValueTest {

    private ContextedRuntimeException exception;
    private ExceptionContext exceptionContext;

    @BeforeEach
    void setUp() {
        exceptionContext = Mockito.mock(ExceptionContext.class);
        exception = new ContextedRuntimeException("Test Exception", null, exceptionContext);
    }

    @Test
    void testGetFirstContextValue_ReturnsValue_WhenLabelExists() {
        String label = "label";
        Object expectedValue = "value";
        Mockito.when(exceptionContext.getFirstContextValue(label)).thenReturn(expectedValue);

        Object actualValue = exception.getFirstContextValue(label);

        assertEquals(expectedValue, actualValue);
    }

    @Test
    void testGetFirstContextValue_ThrowsNoSuchElementException_WhenLabelDoesNotExist() {
        String label = "nonexistentLabel";
        Mockito.when(exceptionContext.getFirstContextValue(label)).thenThrow(NoSuchElementException.class);

        assertThrows(NoSuchElementException.class, () -> exception.getFirstContextValue(label));
    }

    @Test
    void testGetFirstContextValue_ReturnsNull_WhenLabelIsNull() {
        String label = null;
        Object expectedValue = null;
        Mockito.when(exceptionContext.getFirstContextValue(label)).thenReturn(expectedValue);

        Object actualValue = exception.getFirstContextValue(label);

        assertNull(actualValue);
    }

    @Test
    void testGetFirstContextValue_ReturnsNull_WhenExceptionContextIsNull() {
        exception = new ContextedRuntimeException("Test Exception", null, null);

        Object actualValue = exception.getFirstContextValue("label");

        assertNull(actualValue);
    }
}