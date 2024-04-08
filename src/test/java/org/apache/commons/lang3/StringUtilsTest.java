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


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class StringUtilsTest {
    @Test
    void testTrimToNull_withNullString_shouldReturnNull() {
        String result = stringUtils.trimToNull(null);
        assertNull(result);
    }
    
    @Test
    void testTrimToNull_withEmptyString_shouldReturnNull() {
        String result = stringUtils.trimToNull("");
        assertNull(result);
    }
    
    @Test
    void testTrimToNull_withWhitespaceString_shouldReturnNull() {
        String result = stringUtils.trimToNull("     ");
        assertNull(result);
    }
    
    @Test
    void testTrimToNull_withNonEmptyString_shouldReturnTrimmedString() {
        String result = stringUtils.trimToNull("abc");
        assertEquals("abc", result);
    }
    
    @Test
    void testTrimToNull_withNonEmptyStringWithWhitespace_shouldReturnTrimmedString() {
        String result = stringUtils.trimToNull("    abc    ");
        assertEquals("abc", result);
    }
    
    @Test
    void testTrimToNull_withStringContainingControlCharacters_shouldReturnNull() {
        String result = stringUtils.trimToNull("\nabc\r");
        assertNull(result);
    }
    @Test
    void testRightWithNullString() {
        String result = stringUtils.right(null, 3);
        assertNull(result);
    }
    
    @Test
    void testRightWithNegativeLength() {
        String result = stringUtils.right("abc", -1);
        assertEquals("", result);
    }
    
    @Test
    void testRightWithEmptyString() {
        String result = stringUtils.right("", 2);
        assertEquals("", result);
    }
    
    @Test
    void testRightWithLengthZero() {
        String result = stringUtils.right("abc", 0);
        assertEquals("", result);
    }
    
    @Test
    void testRightWithLengthGreaterThanStringSize() {
        String result = stringUtils.right("abc", 4);
        assertEquals("abc", result);
    }
    
    @Test
    void testRightWithValidInput() {
        String result = stringUtils.right("abc", 2);
        assertEquals("bc", result);
    }
    import static org.junit.jupiter.api.Assertions.assertEquals;
    import static org.junit.jupiter.api.Assertions.assertNull;
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Test;
    
    class StringUtilsTest {
    
        @Test
        @DisplayName("Test split with null input")
        void testSplitWithNullInput() {
            assertNull(StringUtils.split(null));
        }
    
        @Test
        @DisplayName("Test split with empty string input")
        void testSplitWithEmptyStringInput() {
            assertEquals(0, StringUtils.split("").length);
        }
    
        @Test
        @DisplayName("Test split with null input and separator")
        void testSplitWithNullInputAndSeparator() {
            assertNull(StringUtils.split(null, ' '));
        }
    
        @Test
        @DisplayName("Test split with empty string input and separator")
        void testSplitWithEmptyStringInputAndSeparator() {
            assertEquals(0, StringUtils.split("", ' ').length);
        }
    
        @Test
        @DisplayName("Test split with null input and separatorChars")
        void testSplitWithNullInputAndSeparatorChars() {
            assertNull(StringUtils.split(null, null));
        }
    
        @Test
        @DisplayName("Test split with empty string input and separatorChars")
        void testSplitWithEmptyStringInputAndSeparatorChars() {
            assertEquals(0, StringUtils.split("", null).length);
        }
    
        @Test
        @DisplayName("Test split with null input, separatorChars, and max")
        void testSplitWithNullInputAndSeparatorCharsAndMax() {
            assertNull(StringUtils.split(null, null, 0));
        }
    
        @Test
        @DisplayName("Test split with empty string input, separatorChars, and max")
        void testSplitWithEmptyStringInputAndSeparatorCharsAndMax() {
            assertEquals(0, StringUtils.split("", null, 0).length);
        }
    
    }
    import static org.junit.jupiter.api.Assertions.*;
    
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Nested;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class StringUtilsTestSuite {
    
        @Nested
        @DisplayName("isAlpha method")
        class IsAlphaTests {
    
            @Test
            @DisplayName("Should return true for alphabetic strings")
            void shouldReturnTrueForAlphabeticStrings() {
                assertTrue(StringUtils.isAlpha("abc"));
                assertTrue(StringUtils.isAlpha("ABC"));
                assertTrue(StringUtils.isAlpha("abcdefghijklmnopqrstuvwxyz"));
                assertTrue(StringUtils.isAlpha("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
            }
    
            @Test
            @DisplayName("Should return false for non-alphabetic strings")
            void shouldReturnFalseForNonAlphabeticStrings() {
                assertFalse(StringUtils.isAlpha(""));
                assertFalse(StringUtils.isAlpha(" "));
                assertFalse(StringUtils.isAlpha("123"));
                assertFalse(StringUtils.isAlpha("abc1"));
                assertFalse(StringUtils.isAlpha("abc!"));
                assertFalse(StringUtils.isAlpha("abc@"));
                assertFalse(StringUtils.isAlpha("abc#"));
                assertFalse(StringUtils.isAlpha("abc$"));
                assertFalse(StringUtils.isAlpha("abc%"));
                assertFalse(StringUtils.isAlpha("abc^"));
                assertFalse(StringUtils.isAlpha("abc&"));
                assertFalse(StringUtils.isAlpha("abc*"));
                assertFalse(StringUtils.isAlpha("abc("));
                assertFalse(StringUtils.isAlpha("abc)"));
                assertFalse(StringUtils.isAlpha("abc-"));
                assertFalse(StringUtils.isAlpha("abc_"));
                assertFalse(StringUtils.isAlpha("abc="));
                assertFalse(StringUtils.isAlpha("abc+"));
                assertFalse(StringUtils.isAlpha("abc["));
                assertFalse(StringUtils.isAlpha("abc]"));
                assertFalse(StringUtils.isAlpha("abc{"));
                assertFalse(StringUtils.isAlpha("abc}"));
                assertFalse(StringUtils.isAlpha("abc|"));
                assertFalse(StringUtils.isAlpha("abc\\"));
                assertFalse(StringUtils.isAlpha("abc;"));
                assertFalse(StringUtils.isAlpha("abc:"));
                assertFalse(StringUtils.isAlpha("abc'"));
                assertFalse(StringUtils.isAlpha("abc\""));
                assertFalse(StringUtils.isAlpha("abc<"));
                assertFalse(StringUtils.isAlpha("abc>"));
                assertFalse(StringUtils.isAlpha("abc,"));
                assertFalse(StringUtils.isAlpha("abc."));
                assertFalse(StringUtils.isAlpha("abc/"));
                assertFalse(StringUtils.isAlpha("abc?"));
            }
    
            @Test
            @DisplayName("Should return false for null input")
            void shouldReturnFalseForNullInput() {
                assertFalse(StringUtils.isAlpha(null));
            }
    
            @Test
            @DisplayName("Should return false for CharSequence with length 0")
            void shouldReturnFalseForEmptyCharSequence() {
                assertFalse(StringUtils.isAlpha(""));
            }
    
            @Test
            @DisplayName("Should return true for alphabetic strings with whitespace")
            void shouldReturnTrueForAlphabeticStringsWithWhitespace() {
                assertTrue(StringUtils.isAlpha("abc def"));
                assertTrue(StringUtils.isAlpha("ABC DEF"));
                assertTrue(StringUtils.isAlpha("abc def ghi"));
                assertTrue(StringUtils.isAlpha("ABC DEF GHI"));
            }
    
            @Test
            @DisplayName("Should return false for non-alphabetic strings with whitespace")
            void shouldReturnFalseForNonAlphabeticStringsWithWhitespace() {
                assertFalse(StringUtils.isAlpha("123 abc"));
                assertFalse(StringUtils.isAlpha("abc 1"));
                assertFalse(StringUtils.isAlpha("abc! def"));
                assertFalse(StringUtils.isAlpha("abc @def"));
                assertFalse(StringUtils.isAlpha("abc#def"));
                assertFalse(StringUtils.isAlpha("abc$def"));
                assertFalse(StringUtils.isAlpha("abc%def"));
                assertFalse(StringUtils.isAlpha("abc^def"));
                assertFalse(StringUtils.isAlpha("abc&def"));
                assertFalse(StringUtils.isAlpha("abc*def"));
                assertFalse(StringUtils.isAlpha("abc(def"));
                assertFalse(StringUtils.isAlpha("abc)def"));
                assertFalse(StringUtils.isAlpha("abc-def"));
                assertFalse(StringUtils.isAlpha("abc_def"));
                assertFalse(StringUtils.isAlpha("abc=def"));
                assertFalse(StringUtils.isAlpha("abc+def"));
                assertFalse(StringUtils.isAlpha("abc[def"));
                assertFalse(StringUtils.isAlpha("abc]def"));
                assertFalse(StringUtils.isAlpha("abc{def"));
                assertFalse(StringUtils.isAlpha("abc}def"));
                assertFalse(StringUtils.isAlpha("abc|def"));
                assertFalse(StringUtils.isAlpha("abc\\def"));
                assertFalse(StringUtils.isAlpha("abc;def"));
                assertFalse(StringUtils.isAlpha("abc:def"));
                assertFalse(StringUtils.isAlpha("abc'def"));
                assertFalse(StringUtils.isAlpha("abc\"def"));
                assertFalse(StringUtils.isAlpha("abc<def"));
                assertFalse(StringUtils.isAlpha("abc>def"));
                assertFalse(StringUtils.isAlpha("abc,def"));
                assertFalse(StringUtils.isAlpha("abc.def"));
                assertFalse(StringUtils.isAlpha("abc/def"));
                assertFalse(StringUtils.isAlpha("abc?def"));
            }
        }
    }
    
    import org.junit.jupiter.api.Assertions;
    import org.junit.jupiter.api.Test;
    
    public class StringUtilsTestSuite {
    
        @Test
        public void testGetLevenshteinDistance_NullString_ShouldThrowIllegalArgumentException() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                StringUtils.getLevenshteinDistance(null, "test");
            });
        }
    
        @Test
        public void testGetLevenshteinDistance_EmptyString_ShouldReturnZero() {
            int distance = StringUtils.getLevenshteinDistance("", "");
            Assertions.assertEquals(0, distance);
        }
    
        @Test
        public void testGetLevenshteinDistance_SameString_ShouldReturnZero() {
            int distance = StringUtils.getLevenshteinDistance("test", "test");
            Assertions.assertEquals(0, distance);
        }
    
        @Test
        public void testGetLevenshteinDistance_OneEmptyString_ShouldReturnLengthOfNonEmptyString() {
            int distance = StringUtils.getLevenshteinDistance("", "test");
            Assertions.assertEquals(4, distance);
    
            distance = StringUtils.getLevenshteinDistance("test", "");
            Assertions.assertEquals(4, distance);
        }
    
        @Test
        public void testGetLevenshteinDistance_DifferentLengthStrings_ShouldReturnCorrectDistance() {
            int distance = StringUtils.getLevenshteinDistance("test", "text");
            Assertions.assertEquals(1, distance);
    
            distance = StringUtils.getLevenshteinDistance("hello", "hallo");
            Assertions.assertEquals(1, distance);
    
            distance = StringUtils.getLevenshteinDistance("elephant", "hippo");
            Assertions.assertEquals(7, distance);
    
            distance = StringUtils.getLevenshteinDistance("hippo", "elephant");
            Assertions.assertEquals(7, distance);
        }
    
        @Test
        public void testGetLevenshteinDistance_ThresholdExceeded_ShouldReturnNegativeOne() {
            int distance = StringUtils.getLevenshteinDistance("test", "text", 0);
            Assertions.assertEquals(-1, distance);
    
            distance = StringUtils.getLevenshteinDistance("elephant", "hippo", 6);
            Assertions.assertEquals(-1, distance);
        }
    
        @Test
        public void testGetLevenshteinDistance_ThresholdNotExceeded_ShouldReturnCorrectDistance() {
            int distance = StringUtils.getLevenshteinDistance("test", "text", 1);
            Assertions.assertEquals(1, distance);
    
            distance = StringUtils.getLevenshteinDistance("elephant", "hippo", 7);
            Assertions.assertEquals(7, distance);
        }
    }
    @Test
    void shouldReturnNull() {
        assertNull(stringUtils.firstNonEmpty(null));
    }
    
    @Test
    void shouldReturnNullWhenMultipleValues() {
        assertNull(stringUtils.firstNonEmpty(null, null, null));
    }
    
    @Test
    void shouldReturnNull() {
        assertNull(stringUtils.firstNonEmpty());
    }
    
    @Test
    void shouldReturnNull() {
        assertNull(stringUtils.firstNonEmpty("", "", ""));
    }
    
    @Test
    void shouldReturnFirstNonEmptyValue() {
        assertEquals("abc", stringUtils.firstNonEmpty("abc"));
        assertEquals("xyz", stringUtils.firstNonEmpty(null, "xyz"));
        assertEquals("xyz", stringUtils.firstNonEmpty("", "xyz"));
        assertEquals("xyz", stringUtils.firstNonEmpty(null, "xyz", "abc"));
    }
    import org.junit.jupiter.api.Test;
    
    @Test
    void testNormalizeSpace_shouldReturnEmptyString_whenInputIsNull() {
        assertNull(stringUtils.normalizeSpace(null));
    }
    
    @Test
    void testNormalizeSpace_shouldReturnEmptyString_whenInputIsEmptyString() {
        assertEquals("", stringUtils.normalizeSpace(""));
    }
    
    @Test
    void testNormalizeSpace_shouldReturnTrimmedString_whenInputHasLeadingAndTrailingWhitespace() {
        assertEquals("abc", stringUtils.normalizeSpace("   abc   "));
    }
    
    @Test
    void testNormalizeSpace_shouldReturnStringWithSingleSpace_whenInputHasMultipleWhitespaces() {
        assertEquals("a b c", stringUtils.normalizeSpace("a   b  c"));
    }
    
    @Test
    void testNormalizeSpace_shouldReturnStringWithNormalizedSpaces_whenInputHasDifferentWhitespaceCharacters() {
        assertEquals("a b c", stringUtils.normalizeSpace("a\tb\n\rc"));
    }
    
    @Test
    void testNormalizeSpace_shouldReturnStringWithNormalizedSpaces_whenInputHasNonBreakingSpaces() {
        assertEquals("a b c", stringUtils.normalizeSpace("a\u00A0b c"));
    }
    
    @Test
    void testNormalizeSpace_shouldReturnStringWithNoLeadingWhitespace_whenInputStartsWithWhitespace() {
        assertEquals("abc", stringUtils.normalizeSpace("  abc"));
    }
    
    @Test
    void testNormalizeSpace_shouldReturnStringWithNoTrailingWhitespace_whenInputEndsWithWhitespace() {
        assertEquals("abc", stringUtils.normalizeSpace("abc   "));
    }
    
    @Test
    void testNormalizeSpace_shouldReturnStringWithNoLeadingOrTrailingWhitespace_whenInputIsAlreadyTrimmed() {
        assertEquals("abc", stringUtils.normalizeSpace("abc"));
    }
    
    @Test
    void testNormalizeSpace_shouldReturnStringWithNoLeadingOrTrailingWhitespace_whenInputHasOnlyWhitespace() {
        assertEquals("", stringUtils.normalizeSpace("   "));
    }
    
    @Test
    void testNormalizeSpace_shouldReturnStringWithNoLeadingOrTrailingWhitespace_whenInputHasOnlyWhitespaceAndNonBreakingSpaces() {
        assertEquals("", stringUtils.normalizeSpace("\t\n\r\u00A0"));
    }
    import org.junit.jupiter.api.Test;
    
    import static org.junit.jupiter.api.Assertions.*;
    
    class StringUtilsTest {
    
        private StringUtils stringUtils;
    
        @Test
        void isAllLowerCase_shouldReturnTrue_whenStringContainsOnlyLowerCaseLetters() {
            // Test implementation here
        }
    
        @Test
        void isAllLowerCase_shouldReturnFalse_whenStringContainsUpperCaseLetters() {
            // Test implementation here
        }
    
        @Test
        void isAllLowerCase_shouldReturnFalse_whenStringContainsWhitespaceAfterLowerCaseLetters() {
            // Test implementation here
        }
    
        @Test
        void isAllLowerCase_shouldReturnFalse_whenStringContainsNumbersAfterLowerCaseLetters() {
            // Test implementation here
        }
    
        @Test
        void isAllLowerCase_shouldReturnFalse_whenStringContainsSpecialCharactersAfterLowerCaseLetters() {
            // Test implementation here
        }
    
        @Test
        void isAllLowerCase_shouldReturnFalse_whenStringIsEmpty() {
            // Test implementation here
        }
    
        @Test
        void isAllLowerCase_shouldReturnFalse_whenStringIsNull() {
            // Test implementation here
        }
    }
    @Test
    void testSubstringBeforeLastNullString() {
        assertNull(stringUtils.substringBeforeLast(null, "a"));
    }
    
    @Test
    void testSubstringBeforeLastEmptyString() {
        assertEquals("", stringUtils.substringBeforeLast("", "a"));
    }
    
    @Test
    void testSubstringBeforeLastNullSeparator() {
        assertEquals("abc", stringUtils.substringBeforeLast("abc", null));
    }
    
    @Test
    void testSubstringBeforeLastEmptySeparator() {
        assertEquals("abc", stringUtils.substringBeforeLast("abc", ""));
    }
    
    @Test
    void testSubstringBeforeLastSeparatorNotFound() {
        assertEquals("abc", stringUtils.substringBeforeLast("abc", "d"));
    }
    
    @Test
    void testSubstringBeforeLastSeparatorAtBeginning() {
        assertEquals("", stringUtils.substringBeforeLast("abc", "a"));
    }
    
    @Test
    void testSubstringBeforeLastSeparatorAtEnd() {
        assertEquals("ab", stringUtils.substringBeforeLast("abc", "c"));
    }
    
    @Test
    void testSubstringBeforeLastSeparatorInMiddle() {
        assertEquals("abc", stringUtils.substringBeforeLast("abcd", "d"));
    }
    
    @Test
    void testSubstringBeforeLastMultipleSeparators() {
        assertEquals("abc", stringUtils.substringBeforeLast("abcabcabc", "c"));
    }
    @Test
    @DisplayName("Should return null")
    void shouldReturnNull() {
        // Arrange
        String str = null;
        int shift = 2;
    
        // Act
        String result = StringUtils.rotate(str, shift);
    
        // Assert
        Assertions.assertNull(result);
    }
    
    @Test
    @DisplayName("Should return empty string")
    void shouldReturnEmptyString() {
        // Arrange
        String str = "";
        int shift = 3;
    
        // Act
        String result = StringUtils.rotate(str, shift);
    
        // Assert
        Assertions.assertEquals("", result);
    }
    
    @Test
    @DisplayName("Should return the original string")
    void shouldReturnOriginalString() {
        // Arrange
        String str = "abcdefg";
        int shift = 0;
    
        // Act
        String result = StringUtils.rotate(str, shift);
    
        // Assert
        Assertions.assertEquals("abcdefg", result);
    }
    
    @Test
    @DisplayName("Should perform right circular shift")
    void shouldPerformRightCircularShift() {
        // Arrange
        String str = "abcdefg";
        int shift = 2;
    
        // Act
        String result = StringUtils.rotate(str, shift);
    
        // Assert
        Assertions.assertEquals("fgabcde", result);
    }
    
    @Test
    @DisplayName("Should perform left circular shift")
    void shouldPerformLeftCircularShift() {
        // Arrange
        String str = "abcdefg";
        int shift = -2;
    
        // Act
        String result = StringUtils.rotate(str, shift);
    
        // Assert
        Assertions.assertEquals("cdefgab", result);
    }
    
    @Test
    @DisplayName("Should perform circular shift with correct modulus")
    void shouldPerformCircularShiftWithModulus() {
        // Arrange
        String str = "abcdefg";
        int shift = 9;
    
        // Act
        String result = StringUtils.rotate(str, shift);
    
        // Assert
        Assertions.assertEquals("fgabcde", result);
    }
    
    @Test
    @DisplayName("Should perform circular shift with correct modulus")
    void shouldPerformCircularShiftWithModulus() {
        // Arrange
        String str = "abcdefg";
        int shift = -9;
    
        // Act
        String result = StringUtils.rotate(str, shift);
    
        // Assert
        Assertions.assertEquals("cdefgab", result);
    }
    @Test
    void testSplitByCharacterTypeCamelCase_NullInput_ReturnNull() {
        assertNull(StringUtils.splitByCharacterTypeCamelCase(null));
    }
    
    @Test
    void testSplitByCharacterTypeCamelCase_EmptyString_ReturnEmptyArray() {
        assertEquals(0, StringUtils.splitByCharacterTypeCamelCase("").length);
    }
    
    @Test
    void testSplitByCharacterTypeCamelCase_WhitespaceString_ReturnArrayWithWhitespace() {
        assertArrayEquals(new String[] { " " }, StringUtils.splitByCharacterTypeCamelCase(" "));
    }
    
    @Test
    void testSplitByCharacterTypeCamelCase_SingleWord_ReturnArrayWithSingleWord() {
        assertArrayEquals(new String[] { "word" }, StringUtils.splitByCharacterTypeCamelCase("word"));
    }
    
    @Test
    void testSplitByCharacterTypeCamelCase_MultipleWords_ReturnArrayWithWordsSeparatedByWhitespace() {
        assertArrayEquals(new String[] { "camel", " case" }, StringUtils.splitByCharacterTypeCamelCase("camel case"));
    }
    
    @Test
    void testSplitByCharacterTypeCamelCase_SingleUppercaseWord_ReturnArrayWithWordsSeparatedByUppercaseLetter() {
        assertArrayEquals(new String[] { "foo", "Bar" }, StringUtils.splitByCharacterTypeCamelCase("fooBar"));
    }
    
    @Test
    void testSplitByCharacterTypeCamelCase_WordWithNumbers_ReturnArrayWithWordsSeparatedByNumbers() {
        assertArrayEquals(new String[] { "foo", "200", "Bar" }, StringUtils.splitByCharacterTypeCamelCase("foo200Bar"));
    }
    
    @Test
    void testSplitByCharacterTypeCamelCase_WordWithSpecialCharacters_ReturnArrayWithWordsSeparatedBySpecialCharacters() {
        assertArrayEquals(new String[] { "ab", ":", "cd", ":", "ef" }, StringUtils.splitByCharacterTypeCamelCase("ab:cd:ef"));
    }
    
    @Test
    void testSplitByCharacterTypeCamelCase_WordWithAcronyms_ReturnArrayWithWordsSeparatedByAcronyms() {
        assertArrayEquals(new String[] { "ASF", "Rules" }, StringUtils.splitByCharacterTypeCamelCase("ASFRules"));
    }
    @Test
    void testRepeatCharZeroTimes() {
        assertEquals("", StringUtils.repeat('e', 0));
    }
    
    @Test
    void testRepeatCharThreeTimes() {
        assertEquals("eee", StringUtils.repeat('e', 3));
    }
    
    @Test
    void testRepeatCharNegativeTimes() {
        assertEquals("", StringUtils.repeat('e', -2));
    }
    
    @Test
    void testRepeatNullString() {
        assertEquals(null, StringUtils.repeat(null, 2));
    }
    
    @Test
    void testRepeatEmptyStringZeroTimes() {
        assertEquals("", StringUtils.repeat("", 0));
    }
    
    @Test
    void testRepeatEmptyStringTwoTimes() {
        assertEquals("", StringUtils.repeat("", 2));
    }
    
    @Test
    void testRepeatStringThreeTimes() {
        assertEquals("aaa", StringUtils.repeat("a", 3));
    }
    
    @Test
    void testRepeatStringTwoTimes() {
        assertEquals("abab", StringUtils.repeat("ab", 2));
    }
    
    @Test
    void testRepeatStringNegativeTimes() {
        assertEquals("", StringUtils.repeat("a", -2));
    }
    
    @Test
    void testRepeatNullStringWithNullSeparator() {
        assertEquals(null, StringUtils.repeat(null, null, 2));
    }
    
    @Test
    void testRepeatNullStringWithSeparator() {
        assertEquals(null, StringUtils.repeat(null, "x", 2));
    }
    
    @Test
    void testRepeatEmptyStringWithNullSeparator() {
        assertEquals("", StringUtils.repeat("", null, 0));
    }
    
    @Test
    void testRepeatEmptyStringWithEmptySeparator() {
        assertEquals("", StringUtils.repeat("", "", 2));
    }
    
    @Test
    void testRepeatEmptyStringWithSeparatorThreeTimes() {
        assertEquals("xx", StringUtils.repeat("", "x", 3));
    }
    
    @Test
    void testRepeatStringWithSeparatorThreeTimes() {
        assertEquals("?, ?, ?", StringUtils.repeat("?", ", ", 3));
    }
    @Test
    public void testIsNotBlank_Null_ReturnsFalse() {
        assertFalse(StringUtils.isNotBlank(null));
    }
    
    @Test
    public void testIsNotBlank_EmptyString_ReturnsFalse() {
        assertFalse(StringUtils.isNotBlank(""));
    }
    
    @Test
    public void testIsNotBlank_WhitespaceString_ReturnsFalse() {
        assertFalse(StringUtils.isNotBlank(" "));
    }
    
    @Test
    public void testIsNotBlank_NonEmptyString_ReturnsTrue() {
        assertTrue(StringUtils.isNotBlank("bob"));
    }
    
    @Test
    public void testIsNotBlank_WhitespaceSurroundedString_ReturnsTrue() {
        assertTrue(StringUtils.isNotBlank("  bob  "));
    }
    // Your Java code here
    
    @Test
    @DisplayName("Should return -1 when cs is null")
    void testIndexOfAnyChar_NullCS() {
        // Test implementation here
    }
    
    @Test
    @DisplayName("Should return -1 when searchChars is null")
    void testIndexOfAnyChar_NullSearchChars() {
        // Test implementation here
    }
    
    @Test
    @DisplayName("Should return -1 when cs is empty")
    void testIndexOfAnyChar_EmptyCS() {
        // Test implementation here
    }
    
    @Test
    @DisplayName("Should return -1 when searchChars is empty")
    void testIndexOfAnyChar_EmptySearchChars() {
        // Test implementation here
    }
    
    @Test
    @DisplayName("Should return -1 when cs does not contain any characters from searchChars")
    void testIndexOfAnyChar_NoMatch() {
        // Test implementation here
    }
    
    @Test
    @DisplayName("Should return the index of the first matching character when cs contains multiple characters from searchChars")
    void testIndexOfAnyChar_MultipleMatches() {
        // Test implementation here
    }
    
    @Test
    @DisplayName("Should return the index of the first matching character when cs contains a single character from searchChars")
    void testIndexOfAnyChar_SingleMatch() {
        // Test implementation here
    }
    
    @Test
    @DisplayName("Should return the index of the first matching character when cs contains a supplementary character")
    void testIndexOfAnyChar_SupplementaryCharacter() {
        // Test implementation here
    }
    
    @Test
    @DisplayName("Should return -1 when str is null")
    void testIndexOfAnyString_NullStr() {
        // Test implementation here
    }
    
    @Test
    @DisplayName("Should return -1 when searchStrs is null")
    void testIndexOfAnyString_NullSearchStrs() {
        // Test implementation here
    }
    
    @Test
    @DisplayName("Should return -1 when str is empty")
    void testIndexOfAnyString_EmptyStr() {
        // Test implementation here
    }
    
    @Test
    @DisplayName("Should return -1 when searchStrs is empty")
    void testIndexOfAnyString_EmptySearchStrs() {
        // Test implementation here
    }
    
    @Test
    @DisplayName("Should return -1 when str does not contain any substring from searchStrs")
    void testIndexOfAnyString_NoMatch() {
        // Test implementation here
    }
    
    @Test
    @DisplayName("Should return the index of the first matching substring when str contains multiple substrings from searchStrs")
    void testIndexOfAnyString_MultipleMatches() {
        // Test implementation here
    }
    
    @Test
    @DisplayName("Should return the index of the first matching substring when str contains a single substring from searchStrs")
    void testIndexOfAnyString_SingleMatch() {
        // Test implementation here
    }
    
    @Test
    @DisplayName("Should return the index of the first matching substring when str contains a supplementary character")
    void testIndexOfAnyString_SupplementaryCharacter() {
        // Test implementation here
    }
    
    @Test
    @DisplayName("Should return -1 when cs is null")
    void testIndexOfAnyString_NullCS() {
        // Test implementation here
    }
    
    @Test
    @DisplayName("Should return -1 when searchChars is null")
    void testIndexOfAnyString_NullSearchChars() {
        // Test implementation here
    }
    
    @Test
    @DisplayName("Should return -1 when cs is empty")
    void testIndexOfAnyString_EmptyCS() {
        // Test implementation here
    }
    
    @Test
    @DisplayName("Should return -1 when searchChars is empty")
    void testIndexOfAnyString_EmptySearchChars() {
        // Test implementation here
    }
    
    @Test
    @DisplayName("Should return -1 when cs does not contain any characters from searchChars")
    void testIndexOfAnyString_NoMatch() {
        // Test implementation here
    }
    
    @Test
    @DisplayName("Should return the index of the first matching character when cs contains multiple characters from searchChars")
    void testIndexOfAnyString_MultipleMatches() {
        // Test implementation here
    }
    
    @Test
    @DisplayName("Should return the index of the first matching character when cs contains a single character from searchChars")
    void testIndexOfAnyString_SingleMatch() {
        // Test implementation here
    }
    
    @Test
    @DisplayName("Should return the index of the first matching character when cs contains a supplementary character")
    void testIndexOfAnyString_SupplementaryCharacter() {
        // Test implementation here
    }
    @Test
    void testGetDigitsWithNullString() {
        String digits = stringUtils.getDigits(null);
        assertEquals(null, digits);
    }
    
    @Test
    void testGetDigitsWithEmptyString() {
        String digits = stringUtils.getDigits("");
        assertEquals("", digits);
    }
    
    @Test
    void testGetDigitsWithNoDigits() {
        String digits = stringUtils.getDigits("abc");
        assertEquals("", digits);
    }
    
    @Test
    void testGetDigitsWithDigitsAndSpecialCharacters() {
        String digits = stringUtils.getDigits("1000$");
        assertEquals("1000", digits);
    }
    
    @Test
    void testGetDigitsWithDigitsAndAlphabets() {
        String digits = stringUtils.getDigits("1123~45");
        assertEquals("112345", digits);
    }
    
    @Test
    void testGetDigitsWithPhoneNumber() {
        String digits = stringUtils.getDigits("(541) 754-3010");
        assertEquals("5417543010", digits);
    }
    
    @Test
    void testGetDigitsWithUnicodeDigits() {
        String digits = stringUtils.getDigits("\u0967\u0968\u0969");
        assertEquals("\u0967\u0968\u0969", digits);
    }
    @Test
    void testWrapIfMissing_withNullString_shouldReturnNull() {
        assertNull(StringUtils.wrapIfMissing(null, 'x'));
    }
    
    @Test
    void testWrapIfMissing_withEmptyString_shouldReturnEmptyString() {
        assertEquals("", StringUtils.wrapIfMissing("", 'x'));
    }
    
    @Test
    void testWrapIfMissing_withStringAlreadyWrapped_shouldReturnSameString() {
        String str = "abc";
        assertEquals(str, StringUtils.wrapIfMissing("x" + str + "x", 'x'));
    }
    
    @Test
    void testWrapIfMissing_withStringNotWrapped_shouldReturnWrappedString() {
        String str = "abc";
        assertEquals("x" + str + "x", StringUtils.wrapIfMissing(str, 'x'));
    }
    
    @Test
    void testWrapIfMissing_withStringWrappedOnStart_shouldReturnSameString() {
        String str = "abc";
        assertEquals(str, StringUtils.wrapIfMissing("x" + str, 'x'));
    }
    
    @Test
    void testWrapIfMissing_withStringWrappedOnEnd_shouldReturnSameString() {
        String str = "abc";
        assertEquals(str, StringUtils.wrapIfMissing(str + "x", 'x'));
    }
    
    @Test
    void testWrapIfMissing_withEmptyStringAndNullChar_shouldReturnEmptyString() {
        assertEquals("", StringUtils.wrapIfMissing("", '\0'));
    }
    
    @Test
    void testWrapIfMissing_withStringAndNullChar_shouldReturnSameString() {
        String str = "abc";
        assertEquals(str, StringUtils.wrapIfMissing(str, '\0'));
    }
    
    @Test
    void testWrapIfMissing_withNullString_shouldReturnNull() {
        assertNull(StringUtils.wrapIfMissing(null, "x"));
    }
    
    @Test
    void testWrapIfMissing_withEmptyString_shouldReturnEmptyString() {
        assertEquals("", StringUtils.wrapIfMissing("", "x"));
    }
    
    @Test
    void testWrapIfMissing_withStringAlreadyWrapped_shouldReturnSameString() {
        String str = "abc";
        assertEquals(str, StringUtils.wrapIfMissing("x" + str + "x", "x"));
    }
    
    @Test
    void testWrapIfMissing_withStringNotWrapped_shouldReturnWrappedString() {
        String str = "abc";
        assertEquals("x" + str + "x", StringUtils.wrapIfMissing(str, "x"));
    }
    
    @Test
    void testWrapIfMissing_withStringWrappedOnStart_shouldReturnSameString() {
        String str = "abc";
        assertEquals(str, StringUtils.wrapIfMissing("x" + str, "x"));
    }
    
    @Test
    void testWrapIfMissing_withStringWrappedOnEnd_shouldReturnSameString() {
        String str = "abc";
        assertEquals(str, StringUtils.wrapIfMissing(str + "x", "x"));
    }
    
    @Test
    void testWrapIfMissing_withStringAndNullWrapWith_shouldReturnSameString() {
        String str = "abc";
        assertEquals(str, StringUtils.wrapIfMissing(str, null));
    }
    
    @Test
    void testWrapIfMissing_withNullStringAndNonNullWrapWith_shouldReturnNull() {
        assertNull(StringUtils.wrapIfMissing(null, "x"));
    }
    @Test
    void testRemoveFirst() {
        // Test removing first occurrence of regex
        assertEquals("bc", StringUtils.removeFirst("abc", ".?"));
        assertEquals("ABCbc123", StringUtils.removeFirst("ABCabc123", "[a-z]"));
        assertEquals("ABC123abc", StringUtils.removeFirst("ABCabc123abc", "[a-z]+"));
    
        // Test removing empty string
        assertEquals(null, StringUtils.removeFirst(null, null));
        assertEquals("any", StringUtils.removeFirst("any", null));
        assertEquals("any", StringUtils.removeFirst("any", ""));
    
        // Test removing all occurrences of regex
        assertEquals("", StringUtils.removeFirst("any", ".*"));
        assertEquals("", StringUtils.removeFirst("any", ".+"));
    
        // Test removing regex with line breaks
        assertEquals("A\n&lt;__&gt;B", StringUtils.removeFirst("A&lt;__&gt;\n&lt;__&gt;B", "&lt;.*&gt;"));
        assertEquals("AB", StringUtils.removeFirst("A&lt;__&gt;\n&lt;__&gt;B", "(?s)&lt;.*&gt;"));
    }
    @Test
    @DisplayName("Should return null when source string is null")
    void testRemoveChar_NullSourceString() {
        String result = stringUtils.remove(null, 'a');
        assertNull(result);
    }
    
    @Test
    @DisplayName("Should return empty string when source string is empty")
    void testRemoveChar_EmptySourceString() {
        String result = stringUtils.remove("", 'a');
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Should return source string when remove char is not found")
    void testRemoveChar_CharNotFound() {
        String result = stringUtils.remove("queued", 'z');
        assertEquals("queued", result);
    }
    
    @Test
    @DisplayName("Should remove all occurrences of the remove char")
    void testRemoveChar_RemoveCharFound() {
        String result = stringUtils.remove("queued", 'u');
        assertEquals("qeed", result);
    }
    
    @Test
    @DisplayName("Should return null when source string is null")
    void testRemoveString_NullSourceString() {
        String result = stringUtils.remove(null, "ue");
        assertNull(result);
    }
    
    @Test
    @DisplayName("Should return empty string when source string is empty")
    void testRemoveString_EmptySourceString() {
        String result = stringUtils.remove("", "ue");
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Should return source string when remove string is null")
    void testRemoveString_NullRemoveString() {
        String result = stringUtils.remove("queued", null);
        assertEquals("queued", result);
    }
    
    @Test
    @DisplayName("Should return source string when remove string is empty")
    void testRemoveString_EmptyRemoveString() {
        String result = stringUtils.remove("queued", "");
        assertEquals("queued", result);
    }
    
    @Test
    @DisplayName("Should remove all occurrences of the remove string")
    void testRemoveString_RemoveStringFound() {
        String result = stringUtils.remove("queued", "ue");
        assertEquals("qd", result);
    }
    
    @Test
    @DisplayName("Should return source string when remove string is not found")
    void testRemoveString_RemoveStringNotFound() {
        String result = stringUtils.remove("queued", "zz");
        assertEquals("queued", result);
    }
    @Test
    public void testEndsWithIgnoreCase() {
        assertTrue(stringUtils.endsWithIgnoreCase(null, null));
        assertFalse(stringUtils.endsWithIgnoreCase(null, "def"));
        assertFalse(stringUtils.endsWithIgnoreCase("abcdef", null));
        assertTrue(stringUtils.endsWithIgnoreCase("abcdef", "def"));
        assertTrue(stringUtils.endsWithIgnoreCase("ABCDEF", "def"));
        assertFalse(stringUtils.endsWithIgnoreCase("ABCDEF", "cde"));
    }
    
    @Test
    public void testEndsWithIgnoreCase_EmptyString() {
        assertTrue(stringUtils.endsWithIgnoreCase("", ""));
        assertFalse(stringUtils.endsWithIgnoreCase("", "def"));
        assertFalse(stringUtils.endsWithIgnoreCase("abcdef", ""));
        assertTrue(stringUtils.endsWithIgnoreCase("ABCDEF", ""));
    }
    
    @Test
    public void testEndsWithIgnoreCase_Whitespace() {
        assertTrue(stringUtils.endsWithIgnoreCase("abc def", " def"));
        assertTrue(stringUtils.endsWithIgnoreCase("abc def", " DEF"));
        assertFalse(stringUtils.endsWithIgnoreCase("abc def", "abc "));
        assertFalse(stringUtils.endsWithIgnoreCase("abc def", "ABC "));
    }
    
    @Test
    public void testEndsWithIgnoreCase_SpecialCharacters() {
        assertTrue(stringUtils.endsWithIgnoreCase("abc@def", "@def"));
        assertTrue(stringUtils.endsWithIgnoreCase("abc@def", "@DEF"));
        assertFalse(stringUtils.endsWithIgnoreCase("abc@def", "abc@"));
        assertFalse(stringUtils.endsWithIgnoreCase("abc@def", "ABC@"));
    }
    @Test
    @DisplayName("Test swapCase with null input")
    void testSwapCaseWithNullInput() {
        assertNull(StringUtils.swapCase(null));
    }
    
    @Test
    @DisplayName("Test swapCase with empty input")
    void testSwapCaseWithEmptyInput() {
        assertEquals("", StringUtils.swapCase(""));
    }
    
    @Test
    @DisplayName("Test swapCase with all lowercase characters")
    void testSwapCaseWithAllLowercaseCharacters() {
        assertEquals("HELLO WORLD", StringUtils.swapCase("hello world"));
    }
    
    @Test
    @DisplayName("Test swapCase with all uppercase characters")
    void testSwapCaseWithAllUppercaseCharacters() {
        assertEquals("hello world", StringUtils.swapCase("HELLO WORLD"));
    }
    
    @Test
    @DisplayName("Test swapCase with mixed case characters")
    void testSwapCaseWithMixedCaseCharacters() {
        assertEquals("tHE DOG HAS A bone", StringUtils.swapCase("The dog has a BONE"));
    }
    
    @Test
    @DisplayName("Test swapCase with non-alphabetic characters")
    void testSwapCaseWithNonAlphabeticCharacters() {
        assertEquals("12345!@#$%", StringUtils.swapCase("12345!@#$%"));
    }
    
    @Test
    @DisplayName("Test swapCase with Unicode characters")
    void testSwapCaseWithUnicodeCharacters() {
        assertEquals("ΑβΓδεΖηΘ", StringUtils.swapCase("αΒγΔΕζΗθ"));
    }
    @Test
    @DisplayName("Should return all matching substrings in an array")
    void testSubstringsBetween() {
        String[] expected = {"a", "b", "c"};
        String[] actual = stringUtils.substringsBetween("[a][b][c]", "[", "]");
        assertArrayEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Should return null when input string is null")
    void testSubstringsBetweenWithNullString() {
        String[] actual = stringUtils.substringsBetween(null, "[", "]");
        assertNull(actual);
    }
    
    @Test
    @DisplayName("Should return null when open string is null")
    void testSubstringsBetweenWithNullOpen() {
        String[] actual = stringUtils.substringsBetween("[a][b][c]", null, "]");
        assertNull(actual);
    }
    
    @Test
    @DisplayName("Should return null when close string is null")
    void testSubstringsBetweenWithNullClose() {
        String[] actual = stringUtils.substringsBetween("[a][b][c]", "[", null);
        assertNull(actual);
    }
    
    @Test
    @DisplayName("Should return empty array when input string is empty")
    void testSubstringsBetweenWithEmptyString() {
        String[] actual = stringUtils.substringsBetween("", "[", "]");
        assertEquals(0, actual.length);
    }
    
    @Test
    @DisplayName("Should return empty array when open string is empty")
    void testSubstringsBetweenWithEmptyOpen() {
        String[] actual = stringUtils.substringsBetween("[a][b][c]", "", "]");
        assertEquals(0, actual.length);
    }
    
    @Test
    @DisplayName("Should return empty array when close string is empty")
    void testSubstringsBetweenWithEmptyClose() {
        String[] actual = stringUtils.substringsBetween("[a][b][c]", "[", "");
        assertEquals(0, actual.length);
    }
    
    @Test
    @DisplayName("Should return null when no match is found")
    void testSubstringsBetweenWithNoMatch() {
        String[] actual = stringUtils.substringsBetween("[a][b][c]", "{", "}");
        assertNull(actual);
    }
    
    @Test
    @DisplayName("Should handle multiple occurrences of open and close strings")
    void testSubstringsBetweenWithMultipleOccurrences() {
        String[] expected = {"a", "b", "c"};
        String[] actual = stringUtils.substringsBetween("[a][b][c][d][e][f]", "[", "]");
        assertArrayEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Should handle overlapping open and close strings")
    void testSubstringsBetweenWithOverlappingStrings() {
        String[] expected = {"ab"};
        String[] actual = stringUtils.substringsBetween("[ab][bc][cd]", "[a", "b]");
        assertArrayEquals(expected, actual);
    }
    @Test
    void testGetFuzzyDistance_NullInput_ThrowsIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            stringUtils.getFuzzyDistance(null, null, null);
        });
    }
    
    @Test
    void testGetFuzzyDistance_EmptyInput_ReturnsZero() {
        int distance = stringUtils.getFuzzyDistance("", "", Locale.ENGLISH);
        Assertions.assertEquals(0, distance);
    }
    
    @Test
    void testGetFuzzyDistance_QueryLongerThanTerm_ReturnsZero() {
        int distance = stringUtils.getFuzzyDistance("Workshop", "b", Locale.ENGLISH);
        Assertions.assertEquals(0, distance);
    }
    
    @Test
    void testGetFuzzyDistance_QueryCharacterNotFound_ReturnsZero() {
        int distance = stringUtils.getFuzzyDistance("Room", "o", Locale.ENGLISH);
        Assertions.assertEquals(1, distance);
    }
    
    @Test
    void testGetFuzzyDistance_SingleCharacterMatch_ReturnsOne() {
        int distance = stringUtils.getFuzzyDistance("Workshop", "w", Locale.ENGLISH);
        Assertions.assertEquals(1, distance);
    }
    
    @Test
    void testGetFuzzyDistance_TwoCharacterMatch_ReturnsTwo() {
        int distance = stringUtils.getFuzzyDistance("Workshop", "ws", Locale.ENGLISH);
        Assertions.assertEquals(2, distance);
    }
    
    @Test
    void testGetFuzzyDistance_FourCharacterMatch_ReturnsFour() {
        int distance = stringUtils.getFuzzyDistance("Workshop", "wo", Locale.ENGLISH);
        Assertions.assertEquals(4, distance);
    }
    
    @Test
    void testGetFuzzyDistance_MultipleCharacterMatch_ReturnsCorrectScore() {
        int distance = stringUtils.getFuzzyDistance("Apache Software Foundation", "asf", Locale.ENGLISH);
        Assertions.assertEquals(3, distance);
    }
    // Your Java code here
    
    @Test
    void shouldReturnNullWhenStringIsNull() {
        String result = StringUtils.truncate(null, 5);
        assertNull(result);
    }
    
    @Test
    void shouldReturnEmptyStringWhenStringIsEmpty() {
        String result = StringUtils.truncate("", 5);
        assertEquals("", result);
    }
    
    @Test
    void shouldReturnStringWhenMaxLengthIsGreaterThanStringLength() {
        String result = StringUtils.truncate("abcdefg", 10);
        assertEquals("abcdefg", result);
    }
    
    @Test
    void shouldTruncateStringWhenMaxLengthIsLessThanStringLength() {
        String result = StringUtils.truncate("abcdefg", 4);
        assertEquals("abcd", result);
    }
    
    @Test
    void shouldThrowIllegalArgumentExceptionWhenMaxLengthIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.truncate("abcdefg", -1));
    }
    
    @Test
    void shouldReturnNullWhenStringIsNull() {
        String result = StringUtils.truncate(null, 0, 5);
        assertNull(result);
    }
    
    @Test
    void shouldReturnEmptyStringWhenStringIsEmpty() {
        String result = StringUtils.truncate("", 0, 5);
        assertEquals("", result);
    }
    
    @Test
    void shouldReturnStringWhenMaxLengthIsGreaterThanStringLength() {
        String result = StringUtils.truncate("abcdefg", 0, 10);
        assertEquals("abcdefg", result);
    }
    
    @Test
    void shouldTruncateStringFromOffsetWhenMaxLengthIsLessThanStringLength() {
        String result = StringUtils.truncate("abcdefg", 2, 6);
        assertEquals("cdefg", result);
    }
    
    @Test
    void shouldTruncateStringFromOffsetWhenMaxLengthIsEqualToStringLength() {
        String result = StringUtils.truncate("abcdefg", 2, 5);
        assertEquals("cdefg", result);
    }
    
    @Test
    void shouldTruncateStringFromOffsetWhenMaxLengthIsGreaterThanStringLength() {
        String result = StringUtils.truncate("abcdefg", 2, 10);
        assertEquals("cdefg", result);
    }
    
    @Test
    void shouldThrowIllegalArgumentExceptionWhenOffsetIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.truncate("abcdefg", -1, 5));
    }
    
    @Test
    void shouldThrowIllegalArgumentExceptionWhenMaxLengthIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.truncate("abcdefg", 0, -1));
    }
    
    @Test
    void shouldThrowIllegalArgumentExceptionWhenOffsetIsGreaterThanStringLength() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.truncate("abcdefg", 10, 5));
    }
    @Test
    @DisplayName("Test strip() with null input")
    void testStripWithNullInput() {
        String str = null;
        assertNull(StringUtils.strip(str));
    }
    
    @Test
    @DisplayName("Test strip() with empty string input")
    void testStripWithEmptyStringInput() {
        String str = "";
        assertEquals("", StringUtils.strip(str));
    }
    
    @Test
    @DisplayName("Test strip() with whitespace input")
    void testStripWithWhitespaceInput() {
        String str = "   ";
        assertEquals("", StringUtils.strip(str));
    }
    
    @Test
    @DisplayName("Test strip() with non-whitespace input")
    void testStripWithNonWhitespaceInput() {
        String str = "abc";
        assertEquals("abc", StringUtils.strip(str));
    }
    
    @Test
    @DisplayName("Test strip() with leading whitespace input")
    void testStripWithLeadingWhitespaceInput() {
        String str = "  abc";
        assertEquals("abc", StringUtils.strip(str));
    }
    
    @Test
    @DisplayName("Test strip() with trailing whitespace input")
    void testStripWithTrailingWhitespaceInput() {
        String str = "abc  ";
        assertEquals("abc", StringUtils.strip(str));
    }
    
    @Test
    @DisplayName("Test strip() with whitespace in between input")
    void testStripWithWhitespaceInBetweenInput() {
        String str = " ab c ";
        assertEquals("ab c", StringUtils.strip(str));
    }
    
    @Test
    @DisplayName("Test strip() with null input and strip characters")
    void testStripWithNullInputAndStripCharacters() {
        String str = null;
        String stripChars = "xyz";
        assertNull(StringUtils.strip(str, stripChars));
    }
    
    @Test
    @DisplayName("Test strip() with empty string input and strip characters")
    void testStripWithEmptyStringInputAndStripCharacters() {
        String str = "";
        String stripChars = "xyz";
        assertEquals("", StringUtils.strip(str, stripChars));
    }
    
    @Test
    @DisplayName("Test strip() with whitespace input and strip characters")
    void testStripWithWhitespaceInputAndStripCharacters() {
        String str = "   ";
        String stripChars = "xyz";
        assertEquals("", StringUtils.strip(str, stripChars));
    }
    
    @Test
    @DisplayName("Test strip() with non-whitespace input and strip characters")
    void testStripWithNonWhitespaceInputAndStripCharacters() {
        String str = "abc";
        String stripChars = "xyz";
        assertEquals("abc", StringUtils.strip(str, stripChars));
    }
    
    @Test
    @DisplayName("Test strip() with leading whitespace input and strip characters")
    void testStripWithLeadingWhitespaceInputAndStripCharacters() {
        String str = "  abc";
        String stripChars = "xyz";
        assertEquals("abc", StringUtils.strip(str, stripChars));
    }
    
    @Test
    @DisplayName("Test strip() with trailing whitespace input and strip characters")
    void testStripWithTrailingWhitespaceInputAndStripCharacters() {
        String str = "abc  ";
        String stripChars = "xyz";
        assertEquals("abc", StringUtils.strip(str, stripChars));
    }
    
    @Test
    @DisplayName("Test strip() with whitespace in between input and strip characters")
    void testStripWithWhitespaceInBetweenInputAndStripCharacters() {
        String str = " ab c ";
        String stripChars = "xyz";
        assertEquals("ab c", StringUtils.strip(str, stripChars));
    }
    // Your Java code here
    @Test
    @DisplayName("Should return null when input string is null")
    void shouldReturnNullWhenInputStringIsNull() {
        // Arrange
        String str = null;
        String stripChars = "xyz";
    
        // Act
        String result = stringUtils.stripEnd(str, stripChars);
    
        // Assert
        assertNull(result);
    }
    
    @Test
    @DisplayName("Should return empty string when input string is empty")
    void shouldReturnEmptyStringWhenInputStringIsEmpty() {
        // Arrange
        String str = "";
        String stripChars = "xyz";
    
        // Act
        String result = stringUtils.stripEnd(str, stripChars);
    
        // Assert
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Should return the same string when stripChars is null")
    void shouldReturnSameStringWhenStripCharsIsNull() {
        // Arrange
        String str = "abc";
        String stripChars = null;
    
        // Act
        String result = stringUtils.stripEnd(str, stripChars);
    
        // Assert
        assertEquals("abc", result);
    }
    
    @Test
    @DisplayName("Should strip whitespace characters from the end of the string")
    void shouldStripWhitespaceCharactersFromEndOfString() {
        // Arrange
        String str = "  abc  ";
        String stripChars = null;
    
        // Act
        String result = stringUtils.stripEnd(str, stripChars);
    
        // Assert
        assertEquals("  abc", result);
    }
    
    @Test
    @DisplayName("Should strip specified characters from the end of the string")
    void shouldStripSpecifiedCharactersFromEndOfString() {
        // Arrange
        String str = "  abcyx";
        String stripChars = "xyz";
    
        // Act
        String result = stringUtils.stripEnd(str, stripChars);
    
        // Assert
        assertEquals("  abc", result);
    }
    
    @Test
    @DisplayName("Should strip specified string from the end of the string")
    void shouldStripSpecifiedStringFromEndOfString() {
        // Arrange
        String str = "120.00";
        String stripChars = ".0";
    
        // Act
        String result = stringUtils.stripEnd(str, stripChars);
    
        // Assert
        assertEquals("12", result);
    }
    
    @Test
    @DisplayName("Should return the same string when stripChars is empty")
    void shouldReturnSameStringWhenStripCharsIsEmpty() {
        // Arrange
        String str = "abc";
        String stripChars = "";
    
        // Act
        String result = stringUtils.stripEnd(str, stripChars);
    
        // Assert
        assertEquals("abc", result);
    }
    
    @Test
    @DisplayName("Should return the same string when there are no characters to strip")
    void shouldReturnSameStringWhenNoCharactersToStrip() {
        // Arrange
        String str = "abc";
        String stripChars = "xyz";
    
        // Act
        String result = stringUtils.stripEnd(str, stripChars);
    
        // Assert
        assertEquals("abc", result);
    }
    @Test
    void testReplaceFirst_NullInput_ReturnsNull() {
      String result = stringUtils.replaceFirst(null, "regex", "replacement");
      Assertions.assertNull(result);
    }
    
    @Test
    void testReplaceFirst_NullRegex_ReturnsSameString() {
      String input = "input string";
      String result = stringUtils.replaceFirst(input, null, "replacement");
      Assertions.assertEquals(input, result);
    }
    
    @Test
    void testReplaceFirst_NullReplacement_ReturnsSameString() {
      String input = "input string";
      String result = stringUtils.replaceFirst(input, "regex", null);
      Assertions.assertEquals(input, result);
    }
    
    @Test
    void testReplaceFirst_EmptyString_ReturnsSameString() {
      String input = "";
      String result = stringUtils.replaceFirst(input, "regex", "replacement");
      Assertions.assertEquals(input, result);
    }
    
    @Test
    void testReplaceFirst_NoMatch_ReturnsSameString() {
      String input = "input string";
      String result = stringUtils.replaceFirst(input, "regex", "replacement");
      Assertions.assertEquals(input, result);
    }
    
    @Test
    void testReplaceFirst_MatchFound_ReplacesFirstMatch() {
      String input = "input string";
      String result = stringUtils.replaceFirst(input, "input", "replacement");
      Assertions.assertEquals("replacement string", result);
    }
    
    @Test
    void testReplaceFirst_MatchFoundWithRegex_ReplacesFirstMatch() {
      String input = "input string";
      String result = stringUtils.replaceFirst(input, "in.*", "replacement");
      Assertions.assertEquals("replacement string", result);
    }
    
    @Test
    void testReplaceFirst_MatchFoundWithRegexCaseSensitive_ReplacesFirstMatch() {
      String input = "input string";
      String result = stringUtils.replaceFirst(input, "IN.*", "replacement");
      Assertions.assertEquals("input string", result);
    }
    
    @Test
    void testReplaceFirst_MatchFoundWithRegexCaseInsensitive_ReplacesFirstMatch() {
      String input = "input string";
      String result = stringUtils.replaceFirst(input, "(?i)IN.*", "replacement");
      Assertions.assertEquals("replacement string", result);
    }
    
    @Test
    void testReplaceFirst_SpecialCharactersInRegex_ReplacesFirstMatch() {
      String input = "<input> string";
      String result = stringUtils.replaceFirst(input, "<.*>", "replacement");
      Assertions.assertEquals("replacement string", result);
    }
    
    @Test
    void testReplaceFirst_SpecialCharactersInReplacement_ReplacesFirstMatch() {
      String input = "input string";
      String result = stringUtils.replaceFirst(input, "input", "<replacement>");
      Assertions.assertEquals("<replacement> string", result);
    }
    @Test
    void testAbbreviate_NullInput_ReturnsNull() {
        assertNull(stringUtils.abbreviate(null, 5));
    }
    
    @Test
    void testAbbreviate_EmptyInput_ReturnsEmptyString() {
        assertEquals("", stringUtils.abbreviate("", 5));
    }
    
    @Test
    void testAbbreviate_InputLessThanMaxWidth_ReturnsInputString() {
        assertEquals("abcdefg", stringUtils.abbreviate("abcdefg", 8));
    }
    
    @Test
    void testAbbreviate_InputEqualToMaxWidth_ReturnsInputString() {
        assertEquals("abcdefg", stringUtils.abbreviate("abcdefg", 7));
    }
    
    @Test
    void testAbbreviate_InputGreaterThanMaxWidth_ReturnsAbbreviatedString() {
        assertEquals("abc...", stringUtils.abbreviate("abcdefgh", 6));
    }
    
    @Test
    void testAbbreviate_MaxWidthLessThanFour_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            stringUtils.abbreviate("abcdefg", 3);
        });
    }
    
    @Test
    void testAbbreviateWithOffset_NullInput_ReturnsNull() {
        assertNull(stringUtils.abbreviate(null, 0, 5));
    }
    
    @Test
    void testAbbreviateWithOffset_EmptyInput_ReturnsEmptyString() {
        assertEquals("", stringUtils.abbreviate("", 0, 5));
    }
    
    @Test
    void testAbbreviateWithOffset_InputLessThanMaxWidth_ReturnsInputString() {
        assertEquals("abcdefg", stringUtils.abbreviate("abcdefg", 0, 8));
    }
    
    @Test
    void testAbbreviateWithOffset_InputEqualToMaxWidth_ReturnsInputString() {
        assertEquals("abcdefg", stringUtils.abbreviate("abcdefg", 0, 7));
    }
    
    @Test
    void testAbbreviateWithOffset_InputGreaterThanMaxWidth_ReturnsAbbreviatedString() {
        assertEquals("...defgh", stringUtils.abbreviate("abcdefgh", 3, 8));
    }
    
    @Test
    void testAbbreviateWithOffset_MaxWidthLessThanFour_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            stringUtils.abbreviate("abcdefg", 0, 3);
        });
    }
    
    @Test
    void testAbbreviateWithMarker_NullInput_ReturnsNull() {
        assertNull(stringUtils.abbreviate(null, "...", 5));
    }
    
    @Test
    void testAbbreviateWithMarker_EmptyInput_ReturnsEmptyString() {
        assertEquals("", stringUtils.abbreviate("", "...", 5));
    }
    
    @Test
    void testAbbreviateWithMarker_InputLessThanMaxWidth_ReturnsInputString() {
        assertEquals("abcdefg", stringUtils.abbreviate("abcdefg", "...", 8));
    }
    
    @Test
    void testAbbreviateWithMarker_InputEqualToMaxWidth_ReturnsInputString() {
        assertEquals("abcdefg", stringUtils.abbreviate("abcdefg", "...", 7));
    }
    
    @Test
    void testAbbreviateWithMarker_InputGreaterThanMaxWidth_ReturnsAbbreviatedString() {
        assertEquals("ab...", stringUtils.abbreviate("abcdefgh", "...", 6));
    }
    
    @Test
    void testAbbreviateWithMarker_MaxWidthLessThanMarkerLengthPlusOne_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            stringUtils.abbreviate("abcdefg", "...", 3);
        });
    }
    
    @Test
    void testAbbreviateWithOffsetAndMarker_NullInput_ReturnsNull() {
        assertNull(stringUtils.abbreviate(null, "...", 0, 5));
    }
    
    @Test
    void testAbbreviateWithOffsetAndMarker_EmptyInput_ReturnsEmptyString() {
        assertEquals("", stringUtils.abbreviate("", "...", 0, 5));
    }
    
    @Test
    void testAbbreviateWithOffsetAndMarker_InputLessThanMaxWidth_ReturnsInputString() {
        assertEquals("abcdefg", stringUtils.abbreviate("abcdefg", "...", 0, 8));
    }
    
    @Test
    void testAbbreviateWithOffsetAndMarker_InputEqualToMaxWidth_ReturnsInputString() {
        assertEquals("abcdefg", stringUtils.abbreviate("abcdefg", "...", 0, 7));
    }
    
    @Test
    void testAbbreviateWithOffsetAndMarker_InputGreaterThanMaxWidth_ReturnsAbbreviatedString() {
        assertEquals("...defgh", stringUtils.abbreviate("abcdefgh", "...", 3, 8));
    }
    
    @Test
    void testAbbreviateWithOffsetAndMarker_MaxWidthLessThanMarkerLengthPlusOne_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            stringUtils.abbreviate("abcdefg", "...", 0, 3);
        });
    }
    import org.junit.jupiter.api.Test;
    
    class StringUtilsTest {
    
        @Test
        void testReplaceIgnoreCaseWithNullText() {
            // test code here
        }
    
        @Test
        void testReplaceIgnoreCaseWithNullSearchString() {
            // test code here
        }
    
        @Test
        void testReplaceIgnoreCaseWithNullReplacement() {
            // test code here
        }
    
        @Test
        void testReplaceIgnoreCaseWithEmptyText() {
            // test code here
        }
    
        @Test
        void testReplaceIgnoreCaseWithEmptySearchString() {
            // test code here
        }
    
        @Test
        void testReplaceIgnoreCaseWithNoMatch() {
            // test code here
        }
    
        @Test
        void testReplaceIgnoreCaseWithMatches() {
            // test code here
        }
    
        @Test
        void testReplaceIgnoreCaseWithMaxWithNullText() {
            // test code here
        }
    
        @Test
        void testReplaceIgnoreCaseWithMaxWithNullSearchString() {
            // test code here
        }
    
        @Test
        void testReplaceIgnoreCaseWithMaxWithNullReplacement() {
            // test code here
        }
    
        @Test
        void testReplaceIgnoreCaseWithMaxWithEmptyText() {
            // test code here
        }
    
        @Test
        void testReplaceIgnoreCaseWithMaxWithEmptySearchString() {
            // test code here
        }
    
        @Test
        void testReplaceIgnoreCaseWithMaxWithZeroMax() {
            // test code here
        }
    
        @Test
        void testReplaceIgnoreCaseWithMaxWithUnlimitedMax() {
            // test code here
        }
    
        @Test
        void testReplaceIgnoreCaseWithMaxWithLimitedMax() {
            // test code here
        }
    }
    @Test
    @DisplayName("should return false if any CharSequence is empty")
    void testIsNoneEmpty_withEmptyCharSequence_shouldReturnFalse() {
        assertFalse(stringUtils.isNoneEmpty(""));
        assertFalse(stringUtils.isNoneEmpty("", "bar"));
        assertFalse(stringUtils.isNoneEmpty("bob", ""));
        assertFalse(stringUtils.isNoneEmpty("  bob  ", null));
        assertFalse(stringUtils.isNoneEmpty(new String[] { "" }));
    }
    
    @Test
    @DisplayName("should return false if any CharSequence is null")
    void testIsNoneEmpty_withNullCharSequence_shouldReturnFalse() {
        assertFalse(stringUtils.isNoneEmpty((CharSequence) null));
        assertFalse(stringUtils.isNoneEmpty((CharSequence[]) null));
        assertFalse(stringUtils.isNoneEmpty(null, "foo"));
    }
    
    @Test
    @DisplayName("should return true if all CharSequences are not empty or null")
    void testIsNoneEmpty_withNonEmptyCharSequence_shouldReturnTrue() {
        assertTrue(stringUtils.isNoneEmpty(" "));
        assertTrue(stringUtils.isNoneEmpty("foo", "bar"));
    }
    
    @Test
    @DisplayName("should return true if no CharSequences are provided")
    void testIsNoneEmpty_withNoCharSequences_shouldReturnTrue() {
        assertTrue(stringUtils.isNoneEmpty());
    }
    @Test
    void testContainsAnyIgnoreCase() {
        CharSequence cs = "abcd";
        CharSequence[] searchCharSequences = {"ab", null};
    
        assertTrue(StringUtils.containsAnyIgnoreCase(cs, searchCharSequences));
    }
    
    @Test
    void testContainsAnyIgnoreCase_emptyString() {
        CharSequence cs = "";
        CharSequence[] searchCharSequences = {"ab", null};
    
        assertFalse(StringUtils.containsAnyIgnoreCase(cs, searchCharSequences));
    }
    
    @Test
    void testContainsAnyIgnoreCase_nullCS() {
        CharSequence cs = null;
        CharSequence[] searchCharSequences = {"ab", null};
    
        assertFalse(StringUtils.containsAnyIgnoreCase(cs, searchCharSequences));
    }
    
    @Test
    void testContainsAnyIgnoreCase_nullSearchCharSequences() {
        CharSequence cs = "abcd";
        CharSequence[] searchCharSequences = null;
    
        assertFalse(StringUtils.containsAnyIgnoreCase(cs, searchCharSequences));
    }
    
    @Test
    void testContainsAnyIgnoreCase_noMatch() {
        CharSequence cs = "abcd";
        CharSequence[] searchCharSequences = {"ef", "gh"};
    
        assertFalse(StringUtils.containsAnyIgnoreCase(cs, searchCharSequences));
    }
    
    @Test
    void testContainsAnyIgnoreCase_caseSensitiveMatch() {
        CharSequence cs = "abcd";
        CharSequence[] searchCharSequences = {"AB", "CD"};
    
        assertFalse(StringUtils.containsAnyIgnoreCase(cs, searchCharSequences));
    }
    
    @Test
    void testContainsAnyIgnoreCase_caseInsensitiveMatch() {
        CharSequence cs = "abcd";
        CharSequence[] searchCharSequences = {"AB", "CD"};
    
        assertTrue(StringUtils.containsAnyIgnoreCase(cs, searchCharSequences));
    }
    
    @Test
    void testContainsAnyIgnoreCase_unicodeNormalization() {
        CharSequence cs = "café";
        CharSequence[] searchCharSequences = {"cafe"};
    
        assertTrue(StringUtils.containsAnyIgnoreCase(cs, searchCharSequences));
    }
    @Test
    void testJoinWithNullArray() {
        // Arrange
        boolean[] array = null;
        char delimiter = ',';
    
        // Act
        String result = StringUtils.join(array, delimiter);
    
        // Assert
        assertNull(result);
    }
    
    @Test
    void testJoinWithEmptyArray() {
        // Arrange
        boolean[] array = new boolean[0];
        char delimiter = ',';
    
        // Act
        String result = StringUtils.join(array, delimiter);
    
        // Assert
        assertEquals("", result);
    }
    
    @Test
    void testJoinWithNullElements() {
        // Arrange
        boolean[] array = {true, false, true};
        char delimiter = ',';
    
        // Act
        String result = StringUtils.join(array, delimiter);
    
        // Assert
        assertEquals("true,false,true", result);
    }
    
    @Test
    void testJoinWithEmptyElements() {
        // Arrange
        boolean[] array = {true, false, true};
        char delimiter = ',';
    
        // Act
        String result = StringUtils.join(array, delimiter);
    
        // Assert
        assertEquals("true,false,true", result);
    }
    
    @Test
    void testJoinWithSingleElement() {
        // Arrange
        boolean[] array = {true};
        char delimiter = ',';
    
        // Act
        String result = StringUtils.join(array, delimiter);
    
        // Assert
        assertEquals("true", result);
    }
    
    @Test
    void testJoinWithMultipleElements() {
        // Arrange
        boolean[] array = {true, false, true};
        char delimiter = ',';
    
        // Act
        String result = StringUtils.join(array, delimiter);
    
        // Assert
        assertEquals("true,false,true", result);
    }
    
    @Test
    void testJoinWithStartIndexAndEndIndex() {
        // Arrange
        boolean[] array = {true, false, true, false, true};
        char delimiter = ',';
        int startIndex = 1;
        int endIndex = 4;
    
        // Act
        String result = StringUtils.join(array, delimiter, startIndex, endIndex);
    
        // Assert
        assertEquals("false,true,false", result);
    }
    @Test
    @DisplayName("Test splitByCharacterType with null input")
    void testSplitByCharacterTypeWithNullInput() {
        String[] result = stringUtils.splitByCharacterType(null);
        Assertions.assertNull(result);
    }
    
    @Test
    @DisplayName("Test splitByCharacterType with empty input")
    void testSplitByCharacterTypeWithEmptyInput() {
        String[] result = stringUtils.splitByCharacterType("");
        Assertions.assertEquals(0, result.length);
    }
    
    @Test
    @DisplayName("Test splitByCharacterType with input containing only one character")
    void testSplitByCharacterTypeWithSingleCharacterInput() {
        String[] result = stringUtils.splitByCharacterType("a");
        Assertions.assertEquals(1, result.length);
        Assertions.assertEquals("a", result[0]);
    }
    
    @Test
    @DisplayName("Test splitByCharacterType with input containing letters and numbers")
    void testSplitByCharacterTypeWithLetterNumberInput() {
        String[] result = stringUtils.splitByCharacterType("abc123");
        Assertions.assertEquals(2, result.length);
        Assertions.assertEquals("abc", result[0]);
        Assertions.assertEquals("123", result[1]);
    }
    
    @Test
    @DisplayName("Test splitByCharacterType with input containing letters, numbers, and special characters")
    void testSplitByCharacterTypeWithLetterNumberSpecialCharacterInput() {
        String[] result = stringUtils.splitByCharacterType("abc123@#$");
        Assertions.assertEquals(4, result.length);
        Assertions.assertEquals("abc", result[0]);
        Assertions.assertEquals("123", result[1]);
        Assertions.assertEquals("@#$", result[2]);
    }
    
    @Test
    @DisplayName("Test splitByCharacterType with input containing whitespace characters")
    void testSplitByCharacterTypeWithWhitespaceInput() {
        String[] result = stringUtils.splitByCharacterType("a b c");
        Assertions.assertEquals(5, result.length);
        Assertions.assertEquals("a", result[0]);
        Assertions.assertEquals(" ", result[1]);
        Assertions.assertEquals("b", result[2]);
        Assertions.assertEquals(" ", result[3]);
        Assertions.assertEquals("c", result[4]);
    }
    
    @Test
    @DisplayName("Test splitByCharacterType with input containing newline characters")
    void testSplitByCharacterTypeWithNewlineInput() {
        String[] result = stringUtils.splitByCharacterType("a\nb\nc");
        Assertions.assertEquals(5, result.length);
        Assertions.assertEquals("a", result[0]);
        Assertions.assertEquals("\n", result[1]);
        Assertions.assertEquals("b", result[2]);
        Assertions.assertEquals("\n", result[3]);
        Assertions.assertEquals("c", result[4]);
    }
    
    @Test
    @DisplayName("Test splitByCharacterType with input containing carriage return characters")
    void testSplitByCharacterTypeWithCarriageReturnInput() {
        String[] result = stringUtils.splitByCharacterType("a\rb\rc");
        Assertions.assertEquals(5, result.length);
        Assertions.assertEquals("a", result[0]);
        Assertions.assertEquals("\r", result[1]);
        Assertions.assertEquals("b", result[2]);
        Assertions.assertEquals("\r", result[3]);
        Assertions.assertEquals("c", result[4]);
    }
    
    @Test
    @DisplayName("Test splitByCharacterType with input containing mixed whitespace characters")
    void testSplitByCharacterTypeWithMixedWhitespaceInput() {
        String[] result = stringUtils.splitByCharacterType("a\tb\n\rc");
        Assertions.assertEquals(7, result.length);
        Assertions.assertEquals("a", result[0]);
        Assertions.assertEquals("\t", result[1]);
        Assertions.assertEquals("b", result[2]);
        Assertions.assertEquals("\n", result[3]);
        Assertions.assertEquals("\r", result[4]);
        Assertions.assertEquals("c", result[5]);
    }
    
    @Test
    @DisplayName("Test splitByCharacterType with input containing special characters")
    void testSplitByCharacterTypeWithSpecialCharacterInput() {
        String[] result = stringUtils.splitByCharacterType("a@b#c");
        Assertions.assertEquals(5, result.length);
        Assertions.assertEquals("a", result[0]);
        Assertions.assertEquals("@", result[1]);
        Assertions.assertEquals("b", result[2]);
        Assertions.assertEquals("#", result[3]);
        Assertions.assertEquals("c", result[4]);
    }
    
    @Test
    @DisplayName("Test splitByCharacterType with input containing multiple special characters")
    void testSplitByCharacterTypeWithMultipleSpecialCharactersInput() {
        String[] result = stringUtils.splitByCharacterType("a@#b$c");
        Assertions.assertEquals(7, result.length);
        Assertions.assertEquals("a", result[0]);
        Assertions.assertEquals("@", result[1]);
        Assertions.assertEquals("#", result[2]);
        Assertions.assertEquals("b", result[3]);
        Assertions.assertEquals("$", result[4]);
        Assertions.assertEquals("c", result[5]);
    }
    @Test
    @DisplayName("Should convert all remaining accent characters to their corresponding non-accent characters")
    void testConvertRemainingAccentCharacters() {
        StringBuilder decomposed = new StringBuilder("ąćęłńóśźż");
        StringUtils.convertRemainingAccentCharacters(decomposed);
        assertEquals("acelnoszz", decomposed.toString());
    }
    
    @Test
    @DisplayName("Should not modify the string if there are no remaining accent characters")
    void testConvertRemainingAccentCharactersNoAccentCharacters() {
        StringBuilder decomposed = new StringBuilder("abcdef");
        StringUtils.convertRemainingAccentCharacters(decomposed);
        assertEquals("abcdef", decomposed.toString());
    }
    
    @Test
    @DisplayName("Should convert 'Ł' to 'L'")
    void testConvertRemainingAccentCharactersCapitalL() {
        StringBuilder decomposed = new StringBuilder("Ł");
        StringUtils.convertRemainingAccentCharacters(decomposed);
        assertEquals("L", decomposed.toString());
    }
    
    @Test
    @DisplayName("Should convert 'ł' to 'l'")
    void testConvertRemainingAccentCharactersLowercaseL() {
        StringBuilder decomposed = new StringBuilder("ł");
        StringUtils.convertRemainingAccentCharacters(decomposed);
        assertEquals("l", decomposed.toString());
    }
    
    @Test
    @DisplayName("Should not modify the string if it is empty")
    void testConvertRemainingAccentCharactersEmptyString() {
        StringBuilder decomposed = new StringBuilder();
        StringUtils.convertRemainingAccentCharacters(decomposed);
        assertEquals("", decomposed.toString());
    }
    
    @Test
    @DisplayName("Should handle null string")
    void testConvertRemainingAccentCharactersNullString() {
        StringBuilder decomposed = null;
        StringUtils.convertRemainingAccentCharacters(decomposed);
        assertEquals(null, decomposed);
    }
    @Test
    @DisplayName("Should return null when input string is null")
    void shouldReturnNullWhenInputStringIsNull() {
        // Arrange
        String str = null;
        char remove = 'a';
    
        // Act
        String result = StringUtils.removeStart(str, remove);
    
        // Assert
        assertEquals(null, result);
    }
    
    @Test
    @DisplayName("Should return empty string when input string is empty")
    void shouldReturnEmptyStringWhenInputStringIsEmpty() {
        // Arrange
        String str = "";
        char remove = 'a';
    
        // Act
        String result = StringUtils.removeStart(str, remove);
    
        // Assert
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Should return input string when remove char is null")
    void shouldReturnInputStringWhenRemoveCharIsNull() {
        // Arrange
        String str = "abc";
        Character remove = null;
    
        // Act
        String result = StringUtils.removeStart(str, remove);
    
        // Assert
        assertEquals("abc", result);
    }
    
    @Test
    @DisplayName("Should remove char at the beginning of the input string")
    void shouldRemoveCharAtBeginningOfInputString() {
        // Arrange
        String str = "abc";
        char remove = 'a';
    
        // Act
        String result = StringUtils.removeStart(str, remove);
    
        // Assert
        assertEquals("bc", result);
    }
    
    @Test
    @DisplayName("Should not remove char if it is not at the beginning of the input string")
    void shouldNotRemoveCharIfNotAtBeginningOfInputString() {
        // Arrange
        String str = "abc";
        char remove = 'b';
    
        // Act
        String result = StringUtils.removeStart(str, remove);
    
        // Assert
        assertEquals("abc", result);
    }
    
    @Test
    @DisplayName("Should return null when input string is null")
    void shouldReturnNullWhenInputStringIsNull() {
        // Arrange
        String str = null;
        String remove = "abc";
    
        // Act
        String result = StringUtils.removeStart(str, remove);
    
        // Assert
        assertEquals(null, result);
    }
    
    @Test
    @DisplayName("Should return empty string when input string is empty")
    void shouldReturnEmptyStringWhenInputStringIsEmpty() {
        // Arrange
        String str = "";
        String remove = "abc";
    
        // Act
        String result = StringUtils.removeStart(str, remove);
    
        // Assert
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Should return input string when remove string is null")
    void shouldReturnInputStringWhenRemoveStringIsNull() {
        // Arrange
        String str = "abc";
        String remove = null;
    
        // Act
        String result = StringUtils.removeStart(str, remove);
    
        // Assert
        assertEquals("abc", result);
    }
    
    @Test
    @DisplayName("Should remove string at the beginning of the input string")
    void shouldRemoveStringAtBeginningOfInputString() {
        // Arrange
        String str = "abc";
        String remove = "ab";
    
        // Act
        String result = StringUtils.removeStart(str, remove);
    
        // Assert
        assertEquals("c", result);
    }
    
    @Test
    @DisplayName("Should not remove string if it is not at the beginning of the input string")
    void shouldNotRemoveStringIfNotAtBeginningOfInputString() {
        // Arrange
        String str = "abc";
        String remove = "bc";
    
        // Act
        String result = StringUtils.removeStart(str, remove);
    
        // Assert
        assertEquals("abc", result);
    }
    @Test
    void testEqualsIgnoreCase_BothNull_ReturnsTrue() {
      assertTrue(StringUtils.equalsIgnoreCase(null, null));
    }
    
    @Test
    void testEqualsIgnoreCase_OneNull_ReturnsFalse() {
      assertFalse(StringUtils.equalsIgnoreCase(null, "abc"));
      assertFalse(StringUtils.equalsIgnoreCase("abc", null));
    }
    
    @Test
    void testEqualsIgnoreCase_EqualStrings_ReturnsTrue() {
      assertTrue(StringUtils.equalsIgnoreCase("abc", "abc"));
    }
    
    @Test
    void testEqualsIgnoreCase_DifferentCase_ReturnsTrue() {
      assertTrue(StringUtils.equalsIgnoreCase("abc", "ABC"));
    }
    
    @Test
    void testEqualsIgnoreCase_DifferentLength_ReturnsFalse() {
      assertFalse(StringUtils.equalsIgnoreCase("abc", "abcd"));
      assertFalse(StringUtils.equalsIgnoreCase("abcd", "abc"));
    }
    
    @Test
    void testEqualsIgnoreCase_EmptyStrings_ReturnsTrue() {
      assertTrue(StringUtils.equalsIgnoreCase("", ""));
    }
    
    @Test
    void testEqualsIgnoreCase_EmptyStringAndNonNull_ReturnsFalse() {
      assertFalse(StringUtils.equalsIgnoreCase("", "abc"));
      assertFalse(StringUtils.equalsIgnoreCase("abc", ""));
    }
    
    @Test
    void testEqualsIgnoreCase_WhitespaceStrings_ReturnsTrue() {
      assertTrue(StringUtils.equalsIgnoreCase("  ", "  "));
      assertTrue(StringUtils.equalsIgnoreCase("\t", "\t"));
      assertTrue(StringUtils.equalsIgnoreCase("\n", "\n"));
      assertTrue(StringUtils.equalsIgnoreCase("\r", "\r"));
    }
    
    @Test
    void testEqualsIgnoreCase_WhitespaceAndNonNull_ReturnsFalse() {
      assertFalse(StringUtils.equalsIgnoreCase("  ", "abc"));
      assertFalse(StringUtils.equalsIgnoreCase("abc", "  "));
      assertFalse(StringUtils.equalsIgnoreCase("\t", "abc"));
      assertFalse(StringUtils.equalsIgnoreCase("abc", "\t"));
      assertFalse(StringUtils.equalsIgnoreCase("\n", "abc"));
      assertFalse(StringUtils.equalsIgnoreCase("abc", "\n"));
      assertFalse(StringUtils.equalsIgnoreCase("\r", "abc"));
      assertFalse(StringUtils.equalsIgnoreCase("abc", "\r"));
    }
    
    @Test
    void testEqualsIgnoreCase_AccentedCharacters_ReturnsTrue() {
      assertTrue(StringUtils.equalsIgnoreCase("àèìòù", "ÀÈÌÒÙ"));
      assertTrue(StringUtils.equalsIgnoreCase("äëïöü", "ÄËÏÖÜ"));
      assertTrue(StringUtils.equalsIgnoreCase("áéíóú", "ÁÉÍÓÚ"));
      assertTrue(StringUtils.equalsIgnoreCase("âêîôû", "ÂÊÎÔÛ"));
      assertTrue(StringUtils.equalsIgnoreCase("ãõñ", "ÃÕÑ"));
      assertTrue(StringUtils.equalsIgnoreCase("āēīōū", "ĀĒĪŌŪ"));
    }
    
    @Test
    void testEqualsIgnoreCase_AsciiAndNonAsciiCharacters_ReturnsFalse() {
      assertFalse(StringUtils.equalsIgnoreCase("abc", "àbc"));
      assertFalse(StringUtils.equalsIgnoreCase("abc", "äbc"));
      assertFalse(StringUtils.equalsIgnoreCase("abc", "ábc"));
      assertFalse(StringUtils.equalsIgnoreCase("abc", "âbc"));
      assertFalse(StringUtils.equalsIgnoreCase("abc", "ãbc"));
      assertFalse(StringUtils.equalsIgnoreCase("abc", "ābc"));
    }
    
    @Test
    void testEqualsIgnoreCase_UnicodeCharacters_ReturnsTrue() {
      assertTrue(StringUtils.equalsIgnoreCase("𐐀", "𐐀"));
      assertTrue(StringUtils.equalsIgnoreCase("𠀀", "𠀀"));
      assertTrue(StringUtils.equalsIgnoreCase("𠈓", "𠈓"));
      assertTrue(StringUtils.equalsIgnoreCase("芽", "芽"));
    }
    
    @Test
    void testEqualsIgnoreCase_UnicodeAndNonUnicodeCharacters_ReturnsFalse() {
      assertFalse(StringUtils.equalsIgnoreCase("abc", "𐐀bc"));
      assertFalse(StringUtils.equalsIgnoreCase("abc", "𠀀bc"));
      assertFalse(StringUtils.equalsIgnoreCase("abc", "𠈓bc"));
      assertFalse(StringUtils.equalsIgnoreCase("abc", "芽bc"));
    }
    import static org.junit.jupiter.api.Assertions.assertEquals;
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Nested;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.params.ParameterizedTest;
    import org.junit.jupiter.params.provider.MethodSource;
    import java.nio.charset.Charset;
    import java.text.Normalizer;
    import java.util.Arrays;
    import java.util.List;
    import java.util.stream.Stream;
    
    public class StringUtilsTest {
    
        @Test
        @DisplayName("should return null when input is null")
        void shouldReturnNullWhenInputIsNull() {
            // Arrange
            String input = null;
    
            // Act
            String result = StringUtils.stripAccents(input);
    
            // Assert
            assertEquals(null, result);
        }
    
        @Test
        @DisplayName("should return empty string when input is empty string")
        void shouldReturnEmptyStringWhenInputIsEmptyString() {
            // Arrange
            String input = "";
    
            // Act
            String result = StringUtils.stripAccents(input);
    
            // Assert
            assertEquals("", result);
        }
    
        @Test
        @DisplayName("should return input string when input string does not contain any accents")
        void shouldReturnInputStringWhenInputStringDoesNotContainAnyAccents() {
            // Arrange
            String input = "control";
    
            // Act
            String result = StringUtils.stripAccents(input);
    
            // Assert
            assertEquals("control", result);
        }
    
        @Test
        @DisplayName("should remove accents from input string")
        void shouldRemoveAccentsFromInputString() {
            // Arrange
            String input = "&eacute;clair";
    
            // Act
            String result = StringUtils.stripAccents(input);
    
            // Assert
            assertEquals("eclair", result);
        }
    
        @Test
        @DisplayName("should correctly remove accents from input string with ligatures")
        void shouldCorrectlyRemoveAccentsFromInputStringWithLigatures() {
            // Arrange
            String input = "floræ";
    
            // Act
            String result = StringUtils.stripAccents(input);
    
            // Assert
            assertEquals("florae", result);
        }
    }
    @Test
    @DisplayName("Should return null when input string is null")
    void testSubstringAfterNullString() {
        String result = stringUtils.substringAfter(null, 32);
        assertNull(result);
    }
    
    @Test
    @DisplayName("Should return empty string when input string is empty")
    void testSubstringAfterEmptyString() {
        String result = stringUtils.substringAfter("", 32);
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Should return substring after the first occurrence of separator")
    void testSubstringAfterFirstOccurrence() {
        String result = stringUtils.substringAfter("abc", 'a');
        assertEquals("bc", result);
    }
    
    @Test
    @DisplayName("Should return substring after the first occurrence of separator when separator is not at the beginning")
    void testSubstringAfterFirstOccurrenceNotAtBeginning() {
        String result = stringUtils.substringAfter("abcba", 'b');
        assertEquals("cba", result);
    }
    
    @Test
    @DisplayName("Should return empty string when separator is at the end")
    void testSubstringAfterSeparatorAtEnd() {
        String result = stringUtils.substringAfter("abc", 'c');
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Should return empty string when separator is not found")
    void testSubstringAfterSeparatorNotFound() {
        String result = stringUtils.substringAfter("abc", 'd');
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Should return input string when separator is a space character")
    void testSubstringAfterSpaceSeparator() {
        String result = stringUtils.substringAfter(" abc", 32);
        assertEquals("abc", result);
    }
    
    @Test
    @DisplayName("Should return null when input string is null")
    void testSubstringAfterNullString() {
        String result = stringUtils.substringAfter(null, "a");
        assertNull(result);
    }
    
    @Test
    @DisplayName("Should return empty string when input string is empty")
    void testSubstringAfterEmptyString() {
        String result = stringUtils.substringAfter("", "a");
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Should return empty string when separator is null")
    void testSubstringAfterNullSeparator() {
        String result = stringUtils.substringAfter("abc", null);
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Should return substring after the first occurrence of separator")
    void testSubstringAfterFirstOccurrence() {
        String result = stringUtils.substringAfter("abc", "a");
        assertEquals("bc", result);
    }
    
    @Test
    @DisplayName("Should return substring after the first occurrence of separator when separator is not at the beginning")
    void testSubstringAfterFirstOccurrenceNotAtBeginning() {
        String result = stringUtils.substringAfter("abcba", "b");
        assertEquals("cba", result);
    }
    
    @Test
    @DisplayName("Should return empty string when separator is at the end")
    void testSubstringAfterSeparatorAtEnd() {
        String result = stringUtils.substringAfter("abc", "c");
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Should return empty string when separator is not found")
    void testSubstringAfterSeparatorNotFound() {
        String result = stringUtils.substringAfter("abc", "d");
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Should return input string when separator is an empty string")
    void testSubstringAfterEmptySeparator() {
        String result = stringUtils.substringAfter("abc", "");
        assertEquals("abc", result);
    }
    @Test
    public void testLeftPad_NullString_ReturnsNull() {
        Assertions.assertNull(StringUtils.leftPad(null, 5));
    }
    
    @Test
    public void testLeftPad_EmptyString_ReturnsPaddedString() {
        Assertions.assertEquals("     ", StringUtils.leftPad("", 5));
    }
    
    @Test
    public void testLeftPad_StringLessThanSize_ReturnsPaddedString() {
        Assertions.assertEquals("  bat", StringUtils.leftPad("bat", 5));
    }
    
    @Test
    public void testLeftPad_StringEqualToSize_ReturnsOriginalString() {
        Assertions.assertEquals("bat", StringUtils.leftPad("bat", 3));
    }
    
    @Test
    public void testLeftPad_StringGreaterThanSize_ReturnsOriginalString() {
        Assertions.assertEquals("bat", StringUtils.leftPad("bat", 1));
    }
    
    @Test
    public void testLeftPad_NegativeSize_ReturnsOriginalString() {
        Assertions.assertEquals("bat", StringUtils.leftPad("bat", -1));
    }
    
    @Test
    public void testLeftPad_NullStringWithChar_ReturnsNull() {
        Assertions.assertNull(StringUtils.leftPad(null, 5, 'z'));
    }
    
    @Test
    public void testLeftPad_EmptyStringWithChar_ReturnsPaddedString() {
        Assertions.assertEquals("zzzzz", StringUtils.leftPad("", 5, 'z'));
    }
    
    @Test
    public void testLeftPad_StringLessThanSizeWithChar_ReturnsPaddedString() {
        Assertions.assertEquals("zzbat", StringUtils.leftPad("bat", 5, 'z'));
    }
    
    @Test
    public void testLeftPad_StringEqualToSizeWithChar_ReturnsOriginalString() {
        Assertions.assertEquals("bat", StringUtils.leftPad("bat", 3, 'z'));
    }
    
    @Test
    public void testLeftPad_StringGreaterThanSizeWithChar_ReturnsOriginalString() {
        Assertions.assertEquals("bat", StringUtils.leftPad("bat", 1, 'z'));
    }
    
    @Test
    public void testLeftPad_NegativeSizeWithChar_ReturnsOriginalString() {
        Assertions.assertEquals("bat", StringUtils.leftPad("bat", -1, 'z'));
    }
    
    @Test
    public void testLeftPad_NullStringWithPadString_ReturnsNull() {
        Assertions.assertNull(StringUtils.leftPad(null, 5, "yz"));
    }
    
    @Test
    public void testLeftPad_EmptyStringWithPadString_ReturnsPaddedString() {
        Assertions.assertEquals("yzyzy", StringUtils.leftPad("", 5, "yz"));
    }
    
    @Test
    public void testLeftPad_StringLessThanSizeWithPadString_ReturnsPaddedString() {
        Assertions.assertEquals("yzbat", StringUtils.leftPad("bat", 5, "yz"));
    }
    
    @Test
    public void testLeftPad_StringEqualToSizeWithPadString_ReturnsOriginalString() {
        Assertions.assertEquals("bat", StringUtils.leftPad("bat", 3, "yz"));
    }
    
    @Test
    public void testLeftPad_StringGreaterThanSizeWithPadString_ReturnsOriginalString() {
        Assertions.assertEquals("bat", StringUtils.leftPad("bat", 1, "yz"));
    }
    
    @Test
    public void testLeftPad_NegativeSizeWithPadString_ReturnsOriginalString() {
        Assertions.assertEquals("bat", StringUtils.leftPad("bat", -1, "yz"));
    }
    
    @Test
    public void testLeftPad_EmptyPadString_ReturnsPaddedStringWithSpaces() {
        Assertions.assertEquals("   bat", StringUtils.leftPad("bat", 6, ""));
    }
    
    @Test
    public void testLeftPad_NullPadString_ReturnsPaddedStringWithSpaces() {
        Assertions.assertEquals("   bat", StringUtils.leftPad("bat", 6, null));
    }
    // Your Java code here
    
    import org.junit.jupiter.api.Test;
    
    class StringUtilsTest {
    
        // ... other code
    
        @Test
        @DisplayName("Unwrap null string with null char")
        void testUnwrapNullStringWithNullChar() {
            assertNull(stringUtils.unwrap(null, '\0'));
        }
    
        @Test
        @DisplayName("Unwrap null string with non-null char")
        void testUnwrapNullStringWithNonNullChar() {
            assertNull(stringUtils.unwrap(null, 'a'));
        }
    
        @Test
        @DisplayName("Unwrap empty string with null char")
        void testUnwrapEmptyStringWithNullChar() {
            assertEquals("", stringUtils.unwrap("", '\0'));
        }
    
        @Test
        @DisplayName("Unwrap empty string with non-null char")
        void testUnwrapEmptyStringWithNonNullChar() {
            assertEquals("", stringUtils.unwrap("", 'a'));
        }
    
        @Test
        @DisplayName("Unwrap string with same start and end char")
        void testUnwrapStringWithSameStartAndEndChar() {
            assertEquals("a", stringUtils.unwrap("a", 'a'));
        }
    
        @Test
        @DisplayName("Unwrap string with different start and end char")
        void testUnwrapStringWithDifferentStartAndEndChar() {
            assertEquals("", stringUtils.unwrap("aa", 'a'));
        }
    
        @Test
        @DisplayName("Unwrap string with different start and end char and additional chars")
        void testUnwrapStringWithDifferentStartAndEndCharAndAdditionalChars() {
            assertEquals("abc", stringUtils.unwrap("'abc'", '\''));
        }
    
        @Test
        @DisplayName("Unwrap string with different start and end char and additional chars")
        void testUnwrapStringWithDifferentStartAndEndCharAndAdditionalChars() {
            assertEquals("abc", stringUtils.unwrap("\"abc\"", "\""));
        }
    
        @Test
        @DisplayName("Unwrap string with same start and end char and additional chars")
        void testUnwrapStringWithSameStartAndEndCharAndAdditionalChars() {
            assertEquals("ABabcBA", stringUtils.unwrap("AABabcBAA", 'A'));
        }
    
        @Test
        @DisplayName("Unwrap string with different start and end char and no additional chars")
        void testUnwrapStringWithDifferentStartAndEndCharAndNoAdditionalChars() {
            assertEquals("A", stringUtils.unwrap("A", '#'));
        }
    
        @Test
        @DisplayName("Unwrap string with same start and end char and no additional chars")
        void testUnwrapStringWithSameStartAndEndCharAndNoAdditionalChars() {
            assertEquals("#A", stringUtils.unwrap("#A", '#'));
        }
    
        @Test
        @DisplayName("Unwrap string with different start and end char and no additional chars")
        void testUnwrapStringWithDifferentStartAndEndCharAndNoAdditionalChars() {
            assertEquals("A#", stringUtils.unwrap("A#", '#'));
        }
    
        @Test
        @DisplayName("Unwrap null string with null token")
        void testUnwrapNullStringWithNullToken() {
            assertNull(stringUtils.unwrap(null, null));
        }
    
        @Test
        @DisplayName("Unwrap null string with empty token")
        void testUnwrapNullStringWithEmptyToken() {
            assertNull(stringUtils.unwrap(null, ""));
        }
    
        @Test
        @DisplayName("Unwrap null string with non-empty token")
        void testUnwrapNullStringWithNonEmptyToken() {
            assertNull(stringUtils.unwrap(null, "1"));
        }
    
        @Test
        @DisplayName("Unwrap empty string with null token")
        void testUnwrapEmptyStringWithNullToken() {
            assertEquals("", stringUtils.unwrap("", null));
        }
    
        @Test
        @DisplayName("Unwrap empty string with empty token")
        void testUnwrapEmptyStringWithEmptyToken() {
            assertEquals("", stringUtils.unwrap("", ""));
        }
    
        @Test
        @DisplayName("Unwrap empty string with non-empty token")
        void testUnwrapEmptyStringWithNonEmptyToken() {
            assertEquals("", stringUtils.unwrap("", "1"));
        }
    
        @Test
        @DisplayName("Unwrap string with same start and end token")
        void testUnwrapStringWithSameStartAndEndToken() {
            assertEquals("a", stringUtils.unwrap("a", "a"));
        }
    
        @Test
        @DisplayName("Unwrap string with different start and end token")
        void testUnwrapStringWithDifferentStartAndEndToken() {
            assertEquals("", stringUtils.unwrap("aa", "a"));
        }
    
        @Test
        @DisplayName("Unwrap string with different start and end token and additional tokens")
        void testUnwrapStringWithDifferentStartAndEndTokenAndAdditionalTokens() {
            assertEquals("abc", stringUtils.unwrap("'abc'", "'"));
        }
    
        @Test
        @DisplayName("Unwrap string with different start and end token and additional tokens")
        void testUnwrapStringWithDifferentStartAndEndTokenAndAdditionalTokens() {
            assertEquals("abc", stringUtils.unwrap("\"abc\"", "\""));
        }
    
        @Test
        @DisplayName("Unwrap string with same start and end token and additional tokens")
        void testUnwrapStringWithSameStartAndEndTokenAndAdditionalTokens() {
            assertEquals("BabcB", stringUtils.unwrap("AABabcBAA", "AA"));
        }
    
        @Test
        @DisplayName("Unwrap string with different start and end token and no additional tokens")
        void testUnwrapStringWithDifferentStartAndEndTokenAndNoAdditionalTokens() {
            assertEquals("A", stringUtils.unwrap("A", "#"));
        }
    
        @Test
        @DisplayName("Unwrap string with same start and end token and no additional tokens")
        void testUnwrapStringWithSameStartAndEndTokenAndNoAdditionalTokens() {
            assertEquals("#A", stringUtils.unwrap("#A", "#"));
        }
    
        @Test
        @DisplayName("Unwrap string with different start and end token and no additional tokens")
        void testUnwrapStringWithDifferentStartAndEndTokenAndNoAdditionalTokens() {
            assertEquals("A#", stringUtils.unwrap("A#", "#"));
        }
    }
    @Test
    @DisplayName("Test with null input and non-null defaultStr")
    void testDefaultIfEmptyWithNullInputAndNonNullDefaultStr() {
        String result = StringUtils.defaultIfEmpty(null, "DEFAULT");
        assertEquals("DEFAULT", result);
    }
    
    @Test
    @DisplayName("Test with empty input and non-null defaultStr")
    void testDefaultIfEmptyWithEmptyInputAndNonNullDefaultStr() {
        String result = StringUtils.defaultIfEmpty("", "DEFAULT");
        assertEquals("DEFAULT", result);
    }
    
    @Test
    @DisplayName("Test with whitespace input and non-null defaultStr")
    void testDefaultIfEmptyWithWhitespaceInputAndNonNullDefaultStr() {
        String result = StringUtils.defaultIfEmpty("  ", "DEFAULT");
        assertEquals("  ", result);
    }
    
    @Test
    @DisplayName("Test with non-empty input and non-null defaultStr")
    void testDefaultIfEmptyWithNonEmptyInputAndNonNullDefaultStr() {
        String result = StringUtils.defaultIfEmpty("abc", "DEFAULT");
        assertEquals("abc", result);
    }
    
    @Test
    @DisplayName("Test with empty input and null defaultStr")
    void testDefaultIfEmptyWithEmptyInputAndNullDefaultStr() {
        String result = StringUtils.defaultIfEmpty("", null);
        assertEquals(null, result);
    }
    
    @Test
    @DisplayName("Test with null input and null defaultStr")
    void testDefaultIfEmptyWithNullInputAndNullDefaultStr() {
        String result = StringUtils.defaultIfEmpty(null, null);
        assertEquals(null, result);
    }
    @Test
    @DisplayName("Replacing a character in a non-null string")
    void testReplaceCharsNonEmptyString() {
        String input = "abcba";
        char searchChar = 'b';
        char replaceChar = 'y';
        String expected = "aycya";
        
        String result = StringUtils.replaceChars(input, searchChar, replaceChar);
        
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("Replacing a character in an empty string")
    void testReplaceCharsEmptyString() {
        String input = "";
        char searchChar = 'b';
        char replaceChar = 'y';
        String expected = "";
        
        String result = StringUtils.replaceChars(input, searchChar, replaceChar);
        
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("Replacing a character in a null string")
    void testReplaceCharsNullString() {
        String input = null;
        char searchChar = 'b';
        char replaceChar = 'y';
        
        String result = StringUtils.replaceChars(input, searchChar, replaceChar);
        
        assertNull(result);
    }
    
    @Test
    @DisplayName("Replacing multiple characters in a non-null string")
    void testReplaceCharsNonEmptyString() {
        String input = "abcba";
        String searchChars = "bc";
        String replaceChars = "yz";
        String expected = "ayzya";
        
        String result = StringUtils.replaceChars(input, searchChars, replaceChars);
        
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("Replacing multiple characters in an empty string")
    void testReplaceCharsEmptyString() {
        String input = "";
        String searchChars = "bc";
        String replaceChars = "yz";
        String expected = "";
        
        String result = StringUtils.replaceChars(input, searchChars, replaceChars);
        
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("Replacing multiple characters in a null string")
    void testReplaceCharsNullString() {
        String input = null;
        String searchChars = "bc";
        String replaceChars = "yz";
        
        String result = StringUtils.replaceChars(input, searchChars, replaceChars);
        
        assertNull(result);
    }
    
    @Test
    @DisplayName("Replacing characters with null replaceChars")
    void testReplaceCharsNullReplaceChars() {
        String input = "abcba";
        String searchChars = "bc";
        String replaceChars = null;
        String expected = "aa";
        
        String result = StringUtils.replaceChars(input, searchChars, replaceChars);
        
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("Replacing characters with empty replaceChars")
    void testReplaceCharsEmptyReplaceChars() {
        String input = "abcba";
        String searchChars = "bc";
        String replaceChars = "";
        String expected = "aa";
        
        String result = StringUtils.replaceChars(input, searchChars, replaceChars);
        
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("Replacing characters with extra search characters")
    void testReplaceCharsExtraSearchChars() {
        String input = "abcba";
        String searchChars = "bcz";
        String replaceChars = "yz";
        String expected = "ayzya";
        
        String result = StringUtils.replaceChars(input, searchChars, replaceChars);
        
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("Replacing characters with extra replace characters")
    void testReplaceCharsExtraReplaceChars() {
        String input = "abcba";
        String searchChars = "bc";
        String replaceChars = "yzx";
        String expected = "ayzya";
        
        String result = StringUtils.replaceChars(input, searchChars, replaceChars);
        
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("should return null if str is null")
    void testPrependIfMissingIgnoreCaseWithNullStr() {
        String result = stringUtils.prependIfMissingIgnoreCase(null, "prefix");
        assertNull(result);
    }
    
    @Test
    @DisplayName("should return str if prefix is null")
    void testPrependIfMissingIgnoreCaseWithNullPrefix() {
        String result = stringUtils.prependIfMissingIgnoreCase("str", null);
        assertEquals("str", result);
    }
    
    @Test
    @DisplayName("should return prefix + str if str does not start with prefix")
    void testPrependIfMissingIgnoreCaseWithNonMatchingPrefix() {
        String result = stringUtils.prependIfMissingIgnoreCase("str", "prefix");
        assertEquals("prefixstr", result);
    }
    
    @Test
    @DisplayName("should return str if str starts with prefix")
    void testPrependIfMissingIgnoreCaseWithMatchingPrefix() {
        String result = stringUtils.prependIfMissingIgnoreCase("prefixstr", "prefix");
        assertEquals("prefixstr", result);
    }
    
    @Test
    @DisplayName("should return prefix + str if str starts with prefix in different case")
    void testPrependIfMissingIgnoreCaseWithMatchingPrefixDifferentCase() {
        String result = stringUtils.prependIfMissingIgnoreCase("prefixstr", "PREFIX");
        assertEquals("PREFIXstr", result);
    }
    
    @Test
    @DisplayName("should return prefix + str if str starts with any of the prefixes")
    void testPrependIfMissingIgnoreCaseWithMultiplePrefixes() {
        String result = stringUtils.prependIfMissingIgnoreCase("str", "prefix", "another");
        assertEquals("prefixstr", result);
    }
    
    @Test
    @DisplayName("should return str if str starts with any of the prefixes")
    void testPrependIfMissingIgnoreCaseWithMultiplePrefixesMatching() {
        String result = stringUtils.prependIfMissingIgnoreCase("prefixstr", "prefix", "another");
        assertEquals("prefixstr", result);
    }
    
    @Test
    @DisplayName("should return str if str starts with any of the prefixes in different case")
    void testPrependIfMissingIgnoreCaseWithMultiplePrefixesMatchingDifferentCase() {
        String result = stringUtils.prependIfMissingIgnoreCase("PREFIXstr", "prefix", "another");
        assertEquals("PREFIXstr", result);
    }
    
    @Test
    @DisplayName("should return prefix + str if str starts with any of the prefixes in different case")
    void testPrependIfMissingIgnoreCaseWithMultiplePrefixesNonMatchingDifferentCase() {
        String result = stringUtils.prependIfMissingIgnoreCase("prefixstr", "PREFIX", "another");
        assertEquals("PREFIXstr", result);
    }
    
    @Test
    @DisplayName("should return prefix + str if str starts with any of the prefixes and additional prefixes are null")
    void testPrependIfMissingIgnoreCaseWithNullAdditionalPrefixes() {
        String result = stringUtils.prependIfMissingIgnoreCase("str", "prefix", null);
        assertEquals("prefixstr", result);
    }
    
    @Test
    @DisplayName("should return str if str starts with any of the prefixes and additional prefixes are empty")
    void testPrependIfMissingIgnoreCaseWithEmptyAdditionalPrefixes() {
        String result = stringUtils.prependIfMissingIgnoreCase("prefixstr", "prefix", "");
        assertEquals("prefixstr", result);
    }
    
    @Test
    @DisplayName("should return prefix + str if str starts with any of the prefixes and additional prefixes are provided")
    void testPrependIfMissingIgnoreCaseWithAdditionalPrefixes() {
        String result = stringUtils.prependIfMissingIgnoreCase("str", "prefix", "another");
        assertEquals("prefixstr", result);
    }
    
    @Test
    @DisplayName("should return str if str starts with any of the prefixes and additional prefixes are provided")
    void testPrependIfMissingIgnoreCaseWithAdditionalPrefixesMatching() {
        String result = stringUtils.prependIfMissingIgnoreCase("prefixstr", "prefix", "another");
        assertEquals("prefixstr", result);
    }
    
    @Test
    @DisplayName("should return str if str starts with any of the prefixes in different case and additional prefixes are provided")
    void testPrependIfMissingIgnoreCaseWithAdditionalPrefixesMatchingDifferentCase() {
        String result = stringUtils.prependIfMissingIgnoreCase("PREFIXstr", "prefix", "another");
        assertEquals("PREFIXstr", result);
    }
    
    @Test
    @DisplayName("should return prefix + str if str starts with any of the prefixes in different case and additional prefixes are provided")
    void testPrependIfMissingIgnoreCaseWithAdditionalPrefixesNonMatchingDifferentCase() {
        String result = stringUtils.prependIfMissingIgnoreCase("prefixstr", "PREFIX", "another");
        assertEquals("PREFIXstr", result);
    }
    @Test
    public void testNullInput() {
        assertEquals("", stringUtils.stripToEmpty(null));
    }
    
    @Test
    public void testEmptyInput() {
        assertEquals("", stringUtils.stripToEmpty(""));
    }
    
    @Test
    public void testWhitespaceInput() {
        assertEquals("", stringUtils.stripToEmpty("   "));
    }
    
    @Test
    public void testNoWhitespaceInput() {
        assertEquals("abc", stringUtils.stripToEmpty("abc"));
    }
    
    @Test
    public void testLeadingWhitespaceInput() {
        assertEquals("abc", stringUtils.stripToEmpty("  abc"));
    }
    
    @Test
    public void testTrailingWhitespaceInput() {
        assertEquals("abc", stringUtils.stripToEmpty("abc  "));
    }
    
    @Test
    public void testSurroundingWhitespaceInput() {
        assertEquals("abc", stringUtils.stripToEmpty(" abc "));
    }
    
    @Test
    public void testWhitespaceInMiddleInput() {
        assertEquals("ab c", stringUtils.stripToEmpty(" ab c "));
    }
    void testStripStart_withNullString_returnsNull() {}
    void testStripStart_withEmptyString_returnsEmptyString() {}
    void testStripStart_withNonMatchingStripChars_returnsOriginalString() {}
    void testStripStart_withEmptyStripChars_returnsOriginalString() {}
    void testStripStart_withNullStripChars_stripsWhitespace() {}
    void testStripStart_withNonEmptyStripChars_stripsMatchingCharacters() {}
    void testStripStart_withWhitespaceStringAndNullStripChars_stripsWhitespace() {}
    void testStripStart_withWhitespaceStringAndEmptyStripChars_returnsOriginalString() {}
    void testStripStart_withWhitespaceStringAndNonEmptyStripChars_returnsOriginalString() {}
    @Test
    void testCenterWithNullString() {
        String result = StringUtils.center(null, 5);
        Assertions.assertNull(result);
    }
    
    @Test
    void testCenterWithEmptyString() {
        String result = StringUtils.center("", 5);
        Assertions.assertEquals("     ", result);
    }
    
    @Test
    void testCenterWithNegativeSize() {
        String result = StringUtils.center("ab", -1);
        Assertions.assertEquals("ab", result);
    }
    
    @Test
    void testCenterWithSizeLessThanStringLength() {
        String result = StringUtils.center("abcd", 2);
        Assertions.assertEquals("abcd", result);
    }
    
    @Test
    void testCenterWithEvenSize() {
        String result = StringUtils.center("ab", 4);
        Assertions.assertEquals(" ab ", result);
    }
    
    @Test
    void testCenterWithOddSize() {
        String result = StringUtils.center("a", 4);
        Assertions.assertEquals(" a  ", result);
    }
    
    @Test
    void testCenterWithPaddingCharacter() {
        String result = StringUtils.center("a", 4, 'y');
        Assertions.assertEquals("yayy", result);
    }
    
    @Test
    void testCenterWithPaddingString() {
        String result = StringUtils.center("a", 4, "yz");
        Assertions.assertEquals("yayz", result);
    }
    
    @Test
    void testCenterWithNullPaddingString() {
        String result = StringUtils.center("abc", 7, null);
        Assertions.assertEquals("  abc  ", result);
    }
    
    @Test
    void testCenterWithEmptyPaddingString() {
        String result = StringUtils.center("abc", 7, "");
        Assertions.assertEquals("  abc  ", result);
    }
    import static org.junit.jupiter.api.Assertions.*;
    import org.junit.jupiter.api.Test;
    
    class StringUtilsTestSuite {
    
      private StringUtils stringUtils;
    
      @Test
      void testRemoveAll_NullInput_ReturnsNull() {
        assertNull(stringUtils.removeAll(null, ""));
      }
    
      @Test
      void testRemoveAll_EmptyInput_ReturnsEmpty() {
        assertEquals("", stringUtils.removeAll("", ""));
      }
    
      @Test
      void testRemoveAll_NoMatch_ReturnsInputString() {
        String input = "abc";
        assertEquals(input, stringUtils.removeAll(input, "def"));
      }
    
      @Test
      void testRemoveAll_SingleMatch_ReturnsStringWithoutMatch() {
        String input = "abc";
        assertEquals("ac", stringUtils.removeAll(input, "b"));
      }
    
      @Test
      void testRemoveAll_MultipleMatches_ReturnsStringWithoutMatches() {
        String input = "abcabcabc";
        assertEquals("acacac", stringUtils.removeAll(input, "b"));
      }
    
      @Test
      void testRemoveAll_RegexMatch_ReturnsStringWithoutMatches() {
        String input = "A<__>\n<__>B";
        assertEquals("AB", stringUtils.removeAll(input, "<.*>"));
      }
    
      @Test
      void testRemoveAll_RegexWithDotallOption_ReturnsStringWithoutMatches() {
        String input = "A<__>\n<__>B";
        assertEquals("A\nB", stringUtils.removeAll(input, "(?s)<.*>"));
      }
    
      @Test
      void testRemoveAll_RegexWithSpecialChars_ReturnsStringWithoutMatches() {
        String input = "ABCabc123abc";
        assertEquals("ABC123", stringUtils.removeAll(input, "[a-z]"));
      }
    
    }
    @Test
    @DisplayName("Empty string should return false")
    void testContainsWhitespace_EmptyString() {
        assertFalse(stringUtils.containsWhitespace(""));
    }
    
    @Test
    @DisplayName("String without whitespace should return false")
    void testContainsWhitespace_NoWhitespace() {
        assertFalse(stringUtils.containsWhitespace("HelloWorld"));
    }
    
    @Test
    @DisplayName("String with whitespace should return true")
    void testContainsWhitespace_WithWhitespace() {
        assertTrue(stringUtils.containsWhitespace("Hello World"));
    }
    
    @Test
    @DisplayName("String with leading whitespace should return true")
    void testContainsWhitespace_LeadingWhitespace() {
        assertTrue(stringUtils.containsWhitespace("  HelloWorld"));
    }
    
    @Test
    @DisplayName("String with trailing whitespace should return true")
    void testContainsWhitespace_TrailingWhitespace() {
        assertTrue(stringUtils.containsWhitespace("HelloWorld  "));
    }
    
    @Test
    @DisplayName("String with whitespace in the middle should return true")
    void testContainsWhitespace_WhitespaceInMiddle() {
        assertTrue(stringUtils.containsWhitespace("Hello World!"));
    }
    
    @Test
    @DisplayName("String with multiple whitespace characters should return true")
    void testContainsWhitespace_MultipleWhitespaceCharacters() {
        assertTrue(stringUtils.containsWhitespace("Hello    World"));
    }
    
    @Test
    @DisplayName("String with only whitespace characters should return true")
    void testContainsWhitespace_OnlyWhitespaceCharacters() {
        assertTrue(stringUtils.containsWhitespace("   "));
    }
    
    @Test
    @DisplayName("String with non-breaking whitespace characters should return true")
    void testContainsWhitespace_NonBreakingWhitespaceCharacters() {
        assertTrue(stringUtils.containsWhitespace("Hello\u00A0World"));
    }
    
    @Test
    @DisplayName("Null string should return false")
    void testContainsWhitespace_NullString() {
        assertFalse(stringUtils.containsWhitespace(null));
    }
    // Your Java code here
    
    @Test
    void testIsAlphaSpace_Null_ReturnsFalse() {
        assertFalse(StringUtils.isAlphaSpace(null));
    }
    
    @Test
    void testIsAlphaSpace_EmptyString_ReturnsTrue() {
        assertTrue(StringUtils.isAlphaSpace(""));
    }
    
    @Test
    void testIsAlphaSpace_OnlySpaces_ReturnsTrue() {
        assertTrue(StringUtils.isAlphaSpace("  "));
    }
    
    @Test
    void testIsAlphaSpace_OnlyLetters_ReturnsTrue() {
        assertTrue(StringUtils.isAlphaSpace("abc"));
    }
    
    @Test
    void testIsAlphaSpace_LettersAndSpace_ReturnsTrue() {
        assertTrue(StringUtils.isAlphaSpace("ab c"));
    }
    
    @Test
    void testIsAlphaSpace_LettersAndNumbers_ReturnsFalse() {
        assertFalse(StringUtils.isAlphaSpace("ab2c"));
    }
    
    @Test
    void testIsAlphaSpace_LettersAndSymbols_ReturnsFalse() {
        assertFalse(StringUtils.isAlphaSpace("ab-c"));
    }
    @Test
    @DisplayName("should return encoded string using the specified character encoding")
    void shouldReturnEncodedStringUsingSpecifiedCharset() {
        // Arrange
        byte[] bytes = new byte[]{97, 98, 99}; // "abc"
        Charset charset = StandardCharsets.UTF_8;
        String expected = "abc";
    
        // Act
        String result = StringUtils.toEncodedString(bytes, charset);
    
        // Assert
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("should return encoded string using the default character encoding if charset is null")
    void shouldReturnEncodedStringUsingDefaultCharsetIfCharsetIsNull() {
        // Arrange
        byte[] bytes = new byte[]{97, 98, 99}; // "abc"
        Charset charset = null;
        String expected = "abc";
    
        // Act
        String result = StringUtils.toEncodedString(bytes, charset);
    
        // Assert
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("returns true for an all uppercase string")
    void testIsAllUpperCase_AllUppercaseString_ReturnsTrue() {
        assertTrue(StringUtils.isAllUpperCase("ABC"));
    }
    
    @Test
    @DisplayName("returns false for a string with lowercase characters")
    void testIsAllUpperCase_StringWithLowercaseCharacters_ReturnsFalse() {
        assertFalse(StringUtils.isAllUpperCase("aBC"));
    }
    
    @Test
    @DisplayName("returns false for a string with a space character")
    void testIsAllUpperCase_StringWithSpaceCharacter_ReturnsFalse() {
        assertFalse(StringUtils.isAllUpperCase("A C"));
    }
    
    @Test
    @DisplayName("returns false for a string with a digit character")
    void testIsAllUpperCase_StringWithDigitCharacter_ReturnsFalse() {
        assertFalse(StringUtils.isAllUpperCase("A1C"));
    }
    
    @Test
    @DisplayName("returns false for a string with a special character")
    void testIsAllUpperCase_StringWithSpecialCharacter_ReturnsFalse() {
        assertFalse(StringUtils.isAllUpperCase("A/C"));
    }
    
    @Test
    @DisplayName("returns false for null input")
    void testIsAllUpperCase_NullInput_ReturnsFalse() {
        assertFalse(StringUtils.isAllUpperCase(null));
    }
    
    @Test
    @DisplayName("returns false for an empty string")
    void testIsAllUpperCase_EmptyString_ReturnsFalse() {
        assertFalse(StringUtils.isAllUpperCase(""));
    }
    
    @Test
    @DisplayName("returns false for a string with only whitespace characters")
    void testIsAllUpperCase_StringWithWhitespaceCharacters_ReturnsFalse() {
        assertFalse(StringUtils.isAllUpperCase("  "));
    }
    @Test
    void testGetIfEmpty_withNullStringAndNonNullDefaultSupplier_shouldReturnDefault() {
        String str = null;
        Supplier<String> defaultSupplier = () -> "DEFAULT";
        String result = stringUtils.getIfEmpty(str, defaultSupplier);
        assertEquals("DEFAULT", result);
    }
    
    @Test
    void testGetIfEmpty_withEmptyStringAndNonNullDefaultSupplier_shouldReturnDefault() {
        String str = "";
        Supplier<String> defaultSupplier = () -> "DEFAULT";
        String result = stringUtils.getIfEmpty(str, defaultSupplier);
        assertEquals("DEFAULT", result);
    }
    
    @Test
    void testGetIfEmpty_withWhitespaceStringAndNonNullDefaultSupplier_shouldReturnString() {
        String str = " ";
        Supplier<String> defaultSupplier = () -> "DEFAULT";
        String result = stringUtils.getIfEmpty(str, defaultSupplier);
        assertEquals(" ", result);
    }
    
    @Test
    void testGetIfEmpty_withNonEmptyStringAndNonNullDefaultSupplier_shouldReturnString() {
        String str = "bat";
        Supplier<String> defaultSupplier = () -> "DEFAULT";
        String result = stringUtils.getIfEmpty(str, defaultSupplier);
        assertEquals("bat", result);
    }
    
    @Test
    void testGetIfEmpty_withEmptyStringAndNullDefaultSupplier_shouldReturnNull() {
        String str = "";
        Supplier<String> defaultSupplier = null;
        String result = stringUtils.getIfEmpty(str, defaultSupplier);
        assertNull(result);
    }
    
    @Test
    void testGetIfEmpty_withEmptyStringAndNonNullDefaultSupplierReturningNull_shouldReturnNull() {
        String str = "";
        Supplier<String> defaultSupplier = () -> null;
        String result = stringUtils.getIfEmpty(str, defaultSupplier);
        assertNull(result);
    }
    
    @Test
    void testGetIfEmpty_withNullStringAndNullDefaultSupplier_shouldReturnNull() {
        String str = null;
        Supplier<String> defaultSupplier = null;
        String result = stringUtils.getIfEmpty(str, defaultSupplier);
        assertNull(result);
    }
    
    @Test
    void testGetIfEmpty_withEmptyStringAndEmptyDefaultSupplier_shouldReturnEmptyString() {
        String str = "";
        Supplier<String> defaultSupplier = () -> "";
        String result = stringUtils.getIfEmpty(str, defaultSupplier);
        assertEquals("", result);
    }
    @Test
    @DisplayName("Should return true when cs is null")
    void testContainsNoneCharArrayWithNullCs() {
        assertTrue(StringUtils.containsNone(null, 'a', 'b', 'c'));
    }
    
    @Test
    @DisplayName("Should return true when searchChars is null")
    void testContainsNoneCharArrayWithNullSearchChars() {
        assertTrue(StringUtils.containsNone("abc", null));
    }
    
    @Test
    @DisplayName("Should return true when cs is an empty string")
    void testContainsNoneCharArrayWithEmptyCs() {
        assertTrue(StringUtils.containsNone("", 'a', 'b', 'c'));
    }
    
    @Test
    @DisplayName("Should return true when cs does not contain any of the searchChars")
    void testContainsNoneCharArrayWithNoMatches() {
        assertTrue(StringUtils.containsNone("def", 'a', 'b', 'c'));
    }
    
    @Test
    @DisplayName("Should return false when cs contains at least one of the searchChars")
    void testContainsNoneCharArrayWithMatches() {
        assertFalse(StringUtils.containsNone("abc", 'a', 'b', 'c'));
    }
    
    @Test
    @DisplayName("Should return false when cs contains a high surrogate followed by a searchChar")
    void testContainsNoneCharArrayWithHighSurrogate() {
        assertFalse(StringUtils.containsNone("a\uD800b", 'a', 'b'));
    }
    
    @Test
    @DisplayName("Should return false when cs contains a low surrogate preceded by a searchChar")
    void testContainsNoneCharArrayWithLowSurrogate() {
        assertFalse(StringUtils.containsNone("ab\uDFFF", 'a', 'b'));
    }
    
    @Test
    @DisplayName("Should return false when cs contains a high surrogate followed by a low surrogate preceded by a searchChar")
    void testContainsNoneCharArrayWithHighAndLowSurrogate() {
        assertFalse(StringUtils.containsNone("a\uD800\uDFFFb", 'a', 'b'));
    }
    
    @Test
    @DisplayName("Should return true when cs is null")
    void testContainsNoneStringWithNullCs() {
        assertTrue(StringUtils.containsNone(null, "abc"));
    }
    
    @Test
    @DisplayName("Should return true when invalidChars is null")
    void testContainsNoneStringWithNullInvalidChars() {
        assertTrue(StringUtils.containsNone("abc", null));
    }
    
    @Test
    @DisplayName("Should return true when cs is an empty string")
    void testContainsNoneStringWithEmptyCs() {
        assertTrue(StringUtils.containsNone("", "abc"));
    }
    
    @Test
    @DisplayName("Should return true when cs does not contain any of the invalidChars")
    void testContainsNoneStringWithNoMatches() {
        assertTrue(StringUtils.containsNone("def", "abc"));
    }
    
    @Test
    @DisplayName("Should return false when cs contains at least one of the invalidChars")
    void testContainsNoneStringWithMatches() {
        assertFalse(StringUtils.containsNone("abc", "abc"));
    }
    
    @Test
    @DisplayName("Should return false when cs contains a high surrogate followed by an invalidChar")
    void testContainsNoneStringWithHighSurrogate() {
        assertFalse(StringUtils.containsNone("a\uD800b", "ab"));
    }
    
    @Test
    @DisplayName("Should return false when cs contains a low surrogate preceded by an invalidChar")
    void testContainsNoneStringWithLowSurrogate() {
        assertFalse(StringUtils.containsNone("ab\uDFFF", "ab"));
    }
    
    @Test
    @DisplayName("Should return false when cs contains a high surrogate followed by a low surrogate preceded by an invalidChar")
    void testContainsNoneStringWithHighAndLowSurrogate() {
        assertFalse(StringUtils.containsNone("a\uD800\uDFFFb", "ab"));
    }
    @Test
    @DisplayName("When given null string, should return null")
    void testLeftWithNullString() {
        // Arrange
        String str = null;
        int len = 5;
    
        // Act
        String result = StringUtils.left(str, len);
    
        // Assert
        assertNull(result);
    }
    
    @Test
    @DisplayName("When given negative length, should return empty string")
    void testLeftWithNegativeLength() {
        // Arrange
        String str = "abcdef";
        int len = -5;
    
        // Act
        String result = StringUtils.left(str, len);
    
        // Assert
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("When given empty string, should return empty string")
    void testLeftWithEmptyString() {
        // Arrange
        String str = "";
        int len = 5;
    
        // Act
        String result = StringUtils.left(str, len);
    
        // Assert
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("When len is 0, should return empty string")
    void testLeftWithZeroLength() {
        // Arrange
        String str = "abcdef";
        int len = 0;
    
        // Act
        String result = StringUtils.left(str, len);
    
        // Assert
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("When len is greater than string length, should return the whole string")
    void testLeftWithLengthGreaterThanString() {
        // Arrange
        String str = "abcdef";
        int len = 10;
    
        // Act
        String result = StringUtils.left(str, len);
    
        // Assert
        assertEquals("abcdef", result);
    }
    
    @Test
    @DisplayName("When len is less than string length, should return the leftmost characters")
    void testLeftWithLengthLessThanString() {
        // Arrange
        String str = "abcdef";
        int len = 3;
    
        // Act
        String result = StringUtils.left(str, len);
    
        // Assert
        assertEquals("abc", result);
    }
    import static org.junit.jupiter.api.Assertions.assertEquals;
    
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Test;
    
    class StringUtilsTestSuite {
    
        private StringUtils stringUtils;
        
        @BeforeEach
        void setUp() {
            stringUtils = new StringUtils();
        }
        
        @Test
        void shouldReturnMinusOneWhenInputIsNull() {
            // Arrange
            CharSequence[] css = null;
            
            // Act
            int result = stringUtils.indexOfDifference(css);
            
            // Assert
            assertEquals(-1, result);
        }
        
        @Test
        void shouldReturnMinusOneWhenInputIsEmpty() {
            // Arrange
            CharSequence[] css = {};
            
            // Act
            int result = stringUtils.indexOfDifference(css);
            
            // Assert
            assertEquals(-1, result);
        }
        
        @Test
        void shouldReturnMinusOneWhenInputContainsOnlyOneCharSequence() {
            // Arrange
            CharSequence[] css = {"abc"};
            
            // Act
            int result = stringUtils.indexOfDifference(css);
            
            // Assert
            assertEquals(-1, result);
        }
        
        @Test
        void shouldReturnMinusOneWhenInputContainsTwoNullCharSequences() {
            // Arrange
            CharSequence[] css = {null, null};
            
            // Act
            int result = stringUtils.indexOfDifference(css);
            
            // Assert
            assertEquals(-1, result);
        }
        
        @Test
        void shouldReturnMinusOneWhenInputContainsTwoEmptyCharSequences() {
            // Arrange
            CharSequence[] css = {"", ""};
            
            // Act
            int result = stringUtils.indexOfDifference(css);
            
            // Assert
            assertEquals(-1, result);
        }
        
        @Test
        void shouldReturnMinusOneWhenInputContainsTwoIdenticalNonEmptyCharSequences() {
            // Arrange
            CharSequence[] css = {"abc", "abc"};
            
            // Act
            int result = stringUtils.indexOfDifference(css);
            
            // Assert
            assertEquals(-1, result);
        }
        
        @Test
        void shouldReturnZeroWhenInputContainsTwoCharSequencesWhereOneIsEmptyAndTheOtherIsNull() {
            // Arrange
            CharSequence[] css = {"", null};
            
            // Act
            int result = stringUtils.indexOfDifference(css);
            
            // Assert
            assertEquals(0, result);
        }
        
        @Test
        void shouldReturnZeroWhenInputContainsTwoCharSequencesWhereOneIsNonEmptyAndTheOtherIsNull() {
            // Arrange
            CharSequence[] css = {"abc", null};
            
            // Act
            int result = stringUtils.indexOfDifference(css);
            
            // Assert
            assertEquals(0, result);
        }
        
        @Test
        void shouldReturnZeroWhenInputContainsTwoCharSequencesWhereOneIsNullAndTheOtherIsNonEmpty() {
            // Arrange
            CharSequence[] css = {null, "abc"};
            
            // Act
            int result = stringUtils.indexOfDifference(css);
            
            // Assert
            assertEquals(0, result);
        }
        
        @Test
        void shouldReturnZeroWhenInputContainsThreeCharSequencesWhereTwoAreNullAndOneIsEmpty() {
            // Arrange
            CharSequence[] css = {"", null, null};
            
            // Act
            int result = stringUtils.indexOfDifference(css);
            
            // Assert
            assertEquals(0, result);
        }
        
        @Test
        void shouldReturnZeroWhenInputContainsThreeCharSequencesWhereTwoAreNullAndOneIsNonEmpty() {
            // Arrange
            CharSequence[] css = {"abc", null, null};
            
            // Act
            int result = stringUtils.indexOfDifference(css);
            
            // Assert
            assertEquals(0, result);
        }
        
        @Test
        void shouldReturnZeroWhenInputContainsThreeCharSequencesWhereOneIsNullAndTwoAreNonEmpty() {
            // Arrange
            CharSequence[] css = {null, null, "abc"};
            
            // Act
            int result = stringUtils.indexOfDifference(css);
            
            // Assert
            assertEquals(0, result);
        }
        
        @Test
        void shouldReturnOneWhenInputContainsTwoCharSequencesThatDifferAtTheSecondCharacter() {
            // Arrange
            CharSequence[] css = {"abc", "adc"};
            
            // Act
            int result = stringUtils.indexOfDifference(css);
            
            // Assert
            assertEquals(1, result);
        }
        
        @Test
        void shouldReturnTwoWhenInputContainsTwoCharSequencesThatDifferAtTheThirdCharacter() {
            // Arrange
            CharSequence[] css = {"abc", "abd"};
            
            // Act
            int result = stringUtils.indexOfDifference(css);
            
            // Assert
            assertEquals(2, result);
        }
        
        @Test
        void shouldReturnTwoWhenInputContainsTwoCharSequencesWithDifferentLengthsAndTheDifferenceIsAtTheSecondCharacter() {
            // Arrange
            CharSequence[] css = {"ab", "adc"};
            
            // Act
            int result = stringUtils.indexOfDifference(css);
            
            // Assert
            assertEquals(2, result);
        }
        
        @Test
        void shouldReturnTwoWhenInputContainsTwoCharSequencesWithDifferentLengthsAndTheDifferenceIsAtTheThirdCharacter() {
            // Arrange
            CharSequence[] css = {"abc", "ad"};
            
            // Act
            int result = stringUtils.indexOfDifference(css);
            
            // Assert
            assertEquals(2, result);
        }
        
        @Test
        void shouldReturnSevenWhenInputContainsTwoCharSequencesWithDifferentLengthsAndTheDifferenceIsAtTheSeventhCharacter() {
            // Arrange
            CharSequence[] css = {"i am a machine", "i am a robot"};
            
            // Act
            int result = stringUtils.indexOfDifference(css);
            
            // Assert
            assertEquals(7, result);
        }
        
        @Test
        void shouldReturnMinusOneWhenBothInputCharSequencesAreNull() {
            // Arrange
            CharSequence cs1 = null;
            CharSequence cs2 = null;
            
            // Act
            int result = stringUtils.indexOfDifference(cs1, cs2);
            
            // Assert
            assertEquals(-1, result);
        }
        
        @Test
        void shouldReturnMinusOneWhenBothInputCharSequencesAreEmpty() {
            // Arrange
            CharSequence cs1 = "";
            CharSequence cs2 = "";
            
            // Act
            int result = stringUtils.indexOfDifference(cs1, cs2);
            
            // Assert
            assertEquals(-1, result);
        }
        
        @Test
        void shouldReturnZeroWhenOneInputCharSequenceIsEmptyAndTheOtherIsNull() {
            // Arrange
            CharSequence cs1 = "";
            CharSequence cs2 = null;
            
            // Act
            int result = stringUtils.indexOfDifference(cs1, cs2);
            
            // Assert
            assertEquals(0, result);
        }
        
        @Test
        void shouldReturnZeroWhenOneInputCharSequenceIsNullAndTheOtherIsEmpty() {
            // Arrange
            CharSequence cs1 = null;
            CharSequence cs2 = "";
            
            // Act
            int result = stringUtils.indexOfDifference(cs1, cs2);
            
            // Assert
            assertEquals(0, result);
        }
        
        @Test
        void shouldReturnMinusOneWhenBothInputCharSequencesAreEqual() {
            // Arrange
            CharSequence cs1 = "abc";
            CharSequence cs2 = "abc";
            
            // Act
            int result = stringUtils.indexOfDifference(cs1, cs2);
            
            // Assert
            assertEquals(-1, result);
        }
        
        @Test
        void shouldReturnZeroWhenOneInputCharSequenceIsEmptyAndTheOtherIsNonEmpty() {
            // Arrange
            CharSequence cs1 = "";
            CharSequence cs2 = "abc";
            
            // Act
            int result = stringUtils.indexOfDifference(cs1, cs2);
            
            // Assert
            assertEquals(0, result);
        }
        
        @Test
        void shouldReturnZeroWhenOneInputCharSequenceIsNonEmptyAndTheOtherIsEmpty() {
            // Arrange
            CharSequence cs1 = "abc";
            CharSequence cs2 = "";
            
            // Act
            int result = stringUtils.indexOfDifference(cs1, cs2);
            
            // Assert
            assertEquals(0, result);
        }
        
        @Test
        void shouldReturnOneWhenInputCharSequencesDifferAtTheSecondCharacter() {
            // Arrange
            CharSequence cs1 = "abc";
            CharSequence cs2 = "adc";
            
            // Act
            int result = stringUtils.indexOfDifference(cs1, cs2);
            
            // Assert
            assertEquals(1, result);
        }
        
        @Test
        void shouldReturnTwoWhenInputCharSequencesDifferAtTheThirdCharacter() {
            // Arrange
            CharSequence cs1 = "abc";
            CharSequence cs2 = "abd";
            
            // Act
            int result = stringUtils.indexOfDifference(cs1, cs2);
            
            // Assert
            assertEquals(2, result);
        }
        
        @Test
        void shouldReturnTwoWhenInputCharSequencesHaveDifferentLengthsAndTheDifferenceIsAtTheSecondCharacter() {
            // Arrange
            CharSequence cs1 = "ab";
            CharSequence cs2 = "adc";
            
            // Act
            int result = stringUtils.indexOfDifference(cs1, cs2);
            
            // Assert
            assertEquals(2, result);
        }
        
        @Test
        void shouldReturnTwoWhenInputCharSequencesHaveDifferentLengthsAndTheDifferenceIsAtTheThirdCharacter() {
            // Arrange
            CharSequence cs1 = "abc";
            CharSequence cs2 = "ad";
            
            // Act
            int result = stringUtils.indexOfDifference(cs1, cs2);
            
            // Assert
            assertEquals(2, result);
        }
        
        @Test
        void shouldReturnSevenWhenInputCharSequencesHaveDifferentLengthsAndTheDifferenceIsAtTheSeventhCharacter() {
            // Arrange
            CharSequence cs1 = "i am a machine";
            CharSequence cs2 = "i am a robot";
            
            // Act
            int result = stringUtils.indexOfDifference(cs1, cs2);
            
            // Assert
            assertEquals(7, result);
        }
    }
    @Test
    public void testIndexOfIgnoreCase_NullString_ReturnsNegativeOne() {
        int result = stringUtils.indexOfIgnoreCase(null, "abc");
        assertEquals(-1, result);
    }
    
    @Test
    public void testIndexOfIgnoreCase_NullSearchStr_ReturnsNegativeOne() {
        int result = stringUtils.indexOfIgnoreCase("abc", null);
        assertEquals(-1, result);
    }
    
    @Test
    public void testIndexOfIgnoreCase_EmptyString_ReturnsZero() {
        int result = stringUtils.indexOfIgnoreCase("", "abc");
        assertEquals(0, result);
    }
    
    @Test
    public void testIndexOfIgnoreCase_EmptySearchStr_ReturnsStartPos() {
        int result = stringUtils.indexOfIgnoreCase("abc", "");
        assertEquals(0, result);
    }
    
    @Test
    public void testIndexOfIgnoreCase_StartPosLessThanZero_ReturnsStartPosAsZero() {
        int result = stringUtils.indexOfIgnoreCase("abc", "a", -1);
        assertEquals(0, result);
    }
    
    @Test
    public void testIndexOfIgnoreCase_StartPosGreaterThanStringLength_ReturnsNegativeOne() {
        int result = stringUtils.indexOfIgnoreCase("abc", "a", 4);
        assertEquals(-1, result);
    }
    
    @Test
    public void testIndexOfIgnoreCase_SearchStrLengthZero_ReturnsStartPos() {
        int result = stringUtils.indexOfIgnoreCase("abc", "", 2);
        assertEquals(2, result);
    }
    
    @Test
    public void testIndexOfIgnoreCase_CaseSensitiveMatch_ReturnsCorrectIndex() {
        int result = stringUtils.indexOfIgnoreCase("aabaabaa", "a");
        assertEquals(0, result);
    }
    
    @Test
    public void testIndexOfIgnoreCase_CaseInsensitiveMatch_ReturnsCorrectIndex() {
        int result = stringUtils.indexOfIgnoreCase("aabaabaa", "A");
        assertEquals(0, result);
    }
    
    @Test
    public void testIndexOfIgnoreCase_NoMatch_ReturnsNegativeOne() {
        int result = stringUtils.indexOfIgnoreCase("aabaabaa", "x");
        assertEquals(-1, result);
    }
    
    @Test
    public void testIndexOfIgnoreCase_PartialMatch_ReturnsCorrectIndex() {
        int result = stringUtils.indexOfIgnoreCase("aabaabaa", "ab");
        assertEquals(1, result);
    }
    
    @Test
    public void testIndexOfIgnoreCase_MultipleMatches_ReturnsFirstMatchIndex() {
        int result = stringUtils.indexOfIgnoreCase("aabaabaa", "b");
        assertEquals(2, result);
    }
    @Test
    void testJoinWith() {
        // Test case 1: delimiter is null, array is empty
        String delimiter1 = null;
        Object[] array1 = {};
        String expected1 = "";
        String result1 = StringUtils.joinWith(delimiter1, array1);
        assertEquals(expected1, result1);
        
        // Test case 2: delimiter is null, array has one element
        String delimiter2 = null;
        Object[] array2 = {"a"};
        String expected2 = "a";
        String result2 = StringUtils.joinWith(delimiter2, array2);
        assertEquals(expected2, result2);
        
        // Test case 3: delimiter is null, array has multiple elements
        String delimiter3 = null;
        Object[] array3 = {"a", "b", "c"};
        String expected3 = "abc";
        String result3 = StringUtils.joinWith(delimiter3, array3);
        assertEquals(expected3, result3);
        
        // Test case 4: delimiter is empty, array is empty
        String delimiter4 = "";
        Object[] array4 = {};
        String expected4 = "";
        String result4 = StringUtils.joinWith(delimiter4, array4);
        assertEquals(expected4, result4);
        
        // Test case 5: delimiter is empty, array has one element
        String delimiter5 = "";
        Object[] array5 = {"a"};
        String expected5 = "a";
        String result5 = StringUtils.joinWith(delimiter5, array5);
        assertEquals(expected5, result5);
        
        // Test case 6: delimiter is empty, array has multiple elements
        String delimiter6 = "";
        Object[] array6 = {"a", "b", "c"};
        String expected6 = "abc";
        String result6 = StringUtils.joinWith(delimiter6, array6);
        assertEquals(expected6, result6);
        
        // Test case 7: delimiter is ",", array is empty
        String delimiter7 = ",";
        Object[] array7 = {};
        String expected7 = "";
        String result7 = StringUtils.joinWith(delimiter7, array7);
        assertEquals(expected7, result7);
        
        // Test case 8: delimiter is ",", array has one element
        String delimiter8 = ",";
        Object[] array8 = {"a"};
        String expected8 = "a";
        String result8 = StringUtils.joinWith(delimiter8, array8);
        assertEquals(expected8, result8);
        
        // Test case 9: delimiter is ",", array has multiple elements
        String delimiter9 = ",";
        Object[] array9 = {"a", "b", "c"};
        String expected9 = "a,b,c";
        String result9 = StringUtils.joinWith(delimiter9, array9);
        assertEquals(expected9, result9);
        
        // Test case 10: delimiter is null, array contains null elements
        String delimiter10 = null;
        Object[] array10 = {"a", null, "b"};
        String expected10 = "a,,b";
        String result10 = StringUtils.joinWith(delimiter10, array10);
        assertEquals(expected10, result10);
        
        // Test case 11: delimiter is ",", array contains null elements
        String delimiter11 = ",";
        Object[] array11 = {"a", null, "b"};
        String expected11 = "a,,b";
        String result11 = StringUtils.joinWith(delimiter11, array11);
        assertEquals(expected11, result11);
    }
    @Test
    void testIsAnyEmpty_WithNullInput_ReturnsTrue() {
        assertTrue(StringUtils.isAnyEmpty((CharSequence) null));
    }
    
    @Test
    void testIsAnyEmpty_WithNullArrayInput_ReturnsFalse() {
        assertFalse(StringUtils.isAnyEmpty((CharSequence[]) null));
    }
    
    @Test
    void testIsAnyEmpty_WithNullAndNonEmpty_ReturnsTrue() {
        assertTrue(StringUtils.isAnyEmpty(null, "foo"));
    }
    
    @Test
    void testIsAnyEmpty_WithEmptyAndNonEmpty_ReturnsTrue() {
        assertTrue(StringUtils.isAnyEmpty("", "bar"));
    }
    
    @Test
    void testIsAnyEmpty_WithNonEmptyAndEmpty_ReturnsTrue() {
        assertTrue(StringUtils.isAnyEmpty("bob", ""));
    }
    
    @Test
    void testIsAnyEmpty_WithWhiteSpaceAndNull_ReturnsTrue() {
        assertTrue(StringUtils.isAnyEmpty("  bob  ", null));
    }
    
    @Test
    void testIsAnyEmpty_WithWhiteSpaceAndNonEmpty_ReturnsFalse() {
        assertFalse(StringUtils.isAnyEmpty(" ", "bar"));
    }
    
    @Test
    void testIsAnyEmpty_WithNonEmptyInputs_ReturnsFalse() {
        assertFalse(StringUtils.isAnyEmpty("foo", "bar"));
    }
    
    @Test
    void testIsAnyEmpty_WithEmptyArray_ReturnsFalse() {
        assertFalse(StringUtils.isAnyEmpty(new CharSequence[] {}));
    }
    
    @Test
    void testIsAnyEmpty_WithEmptyStringArray_ReturnsTrue() {
        assertTrue(StringUtils.isAnyEmpty(new CharSequence[] {""}));
    }
    @Test
    @DisplayName("Test mid() with null string")
    void testMidWithNullString() {
        assertNull(stringUtils.mid(null, 0, 2));
    }
    
    @Test
    @DisplayName("Test mid() with valid string and positions")
    void testMidWithValidStringAndPositions(String str, int pos, int len, String expected) {
        assertEquals(expected, stringUtils.mid(str, pos, len));
    }
    
    @Test
    @DisplayName("Test mid() with invalid positions")
    void testMidWithInvalidPositions(String str, int pos, int len, String expected) {
        assertEquals(expected, stringUtils.mid(str, pos, len));
    }
    @Test
    void testEndsWithNullNull() {
        assertTrue(StringUtils.endsWith(null, null));
    }
    
    @Test
    void testEndsWithNullSuffix() {
        assertFalse(StringUtils.endsWith(null, "def"));
    }
    
    @Test
    void testEndsWithStringNull() {
        assertFalse(StringUtils.endsWith("abcdef", null));
    }
    
    @Test
    void testEndsWithStringSuffixTrue() {
        assertTrue(StringUtils.endsWith("abcdef", "def"));
    }
    
    @Test
    void testEndsWithStringSuffixFalse() {
        assertFalse(StringUtils.endsWith("ABCDEF", "def"));
    }
    
    @Test
    void testEndsWithStringSuffixFalseCaseInsensitive() {
        assertFalse(StringUtils.endsWith("ABCDEF", "cde"));
    }
    
    @Test
    void testEndsWithStringEmptySuffix() {
        assertTrue(StringUtils.endsWith("ABCDEF", ""));
    }
    @Test
    @DisplayName("Should return 0 when input is null")
    void shouldReturnZeroWhenInputIsNull() {
        // Arrange
        CharSequence input = null;
    
        // Act
        int result = stringUtils.length(input);
    
        // Assert
        assertEquals(0, result);
    }
    
    @Test
    @DisplayName("Should return 0 when input is an empty string")
    void shouldReturnZeroWhenInputIsEmptyString() {
        // Arrange
        CharSequence input = "";
    
        // Act
        int result = stringUtils.length(input);
    
        // Assert
        assertEquals(0, result);
    }
    
    @Test
    @DisplayName("Should return the length of the input string")
    void shouldReturnLengthOfInputString() {
        // Arrange
        CharSequence input = "Hello World";
    
        // Act
        int result = stringUtils.length(input);
    
        // Assert
        assertEquals(11, result);
    }
    @Test
    void testEndsWithAny_NullSequence_NullSearchStrings_ReturnsFalse() {
        assertFalse(StringUtils.endsWithAny(null, null));
    }
    
    @Test
    void testEndsWithAny_NullSequence_EmptySearchStrings_ReturnsFalse() {
        assertFalse(StringUtils.endsWithAny(null));
    }
    
    @Test
    void testEndsWithAny_NullSequence_NonEmptySearchStrings_ReturnsFalse() {
        assertFalse(StringUtils.endsWithAny(null, "abc"));
    }
    
    @Test
    void testEndsWithAny_EmptySequence_NullSearchStrings_ReturnsFalse() {
        assertFalse(StringUtils.endsWithAny("", null));
    }
    
    @Test
    void testEndsWithAny_EmptySequence_EmptySearchStrings_ReturnsFalse() {
        assertFalse(StringUtils.endsWithAny(""));
    }
    
    @Test
    void testEndsWithAny_EmptySequence_NonEmptySearchStrings_ReturnsFalse() {
        assertFalse(StringUtils.endsWithAny("", "abc"));
    }
    
    @Test
    void testEndsWithAny_NonEmptySequence_NullSearchStrings_ReturnsFalse() {
        assertFalse(StringUtils.endsWithAny("abcxyz", null));
    }
    
    @Test
    void testEndsWithAny_NonEmptySequence_EmptySearchStrings_ReturnsTrue() {
        assertTrue(StringUtils.endsWithAny("abcxyz"));
    }
    
    @Test
    void testEndsWithAny_NonEmptySequence_NonEmptySearchStrings_NoMatch_ReturnsFalse() {
        assertFalse(StringUtils.endsWithAny("abcxyz", "def"));
    }
    
    @Test
    void testEndsWithAny_NonEmptySequence_NonEmptySearchStrings_Match_ReturnsTrue() {
        assertTrue(StringUtils.endsWithAny("abcxyz", "xyz"));
    }
    
    @Test
    void testEndsWithAny_NonEmptySequence_NonEmptySearchStrings_MultipleMatches_ReturnsTrue() {
        assertTrue(StringUtils.endsWithAny("abcxyz", null, "xyz", "abc"));
    }
    
    @Test
    void testEndsWithAny_NonEmptySequence_NonEmptySearchStrings_CaseSensitiveMatch_ReturnsTrue() {
        assertTrue(StringUtils.endsWithAny("abcXYZ", "def", "XYZ"));
    }
    
    @Test
    void testEndsWithAny_NonEmptySequence_NonEmptySearchStrings_CaseSensitiveNoMatch_ReturnsFalse() {
        assertFalse(StringUtils.endsWithAny("abcXYZ", "def", "xyz"));
    }
    import static org.junit.jupiter.api.Assertions.assertEquals;
    
    import org.junit.jupiter.api.Test;
    
    class StringUtilsMatchesTest {
    
        @Test
        void shouldReturnCorrectMatchValues() {
            String first = "hello";
            String second = "hello";
            int[] expected = {5, 0, 5, 5};
            int[] result = StringUtils.matches(first, second);
            assertEquals(expected, result);
        }
    
        @Test
        void shouldReturnCorrectMatchValues2() {
            String first = "hello";
            String second = "hella";
            int[] expected = {4, 0, 4, 5};
            int[] result = StringUtils.matches(first, second);
            assertEquals(expected, result);
        }
    
        @Test
        void shouldReturnCorrectMatchValues3() {
            String first = "hello";
            String second = "hallo";
            int[] expected = {4, 0, 1, 5};
            int[] result = StringUtils.matches(first, second);
            assertEquals(expected, result);
        }
    
        @Test
        void shouldReturnCorrectMatchValues4() {
            String first = "hello";
            String second = "world";
            int[] expected = {0, 0, 0, 5};
            int[] result = StringUtils.matches(first, second);
            assertEquals(expected, result);
        }
    }
    @Test
    @DisplayName("Should return true for null input")
    void isBlank_NullInput_ReturnsTrue() {
        assertTrue(stringUtils.isBlank(null));
    }
    
    @Test
    @DisplayName("Should return true for empty string")
    void isBlank_EmptyString_ReturnsTrue() {
        assertTrue(stringUtils.isBlank(""));
    }
    
    @Test
    @DisplayName("Should return true for whitespace only string")
    void isBlank_WhitespaceString_ReturnsTrue() {
        assertTrue(stringUtils.isBlank(" "));
    }
    
    @Test
    @DisplayName("Should return false for non-blank string")
    void isBlank_NonBlankString_ReturnsFalse() {
        assertFalse(stringUtils.isBlank("bob"));
    }
    
    @Test
    @DisplayName("Should return false for string with leading and trailing whitespace")
    void isBlank_StringWithWhitespace_ReturnsFalse() {
        assertFalse(stringUtils.isBlank("  bob  "));
    }
    @Test
    void shouldReturnIndexNotFoundWhenStringIsNull() {
        int lastIndex = StringUtils.lastIndexOfIgnoreCase(null, "abc");
        assertEquals(StringUtils.INDEX_NOT_FOUND, lastIndex);
    }
    
    @Test
    void shouldReturnIndexNotFoundWhenSearchStringIsNull() {
        int lastIndex = StringUtils.lastIndexOfIgnoreCase("abc", null);
        assertEquals(StringUtils.INDEX_NOT_FOUND, lastIndex);
    }
    
    @Test
    void shouldReturnIndexNotFoundWhenBothStringsAreNull() {
        int lastIndex = StringUtils.lastIndexOfIgnoreCase(null, null);
        assertEquals(StringUtils.INDEX_NOT_FOUND, lastIndex);
    }
    
    @Test
    void shouldReturnLastIndexWhenStartPositionIsGreaterThanStringLength() {
        int lastIndex = StringUtils.lastIndexOfIgnoreCase("abc", "b", 5);
        assertEquals(1, lastIndex);
    }
    
    @Test
    void shouldReturnIndexNotFoundWhenStartPositionIsLessThanZero() {
        int lastIndex = StringUtils.lastIndexOfIgnoreCase("abc", "a", -1);
        assertEquals(StringUtils.INDEX_NOT_FOUND, lastIndex);
    }
    
    @Test
    void shouldReturnStartPosWhenSearchStringIsEmpty() {
        int lastIndex = StringUtils.lastIndexOfIgnoreCase("abc", "", 1);
        assertEquals(1, lastIndex);
    }
    
    @Test
    void shouldFindLastIndexIgnoreCaseWithStartPosition() {
        int lastIndex = StringUtils.lastIndexOfIgnoreCase("aabaabaa", "A", 8);
        assertEquals(7, lastIndex);
    }
    
    @Test
    void shouldFindLastIndexIgnoreCaseWithStartPositionAndSearchString() {
        int lastIndex = StringUtils.lastIndexOfIgnoreCase("aabaabaa", "AB", 8);
        assertEquals(4, lastIndex);
    }
    
    @Test
    void shouldIgnoreMatchesStartingAfterStartPos() {
        int lastIndex = StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 9);
        assertEquals(5, lastIndex);
    }
    
    @Test
    void shouldReturnIndexNotFoundWhenNoMatchWithStartPosition() {
        int lastIndex = StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 0);
        assertEquals(StringUtils.INDEX_NOT_FOUND, lastIndex);
    }
    
    @Test
    void shouldReturnIndexNotFoundWhenNoMatchWithStartPos() {
        int lastIndex = StringUtils.lastIndexOfIgnoreCase("aabaabaa", "B", 11);
        assertEquals(StringUtils.INDEX_NOT_FOUND, lastIndex);
    }
    
    @Test
    void shouldReturnIndexNotFoundWhenNoMatch() {
        int lastIndex = StringUtils.lastIndexOfIgnoreCase("aabaabaa", "C");
        assertEquals(StringUtils.INDEX_NOT_FOUND, lastIndex);
    }
    @Test
    @DisplayName("Should return an empty string when input is null")
    void shouldReturnEmptyStringWhenInputIsNull() {
        // Arrange
        String str = null;
    
        // Act
        String result = StringUtils.trimToEmpty(str);
    
        // Assert
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Should return an empty string when input is an empty string")
    void shouldReturnEmptyStringWhenInputIsEmptyString() {
        // Arrange
        String str = "";
    
        // Act
        String result = StringUtils.trimToEmpty(str);
    
        // Assert
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Should return an empty string when input contains only spaces")
    void shouldReturnEmptyStringWhenInputContainsOnlySpaces() {
        // Arrange
        String str = "     ";
    
        // Act
        String result = StringUtils.trimToEmpty(str);
    
        // Assert
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Should return the input string when it does not contain leading or trailing spaces")
    void shouldReturnInputStringWhenNoLeadingOrTrailingSpaces() {
        // Arrange
        String str = "abc";
    
        // Act
        String result = StringUtils.trimToEmpty(str);
    
        // Assert
        assertEquals("abc", result);
    }
    
    @Test
    @DisplayName("Should remove leading and trailing spaces from the input string")
    void shouldRemoveLeadingAndTrailingSpaces() {
        // Arrange
        String str = "    abc    ";
    
        // Act
        String result = StringUtils.trimToEmpty(str);
    
        // Assert
        assertEquals("abc", result);
    }
    import org.junit.jupiter.api.Test;
    
    @Test
    void testIndexOfAnyBut_withNullCharSequence_shouldReturnMinusOne() {
        // test logic here
    }
    
    @Test
    void testIndexOfAnyBut_withEmptyCharSequence_shouldReturnMinusOne() {
        // test logic here
    }
    
    @Test
    void testIndexOfAnyBut_withNullSearchChars_shouldReturnMinusOne() {
        // test logic here
    }
    
    @Test
    void testIndexOfAnyBut_withEmptySearchChars_shouldReturnMinusOne() {
        // test logic here
    }
    
    @Test
    void testIndexOfAnyBut_withValidInput_shouldReturnIndex() {
        // test logic here
    }
    
    @Test
    void testIndexOfAnyBut_withValidInput_shouldReturnMinusOne() {
        // test logic here
    }
    
    @Test
    void testIndexOfAnyBut_withNullCharSequence_shouldReturnMinusOne() {
        // test logic here
    }
    
    @Test
    void testIndexOfAnyBut_withEmptyCharSequence_shouldReturnMinusOne() {
        // test logic here
    }
    
    @Test
    void testIndexOfAnyBut_withNullSearchChars_shouldReturnMinusOne() {
        // test logic here
    }
    
    @Test
    void testIndexOfAnyBut_withEmptySearchChars_shouldReturnMinusOne() {
        // test logic here
    }
    
    @Test
    void testIndexOfAnyBut_withValidInput_shouldReturnIndex() {
        // test logic here
    }
    
    @Test
    void testIndexOfAnyBut_withValidInput_shouldReturnMinusOne() {
        // test logic here
    }
    @Test
    void testDeleteWhitespace_NullInput_ReturnNull() {
        assertNull(stringUtils.deleteWhitespace(null));
    }
    
    @Test
    void testDeleteWhitespace_EmptyString_ReturnEmptyString() {
        assertEquals("", stringUtils.deleteWhitespace(""));
    }
    
    @Test
    void testDeleteWhitespace_NoWhitespace_ReturnSameString() {
        String input = "abc";
        assertEquals(input, stringUtils.deleteWhitespace(input));
    }
    
    @Test
    void testDeleteWhitespace_WhitespaceOnly_ReturnEmptyString() {
        String input = "   ";
        assertEquals("", stringUtils.deleteWhitespace(input));
    }
    
    @Test
    void testDeleteWhitespace_MixedString_ReturnStringWithoutWhitespace() {
        String input = "   ab  c  ";
        assertEquals("abc", stringUtils.deleteWhitespace(input));
    }
    @Test
    void testIsAllEmpty_NullInput_ReturnsTrue() {
        assertTrue(StringUtils.isAllEmpty(null));
    }
    
    @Test
    void testIsAllEmpty_NullAndEmptyInput_ReturnsTrue() {
        assertTrue(StringUtils.isAllEmpty(null, ""));
    }
    
    @Test
    void testIsAllEmpty_EmptyArrayInput_ReturnsTrue() {
        assertTrue(StringUtils.isAllEmpty(new CharSequence[] {}));
    }
    
    @Test
    void testIsAllEmpty_NullAndNonEmptyInput_ReturnsFalse() {
        assertFalse(StringUtils.isAllEmpty(null, "foo"));
    }
    
    @Test
    void testIsAllEmpty_EmptyAndNonEmptyInput_ReturnsFalse() {
        assertFalse(StringUtils.isAllEmpty("", "bar"));
    }
    
    @Test
    void testIsAllEmpty_NonEmptyAndEmptyInput_ReturnsFalse() {
        assertFalse(StringUtils.isAllEmpty("bob", ""));
    }
    
    @Test
    void testIsAllEmpty_WhitespaceAndNullInput_ReturnsFalse() {
        assertFalse(StringUtils.isAllEmpty("  bob  ", null));
    }
    
    @Test
    void testIsAllEmpty_WhitespaceAndNonEmptyInput_ReturnsFalse() {
        assertFalse(StringUtils.isAllEmpty(" ", "bar"));
    }
    
    @Test
    void testIsAllEmpty_NonEmptyInput_ReturnsFalse() {
        assertFalse(StringUtils.isAllEmpty("foo", "bar"));
    }
    @Test
    @DisplayName("Should return null if input string is null")
    void testSplitByWholeSeparatorPreserveAllTokensWithNullString() {
        // Arrange
        String str = null;
        String separator = ":";
    
        // Act
        String[] result = stringUtils.splitByWholeSeparatorPreserveAllTokens(str, separator);
    
        // Assert
        assertNull(result);
    }
    
    @Test
    @DisplayName("Should return an empty array if input string is empty")
    void testSplitByWholeSeparatorPreserveAllTokensWithEmptyString() {
        // Arrange
        String str = "";
        String separator = ":";
    
        // Act
        String[] result = stringUtils.splitByWholeSeparatorPreserveAllTokens(str, separator);
    
        // Assert
        assertNotNull(result);
        assertEquals(0, result.length);
    }
    
    @Test
    @DisplayName("Should split the string by the separator")
    void testSplitByWholeSeparatorPreserveAllTokensWithValidStringAndSeparator() {
        // Arrange
        String str = "ab:cd:ef";
        String separator = ":";
    
        // Act
        String[] result = stringUtils.splitByWholeSeparatorPreserveAllTokens(str, separator);
    
        // Assert
        assertNotNull(result);
        assertEquals(3, result.length);
        assertEquals("ab", result[0]);
        assertEquals("cd", result[1]);
        assertEquals("ef", result[2]);
    }
    
    @Test
    @DisplayName("Should split the string by the separator and return empty tokens")
    void testSplitByWholeSeparatorPreserveAllTokensWithValidStringAndSeparatorIncludingEmptyTokens() {
        // Arrange
        String str = "ab::cd::ef";
        String separator = "::";
    
        // Act
        String[] result = stringUtils.splitByWholeSeparatorPreserveAllTokens(str, separator);
    
        // Assert
        assertNotNull(result);
        assertEquals(5, result.length);
        assertEquals("ab", result[0]);
        assertEquals("", result[1]);
        assertEquals("", result[2]);
        assertEquals("cd", result[3]);
        assertEquals("ef", result[4]);
    }
    
    @Test
    @DisplayName("Should split the string by the separator and return limited number of tokens")
    void testSplitByWholeSeparatorPreserveAllTokensWithValidStringAndSeparatorAndMaxLimit() {
        // Arrange
        String str = "ab:cd:ef";
        String separator = ":";
        int max = 2;
    
        // Act
        String[] result = stringUtils.splitByWholeSeparatorPreserveAllTokens(str, separator, max);
    
        // Assert
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals("ab", result[0]);
        assertEquals("cd:ef", result[1]);
    }
    
    @Test
    @DisplayName("Should split the string by the separator and return limited number of tokens with empty tokens")
    void testSplitByWholeSeparatorPreserveAllTokensWithValidStringAndSeparatorAndMaxLimitIncludingEmptyTokens() {
        // Arrange
        String str = "ab::cd::ef";
        String separator = "::";
        int max = 2;
    
        // Act
        String[] result = stringUtils.splitByWholeSeparatorPreserveAllTokens(str, separator, max);
    
        // Assert
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals("ab", result[0]);
        assertEquals("cd::ef", result[1]);
    }
    @Test
        @DisplayName("returns false")
        void testNullInputs() {
            assertFalse(StringUtils.containsIgnoreCase(null, null));
        }
    
        @Test
        @DisplayName("returns false when search string is null")
        void testNullSearchString() {
            assertFalse(StringUtils.containsIgnoreCase("abc", null));
        }
    
        @Test
        @DisplayName("returns false when input string is null")
        void testNullInputString() {
            assertFalse(StringUtils.containsIgnoreCase(null, "abc"));
        }
    
        @Test
        @DisplayName("returns true when both strings are empty")
        void testBothEmptyStrings() {
            assertTrue(StringUtils.containsIgnoreCase("", ""));
        }
    
        @Test
        @DisplayName("returns true when search string is empty")
        void testEmptySearchString() {
            assertTrue(StringUtils.containsIgnoreCase("abc", ""));
        }
    
        @Test
        @DisplayName("returns false when input string is empty")
        void testEmptyInputString() {
            assertFalse(StringUtils.containsIgnoreCase("", "abc"));
        }
    
        @Test
        @DisplayName("returns true when input string contains search string")
        void testContains() {
            assertTrue(StringUtils.containsIgnoreCase("abc", "a"));
            assertTrue(StringUtils.containsIgnoreCase("abc", "A"));
            assertTrue(StringUtils.containsIgnoreCase("abc", "b"));
            assertTrue(StringUtils.containsIgnoreCase("abc", "c"));
            assertTrue(StringUtils.containsIgnoreCase("abc", "ab"));
            assertTrue(StringUtils.containsIgnoreCase("abc", "BC"));
        }
    
        @Test
        @DisplayName("returns false when input string does not contain search string")
        void testNotContains() {
            assertFalse(StringUtils.containsIgnoreCase("abc", "z"));
            assertFalse(StringUtils.containsIgnoreCase("abc", "d"));
            assertFalse(StringUtils.containsIgnoreCase("abc", "bc"));
            assertFalse(StringUtils.containsIgnoreCase("abc", "CB"));
        }
    @Test
    @DisplayName("Test isWhitespace with null input")
    void testIsWhitespaceWithNull() {
      assertFalse(stringUtils.isWhitespace(null));
    }
    
    @Test
    @DisplayName("Test isWhitespace with empty input")
    void testIsWhitespaceWithEmpty() {
      assertTrue(stringUtils.isWhitespace(""));
    }
    
    @Test
    @DisplayName("Test isWhitespace with space input")
    void testIsWhitespaceWithSpace() {
      assertTrue(stringUtils.isWhitespace(" "));
    }
    
    @Test
    @DisplayName("Test isWhitespace with multiple spaces input")
    void testIsWhitespaceWithMultipleSpaces() {
      assertTrue(stringUtils.isWhitespace("   "));
    }
    
    @Test
    @DisplayName("Test isWhitespace with tab input")
    void testIsWhitespaceWithTab() {
      assertTrue(stringUtils.isWhitespace("\t"));
    }
    
    @Test
    @DisplayName("Test isWhitespace with newline input")
    void testIsWhitespaceWithNewline() {
      assertTrue(stringUtils.isWhitespace("\n"));
    }
    
    @Test
    @DisplayName("Test isWhitespace with carriage return input")
    void testIsWhitespaceWithCarriageReturn() {
      assertTrue(stringUtils.isWhitespace("\r"));
    }
    
    @Test
    @DisplayName("Test isWhitespace with alphanumeric input")
    void testIsWhitespaceWithAlphanumeric() {
      assertFalse(stringUtils.isWhitespace("abc123"));
    }
    
    @Test
    @DisplayName("Test isWhitespace with special characters input")
    void testIsWhitespaceWithSpecialCharacters() {
      assertFalse(stringUtils.isWhitespace("!@#$%^&*()"));
    }
    
    @Test
    @DisplayName("Test isWhitespace with mixed whitespace and non-whitespace input")
    void testIsWhitespaceWithMixedWhitespaceAndNonWhitespace() {
      assertFalse(stringUtils.isWhitespace(" a b c "));
    }
    @Test
    void testIsNumericSpace_NullInput_ReturnsFalse() {
        assertFalse(stringUtils.isNumericSpace(null));
    }
    
    @Test
    void testIsNumericSpace_EmptyString_ReturnsTrue() {
        assertTrue(stringUtils.isNumericSpace(""));
    }
    
    @Test
    void testIsNumericSpace_WhitespaceString_ReturnsTrue() {
        assertTrue(stringUtils.isNumericSpace("  "));
    }
    
    @Test
    void testIsNumericSpace_OnlyDigits_ReturnsTrue() {
        assertTrue(stringUtils.isNumericSpace("123"));
    }
    
    @Test
    void testIsNumericSpace_DigitsWithWhitespace_ReturnsTrue() {
        assertTrue(stringUtils.isNumericSpace("12 3"));
    }
    
    @Test
    void testIsNumericSpace_UnicodeDigits_ReturnsTrue() {
        assertTrue(stringUtils.isNumericSpace("\u0967\u0968\u0969"));
    }
    
    @Test
    void testIsNumericSpace_UnicodeDigitsWithWhitespace_ReturnsTrue() {
        assertTrue(stringUtils.isNumericSpace("\u0967\u0968 \u0969"));
    }
    
    @Test
    void testIsNumericSpace_NonNumericCharacter_ReturnsFalse() {
        assertFalse(stringUtils.isNumericSpace("ab2c"));
    }
    
    @Test
    void testIsNumericSpace_NumericCharacterWithHyphen_ReturnsFalse() {
        assertFalse(stringUtils.isNumericSpace("12-3"));
    }
    
    @Test
    void testIsNumericSpace_NumericCharacterWithDecimalPoint_ReturnsFalse() {
        assertFalse(stringUtils.isNumericSpace("12.3"));
    }
    @Test
    @DisplayName("Test ordinalIndexOf with null input")
    void testOrdinalIndexOfWithNullInput() {
        assertEquals(-1, stringUtils.ordinalIndexOf(null, "a", 1));
        assertEquals(-1, stringUtils.ordinalIndexOf("a", null, 1));
        assertEquals(-1, stringUtils.ordinalIndexOf(null, null, 1));
    }
    
    @Test
    @DisplayName("Test ordinalIndexOf with empty input")
    void testOrdinalIndexOfWithEmptyInput() {
        assertEquals(0, stringUtils.ordinalIndexOf("", "", 1));
        assertEquals(0, stringUtils.ordinalIndexOf("", "a", 1));
        assertEquals(0, stringUtils.ordinalIndexOf("a", "", 1));
    }
    
    @Test
    @DisplayName("Test ordinalIndexOf with valid input")
    void testOrdinalIndexOfWithValidInput() {
        assertEquals(0, stringUtils.ordinalIndexOf("aabaabaa", "a", 1));
        assertEquals(1, stringUtils.ordinalIndexOf("aabaabaa", "a", 2));
        assertEquals(2, stringUtils.ordinalIndexOf("aabaabaa", "b", 1));
        assertEquals(5, stringUtils.ordinalIndexOf("aabaabaa", "b", 2));
        assertEquals(1, stringUtils.ordinalIndexOf("aabaabaa", "ab", 1));
        assertEquals(4, stringUtils.ordinalIndexOf("aabaabaa", "ab", 2));
    }
    
    @Test
    @DisplayName("Test ordinalIndexOf with overlapping matches")
    void testOrdinalIndexOfWithOverlappingMatches() {
        assertEquals(0, stringUtils.ordinalIndexOf("ababab", "aba", 1));
        assertEquals(2, stringUtils.ordinalIndexOf("ababab", "aba", 2));
        assertEquals(-1, stringUtils.ordinalIndexOf("ababab", "aba", 3));
        assertEquals(0, stringUtils.ordinalIndexOf("abababab", "abab", 1));
        assertEquals(2, stringUtils.ordinalIndexOf("abababab", "abab", 2));
        assertEquals(4, stringUtils.ordinalIndexOf("abababab", "abab", 3));
        assertEquals(-1, stringUtils.ordinalIndexOf("abababab", "abab", 4));
    }
    // Test with null CharSequence
    @Test
    public void testContainsAny() {
        boolean result = StringUtils.containsAny(null, 'a', 'b');
        Assertions.assertFalse(result);
    }
    
    // Test with empty CharSequence
    @Test
    public void testContainsAny() {
        boolean result = StringUtils.containsAny("", 'a', 'b');
        Assertions.assertFalse(result);
    }
    
    // Test with null searchChars
    @Test
    public void testContainsAny() {
        boolean result = StringUtils.containsAny("zzabyycdxx", (char[]) null);
        Assertions.assertFalse(result);
    }
    
    // Test with empty searchChars
    @Test
    public void testContainsAny() {
        boolean result = StringUtils.containsAny("zzabyycdxx", new char[0]);
        Assertions.assertFalse(result);
    }
    
    // Test with valid input
    @Test
    public void testContainsAny() {
        boolean result = StringUtils.containsAny("zzabyycdxx", 'z', 'a');
        Assertions.assertTrue(result);
    }
    
    @Test
    public void testContainsAny() {
        boolean result = StringUtils.containsAny("zzabyycdxx", 'b', 'y');
        Assertions.assertTrue(result);
    }
    
    @Test
    public void testContainsAny() {
        boolean result = StringUtils.containsAny("zzabyycdxx", 'z', 'y');
        Assertions.assertTrue(result);
    }
    
    @Test
    public void testContainsAny() {
        boolean result = StringUtils.containsAny("aba", 'z');
        Assertions.assertFalse(result);
    }
    
    // Test with null CharSequence
    @Test
    public void testContainsAny_CharSequence() {
        boolean result = StringUtils.containsAny(null, "za");
        Assertions.assertFalse(result);
    }
    
    // Test with empty CharSequence
    @Test
    public void testContainsAny_CharSequence() {
        boolean result = StringUtils.containsAny("", "za");
        Assertions.assertFalse(result);
    }
    
    // Test with null searchChars
    @Test
    public void testContainsAny_CharSequence() {
        boolean result = StringUtils.containsAny("zzabyycdxx", (CharSequence) null);
        Assertions.assertFalse(result);
    }
    
    // Test with empty searchChars
    @Test
    public void testContainsAny_CharSequence() {
        boolean result = StringUtils.containsAny("zzabyycdxx", "");
        Assertions.assertFalse(result);
    }
    
    // Test with valid input
    @Test
    public void testContainsAny_CharSequence() {
        boolean result = StringUtils.containsAny("zzabyycdxx", "za");
        Assertions.assertTrue(result);
    }
    
    @Test
    public void testContainsAny_CharSequence() {
        boolean result = StringUtils.containsAny("zzabyycdxx", "by");
        Assertions.assertTrue(result);
    }
    
    @Test
    public void testContainsAny_CharSequence() {
        boolean result = StringUtils.containsAny("zzabyycdxx", "zy");
        Assertions.assertTrue(result);
    }
    
    @Test
    public void testContainsAny_CharSequence() {
        boolean result = StringUtils.containsAny("zzabyycdxx", "\tx");
        Assertions.assertTrue(result);
    }
    
    @Test
    public void testContainsAny_CharSequence() {
        boolean result = StringUtils.containsAny("zzabyycdxx", "$.#yF");
        Assertions.assertTrue(result);
    }
    
    @Test
    public void testContainsAny_CharSequence() {
        boolean result = StringUtils.containsAny("aba", "z");
        Assertions.assertFalse(result);
    }
    
    // Test with null CharSequence
    @Test
    public void testContainsAny_CharSequenceArray() {
        boolean result = StringUtils.containsAny(null, "ab", null);
        Assertions.assertFalse(result);
    }
    
    // Test with empty CharSequence
    @Test
    public void testContainsAny_CharSequenceArray() {
        boolean result = StringUtils.containsAny("", "ab", null);
        Assertions.assertFalse(result);
    }
    
    // Test with null searchCharSequences
    @Test
    public void testContainsAny_CharSequenceArray() {
        boolean result = StringUtils.containsAny("abcd", (CharSequence[]) null);
        Assertions.assertFalse(result);
    }
    
    // Test with empty searchCharSequences
    @Test
    public void testContainsAny_CharSequenceArray() {
        boolean result = StringUtils.containsAny("abcd", new CharSequence[0]);
        Assertions.assertFalse(result);
    }
    
    // Test with valid input
    @Test
    public void testContainsAny_CharSequenceArray() {
        boolean result = StringUtils.containsAny("abcd", "ab", null);
        Assertions.assertTrue(result);
    }
    
    @Test
    public void testContainsAny_CharSequenceArray() {
        boolean result = StringUtils.containsAny("abcd", "ab", "cd");
        Assertions.assertTrue(result);
    }
    
    @Test
    public void testContainsAny_CharSequenceArray() {
        boolean result = StringUtils.containsAny("abc", "d", "abc");
        Assertions.assertTrue(result);
    }
    @Test
    public void testRightPad_NullString_ReturnsNull() {
        assertNull(stringUtils.rightPad(null, 5));
    }
    
    @Test
    public void testRightPad_EmptyString_ReturnsPaddedString() {
        assertEquals("     ", stringUtils.rightPad("", 5));
    }
    
    @Test
    public void testRightPad_StringWithSizeLessThanPadding_ReturnsPaddedString() {
        assertEquals("bat  ", stringUtils.rightPad("bat", 5));
    }
    
    @Test
    public void testRightPad_StringWithSizeEqualToPadding_ReturnsOriginalString() {
        assertEquals("bat", stringUtils.rightPad("bat", 3));
    }
    
    @Test
    public void testRightPad_StringWithSizeGreaterThanPadding_ReturnsOriginalString() {
        assertEquals("bat", stringUtils.rightPad("bat", 2));
    }
    
    @Test
    public void testRightPad_PadSizeZero_ReturnsOriginalString() {
        assertEquals("bat", stringUtils.rightPad("bat", 0));
    }
    
    @Test
    public void testRightPad_NegativePadSize_ReturnsOriginalString() {
        assertEquals("bat", stringUtils.rightPad("bat", -1));
    }
    
    @Test
    public void testRightPad_NullStringWithPadChar_ReturnsNull() {
        assertNull(stringUtils.rightPad(null, 5, 'z'));
    }
    
    @Test
    public void testRightPad_EmptyStringWithPadChar_ReturnsPaddedString() {
        assertEquals("zzzzz", stringUtils.rightPad("", 5, 'z'));
    }
    
    @Test
    public void testRightPad_StringWithSizeLessThanPaddingWithPadChar_ReturnsPaddedString() {
        assertEquals("batzz", stringUtils.rightPad("bat", 5, 'z'));
    }
    
    @Test
    public void testRightPad_StringWithSizeEqualToPaddingWithPadChar_ReturnsOriginalString() {
        assertEquals("bat", stringUtils.rightPad("bat", 3, 'z'));
    }
    
    @Test
    public void testRightPad_StringWithSizeGreaterThanPaddingWithPadChar_ReturnsOriginalString() {
        assertEquals("bat", stringUtils.rightPad("bat", 2, 'z'));
    }
    
    @Test
    public void testRightPad_PadSizeZeroWithPadChar_ReturnsOriginalString() {
        assertEquals("bat", stringUtils.rightPad("bat", 0, 'z'));
    }
    
    @Test
    public void testRightPad_NegativePadSizeWithPadChar_ReturnsOriginalString() {
        assertEquals("bat", stringUtils.rightPad("bat", -1, 'z'));
    }
    
    @Test
    public void testRightPad_NullStringWithPadString_ReturnsNull() {
        assertNull(stringUtils.rightPad(null, 5, "yz"));
    }
    
    @Test
    public void testRightPad_EmptyStringWithPadString_ReturnsPaddedString() {
        assertEquals("yzyzy", stringUtils.rightPad("", 5, "yz"));
    }
    
    @Test
    public void testRightPad_StringWithSizeLessThanPaddingWithPadString_ReturnsPaddedString() {
        assertEquals("batyz", stringUtils.rightPad("bat", 5, "yz"));
    }
    
    @Test
    public void testRightPad_StringWithSizeEqualToPaddingWithPadString_ReturnsOriginalString() {
        assertEquals("bat", stringUtils.rightPad("bat", 3, "yz"));
    }
    
    @Test
    public void testRightPad_StringWithSizeGreaterThanPaddingWithPadString_ReturnsOriginalString() {
        assertEquals("bat", stringUtils.rightPad("bat", 2, "yz"));
    }
    
    @Test
    public void testRightPad_PadSizeZeroWithPadString_ReturnsOriginalString() {
        assertEquals("bat", stringUtils.rightPad("bat", 0, "yz"));
    }
    
    @Test
    public void testRightPad_NegativePadSizeWithPadString_ReturnsOriginalString() {
        assertEquals("bat", stringUtils.rightPad("bat", -1, "yz"));
    }
    
    @Test
    public void testRightPad_NullStringWithNullPadString_ReturnsNull() {
        assertNull(stringUtils.rightPad(null, 5, null));
    }
    
    @Test
    public void testRightPad_EmptyStringWithNullPadString_ReturnsPaddedString() {
        assertEquals("     ", stringUtils.rightPad("", 5, null));
    }
    
    @Test
    public void testRightPad_StringWithSizeLessThanPaddingWithNullPadString_ReturnsPaddedString() {
        assertEquals("bat  ", stringUtils.rightPad("bat", 5, null));
    }
    
    @Test
    public void testRightPad_StringWithSizeEqualToPaddingWithNullPadString_ReturnsOriginalString() {
        assertEquals("bat", stringUtils.rightPad("bat", 3, null));
    }
    
    @Test
    public void testRightPad_StringWithSizeGreaterThanPaddingWithNullPadString_ReturnsOriginalString() {
        assertEquals("bat", stringUtils.rightPad("bat", 2, null));
    }
    
    @Test
    public void testRightPad_PadSizeZeroWithNullPadString_ReturnsOriginalString() {
        assertEquals("bat", stringUtils.rightPad("bat", 0, null));
    }
    
    @Test
    public void testRightPad_NegativePadSizeWithNullPadString_ReturnsOriginalString() {
        assertEquals("bat", stringUtils.rightPad("bat", -1, null));
    }
    @Test
    void testSubstringAfterLast_WithNullString_ReturnsNull() {
        String result = stringUtils.substringAfterLast(null, 'a');
        assertNull(result);
    }
    
    @Test
    void testSubstringAfterLast_WithEmptyString_ReturnsEmptyString() {
        String result = stringUtils.substringAfterLast("", 'a');
        assertEquals("", result);
    }
    
    @Test
    void testSubstringAfterLast_WithNoSeparatorInString_ReturnsEmptyString() {
        String result = stringUtils.substringAfterLast("abc", 'd');
        assertEquals("", result);
    }
    
    @Test
    void testSubstringAfterLast_WithSeparatorAtEndOfString_ReturnsEmptyString() {
        String result = stringUtils.substringAfterLast("abc", 'c');
        assertEquals("", result);
    }
    
    @Test
    void testSubstringAfterLast_WithSeparatorInMiddleOfString_ReturnsSubstringAfterSeparator() {
        String result = stringUtils.substringAfterLast("abcba", 'b');
        assertEquals("a", result);
    }
    
    @Test
    void testSubstringAfterLast_WithSeparatorAtStartOfString_ReturnsSubstringAfterSeparator() {
        String result = stringUtils.substringAfterLast("abc", 'a');
        assertEquals("bc", result);
    }
    
    @Test
    void testSubstringAfterLast_WithSeparatorInString_ReturnsSubstringAfterSeparator() {
        String result = stringUtils.substringAfterLast(" abc", ' ');
        assertEquals("bc", result);
    }
    
    @Test
    void testSubstringAfterLast_WithUnicodeSeparator_ReturnsSubstringAfterSeparator() {
        String result = stringUtils.substringAfterLast("abc\u00A0def", '\u00A0');
        assertEquals("def", result);
    }
    
    @Test
    void testSubstringAfterLast_WithNullSeparatorAndNonNullString_ReturnsEmptyString() {
        String result = stringUtils.substringAfterLast("abc", null);
        assertEquals("", result);
    }
    
    @Test
    void testSubstringAfterLast_WithNonNullSeparatorAndNullString_ReturnsNull() {
        String result = stringUtils.substringAfterLast(null, "a");
        assertNull(result);
    }
    
    @Test
    void testSubstringAfterLast_WithEmptySeparatorAndNonNullString_ReturnsEmptyString() {
        String result = stringUtils.substringAfterLast("abc", "");
        assertEquals("", result);
    }
    
    @Test
    void testSubstringAfterLast_WithNonNullSeparatorAndEmptyString_ReturnsEmptyString() {
        String result = stringUtils.substringAfterLast("", "a");
        assertEquals("", result);
    }
    
    @Test
    void testSubstringAfterLast_WithSeparatorNotInString_ReturnsEmptyString() {
        String result = stringUtils.substringAfterLast("abc", "d");
        assertEquals("", result);
    }
    
    @Test
    void testSubstringAfterLast_WithSeparatorAtEndOfString_ReturnsEmptyString() {
        String result = stringUtils.substringAfterLast("abc", "c");
        assertEquals("", result);
    }
    
    @Test
    void testSubstringAfterLast_WithSeparatorInMiddleOfString_ReturnsSubstringAfterSeparator() {
        String result = stringUtils.substringAfterLast("abcba", "b");
        assertEquals("a", result);
    }
    
    @Test
    void testSubstringAfterLast_WithSeparatorAtStartOfString_ReturnsSubstringAfterSeparator() {
        String result = stringUtils.substringAfterLast("abc", "a");
        assertEquals("bc", result);
    }
    
    @Test
    void testSubstringAfterLast_WithSeparatorInString_ReturnsSubstringAfterSeparator() {
        String result = stringUtils.substringAfterLast(" abc", " ");
        assertEquals("bc", result);
    }
    
    @Test
    void testSubstringAfterLast_WithUnicodeSeparator_ReturnsSubstringAfterSeparator() {
        String result = stringUtils.substringAfterLast("abc\u00A0def", "\u00A0");
        assertEquals("def", result);
    }
    @Test
    void testReverse_NullInput_ReturnsNull() {
        assertNull(stringUtils.reverse(null));
    }
    
    @Test
    void testReverse_EmptyStringInput_ReturnsEmptyString() {
        assertEquals("", stringUtils.reverse(""));
    }
    
    @Test
    void testReverse_SingleCharacterInput_ReturnsSameCharacter() {
        assertEquals("a", stringUtils.reverse("a"));
    }
    
    @Test
    void testReverse_MultipleCharacterInput_ReturnsReversedString() {
        assertEquals("tac", stringUtils.reverse("cat"));
    }
    
    @Test
    void testReverse_InputWithWhitespace_ReturnsReversedStringWithWhitespace() {
        assertEquals("  yz  ", stringUtils.reverse("  zy  "));
    }
    
    @Test
    void testReverse_InputWithSpecialCharacters_ReturnsReversedStringWithSpecialCharacters() {
        assertEquals(")dcba*(#@!", stringUtils.reverse("!@(#*abcd)"));
    }
    
    @Test
    void testReverse_InputWithUnicodeCharacters_ReturnsReversedStringWithUnicodeCharacters() {
        assertEquals("ɘɿɒƨɘvoЯ", stringUtils.reverse("Яovoƨɒɿɘ"));
    }
    @Test
    void testContainsOnlyWithNullCharSequenceAndValidChars() {
      CharSequence cs = null;
      char[] validChars = {'a', 'b', 'c'};
      
      boolean result = stringUtils.containsOnly(cs, validChars);
      
      Assertions.assertFalse(result);
    }
    
    @Test
    void testContainsOnlyWithNullValidChars() {
      CharSequence cs = "abc";
      char[] validChars = null;
      
      boolean result = stringUtils.containsOnly(cs, validChars);
      
      Assertions.assertFalse(result);
    }
    
    @Test
    void testContainsOnlyWithEmptyCharSequenceAndValidChars() {
      CharSequence cs = "";
      char[] validChars = {'a', 'b', 'c'};
      
      boolean result = stringUtils.containsOnly(cs, validChars);
      
      Assertions.assertTrue(result);
    }
    
    @Test
    void testContainsOnlyWithEmptyValidChars() {
      CharSequence cs = "abc";
      char[] validChars = {};
      
      boolean result = stringUtils.containsOnly(cs, validChars);
      
      Assertions.assertFalse(result);
    }
    
    @Test
    void testContainsOnlyWithValidChars() {
      CharSequence cs = "abab";
      char[] validChars = {'a', 'b', 'c'};
      
      boolean result = stringUtils.containsOnly(cs, validChars);
      
      Assertions.assertTrue(result);
    }
    
    @Test
    void testContainsOnlyWithInvalidChars() {
      CharSequence cs = "ab1";
      char[] validChars = {'a', 'b', 'c'};
      
      boolean result = stringUtils.containsOnly(cs, validChars);
      
      Assertions.assertFalse(result);
    }
    
    @Test
    void testContainsOnlyWithInvalidCharsAndValidChars() {
      CharSequence cs = "abz";
      char[] validChars = {'a', 'b', 'c'};
      
      boolean result = stringUtils.containsOnly(cs, validChars);
      
      Assertions.assertFalse(result);
    }
    
    @Test
    void testContainsOnlyWithNullCharSequenceAndValidString() {
      CharSequence cs = null;
      String validString = "abc";
      
      boolean result = stringUtils.containsOnly(cs, validString);
      
      Assertions.assertFalse(result);
    }
    
    @Test
    void testContainsOnlyWithNullValidString() {
      CharSequence cs = "abc";
      String validString = null;
      
      boolean result = stringUtils.containsOnly(cs, validString);
      
      Assertions.assertFalse(result);
    }
    
    @Test
    void testContainsOnlyWithEmptyCharSequenceAndValidString() {
      CharSequence cs = "";
      String validString = "abc";
      
      boolean result = stringUtils.containsOnly(cs, validString);
      
      Assertions.assertTrue(result);
    }
    
    @Test
    void testContainsOnlyWithEmptyValidString() {
      CharSequence cs = "abc";
      String validString = "";
      
      boolean result = stringUtils.containsOnly(cs, validString);
      
      Assertions.assertFalse(result);
    }
    
    @Test
    void testContainsOnlyWithValidString() {
      CharSequence cs = "abab";
      String validString = "abc";
      
      boolean result = stringUtils.containsOnly(cs, validString);
      
      Assertions.assertTrue(result);
    }
    
    @Test
    void testContainsOnlyWithInvalidString() {
      CharSequence cs = "ab1";
      String validString = "abc";
      
      boolean result = stringUtils.containsOnly(cs, validString);
      
      Assertions.assertFalse(result);
    }
    
    @Test
    void testContainsOnlyWithInvalidStringAndValidChars() {
      CharSequence cs = "abz";
      String validString = "abc";
      
      boolean result = stringUtils.containsOnly(cs, validString);
      
      Assertions.assertFalse(result);
    }
    @Test
    void testContains_withNullSequence_shouldReturnFalse() {
        // Arrange
        CharSequence seq = null;
        CharSequence searchSeq = "abc";
    
        // Act
        boolean result = StringUtils.contains(seq, searchSeq);
    
        // Assert
        assertFalse(result);
    }
    
    @Test
    void testContains_withNullSearchSequence_shouldReturnFalse() {
        // Arrange
        CharSequence seq = "abc";
        CharSequence searchSeq = null;
    
        // Act
        boolean result = StringUtils.contains(seq, searchSeq);
    
        // Assert
        assertFalse(result);
    }
    
    @Test
    void testContains_withEmptySequences_shouldReturnTrue() {
        // Arrange
        CharSequence seq = "";
        CharSequence searchSeq = "";
    
        // Act
        boolean result = StringUtils.contains(seq, searchSeq);
    
        // Assert
        assertTrue(result);
    }
    
    @Test
    void testContains_withEmptySequence_shouldReturnTrue() {
        // Arrange
        CharSequence seq = "abc";
        CharSequence searchSeq = "";
    
        // Act
        boolean result = StringUtils.contains(seq, searchSeq);
    
        // Assert
        assertTrue(result);
    }
    
    @Test
    void testContains_withMatchingSequence_shouldReturnTrue() {
        // Arrange
        CharSequence seq = "abc";
        CharSequence searchSeq = "a";
    
        // Act
        boolean result = StringUtils.contains(seq, searchSeq);
    
        // Assert
        assertTrue(result);
    }
    
    @Test
    void testContains_withNonMatchingSequence_shouldReturnFalse() {
        // Arrange
        CharSequence seq = "abc";
        CharSequence searchSeq = "z";
    
        // Act
        boolean result = StringUtils.contains(seq, searchSeq);
    
        // Assert
        assertFalse(result);
    }
    
    @Test
    void testContains_withNullSequenceAndChar_shouldReturnFalse() {
        // Arrange
        CharSequence seq = null;
        int searchChar = 'a';
    
        // Act
        boolean result = StringUtils.contains(seq, searchChar);
    
        // Assert
        assertFalse(result);
    }
    
    @Test
    void testContains_withEmptySequenceAndChar_shouldReturnFalse() {
        // Arrange
        CharSequence seq = "";
        int searchChar = 'a';
    
        // Act
        boolean result = StringUtils.contains(seq, searchChar);
    
        // Assert
        assertFalse(result);
    }
    
    @Test
    void testContains_withMatchingChar_shouldReturnTrue() {
        // Arrange
        CharSequence seq = "abc";
        int searchChar = 'a';
    
        // Act
        boolean result = StringUtils.contains(seq, searchChar);
    
        // Assert
        assertTrue(result);
    }
    
    @Test
    void testContains_withNonMatchingChar_shouldReturnFalse() {
        // Arrange
        CharSequence seq = "abc";
        int searchChar = 'z';
    
        // Act
        boolean result = StringUtils.contains(seq, searchChar);
    
        // Assert
        assertFalse(result);
    }
    import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.*;
    
    class StringUtilsTest {
        
        private StringUtils stringUtils;
        
        @BeforeAll
        void setUp() {
            stringUtils = new StringUtils();
        }
        
        @Test
        void testAppendIfMissingIgnoreCase_NullString() {
            String result = stringUtils.appendIfMissingIgnoreCase(null, "suffix");
            assertNull(result);
        }
        
        @Test
        void testAppendIfMissingIgnoreCase_NullSuffix() {
            String result = stringUtils.appendIfMissingIgnoreCase("string", null);
            assertEquals("string", result);
        }
        
        @Test
        void testAppendIfMissingIgnoreCase_EmptyString() {
            String result = stringUtils.appendIfMissingIgnoreCase("", "suffix");
            assertEquals("suffix", result);
        }
        
        @Test
        void testAppendIfMissingIgnoreCase_StringWithoutSuffix() {
            String result = stringUtils.appendIfMissingIgnoreCase("string", "suffix");
            assertEquals("stringsuffix", result);
        }
        
        @Test
        void testAppendIfMissingIgnoreCase_StringWithSuffix() {
            String result = stringUtils.appendIfMissingIgnoreCase("stringsuffix", "suffix");
            assertEquals("stringsuffix", result);
        }
        
        @Test
        void testAppendIfMissingIgnoreCase_StringWithDifferentCaseSuffix() {
            String result = stringUtils.appendIfMissingIgnoreCase("stringSuffix", "suffix");
            assertEquals("stringSuffixsuffix", result);
        }
        
        @Test
        void testAppendIfMissingIgnoreCase_NullSuffixes() {
            String result = stringUtils.appendIfMissingIgnoreCase("string", "suffix", null);
            assertEquals("stringsuffix", result);
        }
        
        @Test
        void testAppendIfMissingIgnoreCase_EmptySuffixes() {
            String result = stringUtils.appendIfMissingIgnoreCase("string", "suffix", "");
            assertEquals("stringsuffix", result);
        }
        
        @Test
        void testAppendIfMissingIgnoreCase_StringWithDifferentCaseSuffixes() {
            String result = stringUtils.appendIfMissingIgnoreCase("string", "suffix", "mno");
            assertEquals("stringsuffix", result);
        }
        
        @Test
        void testAppendIfMissingIgnoreCase_StringWithSuffixes() {
            String result = stringUtils.appendIfMissingIgnoreCase("stringsuffix", "suffix", "mno");
            assertEquals("stringsuffix", result);
        }
        
        @Test
        void testAppendIfMissingIgnoreCase_StringWithDifferentCaseSuffixes() {
            String result = stringUtils.appendIfMissingIgnoreCase("stringSuffix", "suffix", "mno");
            assertEquals("stringSuffixsuffix", result);
        }
        
        @Test
        void testAppendIfMissingIgnoreCase_StringWithDifferentCaseSuffixes2() {
            String result = stringUtils.appendIfMissingIgnoreCase("stringMNO", "suffix", "mno");
            assertEquals("stringMNOsuffix", result);
        }
        
        @Test
        void testAppendIfMissingIgnoreCase_AllNullParams() {
            String result = stringUtils.appendIfMissingIgnoreCase(null, null, (CharSequence[]) null);
            assertNull(result);
        }
        
        @Test
        void testAppendIfMissingIgnoreCase_NullString_NullSuffix() {
            String result = stringUtils.appendIfMissingIgnoreCase(null, null, "suffix");
            assertNull(result);
        }
        
        @Test
        void testAppendIfMissingIgnoreCase_NullString_EmptySuffix() {
            String result = stringUtils.appendIfMissingIgnoreCase(null, "", "suffix");
            assertNull(result);
        }
        
        @Test
        void testAppendIfMissingIgnoreCase_StringWithDifferentCaseSuffixes3() {
            String result = stringUtils.appendIfMissingIgnoreCase("stringMNO", "suffix", "mno", null);
            assertEquals("stringMNOsuffix", result);
        }
        
        @Test
        void testAppendIfMissingIgnoreCase_StringWithDifferentCaseSuffixes4() {
            String result = stringUtils.appendIfMissingIgnoreCase("stringMNO", "suffix", "mno", "");
            assertEquals("stringMNOsuffix", result);
        }
        
        @Test
        void testAppendIfMissingIgnoreCase_StringWithDifferentCaseSuffixes5() {
            String result = stringUtils.appendIfMissingIgnoreCase("stringMNO", "suffix", "mno", "XYZ");
            assertEquals("stringMNOsuffix", result);
        }
        
        @Test
        void testAppendIfMissingIgnoreCase_StringWithDifferentCaseSuffixes6() {
            String result = stringUtils.appendIfMissingIgnoreCase("stringMNO", "suffix", "mno", "XYZ", "abc");
            assertEquals("stringMNOsuffix", result);
        }
        
        @Test
        void testAppendIfMissingIgnoreCase_StringWithDifferentCaseSuffixes7() {
            String result = stringUtils.appendIfMissingIgnoreCase("stringMNO", "suffix", "mno", "XYZ", "abc", null);
            assertEquals("stringMNOsuffix", result);
        }
        
        @Test
        void testAppendIfMissingIgnoreCase_StringWithDifferentCaseSuffixes8() {
            String result = stringUtils.appendIfMissingIgnoreCase("stringMNO", "suffix", "mno", "XYZ", "abc", "");
            assertEquals("stringMNOsuffix", result);
        }
        
        @Test
        void testAppendIfMissingIgnoreCase_StringWithDifferentCaseSuffixes9() {
            String result = stringUtils.appendIfMissingIgnoreCase("stringMNO", "suffix", "mno", "XYZ", "abc", "def");
            assertEquals("stringMNOsuffix", result);
        }
        
        @Test
        void testAppendIfMissingIgnoreCase_StringWithDifferentCaseSuffixes10() {
            String result = stringUtils.appendIfMissingIgnoreCase("stringMNO", "suffix", "mno", "XYZ", "abc", "def", "ghi");
            assertEquals("stringMNOsuffix", result);
        }
        
        @Test
        void testAppendIfMissingIgnoreCase_StringWithDifferentCaseSuffixes11() {
            String result = stringUtils.appendIfMissingIgnoreCase("stringMNO", "suffix", "mno", "XYZ", "abc", "def", "ghi", null);
            assertEquals("stringMNOsuffix", result);
        }
        
        @Test
        void testAppendIfMissingIgnoreCase_StringWithDifferentCaseSuffixes12() {
            String result = stringUtils.appendIfMissingIgnoreCase("stringMNO", "suffix", "mno", "XYZ", "abc", "def", "ghi", "");
            assertEquals("stringMNOsuffix", result);
        }
    }
    @Test
    @DisplayName("Replace once with non-null text, search string, and replacement")
    void testReplaceOnceWithNonNullInputs() {
        String text = "aba";
        String searchString = "a";
        String replacement = "z";
        String expectedResult = "zba";
    
        String result = stringUtils.replaceOnce(text, searchString, replacement);
    
        assertEquals(expectedResult, result);
    }
    
    @Test
    @DisplayName("Replace once with null text")
    void testReplaceOnceWithNullText() {
        String text = null;
        String searchString = "a";
        String replacement = "z";
    
        String result = stringUtils.replaceOnce(text, searchString, replacement);
    
        assertNull(result);
    }
    
    @Test
    @DisplayName("Replace once with null search string")
    void testReplaceOnceWithNullSearchString() {
        String text = "aba";
        String searchString = null;
        String replacement = "z";
        String expectedResult = "aba";
    
        String result = stringUtils.replaceOnce(text, searchString, replacement);
    
        assertEquals(expectedResult, result);
    }
    
    @Test
    @DisplayName("Replace once with null replacement")
    void testReplaceOnceWithNullReplacement() {
        String text = "aba";
        String searchString = "a";
        String replacement = null;
        String expectedResult = "ba";
    
        String result = stringUtils.replaceOnce(text, searchString, replacement);
    
        assertEquals(expectedResult, result);
    }
    
    @Test
    @DisplayName("Replace once with empty search string")
    void testReplaceOnceWithEmptySearchString() {
        String text = "aba";
        String searchString = "";
        String replacement = "z";
        String expectedResult = "aba";
    
        String result = stringUtils.replaceOnce(text, searchString, replacement);
    
        assertEquals(expectedResult, result);
    }
    
    @Test
    @DisplayName("Replace once with empty text")
    void testReplaceOnceWithEmptyText() {
        String text = "";
        String searchString = "a";
        String replacement = "z";
        String expectedResult = "";
    
        String result = stringUtils.replaceOnce(text, searchString, replacement);
    
        assertEquals(expectedResult, result);
    }
    @Test
    void testTrimNullString() {
        String result = stringUtils.trim(null);
        assertEquals(null, result);
    }
    
    @Test
    void testTrimEmptyString() {
        String result = stringUtils.trim("");
        assertEquals("", result);
    }
    
    @Test
    void testTrimWhitespaceString() {
        String result = stringUtils.trim("     ");
        assertEquals("", result);
    }
    
    @Test
    void testTrimNoWhitespaceString() {
        String result = stringUtils.trim("abc");
        assertEquals("abc", result);
    }
    
    @Test
    void testTrimLeadingAndTrailingWhitespace() {
        String result = stringUtils.trim("    abc    ");
        assertEquals("abc", result);
    }
    @Test
    @DisplayName("Should return null if source string is null")
    void testRemovePatternWithNullSource() {
        // Arrange
        String source = null;
        String regex = "abc";
    
        // Act
        String result = stringUtils.removePattern(source, regex);
    
        // Assert
        assertEquals(null, result);
    }
    
    @Test
    @DisplayName("Should return source string if regex is null")
    void testRemovePatternWithNullRegex() {
        // Arrange
        String source = "abc";
        String regex = null;
    
        // Act
        String result = stringUtils.removePattern(source, regex);
    
        // Assert
        assertEquals("abc", result);
    }
    
    @Test
    @DisplayName("Should remove pattern from source string")
    void testRemovePattern() {
        // Arrange
        String source = "A<__><__>B";
        String regex = "<.*>";
    
        // Act
        String result = stringUtils.removePattern(source, regex);
    
        // Assert
        assertEquals("AB", result);
    }
    
    @Test
    @DisplayName("Should remove all lowercase letters from source string")
    void testRemovePatternWithLowercaseRegex() {
        // Arrange
        String source = "ABCabc123";
        String regex = "[a-z]";
    
        // Act
        String result = stringUtils.removePattern(source, regex);
    
        // Assert
        assertEquals("ABC123", result);
    }
    @Test
    @DisplayName("should return null if text is null")
    void testReplaceEachRepeatedlyWithNullText() {
        String[] searchList = {"a"};
        String[] replacementList = {"b"};
        String result = stringUtils.replaceEachRepeatedly(null, searchList, replacementList);
        assertNull(result);
    }
    
    @Test
    @DisplayName("should return empty string if text is empty")
    void testReplaceEachRepeatedlyWithEmptyText() {
        String[] searchList = {"a"};
        String[] replacementList = {"b"};
        String result = stringUtils.replaceEachRepeatedly("", searchList, replacementList);
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("should return text if searchList is null")
    void testReplaceEachRepeatedlyWithNullSearchList() {
        String[] replacementList = {"b"};
        String result = stringUtils.replaceEachRepeatedly("aba", null, replacementList);
        assertEquals("aba", result);
    }
    
    @Test
    @DisplayName("should return text if replacementList is null")
    void testReplaceEachRepeatedlyWithNullReplacementList() {
        String[] searchList = {"a"};
        String result = stringUtils.replaceEachRepeatedly("aba", searchList, null);
        assertEquals("aba", result);
    }
    
    @Test
    @DisplayName("should return text if searchList is empty")
    void testReplaceEachRepeatedlyWithEmptySearchList() {
        String[] searchList = {};
        String[] replacementList = {"b"};
        String result = stringUtils.replaceEachRepeatedly("aba", searchList, replacementList);
        assertEquals("aba", result);
    }
    
    @Test
    @DisplayName("should return text if replacementList is empty")
    void testReplaceEachRepeatedlyWithEmptyReplacementList() {
        String[] searchList = {"a"};
        String[] replacementList = {};
        String result = stringUtils.replaceEachRepeatedly("aba", searchList, replacementList);
        assertEquals("aba", result);
    }
    
    @Test
    @DisplayName("should return text if searchList and replacementList are empty")
    void testReplaceEachRepeatedlyWithEmptySearchListAndEmptyReplacementList() {
        String[] searchList = {};
        String[] replacementList = {};
        String result = stringUtils.replaceEachRepeatedly("aba", searchList, replacementList);
        assertEquals("aba", result);
    }
    
    @Test
    @DisplayName("should return text if searchList has null element")
    void testReplaceEachRepeatedlyWithNullElementInSearchList() {
        String[] searchList = {null};
        String[] replacementList = {"b"};
        String result = stringUtils.replaceEachRepeatedly("aba", searchList, replacementList);
        assertEquals("aba", result);
    }
    
    @Test
    @DisplayName("should return text if replacementList has null element")
    void testReplaceEachRepeatedlyWithNullElementInReplacementList() {
        String[] searchList = {"a"};
        String[] replacementList = {null};
        String result = stringUtils.replaceEachRepeatedly("aba", searchList, replacementList);
        assertEquals("aba", result);
    }
    
    @Test
    @DisplayName("should return text if searchList and replacementList have different lengths")
    void testReplaceEachRepeatedlyWithDifferentLengths() {
        String[] searchList = {"a"};
        String[] replacementList = {"b", "c"};
        assertThrows(IllegalArgumentException.class, () -> {
            stringUtils.replaceEachRepeatedly("aba", searchList, replacementList);
        });
    }
    
    @Test
    @DisplayName("should return correct result")
    void testReplaceEachRepeatedlyWithValidInput() {
        String[] searchList = {"ab", "d"};
        String[] replacementList = {"w", "t"};
        String result = stringUtils.replaceEachRepeatedly("abcde", searchList, replacementList);
        assertEquals("wcte", result);
    }
    
    @Test
    @DisplayName("should handle repeating replacements")
    void testReplaceEachRepeatedlyWithRepeatingReplacements() {
        String[] searchList = {"ab", "d"};
        String[] replacementList = {"d", "t"};
        String result = stringUtils.replaceEachRepeatedly("abcde", searchList, replacementList);
        assertEquals("tcte", result);
    }
    
    @Test
    @DisplayName("should throw IllegalStateException for endless loop")
    void testReplaceEachRepeatedlyWithEndlessLoop() {
        String[] searchList = {"ab", "d"};
        String[] replacementList = {"d", "ab"};
        assertThrows(IllegalStateException.class, () -> {
            stringUtils.replaceEachRepeatedly("abcde", searchList, replacementList);
        });
    }
    @Test
    void testValueOfWithNull() {
        assertNull(StringUtils.valueOf(null));
    }
    
    @Test
    void testValueOfWithEmptyArray() {
        String result = StringUtils.valueOf(new char[0]);
        assertEquals("", result);
    }
    
    @Test
    void testValueOfWithNonEmptyArray() {
        char[] array = {'a', 'b', 'c'};
        String result = StringUtils.valueOf(array);
        assertEquals("abc", result);
    }
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    import org.junit.jupiter.api.TestInstance.Lifecycle;
    
    @TestInstance(Lifecycle.PER_CLASS)
    public class StringUtilsTest {
    
        private StringUtils stringUtils;
    
        @BeforeAll
        public void setup() {
            stringUtils = new StringUtils();
        }
    
        @Test
        public void testReplaceOnceIgnoreCase() {
            // Test null input
            assertNull(stringUtils.replaceOnceIgnoreCase(null, "", ""));
            assertNull(stringUtils.replaceOnceIgnoreCase(null, "a", ""));
            assertNull(stringUtils.replaceOnceIgnoreCase(null, "", "z"));
            assertNull(stringUtils.replaceOnceIgnoreCase(null, "a", "z"));
    
            // Test empty input
            assertEquals("", stringUtils.replaceOnceIgnoreCase("", "", ""));
            assertEquals("", stringUtils.replaceOnceIgnoreCase("", "a", ""));
            assertEquals("", stringUtils.replaceOnceIgnoreCase("", "", "z"));
            assertEquals("", stringUtils.replaceOnceIgnoreCase("", "a", "z"));
    
            // Test no replacement
            assertEquals("foo", stringUtils.replaceOnceIgnoreCase("foo", "", ""));
            assertEquals("foo", stringUtils.replaceOnceIgnoreCase("foo", "a", ""));
            assertEquals("foo", stringUtils.replaceOnceIgnoreCase("foo", "", "z"));
            assertEquals("foo", stringUtils.replaceOnceIgnoreCase("foo", "a", "z"));
    
            // Test replacement
            assertEquals("zoo", stringUtils.replaceOnceIgnoreCase("foo", "f", "z"));
            assertEquals("foo", stringUtils.replaceOnceIgnoreCase("foo", "o", "z"));
            assertEquals("zoo", stringUtils.replaceOnceIgnoreCase("foo", "F", "z"));
            assertEquals("foo", stringUtils.replaceOnceIgnoreCase("foo", "O", "z"));
    
            // Test multiple replacements
            assertEquals("zoo", stringUtils.replaceOnceIgnoreCase("fOo", "o", "z"));
            assertEquals("foo", stringUtils.replaceOnceIgnoreCase("fOo", "O", "z"));
            assertEquals("zoo", stringUtils.replaceOnceIgnoreCase("fOo", "O", "z"));
    
            // Test case-insensitive replacement
            assertEquals("zoo", stringUtils.replaceOnceIgnoreCase("FoO", "o", "z"));
            assertEquals("foo", stringUtils.replaceOnceIgnoreCase("FoO", "O", "z"));
    
            // Test case-sensitive replacement
            assertEquals("Foo", stringUtils.replaceOnceIgnoreCase("FoO", "o", "z", 0));
            assertEquals("FoO", stringUtils.replaceOnceIgnoreCase("FoO", "O", "z", 0));
        }
    }
    @Test
    void testRemoveStartIgnoreCase_NullSourceString() {
        assertNull(StringUtils.removeStartIgnoreCase(null, "remove"));
    }
    
    @Test
    void testRemoveStartIgnoreCase_EmptySourceString() {
        assertEquals("", StringUtils.removeStartIgnoreCase("", "remove"));
    }
    
    @Test
    void testRemoveStartIgnoreCase_NullRemoveString() {
        assertEquals("source", StringUtils.removeStartIgnoreCase("source", null));
    }
    
    @Test
    void testRemoveStartIgnoreCase_RemoveStringNotPresent() {
        assertEquals("source", StringUtils.removeStartIgnoreCase("source", "remove"));
    }
    
    @Test
    void testRemoveStartIgnoreCase_RemoveStringPresent_CaseInsensitive() {
        assertEquals("domain.com", StringUtils.removeStartIgnoreCase("www.domain.com", "www."));
    }
    
    @Test
    void testRemoveStartIgnoreCase_RemoveStringPresent_CaseInsensitive_UpperCase() {
        assertEquals("domain.com", StringUtils.removeStartIgnoreCase("www.domain.com", "WWW."));
    }
    
    @Test
    void testRemoveStartIgnoreCase_RemoveStringPresent_NoMatch() {
        assertEquals("www.domain.com", StringUtils.removeStartIgnoreCase("www.domain.com", "domain"));
    }
    
    @Test
    void testRemoveStartIgnoreCase_RemoveStringEmpty() {
        assertEquals("abc", StringUtils.removeStartIgnoreCase("abc", ""));
    }
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.Assertions;
    
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    public class StringUtilsTest {
    
        @Test
        public void testToRootLowerCase_NullSource() {
            String source = null;
            String result = StringUtils.toRootLowerCase(source);
            Assertions.assertNull(result);
        }
    
        @Test
        public void testToRootLowerCase_EmptySource() {
            String source = "";
            String result = StringUtils.toRootLowerCase(source);
            Assertions.assertEquals("", result);
        }
    
        @Test
        public void testToRootLowerCase_SingleCharacterSource() {
            String source = "A";
            String result = StringUtils.toRootLowerCase(source);
            Assertions.assertEquals("a", result);
        }
    
        @Test
        public void testToRootLowerCase_LowerCaseSource() {
            String source = "lowercase";
            String result = StringUtils.toRootLowerCase(source);
            Assertions.assertEquals("lowercase", result);
        }
    
        @Test
        public void testToRootLowerCase_UpperCaseSource() {
            String source = "UPPERCASE";
            String result = StringUtils.toRootLowerCase(source);
            Assertions.assertEquals("uppercase", result);
        }
    
        @Test
        public void testToRootLowerCase_MixedCaseSource() {
            String source = "MiXeDcAsE";
            String result = StringUtils.toRootLowerCase(source);
            Assertions.assertEquals("mixedcase", result);
        }
    
        @Test
        public void testToRootLowerCase_SpecialCharactersSource() {
            String source = "!@#$%^&*()";
            String result = StringUtils.toRootLowerCase(source);
            Assertions.assertEquals("!@#$%^&*()", result);
        }
    
        @Test
        public void testToRootLowerCase_AccentedCharactersSource() {
            String source = "ÁÉÍÓÚ";
            String result = StringUtils.toRootLowerCase(source);
            Assertions.assertEquals("áéíóú", result);
        }
        
        @Test
        public void testToRootLowerCase_MixedCharactersSource() {
            String source = "MiXeDcAsEÁÉÍÓÚ";
            String result = StringUtils.toRootLowerCase(source);
            Assertions.assertEquals("mixedcaseáéíóú", result);
        }
    
    }
    // Your Java code here
    
    @Test
    @DisplayName("Should return null when both strings are null")
    void shouldReturnNullWhenBothStringsAreNull() {
        String str1 = null;
        String str2 = null;
    
        String result = StringUtils.difference(str1, str2);
    
        assertEquals(null, result);
    }
    
    @Test
    @DisplayName("Should return empty string when both strings are empty")
    void shouldReturnEmptyStringWhenBothStringsAreEmpty() {
        String str1 = "";
        String str2 = "";
    
        String result = StringUtils.difference(str1, str2);
    
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Should return str2 when str1 is empty")
    void shouldReturnStr2WhenStr1IsEmpty() {
        String str1 = "";
        String str2 = "abc";
    
        String result = StringUtils.difference(str1, str2);
    
        assertEquals("abc", result);
    }
    
    @Test
    @DisplayName("Should return empty string when str2 is empty")
    void shouldReturnEmptyStringWhenStr2IsEmpty() {
        String str1 = "abc";
        String str2 = "";
    
        String result = StringUtils.difference(str1, str2);
    
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Should return empty string when both strings are equal")
    void shouldReturnEmptyStringWhenBothStringsAreEqual() {
        String str1 = "abc";
        String str2 = "abc";
    
        String result = StringUtils.difference(str1, str2);
    
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Should return empty string when str1 is a substring of str2")
    void shouldReturnEmptyStringWhenStr1IsSubstringOfStr2() {
        String str1 = "ab";
        String str2 = "abxyz";
    
        String result = StringUtils.difference(str1, str2);
    
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Should return remaining string from str2 when str1 is a prefix of str2")
    void shouldReturnRemainingStringFromStr2WhenStr1IsPrefixOfStr2() {
        String str1 = "abcde";
        String str2 = "abxyz";
    
        String result = StringUtils.difference(str1, str2);
    
        assertEquals("xyz", result);
    }
    
    @Test
    @DisplayName("Should return remaining string from str2 when str1 is not a prefix of str2")
    void shouldReturnRemainingStringFromStr2WhenStr1IsNotPrefixOfStr2() {
        String str1 = "abcde";
        String str2 = "xyz";
    
        String result = StringUtils.difference(str1, str2);
    
        assertEquals("xyz", result);
    }
    // Your Java code here
    
    @Test
    @DisplayName("Testing substring with null input")
    void testSubstringWithNull() {
        String result = StringUtils.substring(null, 0);
        Assertions.assertNull(result);
    }
    
    @Test
    @DisplayName("Testing substring with empty string input")
    void testSubstringWithEmptyString() {
        String result = StringUtils.substring("", 0);
        Assertions.assertEquals("", result);
    }
    
    @Test
    @DisplayName("Testing substring with start position 0")
    void testSubstringWithStartPosition0() {
        String result = StringUtils.substring("abc", 0);
        Assertions.assertEquals("abc", result);
    }
    
    @Test
    @DisplayName("Testing substring with positive start position")
    void testSubstringWithPositiveStartPosition() {
        String result = StringUtils.substring("abc", 2);
        Assertions.assertEquals("c", result);
    }
    
    @Test
    @DisplayName("Testing substring with start position greater than string length")
    void testSubstringWithStartPositionGreaterThanLength() {
        String result = StringUtils.substring("abc", 4);
        Assertions.assertEquals("", result);
    }
    
    @Test
    @DisplayName("Testing substring with negative start position")
    void testSubstringWithNegativeStartPosition() {
        String result = StringUtils.substring("abc", -2);
        Assertions.assertEquals("bc", result);
    }
    
    @Test
    @DisplayName("Testing substring with negative start position and string length greater than start position")
    void testSubstringWithNegativeStartPositionAndStringLengthGreaterThanStart() {
        String result = StringUtils.substring("abc", -4);
        Assertions.assertEquals("abc", result);
    }
    
    @Test
    @DisplayName("Testing substring with null input and start and end positions")
    void testSubstringWithNullAndStartAndEnd() {
        String result = StringUtils.substring(null, 0, 2);
        Assertions.assertNull(result);
    }
    
    @Test
    @DisplayName("Testing substring with empty string input and start and end positions")
    void testSubstringWithEmptyStringAndStartAndEnd() {
        String result = StringUtils.substring("", 0, 2);
        Assertions.assertEquals("", result);
    }
    
    @Test
    @DisplayName("Testing substring with start position greater than end position")
    void testSubstringWithStartPositionGreaterThanEndPosition() {
        String result = StringUtils.substring("abc", 2, 0);
        Assertions.assertEquals("", result);
    }
    
    @Test
    @DisplayName("Testing substring with start and end positions")
    void testSubstringWithStartAndEndPositions() {
        String result = StringUtils.substring("abc", 0, 2);
        Assertions.assertEquals("ab", result);
    }
    
    @Test
    @DisplayName("Testing substring with start and end positions greater than string length")
    void testSubstringWithStartAndEndPositionsGreaterThanLength() {
        String result = StringUtils.substring("abc", 2, 4);
        Assertions.assertEquals("c", result);
    }
    
    @Test
    @DisplayName("Testing substring with start and end positions equal to string length")
    void testSubstringWithStartAndEndPositionsEqualToLength() {
        String result = StringUtils.substring("abc", 4, 6);
        Assertions.assertEquals("", result);
    }
    
    @Test
    @DisplayName("Testing substring with start and end positions equal")
    void testSubstringWithStartAndEndPositionsEqual() {
        String result = StringUtils.substring("abc", 2, 2);
        Assertions.assertEquals("", result);
    }
    
    @Test
    @DisplayName("Testing substring with negative start and end positions")
    void testSubstringWithNegativeStartAndEndPositions() {
        String result = StringUtils.substring("abc", -2, -1);
        Assertions.assertEquals("b", result);
    }
    
    @Test
    @DisplayName("Testing substring with negative start position and end position greater than string length")
    void testSubstringWithNegativeStartPositionAndEndPositionGreaterThanLength() {
        String result = StringUtils.substring("abc", -4, 2);
        Assertions.assertEquals("ab", result);
    }
    import static org.junit.jupiter.api.Assertions.*;
    
    import org.junit.jupiter.api.Test;
    
    class StringUtilsTest {
    
        @Test
        void testEqualsWithTwoNullCharSequences() {
            assertTrue(StringUtils.equals(null, null));
        }
    
        @Test
        void testEqualsWithNullAndNonNullCharSequences() {
            assertFalse(StringUtils.equals(null, "abc"));
        }
    
        @Test
        void testEqualsWithNonNullAndNullCharSequences() {
            assertFalse(StringUtils.equals("abc", null));
        }
    
        @Test
        void testEqualsWithEqualCharSequences() {
            assertTrue(StringUtils.equals("abc", "abc"));
        }
    
        @Test
        void testEqualsWithDifferentCharSequences() {
            assertFalse(StringUtils.equals("abc", "ABC"));
        }
    
        @Test
        void testEqualsWithVariousEqualCharSequences() {
            assertTrue(StringUtils.equals("abc", "abc"));
        }
    
        @Test
        void testEqualsWithVariousDifferentCharSequences() {
            assertFalse(StringUtils.equals("abc", "abc1"));
        }
    
        @Test
        void testEqualsWithDifferentLengthCharSequences() {
            assertFalse(StringUtils.equals("abc", "abcd"));
        }
    
        @Test
        void testEqualsWithTwoEmptyCharSequences() {
            assertTrue(StringUtils.equals("", ""));
        }
    
        @Test
        void testEqualsWithEmptyAndNonEmptyCharSequences() {
            assertFalse(StringUtils.equals("", "abc"));
        }
    
        @Test
        void testEqualsWithNonEmptyAndEmptyCharSequences() {
            assertFalse(StringUtils.equals("abc", ""));
        }
    }
    @Test
    void testIsNoneBlank_NullInput() {
        assertFalse(StringUtils.isNoneBlank((CharSequence[]) null));
    }
    
    @Test
    void testIsNoneBlank_NullElement() {
        assertFalse(StringUtils.isNoneBlank(null, "foo"));
    }
    
    @Test
    void testIsNoneBlank_EmptyElement() {
        assertFalse(StringUtils.isNoneBlank("", "bar"));
    }
    
    @Test
    void testIsNoneBlank_WhitespaceElement() {
        assertFalse(StringUtils.isNoneBlank(" ", "bar"));
    }
    
    @Test
    void testIsNoneBlank_AllEmptyElements() {
        assertFalse(StringUtils.isNoneBlank("", ""));
    }
    
    @Test
    void testIsNoneBlank_AllWhitespaceElements() {
        assertFalse(StringUtils.isNoneBlank(" ", " "));
    }
    
    @Test
    void testIsNoneBlank_SingleNonBlankElement() {
        assertTrue(StringUtils.isNoneBlank("foo"));
    }
    
    @Test
    void testIsNoneBlank_MultipleNonBlankElements() {
        assertTrue(StringUtils.isNoneBlank("foo", "bar"));
    }
    
    @Test
    void testIsNoneBlank_MixedElements() {
        assertFalse(StringUtils.isNoneBlank("  bob  ", null));
    }
    
    @Test
    void testIsNoneBlank_EmptyArray() {
        assertTrue(StringUtils.isNoneBlank(new String[] {}));
    }
    
    @Test
    void testIsNoneBlank_SingleEmptyElementArray() {
        assertFalse(StringUtils.isNoneBlank(new String[] {""}));
    }
    @Test
    @DisplayName("Null input should return false")
    void isAlphanumericSpace_NullInput_ReturnsFalse() {
        assertFalse(stringUtils.isAlphanumericSpace(null));
    }
    
    @Test
    @DisplayName("Empty string input should return true")
    void isAlphanumericSpace_EmptyString_ReturnsTrue() {
        assertTrue(stringUtils.isAlphanumericSpace(""));
    }
    
    @Test
    @DisplayName("String with only spaces should return true")
    void isAlphanumericSpace_OnlySpaces_ReturnsTrue() {
        assertTrue(stringUtils.isAlphanumericSpace("  "));
    }
    
    @Test
    @DisplayName("String with only letters and digits should return true")
    void isAlphanumericSpace_OnlyLettersAndDigits_ReturnsTrue() {
        assertTrue(stringUtils.isAlphanumericSpace("abc"));
        assertTrue(stringUtils.isAlphanumericSpace("ab2c"));
    }
    
    @Test
    @DisplayName("String with letters, digits, and spaces should return true")
    void isAlphanumericSpace_LettersDigitsSpaces_ReturnsTrue() {
        assertTrue(stringUtils.isAlphanumericSpace("ab c"));
    }
    
    @Test
    @DisplayName("String with non-alphanumeric characters should return false")
    void isAlphanumericSpace_NonAlphanumeric_ReturnsFalse() {
        assertFalse(stringUtils.isAlphanumericSpace("ab-c"));
    }
    @Test
    @DisplayName("When input is null, should return an empty string")
    void testDefaultStringWithNullInput() {
        // Arrange
        String str = null;
    
        // Act
        String result = StringUtils.defaultString(str);
    
        // Assert
        Assertions.assertEquals("", result);
    }
    
    @Test
    @DisplayName("When input is an empty string, should return the same empty string")
    void testDefaultStringWithEmptyInput() {
        // Arrange
        String str = "";
    
        // Act
        String result = StringUtils.defaultString(str);
    
        // Assert
        Assertions.assertEquals("", result);
    }
    
    @Test
    @DisplayName("When input is a non-empty string, should return the same string")
    void testDefaultStringWithNonEmptyInput() {
        // Arrange
        String str = "bat";
    
        // Act
        String result = StringUtils.defaultString(str);
    
        // Assert
        Assertions.assertEquals("bat", result);
    }
    
    @Test
    @DisplayName("When input is null and nullDefault is provided, should return nullDefault")
    void testDefaultStringWithNullInputAndNullDefault() {
        // Arrange
        String str = null;
        String nullDefault = "NULL";
    
        // Act
        String result = StringUtils.defaultString(str, nullDefault);
    
        // Assert
        Assertions.assertEquals("NULL", result);
    }
    
    @Test
    @DisplayName("When input is an empty string and nullDefault is provided, should return an empty string")
    void testDefaultStringWithEmptyInputAndNullDefault() {
        // Arrange
        String str = "";
        String nullDefault = "NULL";
    
        // Act
        String result = StringUtils.defaultString(str, nullDefault);
    
        // Assert
        Assertions.assertEquals("", result);
    }
    
    @Test
    @DisplayName("When input is a non-empty string and nullDefault is provided, should return the same string")
    void testDefaultStringWithNonEmptyInputAndNullDefault() {
        // Arrange
        String str = "bat";
        String nullDefault = "NULL";
    
        // Act
        String result = StringUtils.defaultString(str, nullDefault);
    
        // Assert
        Assertions.assertEquals("bat", result);
    }
    @Test
    @DisplayName("Test upper case conversion with null input")
    void testUpperCaseWithNullInput() {
        String str = null;
        String result = StringUtils.upperCase(str);
        Assertions.assertNull(result);
    }
    
    @Test
    @DisplayName("Test upper case conversion with empty string input")
    void testUpperCaseWithEmptyStringInput() {
        String str = "";
        String result = StringUtils.upperCase(str);
        Assertions.assertEquals("", result);
    }
    
    @Test
    @DisplayName("Test upper case conversion with all lowercase characters")
    void testUpperCaseWithAllLowercaseCharacters() {
        String str = "abc";
        String result = StringUtils.upperCase(str);
        Assertions.assertEquals("ABC", result);
    }
    
    @Test
    @DisplayName("Test upper case conversion with all uppercase characters")
    void testUpperCaseWithAllUppercaseCharacters() {
        String str = "ABC";
        String result = StringUtils.upperCase(str);
        Assertions.assertEquals("ABC", result);
    }
    
    @Test
    @DisplayName("Test upper case conversion with mixed case characters")
    void testUpperCaseWithMixedCaseCharacters() {
        String str = "aBc";
        String result = StringUtils.upperCase(str);
        Assertions.assertEquals("ABC", result);
    }
    
    @Test
    @DisplayName("Test upper case conversion with null input and English locale")
    void testUpperCaseWithNullInputAndEnglishLocale() {
        String str = null;
        Locale locale = Locale.ENGLISH;
        String result = StringUtils.upperCase(str, locale);
        Assertions.assertNull(result);
    }
    
    @Test
    @DisplayName("Test upper case conversion with empty string input and English locale")
    void testUpperCaseWithEmptyStringInputAndEnglishLocale() {
        String str = "";
        Locale locale = Locale.ENGLISH;
        String result = StringUtils.upperCase(str, locale);
        Assertions.assertEquals("", result);
    }
    
    @Test
    @DisplayName("Test upper case conversion with all lowercase characters and English locale")
    void testUpperCaseWithAllLowercaseCharactersAndEnglishLocale() {
        String str = "abc";
        Locale locale = Locale.ENGLISH;
        String result = StringUtils.upperCase(str, locale);
        Assertions.assertEquals("ABC", result);
    }
    
    @Test
    @DisplayName("Test upper case conversion with all uppercase characters and English locale")
    void testUpperCaseWithAllUppercaseCharactersAndEnglishLocale() {
        String str = "ABC";
        Locale locale = Locale.ENGLISH;
        String result = StringUtils.upperCase(str, locale);
        Assertions.assertEquals("ABC", result);
    }
    
    @Test
    @DisplayName("Test upper case conversion with mixed case characters and English locale")
    void testUpperCaseWithMixedCaseCharactersAndEnglishLocale() {
        String str = "aBc";
        Locale locale = Locale.ENGLISH;
        String result = StringUtils.upperCase(str, locale);
        Assertions.assertEquals("ABC", result);
    }
    @Test
    @DisplayName("Should wrap string with char")
    void testWrapWithChar() {
        // Given
        String str = "ab";
        char wrapWith = 'x';
        String expected = "xabx";
    
        // When
        String actual = StringUtils.wrap(str, wrapWith);
    
        // Then
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Should return null if string is null")
    void testWrapWithChar_NullString() {
        // Given
        String str = null;
        char wrapWith = 'x';
    
        // When
        String actual = StringUtils.wrap(str, wrapWith);
    
        // Then
        assertNull(actual);
    }
    
    @Test
    @DisplayName("Should return the same string if string is empty")
    void testWrapWithChar_EmptyString() {
        // Given
        String str = "";
        char wrapWith = 'x';
    
        // When
        String actual = StringUtils.wrap(str, wrapWith);
    
        // Then
        assertEquals(str, actual);
    }
    
    @Test
    @DisplayName("Should return the same string if wrapWith is the null character")
    void testWrapWithChar_NullChar() {
        // Given
        String str = "ab";
        char wrapWith = '\0';
    
        // When
        String actual = StringUtils.wrap(str, wrapWith);
    
        // Then
        assertEquals(str, actual);
    }
    
    @Test
    @DisplayName("Should wrap string with string")
    void testWrapWithString() {
        // Given
        String str = "ab";
        String wrapWith = "x";
        String expected = "xabx";
    
        // When
        String actual = StringUtils.wrap(str, wrapWith);
    
        // Then
        assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Should return null if string is null")
    void testWrapWithString_NullString() {
        // Given
        String str = null;
        String wrapWith = "x";
    
        // When
        String actual = StringUtils.wrap(str, wrapWith);
    
        // Then
        assertNull(actual);
    }
    
    @Test
    @DisplayName("Should return the same string if string is empty")
    void testWrapWithString_EmptyString() {
        // Given
        String str = "";
        String wrapWith = "x";
    
        // When
        String actual = StringUtils.wrap(str, wrapWith);
    
        // Then
        assertEquals(str, actual);
    }
    
    @Test
    @DisplayName("Should return the same string if wrapWith is null or empty")
    void testWrapWithString_NullOrEmptyWrapWith() {
        // Given
        String str = "ab";
        String wrapWith = null;
    
        // When
        String actual = StringUtils.wrap(str, wrapWith);
    
        // Then
        assertEquals(str, actual);
    
        // Given
        wrapWith = "";
    
        // When
        actual = StringUtils.wrap(str, wrapWith);
    
        // Then
        assertEquals(str, actual);
    }
    @Test
    @DisplayName("should return null if text is null")
    void shouldReturnNullIfTextIsNull() {
        String[] searchList = {"a"};
        String[] replacementList = {"b"};
    
        String result = StringUtils.replaceEach(null, searchList, replacementList);
    
        assertNull(result);
    }
    
    @Test
    @DisplayName("should return empty string if text is empty")
    void shouldReturnEmptyStringIfTextIsEmpty() {
        String text = "";
        String[] searchList = {"a"};
        String[] replacementList = {"b"};
    
        String result = StringUtils.replaceEach(text, searchList, replacementList);
    
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("should return text if search list is null")
    void shouldReturnTextIfSearchListIsNull() {
        String text = "abc";
        String[] searchList = null;
        String[] replacementList = {"b"};
    
        String result = StringUtils.replaceEach(text, searchList, replacementList);
    
        assertEquals("abc", result);
    }
    
    @Test
    @DisplayName("should return text if replacement list is null")
    void shouldReturnTextIfReplacementListIsNull() {
        String text = "abc";
        String[] searchList = {"a"};
        String[] replacementList = null;
    
        String result = StringUtils.replaceEach(text, searchList, replacementList);
    
        assertEquals("abc", result);
    }
    
    @Test
    @DisplayName("should return text if search list is empty")
    void shouldReturnTextIfSearchListIsEmpty() {
        String text = "abc";
        String[] searchList = {};
        String[] replacementList = {"b"};
    
        String result = StringUtils.replaceEach(text, searchList, replacementList);
    
        assertEquals("abc", result);
    }
    
    @Test
    @DisplayName("should return text if replacement list is empty")
    void shouldReturnTextIfReplacementListIsEmpty() {
        String text = "abc";
        String[] searchList = {"a"};
        String[] replacementList = {};
    
        String result = StringUtils.replaceEach(text, searchList, replacementList);
    
        assertEquals("abc", result);
    }
    
    @Test
    @DisplayName("should throw IllegalArgumentException if search list and replacement list have different lengths")
    void shouldThrowIllegalArgumentExceptionIfSearchListAndReplacementListHaveDifferentLengths() {
        String text = "abc";
        String[] searchList = {"a", "b"};
        String[] replacementList = {"x"};
    
        assertThrows(IllegalArgumentException.class, () -> StringUtils.replaceEach(text, searchList, replacementList));
    }
    
    @Test
    @DisplayName("should replace all occurrences of strings within another string")
    void shouldReplaceAllOccurrencesOfStringsWithinAnotherString() {
        String text = "abcde";
        String[] searchList = {"ab", "d"};
        String[] replacementList = {"w", "t"};
    
        String result = StringUtils.replaceEach(text, searchList, replacementList);
    
        assertEquals("wcte", result);
    }
    
    @Test
    @DisplayName("should ignore null search strings")
    void shouldIgnoreNullSearchStrings() {
        String text = "abcde";
        String[] searchList = {null};
        String[] replacementList = {"a"};
    
        String result = StringUtils.replaceEach(text, searchList, replacementList);
    
        assertEquals("abcde", result);
    }
    
    @Test
    @DisplayName("should ignore null replacement strings")
    void shouldIgnoreNullReplacementStrings() {
        String text = "abcde";
        String[] searchList = {"a"};
        String[] replacementList = {null};
    
        String result = StringUtils.replaceEach(text, searchList, replacementList);
    
        assertEquals("abcde", result);
    }
    
    @Test
    @DisplayName("should replace with empty string if replacement string is empty")
    void shouldReplaceWithEmptyStringIfReplacementStringIsEmpty() {
        String text = "aba";
        String[] searchList = {"a"};
        String[] replacementList = {""};
    
        String result = StringUtils.replaceEach(text, searchList, replacementList);
    
        assertEquals("b", result);
    }
    
    @Test
    @DisplayName("should not repeat replacements")
    void shouldNotRepeatReplacements() {
        String text = "abcde";
        String[] searchList = {"ab", "d"};
        String[] replacementList = {"d", "t"};
    
        String result = StringUtils.replaceEach(text, searchList, replacementList);
    
        assertEquals("dcte", result);
    }
    @Test
    void testChompWithNullString() {
        String result = StringUtils.chomp(null);
        assertEquals(null, result);
    }
    
    @Test
    void testChompWithEmptyString() {
        String result = StringUtils.chomp("");
        assertEquals("", result);
    }
    
    @Test
    void testChompWithSingleCharacterCRString() {
        String result = StringUtils.chomp("\r");
        assertEquals("", result);
    }
    
    @Test
    void testChompWithSingleCharacterLFString() {
        String result = StringUtils.chomp("\n");
        assertEquals("", result);
    }
    
    @Test
    void testChompWithSingleCharacterNonNewlineString() {
        String result = StringUtils.chomp("a");
        assertEquals("a", result);
    }
    
    @Test
    void testChompWithCRString() {
        String result = StringUtils.chomp("abc\r");
        assertEquals("abc", result);
    }
    
    @Test
    void testChompWithLFString() {
        String result = StringUtils.chomp("abc\n");
        assertEquals("abc", result);
    }
    
    @Test
    void testChompWithCRLFString() {
        String result = StringUtils.chomp("abc\r\n");
        assertEquals("abc", result);
    }
    
    @Test
    void testChompWithMultipleCRLFString() {
        String result = StringUtils.chomp("abc\r\n\r\n");
        assertEquals("abc\r\n", result);
    }
    
    @Test
    void testChompWithLFCRString() {
        String result = StringUtils.chomp("abc\n\r");
        assertEquals("abc\n", result);
    }
    
    @Test
    void testChompWithNonNewlineString() {
        String result = StringUtils.chomp("abc");
        assertEquals("abc", result);
    }
    
    @Test
    void testChompWithSeparatorAtEndOfString() {
        String result = StringUtils.chomp("foobar", "bar");
        assertEquals("foo", result);
    }
    
    @Test
    void testChompWithSeparatorNotAtEndOfString() {
        String result = StringUtils.chomp("foobar", "baz");
        assertEquals("foobar", result);
    }
    
    @Test
    void testChompWithSameStringAsSeparator() {
        String result = StringUtils.chomp("foo", "foo");
        assertEquals("", result);
    }
    
    @Test
    void testChompWithSeparatorWithSpaceAtEndOfString() {
        String result = StringUtils.chomp("foo ", "foo");
        assertEquals("foo ", result);
    }
    
    @Test
    void testChompWithSeparatorWithSpaceAtStartOfString() {
        String result = StringUtils.chomp(" foo", "foo");
        assertEquals(" ", result);
    }
    
    @Test
    void testChompWithSeparatorInsideString() {
        String result = StringUtils.chomp("foo", "foooo");
        assertEquals("foo", result);
    }
    
    @Test
    void testChompWithEmptySeparator() {
        String result = StringUtils.chomp("foo", "");
        assertEquals("foo", result);
    }
    
    @Test
    void testChompWithNullSeparator() {
        String result = StringUtils.chomp("foo", null);
        assertEquals("foo", result);
    }
    @Test
    public void testSplitPreserveAllTokens_NullInput_ReturnNull() {
        assertNull(StringUtils.splitPreserveAllTokens(null));
    }
    
    @Test
    public void testSplitPreserveAllTokens_EmptyInput_ReturnEmptyArray() {
        assertEquals(0, StringUtils.splitPreserveAllTokens("").length);
    }
    
    @Test
    public void testSplitPreserveAllTokens_SpaceInput_ReturnArrayWithEmptyString() {
        String[] result = StringUtils.splitPreserveAllTokens(" ");
        assertEquals(1, result.length);
        assertEquals("", result[0]);
    }
    
    @Test
    public void testSplitPreserveAllTokens_NoSeparators_ReturnArrayWithOriginalString() {
        String[] result = StringUtils.splitPreserveAllTokens("abc def");
        assertEquals(1, result.length);
        assertEquals("abc def", result[0]);
    }
    
    @Test
    public void testSplitPreserveAllTokens_SingleSeparator_ReturnArrayWithTokens() {
        String[] result = StringUtils.splitPreserveAllTokens("a.b.c", '.');
        assertEquals(3, result.length);
        assertEquals("a", result[0]);
        assertEquals("b", result[1]);
        assertEquals("c", result[2]);
    }
    
    @Test
    public void testSplitPreserveAllTokens_MultipleSeparators_ReturnArrayWithTokensAndEmptyStrings() {
        String[] result = StringUtils.splitPreserveAllTokens("a..b.c", '.');
        assertEquals(4, result.length);
        assertEquals("a", result[0]);
        assertEquals("", result[1]);
        assertEquals("b", result[2]);
        assertEquals("c", result[3]);
    }
    
    @Test
    public void testSplitPreserveAllTokens_NullSeparator_ReturnArrayWithTokensSeparatedByWhitespaces() {
        String[] result = StringUtils.splitPreserveAllTokens("a b c", null);
        assertEquals(3, result.length);
        assertEquals("a", result[0]);
        assertEquals("b", result[1]);
        assertEquals("c", result[2]);
    }
    
    @Test
    public void testSplitPreserveAllTokens_EmptySeparator_ReturnArrayWithTokensSeparatedByWhitespaces() {
        String[] result = StringUtils.splitPreserveAllTokens("a b c", "");
        assertEquals(3, result.length);
        assertEquals("a", result[0]);
        assertEquals("b", result[1]);
        assertEquals("c", result[2]);
    }
    
    @Test
    public void testSplitPreserveAllTokens_MaxLengthReached_ReturnArrayWithLimitedNumberOfElements() {
        String[] result = StringUtils.splitPreserveAllTokens("ab   de fg", null, 2);
        assertEquals(2, result.length);
        assertEquals("ab", result[0]);
        assertEquals("  de fg", result[1]);
    }
    
    @Test
    public void testSplitPreserveAllTokens_MaxLengthZero_ReturnArrayWithAllElements() {
        String[] result = StringUtils.splitPreserveAllTokens("ab   de fg", null, 0);
        assertEquals(4, result.length);
        assertEquals("ab", result[0]);
        assertEquals("", result[1]);
        assertEquals("", result[2]);
        assertEquals("de fg", result[3]);
    }
    
    @Test
    public void testSplitPreserveAllTokens_MaxLengthNegative_ReturnArrayWithAllElements() {
        String[] result = StringUtils.splitPreserveAllTokens("ab   de fg", null, -1);
        assertEquals(4, result.length);
        assertEquals("ab", result[0]);
        assertEquals("", result[1]);
        assertEquals("", result[2]);
        assertEquals("de fg", result[3]);
    }
    @Test
    void testDefaultIfBlank_NullDefault() {
        assertEquals("NULL", stringUtils.defaultIfBlank(null, "NULL"));
        assertEquals("NULL", stringUtils.defaultIfBlank("", "NULL"));
        assertEquals("NULL", stringUtils.defaultIfBlank(" ", "NULL"));
        assertEquals("bat", stringUtils.defaultIfBlank("bat", "NULL"));
    }
    
    @Test
    void testDefaultIfBlank_NullInput() {
        assertNull(stringUtils.defaultIfBlank(null, null));
    }
    
    @Test
    void testDefaultIfBlank_EmptyInput() {
        assertEquals("NULL", stringUtils.defaultIfBlank("", "NULL"));
    }
    
    @Test
    void testDefaultIfBlank_WhitespaceInput() {
        assertEquals("NULL", stringUtils.defaultIfBlank(" ", "NULL"));
    }
    
    @Test
    void testDefaultIfBlank_NonBlankInput() {
        assertEquals("bat", stringUtils.defaultIfBlank("bat", "NULL"));
    }
    
    @Test
    void testDefaultIfBlank_NullInputAndDefault() {
        assertNull(stringUtils.defaultIfBlank(null, null));
    }
    
    @Test
    void testDefaultIfBlank_EmptyInputAndDefault() {
        assertEquals("", stringUtils.defaultIfBlank("", ""));
    }
    
    @Test
    void testDefaultIfBlank_WhitespaceInputAndDefault() {
        assertEquals(" ", stringUtils.defaultIfBlank(" ", " "));
    }
    
    @Test
    void testDefaultIfBlank_NonBlankInputAndDefault() {
        assertEquals("bat", stringUtils.defaultIfBlank("bat", "NULL"));
    }
    @Test
    public void testToStringOrEmpty_NullObject_ReturnsEmptyString() {
        Object obj = null;
        String expected = "";
        String result = stringUtils.toStringOrEmpty(obj);
        assertEquals(expected, result);
    }
    
    @Test
    public void testToStringOrEmpty_EmptyStringObject_ReturnsEmptyString() {
        Object obj = "";
        String expected = "";
        String result = stringUtils.toStringOrEmpty(obj);
        assertEquals(expected, result);
    }
    
    @Test
    public void testToStringOrEmpty_NonEmptyStringObject_ReturnsString() {
        Object obj = "Hello";
        String expected = "Hello";
        String result = stringUtils.toStringOrEmpty(obj);
        assertEquals(expected, result);
    }
    
    @Test
    public void testToStringOrEmpty_IntegerObject_ReturnsString() {
        Object obj = 123;
        String expected = "123";
        String result = stringUtils.toStringOrEmpty(obj);
        assertEquals(expected, result);
    }
    
    @Test
    public void testToStringOrEmpty_DoubleObject_ReturnsString() {
        Object obj = 3.14;
        String expected = "3.14";
        String result = stringUtils.toStringOrEmpty(obj);
        assertEquals(expected, result);
    }
    
    @Test
    public void testToStringOrEmpty_BooleanObject_ReturnsString() {
        Object obj = true;
        String expected = "true";
        String result = stringUtils.toStringOrEmpty(obj);
        assertEquals(expected, result);
    }
    @Test
    @DisplayName("Test with null string")
    public void testLastOrdinalIndexOfWithNullString() {
        int result = StringUtils.lastOrdinalIndexOf(null, "a", 1);
        assertEquals(-1, result);
    }
    
    @Test
    @DisplayName("Test with null search string")
    public void testLastOrdinalIndexOfWithNullSearchString() {
        int result = StringUtils.lastOrdinalIndexOf("aabaabaa", null, 1);
        assertEquals(-1, result);
    }
    
    @Test
    @DisplayName("Test with empty string")
    public void testLastOrdinalIndexOfWithEmptyString() {
        int result = StringUtils.lastOrdinalIndexOf("", "", 1);
        assertEquals(0, result);
    }
    
    @Test
    @DisplayName("Test with valid inputs")
    public void testLastOrdinalIndexOfWithValidInputs() {
        int result1 = StringUtils.lastOrdinalIndexOf("aabaabaa", "a", 1);
        assertEquals(7, result1);
    
        int result2 = StringUtils.lastOrdinalIndexOf("aabaabaa", "a", 2);
        assertEquals(6, result2);
    
        int result3 = StringUtils.lastOrdinalIndexOf("aabaabaa", "b", 1);
        assertEquals(5, result3);
    
        int result4 = StringUtils.lastOrdinalIndexOf("aabaabaa", "b", 2);
        assertEquals(2, result4);
    
        int result5 = StringUtils.lastOrdinalIndexOf("aabaabaa", "ab", 1);
        assertEquals(4, result5);
    
        int result6 = StringUtils.lastOrdinalIndexOf("aabaabaa", "ab", 2);
        assertEquals(1, result6);
    
        int result7 = StringUtils.lastOrdinalIndexOf("aabaabaa", "", 1);
        assertEquals(8, result7);
    
        int result8 = StringUtils.lastOrdinalIndexOf("aabaabaa", "", 2);
        assertEquals(8, result8);
    }
    @Test
    @DisplayName("Test substringBefore with null string input")
    void testSubstringBeforeWithNullString() {
        String input = null;
        int separator = 'a';
        String expected = null;
    
        String result = StringUtils.substringBefore(input, separator);
    
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("Test substringBefore with empty string input")
    void testSubstringBeforeWithEmptyString() {
        String input = "";
        int separator = 'a';
        String expected = "";
    
        String result = StringUtils.substringBefore(input, separator);
    
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("Test substringBefore with separator found at the beginning")
    void testSubstringBeforeWithSeparatorAtBeginning() {
        String input = "abc";
        int separator = 'a';
        String expected = "";
    
        String result = StringUtils.substringBefore(input, separator);
    
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("Test substringBefore with separator found in the middle")
    void testSubstringBeforeWithSeparatorInMiddle() {
        String input = "abcba";
        int separator = 'b';
        String expected = "a";
    
        String result = StringUtils.substringBefore(input, separator);
    
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("Test substringBefore with separator found at the end")
    void testSubstringBeforeWithSeparatorAtEnd() {
        String input = "abc";
        int separator = 'c';
        String expected = "ab";
    
        String result = StringUtils.substringBefore(input, separator);
    
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("Test substringBefore with separator not found")
    void testSubstringBeforeWithSeparatorNotFound() {
        String input = "abc";
        int separator = 'd';
        String expected = "abc";
    
        String result = StringUtils.substringBefore(input, separator);
    
        assertEquals(expected, result);
    }
    // Your Java code here
    @Test
    void testFirstNonBlankWithNullValues() {
        String result = StringUtils.firstNonBlank(null, null, null);
        Assertions.assertNull(result);
    }
    
    @Test
    void testFirstNonBlankWithEmptyAndWhitespaceValues() {
        String result = StringUtils.firstNonBlank(null, "", " ");
        Assertions.assertNull(result);
    }
    
    @Test
    void testFirstNonBlankWithSingleValue() {
        String result = StringUtils.firstNonBlank("abc");
        Assertions.assertEquals("abc", result);
    }
    
    @Test
    void testFirstNonBlankWithNullAndNonBlankValues() {
        String result = StringUtils.firstNonBlank(null, "xyz");
        Assertions.assertEquals("xyz", result);
    }
    
    @Test
    void testFirstNonBlankWithNullEmptyWhitespaceAndNonBlankValues() {
        String result = StringUtils.firstNonBlank(null, "", " ", "xyz");
        Assertions.assertEquals("xyz", result);
    }
    
    @Test
    void testFirstNonBlankWithNullEmptyAndNonBlankValues() {
        String result = StringUtils.firstNonBlank(null, "xyz", "abc");
        Assertions.assertEquals("xyz", result);
    }
    
    @Test
    void testFirstNonBlankWithNoValues() {
        String result = StringUtils.firstNonBlank();
        Assertions.assertNull(result);
    }
    @Test
    @DisplayName("Should return 0 when both strings are null")
    void testCompareNullStrings() {
        int result = stringUtils.compare(null, null);
        assertEquals(0, result);
    }
    
    @Test
    @DisplayName("Should return negative value when first string is null and nullIsLess is true")
    void testCompareFirstNullStringNullIsLessTrue() {
        int result = stringUtils.compare(null, "a", true);
        assertTrue(result < 0);
    }
    
    @Test
    @DisplayName("Should return positive value when first string is null and nullIsLess is false")
    void testCompareFirstNullStringNullIsLessFalse() {
        int result = stringUtils.compare(null, "a", false);
        assertTrue(result > 0);
    }
    
    @Test
    @DisplayName("Should return positive value when second string is null and nullIsLess is true")
    void testCompareSecondNullStringNullIsLessTrue() {
        int result = stringUtils.compare("a", null, true);
        assertTrue(result > 0);
    }
    
    @Test
    @DisplayName("Should return negative value when second string is null and nullIsLess is false")
    void testCompareSecondNullStringNullIsLessFalse() {
        int result = stringUtils.compare("a", null, false);
        assertTrue(result < 0);
    }
    
    @Test
    @DisplayName("Should return 0 when both strings are equal")
    void testCompareEqualStrings() {
        int result = stringUtils.compare("abc", "abc");
        assertEquals(0, result);
    }
    
    @Test
    @DisplayName("Should return negative value when first string is less than second string")
    void testCompareFirstStringLessThanSecondString() {
        int result = stringUtils.compare("a", "b");
        assertTrue(result < 0);
    }
    
    @Test
    @DisplayName("Should return positive value when first string is greater than second string")
    void testCompareFirstStringGreaterThanSecondString() {
        int result = stringUtils.compare("b", "a");
        assertTrue(result > 0);
    }
    
    @Test
    @DisplayName("Should return positive value when first string is greater than second string (case sensitive)")
    void testCompareFirstStringGreaterThanSecondStringCaseSensitive() {
        int result = stringUtils.compare("a", "B");
        assertTrue(result > 0);
    }
    
    @Test
    @DisplayName("Should return negative value when first string is a substring of second string")
    void testCompareFirstStringSubstringOfSecondString() {
        int result = stringUtils.compare("ab", "abc");
        assertTrue(result < 0);
    }
    import static org.junit.jupiter.api.Assertions.*;
    
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Nested;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class StringUtilsTest {
    
        private StringUtils stringUtils;
    
        @BeforeEach
        void setUp() {
            stringUtils = new StringUtils();
        }
    
        @Nested
        @DisplayName("Test startsWithIgnoreCase")
        class StartsWithIgnoreCase {
    
            @Test
            void shouldReturnTrueWhenStringsAreEqualIgnoringCase() {
                assertTrue(stringUtils.startsWithIgnoreCase("abcdef", "ABC"));
            }
    
            @Test
            void shouldReturnTrueWhenStringStartsWithPrefixIgnoringCase() {
                assertTrue(stringUtils.startsWithIgnoreCase("abcdef", "AB"));
            }
    
            @Test
            void shouldReturnFalseWhenStringDoesNotStartWithPrefixIgnoringCase() {
                assertFalse(stringUtils.startsWithIgnoreCase("abcdef", "CD"));
            }
    
            @Test
            void shouldReturnFalseWhenStringIsNullAndPrefixIsNotNull() {
                assertFalse(stringUtils.startsWithIgnoreCase(null, "abc"));
            }
    
            @Test
            void shouldReturnFalseWhenPrefixIsNullAndStringIsNotNull() {
                assertFalse(stringUtils.startsWithIgnoreCase("abcdef", null));
            }
    
            @Test
            void shouldReturnTrueWhenBothStringAndPrefixAreNull() {
                assertTrue(stringUtils.startsWithIgnoreCase(null, null));
            }
    
        }
    }
    @Test
    public void testRemoveEndIgnoreCase_nullSourceString() {
      String result = stringUtils.removeEndIgnoreCase(null, "remove");
      assertEquals(null, result);
    }
    
    @Test
    public void testRemoveEndIgnoreCase_emptySourceString() {
      String result = stringUtils.removeEndIgnoreCase("", "remove");
      assertEquals("", result);
    }
    
    @Test
    public void testRemoveEndIgnoreCase_nullRemoveString() {
      String result = stringUtils.removeEndIgnoreCase("source", null);
      assertEquals("source", result);
    }
    
    @Test
    public void testRemoveEndIgnoreCase_removeStringNotFound() {
      String result = stringUtils.removeEndIgnoreCase("source", "remove");
      assertEquals("source", result);
    }
    
    @Test
    public void testRemoveEndIgnoreCase_removeStringFoundAtEnd() {
      String result = stringUtils.removeEndIgnoreCase("www.domain.com", ".com");
      assertEquals("www.domain", result);
    }
    
    @Test
    public void testRemoveEndIgnoreCase_removeStringFoundNotAtEnd() {
      String result = stringUtils.removeEndIgnoreCase("www.domain.com", ".com.");
      assertEquals("www.domain.com", result);
    }
    
    @Test
    public void testRemoveEndIgnoreCase_removeStringIgnoreCase() {
      String result = stringUtils.removeEndIgnoreCase("www.domain.com", ".COM");
      assertEquals("www.domain", result);
    }
    
    @Test
    public void testRemoveEndIgnoreCase_removeStringCaseSensitive() {
      String result = stringUtils.removeEndIgnoreCase("www.domain.COM", ".com");
      assertEquals("www.domain", result);
    }
    
    @Test
    public void testRemoveEndIgnoreCase_removeStringEmpty() {
      String result = stringUtils.removeEndIgnoreCase("abc", "");
      assertEquals("abc", result);
    }
    @Test
    public void testIsNotEmpty_Null_ReturnsFalse() {
        CharSequence cs = null;
        boolean result = stringUtils.isNotEmpty(cs);
        Assertions.assertFalse(result);
    }
    
    @Test
    public void testIsNotEmpty_EmptyString_ReturnsFalse() {
        CharSequence cs = "";
        boolean result = stringUtils.isNotEmpty(cs);
        Assertions.assertFalse(result);
    }
    
    @Test
    public void testIsNotEmpty_SpaceCharacter_ReturnsTrue() {
        CharSequence cs = " ";
        boolean result = stringUtils.isNotEmpty(cs);
        Assertions.assertTrue(result);
    }
    
    @Test
    public void testIsNotEmpty_NonEmptyString_ReturnsTrue() {
        CharSequence cs = "bob";
        boolean result = stringUtils.isNotEmpty(cs);
        Assertions.assertTrue(result);
    }
    
    @Test
    public void testIsNotEmpty_StringWithSpaces_ReturnsTrue() {
        CharSequence cs = "  bob  ";
        boolean result = stringUtils.isNotEmpty(cs);
        Assertions.assertTrue(result);
    }
    @Test
    void testUncapitalizeNullInput() {
        assertNull(stringUtils.uncapitalize(null));
    }
    
    @Test
    void testUncapitalizeEmptyString() {
        assertEquals("", stringUtils.uncapitalize(""));
    }
    
    @Test
    void testUncapitalizeLowerCaseString() {
        assertEquals("cat", stringUtils.uncapitalize("cat"));
    }
    
    @Test
    void testUncapitalizeCapitalizedString() {
        assertEquals("cat", stringUtils.uncapitalize("Cat"));
    }
    
    @Test
    void testUncapitalizeUpperCaseString() {
        assertEquals("cAT", stringUtils.uncapitalize("CAT"));
    }
    
    @Test
    void testUncapitalizeFirstCharacterNotLetter() {
        assertEquals("123abc", stringUtils.uncapitalize("123abc"));
    }
    
    @Test
    void testUncapitalizeFirstCharacterLetter() {
        assertEquals("abc", stringUtils.uncapitalize("Abc"));
    }
    
    @Test
    void testUncapitalizeFirstCharacterUnicode() {
        assertEquals("άbc", stringUtils.uncapitalize("Άbc"));
    }
    
    @Test
    void testUncapitalizeFirstCharacterExtendedUnicode() {
        assertEquals("𐐏bc", stringUtils.uncapitalize("𐐏bc"));
    }
    
    @Test
    void testUncapitalizeLongString() {
        String str = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        assertEquals(str.toLowerCase(), stringUtils.uncapitalize(str));
    }
    @Test
        @DisplayName("Test prependIfMissing with null string and null prefix")
        void testPrependIfMissingWithNullStringAndNullPrefix() {
            String result = StringUtils.prependIfMissing(null, null);
            assertNull(result);
        }
    
        @Test
        @DisplayName("Test prependIfMissing with non-null string and null prefix")
        void testPrependIfMissingWithNonNullStringAndNullPrefix() {
            String result = StringUtils.prependIfMissing("abc", null);
            assertEquals("abc", result);
        }
    
        @Test
        @DisplayName("Test prependIfMissing with empty string and non-null prefix")
        void testPrependIfMissingWithEmptyStringAndNonNullPrefix() {
            String result = StringUtils.prependIfMissing("", "xyz");
            assertEquals("xyz", result);
        }
    
        @Test
        @DisplayName("Test prependIfMissing with non-empty string and non-null prefix")
        void testPrependIfMissingWithNonEmptyStringAndNonNullPrefix() {
            String result = StringUtils.prependIfMissing("abc", "xyz");
            assertEquals("xyzabc", result);
        }
    
        @Test
        @DisplayName("Test prependIfMissing with string starting with prefix")
        void testPrependIfMissingWithStringStartingWithPrefix() {
            String result = StringUtils.prependIfMissing("xyzabc", "xyz");
            assertEquals("xyzabc", result);
        }
    
        @Test
        @DisplayName("Test prependIfMissing with string starting with different case prefix")
        void testPrependIfMissingWithStringStartingWithDifferentCasePrefix() {
            String result = StringUtils.prependIfMissing("XYZabc", "xyz");
            assertEquals("xyzXYZabc", result);
        }
    
        @Test
        @DisplayName("Test prependIfMissing with additional prefixes")
        void testPrependIfMissingWithAdditionalPrefixes() {
            String result = StringUtils.prependIfMissing("abc", "xyz", "mno");
            assertEquals("xyzabc", result);
        }
    
        @Test
        @DisplayName("Test prependIfMissing with additional prefixes and string starting with prefix")
        void testPrependIfMissingWithAdditionalPrefixesAndStringStartingWithPrefix() {
            String result = StringUtils.prependIfMissing("xyzabc", "xyz", "mno");
            assertEquals("xyzabc", result);
        }
    
        @Test
        @DisplayName("Test prependIfMissing with additional prefixes and string starting with different case prefix")
        void testPrependIfMissingWithAdditionalPrefixesAndStringStartingWithDifferentCasePrefix() {
            String result = StringUtils.prependIfMissing("XYZabc", "xyz", "mno");
            assertEquals("xyzXYZabc", result);
        }
    
        @Test
        @DisplayName("Test prependIfMissing with additional prefixes and string starting with additional prefix")
        void testPrependIfMissingWithAdditionalPrefixesAndStringStartingWithAdditionalPrefix() {
            String result = StringUtils.prependIfMissing("mnoabc", "xyz", "mno");
            assertEquals("mnoabc", result);
        }
    
        @Test
        @DisplayName("Test prependIfMissing with additional prefixes and string starting with different case additional prefix")
        void testPrependIfMissingWithAdditionalPrefixesAndStringStartingWithDifferentCaseAdditionalPrefix() {
            String result = StringUtils.prependIfMissing("MNOabc", "xyz", "mno");
            assertEquals("xyzMNOabc", result);
        }
    @Test
    public void testStripToNull() {
        // Test with null input
        Assertions.assertNull(StringUtils.stripToNull(null));
    
        // Test with empty string
        Assertions.assertNull(StringUtils.stripToNull(""));
    
        // Test with whitespace string
        Assertions.assertNull(StringUtils.stripToNull("   "));
    
        // Test with non-empty string
        Assertions.assertEquals("abc", StringUtils.stripToNull("abc"));
    
        // Test with leading whitespace
        Assertions.assertEquals("abc", StringUtils.stripToNull("  abc"));
    
        // Test with trailing whitespace
        Assertions.assertEquals("abc", StringUtils.stripToNull("abc  "));
    
        // Test with leading and trailing whitespace
        Assertions.assertEquals("abc", StringUtils.stripToNull(" abc "));
    
        // Test with whitespace in the middle
        Assertions.assertEquals("ab c", StringUtils.stripToNull(" ab c "));
    }
    // Your Java code here
    
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    
    import static org.junit.jupiter.api.Assertions.assertEquals;
    import static org.junit.jupiter.api.Assertions.assertNull;
    
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class StringUtilsTest {
    
        private final StringUtils stringUtils = new StringUtils();
    
        @Test
        void testRemoveEndWithEmptyStringAndNullRemove() {
            String result = stringUtils.removeEnd("", null);
            assertEquals("", result);
        }
    
        @Test
        void testRemoveEndWithNullStringAndEmptyRemove() {
            String result = stringUtils.removeEnd(null, "");
            assertNull(result);
        }
    
        @Test
        void testRemoveEndWithNullStringAndNullRemove() {
            String result = stringUtils.removeEnd(null, null);
            assertNull(result);
        }
    }
    @Test
    void testLastIndexOf_NullCharSequence_ReturnsNegativeOne() {
        // Arrange
        CharSequence seq = null;
        CharSequence searchSeq = "a";
    
        // Act
        int result = stringUtils.lastIndexOf(seq, searchSeq);
    
        // Assert
        assertEquals(-1, result);
    }
    
    @Test
    void testLastIndexOf_NullSearchCharSequence_ReturnsNegativeOne() {
        // Arrange
        CharSequence seq = "aabaabaa";
        CharSequence searchSeq = null;
    
        // Act
        int result = stringUtils.lastIndexOf(seq, searchSeq);
    
        // Assert
        assertEquals(-1, result);
    }
    
    @Test
    void testLastIndexOf_EmptyCharSequence_ReturnsNegativeOne() {
        // Arrange
        CharSequence seq = "";
        CharSequence searchSeq = "a";
    
        // Act
        int result = stringUtils.lastIndexOf(seq, searchSeq);
    
        // Assert
        assertEquals(-1, result);
    }
    
    @Test
    void testLastIndexOf_EmptySearchCharSequence_ReturnsLengthOfSeq() {
        // Arrange
        CharSequence seq = "aabaabaa";
        CharSequence searchSeq = "";
    
        // Act
        int result = stringUtils.lastIndexOf(seq, searchSeq);
    
        // Assert
        assertEquals(seq.length(), result);
    }
    
    @Test
    void testLastIndexOf_SearchCharSequenceNotFound_ReturnsNegativeOne() {
        // Arrange
        CharSequence seq = "aabaabaa";
        CharSequence searchSeq = "c";
    
        // Act
        int result = stringUtils.lastIndexOf(seq, searchSeq);
    
        // Assert
        assertEquals(-1, result);
    }
    
    @Test
    void testLastIndexOf_SearchCharSequenceFound_ReturnsIndexOfLastOccurrence() {
        // Arrange
        CharSequence seq = "aabaabaa";
        CharSequence searchSeq = "a";
    
        // Act
        int result = stringUtils.lastIndexOf(seq, searchSeq);
    
        // Assert
        assertEquals(7, result);
    }
    
    @Test
    void testLastIndexOf_SearchCharSequenceFoundAtStartPos_ReturnsIndexOfLastOccurrenceBeforeStartPos() {
        // Arrange
        CharSequence seq = "aabaabaa";
        CharSequence searchSeq = "b";
        int startPos = 8;
    
        // Act
        int result = stringUtils.lastIndexOf(seq, searchSeq, startPos);
    
        // Assert
        assertEquals(5, result);
    }
    
    @Test
    void testLastIndexOf_SearchCharSequenceNotFoundAtStartPos_ReturnsNegativeOne() {
        // Arrange
        CharSequence seq = "aabaabaa";
        CharSequence searchSeq = "b";
        int startPos = 0;
    
        // Act
        int result = stringUtils.lastIndexOf(seq, searchSeq, startPos);
    
        // Assert
        assertEquals(-1, result);
    }
    
    @Test
    void testLastIndexOf_SearchCharFound_ReturnsIndexOfLastOccurrence() {
        // Arrange
        CharSequence seq = "aabaabaa";
        int searchChar = 'a';
    
        // Act
        int result = stringUtils.lastIndexOf(seq, searchChar);
    
        // Assert
        assertEquals(7, result);
    }
    
    @Test
    void testLastIndexOf_SearchCharNotFound_ReturnsNegativeOne() {
        // Arrange
        CharSequence seq = "aabaabaa";
        int searchChar = 'c';
    
        // Act
        int result = stringUtils.lastIndexOf(seq, searchChar);
    
        // Assert
        assertEquals(-1, result);
    }
    
    @Test
    void testLastIndexOf_SearchCharFoundAtStartPos_ReturnsIndexOfLastOccurrenceBeforeStartPos() {
        // Arrange
        CharSequence seq = "aabaabaa";
        int searchChar = 'b';
        int startPos = 8;
    
        // Act
        int result = stringUtils.lastIndexOf(seq, searchChar, startPos);
    
        // Assert
        assertEquals(5, result);
    }
    
    @Test
    void testLastIndexOf_SearchCharNotFoundAtStartPos_ReturnsNegativeOne() {
        // Arrange
        CharSequence seq = "aabaabaa";
        int searchChar = 'b';
        int startPos = 0;
    
        // Act
        int result = stringUtils.lastIndexOf(seq, searchChar, startPos);
    
        // Assert
        assertEquals(-1, result);
    }
    import static org.junit.jupiter.api.Assertions.*;
    import org.junit.jupiter.api.Test;
    
    class StringUtilsTest {
    
        @Test
        void shouldRemoveLastCharacter() {
            String input = "abc \r";
            String expectedOutput = "abc ";
            assertEquals(expectedOutput, StringUtils.chop(input));
        }
    
        @Test
        void shouldRemoveLastCharacterEmptyString() {
            String input = "";
            String expectedOutput = "";
            assertEquals(expectedOutput, StringUtils.chop(input));
        }
    
        @Test
        void shouldRemoveLastCharacterMultipleLines() {
            String input = "abc\nabc";
            String expectedOutput = "abc\nab";
            assertEquals(expectedOutput, StringUtils.chop(input));
        }
    
        @Test
        void shouldRemoveLastCharacterSingleCharacter() {
            String input = "a";
            String expectedOutput = "";
            assertEquals(expectedOutput, StringUtils.chop(input));
        }
    
        @Test
        void shouldRemoveLastCharacterNewLine() {
            String input = "\n";
            String expectedOutput = "";
            assertEquals(expectedOutput, StringUtils.chop(input));
        }
    
        @Test
        void shouldRemoveLastCharacterCarriageReturn() {
            String input = "\r";
            String expectedOutput = "";
            assertEquals(expectedOutput, StringUtils.chop(input));
        }
    
        @Test
        void shouldRemoveLastCharacterCarriageReturnAndNewLine() {
            String input = "\r\n";
            String expectedOutput = "";
            assertEquals(expectedOutput, StringUtils.chop(input));
        }
    }
    @Test
    void testIsAnyBlank() {
        // Test with empty input
        assertFalse(StringUtils.isAnyBlank());
    
        // Test with null input
        assertFalse(StringUtils.isAnyBlank((CharSequence[]) null));
    
        // Test with empty strings
        assertTrue(StringUtils.isAnyBlank("", "", ""));
    
        // Test with blank strings
        assertTrue(StringUtils.isAnyBlank("   ", "  ", " "));
    
        // Test with non-blank strings
        assertFalse(StringUtils.isAnyBlank("abc", "def", "ghi"));
    
        // Test with a mix of blank and non-blank strings
        assertTrue(StringUtils.isAnyBlank("abc", "", "def"));
    
        // Test with null and non-null strings
        assertTrue(StringUtils.isAnyBlank(null, "abc", "def"));
    
        // Test with null and blank strings
        assertTrue(StringUtils.isAnyBlank(null, "", "def"));
    
        // Test with a single blank string
        assertTrue(StringUtils.isAnyBlank(""));
    
        // Test with a single non-blank string
        assertFalse(StringUtils.isAnyBlank("abc"));
    
        // Test with a single null string
        assertTrue(StringUtils.isAnyBlank((CharSequence) null));
    }
    @Test
    @DisplayName("Should return null for null input")
    void testNullInput() {
        String result = StringUtils.lowerCase(null);
    
        Assertions.assertNull(result);
    }
    
    @Test
    @DisplayName("Should return an empty string for an empty input")
    void testEmptyInput() {
        String result = StringUtils.lowerCase("");
    
        Assertions.assertEquals("", result);
    }
    
    @Test
    @DisplayName("Should convert a non-empty string to lower case")
    void testLowerCaseConversion() {
        String result = StringUtils.lowerCase("aBc");
    
        Assertions.assertEquals("abc", result);
    }
    
    @Test
    @DisplayName("Should return null for null input")
    void testNullInputWithLocale() {
        String result = StringUtils.lowerCase(null, Locale.ENGLISH);
    
        Assertions.assertNull(result);
    }
    
    @Test
    @DisplayName("Should return an empty string for an empty input")
    void testEmptyInputWithLocale() {
        String result = StringUtils.lowerCase("", Locale.ENGLISH);
    
        Assertions.assertEquals("", result);
    }
    
    @Test
    @DisplayName("Should convert a non-empty string to lower case with the specified locale")
    void testLowerCaseConversionWithLocale() {
        String result = StringUtils.lowerCase("aBc", Locale.ENGLISH);
    
        Assertions.assertEquals("abc", result);
    }
    import static org.junit.jupiter.api.Assertions.*;
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Nested;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    import org.junit.jupiter.params.ParameterizedTest;
    import org.junit.jupiter.params.provider.MethodSource;
    
    import java.util.Arrays;
    import java.util.List;
    import java.util.stream.Stream;
    
    @DisplayName("StringUtils startsWithAny Test Suite")
    class StringUtilsTest {
    
        private StringUtils stringUtils;
    
        @BeforeEach
        void setUp() {
            stringUtils = new StringUtils();
        }
    
        @Nested
        @DisplayName("Tests for startsWithAny method")
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        class StartsWithAnyTests {
    
            private Stream<Arguments> startsWithAnyArguments() {
                return Stream.of(
                        Arguments.of(null, new String[] {"abc"}, false),
                        Arguments.of("abcxyz", null, false),
                        Arguments.of("abcxyz", new String[] {}, false),
                        Arguments.of("abcxyz", new String[] {""}, true),
                        Arguments.of("abcxyz", new String[] {"abc"}, true),
                        Arguments.of("abcxyz", new String[] {null, "xyz", "abc"}, true),
                        Arguments.of("abcxyz", new String[] {null, "xyz", "ABCX"}, false),
                        Arguments.of("ABCXYZ", new String[] {null, "xyz", "abc"}, false)
                );
            }
    
            @ParameterizedTest(name = "startsWithAny({0}, {1}) = {2}")
            @MethodSource("startsWithAnyArguments")
            void startsWithAny_ShouldReturnExpectedResult(String sequence, String[] searchStrings, boolean expectedResult) {
                boolean result = stringUtils.startsWithAny(sequence, searchStrings);
                assertEquals(expectedResult, result);
            }
        }
    
        @Test
        void exampleTest1() {
            // Test code here
        }
    
        @Test
        void exampleTest2() {
            // Test code here
        }
    
        // Add more @Test methods as needed
    
    }
    // Here are the @Test test functions:
    
    @Test
    void testToStringWithNullBytesAndNullCharsetName() {
        byte[] bytes = null;
        String charsetName = null;
        String expected = null;
    
        String result = StringUtils.toString(bytes, charsetName);
    
        assertEquals(expected, result);
    }
    
    @Test
    void testToStringWithNullBytesAndCharsetName() {
        byte[] bytes = null;
        String charsetName = "UTF-8";
        String expected = null;
    
        String result = StringUtils.toString(bytes, charsetName);
    
        assertEquals(expected, result);
    }
    
    @Test
    void testToStringWithBytesAndNullCharsetName() throws UnsupportedEncodingException {
        byte[] bytes = "Hello".getBytes();
        String charsetName = null;
        String expected = null;
    
        String result = StringUtils.toString(bytes, charsetName);
    
        assertEquals(expected, result);
    }
    
    @Test
    void testToStringWithBytesAndCharsetName() throws UnsupportedEncodingException {
        byte[] bytes = "Hello".getBytes();
        String charsetName = "UTF-8";
        String expected = "Hello";
    
        String result = StringUtils.toString(bytes, charsetName);
    
        assertEquals(expected, result);
    }
    @Test
    void testStripAll_NullArray_ReturnNull() {
        String[] strs = null;
        String[] result = stringUtils.stripAll(strs);
        assertNull(result);
    }
    
    @Test
    void testStripAll_EmptyArray_ReturnEmptyArray() {
        String[] strs = new String[0];
        String[] result = stringUtils.stripAll(strs);
        assertEquals(0, result.length);
    }
    
    @Test
    void testStripAll_NoWhitespace_ReturnStrippedStrings() {
        String[] strs = {"abc", "def", "ghi"};
        String[] result = stringUtils.stripAll(strs);
        assertArrayEquals(strs, result);
    }
    
    @Test
    void testStripAll_Whitespace_ReturnStrippedStrings() {
        String[] strs = {" abc ", " def ", " ghi "};
        String[] expected = {"abc", "def", "ghi"};
        String[] result = stringUtils.stripAll(strs);
        assertArrayEquals(expected, result);
    }
    
    @Test
    void testStripAll_NullEntry_ReturnStrippedStrings() {
        String[] strs = {"abc", null, "def"};
        String[] expected = {"abc", null, "def"};
        String[] result = stringUtils.stripAll(strs);
        assertArrayEquals(expected, result);
    }
    
    @Test
    void testStripAll_StripCharsNull_ReturnStrippedStrings() {
        String[] strs = {"abc", "  abc", "def"};
        String[] expected = {"abc", "abc", "def"};
        String[] result = stringUtils.stripAll(strs, null);
        assertArrayEquals(expected, result);
    }
    
    @Test
    void testStripAll_StripCharsEmpty_ReturnStrippedStrings() {
        String[] strs = {"abc", "  abc", "def"};
        String[] expected = {"abc", "abc", "def"};
        String[] result = stringUtils.stripAll(strs, "");
        assertArrayEquals(expected, result);
    }
    
    @Test
    void testStripAll_StripCharsWhitespace_ReturnStrippedStrings() {
        String[] strs = {"  abc  ", "  def  ", "  ghi  "};
        String[] expected = {"abc", "def", "ghi"};
        String[] result = stringUtils.stripAll(strs, " ");
        assertArrayEquals(expected, result);
    }
    
    @Test
    void testStripAll_StripCharsNonWhitespace_ReturnStrippedStrings() {
        String[] strs = {"xyzabcxyz", "yzdefyz", "ghi"};
        String[] expected = {"abc", "def", "ghi"};
        String[] result = stringUtils.stripAll(strs, "yz");
        assertArrayEquals(expected, result);
    }
    @Test
    @DisplayName("should return null when input string is null")
    void shouldReturnNullWhenInputStringIsNull() {
        // Arrange
        String str = null;
        String separator = "-";
    
        // Act
        String[] result = StringUtils.splitByWholeSeparator(str, separator);
    
        // Assert
        assertNull(result);
    }
    
    @Test
    @DisplayName("should return empty array when input string is empty")
    void shouldReturnEmptyArrayWhenInputStringIsEmpty() {
        // Arrange
        String str = "";
        String separator = "-";
    
        // Act
        String[] result = StringUtils.splitByWholeSeparator(str, separator);
    
        // Assert
        assertEquals(0, result.length);
    }
    
    @Test
    @DisplayName("should split the string by the separator")
    void shouldSplitStringBySeparator() {
        // Arrange
        String str = "ab-cd-ef";
        String separator = "-";
    
        // Act
        String[] result = StringUtils.splitByWholeSeparator(str, separator);
    
        // Assert
        assertArrayEquals(new String[]{"ab", "cd", "ef"}, result);
    }
    
    @Test
    @DisplayName("should split the string by the separator and ignore adjacent separators")
    void shouldSplitStringBySeparatorAndIgnoreAdjacentSeparators() {
        // Arrange
        String str = "ab--cd--ef";
        String separator = "--";
    
        // Act
        String[] result = StringUtils.splitByWholeSeparator(str, separator);
    
        // Assert
        assertArrayEquals(new String[]{"ab", "cd", "ef"}, result);
    }
    
    @Test
    @DisplayName("should split the string by whitespace when separator is null")
    void shouldSplitStringByWhitespaceWhenSeparatorIsNull() {
        // Arrange
        String str = "ab cd ef";
        String separator = null;
    
        // Act
        String[] result = StringUtils.splitByWholeSeparator(str, separator);
    
        // Assert
        assertArrayEquals(new String[]{"ab", "cd", "ef"}, result);
    }
    
    @Test
    @DisplayName("should return null when input string is null")
    void shouldReturnNullWhenInputStringIsNull() {
        // Arrange
        String str = null;
        String separator = "-";
        int max = 2;
    
        // Act
        String[] result = StringUtils.splitByWholeSeparator(str, separator, max);
    
        // Assert
        assertNull(result);
    }
    
    @Test
    @DisplayName("should return empty array when input string is empty")
    void shouldReturnEmptyArrayWhenInputStringIsEmpty() {
        // Arrange
        String str = "";
        String separator = "-";
        int max = 2;
    
        // Act
        String[] result = StringUtils.splitByWholeSeparator(str, separator, max);
    
        // Assert
        assertEquals(0, result.length);
    }
    
    @Test
    @DisplayName("should split the string by the separator up to the maximum number of elements")
    void shouldSplitStringBySeparatorUpToMaximumNumberOfElements() {
        // Arrange
        String str = "ab-cd-ef-gh";
        String separator = "-";
        int max = 3;
    
        // Act
        String[] result = StringUtils.splitByWholeSeparator(str, separator, max);
    
        // Assert
        assertArrayEquals(new String[]{"ab", "cd", "ef-gh"}, result);
    }
    
    @Test
    @DisplayName("should split the string by the separator and ignore adjacent separators up to the maximum number of elements")
    void shouldSplitStringBySeparatorAndIgnoreAdjacentSeparatorsUpToMaximumNumberOfElements() {
        // Arrange
        String str = "ab--cd--ef--gh";
        String separator = "--";
        int max = 3;
    
        // Act
        String[] result = StringUtils.splitByWholeSeparator(str, separator, max);
    
        // Assert
        assertArrayEquals(new String[]{"ab", "cd", "ef--gh"}, result);
    }
    
    @Test
    @DisplayName("should split the string by whitespace when separator is null and up to the maximum number of elements")
    void shouldSplitStringByWhitespaceWhenSeparatorIsNullAndUpToMaximumNumberOfElements() {
        // Arrange
        String str = "ab cd ef gh";
        String separator = null;
        int max = 3;
    
        // Act
        String[] result = StringUtils.splitByWholeSeparator(str, separator, max);
    
        // Assert
        assertArrayEquals(new String[]{"ab", "cd", "ef gh"}, result);
    }
    @Test
    void testCountMatchesWithNullString() {
        int result = stringUtils.countMatches(null, 'a');
        Assertions.assertEquals(0, result);
    }
    
    @Test
    void testCountMatchesWithEmptyString() {
        int result = stringUtils.countMatches("", 'a');
        Assertions.assertEquals(0, result);
    }
    
    @Test
    void testCountMatchesWithNoMatch() {
        int result = stringUtils.countMatches("abba", 'x');
        Assertions.assertEquals(0, result);
    }
    
    @Test
    void testCountMatchesWithSingleMatch() {
        int result = stringUtils.countMatches("abba", 'b');
        Assertions.assertEquals(2, result);
    }
    
    @Test
    void testCountMatchesWithMultipleMatches() {
        int result = stringUtils.countMatches("ababa", "aba");
        Assertions.assertEquals(1, result);
    }
    
    @Test
    void testCountMatchesWithMultiCharacterSubstring() {
        int result = stringUtils.countMatches("abba", "ab");
        Assertions.assertEquals(1, result);
    }
    import static org.junit.jupiter.api.Assertions.*;
    import org.junit.jupiter.api.Test;
    
    class StringUtilsTest {
    
        private StringUtils stringUtils;
    
        @BeforeEach
        void setUp() {
            stringUtils = new StringUtils();
        }
    
        @Test
        void testIsEmptyWithEmptyString() {
            assertTrue(stringUtils.isEmpty(""));
        }
    
        @Test
        void testIsEmptyWithNullString() {
            assertTrue(stringUtils.isEmpty(null));
        }
    
        @Test
        void testIsEmptyWithStringWithSpaces() {
            assertFalse(stringUtils.isEmpty(" "));
        }
    
        @Test
        void testIsEmptyWithNonEmptyString() {
            assertFalse(stringUtils.isEmpty("bob"));
        }
    
        @Test
        void testIsEmptyWithStringWithLeadingAndTrailingSpaces() {
            assertFalse(stringUtils.isEmpty("  bob  "));
        }
    }
    @Test
    void testReplace_NullText_ReturnsNull() {
        String result = stringUtils.replace(null, "a", "b");
        assertEquals(null, result);
    }
    
    @Test
    void testReplace_EmptyText_ReturnsEmpty() {
        String result = stringUtils.replace("", "a", "b");
        assertEquals("", result);
    }
    
    @Test
    void testReplace_NullSearchString_ReturnsUnchangedText() {
        String result = stringUtils.replace("any", null, "b");
        assertEquals("any", result);
    }
    
    @Test
    void testReplace_NullReplacement_ReturnsUnchangedText() {
        String result = stringUtils.replace("any", "a", null);
        assertEquals("any", result);
    }
    
    @Test
    void testReplace_EmptySearchString_ReturnsUnchangedText() {
        String result = stringUtils.replace("any", "", "b");
        assertEquals("any", result);
    }
    
    @Test
    void testReplace_NoOccurrences_ReturnsUnchangedText() {
        String result = stringUtils.replace("aba", "c", "b");
        assertEquals("aba", result);
    }
    
    @Test
    void testReplace_OneOccurrence_ReturnsTextWithReplacement() {
        String result = stringUtils.replace("aba", "a", "z");
        assertEquals("zbz", result);
    }
    
    @Test
    void testReplace_MultipleOccurrences_ReturnsTextWithReplacements() {
        String result = stringUtils.replace("abaa", "a", "z");
        assertEquals("zbza", result);
    }
    
    @Test
    void testReplace_MaxZero_ReturnsUnchangedText() {
        String result = stringUtils.replace("abaa", "a", "z", 0);
        assertEquals("abaa", result);
    }
    
    @Test
    void testReplace_MaxOne_ReturnsTextWithFirstOccurrenceReplaced() {
        String result = stringUtils.replace("abaa", "a", "z", 1);
        assertEquals("zbaa", result);
    }
    
    @Test
    void testReplace_MaxTwo_ReturnsTextWithFirstTwoOccurrencesReplaced() {
        String result = stringUtils.replace("abaa", "a", "z", 2);
        assertEquals("zbza", result);
    }
    
    @Test
    void testReplace_MaxNegative_ReturnsTextWithAllOccurrencesReplaced() {
        String result = stringUtils.replace("abaa", "a", "z", -1);
        assertEquals("zbzz", result);
    }
    @Test
    @DisplayName("should return true for a string with only digits")
    void testIsNumericWithOnlyDigits() {
        assertTrue(StringUtils.isNumeric("123"));
    }
    
    @Test
    @DisplayName("should return true for a string with unicode digits")
    void testIsNumericWithUnicodeDigits() {
        assertTrue(StringUtils.isNumeric("\u0967\u0968\u0969"));
    }
    
    @Test
    @DisplayName("should return false for an empty string")
    void testIsNumericWithEmptyString() {
        assertFalse(StringUtils.isNumeric(""));
    }
    
    @Test
    @DisplayName("should return false for a string with spaces")
    void testIsNumericWithSpaces() {
        assertFalse(StringUtils.isNumeric("  "));
    }
    
    @Test
    @DisplayName("should return false for a string with non-digits")
    void testIsNumericWithNonDigits() {
        assertFalse(StringUtils.isNumeric("ab2c"));
    }
    
    @Test
    @DisplayName("should return false for a string with a decimal point")
    void testIsNumericWithDecimalPoint() {
        assertFalse(StringUtils.isNumeric("12.3"));
    }
    
    @Test
    @DisplayName("should return false for a string with a negative sign")
    void testIsNumericWithNegativeSign() {
        assertFalse(StringUtils.isNumeric("-123"));
    }
    
    @Test
    @DisplayName("should return false for a string with a positive sign")
    void testIsNumericWithPositiveSign() {
        assertFalse(StringUtils.isNumeric("+123"));
    }
    import org.junit.jupiter.api.Test;
    import static org.junit.jupiter.api.Assertions.*;
    
    class StringUtilsTestSuite {
        @Test
        void testIsAsciiPrintable_NullString_ReturnsFalse() {
            assertFalse(StringUtils.isAsciiPrintable(null));
        }
    
        @Test
        void testIsAsciiPrintable_EmptyString_ReturnsTrue() {
            assertTrue(StringUtils.isAsciiPrintable(""));
        }
    
        @Test
        void testIsAsciiPrintable_SpaceCharacter_ReturnsTrue() {
            assertTrue(StringUtils.isAsciiPrintable(" "));
        }
    
        @Test
        void testIsAsciiPrintable_AllAsciiPrintableCharacters_ReturnsTrue() {
            assertTrue(StringUtils.isAsciiPrintable("Ceki"));
        }
    
        @Test
        void testIsAsciiPrintable_ContainsNonAsciiPrintableCharacters_ReturnsFalse() {
            assertFalse(StringUtils.isAsciiPrintable("Ceki Gülçü"));
        }
    }
    import static org.junit.jupiter.api.Assertions.*;
    
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.Nested;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    import org.junit.jupiter.api.TestInstance.Lifecycle;
    
    @TestInstance(Lifecycle.PER_CLASS)
    class StringUtilsTest {
    
        private StringUtils StringUtils;
    
        @BeforeEach
        void setUp() {
            StringUtils = new StringUtils();
        }
    
        @Nested
        @DisplayName("toCodePoints")
        class ToCodePoints {
    
            @Test
            @DisplayName("Should return null if input is null")
            void shouldReturnNullIfInputIsNull() {
                // Given
                CharSequence input = null;
    
                // When
                int[] result = StringUtils.toCodePoints(input);
    
                // Then
                assertNull(result);
            }
    
            @Test
            @DisplayName("Should return an empty array if input is empty")
            void shouldReturnEmptyArrayIfInputIsEmpty() {
                // Given
                CharSequence input = "";
    
                // When
                int[] result = StringUtils.toCodePoints(input);
    
                // Then
                assertEquals(0, result.length);
            }
    
            @Test
            @DisplayName("Should convert a CharSequence into an array of code points")
            void shouldConvertCharSequenceIntoArrayOfCodePoints() {
                // Given
                CharSequence input = "Hello, World!";
    
                // When
                int[] result = StringUtils.toCodePoints(input);
    
                // Then
                int[] expected = {72, 101, 108, 108, 111, 44, 32, 87, 111, 114, 108, 100, 33};
                assertArrayEquals(expected, result);
            }
    
            @Test
            @DisplayName("Should handle surrogate pairs correctly")
            void shouldHandleSurrogatePairsCorrectly() {
                // Given
                CharSequence input = "😀👍";
    
                // When
                int[] result = StringUtils.toCodePoints(input);
    
                // Then
                int[] expected = {128512, 128077};
                assertArrayEquals(expected, result);
            }
        }
    }
    @Test
    void testGetBytes_NullString_ReturnEmptyByteArray() {
        byte[] result = stringUtils.getBytes(null, Charset.defaultCharset());
        assertEquals(0, result.length);
    }
    
    @Test
    void testGetBytes_NullCharset_ReturnDefaultCharsetByteArray() {
        String string = "Hello World";
        byte[] expectedResult = string.getBytes(Charset.defaultCharset());
        byte[] result = stringUtils.getBytes(string, null);
        assertArrayEquals(expectedResult, result);
    }
    
    @Test
    void testGetBytes_ValidStringAndCharset_ReturnByteArray() {
        String string = "Hello World";
        Charset charset = Charset.forName("UTF-8");
        byte[] expectedResult = string.getBytes(charset);
        byte[] result = stringUtils.getBytes(string, charset);
        assertArrayEquals(expectedResult, result);
    }
    
    @Test
    void testGetBytes_ValidStringAndInvalidCharset_ThrowUnsupportedEncodingException() {
        String string = "Hello World";
        String charset = "InvalidCharset";
        assertThrows(UnsupportedEncodingException.class, () -> {
            stringUtils.getBytes(string, charset);
        });
    }
    @Test
    void testIsAllBlank_NullInput_ReturnsTrue() {
        assertTrue(StringUtils.isAllBlank(null));
    }
    
    @Test
    void testIsAllBlank_NullAndNonBlankInput_ReturnsFalse() {
        assertFalse(StringUtils.isAllBlank(null, "foo"));
    }
    
    @Test
    void testIsAllBlank_NullAndNullInput_ReturnsTrue() {
        assertTrue(StringUtils.isAllBlank(null, null));
    }
    
    @Test
    void testIsAllBlank_EmptyAndNonBlankInput_ReturnsFalse() {
        assertFalse(StringUtils.isAllBlank("", "bar"));
    }
    
    @Test
    void testIsAllBlank_NonBlankAndEmptyInput_ReturnsFalse() {
        assertFalse(StringUtils.isAllBlank("bob", ""));
    }
    
    @Test
    void testIsAllBlank_WhitespaceAndNullInput_ReturnsFalse() {
        assertFalse(StringUtils.isAllBlank("  bob  ", null));
    }
    
    @Test
    void testIsAllBlank_WhitespaceAndNonBlankInput_ReturnsFalse() {
        assertFalse(StringUtils.isAllBlank(" ", "bar"));
    }
    
    @Test
    void testIsAllBlank_NonBlankInput_ReturnsFalse() {
        assertFalse(StringUtils.isAllBlank("foo", "bar"));
    }
    
    @Test
    void testIsAllBlank_EmptyArrayInput_ReturnsTrue() {
        assertTrue(StringUtils.isAllBlank(new String[] {}));
    }
    @Test
    void testRemoveIgnoreCase_nullSourceString() {
      assertNull(stringUtils.removeIgnoreCase(null, "remove"));
    }
    
    @Test
    void testRemoveIgnoreCase_emptySourceString() {
      assertEquals("", stringUtils.removeIgnoreCase("", "remove"));
    }
    
    @Test
    void testRemoveIgnoreCase_nullRemoveString() {
      assertEquals("source", stringUtils.removeIgnoreCase("source", null));
    }
    
    @Test
    void testRemoveIgnoreCase_emptyRemoveString() {
      assertEquals("source", stringUtils.removeIgnoreCase("source", ""));
    }
    
    @Test
    void testRemoveIgnoreCase_removeStringNotFound() {
      assertEquals("source", stringUtils.removeIgnoreCase("source", "remove"));
    }
    
    @Test
    void testRemoveIgnoreCase_removeStringFound() {
      assertEquals("qd", stringUtils.removeIgnoreCase("queued", "ue"));
    }
    
    @Test
    void testRemoveIgnoreCase_removeStringFoundIgnoreCase() {
      assertEquals("qd", stringUtils.removeIgnoreCase("quEUed", "UE"));
    }
    
    @Test
    void testRemoveIgnoreCase_multipleOccurrencesOfRemoveString() {
      assertEquals("qdqd", stringUtils.removeIgnoreCase("queuedqueued", "ue"));
    }
    
    @Test
    void testRemoveIgnoreCase_removeStringEqualsSourceString() {
      assertEquals("", stringUtils.removeIgnoreCase("remove", "remove"));
    }
    @Test
        void testGetJaroWinklerDistance_NullStrings_IllegalArgumentException() {
            assertThrows(IllegalArgumentException.class, () -> stringUtils.getJaroWinklerDistance(null, null));
        }
    
        @Test
        void testGetJaroWinklerDistance_EmptyStrings_ZeroDistance() {
            assertEquals(0.0, stringUtils.getJaroWinklerDistance("", ""));
            assertEquals(0.0, stringUtils.getJaroWinklerDistance("", "a"));
            assertEquals(0.0, stringUtils.getJaroWinklerDistance("aaapppp", ""));
        }
    
        @Test
        void testGetJaroWinklerDistance_SameStrings_FullDistance() {
            assertEquals(1.0, stringUtils.getJaroWinklerDistance("frog", "frog"));
            assertEquals(1.0, stringUtils.getJaroWinklerDistance("hello", "hello"));
        }
    
        @Test
        void testGetJaroWinklerDistance_SimilarStrings_HighDistance() {
            assertEquals(0.93, stringUtils.getJaroWinklerDistance("frog", "fog"));
            assertEquals(0.88, stringUtils.getJaroWinklerDistance("hello", "hallo"));
            assertEquals(0.93, stringUtils.getJaroWinklerDistance("ABC Corporation", "ABC Corp"));
            assertEquals(0.95, stringUtils.getJaroWinklerDistance("D N H Enterprises Inc", "D & H Enterprises, Inc."));
            assertEquals(0.92, stringUtils.getJaroWinklerDistance("My Gym Children's Fitness Center", "My Gym. Childrens Fitness"));
            assertEquals(0.88, stringUtils.getJaroWinklerDistance("PENNSYLVANIA", "PENNCISYLVNIA"));
        }
    
        @Test
        void testGetJaroWinklerDistance_DissimilarStrings_LowDistance() {
            assertEquals(0.0, stringUtils.getJaroWinklerDistance("fly", "ant"));
            assertEquals(0.44, stringUtils.getJaroWinklerDistance("elephant", "hippo"));
            assertEquals(0.0, stringUtils.getJaroWinklerDistance("hippo", "zzzzzzzz"));
        }
    @Test
    void testReplacePattern_nullSource() {
        String result = stringUtils.replacePattern(null, ".*", "zzz");
        Assertions.assertNull(result);
    }
    
    @Test
    void testReplacePattern_nullRegex() {
        String result = stringUtils.replacePattern("any", null, "zzz");
        Assertions.assertEquals("any", result);
    }
    
    @Test
    void testReplacePattern_nullReplacement() {
        String result = stringUtils.replacePattern("any", ".*", null);
        Assertions.assertEquals("any", result);
    }
    
    @Test
    void testReplacePattern_emptySourceAndRegex() {
        String result = stringUtils.replacePattern("", "", "zzz");
        Assertions.assertEquals("zzz", result);
    }
    
    @Test
    void testReplacePattern_emptySourceAndNonEmptyRegex() {
        String result = stringUtils.replacePattern("", ".*", "zzz");
        Assertions.assertEquals("zzz", result);
    }
    
    @Test
    void testReplacePattern_emptySourceAndNonEmptyRegex_withSpecialCharacters() {
        String result = stringUtils.replacePattern("", "<.*>", "zzz");
        Assertions.assertEquals("zzz", result);
    }
    
    @Test
    void testReplacePattern_emptySourceAndNonEmptyRegex_withAlphabets() {
        String result = stringUtils.replacePattern("", "[a-z]", "zzz");
        Assertions.assertEquals("", result);
    }
    
    @Test
    void testReplacePattern_nonEmptySourceAndEmptyRegex() {
        String result = stringUtils.replacePattern("ABCabc123", "", "zzz");
        Assertions.assertEquals("ABCabc123", result);
    }
    
    @Test
    void testReplacePattern_nonEmptySourceAndNonEmptyRegex_withAlphabets() {
        String result = stringUtils.replacePattern("ABCabc123", "[a-z]", "_");
        Assertions.assertEquals("ABC___123", result);
    }
    
    @Test
    void testReplacePattern_nonEmptySourceAndNonEmptyRegex_withNonAlphanumeric() {
        String result = stringUtils.replacePattern("ABCabc123", "[^A-Z0-9]+", "_");
        Assertions.assertEquals("ABC_123", result);
    }
    
    @Test
    void testReplacePattern_nonEmptySourceAndNonEmptyRegex_withNonAlphanumericAndEmptyReplacement() {
        String result = stringUtils.replacePattern("ABCabc123", "[^A-Z0-9]+", "");
        Assertions.assertEquals("ABC123", result);
    }
    
    @Test
    void testReplacePattern_nonEmptySourceAndNonEmptyRegex_withSpaces() {
        String result = stringUtils.replacePattern("Lorem ipsum  dolor   sit", "( +)([a-z]+)", "_$2");
        Assertions.assertEquals("Lorem_ipsum_dolor_sit", result);
    }
    @Test
    void testNullStringInput() {
        assertNull(StringUtils.overlay(null, "abc", 0, 0));
    }
    
    @Test
    void testEmptyOverlay() {
        assertEquals("abc", StringUtils.overlay("", "abc", 0, 0));
    }
    
    @Test
    void testNullOverlay() {
        assertEquals("abef", StringUtils.overlay("abcdef", null, 2, 4));
    }
    
    @Test
    void testEmptyOverlayWithIndicesSwapped() {
        assertEquals("abef", StringUtils.overlay("abcdef", "", 4, 2));
    }
    
    @Test
    void testOverlayWithNonEmptyString() {
        assertEquals("abzzzzef", StringUtils.overlay("abcdef", "zzzz", 2, 4));
    }
    
    @Test
    void testOverlayWithNegativeStartIndex() {
        assertEquals("zzzzef", StringUtils.overlay("abcdef", "zzzz", -1, 4));
    }
    
    @Test
    void testOverlayWithEndIndexOutOfRange() {
        assertEquals("abzzzz", StringUtils.overlay("abcdef", "zzzz", 2, 8));
    }
    
    @Test
    void testOverlayWithIndicesOutOfRange() {
        assertEquals("zzzzabcdef", StringUtils.overlay("abcdef", "zzzz", -2, -3));
    }
    
    @Test
    void testOverlayWithEndIndexGreaterThanStringLength() {
        assertEquals("abcdefzzzz", StringUtils.overlay("abcdef", "zzzz", 8, 10));
    }
    import org.junit.jupiter.api.Assertions;
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Nested;
    import org.junit.jupiter.api.Test;
    import java.util.Locale;
    
    class StringUtilsTest {
    
        @Nested
        @DisplayName("toRootUpperCase method")
        class ToRootUpperCaseTests {
    
            @Test
            @DisplayName("should return null when source is null")
            void testToRootUpperCaseWithNullSource() {
                // Arrange
                String source = null;
    
                // Act
                String result = StringUtils.toRootUpperCase(source);
    
                // Assert
                Assertions.assertNull(result);
            }
    
            @Test
            @DisplayName("should return the upper-case of the source string")
            void testToRootUpperCaseWithValidSource() {
                // Arrange
                String source = "hello world";
                String expected = "HELLO WORLD";
    
                // Act
                String result = StringUtils.toRootUpperCase(source);
    
                // Assert
                Assertions.assertEquals(expected, result);
            }
        }
    }
    @Test
    void testSubstringBetween() {
        // Test with null input String and tag
        assertEquals(null, stringUtils.substringBetween(null, null));
    
        // Test with empty input String and tag
        assertEquals("", stringUtils.substringBetween("", ""));
    
        // Test with empty input String and non-empty tag
        assertEquals(null, stringUtils.substringBetween("", "tag"));
    
        // Test with input String and null tag
        assertEquals(null, stringUtils.substringBetween("tagabctag", null));
    
        // Test with input String and empty tag
        assertEquals("", stringUtils.substringBetween("tagabctag", ""));
    
        // Test with input String, tag before and after the substring
        assertEquals("abc", stringUtils.substringBetween("tagabctag", "tag"));
    
        // Test with input String, tag before and after the substring
        assertEquals("b", stringUtils.substringBetween("wx[b]yz", "[", "]"));
    
        // Test with input String, empty tag before and after the substring
        assertEquals("", stringUtils.substringBetween("yabcz", "", ""));
    
        // Test with input String, tag before and after the substring
        assertEquals("abc", stringUtils.substringBetween("yabczyabcz", "y", "z"));
    }
    @Test
    @DisplayName("Should return null when given null string")
    void testCapitalizeNullString() {
      // Arrange
      String str = null;
      
      // Act
      String result = StringUtils.capitalize(str);
      
      // Assert
      assertEquals(null, result);
    }
    
    @Test
    @DisplayName("Should return empty string when given empty string")
    void testCapitalizeEmptyString() {
      // Arrange
      String str = "";
      
      // Act
      String result = StringUtils.capitalize(str);
      
      // Assert
      assertEquals("", result);
    }
    
    @Test
    @DisplayName("Should capitalize the first character of a word")
    void testCapitalizeWord() {
      // Arrange
      String str = "cat";
      
      // Act
      String result = StringUtils.capitalize(str);
      
      // Assert
      assertEquals("Cat", result);
    }
    
    @Test
    @DisplayName("Should not change the case of the remaining characters")
    void testCapitalizeMixedCase() {
      // Arrange
      String str = "cAt";
      
      // Act
      String result = StringUtils.capitalize(str);
      
      // Assert
      assertEquals("CAt", result);
    }
    
    @Test
    @DisplayName("Should not capitalize special characters")
    void testCapitalizeSpecialCharacters() {
      // Arrange
      String str = "'cat'";
      
      // Act
      String result = StringUtils.capitalize(str);
      
      // Assert
      assertEquals("'cat'", result);
    }
    @Test
    void testIsMixedCase_returnsTrueForMixedCaseString() {
        boolean result = StringUtils.isMixedCase("aBc");
        assertTrue(result);
    }
    
    @Test
    void testIsMixedCase_returnsTrueForMixedCaseStringWithWhitespace() {
        boolean result = StringUtils.isMixedCase("A c");
        assertTrue(result);
    }
    
    @Test
    void testIsMixedCase_returnsTrueForMixedCaseStringWithNumbers() {
        boolean result = StringUtils.isMixedCase("A1c");
        assertTrue(result);
    }
    
    @Test
    void testIsMixedCase_returnsTrueForMixedCaseStringWithSpecialCharacters() {
        boolean result = StringUtils.isMixedCase("a/C");
        assertTrue(result);
    }
    
    @Test
    void testIsMixedCase_returnsTrueForMixedCaseStringWithWhitespaceAndTab() {
        boolean result = StringUtils.isMixedCase("aC\t");
        assertTrue(result);
    }
    @Test
    @DisplayName("Returns empty string when input array is null")
    void testGetCommonPrefix_NullArray_ReturnsEmptyString() {
        String[] strs = null;
    
        String result = stringUtils.getCommonPrefix(strs);
    
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Returns empty string when input array is empty")
    void testGetCommonPrefix_EmptyArray_ReturnsEmptyString() {
        String[] strs = {};
    
        String result = stringUtils.getCommonPrefix(strs);
    
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Returns the only string in the array when there is only one string")
    void testGetCommonPrefix_OneStringInArray_ReturnsString() {
        String[] strs = {"abc"};
    
        String result = stringUtils.getCommonPrefix(strs);
    
        assertEquals("abc", result);
    }
    
    @Test
    @DisplayName("Returns empty string when all strings in the array are null")
    void testGetCommonPrefix_AllNullStringsInArray_ReturnsEmptyString() {
        String[] strs = {null, null};
    
        String result = stringUtils.getCommonPrefix(strs);
    
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Returns empty string when all strings in the array are empty")
    void testGetCommonPrefix_AllEmptyStringsInArray_ReturnsEmptyString() {
        String[] strs = {"", ""};
    
        String result = stringUtils.getCommonPrefix(strs);
    
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Returns empty string when one string in the array is null")
    void testGetCommonPrefix_OneNullStringInArray_ReturnsEmptyString() {
        String[] strs = {"", null};
    
        String result = stringUtils.getCommonPrefix(strs);
    
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Returns empty string when one string in the array is empty")
    void testGetCommonPrefix_OneEmptyStringInArray_ReturnsEmptyString() {
        String[] strs = {"abc", ""};
    
        String result = stringUtils.getCommonPrefix(strs);
    
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Returns empty string when one string in the array is empty and one string is null")
    void testGetCommonPrefix_OneEmptyStringAndOneNullStringInArray_ReturnsEmptyString() {
        String[] strs = {"abc", null, null};
    
        String result = stringUtils.getCommonPrefix(strs);
    
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Returns empty string when there is no common prefix")
    void testGetCommonPrefix_NoCommonPrefix_ReturnsEmptyString() {
        String[] strs = {"abc", "xyz"};
    
        String result = stringUtils.getCommonPrefix(strs);
    
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Returns the common prefix when it exists")
    void testGetCommonPrefix_CommonPrefixExists_ReturnsCommonPrefix() {
        String[] strs = {"abcde", "abxyz"};
    
        String result = stringUtils.getCommonPrefix(strs);
    
        assertEquals("ab", result);
    }
    
    @Test
    @DisplayName("Returns empty string when input array contains one string with common prefix and one string without common prefix")
    void testGetCommonPrefix_OneStringWithCommonPrefixAndOneStringWithoutCommonPrefix_ReturnsEmptyString() {
        String[] strs = {"abcde", "xyz"};
    
        String result = stringUtils.getCommonPrefix(strs);
    
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Returns common prefix when input array contains multiple strings with common prefix")
    void testGetCommonPrefix_MultipleStringsWithCommonPrefix_ReturnsCommonPrefix() {
        String[] strs = {"abcde", "abxyz"};
    
        String result = stringUtils.getCommonPrefix(strs);
    
        assertEquals("ab", result);
    }
    
    @Test
    @DisplayName("Returns common prefix when input array contains multiple strings with common prefix and one string without common prefix")
    void testGetCommonPrefix_MultipleStringsWithCommonPrefixAndOneStringWithoutCommonPrefix_ReturnsCommonPrefix() {
        String[] strs = {"abcde", "abxyz", "xyz"};
    
        String result = stringUtils.getCommonPrefix(strs);
    
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Returns common prefix when input array contains multiple strings with common prefix and one string with common prefix only at the start")
    void testGetCommonPrefix_MultipleStringsWithCommonPrefixAndOneStringWithCommonPrefixOnlyAtStart_ReturnsCommonPrefix() {
        String[] strs = {"abcde", "abxyz", "a"};
    
        String result = stringUtils.getCommonPrefix(strs);
    
        assertEquals("a", result);
    }
    
    @Test
    @DisplayName("Returns common prefix when input array contains multiple strings with common prefix and one string with common prefix only at the end")
    void testGetCommonPrefix_MultipleStringsWithCommonPrefixAndOneStringWithCommonPrefixOnlyAtEnd_ReturnsCommonPrefix() {
        String[] strs = {"abcde", "abxyz", "ab"};
    
        String result = stringUtils.getCommonPrefix(strs);
    
        assertEquals("ab", result);
    }
    
    @Test
    @DisplayName("Returns common prefix when input array contains multiple strings with common prefix and one string with common prefix only in the middle")
    void testGetCommonPrefix_MultipleStringsWithCommonPrefixAndOneStringWithCommonPrefixOnlyInMiddle_ReturnsCommonPrefix() {
        String[] strs = {"abcde", "abxyz", "axyz"};
    
        String result = stringUtils.getCommonPrefix(strs);
    
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Returns common prefix when input array contains multiple strings with common prefix and one string with common prefix overlapping at the start and end")
    void testGetCommonPrefix_MultipleStringsWithCommonPrefixAndOneStringWithCommonPrefixOverlappingAtStartAndEnd_ReturnsCommonPrefix() {
        String[] strs = {"abcde", "abxyz", "ab"};
    
        String result = stringUtils.getCommonPrefix(strs);
    
        assertEquals("ab", result);
    }
    
    @Test
    @DisplayName("Returns common prefix when input array contains multiple strings with common prefix and one string with common prefix overlapping in the middle")
    void testGetCommonPrefix_MultipleStringsWithCommonPrefixAndOneStringWithCommonPrefixOverlappingInMiddle_ReturnsCommonPrefix() {
        String[] strs = {"abcde", "abxyz", "abxyz"};
    
        String result = stringUtils.getCommonPrefix(strs);
    
        assertEquals("ab", result);
    }
    
    @Test
    @DisplayName("Returns common prefix when input array contains multiple strings with common prefix and one string with common prefix overlapping at the start and middle")
    void testGetCommonPrefix_MultipleStringsWithCommonPrefixAndOneStringWithCommonPrefixOverlappingAtStartAndMiddle_ReturnsCommonPrefix() {
        String[] strs = {"abcde", "abxyz", "a"};
    
        String result = stringUtils.getCommonPrefix(strs);
    
        assertEquals("a", result);
    }
    
    @Test
    @DisplayName("Returns common prefix when input array contains multiple strings with common prefix and one string with common prefix overlapping at the middle and end")
    void testGetCommonPrefix_MultipleStringsWithCommonPrefixAndOneStringWithCommonPrefixOverlappingAtMiddleAndEnd_ReturnsCommonPrefix() {
        String[] strs = {"abcde", "abxyz", "xyz"};
    
        String result = stringUtils.getCommonPrefix(strs);
    
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Returns common prefix when input array contains multiple strings with common prefix and one string with common prefix overlapping at the start, middle, and end")
    void testGetCommonPrefix_MultipleStringsWithCommonPrefixAndOneStringWithCommonPrefixOverlappingAtStartMiddleAndEnd_ReturnsCommonPrefix() {
        String[] strs = {"abcde", "abxyz", "ab"};
    
        String result = stringUtils.getCommonPrefix(strs);
    
        assertEquals("ab", result);
    }
    
    @Test
    @DisplayName("Returns common prefix when input array contains multiple strings with common prefix and one string with common prefix overlapping at the start and end but not in the middle")
    void testGetCommonPrefix_MultipleStringsWithCommonPrefixAndOneStringWithCommonPrefixOverlappingAtStartAndEndButNotInMiddle_ReturnsCommonPrefix() {
        String[] strs = {"abcde", "abxyz", "axyz"};
    
        String result = stringUtils.getCommonPrefix(strs);
    
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Returns common prefix when input array contains multiple strings with common prefix and one string with common prefix overlapping at the start and middle but not at the end")
    void testGetCommonPrefix_MultipleStringsWithCommonPrefixAndOneStringWithCommonPrefixOverlappingAtStartAndMiddleButNotAtEnd_ReturnsCommonPrefix() {
        String[] strs = {"abcde", "abxyz", "a"};
    
        String result = stringUtils.getCommonPrefix(strs);
    
        assertEquals("a", result);
    }
    
    @Test
    @DisplayName("Returns common prefix when input array contains multiple strings with common prefix and one string with common prefix overlapping at the middle and end but not at the start")
    void testGetCommonPrefix_MultipleStringsWithCommonPrefixAndOneStringWithCommonPrefixOverlappingAtMiddleAndEndButNotAtStart_ReturnsCommonPrefix() {
        String[] strs = {"abcde", "abxyz", "xyz"};
    
        String result = stringUtils.getCommonPrefix(strs);
    
        assertEquals("", result);
    }
    
    @Test
    @DisplayName("Returns common prefix when input array contains multiple strings with common prefix and one string with common prefix overlapping at the start, middle, and end but not in the middle")
    void testGetCommonPrefix_MultipleStringsWithCommonPrefixAndOneStringWithCommonPrefixOverlappingAtStartMiddleAndEndButNotInMiddle_ReturnsCommonPrefix() {
        String[] strs = {"abcde", "abxyz", "ab"};
    
        String result = stringUtils.getCommonPrefix(strs);
    
        assertEquals("ab", result);
    }
    
    @Test
    @DisplayName("Returns common prefix when input array contains multiple strings with common prefix and one string with common prefix overlapping at the start and middle but not at the end and another string with common prefix overlapping at the middle and end but not at the start")
    void testGetCommonPrefix_MultipleStringsWithCommonPrefixAndOneStringWithCommonPrefixOverlappingAtStartAndMiddleButNotAtEndAndAnotherStringWithCommonPrefixOverlappingAtMiddleAndEndButNotAtStart_ReturnsCommonPrefix() {
        String[] strs = {"abcde", "abxyz", "ab", "xyz"};
    
        String result = stringUtils.getCommonPrefix(strs);
    
        assertEquals("", result);
    }
    @Test
    void testEqualsAnyIgnoreCase_NullStringAndNullSearchStrings_ReturnsFalse() {
        CharSequence string = null;
        CharSequence[] searchStrings = null;
    
        boolean result = stringUtils.equalsAnyIgnoreCase(string, searchStrings);
    
        Assertions.assertFalse(result);
    }
    
    @Test
    void testEqualsAnyIgnoreCase_NullStringAndNonNullSearchStrings_ReturnsFalse() {
        CharSequence string = null;
        CharSequence[] searchStrings = {"abc", "def"};
    
        boolean result = stringUtils.equalsAnyIgnoreCase(string, searchStrings);
    
        Assertions.assertFalse(result);
    }
    
    @Test
    void testEqualsAnyIgnoreCase_NonNullStringAndNullSearchStrings_ReturnsFalse() {
        CharSequence string = "abc";
        CharSequence[] searchStrings = null;
    
        boolean result = stringUtils.equalsAnyIgnoreCase(string, searchStrings);
    
        Assertions.assertFalse(result);
    }
    
    @Test
    void testEqualsAnyIgnoreCase_EmptyStringAndNonNullSearchStrings_ReturnsFalse() {
        CharSequence string = "";
        CharSequence[] searchStrings = {"abc", "def"};
    
        boolean result = stringUtils.equalsAnyIgnoreCase(string, searchStrings);
    
        Assertions.assertFalse(result);
    }
    
    @Test
    void testEqualsAnyIgnoreCase_NonEmptyStringAndNullSearchStrings_ReturnsFalse() {
        CharSequence string = "abc";
        CharSequence[] searchStrings = null;
    
        boolean result = stringUtils.equalsAnyIgnoreCase(string, searchStrings);
    
        Assertions.assertFalse(result);
    }
    
    @Test
    void testEqualsAnyIgnoreCase_NonEmptyStringAndEmptySearchStrings_ReturnsFalse() {
        CharSequence string = "abc";
        CharSequence[] searchStrings = {};
    
        boolean result = stringUtils.equalsAnyIgnoreCase(string, searchStrings);
    
        Assertions.assertFalse(result);
    }
    
    @Test
    void testEqualsAnyIgnoreCase_StringEqualIgnoreCaseToOneSearchString_ReturnsTrue() {
        CharSequence string = "abc";
        CharSequence[] searchStrings = {"ABC"};
    
        boolean result = stringUtils.equalsAnyIgnoreCase(string, searchStrings);
    
        Assertions.assertTrue(result);
    }
    
    @Test
    void testEqualsAnyIgnoreCase_StringEqualIgnoreCaseToMultipleSearchStrings_ReturnsTrue() {
        CharSequence string = "abc";
        CharSequence[] searchStrings = {"ABC", "DEF", "GHI"};
    
        boolean result = stringUtils.equalsAnyIgnoreCase(string, searchStrings);
    
        Assertions.assertTrue(result);
    }
    
    @Test
    void testEqualsAnyIgnoreCase_StringNotEqualIgnoreCaseToAnySearchString_ReturnsFalse() {
        CharSequence string = "abc";
        CharSequence[] searchStrings = {"DEF", "GHI"};
    
        boolean result = stringUtils.equalsAnyIgnoreCase(string, searchStrings);
    
        Assertions.assertFalse(result);
    }
    @Test
    void testReverseDelimited_withNullString_shouldReturnNull() {
        String reversed = StringUtils.reverseDelimited(null, '.');
        assertEquals(null, reversed);
    }
    
    @Test
    void testReverseDelimited_withEmptyString_shouldReturnEmptyString() {
        String reversed = StringUtils.reverseDelimited("", '.');
        assertEquals("", reversed);
    }
    
    @Test
    void testReverseDelimited_withNoDelimiter_shouldReturnSameString() {
        String reversed = StringUtils.reverseDelimited("abc", '.');
        assertEquals("abc", reversed);
    }
    
    @Test
    void testReverseDelimited_withDelimiter_shouldReturnReversedString() {
        String reversed = StringUtils.reverseDelimited("a.b.c", '.');
        assertEquals("c.b.a", reversed);
    }
    
    @Test
    void testReverseDelimited_withMultipleDelimiters_shouldReturnReversedString() {
        String reversed = StringUtils.reverseDelimited("a.b.c.d", '.');
        assertEquals("d.c.b.a", reversed);
    }
    @Test
    void testEqualsAny_NullStringAndNullSearchStrings_ReturnsFalse() {
      CharSequence string = null;
      CharSequence[] searchStrings = null;
      
      assertFalse(StringUtils.equalsAny(string, searchStrings));
    }
    
    @Test
    void testEqualsAny_NullStringAndEmptySearchStrings_ReturnsFalse() {
      CharSequence string = null;
      CharSequence[] searchStrings = new CharSequence[0];
      
      assertFalse(StringUtils.equalsAny(string, searchStrings));
    }
    
    @Test
    void testEqualsAny_NullStringAndNonEmptySearchStrings_ReturnsFalse() {
      CharSequence string = null;
      CharSequence[] searchStrings = { "abc", "def" };
      
      assertFalse(StringUtils.equalsAny(string, searchStrings));
    }
    
    @Test
    void testEqualsAny_EmptyStringAndNullSearchStrings_ReturnsFalse() {
      CharSequence string = "";
      CharSequence[] searchStrings = null;
      
      assertFalse(StringUtils.equalsAny(string, searchStrings));
    }
    
    @Test
    void testEqualsAny_EmptyStringAndEmptySearchStrings_ReturnsFalse() {
      CharSequence string = "";
      CharSequence[] searchStrings = new CharSequence[0];
      
      assertFalse(StringUtils.equalsAny(string, searchStrings));
    }
    
    @Test
    void testEqualsAny_EmptyStringAndNonEmptySearchStrings_ReturnsFalse() {
      CharSequence string = "";
      CharSequence[] searchStrings = { "abc", "def" };
      
      assertFalse(StringUtils.equalsAny(string, searchStrings));
    }
    
    @Test
    void testEqualsAny_NonEmptyStringAndNullSearchStrings_ReturnsFalse() {
      CharSequence string = "abc";
      CharSequence[] searchStrings = null;
      
      assertFalse(StringUtils.equalsAny(string, searchStrings));
    }
    
    @Test
    void testEqualsAny_NonEmptyStringAndEmptySearchStrings_ReturnsFalse() {
      CharSequence string = "abc";
      CharSequence[] searchStrings = new CharSequence[0];
      
      assertFalse(StringUtils.equalsAny(string, searchStrings));
    }
    
    @Test
    void testEqualsAny_NonEmptyStringAndNonEmptySearchStrings_ReturnsFalse() {
      CharSequence string = "abc";
      CharSequence[] searchStrings = { "def", "ghi" };
      
      assertFalse(StringUtils.equalsAny(string, searchStrings));
    }
    
    @Test
    void testEqualsAny_StringEqualsToFirstSearchString_ReturnsTrue() {
      CharSequence string = "abc";
      CharSequence[] searchStrings = { "abc", "def" };
      
      assertTrue(StringUtils.equalsAny(string, searchStrings));
    }
    
    @Test
    void testEqualsAny_StringEqualsToLastSearchString_ReturnsTrue() {
      CharSequence string = "def";
      CharSequence[] searchStrings = { "abc", "def" };
      
      assertTrue(StringUtils.equalsAny(string, searchStrings));
    }
    
    @Test
    void testEqualsAny_StringEqualsToMiddleSearchString_ReturnsTrue() {
      CharSequence string = "def";
      CharSequence[] searchStrings = { "abc", "def", "ghi" };
      
      assertTrue(StringUtils.equalsAny(string, searchStrings));
    }
    
    @Test
    void testEqualsAny_StringDoesNotEqualAnySearchString_ReturnsFalse() {
      CharSequence string = "xyz";
      CharSequence[] searchStrings = { "abc", "def", "ghi" };
      
      assertFalse(StringUtils.equalsAny(string, searchStrings));
    }
    @Test
    void testIsAlphanumeric_NullInput_ReturnsFalse() {
        assertFalse(StringUtils.isAlphanumeric(null));
    }
    
    @Test
    void testIsAlphanumeric_EmptyString_ReturnsFalse() {
        assertFalse(StringUtils.isAlphanumeric(""));
    }
    
    @Test
    void testIsAlphanumeric_Whitespace_ReturnsFalse() {
        assertFalse(StringUtils.isAlphanumeric("  "));
    }
    
    @Test
    void testIsAlphanumeric_OnlyLetters_ReturnsTrue() {
        assertTrue(StringUtils.isAlphanumeric("abc"));
    }
    
    @Test
    void testIsAlphanumeric_LettersAndWhitespace_ReturnsFalse() {
        assertFalse(StringUtils.isAlphanumeric("ab c"));
    }
    
    @Test
    void testIsAlphanumeric_LettersAndDigits_ReturnsTrue() {
        assertTrue(StringUtils.isAlphanumeric("ab2c"));
    }
    
    @Test
    void testIsAlphanumeric_LettersAndSpecialCharacters_ReturnsFalse() {
        assertFalse(StringUtils.isAlphanumeric("ab-c"));
    }
    
    @Test
    void testIsAlphanumeric_SpecialCharacters_ReturnsFalse() {
        assertFalse(StringUtils.isAlphanumeric("!@#$%^&*()"));
    }
    
    @Test
    void testIsAlphanumeric_Numbers_ReturnsTrue() {
        assertTrue(StringUtils.isAlphanumeric("1234567890"));
    }
    
    @Test
    void testIsAlphanumeric_NumbersAndWhitespace_ReturnsFalse() {
        assertFalse(StringUtils.isAlphanumeric("123 456"));
    }
    
    @Test
    void testIsAlphanumeric_NumbersAndSpecialCharacters_ReturnsFalse() {
        assertFalse(StringUtils.isAlphanumeric("123#456"));
    }
    
    @Test
    void testIsAlphanumeric_LettersNumbersAndSpecialCharacters_ReturnsFalse() {
        assertFalse(StringUtils.isAlphanumeric("abc123#"));
    }
    
    @Test
    void testIsAlphanumeric_LargeInput_ReturnsTrue() {
        assertTrue(StringUtils.isAlphanumeric("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed non risus. Suspendisse"));
    }
    @Test
    void testAppendIfMissing_NullString() {
        String actual = stringUtils.appendIfMissing(null, "suffix");
        assertNull(actual);
    }
    
    @Test
    void testAppendIfMissing_NullSuffix() {
        String str = "abc";
        String actual = stringUtils.appendIfMissing(str, null);
        assertEquals(str, actual);
    }
    
    @Test
    void testAppendIfMissing_EmptySuffix() {
        String str = "abc";
        String actual = stringUtils.appendIfMissing(str, "");
        assertEquals(str, actual);
    }
    
    @Test
    void testAppendIfMissing_StringEndsWithSuffix() {
        String str = "abcxyz";
        String actual = stringUtils.appendIfMissing(str, "xyz");
        assertEquals(str, actual);
    }
    
    @Test
    void testAppendIfMissing_AppendSuffix() {
        String str = "abc";
        String suffix = "xyz";
        String expected = "abcxyz";
        String actual = stringUtils.appendIfMissing(str, suffix);
        assertEquals(expected, actual);
    }
    
    @Test
    void testAppendIfMissing_AppendSuffixWithMultipleSuffixes() {
        String str = "abc";
        String suffix1 = "xyz";
        String suffix2 = "mno";
        String expected = "abcxyz";
        String actual = stringUtils.appendIfMissing(str, suffix1, suffix2);
        assertEquals(expected, actual);
    }
    
    @Test
    void testAppendIfMissing_AppendSuffixWithAdditionalSuffixes() {
        String str = "abc";
        String suffix = "xyz";
        String additionalSuffix = "mno";
        String expected = "abcxyz";
        String actual = stringUtils.appendIfMissing(str, suffix, additionalSuffix);
        assertEquals(expected, actual);
    }
    
    @Test
    void testAppendIfMissing_NullStringAndSuffixes() {
        String actual = stringUtils.appendIfMissing(null, null, null);
        assertNull(actual);
    }
    
    @Test
    void testAppendIfMissing_NullStringAndNullSuffixes() {
        String str = null;
        String actual = stringUtils.appendIfMissing(str, null, null);
        assertNull(actual);
    }
    
    @Test
    void testAppendIfMissing_NullSuffixAndNullSuffixes() {
        String str = "abc";
        String actual = stringUtils.appendIfMissing(str, null, null);
        assertEquals(str, actual);
    }
    
    @Test
    void testAppendIfMissing_EmptySuffixAndNullSuffixes() {
        String str = "abc";
        String actual = stringUtils.appendIfMissing(str, "", null);
        assertEquals(str, actual);
    }
    
    @Test
    void testAppendIfMissing_AppendSuffixWithNullSuffixes() {
        String str = "abc";
        String suffix = "xyz";
        String expected = "abcxyz";
        String actual = stringUtils.appendIfMissing(str, suffix, null);
        assertEquals(expected, actual);
    }
    
    @Test
    void testAppendIfMissing_AppendSuffixWithEmptySuffixes() {
        String str = "abc";
        String suffix = "xyz";
        String expected = "abcxyz";
        String actual = stringUtils.appendIfMissing(str, suffix, "");
        assertEquals(expected, actual);
    }
    
    @Test
    void testAppendIfMissing_StringEndsWithSuffixAndNullSuffixes() {
        String str = "abcxyz";
        String expected = "abcxyz";
        String actual = stringUtils.appendIfMissing(str, "xyz", null);
        assertEquals(expected, actual);
    }
    
    @Test
    void testAppendIfMissing_StringEndsWithSuffixAndEmptySuffixes() {
        String str = "abcxyz";
        String expected = "abcxyz";
        String actual = stringUtils.appendIfMissing(str, "xyz", "");
        assertEquals(expected, actual);
    }
    
    @Test
    void testAppendIfMissing_StringEndsWithSuffixAndAdditionalSuffixes() {
        String str = "abcxyz";
        String suffix = "xyz";
        String additionalSuffix = "mno";
        String expected = "abcxyz";
        String actual = stringUtils.appendIfMissing(str, suffix, additionalSuffix);
        assertEquals(expected, actual);
    }
    
    @Test
    void testAppendIfMissing_StringEndsWithSuffixAndSuffixesProvided() {
        String str = "abcxyz";
        String suffix = "xyz";
        String expected = "abcxyz";
        String actual = stringUtils.appendIfMissing(str, suffix, "mno", "pqr");
        assertEquals(expected, actual);
    }
    
    @Test
    void testAppendIfMissing_StringEndsWithSuffixAndNullAdditionalSuffixes() {
        String str = "abcxyz";
        String suffix = "xyz";
        String expected = "abcxyz";
        String actual = stringUtils.appendIfMissing(str, suffix, null);
        assertEquals(expected, actual);
    }
    
    @Test
    void testAppendIfMissing_StringEndsWithSuffixAndEmptyAdditionalSuffixes() {
        String str = "abcxyz";
        String suffix = "xyz";
        String expected = "abcxyz";
        String actual = stringUtils.appendIfMissing(str, suffix, "");
        assertEquals(expected, actual);
    }
    
    @Test
    void testAppendIfMissing_StringEndsWithSuffixAndAdditionalSuffixesProvided() {
        String str = "abcxyz";
        String suffix = "xyz";
        String expected = "abcxyz";
        String actual = stringUtils.appendIfMissing(str, suffix, "mno", "pqr");
        assertEquals(expected, actual);
    }
    
    @Test
    void testAppendIfMissing_StringEndsWithSuffixAndNullAndEmptyAdditionalSuffixes() {
        String str = "abcxyz";
        String suffix = "xyz";
        String expected = "abcxyz";
        String actual = stringUtils.appendIfMissing(str, suffix, null, "");
        assertEquals(expected, actual);
    }
    // Should return null when input is null
    @Test
    void testAbbreviateMiddleWithNullInput() {
        // Given
        String str = null;
        String middle = null;
        int length = 0;
        
        // When
        String result = StringUtils.abbreviateMiddle(str, middle, length);
        
        // Then
        Assertions.assertNull(result);
    }
    
    // Should return original string when middle is null and length is 0
    @Test
    void testAbbreviateMiddleWithNullMiddleAndZeroLength() {
        // Given
        String str = "abc";
        String middle = null;
        int length = 0;
        
        // When
        String result = StringUtils.abbreviateMiddle(str, middle, length);
        
        // Then
        Assertions.assertEquals(str, result);
    }
    
    // Should return original string when middle is null and length is less than string length
    @Test
    void testAbbreviateMiddleWithNullMiddleAndLengthLessThanStringLength() {
        // Given
        String str = "abc";
        String middle = null;
        int length = 2;
        
        // When
        String result = StringUtils.abbreviateMiddle(str, middle, length);
        
        // Then
        Assertions.assertEquals(str, result);
    }
    
    // Should return original string when middle is null and length is equal to string length
    @Test
    void testAbbreviateMiddleWithNullMiddleAndLengthEqualToStringLength() {
        // Given
        String str = "abc";
        String middle = null;
        int length = 3;
        
        // When
        String result = StringUtils.abbreviateMiddle(str, middle, length);
        
        // Then
        Assertions.assertEquals(str, result);
    }
    
    // Should return original string when middle is null and length is greater than string length
    @Test
    void testAbbreviateMiddleWithNullMiddleAndLengthGreaterThanStringLength() {
        // Given
        String str = "abc";
        String middle = null;
        int length = 4;
        
        // When
        String result = StringUtils.abbreviateMiddle(str, middle, length);
        
        // Then
        Assertions.assertEquals(str, result);
    }
    
    // Should return original string when middle is empty and length is 0
    @Test
    void testAbbreviateMiddleWithEmptyMiddleAndZeroLength() {
        // Given
        String str = "abc";
        String middle = "";
        int length = 0;
        
        // When
        String result = StringUtils.abbreviateMiddle(str, middle, length);
        
        // Then
        Assertions.assertEquals(str, result);
    }
    
    // Should return original string when middle is empty and length is less than string length
    @Test
    void testAbbreviateMiddleWithEmptyMiddleAndLengthLessThanStringLength() {
        // Given
        String str = "abc";
        String middle = "";
        int length = 2;
        
        // When
        String result = StringUtils.abbreviateMiddle(str, middle, length);
        
        // Then
        Assertions.assertEquals(str, result);
    }
    
    // Should return original string when middle is empty and length is equal to string length
    @Test
    void testAbbreviateMiddleWithEmptyMiddleAndLengthEqualToStringLength() {
        // Given
        String str = "abc";
        String middle = "";
        int length = 3;
        
        // When
        String result = StringUtils.abbreviateMiddle(str, middle, length);
        
        // Then
        Assertions.assertEquals(str, result);
    }
    
    // Should return original string when middle is empty and length is greater than string length
    @Test
    void testAbbreviateMiddleWithEmptyMiddleAndLengthGreaterThanStringLength() {
        // Given
        String str = "abc";
        String middle = "";
        int length = 4;
        
        // When
        String result = StringUtils.abbreviateMiddle(str, middle, length);
        
        // Then
        Assertions.assertEquals(str, result);
    }
    
    // Should return abbreviated string with middle when length is less than string length
    @Test
    void testAbbreviateMiddleWithValidInputAndLengthLessThanStringLength() {
        // Given
        String str = "abcdef";
        String middle = ".";
        int length = 4;
        
        // When
        String result = StringUtils.abbreviateMiddle(str, middle, length);
        
        // Then
        Assertions.assertEquals("ab.f", result);
    }
    
    // Should return abbreviated string with middle when length is equal to string length
    @Test
    void testAbbreviateMiddleWithValidInputAndLengthEqualToStringLength() {
        // Given
        String str = "abcdef";
        String middle = ".";
        int length = 6;
        
        // When
        String result = StringUtils.abbreviateMiddle(str, middle, length);
        
        // Then
        Assertions.assertEquals("abcdef", result);
    }
    
    // Should return abbreviated string with middle when length is greater than string length
    @Test
    void testAbbreviateMiddleWithValidInputAndLengthGreaterThanStringLength() {
        // Given
        String str = "abcdef";
        String middle = ".";
        int length = 8;
        
        // When
        String result = StringUtils.abbreviateMiddle(str, middle, length);
        
        // Then
        Assertions.assertEquals("abcdef", result);
    }
    @Test
    void testStartsWithNull() {
        CharSequence str = null;
        CharSequence prefix = null;
        assertTrue(stringUtils.startsWith(str, prefix));
    }
    
    @Test
    void testStartsWithNullPrefix() {
        CharSequence str = "abcdef";
        CharSequence prefix = null;
        assertFalse(stringUtils.startsWith(str, prefix));
    }
    
    @Test
    void testStartsWithNullString() {
        CharSequence str = null;
        CharSequence prefix = "abc";
        assertFalse(stringUtils.startsWith(str, prefix));
    }
    
    @Test
    void testStartsWithEmptyString() {
        CharSequence str = "";
        CharSequence prefix = "abc";
        assertFalse(stringUtils.startsWith(str, prefix));
    }
    
    @Test
    void testStartsWithEmptyPrefix() {
        CharSequence str = "abcdef";
        CharSequence prefix = "";
        assertTrue(stringUtils.startsWith(str, prefix));
    }
    
    @Test
    void testStartsWithCaseSensitive() {
        CharSequence str = "ABCDEF";
        CharSequence prefix = "abc";
        assertFalse(stringUtils.startsWith(str, prefix));
    }
    
    @Test
    void testStartsWithCaseInsensitive() {
        CharSequence str = "ABCDEF";
        CharSequence prefix = "abc";
        assertTrue(stringUtils.startsWith(str, prefix, true));
    }
    
    @Test
    void testStartsWithUnicodeNormalization() {
        CharSequence str = "Müller";
        CharSequence prefix = "Mu";
        assertTrue(stringUtils.startsWith(str, prefix));
    }
    
    @Test
    void testStartsWithUnicodeNormalizationCaseInsensitive() {
        CharSequence str = "Müller";
        CharSequence prefix = "mu";
        assertTrue(stringUtils.startsWith(str, prefix, true));
    }
    @Test
    void testReplaceAll() {
        // Test with null text
        assertNull(stringUtils.replaceAll(null, "a", "b"));
    
        // Test with null regex
        assertEquals("abc", stringUtils.replaceAll("abc", null, "d"));
    
        // Test with null replacement
        assertEquals("abc", stringUtils.replaceAll("abc", "a", null));
    
        // Test with empty text
        assertEquals("", stringUtils.replaceAll("", "a", "b"));
    
        // Test with empty regex
        assertEquals("abc", stringUtils.replaceAll("abc", "", "d"));
    
        // Test with empty replacement
        assertEquals("abc", stringUtils.replaceAll("abc", "a", ""));
    
        // Test with no replacements
        assertEquals("abc", stringUtils.replaceAll("abc", "d", "e"));
    
        // Test with single replacement
        assertEquals("dbc", stringUtils.replaceAll("abc", "a", "d"));
    
        // Test with multiple replacements
        assertEquals("dbce", stringUtils.replaceAll("abca", "a", "d"));
    
        // Test with regex special characters
        assertEquals("d.b.c", stringUtils.replaceAll("a.b.c", "[a-z]", "d"));
    
        // Test with regex special characters in replacement
        assertEquals("dddc", stringUtils.replaceAll("abc", "[a-z]", "d."));
    
        // Test with DOTALL option
        assertEquals("dbce", stringUtils.replaceAll("a\na", "(?s)a", "d"));
    }
    @Test
    void testLastIndexOfAny_nullString() {
        assertEquals(-1, stringUtils.lastIndexOfAny(null, "ab", "cd"));
    }
    
    @Test
    void testLastIndexOfAny_nullSearchStrings() {
        assertEquals(-1, stringUtils.lastIndexOfAny("zzabyycdxx", null));
    }
    
    @Test
    void testLastIndexOfAny_nullSearchString() {
        assertEquals(-1, stringUtils.lastIndexOfAny("zzabyycdxx", "ab", null));
    }
    
    @Test
    void testLastIndexOfAny_emptySearchString() {
        assertEquals(10, stringUtils.lastIndexOfAny("zzabyycdxx", "mn", ""));
    }
    
    @Test
    void testLastIndexOfAny_noMatch() {
        assertEquals(-1, stringUtils.lastIndexOfAny("zzabyycdxx", "mn", "op"));
    }
    
    @Test
    void testLastIndexOfAny_singleMatch() {
        assertEquals(6, stringUtils.lastIndexOfAny("zzabyycdxx", "ab", "cd"));
    }
    
    @Test
    void testLastIndexOfAny_multipleMatches() {
        assertEquals(6, stringUtils.lastIndexOfAny("zzabyycdxx", "cd", "ab"));
    }
    @Test
    void testGetIfBlankWithNullStringAndNonNullDefaultSupplier() {
        Supplier<String> defaultSupplier = () -> "DEFAULT";
        String result = stringUtils.getIfBlank(null, defaultSupplier);
        Assertions.assertEquals("DEFAULT", result);
    }
    
    @Test
    void testGetIfBlankWithEmptyStringAndNonNullDefaultSupplier() {
        Supplier<String> defaultSupplier = () -> "DEFAULT";
        String result = stringUtils.getIfBlank("", defaultSupplier);
        Assertions.assertEquals("DEFAULT", result);
    }
    
    @Test
    void testGetIfBlankWithBlankStringAndNonNullDefaultSupplier() {
        Supplier<String> defaultSupplier = () -> "DEFAULT";
        String result = stringUtils.getIfBlank("   ", defaultSupplier);
        Assertions.assertEquals("DEFAULT", result);
    }
    
    @Test
    void testGetIfBlankWithNonBlankStringAndNonNullDefaultSupplier() {
        Supplier<String> defaultSupplier = () -> "DEFAULT";
        String result = stringUtils.getIfBlank("bat", defaultSupplier);
        Assertions.assertEquals("bat", result);
    }
    
    @Test
    void testGetIfBlankWithEmptyStringAndNullDefaultSupplier() {
        String result = stringUtils.getIfBlank("", null);
        Assertions.assertNull(result);
    }
    
    @Test
    void testGetIfBlankWithNullStringAndNullDefaultSupplier() {
        String result = stringUtils.getIfBlank(null, null);
        Assertions.assertNull(result);
    }
    @Test
    void testIndexOf_NullSeq_ReturnsNegativeOne() {
        int result = stringUtils.indexOf(null, "a");
        assertEquals(-1, result);
    }
    
    @Test
    void testIndexOf_NullSearchSeq_ReturnsNegativeOne() {
        int result = stringUtils.indexOf("aabaabaa", null);
        assertEquals(-1, result);
    }
    
    @Test
    void testIndexOf_EmptySeq_ReturnsZero() {
        int result = stringUtils.indexOf("", "");
        assertEquals(0, result);
    }
    
    @Test
    void testIndexOf_EmptySeqWithNonEmptySearchSeq_ReturnsNegativeOne() {
        int result = stringUtils.indexOf("", "a");
        assertEquals(-1, result);
    }
    
    @Test
    void testIndexOf_NonEmptySeqWithEmptySearchSeq_ReturnsZero() {
        int result = stringUtils.indexOf("aabaabaa", "");
        assertEquals(0, result);
    }
    
    @Test
    void testIndexOf_SearchSeqNotFound_ReturnsNegativeOne() {
        int result = stringUtils.indexOf("aabaabaa", "c");
        assertEquals(-1, result);
    }
    
    @Test
    void testIndexOf_SearchSeqFoundAtStart_ReturnsZero() {
        int result = stringUtils.indexOf("aabaabaa", "a");
        assertEquals(0, result);
    }
    
    @Test
    void testIndexOf_SearchSeqFoundInMiddle_ReturnsCorrectIndex() {
        int result = stringUtils.indexOf("aabaabaa", "b");
        assertEquals(2, result);
    }
    
    @Test
    void testIndexOf_SearchSeqFoundAtEnd_ReturnsCorrectIndex() {
        int result = stringUtils.indexOf("aabaabaa", "aa");
        assertEquals(5, result);
    }
    
    @Test
    void testIndexOf_SearchSeqFoundMultipleTimes_ReturnsFirstIndex() {
        int result = stringUtils.indexOf("aabaabaa", "ab");
        assertEquals(1, result);
    }
    
    @Test
    void testIndexOf_StartPosGreaterThanLength_ReturnsNegativeOne() {
        int result = stringUtils.indexOf("aabaabaa", "a", 10);
        assertEquals(-1, result);
    }
    
    @Test
    void testIndexOf_StartPosLessThanZero_ReturnsZero() {
        int result = stringUtils.indexOf("aabaabaa", "a", -1);
        assertEquals(0, result);
    }
    
    @Test
    void testIndexOf_StartPosEqualToLength_ReturnsNegativeOne() {
        int result = stringUtils.indexOf("aabaabaa", "a", 8);
        assertEquals(-1, result);
    }
    
    @Test
    void testIndexOf_StartPosGreaterThanZero_ReturnsCorrectIndex() {
        int result = stringUtils.indexOf("aabaabaa", "b", 3);
        assertEquals(5, result);
    }
    
    @Test
    void testIndexOf_SearchCharNotFound_ReturnsNegativeOne() {
        int result = stringUtils.indexOf("aabaabaa", 'c');
        assertEquals(-1, result);
    }
    
    @Test
    void testIndexOf_SearchCharFoundAtStart_ReturnsZero() {
        int result = stringUtils.indexOf("aabaabaa", 'a');
        assertEquals(0, result);
    }
    
    @Test
    void testIndexOf_SearchCharFoundInMiddle_ReturnsCorrectIndex() {
        int result = stringUtils.indexOf("aabaabaa", 'b');
        assertEquals(2, result);
    }
    
    @Test
    void testIndexOf_SearchCharFoundAtEnd_ReturnsCorrectIndex() {
        int result = stringUtils.indexOf("aabaabaa", 'a');
        assertEquals(7, result);
    }
    
    @Test
    void testIndexOf_EmptySeq_ReturnsNegativeOne() {
        int result = stringUtils.indexOf("", 'a');
        assertEquals(-1, result);
    }
    
    @Test
    void testIndexOf_EmptySeqWithStartPos_ReturnsNegativeOne() {
        int result = stringUtils.indexOf("", 'a', 0);
        assertEquals(-1, result);
    }
    
    @Test
    void testIndexOf_SearchCharFoundWithStartPos_ReturnsCorrectIndex() {
        int result = stringUtils.indexOf("aabaabaa", 'b', 3);
        assertEquals(5, result);
    }
    @Test
    @DisplayName("should return 0 when comparing two equal strings")
    void testCompareIgnoreCaseEqualStrings() {
        // Arrange
        String str1 = "abc";
        String str2 = "ABC";
    
        // Act
        int result = StringUtils.compareIgnoreCase(str1, str2);
    
        // Assert
        assertEquals(0, result);
    }
    
    @Test
    @DisplayName("should return a negative value when str1 is less than str2")
    void testCompareIgnoreCaseStr1LessThanStr2() {
        // Arrange
        String str1 = "abc";
        String str2 = "def";
    
        // Act
        int result = StringUtils.compareIgnoreCase(str1, str2);
    
        // Assert
        assertTrue(result < 0);
    }
    
    @Test
    @DisplayName("should return a positive value when str1 is greater than str2")
    void testCompareIgnoreCaseStr1GreaterThanStr2() {
        // Arrange
        String str1 = "def";
        String str2 = "abc";
    
        // Act
        int result = StringUtils.compareIgnoreCase(str1, str2);
    
        // Assert
        assertTrue(result > 0);
    }
    
    @Test
    @DisplayName("should handle null values correctly")
    void testCompareIgnoreCaseNullValues() {
        // Arrange
        String str1 = null;
        String str2 = "abc";
    
        // Act
        int result1 = StringUtils.compareIgnoreCase(str1, str2);
        int result2 = StringUtils.compareIgnoreCase(str2, str1);
        int result3 = StringUtils.compareIgnoreCase(str1, str1);
    
        // Assert
        assertTrue(result1 < 0);
        assertTrue(result2 > 0);
        assertEquals(0, result3);
    }
    
    @Test
    @DisplayName("should handle nullIsLess parameter correctly")
    void testCompareIgnoreCaseNullIsLessParameter() {
        // Arrange
        String str1 = null;
        String str2 = "abc";
    
        // Act
        int result1 = StringUtils.compareIgnoreCase(str1, str2, true);
        int result2 = StringUtils.compareIgnoreCase(str1, str2, false);
    
        // Assert
        assertTrue(result1 < 0);
        assertTrue(result2 > 0);
    }

}