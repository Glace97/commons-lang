import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("dotAllMatcher Test Suite")
class dotAllMatcherTest {

    @Test
    @DisplayName("Test dotAllMatcher with valid inputs")
    void testDotAllMatcherWithValidInputs() {
        String regex = "abc.*def";
        String text = "abc\ndef";
        Matcher matcher = RegExUtils.dotAllMatcher(regex, text);
        assertTrue(matcher.matches());
    }

    @Test
    @DisplayName("Test dotAllMatcher with invalid regex")
    void testDotAllMatcherWithInvalidRegex() {
        String regex = "[a-z";
        String text = "abc\ndef";
        assertThrows(PatternSyntaxException.class, () -> {
            RegExUtils.dotAllMatcher(regex, text);
        });
    }

    @Test
    @DisplayName("Test dotAllMatcher with null regex")
    void testDotAllMatcherWithNullRegex() {
        String regex = null;
        String text = "abc\ndef";
        assertThrows(NullPointerException.class, () -> {
            RegExUtils.dotAllMatcher(regex, text);
        });
    }

    @Test
    @DisplayName("Test dotAllMatcher with null text")
    void testDotAllMatcherWithNullText() {
        String regex = "abc.*def";
        String text = null;
        assertThrows(NullPointerException.class, () -> {
            RegExUtils.dotAllMatcher(regex, text);
        });
    }

    @Test
    @DisplayName("Test dotAllMatcher with empty regex and text")
    void testDotAllMatcherWithEmptyRegexAndText() {
        String regex = "";
        String text = "";
        Matcher matcher = RegExUtils.dotAllMatcher(regex, text);
        assertFalse(matcher.matches());
    }

    @Test
    @DisplayName("Test dotAllMatcher with empty regex")
    void testDotAllMatcherWithEmptyRegex() {
        String regex = "";
        String text = "abc\ndef";
        Matcher matcher = RegExUtils.dotAllMatcher(regex, text);
        assertFalse(matcher.matches());
    }

    @Test
    @DisplayName("Test dotAllMatcher with empty text")
    void testDotAllMatcherWithEmptyText() {
        String regex = "abc.*def";
        String text = "";
        Matcher matcher = RegExUtils.dotAllMatcher(regex, text);
        assertFalse(matcher.matches());
    }

    @Test
    @DisplayName("Test dotAllMatcher with regex and text containing special characters")
    void testDotAllMatcherWithSpecialCharacters() {
        String regex = "a\\|c.*d\\*f";
        String text = "a|c\nd*f";
        Matcher matcher = RegExUtils.dotAllMatcher(regex, text);
        assertTrue(matcher.matches());
    }
}