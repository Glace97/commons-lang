import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.tuple.Pair;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class addContextValueTest {

    private ContextedException exception;

    @BeforeEach
    void setUp() {
        exception = new ContextedException();
    }

    @Test
    void testAddContextValue_WithValidLabelAndValue_ShouldAddValueToExceptionContext() {
        String label = "testLabel";
        String value = "testValue";

        ContextedException result = exception.addContextValue(label, value);

        assertNotNull(result);
        assertNotNull(result.exceptionContext);
        assertEquals(1, result.exceptionContext.getContextValues().size());
        assertEquals(value, result.exceptionContext.getContextValues().get(label));
    }

    @Test
    void testAddContextValue_WithNullLabelAndValue_ShouldNotAddValueToExceptionContext() {
        String label = null;
        Object value = null;

        ContextedException result = exception.addContextValue(label, value);

        assertNotNull(result);
        assertNotNull(result.exceptionContext);
        assertEquals(0, result.exceptionContext.getContextValues().size());
    }

    @Test
    void testAddContextValue_WithExistingLabelAndValue_ShouldAddNewValueToExceptionContext() {
        String label = "testLabel";
        String value1 = "testValue1";
        String value2 = "testValue2";

        exception.addContextValue(label, value1);
        ContextedException result = exception.addContextValue(label, value2);

        assertNotNull(result);
        assertNotNull(result.exceptionContext);
        assertEquals(1, result.exceptionContext.getContextValues().size());
        assertEquals(value2, result.exceptionContext.getContextValues().get(label));
    }

    @Test
    void testAddContextValue_WithDifferentLabelsAndValues_ShouldAddValuesToExceptionContext() {
        String label1 = "testLabel1";
        String label2 = "testLabel2";
        String value1 = "testValue1";
        String value2 = "testValue2";

        exception.addContextValue(label1, value1);
        ContextedException result = exception.addContextValue(label2, value2);

        assertNotNull(result);
        assertNotNull(result.exceptionContext);
        assertEquals(2, result.exceptionContext.getContextValues().size());
        assertEquals(value1, result.exceptionContext.getContextValues().get(label1));
        assertEquals(value2, result.exceptionContext.getContextValues().get(label2));
    }
}