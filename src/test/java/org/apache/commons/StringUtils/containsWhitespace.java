import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Arrays;

class containsWhitespaceTest {
    
    @Test
    void testContainsWhitespace() {
        // Empty string
        assertFalse(StringUtils.containsWhitespace(""));
        
        // String with no whitespace
        assertFalse(StringUtils.containsWhitespace("HelloWorld"));
        
        // String with whitespace
        assertTrue(StringUtils.containsWhitespace("Hello World"));
        
        // String with only whitespace
        assertTrue(StringUtils.containsWhitespace("  "));
        
        // String with leading and trailing whitespace
        assertTrue(StringUtils.containsWhitespace("  Hello World  "));
    }
}