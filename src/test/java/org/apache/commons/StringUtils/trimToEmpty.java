import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class trimToEmptyTest {

    @Test
    void testTrimToEmpty_NullInput_ReturnsEmptyString() {
        String input = null;
        String expected = "";
        
        String result = StringUtils.trimToEmpty(input);
        
        assertEquals(expected, result);
    }
    
    @Test
    void testTrimToEmpty_EmptyInput_ReturnsEmptyString() {
        String input = "";
        String expected = "";
        
        String result = StringUtils.trimToEmpty(input);
        
        assertEquals(expected, result);
    }
    
    @Test
    void testTrimToEmpty_WhitespaceInput_ReturnsEmptyString() {
        String input = "     ";
        String expected = "";
        
        String result = StringUtils.trimToEmpty(input);
        
        assertEquals(expected, result);
    }
    
    @Test
    void testTrimToEmpty_NonEmptyInput_ReturnsTrimmedString() {
        String input = "abc";
        String expected = "abc";
        
        String result = StringUtils.trimToEmpty(input);
        
        assertEquals(expected, result);
    }
    
    @Test
    void testTrimToEmpty_InputWithLeadingAndTrailingWhitespace_ReturnsTrimmedString() {
        String input = "    abc    ";
        String expected = "abc";
        
        String result = StringUtils.trimToEmpty(input);
        
        assertEquals(expected, result);
    }
}