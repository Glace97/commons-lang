import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setValueTest {

    @Test
    void testSetValue() {
        MutableInt mutableInt = new MutableInt();
        
        // Test setting positive value
        mutableInt.setValue(10);
        assertEquals(10, mutableInt.getValue());
        
        // Test setting negative value
        mutableInt.setValue(-5);
        assertEquals(-5, mutableInt.getValue());
        
        // Test setting zero value
        mutableInt.setValue(0);
        assertEquals(0, mutableInt.getValue());
    }

    @Test
    void testSetValueFromNumber() {
        MutableInt mutableInt = new MutableInt();
        
        // Test setting positive value from Integer
        mutableInt.setValue(Integer.valueOf(10));
        assertEquals(10, mutableInt.getValue());
        
        // Test setting negative value from Float
        mutableInt.setValue(Float.valueOf(-5.5));
        assertEquals(-5, mutableInt.getValue());
        
        // Test setting zero value from Double
        mutableInt.setValue(Double.valueOf(0));
        assertEquals(0, mutableInt.getValue());
    }
    
    @Test
    void testSetValueFromString() {
        MutableInt mutableInt = new MutableInt();
        
        // Test setting positive value from String
        mutableInt.setValue("10");
        assertEquals(10, mutableInt.getValue());
        
        // Test setting negative value from String
        mutableInt.setValue("-5");
        assertEquals(-5, mutableInt.getValue());
        
        // Test setting zero value from String
        mutableInt.setValue("0");
        assertEquals(0, mutableInt.getValue());
        
        // Test setting non-numeric value from String
        assertThrows(NumberFormatException.class, () -> mutableInt.setValue("abc"));
    }
}