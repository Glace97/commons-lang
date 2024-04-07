
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class setContextValueTest {

    @Mock
    private ExceptionContext exceptionContext;

    private ContextedRuntimeException contextedRuntimeException;

    @BeforeEach
    void setUp() {
        contextedRuntimeException = new ContextedRuntimeException();
        contextedRuntimeException.exceptionContext = exceptionContext;
    }

    @Test
    void setContextValue_shouldSetLabelAndValue() {
        String label = "label";
        Object value = "value";

        contextedRuntimeException.setContextValue(label, value);

        verify(exceptionContext).setContextValue(label, value);
    }

    @Test
    void setContextValue_shouldReturnItself() {
        String label = "label";
        Object value = "value";

        ContextedRuntimeException result = contextedRuntimeException.setContextValue(label, value);

        assertEquals(contextedRuntimeException, result);
    }
}
