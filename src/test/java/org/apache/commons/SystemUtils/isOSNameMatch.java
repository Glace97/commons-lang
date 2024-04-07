import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isOSNameMatchTest {
    
    @Test
    void testIsOSNameMatch() {
        // Test with valid OS name prefix
        assertTrue(SystemUtils.isOSNameMatch("Windows XP", "Windows"));
        
        // Test with invalid OS name prefix
        assertFalse(SystemUtils.isOSNameMatch("Linux", "Windows"));
        
        // Test with null OS name
        assertFalse(SystemUtils.isOSNameMatch(null, "Windows"));
    }
}