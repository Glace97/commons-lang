import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SetValueTest {

    @Test
    void testSetValue() {
        MutableLong mutableLong = new MutableLong();
        
        // Test case 1: Set value to zero
        mutableLong.setValue(0);
        assertEquals(0, mutableLong.getValue());
        
        // Test case 2: Set value to positive number
        mutableLong.setValue(100);
        assertEquals(100, mutableLong.getValue());
        
        // Test case 3: Set value to negative number
        mutableLong.setValue(-100);
        assertEquals(-100, mutableLong.getValue());
        
        // Test case 4: Set value to maximum long value
        mutableLong.setValue(Long.MAX_VALUE);
        assertEquals(Long.MAX_VALUE, mutableLong.getValue());
        
        // Test case 5: Set value to minimum long value
        mutableLong.setValue(Long.MIN_VALUE);
        assertEquals(Long.MIN_VALUE, mutableLong.getValue());
    }
    
    @Test
    void testSetValueWithNumber() {
        MutableLong mutableLong = new MutableLong();
        
        // Test case 1: Set value using Integer
        mutableLong.setValue(Integer.valueOf(100));
        assertEquals(100, mutableLong.getValue());
        
        // Test case 2: Set value using Double
        mutableLong.setValue(Double.valueOf(100.5));
        assertEquals(100, mutableLong.getValue());
        
        // Test case 3: Set value using Float
        mutableLong.setValue(Float.valueOf(100.5f));
        assertEquals(100, mutableLong.getValue());
        
        // Test case 4: Set value using Byte
        mutableLong.setValue(Byte.valueOf((byte) 100));
        assertEquals(100, mutableLong.getValue());
        
        // Test case 5: Set value using Short
        mutableLong.setValue(Short.valueOf((short) 100));
        assertEquals(100, mutableLong.getValue());
        
        // Test case 6: Set value using Long
        mutableLong.setValue(Long.valueOf(100));
        assertEquals(100, mutableLong.getValue());
    }
    
    @Test
    void testSetValueWithString() {
        MutableLong mutableLong = new MutableLong();
        
        // Test case 1: Set value using valid string representation of long
        mutableLong.setValue("100");
        assertEquals(100, mutableLong.getValue());
        
        // Test case 2: Set value using valid negative string representation of long
        mutableLong.setValue("-100");
        assertEquals(-100, mutableLong.getValue());
        
        // Test case 3: Set value using invalid string representation of long
        assertThrows(NumberFormatException.class, () -> mutableLong.setValue("abc"));
        
        // Test case 4: Set value using null string
        assertThrows(NullPointerException.class, () -> mutableLong.setValue(null));
    }
}