import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class setContextValueTest {

    private ContextedException exception;

    @BeforeAll
    void setUp() {
        exception = new ContextedException();
    }

    @Test
    void testSetContextValue() {
        String label = "label";
        String value = "value";

        ContextedException result = exception.setContextValue(label, value);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(exception, result);
    }

    @Test
    void testSetContextValue_NullLabel() {
        String label = null;
        String value = "value";

        ContextedException result = exception.setContextValue(label, value);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(exception, result);
    }

    @Test
    void testSetContextValue_NullValue() {
        String label = "label";
        String value = null;

        ContextedException result = exception.setContextValue(label, value);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(exception, result);
    }

    @Test
    void testSetContextValue_EdgeCases() {
        // Test with label and value being edge cases

        String emptyLabel = "";
        Integer zeroValue = 0;

        ContextedException result1 = exception.setContextValue(emptyLabel, zeroValue);
        ContextedException result2 = exception.setContextValue(emptyLabel, null);
        ContextedException result3 = exception.setContextValue(null, zeroValue);
        ContextedException result4 = exception.setContextValue(null, null);

        Assertions.assertNotNull(result1);
        Assertions.assertNotNull(result2);
        Assertions.assertNotNull(result3);
        Assertions.assertNotNull(result4);
        Assertions.assertEquals(exception, result1);
        Assertions.assertEquals(exception, result2);
        Assertions.assertEquals(exception, result3);
        Assertions.assertEquals(exception, result4);
    }
}