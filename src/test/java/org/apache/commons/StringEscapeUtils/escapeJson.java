
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class escapeJsonTest {

    private final StringEscapeUtils stringEscapeUtils = new StringEscapeUtils();

    @Test
    void testEscapeJson_NullInput() {
        String input = null;
        String expected = null;

        String result = stringEscapeUtils.escapeJson(input);

        assertEquals(expected, result);
    }

    @Test
    void testEscapeJson_EmptyInput() {
        String input = "";
        String expected = "";

        String result = stringEscapeUtils.escapeJson(input);

        assertEquals(expected, result);
    }

    @Test
    void testEscapeJson_NoSpecialCharacters() {
        String input = "Hello, world!";
        String expected = "Hello, world!";

        String result = stringEscapeUtils.escapeJson(input);

        assertEquals(expected, result);
    }

    @Test
    void testEscapeJson_SpecialCharacters() {
        String input = "\"Hello, world!\"";
        String expected = "\\\"Hello, world!\\\"";

        String result = stringEscapeUtils.escapeJson(input);

        assertEquals(expected, result);
    }

    @Test
    void testEscapeJson_UnicodeCharacters() {
        String input = "Hello, 世界!";
        String expected = "Hello, 世界!";

        String result = stringEscapeUtils.escapeJson(input);

        assertEquals(expected, result);
    }

    @Test
    void testEscapeJson_ControlCharacters() {
        String input = "\bHello, \nworld!\r";
        String expected = "\\bHello, \\nworld!\\r";

        String result = stringEscapeUtils.escapeJson(input);

        assertEquals(expected, result);
    }

    @Test
    void testEscapeJson_UnicodeSurrogatePairs() {
        String input = "Hello, \uD83D\uDE00";
        String expected = "Hello, \uD83D\uDE00";

        String result = stringEscapeUtils.escapeJson(input);

        assertEquals(expected, result);
    }

    // Add more test cases as needed

}
