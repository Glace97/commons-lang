import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class escapeXml11Test {

    @Test
    void testEscapeXml11() {
        // Test escaping special characters
        assertEquals("bread &amp; butter", StringEscapeUtils.escapeXml11("bread & butter"));
        assertEquals("&lt;Français&gt;", StringEscapeUtils.escapeXml11("<Français>"));
        assertEquals("He didn't say, &quot;Stop!&quot;", StringEscapeUtils.escapeXml11("He didn't say, \"Stop!\""));

        // Test escaping control characters
        assertEquals("&#0;", StringEscapeUtils.escapeXml11("\u0000"));
        assertEquals("&#9;", StringEscapeUtils.escapeXml11("\t"));
        assertEquals("&#10;", StringEscapeUtils.escapeXml11("\n"));
        assertEquals("&#13;", StringEscapeUtils.escapeXml11("\r"));
        assertEquals("&#12;", StringEscapeUtils.escapeXml11("\f"));

        // Test escaping Unicode characters
        assertEquals("&#8364;", StringEscapeUtils.escapeXml11("€"));
        assertEquals("&#128514;", StringEscapeUtils.escapeXml11("😂"));
    }
}