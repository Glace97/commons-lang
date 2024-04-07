import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isOSVersionMatchTest {
    
    @Test
    void testIsOSVersionMatch() {
        // Test for matching versions
        assertTrue(SystemUtils.isOSVersionMatch("10.0.0", "10"));
        assertTrue(SystemUtils.isOSVersionMatch("10.1.2", "10.1"));
        assertTrue(SystemUtils.isOSVersionMatch("10.2.3", "10.2"));
        
        // Test for non-matching versions
        assertFalse(SystemUtils.isOSVersionMatch("9.0.0", "10"));
        assertFalse(SystemUtils.isOSVersionMatch("10.1.2", "9.1"));
        assertFalse(SystemUtils.isOSVersionMatch("10.2.3", "10.3"));
        
        // Test for invalid versions
        assertFalse(SystemUtils.isOSVersionMatch("", "10"));
        assertFalse(SystemUtils.isOSVersionMatch("10.1.2", ""));
        assertFalse(SystemUtils.isOSVersionMatch("", ""));
    }
}