import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.math.BigInteger;

class isNumberTest {

    @Nested
    @DisplayName("Positive Cases")
    class PositiveCases {

        @Test
        @DisplayName("Test isNumber with valid integer")
        void testIsNumberWithValidInteger() {
            String number = "123";
            Assertions.assertTrue(NumberUtils.isNumber(number));
        }

        @Test
        @DisplayName("Test isNumber with valid decimal")
        void testIsNumberWithValidDecimal() {
            String number = "12.34";
            Assertions.assertTrue(NumberUtils.isNumber(number));
        }

        @Test
        @DisplayName("Test isNumber with valid scientific notation")
        void testIsNumberWithValidScientificNotation() {
            String number = "1.23E+10";
            Assertions.assertTrue(NumberUtils.isNumber(number));
        }

        @Test
        @DisplayName("Test isNumber with valid hexadecimal")
        void testIsNumberWithValidHexadecimal() {
            String number = "0xF";
            Assertions.assertTrue(NumberUtils.isNumber(number));
        }

        @Test
        @DisplayName("Test isNumber with valid octal")
        void testIsNumberWithValidOctal() {
            String number = "0123";
            Assertions.assertTrue(NumberUtils.isNumber(number));
        }

        @Test
        @DisplayName("Test isNumber with valid number marked with type qualifier")
        void testIsNumberWithValidTypeQualifier() {
            String number = "123L";
            Assertions.assertTrue(NumberUtils.isNumber(number));
        }

        @Test
        @DisplayName("Test isNumber with valid negative number")
        void testIsNumberWithValidNegativeNumber() {
            String number = "-123";
            Assertions.assertTrue(NumberUtils.isNumber(number));
        }

    }

    @Nested
    @DisplayName("Negative Cases")
    class NegativeCases {

        @Test
        @DisplayName("Test isNumber with null")
        void testIsNumberWithNull() {
            String number = null;
            Assertions.assertFalse(NumberUtils.isNumber(number));
        }

        @Test
        @DisplayName("Test isNumber with empty string")
        void testIsNumberWithEmptyString() {
            String number = "";
            Assertions.assertFalse(NumberUtils.isNumber(number));
        }

        @Test
        @DisplayName("Test isNumber with blank string")
        void testIsNumberWithBlankString() {
            String number = "   ";
            Assertions.assertFalse(NumberUtils.isNumber(number));
        }

        @Test
        @DisplayName("Test isNumber with invalid number")
        void testIsNumberWithInvalidNumber() {
            String number = "ABC";
            Assertions.assertFalse(NumberUtils.isNumber(number));
        }

        @Test
        @DisplayName("Test isNumber with invalid hexadecimal")
        void testIsNumberWithInvalidHexadecimal() {
            String number = "0XG";
            Assertions.assertFalse(NumberUtils.isNumber(number));
        }

        @Test
        @DisplayName("Test isNumber with invalid octal")
        void testIsNumberWithInvalidOctal() {
            String number = "08";
            Assertions.assertFalse(NumberUtils.isNumber(number));
        }

        @Test
        @DisplayName("Test isNumber with invalid number marked with type qualifier")
        void testIsNumberWithInvalidTypeQualifier() {
            String number = "123Q";
            Assertions.assertFalse(NumberUtils.isNumber(number));
        }

        @Test
        @DisplayName("Test isNumber with invalid negative number")
        void testIsNumberWithInvalidNegativeNumber() {
            String number = "-123.45";
            Assertions.assertFalse(NumberUtils.isNumber(number));
        }

    }

}