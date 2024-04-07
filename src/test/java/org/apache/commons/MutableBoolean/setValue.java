import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setValueTest {

    @Test
    void testSetValue() {
        MutableBoolean mutableBoolean = new MutableBoolean();
        
        // Test with false value
        mutableBoolean.setValue(false);
        assertFalse(mutableBoolean.getValue());
        
        // Test with true value
        mutableBoolean.setValue(true);
        assertTrue(mutableBoolean.getValue());
    }
    
    @Test
    void testSetValueFromBoolean() {
        MutableBoolean mutableBoolean = new MutableBoolean();
        
        // Test with false value
        mutableBoolean.setValue(Boolean.FALSE);
        assertFalse(mutableBoolean.getValue());
        
        // Test with true value
        mutableBoolean.setValue(Boolean.TRUE);
        assertTrue(mutableBoolean.getValue());
    }
    
    @Test
    void testSetValueFromNull() {
        MutableBoolean mutableBoolean = new MutableBoolean();
        
        // Test with null value
        assertThrows(NullPointerException.class, () -> mutableBoolean.setValue(null));
    }
    
}