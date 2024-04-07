import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class doubleValueTest {
    
    @Test
    void testDoubleValue() {
        // Test case 1: Default value of zero
        MutableDouble mutableDouble1 = new MutableDouble();
        assertEquals(0.0, mutableDouble1.doubleValue());
        
        // Test case 2: Positive value
        MutableDouble mutableDouble2 = new MutableDouble(5.5);
        assertEquals(5.5, mutableDouble2.doubleValue());
        
        // Test case 3: Negative value
        MutableDouble mutableDouble3 = new MutableDouble(-2.3);
        assertEquals(-2.3, mutableDouble3.doubleValue());
        
        // Test case 4: Value from Number object
        MutableDouble mutableDouble4 = new MutableDouble(10);
        assertEquals(10.0, mutableDouble4.doubleValue());
        
        // Test case 5: Value from String
        MutableDouble mutableDouble5 = new MutableDouble("3.14");
        assertEquals(3.14, mutableDouble5.doubleValue());
        
        // Test case 6: Value from invalid String
        assertThrows(NumberFormatException.class, () -> new MutableDouble("abc"));
    }
}