
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class RotateTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Nested
    @DisplayName("Tests for rotate method")
    class RotateTests {

        @Test
        @DisplayName("Should return null when input string is null")
        void shouldReturnNullWhenInputStringIsNull() {
            assertNull(stringUtils.rotate(null, 1));
        }

        @Test
        @DisplayName("Should return the original string when shift is 0")
        void shouldReturnOriginalStringWhenShiftIsZero() {
            String input = "abcdefg";
            assertEquals(input, stringUtils.rotate(input, 0));
        }

        @Test
        @DisplayName("Should return the rotated string for positive shift")
        void shouldReturnRotatedStringForPositiveShift() {
            assertEquals("fgabcde", stringUtils.rotate("abcdefg", 2));
        }

        @Test
        @DisplayName("Should return the rotated string for negative shift")
        void shouldReturnRotatedStringForNegativeShift() {
            assertEquals("cdefgab", stringUtils.rotate("abcdefg", -2));
        }

        @Test
        @DisplayName("Should return the original string when shift is equal to string length")
        void shouldReturnOriginalStringWhenShiftIsEqualToStringLength() {
            String input = "abcdefg";
            assertEquals(input, stringUtils.rotate(input, 7));
        }

        @Test
        @DisplayName("Should return the original string when shift is a multiple of string length")
        void shouldReturnOriginalStringWhenShiftIsMultipleOfStringLength() {
            String input = "abcdefg";
            assertEquals(input, stringUtils.rotate(input, 14));
        }

        @Test
        @DisplayName("Should return the rotated string for shift greater than string length")
        void shouldReturnRotatedStringForShiftGreaterThanStringLength() {
            assertEquals("fgabcde", stringUtils.rotate("abcdefg", 9));
        }

        @Test
        @DisplayName("Should return the rotated string for shift less than negative string length")
        void shouldReturnRotatedStringForShiftLessThanNegativeStringLength() {
            assertEquals("cdefgab", stringUtils.rotate("abcdefg", -9));
        }

    }
}
