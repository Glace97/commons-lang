import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class escapeXml10Test {

    @Test
    void testEscapeXml10_NullInput_ReturnsNull() {
        String input = null;
        String expected = null;

        String result = StringEscapeUtils.escapeXml10(input);

        assertEquals(expected, result);
    }

    @Test
    void testEscapeXml10_EmptyString_ReturnsEmptyString() {
        String input = "";
        String expected = "";

        String result = StringEscapeUtils.escapeXml10(input);

        assertEquals(expected, result);
    }

    @Test
    void testEscapeXml10_NoSpecialCharacters_ReturnsInputString() {
        String input = "Hello World!";
        String expected = "Hello World!";

        String result = StringEscapeUtils.escapeXml10(input);

        assertEquals(expected, result);
    }

    @Test
    void testEscapeXml10_SpecialCharacters_ReturnsEscapedString() {
        String input = "<Hello> & 'World'";
        String expected = "&lt;Hello&gt; &amp; &apos;World&apos;";

        String result = StringEscapeUtils.escapeXml10(input);

        assertEquals(expected, result);
    }

    @Test
    void testEscapeXml10_UnicodeCharacters_ReturnsEscapedString() {
        String input = "Hello \u00A9 World!";
        String expected = "Hello &#169; World!";

        String result = StringEscapeUtils.escapeXml10(input);

        assertEquals(expected, result);
    }

    @Test
    void testEscapeXml10_ControlCharacters_ReturnsEscapedString() {
        String input = "Hello \n World!";
        String expected = "Hello &#10; World!";

        String result = StringEscapeUtils.escapeXml10(input);

        assertEquals(expected, result);
    }
}