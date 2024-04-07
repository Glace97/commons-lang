import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class notNaNTest {
    
    @Test
    void testNotNaN() {
        // Test with a valid double value
        assertDoesNotThrow(() -> Validate.notNaN(10.5));
        
        // Test with NaN value
        assertThrows(IllegalArgumentException.class, () -> Validate.notNaN(Double.NaN));
    }
    
    @Test
    void testNotNaNWithMessage() {
        // Test with a valid double value
        assertDoesNotThrow(() -> Validate.notNaN(10.5, "Value must be a number"));
        
        // Test with NaN value
        assertThrows(IllegalArgumentException.class, () -> Validate.notNaN(Double.NaN, "Value must be a number"));
    }
}