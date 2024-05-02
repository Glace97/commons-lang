package org.apache.commons.lang3;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;
import org.mockito.MockedStatic;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import java.io.UnsupportedEncodingException;
import org.junit.jupiter.api.function.Executable;
import java.util.function.Supplier;
import static org.mockito.Mockito.mock;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.nio.charset.Charset;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class StringUtilsTest {


    @Test
    public void testSubstringAfter() {
        // Test with null string
        assertNull(StringUtils.substringAfter(null, "a"));

        // Test with empty string
        assertEquals("", StringUtils.substringAfter("", "a"));

        // Test with null separator
        assertEquals("", StringUtils.substringAfter("abc", null));

        // Test with string that contains the separator
        assertEquals("bc", StringUtils.substringAfter("abc", "a"));
        assertEquals("cba", StringUtils.substringAfter("abcba", "b"));
        
        // Test with string that does not contain the separator
        assertEquals("", StringUtils.substringAfter("abc", "d"));

        // Test with empty separator
        assertEquals("abc", StringUtils.substringAfter("abc", ""));
    }
    
    @Test
    public void testSubstringAfter_withChar() {
        // Test with null string
        assertNull(StringUtils.substringAfter(null, 'a'));

        // Test with empty string
        assertEquals("", StringUtils.substringAfter("", 'a'));

        // Test with string that contains the separator
        assertEquals("bc", StringUtils.substringAfter("abc", 'a'));
        assertEquals("cba", StringUtils.substringAfter("abcba", 'b'));

        // Test with string that does not contain the separator
        assertEquals("", StringUtils.substringAfter("abc", 'd'));

        // Test with space as separator
        assertEquals("abc", StringUtils.substringAfter(" abc", 32));
    }





    @Test
    public void testIsNoneBlank_AllNonBlank() {
        CharSequence[] sequences = new CharSequence[]{"hello", "world"};
        assertTrue(StringUtils.isNoneBlank(sequences));
    }

    @Test
    public void testIsNoneBlank_ContainsBlank() {
        CharSequence[] sequences = new CharSequence[]{"hello", " ", "world"};
        assertFalse(StringUtils.isNoneBlank(sequences));
    }

    @Test
    public void testIsNoneBlank_ContainsNull() {
        CharSequence[] sequences = new CharSequence[]{"hello", null, "world"};
        assertFalse(StringUtils.isNoneBlank(sequences));
    }

    @Test
    public void testIsNoneBlank_EmptySequences() {
        CharSequence[] sequences = new CharSequence[]{};
        assertTrue(StringUtils.isNoneBlank(sequences));
    }

    @Test
    public void testIsNoneBlank_NullSequences() {
        assertFalse(StringUtils.isNoneBlank(null));
    }





    @Test
    public void testLastOrdinalIndexOf_NullString() {
        assertEquals(-1, StringUtils.lastOrdinalIndexOf(null, "a", 1));
    }
    
    @Test
    public void testLastOrdinalIndexOf_NullSearchStr() {
        assertEquals(-1, StringUtils.lastOrdinalIndexOf("aabaabaa", null, 1));
    }
    
    @Test
    public void testLastOrdinalIndexOf_EmptyString() {
        assertEquals(0, StringUtils.lastOrdinalIndexOf("", "", 1));
    }
    
    @Test
    public void testLastOrdinalIndexOf_LastSingleCharacter() {
        assertEquals(7, StringUtils.lastOrdinalIndexOf("aabaabaa", "a", 1));
    }
    
    @Test
    public void testLastOrdinalIndexOf_SecondLastSingleCharacter() {
        assertEquals(6, StringUtils.lastOrdinalIndexOf("aabaabaa", "a", 2));
    }
    
    @Test
    public void testLastOrdinalIndexOf_LastSingleCharacterNotAtEnd() {
        assertEquals(5, StringUtils.lastOrdinalIndexOf("aabaabaa", "b", 1));
    }
    
    @Test
    public void testLastOrdinalIndexOf_SecondLastSingleCharacterNotAtEnd() {
        assertEquals(2, StringUtils.lastOrdinalIndexOf("aabaabaa", "b", 2));
    }
    
    @Test
    public void testLastOrdinalIndexOf_LastMultiCharacter() {
        assertEquals(4, StringUtils.lastOrdinalIndexOf("aabaabaa", "ab", 1));
    }

    @Test
    public void testLastOrdinalIndexOf_SecondLastMultiCharacter() {
        assertEquals(1, StringUtils.lastOrdinalIndexOf("aabaabaa", "ab", 2));
    }
    
    @Test
    public void testLastOrdinalIndexOf_EmptySearchStr() {
        assertEquals(8, StringUtils.lastOrdinalIndexOf("aabaabaa", "", 1));
    }





    @Test
    public void testIsNumericSpace_NullInput() {
        assertFalse(StringUtils.isNumericSpace(null));
    }

    @Test
    public void testIsNumericSpace_EmptyString() {
        assertTrue(StringUtils.isNumericSpace(""));
    }

    @Test
    public void testIsNumericSpace_OnlySpace() {
        assertTrue(StringUtils.isNumericSpace("   "));
    }

    @Test
    public void testIsNumericSpace_OnlyDigits() {
        assertTrue(StringUtils.isNumericSpace("1234567890"));
    }

    @Test
    public void testIsNumericSpace_DigitsAndSpaces() {
        assertTrue(StringUtils.isNumericSpace("123 456 789 0"));
    }

    @Test
    public void testIsNumericSpace_UnicodeDigits() {
        assertTrue(StringUtils.isNumericSpace("\u0967\u0968\u0969"));
    }

    @Test
    public void testIsNumericSpace_AlphaNumeric() {
        assertFalse(StringUtils.isNumericSpace("ab2c"));
    }

    @Test
    public void testIsNumericSpace_WithSpecialCharacters() {
        assertFalse(StringUtils.isNumericSpace("12-3"));
        assertFalse(StringUtils.isNumericSpace("12.3"));
    }







    @Test
    public void whenAllStringsAreBlank_thenShouldReturnTrue() {
        assertTrue(StringUtils.isAllBlank("", " ", "\t", "\n"));
    }

    @Test
    public void whenAnyStringIsNotBlank_thenShouldReturnFalse() {
        assertFalse(StringUtils.isAllBlank("", " ", "\t", "test"));
    }

    @Test
    public void whenAllStringsAreNull_thenShouldReturnTrue() {
        assertTrue(StringUtils.isAllBlank(null, null, null));
    }

    @Test
    public void whenAnyStringIsNullAndOthersAreNotBlank_thenShouldReturnFalse() {
        assertFalse(StringUtils.isAllBlank(null, null, "test"));
    }

    @Test
    public void whenInputArrayIsEmpty_thenShouldReturnTrue() {
        assertTrue(StringUtils.isAllBlank());
    }

    @Test
    public void whenInputArrayIsNull_thenShouldReturnTrue() {
        CharSequence[] charSequences = null;
        assertTrue(StringUtils.isAllBlank(charSequences));
    }





    @Test
    public void testSubstringSingleParameter() {
        // Test with null string
        assertNull(StringUtils.substring(null, 0), "Substring of null string should be null");

        // Test with empty string
        assertEquals("", StringUtils.substring("", 0), "Substring of empty string should be empty");

        // Test with normal strings
        assertEquals("abc", StringUtils.substring("abc", 0), "Substring starting from 0 should be same as original string");
        assertEquals("", StringUtils.substring("abc", 4), "Substring starting from position greater than length should be empty string");
        assertEquals("bc", StringUtils.substring("abc", -2), "Substring starting from negative position should start from end of string");
    }

    @Test
    public void testSubstringTwoParameters() {
        // Test with null string
        assertNull(StringUtils.substring(null, 0, 0), "Substring of null string should be null");

        // Test with empty string
        assertEquals("", StringUtils.substring("", 0, 0), "Substring of empty string should be empty");

        // Test with normal strings
        assertEquals("ab", StringUtils.substring("abc", 0, 2), "Substring from 0 to 2 should be 'ab'");
        assertEquals("", StringUtils.substring("abc", 2, 0), "Substring from 2 to 0 should be empty string");
        assertEquals("b", StringUtils.substring("abc", -2, -1), "Substring from -2 to -1 should be 'b'");
    }





    @Test
    public void testLowerCaseNullInput() {
        String input = null;
        String result = StringUtils.lowerCase(input);
        assertNull(result);
    }

    @Test
    public void testLowerCaseEmptyInput() {
        String input = "";
        String expected = "";
        String result = StringUtils.lowerCase(input);
        assertEquals(expected, result);
    }

    @Test
    public void testLowerCaseNormalInput() {
        String input = "AbC";
        String expected = "abc";
        String result = StringUtils.lowerCase(input);
        assertEquals(expected, result);
    }

    @Test
    public void testLowerCaseWithLocaleNullInput() {
        String input = null;
        Locale locale = Locale.ENGLISH;
        String result = StringUtils.lowerCase(input, locale);
        assertNull(result);
    }

    @Test
    public void testLowerCaseWithLocaleEmptyInput() {
        String input = "";
        Locale locale = Locale.ENGLISH;
        String expected = "";
        String result = StringUtils.lowerCase(input, locale);
        assertEquals(expected, result);
    }

    @Test
    public void testLowerCaseWithLocaleNormalInput() {
        String input = "AbC";
        Locale locale = Locale.ENGLISH;
        String expected = "abc";
        String result = StringUtils.lowerCase(input, locale);
        assertEquals(expected, result);
    }









    @Test
    public void testPrependIfMissingWithNullString() {
        String result = StringUtils.prependIfMissing(null, "xyz");
        assertNull(result);
    }

    @Test
    public void testPrependIfMissingWithNullPrefix() {
        String result = StringUtils.prependIfMissing("abc", null);
        assertEquals("abc", result);
    }

    @Test
    public void testPrependIfMissingWithEmptyString() {
        String result = StringUtils.prependIfMissing("", "xyz");
        assertEquals("xyz", result);
    }

    @Test
    public void testPrependIfMissingWhenPrefixIsNotPresent() {
        String result = StringUtils.prependIfMissing("abc", "xyz");
        assertEquals("xyzabc", result);
    }

    @Test
    public void testPrependIfMissingWhenPrefixIsPresent() {
        String result = StringUtils.prependIfMissing("xyzabc", "xyz");
        assertEquals("xyzabc", result);
    }

    @Test
    public void testPrependIfMissingWithAdditionalPrefixes() {
        String result = StringUtils.prependIfMissing("abc", "xyz", "mno");
        assertEquals("xyzabc", result);
    }

    @Test
    public void testPrependIfMissingWhenAdditionalPrefixIsPresent() {
        String result = StringUtils.prependIfMissing("mnoabc", "xyz", "mno");
        assertEquals("mnoabc", result);
    }

    @Test
    public void testPrependIfMissingWithNullAdditionalPrefixes() {
        String result = StringUtils.prependIfMissing("abc", "xyz", (CharSequence[]) null);
        assertEquals("xyzabc", result);
    }

    @Test
    public void testPrependIfMissingWhenAdditionalPrefixesIsEmpty() {
        String result = StringUtils.prependIfMissing("abc", "xyz", "");
        assertEquals("abc", result);
    }









    @Test
    public void shouldReturnIndexOfSearchStrWhenBothStrAndSearchStrAreNotNull() {
        CharSequence str = "Hello World";
        CharSequence searchStr = "world";

        int result = StringUtils.indexOfIgnoreCase(str, searchStr);

        assertEquals(6, result, "The returned index is not as expected");
    }

    @Test
    public void shouldReturnNegativeOneWhenStrIsNull() {
        CharSequence str = null;
        CharSequence searchStr = "world";

        int result = StringUtils.indexOfIgnoreCase(str, searchStr);

        assertEquals(-1, result, "The returned index is not as expected when str is null");
    }

    @Test
    public void shouldReturnNegativeOneWhenSearchStrIsNull() {
        CharSequence str = "Hello World";
        CharSequence searchStr = null;

        int result = StringUtils.indexOfIgnoreCase(str, searchStr);

        assertEquals(-1, result, "The returned index is not as expected when searchStr is null");
    }





    @Test
    public void mid_whenStringIsNull_returnsNull() {
        String str = null;
        int pos = 1;
        int len = 1;

        String result = StringUtils.mid(str, pos, len);

        assertNull(result);
    }

    @Test
    public void mid_whenLengthIsNegative_returnsEmpty() {
        String str = "abc";
        int pos = 0;
        int len = -1;

        String result = StringUtils.mid(str, pos, len);

        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void mid_whenPositionIsGreaterThanStringLength_returnsEmpty() {
        String str = "abc";
        int pos = 4;
        int len = 2;

        String result = StringUtils.mid(str, pos, len);

        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void mid_whenPositionIsNegative_treatsAsZero() {
        String str = "abc";
        int pos = -2;
        int len = 2;

        String result = StringUtils.mid(str, pos, len);

        assertEquals("ab", result);
    }

    @Test
    public void mid_returnsExpectedSubstring() {
        String str = "abc";
        int pos = 0;
        int len = 2;

        String result = StringUtils.mid(str, pos, len);

        assertEquals("ab", result);
    }









    @Test
    public void testReplaceEachRepeatedlyWithNullText() {
        String text = null;
        String[] searchList = new String[] {"a"};
        String[] replacementList = new String[] {"b"};
        assertNull(StringUtils.replaceEachRepeatedly(text, searchList, replacementList));
    }

    @Test
    public void testReplaceEachRepeatedlyWithEmptyText() {
        String text = "";
        String[] searchList = new String[] {"a"};
        String[] replacementList = new String[] {"b"};
        assertEquals("", StringUtils.replaceEachRepeatedly(text, searchList, replacementList));
    }

    @Test
    public void testReplaceEachRepeatedlyWithNullSearchAndReplacementList() {
        String text = "aba";
        assertNull(StringUtils.replaceEachRepeatedly(text, null, null));
    }

    @Test
    public void testReplaceEachRepeatedlyWithEmptySearchAndReplacementList() {
        String text = "aba";
        String[] searchList = new String[] {};
        String[] replacementList = new String[] {};
        assertEquals("aba", StringUtils.replaceEachRepeatedly(text, searchList, replacementList));
    }

    @Test
    public void testReplaceEachRepeatedlyWithNullInSearchList() {
        String text = "aba";
        String[] searchList = new String[] {null};
        String[] replacementList = new String[] {"b"};
        assertEquals("aba", StringUtils.replaceEachRepeatedly(text, searchList, replacementList));
    }

    @Test
    public void testReplaceEachRepeatedlyWithNullInReplacementList() {
        String text = "aba";
        String[] searchList = new String[] {"a"};
        String[] replacementList = new String[] {null};
        assertEquals("aba", StringUtils.replaceEachRepeatedly(text, searchList, replacementList));
    }

    @Test
    public void testReplaceEachRepeatedlyWithRepeatingSearch() {
        String text = "abcde";
        String[] searchList = new String[] {"ab", "d"};
        String[] replacementList = new String[] {"d", "t"};
        assertEquals("tcte", StringUtils.replaceEachRepeatedly(text, searchList, replacementList));
    }

    @Test
    public void testReplaceEachRepeatedlyWithDifferentLengthsOfSearchAndReplacementList() {
        String text = "abcde";
        String[] searchList = new String[] {"ab", "d"};
        String[] replacementList = new String[] {"w"};
        assertThrows(IllegalArgumentException.class, () -> StringUtils.replaceEachRepeatedly(text, searchList, replacementList));
    }

    @Test
    public void testReplaceEachRepeatedlyWithEndlessLoop() {
        String text = "abcde";
        String[] searchList = new String[] {"ab", "d"};
        String[] replacementList = new String[] {"d", "ab"};
        assertThrows(IllegalStateException.class, () -> StringUtils.replaceEachRepeatedly(text, searchList, replacementList));
    }

    @Test
    public void testReplaceEachRepeatedlyWithValidInputs() {
        String text = "abcde";
        String[] searchList = new String[] {"ab", "d"};
        String[] replacementList = new String[] {"w", "t"};
        assertEquals("wcte", StringUtils.replaceEachRepeatedly(text, searchList, replacementList));
    }













    @Test
    public void testWrapIfMissing_withChar() {
        assertNull(StringUtils.wrapIfMissing(null, 'x'));
        assertEquals("", StringUtils.wrapIfMissing("", 'x'));
        assertEquals("ab", StringUtils.wrapIfMissing("ab", '\0'));
        assertEquals("xabx", StringUtils.wrapIfMissing("ab", 'x'));
        assertEquals("'ab'", StringUtils.wrapIfMissing("ab", '\''));
        assertEquals("\"ab\"", StringUtils.wrapIfMissing("\"ab\"", '\"'));
        assertEquals("/", StringUtils.wrapIfMissing("/", '/'));
        assertEquals("/a/b/c/", StringUtils.wrapIfMissing("a/b/c", '/'));
        assertEquals("/a/b/c/", StringUtils.wrapIfMissing("/a/b/c", '/'));
        assertEquals("/a/b/c/", StringUtils.wrapIfMissing("a/b/c/", '/'));
    }

    @Test
    public void testWrapIfMissing_withString() {
        assertNull(StringUtils.wrapIfMissing(null, "x"));
        assertEquals("", StringUtils.wrapIfMissing("", "x"));
        assertEquals("ab", StringUtils.wrapIfMissing("ab", null));
        assertEquals("xabx", StringUtils.wrapIfMissing("ab", "x"));
        assertEquals("\"ab\"", StringUtils.wrapIfMissing("ab", "\""));
        assertEquals("\"ab\"", StringUtils.wrapIfMissing("\"ab\"", "\""));
        assertEquals("'ab'", StringUtils.wrapIfMissing("ab", "'"));
        assertEquals("'abcd'", StringUtils.wrapIfMissing("'abcd'", "'"));
        assertEquals("'\"abcd\"'", StringUtils.wrapIfMissing("\"abcd\"", "'"));
        assertEquals("\"'abcd'\"", StringUtils.wrapIfMissing("'abcd'", "\""));
        assertEquals("/", StringUtils.wrapIfMissing("/", "/"));
        assertEquals("/a/b/c/", StringUtils.wrapIfMissing("a/b/c", "/"));
        assertEquals("/a/b/c/", StringUtils.wrapIfMissing("/a/b/c", "/"));
        assertEquals("/a/b/c/", StringUtils.wrapIfMissing("a/b/c/", "/"));
    }





    @Test
    public void testStripStart_NullInput() {
        String str = null;
        String stripChars = "xyz";
        assertNull(StringUtils.stripStart(str, stripChars));
    }

    @Test
    public void testStripStart_EmptyInput() {
        String str = "";
        String stripChars = "xyz";
        assertEquals("", StringUtils.stripStart(str, stripChars));
    }

    @Test
    public void testStripStart_NoStripChars() {
        String str = "abc";
        String stripChars = "";
        assertEquals("abc", StringUtils.stripStart(str, stripChars));
    }

    @Test
    public void testStripStart_NullStripChars() {
        String str = "  abc";
        String stripChars = null;
        assertEquals("abc", StringUtils.stripStart(str, stripChars));
    }

    @Test
    public void testStripStart_WhiteSpaceInInput() {
        String str = " abc ";
        String stripChars = null;
        assertEquals("abc ", StringUtils.stripStart(str, stripChars));
    }

    @Test
    public void testStripStart_StripCharsPresent() {
        String str = "yxabc  ";
        String stripChars = "xyz";
        assertEquals("abc  ", StringUtils.stripStart(str, stripChars));
    }





    @Test
    public void testLastIndexOfIgnoreCase() {
        assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "test"));
        assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("test", null));
        assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("test", "testtest"));
        assertEquals(0, StringUtils.lastIndexOfIgnoreCase("test", ""));
        assertEquals(0, StringUtils.lastIndexOfIgnoreCase("test", "t"));
        assertEquals(2, StringUtils.lastIndexOfIgnoreCase("test", "S"));
        assertEquals(2, StringUtils.lastIndexOfIgnoreCase("test", "st"));
    }

    @Test
    public void testLastIndexOfIgnoreCaseWithStartPosition() {
        assertEquals(-1, StringUtils.lastIndexOfIgnoreCase(null, "test", 8));
        assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("test", null, 8));
        assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("test", "testtest", 8));
        assertEquals(0, StringUtils.lastIndexOfIgnoreCase("test", "", 8));
        assertEquals(0, StringUtils.lastIndexOfIgnoreCase("test", "t", 8));
        assertEquals(2, StringUtils.lastIndexOfIgnoreCase("test", "S", 8));
        assertEquals(2, StringUtils.lastIndexOfIgnoreCase("test", "st", 8));
        assertEquals(-1, StringUtils.lastIndexOfIgnoreCase("test", "st", 1));
        assertEquals(0, StringUtils.lastIndexOfIgnoreCase("test", "st", 2));
    }





    @Test
    public void testOverlay() {
        String str = "abcdef";
        String overlay = "zzzz";

        String result = StringUtils.overlay(str, overlay, 2, 4);
        assertEquals("abzzzzef", result);

        result = StringUtils.overlay(str, overlay, 4, 2);
        assertEquals("abzzzzef", result);

        result = StringUtils.overlay(str, overlay, -1, 4);
        assertEquals("zzzzef", result);

        result = StringUtils.overlay(str, overlay, 2, 8);
        assertEquals("abzzzz", result);

        result = StringUtils.overlay(str, overlay, -2, -3);
        assertEquals("zzzzabcdef", result);

        result = StringUtils.overlay(str, overlay, 8, 10);
        assertEquals("abcdefzzzz", result);
    }

    @Test
    public void testOverlay_nullStr() {
        String str = null;
        String overlay = "zzzz";
        String result = StringUtils.overlay(str, overlay, 2, 4);
        assertNull(result);
    }

    @Test
    public void testOverlay_nullOverlay() {
        String str = "abcdef";
        String overlay = null;

        String result = StringUtils.overlay(str, overlay, 2, 4);
        assertEquals("abef", result);
    }

    @Test
    public void testOverlay_emptyStr() {
        String str = "";
        String overlay = "abc";

        String result = StringUtils.overlay(str, overlay, 0, 0);
        assertEquals("abc", result);
    }

    @Test
    public void testOverlay_emptyOverlay() {
        String str = "abcdef";
        String overlay = "";

        String result = StringUtils.overlay(str, overlay, 2, 4);
        assertEquals("abef", result);
    }





    @Test
    public void testIndexOfWithTwoCharSequences() {
        assertEquals(0, StringUtils.indexOf("aabaabaa", "a"), "Failed to find the first index of the search CharSequence");
        assertEquals(2, StringUtils.indexOf("aabaabaa", "b"), "Failed to find the first index of the search CharSequence");
        assertEquals(-1, StringUtils.indexOf(null, "a"), "Failed to handle null CharSequence");
        assertEquals(-1, StringUtils.indexOf("aabaabaa", null), "Failed to handle null search CharSequence");
        assertEquals(-1, StringUtils.indexOf("", "a"), "Failed to handle empty CharSequence");
    }

    @Test
    public void testIndexOfWithTwoCharSequencesAndStartPos() {
        assertEquals(0, StringUtils.indexOf("aabaabaa", "a", 0), "Failed to find the first index of the search CharSequence from the start position");
        assertEquals(5, StringUtils.indexOf("aabaabaa", "b", 3), "Failed to find the first index of the search CharSequence from the start position");
        assertEquals(-1, StringUtils.indexOf(null, "a", 0), "Failed to handle null CharSequence");
        assertEquals(-1, StringUtils.indexOf("aabaabaa", null, 0), "Failed to handle null search CharSequence");
        assertEquals(-1, StringUtils.indexOf("", "a", 0), "Failed to handle empty CharSequence");
    }

    @Test
    public void testIndexOfWithCharSequenceAndInt() {
        assertEquals(0, StringUtils.indexOf("aabaabaa", 'a'), "Failed to find the first index of the search character");
        assertEquals(2, StringUtils.indexOf("aabaabaa", 'b'), "Failed to find the first index of the search character");
        assertEquals(-1, StringUtils.indexOf(null, 'a'), "Failed to handle null CharSequence");
        assertEquals(-1, StringUtils.indexOf("", 'a'), "Failed to handle empty CharSequence");
    }

    @Test
    public void testIndexOfWithCharSequenceIntAndStartPos() {
        assertEquals(0, StringUtils.indexOf("aabaabaa", 'a', 0), "Failed to find the first index of the search character from the start position");
        assertEquals(5, StringUtils.indexOf("aabaabaa", 'b', 3), "Failed to find the first index of the search character from the start position");
        assertEquals(-1, StringUtils.indexOf(null, 'a', 0), "Failed to handle null CharSequence");
        assertEquals(-1, StringUtils.indexOf("", 'a', 0), "Failed to handle empty CharSequence");
    }





    @Test
    public void isNotEmpty_ShouldReturnFalse_WhenStringIsNull() {
        // Given
        String str = null;

        // When
        boolean result = StringUtils.isNotEmpty(str);

        // Then
        assertFalse(result, "Expected isNotEmpty to return false when string is null");
    }

    @Test
    public void isNotEmpty_ShouldReturnFalse_WhenStringIsEmpty() {
        // Given
        String str = "";

        // When
        boolean result = StringUtils.isNotEmpty(str);

        // Then
        assertFalse(result, "Expected isNotEmpty to return false when string is empty");
    }

    @Test
    public void isNotEmpty_ShouldReturnTrue_WhenStringIsNotEmpty() {
        // Given
        String str = "test";

        // When
        boolean result = StringUtils.isNotEmpty(str);

        // Then
        assertTrue(result, "Expected isNotEmpty to return true when string is not empty");
    }
    
    @Test
    public void isNotEmpty_ShouldReturnTrue_WhenStringIsNotEmptyIncludingSpaces() {
        // Given
        String str = " ";

        // When
        boolean result = StringUtils.isNotEmpty(str);

        // Then
        assertTrue(result, "Expected isNotEmpty to return true when string is not empty including spaces");
    }









    @Test
    public void testIsAnyBlank_AllNull() {
        assertTrue(StringUtils.isAnyBlank((CharSequence[]) null));
    }

    @Test
    public void testIsAnyBlank_EmptyArray() {
        assertFalse(StringUtils.isAnyBlank(new String[] {}));
    }

    @Test
    public void testIsAnyBlank_SingleNullElement() {
        assertTrue(StringUtils.isAnyBlank((CharSequence) null));
    }

    @Test
    public void testIsAnyBlank_SingleBlankElement() {
        assertTrue(StringUtils.isAnyBlank(""));
    }

    @Test
    public void testIsAnyBlank_SingleWhitespaceElement() {
        assertTrue(StringUtils.isAnyBlank(" "));
    }

    @Test
    public void testIsAnyBlank_MultipleNullElements() {
        assertTrue(StringUtils.isAnyBlank(null, null));
    }

    @Test
    public void testIsAnyBlank_MultipleBlankElements() {
        assertTrue(StringUtils.isAnyBlank("", ""));
    }

    @Test
    public void testIsAnyBlank_MultipleWhitespaceElements() {
        assertTrue(StringUtils.isAnyBlank(" ", " "));
    }

    @Test
    public void testIsAnyBlank_MixedElements() {
        assertTrue(StringUtils.isAnyBlank(" ", "foo"));
    }

    @Test
    public void testIsAnyBlank_MultipleNonBlankElements() {
        assertFalse(StringUtils.isAnyBlank("foo", "bar"));
    }





    @Test
    public void testEquals_BothNull() {
        CharSequence cs1 = null;
        CharSequence cs2 = null;
        assertTrue(StringUtils.equals(cs1, cs2));
    }

    @Test
    public void testEquals_FirstNull() {
        CharSequence cs1 = null;
        CharSequence cs2 = "abc";
        assertFalse(StringUtils.equals(cs1, cs2));
    }

    @Test
    public void testEquals_SecondNull() {
        CharSequence cs1 = "abc";
        CharSequence cs2 = null;
        assertFalse(StringUtils.equals(cs1, cs2));
    }

    @Test
    public void testEquals_BothNonNullEqual() {
        CharSequence cs1 = "abc";
        CharSequence cs2 = "abc";
        assertTrue(StringUtils.equals(cs1, cs2));
    }

    @Test
    public void testEquals_BothNonNullNotEqual() {
        CharSequence cs1 = "abc";
        CharSequence cs2 = "ABC";
        assertFalse(StringUtils.equals(cs1, cs2));
    }

    @Test
    public void testEquals_BothNonNullDifferentLengths() {
        CharSequence cs1 = "abc";
        CharSequence cs2 = "abcd";
        assertFalse(StringUtils.equals(cs1, cs2));
    }

    @Test
    public void testEquals_BothNonNullCaseSensitive() {
        CharSequence cs1 = "ABC";
        CharSequence cs2 = "abc";
        assertFalse(StringUtils.equals(cs1, cs2));
    }





    @Test
    public void shouldReturnSubstringsBetweenGivenStrings() {
        String str = "abc[def]ghi[jkl]mno[pqr]stu";
        String open = "[";
        String close = "]";
        String[] expected = {"def", "jkl", "pqr"};

        String[] actual = StringUtils.substringsBetween(str, open, close);

        assertArrayEquals(expected, actual, "The actual array is not similar to the expected array");
    }

    @Test
    public void shouldReturnNullWhenInputStringIsNull() {
        String str = null;
        String open = "[";
        String close = "]";

        String[] actual = StringUtils.substringsBetween(str, open, close);

        assertNull(actual, "The actual array should be null");
    }

    @Test
    public void shouldReturnNullWhenOpenStringIsNull() {
        String str = "abc[def]ghi[jkl]mno[pqr]stu";
        String open = null;
        String close = "]";

        String[] actual = StringUtils.substringsBetween(str, open, close);

        assertNull(actual, "The actual array should be null");
    }

    @Test
    public void shouldReturnNullWhenCloseStringIsNull() {
        String str = "abc[def]ghi[jkl]mno[pqr]stu";
        String open = "[";
        String close = null;

        String[] actual = StringUtils.substringsBetween(str, open, close);

        assertNull(actual, "The actual array should be null");
    }

    @Test
    public void shouldReturnEmptyArrayWhenNoMatchingSubstrings() {
        String str = "abcdefghi";
        String open = "[";
        String close = "]";

        String[] actual = StringUtils.substringsBetween(str, open, close);

        assertArrayEquals(new String[]{}, actual, "The actual array should be empty");
    }

    @Test
    public void shouldReturnNullWhenEmptyOpenCloseStrings() {
        String str = "abc[def]ghi[jkl]mno[pqr]stu";
        String open = "";
        String close = "";

        String[] actual = StringUtils.substringsBetween(str, open, close);

        assertNull(actual, "The actual array should be null");
    }





    @Test
    public void testStartsWithIgnoreCaseBothNull() {
        assertTrue(StringUtils.startsWithIgnoreCase(null, null));
    }

    @Test
    public void testStartsWithIgnoreCaseFirstNull() {
        assertFalse(StringUtils.startsWithIgnoreCase(null, "abc"));
    }

    @Test
    public void testStartsWithIgnoreCaseSecondNull() {
        assertFalse(StringUtils.startsWithIgnoreCase("abcdef", null));
    }

    @Test
    public void testStartsWithIgnoreCaseValid() {
        assertTrue(StringUtils.startsWithIgnoreCase("abcdef", "abc"));
    }

    @Test
    public void testStartsWithIgnoreCaseCaseDifference() {
        assertTrue(StringUtils.startsWithIgnoreCase("ABCDEF", "abc"));
    }

    @Test
    public void testStartsWithIgnoreCaseCaseDifferenceReverse() {
        assertTrue(StringUtils.startsWithIgnoreCase("abcdef", "ABC"));
    }

    @Test
    public void testStartsWithIgnoreCaseEmptyStrings() {
        assertTrue(StringUtils.startsWithIgnoreCase("", ""));
    }

    @Test
    public void testStartsWithIgnoreCaseFirstEmpty() {
        assertFalse(StringUtils.startsWithIgnoreCase("", "abc"));
    }

    @Test
    public void testStartsWithIgnoreCaseSecondEmpty() {
        assertTrue(StringUtils.startsWithIgnoreCase("abcdef", ""));
    }









    @Test
    public void testIndexOfAny_CharArray() {
        assertEquals(-1, StringUtils.indexOfAny(null, 'a', 'b'));
        assertEquals(-1, StringUtils.indexOfAny("", 'a', 'b'));
        assertEquals(-1, StringUtils.indexOfAny("abc", null));
        assertEquals(-1, StringUtils.indexOfAny("abc"));
        assertEquals(0, StringUtils.indexOfAny("abc", 'a', 'b'));
        assertEquals(1, StringUtils.indexOfAny("abc", 'b', 'c'));
        assertEquals(-1, StringUtils.indexOfAny("abc", 'd'));
    }

    @Test
    public void testIndexOfAny_CharSequences() {
        assertEquals(-1, StringUtils.indexOfAny(null, "a", "b"));
        assertEquals(-1, StringUtils.indexOfAny("", "a", "b"));
        assertEquals(-1, StringUtils.indexOfAny("abc", (CharSequence)null));
        assertEquals(-1, StringUtils.indexOfAny("abc"));
        assertEquals(0, StringUtils.indexOfAny("abc", "a", "b"));
        assertEquals(1, StringUtils.indexOfAny("abc", "b", "c"));
        assertEquals(-1, StringUtils.indexOfAny("abc", "d"));
    }

    @Test
    public void testIndexOfAny_String() {
        assertEquals(-1, StringUtils.indexOfAny(null, "ab"));
        assertEquals(-1, StringUtils.indexOfAny("", "ab"));
        assertEquals(-1, StringUtils.indexOfAny("abc", (String)null));
        assertEquals(-1, StringUtils.indexOfAny("abc", ""));
        assertEquals(0, StringUtils.indexOfAny("abc", "ab"));
        assertEquals(1, StringUtils.indexOfAny("abc", "bc"));
        assertEquals(-1, StringUtils.indexOfAny("abc", "cd"));
    }





    @Test
    public void splitPreserveAllTokens_nullString_returnsNull() {
        assertNull(StringUtils.splitPreserveAllTokens(null));
    }

    @Test
    public void splitPreserveAllTokens_emptyString_returnsEmptyArray() {
        String input = "";
        String[] expected = {};
        assertArrayEquals(expected, StringUtils.splitPreserveAllTokens(input));
    }

    @Test
    public void splitPreserveAllTokens_stringWithWhiteSpace_returnsArrayOfWords() {
        String input = "abc def";
        String[] expected = {"abc", "def"};
        assertArrayEquals(expected, StringUtils.splitPreserveAllTokens(input));
    }

    @Test
    public void splitPreserveAllTokens_stringWithMultipleWhiteSpace_returnsArrayIncludingEmptyStrings() {
        String input = "abc  def";
        String[] expected = {"abc", "", "def"};
        assertArrayEquals(expected, StringUtils.splitPreserveAllTokens(input));
    }

    @Test
    public void splitPreserveAllTokens_stringWithLeadingAndTrailingWhiteSpace_returnsArrayIncludingLeadingAndTrailingEmptyStrings() {
        String input = " abc ";
        String[] expected = {"", "abc", ""};
        assertArrayEquals(expected, StringUtils.splitPreserveAllTokens(input));
    }

    @Test
    public void splitPreserveAllTokens_stringWithCustomSeparator_returnsArraySplitBySeparator() {
        String input = "a.b.c";
        char separator = '.';
        String[] expected = {"a", "b", "c"};
        assertArrayEquals(expected, StringUtils.splitPreserveAllTokens(input, separator));
    }

    @Test
    public void splitPreserveAllTokens_stringWithCustomSeparatorAndAdjacentSeparators_returnsArrayIncludingEmptyStrings() {
        String input = "a..b.c";
        char separator = '.';
        String[] expected = {"a", "", "b", "c"};
        assertArrayEquals(expected, StringUtils.splitPreserveAllTokens(input, separator));
    }

    @Test
    public void splitPreserveAllTokens_stringWithCustomSeparatorChars_returnsArraySplitBySeparatorChars() {
        String input = "ab:cd:ef";
        String separatorChars = ":";
        String[] expected = {"ab", "cd", "ef"};
        assertArrayEquals(expected, StringUtils.splitPreserveAllTokens(input, separatorChars));
    }

    @Test
    public void splitPreserveAllTokens_stringWithCustomSeparatorCharsAndMax_returnsArraySplitBySeparatorCharsAndLimitLength() {
        String input = "ab:cd:ef";
        String separatorChars = ":";
        int max = 2;
        String[] expected = {"ab", "cd:ef"};
        assertArrayEquals(expected, StringUtils.splitPreserveAllTokens(input, separatorChars, max));
    }







    @Test
    @DisplayName("Test left() with null string, should return null")
    public void testLeftWithNullString() {
        String str = null;
        int len = 5;
        String result = StringUtils.left(str, len);
        assertNull(result, "The result should be null");
    }

    @Test
    @DisplayName("Test left() with negative length, should return empty string")
    public void testLeftWithNegativeLength() {
        String str = "test";
        int len = -5;
        String result = StringUtils.left(str, len);
        assertEquals("", result, "The result should be an empty string");
    }

    @Test
    @DisplayName("Test left() with zero length, should return empty string")
    public void testLeftWithZeroLength() {
        String str = "test";
        int len = 0;
        String result = StringUtils.left(str, len);
        assertEquals("", result, "The result should be an empty string");
    }

    @Test
    @DisplayName("Test left() with length less than string length, should return leftmost characters")
    public void testLeftWithLengthLessThanStringLength() {
        String str = "test";
        int len = 2;
        String result = StringUtils.left(str, len);
        assertEquals("te", result, "The result should be the leftmost characters");
    }

    @Test
    @DisplayName("Test left() with length equal to string length, should return the original string")
    public void testLeftWithLengthEqualToStringLength() {
        String str = "test";
        int len = 4;
        String result = StringUtils.left(str, len);
        assertEquals("test", result, "The result should be the original string");
    }

    @Test
    @DisplayName("Test left() with length greater than string length, should return the original string")
    public void testLeftWithLengthGreaterThanStringLength() {
        String str = "test";
        int len = 5;
        String result = StringUtils.left(str, len);
        assertEquals("test", result, "The result should be the original string");
    }







    @Test
    public void testIsBlank_Null() {
        // Test for null string
        assertTrue(StringUtils.isBlank(null));
    }

    @Test
    public void testIsBlank_Empty() {
        // Test for empty string
        assertTrue(StringUtils.isBlank(""));
    }

    public void testIsBlank_WhiteSpace() {
        // Test for string with white space only
        assertTrue(StringUtils.isBlank(" "));
    }

    @Test
    public void testIsBlank_ValidString() {
        // Test for valid string
        assertFalse(StringUtils.isBlank("bob"));
    }

    @Test
    public void testIsBlank_ValidStringWithSpaces() {
        // Test for valid string with spaces
        assertFalse(StringUtils.isBlank("  bob  "));
    }

    @Test
    public void testIsBlank_Tab() {
        // Test for string with tab
        assertTrue(StringUtils.isBlank("\t"));
    }

    @Test
    public void testIsBlank_NewLine() {
        // Test for string with new line
        assertTrue(StringUtils.isBlank("\n"));
    }

    @Test
    public void testIsBlank_CarriageReturn() {
        // Test for string with carriage return
        assertTrue(StringUtils.isBlank("\r"));
    }






    @Test
    public void testFirstNonBlank_AllValuesAreNull() {
        String result = StringUtils.firstNonBlank(null, null, null);
        assertNull(result);
    }

    @Test
    public void testFirstNonBlank_AllValuesAreEmpty() {
        String result = StringUtils.firstNonBlank("", "", "");
        assertNull(result);
    }

    @Test
    public void testFirstNonBlank_AllValuesAreBlanks() {
        String result = StringUtils.firstNonBlank(" ", " ", " ");
        assertNull(result);
    }

    @Test
    public void testFirstNonBlank_FirstValueIsNotBlank() {
        String result = StringUtils.firstNonBlank("abc", null, "");
        assertEquals("abc", result);
    }

    @Test
    public void testFirstNonBlank_SecondValueIsNotBlank() {
        String result = StringUtils.firstNonBlank(null, "xyz", "");
        assertEquals("xyz", result);
    }

    @Test
    public void testFirstNonBlank_LastValueIsNotBlank() {
        String result = StringUtils.firstNonBlank(null, "", "xyz");
        assertEquals("xyz", result);
    }

    @Test
    public void testFirstNonBlank_NoValues() {
        String result = StringUtils.firstNonBlank();
        assertNull(result);
    }







    @Test
    void defaultIfBlank_NullString_DefaultStringReturned() {
        String str = null;
        String defaultStr = "default";
        String result = StringUtils.defaultIfBlank(str, defaultStr);
        assertEquals(defaultStr, result);
    }

    @Test
    void defaultIfBlank_EmptyString_DefaultStringReturned() {
        String str = "";
        String defaultStr = "default";
        String result = StringUtils.defaultIfBlank(str, defaultStr);
        assertEquals(defaultStr, result);
    }

    @Test
    void defaultIfBlank_WhitespaceString_DefaultStringReturned() {
        String str = " ";
        String defaultStr = "default";
        String result = StringUtils.defaultIfBlank(str, defaultStr);
        assertEquals(defaultStr, result);
    }

    @Test
    void defaultIfBlank_NonBlankString_NonBlankStringReturned() {
        String str = "bat";
        String defaultStr = "default";
        String result = StringUtils.defaultIfBlank(str, defaultStr);
        assertEquals(str, result);
    }

    @Test
    void defaultIfBlank_EmptyStringAndNullDefault_NullReturned() {
        String str = "";
        String defaultStr = null;
        String result = StringUtils.defaultIfBlank(str, defaultStr);
        assertNull(result);
    }









    @Test
    public void replaceAllNullText() {
        assertNull(StringUtils.replaceAll(null, ".*", "replace"));
    }

    @Test
    public void replaceAllNullRegex() {
        String text = "Hello World!";
        assertEquals(text, StringUtils.replaceAll(text, null, "replace"));
    }

    @Test
    public void replaceAllNullReplacement() {
        String text = "Hello World!";
        assertEquals(text, StringUtils.replaceAll(text, ".*", null));
    }

    @Test
    public void replaceAllEmptyTextAndRegex() {
        assertEquals("replace", StringUtils.replaceAll("", "", "replace"));
    }

    @Test
    public void replaceAllEmptyTextAndNonEmptyRegex() {
        assertEquals("", StringUtils.replaceAll("", ".*", "replace"));
    }

    @Test
    public void replaceAllNonEmptyTextAndEmptyRegex() {
        String text = "Hello World!";
        assertEquals("replaceHreplacereplacerreplaceereplacereplaceprelacereplacelreplaceareplacecreplaceereplace", StringUtils.replaceAll(text, "", "replace"));
    }

    @Test
    public void replaceAllMultiLineTextAndRegex() {
        String text = "<__>\n<__>";
        assertEquals("z\nz", StringUtils.replaceAll(text, "<.*>", "z"));
    }

    @Test
    public void replaceAllTextAndRegexWithDotAll() {
        String text = "<__>\n<__>";
        assertEquals("z", StringUtils.replaceAll(text, "(?s)<.*>", "z"));
    }

    @Test
    public void replaceAllTextAndRegex() {
        String text = "ABCabc123";
        assertEquals("ABC___123", StringUtils.replaceAll(text, "[a-z]", "_"));
        assertEquals("ABC_123", StringUtils.replaceAll(text, "[^A-Z0-9]+", "_"));
        assertEquals("ABC123", StringUtils.replaceAll(text, "[^A-Z0-9]+", ""));
    }





    @Test
    public void removeFirstWithNullText() {
        String text = null;
        String regex = ".*";

        String result = StringUtils.removeFirst(text, regex);

        assertNull(result);
    }

    @Test
    public void removeFirstWithNullRegex() {
        String text = "any";
        String regex = null;

        String result = StringUtils.removeFirst(text, regex);

        assertEquals("any", result);
    }

    @Test
    public void removeFirstWithEmptyRegex() {
        String text = "any";
        String regex = "";

        String result = StringUtils.removeFirst(text, regex);

        assertEquals("any", result);
    }

    @Test
    public void removeFirstWithAnyTextAndDotStarRegex() {
        String text = "any";
        String regex = ".*";

        String result = StringUtils.removeFirst(text, regex);

        assertEquals("", result);
    }

    @Test
    public void removeFirstWithAnyTextAndDotPlusRegex() {
        String text = "any";
        String regex = ".+";

        String result = StringUtils.removeFirst(text, regex);

        assertEquals("", result);
    }

    @Test
    public void removeFirstWithAbcTextAndDotQuestionMarkRegex() {
        String text = "abc";
        String regex = ".?";

        String result = StringUtils.removeFirst(text, regex);

        assertEquals("bc", result);
    }

    @Test
    public void removeFirstWithComplexTextAndComplexRegex() {
        String text = "A<__>\n<__>B";
        String regex = "<.*>";

        String result = StringUtils.removeFirst(text, regex);

        assertEquals("A\n<__>B", result);
    }

    @Test
    public void removeFirstWithComplexTextAndDotAllRegex() {
        String text = "A<__>\n<__>B";
        String regex = "(?s)<.*>";

        String result = StringUtils.removeFirst(text, regex);

        assertEquals("AB", result);
    }

    @Test
    public void removeFirstWithAlphanumericTextAndLowerCaseRegex() {
        String text = "ABCabc123";
        String regex = "[a-z]";

        String result = StringUtils.removeFirst(text, regex);

        assertEquals("ABCbc123", result);
    }

    @Test
    public void removeFirstWithAlphanumericTextAndLowerCasePlusRegex() {
        String text = "ABCabc123abc";
        String regex = "[a-z]+";

        String result = StringUtils.removeFirst(text, regex);

        assertEquals("ABC123abc", result);
    }









    @Test
    public void testStripToEmpty_NullString() {
        String str = null;
        String result = StringUtils.stripToEmpty(str);
        assertEquals("", result);
    }

    @Test
    public void testStripToEmpty_EmptyString() {
        String str = "";
        String result = StringUtils.stripToEmpty(str);
        assertEquals("", result);
    }

    @Test
    public void testStripToEmpty_WhiteSpaceOnly() {
        String str = "   ";
        String result = StringUtils.stripToEmpty(str);
        assertEquals("", result);
    }

    @Test
    public void testStripToEmpty_NoWhiteSpace() {
        String str = "abc";
        String result = StringUtils.stripToEmpty(str);
        assertEquals("abc", result);
    }

    @Test
    public void testStripToEmpty_WhiteSpaceAtStart() {
        String str = "  abc";
        String result = StringUtils.stripToEmpty(str);
        assertEquals("abc", result);
    }

    @Test
    public void testStripToEmpty_WhiteSpaceAtEnd() {
        String str = "abc  ";
        String result = StringUtils.stripToEmpty(str);
        assertEquals("abc", result);
    }

    @Test
    public void testStripToEmpty_WhiteSpaceAtBothEnds() {
        String str = " abc ";
        String result = StringUtils.stripToEmpty(str);
        assertEquals("abc", result);
    }

    @Test
    public void testStripToEmpty_WhiteSpaceWithinString() {
        String str = " ab c ";
        String result = StringUtils.stripToEmpty(str);
        assertEquals("ab c", result);
    }









    @Test
    public void testGetIfEmpty_nullString() {
        Supplier<String> mockSupplier = mock(Supplier.class);
        when(mockSupplier.get()).thenReturn("DEFAULT");

        String result = StringUtils.getIfEmpty(null, mockSupplier);

        verify(mockSupplier, times(1)).get();
        assertEquals("DEFAULT", result);
    }

    @Test
    public void testGetIfEmpty_emptyString() {
        Supplier<String> mockSupplier = mock(Supplier.class);
        when(mockSupplier.get()).thenReturn("DEFAULT");

        String result = StringUtils.getIfEmpty("", mockSupplier);

        verify(mockSupplier, times(1)).get();
        assertEquals("DEFAULT", result);
    }

    @Test
    public void testGetIfEmpty_nonEmptyString() {
        Supplier<String> mockSupplier = mock(Supplier.class);
        when(mockSupplier.get()).thenReturn("DEFAULT");

        String result = StringUtils.getIfEmpty("bat", mockSupplier);

        verify(mockSupplier, never()).get();
        assertEquals("bat", result);
    }

    @Test
    public void testGetIfEmpty_nullSupplier() {
        String result = StringUtils.getIfEmpty("", null);

        assertNull(result);
    }







    @Test
    public void testContainsNone_CharArray() {
        // Test with null input
        assertTrue(StringUtils.containsNone(null, 'a', 'b', 'c'));

        // Test with null search chars
        assertTrue(StringUtils.containsNone("abc", (char[]) null));

        // Test with empty input
        assertTrue(StringUtils.containsNone("", 'a', 'b', 'c'));

        // Test with no matching chars
        assertTrue(StringUtils.containsNone("abc", 'x', 'y', 'z'));

        // Test with some matching chars
        assertFalse(StringUtils.containsNone("abc", 'a', 'y', 'z'));

        // Test with all matching chars
        assertFalse(StringUtils.containsNone("abc", 'a', 'b', 'c'));
    }

    @Test
    public void testContainsNone_String() {
        // Test with null input
        assertTrue(StringUtils.containsNone(null, "abc"));

        // Test with null search chars
        assertTrue(StringUtils.containsNone("abc", (String) null));

        // Test with empty input
        assertTrue(StringUtils.containsNone("", "abc"));

        // Test with no matching chars
        assertTrue(StringUtils.containsNone("abc", "xyz"));

        // Test with some matching chars
        assertFalse(StringUtils.containsNone("abc", "ayz"));

        // Test with all matching chars
        assertFalse(StringUtils.containsNone("abc", "abc"));
    }





    @Test
    @DisplayName("Test startsWithAny returns false when sequence and searchStrings are null")
    public void testStartsWithAnyReturnsFalseWhenSequenceAndSearchStringsAreNull() {
        assertFalse(StringUtils.startsWithAny(null, (CharSequence[]) null));
    }

    @Test
    @DisplayName("Test startsWithAny returns false when sequence is null and searchStrings are not null")
    public void testStartsWithAnyReturnsFalseWhenSequenceIsNullAndSearchStringsAreNotNull() {
        assertFalse(StringUtils.startsWithAny(null, new String[] {"abc"}));
    }

    @Test
    @DisplayName("Test startsWithAny returns false when sequence is not null and searchStrings are null")
    public void testStartsWithAnyReturnsFalseWhenSequenceIsNotNullAndSearchStringsAreNull() {
        assertFalse(StringUtils.startsWithAny("abcxyz", (CharSequence[]) null));
    }

    @Test
    @DisplayName("Test startsWithAny returns true when sequence starts with searchStrings")
    public void testStartsWithAnyReturnsTrueWhenSequenceStartsWithSearchStrings() {
        assertTrue(StringUtils.startsWithAny("abcxyz", new String[] {"abc"}));
    }

    @Test
    @DisplayName("Test startsWithAny returns true when sequence contains searchStrings")
    public void testStartsWithAnyReturnsTrueWhenSequenceContainsSearchStrings() {
        assertTrue(StringUtils.startsWithAny("abcxyz", new String[] {null, "xyz", "abc"}));
    }

    @Test
    @DisplayName("Test startsWithAny returns false when sequence does not start with searchStrings")
    public void testStartsWithAnyReturnsFalseWhenSequenceDoesNotStartWithSearchStrings() {
        assertFalse(StringUtils.startsWithAny("abcxyz", "xyz", "ABCX"));
    }

    @Test
    @DisplayName("Test startsWithAny returns false when sequence and searchStrings are case-sensitive")
    public void testStartsWithAnyReturnsFalseWhenSequenceAndSearchStringsAreCaseSensitive() {
        assertFalse(StringUtils.startsWithAny("ABCXYZ", null, "xyz", "abc"));
    }





    @Test
    public void rotate_ShouldReturnNull_WhenStringIsNull() {
        String str = null;
        int shift = 2;
        String result = StringUtils.rotate(str, shift);
        assertNull(result);
    }

    @Test
    public void rotate_ShouldReturnSameString_WhenStringIsEmpty() {
        String str = "";
        int shift = 2;
        String result = StringUtils.rotate(str, shift);
        assertEquals(str, result);
    }

    @Test
    public void rotate_ShouldReturnSameString_WhenShiftIsZero() {
        String str = "abc";
        int shift = 0;
        String result = StringUtils.rotate(str, shift);
        assertEquals(str, result);
    }

    @Test
    public void rotate_ShouldReturnSameString_WhenShiftIsMultipleOfStringLength() {
        String str = "abc";
        int shift = 6;
        String result = StringUtils.rotate(str, shift);
        assertEquals(str, result);
    }

    @Test
    public void rotate_ShouldReturnRotatedString_WhenShiftIsPositive() {
        String str = "abcdefg";
        int shift = 2;
        String result = StringUtils.rotate(str, shift);
        assertEquals("fgabcde", result);
    }
    
    @Test
    public void rotate_ShouldReturnRotatedString_WhenShiftIsNegative() {
        String str = "abcdefg";
        int shift = -2;
        String result = StringUtils.rotate(str, shift);
        assertEquals("cdefgab", result);
    }





    @Test
    public void testOrdinalIndexOf_nullInput() {
        assertEquals(-1, StringUtils.ordinalIndexOf(null, "a", 1));
        assertEquals(-1, StringUtils.ordinalIndexOf("aabaabaa", null, 1));
    }

    @Test
    public void testOrdinalIndexOf_emptyInput() {
        assertEquals(0, StringUtils.ordinalIndexOf("", "", 1));
        assertEquals(0, StringUtils.ordinalIndexOf("aabaabaa", "", 1));
    }

    @Test
    public void testOrdinalIndexOf_singleCharSearch() {
        assertEquals(0, StringUtils.ordinalIndexOf("aabaabaa", "a", 1));
        assertEquals(1, StringUtils.ordinalIndexOf("aabaabaa", "a", 2));
        assertEquals(2, StringUtils.ordinalIndexOf("aabaabaa", "b", 1));
        assertEquals(5, StringUtils.ordinalIndexOf("aabaabaa", "b", 2));
    }

    @Test
    public void testOrdinalIndexOf_multiCharSearch() {
        assertEquals(1, StringUtils.ordinalIndexOf("aabaabaa", "ab", 1));
        assertEquals(4, StringUtils.ordinalIndexOf("aabaabaa", "ab", 2));
    }

    @Test
    public void testOrdinalIndexOf_overlappingMatches() {
        assertEquals(0, StringUtils.ordinalIndexOf("ababab", "aba", 1));
        assertEquals(2, StringUtils.ordinalIndexOf("ababab", "aba", 2));
        assertEquals(-1, StringUtils.ordinalIndexOf("ababab", "aba", 3));

        assertEquals(0, StringUtils.ordinalIndexOf("abababab", "abab", 1));
        assertEquals(2, StringUtils.ordinalIndexOf("abababab", "abab", 2));
        assertEquals(4, StringUtils.ordinalIndexOf("abababab", "abab", 3));
        assertEquals(-1, StringUtils.ordinalIndexOf("abababab", "abab", 4));
    }







    @Test
    public void whenBothStringNull_thenFalse() {
        assertFalse(StringUtils.containsIgnoreCase(null, null));
    }

    @Test
    public void whenOneStringNull_thenFalse() {
        assertFalse(StringUtils.containsIgnoreCase(null, "test"));
        assertFalse(StringUtils.containsIgnoreCase("test", null));
    }

    @Test
    public void whenSearchStringEmpty_thenTrue() {
        assertTrue(StringUtils.containsIgnoreCase("test", ""));
    }

    @Test
    public void whenSearchStringFoundIgnoreCase_thenTrue() {
        assertTrue(StringUtils.containsIgnoreCase("test", "T"));
        assertTrue(StringUtils.containsIgnoreCase("test", "TEST"));
    }

    @Test
    public void whenSearchStringNotFound_thenFalse() {
        assertFalse(StringUtils.containsIgnoreCase("test", "z"));
    }









    @Test
    public void shouldReturnTrueWhenBothStringsAreNull() {
        assertTrue(StringUtils.equalsIgnoreCase(null, null));
    }

    @Test
    public void shouldReturnFalseWhenFirstStringIsNull() {
        assertFalse(StringUtils.equalsIgnoreCase(null, "abc"));
    }

    @Test
    public void shouldReturnFalseWhenSecondStringIsNull() {
        assertFalse(StringUtils.equalsIgnoreCase("abc", null));
    }

    @Test
    public void shouldReturnTrueWhenBothStringsAreEqual() {
        assertTrue(StringUtils.equalsIgnoreCase("abc", "abc"));
    }

    @Test
    public void shouldReturnTrueWhenBothStringsAreEqualIgnoringCase() {
        assertTrue(StringUtils.equalsIgnoreCase("abc", "ABC"));
    }

    @Test
    public void shouldReturnFalseWhenStringsAreOfDifferentLengths() {
        assertFalse(StringUtils.equalsIgnoreCase("abc", "abcd"));
    }

    @Test
    public void shouldReturnFalseWhenStringsAreNotEqualIgnoringCase() {
        assertFalse(StringUtils.equalsIgnoreCase("abc", "DEF"));
    }









    @Test
    public void testEqualsAnyIgnoreCase_EmptyStrings() {
        assertTrue(StringUtils.equalsAnyIgnoreCase("", ""));
    }

    @Test
    public void testEqualsAnyIgnoreCase_NullString() {
        assertFalse(StringUtils.equalsAnyIgnoreCase(null, "test"));
    }

    @Test
    public void testEqualsAnyIgnoreCase_NullSearchStrings() {
        assertFalse(StringUtils.equalsAnyIgnoreCase("test", (CharSequence[]) null));
    }

    @Test
    public void testEqualsAnyIgnoreCase_NullStringAndSearchStrings() {
        assertTrue(StringUtils.equalsAnyIgnoreCase(null, (CharSequence) null));
    }

    @Test
    public void testEqualsAnyIgnoreCase_StringNotEqualSearchStrings() {
        assertFalse(StringUtils.equalsAnyIgnoreCase("test", "test1", "test2"));
    }

    @Test
    public void testEqualsAnyIgnoreCase_SearchStringsContainsString() {
        assertTrue(StringUtils.equalsAnyIgnoreCase("test", "test1", "test2", "test"));
    }

    @Test
    public void testEqualsAnyIgnoreCase_SearchStringsContainsStringCaseInsensitive() {
        assertTrue(StringUtils.equalsAnyIgnoreCase("test", "TEst", "Test2", "TesT"));
    }




    
    @Test
    public void testIndexOfAnyButChars() {
        assertEquals(-1, StringUtils.indexOfAnyBut(null, 'a', 'b'));
        assertEquals(-1, StringUtils.indexOfAnyBut("", 'a', 'b'));
        assertEquals(-1, StringUtils.indexOfAnyBut("ab", new char[] {}));
        assertEquals(0, StringUtils.indexOfAnyBut("ab", 'c', 'd'));
        assertEquals(1, StringUtils.indexOfAnyBut("ab", 'a'));
        assertEquals(-1, StringUtils.indexOfAnyBut("aa", 'a'));
    }

    @Test
    public void testIndexOfAnyButCharsWithNullArray() {
        assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                StringUtils.indexOfAnyBut("ab", (char[]) null);
            }
        });
    }

    @Test
    public void testIndexOfAnyButCharSequence() {
        assertEquals(-1, StringUtils.indexOfAnyBut((CharSequence) null, "ab"));
        assertEquals(-1, StringUtils.indexOfAnyBut("", "ab"));
        assertEquals(-1, StringUtils.indexOfAnyBut("ab", (CharSequence) null));
        assertEquals(-1, StringUtils.indexOfAnyBut("ab", ""));
        assertEquals(0, StringUtils.indexOfAnyBut("ab", "cd"));
        assertEquals(1, StringUtils.indexOfAnyBut("ab", "a"));
        assertEquals(-1, StringUtils.indexOfAnyBut("aa", "a"));
    }

    @Test
    public void testIndexOfAnyButCharSequenceWithNullString() {
        assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                StringUtils.indexOfAnyBut("ab", (String) null);
            }
        });
    }







    @Test
    public void testSplitByWholeSeparatorPreserveAllTokens() {
        String[] expectedOutput = {"ab", "cd", "ef"};
        String[] actualOutput = StringUtils.splitByWholeSeparatorPreserveAllTokens("ab-!-cd-!-ef", "-!-");
        assertArrayEquals(expectedOutput, actualOutput);

        expectedOutput = new String[]{"ab", "", "", "de", "fg"};
        actualOutput = StringUtils.splitByWholeSeparatorPreserveAllTokens("ab   de fg", null);
        assertArrayEquals(expectedOutput, actualOutput);

        expectedOutput = new String[]{};
        actualOutput = StringUtils.splitByWholeSeparatorPreserveAllTokens("", "*");
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testSplitByWholeSeparatorPreserveAllTokensWithMax() {
        String[] expectedOutput = {"ab", "cd:ef"};
        String[] actualOutput = StringUtils.splitByWholeSeparatorPreserveAllTokens("ab:cd:ef", ":", 2);
        assertArrayEquals(expectedOutput, actualOutput);

        expectedOutput = new String[]{"ab", "cd-!-ef"};
        actualOutput = StringUtils.splitByWholeSeparatorPreserveAllTokens("ab-!-cd-!-ef", "-!-", 2);
        assertArrayEquals(expectedOutput, actualOutput);

        expectedOutput = new String[]{};
        actualOutput = StringUtils.splitByWholeSeparatorPreserveAllTokens("", "*", 5);
        assertArrayEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testSplitByWholeSeparatorPreserveAllTokensNullInput() {
        assertNull(StringUtils.splitByWholeSeparatorPreserveAllTokens(null, "*"));
    }

    @Test
    public void testSplitByWholeSeparatorPreserveAllTokensWithMaxNullInput() {
        assertNull(StringUtils.splitByWholeSeparatorPreserveAllTokens(null, "*", 5));
    }





    @Test
    public void toStringOrEmpty_ExistingObject_ReturnsObjectToString() {
        // Instantiate all necessary variables here
        Object mockObject = mock(Object.class);
        String expected = "Mock object";

        // Mock the toString method of the object
        when(mockObject.toString()).thenReturn(expected);

        // Instantiate the StringUtils class
        StringUtils stringUtils = new StringUtils();

        // Write the test code here following the given rules
        String actual = stringUtils.toStringOrEmpty(mockObject);

        // Assertion
        assertEquals(expected, actual);
    }

    @Test
    public void toStringOrEmpty_NullObject_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        Object nullObject = null;

        // Instantiate the StringUtils class
        StringUtils stringUtils = new StringUtils();

        // Write the test code here following the given rules
        String actual = stringUtils.toStringOrEmpty(nullObject);

        // Assertion
        assertEquals(StringUtils.EMPTY, actual);
    }









    @Test
    public void testAppendIfMissingIgnoreCase() {
        assertNull(StringUtils.appendIfMissingIgnoreCase(null, null));
        assertEquals("abc", StringUtils.appendIfMissingIgnoreCase("abc", null));
        assertEquals("xyz", StringUtils.appendIfMissingIgnoreCase("", "xyz"));
        assertEquals("abcxyz", StringUtils.appendIfMissingIgnoreCase("abc", "xyz"));
        assertEquals("abcxyz", StringUtils.appendIfMissingIgnoreCase("abcxyz", "xyz"));
        assertEquals("abcXYZ", StringUtils.appendIfMissingIgnoreCase("abcXYZ", "xyz"));
    }

    @Test
    public void testAppendIfMissingIgnoreCaseWithSuffixes() {
        assertNull(StringUtils.appendIfMissingIgnoreCase(null, null, null));
        assertEquals("abc", StringUtils.appendIfMissingIgnoreCase("abc", null, null));
        assertEquals("xyz", StringUtils.appendIfMissingIgnoreCase("", "xyz", null));
        assertEquals("abcxyz", StringUtils.appendIfMissingIgnoreCase("abc", "xyz", new CharSequence[]{null}));
        assertEquals("abc", StringUtils.appendIfMissingIgnoreCase("abc", "xyz", ""));
        assertEquals("abcxyz", StringUtils.appendIfMissingIgnoreCase("abc", "xyz", "mno"));
        assertEquals("abcxyz", StringUtils.appendIfMissingIgnoreCase("abcxyz", "xyz", "mno"));
        assertEquals("abcmno", StringUtils.appendIfMissingIgnoreCase("abcmno", "xyz", "mno"));
        assertEquals("abcXYZ", StringUtils.appendIfMissingIgnoreCase("abcXYZ", "xyz", "mno"));
        assertEquals("abcMNO", StringUtils.appendIfMissingIgnoreCase("abcMNO", "xyz", "mno"));
    }





    @Test
    public void testAbbreviate() {
        String str = "Now is the time for all good men";
        String abbrevMarker = "...";
        int maxWidth = 10;
        String result = StringUtils.abbreviate(str, abbrevMarker, maxWidth);
        assertEquals("Now is...", result);

        str = "Short";
        result = StringUtils.abbreviate(str, abbrevMarker, maxWidth);
        assertEquals("Short", result);

        str = "Now is the time for all good men";
        maxWidth = 2;
        assertThrows(IllegalArgumentException.class, () -> StringUtils.abbreviate(str, abbrevMarker, maxWidth));
    }

    @Test
    public void testAbbreviateWithOffset() {
        String str = "Now is the time for all good men";
        String abbrevMarker = "...";
        int maxWidth = 10;
        int offset = 5;
        String result = StringUtils.abbreviate(str, abbrevMarker, offset, maxWidth);
        assertEquals("... is the...", result);

        str = "Short";
        result = StringUtils.abbreviate(str, abbrevMarker, offset, maxWidth);
        assertEquals("Short", result);

        str = "Now is the time for all good men";
        maxWidth = 2;
        assertThrows(IllegalArgumentException.class, () -> StringUtils.abbreviate(str, abbrevMarker, offset, maxWidth));
    }

    @Test
    public void testAbbreviateWithNulls() {
        String str = null;
        String abbrevMarker = "...";
        int maxWidth = 10;
        String result = StringUtils.abbreviate(str, abbrevMarker, maxWidth);
        assertNull(result);

        str = "Now is the time for all good men";
        abbrevMarker = null;
        result = StringUtils.abbreviate(str, abbrevMarker, maxWidth);
        assertEquals("Now is...", result);
    }











    @Test
    public void testIsNoneEmpty_nullString() {
        // Instantiate all necessary variables here
        String nullString = null;

        // Test that isNoneEmpty returns false when one of the strings is null
        assertFalse(StringUtils.isNoneEmpty(nullString));
    }

    @Test
    public void testIsNoneEmpty_emptyString() {
        // Instantiate all necessary variables here
        String emptyString = "";

        // Test that isNoneEmpty returns false when one of the strings is empty
        assertFalse(StringUtils.isNoneEmpty(emptyString));
    }

    @Test
    public void testIsNoneEmpty_nonEmptyString() {
        // Instantiate all necessary variables here
        String nonEmptyString = "test";

        // Test that isNoneEmpty returns true when all strings are non-empty
        assertTrue(StringUtils.isNoneEmpty(nonEmptyString));
    }

    @Test
    public void testIsNoneEmpty_multipleStrings() {
        // Instantiate all necessary variables here
        String nullString = null;
        String emptyString = "";
        String nonEmptyString = "test";

        // Test that isNoneEmpty returns true when all strings are non-empty
        assertTrue(StringUtils.isNoneEmpty(nonEmptyString, nonEmptyString));

        // Test that isNoneEmpty returns false when one of the strings is empty
        assertFalse(StringUtils.isNoneEmpty(nonEmptyString, emptyString));

        // Test that isNoneEmpty returns false when one of the strings is null
        assertFalse(StringUtils.isNoneEmpty(nonEmptyString, nullString));
    }

    @Test
    public void testIsNoneEmpty_nullArray() {
        // Test that isNoneEmpty returns true when the array is null
        assertTrue(StringUtils.isNoneEmpty((CharSequence[]) null));
    }

    @Test
    public void testIsNoneEmpty_emptyArray() {
        // Test that isNoneEmpty returns true when the array is empty
        assertTrue(StringUtils.isNoneEmpty(new CharSequence[]{}));
    }









    @Test
    public void replaceOnceIgnoreCase_NullText() {
        String result = StringUtils.replaceOnceIgnoreCase(null, "search", "replace");
        assertNull(result);
    }

    @Test
    public void replaceOnceIgnoreCase_EmptyText() {
        String result = StringUtils.replaceOnceIgnoreCase("", "search", "replace");
        assertEquals("", result);
    }

    @Test
    public void replaceOnceIgnoreCase_NullSearch() {
        String result = StringUtils.replaceOnceIgnoreCase("some text", null, "replace");
        assertEquals("some text", result);
    }

    @Test
    public void replaceOnceIgnoreCase_NullReplace() {
        String result = StringUtils.replaceOnceIgnoreCase("some text", "search", null);
        assertEquals("some text", result);
    }

    @Test
    public void replaceOnceIgnoreCase_EmptySearch() {
        String result = StringUtils.replaceOnceIgnoreCase("some text", "", "replace");
        assertEquals("some text", result);
    }

    @Test
    public void replaceOnceIgnoreCase_SearchNotFound() {
        String result = StringUtils.replaceOnceIgnoreCase("some text", "notfound", "replace");
        assertEquals("some text", result);
    }

    @Test
    public void replaceOnceIgnoreCase_ReplaceWithEmpty() {
        String result = StringUtils.replaceOnceIgnoreCase("some text", "some", "");
        assertEquals(" text", result);
    }

    @Test
    public void replaceOnceIgnoreCase_ReplaceWithDifferentText() {
        String result = StringUtils.replaceOnceIgnoreCase("some text", "some", "any");
        assertEquals("any text", result);
    }

    @Test
    public void replaceOnceIgnoreCase_CaseInsensitiveReplace() {
        String result = StringUtils.replaceOnceIgnoreCase("Some text", "some", "any");
        assertEquals("any text", result);
    }











    @Test
    public void trimToEmpty_nullString_returnsEmptyString() {
        String str = null;
        String expected = "";
        String actual = StringUtils.trimToEmpty(str);
        assertEquals(expected, actual, "Expected empty string for null input");
    }

    @Test
    public void trimToEmpty_emptyString_returnsEmptyString() {
        String str = "";
        String expected = "";
        String actual = StringUtils.trimToEmpty(str);
        assertEquals(expected, actual, "Expected empty string for empty string input");
    }

    @Test
    public void trimToEmpty_stringWithSpaces_returnsEmptyString() {
        String str = "     ";
        String expected = "";
        String actual = StringUtils.trimToEmpty(str);
        assertEquals(expected, actual, "Expected empty string for string with spaces");
    }

    @Test
    public void trimToEmpty_stringWithText_returnsTrimmedString() {
        String str = "  abc  ";
        String expected = "abc";
        String actual = StringUtils.trimToEmpty(str);
        assertEquals(expected, actual, "Expected trimmed string for string with text");
    }

    @Test
    public void trimToEmpty_stringWithTextNoSpaces_returnsSameString() {
        String str = "abc";
        String expected = "abc";
        String actual = StringUtils.trimToEmpty(str);
        assertEquals(expected, actual, "Expected same string for string with text and no spaces");
    }







    @Test
    public void whenInputIsNull_thenIsNotBlankShouldReturnFalse() {
        // Arrange
        CharSequence input = null;

        // Act
        boolean result = StringUtils.isNotBlank(input);

        // Assert
        assertFalse(result, "Expected isNotBlank to return false when input is null.");
    }

    @Test
    public void whenInputIsEmptyString_thenIsNotBlankShouldReturnFalse() {
        // Arrange
        CharSequence input = "";

        // Act
        boolean result = StringUtils.isNotBlank(input);

        // Assert
        assertFalse(result, "Expected isNotBlank to return false when input is an empty string.");
    }

    @Test
    public void whenInputIsWhitespace_thenIsNotBlankShouldReturnFalse() {
        // Arrange
        CharSequence input = " ";

        // Act
        boolean result = StringUtils.isNotBlank(input);

        // Assert
        assertFalse(result, "Expected isNotBlank to return false when input is a whitespace.");
    }

    @Test
    public void whenInputIsNonEmptyString_thenIsNotBlankShouldReturnTrue() {
        // Arrange
        CharSequence input = "bob";

        // Act
        boolean result = StringUtils.isNotBlank(input);

        // Assert
        assertTrue(result, "Expected isNotBlank to return true when input is a non-empty string.");
    }

    @Test
    public void whenInputIsNonEmptyStringWithLeadingAndTrailingWhitespace_thenIsNotBlankShouldReturnTrue() {
        // Arrange
        CharSequence input = "  bob  ";

        // Act
        boolean result = StringUtils.isNotBlank(input);

        // Assert
        assertTrue(result, "Expected isNotBlank to return true when input is a non-empty string with leading and trailing whitespace.");
    }





    @Test
    public void splitByCharacterTypeCamelCaseNullInputTest() {
        String[] result = StringUtils.splitByCharacterTypeCamelCase(null);
        assertNull(result, "The result should be null");
    }

    @Test
    public void splitByCharacterTypeCamelCaseEmptyInputTest() {
        String[] result = StringUtils.splitByCharacterTypeCamelCase("");
        assertNotNull(result, "The result should not be null");
        assertEquals(0, result.length, "The result array should be empty");
    }

    @Test
    public void splitByCharacterTypeCamelCaseTest() {
        String[] result = StringUtils.splitByCharacterTypeCamelCase("fooBar");
        assertNotNull(result, "The result should not be null");
        assertEquals(2, result.length, "The result array should have two elements");
        assertEquals("foo", result[0], "The first element should be 'foo'");
        assertEquals("Bar", result[1], "The second element should be 'Bar'");
    }

    @Test
    public void splitByCharacterTypeCamelCaseWithNumbersTest() {
        String[] result = StringUtils.splitByCharacterTypeCamelCase("foo200Bar");
        assertNotNull(result, "The result should not be null");
        assertEquals(3, result.length, "The result array should have three elements");
        assertEquals("foo", result[0], "The first element should be 'foo'");
        assertEquals("200", result[1], "The second element should be '200'");
        assertEquals("Bar", result[2], "The third element should be 'Bar'");
    }

    @Test
    public void splitByCharacterTypeCamelCaseWithSpecialCharactersTest() {
        String[] result = StringUtils.splitByCharacterTypeCamelCase("ab:cd:ef");
        assertNotNull(result, "The result should not be null");
        assertEquals(5, result.length, "The result array should have five elements");
        assertEquals("ab", result[0], "The first element should be 'ab'");
        assertEquals(":", result[1], "The second element should be ':'");
        assertEquals("cd", result[2], "The third element should be 'cd'");
    }







    @Test
    public void testIsAlphanumeric_NullInput() {
        assertFalse(StringUtils.isAlphanumeric(null));
    }

    @Test
    public void testIsAlphanumeric_EmptyString() {
        assertFalse(StringUtils.isAlphanumeric(""));
    }

    @Test
    public void testIsAlphanumeric_SpaceString() {
        assertFalse(StringUtils.isAlphanumeric(" "));
    }

    @Test
    public void testIsAlphanumeric_AlphaString() {
        assertTrue(StringUtils.isAlphanumeric("abc"));
    }

    @Test
    public void testIsAlphanumeric_AlphaNumericString() {
        assertTrue(StringUtils.isAlphanumeric("ab2c"));
    }

    @Test
    public void testIsAlphanumeric_NonAlphaNumericString() {
        assertFalse(StringUtils.isAlphanumeric("ab-c"));
    }







    @Test
    public void testStripAccentsWithNullInput() {
        String input = null;
        String result = StringUtils.stripAccents(input);
        assertNull(result, "stripAccents() should return null for null input");
    }

    @Test
    public void testStripAccentsWithEmptyInput() {
        String input = "";
        String result = StringUtils.stripAccents(input);
        assertEquals("", result, "stripAccents() should return an empty string for empty input");
    }

    @Test
    public void testStripAccentsWithNoAccents() {
        String input = "control";
        String result = StringUtils.stripAccents(input);
        assertEquals("control", result, "stripAccents() should return the same string when there are no accents");
    }

    @Test
    public void testStripAccentsWithAccents() {
        String input = "éclair";
        String result = StringUtils.stripAccents(input);
        assertEquals("eclair", result, "stripAccents() should strip accents from letters");
    }

    @Test
    public void testStripAccentsWithMultipleAccents() {
        String input = "résumé";
        String result = StringUtils.stripAccents(input);
        assertEquals("resume", result, "stripAccents() should strip all accents from letters");
    }

    @Test
    public void testStripAccentsWithLigature() {
        String input = "æther";
        String result = StringUtils.stripAccents(input);
        assertEquals("æther", result, "stripAccents() should not strip ligatures");
    }





    @Test
    @DisplayName("Test endsWithIgnoreCase() with both inputs null")
    public void testEndsWithIgnoreCaseBothNull() {
        assertTrue(StringUtils.endsWithIgnoreCase(null, null));
    }

    @Test
    @DisplayName("Test endsWithIgnoreCase() with only first input null")
    public void testEndsWithIgnoreCaseFirstNull() {
        assertFalse(StringUtils.endsWithIgnoreCase(null, "suffix"));
    }

    @Test
    @DisplayName("Test endsWithIgnoreCase() with only second input null")
    public void testEndsWithIgnoreCaseSecondNull() {
        assertFalse(StringUtils.endsWithIgnoreCase("string", null));
    }

    @Test
    @DisplayName("Test endsWithIgnoreCase() with non-null inputs and suffix at the end")
    public void testEndsWithIgnoreCaseSuffixAtEnd() {
        assertTrue(StringUtils.endsWithIgnoreCase("string", "ing"));
    }

    @Test
    @DisplayName("Test endsWithIgnoreCase() with non-null inputs and suffix not at the end")
    public void testEndsWithIgnoreCaseSuffixNotAtEnd() {
        assertFalse(StringUtils.endsWithIgnoreCase("string", "tr"));
    }

    @Test
    @DisplayName("Test endsWithIgnoreCase() with non-null inputs, different cases and suffix at the end")
    public void testEndsWithIgnoreCaseDifferentCasesSuffixAtEnd() {
        assertTrue(StringUtils.endsWithIgnoreCase("STRING", "ing"));
    }

    @Test
    @DisplayName("Test endsWithIgnoreCase() with non-null inputs, different cases and suffix not at the end")
    public void testEndsWithIgnoreCaseDifferentCasesSuffixNotAtEnd() {
        assertFalse(StringUtils.endsWithIgnoreCase("STRING", "tr"));
    }







    @Test
    public void testRemoveChar() {
        String str = "queued";
        char remove = 'u';
        String expected = "qeed";
        String actual = StringUtils.remove(str, remove);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveCharWithCharNotFound() {
        String str = "queued";
        char remove = 'z';
        String expected = "queued";
        String actual = StringUtils.remove(str, remove);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveCharWithNullInput() {
        String str = null;
        char remove = 'u';
        String expected = null;
        String actual = StringUtils.remove(str, remove);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveCharWithEmptyInput() {
        String str = "";
        char remove = 'u';
        String expected = "";
        String actual = StringUtils.remove(str, remove);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveString() {
        String str = "queued";
        String remove = "ue";
        String expected = "qd";
        String actual = StringUtils.remove(str, remove);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveStringWithRemoveNotFound() {
        String str = "queued";
        String remove = "zz";
        String expected = "queued";
        String actual = StringUtils.remove(str, remove);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveStringWithNullInput() {
        String str = null;
        String remove = "ue";
        String expected = null;
        String actual = StringUtils.remove(str, remove);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveStringWithEmptyInput() {
        String str = "";
        String remove = "ue";
        String expected = "";
        String actual = StringUtils.remove(str, remove);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveStringWithNullRemove() {
        String str = "queued";
        String remove = null;
        String expected = "queued";
        String actual = StringUtils.remove(str, remove);
        assertEquals(expected, actual);
    }

    @Test
    public void testRemoveStringWithEmptyRemove() {
        String str = "queued";
        String remove = "";
        String expected = "queued";
        String actual = StringUtils.remove(str, remove);
        assertEquals(expected, actual);
    }







    @Test
    public void testGetFuzzyDistance_NullTerm() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.getFuzzyDistance(null, "query", Locale.ENGLISH);
        });
    }

    @Test
    public void testGetFuzzyDistance_NullQuery() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.getFuzzyDistance("term", null, Locale.ENGLISH);
        });
    }

    @Test
    public void testGetFuzzyDistance_NullLocale() {
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.getFuzzyDistance("term", "query", null);
        });
    }

    @Test
    public void testGetFuzzyDistance_EmptyStrings() {
        assertEquals(0, StringUtils.getFuzzyDistance("", "", Locale.ENGLISH));
    }

    @Test
    public void testGetFuzzyDistance_NoMatch() {
        assertEquals(0, StringUtils.getFuzzyDistance("Workshop", "b", Locale.ENGLISH));
    }

    @Test
    public void testGetFuzzyDistance_SingleMatch() {
        assertEquals(1, StringUtils.getFuzzyDistance("Room", "o", Locale.ENGLISH));
    }

    @Test
    public void testGetFuzzyDistance_MultipleMatches() {
        assertEquals(4, StringUtils.getFuzzyDistance("Workshop", "wo", Locale.ENGLISH));
    }

    @Test
    public void testGetFuzzyDistance_SubsequentMatchesBonus() {
        assertEquals(3, StringUtils.getFuzzyDistance("Apache Software Foundation", "asf", Locale.ENGLISH));
    }






    @Test
    public void testReverse_NullString() {
        String str = null;
        String result = StringUtils.reverse(str);
        assertNull(result);
    }

    @Test
    public void testReverse_EmptyString() {
        String str = "";
        String result = StringUtils.reverse(str);
        assertEquals("", result);
    }

    @Test
    public void testReverse_RegularString() {
        String str = "bat";
        String result = StringUtils.reverse(str);
        assertEquals("tab", result);
    }

    @Test
    public void testReverse_SpecialCharacters() {
        String str = "!@#123";
        String result = StringUtils.reverse(str);
        assertEquals("321@#!", result);
    }

    @Test
    public void testReverse_WhitespaceString() {
        String str = "    ";
        String result = StringUtils.reverse(str);
        assertEquals("    ", result);
    }

    @Test
    public void testReverse_LongString() {
        String str = "This is a very long string for testing";
        String result = StringUtils.reverse(str);
        assertEquals("gnitset rof gnirts gnol yrev a si sihT", result);
    }






    
    @Test
    public void testRemoveEnd() {
        // Test with null input string
        assertNull(StringUtils.removeEnd(null, ".com"));

        // Test with empty input string
        assertEquals("", StringUtils.removeEnd("", ".com"));

        // Test with null remove string
        assertEquals("www.domain.com", StringUtils.removeEnd("www.domain.com", null));

        // Test with string not ending with remove string
        assertEquals("www.domain.com", StringUtils.removeEnd("www.domain.com", ".com."));

        // Test with string ending with remove string
        assertEquals("www.domain", StringUtils.removeEnd("www.domain.com", ".com"));

        // Test with remove string not present in the input string
        assertEquals("www.domain.com", StringUtils.removeEnd("www.domain.com", "domain"));

        // Test with empty remove string
        assertEquals("abc", StringUtils.removeEnd("abc", ""));

        // Test with input string equals to the remove string
        assertEquals("", StringUtils.removeEnd("abc", "abc"));
    }









    @Test
    public void testRepeatChar() {
        assertEquals("aaaaa", StringUtils.repeat('a', 5));
        assertEquals("", StringUtils.repeat('a', 0));
        assertEquals("", StringUtils.repeat('a', -1));
    }

    @Test
    public void testRepeatString() {
        assertEquals("abcabcabc", StringUtils.repeat("abc", 3));
        assertEquals("", StringUtils.repeat("abc", 0));
        assertEquals("", StringUtils.repeat("abc", -1));
        assertEquals("", StringUtils.repeat("", 3));
        assertNull(StringUtils.repeat(null, 3));
    }

    @Test
    public void testRepeatStringWithSeparator() {
        assertEquals("a-b-c-a-b-c-", StringUtils.repeat("a-b-c-", null, 2));
        assertEquals("abc-abc-", StringUtils.repeat("abc", "-", 2));
        assertEquals("", StringUtils.repeat("", "-", 2));
        assertEquals("", StringUtils.repeat("abc", "", 2));
        assertEquals("", StringUtils.repeat("abc", "-", 0));
        assertNull(StringUtils.repeat(null, "-", 2));
        assertEquals("abcabc", StringUtils.repeat("abc", null, 2));
    }





    
    @Test
    public void testGetBytesWithCharset() {
        String input = "Test String";
        byte[] expected = input.getBytes(StandardCharsets.UTF_8);
        byte[] result = StringUtils.getBytes(input, StandardCharsets.UTF_8);
        assertArrayEquals(expected, result, "The byte arrays should be the same");

        assertNull(StringUtils.getBytes(null, StandardCharsets.UTF_8), "If String is null, the result should be null");
    }

    @Test
    public void testGetBytesWithUnsupportedCharset() throws UnsupportedEncodingException {
        String input = "Test String";
        byte[] expected = input.getBytes("UTF-8");
        byte[] result = StringUtils.getBytes(input, "UTF-8");
        assertArrayEquals(expected, result, "The byte arrays should be the same");

        assertNull(StringUtils.getBytes(null, "UTF-8"), "If String is null, the result should be null");
    }

    @Test
    public void testGetBytesWithUnsupportedCharsetException() {
        assertThrows(UnsupportedEncodingException.class, () -> {
            StringUtils.getBytes("Test String", "UnsupportedCharsetName");
        }, "UnsupportedEncodingException should be thrown when the charset name is not supported");
    }







    @Test
    public void shouldReturnTrueWhenStringEqualsAnyOfStringArray() {
        // Test data
        CharSequence string = "abc";
        CharSequence[] searchStrings = {"xyz", "abc", "123"};

        // Execute & Verify
        assertTrue(StringUtils.equalsAny(string, searchStrings));
    }

    @Test
    public void shouldReturnFalseWhenStringNotEqualsAnyOfStringArray() {
        // Test data
        CharSequence string = "test";
        CharSequence[] searchStrings = {"abc", "xyz", "123"};

        // Execute & Verify
        assertFalse(StringUtils.equalsAny(string, searchStrings));
    }

    @Test
    public void shouldReturnFalseWhenStringIsNullAndStringArrayContainsNonNullStrings() {
        // Test data
        CharSequence string = null;
        CharSequence[] searchStrings = {"abc", "xyz", "123"};

        // Execute & Verify
        assertFalse(StringUtils.equalsAny(string, searchStrings));
    }

    @Test
    public void shouldReturnTrueWhenBothStringAndStringArrayAreNull() {
        // Test data
        CharSequence string = null;
        CharSequence[] searchStrings = null;

        // Execute & Verify
        assertTrue(StringUtils.equalsAny(string, searchStrings));
    }

    @Test
    public void shouldReturnTrueWhenStringIsNullAndStringArrayContainsNullString() {
        // Test data
        CharSequence string = null;
        CharSequence[] searchStrings = {"abc", null, "123"};

        // Execute & Verify
        assertTrue(StringUtils.equalsAny(string, searchStrings));
    }

    @Test
    public void shouldReturnFalseWhenStringArrayIsEmpty() {
        // Test data
        CharSequence string = "abc";
        CharSequence[] searchStrings = {};

        // Execute & Verify
        assertFalse(StringUtils.equalsAny(string, searchStrings));
    }

    @Test
    public void shouldHandleCaseSensitivityProperly() {
        // Test data
        CharSequence string = "ABC";
        CharSequence[] searchStrings = {"abc", "xyz", "123"};

        // Execute & Verify
        assertFalse(StringUtils.equalsAny(string, searchStrings));
    }



















    @Test
    public void testStrip_nullInput() {
        // Test for null string input
        String input = null;
        String output = StringUtils.strip(input);
        assertNull(output);
    }
    
    @Test
    public void testStrip_emptyInput() {
        // Test for empty string input
        String input = "";
        String output = StringUtils.strip(input);
        assertEquals("", output);
    }
    
    @Test
    public void testStrip_whitespaceInput() {
        // Test for string with only whitespaces
        String input = "    ";
        String output = StringUtils.strip(input);
        assertEquals("", output);
    }
    
    @Test
    public void testStrip_noWhitespace() {
        // Test for string with no leading or trailing whitespaces
        String input = "abc";
        String output = StringUtils.strip(input);
        assertEquals("abc", output);
    }
    
    @Test
    public void testStrip_leadingWhitespace() {
        // Test for string with leading whitespaces
        String input = "  abc";
        String output = StringUtils.strip(input);
        assertEquals("abc", output);
    }
    
    @Test
    public void testStrip_trailingWhitespace() {
        // Test for string with trailing whitespaces
        String input = "abc  ";
        String output = StringUtils.strip(input);
        assertEquals("abc", output);
    }
    
    @Test
    public void testStrip_bothWhitespace() {
        // Test for string with both leading and trailing whitespaces
        String input = " abc ";
        String output = StringUtils.strip(input);
        assertEquals("abc", output);
    }
    
    @Test
    public void testStrip_internalWhitespace() {
        // Test for string with internal spaces
        String input = " ab c ";
        String output = StringUtils.strip(input);
        assertEquals("ab c", output);
    }







    @Test
    public void testSplitByWhitespace() {
        String str = "abc def";
        String[] result = StringUtils.split(str);
        assertArrayEquals(new String[]{"abc", "def"}, result);
    }

    @Test
    public void testSplitByCharSeparator() {
        String str = "a.b.c";
        String[] result = StringUtils.split(str, '.');
        assertArrayEquals(new String[]{"a", "b", "c"}, result);
    }

    @Test
    public void testSplitByCharSeparatorWithAdjacentSeparators() {
        String str = "a..b.c";
        String[] result = StringUtils.split(str, '.');
        assertArrayEquals(new String[]{"a", "b", "c"}, result);
    }

    @Test
    public void testSplitByStringSeparator() {
        String str = "abc  def";
        String[] result = StringUtils.split(str, " ");
        assertArrayEquals(new String[]{"abc", "def"}, result);
    }

    @Test
    public void testSplitByStringSeparatorWithMax() {
        String str = "ab:cd:ef";
        String[] result = StringUtils.split(str, ":", 2);
        assertArrayEquals(new String[]{"ab", "cd:ef"}, result);
    }

    @Test
    public void testSplitNullString() {
        String str = null;
        String[] result = StringUtils.split(str);
        assertNull(result);
    }

    @Test
    public void testSplitEmptyString() {
        String str = "";
        String[] result = StringUtils.split(str);
        assertArrayEquals(new String[]{}, result);
    }







    @Test
    public void testSplitByWholeSeparatorNullString() {
        String str = null;
        String[] result = StringUtils.splitByWholeSeparator(str, ",");
        assertNull(result);
    }

    @Test
    public void testSplitByWholeSeparatorEmptyString() {
        String str = "";
        String[] result = StringUtils.splitByWholeSeparator(str, ",");
        assertEquals(0, result.length);
    }

    @Test
    public void testSplitByWholeSeparatorNullSeparator() {
        String str = "ab de fg";
        String[] result = StringUtils.splitByWholeSeparator(str, null);
        assertEquals(3, result.length);
        assertArrayEquals(new String[] {"ab", "de", "fg"}, result);
    }

    @Test
    public void testSplitByWholeSeparator() {
        String str = "ab:cd:ef";
        String[] result = StringUtils.splitByWholeSeparator(str, ":");
        assertEquals(3, result.length);
        assertArrayEquals(new String[] {"ab", "cd", "ef"}, result);
    }

    @Test
    public void testSplitByWholeSeparatorMaxSubstrings() {
        String str = "ab:cd:ef";
        String[] result = StringUtils.splitByWholeSeparator(str, ":", 2);
        assertEquals(2, result.length);
        assertArrayEquals(new String[] {"ab", "cd:ef"}, result);
    }

    @Test
    public void testSplitByWholeSeparatorMaxSubstringsExceeded() {
        String str = "ab-!-cd-!-ef";
        String[] result = StringUtils.splitByWholeSeparator(str, "-!-", 2);
        assertEquals(2, result.length);
        assertArrayEquals(new String[] {"ab", "cd-!-ef"}, result);
    }





    @Test
    public void testRemoveStartChar() {
        // Test with null string
        assertNull(StringUtils.removeStart(null, '/'));

        // Test with empty string
        assertEquals("", StringUtils.removeStart("", '/'));

        // Test with string not starting with the specified char
        assertEquals("path", StringUtils.removeStart("path", '/'));

        // Test with string starting with the specified char
        assertEquals("path", StringUtils.removeStart("/path", '/'));
    }

    @Test
    public void testRemoveStartString() {
        // Test with null string
        assertNull(StringUtils.removeStart(null, "www."));

        // Test with empty string
        assertEquals("", StringUtils.removeStart("", "www."));

        // Test with string not starting with the specified string
        assertEquals("domain.com", StringUtils.removeStart("domain.com", "www."));

        // Test with string starting with the specified string
        assertEquals("domain.com", StringUtils.removeStart("www.domain.com", "www."));

        // Test with empty remove string
        assertEquals("abc", StringUtils.removeStart("abc", ""));
    }









    @Test
    public void testIsAlphaSpaceWithAlphaAndSpace() {
        String str = "hello world";
        assertTrue(StringUtils.isAlphaSpace(str));
    }

    @Test
    public void testIsAlphaSpaceWithAlpha() {
        String str = "helloworld";
        assertTrue(StringUtils.isAlphaSpace(str));
    }

    @Test
    public void testIsAlphaSpaceWithNonAlpha() {
        String str = "hello2world";
        assertFalse(StringUtils.isAlphaSpace(str));
    }

    @Test
    public void testIsAlphaSpaceWithNull() {
        String str = null;
        assertFalse(StringUtils.isAlphaSpace(str));
    }

    @Test
    public void testIsAlphaSpaceWithEmpty() {
        String str = "";
        assertTrue(StringUtils.isAlphaSpace(str));
    }

    @Test
    public void testIsAlphaSpaceWithSpaceOnly() {
        String str = "     ";
        assertTrue(StringUtils.isAlphaSpace(str));
    }









    @Test
    public void testNormalizeSpaceWithNull() {
        String input = null;
        String result = StringUtils.normalizeSpace(input);
        assertNull(result);
    }

    @Test
    public void testNormalizeSpaceWithEmptyString() {
        String input = "";
        String result = StringUtils.normalizeSpace(input);
        assertEquals("", result);
    }

    @Test
    public void testNormalizeSpaceWithOnlySpaces() {
        String input = "    ";
        String result = StringUtils.normalizeSpace(input);
        assertEquals("", result);
    }

    @Test
    public void testNormalizeSpaceWithMultipleSpaces() {
        String input = "Hello    World";
        String result = StringUtils.normalizeSpace(input);
        assertEquals("Hello World", result);
    }

    @Test
    public void testNormalizeSpaceWithTabAndNewline() {
        String input = "Hello\t\nWorld";
        String result = StringUtils.normalizeSpace(input);
        assertEquals("Hello World", result);
    }

    @Test
    public void testNormalizeSpaceWithLeadingAndTrailingSpaces() {
        String input = "   Hello World   ";
        String result = StringUtils.normalizeSpace(input);
        assertEquals("Hello World", result);
    }

    @Test
    public void testNormalizeSpaceWithNoExtraSpaces() {
        String input = "Hello World";
        String result = StringUtils.normalizeSpace(input);
        assertEquals("Hello World", result);
    }







    @Test
    public void testSubstringBeforeWithChar() {
        String testString = "abc";
        int separator = 'b';
        String result = StringUtils.substringBefore(testString, separator);
        assertEquals("a", result);

        separator = 'd';
        result = StringUtils.substringBefore(testString, separator);
        assertEquals("abc", result);

        testString = "";
        result = StringUtils.substringBefore(testString, separator);
        assertEquals("", result);

        testString = null;
        result = StringUtils.substringBefore(testString, separator);
        assertNull(result);
    }

    @Test
    public void testSubstringBeforeWithString() {
        String testString = "abc";
        String separator = "b";
        String result = StringUtils.substringBefore(testString, separator);
        assertEquals("a", result);

        separator = "d";
        result = StringUtils.substringBefore(testString, separator);
        assertEquals("abc", result);

        separator = "";
        result = StringUtils.substringBefore(testString, separator);
        assertEquals("", result);

        separator = null;
        result = StringUtils.substringBefore(testString, separator);
        assertEquals("abc", result);

        testString = "";
        result = StringUtils.substringBefore(testString, separator);
        assertEquals("", result);

        testString = null;
        result = StringUtils.substringBefore(testString, separator);
        assertNull(result);
    }





    @Test
    public void trimToNull_NullString() {
        String str = null;
        String result = StringUtils.trimToNull(str);
        assertNull(result);
    }
    
    @Test
    public void trimToNull_EmptyString() {
        String str = "";
        String result = StringUtils.trimToNull(str);
        assertNull(result);
    }
    
    @Test
    public void trimToNull_WhiteSpaceString() {
        String str = "     ";
        String result = StringUtils.trimToNull(str);
        assertNull(result);
    }
    
    @Test
    public void trimToNull_ValidString() {
        String str = "abc";
        String result = StringUtils.trimToNull(str);
        assertEquals("abc", result);
    }
    
    @Test
    public void trimToNull_StringWithSpaces() {
        String str = "    abc    ";
        String result = StringUtils.trimToNull(str);
        assertEquals("abc", result);
    }







    @Test
    public void testSwapCase() {
        assertNull(StringUtils.swapCase(null));
        assertEquals("", StringUtils.swapCase(""));
        assertEquals("tHE DOG HAS A bone", StringUtils.swapCase("The dog has a BONE"));
        assertEquals("12345", StringUtils.swapCase("12345"));
        assertEquals(" \t", StringUtils.swapCase(" \t"));
    }

    @Test
    public void testSwapCaseWithUnicodeCharacters() {
        // Testing with Unicode characters
        assertEquals("ǅǆ", StringUtils.swapCase("Ǆǅ"));
    }

    @Test
    public void testSwapCaseWithEmptyAndWhitespace() {
        // Testing with empty strings and whitespaces
        assertEquals("", StringUtils.swapCase(""));
        assertEquals(" ", StringUtils.swapCase(" "));
        assertEquals("\t", StringUtils.swapCase("\t"));
        assertEquals("\n", StringUtils.swapCase("\n"));
        assertEquals("\r", StringUtils.swapCase("\r"));
    }







    @Test
    public void testReplaceIgnoreCase_nullText() {
        assertNull(StringUtils.replaceIgnoreCase(null, "test", "check"));
    }

    @Test
    public void testReplaceIgnoreCase_emptyText() {
        assertEquals("", StringUtils.replaceIgnoreCase("", "test", "check"));
    }

    @Test
    public void testReplaceIgnoreCase_nullSearchString() {
        assertEquals("test", StringUtils.replaceIgnoreCase("test", null, "check"));
    }

    @Test
    public void testReplaceIgnoreCase_nullReplacement() {
        assertEquals("test", StringUtils.replaceIgnoreCase("test", "test", null));
    }

    @Test
    public void testReplaceIgnoreCase_emptySearchString() {
        assertEquals("test", StringUtils.replaceIgnoreCase("test", "", "check"));
    }

    @Test
    public void testReplaceIgnoreCase_searchStringNotFound() {
        assertEquals("test", StringUtils.replaceIgnoreCase("test", "demo", "check"));
    }

    @Test
    public void testReplaceIgnoreCase_replacement() {
        assertEquals("check", StringUtils.replaceIgnoreCase("test", "test", "check"));
    }

    @Test
    public void testReplaceIgnoreCase_caseInsensitiveReplacement() {
        assertEquals("check", StringUtils.replaceIgnoreCase("test", "TEST", "check"));
    }

    @Test
    public void testReplaceIgnoreCase_maxZero() {
        assertEquals("test", StringUtils.replaceIgnoreCase("test", "test", "check", 0));
    }

    @Test
    public void testReplaceIgnoreCase_maxLessThanZero() {
        assertEquals("check", StringUtils.replaceIgnoreCase("test", "test", "check", -1));
    }

    @Test
    public void testReplaceIgnoreCase_maxGreaterThanZero() {
        assertEquals("checkcheck", StringUtils.replaceIgnoreCase("testtest", "test", "check", 2));
    }

    @Test
    public void testReplaceIgnoreCase_maxGreaterThanOccurrences() {
        assertEquals("checkcheck", StringUtils.replaceIgnoreCase("testtest", "test", "check", 5));
    }











    @Test
    public void testCompareWithNulls() {
        assertEquals(0, StringUtils.compare(null, null));
        assertTrue(StringUtils.compare(null, "a") < 0);
        assertTrue(StringUtils.compare("a", null) > 0);
    }

    @Test
    public void testCompareWithNonNulls() {
        assertEquals(0, StringUtils.compare("abc", "abc"));
        assertTrue(StringUtils.compare("a", "b") < 0);
        assertTrue(StringUtils.compare("b", "a") > 0);
        assertTrue(StringUtils.compare("a", "B") > 0);
        assertTrue(StringUtils.compare("ab", "abc") < 0);
    }

    @Test
    public void testCompareWithNullsConsideringNullsLess() {
        assertEquals(0, StringUtils.compare(null, null, true));
        assertTrue(StringUtils.compare(null, "a", true) < 0);
        assertTrue(StringUtils.compare("a", null, true) > 0);
    }

    @Test
    public void testCompareWithNullsConsideringNullsGreater() {
        assertEquals(0, StringUtils.compare(null, null, false));
        assertTrue(StringUtils.compare(null, "a", false) > 0);
        assertTrue(StringUtils.compare("a", null, false) < 0);
    }

    @Test
    public void testCompareWithNonNullsConsideringNullsLess() {
        assertEquals(0, StringUtils.compare("abc", "abc", true));
        assertTrue(StringUtils.compare("a", "b", true) < 0);
        assertTrue(StringUtils.compare("b", "a", true) > 0);
        assertTrue(StringUtils.compare("a", "B", true) > 0);
        assertTrue(StringUtils.compare("ab", "abc", true) < 0);
    }

    @Test
    public void testCompareWithNonNullsConsideringNullsGreater() {
        assertEquals(0, StringUtils.compare("abc", "abc", false));
        assertTrue(StringUtils.compare("a", "b", false) < 0);
        assertTrue(StringUtils.compare("b", "a", false) > 0);
        assertTrue(StringUtils.compare("a", "B", false) > 0);
        assertTrue(StringUtils.compare("ab", "abc", false) < 0);
    }





    @Test
    public void testRemovePatternWithNullSource() {
        assertNull(StringUtils.removePattern(null, "regex"));
    }

    @Test
    public void testRemovePatternWithNullRegex() {
        String source = "any";
        assertEquals("any", StringUtils.removePattern(source, null));
    }

    @Test
    public void testRemovePatternWithMatch() {
        String source = "A<__>\n<__>B";
        String regex = "<.*>";
        assertEquals("AB", StringUtils.removePattern(source, regex));
    }

    @Test
    public void testRemovePatternWithNoMatch() {
        String source = "ABCabc123";
        String regex = "[a-z]";
        assertEquals("ABC123", StringUtils.removePattern(source, regex));
    }







    @Test
    public void testGetIfBlank_NullString() {
        Supplier<String> mockSupplier = mock(Supplier.class);
        when(mockSupplier.get()).thenReturn("NULL");
        String result = StringUtils.getIfBlank(null, mockSupplier);
        assertEquals("NULL", result);
    }

    @Test
    public void testGetIfBlank_EmptyString() {
        Supplier<String> mockSupplier = mock(Supplier.class);
        when(mockSupplier.get()).thenReturn("NULL");
        String result = StringUtils.getIfBlank("", mockSupplier);
        assertEquals("NULL", result);
    }

    @Test
    public void testGetIfBlank_WhitespaceString() {
        Supplier<String> mockSupplier = mock(Supplier.class);
        when(mockSupplier.get()).thenReturn("NULL");
        String result = StringUtils.getIfBlank(" ", mockSupplier);
        assertEquals("NULL", result);
    }

    @Test
    public void testGetIfBlank_NonEmptyString() {
        Supplier<String> mockSupplier = mock(Supplier.class);
        when(mockSupplier.get()).thenReturn("NULL");
        String result = StringUtils.getIfBlank("bat", mockSupplier);
        assertEquals("bat", result);
    }

    @Test
    public void testGetIfBlank_NullSupplier() {
        String result = StringUtils.getIfBlank("", null);
        assertNull(result);
    }

    @Test
    public void testGetIfBlank_SupplierReturnsNull() {
        Supplier<String> mockSupplier = mock(Supplier.class);
        when(mockSupplier.get()).thenReturn(null);
        String result = StringUtils.getIfBlank("", mockSupplier);
        assertNull(result);
    }





    @Test
    public void testRemoveIgnoreCase() {
        assertEquals("qd", StringUtils.removeIgnoreCase("queued", "ue"));
        assertEquals("queued", StringUtils.removeIgnoreCase("queued", "zz"));
        assertEquals("qd", StringUtils.removeIgnoreCase("quEUed", "UE"));
        assertEquals("queued", StringUtils.removeIgnoreCase("queued", "zZ"));
    }

    @Test
    public void testRemoveIgnoreCaseWithNullInput() {
        assertNull(StringUtils.removeIgnoreCase(null, "ue"));
        assertNull(StringUtils.removeIgnoreCase("queued", null));
        assertNull(StringUtils.removeIgnoreCase(null, null));
    }

    @Test
    public void testRemoveIgnoreCaseWithEmptyInput() {
        assertEquals("", StringUtils.removeIgnoreCase("", "ue"));
        assertEquals("queued", StringUtils.removeIgnoreCase("queued", ""));
        assertEquals("", StringUtils.removeIgnoreCase("", ""));
    }





    @Test
    public void testEndsWithAny_BothNull() {
        // Given
        CharSequence sequence = null;
        CharSequence[] searchStrings = null;

        // When
        boolean result = StringUtils.endsWithAny(sequence, searchStrings);

        // Then
        assertFalse(result);
    }

    @Test
    public void testEndsWithAny_SequenceNull() {
        // Given
        CharSequence sequence = null;
        CharSequence[] searchStrings = {"abc"};

        // When
        boolean result = StringUtils.endsWithAny(sequence, searchStrings);

        // Then
        assertFalse(result);
    }

    @Test
    public void testEndsWithAny_SearchStringsNull() {
        // Given
        CharSequence sequence = "abcxyz";
        CharSequence[] searchStrings = null;

        // When
        boolean result = StringUtils.endsWithAny(sequence, searchStrings);

        // Then
        assertFalse(result);
    }

    @Test
    public void testEndsWithAny_SearchStringsEmpty() {
        // Given
        CharSequence sequence = "abcxyz";
        CharSequence[] searchStrings = {""};

        // When
        boolean result = StringUtils.endsWithAny(sequence, searchStrings);

        // Then
        assertTrue(result);
    }

    @Test
    public void testEndsWithAny_ValidSuffix() {
        // Given
        CharSequence sequence = "abcxyz";
        CharSequence[] searchStrings = {"xyz"};

        // When
        boolean result = StringUtils.endsWithAny(sequence, searchStrings);

        // Then
        assertTrue(result);
    }

    @Test
    public void testEndsWithAny_InvalidSuffix() {
        // Given
        CharSequence sequence = "abcXYZ";
        CharSequence[] searchStrings = {"xyz"};

        // When
        boolean result = StringUtils.endsWithAny(sequence, searchStrings);

        // Then
        assertFalse(result);
    }

    @Test
    public void testEndsWithAny_MultipleSuffixes() {
        // Given
        CharSequence sequence = "abcXYZ";
        CharSequence[] searchStrings = {"def", "XYZ"};

        // When
        boolean result = StringUtils.endsWithAny(sequence, searchStrings);

        // Then
        assertTrue(result);
    }





    @Test
    public void testIsAlphanumericSpace_NullString() {
        // Test for null input
        assertFalse(StringUtils.isAlphanumericSpace(null));
    }

    @Test
    public void testIsAlphanumericSpace_EmptyString() {
        // Test for empty string
        assertTrue(StringUtils.isAlphanumericSpace(""));
    }

    @Test
    public void testIsAlphanumericSpace_SpaceOnlyString() {
        // Test for string with only spaces
        assertTrue(StringUtils.isAlphanumericSpace("   "));
    }

    @Test
    public void testIsAlphanumericSpace_AlphanumericString() {
        // Test for alphanumeric string
        assertTrue(StringUtils.isAlphanumericSpace("abc123"));
    }

    @Test
    public void testIsAlphanumericSpace_AlphanumericStringWithSpaces() {
        // Test for alphanumeric string with spaces
        assertTrue(StringUtils.isAlphanumericSpace("abc 123"));
    }

    @Test
    public void testIsAlphanumericSpace_NonAlphanumericString() {
        // Test for non-alphanumeric string
        assertFalse(StringUtils.isAlphanumericSpace("abc-123"));
    }








    @Test
    public void testAppendIfMissingBothNull() {
        assertNull(StringUtils.appendIfMissing(null, null));
    }

    @Test
    public void testAppendIfMissingStrNull() {
        assertEquals("xyz", StringUtils.appendIfMissing(null, "xyz"));
    }

    @Test
    public void testAppendIfMissingSuffixNull() {
        assertEquals("abc", StringUtils.appendIfMissing("abc", null));
    }

    @Test
    public void testAppendIfMissingNormal() {
        assertEquals("abcxyz", StringUtils.appendIfMissing("abc", "xyz"));
    }

    @Test
    public void testAppendIfMissingAlreadyEndsWithSuffix() {
        assertEquals("abcxyz", StringUtils.appendIfMissing("abcxyz", "xyz"));
    }

    @Test
    public void testAppendIfMissingWithMultipleSuffixes() {
        assertEquals("abcxyz", StringUtils.appendIfMissing("abc", "xyz", "ab", "cd"));
    }

    @Test
    public void testAppendIfMissingWithSuffixInSuffixes() {
        assertEquals("abc", StringUtils.appendIfMissing("abc", "xyz", "abc"));
    }

    @Test
    public void testAppendIfMissingWithSuffixesNull() {
        assertEquals("abcxyz", StringUtils.appendIfMissing("abc", "xyz", (CharSequence[]) null));
    }

    @Test
    public void testAppendIfMissingWithSuffixesEmpty() {
        assertEquals("abcxyz", StringUtils.appendIfMissing("abc", "xyz", ""));
    }

    @Test
    public void testAppendIfMissingWithSuffixEmpty() {
        assertEquals("abc", StringUtils.appendIfMissing("abc", ""));
    }





    @Test
    public void testContainsAny_CharArray() {
        // Test with null input
        assertFalse(StringUtils.containsAny(null, 'a', 'b'));
        assertFalse(StringUtils.containsAny("test", (char[]) null));

        // Test with empty input
        assertFalse(StringUtils.containsAny("", 'a', 'b'));
        assertFalse(StringUtils.containsAny("test", new char[]{}));

        // Test with valid input
        assertTrue(StringUtils.containsAny("test", 'e', 'b'));
        assertFalse(StringUtils.containsAny("test", 'a', 'b'));
    }

    @Test
    public void testContainsAny_CharSequence() {
        // Test with null input
        assertFalse(StringUtils.containsAny(null, "ab"));
        assertFalse(StringUtils.containsAny("test", (CharSequence) null));

        // Test with empty input
        assertFalse(StringUtils.containsAny("", "ab"));
        assertFalse(StringUtils.containsAny("test", ""));

        // Test with valid input
        assertTrue(StringUtils.containsAny("test", "et"));
        assertFalse(StringUtils.containsAny("test", "ab"));
    }

    @Test
    public void testContainsAny_CharSequenceArray() {
        // Test with null input
        assertFalse(StringUtils.containsAny(null, "ab", "cd"));
        assertFalse(StringUtils.containsAny("test", (CharSequence[]) null));

        // Test with empty input
        assertFalse(StringUtils.containsAny("", "ab", "cd"));
        assertFalse(StringUtils.containsAny("test"));

        // Test with valid input
        assertTrue(StringUtils.containsAny("test", "et", "cd"));
        assertFalse(StringUtils.containsAny("test", "ab", "cd"));
    }



    @Test
    public void testCenter_whenStringIsNull_shouldReturnNull() {
        String str = null;
        int size = 10;
        char padChar = ' ';

        String result = StringUtils.center(str, size, padChar);

        assertNull(result);
    }

    @Test
    public void testCenter_whenSizeIsLessThanZero_shouldReturnOriginalString() {
        String str = "test";
        int size = -1;
        char padChar = ' ';

        String result = StringUtils.center(str, size, padChar);

        assertEquals("test", result);
    }

    @Test
    public void testCenter_whenSizeIsLessThanStringLength_shouldReturnOriginalString() {
        String str = "test";
        int size = 2;
        char padChar = ' ';

        String result = StringUtils.center(str, size, padChar);

        assertEquals("test", result);
    }

    @Test
    public void testCenter_whenSizeIsGreaterThanStringLength_shouldReturnCenteredString() {
        String str = "test";
        int size = 10;
        char padChar = ' ';

        String result = StringUtils.center(str, size, padChar);

        assertEquals("   test   ", result);
    }

    @Test
    public void testCenter_whenSizeIsEqualToStringLength_shouldReturnOriginalString() {
        String str = "test";
        int size = 4;
        char padChar = ' ';

        String result = StringUtils.center(str, size, padChar);

        assertEquals("test", result);
    }

    @Test
    public void testCenter_whenPadCharIsNotSpace_shouldReturnCenteredStringWithPadChar() {
        String str = "test";
        int size = 10;
        char padChar = '-';

        String result = StringUtils.center(str, size, padChar);

        assertEquals("---test---", result);
    }





    @Test
    public void testSubstringAfterLast_WithSeparatorAsChar() {
        assertEquals("bc", StringUtils.substringAfterLast("abc", 'a'));
        assertEquals("a", StringUtils.substringAfterLast("abcba", 'b'));
        assertEquals("", StringUtils.substringAfterLast("abc", 'c'));
        assertEquals("", StringUtils.substringAfterLast("a", 'a'));
        assertEquals("", StringUtils.substringAfterLast("a", 'z'));
    }

    @Test
    public void testSubstringAfterLast_WithSeparatorAsString() {
        assertEquals("bc", StringUtils.substringAfterLast("abc", "a"));
        assertEquals("a", StringUtils.substringAfterLast("abcba", "b"));
        assertEquals("", StringUtils.substringAfterLast("abc", "c"));
        assertEquals("", StringUtils.substringAfterLast("a", "a"));
        assertEquals("", StringUtils.substringAfterLast("a", "z"));
    }

    @Test
    public void testSubstringAfterLast_WithEmptyString() {
        assertEquals("", StringUtils.substringAfterLast("", "a"));
        assertEquals("", StringUtils.substringAfterLast("", ""));
    }

    @Test
    public void testSubstringAfterLast_WithNullString() {
        assertNull(StringUtils.substringAfterLast(null, "a"));
        assertNull(StringUtils.substringAfterLast(null, null));
    }

    @Test
    public void testSubstringAfterLast_WithNullSeparator() {
        assertEquals("", StringUtils.substringAfterLast("a", null));
    }

    @Test
    public void testSubstringAfterLast_WithEmptySeparator() {
        assertEquals("", StringUtils.substringAfterLast("a", ""));
    }








    @Test
    public void toRootLowerCase_NullInput_ReturnsNull() {
        // Arrange
        String source = null;

        // Act
        String actual = StringUtils.toRootLowerCase(source);

        // Assert
        assertNull(actual);
    }

    @Test
    public void toRootLowerCase_EmptyString_ReturnsEmptyString() {
        // Arrange
        String source = "";

        // Act
        String actual = StringUtils.toRootLowerCase(source);

        // Assert
        assertEquals("", actual);
    }

    @Test
    public void toRootLowerCase_LowerCaseInput_ReturnsSameString() {
        // Arrange
        String source = "lowercase";

        // Act
        String actual = StringUtils.toRootLowerCase(source);

        // Assert
        assertEquals(source, actual);
    }

    @Test
    public void toRootLowerCase_UpperCaseInput_ReturnsLowerCaseString() {
        // Arrange
        String source = "UPPERCASE";

        // Act
        String actual = StringUtils.toRootLowerCase(source);

        // Assert
        assertEquals(source.toLowerCase(Locale.ROOT), actual);
    }

    @Test
    public void toRootLowerCase_MixedCaseInput_ReturnsLowerCaseString() {
        // Arrange
        String source = "MiXeDCaSe";

        // Act
        String actual = StringUtils.toRootLowerCase(source);

        // Assert
        assertEquals(source.toLowerCase(Locale.ROOT), actual);
    }

    @Test
    public void toRootLowerCase_NumericInput_ReturnsSameString() {
        // Arrange
        String source = "12345";

        // Act
        String actual = StringUtils.toRootLowerCase(source);

        // Assert
        assertEquals(source, actual);
    }

    @Test
    public void toRootLowerCase_SpecialCharactersInput_ReturnsSameString() {
        // Arrange
        String source = "@#!$%^&*()";

        // Act
        String actual = StringUtils.toRootLowerCase(source);

        // Assert
        assertEquals(source, actual);
    }






    @Test
    @DisplayName("Test contains method with null values")
    public void testContainsWithNullValues() {
        CharSequence seq = null;
        CharSequence searchSeq = null;

        boolean result = StringUtils.contains(seq, searchSeq);

        assertFalse(result, "Expected false for null inputs");
    }

    @Test
    @DisplayName("Test contains method with empty string values")
    public void testContainsWithEmptyValues() {
        CharSequence seq = "";
        CharSequence searchSeq = "";

        boolean result = StringUtils.contains(seq, searchSeq);

        assertTrue(result, "Expected true for empty inputs");
    }

    @Test
    @DisplayName("Test contains method for non-contained string")
    public void testContainsForNonContainedString() {
        CharSequence seq = "abc";
        CharSequence searchSeq = "z";

        boolean result = StringUtils.contains(seq, searchSeq);

        assertFalse(result, "Expected false for non-contained string");
    }

    @Test
    @DisplayName("Test contains method for contained string")
    public void testContainsForContainedString() {
        CharSequence seq = "abc";
        CharSequence searchSeq = "a";

        boolean result = StringUtils.contains(seq, searchSeq);

        assertTrue(result, "Expected true for contained string");
    }

    @Test
    @DisplayName("Test contains method for null seq and non-null searchSeq")
    public void testContainsForNullSeqNonNullSearchSeq() {
        CharSequence seq = null;
        CharSequence searchSeq = "a";

        boolean result = StringUtils.contains(seq, searchSeq);

        assertFalse(result, "Expected false for null seq and non-null searchSeq");
    }

    @Test
    @DisplayName("Test contains method for non-null seq and null searchSeq")
    public void testContainsForNonNullSeqNullSearchSeq() {
        CharSequence seq = "abc";
        CharSequence searchSeq = null;

        boolean result = StringUtils.contains(seq, searchSeq);

        assertFalse(result, "Expected false for non-null seq and null searchSeq");
    }




    @Test
    public void testGetJaroWinklerDistance_NullStrings() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.getJaroWinklerDistance(null, null));
    }

    @Test
    public void testGetJaroWinklerDistance_EmptyStrings() {
        double result = StringUtils.getJaroWinklerDistance("", "");
        assertEquals(0.0, result);
    }

    @Test
    public void testGetJaroWinklerDistance_OneEmptyString() {
        double result1 = StringUtils.getJaroWinklerDistance("", "a");
        double result2 = StringUtils.getJaroWinklerDistance("aaapppp", "");
        assertEquals(0.0, result1);
        assertEquals(0.0, result2);
    }

    @Test
    public void testGetJaroWinklerDistance_SimilarStrings() {
        double result = StringUtils.getJaroWinklerDistance("frog", "fog");
        assertEquals(0.93, result);
    }

    @Test
    public void testGetJaroWinklerDistance_DifferentStrings() {
        double result = StringUtils.getJaroWinklerDistance("fly", "ant");
        assertEquals(0.0, result);
    }

    @Test
    public void testGetJaroWinklerDistance_LongStrings() {
        double result = StringUtils.getJaroWinklerDistance("elephant", "hippo");
        assertEquals(0.44, result);
    }

    @Test
    public void testGetJaroWinklerDistance_ReversedStrings() {
        double result = StringUtils.getJaroWinklerDistance("hippo", "elephant");
        assertEquals(0.44, result);
    }

    @Test
    public void testGetJaroWinklerDistance_NoCommonCharacters() {
        double result = StringUtils.getJaroWinklerDistance("hippo", "zzzzzzzz");
        assertEquals(0.0, result);
    }

    @Test
    public void testGetJaroWinklerDistance_SlightDifference() {
        double result = StringUtils.getJaroWinklerDistance("hello", "hallo");
        assertEquals(0.88, result);
    }

    @Test
    public void testGetJaroWinklerDistance_CompanyNames() {
        double result = StringUtils.getJaroWinklerDistance("ABC Corporation", "ABC Corp");
        assertEquals(0.93, result);
    }

    @Test
    public void testGetJaroWinklerDistance_ComplexNames() {
        double result = StringUtils.getJaroWinklerDistance("D N H Enterprises Inc", "D & H Enterprises, Inc.");
        assertEquals(0.95, result);
    }

    @Test
    public void testGetJaroWinklerDistance_SlightTypos() {
        double result = StringUtils.getJaroWinklerDistance("PENNSYLVANIA", "PENNCISYLVNIA");
        assertEquals(0.88, result);
    }




    @Test
    public void testAbbreviateMiddle_NullString() {
        String str = null;
        String result = StringUtils.abbreviateMiddle(str, ".", 4);
        assertNull(result);
    }

    @Test
    public void testAbbreviateMiddle_NullMiddle() {
        String str = "abcdef";
        String result = StringUtils.abbreviateMiddle(str, null, 4);
        assertEquals("abcdef", result);
    }

    @Test
    public void testAbbreviateMiddle_ZeroLength() {
        String str = "abcdef";
        String result = StringUtils.abbreviateMiddle(str, ".", 0);
        assertEquals("abcdef", result);
    }

    @Test
    public void testAbbreviateMiddle_LengthLessThanString() {
        String str = "abcdef";
        String result = StringUtils.abbreviateMiddle(str, ".", 4);
        assertEquals("ab.f", result);
    }

    @Test
    public void testAbbreviateMiddle_LengthEqualToString() {
        String str = "abc";
        String result = StringUtils.abbreviateMiddle(str, ".", 3);
        assertEquals("abc", result);
    }

    @Test
    public void testAbbreviateMiddle_LengthGreaterThanString() {
        String str = "abc";
        String result = StringUtils.abbreviateMiddle(str, ".", 4);
        assertEquals("abc", result);
    }

    @Test
    public void testAbbreviateMiddle_LengthLessThanMiddlePlusTwo() {
        String str = "abcdef";
        String result = StringUtils.abbreviateMiddle(str, "...", 4);
        assertEquals("abcdef", result);
    }

    @Test
    public void testAbbreviateMiddle_LengthEqualToMiddlePlusTwo() {
        String str = "abcdef";
        String result = StringUtils.abbreviateMiddle(str, "..", 4);
        assertEquals("a..f", result);
    }

    @Test
    public void testAbbreviateMiddle_LengthGreaterThanMiddlePlusTwo() {
        String str = "abcdef";
        String result = StringUtils.abbreviateMiddle(str, "..", 5);
        assertEquals("a..ef", result);
    }





    @Test
    public void chompShouldReturnNullWhenNullInput() {
        assertNull(StringUtils.chomp(null));
    }

    @Test
    public void chompShouldReturnEmptyStringWhenEmptyInput() {
        assertEquals("", StringUtils.chomp(""));
    }

    @Test
    public void chompShouldRemoveNewlineAtEnd() {
        assertEquals("abc", StringUtils.chomp("abc\n"));
    }

    @Test
    public void chompShouldRemoveCarriageReturnAtEnd() {
        assertEquals("abc", StringUtils.chomp("abc\r"));
    }

    @Test
    public void chompShouldRemoveCarriageReturnNewlineAtEnd() {
        assertEquals("abc", StringUtils.chomp("abc\r\n"));
    }

    @Test
    public void chompShouldNotRemoveNewlineInMiddle() {
        assertEquals("abc\nabc", StringUtils.chomp("abc\nabc"));
    }

    @Test
    public void chompShouldRemoveOnlyLastNewlineInSequence() {
        assertEquals("abc\r\n", StringUtils.chomp("abc\r\n\r\n"));
    }

    @Test
    public void chompShouldReturnEmptyStringWhenOnlyNewline() {
        assertEquals("", StringUtils.chomp("\n"));
    }

    @Test
    public void chompShouldReturnEmptyStringWhenOnlyCarriageReturn() {
        assertEquals("", StringUtils.chomp("\r"));
    }

    @Test
    public void chompShouldReturnEmptyStringWhenOnlyCarriageReturnNewline() {
        assertEquals("", StringUtils.chomp("\r\n"));
    }

    @Test
    public void chompShouldReturnSameStringWhenNoNewlineOrCarriageReturn() {
        assertEquals("abc", StringUtils.chomp("abc"));
    }





    @Test
    public void testLastIndexOfWithNullSeq() {
        assertEquals(-1, StringUtils.lastIndexOf(null, "test"));
    }

    @Test
    public void testLastIndexOfWithNullSearchSeq() {
        assertEquals(-1, StringUtils.lastIndexOf("test", null));
    }

    @Test
    public void testLastIndexOfWithEmptyStrings() {
        assertEquals(0, StringUtils.lastIndexOf("", ""));
    }

    @Test
    public void testLastIndexOfSuccess() {
        assertEquals(7, StringUtils.lastIndexOf("aabaabaa", "a"));
    }

    @Test
    public void testLastIndexOfWithStartPosSuccess() {
        assertEquals(4, StringUtils.lastIndexOf("aabaabaa", "ab", 5));
    }

    @Test
    public void testLastIndexOfWithStartPosNegative() {
        assertEquals(-1, StringUtils.lastIndexOf("aabaabaa", "ab", -1));
    }

    @Test
    public void testLastIndexOfWithCharSuccess() {
        assertEquals(7, StringUtils.lastIndexOf("aabaabaa", 'a'));
    }

    @Test
    public void testLastIndexOfWithCharAndStartPosSuccess() {
        assertEquals(4, StringUtils.lastIndexOf("aabaabaa", 'a', 5));
    }

    @Test
    public void testLastIndexOfWithCharAndStartPosNegative() {
        assertEquals(-1, StringUtils.lastIndexOf("aabaabaa", 'a', -1));
    }






    @Test
    public void testGetLevenshteinDistance() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.getLevenshteinDistance(null, "test"));
        assertThrows(IllegalArgumentException.class, () -> StringUtils.getLevenshteinDistance("test", null));
        assertEquals(0, StringUtils.getLevenshteinDistance("", ""));
        assertEquals(1, StringUtils.getLevenshteinDistance("", "a"));
        assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", ""));
        assertEquals(1, StringUtils.getLevenshteinDistance("frog", "fog"));
        assertEquals(3, StringUtils.getLevenshteinDistance("fly", "ant"));
        assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo"));
        assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant"));
        assertEquals(8, StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz"));
        assertEquals(1, StringUtils.getLevenshteinDistance("hello", "hallo"));
    }

    @Test
    public void testGetLevenshteinDistanceWithThreshold() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.getLevenshteinDistance(null, "test", 1));
        assertThrows(IllegalArgumentException.class, () -> StringUtils.getLevenshteinDistance("test", null, 1));
        assertThrows(IllegalArgumentException.class, () -> StringUtils.getLevenshteinDistance("test", "test", -1));
        assertEquals(0, StringUtils.getLevenshteinDistance("", "", 0));
        assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 8));
        assertEquals(7, StringUtils.getLevenshteinDistance("aaapppp", "", 7));
        assertEquals(-1, StringUtils.getLevenshteinDistance("aaapppp", "", 6));
        assertEquals(7, StringUtils.getLevenshteinDistance("elephant", "hippo", 7));
        assertEquals(-1, StringUtils.getLevenshteinDistance("elephant", "hippo", 6));
        assertEquals(7, StringUtils.getLevenshteinDistance("hippo", "elephant", 7));
        assertEquals(-1, StringUtils.getLevenshteinDistance("hippo", "elephant", 6));
    }




    @DisplayName("Test endsWith() method")
    @Test
    public void testEndsWith() {
        // Test when both parameters are null
        assertTrue(StringUtils.endsWith(null, null));

        // Test when str is null and suffix is not null
        assertFalse(StringUtils.endsWith(null, "def"));

        // Test when str is not null and suffix is null
        assertFalse(StringUtils.endsWith("abcdef", null));

        // Test when str ends with suffix
        assertTrue(StringUtils.endsWith("abcdef", "def"));

        // Test when str does not end with suffix
        assertFalse(StringUtils.endsWith("abcdef", "abc"));

        // Test when str ends with suffix but with different case
        assertFalse(StringUtils.endsWith("ABCDEF", "def"));

        // Test when str does not end with suffix but with different case
        assertFalse(StringUtils.endsWith("ABCDEF", "cde"));

        // Test when suffix is empty string
        assertTrue(StringUtils.endsWith("ABCDEF", ""));

        // Test when str is empty string and suffix is not empty
        assertFalse(StringUtils.endsWith("", "abc"));

        // Test when both str and suffix are empty strings
        assertTrue(StringUtils.endsWith("", ""));
    }




    @Test
    public void testReplaceEach() {
        // Text is null
        assertNull(StringUtils.replaceEach(null, new String[]{"a"}, new String[]{"b"}));

        // Text is empty
        assertEquals(StringUtils.replaceEach("", new String[]{"a"}, new String[]{"b"}), "");

        // SearchList is null
        assertEquals(StringUtils.replaceEach("aba", null, new String[]{"b"}), "aba");

        // ReplacementList is null
        assertEquals(StringUtils.replaceEach("aba", new String[]{"a"}, null), "aba");

        // SearchList is empty
        assertEquals(StringUtils.replaceEach("aba", new String[]{}, new String[]{"b"}), "aba");

        // ReplacementList is empty
        assertEquals(StringUtils.replaceEach("aba", new String[]{"a"}, new String[]{}), "aba");

        // SearchList has null value
        assertEquals(StringUtils.replaceEach("aba", new String[]{null}, new String[]{"b"}), "aba");

        // ReplacementList has null value
        assertEquals(StringUtils.replaceEach("aba", new String[]{"a"}, new String[]{null}), "aba");

        // SearchList and ReplacementList have different lengths
        assertThrows(IllegalArgumentException.class, () -> {
            StringUtils.replaceEach("aba", new String[]{"a", "b"}, new String[]{"b"});
        });

        // Normal case
        assertEquals(StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"w", "t"}), "wcte");

        // Non repeating replacements
        assertEquals(StringUtils.replaceEach("abcde", new String[]{"ab", "d"}, new String[]{"d", "t"}), "dcte");
    }





    @Test
    public void testMatchesWithEqualStrings() {
        StringUtils stringUtils = new StringUtils();
        int[] expected = new int[]{5, 0, 5, 5};
        assertArrayEquals(expected, stringUtils.matches("hello", "hello"));
    }

    @Test
    public void testMatchesWithOneCharacterDifference() {
        StringUtils stringUtils = new StringUtils();
        int[] expected = new int[]{4, 1, 0, 5};
        assertArrayEquals(expected, stringUtils.matches("hello", "helli"));
    }

    @Test
    public void testMatchesWithCompletelyDifferentStrings() {
        StringUtils stringUtils = new StringUtils();
        int[] expected = new int[]{0, 0, 0, 5};
        assertArrayEquals(expected, stringUtils.matches("hello", "world"));
    }

    @Test
    public void testMatchesWithEmptyStrings() {
        StringUtils stringUtils = new StringUtils();
        int[] expected = new int[]{0, 0, 0, 0};
        assertArrayEquals(expected, stringUtils.matches("", ""));
    }

    @Test
    public void testMatchesWithNullStrings() {
        StringUtils stringUtils = new StringUtils();
        assertThrows(NullPointerException.class, () -> stringUtils.matches(null, null));
    }

    @Test
    public void testMatchesWithOneNullString() {
        StringUtils stringUtils = new StringUtils();
        assertThrows(NullPointerException.class, () -> stringUtils.matches("hello", null));
        assertThrows(NullPointerException.class, () -> stringUtils.matches(null, "hello"));
    }

    @Test
    public void testMatchesWithOneEmptyString() {
        StringUtils stringUtils = new StringUtils();
        int[] expected = new int[]{0, 0, 0, 5};
        assertArrayEquals(expected, stringUtils.matches("hello", ""));
        assertArrayEquals(expected, stringUtils.matches("", "hello"));
    }




    @Test
    public void whenNullString_thenIsAnyEmptyReturnsTrue() {
        // Given
        String nullString = null;

        // When
        boolean result = StringUtils.isAnyEmpty(nullString);

        // Then
        assertTrue(result);
    }

    @Test
    public void whenEmptyString_thenIsAnyEmptyReturnsTrue() {
        // Given
        String emptyString = "";

        // When
        boolean result = StringUtils.isAnyEmpty(emptyString);

        // Then
        assertTrue(result);
    }

    @Test
    public void whenNonEmptyString_thenIsAnyEmptyReturnsFalse() {
        // Given
        String nonEmptyString = "Non Empty String";

        // When
        boolean result = StringUtils.isAnyEmpty(nonEmptyString);

        // Then
        assertFalse(result);
    }

    @Test
    public void whenNullAndNonEmptyString_thenIsAnyEmptyReturnsTrue() {
        // Given
        String nullString = null;
        String nonEmptyString = "Non Empty String";

        // When
        boolean result = StringUtils.isAnyEmpty(nullString, nonEmptyString);

        // Then
        assertTrue(result);
    }

    @Test
    public void whenEmptyAndNonEmptyString_thenIsAnyEmptyReturnsTrue() {
        // Given
        String emptyString = "";
        String nonEmptyString = "Non Empty String";

        // When
        boolean result = StringUtils.isAnyEmpty(emptyString, nonEmptyString);

        // Then
        assertTrue(result);
    }

    @Test
    public void whenAllNonEmptyStrings_thenIsAnyEmptyReturnsFalse() {
        // Given
        String string1 = "String 1";
        String string2 = "String 2";
        String string3 = "String 3";

        // When
        boolean result = StringUtils.isAnyEmpty(string1, string2, string3);

        // Then
        assertFalse(result);
    }






    @Test
    public void compareIgnoreCaseTest() {
        assertEquals(0, StringUtils.compareIgnoreCase(null, null));
        assertNotEquals(0, StringUtils.compareIgnoreCase(null, "a"));
        assertNotEquals(0, StringUtils.compareIgnoreCase("a", null));
        assertEquals(0, StringUtils.compareIgnoreCase("abc", "abc"));
        assertEquals(0, StringUtils.compareIgnoreCase("abc", "ABC"));
        assertNotEquals(0, StringUtils.compareIgnoreCase("a", "b"));
        assertNotEquals(0, StringUtils.compareIgnoreCase("b", "a"));
        assertNotEquals(0, StringUtils.compareIgnoreCase("a", "B"));
        assertNotEquals(0, StringUtils.compareIgnoreCase("A", "b"));
        assertNotEquals(0, StringUtils.compareIgnoreCase("ab", "ABC"));
    }

    @Test
    public void compareIgnoreCaseTestWithNullIsLess() {
        assertEquals(0, StringUtils.compareIgnoreCase(null, null, true));
        assertNotEquals(0, StringUtils.compareIgnoreCase(null, "a", true));
        assertNotEquals(0, StringUtils.compareIgnoreCase(null, "a", false));
        assertNotEquals(0, StringUtils.compareIgnoreCase("a", null, true));
        assertNotEquals(0, StringUtils.compareIgnoreCase("a", null, false));
        assertEquals(0, StringUtils.compareIgnoreCase("abc", "abc", true));
        assertEquals(0, StringUtils.compareIgnoreCase("abc", "ABC", true));
        assertNotEquals(0, StringUtils.compareIgnoreCase("a", "b", true));
        assertNotEquals(0, StringUtils.compareIgnoreCase("b", "a", true));
        assertNotEquals(0, StringUtils.compareIgnoreCase("a", "B", true));
        assertNotEquals(0, StringUtils.compareIgnoreCase("A", "b", true));
        assertNotEquals(0, StringUtils.compareIgnoreCase("ab", "abc", true));
    }




    @Test
    public void testReverseDelimited_NullInput() {
        String str = null;
        char separatorChar = '.';
        assertNull(StringUtils.reverseDelimited(str, separatorChar));
    }

    @Test
    public void testReverseDelimited_EmptyInput() {
        String str = "";
        char separatorChar = '.';
        assertEquals("", StringUtils.reverseDelimited(str, separatorChar));
    }

    @Test
    public void testReverseDelimited_NoDelimiter() {
        String str = "abc";
        char separatorChar = '.';
        assertEquals("abc", StringUtils.reverseDelimited(str, separatorChar));
    }

    @Test
    public void testReverseDelimited_NormalCase() {
        String str = "a.b.c";
        char separatorChar = '.';
        assertEquals("c.b.a", StringUtils.reverseDelimited(str, separatorChar));
    }





    @Test
    public void testIsEmpty_WhenNull() {
        // Given
        CharSequence cs = null;

        // When
        boolean result = StringUtils.isEmpty(cs);

        // Then
        assertTrue(result, "IsEmpty should return true when the CharSequence is null");
    }

    @Test
    public void testIsEmpty_WhenEmpty() {
        // Given
        CharSequence cs = "";

        // When
        boolean result = StringUtils.isEmpty(cs);

        // Then
        assertTrue(result, "IsEmpty should return true when the CharSequence is empty");
    }

    @Test
    public void testIsEmpty_WhenNotEmpty() {
        // Given
        CharSequence cs = "hello";

        // When
        boolean result = StringUtils.isEmpty(cs);

        // Then
        assertFalse(result, "IsEmpty should return false when the CharSequence is not empty");
    }

    @Test
    public void testIsEmpty_WhenOnlySpaces() {
        // Given
        CharSequence cs = " ";

        // When
        boolean result = StringUtils.isEmpty(cs);

        // Then
        assertFalse(result, "IsEmpty should return false when the CharSequence is a space");
    }




    @Test
    public void testFirstNonEmpty_NullInput() {
        // Test for when the method receives a null input
        assertNull(StringUtils.firstNonEmpty(null));
    }

    @Test
    public void testFirstNonEmpty_EmptyInput() {
        // Test for when the method receives an empty input
        assertNull(StringUtils.firstNonEmpty());
    }

    @Test
    public void testFirstNonEmpty_AllNullValues() {
        // Test for when the method receives all null values
        assertNull(StringUtils.firstNonEmpty(null, null, null));
    }

    @Test
    public void testFirstNonEmpty_AllEmptyStrings() {
        // Test for when the method receives all empty strings
        assertNull(StringUtils.firstNonEmpty("", "", ""));
    }

    @Test
    public void testFirstNonEmpty_MixedValues() {
        // Test for when the method receives a mix of null, empty, and non-empty strings
        assertEquals("abc", StringUtils.firstNonEmpty(null, "", "abc"));
    }

    @Test
    public void testFirstNonEmpty_NonEmptyValues() {
        // Test for when the method receives only non-empty strings
        assertEquals("abc", StringUtils.firstNonEmpty("abc", "def", "ghi"));
    }




    @Test
    public void testDefaultIfEmpty_whenInputIsNull() {
        // Variable initialization
        String str = null;
        String defaultStr = "DEFAULT";

        // Test code
        String result = StringUtils.defaultIfEmpty(str, defaultStr);

        // Assertions
        assertEquals(defaultStr, result);
    }

    @Test
    public void testDefaultIfEmpty_whenInputIsEmpty() {
        // Variable initialization
        String str = "";
        String defaultStr = "DEFAULT";

        // Test code
        String result = StringUtils.defaultIfEmpty(str, defaultStr);

        // Assertions
        assertEquals(defaultStr, result);
    }

    @Test
    public void testDefaultIfEmpty_whenInputIsNotEmpty() {
        // Variable initialization
        String str = "NON EMPTY STRING";
        String defaultStr = "DEFAULT";

        // Test code
        String result = StringUtils.defaultIfEmpty(str, defaultStr);

        // Assertions
        assertEquals(str, result);
    }

    @Test
    public void testDefaultIfEmpty_whenDefaultIsNull() {
        // Variable initialization
        String str = "";
        String defaultStr = null;

        // Test code
        String result = StringUtils.defaultIfEmpty(str, defaultStr);

        // Assertions
        assertNull(result);
    }

    @Test
    public void testDefaultIfEmpty_whenInputAndDefaultAreNull() {
        // Variable initialization
        String str = null;
        String defaultStr = null;

        // Test code
        String result = StringUtils.defaultIfEmpty(str, defaultStr);

        // Assertions
        assertNull(result);
    }

    @Test
    public void testDefaultIfEmpty_whenInputAndDefaultAreEmpty() {
        // Variable initialization
        String str = "";
        String defaultStr = "";

        // Test code
        String result = StringUtils.defaultIfEmpty(str, defaultStr);

        // Assertions
        assertEquals(defaultStr, result);
    }




    @Test
    public void testIsAsciiPrintable_withNullInput() {
        assertFalse(StringUtils.isAsciiPrintable(null));
    }

    @Test
    public void testIsAsciiPrintable_withEmptyInput() {
        assertTrue(StringUtils.isAsciiPrintable(""));
    }

    @Test
    public void testIsAsciiPrintable_withSpaceInput() {
        assertTrue(StringUtils.isAsciiPrintable(" "));
    }

    @Test
    public void testIsAsciiPrintable_withAsciiPrintableInput() {
        assertTrue(StringUtils.isAsciiPrintable("Ceki"));
    }

    @Test
    public void testIsAsciiPrintable_withNonAsciiPrintableInput() {
        assertFalse(StringUtils.isAsciiPrintable("Ceki G\u00fclc\u00fc"));
    }

    @Test
    public void testIsAsciiPrintable_withSpecialCharacters() {
        assertTrue(StringUtils.isAsciiPrintable("!ab-c~"));
    }

    @Test
    public void testIsAsciiPrintable_withUnicodeSpace() {
        assertTrue(StringUtils.isAsciiPrintable("\u0020"));
    }

    @Test
    public void testIsAsciiPrintable_withUnicodeExclamationMark() {
        assertTrue(StringUtils.isAsciiPrintable("\u0021"));
    }

    @Test
    public void testIsAsciiPrintable_withUnicodeTilde() {
        assertTrue(StringUtils.isAsciiPrintable("\u007e"));
    }

    @Test
    public void testIsAsciiPrintable_withUnicodeDelete() {
        assertFalse(StringUtils.isAsciiPrintable("\u007f"));
    }




    @Test
    public void whenStringIsNull_thenReturnsNull() {
        String str = null;
        int len = 5;
        String result = StringUtils.right(str, len);
        assertNull(result);
    }

    @Test
    public void whenLenIsNegative_thenReturnsEmptyString() {
        String str = "abc";
        int len = -5;
        String result = StringUtils.right(str, len);
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void whenInputStringIsEmpty_thenReturnsEmptyString() {
        String str = "";
        int len = 5;
        String result = StringUtils.right(str, len);
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void whenLenIsZero_thenReturnsEmptyString() {
        String str = "abc";
        int len = 0;
        String result = StringUtils.right(str, len);
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void whenLenIsLessThanStringLength_thenReturnsSubstring() {
        String str = "abc";
        int len = 2;
        String result = StringUtils.right(str, len);
        assertEquals("bc", result);
    }

    @Test
    public void whenLenIsEqualToStringLength_thenReturnsInputString() {
        String str = "abc";
        int len = 3;
        String result = StringUtils.right(str, len);
        assertEquals(str, result);
    }

    @Test
    public void whenLenIsGreaterThanStringLength_thenReturnsInputString() {
        String str = "abc";
        int len = 5;
        String result = StringUtils.right(str, len);
        assertEquals(str, result);
    }




    @Test
    public void testToCodePointsNull() {
        // Test for null input
        assertNull(StringUtils.toCodePoints(null));
    }

    @Test
    public void testToCodePointsEmpty() {
        // Test for empty string
        CharSequence cs = "";
        int[] expected = new int[0];
        assertArrayEquals(expected, StringUtils.toCodePoints(cs));
    }

    @Test
    public void testToCodePointsNonEmpty() {
        // Test for non-empty string
        CharSequence cs = "test";
        int[] expected = {116, 101, 115, 116};
        assertArrayEquals(expected, StringUtils.toCodePoints(cs));
    }

    @Test
    public void testToCodePointsSpecialCharacters() {
        // Test for string with special characters
        CharSequence cs = "!@#";
        int[] expected = {33, 64, 35};
        assertArrayEquals(expected, StringUtils.toCodePoints(cs));
    }

    @Test
    public void testToCodePointsUnicodeCharacters() {
        // Test for string with Unicode characters
        CharSequence cs = "\uD800\uDC00";
        int[] expected = {65536};
        assertArrayEquals(expected, StringUtils.toCodePoints(cs));
    }

    @Test
    public void testToCodePointsIsolatedSurrogate() {
        // Test for string with isolated surrogate
        CharSequence cs = "\uD800";
        int[] expected = {55296};
        assertArrayEquals(expected, StringUtils.toCodePoints(cs));
    }




    @Test
    public void testStripToNullWithNullInput() {
        assertNull(StringUtils.stripToNull(null));
    }

    @Test
    public void testStripToNullWithEmptyString() {
        assertNull(StringUtils.stripToNull(""));
    }

    @Test
    public void testStripToNullWithOnlySpaces() {
        assertNull(StringUtils.stripToNull("   "));
    }

    @Test
    public void testStripToNullWithNoSpaces() {
        assertEquals("abc", StringUtils.stripToNull("abc"));
    }

    @Test
    public void testStripToNullWithLeadingSpaces() {
        assertEquals("abc", StringUtils.stripToNull("  abc"));
    }

    @Test
    public void testStripToNullWithTrailingSpaces() {
        assertEquals("abc", StringUtils.stripToNull("abc  "));
    }

    @Test
    public void testStripToNullWithSurroundingSpaces() {
        assertEquals("abc", StringUtils.stripToNull(" abc "));
    }

    @Test
    public void testStripToNullWithInternalSpaces() {
        assertEquals("ab c", StringUtils.stripToNull(" ab c "));
    }





    @Test
    public void testToRootUpperCase_whenNullString_shouldReturnNull() {
        String source = null;

        String result = StringUtils.toRootUpperCase(source);

        assertNull(result);
    }

    @Test
    public void testToRootUpperCase_whenEmptyString_shouldReturnEmptyString() {
        String source = "";

        String result = StringUtils.toRootUpperCase(source);

        assertEquals("", result);
    }

    @Test
    public void testToRootUpperCase_whenLowerCaseString_shouldReturnUpperCaseString() {
        String source = "lowercase";

        String result = StringUtils.toRootUpperCase(source);

        assertEquals("LOWERCASE", result);
    }

    @Test
    public void testToRootUpperCase_whenUpperCaseString_shouldReturnSameString() {
        String source = "UPPERCASE";

        String result = StringUtils.toRootUpperCase(source);

        assertEquals("UPPERCASE", result);
    }

    @Test
    public void testToRootUpperCase_whenMixedCaseString_shouldReturnUpperCaseString() {
        String source = "MixedCase";

        String result = StringUtils.toRootUpperCase(source);

        assertEquals("MIXEDCASE", result);
    }

    @Test
    public void testToRootUpperCase_whenNonAlphabetString_shouldReturnSameString() {
        String source = "1234!@#$";

        String result = StringUtils.toRootUpperCase(source);

        assertEquals("1234!@#$", result);
    }

    @Test
    public void testToRootUpperCase_whenStringWithSpaces_shouldReturnUpperCaseString() {
        String source = "string with spaces";

        String result = StringUtils.toRootUpperCase(source);

        assertEquals("STRING WITH SPACES", result);
    }

    @Test
    public void testToRootUpperCase_whenStringWithLocaleSpecificCharacters_shouldReturnUpperCaseString() {
        String source = "türkçe";

        String result = StringUtils.toRootUpperCase(source);

        assertEquals("TÜRKÇE", result);
    }






    @Test
    public void testReplaceCharsWhenStringIsNull() {
        String str = null;
        char searchChar = 'a';
        char replaceChar = 'b';
        assertNull(StringUtils.replaceChars(str, searchChar, replaceChar));
    }

    @Test
    public void testReplaceCharsWhenStringIsEmpty() {
        String str = "";
        char searchChar = 'a';
        char replaceChar = 'b';
        assertEquals("", StringUtils.replaceChars(str, searchChar, replaceChar));
    }

    @Test
    public void testReplaceCharsWhenCharIsNotFound() {
        String str = "abcba";
        char searchChar = 'z';
        char replaceChar = 'y';
        assertEquals("abcba", StringUtils.replaceChars(str, searchChar, replaceChar));
    }

    @Test
    public void testReplaceCharsWhenCharIsFound() {
        String str = "abcba";
        char searchChar = 'b';
        char replaceChar = 'y';
        assertEquals("aycya", StringUtils.replaceChars(str, searchChar, replaceChar));
    }

    @Test
    public void testReplaceCharsWithStringsWhenStringIsNull() {
        String str = null;
        String searchChars = "abc";
        String replaceChars = "def";
        assertNull(StringUtils.replaceChars(str, searchChars, replaceChars));
    }

    @Test
    public void testReplaceCharsWithStringsWhenStringIsEmpty() {
        String str = "";
        String searchChars = "abc";
        String replaceChars = "def";
        assertEquals("", StringUtils.replaceChars(str, searchChars, replaceChars));
    }

    @Test
    public void testReplaceCharsWithStringsWhenSearchCharsIsNull() {
        String str = "abc";
        String searchChars = null;
        String replaceChars = "def";
        assertEquals("abc", StringUtils.replaceChars(str, searchChars, replaceChars));
    }

    @Test
    public void testReplaceCharsWithStringsWhenSearchCharsIsEmpty() {
        String str = "abc";
        String searchChars = "";
        String replaceChars = "def";
        assertEquals("abc", StringUtils.replaceChars(str, searchChars, replaceChars));
    }

    @Test
    public void testReplaceCharsWithStringsWhenReplaceCharsIsNull() {
        String str = "abc";
        String searchChars = "b";
        String replaceChars = null;
        assertEquals("ac", StringUtils.replaceChars(str, searchChars, replaceChars));
    }

    @Test
    public void testReplaceCharsWithStringsWhenReplaceCharsIsEmpty() {
        String str = "abc";
        String searchChars = "b";
        String replaceChars = "";
        assertEquals("ac", StringUtils.replaceChars(str, searchChars, replaceChars));
    }

    @Test
    public void testReplaceCharsWithStringsWhenCharsAreReplaced() {
        String str = "abcba";
        String searchChars = "bc";
        String replaceChars = "yz";
        assertEquals("ayzya", StringUtils.replaceChars(str, searchChars, replaceChars));
    }

    @Test
    public void testReplaceCharsWithStringsWhenSearchCharsIsLongerThanReplaceChars() {
        String str = "abcba";
        String searchChars = "bc";
        String replaceChars = "y";
        assertEquals("ayya", StringUtils.replaceChars(str, searchChars, replaceChars));
    }

    @Test
    public void testReplaceCharsWithStringsWhenReplaceCharsIsLongerThanSearchChars() {
        String str = "abcba";
        String searchChars = "bc";
        String replaceChars = "yzx";
        assertEquals("ayzya", StringUtils.replaceChars(str, searchChars, replaceChars));
    }




    @Test
    public void testJoinWith() {
        // Test when the delimiter and the elements are valid
        assertEquals("a,b,c", StringUtils.joinWith(",", "a", "b", "c"));
        // Test when the elements have null values
        assertEquals("a,,c", StringUtils.joinWith(",", "a", null, "c"));
        // Test when the delimiter is null
        assertEquals("abc", StringUtils.joinWith(null, "a", "b", "c"));
        // Test when the elements are empty
        assertEquals("a,b,", StringUtils.joinWith(",", "a", "b", ""));
    }

    @Test
    public void testJoinWith_NullArray() {
        // Test when the array is null
        assertThrows(IllegalArgumentException.class, () -> StringUtils.joinWith(",", null));
    }





    @Test
    public void valueOfCharArr_returnsString() {
        char[] input = {'t', 'e', 's', 't'};
        String result = StringUtils.valueOf(input);

        assertNotNull(result, "Result should not be null");
        assertEquals("test", result, "The resulting string should be 'test'");
    }

    @Test
    public void valueOfEmptyCharArr_returnsEmptyString() {
        char[] input = {};
        String result = StringUtils.valueOf(input);

        assertNotNull(result, "Result should not be null");
        assertEquals("", result, "The resulting string should be empty");
    }

    @Test
    public void valueOfNullCharArr_returnsNull() {
        char[] input = null;
        String result = StringUtils.valueOf(input);

        assertNull(result, "Result should be null");
    }






    @Test
    public void testSubstringBeforeLast() {
        // Test with null string
        assertNull(StringUtils.substringBeforeLast(null, "test"));

        // Test with empty string
        assertEquals("", StringUtils.substringBeforeLast("", "test"));

        // Test with empty separator
        assertEquals("test", StringUtils.substringBeforeLast("test", ""));

        // Test with null separator
        assertEquals("test", StringUtils.substringBeforeLast("test", null));

        // Test with separator not in string
        assertEquals("test", StringUtils.substringBeforeLast("test", "x"));

        // Test with separator in string
        assertEquals("te", StringUtils.substringBeforeLast("test", "st"));

        // Test with separator at the end of string
        assertEquals("test", StringUtils.substringBeforeLast("test#", "#"));

        // Test with multiple separators in string
        assertEquals("test#test", StringUtils.substringBeforeLast("test#test#test", "#"));

        // Test with string equals to separator
        assertEquals("", StringUtils.substringBeforeLast("#", "#"));
    }




    @Test
    public void testReplaceFirst_textIsNull_returnsNull() {
        String result = StringUtils.replaceFirst(null, "abc", "def");
        assertNull(result);
    }

    @Test
    public void testReplaceFirst_regexIsNull_returnsOriginalText() {
        String result = StringUtils.replaceFirst("abc", null, "def");
        assertEquals("abc", result);
    }

    @Test
    public void testReplaceFirst_replacementIsNull_returnsOriginalText() {
        String result = StringUtils.replaceFirst("abc", "abc", null);
        assertEquals("abc", result);
    }

    @Test
    public void testReplaceFirst_allNull_returnsNull() {
        String result = StringUtils.replaceFirst(null, null, null);
        assertNull(result);
    }

    @Test
    public void testReplaceFirst_emptyStringAndEmptyRegex_returnsReplacement() {
        String result = StringUtils.replaceFirst("", "", "zzz");
        assertEquals("zzz", result);
    }

    @Test
    public void testReplaceFirst_nonMatchingRegex_returnsOriginalText() {
        String result = StringUtils.replaceFirst("abc", "def", "ghi");
        assertEquals("abc", result);
    }

    @Test
    public void testReplaceFirst_matchingRegex_returnsReplacedText() {
        String result = StringUtils.replaceFirst("abcabcabc", "abc", "def");
        assertEquals("defabcabc", result);
    }

    @Test
    public void testReplaceFirst_multipleMatchingRegex_returnsFirstReplacedText() {
        String result = StringUtils.replaceFirst("abcabcabc", "abc", "def");
        assertEquals("defabcabc", result);
    }

    @Test
    public void testReplaceFirst_regexWithSpecialCharacters_returnsReplacedText() {
        String result = StringUtils.replaceFirst("abcabcabc", "[a-c]+", "def");
        assertEquals("def", result);
    }






    @Test
    public void testSplitByCharacterType_NullString(){
        String str = null;
        assertNull(StringUtils.splitByCharacterType(str));
    }

    @Test
    public void testSplitByCharacterType_EmptyString(){
        String str = "";
        String[] result = StringUtils.splitByCharacterType(str);
        assertTrue(result.length == 0);
    }

    @Test
    public void testSplitByCharacterType_WhiteSpaceString(){
        String str = "ab de fg";
        String[] result = StringUtils.splitByCharacterType(str);
        assertArrayEquals(new String[]{"ab", " ", "de", " ", "fg"}, result);
    }

    @Test
    public void testSplitByCharacterType_MultipleWhiteSpaceString(){
        String str = "ab   de fg";
        String[] result = StringUtils.splitByCharacterType(str);
        assertArrayEquals(new String[]{"ab", "   ", "de", " ", "fg"}, result);
    }

    @Test
    public void testSplitByCharacterType_SpecialCharString(){
        String str = "ab:cd:ef";
        String[] result = StringUtils.splitByCharacterType(str);
        assertArrayEquals(new String[]{"ab", ":", "cd", ":", "ef"}, result);
    }

    @Test
    public void testSplitByCharacterType_AlphanumericString(){
        String str = "number5";
        String[] result = StringUtils.splitByCharacterType(str);
        assertArrayEquals(new String[]{"number", "5"}, result);
    }

    @Test
    public void testSplitByCharacterType_CamelCaseString(){
        String str = "fooBar";
        String[] result = StringUtils.splitByCharacterType(str);
        assertArrayEquals(new String[]{"foo", "B", "ar"}, result);
    }

    @Test
    public void testSplitByCharacterType_MixedString(){
        String str = "foo200Bar";
        String[] result = StringUtils.splitByCharacterType(str);
        assertArrayEquals(new String[]{"foo", "200", "B", "ar"}, result);
    }

    @Test
    public void testSplitByCharacterType_UpperCaseString(){
        String str = "ASFRules";
        String[] result = StringUtils.splitByCharacterType(str);
        assertArrayEquals(new String[]{"ASFR", "ules"}, result);
    }





    @Test
    public void testDifferenceWhenBothStringsAreNull() {
        assertNull(StringUtils.difference(null, null));
    }

    @Test
    public void testDifferenceWhenFirstStringIsNull() {
        String str2 = "test";
        assertEquals(str2, StringUtils.difference(null, str2));
    }

    @Test
    public void testDifferenceWhenSecondStringIsNull() {
        String str1 = "test";
        assertEquals(str1, StringUtils.difference(str1, null));
    }

    @Test
    public void testDifferenceWhenBothStringsAreEmpty() {
        assertEquals(StringUtils.EMPTY, StringUtils.difference(StringUtils.EMPTY, StringUtils.EMPTY));
    }

    @Test
    public void testDifferenceWhenFirstStringIsEmpty() {
        String str2 = "test";
        assertEquals(str2, StringUtils.difference(StringUtils.EMPTY, str2));
    }

    @Test
    public void testDifferenceWhenSecondStringIsEmpty() {
        String str1 = "test";
        assertEquals(StringUtils.EMPTY, StringUtils.difference(str1, StringUtils.EMPTY));
    }

    @Test
    public void testDifferenceWhenStringsAreEqual() {
        String str1 = "test";
        String str2 = "test";
        assertEquals(StringUtils.EMPTY, StringUtils.difference(str1, str2));
    }

    @Test
    public void testDifferenceWhenStringsAreDifferent() {
        String str1 = "test";
        String str2 = "testing";
        assertEquals("ing", StringUtils.difference(str1, str2));
    }






    @Test
    public void testStripEndNullInput() {
        assertNull(StringUtils.stripEnd(null, "xyz"));
    }

    @Test
    public void testStripEndEmptyInput() {
        assertEquals("", StringUtils.stripEnd("", "xyz"));
    }

    @Test
    public void testStripEndWithoutStripChars() {
        assertEquals("abc", StringUtils.stripEnd("abc", ""));
        assertEquals("abc", StringUtils.stripEnd("abc", null));
    }

    @Test
    public void testStripEndWithSpaces() {
        assertEquals("  abc", StringUtils.stripEnd("  abc", null));
        assertEquals("abc", StringUtils.stripEnd("abc  ", null));
        assertEquals(" abc", StringUtils.stripEnd(" abc ", null));
    }

    @Test
    public void testStripEndWithSpecificChars() {
        assertEquals("  abc", StringUtils.stripEnd("  abcyx", "xyz"));
    }

    @Test
    public void testStripEndWithNumbers() {
        assertEquals("12", StringUtils.stripEnd("120.00", ".0"));
    }





    @Test
    public void testReplaceWhenTextIsNull() {
        String text = null;
        String searchString = "a";
        String replacement = "z";
        String result = StringUtils.replace(text, searchString, replacement);
        assertNull(result, "Result should be null when text is null");
    }

    @Test
    public void testReplaceWhenTextIsEmpty() {
        String text = "";
        String searchString = "a";
        String replacement = "z";
        String result = StringUtils.replace(text, searchString, replacement);
        assertEquals("", result, "Result should be empty when text is empty");
    }

    @Test
    public void testReplaceWhenSearchStringIsNull() {
        String text = "any";
        String searchString = null;
        String replacement = "z";
        String result = StringUtils.replace(text, searchString, replacement);
        assertEquals("any", result, "Result should be same as text when search string is null");
    }

    @Test
    public void testReplaceWhenReplacementIsNull() {
        String text = "aba";
        String searchString = "a";
        String replacement = null;
        String result = StringUtils.replace(text, searchString, replacement);
        assertEquals("aba", result, "Result should be same as text when replacement is null");
    }

    @Test
    public void testReplaceWhenSearchStringIsEmpty() {
        String text = "any";
        String searchString = "";
        String replacement = "z";
        String result = StringUtils.replace(text, searchString, replacement);
        assertEquals("any", result, "Result should be same as text when search string is empty");
    }

    @Test
    public void testReplaceWhenReplacementIsEmpty() {
        String text = "aba";
        String searchString = "a";
        String replacement = "";
        String result = StringUtils.replace(text, searchString, replacement);
        assertEquals("b", result, "Result should be 'b' when replacement is empty");
    }

    @Test
    public void testReplaceAllOccurrences() {
        String text = "aba";
        String searchString = "a";
        String replacement = "z";
        String result = StringUtils.replace(text, searchString, replacement);
        assertEquals("zbz", result, "Result should be 'zbz' when replacing all 'a' with 'z'");
    }




    @Test
    public void whenNullString_thenDoesNotContainWhitespace() {
        // Arrange
        CharSequence seq = null;
        
        // Act
        boolean result = StringUtils.containsWhitespace(seq);
        
        // Assert
        assertFalse(result);
    }

    @Test
    public void whenEmptyString_thenDoesNotContainWhitespace() {
        // Arrange
        CharSequence seq = "";
        
        // Act
        boolean result = StringUtils.containsWhitespace(seq);
        
        // Assert
        assertFalse(result);
    }

    @Test
    public void whenStringWithNoWhitespace_thenDoesNotContainWhitespace() {
        // Arrange
        CharSequence seq = "NoWhitespace";
        
        // Act
        boolean result = StringUtils.containsWhitespace(seq);
        
        // Assert
        assertFalse(result);
    }

    @Test
    public void whenStringWithWhitespace_thenContainsWhitespace() {
        // Arrange
        CharSequence seq = "With Whitespace";
        
        // Act
        boolean result = StringUtils.containsWhitespace(seq);
        
        // Assert
        assertTrue(result);
    }

    @Test
    public void whenStringWithTab_thenContainsWhitespace() {
        // Arrange
        CharSequence seq = "With\tTab";
        
        // Act
        boolean result = StringUtils.containsWhitespace(seq);
        
        // Assert
        assertTrue(result);
    }

    @Test
    public void whenStringWithNewLine_thenContainsWhitespace() {
        // Arrange
        CharSequence seq = "With\nNewLine";
        
        // Act
        boolean result = StringUtils.containsWhitespace(seq);
        
        // Assert
        assertTrue(result);
    }




    @Test
    public void length_whenCharSequenceIsNull_shouldReturnZero() {
        CharSequence cs = null;

        int result = StringUtils.length(cs);

        assertEquals(0, result, "Length of null CharSequence should be 0");
    }

    @Test
    public void length_whenCharSequenceIsEmpty_shouldReturnZero() {
        CharSequence cs = "";

        int result = StringUtils.length(cs);

        assertEquals(0, result, "Length of empty CharSequence should be 0");
    }

    @Test
    public void length_whenCharSequenceIsNotEmpty_shouldReturnCorrectLength() {
        CharSequence cs = "test";

        int result = StringUtils.length(cs);

        assertEquals(4, result, "Length of CharSequence 'test' should be 4");
    }

    @Test
    public void length_whenCharSequenceContainsSpaces_shouldCountSpaces() {
        CharSequence cs = " t e s t ";

        int result = StringUtils.length(cs);

        assertEquals(9, result, "Length of CharSequence ' t e s t ' should be 9");
    }

    @Test
    public void length_whenCharSequenceContainsSpecialCharacters_shouldCountSpecialCharacters() {
        CharSequence cs = "test@123!";

        int result = StringUtils.length(cs);

        assertEquals(9, result, "Length of CharSequence 'test@123!' should be 9");
    }





    @Test
    public void testIsWhitespace() {
        // Null string should return false
        assertFalse(StringUtils.isWhitespace(null));
        
        // Empty string should return true
        assertTrue(StringUtils.isWhitespace(""));

        // String with only spaces should return true
        assertTrue(StringUtils.isWhitespace("   "));

        // String with non-space characters should return false
        assertFalse(StringUtils.isWhitespace("abc"));

        // String with non-space characters and spaces should return false
        assertFalse(StringUtils.isWhitespace(" a b c "));

        // String with special characters should return false
        assertFalse(StringUtils.isWhitespace("@#%"));

        // String with a new line character should return true
        assertTrue(StringUtils.isWhitespace("\n"));

        // String with a carriage return character should return true
        assertTrue(StringUtils.isWhitespace("\r"));

        // String with a tab character should return true
        assertTrue(StringUtils.isWhitespace("\t"));
    }




    @Test
    public void testDeleteWhitespace_NullInput() {
        String input = null;
        String result = StringUtils.deleteWhitespace(input);
        assertNull(result);
    }

    @Test
    public void testDeleteWhitespace_EmptyInput() {
        String input = "";
        String result = StringUtils.deleteWhitespace(input);
        assertEquals(input, result);
    }

    @Test
    public void testDeleteWhitespace_NoWhitespace() {
        String input = "abc";
        String result = StringUtils.deleteWhitespace(input);
        assertEquals(input, result);
    }

    @Test
    public void testDeleteWhitespace_WhitespaceAtBothEnds() {
        String input = "   abc   ";
        String expected = "abc";
        String result = StringUtils.deleteWhitespace(input);
        assertEquals(expected, result);
    }

    @Test
    public void testDeleteWhitespace_WhitespaceInMiddle() {
        String input = "a b c";
        String expected = "abc";
        String result = StringUtils.deleteWhitespace(input);
        assertEquals(expected, result);
    }

    @Test
    public void testDeleteWhitespace_AllWhitespace() {
        String input = "   ";
        String expected = "";
        String result = StringUtils.deleteWhitespace(input);
        assertEquals(expected, result);
    }





    @Test
    public void testRemoveStartIgnoreCase() {
        String str = "www.domain.com";
        String remove = "www.";
        String result = StringUtils.removeStartIgnoreCase(str, remove);
        assertEquals("domain.com", result);
    }

    @Test
    public void testRemoveStartIgnoreCaseCaseInsensitive() {
        String str = "www.domain.com";
        String remove = "WWW.";
        String result = StringUtils.removeStartIgnoreCase(str, remove);
        assertEquals("domain.com", result);
    }

    @Test
    public void testRemoveStartIgnoreCaseNoRemove() {
        String str = "domain.com";
        String remove = "www.";
        String result = StringUtils.removeStartIgnoreCase(str, remove);
        assertEquals("domain.com", result);
    }

    @Test
    public void testRemoveStartIgnoreCaseRemoveNotAtStart() {
        String str = "www.domain.com";
        String remove = "domain";
        String result = StringUtils.removeStartIgnoreCase(str, remove);
        assertEquals("www.domain.com", result);
    }

    @Test
    public void testRemoveStartIgnoreCaseWithNullStr() {
        String str = null;
        String remove = "www.";
        String result = StringUtils.removeStartIgnoreCase(str, remove);
        assertNull(result);
    }

    @Test
    public void testRemoveStartIgnoreCaseWithEmptyStr() {
        String str = "";
        String remove = "www.";
        String result = StringUtils.removeStartIgnoreCase(str, remove);
        assertEquals("", result);
    }

    @Test
    public void testRemoveStartIgnoreCaseWithNullRemove() {
        String str = "www.domain.com";
        String remove = null;
        String result = StringUtils.removeStartIgnoreCase(str, remove);
        assertEquals("www.domain.com", result);
    }

    @Test
    public void testRemoveStartIgnoreCaseWithEmptyRemove() {
        String str = "abc";
        String remove = "";
        String result = StringUtils.removeStartIgnoreCase(str, remove);
        assertEquals("abc", result);
    }




    @Test
    public void testWrapWithChar() {
        String str = "test";
        char wrapWith = '*';

        String result = StringUtils.wrap(str, wrapWith);

        assertEquals("*test*", result);
    }

    @Test
    public void testWrapWithNullStringChar() {
        String str = null;
        char wrapWith = '*';

        String result = StringUtils.wrap(str, wrapWith);

        assertNull(result);
    }

    @Test
    public void testWrapWithEmptyStringChar() {
        String str = "";
        char wrapWith = '*';

        String result = StringUtils.wrap(str, wrapWith);

        assertEquals("", result);
    }

    @Test
    public void testWrapWithCharNUL() {
        String str = "test";
        char wrapWith = '\0';

        String result = StringUtils.wrap(str, wrapWith);

        assertEquals("test", result);
    }

    @Test
    public void testWrapWithString() {
        String str = "test";
        String wrapWith = "**";

        String result = StringUtils.wrap(str, wrapWith);

        assertEquals("**test**", result);
    }

    @Test
    public void testWrapWithNullString() {
        String str = null;
        String wrapWith = "**";

        String result = StringUtils.wrap(str, wrapWith);

        assertNull(result);
    }

    @Test
    public void testWrapWithEmptyString() {
        String str = "";
        String wrapWith = "**";

        String result = StringUtils.wrap(str, wrapWith);

        assertEquals("", result);
    }

    @Test
    public void testWrapWithNullWrapString() {
        String str = "test";
        String wrapWith = null;

        String result = StringUtils.wrap(str, wrapWith);

        assertEquals("test", result);
    }

    @Test
    public void testWrapWithEmptyWrapString() {
        String str = "test";
        String wrapWith = "";

        String result = StringUtils.wrap(str, wrapWith);

        assertEquals("test", result);
    }




    @Test
    public void testIsAllEmptyWithNullInput() {
        assertTrue(StringUtils.isAllEmpty(null));
    }

    @Test
    public void testIsAllEmptyWithNullAndEmptyString() {
        assertTrue(StringUtils.isAllEmpty(null, ""));
    }

    @Test
    public void testIsAllEmptyWithEmptyArray() {
        assertTrue(StringUtils.isAllEmpty(new String[] {}));
    }

    @Test
    public void testIsAllEmptyWithNullAndNonEmptyString() {
        assertFalse(StringUtils.isAllEmpty(null, "foo"));
    }

    @Test
    public void testIsAllEmptyWithEmptyStringAndNonEmptyString() {
        assertFalse(StringUtils.isAllEmpty("", "bar"));
    }

    @Test
    public void testIsAllEmptyWithNonEmptyStrings() {
        assertFalse(StringUtils.isAllEmpty("bob", ""));
    }

    @Test
    public void testIsAllEmptyWithNonEmptyStringAndNull() {
        assertFalse(StringUtils.isAllEmpty("  bob  ", null));
    }

    @Test
    public void testIsAllEmptyWithSpaceAndNonEmptyString() {
        assertFalse(StringUtils.isAllEmpty(" ", "bar"));
    }

    @Test
    public void testIsAllEmptyWithTwoNonEmptyStrings() {
        assertFalse(StringUtils.isAllEmpty("foo", "bar"));
    }






    @Test
    public void countMatches_charSequence_char() {
        // Case: Null string
        assertEquals(0, StringUtils.countMatches(null, 'a'));

        // Case: Empty string
        assertEquals(0, StringUtils.countMatches("", 'a'));

        // Case: No match
        assertEquals(0, StringUtils.countMatches("abcde", 'z'));

        // Case: Single match
        assertEquals(1, StringUtils.countMatches("abcde", 'a'));

        // Case: Multiple matches
        assertEquals(3, StringUtils.countMatches("aaabbb", 'a'));
    }

    @Test
    public void countMatches_charSequence_charSequence() {
        // Case: Both strings are null
        assertEquals(0, StringUtils.countMatches(null, null));

        // Case: Null string
        assertEquals(0, StringUtils.countMatches(null, "abc"));

        // Case: Null substring
        assertEquals(0, StringUtils.countMatches("abc", null));

        // Case: Empty string and non-empty substring
        assertEquals(0, StringUtils.countMatches("", "abc"));

        // Case: Non-empty string and empty substring
        assertEquals(0, StringUtils.countMatches("abc", ""));

        // Case: No match
        assertEquals(0, StringUtils.countMatches("abcde", "z"));

        // Case: Single match
        assertEquals(1, StringUtils.countMatches("abcde", "a"));

        // Case: Multiple matches
        assertEquals(2, StringUtils.countMatches("abcabc", "abc"));

        // Case: Overlapping matches
        assertEquals(1, StringUtils.countMatches("abcabc", "abcabc"));
    }




    @Test
    public void testGetCommonPrefixWithNull() {
        String prefix = StringUtils.getCommonPrefix(null);
        assertEquals("", prefix);
    }

    @Test
    public void testGetCommonPrefixWithEmptyStrings() {
        String prefix = StringUtils.getCommonPrefix("", "");
        assertEquals("", prefix);
    }

    @Test
    public void testGetCommonPrefixWithNullAndEmptyStrings() {
        String prefix = StringUtils.getCommonPrefix("", null);
        assertEquals("", prefix);
    }

    @Test
    public void testGetCommonPrefixWithIdenticalStrings() {
        String prefix = StringUtils.getCommonPrefix("abc", "abc");
        assertEquals("abc", prefix);
    }

    @Test
    public void testGetCommonPrefixWithOnePrefixString() {
        String prefix = StringUtils.getCommonPrefix("abc", "a");
        assertEquals("a", prefix);
    }

    @Test
    public void testGetCommonPrefixWithNoCommonPrefix() {
        String prefix = StringUtils.getCommonPrefix("abcde", "xyz");
        assertEquals("", prefix);
    }

    @Test
    public void testGetCommonPrefixWithMultipleStrings() {
        String prefix = StringUtils.getCommonPrefix("i am a machine", "i am a robot");
        assertEquals("i am a ", prefix);
    }






    @Test
    public void testIsMixedCase_withNullString() {
        assertFalse(StringUtils.isMixedCase(null));
    }

    @Test
    public void testIsMixedCase_withEmptyString() {
        assertFalse(StringUtils.isMixedCase(""));
    }

    @Test
    public void testIsMixedCase_withSpaceString() {
        assertFalse(StringUtils.isMixedCase(" "));
    }

    @Test
    public void testIsMixedCase_withUpperCaseString() {
        assertFalse(StringUtils.isMixedCase("ABC"));
    }

    @Test
    public void testIsMixedCase_withLowerCaseString() {
        assertFalse(StringUtils.isMixedCase("abc"));
    }

    @Test
    public void testIsMixedCase_withMixedCaseString() {
        assertTrue(StringUtils.isMixedCase("aBc"));
    }

    @Test
    public void testIsMixedCase_withMixedCaseStringAndSpaces() {
        assertTrue(StringUtils.isMixedCase("A c"));
    }

    @Test
    public void testIsMixedCase_withMixedCaseStringAndNumbers() {
        assertTrue(StringUtils.isMixedCase("A1c"));
    }

    @Test
    public void testIsMixedCase_withMixedCaseStringAndSpecialCharacters() {
        assertTrue(StringUtils.isMixedCase("a/C"));
    }

    @Test
    public void testIsMixedCase_withMixedCaseStringAndTabs() {
        assertTrue(StringUtils.isMixedCase("aC\t"));
    }






    @Test
    public void trim_nullInput_returnsNull() {
        // given
        String input = null;

        // when
        String result = StringUtils.trim(input);

        // then
        assertNull(result);
    }

    @Test
    public void trim_emptyInput_returnsEmpty() {
        // given
        String input = "";

        // when
        String result = StringUtils.trim(input);

        // then
        assertEquals("", result);
    }

    @Test
    public void trim_stringWithSpaces_returnsTrimmedString() {
        // given
        String input = "    abc    ";

        // when
        String result = StringUtils.trim(input);

        // then
        assertEquals("abc", result);
    }

    @Test
    public void trim_stringWithNoSpaces_returnsSameString() {
        // given
        String input = "abc";

        // when
        String result = StringUtils.trim(input);

        // then
        assertEquals("abc", result);
    }

    @Test
    public void trim_stringWithOnlySpaces_returnsEmpty() {
        // given
        String input = "     ";

        // when
        String result = StringUtils.trim(input);

        // then
        assertEquals("", result);
    }




    @Test
    public void testChop_NullString() {
        String str = null;
        String result = StringUtils.chop(str);
        assertNull(result);
    }

    @Test
    public void testChop_EmptyString() {
        String str = "";
        String result = StringUtils.chop(str);
        assertEquals("", result);
    }

    @Test
    public void testChop_StringEndsWithCR() {
        String str = "abc \r";
        String result = StringUtils.chop(str);
        assertEquals("abc ", result);
    }

    @Test
    public void testChop_StringEndsWithLF() {
        String str = "abc\n";
        String result = StringUtils.chop(str);
        assertEquals("abc", result);
    }

    @Test
    public void testChop_StringEndsWithCRLF() {
        String str = "abc\r\n";
        String result = StringUtils.chop(str);
        assertEquals("abc", result);
    }

    @Test
    public void testChop_SingleCharacterString() {
        String str = "a";
        String result = StringUtils.chop(str);
        assertEquals("", result);
    }

    @Test
    public void testChop_StringEndsWithSingleLF() {
        String str = "\n";
        String result = StringUtils.chop(str);
        assertEquals("", result);
    }

    @Test
    public void testChop_StringEndsWithSingleCR() {
        String str = "\r";
        String result = StringUtils.chop(str);
        assertEquals("", result);
    }

    @Test
    public void testChop_StringEndsWithCRLFTogether() {
        String str = "\r\n";
        String result = StringUtils.chop(str);
        assertEquals("", result);
    }





    @Test
    public void containsOnly_CharArray_Test_NullCharSequence() {
        assertFalse(StringUtils.containsOnly(null, 'a', 'b', 'c'));
    }
    
    @Test
    public void containsOnly_CharArray_Test_NullValidCharArray() {
        assertFalse(StringUtils.containsOnly("abc", (char[]) null));
    }
    
    @Test
    public void containsOnly_CharArray_Test_EmptyCharSequence() {
        assertTrue(StringUtils.containsOnly("", 'a', 'b', 'c'));
    }
    
    @Test
    public void containsOnly_CharArray_Test_EmptyValidCharArray() {
        assertFalse(StringUtils.containsOnly("abc", new char[0]));
    }
    
    @Test
    public void containsOnly_CharArray_Test_ValidChars() {
        assertTrue(StringUtils.containsOnly("abc", 'a', 'b', 'c'));
    }
    
    @Test
    public void containsOnly_CharArray_Test_InvalidChars() {
        assertFalse(StringUtils.containsOnly("abc1", 'a', 'b', 'c'));
    }
    
    @Test
    public void containsOnly_String_Test_NullCharSequence() {
        assertFalse(StringUtils.containsOnly(null, "abc"));
    }
    
    @Test
    public void containsOnly_String_Test_NullValidString() {
        assertFalse(StringUtils.containsOnly("abc", (String) null));
    }
    
    @Test
    public void containsOnly_String_Test_EmptyCharSequence() {
        assertTrue(StringUtils.containsOnly("", "abc"));
    }
    
    @Test
    public void containsOnly_String_Test_EmptyValidString() {
        assertFalse(StringUtils.containsOnly("abc", ""));
    }
    
    @Test
    public void containsOnly_String_Test_ValidChars() {
        assertTrue(StringUtils.containsOnly("abc", "abc"));
    }
    
    @Test
    public void containsOnly_String_Test_InvalidChars() {
        assertFalse(StringUtils.containsOnly("abc1", "abc"));
    }




    @Test
    public void testUncapitalize() {
        // Test for null string
        assertNull(StringUtils.uncapitalize(null));

        // Test for empty string
        assertEquals("", StringUtils.uncapitalize(""));

        // Test for string with all characters in lower case
        assertEquals("cat", StringUtils.uncapitalize("cat"));

        // Test for string with first character in upper case
        assertEquals("cat", StringUtils.uncapitalize("Cat"));

        // Test for string with all characters in upper case
        assertEquals("cAT", StringUtils.uncapitalize("CAT"));

        // Test for string with special characters
        assertEquals("1@#cat$", StringUtils.uncapitalize("1@#Cat$"));
    }

    @Test
    public void testUncapitalizeWithNonAsciiChars() {
        // Test for string with non-ASCII characters
        assertEquals("éclair", StringUtils.uncapitalize("Éclair"));
    }

    @Test
    public void testUncapitalizeWithDigits() {
        // Test for string with digits
        assertEquals("123cat", StringUtils.uncapitalize("123Cat"));
    }





    @Test
    public void testToEncodedString_ValidBytesAndCharset() {
        byte[] bytes = {'h', 'e', 'l', 'l', 'o'};
        Charset charset = StandardCharsets.UTF_8;
        String expected = "hello";

        String actual = StringUtils.toEncodedString(bytes, charset);

        assertEquals(expected, actual);
    }

    @Test
    public void testToEncodedString_NullBytes() {
        byte[] bytes = null;
        Charset charset = StandardCharsets.UTF_8;

        assertThrows(NullPointerException.class, () -> StringUtils.toEncodedString(bytes, charset));
    }

    @Test
    public void testToEncodedString_NullCharset() {
        byte[] bytes = {'h', 'e', 'l', 'l', 'o'};
        Charset charset = null;
        String expected = "hello";

        String actual = StringUtils.toEncodedString(bytes, charset);

        assertEquals(expected, actual);
    }

    @Test
    public void testToEncodedString_EmptyBytes() {
        byte[] bytes = {};
        Charset charset = StandardCharsets.UTF_8;
        String expected = "";

        String actual = StringUtils.toEncodedString(bytes, charset);

        assertEquals(expected, actual);
    }








    @Test
    public void testIsAlphaWithNullString() {
        // test data
        CharSequence cs = null;

        // Call isAlpha
        boolean result = StringUtils.isAlpha(cs);

        // Assertion
        assertFalse(result);
    }

    @Test
    public void testIsAlphaWithEmptyString() {
        // test data
        CharSequence cs = "";

        // Call isAlpha
        boolean result = StringUtils.isAlpha(cs);

        // Assertion
        assertFalse(result);
    }

    @Test
    public void testIsAlphaWithNonAlphaString() {
        // test data
        CharSequence cs = "1234";

        // Call isAlpha
        boolean result = StringUtils.isAlpha(cs);

        // Assertion
        assertFalse(result);
    }

    @Test
    public void testIsAlphaWithMixedAlphaAndNonAlphaString() {
        // test data
        CharSequence cs = "abc123";

        // Call isAlpha
        boolean result = StringUtils.isAlpha(cs);

        // Assertion
        assertFalse(result);
    }

    @Test
    public void testIsAlphaWithPureAlphaString() {
        // test data
        CharSequence cs = "abc";

        // Call isAlpha
        boolean result = StringUtils.isAlpha(cs);

        // Assertion
        assertTrue(result);
    }





    @Test
    public void testCapitalizeNull() {
        String str = null;
        String result = StringUtils.capitalize(str);
        assertNull(result);
    }

    @Test
    public void testCapitalizeEmpty() {
        String str = "";
        String result = StringUtils.capitalize(str);
        assertEquals("", result);
    }

    @Test
    public void testCapitalizeLowercaseWord() {
        String str = "cat";
        String result = StringUtils.capitalize(str);
        assertEquals("Cat", result);
    }

    @Test
    public void testCapitalizeUppercaseWord() {
        String str = "CAT";
        String result = StringUtils.capitalize(str);
        assertEquals("CAT", result);
    }

    @Test
    public void testCapitalizeMixedCaseWord() {
        String str = "cAt";
        String result = StringUtils.capitalize(str);
        assertEquals("CAt", result);
    }

    @Test
    public void testCapitalizeWordWithSpecialChar() {
        String str = "'cat'";
        String result = StringUtils.capitalize(str);
        assertEquals("'cat'", result);
    }

    @Test
    public void testCapitalizeSentence() {
        String str = "hello world";
        String result = StringUtils.capitalize(str);
        assertEquals("Hello world", result);
    }




    @Test
    public void testUnwrapWithChar() {
        // Test with null string
        assertNull(StringUtils.unwrap(null, 'a'));

        // Test with empty string
        assertEquals("", StringUtils.unwrap("", 'a'));

        // Test with one character string
        assertEquals("a", StringUtils.unwrap("a", 'a'));

        // Test with wrapped string
        assertEquals("abc", StringUtils.unwrap("'abc'", '\''));

        // Test with unwrapped string
        assertEquals("abc", StringUtils.unwrap("abc", '\''));

        // Test with partially wrapped string
        assertEquals("'abc", StringUtils.unwrap("'abc", '\''));
        assertEquals("abc'", StringUtils.unwrap("abc'", '\''));
    }

    @Test
    public void testUnwrapWithString() {
        // Test with null string
        assertNull(StringUtils.unwrap(null, "a"));

        // Test with empty string
        assertEquals("", StringUtils.unwrap("", "a"));

        // Test with one character string
        assertEquals("a", StringUtils.unwrap("a", "a"));

        // Test with wrapped string
        assertEquals("abc", StringUtils.unwrap("\"abc\"", "\""));

        // Test with unwrapped string
        assertEquals("abc", StringUtils.unwrap("abc", "\""));

        // Test with partially wrapped string
        assertEquals("\"abc", StringUtils.unwrap("\"abc", "\""));
        assertEquals("abc\"", StringUtils.unwrap("abc\"", "\""));
    }





    @Test
    public void convertRemainingAccentCharacters_AllAccents() {
        StringBuilder decomposed = new StringBuilder("\u0141\u0142");
        new StringUtils().convertRemainingAccentCharacters(decomposed);
        assertEquals("Ll", decomposed.toString());
    }

    @Test
    public void convertRemainingAccentCharacters_SomeAccents() {
        StringBuilder decomposed = new StringBuilder("A\u0141B\u0142C");
        new StringUtils().convertRemainingAccentCharacters(decomposed);
        assertEquals("ALBlC", decomposed.toString());
    }

    @Test
    public void convertRemainingAccentCharacters_NoAccents() {
        StringBuilder decomposed = new StringBuilder("ABC");
        new StringUtils().convertRemainingAccentCharacters(decomposed);
        assertEquals("ABC", decomposed.toString());
    }

    @Test
    public void convertRemainingAccentCharacters_EmptyString() {
        StringBuilder decomposed = new StringBuilder("");
        new StringUtils().convertRemainingAccentCharacters(decomposed);
        assertEquals("", decomposed.toString());
    }





    @Test
    public void testIsNumericNull() {
        // Act & Assert
        assertFalse(StringUtils.isNumeric(null));
    }

    @Test
    public void testIsNumericEmptyString() {
        // Arrange
        String input = "";

        // Act & Assert
        assertFalse(StringUtils.isNumeric(input));
    }

    @Test
    public void testIsNumericWithSpaces() {
        // Arrange
        String input = "  ";

        // Act & Assert
        assertFalse(StringUtils.isNumeric(input));
    }

    @Test
    public void testIsNumericValidNumber() {
        // Arrange
        String input = "123";

        // Act & Assert
        assertTrue(StringUtils.isNumeric(input));
    }

    @Test
    public void testIsNumericInvalidNumberWithSpaces() {
        // Arrange
        String input = "12 3";

        // Act & Assert
        assertFalse(StringUtils.isNumeric(input));
    }

    @Test
    public void testIsNumericInvalidNumberWithNonNumericCharacters() {
        // Arrange
        String input = "ab2c";

        // Act & Assert
        assertFalse(StringUtils.isNumeric(input));
    }

    @Test
    public void testIsNumericInvalidNumberWithMinusSign() {
        // Arrange
        String input = "-123";

        // Act & Assert
        assertFalse(StringUtils.isNumeric(input));
    }

    @Test
    public void testIsNumericInvalidNumberWithPlusSign() {
        // Arrange
        String input = "+123";

        // Act & Assert
        assertFalse(StringUtils.isNumeric(input));
    }






    @Test
    public void testStripAllNullInput() {
        assertNull(StringUtils.stripAll(null));
    }

    @Test
    public void testStripAllEmptyInput() {
        String[] input = new String[] {};
        String[] expected = new String[] {};
        assertArrayEquals(expected, StringUtils.stripAll(input));
    }

    @Test
    public void testStripAllWithWhiteSpace() {
        String[] input = new String[] {"   abc   ", "  def   ", "  ghi  "};
        String[] expected = new String[] {"abc", "def", "ghi"};
        assertArrayEquals(expected, StringUtils.stripAll(input));
    }

    @Test
    public void testStripAllWithNullValue() {
        String[] input = new String[] {"   abc   ", null, "  ghi  "};
        String[] expected = new String[] {"abc", null, "ghi"};
        assertArrayEquals(expected, StringUtils.stripAll(input));
    }

    @Test
    public void testStripAllWithStripChars() {
        String[] input = new String[] {"xyzabcxyz", "yzdefyz", "zghiz"};
        String[] stripChars = new String[] {"xyz"};
        String[] expected = new String[] {"abc", "def", "ghi"};
        assertArrayEquals(expected, StringUtils.stripAll(input, stripChars));
    }




    @Test
    public void testPrependIfMissingIgnoreCaseNullString() {
        String result = StringUtils.prependIfMissingIgnoreCase(null, "xyz");
        assertNull(result);
    }

    @Test
    public void testPrependIfMissingIgnoreCaseNullPrefix() {
        String result = StringUtils.prependIfMissingIgnoreCase("abc", null);
        assertEquals("abc", result);
    }

    @Test
    public void testPrependIfMissingIgnoreCaseEmptyString() {
        String result = StringUtils.prependIfMissingIgnoreCase("", "xyz");
        assertEquals("xyz", result);
    }

    @Test
    public void testPrependIfMissingIgnoreCaseCaseSensitivePrefix() {
        String result = StringUtils.prependIfMissingIgnoreCase("abc", "xyz");
        assertEquals("xyzabc", result);
    }

    @Test
    public void testPrependIfMissingIgnoreCaseCaseInsensitivePrefix() {
        String result = StringUtils.prependIfMissingIgnoreCase("XYZabc", "xyz");
        assertEquals("XYZabc", result);
    }

    @Test
    public void testPrependIfMissingIgnoreCaseWithAdditionalPrefixes() {
        String result = StringUtils.prependIfMissingIgnoreCase("abc", "xyz", "mno");
        assertEquals("xyzabc", result);
    }

    @Test
    public void testPrependIfMissingIgnoreCaseWithExistingPrefix() {
        String result = StringUtils.prependIfMissingIgnoreCase("mnoabc", "xyz", "mno");
        assertEquals("mnoabc", result);
    }

    @Test
    public void testPrependIfMissingIgnoreCaseWithExistingCaseInsensitivePrefix() {
        String result = StringUtils.prependIfMissingIgnoreCase("MNOabc", "xyz", "mno");
        assertEquals("MNOabc", result);
    }





    @Test
    public void testGetDigits_Null() {
        String str = null;
        String result = StringUtils.getDigits(str);
        assertNull(result);
    }

    @Test
    public void testGetDigits_Empty() {
        String str = "";
        String result = StringUtils.getDigits(str);
        assertEquals("", result);
    }

    @Test
    public void testGetDigits_NoDigits() {
        String str = "abc";
        String result = StringUtils.getDigits(str);
        assertEquals("", result);
    }

    @Test
    public void testGetDigits_DigitsInMiddle() {
        String str = "1000$";
        String result = StringUtils.getDigits(str);
        assertEquals("1000", result);
    }

    @Test
    public void testGetDigits_DigitsAtEnds() {
        String str = "1123~45";
        String result = StringUtils.getDigits(str);
        assertEquals("112345", result);
    }

    @Test
    public void testGetDigits_DigitsWithSpecialCharacters() {
        String str = "(541) 754-3010";
        String result = StringUtils.getDigits(str);
        assertEquals("5417543010", result);
    }

    @Test
    public void testGetDigits_UnicodeDigits() {
        String str = "\u0967\u0968\u0969";
        String result = StringUtils.getDigits(str);
        assertEquals("\u0967\u0968\u0969", result);
    }






    @Test
    public void testIsAllUpperCase_null() {
        assertFalse(StringUtils.isAllUpperCase(null));
    }
    
    @Test
    public void testIsAllUpperCase_empty() {
        assertFalse(StringUtils.isAllUpperCase(""));
    }
    
    @Test
    public void testIsAllUpperCase_spaces() {
        assertFalse(StringUtils.isAllUpperCase("  "));
    }
    
    @Test
    public void testIsAllUpperCase_allUpperCase() {
        assertTrue(StringUtils.isAllUpperCase("ABC"));
    }
    
    @Test
    public void testIsAllUpperCase_mixedCase() {
        assertFalse(StringUtils.isAllUpperCase("aBC"));
    }
    
    @Test
    public void testIsAllUpperCase_upperCaseWithSpace() {
        assertFalse(StringUtils.isAllUpperCase("A C"));
    }
    
    @Test
    public void testIsAllUpperCase_upperCaseWithNumber() {
        assertFalse(StringUtils.isAllUpperCase("A1C"));
    }
    
    @Test
    public void testIsAllUpperCase_upperCaseWithSpecialChar() {
        assertFalse(StringUtils.isAllUpperCase("A/C"));
    }





    @Test
    public void testIndexOfDifferenceArray() {
        assertEquals(-1, StringUtils.indexOfDifference((CharSequence[]) null));
        assertEquals(-1, StringUtils.indexOfDifference(new String[] {}));
        assertEquals(-1, StringUtils.indexOfDifference(new String[] {"abc"}));
        assertEquals(-1, StringUtils.indexOfDifference(new String[] {null, null}));
        assertEquals(-1, StringUtils.indexOfDifference(new String[] {"", ""}));
        assertEquals(0, StringUtils.indexOfDifference(new String[] {"", null}));
        assertEquals(0, StringUtils.indexOfDifference(new String[] {"abc", null, null}));
        assertEquals(0, StringUtils.indexOfDifference(new String[] {null, null, "abc"}));
        assertEquals(0, StringUtils.indexOfDifference(new String[] {"", "abc"}));
        assertEquals(0, StringUtils.indexOfDifference(new String[] {"abc", ""}));
        assertEquals(-1, StringUtils.indexOfDifference(new String[] {"abc", "abc"}));
        assertEquals(1, StringUtils.indexOfDifference(new String[] {"abc", "a"}));
        assertEquals(2, StringUtils.indexOfDifference(new String[] {"ab", "abxyz"}));
        assertEquals(2, StringUtils.indexOfDifference(new String[] {"abcde", "abxyz"}));
        assertEquals(0, StringUtils.indexOfDifference(new String[] {"abcde", "xyz"}));
        assertEquals(0, StringUtils.indexOfDifference(new String[] {"xyz", "abcde"}));
        assertEquals(7, StringUtils.indexOfDifference(new String[] {"i am a machine", "i am a robot"}));
    }

    @Test
    public void testIndexOfDifferenceTwoStrings() {
        assertEquals(-1, StringUtils.indexOfDifference(null, null));
        assertEquals(-1, StringUtils.indexOfDifference("", ""));
        assertEquals(0, StringUtils.indexOfDifference("", "abc"));
        assertEquals(0, StringUtils.indexOfDifference("abc", ""));
        assertEquals(-1, StringUtils.indexOfDifference("abc", "abc"));
        assertEquals(2, StringUtils.indexOfDifference("ab", "abxyz"));
        assertEquals(2, StringUtils.indexOfDifference("abcde", "abxyz"));
        assertEquals(0, StringUtils.indexOfDifference("abcde", "xyz"));
        assertEquals(7, StringUtils.indexOfDifference("i am a machine", "i am a robot"));
    }







    @Test
    public void removeEndIgnoreCaseTest_nullSourceString() {
        String source = null;
        String toRemove = "remove";
        assertNull(StringUtils.removeEndIgnoreCase(source, toRemove));
    }

    @Test
    public void removeEndIgnoreCaseTest_emptySourceString() {
        String source = "";
        String toRemove = "remove";
        assertEquals("", StringUtils.removeEndIgnoreCase(source, toRemove));
    }

    @Test
    public void removeEndIgnoreCaseTest_nullToRemoveString() {
        String source = "source";
        String toRemove = null;
        assertEquals("source", StringUtils.removeEndIgnoreCase(source, toRemove));
    }

    @Test
    public void removeEndIgnoreCaseTest_removeStringNotAtEnd() {
        String source = "www.domain.com";
        String toRemove = "domain";
        assertEquals("www.domain.com", StringUtils.removeEndIgnoreCase(source, toRemove));
    }

    @Test
    public void removeEndIgnoreCaseTest_removeStringAtEnd() {
        String source = "www.domain.com";
        String toRemove = ".com";
        assertEquals("www.domain", StringUtils.removeEndIgnoreCase(source, toRemove));
    }

    @Test
    public void removeEndIgnoreCaseTest_removeStringAtEnd_ignoreCase() {
        String source = "www.domain.COM";
        String toRemove = ".com";
        assertEquals("www.domain", StringUtils.removeEndIgnoreCase(source, toRemove));
    }




    @Test
    public void removeAllShouldReturnNullWhenTextIsNull() {
        try (MockedStatic<RegExUtils> mocked = Mockito.mockStatic(RegExUtils.class)) {
            mocked.when(() -> RegExUtils.removeAll(null, ".*")).thenReturn(null);
            assertNull(StringUtils.removeAll(null, ".*"));
        }
    }

    @Test
    public void removeAllShouldReturnUnchangedStringWhenRegexIsNull() {
        String text = "any";
        try (MockedStatic<RegExUtils> mocked = Mockito.mockStatic(RegExUtils.class)) {
            mocked.when(() -> RegExUtils.removeAll(text, null)).thenReturn(text);
            assertEquals(text, StringUtils.removeAll(text, null));
        }
    }

    @Test
    public void removeAllShouldReturnUnchangedStringWhenRegexIsEmpty() {
        String text = "any";
        try (MockedStatic<RegExUtils> mocked = Mockito.mockStatic(RegExUtils.class)) {
            mocked.when(() -> RegExUtils.removeAll(text, "")).thenReturn(text);
            assertEquals(text, StringUtils.removeAll(text, ""));
        }
    }

    @Test
    public void removeAllShouldRemoveAllMatches() {
        String text = "ABCabc123abc";
        String regex = "[a-z]";
        try (MockedStatic<RegExUtils> mocked = Mockito.mockStatic(RegExUtils.class)) {
            mocked.when(() -> RegExUtils.removeAll(text, regex)).thenReturn("ABC123");
            assertEquals("ABC123", StringUtils.removeAll(text, regex));
        }
    }








    @Test
    public void testLastIndexOfAnyWithNullString() {
        CharSequence[] searchStrings = {"ab", "cd"};
        int result = StringUtils.lastIndexOfAny(null, searchStrings);
        assertEquals(-1, result);
    }

    @Test
    public void testLastIndexOfAnyWithNullSearchArray() {
        CharSequence str = "zzabyycdxx";
        int result = StringUtils.lastIndexOfAny(str, null);
        assertEquals(-1, result);
    }

    @Test
    public void testLastIndexOfAnyWithEmptySearchArray() {
        CharSequence str = "zzabyycdxx";
        CharSequence[] searchStrings = {};
        int result = StringUtils.lastIndexOfAny(str, searchStrings);
        assertEquals(-1, result);
    }

    @Test
    public void testLastIndexOfAnyWithSearchArrayContainingNull() {
        CharSequence str = "zzabyycdxx";
        CharSequence[] searchStrings = {null};
        int result = StringUtils.lastIndexOfAny(str, searchStrings);
        assertEquals(-1, result);
    }

    @Test
    public void testLastIndexOfAnyWithValidStringAndSearchArray() {
        CharSequence str = "zzabyycdxx";
        CharSequence[] searchStrings = {"ab", "cd"};
        int result = StringUtils.lastIndexOfAny(str, searchStrings);
        assertEquals(6, result);
    }

    @Test
    public void testLastIndexOfAnyWithSearchArrayNotContainingSubString() {
        CharSequence str = "zzabyycdxx";
        CharSequence[] searchStrings = {"mn", "op"};
        int result = StringUtils.lastIndexOfAny(str, searchStrings);
        assertEquals(-1, result);
    }

    @Test
    public void testLastIndexOfAnyWithSearchArrayContainingEmptyString() {
        CharSequence str = "zzabyycdxx";
        CharSequence[] searchStrings = {"mn", ""};
        int result = StringUtils.lastIndexOfAny(str, searchStrings);
        assertEquals(10, result);
    }




    @Test
    public void testUpperCaseNullInput() {
        String str = null;
        String result = StringUtils.upperCase(str);
        assertNull(result);
    }

    @Test
    public void testUpperCaseEmptyInput() {
        String str = "";
        String result = StringUtils.upperCase(str);
        assertEquals("", result);
    }

    @Test
    public void testUpperCaseLowercaseInput() {
        String str = "abc";
        String result = StringUtils.upperCase(str);
        assertEquals("ABC", result);
    }

    @Test
    public void testUpperCaseMixedCaseInput() {
        String str = "aBc";
        String result = StringUtils.upperCase(str);
        assertEquals("ABC", result);
    }

    @Test
    public void testUpperCaseNullLocaleInput() {
        String str = "abc";
        Locale locale = null;
        assertThrows(NullPointerException.class, () -> StringUtils.upperCase(str, locale));
    }

    @Test
    public void testUpperCaseEmptyLocaleInput() {
        String str = "";
        Locale locale = Locale.ENGLISH;
        String result = StringUtils.upperCase(str, locale);
        assertEquals("", result);
    }

    @Test
    public void testUpperCaseLowercaseLocaleInput() {
        String str = "abc";
        Locale locale = Locale.ENGLISH;
        String result = StringUtils.upperCase(str, locale);
        assertEquals("ABC", result);
    }

    @Test
    public void testUpperCaseMixedCaseLocaleInput() {
        String str = "aBc";
        Locale locale = Locale.ENGLISH;
        String result = StringUtils.upperCase(str, locale);
        assertEquals("ABC", result);
    }










    @Test
    @DisplayName("Test toString() method with UTF-8 encoding")
    public void testToStringWithUTF8Encoding() throws UnsupportedEncodingException {
        byte[] bytes = "test".getBytes(StandardCharsets.UTF_8);
        String result = StringUtils.toString(bytes, "UTF-8");
        assertEquals("test", result);
    }

    @Test
    @DisplayName("Test toString() method with ISO-8859-1 encoding")
    public void testToStringWithISO88591Encoding() throws UnsupportedEncodingException {
        byte[] bytes = "test".getBytes(StandardCharsets.ISO_8859_1);
        String result = StringUtils.toString(bytes, "ISO-8859-1");
        assertEquals("test", result);
    }

    @Test
    @DisplayName("Test toString() method with null bytes")
    public void testToStringWithNullBytes() {
        assertThrows(NullPointerException.class, () -> StringUtils.toString(null, "UTF-8"));
    }

    @Test
    @DisplayName("Test toString() method with null charset name")
    public void testToStringWithNullCharsetName() throws UnsupportedEncodingException {
        byte[] bytes = "test".getBytes(StandardCharsets.UTF_8);
        String result = StringUtils.toString(bytes, null);
        assertEquals("test", result);
    }

    @Test
    @DisplayName("Test toString() method with unsupported encoding")
    public void testToStringWithUnsupportedEncoding() {
        byte[] bytes = "test".getBytes(StandardCharsets.UTF_8);
        assertThrows(UnsupportedEncodingException.class, () -> StringUtils.toString(bytes, "unsupported"));
    }



    @Test
    public void replacePatternTest() {
        // Test case: replace all lowercase letters in the string with "_"
        String source = "ABCabc123";
        String regex = "[a-z]";
        String replacement = "_";
        String expected = "ABC___123";
        String actual = StringUtils.replacePattern(source, regex, replacement);
        assertEquals(expected, actual, "The replacePattern method did not work as expected.");

        // Test case: remove all non alphanumeric characters from the string
        source = "ABCabc123";
        regex = "[^A-Z0-9]+";
        replacement = "";
        expected = "ABCabc123";
        actual = StringUtils.replacePattern(source, regex, replacement);
        assertEquals(expected, actual, "The replacePattern method did not work as expected.");

        // Test case: replace multiple spaces between words with a single underscore
        source = "Lorem ipsum  dolor   sit";
        regex = "( +)([a-z]+)";
        replacement = "_$2";
        expected = "Lorem_ipsum_dolor_sit";
        actual = StringUtils.replacePattern(source, regex, replacement);
        assertEquals(expected, actual, "The replacePattern method did not work as expected.");

        // Test case: source is null
        source = null;
        regex = "[a-z]";
        replacement = "_";
        assertNull(StringUtils.replacePattern(source, regex, replacement), "The replacePattern method did not work as expected when source is null.");

        // Test case: regex is null
        source = "ABCabc123";
        regex = null;
        replacement = "_";
        assertEquals(source, StringUtils.replacePattern(source, regex, replacement), "The replacePattern method did not work as expected when regex is null.");

        // Test case: replacement is null
        source = "ABCabc123";
        regex = "[a-z]";
        replacement = null;
        assertEquals(source, StringUtils.replacePattern(source, regex, replacement), "The replacePattern method did not work as expected when replacement is null.");
    }




    @Test
    public void testTruncateWhenStringLengthIsLessThanMaxWidth() {
        String str = "Hello";
        int maxWidth = 10;
        String result = StringUtils.truncate(str, maxWidth);
        assertEquals(str, result);
    }

    @Test
    public void testTruncateWhenStringLengthIsEqualToMaxWidth() {
        String str = "HelloWorld";
        int maxWidth = 10;
        String result = StringUtils.truncate(str, maxWidth);
        assertEquals(str, result);
    }

    @Test
    public void testTruncateWhenStringLengthIsGreaterThanMaxWidth() {
        String str = "HelloWorld";
        int maxWidth = 5;
        String result = StringUtils.truncate(str, maxWidth);
        assertEquals("Hello", result);
    }

    @Test
    public void testTruncateWhenMaxWidthIsLessThanZero() {
        String str = "HelloWorld";
        int maxWidth = -1;
        assertThrows(IllegalArgumentException.class, () -> StringUtils.truncate(str, maxWidth));
    }

    @Test
    public void testTruncateWhenStringIsNull() {
        String str = null;
        int maxWidth = 5;
        String result = StringUtils.truncate(str, maxWidth);
        assertNull(result);
    }

    @Test
    public void testTruncateWithOffsetWhenOffsetIsGreaterThanStringLength() {
        String str = "HelloWorld";
        int offset = 15;
        int maxWidth = 5;
        String result = StringUtils.truncate(str, offset, maxWidth);
        assertEquals("", result);
    }

    @Test
    public void testTruncateWithOffsetWhenOffsetIsLessThanZero() {
        String str = "HelloWorld";
        int offset = -1;
        int maxWidth = 5;
        assertThrows(IllegalArgumentException.class, () -> StringUtils.truncate(str, offset, maxWidth));
    }

    @Test
    public void testTruncateWithOffsetWhenMaxWidthIsLessThanZero() {
        String str = "HelloWorld";
        int offset = 3;
        int maxWidth = -1;
        assertThrows(IllegalArgumentException.class, () -> StringUtils.truncate(str, offset, maxWidth));
    }

    @Test
    public void testTruncateWithOffsetWhenOffsetIsLessThanStringLengthAndMaxWidthIsGreaterThanStringLength() {
        String str = "HelloWorld";
        int offset = 3;
        int maxWidth = 15;
        String result = StringUtils.truncate(str, offset, maxWidth);
        assertEquals("loWorld", result);
    }

    @Test
    public void testTruncateWithOffsetWhenOffsetIsLessThanStringLengthAndMaxWidthIsLessThanStringLength() {
        String str = "HelloWorld";
        int offset = 3;
        int maxWidth = 5;
        String result = StringUtils.truncate(str, offset, maxWidth);
        assertEquals("loWor", result);
    }




    @Test
    public void startsWith_bothNull_returnsTrue() {
        assertTrue(StringUtils.startsWith(null, null));
    }

    @Test
    public void startsWith_stringIsNull_returnsFalse() {
        assertFalse(StringUtils.startsWith(null, "abc"));
    }

    @Test
    public void startsWith_prefixIsNull_returnsFalse() {
        assertFalse(StringUtils.startsWith("abcdef", null));
    }

    @Test
    public void startsWith_stringStartsWithPrefix_returnsTrue() {
        assertTrue(StringUtils.startsWith("abcdef", "abc"));
    }

    @Test
    public void startsWith_stringDoesNotStartWithPrefix_returnsFalse() {
        assertFalse(StringUtils.startsWith("abcdef", "xyz"));
    }

    @Test
    public void startsWith_caseSensitiveCheck_returnsFalse() {
        assertFalse(StringUtils.startsWith("ABCDEF", "abc"));
    }





    @Test
    public void testRightPadNullString() {
        assertNull(StringUtils.rightPad(null, 5));
    }

    @Test
    public void testRightPadEmptyString() {
        assertEquals("     ", StringUtils.rightPad("", 5));
    }

    @Test
    public void testRightPadStringNoPaddingNeeded() {
        assertEquals("test", StringUtils.rightPad("test", 4));
    }

    @Test
    public void testRightPadStringPaddingNeeded() {
        assertEquals("test  ", StringUtils.rightPad("test", 6));
    }

    @Test
    public void testRightPadStringNegativeSize() {
        assertEquals("test", StringUtils.rightPad("test", -1));
    }

    @Test
    public void testRightPadStringZeroSize() {
        assertEquals("test", StringUtils.rightPad("test", 0));
    }

    @Test
    public void testRightPadStringWithChar() {
        assertEquals("testzz", StringUtils.rightPad("test", 6, 'z'));
    }

    @Test
    public void testRightPadStringWithPadString() {
        assertEquals("testyz", StringUtils.rightPad("test", 6, "yz"));
    }

    @Test
    public void testRightPadStringWithEmptyPadString() {
        assertEquals("test  ", StringUtils.rightPad("test", 6, ""));
    }

    @Test
    public void testRightPadStringWithNullPadString() {
        assertEquals("test  ", StringUtils.rightPad("test", 6, null));
    }
    
    @Test
    public void testRightPadStringWithLongerPadString() {
        assertEquals("testyzyzyzyzyz", StringUtils.rightPad("test", 14, "yz"));
    }




    @Test
    public void testIsAllLowerCase_NullInput() {
        assertFalse(StringUtils.isAllLowerCase(null));
    }

    @Test
    public void testIsAllLowerCase_EmptyString() {
        assertFalse(StringUtils.isAllLowerCase(""));
    }

    @Test
    public void testIsAllLowerCase_WhiteSpace() {
        assertFalse(StringUtils.isAllLowerCase("   "));
    }

    @Test
    public void testIsAllLowerCase_AllLowerCaseLetters() {
        assertTrue(StringUtils.isAllLowerCase("abc"));
    }

    @Test
    public void testIsAllLowerCase_MixedCaseLetters() {
        assertFalse(StringUtils.isAllLowerCase("abC"));
    }

    @Test
    public void testIsAllLowerCase_LowerCaseLettersWithSpace() {
        assertFalse(StringUtils.isAllLowerCase("ab c"));
    }

    @Test
    public void testIsAllLowerCase_LowerCaseLettersWithNumbers() {
        assertFalse(StringUtils.isAllLowerCase("ab1c"));
    }

    @Test
    public void testIsAllLowerCase_LowerCaseLettersWithSpecialCharacters() {
        assertFalse(StringUtils.isAllLowerCase("ab/c"));
    }






    @Test
    public void defaultString_NullInput_ReturnsEmptyString() {
        String input = null;
        String result = StringUtils.defaultString(input);
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void defaultString_EmptyInput_ReturnsEmptyString() {
        String input = "";
        String result = StringUtils.defaultString(input);
        assertEquals(StringUtils.EMPTY, result);
    }

    @Test
    public void defaultString_ValidInput_ReturnsSameString() {
        String input = "bat";
        String result = StringUtils.defaultString(input);
        assertEquals(input, result);
    }




    @Test
    public void testSubstringBetween() {
        // Test with null string
        assertNull(StringUtils.substringBetween(null, "tag"));

        // Test with empty string and empty tag
        assertEquals("", StringUtils.substringBetween("", ""));

        // Test with empty string and non-empty tag
        assertNull(StringUtils.substringBetween("", "tag"));

        // Test with valid string and null tag
        assertNull(StringUtils.substringBetween("tagabctag", null));

        // Test with valid string and empty tag
        assertEquals("", StringUtils.substringBetween("tagabctag", ""));

        // Test with valid string and valid tag
        assertEquals("abc", StringUtils.substringBetween("tagabctag", "tag"));
    }

    @Test
    public void testSubstringBetweenWithOpenAndClose() {
        // Test with null string
        assertNull(StringUtils.substringBetween(null, "[", "]"));

        // Test with valid string and null open/close tags
        assertNull(StringUtils.substringBetween("wx[b]yz", null, "]"));
        assertNull(StringUtils.substringBetween("wx[b]yz", "[", null));

        // Test with empty string and empty open/close tags
        assertEquals("", StringUtils.substringBetween("", "", ""));

        // Test with empty string and non-empty open/close tags
        assertNull(StringUtils.substringBetween("", "", "]"));
        assertNull(StringUtils.substringBetween("", "[", "]"));

        // Test with valid string and empty open/close tags
        assertEquals("", StringUtils.substringBetween("yabcz", "", ""));

        // Test with valid string and valid open/close tags
        assertEquals("abc", StringUtils.substringBetween("yabcz", "y", "z"));

        // Test with valid string and multiple matches
        assertEquals("abc", StringUtils.substringBetween("yabczyabcz", "y", "z"));
    }





    @Test
    public void testReplaceOnce_nullText() {
        String text = null;
        String searchString = "any";
        String replacement = "none";
        assertNull(StringUtils.replaceOnce(text, searchString, replacement));
    }

    @Test
    public void testReplaceOnce_emptyText() {
        String text = "";
        String searchString = "any";
        String replacement = "none";
        assertEquals("", StringUtils.replaceOnce(text, searchString, replacement));
    }

    @Test
    public void testReplaceOnce_nullSearchString() {
        String text = "any";
        String searchString = null;
        String replacement = "none";
        assertEquals("any", StringUtils.replaceOnce(text, searchString, replacement));
    }

    @Test
    public void testReplaceOnce_nullReplacement() {
        String text = "any";
        String searchString = "any";
        String replacement = null;
        assertEquals("any", StringUtils.replaceOnce(text, searchString, replacement));
    }

    @Test
    public void testReplaceOnce_emptySearchString() {
        String text = "any";
        String searchString = "";
        String replacement = "none";
        assertEquals("any", StringUtils.replaceOnce(text, searchString, replacement));
    }

    @Test
    public void testReplaceOnce_searchStringNotFound() {
        String text = "any";
        String searchString = "notfound";
        String replacement = "none";
        assertEquals("any", StringUtils.replaceOnce(text, searchString, replacement));
    }

    @Test
    public void testReplaceOnce_replacementIsSuccessful() {
        String text = "aba";
        String searchString = "a";
        String replacement = "z";
        assertEquals("zba", StringUtils.replaceOnce(text, searchString, replacement));
    }




    @Test
    public void testContainsAnyIgnoreCaseWithValidInputs() {
        // test when the char sequence contains one of the search sequences
        assertTrue(StringUtils.containsAnyIgnoreCase("abcd", "ab", "cd"));
        assertTrue(StringUtils.containsAnyIgnoreCase("abc", "d", "abc"));
        
        // Test with case differences
        assertTrue(StringUtils.containsAnyIgnoreCase("abc", "D", "ABC"));
        assertTrue(StringUtils.containsAnyIgnoreCase("ABC", "d", "abc"));
    }

    @Test
    public void testContainsAnyIgnoreCaseWithInvalidInputs() {
        // test when the char sequence does not contain any of the search sequences
        assertFalse(StringUtils.containsAnyIgnoreCase("abcd", "ef", "gh"));
        
        // Test with case differences
        assertFalse(StringUtils.containsAnyIgnoreCase("abc", "E", "FG"));
        assertFalse(StringUtils.containsAnyIgnoreCase("ABC", "h", "ij"));
    }

    @Test
    public void testContainsAnyIgnoreCaseWithEmptyInputs() {
        // test with empty char sequence
        assertFalse(StringUtils.containsAnyIgnoreCase("", "ab", "cd"));
        
        // test with empty search sequences
        assertFalse(StringUtils.containsAnyIgnoreCase("abcd", "", ""));
        
        // test with empty char sequence and search sequences
        assertFalse(StringUtils.containsAnyIgnoreCase("", "", ""));
    }

    @Test
    public void testContainsAnyIgnoreCaseWithNullInputs() {
        // test with null char sequence
        assertFalse(StringUtils.containsAnyIgnoreCase(null, "ab", "cd"));
        
        // test with null search sequences
        assertFalse(StringUtils.containsAnyIgnoreCase("abcd", null));
        
        // test with null char sequence and search sequences
        assertFalse(StringUtils.containsAnyIgnoreCase(null, (CharSequence[]) null));
    }







    @Test
    public void testLeftPad_nullString() {
        assertNull(StringUtils.leftPad(null, 5));
    }

    @Test
    public void testLeftPad_emptyString() {
        assertEquals("    ", StringUtils.leftPad("", 4));
    }

    @Test
    public void testLeftPad_sameSize() {
        assertEquals("test", StringUtils.leftPad("test", 4));
    }

    @Test
    public void testLeftPad_largerSize() {
        assertEquals("  test", StringUtils.leftPad("test", 6));
    }

    @Test
    public void testLeftPad_smallerSize() {
        assertEquals("test", StringUtils.leftPad("test", 3));
    }

    @Test
    public void testLeftPad_negativeSize() {
        assertEquals("test", StringUtils.leftPad("test", -1));
    }

    @Test
    public void testLeftPad_withChar_nullString() {
        assertNull(StringUtils.leftPad(null, 5, 'x'));
    }

    @Test
    public void testLeftPad_withChar_emptyString() {
        assertEquals("xxxx", StringUtils.leftPad("", 4, 'x'));
    }

    @Test
    public void testLeftPad_withChar_sameSize() {
        assertEquals("test", StringUtils.leftPad("test", 4, 'x'));
    }

    @Test
    public void testLeftPad_withChar_largerSize() {
        assertEquals("xxtest", StringUtils.leftPad("test", 6, 'x'));
    }

    @Test
    public void testLeftPad_withChar_smallerSize() {
        assertEquals("test", StringUtils.leftPad("test", 3, 'x'));
    }

    @Test
    public void testLeftPad_withChar_negativeSize() {
        assertEquals("test", StringUtils.leftPad("test", -1, 'x'));
    }

    @Test
    public void testLeftPad_withString_nullString() {
        assertNull(StringUtils.leftPad(null, 5, "xy"));
    }

    @Test
    public void testLeftPad_withString_emptyString() {
        assertEquals("xyxy", StringUtils.leftPad("", 4, "xy"));
    }

    @Test
    public void testLeftPad_withString_sameSize() {
        assertEquals("test", StringUtils.leftPad("test", 4, "xy"));
    }

    @Test
    public void testLeftPad_withString_largerSize() {
        assertEquals("xytest", StringUtils.leftPad("test", 6, "xy"));
    }

    @Test
    public void testLeftPad_withString_smallerSize() {
        assertEquals("test", StringUtils.leftPad("test", 3, "xy"));
    }

    @Test
    public void testLeftPad_withString_negativeSize() {
        assertEquals("test", StringUtils.leftPad("test", -1, "xy"));
    }

    @Test
    public void testLeftPad_withString_nullPadString() {
        assertEquals("  test", StringUtils.leftPad("test", 6, null));
    }

    @Test
    public void testLeftPad_withString_emptyPadString() {
        assertEquals("  test", StringUtils.leftPad("test", 6, ""));
    }





}