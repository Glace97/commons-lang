import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class escapeXmlTest {

    @Test
    void testEscapeXml() {
        StringEscapeUtils stringEscapeUtils = new StringEscapeUtils();

        // Test input with no special characters
        String input1 = "This is a test";
        String expected1 = "This is a test";
        String actual1 = stringEscapeUtils.escapeXml(input1);
        assertEquals(expected1, actual1);

        // Test input with special characters
        String input2 = "<div>This is a test &amp; it's great!</div>";
        String expected2 = "&lt;div&gt;This is a test &amp;amp; it&apos;s great!&lt;/div&gt;";
        String actual2 = stringEscapeUtils.escapeXml(input2);
        assertEquals(expected2, actual2);

        // Test input with special characters and Unicode characters
        String input3 = "<div>This is a test &amp; it's great! 🌟</div>";
        String expected3 = "&lt;div&gt;This is a test &amp;amp; it&apos;s great! &#128640;&lt;/div&gt;";
        String actual3 = stringEscapeUtils.escapeXml(input3);
        assertEquals(expected3, actual3);

        // Test empty input
        String input4 = "";
        String expected4 = "";
        String actual4 = stringEscapeUtils.escapeXml(input4);
        assertEquals(expected4, actual4);

        // Test null input
        String input5 = null;
        String expected5 = null;
        String actual5 = stringEscapeUtils.escapeXml(input5);
        assertEquals(expected5, actual5);
    }
}