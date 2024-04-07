
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class removeAllTest {

    private String text;

    @BeforeEach
    void setUp() {
        text = "A&lt;__&gt;\n&lt;__&gt;B";
    }

    @Test
    void testRemoveAllWithNullText() {
        assertNull(RegExUtils.removeAll(null, Pattern.compile(".*")));
    }

    @Test
    void testRemoveAllWithNullPattern() {
        assertEquals(text, RegExUtils.removeAll(text, (Pattern) null));
    }

    @Test
    void testRemoveAllWithEmptyPattern() {
        assertEquals(text, RegExUtils.removeAll(text, ""));
    }

    @Test
    void testRemoveAllWithPatternMatch() {
        assertEquals("", RegExUtils.removeAll(text, Pattern.compile(".+")));
    }

    @Test
    void testRemoveAllWithPatternNonMatch() {
        assertEquals(text, RegExUtils.removeAll(text, Pattern.compile(".?")));
    }

    @Test
    void testRemoveAllWithPatternAndReplacement() {
        assertEquals("A\nB", RegExUtils.removeAll(text, Pattern.compile("&lt;.*&gt;")));
    }

    @Test
    void testRemoveAllWithPatternAndReplacementDotall() {
        assertEquals("AB", RegExUtils.removeAll(text, Pattern.compile("(?s)&lt;.*&gt;")));
    }

    @Test
    void testRemoveAllWithStringPattern() {
        assertEquals("ABC123", RegExUtils.removeAll("ABCabc123abc", "[a-z]"));
    }
}
