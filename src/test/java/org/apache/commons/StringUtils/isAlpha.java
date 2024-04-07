import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isAlphaTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Nested
    @DisplayName("Testing isAlpha method")
    class IsAlphaMethod {

        @Test
        @DisplayName("Should return false for null input")
        void testIsAlphaNullInput() {
            assertFalse(stringUtils.isAlpha(null));
        }

        @Test
        @DisplayName("Should return false for empty string input")
        void testIsAlphaEmptyString() {
            assertFalse(stringUtils.isAlpha(""));
        }

        @Test
        @DisplayName("Should return false for string with only spaces")
        void testIsAlphaOnlySpaces() {
            assertFalse(stringUtils.isAlpha("    "));
        }

        @Test
        @DisplayName("Should return true for string with only letters")
        void testIsAlphaOnlyLetters() {
            assertTrue(stringUtils.isAlpha("abc"));
        }

        @Test
        @DisplayName("Should return false for string with numbers")
        void testIsAlphaWithNumbers() {
            assertFalse(stringUtils.isAlpha("ab2c"));
        }

        @Test
        @DisplayName("Should return false for string with special characters")
        void testIsAlphaWithSpecialCharacters() {
            assertFalse(stringUtils.isAlpha("ab-c"));
        }

        @Test
        @DisplayName("Should return true for string with uppercase letters")
        void testIsAlphaWithUppercaseLetters() {
            assertTrue(stringUtils.isAlpha("ABC"));
        }

        @Test
        @DisplayName("Should return true for string with mixed case letters")
        void testIsAlphaWithMixedCaseLetters() {
            assertTrue(stringUtils.isAlpha("AbC"));
        }
    }
}