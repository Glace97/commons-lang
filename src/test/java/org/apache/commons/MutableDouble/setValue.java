import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class setValueTest {

    @Test
    public void testSetValue() {
        MutableDouble mutableDouble = new MutableDouble();
        
        // Test setting positive value
        mutableDouble.setValue(5.0);
        assertEquals(5.0, mutableDouble.getValue());
        
        // Test setting negative value
        mutableDouble.setValue(-10.0);
        assertEquals(-10.0, mutableDouble.getValue());
        
        // Test setting zero value
        mutableDouble.setValue(0.0);
        assertEquals(0.0, mutableDouble.getValue());
    }

    @Test
    public void testSetValueFromNumber() {
        MutableDouble mutableDouble = new MutableDouble();
        
        // Test setting positive value
        mutableDouble.setValue(5);
        assertEquals(5.0, mutableDouble.getValue());
        
        // Test setting negative value
        mutableDouble.setValue(-10);
        assertEquals(-10.0, mutableDouble.getValue());
        
        // Test setting zero value
        mutableDouble.setValue(0);
        assertEquals(0.0, mutableDouble.getValue());
    }
    
    @Test
    public void testSetValueFromString() {
        MutableDouble mutableDouble = new MutableDouble();
        
        // Test setting positive value
        mutableDouble.setValue("5.0");
        assertEquals(5.0, mutableDouble.getValue());
        
        // Test setting negative value
        mutableDouble.setValue("-10.0");
        assertEquals(-10.0, mutableDouble.getValue());
        
        // Test setting zero value
        mutableDouble.setValue("0.0");
        assertEquals(0.0, mutableDouble.getValue());
    }
    
    @Test
    public void testSetValueFromNullNumber() {
        MutableDouble mutableDouble = new MutableDouble();
        
        // Test setting null value
        assertThrows(NullPointerException.class, () -> mutableDouble.setValue(null));
    }
    
    @Test
    public void testSetValueFromNullString() {
        MutableDouble mutableDouble = new MutableDouble();
        
        // Test setting null value
        assertThrows(NullPointerException.class, () -> mutableDouble.setValue((String)null));
    }
    
    @Test
    public void testSetValueFromInvalidString() {
        MutableDouble mutableDouble = new MutableDouble();
        
        // Test setting invalid string value
        assertThrows(NumberFormatException.class, () -> mutableDouble.setValue("abc"));
    }
    
}