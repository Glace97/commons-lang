import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class reverseTest {
    
    private StringUtils stringUtils;

    @BeforeEach
    public void setUp() {
        stringUtils = new StringUtils();
    }
    
    @Test
    @DisplayName("Test reverse with null input")
    public void testReverseWithNullInput() {
        String input = null;
        String result = stringUtils.reverse(input);
        assertNull(result);
    }
    
    @Test
    @DisplayName("Test reverse with empty input")
    public void testReverseWithEmptyInput() {
        String input = "";
        String result = stringUtils.reverse(input);
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Test reverse with non-empty input")
    public void testReverseWithNonEmptyInput() {
        String input = "bat";
        String result = stringUtils.reverse(input);
        assertEquals("tab", result);
    }
    
    @Test
    @DisplayName("Test reverse with input containing space")
    public void testReverseWithSpaceInput() {
        String input = "hello world";
        String result = stringUtils.reverse(input);
        assertEquals("dlrow olleh", result);
    }
    
    @Test
    @DisplayName("Test reverse with input containing special characters")
    public void testReverseWithSpecialCharacterInput() {
        String input = "!@#$%^&*()";
        String result = stringUtils.reverse(input);
        assertEquals(")(*&^%$#@!", result);
    }
    
    @Test
    @DisplayName("Test reverse with input containing numbers")
    public void testReverseWithNumberInput() {
        String input = "12345";
        String result = stringUtils.reverse(input);
        assertEquals("54321", result);
    }
    
    @Test
    @DisplayName("Test reverse with input containing unicode characters")
    public void testReverseWithUnicodeInput() {
        String input = "こんにちは";
        String result = stringUtils.reverse(input);
        assertEquals("はちにんこ", result);
    }
    
    @Test
    @DisplayName("Test reverse with input containing new line")
    public void testReverseWithNewLineInput() {
        String input = "Hello\nWorld";
        String result = stringUtils.reverse(input);
        assertEquals("dlroW\nolleH", result);
    }
    
    @Test
    @DisplayName("Test reverse with input containing carriage return")
    public void testReverseWithCarriageReturnInput() {
        String input = "Hello\rWorld";
        String result = stringUtils.reverse(input);
        assertEquals("dlroW\rolleH", result);
    }
}