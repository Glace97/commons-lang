
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharUtilsTest {

    @Nested
    @DisplayName("isAsciiAlphaUpper")
    class IsAsciiAlphaUpper {

        @Test
        @DisplayName("should return true for uppercase letters")
        void testIsAsciiAlphaUpperWithUppercaseLetters() {
            assertTrue(CharUtils.isAsciiAlphaUpper('A'));
            assertTrue(CharUtils.isAsciiAlphaUpper('Z'));
        }

        @Test
        @DisplayName("should return false for lowercase letters")
        void testIsAsciiAlphaUpperWithLowercaseLetters() {
            assertFalse(CharUtils.isAsciiAlphaUpper('a'));
            assertFalse(CharUtils.isAsciiAlphaUpper('z'));
        }

        @Test
        @DisplayName("should return false for non-alphabetic characters")
        void testIsAsciiAlphaUpperWithNonAlphabeticCharacters() {
            assertFalse(CharUtils.isAsciiAlphaUpper('3'));
            assertFalse(CharUtils.isAsciiAlphaUpper('-'));
            assertFalse(CharUtils.isAsciiAlphaUpper('\n'));
            assertFalse(CharUtils.isAsciiAlphaUpper('&'));
            assertFalse(CharUtils.isAsciiAlphaUpper('©'));
        }

        @Test
        @DisplayName("should return false for special characters")
        void testIsAsciiAlphaUpperWithSpecialCharacters() {
            assertFalse(CharUtils.isAsciiAlphaUpper(CharUtils.LF));
            assertFalse(CharUtils.isAsciiAlphaUpper(CharUtils.CR));
            assertFalse(CharUtils.isAsciiAlphaUpper(CharUtils.NUL));
        }

        @Test
        @DisplayName("should return true for all uppercase letters in ASCII range")
        void testIsAsciiAlphaUpperWithAllUppercaseLettersInRange() {
            for (char ch = 'A'; ch <= 'Z'; ch++) {
                assertTrue(CharUtils.isAsciiAlphaUpper(ch));
            }
        }

        @Test
        @DisplayName("should return false for all lowercase letters in ASCII range")
        void testIsAsciiAlphaUpperWithAllLowercaseLettersInRange() {
            for (char ch = 'a'; ch <= 'z'; ch++) {
                assertFalse(CharUtils.isAsciiAlphaUpper(ch));
            }
        }
    }
}
