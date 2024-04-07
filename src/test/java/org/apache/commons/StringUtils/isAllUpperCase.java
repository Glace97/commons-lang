
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("isAllUpperCase Tests")
class isAllUpperCaseTest {

    @Nested
    @DisplayName("Empty Input Tests")
    class EmptyInputTests {
        @Test
        @DisplayName("Test with null input")
        void testNullInput() {
            assertFalse(StringUtils.isAllUpperCase(null));
        }

        @Test
        @DisplayName("Test with empty string input")
        void testEmptyStringInput() {
            assertFalse(StringUtils.isAllUpperCase(""));
        }
    }

    @Nested
    @DisplayName("Uppercase Input Tests")
    class UppercaseInputTests {
        @Test
        @DisplayName("Test with uppercase string")
        void testUppercaseString() {
            assertTrue(StringUtils.isAllUpperCase("ABC"));
        }

        @Test
        @DisplayName("Test with mixed case string")
        void testMixedCaseString() {
            assertFalse(StringUtils.isAllUpperCase("aBC"));
        }
    }

    @Nested
    @DisplayName("Whitespace Input Tests")
    class WhitespaceInputTests {
        @Test
        @DisplayName("Test with string containing only whitespace")
        void testWhitespaceString() {
            assertFalse(StringUtils.isAllUpperCase("  "));
        }

        @Test
        @DisplayName("Test with string containing whitespace and uppercase characters")
        void testWhitespaceAndUppercaseString() {
            assertFalse(StringUtils.isAllUpperCase("A C"));
        }
    }

    @Nested
    @DisplayName("Non-Alphabetic Input Tests")
    class NonAlphabeticInputTests {
        @Test
        @DisplayName("Test with string containing non-alphabetic characters")
        void testNonAlphabeticString() {
            assertFalse(StringUtils.isAllUpperCase("A1C"));
        }

        @Test
        @DisplayName("Test with string containing special characters")
        void testSpecialCharactersString() {
            assertFalse(StringUtils.isAllUpperCase("A/C"));
        }
    }
}
