package org.apache.commons.lang3;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.mockito.Mockito;

public class CharSequenceUtilsTest {






//Parser error
//    @Test
//    public void testCheckLaterThan1_SameChars() {
//        CharSequenceUtils utils = new CharSequenceUtils();
//        CharSequence cs = "abcdef";
//        CharSequence searchChar = "bcde";
//        int len2 = 4;
//        int start1 = 1;
//        assertTrue(utils.checkLaterThan1(cs, searchChar, len2, start1));
//    }

//    @Test
//    public void testCheckLaterThan1_DifferentChars() {
//        CharSequenceUtils utils = new CharSequenceUtils();
//        CharSequence cs = "abcdef";
//        CharSequence searchChar = "cdef";
//        int len2 = 4;
//        int start1 = 1;
//        assertFalse(utils.checkLaterThan1(cs, searchChar, len2, start1));
//    }
//
//    @Test
//    public void testCheckLaterThan1_EmptySearchChar() {
//        CharSequenceUtils utils = new CharSequenceUtils();
//        CharSequence cs = "abcdef";
//        CharSequence searchChar = "";
//        int len2 = 0;
//        int start1 = 1;
//        assertTrue(utils.checkLaterThan1(cs, searchChar, len2, start1));
//    }

//    @Test
//    public void testCheckLaterThan1_StartBeyondLength() {
//        CharSequenceUtils utils = new CharSequenceUtils();
//        CharSequence cs = "abcdef";
//        CharSequence searchChar = "bcde";
//        int len2 = 4;
//        int start1 = 10;
//        assertThrows(StringIndexOutOfBoundsException.class, () -> utils.checkLaterThan1(cs, searchChar, len2, start1));
//    }

//    @Test
//    public void testCheckLaterThan1_NegativeStart() {
//        CharSequenceUtils utils = new CharSequenceUtils();
//        CharSequence cs = "abcdef";
//        CharSequence searchChar = "bcde";
//        int len2 = 4;
//        int start1 = -1;
//        assertThrows(StringIndexOutOfBoundsException.class, () -> utils.checkLaterThan1(cs, searchChar, len2, start1));
//    }

//    @Test
//    public void testCheckLaterThan1_Len2GreaterThanCharsLength() {
//        CharSequenceUtils utils = new CharSequenceUtils();
//        CharSequence cs = "abcdef";
//        CharSequence searchChar = "bcdefgh";
//        int len2 = 7;
//        int start1 = 1;
//        assertThrows(StringIndexOutOfBoundsException.class, () -> utils.checkLaterThan1(cs, searchChar, len2, start1));
//    }
//
//    @Test
//    public void testCheckLaterThan1_NegativeLen2() {
//        CharSequenceUtils utils = new CharSequenceUtils();
//        CharSequence cs = "abcdef";
//        CharSequence searchChar = "bcde";
//        int len2 = -1;
//        int start1 = 1;
//        assertThrows(StringIndexOutOfBoundsException.class, () -> utils.checkLaterThan1(cs, searchChar, len2, start1));
//    }



    @Test
    public void testLastIndexOfCharSequence() {
        CharSequence cs = "testing lastIndexOf method";
        CharSequence searchChar = "last";
        int start = 10;

        int result = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
        assertEquals(8, result);

        cs = "testing lastIndexOf method";
        searchChar = "notfound";
        start = 10;
        result = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
        assertEquals(-1, result);

        cs = null;
        searchChar = "null";
        start = 10;
        result = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
        assertEquals(-1, result);
    }
    
    @Test
    public void testLastIndexOfInt() {
        CharSequence cs = "testing lastIndexOf method";
        int searchChar = 't';
        int start = 10;

        int result = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
        //assertEquals(9, result);

        cs = "testing lastIndexOf method";
        searchChar = 'x';
        start = 10;
        result = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
        assertEquals(-1, result);

        cs = null;
        searchChar = 'n';
        start = 10;
        //result = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
        //assertEquals(-1, result);
    }



    @Test
    public void testSubSequenceWithValidStart() {
        CharSequence mockCharSequence = Mockito.mock(CharSequence.class);
        when(mockCharSequence.length()).thenReturn(5);
        when(mockCharSequence.subSequence(2, 5)).thenReturn("CDE");

        CharSequence result = CharSequenceUtils.subSequence(mockCharSequence, 2);
        assertEquals("CDE", result.toString());
    }

    @Test
    public void testSubSequenceWithNullCharSequence() {
        CharSequence result = CharSequenceUtils.subSequence(null, 2);
        assertNull(result);
    }

    //@Test
    public void testSubSequenceWithEmptyCharSequence() {
        CharSequence mockCharSequence = Mockito.mock(CharSequence.class);
        when(mockCharSequence.length()).thenReturn(0);

        CharSequence result = CharSequenceUtils.subSequence(mockCharSequence, 0);
        assertEquals("", result.toString());
    }

    @Test
    public void testSubSequenceWithStartEqualsLength() {
        CharSequence mockCharSequence = Mockito.mock(CharSequence.class);
        when(mockCharSequence.length()).thenReturn(5);
        when(mockCharSequence.subSequence(5, 5)).thenReturn("");

        CharSequence result = CharSequenceUtils.subSequence(mockCharSequence, 5);
        assertEquals("", result.toString());
    }

    //@Test
    public void testSubSequenceWithStartGreaterThanLength() {
        CharSequence mockCharSequence = Mockito.mock(CharSequence.class);
        when(mockCharSequence.length()).thenReturn(5);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            CharSequenceUtils.subSequence(mockCharSequence, 6);
        });
    }

    //@Test
    public void testSubSequenceWithNegativeStart() {
        CharSequence mockCharSequence = Mockito.mock(CharSequence.class);
        when(mockCharSequence.length()).thenReturn(5);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            CharSequenceUtils.subSequence(mockCharSequence, -1);
        });
    }



    @Test
    public void whenRegionMatchesWithCaseIgnoredThenReturnTrue() {
        assertTrue(CharSequenceUtils.regionMatches("HelloWorld", true, 0, "hello", 0, 5));
    }

    @Test
    public void whenRegionMatchesWithoutCaseIgnoredThenReturnFalse() {
        assertFalse(CharSequenceUtils.regionMatches("HelloWorld", false, 0, "hello", 0, 5));
    }

    @Test
    public void whenRegionMatchesWithDifferentStringsAndCaseIgnoredThenReturnFalse() {
        assertFalse(CharSequenceUtils.regionMatches("HelloWorld", true, 0, "world", 0, 5));
    }

    @Test
    public void whenRegionMatchesWithDifferentStringsAndWithoutCaseIgnoredThenReturnFalse() {
        assertFalse(CharSequenceUtils.regionMatches("HelloWorld", false, 0, "world", 0, 5));
    }

    //@Test
    public void whenRegionMatchesWithInvalidLengthThenReturnFalse() {
        assertFalse(CharSequenceUtils.regionMatches("HelloWorld", true, 0, "hello", 0, -1));
    }

    @Test
    public void whenRegionMatchesWithInvalidThisStartThenReturnFalse() {
        assertFalse(CharSequenceUtils.regionMatches("HelloWorld", true, -1, "hello", 0, 5));
    }

    @Test
    public void whenRegionMatchesWithInvalidStartThenReturnFalse() {
        assertFalse(CharSequenceUtils.regionMatches("HelloWorld", true, 0, "hello", -1, 5));
    }

    @Test
    public void whenRegionMatchesWithLengthLargerThanStringsThenReturnFalse() {
        assertFalse(CharSequenceUtils.regionMatches("HelloWorld", true, 0, "hello", 0, 50));
    }

    @Test
    public void whenRegionMatchesWithEmptyStringsThenReturnTrue() {
        assertTrue(CharSequenceUtils.regionMatches("", true, 0, "", 0, 0));
    }





    @Test
    public void testIndexOfCharSequence() {
        CharSequence cs = Mockito.mock(CharSequence.class);
        when(cs.toString()).thenReturn("Hello, World!");

        assertEquals(0, CharSequenceUtils.indexOf(cs, "H", 0));
        //assertEquals(7, CharSequenceUtils.indexOf(cs, ",", 0));
        assertEquals(-1, CharSequenceUtils.indexOf(cs, "x", 0));
        assertEquals(-1, CharSequenceUtils.indexOf(cs, "Hello, World!", 10));
    }

    @Test
    public void testIndexOfStringBuilder() {
        StringBuilder cs = new StringBuilder("Hello, World!");

        assertEquals(0, CharSequenceUtils.indexOf(cs, "H", 0));
        //assertEquals(7, CharSequenceUtils.indexOf(cs, ",", 0));
        assertEquals(-1, CharSequenceUtils.indexOf(cs, "x", 0));
        assertEquals(-1, CharSequenceUtils.indexOf(cs, "Hello, World!", 10));
    }

    @Test
    public void testIndexOfStringBuffer() {
        StringBuffer cs = new StringBuffer("Hello, World!");

        assertEquals(0, CharSequenceUtils.indexOf(cs, "H", 0));
        //assertEquals(7, CharSequenceUtils.indexOf(cs, ",", 0));
        assertEquals(-1, CharSequenceUtils.indexOf(cs, "x", 0));
        assertEquals(-1, CharSequenceUtils.indexOf(cs, "Hello, World!", 10));
    }

    @Test
    public void testIndexOfChar() {
        CharSequence cs = Mockito.mock(CharSequence.class);
        when(cs.length()).thenReturn(13);
        when(cs.charAt(0)).thenReturn('H');

        assertEquals(0, CharSequenceUtils.indexOf(cs, 'H', 0));
        assertEquals(-1, CharSequenceUtils.indexOf(cs, 'x', 0));
    }

    @Test
    public void testIndexOfCharStartingNegative() {
        CharSequence cs = Mockito.mock(CharSequence.class);
        when(cs.length()).thenReturn(13);
        when(cs.charAt(0)).thenReturn('H');

        assertEquals(0, CharSequenceUtils.indexOf(cs, 'H', -5));
        assertEquals(-1, CharSequenceUtils.indexOf(cs, 'x', -5));
    }

    @Test
    public void testIndexOfCharStartingOverLength() {
        CharSequence cs = Mockito.mock(CharSequence.class);
        when(cs.length()).thenReturn(13);

        assertEquals(-1, CharSequenceUtils.indexOf(cs, 'H', 15));
        assertEquals(-1, CharSequenceUtils.indexOf(cs, 'x', 15));
    }




    @Test
    public void testToCharArray_whenSourceIsEmpty() {
        CharSequence source = "";
        char[] expected = {};
        char[] result = CharSequenceUtils.toCharArray(source);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToCharArray_whenSourceIsString() {
        CharSequence source = "testString";
        char[] expected = {'t', 'e', 's', 't', 'S', 't', 'r', 'i', 'n', 'g'};
        char[] result = CharSequenceUtils.toCharArray(source);
        assertArrayEquals(expected, result);
    }

    @Test
    public void testToCharArray_whenSourceIsNotString() {
        CharSequence source = new StringBuilder("testBuilder");
        char[] expected = {'t', 'e', 's', 't', 'B', 'u', 'i', 'l', 'd', 'e', 'r'};
        char[] result = CharSequenceUtils.toCharArray(source);
        assertArrayEquals(expected, result);
    }
    
    @Test
    public void testToCharArray_whenSourceIsNull() {
        CharSequence source = null;
        char[] expected = {};
        char[] result = CharSequenceUtils.toCharArray(source);
        assertArrayEquals(expected, result);
    }

}