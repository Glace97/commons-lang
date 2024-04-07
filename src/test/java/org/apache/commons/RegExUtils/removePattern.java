import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.util.regex.Pattern;

@TestInstance(Lifecycle.PER_CLASS)
class removePatternTest {

    @Test
    void testRemovePattern() {
        // Test case 1: text is null
        assertNull(RegExUtils.removePattern(null, ".*"));

        // Test case 2: regex is null
        assertEquals("any", RegExUtils.removePattern("any", null));

        // Test case 3: text does not contain the pattern
        assertEquals("ABC123", RegExUtils.removePattern("ABCabc123", "[a-z]"));

        // Test case 4: text contains the pattern
        assertEquals("AB", RegExUtils.removePattern("A<__>\n<__>B", "<.*>"));

        // Test case 5: regex matches the entire text
        assertEquals("", RegExUtils.removePattern("ABC", ".*"));

        // Test case 6: regex matches an empty string
        assertEquals("ABC", RegExUtils.removePattern("ABC", ""));

        // Test case 7: regex contains special characters
        assertEquals("ABC", RegExUtils.removePattern("ABC@@@123", "[@]+[0-9]+"));

        // Test case 8: regex contains escape characters
        assertEquals("ABC@@@123", RegExUtils.removePattern("ABC@@@123", "\\d+"));

        // Test case 9: text is an empty string
        assertEquals("", RegExUtils.removePattern("", ".*"));

        // Test case 10: regex is an empty string
        assertEquals("", RegExUtils.removePattern("ABC", ""));

        // Test case 11: regex matches multiple occurrences
        assertEquals("ABC", RegExUtils.removePattern("A<__>\n<__>B<__>\n<__>C", "<.*>"));
    }
}