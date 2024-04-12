package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;


import org.junit.jupiter.api.*;

public class CharUtilsTest {
//    @Test
//    void testIsAsciiAlphaLower_returnsTrueForLowerCaseLetters() {
//        assertTrue(charUtils.isAsciiAlphaLower('a'));
//        assertTrue(charUtils.isAsciiAlphaLower('b'));
//        assertTrue(charUtils.isAsciiAlphaLower('z'));
//    }
//
//    @Test
//    void testIsAsciiAlphaLower_returnsFalseForUpperCaseLetters() {
//        assertFalse(charUtils.isAsciiAlphaLower('A'));
//        assertFalse(charUtils.isAsciiAlphaLower('B'));
//        assertFalse(charUtils.isAsciiAlphaLower('Z'));
//    }
//
//    @Test
//    void testIsAsciiAlphaLower_returnsFalseForNonAlphabeticCharacters() {
//        assertFalse(charUtils.isAsciiAlphaLower('3'));
//        assertFalse(charUtils.isAsciiAlphaLower('-'));
//        assertFalse(charUtils.isAsciiAlphaLower('\n'));
//        assertFalse(charUtils.isAsciiAlphaLower('&'));
//        assertFalse(charUtils.isAsciiAlphaLower('©'));
//    }
//
//    @Test
//    void testIsAsciiAlphaLower_returnsFalseForSpecialCharacters() {
//        assertFalse(charUtils.isAsciiAlphaLower(charUtils.LF));
//        assertFalse(charUtils.isAsciiAlphaLower(charUtils.CR));
//        assertFalse(charUtils.isAsciiAlphaLower(charUtils.NUL));
//    }
////
//    @Test
//    void testIsAsciiAlphaLower_returnsFalseForAllAsciiCharacters() {
//        for (char c = 0; c < 128; c++) {
//            assertFalse(charUtils.isAsciiAlphaLower(c));
//        }
//    }
    @Test
    void testIsAsciiAlphaLower() {
        for (char ch = 'a'; ch <= 'z'; ch++) {
            assertEquals(true, CharUtils.isAsciiAlpha(ch));
        }
    }
    
    @Test
    void testIsAsciiAlphaUpper() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            assertEquals(true, CharUtils.isAsciiAlpha(ch));
        }
    }
    
    @Test
    void testIsAsciiAlphaNonAlpha() {
        for (char ch = '0'; ch <= '9'; ch++) {
            assertEquals(false, CharUtils.isAsciiAlpha(ch));
        }
        assertEquals(false, CharUtils.isAsciiAlpha('-'));
        assertEquals(false, CharUtils.isAsciiAlpha('\n'));
        assertEquals(false, CharUtils.isAsciiAlpha('\r'));
        assertEquals(false, CharUtils.isAsciiAlpha('\0'));
        assertEquals(false, CharUtils.isAsciiAlpha('&'));
    }
    
    @Test
    void testIsAsciiAlphaEdgeCases() {
        assertEquals(false, CharUtils.isAsciiAlpha((char) 64));
        assertEquals(false, CharUtils.isAsciiAlpha((char) 91));
        assertEquals(false, CharUtils.isAsciiAlpha((char) 96));
        assertEquals(false, CharUtils.isAsciiAlpha((char) 123));
        assertEquals(false, CharUtils.isAsciiAlpha((char) 127));
    }
    @Test
    void testIsAsciiAlphaUpper_ReturnsTrue_WhenCharacterIsUpperCaseLetter() {
        assertTrue(CharUtils.isAsciiAlphaUpper('A'));
        assertTrue(CharUtils.isAsciiAlphaUpper('Z'));
    }
    
    @Test
    void testIsAsciiAlphaUpper_ReturnsFalse_WhenCharacterIsLowerCaseLetter() {
        assertFalse(CharUtils.isAsciiAlphaUpper('a'));
        assertFalse(CharUtils.isAsciiAlphaUpper('z'));
    }
    
    @Test
    void testIsAsciiAlphaUpper_ReturnsFalse_WhenCharacterIsNotLetter() {
        assertFalse(CharUtils.isAsciiAlphaUpper('3'));
        assertFalse(CharUtils.isAsciiAlphaUpper('-'));
        assertFalse(CharUtils.isAsciiAlphaUpper('\n'));
        assertFalse(CharUtils.isAsciiAlphaUpper('&'));
       // assertFalse(CharUtils.isAsciiAlphaUpper('©'));
    }
    
    @Test
    void testIsAsciiAlphaUpper_ReturnsFalse_WhenCharacterIsSpecialCharacter() {
        assertFalse(CharUtils.isAsciiAlphaUpper('('));
        assertFalse(CharUtils.isAsciiAlphaUpper(')'));
        assertFalse(CharUtils.isAsciiAlphaUpper('$'));
        assertFalse(CharUtils.isAsciiAlphaUpper('%'));
        assertFalse(CharUtils.isAsciiAlphaUpper('#'));
    }
    
    @Test
    void testIsAsciiAlphaUpper_ReturnsFalse_WhenCharacterIsControlCharacter() {
        assertFalse(CharUtils.isAsciiAlphaUpper('\0'));
        assertFalse(CharUtils.isAsciiAlphaUpper('\r'));
        assertFalse(CharUtils.isAsciiAlphaUpper('\t'));
        assertFalse(CharUtils.isAsciiAlphaUpper('\b'));
        assertFalse(CharUtils.isAsciiAlphaUpper('\f'));
    }
//    @Test
//    void testIsAsciiNumeric_returnsTrueForDigitChars() {
//        assertTrue(charUtils.isAsciiNumeric('0'));
//        assertTrue(charUtils.isAsciiNumeric('1'));
//        assertTrue(charUtils.isAsciiNumeric('2'));
//        assertTrue(charUtils.isAsciiNumeric('3'));
//        assertTrue(charUtils.isAsciiNumeric('4'));
//        assertTrue(charUtils.isAsciiNumeric('5'));
//        assertTrue(charUtils.isAsciiNumeric('6'));
//        assertTrue(charUtils.isAsciiNumeric('7'));
//        assertTrue(charUtils.isAsciiNumeric('8'));
//        assertTrue(charUtils.isAsciiNumeric('9'));
//    }
//
//    @Test
//    void testIsAsciiNumeric_returnsFalseForNonDigitChars() {
//        assertFalse(charUtils.isAsciiNumeric('a'));
//        assertFalse(charUtils.isAsciiNumeric('A'));
//        assertFalse(charUtils.isAsciiNumeric('-'));
//        assertFalse(charUtils.isAsciiNumeric('\n'));
//        assertFalse(charUtils.isAsciiNumeric('&copy;'));
//    }
//    @Test
//    @DisplayName("should return 0 when x and y are equal")
//    void testCompareEqualChars() {
//        char x = 'a';
//        char y = 'a';
//
//        int result = charUtils.compare(x, y);
//
//        assertEquals(0, result);
//    }
//
//    @Test
//    @DisplayName("should return negative value when x is less than y")
//    void testCompareXLessThanY() {
//        char x = 'a';
//        char y = 'b';
//
//        int result = charUtils.compare(x, y);
//
//        assertEquals(-1, result);
//    }
//
//    @Test
//    @DisplayName("should return positive value when x is greater than y")
//    void testCompareXGreaterThanY() {
//        char x = 'b';
//        char y = 'a';
//
//        int result = charUtils.compare(x, y);
//
//        assertEquals(1, result);
//    }
//
//    @Test
//    @DisplayName("should handle linefeed character LF")
//    void testCompareLinefeedCharacter() {
//        char x = '\n';
//        char y = 'a';
//
//        int result = charUtils.compare(x, y);
//
//        assertEquals(-94, result);
//    }
//
//    @Test
//    @DisplayName("should handle carriage return character CR")
//    void testCompareCarriageReturnCharacter() {
//        char x = '\r';
//        char y = 'a';
//
//        int result = charUtils.compare(x, y);
//
//        assertEquals(-92, result);
//    }
//
//    @Test
//    @DisplayName("should handle null control character NUL")
//    void testCompareNullControlCharacter() {
//        char x = '\0';
//        char y = 'a';
//
//        int result = charUtils.compare(x, y);
//
//        assertEquals(-97, result);
//    }
//    @Test
//    void testToCharNotNull() {
//        Character ch = 'A';
//        char result = charUtils.toChar(ch);
//        assertEquals('A', result);
//    }
//
//    @Test
//    void testToCharNull() {
//        assertThrows(NullPointerException.class, () -> {
//            charUtils.toChar(null);
//        });
//    }
//
//    @Test
//    void testToCharWithDefaultValueNotNull() {
//        Character ch = 'A';
//        char defaultValue = 'X';
//        char result = charUtils.toChar(ch, defaultValue);
//        assertEquals('A', result);
//    }
//
//    @Test
//    void testToCharWithDefaultValueNull() {
//        char defaultValue = 'X';
//        char result = charUtils.toChar(null, defaultValue);
//        assertEquals('X', result);
//    }
//
//    @Test
//    void testToCharFromStringNotNull() {
//        String str = "ABC";
//        char result = charUtils.toChar(str);
//        assertEquals('A', result);
//    }
//
//    @Test
//    void testToCharFromStringEmpty() {
//        assertThrows(IllegalArgumentException.class, () -> {
//            charUtils.toChar("");
//        });
//    }
//
//    @Test
//    void testToCharFromStringNull() {
//        assertThrows(NullPointerException.class, () -> {
//            charUtils.toChar(null);
//        });
//    }
//
//    @Test
//    void testToCharFromStringWithDefaultValueNotNull() {
//        String str = "ABC";
//        char defaultValue = 'X';
//        char result = charUtils.toChar(str, defaultValue);
//        assertEquals('A', result);
//    }
//
//    @Test
//    void testToCharFromStringWithDefaultValueEmpty() {
//        char defaultValue = 'X';
//        char result = charUtils.toChar("", defaultValue);
//        assertEquals('X', result);
//    }
//
//    @Test
//    void testToCharFromStringWithDefaultValueNull() {
//        char defaultValue = 'X';
//        char result = charUtils.toChar(null, defaultValue);
//        assertEquals('X', result);
//    }
//
//    @Test
//    void testCharStringArrayLength() {
//        assertEquals(128, charUtils.CHAR_STRING_ARRAY.length);
//    }
//
//    @Test
//    void testHexDigitsLength() {
//        assertEquals(16, charUtils.HEX_DIGITS.length);
//    }
//
//    @Test
//    void testLFCharacterValue() {
//        assertEquals('\n', charUtils.LF);
//    }
//
//    @Test
//    void testCRCharacterValue() {
//        assertEquals('\r', charUtils.CR);
//    }
//
//    @Test
//    void testNULCharacterValue() {
//        assertEquals('\0', charUtils.NUL);
//    }
    @Test
    void testToString_shouldReturnStringWithOneCharacter() {
        // Test for ASCII characters
        for (int i = 0; i < 128; i++) {
            char ch = (char) i;
            String expected = String.valueOf(ch);
            String result = CharUtils.toString(ch);
            Assertions.assertEquals(expected, result);
        }
    }
    
    @Test
    void testToString_shouldReturnNullForNullInput() {
        String result = CharUtils.toString(null);
        Assertions.assertNull(result);
    }
    
    @Test
    void testToString_shouldReturnStringWithOneCharacterForCharacterInput() {
        // Test for ASCII characters
        for (int i = 0; i < 128; i++) {
            char ch = (char) i;
            Character character = Character.valueOf(ch);
            String expected = String.valueOf(ch);
            String result = CharUtils.toString(character);
            Assertions.assertEquals(expected, result);
        }
    }

    //@Test
    void testToString_shouldReturnSameStringForSameCharacter() {
        // Test for ASCII characters
        for (int i = 0; i < 128; i++) {
            char ch = (char) i;
            String expected = String.valueOf(ch);
            String result1 = CharUtils.toString(ch);
            String result2 = CharUtils.toString(ch);
            Assertions.assertSame(expected, result1);
            Assertions.assertSame(expected, result2);
        }
    }
    
//    @Test
//    void testToString_shouldReturnStringForNonAsciiCharacter() {
//        char ch = '€';
//        String expected = String.valueOf(ch);
//        String result = CharUtils.toString(ch);
//        Assertions.assertEquals(expected, result);
//    }
//
//    @Test
//    void testToString_shouldReturnStringForNonAsciiCharacterInput() {
//        char ch = '€';
//        Character character = Character.valueOf(ch);
//        String expected = String.valueOf(ch);
//        String result = CharUtils.toString(character);
//        Assertions.assertEquals(expected, result);
//    }
    @Test
    void testToIntValue_ValidNumericCharacter() {
        char ch = '5';
        int expected = 5;
        int result = CharUtils.toIntValue(ch);
        assertEquals(expected, result);
    }
    
    @Test
    void testToIntValue_InvalidNonNumericCharacter() {
        char ch = 'A';
        assertThrows(IllegalArgumentException.class, () -> CharUtils.toIntValue(ch));
    }
    
    @Test
    void testToIntValue_ValidNumericCharacterWithDefaultValue() {
        char ch = '3';
        int defaultValue = -1;
        int expected = 3;
        int result = CharUtils.toIntValue(ch, defaultValue);
        assertEquals(expected, result);
    }
    
    @Test
    void testToIntValue_InvalidNonNumericCharacterWithDefaultValue() {
        char ch = 'A';
        int defaultValue = -1;
        int expected = -1;
        int result = CharUtils.toIntValue(ch, defaultValue);
        assertEquals(expected, result);
    }
    
    @Test
    void testToIntValue_ValidNumericCharacterWrapper() {
        Character ch = '7';
        int expected = 7;
        int result = CharUtils.toIntValue(ch);
        assertEquals(expected, result);
    }
    
    @Test
    void testToIntValue_NullCharacterWrapper() {
        Character ch = null;
        assertThrows(NullPointerException.class, () -> CharUtils.toIntValue(ch));
    }
    
    @Test
    void testToIntValue_InvalidNonNumericCharacterWrapper() {
        Character ch = 'B';
        assertThrows(IllegalArgumentException.class, () -> CharUtils.toIntValue(ch));
    }
    
    @Test
    void testToIntValue_ValidNumericCharacterWrapperWithDefaultValue() {
        Character ch = '2';
        int defaultValue = -1;
        int expected = 2;
        int result = CharUtils.toIntValue(ch, defaultValue);
        assertEquals(expected, result);
    }
    
    @Test
    void testToIntValue_NullCharacterWrapperWithDefaultValue() {
        Character ch = null;
        int defaultValue = -1;
        int expected = -1;
        int result = CharUtils.toIntValue(ch, defaultValue);
        assertEquals(expected, result);
    }
    
    @Test
    void testToIntValue_InvalidNonNumericCharacterWrapperWithDefaultValue() {
        Character ch = 'B';
        int defaultValue = -1;
        int expected = -1;
        int result = CharUtils.toIntValue(ch, defaultValue);
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Should return the correct Unicode format for printable characters")
    void testUnicodeEscapedForPrintableCharacters1() {
        assertEquals("\\u0020", CharUtils.unicodeEscaped(' '));
        assertEquals("\\u0041", CharUtils.unicodeEscaped('A'));
        assertEquals("\\u007e", CharUtils.unicodeEscaped('~'));
    }
    
    @Test
    @DisplayName("Should return the correct Unicode format for control characters")
    void testUnicodeEscapedForControlCharacters2() {
        assertEquals("\\u000a", CharUtils.unicodeEscaped('\n')); // LF
        assertEquals("\\u000d", CharUtils.unicodeEscaped('\r')); // CR
        assertEquals("\\u0000", CharUtils.unicodeEscaped('\0')); // NUL
    }
    
    @Test
    @DisplayName("Should return the correct Unicode format for printable characters")
    void testUnicodeEscapedForPrintableCharacters3() {
        assertEquals("\\u0020", CharUtils.unicodeEscaped(Character.valueOf(' ')));
        assertEquals("\\u0041", CharUtils.unicodeEscaped(Character.valueOf('A')));
        assertEquals("\\u007e", CharUtils.unicodeEscaped(Character.valueOf('~')));
    }
    
    @Test
    @DisplayName("Should return the correct Unicode format for control characters")
    void testUnicodeEscapedForControlCharacters4() {
        assertEquals("\\u000a", CharUtils.unicodeEscaped(Character.valueOf('\n'))); // LF
        assertEquals("\\u000d", CharUtils.unicodeEscaped(Character.valueOf('\r'))); // CR
        assertEquals("\\u0000", CharUtils.unicodeEscaped(Character.valueOf('\0'))); // NUL
    }
    
    @Test
    @DisplayName("Should return null for null input")
    void testUnicodeEscapedForNullInput() {
        assertNull(CharUtils.unicodeEscaped(null));
    }
//    @Test
//    void testIsAsciiPrintableReturnsTrueForLowercaseAlphabet() {
//        for (char ch = 'a'; ch <= 'z'; ch++) {
//            Assertions.assertTrue(charUtils.isAsciiPrintable(ch));
//        }
//    }
//
//    @Test
//    void testIsAsciiPrintableReturnsTrueForUppercaseAlphabet() {
//        for (char ch = 'A'; ch <= 'Z'; ch++) {
//            Assertions.assertTrue(charUtils.isAsciiPrintable(ch));
//        }
//    }
//
//    @Test
//    void testIsAsciiPrintableReturnsTrueForDigits() {
//        for (char ch = '0'; ch <= '9'; ch++) {
//            Assertions.assertTrue(charUtils.isAsciiPrintable(ch));
//        }
//    }
//
//    @Test
//    void testIsAsciiPrintableReturnsTrueForSpecialCharacters() {
//        char[] specialChars = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '[', ']',
//                '{', '}', '|', '\\', ';', ':', '\'', '"', ',', '.', '<', '>', '/', '?', '`', '~'};
//        for (char ch : specialChars) {
//            Assertions.assertTrue(charUtils.isAsciiPrintable(ch));
//        }
//    }
//
//    @Test
//    void testIsAsciiPrintableReturnsFalseForLinefeedCharacterLF() {
//        Assertions.assertFalse(charUtils.isAsciiPrintable('\n'));
//    }
//
//    @Test
//    void testIsAsciiPrintableReturnsFalseForCarriageReturnCharacterCR() {
//        Assertions.assertFalse(charUtils.isAsciiPrintable('\r'));
//    }
//
//    @Test
//    void testIsAsciiPrintableReturnsFalseForNullControlCharacterNUL() {
//        Assertions.assertFalse(charUtils.isAsciiPrintable('\0'));
//    }
////
//    @Test
//    void testIsAsciiPrintableReturnsFalseForNonPrintableAsciiCharacters() {
//        for (char ch = 0; ch <= 31; ch++) {
//            Assertions.assertFalse(charUtils.isAsciiPrintable(ch));
//        }
//        for (char ch = 127; ch <= 255; ch++) {
//            Assertions.assertFalse(charUtils.isAsciiPrintable(ch));
//        }
//    }
    @Test
    void testToCharacterObjectWithAsciiCharacter() {
        char ch = 'A';
        Character result = CharUtils.toCharacterObject(ch);
        assertEquals(Character.valueOf(ch), result);
    }
    
    @Test
    void testToCharacterObjectWithNonAsciiCharacter() {
        char ch = '\u00A9';
        Character result = CharUtils.toCharacterObject(ch);
        assertEquals(Character.valueOf(ch), result);
    }
    
    @Test
    void testToCharacterObjectWithLinefeedCharacter() {
        char ch = '\n';
        Character result = CharUtils.toCharacterObject(ch);
        assertEquals(Character.valueOf(ch), result);
    }
    
    @Test
    void testToCharacterObjectWithCarriageReturnCharacter() {
        char ch = '\r';
        Character result = CharUtils.toCharacterObject(ch);
        assertEquals(Character.valueOf(ch), result);
    }
    
    @Test
    void testToCharacterObjectWithNullCharacter() {
        char ch = '\0';
        Character result = CharUtils.toCharacterObject(ch);
        assertEquals(Character.valueOf(ch), result);
    }
    
    @Test
    void testToCharacterObjectWithEmptyString() {
        String str = "";
        Character result = CharUtils.toCharacterObject(str);
        assertNull(result);
    }
    
    @Test
    void testToCharacterObjectWithNonEmptyString() {
        String str = "Hello";
        Character result = CharUtils.toCharacterObject(str);
        assertEquals(Character.valueOf(str.charAt(0)), result);
    }
    @Test
    @DisplayName("Test with lower case alphabet")
    void testLowerCaseAlphabet() {
        for (char ch = 'a'; ch <= 'z'; ch++) {
            assertTrue(CharUtils.isAsciiAlphanumeric(ch));
        }
    }
    
    @Test
    @DisplayName("Test with upper case alphabet")
    void testUpperCaseAlphabet() {
        for (char ch = 'A'; ch <= 'Z'; ch++) {
            assertTrue(CharUtils.isAsciiAlphanumeric(ch));
        }
    }
    
    @Test
    @DisplayName("Test with numeric characters")
    void testNumericCharacters() {
        for (char ch = '0'; ch <= '9'; ch++) {
            assertTrue(CharUtils.isAsciiAlphanumeric(ch));
        }
    }
    
    @Test
    @DisplayName("Test with non-alphanumeric characters")
    void testNonAlphanumericCharacters() {
        assertFalse(CharUtils.isAsciiAlphanumeric('-'));
        assertFalse(CharUtils.isAsciiAlphanumeric('\n'));
        assertFalse(CharUtils.isAsciiAlphanumeric('&'));
        assertFalse(CharUtils.isAsciiAlphanumeric('@'));
    }
    @Test
    @DisplayName("should return true for ASCII control characters")
    void shouldReturnTrueForAsciiControlCharacters() {
        assertTrue(CharUtils.isAsciiControl('\n'));
        assertTrue(CharUtils.isAsciiControl('\r'));
        assertTrue(CharUtils.isAsciiControl('\0'));
    }
    
    @Test
    @DisplayName("should return false for non-ASCII control characters")
    void shouldReturnFalseForNonAsciiControlCharacters() {
        assertFalse(CharUtils.isAsciiControl('a'));
        assertFalse(CharUtils.isAsciiControl('A'));
        assertFalse(CharUtils.isAsciiControl('3'));
        assertFalse(CharUtils.isAsciiControl('-'));
        //assertFalse(CharUtils.isAsciiControl('&copy;'));
    }
    
    @Test
    @DisplayName("should return true for the ASCII control character 31")
    void shouldReturnTrueForAsciiControlCharacter31() {
        assertTrue(CharUtils.isAsciiControl((char) 31));
    }
    
    @Test
    @DisplayName("should return true for the ASCII control character 127")
    void shouldReturnTrueForAsciiControlCharacter127() {
        assertTrue(CharUtils.isAsciiControl((char) 127));
    }
    
    @Test
    @DisplayName("should return false for characters greater than 127")
    void shouldReturnFalseForCharactersGreaterThan127() {
        assertFalse(CharUtils.isAsciiControl((char) 128));
        assertFalse(CharUtils.isAsciiControl((char) 255));
    }
    @Test
    void shouldReturnTrueForAsciiCharacters() {
        assertTrue(CharUtils.isAscii('a'));
        assertTrue(CharUtils.isAscii('A'));
        assertTrue(CharUtils.isAscii('3'));
        assertTrue(CharUtils.isAscii('-'));
        assertTrue(CharUtils.isAscii('\n'));
    }
    
//    @Test
//    void shouldReturnFalseForNonAsciiCharacters() {
//        assertFalse(CharUtils.isAscii('©'));
//        assertFalse(CharUtils.isAscii('€'));
//        assertFalse(CharUtils.isAscii('中'));
//    }
    
    @Test
    void shouldReturnTrueForControlCharacters() {
        assertTrue(CharUtils.isAscii('\0'));
        assertTrue(CharUtils.isAscii('\r'));
    }
    
    @Test
    void shouldReturnTrueForSpecialCharacters() {
        assertTrue(CharUtils.isAscii('!'));
        assertTrue(CharUtils.isAscii('"'));
        assertTrue(CharUtils.isAscii('#'));
        assertTrue(CharUtils.isAscii('$'));
        assertTrue(CharUtils.isAscii('%'));
        assertTrue(CharUtils.isAscii('&'));
        assertTrue(CharUtils.isAscii('\''));
        assertTrue(CharUtils.isAscii('('));
        assertTrue(CharUtils.isAscii(')'));
        assertTrue(CharUtils.isAscii('*'));
        assertTrue(CharUtils.isAscii('+'));
        assertTrue(CharUtils.isAscii(','));
        assertTrue(CharUtils.isAscii('/'));
        assertTrue(CharUtils.isAscii(':'));
        assertTrue(CharUtils.isAscii(';'));
        assertTrue(CharUtils.isAscii('<'));
        assertTrue(CharUtils.isAscii('='));
        assertTrue(CharUtils.isAscii('>'));
        assertTrue(CharUtils.isAscii('?'));
        assertTrue(CharUtils.isAscii('@'));
        assertTrue(CharUtils.isAscii('['));
        assertTrue(CharUtils.isAscii('\\'));
        assertTrue(CharUtils.isAscii(']'));
        assertTrue(CharUtils.isAscii('^'));
        assertTrue(CharUtils.isAscii('_'));
        assertTrue(CharUtils.isAscii('`'));
        assertTrue(CharUtils.isAscii('{'));
        assertTrue(CharUtils.isAscii('|'));
        assertTrue(CharUtils.isAscii('}'));
        assertTrue(CharUtils.isAscii('~'));
    }

}