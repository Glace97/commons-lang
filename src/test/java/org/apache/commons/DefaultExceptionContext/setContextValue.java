import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

class setContextValueTest {

    private DefaultExceptionContext exceptionContext;
    
    @BeforeEach
    void setUp() {
        exceptionContext = new DefaultExceptionContext();
    }
    
    @Test
    void testSetContextValue_AddNewValue() {
        String label = "label";
        Object value = "value";
        
        exceptionContext.setContextValue(label, value);
        
        assertEquals(1, exceptionContext.contextValues.size());
        assertEquals(label, exceptionContext.contextValues.get(0).getKey());
        assertEquals(value, exceptionContext.contextValues.get(0).getValue());
    }
    
    @Test
    void testSetContextValue_ReplaceExistingValue() {
        String label = "label";
        Object value1 = "value1";
        Object value2 = "value2";
        
        exceptionContext.setContextValue(label, value1);
        exceptionContext.setContextValue(label, value2);
        
        assertEquals(1, exceptionContext.contextValues.size());
        assertEquals(label, exceptionContext.contextValues.get(0).getKey());
        assertEquals(value2, exceptionContext.contextValues.get(0).getValue());
    }
    
    @Test
    void testSetContextValue_RemoveExistingValue() {
        String label = "label";
        Object value = "value";
        
        exceptionContext.setContextValue(label, value);
        exceptionContext.setContextValue(label, null);
        
        assertEquals(0, exceptionContext.contextValues.size());
    }
    
    @Test
    void testSetContextValue_NullLabel() {
        String label = null;
        Object value = "value";
        
        exceptionContext.setContextValue(label, value);
        
        assertEquals(1, exceptionContext.contextValues.size());
        assertNull(exceptionContext.contextValues.get(0).getKey());
        assertEquals(value, exceptionContext.contextValues.get(0).getValue());
    }
    
    @Test
    void testSetContextValue_NullValue() {
        String label = "label";
        Object value = null;
        
        exceptionContext.setContextValue(label, value);
        
        assertEquals(1, exceptionContext.contextValues.size());
        assertEquals(label, exceptionContext.contextValues.get(0).getKey());
        assertNull(exceptionContext.contextValues.get(0).getValue());
    }
    
    @Test
    void testSetContextValue_EmptyLabel() {
        String label = "";
        Object value = "value";
        
        exceptionContext.setContextValue(label, value);
        
        assertEquals(1, exceptionContext.contextValues.size());
        assertEquals(label, exceptionContext.contextValues.get(0).getKey());
        assertEquals(value, exceptionContext.contextValues.get(0).getValue());
    }
    
    @Test
    void testSetContextValue_DuplicateLabel() {
        String label = "label";
        Object value1 = "value1";
        Object value2 = "value2";
        
        exceptionContext.setContextValue(label, value1);
        exceptionContext.setContextValue(label, value2);
        exceptionContext.setContextValue(label, value1);
        
        assertEquals(1, exceptionContext.contextValues.size());
        assertEquals(label, exceptionContext.contextValues.get(0).getKey());
        assertEquals(value1, exceptionContext.contextValues.get(0).getValue());
    }
    
    @Test
    void testSetContextValue_MultipleValues() {
        String label1 = "label1";
        String label2 = "label2";
        Object value1 = "value1";
        Object value2 = "value2";
        
        exceptionContext.setContextValue(label1, value1);
        exceptionContext.setContextValue(label2, value2);
        
        assertEquals(2, exceptionContext.contextValues.size());
        assertEquals(label1, exceptionContext.contextValues.get(0).getKey());
        assertEquals(value1, exceptionContext.contextValues.get(0).getValue());
        assertEquals(label2, exceptionContext.contextValues.get(1).getKey());
        assertEquals(value2, exceptionContext.contextValues.get(1).getValue());
    }
}