package org.apache.commons.lang3;

import org.mockito.MockedStatic;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;

public class CharUtilsTest {



    @Test
    public void testIsAsciiAlpha_WithLowercase() {
        // Arrange
        char ch = 'a';

        // Act
        boolean result = CharUtils.isAsciiAlpha(ch);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAsciiAlpha_WithUppercase() {
        // Arrange
        char ch = 'A';

        // Act
        boolean result = CharUtils.isAsciiAlpha(ch);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAsciiAlpha_WithNonAlphabeticCharacter() {
        // Arrange
        char ch = '3';

        // Act
        boolean result = CharUtils.isAsciiAlpha(ch);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsAsciiAlpha_WithSpecialCharacter() {
        // Arrange
        char ch = '-';

        // Act
        boolean result = CharUtils.isAsciiAlpha(ch);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsAsciiAlpha_WithNewlineCharacter() {
        // Arrange
        char ch = '\n';

        // Act
        boolean result = CharUtils.isAsciiAlpha(ch);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testToIntValue_ValidNumericCharacter_ReturnsIntValue() {
        char ch = '5';
        int expected = 5;

        int result = CharUtils.toIntValue(ch);

        assertEquals(expected, result);
    }

    @Test
    public void testToIntValue_InvalidNumericCharacter_ThrowsIllegalArgumentException() {
        char ch = 'A';

        assertThrows(IllegalArgumentException.class, () -> {
            CharUtils.toIntValue(ch);
        });
    }

    @Test
    public void testToIntValue_ValidNumericCharacterAndDefaultValue_ReturnsIntValue() {
        char ch = '3';
        int defaultValue = -1;
        int expected = 3;

        int result = CharUtils.toIntValue(ch, defaultValue);

        assertEquals(expected, result);
    }

    @Test
    public void testToIntValue_InvalidNumericCharacterAndDefaultValue_ReturnsDefaultValue() {
        char ch = 'A';
        int defaultValue = -1;

        int result = CharUtils.toIntValue(ch, defaultValue);

        assertEquals(defaultValue, result);
    }

    @Test
    public void testToIntValue_ValidCharacterObject_ReturnsIntValue() {
        Character ch = '7';
        int expected = 7;

        int result = CharUtils.toIntValue(ch);

        assertEquals(expected, result);
    }

    @Test
    public void testToIntValue_NullCharacterObject_ThrowsNullPointerException() {
        Character ch = null;

        assertThrows(NullPointerException.class, () -> {
            CharUtils.toIntValue(ch);
        });
    }

    @Test
    public void testToIntValue_InvalidCharacterObject_ThrowsIllegalArgumentException() {
        Character ch = 'A';

        assertThrows(IllegalArgumentException.class, () -> {
            CharUtils.toIntValue(ch);
        });
    }

    @Test
    public void testToIntValue_ValidCharacterObjectAndDefaultValue_ReturnsIntValue() {
        Character ch = '9';
        int defaultValue = -1;
        int expected = 9;

        int result = CharUtils.toIntValue(ch, defaultValue);

        assertEquals(expected, result);
    }

    @Test
    public void testToIntValue_NullCharacterObjectAndDefaultValue_ReturnsDefaultValue() {
        Character ch = null;
        int defaultValue = -1;

        int result = CharUtils.toIntValue(ch, defaultValue);

        assertEquals(defaultValue, result);
    }

    @Test
    public void testToIntValue_InvalidCharacterObjectAndDefaultValue_ReturnsDefaultValue() {
        Character ch = 'A';
        int defaultValue = -1;

        int result = CharUtils.toIntValue(ch, defaultValue);

        assertEquals(defaultValue, result);
    }


    @Test
    public void testToString_withValidCharacter_shouldReturnStringWithCharacter() {
        // Arrange
        char ch = 'A';

        // Act
        String result = CharUtils.toString(ch);

        // Assert
        assertEquals("A", result);
    }

    @Test
    public void testToString_withNullCharacter_shouldReturnNull() {
        // Arrange
        Character ch = null;

        // Act
        String result = CharUtils.toString(ch);

        // Assert
        assertNull(result);
    }

    @Test
    public void testToString_withLFCharacter_shouldReturnLFString() {
        // Arrange
        char ch = CharUtils.LF;

        // Act
        String result = CharUtils.toString(ch);

        // Assert
        assertEquals("\n", result);
    }

    @Test
    public void testToString_withCRCharacter_shouldReturnCRString() {
        // Arrange
        char ch = CharUtils.CR;

        // Act
        String result = CharUtils.toString(ch);

        // Assert
        assertEquals("\r", result);
    }

    @Test
    public void testToString_withNULCharacter_shouldReturnNULString() {
        // Arrange
        char ch = CharUtils.NUL;

        // Act
        String result = CharUtils.toString(ch);

        // Assert
        assertEquals("\u0000", result);
    }

    @Test
    public void testToString_withCharacterGreaterThanCharArrayLength_shouldReturnStringWithCharacter() {
        // Arrange
        char ch = 150;

        // Act
        String result = CharUtils.toString(ch);

        // Assert
        assertEquals(String.valueOf(ch), result);
    }

    @Test
    public void testIsAsciiAlphaUpper_ReturnsTrueForUpperCaseLetters() {
        // Arrange
        char ch = 'A';

        // Act
        boolean result = CharUtils.isAsciiAlphaUpper(ch);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAsciiAlphaUpper_ReturnsFalseForLowerCaseLetters() {
        // Arrange
        char ch = 'a';

        // Act
        boolean result = CharUtils.isAsciiAlphaUpper(ch);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsAsciiAlphaUpper_ReturnsFalseForDigits() {
        // Arrange
        char ch = '3';

        // Act
        boolean result = CharUtils.isAsciiAlphaUpper(ch);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsAsciiAlphaUpper_ReturnsFalseForSpecialCharacters() {
        // Arrange
        char ch = '-';

        // Act
        boolean result = CharUtils.isAsciiAlphaUpper(ch);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsAsciiAlphaUpper_ReturnsFalseForLFCharacter() {
        // Arrange
        char ch = '\n';

        // Act
        boolean result = CharUtils.isAsciiAlphaUpper(ch);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsAsciiControl_ReturnsTrueForLF() {
        // Arrange
        char ch = CharUtils.LF;

        // Act
        boolean result = CharUtils.isAsciiControl(ch);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAsciiControl_ReturnsTrueForCR() {
        // Arrange
        char ch = CharUtils.CR;

        // Act
        boolean result = CharUtils.isAsciiControl(ch);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAsciiControl_ReturnsTrueForNUL() {
        // Arrange
        char ch = CharUtils.NUL;

        // Act
        boolean result = CharUtils.isAsciiControl(ch);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAsciiControl_ReturnsTrueForControlCharacters() {
        // Arrange
        char ch = 0;

        // Act
        boolean result = CharUtils.isAsciiControl(ch);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAsciiControl_ReturnsFalseForNonControlCharacters() {
        // Arrange
        char ch = 'a';

        // Act
        boolean result = CharUtils.isAsciiControl(ch);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testUnicodeEscaped() {
        // Test with space character
        char ch1 = ' ';
        String expected1 = "\\u0020";
        String actual1 = CharUtils.unicodeEscaped(ch1);
        assertEquals(expected1, actual1);

        // Test with 'A' character
        char ch2 = 'A';
        String expected2 = "\\u0041";
        String actual2 = CharUtils.unicodeEscaped(ch2);
        assertEquals(expected2, actual2);

        // Test with null character
        char ch3 = '\0';
        String expected3 = "\\u0000";
        String actual3 = CharUtils.unicodeEscaped(ch3);
        assertEquals(expected3, actual3);

        // Test with null input
        Character ch4 = null;
        String expected4 = null;
        String actual4 = CharUtils.unicodeEscaped(ch4);
        assertEquals(expected4, actual4);
    }

    @Test
    public void testIsAsciiPrintable_ReturnsTrueForLowercaseLetter() {
        // Arrange
        char ch = 'a';

        // Act
        boolean result = CharUtils.isAsciiPrintable(ch);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAsciiPrintable_ReturnsTrueForUppercaseLetter() {
        // Arrange
        char ch = 'A';

        // Act
        boolean result = CharUtils.isAsciiPrintable(ch);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAsciiPrintable_ReturnsTrueForDigit() {
        // Arrange
        char ch = '3';

        // Act
        boolean result = CharUtils.isAsciiPrintable(ch);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAsciiPrintable_ReturnsTrueForSpecialCharacter() {
        // Arrange
        char ch = '-';

        // Act
        boolean result = CharUtils.isAsciiPrintable(ch);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAsciiPrintable_ReturnsFalseForLinefeedCharacter() {
        // Arrange
        char ch = '\n';

        // Act
        boolean result = CharUtils.isAsciiPrintable(ch);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsAsciiPrintable_ReturnsFalseForNullControlCharacter() {
        // Arrange
        char ch = '\0';

        // Act
        boolean result = CharUtils.isAsciiPrintable(ch);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsAsciiPrintable_ReturnsTrueForAllPrintableAsciiCharacters() {
        // Arrange
        for (int i = 32; i < 127; i++) {
            char ch = (char) i;

            // Act
            boolean result = CharUtils.isAsciiPrintable(ch);

            // Assert
            assertTrue(result);
        }
    }

    @Test
    public void testCompare_GivenSameChars_ReturnsZero() {
        // Arrange
        char x = 'a';
        char y = 'a';

        // Act
        int result = CharUtils.compare(x, y);

        // Assert
        assertEquals(0, result);
    }

    @Test
    public void testCompare_GivenXLessThanY_ReturnsNegativeValue() {
        // Arrange
        char x = 'a';
        char y = 'b';

        // Act
        int result = CharUtils.compare(x, y);

        // Assert
        assertTrue(result < 0);
    }

    @Test
    public void testCompare_GivenXGreaterThanY_ReturnsPositiveValue() {
        // Arrange
        char x = 'b';
        char y = 'a';

        // Act
        int result = CharUtils.compare(x, y);

        // Assert
        assertTrue(result > 0);
    }

    @Test
    public void testCompare_GivenSpecialCharacters_ReturnsCorrectValue() {
        // Arrange
        char x = CharUtils.LF;
        char y = CharUtils.CR;

        // Act
        int result = CharUtils.compare(x, y);

        // Assert
        assertTrue(result < 0);
    }

    @Test
    public void testCompare_GivenNullControlCharacter_ReturnsCorrectValue() {
        // Arrange
        char x = CharUtils.NUL;
        char y = 'a';

        // Act
        int result = CharUtils.compare(x, y);

        // Assert
        assertTrue(result < 0);
    }

    @Test
    public void testToCharacterObjectWithAsciiCharacter() {
        // Arrange
        char ch = 'A';

        // Act
        Character result = CharUtils.toCharacterObject(ch);

        // Assert
        assertEquals(Character.valueOf(ch), result);
    }

    @Test
    public void testToCharacterObjectWithNullCharacter() {
        // Arrange
        char ch = '\0';

        // Act
        Character result = CharUtils.toCharacterObject(ch);

        // Assert
        assertEquals(Character.valueOf(ch), result);
    }

    @Test
    public void testToCharacterObjectWithLinefeedCharacter() {
        // Arrange
        char ch = '\n';

        // Act
        Character result = CharUtils.toCharacterObject(ch);

        // Assert
        assertEquals(Character.valueOf(ch), result);
    }

    @Test
    public void testToCharacterObjectWithCarriageReturnCharacter() {
        // Arrange
        char ch = '\r';

        // Act
        Character result = CharUtils.toCharacterObject(ch);

        // Assert
        assertEquals(Character.valueOf(ch), result);
    }

    @Test
    public void testToCharacterObjectWithStringWithAsciiCharacter() {
        // Arrange
        String str = "A";

        // Act
        Character result = CharUtils.toCharacterObject(str);

        // Assert
        assertEquals(Character.valueOf(str.charAt(0)), result);
    }

    @Test
    public void testToCharacterObjectWithStringWithNonAsciiCharacter() {
        // Arrange
        String str = "Ω";

        // Act
        Character result = CharUtils.toCharacterObject(str);

        // Assert
        assertEquals(Character.valueOf(str.charAt(0)), result);
    }

    @Test
    public void testToCharacterObjectWithNullString() {
        // Arrange
        String str = null;

        // Act
        Character result = CharUtils.toCharacterObject(str);

        // Assert
        assertNull(result);
    }

    @Test
    public void testToCharacterObjectWithEmptyString() {
        // Arrange
        String str = "";

        // Act
        Character result = CharUtils.toCharacterObject(str);

        // Assert
        assertNull(result);
    }

    @Test
    public void testToCharNonNull() {
        // Instantiate all necessary variables here
        Character ch = 'A';

        // Write the test code here following the given rules
        char result = CharUtils.toChar(ch);
        assertEquals('A', result);
    }

    @Test
    public void testToCharNull() {
        // Instantiate all necessary variables here
        Character ch = null;

        // Write the test code here following the given rules
        assertThrows(NullPointerException.class, () -> CharUtils.toChar(ch));
    }

    @Test
    public void testToCharWithDefaultValueNonNull() {
        // Instantiate all necessary variables here
        Character ch = 'A';
        char defaultValue = 'X';

        // Write the test code here following the given rules
        char result = CharUtils.toChar(ch, defaultValue);
        assertEquals('A', result);
    }

    @Test
    public void testToCharWithDefaultValueNull() {
        // Instantiate all necessary variables here
        Character ch = null;
        char defaultValue = 'X';

        // Write the test code here following the given rules
        char result = CharUtils.toChar(ch, defaultValue);
        assertEquals('X', result);
    }

    @Test
    public void testToCharFromStringNonNull() {
        // Instantiate all necessary variables here
        String str = "ABC";

        // Write the test code here following the given rules
        char result = CharUtils.toChar(str);
        assertEquals('A', result);
    }

    @Test
    public void testToCharFromStringEmpty() {
        // Instantiate all necessary variables here
        String str = "";

        // Write the test code here following the given rules
        assertThrows(IllegalArgumentException.class, () -> CharUtils.toChar(str));
    }

    @Test
    public void testToCharFromStringNull() {
        // Instantiate all necessary variables here
        String str = null;

        // Write the test code here following the given rules
        assertThrows(NullPointerException.class, () -> CharUtils.toChar(str));
    }

    @Test
    public void testToCharFromStringWithDefaultValueNonNull() {
        // Instantiate all necessary variables here
        String str = "ABC";
        char defaultValue = 'X';

        // Write the test code here following the given rules
        char result = CharUtils.toChar(str, defaultValue);
        assertEquals('A', result);
    }

    @Test
    public void testToCharFromStringWithDefaultValueEmpty() {
        // Instantiate all necessary variables here
        String str = "";
        char defaultValue = 'X';

        // Write the test code here following the given rules
        char result = CharUtils.toChar(str, defaultValue);
        assertEquals('X', result);
    }

    @Test
    public void testToCharFromStringWithDefaultValueNull() {
        // Instantiate all necessary variables here
        String str = null;
        char defaultValue = 'X';

        // Write the test code here following the given rules
        char result = CharUtils.toChar(str, defaultValue);
        assertEquals('X', result);
    }

    @Test
    public void testIsAsciiAlphaLower_WhenCharacterIsLowerCaseAlphabet_ReturnsTrue() {
        // Arrange
        char ch = 'a';

        // Act
        boolean result = CharUtils.isAsciiAlphaLower(ch);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAsciiAlphaLower_WhenCharacterIsUpperCaseAlphabet_ReturnsFalse() {
        // Arrange
        char ch = 'A';

        // Act
        boolean result = CharUtils.isAsciiAlphaLower(ch);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsAsciiAlphaLower_WhenCharacterIsDigit_ReturnsFalse() {
        // Arrange
        char ch = '3';

        // Act
        boolean result = CharUtils.isAsciiAlphaLower(ch);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsAsciiAlphaLower_WhenCharacterIsSpecialCharacter_ReturnsFalse() {
        // Arrange
        char ch = '-';

        // Act
        boolean result = CharUtils.isAsciiAlphaLower(ch);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsAsciiAlphaLower_WhenCharacterIsLineFeed_ReturnsFalse() {
        // Arrange
        char ch = '\n';

        // Act
        boolean result = CharUtils.isAsciiAlphaLower(ch);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsAsciiAlphanumeric_ReturnsTrueForLowercaseLetters() {
        // Arrange
        char ch = 'a';

        // Act
        boolean result = CharUtils.isAsciiAlphanumeric(ch);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAsciiAlphanumeric_ReturnsTrueForUppercaseLetters() {
        // Arrange
        char ch = 'A';

        // Act
        boolean result = CharUtils.isAsciiAlphanumeric(ch);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAsciiAlphanumeric_ReturnsTrueForNumbers() {
        // Arrange
        char ch = '3';

        // Act
        boolean result = CharUtils.isAsciiAlphanumeric(ch);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAsciiAlphanumeric_ReturnsFalseForNonAlphanumericCharacters() {
        // Arrange
        char ch = '-';

        // Act
        boolean result = CharUtils.isAsciiAlphanumeric(ch);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsAsciiAlphanumeric_ReturnsFalseForLinefeedCharacter() {
        // Arrange
        char ch = '\n';

        // Act
        boolean result = CharUtils.isAsciiAlphanumeric(ch);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsAsciiNumeric() {
        // Test when ch is a digit
        assertTrue(CharUtils.isAsciiNumeric('0'));
        assertTrue(CharUtils.isAsciiNumeric('9'));

        // Test when ch is not a digit
        assertFalse(CharUtils.isAsciiNumeric('a'));
        assertFalse(CharUtils.isAsciiNumeric('A'));
        assertFalse(CharUtils.isAsciiNumeric('-'));
        assertFalse(CharUtils.isAsciiNumeric('\n'));
        assertFalse(CharUtils.isAsciiNumeric('&'));
        assertFalse(CharUtils.isAsciiNumeric('\u00a9'));
    }

    @Test
    public void testIsAscii_lowerCaseLetter() {
        // Instantiate all necessary variables here
        char ch = 'a';

        // Write the test code here following the given rules
        boolean actualResult = CharUtils.isAscii(ch);

        assertTrue(actualResult);
    }

    @Test
    public void testIsAscii_upperCaseLetter() {
        // Instantiate all necessary variables here
        char ch = 'A';

        // Write the test code here following the given rules
        boolean actualResult = CharUtils.isAscii(ch);

        assertTrue(actualResult);
    }

    @Test
    public void testIsAscii_digit() {
        // Instantiate all necessary variables here
        char ch = '3';

        // Write the test code here following the given rules
        boolean actualResult = CharUtils.isAscii(ch);

        assertTrue(actualResult);
    }

    @Test
    public void testIsAscii_specialCharacter() {
        // Instantiate all necessary variables here
        char ch = '-';

        // Write the test code here following the given rules
        boolean actualResult = CharUtils.isAscii(ch);

        assertTrue(actualResult);
    }

    @Test
    public void testIsAscii_linefeedCharacter() {
        // Instantiate all necessary variables here
        char ch = '\n';

        // Write the test code here following the given rules
        boolean actualResult = CharUtils.isAscii(ch);

        assertTrue(actualResult);
    }

    @Test
    public void testIsAscii_edgeCase() {
        // Instantiate all necessary variables here
        char ch = (char) 128;

        // Write the test code here following the given rules
        boolean actualResult = CharUtils.isAscii(ch);

        assertFalse(actualResult);
    }

}