
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

class addContextValueTest {

    @Mock
    private ExceptionContext exceptionContext;

    private ContextedRuntimeException exception;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        exception = new ContextedRuntimeException(null, null, exceptionContext);
    }

    @Test
    @DisplayName("Test adding context value")
    void testAddContextValue() {
        String label = "label";
        Object value = "value";

        exception.addContextValue(label, value);

        verify(exceptionContext).addContextValue(label, value);
    }

    @Test
    @DisplayName("Test returning the same exception instance")
    void testReturnSameInstance() {
        ContextedRuntimeException result = exception.addContextValue("label", "value");

        assertEquals(exception, result);
    }
}
