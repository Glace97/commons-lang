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

public class CharSequenceUtilsTest {
    @Test
    void testRegionMatches_sameCase() {
        CharSequence cs = "Hello World";
        CharSequence substring = "World";
        assertTrue(CharSequenceUtils.regionMatches(cs, false, 6, substring, 0, 5));
    }
    
    @Test
    void testRegionMatches_differentCase() {
        CharSequence cs = "Hello World";
        CharSequence substring = "wOrLd";
        assertTrue(CharSequenceUtils.regionMatches(cs, true, 6, substring, 0, 5));
    }
    
    @Test
    void testRegionMatches_ignoreCase() {
        CharSequence cs = "Hello World";
        CharSequence substring = "wOrLd";
        assertFalse(CharSequenceUtils.regionMatches(cs, false, 6, substring, 0, 5));
    }
    
    @Test
    void testRegionMatches_invalidParameters() {
        CharSequence cs = "Hello World";
        CharSequence substring = "World";
        assertFalse(CharSequenceUtils.regionMatches(cs, false, -1, substring, 0, 5));
    }
    
    @Test
    void testRegionMatches_shortRegion() {
        CharSequence cs = "Hello World";
        CharSequence substring = "World";
        assertFalse(CharSequenceUtils.regionMatches(cs, false, 6, substring, 0, 6));
    }
    
    @Test
    void testRegionMatches_longRegion() {
        CharSequence cs = "Hello World";
        CharSequence substring = "World";
        assertFalse(CharSequenceUtils.regionMatches(cs, false, 6, substring, 0, 4));
    }
    
    @Test
    void testRegionMatches_emptyCharSequence() {
        CharSequence cs = "";
        CharSequence substring = "World";
        assertFalse(CharSequenceUtils.regionMatches(cs, false, 0, substring, 0, 5));
    }
    
    @Test
    void testRegionMatches_emptySubstring() {
        CharSequence cs = "Hello World";
        CharSequence substring = "";
        assertTrue(CharSequenceUtils.regionMatches(cs, false, 0, substring, 0, 0));
    }
    
    @Test
    void testRegionMatches_nullCharSequence() {
        CharSequence cs = null;
        CharSequence substring = "World";
        assertFalse(CharSequenceUtils.regionMatches(cs, false, 0, substring, 0, 5));
    }
    
    @Test
    void testRegionMatches_nullSubstring() {
        CharSequence cs = "Hello World";
        CharSequence substring = null;
        assertFalse(CharSequenceUtils.regionMatches(cs, false, 0, substring, 0, 5));
    }
    @Test
    void testToCharArray_EmptyString() {
        CharSequence source = "";
        char[] result = CharSequenceUtils.toCharArray(source);
        assertArrayEquals(new char[]{}, result);
    }
    
    @Test
    void testToCharArray_String() {
        CharSequence source = "Hello World";
        char[] result = CharSequenceUtils.toCharArray(source);
        assertArrayEquals(new char[]{'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd'}, result);
    }
    
    @Test
    void testToCharArray_SubclassOfString() {
        class CustomString extends String {
            public CustomString(String original) {
                super(original);
            }
        }
    
        CharSequence source = new CustomString("Custom String");
        char[] result = CharSequenceUtils.toCharArray(source);
        assertArrayEquals(new char[]{'C', 'u', 's', 't', 'o', 'm', ' ', 'S', 't', 'r', 'i', 'n', 'g'}, result);
    }
    
    @Test
    void testToCharArray_NonString() {
        CharSequence source = new StringBuilder("StringBuilder");
        char[] result = CharSequenceUtils.toCharArray(source);
        assertArrayEquals(new char[]{'S', 't', 'r', 'i', 'n', 'g', 'B', 'u', 'i', 'l', 'd', 'e', 'r'}, result);
    }
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    import org.junit.jupiter.api.TestInstance.Lifecycle;
    
    import static org.junit.jupiter.api.Assertions.*;
    
    @TestInstance(Lifecycle.PER_CLASS)
    public class CharSequenceUtilsTest {
    
        private static final String TEST_STRING = "abcdefghijklmnopqrstuvwxyz";
        private static final int TEST_STRING_LENGTH = TEST_STRING.length();
    
        @Test
        void testSubSequenceWithNull() {
            assertNull(CharSequenceUtils.subSequence(null, 0));
        }
    
        @Test
        void testSubSequenceWithEmptyString() {
            assertEquals("", CharSequenceUtils.subSequence("", 0));
        }
    
        @Test
        void testSubSequenceWithValidStartIndex() {
            assertEquals(TEST_STRING, CharSequenceUtils.subSequence(TEST_STRING, 0));
        }
    
        @Test
        void testSubSequenceWithStartIndexGreaterThanLength() {
            assertThrows(IndexOutOfBoundsException.class, () ->
                    CharSequenceUtils.subSequence(TEST_STRING, TEST_STRING_LENGTH + 1));
        }
    
        @Test
        void testSubSequenceWithNegativeStartIndex() {
            assertThrows(IndexOutOfBoundsException.class, () ->
                    CharSequenceUtils.subSequence(TEST_STRING, -1));
        }
    
        @Test
        void testSubSequenceWithStartIndexEqualToLength() {
            assertEquals("", CharSequenceUtils.subSequence(TEST_STRING, TEST_STRING_LENGTH));
        }
    }
    @Test
    public void testLastIndexOf_WithNullSearchChar_ReturnsNotFound() {
        CharSequence cs = "hello world";
        CharSequence searchChar = null;
        int start = 0;
    
        int result = charSequenceUtils.lastIndexOf(cs, searchChar, start);
    
        Assertions.assertEquals(-1, result);
    }
    
    @Test
    public void testLastIndexOf_WithNullCS_ReturnsNotFound() {
        CharSequence cs = null;
        CharSequence searchChar = "world";
        int start = 0;
    
        int result = charSequenceUtils.lastIndexOf(cs, searchChar, start);
    
        Assertions.assertEquals(-1, result);
    }
    
    @Test
    public void testLastIndexOf_WithEmptyCS_ReturnsNotFound() {
        CharSequence cs = "";
        CharSequence searchChar = "world";
        int start = 0;
    
        int result = charSequenceUtils.lastIndexOf(cs, searchChar, start);
    
        Assertions.assertEquals(-1, result);
    }
    
    @Test
    public void testLastIndexOf_WithEmptySearchChar_ReturnsStartIndex() {
        CharSequence cs = "hello world";
        CharSequence searchChar = "";
        int start = 5;
    
        int result = charSequenceUtils.lastIndexOf(cs, searchChar, start);
    
        Assertions.assertEquals(start, result);
    }
    
    @Test
    public void testLastIndexOf_WithSearchCharNotInCS_ReturnsNotFound() {
        CharSequence cs = "hello world";
        CharSequence searchChar = "foo";
        int start = 0;
    
        int result = charSequenceUtils.lastIndexOf(cs, searchChar, start);
    
        Assertions.assertEquals(-1, result);
    }
    
    @Test
    public void testLastIndexOf_WithSearchCharInCS_ReturnsCorrectIndex() {
        CharSequence cs = "hello world";
        CharSequence searchChar = "o";
        int start = 0;
    
        int result = charSequenceUtils.lastIndexOf(cs, searchChar, start);
    
        Assertions.assertEquals(7, result);
    }
    
    @Test
    public void testLastIndexOf_WithStartGreaterThanCSLength_ReturnsLastIndex() {
        CharSequence cs = "hello world";
        CharSequence searchChar = "o";
        int start = 100;
    
        int result = charSequenceUtils.lastIndexOf(cs, searchChar, start);
    
        Assertions.assertEquals(7, result);
    }
    
    @Test
    public void testLastIndexOf_WithStartLessThanZero_ReturnsNotFound() {
        CharSequence cs = "hello world";
        CharSequence searchChar = "o";
        int start = -1;
    
        int result = charSequenceUtils.lastIndexOf(cs, searchChar, start);
    
        Assertions.assertEquals(-1, result);
    }
    
    @Test
    public void testLastIndexOf_WithSearchCharAsInt_ReturnsCorrectIndex() {
        CharSequence cs = "hello world";
        int searchChar = 'o';
        int start = 0;
    
        int result = charSequenceUtils.lastIndexOf(cs, searchChar, start);
    
        Assertions.assertEquals(7, result);
    }
    
    @Test
    public void testLastIndexOf_WithSearchCharAsSupplementaryChar_ReturnsCorrectIndex() {
        CharSequence cs = "hello world";
        int searchChar = 128149; // Heart emoji
        int start = 0;
    
        int result = charSequenceUtils.lastIndexOf(cs, searchChar, start);
    
        Assertions.assertEquals(-1, result);
    }
    
    @Test
    public void testLastIndexOf_WithStartGreaterThanCSEnd_ReturnsNotFound() {
        CharSequence cs = "hello world";
        int searchChar = 'o';
        int start = 100;
    
        int result = charSequenceUtils.lastIndexOf(cs, searchChar, start);
    
        Assertions.assertEquals(-1, result);
    }
    
    @Test
    public void testLastIndexOf_WithStartLessThanZeroForSupplementaryChar_ReturnsNotFound() {
        CharSequence cs = "hello world";
        int searchChar = 128149; // Heart emoji
        int start = -1;
    
        int result = charSequenceUtils.lastIndexOf(cs, searchChar, start);
    
        Assertions.assertEquals(-1, result);
    }
    @Test
    void testCheckLaterThan1ReturnsTrueWhenCharSequencesMatch() {
        CharSequence cs = "abcdef";
        CharSequence searchChar = "cde";
        int len2 = searchChar.length();
        int start1 = 2;
    
        assertTrue(CharSequenceUtils.checkLaterThan1(cs, searchChar, len2, start1));
    }
    
    @Test
    void testCheckLaterThan1ReturnsFalseWhenCharSequencesDoNotMatch() {
        CharSequence cs = "abcdef";
        CharSequence searchChar = "cde";
        int len2 = searchChar.length();
        int start1 = 0;
    
        assertFalse(CharSequenceUtils.checkLaterThan1(cs, searchChar, len2, start1));
    }
    
    @Test
    void testCheckLaterThan1ReturnsTrueWhenCharSequencesAreEmpty() {
        CharSequence cs = "";
        CharSequence searchChar = "";
        int len2 = searchChar.length();
        int start1 = 0;
    
        assertTrue(CharSequenceUtils.checkLaterThan1(cs, searchChar, len2, start1));
    }
    
    @Test
    void testCheckLaterThan1ReturnsTrueWhenCharSequencesHaveOnlyOneCharacter() {
        CharSequence cs = "a";
        CharSequence searchChar = "a";
        int len2 = searchChar.length();
        int start1 = 0;
    
        assertTrue(CharSequenceUtils.checkLaterThan1(cs, searchChar, len2, start1));
    }
    
    @Test
    void testCheckLaterThan1ReturnsFalseWhenCharSequencesHaveDifferentLengths() {
        CharSequence cs = "abc";
        CharSequence searchChar = "abcd";
        int len2 = searchChar.length();
        int start1 = 0;
    
        assertFalse(CharSequenceUtils.checkLaterThan1(cs, searchChar, len2, start1));
    }
    
    @Test
    void testCheckLaterThan1ReturnsFalseWhenCharSequencesAreNull() {
        CharSequence cs = null;
        CharSequence searchChar = null;
        int len2 = 0;
        int start1 = 0;
    
        assertFalse(CharSequenceUtils.checkLaterThan1(cs, searchChar, len2, start1));
    }
    @Test
    @DisplayName("When cs and searchChar are empty, start is 0, expect -1")
    void testIndexOfEmptyStrings() {
        CharSequence cs = "";
        CharSequence searchChar = "";
        int start = 0;
        int expected = -1;
    
        int result = charSequenceUtils.indexOf(cs, searchChar, start);
    
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("When cs is empty, searchChar is not empty, start is 0, expect -1")
    void testIndexOfEmptyCs() {
        CharSequence cs = "";
        CharSequence searchChar = "abc";
        int start = 0;
        int expected = -1;
    
        int result = charSequenceUtils.indexOf(cs, searchChar, start);
    
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("When cs is not empty, searchChar is empty, start is 0, expect 0")
    void testIndexOfEmptySearchChar() {
        CharSequence cs = "abc";
        CharSequence searchChar = "";
        int start = 0;
        int expected = 0;
    
        int result = charSequenceUtils.indexOf(cs, searchChar, start);
    
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("When cs and searchChar are equal, start is 0, expect 0")
    void testIndexOfEqualStrings() {
        CharSequence cs = "abc";
        CharSequence searchChar = "abc";
        int start = 0;
        int expected = 0;
    
        int result = charSequenceUtils.indexOf(cs, searchChar, start);
    
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("When cs contains searchChar, start is 0, expect 1")
    void testIndexOfSubstring() {
        CharSequence cs = "abcabc";
        CharSequence searchChar = "bc";
        int start = 0;
        int expected = 1;
    
        int result = charSequenceUtils.indexOf(cs, searchChar, start);
    
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("When cs does not contain searchChar, start is 0, expect -1")
    void testIndexOfNotFound() {
        CharSequence cs = "abc";
        CharSequence searchChar = "def";
        int start = 0;
        int expected = -1;
    
        int result = charSequenceUtils.indexOf(cs, searchChar, start);
    
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("When start index is negative, expect -1")
    void testIndexOfNegativeStart() {
        CharSequence cs = "abc";
        CharSequence searchChar = "a";
        int start = -1;
        int expected = -1;
    
        int result = charSequenceUtils.indexOf(cs, searchChar, start);
    
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("When start index is greater than cs length, expect -1")
    void testIndexOfStartGreaterThanCsLength() {
        CharSequence cs = "abc";
        CharSequence searchChar = "a";
        int start = 10;
        int expected = -1;
    
        int result = charSequenceUtils.indexOf(cs, searchChar, start);
    
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("When cs is empty, start is 0, expect -1")
    void testIndexOfEmptyCs() {
        CharSequence cs = "";
        int searchChar = 'a';
        int start = 0;
        int expected = -1;
    
        int result = charSequenceUtils.indexOf(cs, searchChar, start);
    
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("When cs does not contain searchChar, start is 0, expect -1")
    void testIndexOfCharNotFound() {
        CharSequence cs = "abc";
        int searchChar = 'd';
        int start = 0;
        int expected = -1;
    
        int result = charSequenceUtils.indexOf(cs, searchChar, start);
    
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("When cs contains searchChar, start is 0, expect 1")
    void testIndexOfCharFound() {
        CharSequence cs = "abc";
        int searchChar = 'b';
        int start = 0;
        int expected = 1;
    
        int result = charSequenceUtils.indexOf(cs, searchChar, start);
    
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("When start index is negative, expect -1")
    void testIndexOfCharNegativeStart() {
        CharSequence cs = "abc";
        int searchChar = 'a';
        int start = -1;
        int expected = -1;
    
        int result = charSequenceUtils.indexOf(cs, searchChar, start);
    
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("When start index is greater than cs length, expect -1")
    void testIndexOfCharStartGreaterThanCsLength() {
        CharSequence cs = "abc";
        int searchChar = 'a';
        int start = 10;
        int expected = -1;
    
        int result = charSequenceUtils.indexOf(cs, searchChar, start);
    
        assertEquals(expected, result);
    }

}