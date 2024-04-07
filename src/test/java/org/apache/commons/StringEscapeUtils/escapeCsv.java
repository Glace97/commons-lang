import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class escapeCsvTest {

    @Test
    void testEscapeCsv() {
        StringEscapeUtils stringEscapeUtils = new StringEscapeUtils();
        
        // Test input with no special characters
        String input1 = "Hello World";
        assertEquals(input1, stringEscapeUtils.escapeCsv(input1));

        // Test input with comma
        String input2 = "Hello, World";
        String expected2 = "\"Hello, World\"";
        assertEquals(expected2, stringEscapeUtils.escapeCsv(input2));

        // Test input with newline
        String input3 = "Hello\nWorld";
        String expected3 = "\"Hello\nWorld\"";
        assertEquals(expected3, stringEscapeUtils.escapeCsv(input3));

        // Test input with double quote
        String input4 = "Hello\"World";
        String expected4 = "\"Hello\"\"World\"";
        assertEquals(expected4, stringEscapeUtils.escapeCsv(input4));

        // Test input with all special characters
        String input5 = "Hello, \"World\"\nThis is a test";
        String expected5 = "\"Hello, \"\"World\"\"\nThis is a test\"";
        assertEquals(expected5, stringEscapeUtils.escapeCsv(input5));
    }
}