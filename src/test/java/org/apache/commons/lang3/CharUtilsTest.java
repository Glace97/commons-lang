package org.apache.commons.lang3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class CharUtilsTest {

    @Test
    public void testIsAsciiAlpha() {
        // Test with lowercase alphabets
        for (char ch = 'a'; ch <= 'z'; ch++) {
            assertTrue(CharUtils.isAsciiAlpha(ch));
        }

        // Test with uppercase alphabets
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            assertTrue(CharUtils.isAsciiAlpha(ch));
        }

        // Test with digits
        for (char ch = '0'; ch <= '9'; ch++) {
            assertFalse(CharUtils.isAsciiAlpha(ch));
        }

        // Test with special characters
        for (char ch = '!'; ch <= '/'; ch++) {
            assertFalse(CharUtils.isAsciiAlpha(ch));
        }
        for (char ch = ':'; ch <= '@'; ch++) {
            assertFalse(CharUtils.isAsciiAlpha(ch));
        }
        for (char ch = '['; ch <= '`'; ch++) {
            assertFalse(CharUtils.isAsciiAlpha(ch));
        }
        for (char ch = '{'; ch <= '~'; ch++) {
            assertFalse(CharUtils.isAsciiAlpha(ch));
        }
    }

    @Test
    public void testIsAsciiAlphaWithNonAsciiCharacters() {
        // Test with non-ascii characters
        assertFalse(CharUtils.isAsciiAlpha('\u0080'));
        assertFalse(CharUtils.isAsciiAlpha('\u00FF'));
        assertFalse(CharUtils.isAsciiAlpha('\u0100'));
        assertFalse(CharUtils.isAsciiAlpha('\uFFFF'));
    }

    @Test
    public void testIsAsciiAlphaWithControlCharacters() {
        // Test with control characters
        assertFalse(CharUtils.isAsciiAlpha(CharUtils.LF));
        assertFalse(CharUtils.isAsciiAlpha(CharUtils.CR));
        assertFalse(CharUtils.isAsciiAlpha(CharUtils.NUL));
    }

    @Test
    public void testIsAsciiWithAsciiCharacters() {
        // ASCII characters range from 0 to 127
        for (char ch = 0; ch < 128; ch++) {
            assertTrue(CharUtils.isAscii(ch));
        }
    }

    @Test
    public void testIsAsciiWithNonAsciiCharacters() {
        // Non-ASCII characters range from 128 to 255
        for (char ch = 128; ch < 256; ch++) {
            assertFalse(CharUtils.isAscii(ch));
        }
    }

    @Test
    public void testIsAsciiWithEdgeCases() {
        // Testing edge cases
        assertTrue(CharUtils.isAscii('\0')); // null character
        assertTrue(CharUtils.isAscii('\n')); // newline character
        assertTrue(CharUtils.isAscii('\r')); // carriage return character
        //assertFalse(CharUtils.isAscii('©')); // copyright symbol
    }

    @Test
    void toIntValueChar_Success() {
        int result = CharUtils.toIntValue('5');
        assertEquals(5, result);
    }

    @Test
    void toIntValueChar_Failure() {
        assertThrows(IllegalArgumentException.class, () -> CharUtils.toIntValue('A'));
    }

    @Test
    void toIntValueCharWithDefault_Success() {
        int result = CharUtils.toIntValue('8', -1);
        assertEquals(8, result);
    }

    @Test
    void toIntValueCharWithDefault_Failure() {
        int result = CharUtils.toIntValue('Z', -1);
        assertEquals(-1, result);
    }

    @Test
    void toIntValueCharacter_Success() {
        int result = CharUtils.toIntValue(Character.valueOf('3'));
        assertEquals(3, result);
    }

    @Test
    void toIntValueCharacter_Null() {
        assertThrows(NullPointerException.class, () -> CharUtils.toIntValue((Character) null));
    }

    @Test
    void toIntValueCharacter_Failure() {
        assertThrows(IllegalArgumentException.class, () -> CharUtils.toIntValue(Character.valueOf('B')));
    }

    @Test
    void toIntValueCharacterWithDefault_Success() {
        int result = CharUtils.toIntValue(Character.valueOf('7'), -1);
        assertEquals(7, result);
    }

    @Test
    void toIntValueCharacterWithDefault_Null() {
        int result = CharUtils.toIntValue((Character) null, -1);
        assertEquals(-1, result);
    }

    @Test
    void toIntValueCharacterWithDefault_Failure() {
        int result = CharUtils.toIntValue(Character.valueOf('M'), -1);
        assertEquals(-1, result);
    }

    @Test
    public void testToStringWithChar() {
        assertEquals("a", CharUtils.toString('a'));
        assertEquals("1", CharUtils.toString('1'));
        assertEquals(" ", CharUtils.toString(' '));
        assertEquals("\n", CharUtils.toString(CharUtils.LF));
        assertEquals("\r", CharUtils.toString(CharUtils.CR));
        assertEquals("\0", CharUtils.toString(CharUtils.NUL));
    }

    @Test
    public void testToStringWithNullCharacter() {
        assertNull(CharUtils.toString(null));
    }

    @Test
    public void testToStringWithCharacterObject() {
        assertEquals("a", CharUtils.toString(Character.valueOf('a')));
        assertEquals("1", CharUtils.toString(Character.valueOf('1')));
        assertEquals(" ", CharUtils.toString(Character.valueOf(' ')));
        assertEquals("\n", CharUtils.toString(Character.valueOf(CharUtils.LF)));
        assertEquals("\r", CharUtils.toString(Character.valueOf(CharUtils.CR)));
        assertEquals("\0", CharUtils.toString(Character.valueOf(CharUtils.NUL)));
    }

    @Test
    public void whenCharIsLowercase_thenAsciiAlphaUpperShouldReturnFalse() {
        char ch = 'a';
        assertFalse(CharUtils.isAsciiAlphaUpper(ch));
    }

    @Test
    public void whenCharIsUppercase_thenAsciiAlphaUpperShouldReturnTrue() {
        char ch = 'A';
        assertTrue(CharUtils.isAsciiAlphaUpper(ch));
    }

    @Test
    public void whenCharIsDigit_thenAsciiAlphaUpperShouldReturnFalse() {
        char ch = '3';
        assertFalse(CharUtils.isAsciiAlphaUpper(ch));
    }

    @Test
    public void whenCharIsSpecial_thenAsciiAlphaUpperShouldReturnFalse() {
        char ch = '-';
        assertFalse(CharUtils.isAsciiAlphaUpper(ch));
    }

    @Test
    public void whenCharIsNewline_thenAsciiAlphaUpperShouldReturnFalse() {
        char ch = '\n';
        assertFalse(CharUtils.isAsciiAlphaUpper(ch));
    }

    @Test
    public void testIsAsciiAlphanumeric() {
        // Test with alphanumeric characters
        assertTrue(CharUtils.isAsciiAlphanumeric('a'));
        assertTrue(CharUtils.isAsciiAlphanumeric('A'));
        assertTrue(CharUtils.isAsciiAlphanumeric('3'));

        // Test with non-alphanumeric characters
        assertFalse(CharUtils.isAsciiAlphanumeric('-'));
        assertFalse(CharUtils.isAsciiAlphanumeric('\n'));
        assertFalse(CharUtils.isAsciiAlphanumeric('&'));

        // Test with boundary values
        assertTrue(CharUtils.isAsciiAlphanumeric('0'));
        assertTrue(CharUtils.isAsciiAlphanumeric('9'));
        assertTrue(CharUtils.isAsciiAlphanumeric('z'));
        assertTrue(CharUtils.isAsciiAlphanumeric('Z'));
    }

    @Test
    public void testIsAsciiAlphaLower_withLowerCaseLetters() {
        assertTrue(CharUtils.isAsciiAlphaLower('a'));
        assertTrue(CharUtils.isAsciiAlphaLower('z'));
        assertTrue(CharUtils.isAsciiAlphaLower('m'));
    }

    @Test
    public void testIsAsciiAlphaLower_withUpperCaseLetters() {
        assertFalse(CharUtils.isAsciiAlphaLower('A'));
        assertFalse(CharUtils.isAsciiAlphaLower('Z'));
        assertFalse(CharUtils.isAsciiAlphaLower('M'));
    }

    @Test
    public void testIsAsciiAlphaLower_withDigits() {
        assertFalse(CharUtils.isAsciiAlphaLower('0'));
        assertFalse(CharUtils.isAsciiAlphaLower('9'));
    }

    @Test
    public void testIsAsciiAlphaLower_withSpecialCharacters() {
        assertFalse(CharUtils.isAsciiAlphaLower('-'));
        assertFalse(CharUtils.isAsciiAlphaLower('\n'));
    }

    @Test
    public void testToCharacterObjectWithChar() {
        // Instantiate necessary variables
        char ch = 'A';

        // Test
        Character result = CharUtils.toCharacterObject(ch);
        assertNotNull(result);
        assertEquals(ch, result);
    }

    @Test
    public void testToCharacterObjectWithNullString() {
        // Instantiate necessary variables
        String str = null;

        // Test
        Character result = CharUtils.toCharacterObject(str);
        assertNull(result);
    }

    @Test
    public void testToCharacterObjectWithEmptyString() {
        // Instantiate necessary variables
        String str = "";

        // Test
        Character result = CharUtils.toCharacterObject(str);
        assertNull(result);
    }

    @Test
    public void testToCharacterObjectWithString() {
        // Instantiate necessary variables
        String str = "BA";

        // Test
        Character result = CharUtils.toCharacterObject(str);
        assertNotNull(result);
        assertEquals('B', result);
    }

    @Test
    public void compare_CharactersAreEqual_ReturnsZero() {
        // Arrange
        char x = 'a';
        char y = 'a';

        // Act
        int result = CharUtils.compare(x, y);

        // Assert
        assertEquals(0, result, "When comparing two equal characters, result should be 0");
    }

    @Test
    public void compare_XIsLessThanY_ReturnsNegative() {
        // Arrange
        char x = 'a';
        char y = 'b';

        // Act
        int result = CharUtils.compare(x, y);

        // Assert
        assertTrue(result < 0, "When x is less than y, result should be negative");
    }

    @Test
    public void compare_XIsGreaterThanY_ReturnsPositive() {
        // Arrange
        char x = 'b';
        char y = 'a';

        // Act
        int result = CharUtils.compare(x, y);

        // Assert
        assertTrue(result > 0, "When x is greater than y, result should be positive");
    }

    @Test
    public void compare_NullCharacter_ReturnsExpectedDifference() {
        // Arrange
        char x = CharUtils.NUL;
        char y = 'a';

        // Act
        int result = CharUtils.compare(x, y);

        // Assert
        assertTrue(result < 0, "Comparing NUL with any character should be negative");
    }

    @Test
    public void toChar_CharacterNotNull_ReturnsChar() {
        Character ch = 'A';
        assertEquals('A', CharUtils.toChar(ch));
    }

    @Test
    public void toChar_CharacterNull_ThrowsNullPointerException() {
        Character ch = null;
        assertThrows(NullPointerException.class, () -> CharUtils.toChar(ch));
    }

    @Test
    public void toChar_CharacterNullWithDefault_ReturnsDefault() {
        Character ch = null;
        assertEquals('X', CharUtils.toChar(ch, 'X'));
    }

    @Test
    public void toChar_CharacterNotNullWithDefault_ReturnsChar() {
        Character ch = 'B';
        assertEquals('B', CharUtils.toChar(ch, 'X'));
    }

    @Test
    public void toChar_StringNotNull_ReturnsFirstChar() {
        String str = "Hello";
        assertEquals('H', CharUtils.toChar(str));
    }

    @Test
    public void toChar_StringNull_ThrowsNullPointerException() {
        String str = null;
        assertThrows(NullPointerException.class, () -> CharUtils.toChar(str));
    }

    @Test
    public void toChar_StringEmpty_ThrowsIllegalArgumentException() {
        String str = "";
        assertThrows(IllegalArgumentException.class, () -> CharUtils.toChar(str));
    }

    @Test
    public void toChar_StringNullWithDefault_ReturnsDefault() {
        String str = null;
        assertEquals('X', CharUtils.toChar(str, 'X'));
    }

    @Test
    public void toChar_StringEmptyWithDefault_ReturnsDefault() {
        String str = "";
        assertEquals('X', CharUtils.toChar(str, 'X'));
    }

    @Test
    public void toChar_StringNotNullWithDefault_ReturnsFirstChar() {
        String str = "Hello";
        assertEquals('H', CharUtils.toChar(str, 'X'));
    }

    @Test
    public void Given_AsciiPrintableCharacter_When_isAsciiPrintableCalled_Then_ReturnTrue() {
        // Given
        char ch = 'A';

        // When
        boolean isPrintable = CharUtils.isAsciiPrintable(ch);

        // Then
        assertTrue(isPrintable);
    }

    @Test
    public void Given_NonAsciiPrintableCharacter_When_isAsciiPrintableCalled_Then_ReturnFalse() {
        // Given
        char ch = CharUtils.LF;

        // When
        boolean isPrintable = CharUtils.isAsciiPrintable(ch);

        // Then
        assertFalse(isPrintable);
    }

    @Test
    public void Given_CharacterJustBelowAsciiPrintableRange_When_isAsciiPrintableCalled_Then_ReturnFalse() {
        // Given
        char ch = 31; // just below the printable ASCII range

        // When
        boolean isPrintable = CharUtils.isAsciiPrintable(ch);

        // Then
        assertFalse(isPrintable);
    }

    @Test
    public void Given_CharacterJustAboveAsciiPrintableRange_When_isAsciiPrintableCalled_Then_ReturnFalse() {
        // Given
        char ch = 127; // just above the printable ASCII range

        // When
        boolean isPrintable = CharUtils.isAsciiPrintable(ch);

        // Then
        assertFalse(isPrintable);
    }

    @Test
    public void testUnicodeEscapedWithChar() {
        assertEquals("\\u0041", CharUtils.unicodeEscaped('A'));
        assertEquals("\\u0020", CharUtils.unicodeEscaped(' '));
        assertEquals("\\u000a", CharUtils.unicodeEscaped(CharUtils.LF));
        assertEquals("\\u000d", CharUtils.unicodeEscaped(CharUtils.CR));
        assertEquals("\\u0000", CharUtils.unicodeEscaped(CharUtils.NUL));
    }

    @Test
    public void testUnicodeEscapedWithCharacter() {
        assertEquals("\\u0041", CharUtils.unicodeEscaped(Character.valueOf('A')));
        assertEquals("\\u0020", CharUtils.unicodeEscaped(Character.valueOf(' ')));
        assertEquals("\\u000a", CharUtils.unicodeEscaped(Character.valueOf(CharUtils.LF)));
        assertEquals("\\u000d", CharUtils.unicodeEscaped(Character.valueOf(CharUtils.CR)));
        assertEquals("\\u0000", CharUtils.unicodeEscaped(Character.valueOf(CharUtils.NUL)));
    }

    @Test
    public void testUnicodeEscapedWithNullCharacter() {
        assertNull(CharUtils.unicodeEscaped((Character) null));
    }

    @Test
    public void testIsAsciiControl_withAsciiControlChar() {
        // Arrange
        char charToTest = CharUtils.LF;  // Linefeed character is an ASCII control character.

        // Act
        boolean result = CharUtils.isAsciiControl(charToTest);

        // Assert
        assertTrue(result, "Expected isAsciiControl to return true for ASCII control character.");
    }

    @Test
    public void testIsAsciiControl_withNonAsciiControlChar() {
        // Arrange
        char charToTest = 'a';  // 'a' is a non-ASCII control character.

        // Act
        boolean result = CharUtils.isAsciiControl(charToTest);

        // Assert
        assertFalse(result, "Expected isAsciiControl to return false for non-ASCII control character.");
    }

    @Test
    public void testIsAsciiControl_withCharEqualTo32() {
        // Arrange
        char charToTest = ' ';  // ' ' is ASCII 32.

        // Act
        boolean result = CharUtils.isAsciiControl(charToTest);

        // Assert
        assertFalse(result, "Expected isAsciiControl to return false for char 32.");
    }

    @Test
    public void testIsAsciiControl_withCharEqualTo127() {
        // Arrange
        char charToTest = 127;  // 127 is an ASCII control character.

        // Act
        boolean result = CharUtils.isAsciiControl(charToTest);

        // Assert
        assertTrue(result, "Expected isAsciiControl to return true for ASCII control character 127.");
    }
    @Test
    public void testIsAsciiNumericWithNumeric() {
        assertTrue(CharUtils.isAsciiNumeric('3'), "Expected '3' to be identified as ASCII Numeric");
    }

    @Test
    public void testIsAsciiNumericWithNonNumeric() {
        assertFalse(CharUtils.isAsciiNumeric('a'), "Expected 'a' to not be identified as ASCII Numeric");
    }

    @Test
    public void testIsAsciiNumericWithSpecialChar() {
        assertFalse(CharUtils.isAsciiNumeric('-'), "Expected '-' to not be identified as ASCII Numeric");
    }

    @Test
    public void testIsAsciiNumericWithEscapeChar() {
        assertFalse(CharUtils.isAsciiNumeric('\n'), "Expected '\n' to not be identified as ASCII Numeric");
    }

    @Test
    public void testIsAsciiNumericWithNullChar() {
        assertFalse(CharUtils.isAsciiNumeric(CharUtils.NUL), "Expected null char to not be identified as ASCII Numeric");
    }

    @Test
    public void testIsAsciiNumericWithLowestAsciiValue() {
        assertFalse(CharUtils.isAsciiNumeric((char)0), "Expected lowest ASCII value to not be identified as ASCII Numeric");
    }

    @Test
    public void testIsAsciiNumericWithHighestAsciiValue() {
        assertFalse(CharUtils.isAsciiNumeric((char)127), "Expected highest ASCII value to not be identified as ASCII Numeric");
    }

    @Test
    public void testIsAsciiNumericWithLowestAsciiNumericValue() {
        assertTrue(CharUtils.isAsciiNumeric('0'), "Expected lowest ASCII Numeric value to be identified as ASCII Numeric");
    }

    @Test
    public void testIsAsciiNumericWithHighestAsciiNumericValue() {
        assertTrue(CharUtils.isAsciiNumeric('9'), "Expected highest ASCII Numeric value to be identified as ASCII Numeric");
    }

}