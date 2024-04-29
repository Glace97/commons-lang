package org.apache.commons.lang3;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CharSequenceUtilsTest {



//    @Test
//    public void testIndexOf_String() {
//        // Instantiate all necessary variables here
//        CharSequence cs = "Hello World";
//        CharSequence searchChar = "o";
//        int start = 0;
//
//        // Mock the dependencies
//        String mockedString = mock(String.class);
//        when(cs instanceof String).thenReturn(true);
//        when((String) cs).thenReturn(mockedString);
//        when(mockedString.indexOf(searchChar.toString(), start)).thenReturn(4);
//
//        // Write the test code here following the given rules
//        int result = CharSequenceUtils.indexOf(cs, searchChar, start);
//
//        // Verify the result
//        assertEquals(4, result);
//        //verify(cs instanceof String, times(1)).thenReturn(true);
//        verify((String) cs, times(1)).indexOf(searchChar.toString(), start);
//    }

//    @Test
//    public void testIndexOf_StringBuilder() {
//        // Instantiate all necessary variables here
//        CharSequence cs = new StringBuilder("Hello World");
//        CharSequence searchChar = "o";
//        int start = 0;
//
//        // Mock the dependencies
//        StringBuilder mockedStringBuilder = mock(StringBuilder.class);
//        when(cs instanceof StringBuilder).thenReturn(true);
//        when((StringBuilder) cs).thenReturn(mockedStringBuilder);
//        when(mockedStringBuilder.indexOf(searchChar.toString(), start)).thenReturn(4);
//
//        // Write the test code here following the given rules
//        int result = CharSequenceUtils.indexOf(cs, searchChar, start);
//
//        // Verify the result
//        assertEquals(4, result);
//        //verify(cs instanceof StringBuilder, times(1)).thenReturn(true);
//        verify((StringBuilder) cs, times(1)).indexOf(searchChar.toString(), start);
//    }

//    @Test
//    public void testIndexOf_StringBuffer() {
//        // Instantiate all necessary variables here
//        CharSequence cs = new StringBuffer("Hello World");
//        CharSequence searchChar = "o";
//        int start = 0;
//
//        // Mock the dependencies
//        StringBuffer mockedStringBuffer = mock(StringBuffer.class);
//        when(cs instanceof StringBuffer).thenReturn(true);
//        when((StringBuffer) cs).thenReturn(mockedStringBuffer);
//        when(mockedStringBuffer.indexOf(searchChar.toString(), start)).thenReturn(4);
//
//        // Write the test code here following the given rules
//        int result = CharSequenceUtils.indexOf(cs, searchChar, start);
//
//        // Verify the result
//        assertEquals(4, result);
//        //verify(cs instanceof StringBuffer, times(1)).thenReturn(true);
//        verify((StringBuffer) cs, times(1)).indexOf(searchChar.toString(), start);
//    }

//    @Test
//    public void testIndexOf_OtherCharSequence() {
//        // Instantiate all necessary variables here
//        CharSequence cs = new CustomCharSequence("Hello World");
//        CharSequence searchChar = "o";
//        int start = 0;
//
//        // Mock the dependencies
//        CustomCharSequence mockedCustomCharSequence = mock(CustomCharSequence.class);
//        when(cs instanceof String).thenReturn(false);
//        when(cs.toString()).thenReturn("Hello World");
//        when(mockedCustomCharSequence.indexOf(searchChar.toString(), start)).thenReturn(4);
//
//        // Write the test code here following the given rules
//        int result = CharSequenceUtils.indexOf(cs, searchChar, start);
//
//        // Verify the result
//        assertEquals(4, result);
//        //verify(cs instanceof String, times(1)).thenReturn(false);
//        verify(cs, times(1)).toString();
//        verify(mockedCustomCharSequence, times(1)).indexOf(searchChar.toString(), start);
//    }

    @Test
    public void testIndexOf_Char() {
        // Instantiate all necessary variables here
        CharSequence cs = "Hello World";
        int searchChar = 'o';
        int start = 0;

        // Write the test code here following the given rules
        int result = CharSequenceUtils.indexOf(cs, searchChar, start);

        // Verify the result
        assertEquals(4, result);
    }

    private static class CustomCharSequence implements CharSequence {
        private final String data;

        public CustomCharSequence(String data) {
            this.data = data;
        }

        public int length() {
            return data.length();
        }

        public char charAt(int index) {
            return data.charAt(index);
        }

        public CharSequence subSequence(int start, int end) {
            return data.subSequence(start, end);
        }

        public String toString() {
            return data;
        }

        public int indexOf(String searchChar, int start) {
            return data.indexOf(searchChar, start);
        }
    }

    @Test
    public void testLastIndexOf_String_CharSequence_StartIndex() {
        // Instantiate all necessary variables here
        CharSequence cs = "Hello world";
        CharSequence searchChar = "o";
        int start = 7;

        // Write the test code here following the given rules
        int actualIndex = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
        int expectedIndex = 7;

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testLastIndexOf_String_Int_StartIndex() {
        // Instantiate all necessary variables here
        CharSequence cs = "Hello world";
        int searchChar = 'o';
        int start = 7;

        // Write the test code here following the given rules
        int actualIndex = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
        int expectedIndex = 7;

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testLastIndexOf_String_CharSequence_StartIndex_Null() {
        // Instantiate all necessary variables here
        CharSequence cs = "Hello world";
        CharSequence searchChar = null;
        int start = 7;

        // Write the test code here following the given rules
        int actualIndex = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
        int expectedIndex = -1;

        assertEquals(expectedIndex, actualIndex);
    }

    @Test
    public void testLastIndexOf_String_Int_StartIndex_Null() {
        // Instantiate all necessary variables here
        CharSequence cs = "Hello world";
        int searchChar = 0;
        int start = 7;

        // Write the test code here following the given rules
        int actualIndex = CharSequenceUtils.lastIndexOf(cs, searchChar, start);
        int expectedIndex = -1;

        assertEquals(expectedIndex, actualIndex);
    }



    @Test
    public void testSubSequence_NullInput_ReturnsNull() {
        // Instantiate all necessary variables here
        CharSequence cs = null;
        int start = 0;

        // Write the test code here following the given rules
        CharSequence result = CharSequenceUtils.subSequence(cs, start);

        assertNull(result);
    }

    @Test
    public void testSubSequence_StartIndexNegative_ThrowsIndexOutOfBoundsException() {
        // Instantiate all necessary variables here
        CharSequence cs = "Hello";
        int start = -1;

        // Write the test code here following the given rules
        assertThrows(IndexOutOfBoundsException.class, () -> {
            CharSequenceUtils.subSequence(cs, start);
        });
    }

    @Test
    public void testSubSequence_StartIndexGreaterThanLength_ThrowsIndexOutOfBoundsException() {
        // Instantiate all necessary variables here
        CharSequence cs = "Hello";
        int start = 6;

        // Write the test code here following the given rules
        assertThrows(IndexOutOfBoundsException.class, () -> {
            CharSequenceUtils.subSequence(cs, start);
        });
    }

    @Test
    public void testSubSequence_StartIndexEqualToLength_ReturnsEmptySequence() {
        // Instantiate all necessary variables here
        CharSequence cs = "Hello";
        int start = 5;

        // Write the test code here following the given rules
        CharSequence result = CharSequenceUtils.subSequence(cs, start);

        assertNotNull(result);
        assertEquals(0, result.length());
    }

    @Test
    public void testSubSequence_ValidInput_ReturnsSubsequence() {
        // Instantiate all necessary variables here
        CharSequence cs = "Hello";
        int start = 1;

        // Write the test code here following the given rules
        CharSequence result = CharSequenceUtils.subSequence(cs, start);

        assertNotNull(result);
        assertEquals("ello", result.toString());
    }




//    @Test
//    public void testRegionMatches() {
//        // Instantiate all necessary variables here
//        CharSequence cs = mock(CharSequence.class);
//        CharSequence substring = mock(CharSequence.class);
//        int thisStart = 0;
//        int start = 0;
//        int length = 0;
//        boolean ignoreCase = false;
//
//        // Write the test code here following the given rules
//        boolean result = CharSequenceUtils.regionMatches(cs, ignoreCase, thisStart, substring, start, length);
//
//        // Verify the result
//        assertFalse(result);
//    }






    @Test
    public void testToCharArray_EmptySource_ReturnsEmptyCharArray() {
        // Instantiate all necessary variables here
        CharSequence source = "";

        // Write the test code here following the given rules
        char[] result = CharSequenceUtils.toCharArray(source);

        assertEquals(0, result.length);
    }
    
    @Test
    public void testToCharArray_StringSource_ReturnsCharArray() {
        // Instantiate all necessary variables here
        CharSequence source = "test";

        // Write the test code here following the given rules
        char[] result = CharSequenceUtils.toCharArray(source);

        assertArrayEquals(new char[]{'t', 'e', 's', 't'}, result);
    }
    
    @Test
    public void testToCharArray_GeneralSource_ReturnsCharArray() {
        // Instantiate all necessary variables here
        CharSequence source = new StringBuilder("test");

        // Write the test code here following the given rules
        char[] result = CharSequenceUtils.toCharArray(source);

        assertArrayEquals(new char[]{'t', 'e', 's', 't'}, result);
    }
    
    @Test
    public void testToCharArray_NullSource_ReturnsEmptyCharArray() {
        // Instantiate all necessary variables here
        CharSequence source = null;

        // Write the test code here following the given rules
        char[] result = CharSequenceUtils.toCharArray(source);

        assertEquals(0, result.length);
    }

}