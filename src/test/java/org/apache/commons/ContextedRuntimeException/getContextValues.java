import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import java.util.Arrays;
import java.util.List;

class getContextValuesTest {

    private ContextedRuntimeException exception;

    @BeforeEach
    void setUp() {
        exception = new ContextedRuntimeException();
    }

    @Test
    @DisplayName("Test getContextValues method with valid label")
    void testGetContextValuesWithValidLabel() {
        String label = "label";
        List<Object> expectedValues = Arrays.asList("value1", "value2", "value3");
        exception.exceptionContext.putContextValue(label, expectedValues);
        
        List<Object> actualValues = exception.getContextValues(label);
        
        assertEquals(expectedValues, actualValues);
    }

    @Test
    @DisplayName("Test getContextValues method with invalid label")
    void testGetContextValuesWithInvalidLabel() {
        String label = "invalidLabel";
        
        List<Object> actualValues = exception.getContextValues(label);
        
        assertTrue(actualValues.isEmpty());
    }

    @Test
    @DisplayName("Test getContextValues method with null label")
    void testGetContextValuesWithNullLabel() {
        String label = null;
        
        List<Object> actualValues = exception.getContextValues(label);
        
        assertTrue(actualValues.isEmpty());
    }

    @Test
    @DisplayName("Test getContextValues method with empty label")
    void testGetContextValuesWithEmptyLabel() {
        String label = "";
        
        List<Object> actualValues = exception.getContextValues(label);
        
        assertTrue(actualValues.isEmpty());
    }
}