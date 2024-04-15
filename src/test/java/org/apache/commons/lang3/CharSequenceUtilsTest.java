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

    private static final String TEST_STRING = "abcdefghijklmnopqrstuvwxyz";
    private static final int TEST_STRING_LENGTH = TEST_STRING.length();

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
    void testToCharArray_NonString() {
        CharSequence source = new StringBuilder("StringBuilder");
        char[] result = CharSequenceUtils.toCharArray(source);
        assertArrayEquals(new char[]{'S', 't', 'r', 'i', 'n', 'g', 'B', 'u', 'i', 'l', 'd', 'e', 'r'}, result);
    }


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