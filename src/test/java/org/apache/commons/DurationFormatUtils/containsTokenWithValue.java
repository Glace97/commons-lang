import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class containsTokenWithValueTest {
    
    @Test
    void testContainsTokenWithValue() {
        // Test case with one token that contains the given value
        Token[] tokens = {new Token("Y", false, -1)};
        assertTrue(DurationFormatUtils.containsTokenWithValue(tokens, "Y"));
        
        // Test case with multiple tokens that contain the given value
        tokens = new Token[]{new Token("Y", false, -1), new Token("M", false, -1)};
        assertTrue(DurationFormatUtils.containsTokenWithValue(tokens, "M"));
        
        // Test case with no tokens that contain the given value
        tokens = new Token[]{new Token("Y", false, -1), new Token("M", false, -1)};
        assertFalse(DurationFormatUtils.containsTokenWithValue(tokens, "D"));
        
        // Test case with optional token that contains the given value
        tokens = new Token[]{new Token("Y", true, 0)};
        assertTrue(DurationFormatUtils.containsTokenWithValue(tokens, "Y"));
        
        // Test case with optional token that does not contain the given value
        tokens = new Token[]{new Token("Y", true, 0)};
        assertFalse(DurationFormatUtils.containsTokenWithValue(tokens, "M"));
        
        // Test case with empty array of tokens
        tokens = new Token[]{};
        assertFalse(DurationFormatUtils.containsTokenWithValue(tokens, "Y"));
        
        // Test case with null array of tokens
        assertFalse(DurationFormatUtils.containsTokenWithValue(null, "Y"));
    }
}