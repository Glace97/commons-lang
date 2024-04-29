//package org.apache.commons.lang3;
//
//import static org.mockito.Mockito.*;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class OLD_CharSequenceUtilsTest {
//
//
//
//
//
//    @Test
//    public void testIndexOf_StringInstance() {
//        // Instantiate all necessary variables here
//        CharSequence cs = mock(CharSequence.class);
//        CharSequence searchChar = mock(CharSequence.class);
//        int start = 0;
//
//        // Mock the behavior of cs and searchChar
//        when(cs instanceof String).thenReturn(true);
//        when(((String) cs).indexOf(searchChar.toString(), start)).thenReturn(5);
//
//        // Test the indexOf method
//        int result = CharSequenceUtils.indexOf(cs, searchChar, start);
//
//        // Verify the result
//        assertEquals(5, result);
//    }
//
//    @Test
//    public void testIndexOf_StringBuilderInstance() {
//        // Instantiate all necessary variables here
//        CharSequence cs = mock(CharSequence.class);
//        CharSequence searchChar = mock(CharSequence.class);
//        int start = 0;
//
//        // Mock the behavior of cs and searchChar
//        when(cs instanceof String).thenReturn(false);
//        when(cs instanceof StringBuilder).thenReturn(true);
//        when(((StringBuilder) cs).indexOf(searchChar.toString(), start)).thenReturn(3);
//
//        // Test the indexOf method
//        int result = CharSequenceUtils.indexOf(cs, searchChar, start);
//
//        // Verify the result
//        assertEquals(3, result);
//    }
//
//    @Test
//    public void testIndexOf_StringBufferInstance() {
//        // Instantiate all necessary variables here
//        CharSequence cs = mock(CharSequence.class);
//        CharSequence searchChar = mock(CharSequence.class);
//        int start = 0;
//
//        // Mock the behavior of cs and searchChar
//        when(cs instanceof String).thenReturn(false);
//        when(cs instanceof StringBuilder).thenReturn(false);
//        when(cs instanceof StringBuffer).thenReturn(true);
//        when(((StringBuffer) cs).indexOf(searchChar.toString(), start)).thenReturn(8);
//
//        // Test the indexOf method
//        int result = CharSequenceUtils.indexOf(cs, searchChar, start);
//
//        // Verify the result
//        assertEquals(8, result);
//    }
//
//    @Test
//    public void testIndexOf_OtherInstances() {
//        // Instantiate all necessary variables here
//        CharSequence cs = mock(CharSequence.class);
//        CharSequence searchChar = mock(CharSequence.class);
//        int start = 0;
//
//        // Mock the behavior of cs and searchChar
//        when(cs instanceof String).thenReturn(false);
//        when(cs instanceof StringBuilder).thenReturn(false);
//        when(cs instanceof StringBuffer).thenReturn(false);
//        when(cs.toString()).thenReturn("abcdefg");
//        when(searchChar.toString()).thenReturn("c");
//
//        // Test the indexOf method
//        int result = CharSequenceUtils.indexOf(cs, searchChar, start);
//
//        // Verify the result
//        assertEquals(2, result);
//    }
//
//    @Test
//    public void testIndexOf_CharInstance() {
//        // Instantiate all necessary variables here
//        CharSequence cs = mock(CharSequence.class);
//        int searchChar = 97;
//        int start = 0;
//
//        // Mock the behavior of cs
//        when(cs instanceof String).thenReturn(true);
//        when(((String) cs).indexOf(searchChar, start)).thenReturn(1);
//
//        // Test the indexOf method
//        int result = CharSequenceUtils.indexOf(cs, searchChar, start);
//
//        // Verify the result
//        assertEquals(1, result);
//    }
//
//    @Test
//    public void testIndexOf_CharInstance_NotFound() {
//        // Instantiate all necessary variables here
//        CharSequence cs = mock(CharSequence.class);
//        int searchChar = 98;
//        int start = 0;
//
//        // Mock the behavior of cs
//        when(cs instanceof String).thenReturn(true);
//        when(((String) cs).indexOf(searchChar, start)).thenReturn(-1);
//
//        // Test the indexOf method
//        int result = CharSequenceUtils.indexOf(cs, searchChar, start);
//
//        // Verify the result
//        assertEquals(-1, result);
//    }
//
//
//
//
//
//    @Test
//    public void testCheckLaterThan1() {
//        // Instantiate all necessary variables here
//        CharSequenceUtils charSequenceUtils = new CharSequenceUtils();
//        CharSequence cs = mock(CharSequence.class);
//        CharSequence searchChar = mock(CharSequence.class);
//        int len2 = 10;
//        int start1 = 2;
//
//        // Mock charAt() method of cs and searchChar
//        when(cs.charAt(anyInt())).thenReturn('a');
//        when(searchChar.charAt(anyInt())).thenReturn('a');
//
//        // Write the test code here following the given rules
//        assertTrue(charSequenceUtils.checkLaterThan1(cs, searchChar, len2, start1));
//
//        // Verify that charAt() method of cs and searchChar are called exactly len2/2 times
//        verify(cs, times(len2 / 2)).charAt(anyInt());
//        verify(searchChar, times(len2 / 2)).charAt(anyInt());
//
//        // Reset the mocks
//        reset(cs, searchChar);
//
//        // Mock charAt() method of cs and searchChar to return different characters
//        when(cs.charAt(anyInt())).thenReturn('a');
//        when(searchChar.charAt(anyInt())).thenReturn('b');
//
//        // Write the test code here following the given rules
//        assertFalse(charSequenceUtils.checkLaterThan1(cs, searchChar, len2, start1));
//
//        // Verify that charAt() method of cs and searchChar are called exactly len2/2 times
//        verify(cs, times(len2 / 2)).charAt(anyInt());
//        verify(searchChar, times(len2 / 2)).charAt(anyInt());
//    }
//
//
//
//
//
//
//
//    @Test
//    public void testLastIndexOf_WhenSearchCharIsNull_ShouldReturnNotFound() {
//        // Instantiate all necessary variables here
//        CharSequence cs = "Hello World";
//        CharSequence searchChar = null;
//        int start = 0;
//
//        // Write the test code here following the given rules
//        int result = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
//
//        assertEquals(CharSequenceUtils.NOT_FOUND, result);
//    }
//
//    @Test
//    public void testLastIndexOf_WhenCsIsNull_ShouldReturnNotFound() {
//        // Instantiate all necessary variables here
//        CharSequence cs = null;
//        CharSequence searchChar = "World";
//        int start = 0;
//
//        // Write the test code here following the given rules
//        int result = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
//
//        assertEquals(CharSequenceUtils.NOT_FOUND, result);
//    }
//
//    @Test
//    public void testLastIndexOf_WhenCsAndSearchCharAreValidStrings_ShouldReturnIndexOfSearchChar() {
//        // Instantiate all necessary variables here
//        CharSequence cs = "Hello World";
//        CharSequence searchChar = "World";
//        int start = 0;
//
//        // Write the test code here following the given rules
//        int result = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
//
//        assertEquals(6, result);
//    }
//
//    @Test
//    public void testLastIndexOf_WhenCsAndSearchCharAreValidStringBuilders_ShouldReturnIndexOfSearchChar() {
//        // Instantiate all necessary variables here
//        CharSequence cs = new StringBuilder("Hello World");
//        CharSequence searchChar = new StringBuilder("World");
//        int start = 0;
//
//        // Write the test code here following the given rules
//        int result = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
//
//        assertEquals(6, result);
//    }
//
//    @Test
//    public void testLastIndexOf_WhenCsAndSearchCharAreValidStringBuffers_ShouldReturnIndexOfSearchChar() {
//        // Instantiate all necessary variables here
//        CharSequence cs = new StringBuffer("Hello World");
//        CharSequence searchChar = new StringBuffer("World");
//        int start = 0;
//
//        // Write the test code here following the given rules
//        int result = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
//
//        assertEquals(6, result);
//    }
//
//    @Test
//    public void testLastIndexOf_WhenStartIsGreaterThanCsLength_ShouldSetStartToCsLength() {
//        // Instantiate all necessary variables here
//        CharSequence cs = "Hello World";
//        CharSequence searchChar = "World";
//        int start = 100;
//
//        // Write the test code here following the given rules
//        int result = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
//
//        assertEquals(6, result);
//    }
//
//    @Test
//    public void testLastIndexOf_WhenStartIsNegativeOrSearchCharLengthIsGreaterThanCsLength_ShouldReturnNotFound() {
//        // Instantiate all necessary variables here
//        CharSequence cs = "Hello World";
//        CharSequence searchChar = "World";
//        int start = -1;
//
//        // Write the test code here following the given rules
//        int result = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
//
//        assertEquals(CharSequenceUtils.NOT_FOUND, result);
//
//        start = 0;
//        searchChar = "Hello World!";
//        result = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
//
//        assertEquals(CharSequenceUtils.NOT_FOUND, result);
//    }
//
//    @Test
//    public void testLastIndexOf_WhenSearchCharIsEmpty_ShouldReturnStart() {
//        // Instantiate all necessary variables here
//        CharSequence cs = "Hello World";
//        CharSequence searchChar = "";
//        int start = 0;
//
//        // Write the test code here following the given rules
//        int result = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
//
//        assertEquals(start, result);
//    }
//
//    @Test
//    public void testLastIndexOf_WhenSearchCharLengthIsLessThanOrEqualToToStringLimit_ShouldReturnIndexOfSearchChar() {
//        // Instantiate all necessary variables here
//        CharSequence cs = "Hello World";
//        CharSequence searchChar = "World";
//        int start = 0;
//
//        // Write the test code here following the given rules
//        int result = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
//
//        assertEquals(6, result);
//    }
//
//    @Test
//    public void testLastIndexOf_WhenSearchCharLengthIsGreaterThanToStringLimitAndStartPlusSearchCharLengthIsGreaterThanCsLength_ShouldSetStartToCsLengthMinusSearchCharLength() {
//        // Instantiate all necessary variables here
//        CharSequence cs = "Hello World";
//        CharSequence searchChar = "Hello World!";
//        int start = 0;
//
//        // Write the test code here following the given rules
//        int result = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
//
//        assertEquals(0, result);
//    }
//
//    @Test
//    public void testLastIndexOf_WhenSearchCharStartsWithChar0_ShouldReturnIndexOfSearchChar() {
//        // Instantiate all necessary variables here
//        CharSequence cs = "Hello World";
//        CharSequence searchChar = "World";
//        int start = 0;
//
//        // Write the test code here following the given rules
//        int result = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
//
//        assertEquals(6, result);
//    }
//
//    @Test
//    public void testLastIndexOf_WhenCheckLaterThan1ReturnsTrue_ShouldReturnIndexOfChar0() {
//        // Instantiate all necessary variables here
//        CharSequence cs = "Hello World";
//        CharSequence searchChar = "World";
//        int start = 0;
//
//        // Mock dependencies
//        CharSequenceUtils charSequenceUtils = mock(CharSequenceUtils.class);
//        when(charSequenceUtils.checkLaterThan1(cs, searchChar, searchChar.length(), start)).thenReturn(true);
//
//        // Write the test code here following the given rules
//        int result = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
//
//        assertEquals(6, result);
//    }
//
//    @Test
//    public void testLastIndexOf_WhenCheckLaterThan1ReturnsFalse_ShouldDecrementIAndContinueLoop() {
//        // Instantiate all necessary variables here
//        CharSequence cs = "Hello World";
//        CharSequence searchChar = "World";
//        int start = 0;
//
//        // Mock dependencies
//        CharSequenceUtils charSequenceUtils = mock(CharSequenceUtils.class);
//        when(charSequenceUtils.checkLaterThan1(cs, searchChar, searchChar.length(), start)).thenReturn(false, false, false, true);
//
//        // Write the test code here following the given rules
//        int result = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
//
//        assertEquals(6, result);
//    }
//
//    @Test
//    public void testLastIndexOf_WhenChar0IsNotFound_ShouldReturnNotFound() {
//        // Instantiate all necessary variables here
//        CharSequence cs = "Hello World";
//        CharSequence searchChar = "!";
//        int start = 0;
//
//        // Write the test code here following the given rules
//        int result = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
//
//        assertEquals(CharSequenceUtils.NOT_FOUND, result);
//    }
//
//    @Test
//    public void testLastIndexOf_WhenSearchCharIsWithinRangeOf0To0xFFFF_ShouldReturnLargestIndexOfCharLessThanOrEqualToStart() {
//        // Instantiate all necessary variables here
//        CharSequence cs = "Hello World";
//        int searchChar = (int) 'o';
//        int start = 7;
//
//        // Write the test code here following the given rules
//        int result = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
//
//        assertEquals(4, result);
//    }
//
//    @Test
//    public void testLastIndexOf_WhenSearchCharIsSupplementary_ShouldReturnLargestIndexOfCharLessThanOrEqualToStart() {
//        // Instantiate all necessary variables here
//        CharSequence cs = "Hello World\uD83D\uDE00";
//        int searchChar = 128512; // U+1F600
//        int start = 12;
//
//        // Write the test code here following the given rules
//        int result = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
//
//        assertEquals(11, result);
//    }
//
//
//
//    @Test
//    public void testSubSequence_NullInput_ReturnsNull() {
//        // Instantiate all necessary variables here
//        CharSequence cs = null;
//        int start = 0;
//
//        // Write the test code here following the given rules
//        CharSequence result = CharSequenceUtils.subSequence(cs, start);
//
//        assertNull(result);
//    }
//
//    @Test
//    public void testSubSequence_StartIndexNegative_ThrowsIndexOutOfBoundsException() {
//        // Instantiate all necessary variables here
//        CharSequence cs = mock(CharSequence.class);
//        int start = -1;
//
//        // Write the test code here following the given rules
//        assertThrows(IndexOutOfBoundsException.class, () -> {
//            CharSequenceUtils.subSequence(cs, start);
//        });
//    }
//
//    @Test
//    public void testSubSequence_StartIndexGreaterThanLength_ThrowsIndexOutOfBoundsException() {
//        // Instantiate all necessary variables here
//        CharSequence cs = mock(CharSequence.class);
//        int start = 10;
//        when(cs.length()).thenReturn(5);
//
//        // Write the test code here following the given rules
//        assertThrows(IndexOutOfBoundsException.class, () -> {
//            CharSequenceUtils.subSequence(cs, start);
//        });
//    }
//
//    @Test
//    public void testSubSequence_StartIndexEqualToLength_ReturnsEmptySequence() {
//        // Instantiate all necessary variables here
//        CharSequence cs = mock(CharSequence.class);
//        int start = 5;
//        when(cs.length()).thenReturn(5);
//
//        // Write the test code here following the given rules
//        CharSequence result = CharSequenceUtils.subSequence(cs, start);
//
//        assertEquals("", result.toString());
//    }
//
//    @Test
//    public void testSubSequence_ValidInput_ReturnsSubsequence() {
//        // Instantiate all necessary variables here
//        CharSequence cs = mock(CharSequence.class);
//        int start = 2;
//        when(cs.length()).thenReturn(5);
//        when(cs.subSequence(start, cs.length())).thenReturn("cde");
//
//        // Write the test code here following the given rules
//        CharSequence result = CharSequenceUtils.subSequence(cs, start);
//
//        assertEquals("cde", result.toString());
//    }
//
//
//
//
//    @Test
//    public void testRegionMatches_WhenBothCharSequencesAreStrings_ReturnsExpectedResult() {
//        // Instantiate all necessary variables here
//        CharSequence cs = "Hello World";
//        boolean ignoreCase = true;
//        int thisStart = 0;
//        CharSequence substring = "hello";
//        int start = 0;
//        int length = 5;
//
//        // Mock dependencies
//        String csString = "Hello World";
//        String substringString = "hello";
//        when(cs instanceof String).thenReturn(true);
//        when(substring instanceof String).thenReturn(true);
//        when((String) cs).thenReturn(csString);
//        when((String) substring).thenReturn(substringString);
//
//        // Write the test code here following the given rules
//        boolean result = CharSequenceUtils.regionMatches(cs, ignoreCase, thisStart, substring, start, length);
//
//        assertTrue(result);
//    }
//
//    @Test
//    public void testRegionMatches_WhenCharSequencesAreNotStrings_ReturnsExpectedResult() {
//        // Instantiate all necessary variables here
//        CharSequence cs = mock(CharSequence.class);
//        boolean ignoreCase = true;
//        int thisStart = 0;
//        CharSequence substring = mock(CharSequence.class);
//        int start = 0;
//        int length = 5;
//
//        // Mock dependencies
//        int srcLen = 10;
//        int otherLen = 5;
//        when(cs.length()).thenReturn(srcLen);
//        when(substring.length()).thenReturn(otherLen);
//
//        // Write the test code here following the given rules
//        boolean result = CharSequenceUtils.regionMatches(cs, ignoreCase, thisStart, substring, start, length);
//
//        assertFalse(result);
//    }
//
//    @Test
//    public void testRegionMatches_WhenInvalidParameters_ReturnsFalse() {
//        // Instantiate all necessary variables here
//        CharSequence cs = "Hello World";
//        boolean ignoreCase = true;
//        int thisStart = -1;
//        CharSequence substring = "hello";
//        int start = 0;
//        int length = 5;
//
//        // Write the test code here following the given rules
//        boolean result = CharSequenceUtils.regionMatches(cs, ignoreCase, thisStart, substring, start, length);
//
//        assertFalse(result);
//    }
//
//    @Test
//    public void testRegionMatches_WhenRegionsAreNotLongEnough_ReturnsFalse() {
//        // Instantiate all necessary variables here
//        CharSequence cs = "Hello World";
//        boolean ignoreCase = true;
//        int thisStart = 0;
//        CharSequence substring = "hello";
//        int start = 0;
//        int length = 20;
//
//        // Write the test code here following the given rules
//        boolean result = CharSequenceUtils.regionMatches(cs, ignoreCase, thisStart, substring, start, length);
//
//        assertFalse(result);
//    }
//
//
//
//
//
//
//    @Test
//    public void testToCharArray_EmptySource_ReturnsEmptyArray() {
//        // Arrange
//        CharSequence source = "";
//
//        // Act
//        char[] result = CharSequenceUtils.toCharArray(source);
//
//        // Assert
//        assertArrayEquals(new char[0], result);
//    }
//
//    @Test
//    public void testToCharArray_StringSource_ReturnsCharArray() {
//        // Arrange
//        CharSequence source = "Hello World";
//
//        // Act
//        char[] result = CharSequenceUtils.toCharArray(source);
//
//        // Assert
//        assertArrayEquals(source.toString().toCharArray(), result);
//    }
//
//    @Test
//    public void testToCharArray_NonStringSource_ReturnsCharArray() {
//        // Arrange
//        CharSequence source = new StringBuilder("Hello World");
//
//        // Act
//        char[] result = CharSequenceUtils.toCharArray(source);
//
//        // Assert
//        assertArrayEquals(source.toString().toCharArray(), result);
//    }
//
//    @Test
//    public void testToCharArray_SourceWithSpecialCharacters_ReturnsCharArray() {
//        // Arrange
//        CharSequence source = "Hello\n\tWorld!";
//
//        // Act
//        char[] result = CharSequenceUtils.toCharArray(source);
//
//        // Assert
//        assertArrayEquals(source.toString().toCharArray(), result);
//    }
//
//}