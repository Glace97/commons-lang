import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class unescapeJsonTest {
    
    @Test
    void testUnescapeJson_NullInput_ReturnsNull() {
        String input = null;
        String expectedOutput = null;
        
        String actualOutput = StringEscapeUtils.unescapeJson(input);
        
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    void testUnescapeJson_EmptyInput_ReturnsEmptyString() {
        String input = "";
        String expectedOutput = "";
        
        String actualOutput = StringEscapeUtils.unescapeJson(input);
        
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    void testUnescapeJson_NoEscapedCharacters_ReturnsInputString() {
        String input = "Hello World!";
        String expectedOutput = "Hello World!";
        
        String actualOutput = StringEscapeUtils.unescapeJson(input);
        
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    void testUnescapeJson_EscapedQuotes_ReturnsUnescapedQuotes() {
        String input = "He didn't say, \"Stop!\"";
        String expectedOutput = "He didn't say, \"Stop!\"";
        
        String actualOutput = StringEscapeUtils.unescapeJson(input);
        
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    void testUnescapeJson_EscapedBackslashes_ReturnsUnescapedBackslashes() {
        String input = "C:\\Program Files\\Java";
        String expectedOutput = "C:\\Program Files\\Java";
        
        String actualOutput = StringEscapeUtils.unescapeJson(input);
        
        assertEquals(expectedOutput, actualOutput);
    }
    
    @Test
    void testUnescapeJson_EscapedUnicodeCharacters_ReturnsUnescapedUnicodeCharacters() {
        String input = "\\u0048\\u0065\\u006C\\u006C\\u006F";
        String expectedOutput = "Hello";
        
        String actualOutput = StringEscapeUtils.unescapeJson(input);
        
        assertEquals(expectedOutput, actualOutput);
    }
    
    // Add more test cases to cover all edge cases and achieve high coverage
    
}