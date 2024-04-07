import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setValueTest {
    
    @Test
    void testSetValue() {
        MutableObject<Object> obj = new MutableObject<>();
        
        // Test setting null value
        obj.setValue(null);
        assertNull(obj.getValue());
        
        // Test setting non-null value
        String value = "test";
        obj.setValue(value);
        assertEquals(value, obj.getValue());
        
        // Test setting multiple values
        Integer intValue = 10;
        obj.setValue(intValue);
        assertEquals(intValue, obj.getValue());
        
        Double doubleValue = 3.14;
        obj.setValue(doubleValue);
        assertEquals(doubleValue, obj.getValue());
        
        // Test setting custom object
        CustomObject customObj = new CustomObject();
        obj.setValue(customObj);
        assertEquals(customObj, obj.getValue());
    }
    
    private static class CustomObject {
        // Custom object implementation
    }
}