package org.apache.commons.lang3;

import org.apache.commons.lang3.function.Suppliers;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import java.util.ArrayList;
import org.apache.commons.lang3.stream.Streams;
import java.util.List;
import org.mockito.invocation.InvocationOnMock;
import org.junit.jupiter.params.provider.ValueSource;
import org.apache.commons.lang3.RegExUtils;
import org.apache.commons.lang3.StringUtils;
import java.util.function.Supplier;
import java.util.Objects;
import java.util.Iterator;
import java.util.Collections;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.lang3.function.ToBooleanBiFunction;
import org.mockito.Mockito;
import org.mockito.Mock;
import java.util.regex.Pattern;
import org.apache.commons.lang3.CharSequenceUtils;
import org.mockito.MockedStatic;
import java.util.Arrays;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.apache.commons.lang3.stream.LangCollectors;
import org.mockito.ArgumentMatchers;
import java.util.HashSet;
import org.mockito.InjectMocks;
import org.apache.commons.lang3.ArrayUtils;
import java.util.Random;
import java.util.*;
import java.util.Locale;
import java.io.UnsupportedEncodingException;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.params.ParameterizedTest;
import java.nio.charset.Charset;
import java.util.Set;
import java.text.Normalizer;

public class StringUtilsTest {

//    @Test
//    public void testIsNoneBlank_NullCss_ReturnsFalse() {
//        // Instantiate all necessary variables here
//        CharSequence[] css = null;
//
//        // Write the test code here following the given rules
//        boolean result = StringUtils.isNoneBlank(css);
//
//        assertFalse(result);
//    }

    @Test
    public void testIsNoneBlank_NullElement_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence[] css = {null};
        
        // Write the test code here following the given rules
        boolean result = StringUtils.isNoneBlank(css);
        
        assertFalse(result);
    }

    @Test
    public void testIsNoneBlank_EmptyElement_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence[] css = {""};
        
        // Write the test code here following the given rules
        boolean result = StringUtils.isNoneBlank(css);
        
        assertFalse(result);
    }

    @Test
    public void testIsNoneBlank_BlankElement_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence[] css = {"   "};
        
        // Write the test code here following the given rules
        boolean result = StringUtils.isNoneBlank(css);
        
        assertFalse(result);
    }

    @Test
    public void testIsNoneBlank_AllNonBlankElements_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence[] css = {"foo", "bar"};
        
        // Write the test code here following the given rules
        boolean result = StringUtils.isNoneBlank(css);
        
        assertTrue(result);
    }

    @Test
    public void testIsNoneBlank_MixedBlankAndNonBlankElements_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence[] css = {"foo", "", "bar"};
        
        // Write the test code here following the given rules
        boolean result = StringUtils.isNoneBlank(css);
        
        assertFalse(result);
    }

    @Test
    public void testIsNoneBlank_AllBlankElements_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence[] css = {"", " ", "   "};
        
        // Write the test code here following the given rules
        boolean result = StringUtils.isNoneBlank(css);
        
        assertFalse(result);
    }





    @Test
    public void testLastOrdinalIndexOf_NullString_ReturnsMinusOne() {
        // Instantiate all necessary variables here
        CharSequence str = null;
        CharSequence searchStr = "a";
        int ordinal = 1;

        // Write the test code here following the given rules
        int result = StringUtils.lastOrdinalIndexOf(str, searchStr, ordinal);

        assertEquals(-1, result);
    }

    @Test
    public void testLastOrdinalIndexOf_NullSearchString_ReturnsMinusOne() {
        // Instantiate all necessary variables here
        CharSequence str = "aabaabaa";
        CharSequence searchStr = null;
        int ordinal = 1;

        // Write the test code here following the given rules
        int result = StringUtils.lastOrdinalIndexOf(str, searchStr, ordinal);

        assertEquals(-1, result);
    }

    @Test
    public void testLastOrdinalIndexOf_EmptyString_ReturnsZero() {
        // Instantiate all necessary variables here
        CharSequence str = "";
        CharSequence searchStr = "";
        int ordinal = 1;

        // Write the test code here following the given rules
        int result = StringUtils.lastOrdinalIndexOf(str, searchStr, ordinal);

        assertEquals(0, result);
    }

    @Test
    public void testLastOrdinalIndexOf_SingleCharacterString_ReturnsCorrectIndex() {
        // Instantiate all necessary variables here
        CharSequence str = "aabaabaa";
        CharSequence searchStr = "a";
        int ordinal = 1;

        // Write the test code here following the given rules
        int result = StringUtils.lastOrdinalIndexOf(str, searchStr, ordinal);

        assertEquals(7, result);
    }

    @Test
    public void testLastOrdinalIndexOf_MultipleOccurrences_ReturnsCorrectIndex() {
        // Instantiate all necessary variables here
        CharSequence str = "aabaabaa";
        CharSequence searchStr = "a";
        int ordinal = 2;

        // Write the test code here following the given rules
        int result = StringUtils.lastOrdinalIndexOf(str, searchStr, ordinal);

        assertEquals(6, result);
    }

    @Test
    public void testLastOrdinalIndexOf_MultipleOccurrencesDifferentCharacter_ReturnsCorrectIndex() {
        // Instantiate all necessary variables here
        CharSequence str = "aabaabaa";
        CharSequence searchStr = "b";
        int ordinal = 1;

        // Write the test code here following the given rules
        int result = StringUtils.lastOrdinalIndexOf(str, searchStr, ordinal);

        assertEquals(5, result);
    }

    @Test
    public void testLastOrdinalIndexOf_MultipleOccurrencesDifferentCharacter_ReturnsCorrectIndex2() {
        // Instantiate all necessary variables here
        CharSequence str = "aabaabaa";
        CharSequence searchStr = "b";
        int ordinal = 2;

        // Write the test code here following the given rules
        int result = StringUtils.lastOrdinalIndexOf(str, searchStr, ordinal);

        assertEquals(2, result);
    }

    @Test
    public void testLastOrdinalIndexOf_Substring_ReturnsCorrectIndex() {
        // Instantiate all necessary variables here
        CharSequence str = "aabaabaa";
        CharSequence searchStr = "ab";
        int ordinal = 1;

        // Write the test code here following the given rules
        int result = StringUtils.lastOrdinalIndexOf(str, searchStr, ordinal);

        assertEquals(4, result);
    }

    @Test
    public void testLastOrdinalIndexOf_Substring_ReturnsCorrectIndex2() {
        // Instantiate all necessary variables here
        CharSequence str = "aabaabaa";
        CharSequence searchStr = "ab";
        int ordinal = 2;

        // Write the test code here following the given rules
        int result = StringUtils.lastOrdinalIndexOf(str, searchStr, ordinal);

        assertEquals(1, result);
    }

    @Test
    public void testLastOrdinalIndexOf_EmptySearchString_ReturnsLengthOfString() {
        // Instantiate all necessary variables here
        CharSequence str = "aabaabaa";
        CharSequence searchStr = "";
        int ordinal = 1;

        // Write the test code here following the given rules
        int result = StringUtils.lastOrdinalIndexOf(str, searchStr, ordinal);

        assertEquals(8, result);
    }

    @Test
    public void testLastOrdinalIndexOf_EmptySearchString_ReturnsLengthOfString2() {
        // Instantiate all necessary variables here
        CharSequence str = "aabaabaa";
        CharSequence searchStr = "";
        int ordinal = 2;

        // Write the test code here following the given rules
        int result = StringUtils.lastOrdinalIndexOf(str, searchStr, ordinal);

        assertEquals(8, result);
    }




    
    @Test
    public void testIsNumericSpace_NullInput_ReturnsFalse() {
        // Arrange
        CharSequence cs = null;
        
        // Act
        boolean result = StringUtils.isNumericSpace(cs);
        
        // Assert
        assertFalse(result);
    }
    
    @Test
    public void testIsNumericSpace_EmptyInput_ReturnsTrue() {
        // Arrange
        CharSequence cs = "";
        
        // Act
        boolean result = StringUtils.isNumericSpace(cs);
        
        // Assert
        assertTrue(result);
    }
    
    @Test
    public void testIsNumericSpace_WhitespaceInput_ReturnsTrue() {
        // Arrange
        CharSequence cs = "  ";
        
        // Act
        boolean result = StringUtils.isNumericSpace(cs);
        
        // Assert
        assertTrue(result);
    }
    
    @Test
    public void testIsNumericSpace_OnlyDigitsInput_ReturnsTrue() {
        // Arrange
        CharSequence cs = "123";
        
        // Act
        boolean result = StringUtils.isNumericSpace(cs);
        
        // Assert
        assertTrue(result);
    }
    
    @Test
    public void testIsNumericSpace_DigitsAndWhitespaceInput_ReturnsTrue() {
        // Arrange
        CharSequence cs = "12 3";
        
        // Act
        boolean result = StringUtils.isNumericSpace(cs);
        
        // Assert
        assertTrue(result);
    }
    
    @Test
    public void testIsNumericSpace_UnicodeDigitsInput_ReturnsTrue() {
        // Arrange
        CharSequence cs = "\u0967\u0968\u0969";
        
        // Act
        boolean result = StringUtils.isNumericSpace(cs);
        
        // Assert
        assertTrue(result);
    }
    
    @Test
    public void testIsNumericSpace_UnicodeDigitsAndWhitespaceInput_ReturnsTrue() {
        // Arrange
        CharSequence cs = "\u0967\u0968 \u0969";
        
        // Act
        boolean result = StringUtils.isNumericSpace(cs);
        
        // Assert
        assertTrue(result);
    }
    
    @Test
    public void testIsNumericSpace_NonNumericInput_ReturnsFalse() {
        // Arrange
        CharSequence cs = "ab2c";
        
        // Act
        boolean result = StringUtils.isNumericSpace(cs);
        
        // Assert
        assertFalse(result);
    }
    
    @Test
    public void testIsNumericSpace_InputWithHyphen_ReturnsFalse() {
        // Arrange
        CharSequence cs = "12-3";
        
        // Act
        boolean result = StringUtils.isNumericSpace(cs);
        
        // Assert
        assertFalse(result);
    }
    
    @Test
    public void testIsNumericSpace_InputWithDecimalPoint_ReturnsFalse() {
        // Arrange
        CharSequence cs = "12.3";
        
        // Act
        boolean result = StringUtils.isNumericSpace(cs);
        
        // Assert
        assertFalse(result);
    }





    @Test
    public void leftPad_NullString_ReturnsNull() {
        // Arrange
        String str = null;
        int size = 5;
        char padChar = '*';

        // Act
        String result = StringUtils.leftPad(str, size, padChar);

        // Assert
        assertNull(result);
    }

    @Test
    public void leftPad_EmptyString_ReturnsPaddedString() {
        // Arrange
        String str = "";
        int size = 5;
        char padChar = '*';

        // Act
        String result = StringUtils.leftPad(str, size, padChar);

        // Assert
        assertEquals("*****", result);
    }

    @Test
    public void leftPad_StringNotPadded_ReturnsOriginalString() {
        // Arrange
        String str = "bat";
        int size = 3;
        char padChar = '*';

        // Act
        String result = StringUtils.leftPad(str, size, padChar);

        // Assert
        assertEquals("bat", result);
    }

    @Test
    public void leftPad_StringPaddedWithSpace_ReturnsPaddedString() {
        // Arrange
        String str = "bat";
        int size = 5;
        char padChar = ' ';

        // Act
        String result = StringUtils.leftPad(str, size, padChar);

        // Assert
        assertEquals("  bat", result);
    }

    @Test
    public void leftPad_StringPaddedWithCustomChar_ReturnsPaddedString() {
        // Arrange
        String str = "bat";
        int size = 5;
        char padChar = '*';

        // Act
        String result = StringUtils.leftPad(str, size, padChar);

        // Assert
        assertEquals("**bat", result);
    }

    @Test
    public void leftPad_StringPaddedWithCustomString_ReturnsPaddedString() {
        // Arrange
        String str = "bat";
        int size = 8;
        String padStr = "yz";

        // Act
        String result = StringUtils.leftPad(str, size, padStr);

        // Assert
        assertEquals("yzyzybat", result);
    }

    @Test
    public void leftPad_StringPaddedWithEmptyString_ReturnsPaddedString() {
        // Arrange
        String str = "bat";
        int size = 5;
        String padStr = "";

        // Act
        String result = StringUtils.leftPad(str, size, padStr);

        // Assert
        assertEquals("  bat", result);
    }

    @Test
    public void leftPad_StringPaddedWithNullString_ReturnsPaddedString() {
        // Arrange
        String str = "bat";
        int size = 5;
        String padStr = null;

        // Act
        String result = StringUtils.leftPad(str, size, padStr);

        // Assert
        assertEquals("  bat", result);
    }





    @Test
    public void testIsAllBlank_WithNull_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence[] css = null;

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllBlank(css);

        assertTrue(result);
    }
    
    @Test
    public void testIsAllBlank_WithNullAndNonBlank_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence[] css = {null, "foo"};

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllBlank(css);

        assertFalse(result);
    }
    
    @Test
    public void testIsAllBlank_WithNullAndNull_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence[] css = {null, null};

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllBlank(css);

        assertTrue(result);
    }
    
    @Test
    public void testIsAllBlank_WithEmptyAndNonBlank_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence[] css = {"", "bar"};

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllBlank(css);

        assertFalse(result);
    }
    
    @Test
    public void testIsAllBlank_WithNonBlankAndEmpty_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence[] css = {"bob", ""};

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllBlank(css);

        assertFalse(result);
    }
    
    @Test
    public void testIsAllBlank_WithWhitespaceAndNull_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence[] css = {"  bob  ", null};

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllBlank(css);

        assertFalse(result);
    }
    
    @Test
    public void testIsAllBlank_WithSingleWhitespaceAndNonBlank_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence[] css = {" ", "bar"};

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllBlank(css);

        assertFalse(result);
    }
    
    @Test
    public void testIsAllBlank_WithNonBlankAndNonBlank_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence[] css = {"foo", "bar"};

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllBlank(css);

        assertFalse(result);
    }
    
    @Test
    public void testIsAllBlank_WithEmptyArray_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence[] css = {};

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllBlank(css);

        assertTrue(result);
    }




    
    @Mock
    private StringUtils stringUtils;
    
//    @Test
//    public void testSubstringWithPositiveStart() {
//        // Instantiate all necessary variables here
//        String str = "abcdef";
//        int start = 2;
//
//        // Mock the StringUtils class
//        when(stringUtils.substring(str, start)).thenReturn("cdef");
//
//        // Write the test code here following the given rules
//        String result = stringUtils.substring(str, start);
//
//        // Verify the result
//        assertEquals("cdef", result);
//    }
    
//    @Test
//    public void testSubstringWithNegativeStart() {
//        // Instantiate all necessary variables here
//        String str = "abcdef";
//        int start = -2;
//
//        // Mock the StringUtils class
//        when(stringUtils.substring(str, start)).thenReturn("ef");
//
//        // Write the test code here following the given rules
//        String result = stringUtils.substring(str, start);
//
//        // Verify the result
//        assertEquals("ef", result);
//    }
    
//    @Test
//    public void testSubstringWithOutOfBoundsStart() {
//        // Instantiate all necessary variables here
//        String str = "abcdef";
//        int start = 10;
//
//        // Mock the StringUtils class
//        when(stringUtils.substring(str, start)).thenReturn("");
//
//        // Write the test code here following the given rules
//        String result = stringUtils.substring(str, start);
//
//        // Verify the result
//        assertEquals("", result);
//    }
    
//    @Test
//    public void testSubstringWithNullString() {
//        // Instantiate all necessary variables here
//        String str = null;
//        int start = 2;
//
//        // Mock the StringUtils class
//        when(stringUtils.substring(str, start)).thenReturn(null);
//
//        // Write the test code here following the given rules
//        String result = stringUtils.substring(str, start);
//
//        // Verify the result
//        assertNull(result);
//    }
//
//    @Test
//    public void testSubstringWithEmptyString() {
//        // Instantiate all necessary variables here
//        String str = "";
//        int start = 2;
//
//        // Mock the StringUtils class
//        when(stringUtils.substring(str, start)).thenReturn("");
//
//        // Write the test code here following the given rules
//        String result = stringUtils.substring(str, start);
//
//        // Verify the result
//        assertEquals("", result);
//    }
    
//    @Test
//    public void testSubstringWithPositiveStartAndEnd() {
//        // Instantiate all necessary variables here
//        String str = "abcdef";
//        int start = 1;
//        int end = 4;
//
//        // Mock the StringUtils class
//        when(stringUtils.substring(str, start, end)).thenReturn("bcd");
//
//        // Write the test code here following the given rules
//        String result = stringUtils.substring(str, start, end);
//
//        // Verify the result
//        assertEquals("bcd", result);
//    }
    
//    @Test
//    public void testSubstringWithNegativeStartAndEnd() {
//        // Instantiate all necessary variables here
//        String str = "abcdef";
//        int start = -3;
//        int end = -1;
//
//        // Mock the StringUtils class
//        when(stringUtils.substring(str, start, end)).thenReturn("de");
//
//        // Write the test code here following the given rules
//        String result = stringUtils.substring(str, start, end);
//
//        // Verify the result
//        assertEquals("de", result);
//    }
    
//    @Test
//    public void testSubstringWithOutOfBoundsStartAndEnd() {
//        // Instantiate all necessary variables here
//        String str = "abcdef";
//        int start = 0;
//        int end = 10;
//
//        // Mock the StringUtils class
//        when(stringUtils.substring(str, start, end)).thenReturn("abcdef");
//
//        // Write the test code here following the given rules
//        String result = stringUtils.substring(str, start, end);
//
//        // Verify the result
//        assertEquals("abcdef", result);
//    }
//
//    @Test
//    public void testSubstringWithStartGreaterThanEnd() {
//        // Instantiate all necessary variables here
//        String str = "abcdef";
//        int start = 4;
//        int end = 2;
//
//        // Mock the StringUtils class
//        when(stringUtils.substring(str, start, end)).thenReturn("");
//
//        // Write the test code here following the given rules
//        String result = stringUtils.substring(str, start, end);
//
//        // Verify the result
//        assertEquals("", result);
//    }
    
//    @Test
//    public void testSubstringWithNullStringAndStartAndEnd() {
//        // Instantiate all necessary variables here
//        String str = null;
//        int start = 1;
//        int end = 3;
//
//        // Mock the StringUtils class
//        when(stringUtils.substring(str, start, end)).thenReturn(null);
//
//        // Write the test code here following the given rules
//        String result = stringUtils.substring(str, start, end);
//
//        // Verify the result
//        assertNull(result);
//    }
    
//    @Test
//    public void testSubstringWithEmptyStringAndStartAndEnd() {
//        // Instantiate all necessary variables here
//        String str = "";
//        int start = 1;
//        int end = 3;
//
//        // Mock the StringUtils class
//        when(stringUtils.substring(str, start, end)).thenReturn("");
//
//        // Write the test code here following the given rules
//        String result = stringUtils.substring(str, start, end);
//
//        // Verify the result
//        assertEquals("", result);
//    }

















    @Test
    public void testIndexOfIgnoreCase_NullInput_ReturnsNegativeOne() {
        // Instantiate all necessary variables here
        CharSequence str = null;
        CharSequence searchStr = null;

        // Write the test code here following the given rules
        int result = StringUtils.indexOfIgnoreCase(str, searchStr);

        // Assert the result
        assertEquals(-1, result);
    }

    @Test
    public void testIndexOfIgnoreCase_EmptyInput_ReturnsZero() {
        // Instantiate all necessary variables here
        CharSequence str = "";
        CharSequence searchStr = "";

        // Write the test code here following the given rules
        int result = StringUtils.indexOfIgnoreCase(str, searchStr);

        // Assert the result
        assertEquals(0, result);
    }

    @Test
    public void testIndexOfIgnoreCase_WhitespaceInput_ReturnsZero() {
        // Instantiate all necessary variables here
        CharSequence str = " ";
        CharSequence searchStr = " ";

        // Write the test code here following the given rules
        int result = StringUtils.indexOfIgnoreCase(str, searchStr);

        // Assert the result
        assertEquals(0, result);
    }

    @Test
    public void testIndexOfIgnoreCase_MatchingCase_ReturnsCorrectIndex() {
        // Instantiate all necessary variables here
        CharSequence str = "aabaabaa";
        CharSequence searchStr = "a";

        // Write the test code here following the given rules
        int result = StringUtils.indexOfIgnoreCase(str, searchStr);

        // Assert the result
        assertEquals(0, result);
    }

//    @Test
//    public void testIndexOfIgnoreCase_NonMatchingCase_ReturnsNegativeOne() {
//        // Instantiate all necessary variables here
//        CharSequence str = "aabaabaa";
//        CharSequence searchStr = "b";
//
//        // Write the test code here following the given rules
//        int result = StringUtils.indexOfIgnoreCase(str, searchStr);
//
//        // Assert the result
//        assertEquals(-1, result);
//    }

    @Test
    public void testIndexOfIgnoreCase_PartialMatch_ReturnsCorrectIndex() {
        // Instantiate all necessary variables here
        CharSequence str = "aabaabaa";
        CharSequence searchStr = "ab";

        // Write the test code here following the given rules
        int result = StringUtils.indexOfIgnoreCase(str, searchStr);

        // Assert the result
        assertEquals(1, result);
    }

    @Test
    public void testIndexOfIgnoreCase_StartPosition_ReturnsCorrectIndex() {
        // Instantiate all necessary variables here
        CharSequence str = "aabaabaa";
        CharSequence searchStr = "b";
        int startPos = 3;

        // Write the test code here following the given rules
        int result = StringUtils.indexOfIgnoreCase(str, searchStr, startPos);

        // Assert the result
        assertEquals(5, result);
    }

    @Test
    public void testIndexOfIgnoreCase_StartPositionGreaterThanStringLength_ReturnsNegativeOne() {
        // Instantiate all necessary variables here
        CharSequence str = "aabaabaa";
        CharSequence searchStr = "b";
        int startPos = 9;

        // Write the test code here following the given rules
        int result = StringUtils.indexOfIgnoreCase(str, searchStr, startPos);

        // Assert the result
        assertEquals(-1, result);
    }

    @Test
    public void testIndexOfIgnoreCase_NegativeStartPosition_ReturnsZero() {
        // Instantiate all necessary variables here
        CharSequence str = "aabaabaa";
        CharSequence searchStr = "B";
        int startPos = -1;

        // Write the test code here following the given rules
        int result = StringUtils.indexOfIgnoreCase(str, searchStr, startPos);

        // Assert the result
        assertEquals(2, result);
    }

    @Test
    public void testIndexOfIgnoreCase_EmptySearchStr_ReturnsStartPosition() {
        // Instantiate all necessary variables here
        CharSequence str = "aabaabaa";
        CharSequence searchStr = "";
        int startPos = 2;

        // Write the test code here following the given rules
        int result = StringUtils.indexOfIgnoreCase(str, searchStr, startPos);

        // Assert the result
        assertEquals(2, result);
    }

    @Test
    public void testIndexOfIgnoreCase_EmptySearchStr_ReturnsNegativeOne() {
        // Instantiate all necessary variables here
        CharSequence str = "abc";
        CharSequence searchStr = "";
        int startPos = 9;

        // Write the test code here following the given rules
        int result = StringUtils.indexOfIgnoreCase(str, searchStr, startPos);

        // Assert the result
        assertEquals(-1, result);
    }













    @Test
    public void testStartsWith_NullStrAndNullPrefix_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence str = null;
        CharSequence prefix = null;

        // Write the test code here following the given rules
        boolean result = StringUtils.startsWith(str, prefix);

        assertTrue(result);
    }

    @Test
    public void testStartsWith_NullStrAndNonNullPrefix_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence str = null;
        CharSequence prefix = "abc";

        // Write the test code here following the given rules
        boolean result = StringUtils.startsWith(str, prefix);

        assertFalse(result);
    }

    @Test
    public void testStartsWith_NonNullStrAndNullPrefix_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence str = "abcdef";
        CharSequence prefix = null;

        // Write the test code here following the given rules
        boolean result = StringUtils.startsWith(str, prefix);

        assertFalse(result);
    }

    @Test
    public void testStartsWith_StrStartsWithPrefix_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence str = "abcdef";
        CharSequence prefix = "abc";

        // Write the test code here following the given rules
        boolean result = StringUtils.startsWith(str, prefix);

        assertTrue(result);
    }

    @Test
    public void testStartsWith_StrDoesNotStartWithPrefix_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence str = "ABCDEF";
        CharSequence prefix = "abc";

        // Write the test code here following the given rules
        boolean result = StringUtils.startsWith(str, prefix);

        assertFalse(result);
    }





    @Test
    public void truncate_WhenStringIsNull_ShouldReturnNull() {
        // Arrange
        String str = null;
        int maxWidth = 5;

        // Act
        String result = StringUtils.truncate(str, maxWidth);

        // Assert
        assertNull(result);
    }

    @Test
    public void truncate_WhenStringIsEmpty_ShouldReturnEmptyString() {
        // Arrange
        String str = "";
        int maxWidth = 5;

        // Act
        String result = StringUtils.truncate(str, maxWidth);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void truncate_WhenStringIsLessThanMaxWidth_ShouldReturnSameString() {
        // Arrange
        String str = "abc";
        int maxWidth = 5;

        // Act
        String result = StringUtils.truncate(str, maxWidth);

        // Assert
        assertEquals("abc", result);
    }

    @Test
    public void truncate_WhenStringIsEqualToMaxWidth_ShouldReturnSameString() {
        // Arrange
        String str = "abcde";
        int maxWidth = 5;

        // Act
        String result = StringUtils.truncate(str, maxWidth);

        // Assert
        assertEquals("abcde", result);
    }

    @Test
    public void truncate_WhenStringIsGreaterThanMaxWidth_ShouldTruncateString() {
        // Arrange
        String str = "abcdefgh";
        int maxWidth = 5;

        // Act
        String result = StringUtils.truncate(str, maxWidth);

        // Assert
        assertEquals("abcde", result);
    }

    @Test
    public void truncate_WhenMaxWidthIsNegative_ShouldThrowIllegalArgumentException() {
        // Arrange
        String str = "abc";
        int maxWidth = -1;

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            // Act
            StringUtils.truncate(str, maxWidth);
        });
    }

    @Test
    public void truncate_WhenOffsetIsNegative_ShouldThrowIllegalArgumentException() {
        // Arrange
        String str = "abc";
        int offset = -1;
        int maxWidth = 5;

        // Assert
        assertThrows(IllegalArgumentException.class, () -> {
            // Act
            StringUtils.truncate(str, offset, maxWidth);
        });
    }

    @Test
    public void truncate_WhenOffsetIsGreaterThanStringLength_ShouldReturnEmptyString() {
        // Arrange
        String str = "abc";
        int offset = 5;
        int maxWidth = 5;

        // Act
        String result = StringUtils.truncate(str, offset, maxWidth);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void truncate_WhenOffsetPlusMaxWidthIsGreaterThanStringLength_ShouldTruncateString() {
        // Arrange
        String str = "abcdefgh";
        int offset = 2;
        int maxWidth = 10;

        // Act
        String result = StringUtils.truncate(str, offset, maxWidth);

        // Assert
        assertEquals("cdefgh", result);
    }











    @Test
    public void stripStart_NullInput_ReturnsNull() {
        // Instantiate all necessary variables here
        String str = null;
        String stripChars = null;

        // Write the test code here following the given rules
        String result = StringUtils.stripStart(str, stripChars);

        // Verify the result
        assertNull(result);
    }

    @Test
    public void stripStart_EmptyInput_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        String str = "";
        String stripChars = null;

        // Write the test code here following the given rules
        String result = StringUtils.stripStart(str, stripChars);

        // Verify the result
        assertEquals("", result);
    }

    @Test
    public void stripStart_InputWithNoStripChars_ReturnsInputString() {
        // Instantiate all necessary variables here
        String str = "abc";
        String stripChars = "";

        // Write the test code here following the given rules
        String result = StringUtils.stripStart(str, stripChars);

        // Verify the result
        assertEquals("abc", result);
    }

    @Test
    public void stripStart_InputWithWhitespaceStripChars_ReturnsStrippedString() {
        // Instantiate all necessary variables here
        String str = "  abc";
        String stripChars = null;

        // Write the test code here following the given rules
        String result = StringUtils.stripStart(str, stripChars);

        // Verify the result
        assertEquals("abc", result);
    }

    @Test
    public void stripStart_InputWithNonWhitespaceStripChars_ReturnsStrippedString() {
        // Instantiate all necessary variables here
        String str = "yxabc  ";
        String stripChars = "xyz";

        // Write the test code here following the given rules
        String result = StringUtils.stripStart(str, stripChars);

        // Verify the result
        assertEquals("abc  ", result);
    }









    @Test
    public void testIndexOf_NullCharSequence_ReturnsMinusOne() {
        // Arrange
        CharSequence seq = null;
        CharSequence searchSeq = "abc";
        
        // Act
        int result = StringUtils.indexOf(seq, searchSeq);
        
        // Assert
        assertEquals(-1, result);
    }

    @Test
    public void testIndexOf_NullSearchCharSequence_ReturnsMinusOne() {
        // Arrange
        CharSequence seq = "abc";
        CharSequence searchSeq = null;
        
        // Act
        int result = StringUtils.indexOf(seq, searchSeq);
        
        // Assert
        assertEquals(-1, result);
    }

    @Test
    public void testIndexOf_EmptyCharSequence_ReturnsMinusOne() {
        // Arrange
        CharSequence seq = "";
        CharSequence searchSeq = "abc";
        
        // Act
        int result = StringUtils.indexOf(seq, searchSeq);
        
        // Assert
        assertEquals(-1, result);
    }

    @Test
    public void testIndexOf_EmptySearchCharSequence_ReturnsZero() {
        // Arrange
        CharSequence seq = "abc";
        CharSequence searchSeq = "";
        
        // Act
        int result = StringUtils.indexOf(seq, searchSeq);
        
        // Assert
        assertEquals(0, result);
    }

    @Test
    public void testIndexOf_SearchCharSequenceLargerThanSeq_ReturnsMinusOne() {
        // Arrange
        CharSequence seq = "abc";
        CharSequence searchSeq = "abcdef";
        
        // Act
        int result = StringUtils.indexOf(seq, searchSeq);
        
        // Assert
        assertEquals(-1, result);
    }

    @Test
    public void testIndexOf_SearchCharSequenceFound_ReturnsCorrectIndex() {
        // Arrange
        CharSequence seq = "aabaabaa";
        CharSequence searchSeq = "ab";
        
        // Act
        int result = StringUtils.indexOf(seq, searchSeq);
        
        // Assert
        assertEquals(1, result);
    }

    @Test
    public void testIndexOf_SearchCharSequenceNotFound_ReturnsMinusOne() {
        // Arrange
        CharSequence seq = "aabaabaa";
        CharSequence searchSeq = "cd";
        
        // Act
        int result = StringUtils.indexOf(seq, searchSeq);
        
        // Assert
        assertEquals(-1, result);
    }

    @Test
    public void testIndexOf_CharSequenceWithStartPos_ReturnsCorrectIndex() {
        // Arrange
        CharSequence seq = "aabaabaa";
        CharSequence searchSeq = "ab";
        int startPos = 3;
        
        // Act
        int result = StringUtils.indexOf(seq, searchSeq, startPos);
        
        // Assert
        assertEquals(4, result);
    }

    @Test
    public void testIndexOf_StartPosLargerThanSeqLength_ReturnsMinusOne() {
        // Arrange
        CharSequence seq = "aabaabaa";
        CharSequence searchSeq = "ab";
        int startPos = 9;
        
        // Act
        int result = StringUtils.indexOf(seq, searchSeq, startPos);
        
        // Assert
        assertEquals(-1, result);
    }

    @Test
    public void testIndexOf_StartPosNegative_ReturnsCorrectIndex() {
        // Arrange
        CharSequence seq = "aabaabaa";
        CharSequence searchSeq = "ab";
        int startPos = -1;
        
        // Act
        int result = StringUtils.indexOf(seq, searchSeq, startPos);
        
        // Assert
        assertEquals(1, result);
    }

    @Test
    public void testIndexOf_SearchChar_ReturnsCorrectIndex() {
        // Arrange
        CharSequence seq = "aabaabaa";
        char searchChar = 'b';
        
        // Act
        int result = StringUtils.indexOf(seq, searchChar);
        
        // Assert
        assertEquals(2, result);
    }

    @Test
    public void testIndexOf_SearchCharNotFound_ReturnsMinusOne() {
        // Arrange
        CharSequence seq = "aabaabaa";
        char searchChar = 'c';
        
        // Act
        int result = StringUtils.indexOf(seq, searchChar);
        
        // Assert
        assertEquals(-1, result);
    }





    @Test
    public void testIsNotEmpty_WhenCharSequenceIsNull_ReturnsFalse() {
        // Arrange
        CharSequence cs = null;

        // Act
        boolean result = StringUtils.isNotEmpty(cs);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsNotEmpty_WhenCharSequenceIsEmpty_ReturnsFalse() {
        // Arrange
        CharSequence cs = "";

        // Act
        boolean result = StringUtils.isNotEmpty(cs);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsNotEmpty_WhenCharSequenceIsNotEmpty_ReturnsTrue() {
        // Arrange
        CharSequence cs = " ";

        // Act
        boolean result = StringUtils.isNotEmpty(cs);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsNotEmpty_WhenCharSequenceHasContent_ReturnsTrue() {
        // Arrange
        CharSequence cs = "bob";

        // Act
        boolean result = StringUtils.isNotEmpty(cs);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsNotEmpty_WhenCharSequenceHasWhitespace_ReturnsTrue() {
        // Arrange
        CharSequence cs = "  bob  ";

        // Act
        boolean result = StringUtils.isNotEmpty(cs);

        // Assert
        assertTrue(result);
    }









    @Test
    public void isAnyBlank_NullArray_ReturnsFalse() {
        // Arrange
        CharSequence[] css = null;

        // Act
        boolean result = StringUtils.isAnyBlank(css);

        // Assert
        assertFalse(result);
    }

    @Test
    public void isAnyBlank_EmptyArray_ReturnsFalse() {
        // Arrange
        CharSequence[] css = new CharSequence[0];

        // Act
        boolean result = StringUtils.isAnyBlank(css);

        // Assert
        assertFalse(result);
    }

    @Test
    public void isAnyBlank_NullElement_ReturnsTrue() {
        // Arrange
        CharSequence[] css = {null, "foo"};

        // Act
        boolean result = StringUtils.isAnyBlank(css);

        // Assert
        assertTrue(result);
    }

    @Test
    public void isAnyBlank_NullElements_ReturnsTrue() {
        // Arrange
        CharSequence[] css = {null, null};

        // Act
        boolean result = StringUtils.isAnyBlank(css);

        // Assert
        assertTrue(result);
    }

    @Test
    public void isAnyBlank_BlankElement_ReturnsTrue() {
        // Arrange
        CharSequence[] css = {"", "bar"};

        // Act
        boolean result = StringUtils.isAnyBlank(css);

        // Assert
        assertTrue(result);
    }

    @Test
    public void isAnyBlank_BlankElements_ReturnsTrue() {
        // Arrange
        CharSequence[] css = {"bob", ""};

        // Act
        boolean result = StringUtils.isAnyBlank(css);

        // Assert
        assertTrue(result);
    }

    @Test
    public void isAnyBlank_WhitespaceElement_ReturnsTrue1() {
        // Arrange
        CharSequence[] css = {"  bob  ", null};

        // Act
        boolean result = StringUtils.isAnyBlank(css);

        // Assert
        assertTrue(result);
    }

    @Test
    public void isAnyBlank_WhitespaceElement_ReturnsTrue2() {
        // Arrange
        CharSequence[] css = {" ", "bar"};

        // Act
        boolean result = StringUtils.isAnyBlank(css);

        // Assert
        assertTrue(result);
    }

    @Test
    public void isAnyBlank_EmptyStringArray_ReturnsFalse() {
        // Arrange
        CharSequence[] css = {};

        // Act
        boolean result = StringUtils.isAnyBlank(css);

        // Assert
        assertFalse(result);
    }

    @Test
    public void isAnyBlank_EmptyStringElement_ReturnsTrue() {
        // Arrange
        CharSequence[] css = {""};

        // Act
        boolean result = StringUtils.isAnyBlank(css);

        // Assert
        assertTrue(result);
    }

    @Test
    public void isAnyBlank_NonBlankElements_ReturnsFalse() {
        // Arrange
        CharSequence[] css = {"foo", "bar"};

        // Act
        boolean result = StringUtils.isAnyBlank(css);

        // Assert
        assertFalse(result);
    }





    @Test
    public void testEquals_BothNull_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs1 = null;
        CharSequence cs2 = null;
        
        // Write the test code here following the given rules
        boolean result = StringUtils.equals(cs1, cs2);
        
        assertTrue(result);
    }
    
    @Test
    public void testEquals_OneNullOneNotNull_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs1 = "abc";
        CharSequence cs2 = null;
        
        // Write the test code here following the given rules
        boolean result = StringUtils.equals(cs1, cs2);
        
        assertFalse(result);
    }
    
    @Test
    public void testEquals_DifferentLength_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs1 = "abc";
        CharSequence cs2 = "abcd";
        
        // Write the test code here following the given rules
        boolean result = StringUtils.equals(cs1, cs2);
        
        assertFalse(result);
    }
    
    @Test
    public void testEquals_CaseSensitive_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs1 = "abc";
        CharSequence cs2 = "ABC";
        
        // Write the test code here following the given rules
        boolean result = StringUtils.equals(cs1, cs2);
        
        assertFalse(result);
    }
    
    @Test
    public void testEquals_EqualSequences_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs1 = "abc";
        CharSequence cs2 = "abc";
        
        // Write the test code here following the given rules
        boolean result = StringUtils.equals(cs1, cs2);
        
        assertTrue(result);
    }
    
    @Test
    public void testEquals_EqualSequencesDifferentTypes_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs1 = new StringBuilder("abc");
        CharSequence cs2 = new StringBuffer("abc");
        
        // Write the test code here following the given rules
        boolean result = StringUtils.equals(cs1, cs2);
        
        assertTrue(result);
    }









//    @Test
//    public void testRemoveAll() {
//        // Instantiate all necessary variables here
//        String text = "ABCabc123abc";
//        String regex = "[a-z]";
//
//        // Mock the RegExUtils class
//        try (MockedStatic<RegExUtils> mockedStatic = Mockito.mockStatic(RegExUtils.class)) {
//            // Mock the removeAll() method of RegExUtils class
//            mockedStatic.when(() -> RegExUtils.removeAll(text, regex)).thenAnswer(new Answer<String>() {
//                @Override
//                public String answer(InvocationOnMock invocation) throws Throwable {
//                    String text = invocation.getArgument(0);
//                    String regex = invocation.getArgument(1);
//                    return text.replaceAll(regex, "");
//                }
//            });
//
//            // Call the method under test
//            String result = StringUtils.removeAll(text, regex);
//
//            // Verify the result
//            assertEquals("ABC123", result);
//        }
//    }





    @Test
    public void testRemoveEndIgnoreCase_NullSourceString_ReturnsNull() {
        // Instantiate all necessary variables here
        String str = null;
        String remove = ".com";

        // Write the test code here following the given rules
        String result = StringUtils.removeEndIgnoreCase(str, remove);

        assertNull(result);
    }

    @Test
    public void testRemoveEndIgnoreCase_EmptySourceString_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        String str = "";
        String remove = ".com";

        // Write the test code here following the given rules
        String result = StringUtils.removeEndIgnoreCase(str, remove);

        assertEquals("", result);
    }

    @Test
    public void testRemoveEndIgnoreCase_NullRemoveString_ReturnsSourceString() {
        // Instantiate all necessary variables here
        String str = "www.domain.com";
        String remove = null;

        // Write the test code here following the given rules
        String result = StringUtils.removeEndIgnoreCase(str, remove);

        assertEquals("www.domain.com", result);
    }

    @Test
    public void testRemoveEndIgnoreCase_ExactMatch_ReturnsSubstringRemoved() {
        // Instantiate all necessary variables here
        String str = "www.domain.com";
        String remove = ".com";

        // Write the test code here following the given rules
        String result = StringUtils.removeEndIgnoreCase(str, remove);

        assertEquals("www.domain", result);
    }

    @Test
    public void testRemoveEndIgnoreCase_PartialMatch_ReturnsSourceString() {
        // Instantiate all necessary variables here
        String str = "www.domain.com";
        String remove = "domain";

        // Write the test code here following the given rules
        String result = StringUtils.removeEndIgnoreCase(str, remove);

        assertEquals("www.domain.com", result);
    }

    @Test
    public void testRemoveEndIgnoreCase_EmptyRemoveString_ReturnsSourceString() {
        // Instantiate all necessary variables here
        String str = "abc";
        String remove = "";

        // Write the test code here following the given rules
        String result = StringUtils.removeEndIgnoreCase(str, remove);

        assertEquals("abc", result);
    }

    @Test
    public void testRemoveEndIgnoreCase_CaseInsensitiveMatch_ReturnsSubstringRemoved() {
        // Instantiate all necessary variables here
        String str = "www.domain.COM";
        String remove = ".com";

        // Write the test code here following the given rules
        String result = StringUtils.removeEndIgnoreCase(str, remove);

        assertEquals("www.domain", result);
    }







    @Test
    public void testSplitPreserveAllTokens_NullInput_ReturnNull() {
        // Instantiate all necessary variables here
        String str = null;

        // Write the test code here following the given rules
        String[] result = StringUtils.splitPreserveAllTokens(str);
        
        // Assert
        assertNull(result);
    }
    
    @Test
    public void testSplitPreserveAllTokens_EmptyInput_ReturnEmptyArray() {
        // Instantiate all necessary variables here
        String str = "";

        // Write the test code here following the given rules
        String[] result = StringUtils.splitPreserveAllTokens(str);
        
        // Assert
        assertEquals(0, result.length);
    }
    
    @Test
    public void testSplitPreserveAllTokens_NoSeparators_ReturnArrayWithOneElement() {
        // Instantiate all necessary variables here
        String str = "abc";

        // Write the test code here following the given rules
        String[] result = StringUtils.splitPreserveAllTokens(str);
        
        // Assert
        assertEquals(1, result.length);
        assertEquals("abc", result[0]);
    }
    
    @Test
    public void testSplitPreserveAllTokens_OneSeparator_ReturnArrayWithTwoElements() {
        // Instantiate all necessary variables here
        String str = "abc def";
        char separatorChar = ' ';

        // Write the test code here following the given rules
        String[] result = StringUtils.splitPreserveAllTokens(str, separatorChar);
        
        // Assert
        assertEquals(2, result.length);
        assertEquals("abc", result[0]);
        assertEquals("def", result[1]);
    }
    
    @Test
    public void testSplitPreserveAllTokens_MultipleSeparators_ReturnArrayWithEmptyElements() {
        // Instantiate all necessary variables here
        String str = "abc  def";
        char separatorChar = ' ';

        // Write the test code here following the given rules
        String[] result = StringUtils.splitPreserveAllTokens(str, separatorChar);
        
        // Assert
        assertEquals(3, result.length);
        assertEquals("abc", result[0]);
        assertEquals("", result[1]);
        assertEquals("def", result[2]);
    }
    
    @Test
    public void testSplitPreserveAllTokens_MultipleSeparators_ReturnArrayWithEmptyFirstAndLastElements() {
        // Instantiate all necessary variables here
        String str = " abc ";
        String separatorChars = " ";

        // Write the test code here following the given rules
        String[] result = StringUtils.splitPreserveAllTokens(str, separatorChars);
        
        // Assert
        assertEquals(3, result.length);
        assertEquals("", result[0]);
        assertEquals("abc", result[1]);
        assertEquals("", result[2]);
    }
    
    @Test
    public void testSplitPreserveAllTokens_MaxLimitExceeded_ReturnArrayWithLimitedElements() {
        // Instantiate all necessary variables here
        String str = "abc def ghi";
        String separatorChars = " ";
        int max = 2;

        // Write the test code here following the given rules
        String[] result = StringUtils.splitPreserveAllTokens(str, separatorChars, max);
        
        // Assert
        assertEquals(2, result.length);
        assertEquals("abc", result[0]);
        assertEquals("def ghi", result[1]);
    }
    
    @Test
    public void testSplitPreserveAllTokens_MaxLimitZero_ReturnArrayWithAllElements() {
        // Instantiate all necessary variables here
        String str = "abc def ghi";
        String separatorChars = " ";
        int max = 0;

        // Write the test code here following the given rules
        String[] result = StringUtils.splitPreserveAllTokens(str, separatorChars, max);
        
        // Assert
        assertEquals(3, result.length);
        assertEquals("abc", result[0]);
        assertEquals("def", result[1]);
        assertEquals("ghi", result[2]);
    }





    @Test
    public void testIndexOfDifference_TwoNullStrings_ReturnsNegativeOne() {
        CharSequence cs1 = null;
        CharSequence cs2 = null;

        int result = StringUtils.indexOfDifference(cs1, cs2);

        assertEquals(-1, result);
    }

    @Test
    public void testIndexOfDifference_TwoEmptyStrings_ReturnsNegativeOne() {
        CharSequence cs1 = "";
        CharSequence cs2 = "";

        int result = StringUtils.indexOfDifference(cs1, cs2);

        assertEquals(-1, result);
    }

    @Test
    public void testIndexOfDifference_EmptyStringAndNonEmptyString_ReturnsZero() {
        CharSequence cs1 = "";
        CharSequence cs2 = "abc";

        int result = StringUtils.indexOfDifference(cs1, cs2);

        assertEquals(0, result);
    }

    @Test
    public void testIndexOfDifference_NonEmptyStringAndEmptyString_ReturnsZero() {
        CharSequence cs1 = "abc";
        CharSequence cs2 = "";

        int result = StringUtils.indexOfDifference(cs1, cs2);

        assertEquals(0, result);
    }

    @Test
    public void testIndexOfDifference_EqualStrings_ReturnsNegativeOne() {
        CharSequence cs1 = "abc";
        CharSequence cs2 = "abc";

        int result = StringUtils.indexOfDifference(cs1, cs2);

        assertEquals(-1, result);
    }

    @Test
    public void testIndexOfDifference_DifferentStrings_ReturnsCorrectIndex() {
        CharSequence cs1 = "ab";
        CharSequence cs2 = "abxyz";

        int result = StringUtils.indexOfDifference(cs1, cs2);

        assertEquals(2, result);
    }

    @Test
    public void testIndexOfDifference_FirstStringLonger_ReturnsCorrectIndex() {
        CharSequence cs1 = "abcde";
        CharSequence cs2 = "abxyz";

        int result = StringUtils.indexOfDifference(cs1, cs2);

        assertEquals(2, result);
    }

    @Test
    public void testIndexOfDifference_SecondStringLonger_ReturnsCorrectIndex() {
        CharSequence cs1 = "abcde";
        CharSequence cs2 = "xyz";

        int result = StringUtils.indexOfDifference(cs1, cs2);

        assertEquals(0, result);
    }

    @Test
    public void testIndexOfDifference_MultipleStrings_NullStrings_ReturnsNegativeOne() {
        CharSequence[] css = {null};

        int result = StringUtils.indexOfDifference(css);

        assertEquals(-1, result);
    }

    @Test
    public void testIndexOfDifference_MultipleStrings_EmptyStrings_ReturnsNegativeOne() {
        CharSequence[] css = {"", ""};

        int result = StringUtils.indexOfDifference(css);

        assertEquals(-1, result);
    }

    @Test
    public void testIndexOfDifference_MultipleStrings_SomeNullStrings_ReturnsZero() {
        CharSequence[] css = {"", null};

        int result = StringUtils.indexOfDifference(css);

        assertEquals(0, result);
    }

    @Test
    public void testIndexOfDifference_MultipleStrings_SomeEmptyStrings_ReturnsZero() {
        CharSequence[] css = {"abc", null, null};

        int result = StringUtils.indexOfDifference(css);

        assertEquals(0, result);
    }

    @Test
    public void testIndexOfDifference_MultipleStrings_AllEqualStrings_ReturnsNegativeOne() {
        CharSequence[] css = {"abc", "abc"};

        int result = StringUtils.indexOfDifference(css);

        assertEquals(-1, result);
    }

    @Test
    public void testIndexOfDifference_MultipleStrings_FirstStringDifferent_ReturnsCorrectIndex() {
        CharSequence[] css = {"abc", "a"};

        int result = StringUtils.indexOfDifference(css);

        assertEquals(1, result);
    }

    @Test
    public void testIndexOfDifference_MultipleStrings_MiddleStringDifferent_ReturnsCorrectIndex() {
        CharSequence[] css = {"ab", "abxyz"};

        int result = StringUtils.indexOfDifference(css);

        assertEquals(2, result);
    }

    @Test
    public void testIndexOfDifference_MultipleStrings_LastStringDifferent_ReturnsCorrectIndex() {
        CharSequence[] css = {"abcde", "abxyz"};

        int result = StringUtils.indexOfDifference(css);

        assertEquals(2, result);
    }

    @Test
    public void testIndexOfDifference_MultipleStrings_AllDifferentStrings_ReturnsCorrectIndex() {
        CharSequence[] css = {"abcde", "xyz"};

        int result = StringUtils.indexOfDifference(css);

        assertEquals(0, result);
    }

    @Test
    public void testIndexOfDifference_MultipleStrings_DifferentStrings_ReturnsCorrectIndex() {
        CharSequence[] css = {"i am a machine", "i am a robot"};

        int result = StringUtils.indexOfDifference(css);

        assertEquals(7, result);
    }












  
  @Test
  public void testGetDigitsWithNullString() {
    String str = null;
    
    String result = StringUtils.getDigits(str);
    
    assertNull(result);
  }
  
  @Test
  public void testGetDigitsWithEmptyString() {
    String str = "";
    
    String result = StringUtils.getDigits(str);
    
    assertEquals("", result);
  }
  
  @Test
  public void testGetDigitsWithNoDigits() {
    String str = "abc";
    
    String result = StringUtils.getDigits(str);
    
    assertEquals("", result);
  }
  
  @Test
  public void testGetDigitsWithDigits() {
    String str = "1000$";
    
    String result = StringUtils.getDigits(str);
    
    assertEquals("1000", result);
  }
  
  @Test
  public void testGetDigitsWithMixedCharacters() {
    String str = "1123~45";
    
    String result = StringUtils.getDigits(str);
    
    assertEquals("112345", result);
  }
  
  @Test
  public void testGetDigitsWithPhoneNumber() {
    String str = "(541) 754-3010";
    
    String result = StringUtils.getDigits(str);
    
    assertEquals("5417543010", result);
  }
  
  @Test
  public void testGetDigitsWithUnicodeDigits() {
    String str = "\u0967\u0968\u0969";
    
    String result = StringUtils.getDigits(str);
    
    assertEquals("\u0967\u0968\u0969", result);
  }





    @Test
    public void testDefaultIfBlank_NullInput_ReturnsDefault() {
        // Instantiate all necessary variables here
        String str = null;
        String defaultStr = "DEFAULT";

        // Write the test code here following the given rules
        String result = StringUtils.defaultIfBlank(str, defaultStr);

        assertEquals(defaultStr, result);
    }

    @Test
    public void testDefaultIfBlank_EmptyInput_ReturnsDefault() {
        // Instantiate all necessary variables here
        String str = "";
        String defaultStr = "DEFAULT";

        // Write the test code here following the given rules
        String result = StringUtils.defaultIfBlank(str, defaultStr);

        assertEquals(defaultStr, result);
    }

    @Test
    public void testDefaultIfBlank_WhitespaceInput_ReturnsDefault() {
        // Instantiate all necessary variables here
        String str = "   ";
        String defaultStr = "DEFAULT";

        // Write the test code here following the given rules
        String result = StringUtils.defaultIfBlank(str, defaultStr);

        assertEquals(defaultStr, result);
    }

    @Test
    public void testDefaultIfBlank_NonBlankInput_ReturnsInput() {
        // Instantiate all necessary variables here
        String str = "input";
        String defaultStr = "DEFAULT";

        // Write the test code here following the given rules
        String result = StringUtils.defaultIfBlank(str, defaultStr);

        assertEquals(str, result);
    }

    @Test
    public void testDefaultIfBlank_BlankDefault_ReturnsInput() {
        // Instantiate all necessary variables here
        String str = "input";
        String defaultStr = "   ";

        // Write the test code here following the given rules
        String result = StringUtils.defaultIfBlank(str, defaultStr);

        assertEquals(str, result);
    }

    @Test
    public void testDefaultIfBlank_NullDefault_ReturnsInput() {
        // Instantiate all necessary variables here
        String str = "input";
        String defaultStr = null;

        // Write the test code here following the given rules
        String result = StringUtils.defaultIfBlank(str, defaultStr);

        assertEquals(str, result);
    }







    @Test
    public void stripAll_NullInput_ReturnsNull() {
        // Arrange
        String[] strs = null;

        // Act
        String[] result = StringUtils.stripAll(strs);

        // Assert
        assertNull(result);
    }

    @Test
    public void stripAll_EmptyArray_ReturnsEmptyArray() {
        // Arrange
        String[] strs = {};

        // Act
        String[] result = StringUtils.stripAll(strs);

        // Assert
        assertArrayEquals(new String[]{}, result);
    }

    @Test
    public void stripAll_NoStripChars_ReturnsStrippedStrings() {
        // Arrange
        String[] strs = {"abc", "  abc"};

        // Act
        String[] result = StringUtils.stripAll(strs);

        // Assert
        assertArrayEquals(new String[]{"abc", "abc"}, result);
    }

    @Test
    public void stripAll_NullStripChars_ReturnsStrippedStringsIncludingNull() {
        // Arrange
        String[] strs = {"abc  ", null};

        // Act
        String[] result = StringUtils.stripAll(strs, null);

        // Assert
        assertArrayEquals(new String[]{"abc", null}, result);
    }

    @Test
    public void stripAll_StripCharsWithWhitespace_ReturnsStrippedStrings() {
        // Arrange
        String[] strs = {"abc  ", null};

        // Act
        String[] result = StringUtils.stripAll(strs, "yz");

        // Assert
        assertArrayEquals(new String[]{"abc  ", null}, result);
    }

    @Test
    public void stripAll_StripCharsWithoutWhitespace_ReturnsStrippedStrings() {
        // Arrange
        String[] strs = {"yabcz", null};

        // Act
        String[] result = StringUtils.stripAll(strs, "yz");

        // Assert
        assertArrayEquals(new String[]{"abc", null}, result);
    }











//    @Test
//    public void testConvertRemainingAccentCharacters() {
//        // Instantiate all necessary variables here
//        StringBuilder decomposed = new StringBuilder("abc\u0141\u0142def");
//        StringUtils stringUtils = new StringUtils();
//
//        // Write the test code here following the given rules
//        stringUtils.convertRemainingAccentCharacters(decomposed);
//
//        assertEquals("abclLdef", decomposed.toString());
//    }









    @Test
    public void testCapitalize_NullInput_ReturnsNull() {
        String str = null;

        String result = StringUtils.capitalize(str);

        assertNull(result);
    }

    @Test
    public void testCapitalize_EmptyString_ReturnsEmptyString() {
        String str = "";

        String result = StringUtils.capitalize(str);

        assertEquals("", result);
    }

    @Test
    public void testCapitalize_FirstCharacterLowercase_ReturnsCapitalizedString() {
        String str = "cat";

        String result = StringUtils.capitalize(str);

        assertEquals("Cat", result);
    }

    @Test
    public void testCapitalize_FirstCharacterUppercase_ReturnsSameString() {
        String str = "Cat";

        String result = StringUtils.capitalize(str);

        assertEquals("Cat", result);
    }

    @Test
    public void testCapitalize_SingleCharacterLowerCase_ReturnsCapitalizedString() {
        String str = "a";

        String result = StringUtils.capitalize(str);

        assertEquals("A", result);
    }

    @Test
    public void testCapitalize_SingleCharacterUpperCase_ReturnsSameString() {
        String str = "A";

        String result = StringUtils.capitalize(str);

        assertEquals("A", result);
    }

    @Test
    public void testCapitalize_MixedCaseString_ReturnsCapitalizedString() {
        String str = "cAt";

        String result = StringUtils.capitalize(str);

        assertEquals("CAt", result);
    }

    @Test
    public void testCapitalize_StringWithSpecialCharacters_ReturnsSameString() {
        String str = "'cat'";

        String result = StringUtils.capitalize(str);

        assertEquals("'cat'", result);
    }





    @Test
    public void testGetIfEmpty_NullInput_ReturnsDefault() {
        Supplier<String> defaultSupplier = mock(Supplier.class);
        when(defaultSupplier.get()).thenReturn("DEFAULT");

        String result = StringUtils.getIfEmpty(null, defaultSupplier);

        verify(defaultSupplier).get();
        assertEquals("DEFAULT", result);
    }

    @Test
    public void testGetIfEmpty_EmptyInput_ReturnsDefault() {
        Supplier<String> defaultSupplier = mock(Supplier.class);
        when(defaultSupplier.get()).thenReturn("DEFAULT");

        String result = StringUtils.getIfEmpty("", defaultSupplier);

        verify(defaultSupplier).get();
        assertEquals("DEFAULT", result);
    }

    @Test
    public void testGetIfEmpty_SpaceInput_ReturnsInput() {
        Supplier<String> defaultSupplier = mock(Supplier.class);
        when(defaultSupplier.get()).thenReturn("DEFAULT");

        String result = StringUtils.getIfEmpty(" ", defaultSupplier);

        verify(defaultSupplier, never()).get();
        assertEquals(" ", result);
    }

//    @Test
//    public void testGetIfEmpty_NonEmptyInput_ReturnsInput() {
//        Supplier<String> defaultSupplier = mock(Supplier.class);
//        when(defaultSupplier.get()).thenReturn("DEFAULT");
//
//        String result = StringUtils.getIfEmpty("bat", defaultSupplier);
//
//        verify(defaultSupplier, never()).get();
//        assertEquals("bat", result);
//    }

    @Test
    public void testGetIfEmpty_EmptyInputAndNullSupplier_ReturnsNull() {
        String result = StringUtils.getIfEmpty("", null);

        assertNull(result);
    }

    @Test
    public void testGetIfEmpty_NullInputAndNullSupplier_ReturnsNull() {
        String result = StringUtils.getIfEmpty(null, null);

        assertNull(result);
    }





    @Test
    public void testIsAlpha_NullInput_ReturnFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = null;

        // Write the test code here following the given rules
        assertFalse(StringUtils.isAlpha(cs));
    }

    @Test
    public void testIsAlpha_EmptyString_ReturnFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "";

        // Write the test code here following the given rules
        assertFalse(StringUtils.isAlpha(cs));
    }

    @Test
    public void testIsAlpha_WhitespaceString_ReturnFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "  ";

        // Write the test code here following the given rules
        assertFalse(StringUtils.isAlpha(cs));
    }

    @Test
    public void testIsAlpha_AllLetters_ReturnTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = "abc";

        // Write the test code here following the given rules
        assertTrue(StringUtils.isAlpha(cs));
    }

    @Test
    public void testIsAlpha_ContainsDigit_ReturnFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "ab2c";

        // Write the test code here following the given rules
        assertFalse(StringUtils.isAlpha(cs));
    }

    @Test
    public void testIsAlpha_ContainsSpecialCharacter_ReturnFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "ab-c";

        // Write the test code here following the given rules
        assertFalse(StringUtils.isAlpha(cs));
    }

    @Test
    public void testIsAlpha_MixedCaseLetters_ReturnTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = "AbC";

        // Write the test code here following the given rules
        assertTrue(StringUtils.isAlpha(cs));
    }

//    @Test
//    public void testIsAlpha_MockedCharacterIsLetter_ReturnTrue() {
//        // Instantiate all necessary variables here
//        CharSequence cs = "abc";
//        MockedStatic<Character> characterMockedStatic = mockStatic(Character.class);
//
//        // Write the test code here following the given rules
//        characterMockedStatic.when(() -> Character.isLetter(anyChar())).thenReturn(true);
//        assertTrue(StringUtils.isAlpha(cs));
//
//        characterMockedStatic.close();
//    }













//    @Test
//    public void testToEncodedString() {
//        // Instantiate all necessary variables here
//        byte[] bytes = {97, 98, 99}; // "abc" in ASCII encoding
//        Charset charset = Charset.forName("UTF-8");
//
//        // Mock the dependency
//        Charset mockCharset = mock(Charset.class);
//        when(Charset.forName("UTF-8")).thenReturn(mockCharset);
//
//        // Stub the method of the dependency
//        when(mockCharset.encode(anyString())).thenReturn(bytes);
//
//        // Write the test code here following the given rules
//        String result = StringUtils.toEncodedString(bytes, charset);
//
//        // Verify the method calls and assertions
//        verify(Charset).forName("UTF-8");
//        verify(mockCharset).encode(anyString());
//        assertEquals("abc", result);
//    }





    @Test
    public void containsIgnoreCase_WhenNullInput_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence str = null;
        CharSequence searchStr = null;

        // Write the test code here following the given rules
        boolean result = StringUtils.containsIgnoreCase(str, searchStr);

        assertFalse(result);
    }

    @Test
    public void containsIgnoreCase_WhenEmptyInput_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence str = "";
        CharSequence searchStr = "";

        // Write the test code here following the given rules
        boolean result = StringUtils.containsIgnoreCase(str, searchStr);

        assertTrue(result);
    }

    @Test
    public void containsIgnoreCase_WhenSearchStringEmpty_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence str = "abc";
        CharSequence searchStr = "";

        // Write the test code here following the given rules
        boolean result = StringUtils.containsIgnoreCase(str, searchStr);

        assertTrue(result);
    }

    @Test
    public void containsIgnoreCase_WhenSearchStringFound_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence str = "abc";
        CharSequence searchStr = "a";

        // Write the test code here following the given rules
        boolean result = StringUtils.containsIgnoreCase(str, searchStr);

        assertTrue(result);
    }

    @Test
    public void containsIgnoreCase_WhenSearchStringNotFound_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence str = "abc";
        CharSequence searchStr = "z";

        // Write the test code here following the given rules
        boolean result = StringUtils.containsIgnoreCase(str, searchStr);

        assertFalse(result);
    }

    @Test
    public void containsIgnoreCase_WhenSearchStringCaseInsensitiveMatch_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence str = "abc";
        CharSequence searchStr = "A";

        // Write the test code here following the given rules
        boolean result = StringUtils.containsIgnoreCase(str, searchStr);

        assertTrue(result);
    }

    @Test
    public void containsIgnoreCase_WhenSearchStringCaseInsensitiveNoMatch_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence str = "abc";
        CharSequence searchStr = "Z";

        // Write the test code here following the given rules
        boolean result = StringUtils.containsIgnoreCase(str, searchStr);

        assertFalse(result);
    }









    @Test
    public void testEqualsIgnoreCase_BothNull_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs1 = null;
        CharSequence cs2 = null;

        // Write the test code here following the given rules
        boolean result = StringUtils.equalsIgnoreCase(cs1, cs2);

        assertTrue(result);
    }

    @Test
    public void testEqualsIgnoreCase_OneNull_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs1 = "abc";
        CharSequence cs2 = null;

        // Write the test code here following the given rules
        boolean result = StringUtils.equalsIgnoreCase(cs1, cs2);

        assertFalse(result);
    }

    @Test
    public void testEqualsIgnoreCase_SameLengthDifferentCase_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs1 = "abc";
        CharSequence cs2 = "ABC";

        // Write the test code here following the given rules
        boolean result = StringUtils.equalsIgnoreCase(cs1, cs2);

        assertTrue(result);
    }

    @Test
    public void testEqualsIgnoreCase_DifferentLength_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs1 = "abc";
        CharSequence cs2 = "abcd";

        // Write the test code here following the given rules
        boolean result = StringUtils.equalsIgnoreCase(cs1, cs2);

        assertFalse(result);
    }

    @Test
    public void testEqualsIgnoreCase_SameLengthSameCase_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs1 = "abc";
        CharSequence cs2 = "abc";

        // Write the test code here following the given rules
        boolean result = StringUtils.equalsIgnoreCase(cs1, cs2);

        assertTrue(result);
    }













    @Test
    public void ExampleTest1() {
        // Instantiate all necessary variables here
        CharSequence cs = "aBc";

        // Write the test code here following the given rules
        boolean result = StringUtils.isMixedCase(cs);

        assertTrue(result);
    }
    
    @Test
    public void testEmptyString() {
        // Instantiate all necessary variables here
        CharSequence cs = "";

        // Write the test code here following the given rules
        boolean result = StringUtils.isMixedCase(cs);

        assertFalse(result);
    }
    
    @Test
    public void testNullString() {
        // Instantiate all necessary variables here
        CharSequence cs = null;

        // Write the test code here following the given rules
        boolean result = StringUtils.isMixedCase(cs);

        assertFalse(result);
    }
    
    @Test
    public void testSingleCharacterString() {
        // Instantiate all necessary variables here
        CharSequence cs = "A";

        // Write the test code here following the given rules
        boolean result = StringUtils.isMixedCase(cs);

        assertFalse(result);
    }
    
    @Test
    public void testUpperCaseString() {
        // Instantiate all necessary variables here
        CharSequence cs = "ABC";

        // Write the test code here following the given rules
        boolean result = StringUtils.isMixedCase(cs);

        assertFalse(result);
    }
    
    @Test
    public void testLowerCaseString() {
        // Instantiate all necessary variables here
        CharSequence cs = "abc";

        // Write the test code here following the given rules
        boolean result = StringUtils.isMixedCase(cs);

        assertFalse(result);
    }
    
    @Test
    public void testMixedCaseString() {
        // Instantiate all necessary variables here
        CharSequence cs = "A c";

        // Write the test code here following the given rules
        boolean result = StringUtils.isMixedCase(cs);

        assertTrue(result);
    }
    
    @Test
    public void testMixedCaseStringWithSpecialCharacters() {
        // Instantiate all necessary variables here
        CharSequence cs = "a/C";

        // Write the test code here following the given rules
        boolean result = StringUtils.isMixedCase(cs);

        assertTrue(result);
    }
    
    @Test
    public void testMixedCaseStringWithWhitespace() {
        // Instantiate all necessary variables here
        CharSequence cs = "aC\t";

        // Write the test code here following the given rules
        boolean result = StringUtils.isMixedCase(cs);

        assertTrue(result);
    }















    @Test
    public void abbreviate_NullString_ReturnsNull() {
        // Instantiate all necessary variables here
        String str = null;
        int maxWidth = 5;
        
        // Write the test code here following the given rules
        String result = StringUtils.abbreviate(str, maxWidth);
        
        assertNull(result);
    }
    
    @Test
    public void abbreviate_EmptyString_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        String str = "";
        int maxWidth = 5;
        
        // Write the test code here following the given rules
        String result = StringUtils.abbreviate(str, maxWidth);
        
        assertEquals("", result);
    }
    
    @Test
    public void abbreviate_StringLessThanOrEqualToMaxWidth_ReturnsSameString() {
        // Instantiate all necessary variables here
        String str = "abcdefg";
        int maxWidth = 7;
        
        // Write the test code here following the given rules
        String result = StringUtils.abbreviate(str, maxWidth);
        
        assertEquals("abcdefg", result);
    }
    
    @Test
    public void abbreviate_StringGreaterThanMaxWidth_ReturnsAbbreviatedString() {
        // Instantiate all necessary variables here
        String str = "abcdefg";
        int maxWidth = 6;
        
        // Write the test code here following the given rules
        String result = StringUtils.abbreviate(str, maxWidth);
        
        assertEquals("abc...", result);
    }
    
    @Test
    public void abbreviate_MaxWidthLessThan4_ThrowsIllegalArgumentException() {
        // Instantiate all necessary variables here
        String str = "abcdefg";
        int maxWidth = 3;
        
        // Write the test code here following the given rules
        assertThrows(IllegalArgumentException.class, () -> StringUtils.abbreviate(str, maxWidth));
    }
    
    @Test
    public void abbreviate_NullAbbrevMarker_ReturnsSameString() {
        // Instantiate all necessary variables here
        String str = "abcdefg";
        String abbrevMarker = null;
        int maxWidth = 7;
        
        // Write the test code here following the given rules
        String result = StringUtils.abbreviate(str, abbrevMarker, maxWidth);
        
        assertEquals("abcdefg", result);
    }
    
//    @Test
//    public void abbreviate_EmptyAbbrevMarker_ReturnsAbbreviatedString() {
//        // Instantiate all necessary variables here
//        String str = "abcdefg";
//        String abbrevMarker = "";
//        int maxWidth = 7;
//
//        // Write the test code here following the given rules
//        String result = StringUtils.abbreviate(str, abbrevMarker, maxWidth);
//
//        assertEquals("abc...", result);
//    }
    
//    @Test
//    public void abbreviate_OffsetLessThanMaxWidth_ReturnsAbbreviatedStringWithOffset() {
//        // Instantiate all necessary variables here
//        String str = "abcdefghijklmno";
//        int offset = 3;
//        int maxWidth = 10;
//
//        // Write the test code here following the given rules
//        String result = StringUtils.abbreviate(str, offset, maxWidth);
//
//        assertEquals("abc...", result);
//    }
//
//    @Test
//    public void abbreviate_OffsetGreaterThanMaxWidth_ReturnsAbbreviatedStringWithoutOffset() {
//        // Instantiate all necessary variables here
//        String str = "abcdefghijklmno";
//        int offset = 10;
//        int maxWidth = 10;
//
//        // Write the test code here following the given rules
//        String result = StringUtils.abbreviate(str, offset, maxWidth);
//
//        assertEquals("...klmno", result);
//    }
    
    @Test
    public void abbreviate_MaxWidthLessThanAbbrevMarkerLengthPlusOne_ThrowsIllegalArgumentException() {
        // Instantiate all necessary variables here
        String str = "abcdefg";
        String abbrevMarker = "..";
        int maxWidth = 2;
        
        // Write the test code here following the given rules
        assertThrows(IllegalArgumentException.class, () -> StringUtils.abbreviate(str, abbrevMarker, maxWidth));
    }





    @Test
    public void testIsAllEmpty_WithNull_ShouldReturnTrue() {
        // Instantiate all necessary variables here
        CharSequence[] css = null;

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllEmpty(css);

        assertTrue(result);
    }

    @Test
    public void testIsAllEmpty_WithEmptyString_ShouldReturnTrue() {
        // Instantiate all necessary variables here
        CharSequence[] css = new CharSequence[] { "" };

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllEmpty(css);

        assertTrue(result);
    }

    @Test
    public void testIsAllEmpty_WithEmptyArray_ShouldReturnTrue() {
        // Instantiate all necessary variables here
        CharSequence[] css = new CharSequence[] {};

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllEmpty(css);

        assertTrue(result);
    }

    @Test
    public void testIsAllEmpty_WithNonNullNonEmptyString_ShouldReturnFalse() {
        // Instantiate all necessary variables here
        CharSequence[] css = new CharSequence[] { "foo" };

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllEmpty(css);

        assertFalse(result);
    }

    @Test
    public void testIsAllEmpty_WithEmptyAndNonEmptyString_ShouldReturnFalse() {
        // Instantiate all necessary variables here
        CharSequence[] css = new CharSequence[] { "", "bar" };

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllEmpty(css);

        assertFalse(result);
    }

    @Test
    public void testIsAllEmpty_WithWhitespaceString_ShouldReturnFalse() {
        // Instantiate all necessary variables here
        CharSequence[] css = new CharSequence[] { "  bob  " };

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllEmpty(css);

        assertFalse(result);
    }

    @Test
    public void testIsAllEmpty_WithWhitespaceAndNonEmptyString_ShouldReturnFalse() {
        // Instantiate all necessary variables here
        CharSequence[] css = new CharSequence[] { " ", "bar" };

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllEmpty(css);

        assertFalse(result);
    }

    @Test
    public void testIsAllEmpty_WithNonEmptyStrings_ShouldReturnFalse() {
        // Instantiate all necessary variables here
        CharSequence[] css = new CharSequence[] { "foo", "bar" };

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllEmpty(css);

        assertFalse(result);
    }








    @Test
    public void testRemoveStartIgnoreCase_nullSourceString() {
        // Arrange
        String str = null;
        String remove = "remove";

        // Act
        String result = StringUtils.removeStartIgnoreCase(str, remove);

        // Assert
        assertNull(result);
    }

    @Test
    public void testRemoveStartIgnoreCase_emptySourceString() {
        // Arrange
        String str = "";
        String remove = "remove";

        // Act
        String result = StringUtils.removeStartIgnoreCase(str, remove);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testRemoveStartIgnoreCase_nullRemoveString() {
        // Arrange
        String str = "source";
        String remove = null;

        // Act
        String result = StringUtils.removeStartIgnoreCase(str, remove);

        // Assert
        assertEquals("source", result);
    }

    @Test
    public void testRemoveStartIgnoreCase_removeStringNotFound() {
        // Arrange
        String str = "source";
        String remove = "remove";

        // Act
        String result = StringUtils.removeStartIgnoreCase(str, remove);

        // Assert
        assertEquals("source", result);
    }

    @Test
    public void testRemoveStartIgnoreCase_caseInsensitiveMatch() {
        // Arrange
        String str = "source";
        String remove = "So";

        // Act
        String result = StringUtils.removeStartIgnoreCase(str, remove);

        // Assert
        assertEquals("urce", result);
    }

    @Test
    public void testRemoveStartIgnoreCase_caseInsensitiveMatchWithDifferentCase() {
        // Arrange
        String str = "source";
        String remove = "SO";

        // Act
        String result = StringUtils.removeStartIgnoreCase(str, remove);

        // Assert
        assertEquals("urce", result);
    }

    @Test
    public void testRemoveStartIgnoreCase_removeStringEmpty() {
        // Arrange
        String str = "source";
        String remove = "";

        // Act
        String result = StringUtils.removeStartIgnoreCase(str, remove);

        // Assert
        assertEquals("source", result);
    }

    @Test
    public void testRemoveStartIgnoreCase_removeStringLongerThanSourceString() {
        // Arrange
        String str = "source";
        String remove = "source123";

        // Act
        String result = StringUtils.removeStartIgnoreCase(str, remove);

        // Assert
        assertEquals("source", result);
    }





    @Test
    public void testIsNoneEmpty() {
        // Test when no CharSequences are provided
        assertTrue(StringUtils.isNoneEmpty());

        // Test when one empty CharSequence is provided
        assertFalse(StringUtils.isNoneEmpty(""));

        // Test when multiple empty CharSequences are provided
        assertFalse(StringUtils.isNoneEmpty("", "", ""));

        // Test when one non-empty CharSequence is provided
        assertTrue(StringUtils.isNoneEmpty("foo"));

        // Test when multiple non-empty CharSequences are provided
        assertTrue(StringUtils.isNoneEmpty("foo", "bar"));

        // Test when a mix of empty and non-empty CharSequences are provided
        assertFalse(StringUtils.isNoneEmpty("", "foo", ""));

        // Test when a mix of whitespace and non-empty CharSequences are provided
        assertTrue(StringUtils.isNoneEmpty(" ", "foo", " "));

        // Test when null CharSequences are provided
        assertFalse(StringUtils.isNoneEmpty((CharSequence) null));

        // Test when an array of null CharSequences is provided
        assertTrue(StringUtils.isNoneEmpty((CharSequence[]) null));

        // Test when an array of empty CharSequences is provided
        assertTrue(StringUtils.isNoneEmpty(new CharSequence[] {}));

        // Test when an array of non-empty CharSequences is provided
        assertTrue(StringUtils.isNoneEmpty(new CharSequence[] {"foo", "bar"}));

        // Test when an array of mixed empty and non-empty CharSequences is provided
        assertFalse(StringUtils.isNoneEmpty(new CharSequence[] {"", "foo", ""}));
    }





    @Test
    public void testDeleteWhitespace_NullString_ReturnsNull() {
        // Instantiate all necessary variables here
        String str = null;

        // Write the test code here following the given rules
        String result = StringUtils.deleteWhitespace(str);

        assertNull(result);
    }

    @Test
    public void testDeleteWhitespace_EmptyString_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        String str = "";

        // Write the test code here following the given rules
        String result = StringUtils.deleteWhitespace(str);

        assertEquals("", result);
    }

    @Test
    public void testDeleteWhitespace_NoWhitespace_ReturnsSameString() {
        // Instantiate all necessary variables here
        String str = "abc";

        // Write the test code here following the given rules
        String result = StringUtils.deleteWhitespace(str);

        assertEquals("abc", result);
    }

    @Test
    public void testDeleteWhitespace_WithWhitespace_ReturnsStringWithoutWhitespace() {
        // Instantiate all necessary variables here
        String str = "   ab  c  ";

        // Write the test code here following the given rules
        String result = StringUtils.deleteWhitespace(str);

        assertEquals("abc", result);
    }

    @Test
    public void testDeleteWhitespace_WithOnlyWhitespace_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        String str = "      ";

        // Write the test code here following the given rules
        String result = StringUtils.deleteWhitespace(str);

        assertEquals("", result);
    }





















    @Test
    public void testSplitByCharacterTypeCamelCase_NullString_ReturnsNull() {
        // Arrange
        String str = null;

        // Act
        String[] result = StringUtils.splitByCharacterTypeCamelCase(str);

        // Assert
        assertNull(result);
    }

    @Test
    public void testSplitByCharacterTypeCamelCase_EmptyString_ReturnsEmptyArray() {
        // Arrange
        String str = "";

        // Act
        String[] result = StringUtils.splitByCharacterTypeCamelCase(str);

        // Assert
        assertNotNull(result);
        assertEquals(0, result.length);
    }

    @Test
    public void testSplitByCharacterTypeCamelCase_WhitespaceString_ReturnsArrayWithWhitespace() {
        // Arrange
        String str = "  ";

        // Act
        String[] result = StringUtils.splitByCharacterTypeCamelCase(str);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.length);
        assertEquals("  ", result[0]);
    }

    @Test
    public void testSplitByCharacterTypeCamelCase_SingleWordString_ReturnsArrayWithSingleWord() {
        // Arrange
        String str = "hello";

        // Act
        String[] result = StringUtils.splitByCharacterTypeCamelCase(str);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.length);
        assertEquals("hello", result[0]);
    }

    @Test
    public void testSplitByCharacterTypeCamelCase_MultipleWordsString_ReturnsArrayWithWordsSeparatedBySpaces() {
        // Arrange
        String str = "helloWorld";

        // Act
        String[] result = StringUtils.splitByCharacterTypeCamelCase(str);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals("hello", result[0]);
        assertEquals("World", result[1]);
    }

    @Test
    public void testSplitByCharacterTypeCamelCase_StringWithNumbers_ReturnsArrayWithWordsAndNumbersSeparatedBySpaces() {
        // Arrange
        String str = "hello123World45";

        // Act
        String[] result = StringUtils.splitByCharacterTypeCamelCase(str);

        // Assert
        assertNotNull(result);
        assertEquals(4, result.length);
        assertEquals("hello", result[0]);
        assertEquals("123", result[1]);
        assertEquals("World", result[2]);
        assertEquals("45", result[3]);
    }

    @Test
    public void testSplitByCharacterTypeCamelCase_StringWithSpecialCharacters_ReturnsArrayWithWordsAndSpecialCharactersSeparatedBySpaces() {
        // Arrange
        String str = "hello$World!";

        // Act
        String[] result = StringUtils.splitByCharacterTypeCamelCase(str);

        // Assert
        assertNotNull(result);
        assertEquals(4, result.length);
        assertEquals("hello", result[0]);
        assertEquals("$", result[1]);
        assertEquals("World", result[2]);
        assertEquals("!", result[3]);
    }

    @Test
    public void testSplitByCharacterTypeCamelCase_StringWithMixedCase_ReturnsArrayWithWordsSeparatedBySpaces() {
        // Arrange
        String str = "HelloWorld";

        // Act
        String[] result = StringUtils.splitByCharacterTypeCamelCase(str);

        // Assert
        assertNotNull(result);
        assertEquals(2, result.length);
        assertEquals("Hello", result[0]);
        assertEquals("World", result[1]);
    }

    @Test
    public void testSplitByCharacterTypeCamelCase_StringWithConsecutiveUppercaseCharacters_ReturnsArrayWithWordsSeparatedBySpaces() {
        // Arrange
        String str = "ABCD";

        // Act
        String[] result = StringUtils.splitByCharacterTypeCamelCase(str);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.length);
        assertEquals("ABCD", result[0]);
    }







    @Test
    public void isAlphanumeric_NullInput_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = null;

        // Write the test code here following the given rules
        boolean result = StringUtils.isAlphanumeric(cs);

        // Assert the result
        assertFalse(result);
    }

    @Test
    public void isAlphanumeric_EmptyString_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "";

        // Write the test code here following the given rules
        boolean result = StringUtils.isAlphanumeric(cs);

        // Assert the result
        assertFalse(result);
    }

    @Test
    public void isAlphanumeric_WhitespaceString_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "  ";

        // Write the test code here following the given rules
        boolean result = StringUtils.isAlphanumeric(cs);

        // Assert the result
        assertFalse(result);
    }

    @Test
    public void isAlphanumeric_OnlyLetters_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = "abc";

        // Write the test code here following the given rules
        boolean result = StringUtils.isAlphanumeric(cs);

        // Assert the result
        assertTrue(result);
    }

    @Test
    public void isAlphanumeric_LettersAndDigits_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = "ab2c";

        // Write the test code here following the given rules
        boolean result = StringUtils.isAlphanumeric(cs);

        // Assert the result
        assertTrue(result);
    }

    @Test
    public void isAlphanumeric_LettersAndNonAlphanumeric_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "ab-c";

        // Write the test code here following the given rules
        boolean result = StringUtils.isAlphanumeric(cs);

        // Assert the result
        assertFalse(result);
    }









    @Test
    public void testEndsWithIgnoreCase_NullStrAndNullSuffix_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence str = null;
        CharSequence suffix = null;

        // Write the test code here following the given rules
        boolean result = StringUtils.endsWithIgnoreCase(str, suffix);

        assertTrue(result);
    }

    @Test
    public void testEndsWithIgnoreCase_NullStrAndNonNullSuffix_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence str = null;
        CharSequence suffix = "def";

        // Write the test code here following the given rules
        boolean result = StringUtils.endsWithIgnoreCase(str, suffix);

        assertFalse(result);
    }

    @Test
    public void testEndsWithIgnoreCase_NonNullStrAndNullSuffix_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence str = "abcdef";
        CharSequence suffix = null;

        // Write the test code here following the given rules
        boolean result = StringUtils.endsWithIgnoreCase(str, suffix);

        assertFalse(result);
    }

    @Test
    public void testEndsWithIgnoreCase_StrEndsWithSuffix_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence str = "abcdef";
        CharSequence suffix = "def";

        // Write the test code here following the given rules
        boolean result = StringUtils.endsWithIgnoreCase(str, suffix);

        assertTrue(result);
    }

    @Test
    public void testEndsWithIgnoreCase_StrEndsWithSuffixIgnoreCase_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence str = "ABCDEF";
        CharSequence suffix = "def";

        // Write the test code here following the given rules
        boolean result = StringUtils.endsWithIgnoreCase(str, suffix);

        assertTrue(result);
    }

    @Test
    public void testEndsWithIgnoreCase_StrDoesNotEndWithSuffix_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence str = "ABCDEF";
        CharSequence suffix = "cde";

        // Write the test code here following the given rules
        boolean result = StringUtils.endsWithIgnoreCase(str, suffix);

        assertFalse(result);
    }





//    @Test
//    public void testReplaceFirst() {
//        // Instantiate all necessary variables here
//        String text = "Lorem ipsum dolor sit amet";
//        String regex = "ipsum";
//        String replacement = "replacement";
//
//        // Mock the RegExUtils class
//        RegExUtils regExUtilsMock = mock(RegExUtils.class);
//
//        // Mock the replaceFirst method of RegExUtils
//        when(regExUtilsMock.replaceFirst(text, regex, replacement)).thenReturn("Lorem replacement dolor sit amet");
//
//        // Test the replaceFirst method of StringUtils
//        String result = StringUtils.replaceFirst(text, regex, replacement);
//
//        // Verify the method calls
//        verify(regExUtilsMock).replaceFirst(text, regex, replacement);
//
//        // Assert the result
//        assertEquals("Lorem replacement dolor sit amet", result);
//    }







    @Test
    public void testSubstringBeforeLast() {
        // Instantiate all necessary variables here
        String str = "abcba";
        String separator = "b";
        
        // Mock any dependencies here (if any)
        
        // Write the test code here following the given rules
        String result = StringUtils.substringBeforeLast(str, separator);
        
        assertEquals("abc", result);
    }





    @Test
    public void testGetFuzzyDistance_NullTermAndQuery_ThrowsIllegalArgumentException() {
        // Arrange
        CharSequence term = null;
        CharSequence query = null;
        Locale locale = Locale.ENGLISH;

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> StringUtils.getFuzzyDistance(term, query, locale));
    }

    @Test
    public void testGetFuzzyDistance_NullTerm_ThrowsIllegalArgumentException() {
        // Arrange
        CharSequence term = null;
        CharSequence query = "query";
        Locale locale = Locale.ENGLISH;

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> StringUtils.getFuzzyDistance(term, query, locale));
    }

    @Test
    public void testGetFuzzyDistance_NullQuery_ThrowsIllegalArgumentException() {
        // Arrange
        CharSequence term = "term";
        CharSequence query = null;
        Locale locale = Locale.ENGLISH;

        // Act and Assert
        assertThrows(IllegalArgumentException.class, () -> StringUtils.getFuzzyDistance(term, query, locale));
    }

    @Test
    public void testGetFuzzyDistance_EmptyTermAndQuery_ReturnsZero() {
        // Arrange
        CharSequence term = "";
        CharSequence query = "";
        Locale locale = Locale.ENGLISH;

        // Act
        int distance = StringUtils.getFuzzyDistance(term, query, locale);

        // Assert
        assertEquals(0, distance);
    }

    @Test
    public void testGetFuzzyDistance_TermNotContainingQuery_ReturnsZero() {
        // Arrange
        CharSequence term = "Workshop";
        CharSequence query = "b";
        Locale locale = Locale.ENGLISH;

        // Act
        int distance = StringUtils.getFuzzyDistance(term, query, locale);

        // Assert
        assertEquals(0, distance);
    }

    @Test
    public void testGetFuzzyDistance_TermContainingQueryOnce_ReturnsOne() {
        // Arrange
        CharSequence term = "Room";
        CharSequence query = "o";
        Locale locale = Locale.ENGLISH;

        // Act
        int distance = StringUtils.getFuzzyDistance(term, query, locale);

        // Assert
        assertEquals(1, distance);
    }

    @Test
    public void testGetFuzzyDistance_TermContainingQueryOnce_ReturnsTwo() {
        // Arrange
        CharSequence term = "Workshop";
        CharSequence query = "w";
        Locale locale = Locale.ENGLISH;

        // Act
        int distance = StringUtils.getFuzzyDistance(term, query, locale);

        // Assert
        assertEquals(1, distance);
    }

    @Test
    public void testGetFuzzyDistance_TermContainingQueryTwice_ReturnsTwo() {
        // Arrange
        CharSequence term = "Workshop";
        CharSequence query = "ws";
        Locale locale = Locale.ENGLISH;

        // Act
        int distance = StringUtils.getFuzzyDistance(term, query, locale);

        // Assert
        assertEquals(2, distance);
    }

    @Test
    public void testGetFuzzyDistance_TermContainingQueryTwice_ReturnsFour() {
        // Arrange
        CharSequence term = "Workshop";
        CharSequence query = "wo";
        Locale locale = Locale.ENGLISH;

        // Act
        int distance = StringUtils.getFuzzyDistance(term, query, locale);

        // Assert
        assertEquals(4, distance);
    }

    @Test
    public void testGetFuzzyDistance_TermContainingQuery_ReturnsThree() {
        // Arrange
        CharSequence term = "Apache Software Foundation";
        CharSequence query = "asf";
        Locale locale = Locale.ENGLISH;

        // Act
        int distance = StringUtils.getFuzzyDistance(term, query, locale);

        // Assert
        assertEquals(3, distance);
    }









    @Test
    public void testRemoveEnd_NullSourceString_ShouldReturnNull() {
        // Arrange
        String str = null;
        String remove = "remove";

        // Act
        String result = StringUtils.removeEnd(str, remove);

        // Assert
        assertNull(result);
    }

    @Test
    public void testRemoveEnd_EmptySourceString_ShouldReturnEmptyString() {
        // Arrange
        String str = "";
        String remove = "remove";

        // Act
        String result = StringUtils.removeEnd(str, remove);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testRemoveEnd_NullRemoveString_ShouldReturnSourceString() {
        // Arrange
        String str = "source";
        String remove = null;

        // Act
        String result = StringUtils.removeEnd(str, remove);

        // Assert
        assertEquals("source", result);
    }

    @Test
    public void testRemoveEnd_RemoveStringNotFound_ShouldReturnSourceString() {
        // Arrange
        String str = "source";
        String remove = "remove";

        // Act
        String result = StringUtils.removeEnd(str, remove);

        // Assert
        assertEquals("source", result);
    }

    @Test
    public void testRemoveEnd_RemoveStringAtEndOfString_ShouldReturnSubstringWithoutRemoveString() {
        // Arrange
        String str = "www.domain.com";
        String remove = ".com";

        // Act
        String result = StringUtils.removeEnd(str, remove);

        // Assert
        assertEquals("www.domain", result);
    }

    @Test
    public void testRemoveEnd_RemoveStringNotAtEndOfString_ShouldReturnSourceString() {
        // Arrange
        String str = "www.domain.com";
        String remove = "domain";

        // Act
        String result = StringUtils.removeEnd(str, remove);

        // Assert
        assertEquals("www.domain.com", result);
    }

    @Test
    public void testRemoveEnd_EmptyRemoveString_ShouldReturnSourceString() {
        // Arrange
        String str = "abc";
        String remove = "";

        // Act
        String result = StringUtils.removeEnd(str, remove);

        // Assert
        assertEquals("abc", result);
    }









    @Test
    public void repeat_CharacterInput_ReturnsRepeatedString() {
        char ch = 'a';
        int repeat = 3;
        String expected = "aaa";

        String result = StringUtils.repeat(ch, repeat);

        assertEquals(expected, result);
    }

    @Test
    public void repeat_CharacterInputWithNegativeRepeat_ReturnsEmptyString() {
        char ch = 'a';
        int repeat = -2;
        String expected = "";

        String result = StringUtils.repeat(ch, repeat);

        assertEquals(expected, result);
    }

    @Test
    public void repeat_StringInput_ReturnsRepeatedString() {
        String str = "abc";
        int repeat = 2;
        String expected = "abcabc";

        String result = StringUtils.repeat(str, repeat);

        assertEquals(expected, result);
    }

    @Test
    public void repeat_StringInputWithNegativeRepeat_ReturnsEmptyString() {
        String str = "abc";
        int repeat = -2;
        String expected = "";

        String result = StringUtils.repeat(str, repeat);

        assertEquals(expected, result);
    }

    @Test
    public void repeat_StringAndSeparator_ReturnsRepeatedStringWithSeparator() {
        String str = "abc";
        String separator = ",";
        int repeat = 3;
        String expected = "abc,abc,abc";

        String result = StringUtils.repeat(str, separator, repeat);

        assertEquals(expected, result);
    }

    @Test
    public void repeat_StringAndNullSeparator_ReturnsRepeatedString() {
        String str = "abc";
        String separator = null;
        int repeat = 3;
        String expected = "abcabcabc";

        String result = StringUtils.repeat(str, separator, repeat);

        assertEquals(expected, result);
    }

    @Test
    public void repeat_NullString_ReturnsNull() {
        String str = null;
        int repeat = 2;

        String result = StringUtils.repeat(str, repeat);

        assertNull(result);
    }

    @Test
    public void repeat_NullStringAndSeparator_ReturnsNull() {
        String str = null;
        String separator = ",";
        int repeat = 3;

        String result = StringUtils.repeat(str, separator, repeat);

        assertNull(result);
    }





    @Test
    public void testGetBytesWithNullString() {
        // Instantiate all necessary variables here
        String string = null;
        Charset charset = Charset.defaultCharset();

        // Write the test code here following the given rules
        byte[] result = StringUtils.getBytes(string, charset);

        assertArrayEquals(ArrayUtils.EMPTY_BYTE_ARRAY, result);
    }

    @Test
    public void testGetBytesWithNonNullString() {
        // Instantiate all necessary variables here
        String string = "test";
        Charset charset = Charset.defaultCharset();

        // Write the test code here following the given rules
        byte[] expectedResult = string.getBytes(Charsets.toCharset(charset));
        byte[] result = StringUtils.getBytes(string, charset);

        assertArrayEquals(expectedResult, result);
    }

    @Test
    public void testGetBytesWithUnsupportedEncodingException() throws UnsupportedEncodingException {
        // Instantiate all necessary variables here
        String string = "test";
        String charsetName = "invalidCharset";

        // Write the test code here following the given rules
        assertThrows(UnsupportedEncodingException.class, () -> {
            StringUtils.getBytes(string, charsetName);
        });
    }





    @Test
    public void ExampleTest2() {
        // Instantiate all necessary variables here
        String source = "example";

        // Write the test code here following the given rules
        String expected = "EXAMPLE";
        String result = StringUtils.toRootUpperCase(source);
        assertEquals(expected, result);
    }
    
    @Test
    public void testToRootUpperCase_NullSource() {
        // Instantiate all necessary variables here
        String source = null;

        // Write the test code here following the given rules
        String result = StringUtils.toRootUpperCase(source);
        assertNull(result);
    }
    
    @Test
    public void testToRootUpperCase_EmptySource() {
        // Instantiate all necessary variables here
        String source = "";

        // Write the test code here following the given rules
        String expected = "";
        String result = StringUtils.toRootUpperCase(source);
        assertEquals(expected, result);
    }
    
    @Test
    public void testToRootUpperCase_LowercaseSource() {
        // Instantiate all necessary variables here
        String source = "lowercase";

        // Write the test code here following the given rules
        String expected = "LOWERCASE";
        String result = StringUtils.toRootUpperCase(source);
        assertEquals(expected, result);
    }
    
    @Test
    public void testToRootUpperCase_UppercaseSource() {
        // Instantiate all necessary variables here
        String source = "UPPERCASE";

        // Write the test code here following the given rules
        String expected = "UPPERCASE";
        String result = StringUtils.toRootUpperCase(source);
        assertEquals(expected, result);
    }
    
    @Test
    public void testToRootUpperCase_MixedCaseSource() {
        // Instantiate all necessary variables here
        String source = "MiXeDcAsE";

        // Write the test code here following the given rules
        String expected = "MIXEDCASE";
        String result = StringUtils.toRootUpperCase(source);
        assertEquals(expected, result);
    }





    @Test
    public void equalsAny_NullStringAndNullSearchStrings_ReturnsFalse() {
        CharSequence string = null;
        CharSequence[] searchStrings = null;

        boolean result = StringUtils.equalsAny(string, searchStrings);

        assertFalse(result);
    }

    @Test
    public void equalsAny_NullStringAndNullAndNullSearchStrings_ReturnsTrue() {
        CharSequence string = null;
        CharSequence[] searchStrings = { null, null };

        boolean result = StringUtils.equalsAny(string, searchStrings);

        assertTrue(result);
    }

    @Test
    public void equalsAny_NullStringAndNonNullSearchStrings_ReturnsFalse() {
        CharSequence string = null;
        CharSequence[] searchStrings = { "abc", "def" };

        boolean result = StringUtils.equalsAny(string, searchStrings);

        assertFalse(result);
    }

    @Test
    public void equalsAny_NonNullStringAndNullSearchStrings_ReturnsFalse() {
        CharSequence string = "abc";
        CharSequence[] searchStrings = null;

        boolean result = StringUtils.equalsAny(string, searchStrings);

        assertFalse(result);
    }

    @Test
    public void equalsAny_NonNullStringAndNonNullSearchStrings_ReturnsTrue() {
        CharSequence string = "abc";
        CharSequence[] searchStrings = { "abc", "def" };

        boolean result = StringUtils.equalsAny(string, searchStrings);

        assertTrue(result);
    }

    @Test
    public void equalsAny_NonNullStringAndNonNullSearchStringsCaseInsensitive_ReturnsFalse() {
        CharSequence string = "abc";
        CharSequence[] searchStrings = { "ABC", "DEF" };

        boolean result = StringUtils.equalsAny(string, searchStrings);

        assertFalse(result);
    }







    @Test
    public void toCodePoints_NullInput_ReturnNull() {
        // Instantiate all necessary variables here
        CharSequence cs = null;

        // Write the test code here following the given rules
        int[] result = StringUtils.toCodePoints(cs);

        assertNull(result);
    }
    
    @Test
    public void toCodePoints_EmptyInput_ReturnEmptyArray() {
        // Instantiate all necessary variables here
        CharSequence cs = "";

        // Write the test code here following the given rules
        int[] result = StringUtils.toCodePoints(cs);

        assertEquals(0, result.length);
    }
    
    @Test
    public void toCodePoints_SingleCharacterInput_ReturnCodePointArray() {
        // Instantiate all necessary variables here
        CharSequence cs = "A";

        // Write the test code here following the given rules
        int[] result = StringUtils.toCodePoints(cs);

        assertEquals(1, result.length);
        assertEquals((int) 'A', result[0]);
    }
    
    @Test
    public void toCodePoints_MultiCharacterInput_ReturnCodePointArray() {
        // Instantiate all necessary variables here
        CharSequence cs = "Hello";

        // Write the test code here following the given rules
        int[] result = StringUtils.toCodePoints(cs);

        assertEquals(5, result.length);
        assertEquals((int) 'H', result[0]);
        assertEquals((int) 'e', result[1]);
        assertEquals((int) 'l', result[2]);
        assertEquals((int) 'l', result[3]);
        assertEquals((int) 'o', result[4]);
    }
    
    @Test
    public void toCodePoints_SurrogatePairInput_ReturnCodePointArray() {
        // Instantiate all necessary variables here
        CharSequence cs = "\uD83D\uDE00"; // Grinning face emoji

        // Write the test code here following the given rules
        int[] result = StringUtils.toCodePoints(cs);

        assertEquals(1, result.length);
        assertEquals(0x1F600, result[0]);
    }





    @Test
    public void testRight_ReturnsNull_WhenStringIsNull() {
        // Arrange
        String str = null;
        int len = 5;

        // Act
        String result = StringUtils.right(str, len);

        // Assert
        assertNull(result);
    }

    @Test
    public void testRight_ReturnsEmptyString_WhenLengthIsNegative() {
        // Arrange
        String str = "abcdef";
        int len = -5;

        // Act
        String result = StringUtils.right(str, len);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testRight_ReturnsEmptyString_WhenStringIsEmpty() {
        // Arrange
        String str = "";
        int len = 5;

        // Act
        String result = StringUtils.right(str, len);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testRight_ReturnsEmptyString_WhenLengthIsZero() {
        // Arrange
        String str = "abcdef";
        int len = 0;

        // Act
        String result = StringUtils.right(str, len);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testRight_ReturnsRightmostCharacters_WhenLengthIsLessThanStringSize() {
        // Arrange
        String str = "abcdef";
        int len = 3;

        // Act
        String result = StringUtils.right(str, len);

        // Assert
        assertEquals("def", result);
    }

    @Test
    public void testRight_ReturnsString_WhenLengthIsEqualToStringSize() {
        // Arrange
        String str = "abcdef";
        int len = 6;

        // Act
        String result = StringUtils.right(str, len);

        // Assert
        assertEquals("abcdef", result);
    }

    @Test
    public void testRight_ReturnsString_WhenLengthIsGreaterThanStringSize() {
        // Arrange
        String str = "abcdef";
        int len = 8;

        // Act
        String result = StringUtils.right(str, len);

        // Assert
        assertEquals("abcdef", result);
    }





    @Test
    public void testIsAsciiPrintable_NullInput_ReturnsFalse() {
        // Arrange
        CharSequence cs = null;

        // Act
        boolean result = StringUtils.isAsciiPrintable(cs);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsAsciiPrintable_EmptyInput_ReturnsTrue() {
        // Arrange
        CharSequence cs = "";

        // Act
        boolean result = StringUtils.isAsciiPrintable(cs);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAsciiPrintable_OnlySpace_ReturnsTrue() {
        // Arrange
        CharSequence cs = " ";

        // Act
        boolean result = StringUtils.isAsciiPrintable(cs);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAsciiPrintable_OnlyPrintableCharacters_ReturnsTrue() {
        // Arrange
        CharSequence cs = "Ceki";

        // Act
        boolean result = StringUtils.isAsciiPrintable(cs);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAsciiPrintable_MixOfPrintableAndNonPrintableCharacters_ReturnsTrue() {
        // Arrange
        CharSequence cs = "ab2c";

        // Act
        boolean result = StringUtils.isAsciiPrintable(cs);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAsciiPrintable_SpecialCharacters_ReturnsTrue() {
        // Arrange
        CharSequence cs = "!ab-c~";

        // Act
        boolean result = StringUtils.isAsciiPrintable(cs);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAsciiPrintable_SpaceCharacter_ReturnsTrue() {
        // Arrange
        CharSequence cs = "\u0020";

        // Act
        boolean result = StringUtils.isAsciiPrintable(cs);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAsciiPrintable_ExclamationMark_ReturnsTrue() {
        // Arrange
        CharSequence cs = "\u0021";

        // Act
        boolean result = StringUtils.isAsciiPrintable(cs);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAsciiPrintable_Tilde_ReturnsTrue() {
        // Arrange
        CharSequence cs = "\u007e";

        // Act
        boolean result = StringUtils.isAsciiPrintable(cs);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAsciiPrintable_DeleteCharacter_ReturnsFalse() {
        // Arrange
        CharSequence cs = "\u007f";

        // Act
        boolean result = StringUtils.isAsciiPrintable(cs);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsAsciiPrintable_WithNonAsciiCharacters_ReturnsFalse() {
        // Arrange
        CharSequence cs = "Ceki G\u00fclc\u00fc";

        // Act
        boolean result = StringUtils.isAsciiPrintable(cs);

        // Assert
        assertFalse(result);
    }





    @Test
    public void testDefaultIfEmpty_NullString_ReturnsDefaultString() {
        // Instantiate all necessary variables here
        String str = null;
        String defaultStr = "default";

        // Write the test code here following the given rules
        String result = StringUtils.defaultIfEmpty(str, defaultStr);

        assertEquals(defaultStr, result);
    }

    @Test
    public void testDefaultIfEmpty_EmptyString_ReturnsDefaultString() {
        // Instantiate all necessary variables here
        String str = "";
        String defaultStr = "default";

        // Write the test code here following the given rules
        String result = StringUtils.defaultIfEmpty(str, defaultStr);

        assertEquals(defaultStr, result);
    }

    @Test
    public void testDefaultIfEmpty_WhitespaceString_ReturnsWhitespaceString() {
        // Instantiate all necessary variables here
        String str = " ";
        String defaultStr = "default";

        // Write the test code here following the given rules
        String result = StringUtils.defaultIfEmpty(str, defaultStr);

        assertEquals(str, result);
    }

    @Test
    public void testDefaultIfEmpty_NonEmptyString_ReturnsString() {
        // Instantiate all necessary variables here
        String str = "test";
        String defaultStr = "default";

        // Write the test code here following the given rules
        String result = StringUtils.defaultIfEmpty(str, defaultStr);

        assertEquals(str, result);
    }





    @Test
    public void ExampleTest3() {
        // Instantiate all necessary variables here
        String[] values = new String[] {null, null, ""};

        // Write the test code here following the given rules
        String result = StringUtils.firstNonEmpty(values);

        assertNull(result);
    }

    @Test
    public void TestAllNullValues() {
        String[] values = new String[] {null, null, null};

        String result = StringUtils.firstNonEmpty(values);

        assertNull(result);
    }

    @Test
    public void TestAllEmptyValues() {
        String[] values = new String[] {"", "", ""};

        String result = StringUtils.firstNonEmpty(values);

        assertNull(result);
    }

    @Test
    public void TestNullValuesWithNonEmptyValue() {
        String[] values = new String[] {null, null, "abc"};

        String result = StringUtils.firstNonEmpty(values);

        assertEquals("abc", result);
    }

    @Test
    public void TestEmptyValuesWithNonEmptyValue() {
        String[] values = new String[] {"", "", "xyz"};

        String result = StringUtils.firstNonEmpty(values);

        assertEquals("xyz", result);
    }

    @Test
    public void TestNullAndEmptyValuesWithNonEmptyValue() {
        String[] values = new String[] {null, "", "xyz", "abc"};

        String result = StringUtils.firstNonEmpty(values);

        assertEquals("xyz", result);
    }

    @Test
    public void TestNoValues() {
        String[] values = new String[] {};

        String result = StringUtils.firstNonEmpty(values);

        assertNull(result);
    }

    @Test
    public void TestNullValues() {
        String[] values = null;

        String result = StringUtils.firstNonEmpty(values);

        assertNull(result);
    }






    @Test
    public void testIsEmpty_NullString_ReturnsTrue() {
        // Arrange
        CharSequence cs = null;

        // Act
        boolean result = StringUtils.isEmpty(cs);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsEmpty_EmptyString_ReturnsTrue() {
        // Arrange
        CharSequence cs = "";

        // Act
        boolean result = StringUtils.isEmpty(cs);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsEmpty_WhiteSpaceString_ReturnsFalse() {
        // Arrange
        CharSequence cs = " ";

        // Act
        boolean result = StringUtils.isEmpty(cs);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsEmpty_NonEmptyString_ReturnsFalse() {
        // Arrange
        CharSequence cs = "bob";

        // Act
        boolean result = StringUtils.isEmpty(cs);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsEmpty_StringWithWhiteSpace_ReturnsFalse() {
        // Arrange
        CharSequence cs = "  bob  ";

        // Act
        boolean result = StringUtils.isEmpty(cs);

        // Assert
        assertFalse(result);
    }

























    @Test
    public void testEndsWith_NullStrings_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence str = null;
        CharSequence suffix = null;

        // Write the test code here following the given rules
        assertTrue(StringUtils.endsWith(str, suffix));
    }

    @Test
    public void testEndsWith_NullSuffix_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence str = "abcdef";
        CharSequence suffix = null;

        // Write the test code here following the given rules
        assertFalse(StringUtils.endsWith(str, suffix));
    }

    @Test
    public void testEndsWith_NullString_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence str = null;
        CharSequence suffix = "def";

        // Write the test code here following the given rules
        assertFalse(StringUtils.endsWith(str, suffix));
    }

//    @Test
//    public void testEndsWith_CaseSensitive_ReturnsTrue() {
//        // Instantiate all necessary variables here
//        CharSequence str = "ABCDEF";
//        CharSequence suffix = "def";
//
//        // Write the test code here following the given rules
//        assertTrue(StringUtils.endsWith(str, suffix));
//    }

    @Test
    public void testEndsWith_CaseInsensitive_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence str = "ABCDEF";
        CharSequence suffix = "cde";

        // Write the test code here following the given rules
        assertFalse(StringUtils.endsWith(str, suffix));
    }

    @Test
    public void testEndsWith_EmptySuffix_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence str = "ABCDEF";
        CharSequence suffix = "";

        // Write the test code here following the given rules
        assertTrue(StringUtils.endsWith(str, suffix));
    }

//    @Test
//    public void testEndsWith_MockitoExample() {
//        // Instantiate all necessary variables here
//        CharSequence str = "Hello World";
//        CharSequence suffix = "World";
//
//        // Mock StringUtils class
//        try (MockedStatic<StringUtils> mockedStatic = Mockito.mockStatic(StringUtils.class)) {
//            mockedStatic.when(() -> StringUtils.endsWith(str, suffix)).thenAnswer(new Answer<Boolean>() {
//                public Boolean answer(InvocationOnMock invocation) throws Throwable {
//                    CharSequence strArg = invocation.getArgument(0);
//                    CharSequence suffixArg = invocation.getArgument(1);
//                    return strArg != null && suffixArg != null && strArg.toString().endsWith(suffixArg.toString());
//                }
//            });
//
//            // Write the test code here following the given rules
//            assertTrue(StringUtils.endsWith(str, suffix));
//        }
//    }













    @Test
    public void testLastIndexOf_NullCharSequence_ReturnsMinusOne() {
        // Instantiate all necessary variables here
        CharSequence seq = null;
        CharSequence searchSeq = "a";

        // Write the test code here following the given rules
        int result = StringUtils.lastIndexOf(seq, searchSeq);

        assertEquals(-1, result);
    }

    @Test
    public void testLastIndexOf_NullSearchCharSequence_ReturnsMinusOne() {
        // Instantiate all necessary variables here
        CharSequence seq = "aabaabaa";
        CharSequence searchSeq = null;

        // Write the test code here following the given rules
        int result = StringUtils.lastIndexOf(seq, searchSeq);

        assertEquals(-1, result);
    }

    @Test
    public void testLastIndexOf_EmptyCharSequence_ReturnsZero() {
        // Instantiate all necessary variables here
        CharSequence seq = "";
        CharSequence searchSeq = "";

        // Write the test code here following the given rules
        int result = StringUtils.lastIndexOf(seq, searchSeq);

        assertEquals(0, result);
    }

    @Test
    public void testLastIndexOf_NoMatch_ReturnsMinusOne() {
        // Instantiate all necessary variables here
        CharSequence seq = "aabaabaa";
        CharSequence searchSeq = "c";

        // Write the test code here following the given rules
        int result = StringUtils.lastIndexOf(seq, searchSeq);

        assertEquals(-1, result);
    }

    @Test
    public void testLastIndexOf_LastIndexOfMatch_ReturnsCorrectIndex() {
        // Instantiate all necessary variables here
        CharSequence seq = "aabaabaa";
        CharSequence searchSeq = "a";

        // Write the test code here following the given rules
        int result = StringUtils.lastIndexOf(seq, searchSeq);

        assertEquals(7, result);
    }

    @Test
    public void testLastIndexOf_MultipleMatches_ReturnsIndexOfLastMatch() {
        // Instantiate all necessary variables here
        CharSequence seq = "aabaabaa";
        CharSequence searchSeq = "b";

        // Write the test code here following the given rules
        int result = StringUtils.lastIndexOf(seq, searchSeq);

        assertEquals(5, result);
    }

//    @Test
//    public void testLastIndexOf_SearchSeqLongerThanSeq_ReturnsMinusOne() {
//        // Instantiate all necessary variables here
//        CharSequence seq = "aabaabaa";
//        CharSequence searchSeq = "ab";
//
//        // Write the test code here following the given rules
//        int result = StringUtils.lastIndexOf(seq, searchSeq);
//
//        assertEquals(-1, result);
//    }

    @Test
    public void testLastIndexOf_EmptySearchSeq_ReturnsLengthOfSeq() {
        // Instantiate all necessary variables here
        CharSequence seq = "aabaabaa";
        CharSequence searchSeq = "";

        // Write the test code here following the given rules
        int result = StringUtils.lastIndexOf(seq, searchSeq);

        assertEquals(8, result);
    }

    @Test
    public void testLastIndexOf_NullCharSequenceWithStartPos_ReturnsMinusOne() {
        // Instantiate all necessary variables here
        CharSequence seq = null;
        CharSequence searchSeq = "a";
        int startPos = 10;

        // Write the test code here following the given rules
        int result = StringUtils.lastIndexOf(seq, searchSeq, startPos);

        assertEquals(-1, result);
    }

    @Test
    public void testLastIndexOf_NullSearchCharSequenceWithStartPos_ReturnsMinusOne() {
        // Instantiate all necessary variables here
        CharSequence seq = "aabaabaa";
        CharSequence searchSeq = null;
        int startPos = 10;

        // Write the test code here following the given rules
        int result = StringUtils.lastIndexOf(seq, searchSeq, startPos);

        assertEquals(-1, result);
    }

//    @Test
//    public void testLastIndexOf_StartPosGreaterThanSeqLength_ReturnsMinusOne() {
//        // Instantiate all necessary variables here
//        CharSequence seq = "aabaabaa";
//        CharSequence searchSeq = "a";
//        int startPos = 10;
//
//        // Write the test code here following the given rules
//        int result = StringUtils.lastIndexOf(seq, searchSeq, startPos);
//
//        assertEquals(-1, result);
//    }

    @Test
    public void testLastIndexOf_NegativeStartPos_ReturnsMinusOne() {
        // Instantiate all necessary variables here
        CharSequence seq = "aabaabaa";
        CharSequence searchSeq = "a";
        int startPos = -1;

        // Write the test code here following the given rules
        int result = StringUtils.lastIndexOf(seq, searchSeq, startPos);

        assertEquals(-1, result);
    }

    @Test
    public void testLastIndexOf_LastIndexOfMatchWithStartPos_ReturnsCorrectIndex() {
        // Instantiate all necessary variables here
        CharSequence seq = "aabaabaa";
        CharSequence searchSeq = "a";
        int startPos = 8;

        // Write the test code here following the given rules
        int result = StringUtils.lastIndexOf(seq, searchSeq, startPos);

        assertEquals(7, result);
    }

    @Test
    public void testLastIndexOf_MultipleMatchesWithStartPos_ReturnsIndexOfLastMatch() {
        // Instantiate all necessary variables here
        CharSequence seq = "aabaabaa";
        CharSequence searchSeq = "b";
        int startPos = 8;

        // Write the test code here following the given rules
        int result = StringUtils.lastIndexOf(seq, searchSeq, startPos);

        assertEquals(5, result);
    }

//    @Test
//    public void testLastIndexOf_SearchSeqLongerThanSeqWithStartPos_ReturnsMinusOne() {
//        // Instantiate all necessary variables here
//        CharSequence seq = "aabaabaa";
//        CharSequence searchSeq = "ab";
//        int startPos = 10;
//
//        // Write the test code here following the given rules
//        int result = StringUtils.lastIndexOf(seq, searchSeq, startPos);
//
//        assertEquals(-1, result);
//    }

    @Test
    public void testLastIndexOf_EmptySearchSeqWithStartPos_ReturnsStartPos() {
        // Instantiate all necessary variables here
        CharSequence seq = "aabaabaa";
        CharSequence searchSeq = "";
        int startPos = 5;

        // Write the test code here following the given rules
        int result = StringUtils.lastIndexOf(seq, searchSeq, startPos);

        assertEquals(5, result);
    }

    @Test
    public void testLastIndexOf_EmptyCharSequenceWithSearchChar_ReturnsMinusOne() {
        // Instantiate all necessary variables here
        CharSequence seq = "";
        int searchChar = 'a';

        // Write the test code here following the given rules
        int result = StringUtils.lastIndexOf(seq, searchChar);

        assertEquals(-1, result);
    }

    @Test
    public void testLastIndexOf_NullCharSequenceWithSearchChar_ReturnsMinusOne() {
        // Instantiate all necessary variables here
        CharSequence seq = null;
        int searchChar = 'a';

        // Write the test code here following the given rules
        int result = StringUtils.lastIndexOf(seq, searchChar);

        assertEquals(-1, result);
    }

    @Test
    public void testLastIndexOf_NoMatchWithSearchChar_ReturnsMinusOne() {
        // Instantiate all necessary variables here
        CharSequence seq = "aabaabaa";
        int searchChar = 'c';

        // Write the test code here following the given rules
        int result = StringUtils.lastIndexOf(seq, searchChar);

        assertEquals(-1, result);
    }

    @Test
    public void testLastIndexOf_LastIndexOfMatchWithSearchChar_ReturnsCorrectIndex() {
        // Instantiate all necessary variables here
        CharSequence seq = "aabaabaa";
        int searchChar = 'a';

        // Write the test code here following the given rules
        int result = StringUtils.lastIndexOf(seq, searchChar);

        assertEquals(7, result);
    }

    @Test
    public void testLastIndexOf_MultipleMatchesWithSearchChar_ReturnsIndexOfLastMatch() {
        // Instantiate all necessary variables here
        CharSequence seq = "aabaabaa";
        int searchChar = 'b';

        // Write the test code here following the given rules
        int result = StringUtils.lastIndexOf(seq, searchChar);

        assertEquals(5, result);
    }









    @Test
    public void testReplaceIgnoreCase() {
        String text = "aba";
        String searchString = "A";
        String replacement = "z";
        String expected = "zbz";

        String result = StringUtils.replaceIgnoreCase(text, searchString, replacement);

        assertEquals(expected, result);
    }

    @Test
    public void testReplaceIgnoreCase_NullText() {
        String text = null;
        String searchString = "A";
        String replacement = "z";
        String expected = null;

        String result = StringUtils.replaceIgnoreCase(text, searchString, replacement);

        assertEquals(expected, result);
    }

    @Test
    public void testReplaceIgnoreCase_NullSearchString() {
        String text = "aba";
        String searchString = null;
        String replacement = "z";
        String expected = "aba";

        String result = StringUtils.replaceIgnoreCase(text, searchString, replacement);

        assertEquals(expected, result);
    }

    @Test
    public void testReplaceIgnoreCase_NullReplacement() {
        String text = "aba";
        String searchString = "A";
        String replacement = null;
        String expected = "aba";

        String result = StringUtils.replaceIgnoreCase(text, searchString, replacement);

        assertEquals(expected, result);
    }

    @Test
    public void testReplaceIgnoreCase_EmptyText() {
        String text = "";
        String searchString = "A";
        String replacement = "z";
        String expected = "";

        String result = StringUtils.replaceIgnoreCase(text, searchString, replacement);

        assertEquals(expected, result);
    }

    @Test
    public void testReplaceIgnoreCase_EmptySearchString() {
        String text = "aba";
        String searchString = "";
        String replacement = "z";
        String expected = "aba";

        String result = StringUtils.replaceIgnoreCase(text, searchString, replacement);

        assertEquals(expected, result);
    }

    @Test
    public void testReplaceIgnoreCase_MaxZero() {
        String text = "abaa";
        String searchString = "a";
        String replacement = "";
        int max = 0;
        String expected = "abaa";

        String result = StringUtils.replaceIgnoreCase(text, searchString, replacement, max);

        assertEquals(expected, result);
    }

    @Test
    public void testReplaceIgnoreCase_MaxNegative() {
        String text = "abaa";
        String searchString = "a";
        String replacement = "z";
        int max = -1;
        String expected = "zbzz";

        String result = StringUtils.replaceIgnoreCase(text, searchString, replacement, max);

        assertEquals(expected, result);
    }

    @Test
    public void testReplaceIgnoreCase_CaseSensitive() {
        String text = "abAa";
        String searchString = "a";
        String replacement = "z";
        int max = 2;
        String expected = "zbza";

        String result = StringUtils.replaceIgnoreCase(text, searchString, replacement, max);

        assertEquals(expected, result);
    }

    @Test
    public void testReplaceIgnoreCase_MultipleOccurrences() {
        String text = "abAaA";
        String searchString = "a";
        String replacement = "z";
        int max = -1;
        String expected = "zbzzz";

        String result = StringUtils.replaceIgnoreCase(text, searchString, replacement, max);

        assertEquals(expected, result);
    }

    @Test
    public void testReplaceIgnoreCase_NoOccurrences() {
        String text = "abcde";
        String searchString = "x";
        String replacement = "z";
        int max = -1;
        String expected = "abcde";

        String result = StringUtils.replaceIgnoreCase(text, searchString, replacement, max);

        assertEquals(expected, result);
    }

//    @Test
//    public void testReplaceIgnoreCase_MockStatic() {
//        try (MockedStatic<Pattern> mockedPattern = Mockito.mockStatic(Pattern.class)) {
//            String text = "aba";
//            String searchString = "A";
//            String replacement = "z";
//            String expected = "zbz";
//
//            mockedPattern.when(() -> Pattern.compile("\\p{InCombiningDiacriticalMarks}+")).thenReturn(Pattern.compile("A"));
//
//            String result = StringUtils.replaceIgnoreCase(text, searchString, replacement);
//
//            assertEquals(expected, result);
//        }
//    }













    @Test
    public void ExampleTest4() {
        String source = "A<__>\n<__>B";
        String regex = "<.*>";
        String expected = "AB";
        
        String result = StringUtils.removePattern(source, regex);
        
        assertEquals(expected, result);
    }

    @Test
    public void testRemovePattern_NullSource_ReturnsNull() {
        String source = null;
        String regex = ".*";
        
        String result = StringUtils.removePattern(source, regex);
        
        assertNull(result);
    }

    @Test
    public void testRemovePattern_NullRegex_ReturnsSource() {
        String source = "ABCabc123";
        String regex = null;
        
        String result = StringUtils.removePattern(source, regex);
        
        assertEquals(source, result);
    }

    @Test
    public void testRemovePattern_EmptySource_ReturnsEmpty() {
        String source = "";
        String regex = ".*";
        
        String result = StringUtils.removePattern(source, regex);
        
        assertEquals("", result);
    }

    @Test
    public void testRemovePattern_EmptyRegex_ReturnsSource() {
        String source = "ABCabc123";
        String regex = "";
        
        String result = StringUtils.removePattern(source, regex);
        
        assertEquals(source, result);
    }

    @Test
    public void testRemovePattern_NoMatch_ReturnsSource() {
        String source = "ABCabc123";
        String regex = "x";
        
        String result = StringUtils.removePattern(source, regex);
        
        assertEquals(source, result);
    }

    @Test
    public void testRemovePattern_MultipleMatches_ReturnsCorrectResult() {
        String source = "ABCabc123";
        String regex = "[a-z]";
        String expected = "ABC123";
        
        String result = StringUtils.removePattern(source, regex);
        
        assertEquals(expected, result);
    }

    @Test
    public void testRemovePattern_RegexWithSpecialCharacters_ReturnsCorrectResult() {
        String source = "ABC*abc123";
        String regex = "[a-z*]";
        String expected = "ABC123";
        
        String result = StringUtils.removePattern(source, regex);
        
        assertEquals(expected, result);
    }

    @Test
    public void testRemovePattern_RegexWithSpace_ReturnsCorrectResult() {
        String source = "ABC abc 123";
        String regex = "\\s+";
        String expected = "ABCabc123";
        
        String result = StringUtils.removePattern(source, regex);
        
        assertEquals(expected, result);
    }





    @Test
    public void exampleTest() {
        // Instantiate all necessary variables here
        String source = "AbC";
        
        // Write the test code here following the given rules
        String expected = "abc";
        String actual = StringUtils.toRootLowerCase(source);
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testToRootLowerCase_NullSource() {
        // Instantiate all necessary variables here
        String source = null;
        
        // Write the test code here following the given rules
        String actual = StringUtils.toRootLowerCase(source);
        
        assertNull(actual);
    }
    
    @Test
    public void testToRootLowerCase_EmptySource() {
        // Instantiate all necessary variables here
        String source = "";
        
        // Write the test code here following the given rules
        String expected = "";
        String actual = StringUtils.toRootLowerCase(source);
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testToRootLowerCase_MixedCaseSource() {
        // Instantiate all necessary variables here
        String source = "AbC dEf";
        
        // Write the test code here following the given rules
        String expected = "abc def";
        String actual = StringUtils.toRootLowerCase(source);
        
        assertEquals(expected, actual);
    }
    
//    @Test
//    public void testToRootLowerCase_SpecialCharactersSource() {
//        // Instantiate all necessary variables here
//        String source = "¡HÓLÁ!";
//
//        // Write the test code here following the given rules
//        String expected = "¡hÓlÁ!";
//        String actual = StringUtils.toRootLowerCase(source);
//
//        assertEquals(expected, actual);
//    }





//    @Test
//    public void testGetIfBlank_ReturnsInputString_WhenNotEmpty() {
//        // Arrange
//        String input = "not blank";
//        Supplier<String> defaultSupplier = mock(Supplier.class);
//
//        // Act
//        String result = StringUtils.getIfBlank(input, defaultSupplier);
//
//        // Assert
//        assertEquals(input, result);
//        verify(defaultSupplier, never()).get();
//    }

//    @Test
//    public void testGetIfBlank_ReturnsDefault_WhenNullInputAndNonNullSupplier() {
//        // Arrange
//        String input = null;
//        String defaultValue = "default";
//        Supplier<String> defaultSupplier = mock(Supplier.class);
//        when(defaultSupplier.get()).thenReturn(defaultValue);
//
//        // Act
//        String result = StringUtils.getIfBlank(input, defaultSupplier);
//
//        // Assert
//        assertEquals(defaultValue, result);
//        verify(defaultSupplier).get();
//    }

//    @Test
//    public void testGetIfBlank_ReturnsDefault_WhenEmptyInputAndNonNullSupplier() {
//        // Arrange
//        String input = "";
//        String defaultValue = "default";
//        Supplier<String> defaultSupplier = mock(Supplier.class);
//        when(defaultSupplier.get()).thenReturn(defaultValue);
//
//        // Act
//        String result = StringUtils.getIfBlank(input, defaultSupplier);
//
//        // Assert
//        assertEquals(defaultValue, result);
//        verify(defaultSupplier).get();
//    }

//    @Test
//    public void testGetIfBlank_ReturnsDefault_WhenBlankInputAndNonNullSupplier() {
//        // Arrange
//        String input = "  ";
//        String defaultValue = "default";
//        Supplier<String> defaultSupplier = mock(Supplier.class);
//        when(defaultSupplier.get()).thenReturn(defaultValue);
//
//        // Act
//        String result = StringUtils.getIfBlank(input, defaultSupplier);
//
//        // Assert
//        assertEquals(defaultValue, result);
//        verify(defaultSupplier).get();
//    }

    @Test
    public void testGetIfBlank_ReturnsNull_WhenNullInputAndNullSupplier() {
        // Arrange
        String input = null;
        Supplier<String> defaultSupplier = null;

        // Act
        String result = StringUtils.getIfBlank(input, defaultSupplier);

        // Assert
        assertNull(result);
    }

    @Test
    public void testGetIfBlank_ReturnsNull_WhenEmptyInputAndNullSupplier() {
        // Arrange
        String input = "";
        Supplier<String> defaultSupplier = null;

        // Act
        String result = StringUtils.getIfBlank(input, defaultSupplier);

        // Assert
        assertNull(result);
    }

    @Test
    public void testGetIfBlank_ReturnsNull_WhenBlankInputAndNullSupplier() {
        // Arrange
        String input = "  ";
        Supplier<String> defaultSupplier = null;

        // Act
        String result = StringUtils.getIfBlank(input, defaultSupplier);

        // Assert
        assertNull(result);
    }





    @Test
    public void testRemoveIgnoreCase_NullSourceString_ReturnsNull() {
        String str = null;
        String remove = "remove";
        
        String result = StringUtils.removeIgnoreCase(str, remove);
        
        assertNull(result);
    }
    
    @Test
    public void testRemoveIgnoreCase_EmptySourceString_ReturnsEmptyString() {
        String str = "";
        String remove = "remove";
        
        String result = StringUtils.removeIgnoreCase(str, remove);
        
        assertEquals("", result);
    }
    
    @Test
    public void testRemoveIgnoreCase_NullRemoveString_ReturnsSourceString() {
        String str = "source";
        String remove = null;
        
        String result = StringUtils.removeIgnoreCase(str, remove);
        
        assertEquals("source", result);
    }
    
    @Test
    public void testRemoveIgnoreCase_EmptyRemoveString_ReturnsSourceString() {
        String str = "source";
        String remove = "";
        
        String result = StringUtils.removeIgnoreCase(str, remove);
        
        assertEquals("source", result);
    }
    
    @Test
    public void testRemoveIgnoreCase_RemoveStringNotFound_ReturnsSourceString() {
        String str = "source";
        String remove = "remove";
        
        String result = StringUtils.removeIgnoreCase(str, remove);
        
        assertEquals("source", result);
    }
    
    @Test
    public void testRemoveIgnoreCase_RemoveStringFound_ReturnsSubstringWithRemoveStringRemoved() {
        String str = "queued";
        String remove = "ue";
        
        String result = StringUtils.removeIgnoreCase(str, remove);
        
        assertEquals("qd", result);
    }
    
    @Test
    public void testRemoveIgnoreCase_RemoveStringFound_CaseInsensitive_ReturnsSubstringWithRemoveStringRemoved() {
        String str = "quEUed";
        String remove = "UE";
        
        String result = StringUtils.removeIgnoreCase(str, remove);
        
        assertEquals("qd", result);
    }
    
//    @Test
//    public void testRemoveIgnoreCase_MultipleOccurrencesOfRemoveString_ReturnsSubstringWithAllOccurrencesRemoved() {
//        String str = "queued";
//        String remove = "u";
//
//        String result = StringUtils.removeIgnoreCase(str, remove);
//
//        assertEquals("qed", result);
//    }
    
    @Test
    public void testRemoveIgnoreCase_RemoveStringEqualsSourceString_ReturnsEmptyString() {
        String str = "remove";
        String remove = "remove";
        
        String result = StringUtils.removeIgnoreCase(str, remove);
        
        assertEquals("", result);
    }
    





    @Test
    public void testEndsWithAny_NullSequence_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence sequence = null;
        CharSequence[] searchStrings = new CharSequence[] {"abc"};

        // Mock the dependencies
        
        // Write the test code here following the given rules
        boolean result = StringUtils.endsWithAny(sequence, searchStrings);

        // Perform assertions
        assertFalse(result);
    }

    @Test
    public void testEndsWithAny_NullSearchStrings_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence sequence = "abcxyz";
        CharSequence[] searchStrings = null;

        // Mock the dependencies
        
        // Write the test code here following the given rules
        boolean result = StringUtils.endsWithAny(sequence, searchStrings);

        // Perform assertions
        assertFalse(result);
    }

    @Test
    public void testEndsWithAny_EmptySequence_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence sequence = "";
        CharSequence[] searchStrings = new CharSequence[] {"abc"};

        // Mock the dependencies
        
        // Write the test code here following the given rules
        boolean result = StringUtils.endsWithAny(sequence, searchStrings);

        // Perform assertions
        assertFalse(result);
    }

//    @Test
//    public void testEndsWithAny_EmptySearchStrings_ReturnsTrue() {
//        // Instantiate all necessary variables here
//        CharSequence sequence = "abcxyz";
//        CharSequence[] searchStrings = new CharSequence[] {};
//
//        // Mock the dependencies
//
//        // Write the test code here following the given rules
//        boolean result = StringUtils.endsWithAny(sequence, searchStrings);
//
//        // Perform assertions
//        assertTrue(result);
//    }

    @Test
    public void testEndsWithAny_SequenceEndsWithSearchString_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence sequence = "abcxyz";
        CharSequence[] searchStrings = new CharSequence[] {"xyz"};

        // Mock the dependencies
        
        // Write the test code here following the given rules
        boolean result = StringUtils.endsWithAny(sequence, searchStrings);

        // Perform assertions
        assertTrue(result);
    }

    @Test
    public void testEndsWithAny_SequenceNotEndsWithSearchString_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence sequence = "abcxyz";
        CharSequence[] searchStrings = new CharSequence[] {"def"};

        // Mock the dependencies
        
        // Write the test code here following the given rules
        boolean result = StringUtils.endsWithAny(sequence, searchStrings);

        // Perform assertions
        assertFalse(result);
    }

    @Test
    public void testEndsWithAny_SequenceEndsWithAnySearchString_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence sequence = "abcXYZ";
        CharSequence[] searchStrings = new CharSequence[] {"def", "XYZ"};

        // Mock the dependencies
        
        // Write the test code here following the given rules
        boolean result = StringUtils.endsWithAny(sequence, searchStrings);

        // Perform assertions
        assertTrue(result);
    }

    @Test
    public void testEndsWithAny_SequenceNotEndsWithAnySearchString_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence sequence = "abcXYZ";
        CharSequence[] searchStrings = new CharSequence[] {"def", "xyz"};

        // Mock the dependencies
        
        // Write the test code here following the given rules
        boolean result = StringUtils.endsWithAny(sequence, searchStrings);

        // Perform assertions
        assertFalse(result);
    }







    @Test
    public void testSubstringAfterLast_withCharacter_separatorExists_returnsSubstring() {
        // Instantiate all necessary variables here
        String str = "abcba";
        int separator = 'b';

        // Write the test code here following the given rules
        String result = StringUtils.substringAfterLast(str, separator);

        assertEquals("a", result);
    }

    @Test
    public void testSubstringAfterLast_withCharacter_separatorNotExists_returnsEmptyString() {
        // Instantiate all necessary variables here
        String str = "abc";
        int separator = 'd';

        // Write the test code here following the given rules
        String result = StringUtils.substringAfterLast(str, separator);

        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterLast_withCharacter_emptyStringInput_returnsEmptyString() {
        // Instantiate all necessary variables here
        String str = "";
        int separator = 'a';

        // Write the test code here following the given rules
        String result = StringUtils.substringAfterLast(str, separator);

        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterLast_withCharacter_nullStringInput_returnsNull() {
        // Instantiate all necessary variables here
        String str = null;
        int separator = 'a';

        // Write the test code here following the given rules
        String result = StringUtils.substringAfterLast(str, separator);

        assertNull(result);
    }

    @Test
    public void testSubstringAfterLast_withCharacter_separatorAtEnd_returnsEmptyString() {
        // Instantiate all necessary variables here
        String str = "abc";
        int separator = 'c';

        // Write the test code here following the given rules
        String result = StringUtils.substringAfterLast(str, separator);

        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterLast_withString_separatorExists_returnsSubstring() {
        // Instantiate all necessary variables here
        String str = "abcba";
        String separator = "b";

        // Write the test code here following the given rules
        String result = StringUtils.substringAfterLast(str, separator);

        assertEquals("a", result);
    }

    @Test
    public void testSubstringAfterLast_withString_separatorNotExists_returnsEmptyString() {
        // Instantiate all necessary variables here
        String str = "abc";
        String separator = "d";

        // Write the test code here following the given rules
        String result = StringUtils.substringAfterLast(str, separator);

        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterLast_withString_emptyStringInput_returnsEmptyString() {
        // Instantiate all necessary variables here
        String str = "";
        String separator = "a";

        // Write the test code here following the given rules
        String result = StringUtils.substringAfterLast(str, separator);

        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterLast_withString_nullStringInput_returnsNull() {
        // Instantiate all necessary variables here
        String str = null;
        String separator = "a";

        // Write the test code here following the given rules
        String result = StringUtils.substringAfterLast(str, separator);

        assertNull(result);
    }

    @Test
    public void testSubstringAfterLast_withString_separatorAtEnd_returnsEmptyString() {
        // Instantiate all necessary variables here
        String str = "abc";
        String separator = "c";

        // Write the test code here following the given rules
        String result = StringUtils.substringAfterLast(str, separator);

        assertEquals("", result);
    }





    @Test
    public void testAppendIfMissing_NullStringNullSuffix_ReturnsNull() {
        // Instantiate all necessary variables here
        String str = null;
        CharSequence suffix = null;
        CharSequence[] suffixes = null;

        // Write the test code here following the given rules
        String result = StringUtils.appendIfMissing(str, suffix, suffixes);

        // Verify the result
        assertNull(result);
    }
    
    @Test
    public void testAppendIfMissing_NullStringNullSuffixNonNullSuffixes_ReturnsNull() {
        // Instantiate all necessary variables here
        String str = null;
        CharSequence suffix = null;
        CharSequence[] suffixes = new CharSequence[]{"suffix1", "suffix2"};

        // Write the test code here following the given rules
        String result = StringUtils.appendIfMissing(str, suffix, suffixes);

        // Verify the result
        assertNull(result);
    }
    
//    @Test
//    public void testAppendIfMissing_NullStringEmptySuffix_ReturnsEmptySuffix() {
//        // Instantiate all necessary variables here
//        String str = null;
//        CharSequence suffix = "";
//        CharSequence[] suffixes = null;
//
//        // Write the test code here following the given rules
//        String result = StringUtils.appendIfMissing(str, suffix, suffixes);
//
//        // Verify the result
//        assertEquals("", result);
//    }
    
    @Test
    public void testAppendIfMissing_NonNullStringNullSuffix_ReturnsSameString() {
        // Instantiate all necessary variables here
        String str = "abc";
        CharSequence suffix = null;
        CharSequence[] suffixes = null;

        // Write the test code here following the given rules
        String result = StringUtils.appendIfMissing(str, suffix, suffixes);

        // Verify the result
        assertEquals("abc", result);
    }
    
    @Test
    public void testAppendIfMissing_NonNullStringEmptySuffix_ReturnsSameString() {
        // Instantiate all necessary variables here
        String str = "abc";
        CharSequence suffix = "";
        CharSequence[] suffixes = null;

        // Write the test code here following the given rules
        String result = StringUtils.appendIfMissing(str, suffix, suffixes);

        // Verify the result
        assertEquals("abc", result);
    }
    
    @Test
    public void testAppendIfMissing_NonNullStringNonNullSuffixNotPresentInString_ReturnsStringWithSuffixAppended() {
        // Instantiate all necessary variables here
        String str = "abc";
        CharSequence suffix = "xyz";
        CharSequence[] suffixes = null;

        // Write the test code here following the given rules
        String result = StringUtils.appendIfMissing(str, suffix, suffixes);

        // Verify the result
        assertEquals("abcxyz", result);
    }
    
    @Test
    public void testAppendIfMissing_NonNullStringNonNullSuffixPresentInString_ReturnsSameString() {
        // Instantiate all necessary variables here
        String str = "abcxyz";
        CharSequence suffix = "xyz";
        CharSequence[] suffixes = null;

        // Write the test code here following the given rules
        String result = StringUtils.appendIfMissing(str, suffix, suffixes);

        // Verify the result
        assertEquals("abcxyz", result);
    }
    
    @Test
    public void testAppendIfMissing_NonNullStringNonNullSuffixNotPresentInStringButPresentInSuffixes_ReturnsStringWithSuffixAppended() {
        // Instantiate all necessary variables here
        String str = "abc";
        CharSequence suffix = "xyz";
        CharSequence[] suffixes = new CharSequence[]{"suffix1", "suffix2", "xyz"};

        // Write the test code here following the given rules
        String result = StringUtils.appendIfMissing(str, suffix, suffixes);

        // Verify the result
        assertEquals("abcxyz", result);
    }
    
    @Test
    public void testAppendIfMissing_NonNullStringNonNullSuffixPresentInStringAndSuffixes_ReturnsSameString() {
        // Instantiate all necessary variables here
        String str = "abcxyz";
        CharSequence suffix = "xyz";
        CharSequence[] suffixes = new CharSequence[]{"suffix1", "suffix2", "xyz"};

        // Write the test code here following the given rules
        String result = StringUtils.appendIfMissing(str, suffix, suffixes);

        // Verify the result
        assertEquals("abcxyz", result);
    }









    @Test
    public void testContainsAny_whenCharSequenceContainsSearchChars_shouldReturnTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = "zzabyycdxx";
        char[] searchChars = {'z', 'a'};

        // Write the test code here following the given rules
        boolean result = StringUtils.containsAny(cs, searchChars);
        
        assertTrue(result);
    }
    
    @Test
    public void testContainsAny_whenCharSequenceDoesNotContainSearchChars_shouldReturnFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "aba";
        char[] searchChars = {'z'};

        // Write the test code here following the given rules
        boolean result = StringUtils.containsAny(cs, searchChars);
        
        assertFalse(result);
    }
    
    @Test
    public void testContainsAny_whenCharSequenceIsNull_shouldReturnFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = null;
        char[] searchChars = {'z'};

        // Write the test code here following the given rules
        boolean result = StringUtils.containsAny(cs, searchChars);
        
        assertFalse(result);
    }
    
    @Test
    public void testContainsAny_whenSearchCharsIsNull_shouldReturnFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "zzabyycdxx";
        char[] searchChars = null;

        // Write the test code here following the given rules
        boolean result = StringUtils.containsAny(cs, searchChars);
        
        assertFalse(result);
    }
    
    @Test
    public void testContainsAny_whenCharSequenceIsEmpty_shouldReturnFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "";
        char[] searchChars = {'z'};

        // Write the test code here following the given rules
        boolean result = StringUtils.containsAny(cs, searchChars);
        
        assertFalse(result);
    }
    
    @Test
    public void testContainsAny_whenSearchCharsIsEmpty_shouldReturnFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "zzabyycdxx";
        char[] searchChars = {};

        // Write the test code here following the given rules
        boolean result = StringUtils.containsAny(cs, searchChars);
        
        assertFalse(result);
    }
    
    @Test
    public void testContainsAny_whenCharSequenceContainsSearchCharsAsString_shouldReturnTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = "zzabyycdxx";
        CharSequence searchChars = "za";

        // Write the test code here following the given rules
        boolean result = StringUtils.containsAny(cs, searchChars);
        
        assertTrue(result);
    }
    
    @Test
    public void testContainsAny_whenCharSequenceDoesNotContainSearchCharsAsString_shouldReturnFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "aba";
        CharSequence searchChars = "z";

        // Write the test code here following the given rules
        boolean result = StringUtils.containsAny(cs, searchChars);
        
        assertFalse(result);
    }
    
    @Test
    public void testContainsAny_whenCharSequenceIsNullAndSearchCharsIsNotNull_shouldReturnFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = null;
        CharSequence searchChars = "z";

        // Write the test code here following the given rules
        boolean result = StringUtils.containsAny(cs, searchChars);
        
        assertFalse(result);
    }
    
    @Test
    public void testContainsAny_whenCharSequenceIsNotNullAndSearchCharsIsNull_shouldReturnFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "zzabyycdxx";
        CharSequence searchChars = null;

        // Write the test code here following the given rules
        boolean result = StringUtils.containsAny(cs, searchChars);
        
        assertFalse(result);
    }
    
    @Test
    public void testContainsAny_whenCharSequenceIsEmptyAndSearchCharsIsNotEmpty_shouldReturnFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "";
        CharSequence searchChars = "z";

        // Write the test code here following the given rules
        boolean result = StringUtils.containsAny(cs, searchChars);
        
        assertFalse(result);
    }
    
    @Test
    public void testContainsAny_whenCharSequenceIsNotEmptyAndSearchCharsIsEmpty_shouldReturnFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "zzabyycdxx";
        CharSequence searchChars = "";

        // Write the test code here following the given rules
        boolean result = StringUtils.containsAny(cs, searchChars);
        
        assertFalse(result);
    }
    
    @Test
    public void testContainsAny_whenCharSequenceContainsAnyOfTheSearchCharSequences_shouldReturnTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = "abcd";
        CharSequence[] searchCharSequences = {"ab", null};

        // Write the test code here following the given rules
        boolean result = StringUtils.containsAny(cs, searchCharSequences);
        
        assertTrue(result);
    }
    
//    @Test
//    public void testContainsAny_whenCharSequenceDoesNotContainAnyOfTheSearchCharSequences_shouldReturnFalse() {
//        // Instantiate all necessary variables here
//        CharSequence cs = "abc";
//        CharSequence[] searchCharSequences = {"d", "abc"};
//
//        // Write the test code here following the given rules
//        boolean result = StringUtils.containsAny(cs, searchCharSequences);
//
//        assertFalse(result);
//    }
    
    @Test
    public void testContainsAny_whenCharSequenceIsNullAndSearchCharSequencesAreNotNull_shouldReturnFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = null;
        CharSequence[] searchCharSequences = {"ab", null};

        // Write the test code here following the given rules
        boolean result = StringUtils.containsAny(cs, searchCharSequences);
        
        assertFalse(result);
    }
    
    @Test
    public void testContainsAny_whenCharSequenceIsNotNullAndSearchCharSequencesIsNull_shouldReturnFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "abcd";
        CharSequence[] searchCharSequences = null;

        // Write the test code here following the given rules
        boolean result = StringUtils.containsAny(cs, searchCharSequences);
        
        assertFalse(result);
    }




    @Test
    public void testJoinWithNullArrayReturnsNull() {
        // Arrange
        boolean[] array = null;
        char delimiter = ',';

        // Act
        String result = StringUtils.join(array, delimiter);

        // Assert
        assertNull(result);
    }

    @Test
    public void testJoinWithEmptyArrayReturnsEmptyString() {
        // Arrange
        boolean[] array = {};
        char delimiter = ',';

        // Act
        String result = StringUtils.join(array, delimiter);

        // Assert
        assertEquals("", result);
    }

//    @Test
//    public void testJoinWithNullElementInArrayReturnsEmptyString() {
//        // Arrange
//        boolean[] array = {null};
//        char delimiter = ',';
//
//        // Act
//        String result = StringUtils.join(array, delimiter);
//
//        // Assert
//        assertEquals("", result);
//    }

    @Test
    public void testJoinWithSingleElementArrayReturnsElementAsString() {
        // Arrange
        boolean[] array = {true};
        char delimiter = ',';

        // Act
        String result = StringUtils.join(array, delimiter);

        // Assert
        assertEquals("true", result);
    }

    @Test
    public void testJoinWithMultipleElementsArrayReturnsElementsSeparatedByDelimiter() {
        // Arrange
        boolean[] array = {true, false, true};
        char delimiter = ',';

        // Act
        String result = StringUtils.join(array, delimiter);

        // Assert
        assertEquals("true,false,true", result);
    }

    @Test
    public void testJoinWithStartIndexAndEndIndexReturnsElementsInRangeSeparatedByDelimiter() {
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

//    @Test
//    public void testJoinWithListAndDelimiterReturnsElementsSeparatedByDelimiter() {
//        // Arrange
//        List<Boolean> list = List.of(true, false, true);
//        char delimiter = ',';
//
//        // Act
//        String result = StringUtils.join(list, delimiter);
//
//        // Assert
//        assertEquals("true,false,true", result);
//    }

//    @Test
//    public void testJoinWithIteratorAndDelimiterReturnsElementsSeparatedByDelimiter() {
//        // Arrange
//        List<Boolean> list = List.of(true, false, true);
//        char delimiter = ',';
//        Iterator<Boolean> iterator = list.iterator();
//
//        // Act
//        String result = StringUtils.join(iterator, delimiter);
//
//        // Assert
//        assertEquals("true,false,true", result);
//    }

    @Test
    public void testJoinWithArrayAndSeparatorReturnsElementsSeparatedBySeparator() {
        // Arrange
        Object[] array = {"a", "b", "c"};
        String separator = "--";

        // Act
        String result = StringUtils.join(array, separator);

        // Assert
        assertEquals("a--b--c", result);
    }

    @Test
    public void testJoinWithArrayAndNullSeparatorReturnsElementsConcatenated() {
        // Arrange
        Object[] array = {"a", "b", "c"};
        String separator = null;

        // Act
        String result = StringUtils.join(array, separator);

        // Assert
        assertEquals("abc", result);
    }

    @Test
    public void testJoinWithArrayAndEmptySeparatorReturnsElementsConcatenated() {
        // Arrange
        Object[] array = {"a", "b", "c"};
        String separator = "";

        // Act
        String result = StringUtils.join(array, separator);

        // Assert
        assertEquals("abc", result);
    }

//    @Test
//    public void testJoinWithListAndSeparatorReturnsElementsSeparatedBySeparator() {
//        // Arrange
//        List<String> list = List.of("a", "b", "c");
//        String separator = "--";
//
//        // Act
//        String result = StringUtils.join(list, separator);
//
//        // Assert
//        assertEquals("a--b--c", result);
//    }

//    @Test
//    public void testJoinWithIteratorAndSeparatorReturnsElementsSeparatedBySeparator() {
//        // Arrange
//        List<String> list = List.of("a", "b", "c");
//        String separator = "--";
//        Iterator<String> iterator = list.iterator();
//
//        // Act
//        String result = StringUtils.join(iterator, separator);
//
//        // Assert
//        assertEquals("a--b--c", result);
//    }
//
//    @Test
//    public void testJoinWithListAndStartIndexAndEndIndexReturnsElementsInRangeSeparatedBySeparator() {
//        // Arrange
//        List<String> list = List.of("a", "b", "c", "d", "e");
//        String separator = "--";
//        int startIndex = 1;
//        int endIndex = 4;
//
//        // Act
//        String result = StringUtils.join(list, separator, startIndex, endIndex);
//
//        // Assert
//        assertEquals("b--c--d", result);
//    }

    @Test
    public void testJoinWithArrayAndStartIndexAndEndIndexReturnsElementsInRangeSeparatedBySeparator() {
        // Arrange
        Object[] array = {"a", "b", "c", "d", "e"};
        String separator = "--";
        int startIndex = 1;
        int endIndex = 4;

        // Act
        String result = StringUtils.join(array, separator, startIndex, endIndex);

        // Assert
        assertEquals("b--c--d", result);
    }

//    @Test
//    public void testJoinWithListAndStartIndexEqualToEndIndexReturnsEmptyString() {
//        // Arrange
//        List<String> list = List.of("a", "b", "c", "d", "e");
//        String separator = "--";
//        int startIndex = 2;
//        int endIndex = 2;
//
//        // Act
//        String result = StringUtils.join(list, separator, startIndex, endIndex);
//
//        // Assert
//        assertEquals("", result);
//    }




//    @Test
//    public void ExampleTest() {
//        // Instantiate all necessary variables here
//
//        // Write the test code here following the given rules
//    }
//
    @Test
    public void testCenter_withNullString_shouldReturnNull() {
        // Arrange
        String str = null;
        int size = 5;
        
        // Act
        String result = StringUtils.center(str, size);
        
        // Assert
        assertNull(result);
    }
    
    @Test
    public void testCenter_withEmptyString_shouldReturnPaddedString() {
        // Arrange
        String str = "";
        int size = 5;
        
        // Act
        String result = StringUtils.center(str, size);
        
        // Assert
        assertEquals("     ", result);
    }
    
    @Test
    public void testCenter_withNegativeSize_shouldReturnSameString() {
        // Arrange
        String str = "ab";
        int size = -1;
        
        // Act
        String result = StringUtils.center(str, size);
        
        // Assert
        assertEquals("ab", result);
    }
    
    @Test
    public void testCenter_withSizeSmallerThanString_shouldReturnSameString() {
        // Arrange
        String str = "abcd";
        int size = 2;
        
        // Act
        String result = StringUtils.center(str, size);
        
        // Assert
        assertEquals("abcd", result);
    }
    
    @Test
    public void testCenter_withSizeEqualToString_shouldReturnSameString() {
        // Arrange
        String str = "a";
        int size = 1;
        
        // Act
        String result = StringUtils.center(str, size);
        
        // Assert
        assertEquals("a", result);
    }
    
    @Test
    public void testCenter_withEvenSize_shouldReturnPaddedStringWithEqualPaddingOnBothSides() {
        // Arrange
        String str = "ab";
        int size = 4;
        
        // Act
        String result = StringUtils.center(str, size);
        
        // Assert
        assertEquals(" ab ", result);
    }
    
    @Test
    public void testCenter_withOddSize_shouldReturnPaddedStringWithEqualPaddingOnBothSides() {
        // Arrange
        String str = "a";
        int size = 3;
        
        // Act
        String result = StringUtils.center(str, size);
        
        // Assert
        assertEquals(" a ", result);
    }
    
    @Test
    public void testCenter_withPadChar_shouldReturnPaddedStringWithPadChar() {
        // Arrange
        String str = "a";
        int size = 4;
        char padChar = 'y';
        
        // Act
        String result = StringUtils.center(str, size, padChar);
        
        // Assert
        assertEquals("yayy", result);
    }
    
    @Test
    public void testCenter_withNullPadStr_shouldUseSpaceAsPadStr() {
        // Arrange
        String str = "abc";
        int size = 7;
        String padStr = null;
        
        // Act
        String result = StringUtils.center(str, size, padStr);
        
        // Assert
        assertEquals("  abc  ", result);
    }
    
    @Test
    public void testCenter_withEmptyPadStr_shouldUseSpaceAsPadStr() {
        // Arrange
        String str = "abc";
        int size = 7;
        String padStr = "";
        
        // Act
        String result = StringUtils.center(str, size, padStr);
        
        // Assert
        assertEquals("  abc  ", result);
    }
    
    @Test
    public void testCenter_withNonEmptyPadStr_shouldReturnPaddedStringWithPadStr() {
        // Arrange
        String str = "a";
        int size = 4;
        String padStr = "yz";
        
        // Act
        String result = StringUtils.center(str, size, padStr);
        
        // Assert
        assertEquals("yayz", result);
    }






    @Test
    public void testIsAlphanumericSpace_NullInput_ReturnsFalse() {
        // Arrange
        CharSequence cs = null;

        // Act
        boolean result = StringUtils.isAlphanumericSpace(cs);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsAlphanumericSpace_EmptyString_ReturnsTrue() {
        // Arrange
        CharSequence cs = "";

        // Act
        boolean result = StringUtils.isAlphanumericSpace(cs);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAlphanumericSpace_Whitespace_ReturnsTrue() {
        // Arrange
        CharSequence cs = "  ";

        // Act
        boolean result = StringUtils.isAlphanumericSpace(cs);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAlphanumericSpace_LettersAndDigits_ReturnsTrue() {
        // Arrange
        CharSequence cs = "abc123";

        // Act
        boolean result = StringUtils.isAlphanumericSpace(cs);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAlphanumericSpace_LettersDigitsAndSpace_ReturnsTrue() {
        // Arrange
        CharSequence cs = "ab c12 3";

        // Act
        boolean result = StringUtils.isAlphanumericSpace(cs);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAlphanumericSpace_LettersDigitsAndSpecialCharacter_ReturnsFalse() {
        // Arrange
        CharSequence cs = "ab-c";

        // Act
        boolean result = StringUtils.isAlphanumericSpace(cs);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsAlphanumericSpace_LargeInput_ReturnsTrue() {
        // Arrange
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            sb.append("a");
        }
        CharSequence cs = sb.toString();

        // Act
        boolean result = StringUtils.isAlphanumericSpace(cs);

        // Assert
        assertTrue(result);
    }









    @Test
    public void compare_NullStrings_ReturnsZero() {
        String str1 = null;
        String str2 = null;

        int result = StringUtils.compare(str1, str2);

        assertEquals(0, result);
    }

    @Test
    public void compare_NullStringAndNonNullString_ReturnsNegativeValue() {
        String str1 = null;
        String str2 = "a";

        int result = StringUtils.compare(str1, str2);

        assertTrue(result < 0);
    }

    @Test
    public void compare_NonNullStringAndNullString_ReturnsPositiveValue() {
        String str1 = "a";
        String str2 = null;

        int result = StringUtils.compare(str1, str2);

        assertTrue(result > 0);
    }

    @Test
    public void compare_EqualStrings_ReturnsZero() {
        String str1 = "abc";
        String str2 = "abc";

        int result = StringUtils.compare(str1, str2);

        assertEquals(0, result);
    }

    @Test
    public void compare_LessThanStrings_ReturnsNegativeValue() {
        String str1 = "a";
        String str2 = "b";

        int result = StringUtils.compare(str1, str2);

        assertTrue(result < 0);
    }

    @Test
    public void compare_GreaterThanStrings_ReturnsPositiveValue() {
        String str1 = "b";
        String str2 = "a";

        int result = StringUtils.compare(str1, str2);

        assertTrue(result > 0);
    }

    @Test
    public void compare_CaseSensitiveComparison_ReturnsPositiveValue() {
        String str1 = "a";
        String str2 = "B";

        int result = StringUtils.compare(str1, str2);

        assertTrue(result > 0);
    }

    @Test
    public void compare_SubstringComparison_ReturnsNegativeValue() {
        String str1 = "ab";
        String str2 = "abc";

        int result = StringUtils.compare(str1, str2);

        assertTrue(result < 0);
    }




    @Test
    public void testContains_whenSeqIsNull_ReturnsFalse() {
        // Arrange
        CharSequence seq = null;
        CharSequence searchSeq = "abc";

        // Act
        boolean result = StringUtils.contains(seq, searchSeq);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testContains_whenSearchSeqIsNull_ReturnsFalse() {
        // Arrange
        CharSequence seq = "abc";
        CharSequence searchSeq = null;

        // Act
        boolean result = StringUtils.contains(seq, searchSeq);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testContains_whenSeqAndSearchSeqAreNull_ReturnsFalse() {
        // Arrange
        CharSequence seq = null;
        CharSequence searchSeq = null;

        // Act
        boolean result = StringUtils.contains(seq, searchSeq);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testContains_whenSeqAndSearchSeqAreEmpty_ReturnsTrue() {
        // Arrange
        CharSequence seq = "";
        CharSequence searchSeq = "";

        // Act
        boolean result = StringUtils.contains(seq, searchSeq);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testContains_whenSeqIsEmptyAndSearchSeqIsNotEmpty_ReturnsFalse() {
        // Arrange
        CharSequence seq = "";
        CharSequence searchSeq = "abc";

        // Act
        boolean result = StringUtils.contains(seq, searchSeq);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testContains_whenSeqIsNotEmptyAndSearchSeqIsEmpty_ReturnsTrue() {
        // Arrange
        CharSequence seq = "abc";
        CharSequence searchSeq = "";

        // Act
        boolean result = StringUtils.contains(seq, searchSeq);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testContains_whenSeqDoesNotContainSearchSeq_ReturnsFalse() {
        // Arrange
        CharSequence seq = "abc";
        CharSequence searchSeq = "def";

        // Act
        boolean result = StringUtils.contains(seq, searchSeq);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testContains_whenSeqContainsSearchSeq_ReturnsTrue() {
        // Arrange
        CharSequence seq = "abc";
        CharSequence searchSeq = "b";

        // Act
        boolean result = StringUtils.contains(seq, searchSeq);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testContains_whenSeqContainsMultipleSearchSeq_ReturnsTrue() {
        // Arrange
        CharSequence seq = "abcbcbc";
        CharSequence searchSeq = "b";

        // Act
        boolean result = StringUtils.contains(seq, searchSeq);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testContains_whenSeqContainsSearchChar_ReturnsTrue() {
        // Arrange
        CharSequence seq = "abc";
        int searchChar = 'b';

        // Act
        boolean result = StringUtils.contains(seq, searchChar);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testContains_whenSeqDoesNotContainSearchChar_ReturnsFalse() {
        // Arrange
        CharSequence seq = "abc";
        int searchChar = 'd';

        // Act
        boolean result = StringUtils.contains(seq, searchChar);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testContains_whenSeqIsEmpty_ReturnsFalse() {
        // Arrange
        CharSequence seq = "";
        int searchChar = 'a';

        // Act
        boolean result = StringUtils.contains(seq, searchChar);

        // Assert
        assertFalse(result);
    }




    @Test
    public void testGetJaroWinklerDistance_NullStrings_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.getJaroWinklerDistance(null, null));
    }

    @Test
    public void testGetJaroWinklerDistance_EmptyStrings_ReturnsZero() {
        double distance = StringUtils.getJaroWinklerDistance("", "");
        assertEquals(0.0, distance);
    }

    @Test
    public void testGetJaroWinklerDistance_OneEmptyString_ReturnsZero() {
        double distance = StringUtils.getJaroWinklerDistance("", "a");
        assertEquals(0.0, distance);
    }

    @Test
    public void testGetJaroWinklerDistance_OneStringEmpty_ReturnsZero() {
        double distance = StringUtils.getJaroWinklerDistance("aaapppp", "");
        assertEquals(0.0, distance);
    }

    @Test
    public void testGetJaroWinklerDistance_SameStrings_ReturnsOne() {
        double distance = StringUtils.getJaroWinklerDistance("frog", "frog");
        assertEquals(1.0, distance);
    }

    @Test
    public void testGetJaroWinklerDistance_SimilarStrings_ReturnsExpectedDistance() {
        double distance = StringUtils.getJaroWinklerDistance("frog", "fog");
        assertEquals(0.93, distance, 0.01);
    }

    @Test
    public void testGetJaroWinklerDistance_DissimilarStrings_ReturnsZero() {
        double distance = StringUtils.getJaroWinklerDistance("fly", "ant");
        assertEquals(0.0, distance);
    }

    @Test
    public void testGetJaroWinklerDistance_LongerStrings_ReturnsExpectedDistance() {
        double distance = StringUtils.getJaroWinklerDistance("elephant", "hippo");
        assertEquals(0.44, distance, 0.01);
    }

    @Test
    public void testGetJaroWinklerDistance_ReversedStrings_ReturnsSameDistance() {
        double distance1 = StringUtils.getJaroWinklerDistance("hippo", "elephant");
        double distance2 = StringUtils.getJaroWinklerDistance("elephant", "hippo");
        assertEquals(distance1, distance2, 0.01);
    }

    @Test
    public void testGetJaroWinklerDistance_CompletelyDifferentStrings_ReturnsZero() {
        double distance = StringUtils.getJaroWinklerDistance("hippo", "zzzzzzzz");
        assertEquals(0.0, distance);
    }

//    @Test
//    public void testGetJaroWinklerDistance_SimilarStrings_ReturnsExpectedDistanceWithDifferentScalingFactor() {
//        double distance1 = StringUtils.getJaroWinklerDistance("hello", "hallo");
//        double distance2 = StringUtils.getJaroWinklerDistance("hello", "hallo");
//        assertNotEquals(distance1, distance2);
//    }

    @Test
    public void testGetJaroWinklerDistance_MatchingInitials_ReturnsExpectedDistance() {
        double distance = StringUtils.getJaroWinklerDistance("ABC Corporation", "ABC Corp");
        assertEquals(0.93, distance, 0.01);
    }

    @Test
    public void testGetJaroWinklerDistance_MatchingWithSpecialCharacters_ReturnsExpectedDistance() {
        double distance = StringUtils.getJaroWinklerDistance("D N H Enterprises Inc", "D & H Enterprises, Inc.");
        assertEquals(0.95, distance, 0.01);
    }

    @Test
    public void testGetJaroWinklerDistance_MatchingWithDifferentPunctuation_ReturnsExpectedDistance() {
        double distance = StringUtils.getJaroWinklerDistance("My Gym Children's Fitness Center", "My Gym. Childrens Fitness");
        assertEquals(0.92, distance, 0.01);
    }

    @Test
    public void testGetJaroWinklerDistance_MatchingWithDifferentCase_ReturnsExpectedDistance() {
        double distance = StringUtils.getJaroWinklerDistance("PENNSYLVANIA", "PENNCISYLVNIA");
        assertEquals(0.88, distance, 0.01);
    }




    @Test
    public void testAbbreviateMiddle_WithNullString_ReturnsNull() {
        // Instantiate all necessary variables here
        String str = null;
        String middle = ".";
        int length = 5;

        // Write the test code here following the given rules
        String result = StringUtils.abbreviateMiddle(str, middle, length);

        assertNull(result);
    }

    @Test
    public void testAbbreviateMiddle_WithNullMiddle_ReturnsOriginalString() {
        // Instantiate all necessary variables here
        String str = "abc";
        String middle = null;
        int length = 5;

        // Write the test code here following the given rules
        String result = StringUtils.abbreviateMiddle(str, middle, length);

        assertEquals(str, result);
    }

    @Test
    public void testAbbreviateMiddle_WithLengthEqualOrGreater_ReturnsOriginalString() {
        // Instantiate all necessary variables here
        String str = "abc";
        String middle = ".";
        int length = 3;

        // Write the test code here following the given rules
        String result = StringUtils.abbreviateMiddle(str, middle, length);

        assertEquals(str, result);
    }

//    @Test
//    public void testAbbreviateMiddle_WithLengthLessThanMiddleLengthPlus2_ReturnsOriginalString() {
//        // Instantiate all necessary variables here
//        String str = "abcdef";
//        String middle = ".";
//        int length = 4;
//
//        // Write the test code here following the given rules
//        String result = StringUtils.abbreviateMiddle(str, middle, length);
//
//        assertEquals(str, result);
//    }

//    @Test
//    public void testAbbreviateMiddle_WithValidInputs_ReturnsAbbreviatedString() {
//        // Instantiate all necessary variables here
//        String str = "abcdef";
//        String middle = ".";
//        int length = 6;
//
//        // Write the test code here following the given rules
//        String result = StringUtils.abbreviateMiddle(str, middle, length);
//
//        assertEquals("ab.f", result);
//    }

//    @Test
//    public void testAbbreviateMiddle_WithValidInputsAndOddLength_ReturnsAbbreviatedString() {
//        // Instantiate all necessary variables here
//        String str = "abcdefgh";
//        String middle = ".";
//        int length = 7;
//
//        // Write the test code here following the given rules
//        String result = StringUtils.abbreviateMiddle(str, middle, length);
//
//        assertEquals("ab.fgh", result);
//    }





    @Test
    public void chomp_NullString_ReturnsNull() {
        // Instantiate all necessary variables here
        String str = null;

        // Write the test code here following the given rules
        String result = StringUtils.chomp(str);

        assertNull(result);
    }
    
    @Test
    public void chomp_EmptyString_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        String str = "";

        // Write the test code here following the given rules
        String result = StringUtils.chomp(str);

        assertEquals("", result);
    }
    
    @Test
    public void chomp_SingleCharCR_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        String str = "\r";

        // Write the test code here following the given rules
        String result = StringUtils.chomp(str);

        assertEquals("", result);
    }
    
    @Test
    public void chomp_SingleCharLF_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        String str = "\n";

        // Write the test code here following the given rules
        String result = StringUtils.chomp(str);

        assertEquals("", result);
    }
    
    @Test
    public void chomp_SingleCharNonNewline_ReturnsSameString() {
        // Instantiate all necessary variables here
        String str = "a";

        // Write the test code here following the given rules
        String result = StringUtils.chomp(str);

        assertEquals("a", result);
    }
    
    @Test
    public void chomp_OnlyLF_ReturnsStringWithoutLF() {
        // Instantiate all necessary variables here
        String str = "abc\n";

        // Write the test code here following the given rules
        String result = StringUtils.chomp(str);

        assertEquals("abc", result);
    }
    
    @Test
    public void chomp_OnlyCR_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        String str = "abc\r";

        // Write the test code here following the given rules
        String result = StringUtils.chomp(str);

        assertEquals("abc", result);
    }
    
    @Test
    public void chomp_CRLF_ReturnsStringWithoutCRLF() {
        // Instantiate all necessary variables here
        String str = "abc\r\n";

        // Write the test code here following the given rules
        String result = StringUtils.chomp(str);

        assertEquals("abc", result);
    }
    
    @Test
    public void chomp_MultipleCRLF_ReturnsStringWithoutLastCRLF() {
        // Instantiate all necessary variables here
        String str = "abc\r\n\r\n";

        // Write the test code here following the given rules
        String result = StringUtils.chomp(str);

        assertEquals("abc\r\n", result);
    }
    
    @Test
    public void chomp_CRLFLF_ReturnsStringWithoutLastCRLF() {
        // Instantiate all necessary variables here
        String str = "abc\n\r";

        // Write the test code here following the given rules
        String result = StringUtils.chomp(str);

        assertEquals("abc\n", result);
    }
    
    @Test
    public void chomp_StringWithoutNewline_ReturnsSameString() {
        // Instantiate all necessary variables here
        String str = "abc";

        // Write the test code here following the given rules
        String result = StringUtils.chomp(str);

        assertEquals("abc", result);
    }




    @Test
    public void ExampleTest5() {
        // Instantiate all necessary variables here
        StringUtils stringUtils = new StringUtils();
        String input = "The dog has a BONE";
        String expectedOutput = "tHE DOG HAS A bone";

        // Write the test code here following the given rules
        String actualOutput = stringUtils.swapCase(input);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testSwapCase_NullInput_ReturnsNull() {
        StringUtils stringUtils = new StringUtils();
        String input = null;

        String actualOutput = stringUtils.swapCase(input);

        assertNull(actualOutput);
    }

    @Test
    public void testSwapCase_EmptyInput_ReturnsEmpty() {
        StringUtils stringUtils = new StringUtils();
        String input = "";

        String actualOutput = stringUtils.swapCase(input);

        assertEquals("", actualOutput);
    }

    @Test
    public void testSwapCase_AllUppercaseLetters_ReturnsAllLowercaseLetters() {
        StringUtils stringUtils = new StringUtils();
        String input = "HELLO WORLD";
        String expectedOutput = "hello world";

        String actualOutput = stringUtils.swapCase(input);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testSwapCase_AllLowercaseLetters_ReturnsAllUppercaseLetters() {
        StringUtils stringUtils = new StringUtils();
        String input = "hello world";
        String expectedOutput = "HELLO WORLD";

        String actualOutput = stringUtils.swapCase(input);

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testSwapCase_MixedCaseLetters_ReturnsSwappedCaseLetters() {
        StringUtils stringUtils = new StringUtils();
        String input = "ThE dOg HaS a BoNe";
        String expectedOutput = "tHe DoG hAs A bOnE";

        String actualOutput = stringUtils.swapCase(input);

        assertEquals(expectedOutput, actualOutput);
    }





    @Test
    public void trimToNull_InputIsNull_ReturnsNull() {
        // Arrange
        String input = null;

        // Act
        String result = StringUtils.trimToNull(input);

        // Assert
        assertNull(result);
    }

    @Test
    public void trimToNull_InputIsEmpty_ReturnsNull() {
        // Arrange
        String input = "";

        // Act
        String result = StringUtils.trimToNull(input);

        // Assert
        assertNull(result);
    }

    @Test
    public void trimToNull_InputIsWhitespace_ReturnsNull() {
        // Arrange
        String input = "     ";

        // Act
        String result = StringUtils.trimToNull(input);

        // Assert
        assertNull(result);
    }

    @Test
    public void trimToNull_InputIsNotEmpty_ReturnsTrimmedString() {
        // Arrange
        String input = "  abc  ";

        // Act
        String result = StringUtils.trimToNull(input);

        // Assert
        assertEquals("abc", result);
    }




    @Test
    public void testSubstringBeforeWithSeparator() {
        // Instantiate all necessary variables here
        String str = "abcba";
        int separator = 'b';

        // Write the test code here following the given rules
        String result = StringUtils.substringBefore(str, separator);

        assertEquals("a", result);
    }

    @Test
    public void testSubstringBeforeWithSeparatorNotFound() {
        // Instantiate all necessary variables here
        String str = "abc";
        int separator = 'd';

        // Write the test code here following the given rules
        String result = StringUtils.substringBefore(str, separator);

        assertEquals("abc", result);
    }

    @Test
    public void testSubstringBeforeWithSeparatorNullString() {
        // Instantiate all necessary variables here
        String str = null;
        int separator = 'a';

        // Write the test code here following the given rules
        String result = StringUtils.substringBefore(str, separator);

        assertNull(result);
    }

    @Test
    public void testSubstringBeforeWithStringSeparator() {
        // Instantiate all necessary variables here
        String str = "abcba";
        String separator = "b";

        // Write the test code here following the given rules
        String result = StringUtils.substringBefore(str, separator);

        assertEquals("a", result);
    }

    @Test
    public void testSubstringBeforeWithStringSeparatorNotFound() {
        // Instantiate all necessary variables here
        String str = "abc";
        String separator = "d";

        // Write the test code here following the given rules
        String result = StringUtils.substringBefore(str, separator);

        assertEquals("abc", result);
    }

    @Test
    public void testSubstringBeforeWithStringSeparatorNullString() {
        // Instantiate all necessary variables here
        String str = null;
        String separator = "a";

        // Write the test code here following the given rules
        String result = StringUtils.substringBefore(str, separator);

        assertNull(result);
    }

    @Test
    public void testSubstringBeforeWithStringSeparatorNullSeparator() {
        // Instantiate all necessary variables here
        String str = "abc";
        String separator = null;

        // Write the test code here following the given rules
        String result = StringUtils.substringBefore(str, separator);

        assertEquals("abc", result);
    }

    @Test
    public void testSubstringBeforeWithStringSeparatorEmptySeparator() {
        // Instantiate all necessary variables here
        String str = "abc";
        String separator = "";

        // Write the test code here following the given rules
        String result = StringUtils.substringBefore(str, separator);

        assertEquals("", result);
    }




    @Test
    public void getLevenshteinDistance_NullStrings_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.getLevenshteinDistance(null, null));
    }

    @Test
    public void getLevenshteinDistance_EmptyString_ReturnsZero() {
        int distance = StringUtils.getLevenshteinDistance("", "");
        assertEquals(0, distance);
    }

    @Test
    public void getLevenshteinDistance_OneEmptyString_ReturnsLengthOfNonEmptyString() {
        int distance = StringUtils.getLevenshteinDistance("", "a");
        assertEquals(1, distance);
    }

    @Test
    public void getLevenshteinDistance_DifferentLengthStrings_ReturnsCorrectDistance1() {
        int distance = StringUtils.getLevenshteinDistance("aaapppp", "");
        assertEquals(7, distance);
    }

    @Test
    public void getLevenshteinDistance_SameStrings_ReturnsZero() {
        int distance = StringUtils.getLevenshteinDistance("frog", "frog");
        assertEquals(0, distance);
    }

//    @Test
//    public void getLevenshteinDistance_SingleCharacterDifference_ReturnsOne() {
//        int distance = StringUtils.getLevenshteinDistance("fly", "fog");
//        assertEquals(1, distance);
//    }

    @Test
    public void getLevenshteinDistance_MultipleCharacterDifference_ReturnsCorrectDistance() {
        int distance = StringUtils.getLevenshteinDistance("elephant", "hippo");
        assertEquals(7, distance);
    }

    @Test
    public void getLevenshteinDistance_DifferentOrderStrings_ReturnsCorrectDistance() {
        int distance = StringUtils.getLevenshteinDistance("hippo", "elephant");
        assertEquals(7, distance);
    }

    @Test
    public void getLevenshteinDistance_DifferentLengthStrings_ReturnsCorrectDistance2() {
        int distance = StringUtils.getLevenshteinDistance("hippo", "zzzzzzzz");
        assertEquals(8, distance);
    }

    @Test
    public void getLevenshteinDistance_OneCharacterDifference_ReturnsOne() {
        int distance = StringUtils.getLevenshteinDistance("hello", "hallo");
        assertEquals(1, distance);
    }

    @Test
    public void getLevenshteinDistance_ThresholdNegative_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.getLevenshteinDistance("hello", "hallo", -1));
    }

    @Test
    public void getLevenshteinDistance_NullStringsAndThreshold_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> StringUtils.getLevenshteinDistance(null, null, 0));
    }

//    @Test
//    public void getLevenshteinDistance_ThresholdZero_ReturnsDistanceIfBelowThreshold() {
//        int distance = StringUtils.getLevenshteinDistance("aaapppp", "", 0);
//        assertEquals(7, distance);
//    }

    @Test
    public void getLevenshteinDistance_ThresholdZero_ReturnsNegativeOneIfAboveThreshold() {
        int distance = StringUtils.getLevenshteinDistance("aaapppp", "", 6);
        assertEquals(-1, distance);
    }

    @Test
    public void getLevenshteinDistance_DifferentLengthStringsAndThreshold_ReturnsCorrectDistance() {
        int distance = StringUtils.getLevenshteinDistance("elephant", "hippo", 7);
        assertEquals(7, distance);
    }

    @Test
    public void getLevenshteinDistance_DifferentLengthStringsAndThreshold_ReturnsNegativeOneIfAboveThreshold() {
        int distance = StringUtils.getLevenshteinDistance("elephant", "hippo", 6);
        assertEquals(-1, distance);
    }




    @Test
    public void testNormalizeSpace_WithNullString_ReturnsNull() {
        // Arrange
        String str = null;

        // Act
        String result = StringUtils.normalizeSpace(str);

        // Assert
        assertNull(result);
    }

    @Test
    public void testNormalizeSpace_WithEmptyString_ReturnsEmptyString() {
        // Arrange
        String str = "";

        // Act
        String result = StringUtils.normalizeSpace(str);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testNormalizeSpace_WithWhitespaceString_ReturnsNormalizedString() {
        // Arrange
        String str = "  Hello  World  ";

        // Act
        String result = StringUtils.normalizeSpace(str);

        // Assert
        assertEquals("Hello World", result);
    }

    @Test
    public void testNormalizeSpace_WithLeadingWhitespaceString_ReturnsNormalizedString() {
        // Arrange
        String str = "  Hello World";

        // Act
        String result = StringUtils.normalizeSpace(str);

        // Assert
        assertEquals("Hello World", result);
    }

    @Test
    public void testNormalizeSpace_WithTrailingWhitespaceString_ReturnsNormalizedString() {
        // Arrange
        String str = "Hello World  ";

        // Act
        String result = StringUtils.normalizeSpace(str);

        // Assert
        assertEquals("Hello World", result);
    }

    @Test
    public void testNormalizeSpace_WithMultipleWhitespacesString_ReturnsNormalizedString() {
        // Arrange
        String str = "Hello   World";

        // Act
        String result = StringUtils.normalizeSpace(str);

        // Assert
        assertEquals("Hello World", result);
    }

    @Test
    public void testNormalizeSpace_WithNonBreakingSpaceString_ReturnsNormalizedString() {
        // Arrange
        String str = "Hello\u00A0World";

        // Act
        String result = StringUtils.normalizeSpace(str);

        // Assert
        assertEquals("Hello World", result);
    }

    @Test
    public void testNormalizeSpace_WithMixedWhitespaceString_ReturnsNormalizedString() {
        // Arrange
        String str = "  Hello\tWorld\n";

        // Act
        String result = StringUtils.normalizeSpace(str);

        // Assert
        assertEquals("Hello World", result);
    }

    @Test
    public void testNormalizeSpace_WithControlCharactersString_ReturnsNormalizedString() {
        // Arrange
        String str = "Hello\u0009World";

        // Act
        String result = StringUtils.normalizeSpace(str);

        // Assert
        assertEquals("Hello World", result);
    }





    @Test
    public void testReplaceEach_NullInput_ReturnsNull() {
        // Arrange
        String text = null;
        String[] searchList = {"a"};
        String[] replacementList = {"b"};

        // Act
        String result = StringUtils.replaceEach(text, searchList, replacementList);

        // Assert
        assertNull(result);
    }

    @Test
    public void testReplaceEach_EmptyInput_ReturnsEmpty() {
        // Arrange
        String text = "";
        String[] searchList = {"a"};
        String[] replacementList = {"b"};

        // Act
        String result = StringUtils.replaceEach(text, searchList, replacementList);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testReplaceEach_NullSearchList_ReturnsOriginalText() {
        // Arrange
        String text = "aba";
        String[] searchList = null;
        String[] replacementList = {"b"};

        // Act
        String result = StringUtils.replaceEach(text, searchList, replacementList);

        // Assert
        assertEquals("aba", result);
    }

    @Test
    public void testReplaceEach_NullReplacementList_ReturnsOriginalText() {
        // Arrange
        String text = "aba";
        String[] searchList = {"a"};
        String[] replacementList = null;

        // Act
        String result = StringUtils.replaceEach(text, searchList, replacementList);

        // Assert
        assertEquals("aba", result);
    }

    @Test
    public void testReplaceEach_EmptySearchList_ReturnsOriginalText() {
        // Arrange
        String text = "aba";
        String[] searchList = new String[0];
        String[] replacementList = {"b"};

        // Act
        String result = StringUtils.replaceEach(text, searchList, replacementList);

        // Assert
        assertEquals("aba", result);
    }

    @Test
    public void testReplaceEach_EmptyReplacementList_ReturnsOriginalText() {
        // Arrange
        String text = "aba";
        String[] searchList = {"a"};
        String[] replacementList = new String[0];

        // Act
        String result = StringUtils.replaceEach(text, searchList, replacementList);

        // Assert
        assertEquals("aba", result);
    }

    @Test
    public void testReplaceEach_SingleSearchAndReplacement_ReturnsReplacedText() {
        // Arrange
        String text = "aba";
        String[] searchList = {"a"};
        String[] replacementList = {"b"};

        // Act
        String result = StringUtils.replaceEach(text, searchList, replacementList);

        // Assert
        assertEquals("bbb", result);
    }

    @Test
    public void testReplaceEach_MultipleSearchAndReplacement_ReturnsReplacedText() {
        // Arrange
        String text = "abcde";
        String[] searchList = {"ab", "d"};
        String[] replacementList = {"w", "t"};

        // Act
        String result = StringUtils.replaceEach(text, searchList, replacementList);

        // Assert
        assertEquals("wcte", result);
    }

    @Test
    public void testReplaceEach_RepeatingSearchAndReplacement_ReturnsReplacedText() {
        // Arrange
        String text = "abcde";
        String[] searchList = {"ab", "d"};
        String[] replacementList = {"d", "t"};

        // Act
        String result = StringUtils.replaceEach(text, searchList, replacementList);

        // Assert
        assertEquals("dcte", result);
    }




    @Test
    public void testIsAlphaSpace_NullInput_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = null;

        // Write the test code here following the given rules
        boolean result = StringUtils.isAlphaSpace(cs);

        assertFalse(result);
    }

    @Test
    public void testIsAlphaSpace_EmptyString_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = "";

        // Write the test code here following the given rules
        boolean result = StringUtils.isAlphaSpace(cs);

        assertTrue(result);
    }

    @Test
    public void testIsAlphaSpace_WhitespaceString_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = "  ";

        // Write the test code here following the given rules
        boolean result = StringUtils.isAlphaSpace(cs);

        assertTrue(result);
    }

    @Test
    public void testIsAlphaSpace_OnlyLetters_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = "abc";

        // Write the test code here following the given rules
        boolean result = StringUtils.isAlphaSpace(cs);

        assertTrue(result);
    }

    @Test
    public void testIsAlphaSpace_LettersAndSpace_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = "ab c";

        // Write the test code here following the given rules
        boolean result = StringUtils.isAlphaSpace(cs);

        assertTrue(result);
    }

    @Test
    public void testIsAlphaSpace_LettersAndDigits_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "ab2c";

        // Write the test code here following the given rules
        boolean result = StringUtils.isAlphaSpace(cs);

        assertFalse(result);
    }

    @Test
    public void testIsAlphaSpace_LettersAndSpecialCharacters_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "ab-c";

        // Write the test code here following the given rules
        boolean result = StringUtils.isAlphaSpace(cs);

        assertFalse(result);
    }




//    @Test
//    public void testMatches() {
//        // Test case 1: first and second are empty strings
//        CharSequence first1 = "";
//        CharSequence second1 = "";
//        int[] expected1 = {0, 0, 0, 0};
//        assertArrayEquals(expected1, StringUtils.matches(first1, second1));
//
//        // Test case 2: first is empty string, second is non-empty string
//        CharSequence first2 = "";
//        CharSequence second2 = "abc";
//        int[] expected2 = {0, 0, 0, 3};
//        assertArrayEquals(expected2, StringUtils.matches(first2, second2));
//
//        // Test case 3: first is non-empty string, second is empty string
//        CharSequence first3 = "abc";
//        CharSequence second3 = "";
//        int[] expected3 = {0, 0, 0, 3};
//        assertArrayEquals(expected3, StringUtils.matches(first3, second3));
//
//        // Test case 4: first and second are same non-empty strings
//        CharSequence first4 = "abc";
//        CharSequence second4 = "abc";
//        int[] expected4 = {3, 0, 3, 3};
//        assertArrayEquals(expected4, StringUtils.matches(first4, second4));
//
//        // Test case 5: first and second are different non-empty strings
//        CharSequence first5 = "abc";
//        CharSequence second5 = "def";
//        int[] expected5 = {0, 0, 0, 3};
//        assertArrayEquals(expected5, StringUtils.matches(first5, second5));
//
//        // Test case 6: first and second have partial matching characters
//        CharSequence first6 = "abc";
//        CharSequence second6 = "bcd";
//        int[] expected6 = {3, 0, 3, 3};
//        assertArrayEquals(expected6, StringUtils.matches(first6, second6));
//
//        // Test case 7: first and second have transposed characters
//        CharSequence first7 = "abc";
//        CharSequence second7 = "bac";
//        int[] expected7 = {3, 1, 3, 3};
//        assertArrayEquals(expected7, StringUtils.matches(first7, second7));
//
//        // Test case 8: first and second have common prefix
//        CharSequence first8 = "abc";
//        CharSequence second8 = "abxyz";
//        int[] expected8 = {2, 0, 2, 5};
//        assertArrayEquals(expected8, StringUtils.matches(first8, second8));
//
//        // Test case 9: first and second have common prefix and transposed characters
//        CharSequence first9 = "abc";
//        CharSequence second9 = "baxyz";
//        int[] expected9 = {2, 1, 2, 5};
//        assertArrayEquals(expected9, StringUtils.matches(first9, second9));
//
//        // Test case 10: first and second have no common prefix and transposed characters
//        CharSequence first10 = "abc";
//        CharSequence second10 = "xyzab";
//        int[] expected10 = {0, 0, 0, 5};
//        assertArrayEquals(expected10, StringUtils.matches(first10, second10));
//    }




//    @Test
//    public void isAnyEmpty_NullInput_ReturnsTrue() {
//        // Instantiate all necessary variables here
//        CharSequence[] css = null;
//
//        // Write the test code here following the given rules
//        boolean result = StringUtils.isAnyEmpty(css);
//
//        assertTrue(result);
//    }

    @Test
    public void isAnyEmpty_NullString_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence[] css = new CharSequence[] { null };

        // Write the test code here following the given rules
        boolean result = StringUtils.isAnyEmpty(css);

        assertTrue(result);
    }

    @Test
    public void isAnyEmpty_EmptyString_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence[] css = new CharSequence[] { "" };

        // Write the test code here following the given rules
        boolean result = StringUtils.isAnyEmpty(css);

        assertTrue(result);
    }

    @Test
    public void isAnyEmpty_WhitespaceString_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence[] css = new CharSequence[] { " " };

        // Write the test code here following the given rules
        boolean result = StringUtils.isAnyEmpty(css);

        assertFalse(result);
    }

    @Test
    public void isAnyEmpty_NonEmptyString_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence[] css = new CharSequence[] { "foo" };

        // Write the test code here following the given rules
        boolean result = StringUtils.isAnyEmpty(css);

        assertFalse(result);
    }

    @Test
    public void isAnyEmpty_MixedStrings_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence[] css = new CharSequence[] { "foo", "" };

        // Write the test code here following the given rules
        boolean result = StringUtils.isAnyEmpty(css);

        assertTrue(result);
    }

    @Test
    public void isAnyEmpty_NoStrings_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence[] css = new CharSequence[] {};

        // Write the test code here following the given rules
        boolean result = StringUtils.isAnyEmpty(css);

        assertFalse(result);
    }






    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testRemoveStartWithNullString() {
        // Instantiate all necessary variables here
        String str = null;
        char remove = 'a';

        // Write the test code here following the given rules
        String result = stringUtils.removeStart(str, remove);

        assertNull(result);
    }

    @Test
    public void testRemoveStartWithEmptyString() {
        // Instantiate all necessary variables here
        String str = "";
        char remove = 'a';

        // Write the test code here following the given rules
        String result = stringUtils.removeStart(str, remove);

        assertEquals("", result);
    }

    @Test
    public void testRemoveStartWithNullChar() {
        // Instantiate all necessary variables here
        String str = "path";
        char remove = '\0';

        // Write the test code here following the given rules
        String result = stringUtils.removeStart(str, remove);

        assertEquals("path", result);
    }

    @Test
    public void testRemoveStartWithCharAtBeginning() {
        // Instantiate all necessary variables here
        String str = "/path";
        char remove = '/';

        // Write the test code here following the given rules
        String result = stringUtils.removeStart(str, remove);

        assertEquals("path", result);
    }

    @Test
    public void testRemoveStartWithCharNotAtBeginning() {
        // Instantiate all necessary variables here
        String str = "path";
        char remove = '/';

        // Write the test code here following the given rules
        String result = stringUtils.removeStart(str, remove);

        assertEquals("path", result);
    }

    @Test
    public void testRemoveStartWithNonEmptyString() {
        // Instantiate all necessary variables here
        String str = "path";
        char remove = 0;

        // Write the test code here following the given rules
        String result = stringUtils.removeStart(str, remove);

        assertEquals("path", result);
    }

    @Test
    public void testRemoveStartWithNullStringAndNullChar() {
        // Instantiate all necessary variables here
        String str = null;
        char remove = '\0';

        // Write the test code here following the given rules
        String result = stringUtils.removeStart(str, remove);

        assertNull(result);
    }

    @Test
    public void testRemoveStartWithEmptyStringAndNullChar() {
        // Instantiate all necessary variables here
        String str = "";
        char remove = '\0';

        // Write the test code here following the given rules
        String result = stringUtils.removeStart(str, remove);

        assertEquals("", result);
    }

    @Test
    public void testRemoveStartWithNullStringAndCharAtBeginning() {
        // Instantiate all necessary variables here
        String str = null;
        char remove = '/';

        // Write the test code here following the given rules
        String result = stringUtils.removeStart(str, remove);

        assertNull(result);
    }

    @Test
    public void testRemoveStartWithEmptyStringAndCharAtBeginning() {
        // Instantiate all necessary variables here
        String str = "";
        char remove = '/';

        // Write the test code here following the given rules
        String result = stringUtils.removeStart(str, remove);

        assertEquals("", result);
    }

    @Test
    public void testRemoveStartWithNullStringAndCharNotAtBeginning() {
        // Instantiate all necessary variables here
        String str = null;
        char remove = 'a';

        // Write the test code here following the given rules
        String result = stringUtils.removeStart(str, remove);

        assertNull(result);
    }

    @Test
    public void testRemoveStartWithEmptyStringAndCharNotAtBeginning() {
        // Instantiate all necessary variables here
        String str = "";
        char remove = 'a';

        // Write the test code here following the given rules
        String result = stringUtils.removeStart(str, remove);

        assertEquals("", result);
    }




    @Test
    public void testSplitByWholeSeparator() {
        // Test with null input string
        String[] result1 = StringUtils.splitByWholeSeparator(null, ":");
        assertNull(result1);
        
        // Test with empty input string
        String[] result2 = StringUtils.splitByWholeSeparator("", ",");
        assertEquals(0, result2.length);
        
        // Test with null separator
        String[] result3 = StringUtils.splitByWholeSeparator("ab de fg", null);
        assertArrayEquals(new String[]{"ab", "de", "fg"}, result3);
        
        // Test with whitespace separator
        String[] result4 = StringUtils.splitByWholeSeparator("ab   de fg", null);
        assertArrayEquals(new String[]{"ab", "de", "fg"}, result4);
        
        // Test with regular separator
        String[] result5 = StringUtils.splitByWholeSeparator("ab:cd:ef", ":");
        assertArrayEquals(new String[]{"ab", "cd", "ef"}, result5);
        
        // Test with multiple separators
        String[] result6 = StringUtils.splitByWholeSeparator("ab-!-cd-!-ef", "-!-");
        assertArrayEquals(new String[]{"ab", "cd", "ef"}, result6);
        
        // Test with max elements
        String[] result7 = StringUtils.splitByWholeSeparator("ab-!-cd-!-ef", "-!-", 2);
        assertArrayEquals(new String[]{"ab", "cd-!-ef"}, result7);
        
        // Test with max elements as 0
        String[] result8 = StringUtils.splitByWholeSeparator("ab de fg", " ", 0);
        assertArrayEquals(new String[]{"ab", "de", "fg"}, result8);
    }




    @Test
    public void compareIgnoreCase_BothNull_ReturnsZero() {
        // Instantiate all necessary variables here
        String str1 = null;
        String str2 = null;

        // Write the test code here following the given rules
        int result = StringUtils.compareIgnoreCase(str1, str2);

        assertEquals(0, result);
    }

    @Test
    public void compareIgnoreCase_FirstNullAndNullIsLess_ReturnsNegativeValue() {
        // Instantiate all necessary variables here
        String str1 = null;
        String str2 = "a";

        // Write the test code here following the given rules
        int result = StringUtils.compareIgnoreCase(str1, str2, true);

        assertTrue(result < 0);
    }

    @Test
    public void compareIgnoreCase_FirstNullAndNullIsNotLess_ReturnsPositiveValue() {
        // Instantiate all necessary variables here
        String str1 = null;
        String str2 = "a";

        // Write the test code here following the given rules
        int result = StringUtils.compareIgnoreCase(str1, str2, false);

        assertTrue(result > 0);
    }

    @Test
    public void compareIgnoreCase_SecondNullAndNullIsLess_ReturnsPositiveValue() {
        // Instantiate all necessary variables here
        String str1 = "a";
        String str2 = null;

        // Write the test code here following the given rules
        int result = StringUtils.compareIgnoreCase(str1, str2, true);

        assertTrue(result > 0);
    }

    @Test
    public void compareIgnoreCase_SecondNullAndNullIsNotLess_ReturnsNegativeValue() {
        // Instantiate all necessary variables here
        String str1 = "a";
        String str2 = null;

        // Write the test code here following the given rules
        int result = StringUtils.compareIgnoreCase(str1, str2, false);

        assertTrue(result < 0);
    }

    @Test
    public void compareIgnoreCase_BothEmpty_ReturnsZero() {
        // Instantiate all necessary variables here
        String str1 = "";
        String str2 = "";

        // Write the test code here following the given rules
        int result = StringUtils.compareIgnoreCase(str1, str2);

        assertEquals(0, result);
    }

    @Test
    public void compareIgnoreCase_SameValue_ReturnsZero() {
        // Instantiate all necessary variables here
        String str1 = "abc";
        String str2 = "abc";

        // Write the test code here following the given rules
        int result = StringUtils.compareIgnoreCase(str1, str2);

        assertEquals(0, result);
    }

    @Test
    public void compareIgnoreCase_DifferentCase_ReturnsZero() {
        // Instantiate all necessary variables here
        String str1 = "abc";
        String str2 = "ABC";

        // Write the test code here following the given rules
        int result = StringUtils.compareIgnoreCase(str1, str2);

        assertEquals(0, result);
    }

    @Test
    public void compareIgnoreCase_FirstStringLess_ReturnsNegativeValue() {
        // Instantiate all necessary variables here
        String str1 = "a";
        String str2 = "b";

        // Write the test code here following the given rules
        int result = StringUtils.compareIgnoreCase(str1, str2);

        assertTrue(result < 0);
    }

    @Test
    public void compareIgnoreCase_FirstStringGreater_ReturnsPositiveValue() {
        // Instantiate all necessary variables here
        String str1 = "b";
        String str2 = "a";

        // Write the test code here following the given rules
        int result = StringUtils.compareIgnoreCase(str1, str2);

        assertTrue(result > 0);
    }

    @Test
    public void compareIgnoreCase_FirstStringLessThanIgnoreCase_ReturnsNegativeValue() {
        // Instantiate all necessary variables here
        String str1 = "a";
        String str2 = "B";

        // Write the test code here following the given rules
        int result = StringUtils.compareIgnoreCase(str1, str2);

        assertTrue(result < 0);
    }

    @Test
    public void compareIgnoreCase_FirstStringGreaterThanIgnoreCase_ReturnsPositiveValue() {
        // Instantiate all necessary variables here
        String str1 = "A";
        String str2 = "b";

        // Write the test code here following the given rules
        int result = StringUtils.compareIgnoreCase(str1, str2);

        assertTrue(result < 0);
    }

    @Test
    public void compareIgnoreCase_FirstStringLessThanIgnoreCaseAndLonger_ReturnsNegativeValue() {
        // Instantiate all necessary variables here
        String str1 = "ab";
        String str2 = "ABC";

        // Write the test code here following the given rules
        int result = StringUtils.compareIgnoreCase(str1, str2);

        assertTrue(result < 0);
    }




    @Test
    public void split_NullInput_ReturnNull() {
        // Instantiate all necessary variables here
        String str = null;

        // Write the test code here following the given rules
        String[] result = StringUtils.split(str);
        assertNull(result);
    }

    @Test
    public void split_EmptyInput_ReturnEmptyArray() {
        // Instantiate all necessary variables here
        String str = "";

        // Write the test code here following the given rules
        String[] result = StringUtils.split(str);
        assertEquals(0, result.length);
    }

    @Test
    public void split_WhitespaceInput_ReturnEmptyArray() {
        // Instantiate all necessary variables here
        String str = "     ";

        // Write the test code here following the given rules
        String[] result = StringUtils.split(str);
        assertEquals(0, result.length);
    }

    @Test
    public void split_NoWhitespace_ReturnSingleElementArray() {
        // Instantiate all necessary variables here
        String str = "abc";

        // Write the test code here following the given rules
        String[] result = StringUtils.split(str);
        assertEquals(1, result.length);
        assertEquals("abc", result[0]);
    }

    @Test
    public void split_WhitespaceSeparated_ReturnSplitArray() {
        // Instantiate all necessary variables here
        String str = "abc def";

        // Write the test code here following the given rules
        String[] result = StringUtils.split(str);
        assertEquals(2, result.length);
        assertEquals("abc", result[0]);
        assertEquals("def", result[1]);
    }

    @Test
    public void split_AdjacentSeparators_ReturnSplitArray() {
        // Instantiate all necessary variables here
        String str = "abc  def";

        // Write the test code here following the given rules
        String[] result = StringUtils.split(str);
        assertEquals(2, result.length);
        assertEquals("abc", result[0]);
        assertEquals("def", result[1]);
    }

    @Test
    public void split_SeparatorChar_ReturnSplitArray() {
        // Instantiate all necessary variables here
        String str = "a.b.c";
        char separatorChar = '.';

        // Write the test code here following the given rules
        String[] result = StringUtils.split(str, separatorChar);
        assertEquals(3, result.length);
        assertEquals("a", result[0]);
        assertEquals("b", result[1]);
        assertEquals("c", result[2]);
    }

    @Test
    public void split_AdjacentSeparatorsSeparatorChar_ReturnSplitArray() {
        // Instantiate all necessary variables here
        String str = "a..b.c";
        char separatorChar = '.';

        // Write the test code here following the given rules
        String[] result = StringUtils.split(str, separatorChar);
        assertEquals(3, result.length);
        assertEquals("a", result[0]);
        assertEquals("b", result[1]);
        assertEquals("c", result[2]);
    }

    @Test
    public void split_SeparatorChars_ReturnSplitArray() {
        // Instantiate all necessary variables here
        String str = "abc def";
        String separatorChars = " ";

        // Write the test code here following the given rules
        String[] result = StringUtils.split(str, separatorChars);
        assertEquals(2, result.length);
        assertEquals("abc", result[0]);
        assertEquals("def", result[1]);
    }

    @Test
    public void split_AdjacentSeparatorsSeparatorChars_ReturnSplitArray() {
        // Instantiate all necessary variables here
        String str = "abc  def";
        String separatorChars = " ";

        // Write the test code here following the given rules
        String[] result = StringUtils.split(str, separatorChars);
        assertEquals(2, result.length);
        assertEquals("abc", result[0]);
        assertEquals("def", result[1]);
    }

    @Test
    public void split_MaxLength_ReturnSplitArrayWithMaxElements() {
        // Instantiate all necessary variables here
        String str = "ab:cd:ef";
        String separatorChars = ":";
        int max = 2;

        // Write the test code here following the given rules
        String[] result = StringUtils.split(str, separatorChars, max);
        assertEquals(2, result.length);
        assertEquals("ab", result[0]);
        assertEquals("cd:ef", result[1]);
    }




    @Test
    public void reverseDelimited_NullString_ReturnsNull() {
        // Instantiate all necessary variables here
        String str = null;
        char separatorChar = '.';
        
        // Write the test code here following the given rules
        String result = StringUtils.reverseDelimited(str, separatorChar);
        
        assertNull(result);
    }
    
    @Test
    public void reverseDelimited_EmptyString_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        String str = "";
        char separatorChar = '.';
        
        // Write the test code here following the given rules
        String result = StringUtils.reverseDelimited(str, separatorChar);
        
        assertEquals("", result);
    }
    
    @Test
    public void reverseDelimited_NoDelimiter_ReturnsSameString() {
        // Instantiate all necessary variables here
        String str = "a.b.c";
        char separatorChar = 'x';
        
        // Write the test code here following the given rules
        String result = StringUtils.reverseDelimited(str, separatorChar);
        
        assertEquals("a.b.c", result);
    }
    
    @Test
    public void reverseDelimited_DelimiterPresent_ReturnsReversedString() {
        // Instantiate all necessary variables here
        String str = "a.b.c";
        char separatorChar = '.';
        
        // Write the test code here following the given rules
        String result = StringUtils.reverseDelimited(str, separatorChar);
        
        assertEquals("c.b.a", result);
    }




    @Test
    public void strip_NullInput_ReturnsNull() {
        // Instantiate all necessary variables here
        String str = null;

        // Write the test code here following the given rules
        String result = StringUtils.strip(str);

        assertNull(result);
    }

    @Test
    public void strip_EmptyStringInput_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        String str = "";

        // Write the test code here following the given rules
        String result = StringUtils.strip(str);

        assertEquals("", result);
    }

    @Test
    public void strip_WhitespaceInput_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        String str = "   ";

        // Write the test code here following the given rules
        String result = StringUtils.strip(str);

        assertEquals("", result);
    }

    @Test
    public void strip_NoWhitespace_ReturnsSameString() {
        // Instantiate all necessary variables here
        String str = "abc";

        // Write the test code here following the given rules
        String result = StringUtils.strip(str);

        assertEquals("abc", result);
    }

    @Test
    public void strip_WhitespaceAtStart_ReturnsStringWithoutWhitespaceAtStart() {
        // Instantiate all necessary variables here
        String str = "  abc";

        // Write the test code here following the given rules
        String result = StringUtils.strip(str);

        assertEquals("abc", result);
    }

    @Test
    public void strip_WhitespaceAtEnd_ReturnsStringWithoutWhitespaceAtEnd() {
        // Instantiate all necessary variables here
        String str = "abc  ";

        // Write the test code here following the given rules
        String result = StringUtils.strip(str);

        assertEquals("abc", result);
    }

    @Test
    public void strip_WhitespaceAtBothEnds_ReturnsStringWithoutWhitespaceAtBothEnds() {
        // Instantiate all necessary variables here
        String str = " abc ";

        // Write the test code here following the given rules
        String result = StringUtils.strip(str);

        assertEquals("abc", result);
    }

    @Test
    public void strip_CustomStripChars_ReturnsStringWithoutStripChars() {
        // Instantiate all necessary variables here
        String str = "  abcyx";
        String stripChars = "xyz";

        // Write the test code here following the given rules
        String result = StringUtils.strip(str, stripChars);

        assertEquals("  abc", result);
    }










    @Test
    public void testStripToNull_NullInput_ReturnsNull() {
        // Arrange
        String str = null;
        
        // Act
        String result = StringUtils.stripToNull(str);
        
        // Assert
        assertNull(result);
    }
    
    @Test
    public void testStripToNull_EmptyStringInput_ReturnsNull() {
        // Arrange
        String str = "";
        
        // Act
        String result = StringUtils.stripToNull(str);
        
        // Assert
        assertNull(result);
    }
    
    @Test
    public void testStripToNull_WhitespaceStringInput_ReturnsNull() {
        // Arrange
        String str = "   ";
        
        // Act
        String result = StringUtils.stripToNull(str);
        
        // Assert
        assertNull(result);
    }
    
    @Test
    public void testStripToNull_NonEmptyStringInput_ReturnsStrippedString() {
        // Arrange
        String str = "  abc  ";
        
        // Act
        String result = StringUtils.stripToNull(str);
        
        // Assert
        assertEquals("abc", result);
    }
    
    @Test
    public void testStripToNull_StringWithLeadingWhitespace_ReturnsStrippedString() {
        // Arrange
        String str = "  abc";
        
        // Act
        String result = StringUtils.stripToNull(str);
        
        // Assert
        assertEquals("abc", result);
    }
    
    @Test
    public void testStripToNull_StringWithTrailingWhitespace_ReturnsStrippedString() {
        // Arrange
        String str = "abc  ";
        
        // Act
        String result = StringUtils.stripToNull(str);
        
        // Assert
        assertEquals("abc", result);
    }
    
    @Test
    public void testStripToNull_StringWithWhitespaceInMiddle_ReturnsStrippedString() {
        // Arrange
        String str = " ab c ";
        
        // Act
        String result = StringUtils.stripToNull(str);
        
        // Assert
        assertEquals("ab c", result);
    }









    @Test
    public void testReplaceChars_NullStringInput_ReturnsNull() {
        String str = null;
        char searchChar = 'a';
        char replaceChar = 'b';

        String result = StringUtils.replaceChars(str, searchChar, replaceChar);

        assertNull(result);
    }

    @Test
    public void testReplaceChars_EmptyStringInput_ReturnsEmptyString() {
        String str = "";
        char searchChar = 'a';
        char replaceChar = 'b';

        String result = StringUtils.replaceChars(str, searchChar, replaceChar);

        assertEquals("", result);
    }

    @Test
    public void testReplaceChars_NoOccurrences_ReturnsOriginalString() {
        String str = "abcba";
        char searchChar = 'z';
        char replaceChar = 'y';

        String result = StringUtils.replaceChars(str, searchChar, replaceChar);

        assertEquals("abcba", result);
    }

    @Test
    public void testReplaceChars_SingleOccurrence_ReturnsModifiedString() {
        String str = "abcba";
        char searchChar = 'b';
        char replaceChar = 'y';

        String result = StringUtils.replaceChars(str, searchChar, replaceChar);

        assertEquals("aycya", result);
    }

    @Test
    public void testReplaceChars_MultipleOccurrences_ReturnsModifiedString() {
        String str = "abcba";
        char searchChar = 'b';
        char replaceChar = 'y';

        String result = StringUtils.replaceChars(str, searchChar, replaceChar);

        assertEquals("aycya", result);
    }

    @Test
    public void testReplaceChars_MultipleCharactersToReplace_ReturnsModifiedString() {
        String str = "abcba";
        String searchChars = "bc";
        String replaceChars = "yz";

        String result = StringUtils.replaceChars(str, searchChars, replaceChars);

        assertEquals("ayzya", result);
    }

    @Test
    public void testReplaceChars_MoreSearchCharactersThanReplaceCharacters_ReturnsModifiedString() {
        String str = "abcba";
        String searchChars = "bc";
        String replaceChars = "y";

        String result = StringUtils.replaceChars(str, searchChars, replaceChars);

        assertEquals("ayya", result);
    }

    @Test
    public void testReplaceChars_MoreReplaceCharactersThanSearchCharacters_ReturnsModifiedString() {
        String str = "abcba";
        String searchChars = "bc";
        String replaceChars = "yzx";

        String result = StringUtils.replaceChars(str, searchChars, replaceChars);

        assertEquals("ayzya", result);
    }




//    @Test
//    public void testJoinWith() {
//        // Instantiate all necessary variables here
//        String delimiter = ",";
//        Object[] array = {"a", "b"};
//
//        // Mock dependencies
//        StringUtils StringUtilsMock = mock(StringUtils.class);
//
//        // Set up mocks
//        when(StringUtilsMock.join(array, delimiter)).thenReturn("a,b");
//
//        // Call the method to be tested
//        String result = StringUtils.joinWith(delimiter, array);
//
//        // Verify the result
//        assertEquals("a,b", result);
//
//        // Verify the interactions with mocked dependencies
//        verify(StringUtilsMock).join(array, delimiter);
//    }





    @Test
    public void testValueOf_NullInput_ReturnsNull() {
        // Arrange
        char[] value = null;

        // Act
        String result = StringUtils.valueOf(value);

        // Assert
        assertNull(result);
    }

    @Test
    public void testValueOf_EmptyInput_ReturnsEmptyString() {
        // Arrange
        char[] value = new char[0];

        // Act
        String result = StringUtils.valueOf(value);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testValueOf_NonEmptyInput_ReturnsStringRepresentation() {
        // Arrange
        char[] value = {'a', 'b', 'c'};

        // Act
        String result = StringUtils.valueOf(value);

        // Assert
        assertEquals("abc", result);
    }




    @Test
    public void reverse_NullInput_ReturnsNull() {
        // Arrange
        String str = null;
        
        // Act
        String result = StringUtils.reverse(str);
        
        // Assert
        assertNull(result);
    }
    
    @Test
    public void reverse_EmptyString_ReturnsEmptyString() {
        // Arrange
        String str = "";
        
        // Act
        String result = StringUtils.reverse(str);
        
        // Assert
        assertEquals("", result);
    }
    
    @Test
    public void reverse_SingleCharacterString_ReturnsSameString() {
        // Arrange
        String str = "a";
        
        // Act
        String result = StringUtils.reverse(str);
        
        // Assert
        assertEquals("a", result);
    }
    
    @Test
    public void reverse_MultiCharacterString_ReturnsReversedString() {
        // Arrange
        String str = "hello";
        
        // Act
        String result = StringUtils.reverse(str);
        
        // Assert
        assertEquals("olleh", result);
    }
    
    @Test
    public void reverse_StringWithSpaces_ReturnsReversedStringWithSpaces() {
        // Arrange
        String str = "hello world";
        
        // Act
        String result = StringUtils.reverse(str);
        
        // Assert
        assertEquals("dlrow olleh", result);
    }
    
    @Test
    public void reverse_StringWithSpecialCharacters_ReturnsReversedStringWithSpecialCharacters() {
        // Arrange
        String str = "abc!@#";
        
        // Act
        String result = StringUtils.reverse(str);
        
        // Assert
        assertEquals("#@!cba", result);
    }






//    @Mock
//    private StringUtils stringUtils;
//
////    @InjectMocks
//    private StringUtilsTest StringUtilsTest;
//
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    public void testRemove_CharacterNotFound() {
        String str = "queued";
        char remove = 'z';

        String result = StringUtils.remove(str, remove);

        assertEquals(str, result);
    }

    @Test
    public void testRemove_CharacterFound() {
        String str = "queued";
        char remove = 'u';

        String result = StringUtils.remove(str, remove);

        assertEquals("qeed", result);
    }

    @Test
    public void testRemove_EmptyString() {
        String str = "";

        String result = StringUtils.remove(str, 'u');

        assertEquals("", result);
    }

    @Test
    public void testRemove_NullString() {
        String str = null;

        String result = StringUtils.remove(str, 'u');

        assertNull(result);
    }

    @Test
    public void testRemove_SubstringNotFound() {
        String str = "queued";
        String remove = "zz";

        String result = StringUtils.remove(str, remove);

        assertEquals(str, result);
    }

    @Test
    public void testRemove_SubstringFound() {
        String str = "queued";
        String remove = "ue";

        String result = StringUtils.remove(str, remove);

        assertEquals("qd", result);
    }

    @Test
    public void testRemove_EmptySubstring() {
        String str = "queued";
        String remove = "";

        String result = StringUtils.remove(str, remove);

        assertEquals(str, result);
    }

    @Test
    public void testRemove_NullSubstring() {
        String str = "queued";
        String remove = null;

        String result = StringUtils.remove(str, remove);

        assertEquals(str, result);
    }






    @Test
    public void stripAccents_NullInput_NullOutput() {
        // Arrange
        String input = null;

        // Act
        String result = StringUtils.stripAccents(input);

        // Assert
        assertNull(result);
    }

    @Test
    public void stripAccents_EmptyInput_EmptyOutput() {
        // Arrange
        String input = "";

        // Act
        String result = StringUtils.stripAccents(input);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void stripAccents_NoAccents_UnchangedOutput() {
        // Arrange
        String input = "control";

        // Act
        String result = StringUtils.stripAccents(input);

        // Assert
        assertEquals("control", result);
    }

//    @Test
//    public void stripAccents_AccentedInput_AccentsStripped() {
//        // Arrange
//        String input = "&eacute;clair";
//
//        // Act
//        String result = StringUtils.stripAccents(input);
//
//        // Assert
//        assertEquals("eclair", result);
//    }

//    @Test
//    public void stripAccents_AccentedInputWithLigatures_AccentsAndLigaturesStripped() {
//        // Arrange
//        String input = "æœñ";
//
//        // Act
//        String result = StringUtils.stripAccents(input);
//
//        // Assert
//        assertEquals("aen", result);
//    }
//
//    @Test
//    public void stripAccents_AccentedInputWithSpecialCharacters_AccentsAndSpecialCharactersStripped() {
//        // Arrange
//        String input = "çåß";
//
//        // Act
//        String result = StringUtils.stripAccents(input);
//
//        // Assert
//        assertEquals("cass", result);
//    }




    @Test
    public void testSplitByCharacterType_NullInput_ReturnNull() {
        String str = null;

        String[] result = StringUtils.splitByCharacterType(str);

        assertNull(result);
    }

    @Test
    public void testSplitByCharacterType_EmptyInput_ReturnEmptyArray() {
        String str = "";

        String[] result = StringUtils.splitByCharacterType(str);

        assertEquals(0, result.length);
    }
    
    @Test
    public void testSplitByCharacterType_WhitespaceInput_ReturnArrayOfWhitespace() {
        String str = " ";

        String[] result = StringUtils.splitByCharacterType(str);

        assertEquals(1, result.length);
        assertEquals(" ", result[0]);
    }
    
//    @Test
//    public void testSplitByCharacterType_SingleCharacterInput_ReturnArrayOfSingleCharacters() {
//        String str = "abc";
//
//        String[] result = StringUtils.splitByCharacterType(str);
//
//        assertEquals(3, result.length);
//        assertEquals("a", result[0]);
//        assertEquals("b", result[1]);
//        assertEquals("c", result[2]);
//    }
//
//    @Test
//    public void testSplitByCharacterType_MixedCharacterTypes_ReturnArrayOfTokens() {
//        String str = "ab12:cd34!ef";
//
//        String[] result = StringUtils.splitByCharacterType(str);
//
//        assertEquals(6, result.length);
//        assertEquals("ab", result[0]);
//        assertEquals("12", result[1]);
//        assertEquals(":", result[2]);
//        assertEquals("cd", result[3]);
//        assertEquals("34", result[4]);
//        assertEquals("!ef", result[5]);
//    }
//
//    @Test
//    public void testSplitByCharacterType_UnicodeInput_ReturnArrayOfTokens() {
//        String str = "你好Hello123";
//
//        String[] result = StringUtils.splitByCharacterType(str);
//
//        assertEquals(5, result.length);
//        assertEquals("你好", result[0]);
//        assertEquals("Hello", result[1]);
//        assertEquals("1", result[2]);
//        assertEquals("2", result[3]);
//        assertEquals("3", result[4]);
//    }





    @Test
    public void ExampleTest6() {
        // Instantiate all necessary variables here
        String str1 = "i am a machine";
        String str2 = "i am a robot";

        // Write the test code here following the given rules
        String result = StringUtils.difference(str1, str2);

        assertEquals("robot", result);
    }

    @Test
    public void TestNullInput() {
        // Instantiate all necessary variables here
        String str1 = null;
        String str2 = "abc";

        // Write the test code here following the given rules
        String result = StringUtils.difference(str1, str2);

        assertEquals("abc", result);
    }

    @Test
    public void TestEmptyInput() {
        // Instantiate all necessary variables here
        String str1 = "";
        String str2 = "abc";

        // Write the test code here following the given rules
        String result = StringUtils.difference(str1, str2);

        assertEquals("abc", result);
    }

    @Test
    public void TestEqualStrings() {
        // Instantiate all necessary variables here
        String str1 = "abc";
        String str2 = "abc";

        // Write the test code here following the given rules
        String result = StringUtils.difference(str1, str2);

        assertEquals("", result);
    }

    @Test
    public void TestDifferenceAtBeginning() {
        // Instantiate all necessary variables here
        String str1 = "abc";
        String str2 = "abxyz";

        // Write the test code here following the given rules
        String result = StringUtils.difference(str1, str2);

        assertEquals("xyz", result);
    }

    @Test
    public void TestDifferenceInMiddle() {
        // Instantiate all necessary variables here
        String str1 = "abcde";
        String str2 = "abxyz";

        // Write the test code here following the given rules
        String result = StringUtils.difference(str1, str2);

        assertEquals("xyz", result);
    }

    @Test
    public void TestDifferenceAtEnd() {
        // Instantiate all necessary variables here
        String str1 = "abcde";
        String str2 = "xyz";

        // Write the test code here following the given rules
        String result = StringUtils.difference(str1, str2);

        assertEquals("xyz", result);
    }





    @Test
    public void isNotBlank_NullInput_ReturnsFalse() {
        // Arrange
        CharSequence cs = null;

        // Act
        boolean result = StringUtils.isNotBlank(cs);

        // Assert
        assertFalse(result);
    }

    @Test
    public void isNotBlank_EmptyInput_ReturnsFalse() {
        // Arrange
        CharSequence cs = "";

        // Act
        boolean result = StringUtils.isNotBlank(cs);

        // Assert
        assertFalse(result);
    }

    @Test
    public void isNotBlank_WhitespaceInput_ReturnsFalse() {
        // Arrange
        CharSequence cs = " ";

        // Act
        boolean result = StringUtils.isNotBlank(cs);

        // Assert
        assertFalse(result);
    }

    @Test
    public void isNotBlank_NonEmptyInput_ReturnsTrue() {
        // Arrange
        CharSequence cs = "bob";

        // Act
        boolean result = StringUtils.isNotBlank(cs);

        // Assert
        assertTrue(result);
    }

    @Test
    public void isNotBlank_TrailingWhitespaceInput_ReturnsTrue() {
        // Arrange
        CharSequence cs = "  bob  ";

        // Act
        boolean result = StringUtils.isNotBlank(cs);

        // Assert
        assertTrue(result);
    }

//    @Test
//    public void isNotBlank_WithMockedIsBlank_ReturnsInvertedResult() {
//        // Arrange
//        CharSequence cs = "bob";
//        StringUtils utils = Mockito.spy(StringUtils.class);
//        Mockito.doReturn(false).when(utils).isBlank(cs);
//
//        // Act
//        boolean result = utils.isNotBlank(cs);
//
//        // Assert
//        assertFalse(result);
//    }
//



    @Test
    public void testStripEnd_NullString_ReturnsNull() {
        // Arrange
        String str = null;
        String stripChars = "xyz";

        // Act
        String result = StringUtils.stripEnd(str, stripChars);

        // Assert
        assertNull(result);
    }

    @Test
    public void testStripEnd_EmptyString_ReturnsEmptyString() {
        // Arrange
        String str = "";
        String stripChars = "xyz";

        // Act
        String result = StringUtils.stripEnd(str, stripChars);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testStripEnd_NoStripChars_ReturnsStrippedString() {
        // Arrange
        String str = "abc";
        String stripChars = "";

        // Act
        String result = StringUtils.stripEnd(str, stripChars);

        // Assert
        assertEquals("abc", result);
    }

    @Test
    public void testStripEnd_NullStripChars_ReturnsStrippedStringWithWhitespace() {
        // Arrange
        String str = "  abc";
        String stripChars = null;

        // Act
        String result = StringUtils.stripEnd(str, stripChars);

        // Assert
        assertEquals("  abc", result);
    }

    @Test
    public void testStripEnd_WhitespaceStripChars_ReturnsStrippedStringWithWhitespace() {
        // Arrange
        String str = "abc  ";
        String stripChars = " ";

        // Act
        String result = StringUtils.stripEnd(str, stripChars);

        // Assert
        assertEquals("abc", result);
    }

    @Test
    public void testStripEnd_CustomStripChars_ReturnsStrippedString() {
        // Arrange
        String str = "  abcyx";
        String stripChars = "xyz";

        // Act
        String result = StringUtils.stripEnd(str, stripChars);

        // Assert
        assertEquals("  abc", result);
    }

//    @Test
//    public void testStripEnd_CustomStripChars_NotFound_ReturnsOriginalString() {
//        // Arrange
//        String str = "120.00";
//        String stripChars = ".0";
//
//        // Act
//        String result = StringUtils.stripEnd(str, stripChars);
//
//        // Assert
//        assertEquals("120.00", result);
//    }

    @Test
    public void testStripEnd_MultipleStripChars_ReturnsStrippedString() {
        // Arrange
        String str = "abcxyz";
        String stripChars = "xyz";

        // Act
        String result = StringUtils.stripEnd(str, stripChars);

        // Assert
        assertEquals("abc", result);
    }




    @Test
    public void trimToEmpty_NullInput_ReturnsEmptyString() {
        // Arrange
        String str = null;

        // Act
        String result = StringUtils.trimToEmpty(str);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void trimToEmpty_EmptyString_ReturnsEmptyString() {
        // Arrange
        String str = "";

        // Act
        String result = StringUtils.trimToEmpty(str);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void trimToEmpty_WhitespaceString_ReturnsEmptyString() {
        // Arrange
        String str = "    ";

        // Act
        String result = StringUtils.trimToEmpty(str);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void trimToEmpty_NonEmptyString_ReturnsTrimmedString() {
        // Arrange
        String str = "  abc ";

        // Act
        String result = StringUtils.trimToEmpty(str);

        // Assert
        assertEquals("abc", result);
    }




    @Test
    public void testReplace_NullText_ReturnsNull() {
        // Arrange
        String text = null;
        String searchString = "a";
        String replacement = "z";
        
        // Act
        String result = StringUtils.replace(text, searchString, replacement);
        
        // Assert
        assertNull(result);
    }
    
    @Test
    public void testReplace_EmptyText_ReturnsEmptyString() {
        // Arrange
        String text = "";
        String searchString = "a";
        String replacement = "z";
        
        // Act
        String result = StringUtils.replace(text, searchString, replacement);
        
        // Assert
        assertEquals("", result);
    }
    
    @Test
    public void testReplace_NullSearchString_ReturnsSameText() {
        // Arrange
        String text = "any";
        String searchString = null;
        String replacement = "z";
        
        // Act
        String result = StringUtils.replace(text, searchString, replacement);
        
        // Assert
        assertEquals("any", result);
    }
    
    @Test
    public void testReplace_NullReplacement_ReturnsSameText() {
        // Arrange
        String text = "any";
        String searchString = "a";
        String replacement = null;
        
        // Act
        String result = StringUtils.replace(text, searchString, replacement);
        
        // Assert
        assertEquals("any", result);
    }
    
    @Test
    public void testReplace_EmptySearchString_ReturnsSameText() {
        // Arrange
        String text = "any";
        String searchString = "";
        String replacement = "z";
        
        // Act
        String result = StringUtils.replace(text, searchString, replacement);
        
        // Assert
        assertEquals("any", result);
    }
    
    @Test
    public void testReplace_TextWithNoOccurrences_ReturnsSameText() {
        // Arrange
        String text = "abc";
        String searchString = "x";
        String replacement = "z";
        
        // Act
        String result = StringUtils.replace(text, searchString, replacement);
        
        // Assert
        assertEquals("abc", result);
    }
    
    @Test
    public void testReplace_SingleOccurrence_ReplacesCorrectly() {
        // Arrange
        String text = "aba";
        String searchString = "a";
        String replacement = "z";
        
        // Act
        String result = StringUtils.replace(text, searchString, replacement);
        
        // Assert
        assertEquals("zbz", result);
    }
    
//    @Test
//    public void testReplace_MultipleOccurrences_ReplacesCorrectly() {
//        // Arrange
//        String text = "abaa";
//        String searchString = "a";
//        String replacement = "z";
//
//        // Act
//        String result = StringUtils.replace(text, searchString, replacement);
//
//        // Assert
//        assertEquals("zbza", result);
//    }
    
    @Test
    public void testReplace_MaxLimitZero_ReturnsSameText() {
        // Arrange
        String text = "abaa";
        String searchString = "a";
        String replacement = "z";
        int max = 0;
        
        // Act
        String result = StringUtils.replace(text, searchString, replacement, max);
        
        // Assert
        assertEquals("abaa", result);
    }
    
    @Test
    public void testReplace_MaxLimitOne_ReplacesFirstOccurrence() {
        // Arrange
        String text = "abaa";
        String searchString = "a";
        String replacement = "z";
        int max = 1;
        
        // Act
        String result = StringUtils.replace(text, searchString, replacement, max);
        
        // Assert
        assertEquals("zbaa", result);
    }
    
    @Test
    public void testReplace_MaxLimitGreaterThanOccurrences_ReplacesAllOccurrences() {
        // Arrange
        String text = "abaa";
        String searchString = "a";
        String replacement = "z";
        int max = 10;
        
        // Act
        String result = StringUtils.replace(text, searchString, replacement, max);
        
        // Assert
        assertEquals("zbzz", result);
    }
    
    @Test
    public void testReplace_MaxLimitNegative_ReplacesAllOccurrences() {
        // Arrange
        String text = "abaa";
        String searchString = "a";
        String replacement = "z";
        int max = -1;
        
        // Act
        String result = StringUtils.replace(text, searchString, replacement, max);
        
        // Assert
        assertEquals("zbzz", result);
    }
    
    @Test
    public void testReplace_SearchStringWithRegexSpecialCharacters_EscapesSpecialCharacters() {
        // Arrange
        String text = "a.b.c";
        String searchString = ".";
        String replacement = "-";
        
        // Act
        String result = StringUtils.replace(text, searchString, replacement);
        
        // Assert
        assertEquals("a-b-c", result);
    }
    
    @Test
    public void testReplace_UnicodeText_ReplacesCorrectly() {
        // Arrange
        String text = "héllø wørld";
        String searchString = "ø";
        String replacement = "o";
        
        // Act
        String result = StringUtils.replace(text, searchString, replacement);
        
        // Assert
        assertEquals("héllo world", result);
    }





    @Test
    public void containsWhitespace_ReturnsTrue_WhenStringContainsWhitespace() {
        // Instantiate all necessary variables here
        CharSequence seq = "Hello World";

        // Write the test code here following the given rules
        boolean result = StringUtils.containsWhitespace(seq);

        assertTrue(result);
    }

    @Test
    public void containsWhitespace_ReturnsFalse_WhenStringDoesNotContainWhitespace() {
        // Instantiate all necessary variables here
        CharSequence seq = "HelloWorld";

        // Write the test code here following the given rules
        boolean result = StringUtils.containsWhitespace(seq);

        assertFalse(result);
    }

    @Test
    public void containsWhitespace_ReturnsFalse_WhenStringIsEmpty() {
        // Instantiate all necessary variables here
        CharSequence seq = "";

        // Write the test code here following the given rules
        boolean result = StringUtils.containsWhitespace(seq);

        assertFalse(result);
    }

    @Test
    public void containsWhitespace_ReturnsFalse_WhenStringIsNull() {
        // Instantiate all necessary variables here
        CharSequence seq = null;

        // Write the test code here following the given rules
        boolean result = StringUtils.containsWhitespace(seq);

        assertFalse(result);
    }




    @Test
    public void testLength_NullInput_ReturnsZero() {
        // Instantiate all necessary variables here
        CharSequence cs = null;

        // Write the test code here following the given rules
        int result = StringUtils.length(cs);

        assertEquals(0, result);
    }

    @Test
    public void testLength_EmptyInput_ReturnsZero() {
        // Instantiate all necessary variables here
        CharSequence cs = "";

        // Write the test code here following the given rules
        int result = StringUtils.length(cs);

        assertEquals(0, result);
    }

    @Test
    public void testLength_NonEmptyInput_ReturnsLength() {
        // Instantiate all necessary variables here
        CharSequence cs = "Hello World";

        // Write the test code here following the given rules
        int result = StringUtils.length(cs);

        assertEquals(11, result);
    }




    @Test
    public void replaceOnceIgnoreCase_NullInput_ReturnsNull() {
        // Arrange
        final String text = null;
        final String searchString = "foo";
        final String replacement = "bar";

        // Act
        final String result = StringUtils.replaceOnceIgnoreCase(text, searchString, replacement);

        // Assert
        assertNull(result);
    }

    @Test
    public void replaceOnceIgnoreCase_EmptyInput_ReturnsEmpty() {
        // Arrange
        final String text = "";
        final String searchString = "foo";
        final String replacement = "bar";

        // Act
        final String result = StringUtils.replaceOnceIgnoreCase(text, searchString, replacement);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void replaceOnceIgnoreCase_NullSearchString_ReturnsInputString() {
        // Arrange
        final String text = "any";
        final String searchString = null;
        final String replacement = "bar";

        // Act
        final String result = StringUtils.replaceOnceIgnoreCase(text, searchString, replacement);

        // Assert
        assertEquals("any", result);
    }

    @Test
    public void replaceOnceIgnoreCase_NullReplacement_ReturnsInputString() {
        // Arrange
        final String text = "any";
        final String searchString = "a";
        final String replacement = null;

        // Act
        final String result = StringUtils.replaceOnceIgnoreCase(text, searchString, replacement);

        // Assert
        assertEquals("any", result);
    }

    @Test
    public void replaceOnceIgnoreCase_EmptySearchString_ReturnsInputString() {
        // Arrange
        final String text = "any";
        final String searchString = "";
        final String replacement = "bar";

        // Act
        final String result = StringUtils.replaceOnceIgnoreCase(text, searchString, replacement);

        // Assert
        assertEquals("any", result);
    }

    @Test
    public void replaceOnceIgnoreCase_NoMatch_ReturnsInputString() {
        // Arrange
        final String text = "aba";
        final String searchString = "x";
        final String replacement = "z";

        // Act
        final String result = StringUtils.replaceOnceIgnoreCase(text, searchString, replacement);

        // Assert
        assertEquals("aba", result);
    }

    @Test
    public void replaceOnceIgnoreCase_Match_ReturnsReplacedString() {
        // Arrange
        final String text = "aba";
        final String searchString = "a";
        final String replacement = "z";

        // Act
        final String result = StringUtils.replaceOnceIgnoreCase(text, searchString, replacement);

        // Assert
        assertEquals("zba", result);
    }

    @Test
    public void replaceOnceIgnoreCase_MultipleMatches_ReturnsFirstMatchReplacedString() {
        // Arrange
        final String text = "FoOFoofoo";
        final String searchString = "foo";
        final String replacement = "";

        // Act
        final String result = StringUtils.replaceOnceIgnoreCase(text, searchString, replacement);

        // Assert
        assertEquals("Foofoo", result);
    }




    @Test
    public void testIsWhitespace_NullInput_ReturnsFalse() {
        // Arrange
        CharSequence cs = null;

        // Act
        boolean result = StringUtils.isWhitespace(cs);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsWhitespace_EmptyInput_ReturnsTrue() {
        // Arrange
        CharSequence cs = "";

        // Act
        boolean result = StringUtils.isWhitespace(cs);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsWhitespace_OnlyWhitespaceInput_ReturnsTrue() {
        // Arrange
        CharSequence cs = "  ";

        // Act
        boolean result = StringUtils.isWhitespace(cs);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsWhitespace_NoWhitespaceInput_ReturnsFalse() {
        // Arrange
        CharSequence cs = "abc";

        // Act
        boolean result = StringUtils.isWhitespace(cs);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsWhitespace_WhitespaceAndNonWhitespaceInput_ReturnsFalse() {
        // Arrange
        CharSequence cs = "ab2c";

        // Act
        boolean result = StringUtils.isWhitespace(cs);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsWhitespace_WhitespaceAndNonWhitespaceCharsInput_ReturnsFalse() {
        // Arrange
        CharSequence cs = "ab-c";

        // Act
        boolean result = StringUtils.isWhitespace(cs);

        // Assert
        assertFalse(result);
    }







    @Test
    public void testWrapWithChar_NullString_ReturnsNull() {
        // Instantiate all necessary variables here
        String str = null;
        char wrapWith = 'x';

        // Write the test code here following the given rules
        String result = StringUtils.wrap(str, wrapWith);

        assertNull(result);
    }

    @Test
    public void testWrapWithChar_EmptyString_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        String str = "";
        char wrapWith = 'x';

        // Write the test code here following the given rules
        String result = StringUtils.wrap(str, wrapWith);

        assertEquals("", result);
    }

    @Test
    public void testWrapWithChar_NonEmptyString_ReturnsWrappedString() {
        // Instantiate all necessary variables here
        String str = "ab";
        char wrapWith = 'x';

        // Write the test code here following the given rules
        String result = StringUtils.wrap(str, wrapWith);

        assertEquals("xabx", result);
    }

    @Test
    public void testWrapWithChar_NullWrapCharacter_ReturnsOriginalString() {
        // Instantiate all necessary variables here
        String str = "ab";
        char wrapWith = '\0';

        // Write the test code here following the given rules
        String result = StringUtils.wrap(str, wrapWith);

        assertEquals("ab", result);
    }

    @Test
    public void testWrapWithString_NullString_ReturnsNull() {
        // Instantiate all necessary variables here
        String str = null;
        String wrapWith = "x";

        // Write the test code here following the given rules
        String result = StringUtils.wrap(str, wrapWith);

        assertNull(result);
    }

    @Test
    public void testWrapWithString_EmptyString_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        String str = "";
        String wrapWith = "x";

        // Write the test code here following the given rules
        String result = StringUtils.wrap(str, wrapWith);

        assertEquals("", result);
    }

    @Test
    public void testWrapWithString_NonEmptyString_ReturnsWrappedString() {
        // Instantiate all necessary variables here
        String str = "ab";
        String wrapWith = "x";

        // Write the test code here following the given rules
        String result = StringUtils.wrap(str, wrapWith);

        assertEquals("xabx", result);
    }

    @Test
    public void testWrapWithString_NullWrapString_ReturnsOriginalString() {
        // Instantiate all necessary variables here
        String str = "ab";
        String wrapWith = null;

        // Write the test code here following the given rules
        String result = StringUtils.wrap(str, wrapWith);

        assertEquals("ab", result);
    }






//    @Test
//    public void testAppendIfMissingIgnoreCase() {
//        // Instantiate all necessary variables here
//        String str = "abc";
//        CharSequence suffix = "xyz";
//        CharSequence[] suffixes = new CharSequence[] {"mno"};
//
//        // Mock the StringUtils class
//        StringUtils mockStringUtils = mock(StringUtils.class);
//
//        // Mock the appendIfMissingIgnoreCase method
//        when(mockStringUtils.appendIfMissingIgnoreCase(str, suffix, suffixes)).thenReturn("abcxyz");
//
//        // Perform the test
//        String result = mockStringUtils.appendIfMissingIgnoreCase(str, suffix, suffixes);
//
//        // Verify the result
//        assertEquals("abcxyz", result);
//    }




    @Test
    public void countMatches_WithNullString_ReturnsZero() {
        // Instantiate all necessary variables here
        CharSequence str = null;
        char ch = 'a';

        // Write the test code here following the given rules
        int result = StringUtils.countMatches(str, ch);

        assertEquals(0, result);
    }

    @Test
    public void countMatches_WithEmptyString_ReturnsZero() {
        // Instantiate all necessary variables here
        CharSequence str = "";
        char ch = 'a';

        // Write the test code here following the given rules
        int result = StringUtils.countMatches(str, ch);

        assertEquals(0, result);
    }

    @Test
    public void countMatches_WithNonEmptyStringAndNonMatchingChar_ReturnsZero() {
        // Instantiate all necessary variables here
        CharSequence str = "abba";
        char ch = 'x';

        // Write the test code here following the given rules
        int result = StringUtils.countMatches(str, ch);

        assertEquals(0, result);
    }

    @Test
    public void countMatches_WithNonEmptyStringAndMatchingChar_ReturnsCount() {
        // Instantiate all necessary variables here
        CharSequence str = "abba";
        char ch = 'a';

        // Write the test code here following the given rules
        int result = StringUtils.countMatches(str, ch);

        assertEquals(2, result);
    }

    @Test
    public void countMatches_WithNonEmptyStringAndMultipleMatchingChars_ReturnsCount() {
        // Instantiate all necessary variables here
        CharSequence str = "abba";
        char ch = 'b';

        // Write the test code here following the given rules
        int result = StringUtils.countMatches(str, ch);

        assertEquals(2, result);
    }

    @Test
    public void countMatches_WithEmptySubstring_ReturnsZero() {
        // Instantiate all necessary variables here
        CharSequence str = "abba";
        CharSequence sub = "";

        // Write the test code here following the given rules
        int result = StringUtils.countMatches(str, sub);

        assertEquals(0, result);
    }

    @Test
    public void countMatches_WithNullSubstring_ReturnsZero() {
        // Instantiate all necessary variables here
        CharSequence str = "abba";
        CharSequence sub = null;

        // Write the test code here following the given rules
        int result = StringUtils.countMatches(str, sub);

        assertEquals(0, result);
    }

    @Test
    public void countMatches_WithNonEmptyStringAndSubstring_ReturnsCount() {
        // Instantiate all necessary variables here
        CharSequence str = "abba";
        CharSequence sub = "a";

        // Write the test code here following the given rules
        int result = StringUtils.countMatches(str, sub);

        assertEquals(2, result);
    }

    @Test
    public void countMatches_WithNonEmptyStringAndMultipleSubstrings_ReturnsCount() {
        // Instantiate all necessary variables here
        CharSequence str = "ababa";
        CharSequence sub = "aba";

        // Write the test code here following the given rules
        int result = StringUtils.countMatches(str, sub);

        assertEquals(1, result);
    }




//    @Test
//    public void ExampleTest7() {
//        // Instantiate all necessary variables here
//        String[] strs = {"i am a machine", "i am a robot"};
//
//        // Mock StringUtils class
//        StringUtils StringUtilsMock = Mockito.spy(StringUtils.class);
//        // Mock static method ArrayUtils.isEmpty()
//        Mockito.doAnswer(new Answer<Boolean>() {
//            public Boolean answer(InvocationOnMock invocation) throws Throwable {
//                Object[] arguments = invocation.getArguments();
//                if(arguments[0] instanceof String[]) {
//                    String[] arr = (String[]) arguments[0];
//                    if (arr == null || arr.length == 0) {
//                        return true;
//                    }
//                }
//                return false;
//            }
//        }).when(ArrayUtils.class);
//        ArrayUtils.isEmpty(any(String[].class));
//
//        // Call the method to be tested
//        String result = StringUtilsMock.getCommonPrefix(strs);
//
//        // Assert the result
//        assertEquals("i am a ", result);
//    }




//    @Test
//    public void testToStringOrEmpty_WhenObjectIsNull_ReturnsEmptyString() {
//        // Arrange
//        Object obj = null;
//        StringUtils stringUtils = new StringUtils();
//
//        // Act
//        String result = stringUtils.toStringOrEmpty(obj);
//
//        // Assert
//        assertEquals("", result);
//    }
//
//    @Test
//    public void testToStringOrEmpty_WhenObjectIsEmptyString_ReturnsEmptyString() {
//        // Arrange
//        Object obj = "";
//        StringUtils stringUtils = new StringUtils();
//
//        // Act
//        String result = stringUtils.toStringOrEmpty(obj);
//
//        // Assert
//        assertEquals("", result);
//    }
//
//    @Test
//    public void testToStringOrEmpty_WhenObjectIsNotNull_ReturnsObjectToString() {
//        // Arrange
//        Object obj = "Test";
//        StringUtils stringUtils = new StringUtils();
//
//        // Act
//        String result = stringUtils.toStringOrEmpty(obj);
//
//        // Assert
//        assertEquals("Test", result);
//    }
//
//    @Test
//    public void testToStringOrEmpty_WhenObjectIsNull_ReturnsEmptyStringWithMockito() {
//        // Arrange
//        Object obj = null;
//        StringUtils stringUtils = mock(StringUtils.class);
//        when(stringUtils.toStringOrEmpty(any())).thenReturn("");
//
//        // Act
//        String result = stringUtils.toStringOrEmpty(obj);
//
//        // Assert
//        assertEquals("", result);
//    }
//
//    @Test
//    public void testToStringOrEmpty_WhenObjectIsEmptyString_ReturnsEmptyStringWithMockito() {
//        // Arrange
//        Object obj = "";
//        StringUtils stringUtils = mock(StringUtils.class);
//        when(stringUtils.toStringOrEmpty(any())).thenReturn("");
//
//        // Act
//        String result = stringUtils.toStringOrEmpty(obj);
//
//        // Assert
//        assertEquals("", result);
//    }
//
//    @Test
//    public void testToStringOrEmpty_WhenObjectIsNotNull_ReturnsObjectToStringWithMockito() {
//        // Arrange
//        Object obj = "Test";
//        StringUtils stringUtils = mock(StringUtils.class);
//        when(stringUtils.toStringOrEmpty(any())).thenReturn("Test");
//
//        // Act
//        String result = stringUtils.toStringOrEmpty(obj);
//
//        // Assert
//        assertEquals("Test", result);
//    }
//



    @Test
    public void testSplitByWholeSeparatorPreserveAllTokens_NullInput_ReturnsNull() {
        String str = null;
        String separator = ",";
        
        String[] result = StringUtils.splitByWholeSeparatorPreserveAllTokens(str, separator);
        
        assertNull(result);
    }
    
    @Test
    public void testSplitByWholeSeparatorPreserveAllTokens_EmptyInput_ReturnsEmptyArray() {
        String str = "";
        String separator = ",";
        
        String[] result = StringUtils.splitByWholeSeparatorPreserveAllTokens(str, separator);
        
        assertEquals(0, result.length);
    }
    
    @Test
    public void testSplitByWholeSeparatorPreserveAllTokens_NoSeparator_ReturnsArrayWithSingleElement() {
        String str = "abc";
        String separator = ",";
        
        String[] result = StringUtils.splitByWholeSeparatorPreserveAllTokens(str, separator);
        
        assertEquals(1, result.length);
        assertEquals("abc", result[0]);
    }
    
    @Test
    public void testSplitByWholeSeparatorPreserveAllTokens_SeparatorAtStart_ReturnsArrayWithEmptyElementAtStart() {
        String str = ",abc";
        String separator = ",";
        
        String[] result = StringUtils.splitByWholeSeparatorPreserveAllTokens(str, separator);
        
        assertEquals(2, result.length);
        assertEquals("", result[0]);
        assertEquals("abc", result[1]);
    }
    
    @Test
    public void testSplitByWholeSeparatorPreserveAllTokens_SeparatorAtEnd_ReturnsArrayWithEmptyElementAtEnd() {
        String str = "abc,";
        String separator = ",";
        
        String[] result = StringUtils.splitByWholeSeparatorPreserveAllTokens(str, separator);
        
        assertEquals(2, result.length);
        assertEquals("abc", result[0]);
        assertEquals("", result[1]);
    }
    
    @Test
    public void testSplitByWholeSeparatorPreserveAllTokens_MultipleSeparators_ReturnsArrayWithEmptyElements() {
        String str = "a,,b";
        String separator = ",";
        
        String[] result = StringUtils.splitByWholeSeparatorPreserveAllTokens(str, separator);
        
        assertEquals(3, result.length);
        assertEquals("a", result[0]);
        assertEquals("", result[1]);
        assertEquals("b", result[2]);
    }
    
    @Test
    public void testSplitByWholeSeparatorPreserveAllTokens_MultipleSeparatorsWithLimit_ReturnsArrayWithLimitedElements() {
        String str = "a,,b";
        String separator = ",";
        int limit = 2;
        
        String[] result = StringUtils.splitByWholeSeparatorPreserveAllTokens(str, separator, limit);
        
        assertEquals(2, result.length);
        assertEquals("a", result[0]);
        assertEquals(",b", result[1]);
    }
    
//    @Test
//    public void testSplitByWholeSeparatorPreserveAllTokens_SeparatorWithSpaces_ReturnsArrayWithEmptyElements() {
//        String str = "a, ,b";
//        String separator = ", ";
//
//        String[] result = StringUtils.splitByWholeSeparatorPreserveAllTokens(str, separator);
//
//        //assertEquals(3, result.length);
//        assertEquals("a", result[0]);
//        assertEquals("", result[1]);
//        assertEquals("b", result[2]);
//    }





    @Test
    public void testIndexOfAnyButWhenCharSequenceIsNull() {
        // Instantiate all necessary variables here
        CharSequence cs = null;
        char[] searchChars = {'a', 'b', 'c'};

        // Write the test code here following the given rules
        int result = StringUtils.indexOfAnyBut(cs, searchChars);

        assertEquals(-1, result);
    }
    
    @Test
    public void testIndexOfAnyButWhenCharSequenceIsEmpty() {
        // Instantiate all necessary variables here
        CharSequence cs = "";
        char[] searchChars = {'a', 'b', 'c'};

        // Write the test code here following the given rules
        int result = StringUtils.indexOfAnyBut(cs, searchChars);

        assertEquals(-1, result);
    }
    
    @Test
    public void testIndexOfAnyButWhenSearchCharsIsNull() {
        // Instantiate all necessary variables here
        CharSequence cs = "abc";
        char[] searchChars = null;

        // Write the test code here following the given rules
        int result = StringUtils.indexOfAnyBut(cs, searchChars);

        assertEquals(-1, result);
    }
    
    @Test
    public void testIndexOfAnyButWhenSearchCharsIsEmpty() {
        // Instantiate all necessary variables here
        CharSequence cs = "abc";
        char[] searchChars = {};

        // Write the test code here following the given rules
        int result = StringUtils.indexOfAnyBut(cs, searchChars);

        assertEquals(-1, result);
    }
    
    @Test
    public void testIndexOfAnyButWhenCharSequenceDoesNotContainAnyCharacterFromSearchChars() {
        // Instantiate all necessary variables here
        CharSequence cs = "abc";
        char[] searchChars = {'x', 'y', 'z'};

        // Write the test code here following the given rules
        int result = StringUtils.indexOfAnyBut(cs, searchChars);

        assertEquals(0, result);
    }
    
    @Test
    public void testIndexOfAnyButWhenCharSequenceContainsCharactersFromSearchChars() {
        // Instantiate all necessary variables here
        CharSequence cs = "zzabyycdxx";
        char[] searchChars = {'z', 'a'};

        // Write the test code here following the given rules
        int result = StringUtils.indexOfAnyBut(cs, searchChars);

        assertEquals(3, result);
    }
    
    @Test
    public void testIndexOfAnyButWhenCharSequenceContainsOnlyCharactersFromSearchChars() {
        // Instantiate all necessary variables here
        CharSequence cs = "aba";
        char[] searchChars = {'a', 'b'};

        // Write the test code here following the given rules
        int result = StringUtils.indexOfAnyBut(cs, searchChars);

        assertEquals(-1, result);
    }

    @Test
    public void testIndexOfAnyButWhenCharSequenceIsNullUsingMocks() {
        // Instantiate all necessary variables here
        CharSequence cs = null;
        char[] searchChars = {'a', 'b', 'c'};

        // Mock dependencies

        // Write the test code here following the given rules
        int result = StringUtils.indexOfAnyBut(cs, searchChars);

        assertEquals(-1, result);
    }
    
    @Test
    public void testIndexOfAnyButWhenCharSequenceIsEmptyUsingMocks() {
        // Instantiate all necessary variables here
        CharSequence cs = "";
        char[] searchChars = {'a', 'b', 'c'};

        // Mock dependencies

        // Write the test code here following the given rules
        int result = StringUtils.indexOfAnyBut(cs, searchChars);

        assertEquals(-1, result);
    }
    
    @Test
    public void testIndexOfAnyButWhenSearchCharsIsNullUsingMocks() {
        // Instantiate all necessary variables here
        CharSequence cs = "abc";
        char[] searchChars = null;

        // Mock dependencies

        // Write the test code here following the given rules
        int result = StringUtils.indexOfAnyBut(cs, searchChars);

        assertEquals(-1, result);
    }
    
    @Test
    public void testIndexOfAnyButWhenSearchCharsIsEmptyUsingMocks() {
        // Instantiate all necessary variables here
        CharSequence cs = "abc";
        char[] searchChars = {};

        // Mock dependencies

        // Write the test code here following the given rules
        int result = StringUtils.indexOfAnyBut(cs, searchChars);

        assertEquals(-1, result);
    }
    
    @Test
    public void testIndexOfAnyButWhenCharSequenceDoesNotContainAnyCharacterFromSearchCharsUsingMocks() {
        // Instantiate all necessary variables here
        CharSequence cs = "abc";
        char[] searchChars = {'x', 'y', 'z'};

        // Mock dependencies

        // Write the test code here following the given rules
        int result = StringUtils.indexOfAnyBut(cs, searchChars);

        assertEquals(0, result);
    }
    
    @Test
    public void testIndexOfAnyButWhenCharSequenceContainsCharactersFromSearchCharsUsingMocks() {
        // Instantiate all necessary variables here
        CharSequence cs = "zzabyycdxx";
        char[] searchChars = {'z', 'a'};

        // Mock dependencies

        // Write the test code here following the given rules
        int result = StringUtils.indexOfAnyBut(cs, searchChars);

        assertEquals(3, result);
    }
    
    @Test
    public void testIndexOfAnyButWhenCharSequenceContainsOnlyCharactersFromSearchCharsUsingMocks() {
        // Instantiate all necessary variables here
        CharSequence cs = "aba";
        char[] searchChars = {'a', 'b'};

        // Mock dependencies

        // Write the test code here following the given rules
        int result = StringUtils.indexOfAnyBut(cs, searchChars);

        assertEquals(-1, result);
    }




    @Test
    public void equalsAnyIgnoreCase_NullString_ReturnsFalse() {
        // Arrange
        CharSequence string = null;
        CharSequence[] searchStrings = new CharSequence[] { "abc", "def" };

        // Act
        boolean result = StringUtils.equalsAnyIgnoreCase(string, searchStrings);

        // Assert
        assertFalse(result);
    }

    @Test
    public void equalsAnyIgnoreCase_NullSearchStrings_ReturnsFalse() {
        // Arrange
        CharSequence string = "abc";
        CharSequence[] searchStrings = null;

        // Act
        boolean result = StringUtils.equalsAnyIgnoreCase(string, searchStrings);

        // Assert
        assertFalse(result);
    }

//    @Test
//    public void equalsAnyIgnoreCase_NullStringAndSearchStrings_ReturnsTrue() {
//        // Arrange
//        CharSequence string = null;
//        CharSequence[] searchStrings = null;
//
//        // Act
//        boolean result = StringUtils.equalsAnyIgnoreCase(string, searchStrings);
//
//        // Assert
//        assertTrue(result);
//    }

    @Test
    public void equalsAnyIgnoreCase_NoMatch_ReturnsFalse() {
        // Arrange
        CharSequence string = "abc";
        CharSequence[] searchStrings = new CharSequence[] { "def", "ghi" };

        // Act
        boolean result = StringUtils.equalsAnyIgnoreCase(string, searchStrings);

        // Assert
        assertFalse(result);
    }

    @Test
    public void equalsAnyIgnoreCase_CaseInsensitiveMatch_ReturnsTrue() {
        // Arrange
        CharSequence string = "abc";
        CharSequence[] searchStrings = new CharSequence[] { "ABC", "DEF" };

        // Act
        boolean result = StringUtils.equalsAnyIgnoreCase(string, searchStrings);

        // Assert
        assertTrue(result);
    }

    @Test
    public void equalsAnyIgnoreCase_MultipleMatch_ReturnsTrue() {
        // Arrange
        CharSequence string = "abc";
        CharSequence[] searchStrings = new CharSequence[] { "abc", "def" };

        // Act
        boolean result = StringUtils.equalsAnyIgnoreCase(string, searchStrings);

        // Assert
        assertTrue(result);
    }




    @Test
    public void trim_NullString_ReturnsNull() {
        // Arrange
        String str = null;

        // Act
        String result = StringUtils.trim(str);

        // Assert
        assertNull(result);
    }
    
    @Test
    public void trim_EmptyString_ReturnsEmptyString() {
        // Arrange
        String str = "";

        // Act
        String result = StringUtils.trim(str);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void trim_WhitespaceString_ReturnsEmptyString() {
        // Arrange
        String str = "     ";

        // Act
        String result = StringUtils.trim(str);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void trim_NoWhitespaceString_ReturnsSameString() {
        // Arrange
        String str = "abc";

        // Act
        String result = StringUtils.trim(str);

        // Assert
        assertEquals("abc", result);
    }

    @Test
    public void trim_WhitespaceSurroundedString_ReturnsTrimmedString() {
        // Arrange
        String str = "    abc    ";

        // Act
        String result = StringUtils.trim(str);

        // Assert
        assertEquals("abc", result);
    }




    @Test
    public void testChop_NullInput_ReturnsNull() {
        // Instantiate all necessary variables here
        String str = null;

        // Write the test code here following the given rules
        String result = StringUtils.chop(str);

        assertNull(result);
    }
    
    @Test
    public void testChop_EmptyStringInput_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        String str = "";

        // Write the test code here following the given rules
        String result = StringUtils.chop(str);

        assertEquals("", result);
    }
    
    @Test
    public void testChop_StringWithSingleCharacter_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        String str = "a";

        // Write the test code here following the given rules
        String result = StringUtils.chop(str);

        assertEquals("", result);
    }
    
    @Test
    public void testChop_StringWithLinefeed_ReturnsStringWithoutLinefeed() {
        // Instantiate all necessary variables here
        String str = "abc\n";

        // Write the test code here following the given rules
        String result = StringUtils.chop(str);

        assertEquals("abc", result);
    }
    
    @Test
    public void testChop_StringWithCarriageReturnAndLinefeed_ReturnsStringWithoutBoth() {
        // Instantiate all necessary variables here
        String str = "abc\r\n";

        // Write the test code here following the given rules
        String result = StringUtils.chop(str);

        assertEquals("abc", result);
    }
    
//    @Test
//    public void testChop_StringWithCarriageReturn_ReturnsStringWithoutCarriageReturn() {
//        // Instantiate all necessary variables here
//        String str = "abc\r";
//
//        // Write the test code here following the given rules
//        String result = StringUtils.chop(str);
//
//        assertEquals("abc ", result);
//    }
    
    @Test
    public void testChop_StringWithMultipleCharacters_ReturnsStringWithoutLastCharacter() {
        // Instantiate all necessary variables here
        String str = "abcde";

        // Write the test code here following the given rules
        String result = StringUtils.chop(str);

        assertEquals("abcd", result);
    }

    @Test
    public void testChop_StringWithMultipleCharactersAndLinefeed_ReturnsStringWithoutLinefeed() {
        // Instantiate all necessary variables here
        String str = "abcde\n";

        // Write the test code here following the given rules
        String result = StringUtils.chop(str);

        assertEquals("abcde", result);
    }

    @Test
    public void testChop_StringWithMultipleCharactersAndCarriageReturnAndLinefeed_ReturnsStringWithoutCarriageReturnAndLinefeed() {
        // Instantiate all necessary variables here
        String str = "abcde\r\n";

        // Write the test code here following the given rules
        String result = StringUtils.chop(str);

        assertEquals("abcde", result);
    }

//    @Test
//    public void testChop_StringWithMultipleCharactersAndCarriageReturn_ReturnsStringWithoutCarriageReturn() {
//        // Instantiate all necessary variables here
//        String str = "abcde\r";
//
//        // Write the test code here following the given rules
//        String result = StringUtils.chop(str);
//
//        assertEquals("abcde ", result);
//    }





    @Test
    public void testContainsOnlyWithNullCharSequenceAndValidArray() {
        CharSequence cs = null;
        char[] valid = {'a', 'b', 'c'};
        
        boolean result = StringUtils.containsOnly(cs, valid);
        
        assertFalse(result);
    }
    
    @Test
    public void testContainsOnlyWithNullValidArray() {
        CharSequence cs = "abc";
        char[] valid = null;
        
        boolean result = StringUtils.containsOnly(cs, valid);
        
        assertFalse(result);
    }
    
    @Test
    public void testContainsOnlyWithEmptyCharSequence() {
        CharSequence cs = "";
        char[] valid = {'a', 'b', 'c'};
        
        boolean result = StringUtils.containsOnly(cs, valid);
        
        assertTrue(result);
    }
    
    @Test
    public void testContainsOnlyWithEmptyValidArray() {
        CharSequence cs = "abc";
        char[] valid = new char[0];
        
        boolean result = StringUtils.containsOnly(cs, valid);
        
        assertFalse(result);
    }
    
    @Test
    public void testContainsOnlyWithValidCharSequenceAndValidArray() {
        CharSequence cs = "abab";
        char[] valid = {'a', 'b', 'c'};
        
        boolean result = StringUtils.containsOnly(cs, valid);
        
        assertTrue(result);
    }
    
    @Test
    public void testContainsOnlyWithInvalidCharSequenceAndValidArray() {
        CharSequence cs = "ab1";
        char[] valid = {'a', 'b', 'c'};
        
        boolean result = StringUtils.containsOnly(cs, valid);
        
        assertFalse(result);
    }
    
    @Test
    public void testContainsOnlyWithInvalidCharSequenceAndInvalidArray() {
        CharSequence cs = "abz";
        char[] valid = {'a', 'b', 'c'};
        
        boolean result = StringUtils.containsOnly(cs, valid);
        
        assertFalse(result);
    }
    
    @Test
    public void testContainsOnlyWithNullCharSequenceAndValidString() {
        CharSequence cs = null;
        String valid = "abc";
        
        boolean result = StringUtils.containsOnly(cs, valid);
        
        assertFalse(result);
    }
    
    @Test
    public void testContainsOnlyWithNullValidString() {
        CharSequence cs = "abc";
        String valid = null;
        
        boolean result = StringUtils.containsOnly(cs, valid);
        
        assertFalse(result);
    }
    
    @Test
    public void testContainsOnlyWithEmptyCharSequenceAndValidString() {
        CharSequence cs = "";
        String valid = "abc";
        
        boolean result = StringUtils.containsOnly(cs, valid);
        
        assertTrue(result);
    }
    
    @Test
    public void testContainsOnlyWithEmptyValidString() {
        CharSequence cs = "abc";
        String valid = "";
        
        boolean result = StringUtils.containsOnly(cs, valid);
        
        assertFalse(result);
    }
    
    @Test
    public void testContainsOnlyWithValidCharSequenceAndValidString() {
        CharSequence cs = "abab";
        String valid = "abc";
        
        boolean result = StringUtils.containsOnly(cs, valid);
        
        assertTrue(result);
    }
    
    @Test
    public void testContainsOnlyWithInvalidCharSequenceAndValidString() {
        CharSequence cs = "ab1";
        String valid = "abc";
        
        boolean result = StringUtils.containsOnly(cs, valid);
        
        assertFalse(result);
    }
    
    @Test
    public void testContainsOnlyWithInvalidCharSequenceAndInvalidString() {
        CharSequence cs = "abz";
        String valid = "abc";
        
        boolean result = StringUtils.containsOnly(cs, valid);
        
        assertFalse(result);
    }




    @Test
    public void testUncapitalize_NullInput_ReturnsNull() {
        // Arrange
        String str = null;

        // Act
        String result = StringUtils.uncapitalize(str);

        // Assert
        assertNull(result);
    }

    @Test
    public void testUncapitalize_EmptyInput_ReturnsEmptyString() {
        // Arrange
        String str = "";

        // Act
        String result = StringUtils.uncapitalize(str);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testUncapitalize_LowercaseInput_ReturnsSameString() {
        // Arrange
        String str = "cat";

        // Act
        String result = StringUtils.uncapitalize(str);

        // Assert
        assertEquals("cat", result);
    }

    @Test
    public void testUncapitalize_UppercaseInput_ReturnsUncapitalizedString() {
        // Arrange
        String str = "Cat";

        // Act
        String result = StringUtils.uncapitalize(str);

        // Assert
        assertEquals("cat", result);
    }

    @Test
    public void testUncapitalize_AllUppercaseInput_ReturnsFirstCharacterCapitalizedString() {
        // Arrange
        String str = "CAT";

        // Act
        String result = StringUtils.uncapitalize(str);

        // Assert
        assertEquals("cAT", result);
    }

    @Test
    public void testUncapitalize_MixedCaseInput_ReturnsFirstCharacterLowercasedString() {
        // Arrange
        String str = "HelloWorld";

        // Act
        String result = StringUtils.uncapitalize(str);

        // Assert
        assertEquals("helloWorld", result);
    }






    @Test
    public void ExampleTest() {
        // Instantiate all necessary variables here
        CharSequence str = "aabaabaa";
        CharSequence searchStr = "a";
        int ordinal = 2;

        // Mock the dependencies
//        Pattern pattern = mock(Pattern.class);

        // Set up the behavior of the mocked dependencies

        // Write the test code here following the given rules
        int result = StringUtils.ordinalIndexOf(str, searchStr, ordinal);

        // Verify the results
        assertEquals(1, result);
    }




    @Test
    public void testRotate_NullString_ReturnsNull() {
        // Instantiate all necessary variables here
        String str = null;
        int shift = 5;

        // Write the test code here following the given rules
        String result = StringUtils.rotate(str, shift);

        assertNull(result);
    }

    @Test
    public void testRotate_EmptyString_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        String str = "";
        int shift = 3;

        // Write the test code here following the given rules
        String result = StringUtils.rotate(str, shift);

        assertEquals("", result);
    }

    @Test
    public void testRotate_ShiftZero_ReturnsOriginalString() {
        // Instantiate all necessary variables here
        String str = "abcdefg";
        int shift = 0;

        // Write the test code here following the given rules
        String result = StringUtils.rotate(str, shift);

        assertEquals("abcdefg", result);
    }

    @Test
    public void testRotate_RightShift_ReturnsRotatedString() {
        // Instantiate all necessary variables here
        String str = "abcdefg";
        int shift = 2;

        // Write the test code here following the given rules
        String result = StringUtils.rotate(str, shift);

        assertEquals("fgabcde", result);
    }

    @Test
    public void testRotate_LeftShift_ReturnsRotatedString() {
        // Instantiate all necessary variables here
        String str = "abcdefg";
        int shift = -2;

        // Write the test code here following the given rules
        String result = StringUtils.rotate(str, shift);

        assertEquals("cdefgab", result);
    }

    @Test
    public void testRotate_ShiftEqualToStringLength_ReturnsOriginalString() {
        // Instantiate all necessary variables here
        String str = "abcdefg";
        int shift = 7;

        // Write the test code here following the given rules
        String result = StringUtils.rotate(str, shift);

        assertEquals("abcdefg", result);
    }

    @Test
    public void testRotate_ShiftNegativeEqualToStringLength_ReturnsOriginalString() {
        // Instantiate all necessary variables here
        String str = "abcdefg";
        int shift = -7;

        // Write the test code here following the given rules
        String result = StringUtils.rotate(str, shift);

        assertEquals("abcdefg", result);
    }

    @Test
    public void testRotate_ShiftGreaterThanStringLength_ReturnsRotatedString() {
        // Instantiate all necessary variables here
        String str = "abcdefg";
        int shift = 9;

        // Write the test code here following the given rules
        String result = StringUtils.rotate(str, shift);

        assertEquals("fgabcde", result);
    }

    @Test
    public void testRotate_ShiftNegativeGreaterThanStringLength_ReturnsRotatedString() {
        // Instantiate all necessary variables here
        String str = "abcdefg";
        int shift = -9;

        // Write the test code here following the given rules
        String result = StringUtils.rotate(str, shift);

        assertEquals("cdefgab", result);
    }




    @Test
    public void testStartsWithAny_NullSequenceAndNullSearchStrings_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence sequence = null;
        CharSequence[] searchStrings = null;

        // Write the test code here following the given rules
        assertFalse(StringUtils.startsWithAny(sequence, searchStrings));
    }
    
    @Test
    public void testStartsWithAny_NullSequenceAndNonEmptySearchStrings_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence sequence = null;
        CharSequence[] searchStrings = {"abc"};

        // Write the test code here following the given rules
        assertFalse(StringUtils.startsWithAny(sequence, searchStrings));
    }
    
    @Test
    public void testStartsWithAny_NonEmptySequenceAndNullSearchStrings_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence sequence = "abcxyz";
        CharSequence[] searchStrings = null;

        // Write the test code here following the given rules
        assertFalse(StringUtils.startsWithAny(sequence, searchStrings));
    }
    
//    @Test
//    public void testStartsWithAny_NonEmptySequenceAndEmptySearchStrings_ReturnsTrue() {
//        // Instantiate all necessary variables here
//        CharSequence sequence = "abcxyz";
//        CharSequence[] searchStrings = {};
//
//        // Write the test code here following the given rules
//        assertTrue(StringUtils.startsWithAny(sequence, searchStrings));
//    }
    
    @Test
    public void testStartsWithAny_NonEmptySequenceAndMatchingSearchStrings_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence sequence = "abcxyz";
        CharSequence[] searchStrings = {"abc"};

        // Write the test code here following the given rules
        assertTrue(StringUtils.startsWithAny(sequence, searchStrings));
    }
    
    @Test
    public void testStartsWithAny_NonEmptySequenceAndNonMatchingSearchStrings_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence sequence = "abcxyz";
        CharSequence[] searchStrings = {null, "xyz", "ABCX"};

        // Write the test code here following the given rules
        assertFalse(StringUtils.startsWithAny(sequence, searchStrings));
    }
    
    @Test
    public void testStartsWithAny_NonEmptySequenceAndNonMatchingCaseSensitiveSearchStrings_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence sequence = "ABCXYZ";
        CharSequence[] searchStrings = {null, "xyz", "abc"};

        // Write the test code here following the given rules
        assertFalse(StringUtils.startsWithAny(sequence, searchStrings));
    }




    @Test
    public void testContainsNone_NullCharSequence_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = null;
        char[] searchChars = {'a', 'b'};

        // Write the test code here following the given rules
        boolean result = StringUtils.containsNone(cs, searchChars);
        
        assertTrue(result);
    }
    
    @Test
    public void testContainsNone_NullSearchChars_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = "ab";
        char[] searchChars = null;

        // Write the test code here following the given rules
        boolean result = StringUtils.containsNone(cs, searchChars);
        
        assertTrue(result);
    }
    
    @Test
    public void testContainsNone_EmptyCharSequence_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = "";
        char[] searchChars = {'a', 'b'};

        // Write the test code here following the given rules
        boolean result = StringUtils.containsNone(cs, searchChars);
        
        assertTrue(result);
    }
    
    @Test
    public void testContainsNone_EmptySearchChars_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = "ab";
        char[] searchChars = {};

        // Write the test code here following the given rules
        boolean result = StringUtils.containsNone(cs, searchChars);
        
        assertTrue(result);
    }
    
    @Test
    public void testContainsNone_CharSequenceContainsInvalidChars_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "abz";
        char[] searchChars = {'x', 'y', 'z'};

        // Write the test code here following the given rules
        boolean result = StringUtils.containsNone(cs, searchChars);
        
        assertFalse(result);
    }
    
    @Test
    public void testContainsNone_CharSequenceContainsInvalidCharsInDifferentOrder_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "abz";
        char[] searchChars = {'z', 'y', 'x'};

        // Write the test code here following the given rules
        boolean result = StringUtils.containsNone(cs, searchChars);
        
        assertFalse(result);
    }
    
//    @Test
//    public void testContainsNone_CharSequenceContainsInvalidCharsWithOtherValidChars_ReturnsFalse() {
//        // Instantiate all necessary variables here
//        CharSequence cs = "ab1";
//        char[] searchChars = {'x', 'y', 'z'};
//
//        // Write the test code here following the given rules
//        boolean result = StringUtils.containsNone(cs, searchChars);
//
//        assertFalse(result);
//    }
    
    @Test
    public void testContainsNone_CharSequenceDoesNotContainInvalidChars_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = "abz";
        char[] searchChars = {'x', 'y', 'w'};

        // Write the test code here following the given rules
        boolean result = StringUtils.containsNone(cs, searchChars);
        
        assertTrue(result);
    }
    
    @Test
    public void testContainsNone_NullCharSequenceWithInvalidChars_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = null;
        String invalidChars = "ab";

        // Write the test code here following the given rules
        boolean result = StringUtils.containsNone(cs, invalidChars);
        
        assertTrue(result);
    }
    
    @Test
    public void testContainsNone_NullInvalidChars_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = "ab";
        String invalidChars = null;

        // Write the test code here following the given rules
        boolean result = StringUtils.containsNone(cs, invalidChars);
        
        assertTrue(result);
    }
    
    @Test
    public void testContainsNone_EmptyCharSequenceWithInvalidChars_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = "";
        String invalidChars = "ab";

        // Write the test code here following the given rules
        boolean result = StringUtils.containsNone(cs, invalidChars);
        
        assertTrue(result);
    }
    
    @Test
    public void testContainsNone_EmptyInvalidChars_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = "ab";
        String invalidChars = "";

        // Write the test code here following the given rules
        boolean result = StringUtils.containsNone(cs, invalidChars);
        
        assertTrue(result);
    }
    
    @Test
    public void testContainsNone_CharSequenceContainsInvalidCharsAsString_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "abz";
        String invalidChars = "xyz";

        // Write the test code here following the given rules
        boolean result = StringUtils.containsNone(cs, invalidChars);
        
        assertFalse(result);
    }
    
    @Test
    public void testContainsNone_CharSequenceContainsInvalidCharsInDifferentOrderAsString_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "abz";
        String invalidChars = "zyx";

        // Write the test code here following the given rules
        boolean result = StringUtils.containsNone(cs, invalidChars);
        
        assertFalse(result);
    }
    
//    @Test
//    public void testContainsNone_CharSequenceContainsInvalidCharsWithOtherValidCharsAsString_ReturnsFalse() {
//        // Instantiate all necessary variables here
//        CharSequence cs = "ab1";
//        String invalidChars = "xyz";
//
//        // Write the test code here following the given rules
//        boolean result = StringUtils.containsNone(cs, invalidChars);
//
//        assertFalse(result);
//    }
    
//    @Test
//    public void testContainsNone_CharSequenceDoesNotContainInvalidCharsAsString_ReturnsTrue() {
//        // Instantiate all necessary variables here
//        CharSequence cs = "abz";
//        String invalidChars = "xyzw";
//
//        // Write the test code here following the given rules
//        boolean result = StringUtils.containsNone(cs, invalidChars);
//
//        assertTrue(result);
//    }






    
//    @Mock
//    private CharUtils charUtilsMock;
//
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    public void testUnwrapWithNullStringAndNullWrapChar() {
        String str = null;
        char wrapChar = CharUtils.NUL;
        
        String result = StringUtils.unwrap(str, wrapChar);
        
        assertNull(result);
    }
    
    @Test
    public void testUnwrapWithNullStringAndNonNullWrapChar() {
        String str = null;
        char wrapChar = '1';
        
        String result = StringUtils.unwrap(str, wrapChar);
        
        assertNull(result);
    }
    
    @Test
    public void testUnwrapWithNonNullStringAndNonWrapChar() {
        String str = "a";
        char wrapChar = 'a';
        
        String result = StringUtils.unwrap(str, wrapChar);
        
        assertEquals("a", result);
    }
    
    @Test
    public void testUnwrapWithNonNullStringAndWrapCharAtStartAndEnd() {
        String str = "aa";
        char wrapChar = 'a';
        
        String result = StringUtils.unwrap(str, wrapChar);
        
        assertEquals("", result);
    }
    
    @Test
    public void testUnwrapWithNonNullStringAndWrapCharAtStartAndEndWithAdditionalChars() {
        String str = "'abc'";
        char wrapChar = '\'';
        
        String result = StringUtils.unwrap(str, wrapChar);
        
        assertEquals("abc", result);
    }
    
    @Test
    public void testUnwrapWithNonNullStringAndWrapCharNotAtStartAndEnd() {
        String str = "AABabcBAA";
        char wrapChar = 'A';
        
        String result = StringUtils.unwrap(str, wrapChar);
        
        assertEquals("ABabcBA", result);
    }
    
    @Test
    public void testUnwrapWithNonNullStringAndWrapCharNotPresent() {
        String str = "A";
        char wrapChar = '#';
        
        String result = StringUtils.unwrap(str, wrapChar);
        
        assertEquals("A", result);
    }
    
    @Test
    public void testUnwrapWithNonNullStringAndWrapCharAtStart() {
        String str = "#A";
        char wrapChar = '#';
        
        String result = StringUtils.unwrap(str, wrapChar);
        
        assertEquals("#A", result);
    }
    
    @Test
    public void testUnwrapWithNonNullStringAndWrapCharAtEnd() {
        String str = "A#";
        char wrapChar = '#';
        
        String result = StringUtils.unwrap(str, wrapChar);
        
        assertEquals("A#", result);
    }
    
    @Test
    public void testUnwrapWithEmptyStringAndNullWrapToken() {
        String str = null;
        String wrapToken = null;
        
        String result = StringUtils.unwrap(str, wrapToken);
        
        assertNull(result);
    }
    
    @Test
    public void testUnwrapWithEmptyStringAndEmptyWrapToken() {
        String str = null;
        String wrapToken = "";
        
        String result = StringUtils.unwrap(str, wrapToken);
        
        assertNull(result);
    }
    
    @Test
    public void testUnwrapWithNonEmptyStringAndEmptyWrapToken() {
        String str = null;
        String wrapToken = "";
        
        String result = StringUtils.unwrap(str, wrapToken);
        
        assertNull(result);
    }
    
    @Test
    public void testUnwrapWithNonNullStringAndNonEmptyWrapTokenNotPresent() {
        String str = "a";
        String wrapToken = "a";
        
        String result = StringUtils.unwrap(str, wrapToken);
        
        assertEquals("a", result);
    }
    
    @Test
    public void testUnwrapWithNonNullStringAndWrapTokenAtStartAndEnd() {
        String str = "aa";
        String wrapToken = "a";
        
        String result = StringUtils.unwrap(str, wrapToken);
        
        assertEquals("", result);
    }
    
    @Test
    public void testUnwrapWithNonNullStringAndWrapTokenNotAtStartAndEnd2() {
        String str = "'abc'";
        String wrapToken = "'";
        
        String result = StringUtils.unwrap(str, wrapToken);
        
        assertEquals("abc", result);
    }
    
    @Test
    public void testUnwrapWithNonNullStringAndWrapTokenNotPresent() {
        String str = "\"abc\"";
        String wrapToken = "\"";
        
        String result = StringUtils.unwrap(str, wrapToken);
        
        assertEquals("abc", result);
    }
    
    @Test
    public void testUnwrapWithNonNullStringAndWrapTokenAtStart1() {
        String str = "AABabcBAA";
        String wrapToken = "AA";
        
        String result = StringUtils.unwrap(str, wrapToken);
        
        assertEquals("BabcB", result);
    }
    
    @Test
    public void testUnwrapWithNonNullStringAndWrapTokenNotAtStartAndEnd() {
        String str = "A";
        String wrapToken = "#";
        
        String result = StringUtils.unwrap(str, wrapToken);
        
        assertEquals("A", result);
    }
    
    @Test
    public void testUnwrapWithNonNullStringAndWrapTokenAtStart() {
        String str = "#A";
        String wrapToken = "#";
        
        String result = StringUtils.unwrap(str, wrapToken);
        
        assertEquals("#A", result);
    }
    
    @Test
    public void testUnwrapWithNonNullStringAndWrapTokenAtEnd() {
        String str = "A#";
        String wrapToken = "#";
        
        String result = StringUtils.unwrap(str, wrapToken);
        
        assertEquals("A#", result);
    }




    @Test
    public void stripToEmpty_NullInput_ReturnsEmptyString() {
        // Arrange
        String str = null;

        // Act
        String result = StringUtils.stripToEmpty(str);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void stripToEmpty_EmptyString_ReturnsEmptyString() {
        // Arrange
        String str = "";

        // Act
        String result = StringUtils.stripToEmpty(str);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void stripToEmpty_WhitespaceString_ReturnsEmptyString() {
        // Arrange
        String str = "   ";

        // Act
        String result = StringUtils.stripToEmpty(str);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void stripToEmpty_NonWhitespaceString_ReturnsSameString() {
        // Arrange
        String str = "abc";

        // Act
        String result = StringUtils.stripToEmpty(str);

        // Assert
        assertEquals("abc", result);
    }

    @Test
    public void stripToEmpty_StringWithLeadingWhitespace_ReturnsStringWithoutLeadingWhitespace() {
        // Arrange
        String str = "  abc";

        // Act
        String result = StringUtils.stripToEmpty(str);

        // Assert
        assertEquals("abc", result);
    }

    @Test
    public void stripToEmpty_StringWithTrailingWhitespace_ReturnsStringWithoutTrailingWhitespace() {
        // Arrange
        String str = "abc  ";

        // Act
        String result = StringUtils.stripToEmpty(str);

        // Assert
        assertEquals("abc", result);
    }

    @Test
    public void stripToEmpty_StringWithLeadingAndTrailingWhitespace_ReturnsStringWithoutLeadingAndTrailingWhitespace() {
        // Arrange
        String str = "  abc  ";

        // Act
        String result = StringUtils.stripToEmpty(str);

        // Assert
        assertEquals("abc", result);
    }

    @Test
    public void stripToEmpty_StringWithWhitespaceInMiddle_ReturnsStringWithWhitespaceInMiddle() {
        // Arrange
        String str = " ab c ";

        // Act
        String result = StringUtils.stripToEmpty(str);

        // Assert
        assertEquals("ab c", result);
    }





    @Test
    public void isNumeric_NullString_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = null;
        
        // Write the test code here following the given rules
        boolean result = StringUtils.isNumeric(cs);
        
        assertFalse(result);
    }
    
    @Test
    public void isNumeric_EmptyString_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "";
        
        // Write the test code here following the given rules
        boolean result = StringUtils.isNumeric(cs);
        
        assertFalse(result);
    }
    
    @Test
    public void isNumeric_WhitespaceString_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "  ";
        
        // Write the test code here following the given rules
        boolean result = StringUtils.isNumeric(cs);
        
        assertFalse(result);
    }
    
    @Test
    public void isNumeric_NumericString_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = "123";
        
        // Write the test code here following the given rules
        boolean result = StringUtils.isNumeric(cs);
        
        assertTrue(result);
    }
    
    @Test
    public void isNumeric_UnicodeNumericString_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = "\u0967\u0968\u0969";
        
        // Write the test code here following the given rules
        boolean result = StringUtils.isNumeric(cs);
        
        assertTrue(result);
    }
    
    @Test
    public void isNumeric_WhitespaceWithinString_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "12 3";
        
        // Write the test code here following the given rules
        boolean result = StringUtils.isNumeric(cs);
        
        assertFalse(result);
    }
    
    @Test
    public void isNumeric_NonNumericString_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "ab2c";
        
        // Write the test code here following the given rules
        boolean result = StringUtils.isNumeric(cs);
        
        assertFalse(result);
    }
    
    @Test
    public void isNumeric_StringWithHyphen_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "12-3";
        
        // Write the test code here following the given rules
        boolean result = StringUtils.isNumeric(cs);
        
        assertFalse(result);
    }
    
    @Test
    public void isNumeric_StringWithDecimalPoint_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "12.3";
        
        // Write the test code here following the given rules
        boolean result = StringUtils.isNumeric(cs);
        
        assertFalse(result);
    }
    
    @Test
    public void isNumeric_StringWithNegativeSign_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "-123";
        
        // Write the test code here following the given rules
        boolean result = StringUtils.isNumeric(cs);
        
        assertFalse(result);
    }
    
    @Test
    public void isNumeric_StringWithPositiveSign_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "+123";
        
        // Write the test code here following the given rules
        boolean result = StringUtils.isNumeric(cs);
        
        assertFalse(result);
    }




    @Test
    public void testRemoveFirst_NullInput_ReturnNull() {
        // Arrange
        String text = null;
        String regex = "abc";

        // Act
        String result = StringUtils.removeFirst(text, regex);

        // Assert
        assertNull(result);
    }

    @Test
    public void testRemoveFirst_NullRegex_ReturnOriginalText() {
        // Arrange
        String text = "abc";
        String regex = null;

        // Act
        String result = StringUtils.removeFirst(text, regex);

        // Assert
        assertEquals(text, result);
    }

    @Test
    public void testRemoveFirst_EmptyInput_ReturnEmptyString() {
        // Arrange
        String text = "";
        String regex = "abc";

        // Act
        String result = StringUtils.removeFirst(text, regex);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testRemoveFirst_NoMatch_ReturnOriginalText() {
        // Arrange
        String text = "abc";
        String regex = "xyz";

        // Act
        String result = StringUtils.removeFirst(text, regex);

        // Assert
        assertEquals(text, result);
    }

    @Test
    public void testRemoveFirst_Match_ReturnTextWithMatchRemoved() {
        // Arrange
        String text = "abcxyzabc";
        String regex = "abc";

        // Act
        String result = StringUtils.removeFirst(text, regex);

        // Assert
        assertEquals("xyzabc", result);
    }

    @Test
    public void testRemoveFirst_DotRegex_ReturnTextWithFirstCharacterRemoved() {
        // Arrange
        String text = "abc";
        String regex = ".";

        // Act
        String result = StringUtils.removeFirst(text, regex);

        // Assert
        assertEquals("bc", result);
    }

    @Test
    public void testRemoveFirst_DotAllRegex_ReturnTextWithAllCharactersRemoved() {
        // Arrange
        String text = "A<__>\n<__>B";
        String regex = "(?s)<.*>";

        // Act
        String result = StringUtils.removeFirst(text, regex);

        // Assert
        assertEquals("AB", result);
    }

    @Test
    public void testRemoveFirst_RegexWithCharacterClass_ReturnTextWithFirstCharacterOfClassRemoved() {
        // Arrange
        String text = "ABCabc123";
        String regex = "[a-z]";

        // Act
        String result = StringUtils.removeFirst(text, regex);

        // Assert
        assertEquals("ABCbc123", result);
    }

    @Test
    public void testRemoveFirst_RegexWithCharacterClass_ReturnTextWithAllCharactersOfClassRemoved() {
        // Arrange
        String text = "ABCabc123abc";
        String regex = "[a-z]+";

        // Act
        String result = StringUtils.removeFirst(text, regex);

        // Assert
        assertEquals("ABC123abc", result);
    }




//    @Test
//    public void testReplaceAll() {
//        // Instantiate all necessary variables here
//        String text = "Lorem ipsum dolor sit amet";
//        String regex = "ipsum";
//        String replacement = "REPLACED";
//
//        // Mock the RegExUtils class
//        RegExUtils regExUtilsMock = mock(RegExUtils.class);
//        when(regExUtilsMock.replaceAll(text, regex, replacement)).thenReturn("Lorem REPLACED dolor sit amet");
//
//        // Write the test code here following the given rules
//        String result = StringUtils.replaceAll(text, regex, replacement);
//
//        // Verify the result
//        assertEquals("Lorem REPLACED dolor sit amet", result);
//        verify(regExUtilsMock).replaceAll(text, regex, replacement);
//    }




    @Test
    public void testPrependIfMissingIgnoreCase_NullString_ReturnNull() {
        // Instantiate all necessary variables here
        String str = null;
        String prefix = "abc";
        String[] prefixes = {"xyz"};

        // Write the test code here following the given rules
        String result = StringUtils.prependIfMissingIgnoreCase(str, prefix, prefixes);
        
        assertNull(result);
    }
    
    @Test
    public void testPrependIfMissingIgnoreCase_NullPrefix_ReturnString() {
        // Instantiate all necessary variables here
        String str = "abc";
        String prefix = null;
        String[] prefixes = {"xyz"};

        // Write the test code here following the given rules
        String result = StringUtils.prependIfMissingIgnoreCase(str, prefix, prefixes);
        
        assertEquals(str, result);
    }
    
    @Test
    public void testPrependIfMissingIgnoreCase_EmptyString_ReturnPrefix() {
        // Instantiate all necessary variables here
        String str = "";
        String prefix = "xyz";
        String[] prefixes = {};

        // Write the test code here following the given rules
        String result = StringUtils.prependIfMissingIgnoreCase(str, prefix, prefixes);
        
        assertEquals(prefix, result);
    }
    
//    @Test
//    public void testPrependIfMissingIgnoreCase_StringWithPrefix_ReturnString() {
//        // Instantiate all necessary variables here
//        String str = "abc";
//        String prefix = "xyz";
//        String[] prefixes = {};
//
//        // Write the test code here following the given rules
//        String result = StringUtils.prependIfMissingIgnoreCase(str, prefix, prefixes);
//
//        assertEquals(str, result);
//    }
    
    @Test
    public void testPrependIfMissingIgnoreCase_StringWithoutPrefix_ReturnStringWithPrefix() {
        // Instantiate all necessary variables here
        String str = "xyzabc";
        String prefix = "xyz";
        String[] prefixes = {};

        // Write the test code here following the given rules
        String result = StringUtils.prependIfMissingIgnoreCase(str, prefix, prefixes);
        
        assertEquals("xyzabc", result);
    }
    
    @Test
    public void testPrependIfMissingIgnoreCase_StringWithDifferentCase_ReturnStringWithPrefix() {
        // Instantiate all necessary variables here
        String str = "XYZabc";
        String prefix = "xyz";
        String[] prefixes = {};

        // Write the test code here following the given rules
        String result = StringUtils.prependIfMissingIgnoreCase(str, prefix, prefixes);
        
        assertEquals("XYZabc", result);
    }
    
    @Test
    public void testPrependIfMissingIgnoreCase_AdditionalPrefixes_ReturnStringWithPrefix() {
        // Instantiate all necessary variables here
        String str = "abc";
        String prefix = "xyz";
        String[] prefixes = {"mno"};

        // Write the test code here following the given rules
        String result = StringUtils.prependIfMissingIgnoreCase(str, prefix, prefixes);
        
        assertEquals("xyzabc", result);
    }
    
    @Test
    public void testPrependIfMissingIgnoreCase_StringWithMultiplePrefixes_ReturnString() {
        // Instantiate all necessary variables here
        String str = "xyzabc";
        String prefix = "xyz";
        String[] prefixes = {"mno"};

        // Write the test code here following the given rules
        String result = StringUtils.prependIfMissingIgnoreCase(str, prefix, prefixes);
        
        assertEquals("xyzabc", result);
    }
    
    @Test
    public void testPrependIfMissingIgnoreCase_StringWithDifferentPrefix_ReturnString() {
        // Instantiate all necessary variables here
        String str = "mnoabc";
        String prefix = "xyz";
        String[] prefixes = {"mno"};

        // Write the test code here following the given rules
        String result = StringUtils.prependIfMissingIgnoreCase(str, prefix, prefixes);
        
        assertEquals("mnoabc", result);
    }
    
    @Test
    public void testPrependIfMissingIgnoreCase_StringWithDifferentCasePrefix_ReturnString() {
        // Instantiate all necessary variables here
        String str = "XYZabc";
        String prefix = "xyz";
        String[] prefixes = {"mno"};

        // Write the test code here following the given rules
        String result = StringUtils.prependIfMissingIgnoreCase(str, prefix, prefixes);
        
        assertEquals("XYZabc", result);
    }






    @Test
    public void testFirstNonBlank() {
        // Test case 1: values array is null
        assertNull(StringUtils.firstNonBlank((String[]) null));

        // Test case 2: values array is empty
        assertNull(StringUtils.firstNonBlank(new String[0]));

        // Test case 3: values array contains null values
        assertNull(StringUtils.firstNonBlank(null, null, null));

        // Test case 4: values array contains empty values
        assertNull(StringUtils.firstNonBlank("", ""));

        // Test case 5: values array contains whitespace only values
        assertNull(StringUtils.firstNonBlank(" ", "   ", "  \t  "));

        // Test case 6: values array contains a non-blank value
        assertEquals("abc", StringUtils.firstNonBlank(null, "", "abc"));

        // Test case 7: values array contains multiple non-blank values
        assertEquals("xyz", StringUtils.firstNonBlank(null, "", " ", "xyz"));

        // Test case 8: values array contains all non-blank values
        assertEquals("xyz", StringUtils.firstNonBlank(null, "xyz", "abc"));
    }



    
    @Test
    public void isBlank_Null_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = null;
        
        // Write the test code here following the given rules
        assertTrue(StringUtils.isBlank(cs));
    }
    
    @Test
    public void isBlank_EmptyString_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = "";
        
        // Write the test code here following the given rules
        assertTrue(StringUtils.isBlank(cs));
    }
    
    @Test
    public void isBlank_WhitespaceString_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = " ";
        
        // Write the test code here following the given rules
        assertTrue(StringUtils.isBlank(cs));
    }
    
    @Test
    public void isBlank_NonBlankString_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "bob";
        
        // Write the test code here following the given rules
        assertFalse(StringUtils.isBlank(cs));
    }
    
    @Test
    public void isBlank_StringWithLeadingAndTrailingWhitespace_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "  bob  ";
        
        // Write the test code here following the given rules
        assertFalse(StringUtils.isBlank(cs));
    }
    
//    @Test
//    public void isBlank_StringWithTabsAndNewlines_ReturnsFalse() {
//        // Instantiate all necessary variables here
//        CharSequence cs = "\t\n";
//
//        // Write the test code here following the given rules
//        assertFalse(StringUtils.isBlank(cs));
//    }
    
    @Test
    public void isBlank_StringWithSpecialCharacters_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = " !@#$%^&*() ";
        
        // Write the test code here following the given rules
        assertFalse(StringUtils.isBlank(cs));
    }




    @Test
    public void testIsAllUpperCase_EmptyString_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "";

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllUpperCase(cs);

        assertFalse(result);
    }

    @Test
    public void testIsAllUpperCase_NullString_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = null;

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllUpperCase(cs);

        assertFalse(result);
    }

    @Test
    public void testIsAllUpperCase_AllUppercaseString_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = "ABC";

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllUpperCase(cs);

        assertTrue(result);
    }

    @Test
    public void testIsAllUpperCase_MixedCaseString_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "aBC";

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllUpperCase(cs);

        assertFalse(result);
    }

    @Test
    public void testIsAllUpperCase_StringWithSpace_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "A C";

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllUpperCase(cs);

        assertFalse(result);
    }

    @Test
    public void testIsAllUpperCase_StringWithNumber_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "A1C";

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllUpperCase(cs);

        assertFalse(result);
    }

    @Test
    public void testIsAllUpperCase_StringWithSpecialCharacter_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "A/C";

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllUpperCase(cs);

        assertFalse(result);
    }




    @Test
    public void testLeft_NullString_ReturnsNull() {
        String str = null;
        int len = 5;

        String result = StringUtils.left(str, len);

        assertNull(result);
    }

    @Test
    public void testLeft_NegativeLength_ReturnsEmptyString() {
        String str = "abc";
        int len = -2;

        String result = StringUtils.left(str, len);

        assertEquals("", result);
    }

    @Test
    public void testLeft_EmptyString_ReturnsEmptyString() {
        String str = "";
        int len = 3;

        String result = StringUtils.left(str, len);

        assertEquals("", result);
    }

    @Test
    public void testLeft_LessThanLength_ReturnsSubString() {
        String str = "abcdef";
        int len = 4;

        String result = StringUtils.left(str, len);

        assertEquals("abcd", result);
    }

    @Test
    public void testLeft_EqualToLength_ReturnsString() {
        String str = "abc";
        int len = 3;

        String result = StringUtils.left(str, len);

        assertEquals("abc", result);
    }

    @Test
    public void testLeft_GreaterThanLength_ReturnsString() {
        String str = "abc";
        int len = 5;

        String result = StringUtils.left(str, len);

        assertEquals("abc", result);
    }






    @Test
    public void testIndexOfAny_WithNullString_ReturnsNegativeOne() {
        // Instantiate all necessary variables here
        CharSequence cs = null;
        char[] searchChars = new char[] {'a', 'b', 'c'};

        // Write the test code here following the given rules
        int result = StringUtils.indexOfAny(cs, searchChars);

        assertEquals(-1, result);
    }

    @Test
    public void testIndexOfAny_WithEmptyString_ReturnsNegativeOne() {
        // Instantiate all necessary variables here
        CharSequence cs = "";
        char[] searchChars = new char[] {'a', 'b', 'c'};

        // Write the test code here following the given rules
        int result = StringUtils.indexOfAny(cs, searchChars);

        assertEquals(-1, result);
    }

    @Test
    public void testIndexOfAny_WithNullSearchChars_ReturnsNegativeOne() {
        // Instantiate all necessary variables here
        CharSequence cs = "abc";
        char[] searchChars = null;

        // Write the test code here following the given rules
        int result = StringUtils.indexOfAny(cs, searchChars);

        assertEquals(-1, result);
    }

    @Test
    public void testIndexOfAny_WithEmptySearchChars_ReturnsNegativeOne() {
        // Instantiate all necessary variables here
        CharSequence cs = "abc";
        char[] searchChars = new char[0];

        // Write the test code here following the given rules
        int result = StringUtils.indexOfAny(cs, searchChars);

        assertEquals(-1, result);
    }

    @Test
    public void testIndexOfAny_WithValidInput_ReturnsIndexOfFirstMatch() {
        // Instantiate all necessary variables here
        CharSequence cs = "zzabyycdxx";
        char[] searchChars = new char[] {'b', 'y'};

        // Write the test code here following the given rules
        int result = StringUtils.indexOfAny(cs, searchChars);

        assertEquals(3, result);
    }

    @Test
    public void testIndexOfAny_WithNoMatch_ReturnsNegativeOne() {
        // Instantiate all necessary variables here
        CharSequence cs = "aba";
        char[] searchChars = new char[] {'z'};

        // Write the test code here following the given rules
        int result = StringUtils.indexOfAny(cs, searchChars);

        assertEquals(-1, result);
    }

    @Test
    public void testIndexOfAny_WithNullStringAndNullSearchChars_ReturnsNegativeOne() {
        // Instantiate all necessary variables here
        CharSequence cs = null;
        char[] searchChars = null;

        // Write the test code here following the given rules
        int result = StringUtils.indexOfAny(cs, searchChars);

        assertEquals(-1, result);
    }

    @Test
    public void testIndexOfAny_WithNullStringAndEmptySearchChars_ReturnsNegativeOne() {
        // Instantiate all necessary variables here
        CharSequence cs = null;
        char[] searchChars = new char[0];

        // Write the test code here following the given rules
        int result = StringUtils.indexOfAny(cs, searchChars);

        assertEquals(-1, result);
    }






    @Test
    public void startsWithIgnoreCase_NullStrings_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence str = null;
        CharSequence prefix = null;

        // Write the test code here following the given rules
        boolean result = StringUtils.startsWithIgnoreCase(str, prefix);

        assertTrue(result);
    }

    @Test
    public void startsWithIgnoreCase_NullString_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence str = null;
        CharSequence prefix = "abc";

        // Write the test code here following the given rules
        boolean result = StringUtils.startsWithIgnoreCase(str, prefix);

        assertFalse(result);
    }

    @Test
    public void startsWithIgnoreCase_NullPrefix_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence str = "abcdef";
        CharSequence prefix = null;

        // Write the test code here following the given rules
        boolean result = StringUtils.startsWithIgnoreCase(str, prefix);

        assertFalse(result);
    }

//    @Test
//    public void startsWithIgnoreCase_CaseSensitive_ReturnsFalse() {
//        // Instantiate all necessary variables here
//        CharSequence str = "abcdef";
//        CharSequence prefix = "abc";
//
//        // Write the test code here following the given rules
//        boolean result = StringUtils.startsWithIgnoreCase(str, prefix);
//
//        assertFalse(result);
//    }

    @Test
    public void startsWithIgnoreCase_CaseInsensitive_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence str = "ABCDEF";
        CharSequence prefix = "abc";

        // Write the test code here following the given rules
        boolean result = StringUtils.startsWithIgnoreCase(str, prefix);

        assertTrue(result);
    }




//    @Test
//    public void testSubstringsBetween() {
//        // Instantiate all necessary variables here
//        String str = "[a][b][c]";
//        String open = "[";
//        String close = "]";
//
//        // Mock the dependencies
//        StringUtils utils = spy(new StringUtils());
//
//        // Define the expected result
//        String[] expectedResult = {"a", "b", "c"};
//
//        // Stub the method call
//        doReturn(expectedResult).when(utils).substringsBetween(str, open, close);
//
//        // Call the method
//        String[] actualResult = utils.substringsBetween(str, open, close);
//
//        // Verify the result
//        assertArrayEquals(expectedResult, actualResult);
//
//        // Verify the method call
//        verify(utils).substringsBetween(str, open, close);
//    }
//
//    @Test
//    public void testSubstringsBetween_NullInput() {
//        // Instantiate all necessary variables here
//        String str = null;
//        String open = "[";
//        String close = "]";
//
//        // Mock the dependencies
//        StringUtils utils = spy(new StringUtils());
//
//        // Define the expected result
//        String[] expectedResult = null;
//
//        // Stub the method call
//        doReturn(expectedResult).when(utils).substringsBetween(str, open, close);
//
//        // Call the method
//        String[] actualResult = utils.substringsBetween(str, open, close);
//
//        // Verify the result
//        assertArrayEquals(expectedResult, actualResult);
//
//        // Verify the method call
//        verify(utils).substringsBetween(str, open, close);
//    }
//
//    @Test
//    public void testSubstringsBetween_NullOpenClose() {
//        // Instantiate all necessary variables here
//        String str = "[a][b][c]";
//        String open = null;
//        String close = null;
//
//        // Mock the dependencies
//        StringUtils utils = spy(new StringUtils());
//
//        // Define the expected result
//        String[] expectedResult = null;
//
//        // Stub the method call
//        doReturn(expectedResult).when(utils).substringsBetween(str, open, close);
//
//        // Call the method
//        String[] actualResult = utils.substringsBetween(str, open, close);
//
//        // Verify the result
//        assertArrayEquals(expectedResult, actualResult);
//
//        // Verify the method call
//        verify(utils).substringsBetween(str, open, close);
//    }
//
//    @Test
//    public void testSubstringsBetween_EmptyOpenClose() {
//        // Instantiate all necessary variables here
//        String str = "[a][b][c]";
//        String open = "";
//        String close = "";
//
//        // Mock the dependencies
//        StringUtils utils = spy(new StringUtils());
//
//        // Define the expected result
//        String[] expectedResult = null;
//
//        // Stub the method call
//        doReturn(expectedResult).when(utils).substringsBetween(str, open, close);
//
//        // Call the method
//        String[] actualResult = utils.substringsBetween(str, open, close);
//
//        // Verify the result
//        assertArrayEquals(expectedResult, actualResult);
//
//        // Verify the method call
//        verify(utils).substringsBetween(str, open, close);
//    }
    
//    @Test
//    public void testSubstringsBetween_EmptyString() {
//        // Instantiate all necessary variables here
//        String str = "";
//        String open = "[";
//        String close = "]";
//
//        // Mock the dependencies
//        StringUtils utils = spy(new StringUtils());
//
//        // Define the expected result
//        String[] expectedResult = new String[0];
//
//        // Stub the method call
//        doReturn(expectedResult).when(utils).substringsBetween(str, open, close);
//
//        // Call the method
//        String[] actualResult = utils.substringsBetween(str, open, close);
//
//        // Verify the result
//        assertArrayEquals(expectedResult, actualResult);
//
//        // Verify the method call
//        verify(utils).substringsBetween(str, open, close);
//    }






    @Test
    public void testLastIndexOfAny_NullString_ReturnsNegativeOne() {
        // Instantiate all necessary variables here
        CharSequence[] searchStrs = new CharSequence[] {"ab", "cd"};

        // Mock dependencies
        CharSequence str = null;

        // Write the test code here following the given rules
        int result = StringUtils.lastIndexOfAny(str, searchStrs);

        // Verify the result
        assertEquals(-1, result);
    }

    @Test
    public void testLastIndexOfAny_NullSearchStrs_ReturnsNegativeOne() {
        // Instantiate all necessary variables here
        CharSequence str = "zzabyycdxx";

        // Mock dependencies
        CharSequence[] searchStrs = null;

        // Write the test code here following the given rules
        int result = StringUtils.lastIndexOfAny(str, searchStrs);

        // Verify the result
        assertEquals(-1, result);
    }

    @Test
    public void testLastIndexOfAny_EmptySearchStrs_ReturnsNegativeOne() {
        // Instantiate all necessary variables here
        CharSequence str = "zzabyycdxx";
        CharSequence[] searchStrs = new CharSequence[0];

        // Write the test code here following the given rules
        int result = StringUtils.lastIndexOfAny(str, searchStrs);

        // Verify the result
        assertEquals(-1, result);
    }

    @Test
    public void testLastIndexOfAny_NullSearchStr_ReturnsNegativeOne() {
        // Instantiate all necessary variables here
        CharSequence str = "zzabyycdxx";
        CharSequence[] searchStrs = new CharSequence[] {null};

        // Write the test code here following the given rules
        int result = StringUtils.lastIndexOfAny(str, searchStrs);

        // Verify the result
        assertEquals(-1, result);
    }

    @Test
    public void testLastIndexOfAny_MatchingSearchStrs_ReturnsCorrectIndex() {
        // Instantiate all necessary variables here
        CharSequence str = "zzabyycdxx";
        CharSequence[] searchStrs = new CharSequence[] {"ab", "cd"};

        // Write the test code here following the given rules
        int result = StringUtils.lastIndexOfAny(str, searchStrs);

        // Verify the result
        assertEquals(6, result);
    }

    @Test
    public void testLastIndexOfAny_NoMatchingSearchStrs_ReturnsNegativeOne() {
        // Instantiate all necessary variables here
        CharSequence str = "zzabyycdxx";
        CharSequence[] searchStrs = new CharSequence[] {"mn", "op"};

        // Write the test code here following the given rules
        int result = StringUtils.lastIndexOfAny(str, searchStrs);

        // Verify the result
        assertEquals(-1, result);
    }

    @Test
    public void testLastIndexOfAny_EmptySearchStr_ReturnsLengthOfStr() {
        // Instantiate all necessary variables here
        CharSequence str = "zzabyycdxx";
        CharSequence[] searchStrs = new CharSequence[] {"mn", ""};

        // Write the test code here following the given rules
        int result = StringUtils.lastIndexOfAny(str, searchStrs);

        // Verify the result
        assertEquals(10, result);
    }




    @Test
    public void testUpperCase_withNullInput_shouldReturnNull() {
        // Instantiate all necessary variables here
        String str = null;

        // Write the test code here following the given rules
        String result = StringUtils.upperCase(str);
        
        assertNull(result);
    }

    @Test
    public void testUpperCase_withEmptyInput_shouldReturnEmptyString() {
        // Instantiate all necessary variables here
        String str = "";

        // Write the test code here following the given rules
        String result = StringUtils.upperCase(str);
        
        assertEquals("", result);
    }

    @Test
    public void testUpperCase_withLowercaseInput_shouldReturnUppercaseString() {
        // Instantiate all necessary variables here
        String str = "aBc";

        // Write the test code here following the given rules
        String result = StringUtils.upperCase(str);
        
        assertEquals("ABC", result);
    }

    @Test
    public void testUpperCase_withNullInputAndLocale_shouldReturnNull() {
        // Instantiate all necessary variables here
        String str = null;
        Locale locale = Locale.ENGLISH;

        // Write the test code here following the given rules
        String result = StringUtils.upperCase(str, locale);
        
        assertNull(result);
    }

    @Test
    public void testUpperCase_withEmptyInputAndLocale_shouldReturnEmptyString() {
        // Instantiate all necessary variables here
        String str = "";
        Locale locale = Locale.ENGLISH;

        // Write the test code here following the given rules
        String result = StringUtils.upperCase(str, locale);
        
        assertEquals("", result);
    }

    @Test
    public void testUpperCase_withLowercaseInputAndLocale_shouldReturnUppercaseString() {
        // Instantiate all necessary variables here
        String str = "aBc";
        Locale locale = Locale.ENGLISH;

        // Write the test code here following the given rules
        String result = StringUtils.upperCase(str, locale);
        
        assertEquals("ABC", result);
    }






    @Test
    public void overlay_shouldReturnNull_whenStringIsNull() {
        // Instantiate all necessary variables here
        String str = null;
        String overlay = "abc";
        int start = 0;
        int end = 0;

        // Write the test code here following the given rules
        String result = StringUtils.overlay(str, overlay, start, end);

        assertNull(result);
    }

//    @Test
//    public void overlay_shouldReturnString_whenOverlayIsNull() {
//        // Instantiate all necessary variables here
//        String str = "abcdef";
//        String overlay = null;
//        int start = 2;
//        int end = 4;
//
//        // Write the test code here following the given rules
//        String result = StringUtils.overlay(str, overlay, start, end);
//
//        assertEquals(str, result);
//    }
//
//    @Test
//    public void overlay_shouldReturnString_whenStartAndEndIndicesAreEqual() {
//        // Instantiate all necessary variables here
//        String str = "abcdef";
//        String overlay = "zzzz";
//        int start = 2;
//        int end = 2;
//
//        // Write the test code here following the given rules
//        String result = StringUtils.overlay(str, overlay, start, end);
//
//        assertEquals(str, result);
//    }

    @Test
    public void overlay_shouldReturnString_whenStartIndexIsNegative() {
        // Instantiate all necessary variables here
        String str = "abcdef";
        String overlay = "zzzz";
        int start = -1;
        int end = 4;

        // Write the test code here following the given rules
        String result = StringUtils.overlay(str, overlay, start, end);

        assertEquals("zzzzef", result);
    }

    @Test
    public void overlay_shouldReturnString_whenStartIndexIsGreaterThanStringLength() {
        // Instantiate all necessary variables here
        String str = "abcdef";
        String overlay = "zzzz";
        int start = 8;
        int end = 10;

        // Write the test code here following the given rules
        String result = StringUtils.overlay(str, overlay, start, end);

        assertEquals("abcdefzzzz", result);
    }

//    @Test
//    public void overlay_shouldReturnString_whenEndIndexIsNegative() {
//        // Instantiate all necessary variables here
//        String str = "abcdef";
//        String overlay = "zzzz";
//        int start = 2;
//        int end = -3;
//
//        // Write the test code here following the given rules
//        String result = StringUtils.overlay(str, overlay, start, end);
//
//        assertEquals("zzzzabcdef", result);
//    }

    @Test
    public void overlay_shouldReturnString_whenEndIndexIsGreaterThanStringLength() {
        // Instantiate all necessary variables here
        String str = "abcdef";
        String overlay = "zzzz";
        int start = 2;
        int end = 8;

        // Write the test code here following the given rules
        String result = StringUtils.overlay(str, overlay, start, end);

        assertEquals("abzzzz", result);
    }

    @Test
    public void overlay_shouldReturnOverlayedString_whenValidIndices() {
        // Instantiate all necessary variables here
        String str = "abcdef";
        String overlay = "zzzz";
        int start = 2;
        int end = 4;

        // Write the test code here following the given rules
        String result = StringUtils.overlay(str, overlay, start, end);

        assertEquals("abzzzzef", result);
    }



    
    @Mock
    private CharSequence str;
    
    @Mock
    private CharSequence searchStr;
    
//    @Test
//    public void ExampleTest8() {
//        MockitoAnnotations.initMocks(this);
//
//        // Test when str and searchStr are null
//        int result = StringUtils.lastIndexOfIgnoreCase(null, null);
//        assertEquals(-1, result);
//
//        // Test when str is null and searchStr is not null
//        result = StringUtils.lastIndexOfIgnoreCase(null, searchStr);
//        assertEquals(-1, result);
//
//        // Test when str is not null and searchStr is null
//        result = StringUtils.lastIndexOfIgnoreCase(str, null);
//        assertEquals(-1, result);
//
//        // Test when str and searchStr are empty
//        when(str.length()).thenReturn(0);
//        when(searchStr.length()).thenReturn(0);
//        result = StringUtils.lastIndexOfIgnoreCase(str, searchStr);
//        assertEquals(0, result);
//
//        // Test when str is not empty and searchStr is empty
//        when(str.length()).thenReturn(5);
//        when(searchStr.length()).thenReturn(0);
//        result = StringUtils.lastIndexOfIgnoreCase(str, searchStr);
//        assertEquals(5, result);
//
//        // Test when str and searchStr are not empty
//        when(str.length()).thenReturn(10);
//        when(searchStr.length()).thenReturn(2);
//        when(CharSequenceUtils.regionMatches(str, true, 7, searchStr, 0, 2)).thenReturn(true);
//        result = StringUtils.lastIndexOfIgnoreCase(str, searchStr);
//        assertEquals(7, result);
//    }





    @Test
    public void testWrapIfMissing_withNullString_returnsNull() {
        // Arrange
        String str = null;
        char wrapWith = 'x';

        // Act
        String result = StringUtils.wrapIfMissing(str, wrapWith);

        // Assert
        assertNull(result);
    }

    @Test
    public void testWrapIfMissing_withEmptyString_returnsEmptyString() {
        // Arrange
        String str = "";
        char wrapWith = 'x';

        // Act
        String result = StringUtils.wrapIfMissing(str, wrapWith);

        // Assert
        assertEquals("", result);
    }

//    @Test
//    public void testWrapIfMissing_withStringAlreadyWrapped_returnsSameString() {
//        // Arrange
//        String str = "abc";
//        char wrapWith = 'x';
//
//        // Act
//        String result = StringUtils.wrapIfMissing(str, wrapWith);
//
//        // Assert
//        assertEquals("abc", result);
//    }

    @Test
    public void testWrapIfMissing_withStringNotWrapped_returnsWrappedString() {
        // Arrange
        String str = "abc";
        char wrapWith = 'x';

        // Act
        String result = StringUtils.wrapIfMissing(str, wrapWith);

        // Assert
        assertEquals("xabcx", result);
    }

    @Test
    public void testWrapIfMissing_withEmptyStringAndNullWrapChar_returnsEmptyString() {
        // Arrange
        String str = "";
        char wrapWith = CharUtils.NUL;

        // Act
        String result = StringUtils.wrapIfMissing(str, wrapWith);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testWrapIfMissing_withNullStringAndValidWrapChar_returnsNull() {
        // Arrange
        String str = null;
        char wrapWith = 'x';

        // Act
        String result = StringUtils.wrapIfMissing(str, wrapWith);

        // Assert
        assertNull(result);
    }

//    @Test
//    public void testWrapIfMissing_withStringAlreadyWrappedAndValidWrapChar_returnsSameString() {
//        // Arrange
//        String str = "abc";
//        char wrapWith = 'x';
//
//        // Act
//        String result = StringUtils.wrapIfMissing(str, wrapWith);
//
//        // Assert
//        assertEquals("abc", result);
//    }

    @Test
    public void testWrapIfMissing_withStringNotWrappedAndValidWrapChar_returnsWrappedString() {
        // Arrange
        String str = "abc";
        char wrapWith = 'x';

        // Act
        String result = StringUtils.wrapIfMissing(str, wrapWith);

        // Assert
        assertEquals("xabcx", result);
    }

    @Test
    public void testWrapIfMissing_withEmptyStringAndNullWrapString_returnsEmptyString() {
        // Arrange
        String str = "";
        String wrapWith = null;

        // Act
        String result = StringUtils.wrapIfMissing(str, wrapWith);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testWrapIfMissing_withNullStringAndValidWrapString_returnsNull() {
        // Arrange
        String str = null;
        String wrapWith = "x";

        // Act
        String result = StringUtils.wrapIfMissing(str, wrapWith);

        // Assert
        assertNull(result);
    }

//    @Test
//    public void testWrapIfMissing_withStringAlreadyWrappedAndValidWrapString_returnsSameString() {
//        // Arrange
//        String str = "abc";
//        String wrapWith = "x";
//
//        // Act
//        String result = StringUtils.wrapIfMissing(str, wrapWith);
//
//        // Assert
//        assertEquals("abc", result);
//    }

    @Test
    public void testWrapIfMissing_withStringNotWrappedAndValidWrapString_returnsWrappedString() {
        // Arrange
        String str = "abc";
        String wrapWith = "x";

        // Act
        String result = StringUtils.wrapIfMissing(str, wrapWith);

        // Assert
        assertEquals("xabcx", result);
    }




//    @Test
//    public void testToString_withByteArrayAndCharsetName_shouldReturnString() throws UnsupportedEncodingException {
//        // Instantiate all necessary variables here
//        byte[] bytes = {97, 98, 99};
//        String charsetName = "UTF-8";
//
//        // Mock the dependencies
//        Charset charsetMock = mock(Charset.class);
//        Charsets charsetsMock = mock(Charsets.class);
//        StringUtils stringUtils = new StringUtils();
//
//        // Set up the mock behavior
//        when(charsetsMock.toCharset(charsetName)).thenReturn(charsetMock);
//        when(new String(bytes, charsetMock)).thenReturn("abc");
//
//        // Write the test code here following the given rules
//        String result = StringUtils.toString(bytes, charsetName);
//
//        // Verify the result
//        assertEquals("abc", result);
//        verify(charsetsMock).toCharset(charsetName);
//        //verifyNew(String.class).withArguments(bytes, charsetMock);
//    }




    @Test
    public void replacePattern_NullSource_ReturnsNull() {
        // Arrange
        String source = null;
        String regex = "abc";
        String replacement = "xyz";

        // Act
        String result = StringUtils.replacePattern(source, regex, replacement);

        // Assert
        assertNull(result);
    }

    @Test
    public void replacePattern_NullRegex_ReturnsSource() {
        // Arrange
        String source = "abc123";
        String regex = null;
        String replacement = "xyz";

        // Act
        String result = StringUtils.replacePattern(source, regex, replacement);

        // Assert
        assertEquals(source, result);
    }

    @Test
    public void replacePattern_NullReplacement_ReturnsSource() {
        // Arrange
        String source = "abc123";
        String regex = "abc";
        String replacement = null;

        // Act
        String result = StringUtils.replacePattern(source, regex, replacement);

        // Assert
        assertEquals(source, result);
    }

    @Test
    public void replacePattern_EmptySource_ReturnsEmptySource() {
        // Arrange
        String source = "";
        String regex = "abc";
        String replacement = "xyz";

        // Act
        String result = StringUtils.replacePattern(source, regex, replacement);

        // Assert
        assertEquals(source, result);
    }

//    @Test
//    public void replacePattern_EmptyRegex_ReturnsSource() {
//        // Arrange
//        String source = "abc123";
//        String regex = "";
//        String replacement = "xyz";
//
//        // Act
//        String result = StringUtils.replacePattern(source, regex, replacement);
//
//        // Assert
//        assertEquals(source, result);
//    }

//    @Test
//    public void replacePattern_EmptyReplacement_ReturnsSourceWithRemovedMatches() {
//        // Arrange
//        String source = "abc123";
//        String regex = "[a-z]";
//        String replacement = "";
//
//        // Act
//        String result = StringUtils.replacePattern(source, regex, replacement);
//
//        // Assert
//        assertEquals("123", result);
//    }

    @Test
    public void replacePattern_MatchingRegex_ReturnsSourceWithReplacedMatches() {
        // Arrange
        String source = "abc123def456";
        String regex = "[a-z]+";
        String replacement = "xyz";

        // Act
        String result = StringUtils.replacePattern(source, regex, replacement);

        // Assert
        assertEquals("xyz123xyz456", result);
    }

//    @Test
//    public void replacePattern_NoMatchingRegex_ReturnsSource() {
//        // Arrange
//        String source = "abc123def456";
//        String regex = "\\d+";
//        String replacement = "xyz";
//
//        // Act
//        String result = StringUtils.replacePattern(source, regex, replacement);
//
//        // Assert
//        assertEquals(source, result);
//    }






    @Test
    public void testReplaceEachRepeatedly_NullInput_ReturnsNull() {
        // Arrange
        String text = null;
        String[] searchList = {"a"};
        String[] replacementList = {"b"};

        // Act
        String result = StringUtils.replaceEachRepeatedly(text, searchList, replacementList);

        // Assert
        assertNull(result);
    }

    @Test
    public void testReplaceEachRepeatedly_EmptyInput_ReturnsEmptyString() {
        // Arrange
        String text = "";
        String[] searchList = {"a"};
        String[] replacementList = {"b"};

        // Act
        String result = StringUtils.replaceEachRepeatedly(text, searchList, replacementList);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testReplaceEachRepeatedly_NullSearchList_ReturnsOriginalText() {
        // Arrange
        String text = "aba";
        String[] searchList = null;
        String[] replacementList = {"b"};

        // Act
        String result = StringUtils.replaceEachRepeatedly(text, searchList, replacementList);

        // Assert
        assertEquals("aba", result);
    }

    @Test
    public void testReplaceEachRepeatedly_NullReplacementList_ReturnsOriginalText() {
        // Arrange
        String text = "aba";
        String[] searchList = {"a"};
        String[] replacementList = null;

        // Act
        String result = StringUtils.replaceEachRepeatedly(text, searchList, replacementList);

        // Assert
        assertEquals("aba", result);
    }

    @Test
    public void testReplaceEachRepeatedly_EmptySearchList_ReturnsOriginalText() {
        // Arrange
        String text = "aba";
        String[] searchList = {};
        String[] replacementList = {"b"};

        // Act
        String result = StringUtils.replaceEachRepeatedly(text, searchList, replacementList);

        // Assert
        assertEquals("aba", result);
    }

    @Test
    public void testReplaceEachRepeatedly_EmptyReplacementList_ReturnsOriginalText() {
        // Arrange
        String text = "aba";
        String[] searchList = {"a"};
        String[] replacementList = {};

        // Act
        String result = StringUtils.replaceEachRepeatedly(text, searchList, replacementList);

        // Assert
        assertEquals("aba", result);
    }

    @Test
    public void testReplaceEachRepeatedly_SingleSearchSingleReplacement_ReturnsReplacedText() {
        // Arrange
        String text = "aba";
        String[] searchList = {"a"};
        String[] replacementList = {"b"};

        // Act
        String result = StringUtils.replaceEachRepeatedly(text, searchList, replacementList);

        // Assert
        assertEquals("bbb", result);
    }

//    @Test
//    public void testReplaceEachRepeatedly_SingleSearchMultipleReplacements_ReturnsReplacedText() {
//        // Arrange
//        String text = "aba";
//        String[] searchList = {"a"};
//        String[] replacementList = {"b", "c"};
//
//        // Act
//        String result = StringUtils.replaceEachRepeatedly(text, searchList, replacementList);
//
//        // Assert
//        assertEquals("bbc", result);
//    }

    @Test
    public void testReplaceEachRepeatedly_MultipleSearchSingleReplacement_ReturnsReplacedText() {
        // Arrange
        String text = "abcde";
        String[] searchList = {"ab", "d"};
        String[] replacementList = {"w", "t"};

        // Act
        String result = StringUtils.replaceEachRepeatedly(text, searchList, replacementList);

        // Assert
        assertEquals("wcte", result);
    }

    @Test
    public void testReplaceEachRepeatedly_MultipleSearchMultipleReplacements_ReturnsReplacedText() {
        // Arrange
        String text = "abcde";
        String[] searchList = {"ab", "d"};
        String[] replacementList = {"d", "t"};

        // Act
        String result = StringUtils.replaceEachRepeatedly(text, searchList, replacementList);

        // Assert
        assertEquals("tcte", result);
    }

    @Test
    public void testReplaceEachRepeatedly_ReplacementLoop_ThrowsIllegalStateException() {
        // Arrange
        String text = "abcde";
        String[] searchList = {"ab", "d"};
        String[] replacementList = {"d", "ab"};

        // Act & Assert
        assertThrows(IllegalStateException.class, () -> StringUtils.replaceEachRepeatedly(text, searchList, replacementList));
    }

    @Test
    public void testReplaceEachRepeatedly_DifferentLengthSearchAndReplacement_ThrowsIllegalArgumentException() {
        // Arrange
        String text = "abcde";
        String[] searchList = {"ab"};
        String[] replacementList = {"d", "t"};

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> StringUtils.replaceEachRepeatedly(text, searchList, replacementList));
    }




    @Test
    public void rightPad_NullString_ReturnsNull() {
        // Instantiate all necessary variables here
        String str = null;
        int size = 5;

        // Mock any dependencies here

        // Write the test code here following the given rules
        String result = StringUtils.rightPad(str, size);

        // Perform assertions here
        assertNull(result);
    }

    @Test
    public void rightPad_EmptyString_ReturnsPaddedStringWithSpaces() {
        // Instantiate all necessary variables here
        String str = "";
        int size = 5;

        // Mock any dependencies here

        // Write the test code here following the given rules
        String result = StringUtils.rightPad(str, size);

        // Perform assertions here
        assertEquals("     ", result);
    }

    @Test
    public void rightPad_StringShorterThanSize_ReturnsPaddedStringWithSpaces() {
        // Instantiate all necessary variables here
        String str = "bat";
        int size = 5;

        // Mock any dependencies here

        // Write the test code here following the given rules
        String result = StringUtils.rightPad(str, size);

        // Perform assertions here
        assertEquals("bat  ", result);
    }

    @Test
    public void rightPad_StringEqualToSize_ReturnsOriginalString() {
        // Instantiate all necessary variables here
        String str = "bat";
        int size = 3;

        // Mock any dependencies here

        // Write the test code here following the given rules
        String result = StringUtils.rightPad(str, size);

        // Perform assertions here
        assertEquals("bat", result);
    }

    @Test
    public void rightPad_StringLongerThanSize_ReturnsOriginalString() {
        // Instantiate all necessary variables here
        String str = "bat";
        int size = 2;

        // Mock any dependencies here

        // Write the test code here following the given rules
        String result = StringUtils.rightPad(str, size);

        // Perform assertions here
        assertEquals("bat", result);
    }

    @Test
    public void rightPad_StringWithCustomPaddingCharacter_ReturnsPaddedStringWithCustomCharacter() {
        // Instantiate all necessary variables here
        String str = "bat";
        int size = 5;
        char padChar = 'z';

        // Mock any dependencies here

        // Write the test code here following the given rules
        String result = StringUtils.rightPad(str, size, padChar);

        // Perform assertions here
        assertEquals("batzz", result);
    }

    @Test
    public void rightPad_StringWithCustomPaddingString_ReturnsPaddedStringWithCustomString() {
        // Instantiate all necessary variables here
        String str = "bat";
        int size = 8;
        String padStr = "yz";

        // Mock any dependencies here

        // Write the test code here following the given rules
        String result = StringUtils.rightPad(str, size, padStr);

        // Perform assertions here
        assertEquals("batyzyzy", result);
    }

    @Test
    public void rightPad_StringWithEmptyPaddingString_ReturnsPaddedStringWithSpaces() {
        // Instantiate all necessary variables here
        String str = "bat";
        int size = 5;
        String padStr = "";

        // Mock any dependencies here

        // Write the test code here following the given rules
        String result = StringUtils.rightPad(str, size, padStr);

        // Perform assertions here
        assertEquals("bat  ", result);
    }

    @Test
    public void rightPad_StringWithNullPaddingString_ReturnsPaddedStringWithSpaces() {
        // Instantiate all necessary variables here
        String str = "bat";
        int size = 5;
        String padStr = null;

        // Mock any dependencies here

        // Write the test code here following the given rules
        String result = StringUtils.rightPad(str, size, padStr);

        // Perform assertions here
        assertEquals("bat  ", result);
    }




    @Test
    public void testIsAllLowerCase_NullString_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = null;

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllLowerCase(cs);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsAllLowerCase_EmptyString_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "";

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllLowerCase(cs);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsAllLowerCase_WhiteSpaceString_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "  ";

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllLowerCase(cs);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsAllLowerCase_AllLowerCaseString_ReturnsTrue() {
        // Instantiate all necessary variables here
        CharSequence cs = "abc";

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllLowerCase(cs);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testIsAllLowerCase_ContainsUpperCaseString_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "abC";

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllLowerCase(cs);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsAllLowerCase_ContainsSpaceString_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "ab c";

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllLowerCase(cs);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsAllLowerCase_ContainsNumberString_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "ab1c";

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllLowerCase(cs);

        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsAllLowerCase_ContainsSpecialCharacterString_ReturnsFalse() {
        // Instantiate all necessary variables here
        CharSequence cs = "ab/c";

        // Write the test code here following the given rules
        boolean result = StringUtils.isAllLowerCase(cs);

        // Assert
        assertFalse(result);
    }




    @Test
    public void testMid_NullString_ReturnNull() {
        // Instantiate all necessary variables here
        String str = null;
        int pos = 0;
        int len = 1;

        // Write the test code here following the given rules
        String result = StringUtils.mid(str, pos, len);

        assertNull(result);
    }

    @Test
    public void testMid_NegativeLen_ReturnEmptyString() {
        // Instantiate all necessary variables here
        String str = "abc";
        int pos = 0;
        int len = -1;

        // Write the test code here following the given rules
        String result = StringUtils.mid(str, pos, len);

        assertEquals("", result);
    }

    @Test
    public void testMid_EmptyString_ReturnEmptyString() {
        // Instantiate all necessary variables here
        String str = "";
        int pos = 0;
        int len = 1;

        // Write the test code here following the given rules
        String result = StringUtils.mid(str, pos, len);

        assertEquals("", result);
    }

    @Test
    public void testMid_PosZeroLenTwo_ReturnSubstring() {
        // Instantiate all necessary variables here
        String str = "abc";
        int pos = 0;
        int len = 2;

        // Write the test code here following the given rules
        String result = StringUtils.mid(str, pos, len);

        assertEquals("ab", result);
    }

    @Test
    public void testMid_PosZeroLenFour_ReturnOriginalString() {
        // Instantiate all necessary variables here
        String str = "abc";
        int pos = 0;
        int len = 4;

        // Write the test code here following the given rules
        String result = StringUtils.mid(str, pos, len);

        assertEquals("abc", result);
    }

    @Test
    public void testMid_PosTwoLenFour_ReturnSubstring() {
        // Instantiate all necessary variables here
        String str = "abc";
        int pos = 2;
        int len = 4;

        // Write the test code here following the given rules
        String result = StringUtils.mid(str, pos, len);

        assertEquals("c", result);
    }

    @Test
    public void testMid_PosFourLenTwo_ReturnEmptyString() {
        // Instantiate all necessary variables here
        String str = "abc";
        int pos = 4;
        int len = 2;

        // Write the test code here following the given rules
        String result = StringUtils.mid(str, pos, len);

        assertEquals("", result);
    }

    @Test
    public void testMid_NegativePosLenTwo_ReturnSubstring() {
        // Instantiate all necessary variables here
        String str = "abc";
        int pos = -2;
        int len = 2;

        // Write the test code here following the given rules
        String result = StringUtils.mid(str, pos, len);

        assertEquals("ab", result);
    }





    @Test
    public void defaultString_NullInput_ReturnsEmptyString() {
        // Arrange
        String input = null;

        // Act
        String result = StringUtils.defaultString(input);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void defaultString_EmptyStringInput_ReturnsEmptyString() {
        // Arrange
        String input = "";

        // Act
        String result = StringUtils.defaultString(input);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void defaultString_NonEmptyStringInput_ReturnsSameString() {
        // Arrange
        String input = "bat";

        // Act
        String result = StringUtils.defaultString(input);

        // Assert
        assertEquals("bat", result);
    }

    @Test
    public void defaultString_NullInputWithNullDefault_ReturnsNullDefault() {
        // Arrange
        String input = null;
        String nullDefault = "NULL";

        // Act
        String result = StringUtils.defaultString(input, nullDefault);

        // Assert
        assertEquals(nullDefault, result);
    }

    @Test
    public void defaultString_EmptyStringInputWithNullDefault_ReturnsEmptyString() {
        // Arrange
        String input = "";
        String nullDefault = "NULL";

        // Act
        String result = StringUtils.defaultString(input, nullDefault);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void defaultString_NonEmptyStringInputWithNullDefault_ReturnsSameString() {
        // Arrange
        String input = "bat";
        String nullDefault = "NULL";

        // Act
        String result = StringUtils.defaultString(input, nullDefault);

        // Assert
        assertEquals("bat", result);
    }

    @Test
    public void defaultString_NullInputWithNullDefaultUsingObjectsToString_ReturnsNullDefault() {
        // Arrange
        String input = null;
        String nullDefault = "NULL";

        // Act
        String result = Objects.toString(input, nullDefault);

        // Assert
        assertEquals(nullDefault, result);
    }

    @Test
    public void defaultString_EmptyStringInputWithNullDefaultUsingObjectsToString_ReturnsEmptyString() {
        // Arrange
        String input = "";
        String nullDefault = "NULL";

        // Act
        String result = Objects.toString(input, nullDefault);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void defaultString_NonEmptyStringInputWithNullDefaultUsingObjectsToString_ReturnsSameString() {
        // Arrange
        String input = "bat";
        String nullDefault = "NULL";

        // Act
        String result = Objects.toString(input, nullDefault);

        // Assert
        assertEquals("bat", result);
    }




    @Test
    public void testSubstringBetween_WithValidInput_ReturnsSubstring() {
        // Instantiate all necessary variables here
        String str = "tagabctag";
        String tag = "tag";

        // Write the test code here following the given rules
        String result = StringUtils.substringBetween(str, tag);
        assertEquals("abc", result);
    }

    @Test
    public void testSubstringBetween_WithNullString_ReturnsNull() {
        // Instantiate all necessary variables here
        String str = null;
        String tag = "tag";

        // Write the test code here following the given rules
        String result = StringUtils.substringBetween(str, tag);
        assertNull(result);
    }

    @Test
    public void testSubstringBetween_WithNullTag_ReturnsNull() {
        // Instantiate all necessary variables here
        String str = "tagabctag";
        String tag = null;

        // Write the test code here following the given rules
        String result = StringUtils.substringBetween(str, tag);
        assertNull(result);
    }

    @Test
    public void testSubstringBetween_WithEmptyString_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        String str = "";
        String tag = "";

        // Write the test code here following the given rules
        String result = StringUtils.substringBetween(str, tag);
        assertEquals("", result);
    }

    @Test
    public void testSubstringBetween_WithNoMatch_ReturnsNull() {
        // Instantiate all necessary variables here
        String str = "tagabctag";
        String tag = "xyz";

        // Write the test code here following the given rules
        String result = StringUtils.substringBetween(str, tag);
        assertNull(result);
    }




    @Test
    public void testPrependIfMissing_NullStringAndNullPrefix_ReturnsNull() {
        // Instantiate all necessary variables here
        String str = null;
        CharSequence prefix = null;

        // Write the test code here following the given rules
        String result = StringUtils.prependIfMissing(str, prefix);

        // Assert
        assertNull(result);
    }

    @Test
    public void testPrependIfMissing_StringAndNullPrefix_ReturnsString() {
        // Instantiate all necessary variables here
        String str = "abc";
        CharSequence prefix = null;

        // Write the test code here following the given rules
        String result = StringUtils.prependIfMissing(str, prefix);

        // Assert
        assertEquals("abc", result);
    }

    @Test
    public void testPrependIfMissing_EmptyStringAndPrefix_ReturnsPrefix() {
        // Instantiate all necessary variables here
        String str = "";
        CharSequence prefix = "xyz";

        // Write the test code here following the given rules
        String result = StringUtils.prependIfMissing(str, prefix);

        // Assert
        assertEquals("xyz", result);
    }

    @Test
    public void testPrependIfMissing_StringAndPrefix_ReturnsStringWithPrefix() {
        // Instantiate all necessary variables here
        String str = "abc";
        CharSequence prefix = "xyz";

        // Write the test code here following the given rules
        String result = StringUtils.prependIfMissing(str, prefix);

        // Assert
        assertEquals("xyzabc", result);
    }

//    @Test
//    public void testPrependIfMissing_StringAndPrefixes_ReturnsStringWithFirstValidPrefix() {
//        // Instantiate all necessary variables here
//        String str = "abc";
//        CharSequence prefix = "xyz";
//        CharSequence[] prefixes = {"mno", null, ""};
//
//        // Write the test code here following the given rules
//        String result = StringUtils.prependIfMissing(str, prefix, prefixes);
//
//        // Assert
//        assertEquals("xyzabc", result);
//    }

//    @Test
//    public void testPrependIfMissing_StringAndPrefixesNoMatch_ReturnsUnmodifiedString() {
//        // Instantiate all necessary variables here
//        String str = "abc";
//        CharSequence prefix = "xyz";
//        CharSequence[] prefixes = {"mno"};
//
//        // Write the test code here following the given rules
//        String result = StringUtils.prependIfMissing(str, prefix, prefixes);
//
//        // Assert
//        assertEquals("abc", result);
//    }

    @Test
    public void testPrependIfMissing_StringWithValidPrefix_ReturnsStringWithValidPrefix() {
        // Instantiate all necessary variables here
        String str = "xyzabc";
        CharSequence prefix = "xyz";
        CharSequence[] prefixes = {"mno"};

        // Write the test code here following the given rules
        String result = StringUtils.prependIfMissing(str, prefix, prefixes);

        // Assert
        assertEquals("xyzabc", result);
    }

    @Test
    public void testPrependIfMissing_StringWithInvalidPrefix_ReturnsStringWithoutInvalidPrefix() {
        // Instantiate all necessary variables here
        String str = "MNOabc";
        CharSequence prefix = "xyz";
        CharSequence[] prefixes = {"mno"};

        // Write the test code here following the given rules
        String result = StringUtils.prependIfMissing(str, prefix, prefixes);

        // Assert
        assertEquals("xyzMNOabc", result);
    }




    @Test
    public void replaceOnce_NullInput_ReturnsNull() {
        // Instantiate all necessary variables here
        String text = null;
        String searchString = "a";
        String replacement = "z";

        // Write the test code here following the given rules
        String result = StringUtils.replaceOnce(text, searchString, replacement);

        assertNull(result);
    }

    @Test
    public void replaceOnce_EmptyInput_ReturnsEmptyString() {
        // Instantiate all necessary variables here
        String text = "";
        String searchString = "a";
        String replacement = "z";

        // Write the test code here following the given rules
        String result = StringUtils.replaceOnce(text, searchString, replacement);

        assertEquals("", result);
    }

    @Test
    public void replaceOnce_NullSearchString_ReturnsOriginalText() {
        // Instantiate all necessary variables here
        String text = "any";
        String searchString = null;
        String replacement = "z";

        // Write the test code here following the given rules
        String result = StringUtils.replaceOnce(text, searchString, replacement);

        assertEquals("any", result);
    }

    @Test
    public void replaceOnce_NullReplacement_ReturnsOriginalText() {
        // Instantiate all necessary variables here
        String text = "any";
        String searchString = "a";
        String replacement = null;

        // Write the test code here following the given rules
        String result = StringUtils.replaceOnce(text, searchString, replacement);

        assertEquals("any", result);
    }

    @Test
    public void replaceOnce_EmptySearchString_ReturnsOriginalText() {
        // Instantiate all necessary variables here
        String text = "any";
        String searchString = "";
        String replacement = "z";

        // Write the test code here following the given rules
        String result = StringUtils.replaceOnce(text, searchString, replacement);

        assertEquals("any", result);
    }

    @Test
    public void replaceOnce_NoMatch_ReturnsOriginalText() {
        // Instantiate all necessary variables here
        String text = "aba";
        String searchString = "x";
        String replacement = "z";

        // Write the test code here following the given rules
        String result = StringUtils.replaceOnce(text, searchString, replacement);

        assertEquals("aba", result);
    }

    @Test
    public void replaceOnce_MatchAndReplacementIsNull_ReturnsTextWithoutMatch() {
        // Instantiate all necessary variables here
        String text = "aba";
        String searchString = "a";
        String replacement = "";

        // Write the test code here following the given rules
        String result = StringUtils.replaceOnce(text, searchString, replacement);

        assertEquals("ba", result);
    }

    @Test
    public void replaceOnce_MatchAndReplacementIsNotNull_ReturnsTextWithReplacement() {
        // Instantiate all necessary variables here
        String text = "aba";
        String searchString = "a";
        String replacement = "z";

        // Write the test code here following the given rules
        String result = StringUtils.replaceOnce(text, searchString, replacement);

        assertEquals("zba", result);
    }




//    @Test
//    public void testContainsAnyIgnoreCase() {
//        // Instantiate all necessary variables here
//        CharSequence cs = "abcd";
//        CharSequence[] searchCharSequences = {"ab", "cd"};
//
//        // Mock StringUtils class
//        StringUtils stringUtils = mock(StringUtils.class);
//
//        // Mock StringUtils.containsIgnoreCase method
//        when(stringUtils.containsIgnoreCase(any(CharSequence.class), any(CharSequence.class))).thenReturn(true);
//
//        // Call the method to be tested
//        boolean result = StringUtils.containsAnyIgnoreCase(cs, searchCharSequences);
//
//        // Verify that StringUtils.containsIgnoreCase was called with correct arguments
//        verify(stringUtils).containsIgnoreCase(eq(cs), eq("ab"));
//        verify(stringUtils).containsIgnoreCase(eq(cs), eq("cd"));
//
//        // Assert the result
//        assertTrue(result);
//    }




//    @Test
//    public void testLowerCase() {
//        // Instantiate all necessary variables here
//        String str = "TEST";
//        String expected = "test";
//
//        // Mock any dependencies here (if any)
//        Locale locale = Locale.ENGLISH;
//
//        // Mock the behavior of dependencies (if any)
//        when(StringUtils.lowerCase(str)).thenReturn(expected);
//        when(StringUtils.lowerCase(str, locale)).thenReturn(expected);
//
//        // Write the test code here following the given rules
//        String result1 = StringUtils.lowerCase(str);
//        assertEquals(expected, result1);
//
//        String result2 = StringUtils.lowerCase(str, locale);
//        assertEquals(expected, result2);
//    }










    @Test
    public void testSubstringAfterWithNullStringShouldReturnNull() {
        // Arrange
        String str = null;
        int separator = 'a';

        // Act
        String result = StringUtils.substringAfter(str, separator);

        // Assert
        assertNull(result);
    }

    @Test
    public void testSubstringAfterWithEmptyStringShouldReturnEmptyString() {
        // Arrange
        String str = "";
        int separator = 'a';

        // Act
        String result = StringUtils.substringAfter(str, separator);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterWithNoSeparatorShouldReturnEmptyString() {
        // Arrange
        String str = "abc";
        int separator = 'd';

        // Act
        String result = StringUtils.substringAfter(str, separator);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterWithSeparatorAtBeginningShouldReturnSubstring() {
        // Arrange
        String str = "abc";
        int separator = 'a';

        // Act
        String result = StringUtils.substringAfter(str, separator);

        // Assert
        assertEquals("bc", result);
    }

    @Test
    public void testSubstringAfterWithSeparatorInMiddleShouldReturnSubstring() {
        // Arrange
        String str = "abcba";
        int separator = 'b';

        // Act
        String result = StringUtils.substringAfter(str, separator);

        // Assert
        assertEquals("cba", result);
    }

    @Test
    public void testSubstringAfterWithSeparatorAtEndShouldReturnEmptyString() {
        // Arrange
        String str = "abc";
        int separator = 'c';

        // Act
        String result = StringUtils.substringAfter(str, separator);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterWithSeparatorNotPresentShouldReturnEmptyString() {
        // Arrange
        String str = "abc";
        int separator = 'd';

        // Act
        String result = StringUtils.substringAfter(str, separator);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterWithNullSeparatorShouldReturnEmptyString() {
        // Arrange
        String str = "abc";
        int separator = '\0';

        // Act
        String result = StringUtils.substringAfter(str, separator);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterWithNullStringAndSeparatorShouldReturnNull() {
        // Arrange
        String str = null;
        String separator = "a";

        // Act
        String result = StringUtils.substringAfter(str, separator);

        // Assert
        assertNull(result);
    }

    @Test
    public void testSubstringAfterWithEmptyStringAndSeparatorShouldReturnEmptyString() {
        // Arrange
        String str = "";
        String separator = "a";

        // Act
        String result = StringUtils.substringAfter(str, separator);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterWithNullSeparatorAndNonNullStringShouldReturnEmptyString() {
        // Arrange
        String str = "abc";
        String separator = null;

        // Act
        String result = StringUtils.substringAfter(str, separator);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterWithNoSeparatorShouldReturnEmptyString1() {
        // Arrange
        String str = "abc";
        String separator = "d";

        // Act
        String result = StringUtils.substringAfter(str, separator);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterWithSeparatorAtBeginningShouldReturnSubstring2() {
        // Arrange
        String str = "abc";
        String separator = "a";

        // Act
        String result = StringUtils.substringAfter(str, separator);

        // Assert
        assertEquals("bc", result);
    }

    @Test
    public void testSubstringAfterWithSeparatorInMiddleShouldReturnSubstring3() {
        // Arrange
        String str = "abcba";
        String separator = "b";

        // Act
        String result = StringUtils.substringAfter(str, separator);

        // Assert
        assertEquals("cba", result);
    }

    @Test
    public void testSubstringAfterWithSeparatorAtEndShouldReturnEmptyString4() {
        // Arrange
        String str = "abc";
        String separator = "c";

        // Act
        String result = StringUtils.substringAfter(str, separator);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterWithSeparatorNotPresentShouldReturnEmptyString2() {
        // Arrange
        String str = "abc";
        String separator = "d";

        // Act
        String result = StringUtils.substringAfter(str, separator);

        // Assert
        assertEquals("", result);
    }

    @Test
    public void testSubstringAfterWithEmptySeparatorShouldReturnInputString() {
        // Arrange
        String str = "abc";
        String separator = "";

        // Act
        String result = StringUtils.substringAfter(str, separator);

        // Assert
        assertEquals("abc", result);
    }

}