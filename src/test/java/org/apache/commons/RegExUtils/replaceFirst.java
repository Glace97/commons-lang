import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static org.junit.jupiter.api.Assertions.*;

public class replaceFirstTest {

    @Nested
    @DisplayName("Tests for replaceFirst with Pattern")
    class PatternTests {

        private Pattern pattern;

        @BeforeEach
        void setup() {
            pattern = Pattern.compile("abc");
        }

        @Test
        @DisplayName("Test replaceFirst with null text")
        void testReplaceFirstWithNullText() {
            assertNull(RegExUtils.replaceFirst(null, pattern, "xyz"));
        }

        @Test
        @DisplayName("Test replaceFirst with null pattern")
        void testReplaceFirstWithNullPattern() {
            assertEquals("abc", RegExUtils.replaceFirst("abc", null, "xyz"));
        }

        @Test
        @DisplayName("Test replaceFirst with null replacement")
        void testReplaceFirstWithNullReplacement() {
            assertEquals("abc", RegExUtils.replaceFirst("abc", pattern, null));
        }

        @Test
        @DisplayName("Test replaceFirst with empty text")
        void testReplaceFirstWithEmptyText() {
            assertEquals("", RegExUtils.replaceFirst("", pattern, "xyz"));
        }

        @Test
        @DisplayName("Test replaceFirst with empty pattern")
        void testReplaceFirstWithEmptyPattern() {
            assertEquals("xyz", RegExUtils.replaceFirst("abc", Pattern.compile(""), "xyz"));
        }

        @Test
        @DisplayName("Test replaceFirst with empty replacement")
        void testReplaceFirstWithEmptyReplacement() {
            assertEquals("", RegExUtils.replaceFirst("abc", pattern, ""));
        }

        @Test
        @DisplayName("Test replaceFirst with no match")
        void testReplaceFirstWithNoMatch() {
            assertEquals("abc", RegExUtils.replaceFirst("xyz", pattern, "123"));
        }

        @Test
        @DisplayName("Test replaceFirst with match")
        void testReplaceFirstWithMatch() {
            assertEquals("xyz", RegExUtils.replaceFirst("abc", pattern, "xyz"));
        }

        @Test
        @DisplayName("Test replaceFirst with multiple matches")
        void testReplaceFirstWithMultipleMatches() {
            assertEquals("xyz abc", RegExUtils.replaceFirst("abc abc", pattern, "xyz"));
        }

    }

    @Nested
    @DisplayName("Tests for replaceFirst with String")
    class StringTests {

        @Test
        @DisplayName("Test replaceFirst with null text")
        void testReplaceFirstWithNullText() {
            assertNull(RegExUtils.replaceFirst(null, "abc", "xyz"));
        }

        @Test
        @DisplayName("Test replaceFirst with null regex")
        void testReplaceFirstWithNullRegex() {
            assertEquals("abc", RegExUtils.replaceFirst("abc", null, "xyz"));
        }

        @Test
        @DisplayName("Test replaceFirst with null replacement")
        void testReplaceFirstWithNullReplacement() {
            assertEquals("abc", RegExUtils.replaceFirst("abc", "abc", null));
        }

        @Test
        @DisplayName("Test replaceFirst with empty text")
        void testReplaceFirstWithEmptyText() {
            assertEquals("", RegExUtils.replaceFirst("", "abc", "xyz"));
        }

        @Test
        @DisplayName("Test replaceFirst with empty regex")
        void testReplaceFirstWithEmptyRegex() {
            assertEquals("xyz", RegExUtils.replaceFirst("abc", "", "xyz"));
        }

        @Test
        @DisplayName("Test replaceFirst with empty replacement")
        void testReplaceFirstWithEmptyReplacement() {
            assertEquals("", RegExUtils.replaceFirst("abc", "abc", ""));
        }

        @Test
        @DisplayName("Test replaceFirst with no match")
        void testReplaceFirstWithNoMatch() {
            assertEquals("abc", RegExUtils.replaceFirst("xyz", "abc", "123"));
        }

        @Test
        @DisplayName("Test replaceFirst with match")
        void testReplaceFirstWithMatch() {
            assertEquals("xyz", RegExUtils.replaceFirst("abc", "abc", "xyz"));
        }

        @Test
        @DisplayName("Test replaceFirst with multiple matches")
        void testReplaceFirstWithMultipleMatches() {
            assertEquals("xyz abc", RegExUtils.replaceFirst("abc abc", "abc", "xyz"));
        }

    }

}