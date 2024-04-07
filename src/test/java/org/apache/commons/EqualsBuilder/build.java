import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class buildTest {
    
    @Test
    void testBuild() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        
        // Test with no fields checked
        assertFalse(equalsBuilder.build());
        
        // Test with all fields checked and equal
        equalsBuilder.isEquals = true;
        assertTrue(equalsBuilder.build());
        
        // Test with all fields checked and not equal
        equalsBuilder.isEquals = false;
        assertFalse(equalsBuilder.build());
    }
}