import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class escapeEcmaScriptTest {

    private StringEscapeUtils stringEscapeUtils;

    @BeforeEach
    void setUp() {
        stringEscapeUtils = new StringEscapeUtils();
    }

    @Test
    void testEscapeEcmaScript_NullInput() {
        String result = stringEscapeUtils.escapeEcmaScript(null);
        assertNull(result);
    }

    @Test
    void testEscapeEcmaScript_EmptyInput() {
        String result = stringEscapeUtils.escapeEcmaScript("");
        assertEquals("", result);
    }

    @Test
    void testEscapeEcmaScript_NoSpecialCharacters() {
        String input = "Hello World!";
        String result = stringEscapeUtils.escapeEcmaScript(input);
        assertEquals(input, result);
    }

    @Test
    void testEscapeEcmaScript_SpecialCharacters() {
        String input = "He didn't say, \"Stop!\"";
        String expected = "He didn\\'t say, \\\"Stop!\\\"";
        String result = stringEscapeUtils.escapeEcmaScript(input);
        assertEquals(expected, result);
    }

    @Test
    void testEscapeEcmaScript_SingleQuote() {
        String input = "It's a beautiful day!";
        String expected = "It\\'s a beautiful day!";
        String result = stringEscapeUtils.escapeEcmaScript(input);
        assertEquals(expected, result);
    }

    @Test
    void testEscapeEcmaScript_Backslash() {
        String input = "C:\\Program Files\\";
        String expected = "C:\\\\Program Files\\\\";
        String result = stringEscapeUtils.escapeEcmaScript(input);
        assertEquals(expected, result);
    }

    @Test
    void testEscapeEcmaScript_ForwardSlash() {
        String input = "https://www.example.com/";
        String expected = "https:\\/\\/www.example.com\\/";
        String result = stringEscapeUtils.escapeEcmaScript(input);
        assertEquals(expected, result);
    }
}