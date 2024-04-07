import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class addContextValueTest {

    private DefaultExceptionContext exceptionContext;

    @BeforeEach
    void setUp() {
        exceptionContext = new DefaultExceptionContext();
    }

    @Test
    void testAddContextValue() {
        String label = "testLabel";
        String value = "testValue";

        exceptionContext.addContextValue(label, value);

        List<Pair<String, Object>> contextValues = exceptionContext.contextValues;
        assertEquals(1, contextValues.size());

        Pair<String, Object> contextValue = contextValues.get(0);
        assertEquals(label, contextValue.getKey());
        assertEquals(value, contextValue.getValue());
    }

    @Test
    void testAddContextValueMultipleTimes() {
        String label1 = "testLabel1";
        String value1 = "testValue1";
        String label2 = "testLabel2";
        String value2 = "testValue2";

        exceptionContext.addContextValue(label1, value1);
        exceptionContext.addContextValue(label2, value2);

        List<Pair<String, Object>> contextValues = exceptionContext.contextValues;
        assertEquals(2, contextValues.size());

        Pair<String, Object> contextValue1 = contextValues.get(0);
        assertEquals(label1, contextValue1.getKey());
        assertEquals(value1, contextValue1.getValue());

        Pair<String, Object> contextValue2 = contextValues.get(1);
        assertEquals(label2, contextValue2.getKey());
        assertEquals(value2, contextValue2.getValue());
    }

    @Test
    void testAddContextValueWithNullLabel() {
        String value = "testValue";

        exceptionContext.addContextValue(null, value);

        List<Pair<String, Object>> contextValues = exceptionContext.contextValues;
        assertEquals(1, contextValues.size());

        Pair<String, Object> contextValue = contextValues.get(0);
        assertTrue(StringUtils.isBlank(contextValue.getKey()));
        assertEquals(value, contextValue.getValue());
    }

    @Test
    void testAddContextValueWithNullValue() {
        String label = "testLabel";

        exceptionContext.addContextValue(label, null);

        List<Pair<String, Object>> contextValues = exceptionContext.contextValues;
        assertEquals(1, contextValues.size());

        Pair<String, Object> contextValue = contextValues.get(0);
        assertEquals(label, contextValue.getKey());
        assertEquals(null, contextValue.getValue());
    }
    
    @Test
    void testAddContextValueWithEmptyLabel() {
        String label = "";
        String value = "testValue";

        exceptionContext.addContextValue(label, value);

        List<Pair<String, Object>> contextValues = exceptionContext.contextValues;
        assertEquals(1, contextValues.size());

        Pair<String, Object> contextValue = contextValues.get(0);
        assertTrue(StringUtils.isEmpty(contextValue.getKey()));
        assertEquals(value, contextValue.getValue());
    }

    // Add more tests for edge cases and high coverage

}