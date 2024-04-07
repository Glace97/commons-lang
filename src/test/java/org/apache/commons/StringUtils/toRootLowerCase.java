import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import java.util.Locale;

class toRootLowerCaseTest {
    
    @Test
    void testToRootLowerCase_withNullInput() {
        String input = null;
        String expected = null;
        String result = StringUtils.toRootLowerCase(input);
        assertEquals(expected, result);
    }
    
    @Test
    void testToRootLowerCase_withEmptyString() {
        String input = "";
        String expected = "";
        String result = StringUtils.toRootLowerCase(input);
        assertEquals(expected, result);
    }
    
    @Test
    void testToRootLowerCase_withLowerCaseString() {
        String input = "hello";
        String expected = "hello";
        String result = StringUtils.toRootLowerCase(input);
        assertEquals(expected, result);
    }
    
    @Test
    void testToRootLowerCase_withUpperCaseString() {
        String input = "HELLO";
        String expected = "hello";
        String result = StringUtils.toRootLowerCase(input);
        assertEquals(expected, result);
    }
    
    @Test
    void testToRootLowerCase_withMixedCaseString() {
        String input = "HeLLo";
        String expected = "hello";
        String result = StringUtils.toRootLowerCase(input);
        assertEquals(expected, result);
    }
    
    @Test
    void testToRootLowerCase_withWhitespaceString() {
        String input = "   hello   ";
        String expected = "   hello   ";
        String result = StringUtils.toRootLowerCase(input);
        assertEquals(expected, result);
    }
    
    @Test
    void testToRootLowerCase_withSpecialCharactersString() {
        String input = "!@#$%^&*()";
        String expected = "!@#$%^&*()";
        String result = StringUtils.toRootLowerCase(input);
        assertEquals(expected, result);
    }
    
    @Test
    void testToRootLowerCase_withAccentedCharactersString() {
        String input = "ÈÊÉË";
        String expected = "ÈÊÉË";
        String result = StringUtils.toRootLowerCase(input);
        assertEquals(expected, result);
    }
}