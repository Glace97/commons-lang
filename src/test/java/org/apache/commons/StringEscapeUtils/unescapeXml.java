
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UnescapeXmlTest {

    private StringEscapeUtils stringEscapeUtils = new StringEscapeUtils();

    @Test
    @DisplayName("Test unescaping XML with no special characters")
    void testUnescapeXmlNoSpecialCharacters() {
        String input = "Hello, world!";
        String expected = "Hello, world!";
        String result = stringEscapeUtils.unescapeXml(input);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test unescaping XML with ampersand")
    void testUnescapeXmlWithAmpersand() {
        String input = "AT&amp;T";
        String expected = "AT&T";
        String result = stringEscapeUtils.unescapeXml(input);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test unescaping XML with less than symbol")
    void testUnescapeXmlWithLessThanSymbol() {
        String input = "5 &lt; 10";
        String expected = "5 < 10";
        String result = stringEscapeUtils.unescapeXml(input);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test unescaping XML with greater than symbol")
    void testUnescapeXmlWithGreaterThanSymbol() {
        String input = "10 &gt; 5";
        String expected = "10 > 5";
        String result = stringEscapeUtils.unescapeXml(input);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test unescaping XML with double quote")
    void testUnescapeXmlWithDoubleQuote() {
        String input = "She said, &quot;Hello!&quot;";
        String expected = "She said, \"Hello!\"";
        String result = stringEscapeUtils.unescapeXml(input);
        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test unescaping XML with single quote")
    void testUnescapeXmlWithSingleQuote() {
        String input = "He said, &apos;I'm here!&apos;";
        String expected = "He said, 'I'm here!'";
        String result = stringEscapeUtils.unescapeXml(input);
        assertEquals(expected, result);
    }
}
