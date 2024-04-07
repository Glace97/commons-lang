import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class isDigitsTest {

    @Nested
    @DisplayName("Positive Test Cases")
    class PositiveTests {

        @Test
        @DisplayName("Test isDigits with positive integer")
        void testIsDigitsWithPositiveInteger() {
            String str = "12345";
            boolean result = NumberUtils.isDigits(str);
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("Test isDigits with zero")
        void testIsDigitsWithZero() {
            String str = "0";
            boolean result = NumberUtils.isDigits(str);
            Assertions.assertTrue(result);
        }

        @Test
        @DisplayName("Test isDigits with negative integer")
        void testIsDigitsWithNegativeInteger() {
            String str = "-12345";
            boolean result = NumberUtils.isDigits(str);
            Assertions.assertFalse(result);
        }

        @Test
        @DisplayName("Test isDigits with positive decimal")
        void testIsDigitsWithPositiveDecimal() {
            String str = "123.45";
            boolean result = NumberUtils.isDigits(str);
            Assertions.assertFalse(result);
        }

        @Test
        @DisplayName("Test isDigits with negative decimal")
        void testIsDigitsWithNegativeDecimal() {
            String str = "-123.45";
            boolean result = NumberUtils.isDigits(str);
            Assertions.assertFalse(result);
        }

        @Test
        @DisplayName("Test isDigits with empty string")
        void testIsDigitsWithEmptyString() {
            String str = "";
            boolean result = NumberUtils.isDigits(str);
            Assertions.assertFalse(result);
        }

        @Test
        @DisplayName("Test isDigits with null string")
        void testIsDigitsWithNullString() {
            String str = null;
            boolean result = NumberUtils.isDigits(str);
            Assertions.assertFalse(result);
        }
    }

    @Nested
    @DisplayName("Negative Test Cases")
    class NegativeTests {

        @Test
        @DisplayName("Test isDigits with alphabetic characters")
        void testIsDigitsWithAlphabeticCharacters() {
            String str = "abc";
            boolean result = NumberUtils.isDigits(str);
            Assertions.assertFalse(result);
        }

        @Test
        @DisplayName("Test isDigits with special characters")
        void testIsDigitsWithSpecialCharacters() {
            String str = "!@#$";
            boolean result = NumberUtils.isDigits(str);
            Assertions.assertFalse(result);
        }

        @Test
        @DisplayName("Test isDigits with whitespace")
        void testIsDigitsWithWhitespace() {
            String str = "   ";
            boolean result = NumberUtils.isDigits(str);
            Assertions.assertFalse(result);
        }
    }
}