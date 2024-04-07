import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class replacePatternTest {

    private String sourceText;
    private String regex;
    private String replacement;

    @BeforeEach
    void setUp() {
        sourceText = "ABCabc123";
        regex = "[a-z]";
        replacement = "_";
    }

    @Test
    void testReplacePattern_NullText() {
        String result = RegExUtils.replacePattern(null, regex, replacement);
        assertNull(result);
    }

    @Test
    void testReplacePattern_NullRegex() {
        String result = RegExUtils.replacePattern(sourceText, null, replacement);
        assertEquals(sourceText, result);
    }

    @Test
    void testReplacePattern_NullReplacement() {
        String result = RegExUtils.replacePattern(sourceText, regex, null);
        assertEquals(sourceText, result);
    }

    @Test
    void testReplacePattern_EmptyTextAndEmptyRegex() {
        String result = RegExUtils.replacePattern("", "", replacement);
        assertEquals(replacement, result);
    }

    @Test
    void testReplacePattern_EmptyTextAndAnyRegex() {
        String result = RegExUtils.replacePattern("", ".*", replacement);
        assertEquals(replacement, result);
    }

    @Test
    void testReplacePattern_EmptyTextAndNonEmptyRegex() {
        String result = RegExUtils.replacePattern("", ".+", replacement);
        assertEquals("", result);
    }

    @Test
    void testReplacePattern_MatchingPattern() {
        String result = RegExUtils.replacePattern(sourceText, regex, replacement);
        assertEquals("ABC___123", result);
    }

    @Test
    void testReplacePattern_NonMatchingPattern() {
        String nonMatchingRegex = "[^A-Z0-9]+";
        String result = RegExUtils.replacePattern(sourceText, nonMatchingRegex, replacement);
        assertEquals("ABC_123", result);
    }

    @Test
    void testReplacePattern_NonMatchingPatternWithEmptyReplacement() {
        String nonMatchingRegex = "[^A-Z0-9]+";
        String emptyReplacement = "";
        String result = RegExUtils.replacePattern(sourceText, nonMatchingRegex, emptyReplacement);
        assertEquals("ABC123", result);
    }

    @Test
    void testReplacePattern_ComplexPattern() {
        String complexRegex = "( +)([a-z]+)";
        String complexReplacement = "_$2";
        String sourceText = "Lorem ipsum  dolor   sit";
        String result = RegExUtils.replacePattern(sourceText, complexRegex, complexReplacement);
        assertEquals("Lorem_ipsum_dolor_sit", result);
    }
}