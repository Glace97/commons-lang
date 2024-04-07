
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {

    @Nested
    @DisplayName("stripToEmpty method")
    class StripToEmptyMethod {

        StringUtils stringUtils;

        @BeforeEach
        void setUp() {
            stringUtils = new StringUtils();
        }

        @Test
        @DisplayName("should return empty string for null input")
        void testStripToEmptyNullInput() {
            String result = stringUtils.stripToEmpty(null);
            assertEquals("", result);
        }

        @Test
        @DisplayName("should return empty string for empty string input")
        void testStripToEmptyEmptyInput() {
            String result = stringUtils.stripToEmpty("");
            assertEquals("", result);
        }

        @Test
        @DisplayName("should return empty string for whitespace input")
        void testStripToEmptyWhitespaceInput() {
            String result = stringUtils.stripToEmpty("   ");
            assertEquals("", result);
        }

        @Test
        @DisplayName("should return input string without leading and trailing whitespace")
        void testStripToEmptyLeadingAndTrailingWhitespaceInput() {
            String result = stringUtils.stripToEmpty("  abc  ");
            assertEquals("abc", result);
        }

        @Test
        @DisplayName("should return input string without leading whitespace")
        void testStripToEmptyLeadingWhitespaceInput() {
            String result = stringUtils.stripToEmpty("  abc");
            assertEquals("abc", result);
        }

        @Test
        @DisplayName("should return input string without trailing whitespace")
        void testStripToEmptyTrailingWhitespaceInput() {
            String result = stringUtils.stripToEmpty("abc  ");
            assertEquals("abc", result);
        }

        @Test
        @DisplayName("should return input string without leading and trailing whitespace, and preserve internal whitespace")
        void testStripToEmptyLeadingAndTrailingWhitespaceWithInternalWhitespaceInput() {
            String result = stringUtils.stripToEmpty(" ab c ");
            assertEquals("ab c", result);
        }
    }
}
