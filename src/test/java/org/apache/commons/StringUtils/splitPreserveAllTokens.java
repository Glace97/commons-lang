
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SplitPreserveAllTokensTest {
    
    private StringUtils stringUtils;
    
    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }
    
    @Test
    void testSplitPreserveAllTokens_NullInput_ReturnNull() {
        String[] result = stringUtils.splitPreserveAllTokens(null);
        assertNull(result);
    }
    
    @Test
    void testSplitPreserveAllTokens_EmptyInput_ReturnEmptyArray() {
        String[] result = stringUtils.splitPreserveAllTokens("");
        assertEquals(0, result.length);
    }
    
    @Test
    void testSplitPreserveAllTokens_InputWithNoSeparators_ReturnArrayWithOneElement() {
        String[] result = stringUtils.splitPreserveAllTokens("abc def");
        assertEquals(1, result.length);
        assertEquals("abc def", result[0]);
    }
    
    @Test
    void testSplitPreserveAllTokens_InputWithSingleSeparator_ReturnArrayWithTwoElements() {
        String[] result = stringUtils.splitPreserveAllTokens("a.b.c", '.');
        assertEquals(2, result.length);
        assertEquals("a", result[0]);
        assertEquals("b.c", result[1]);
    }
    
    @Test
    void testSplitPreserveAllTokens_InputWithMultipleSeparators_ReturnArrayWithMultipleElements() {
        String[] result = stringUtils.splitPreserveAllTokens("a..b.c", '.');
        assertEquals(4, result.length);
        assertEquals("a", result[0]);
        assertEquals("", result[1]);
        assertEquals("b", result[2]);
        assertEquals("c", result[3]);
    }
    
    @Test
    void testSplitPreserveAllTokens_InputWithWhitespaceSeparator_ReturnArrayWithMultipleElements() {
        String[] result = stringUtils.splitPreserveAllTokens("a b c", ' ');
        assertEquals(3, result.length);
        assertEquals("a", result[0]);
        assertEquals("b", result[1]);
        assertEquals("c", result[2]);
    }
    
    @Test
    void testSplitPreserveAllTokens_InputWithWhitespaceSeparatorAtStart_ReturnArrayWithEmptyFirstElement() {
        String[] result = stringUtils.splitPreserveAllTokens(" a b c", ' ');
        assertEquals(4, result.length);
        assertEquals("", result[0]);
        assertEquals("a", result[1]);
        assertEquals("b", result[2]);
        assertEquals("c", result[3]);
    }
    
    @Test
    void testSplitPreserveAllTokens_InputWithWhitespaceSeparatorAtEnd_ReturnArrayWithEmptyLastElement() {
        String[] result = stringUtils.splitPreserveAllTokens("a b c ", ' ');
        assertEquals(4, result.length);
        assertEquals("a", result[0]);
        assertEquals("b", result[1]);
        assertEquals("c", result[2]);
        assertEquals("", result[3]);
    }
    
    @Test
    void testSplitPreserveAllTokens_InputWithWhitespaceSeparatorsAtStartAndEnd_ReturnArrayWithEmptyFirstAndLastElement() {
        String[] result = stringUtils.splitPreserveAllTokens(" a b c ", ' ');
        assertEquals(5, result.length);
        assertEquals("", result[0]);
        assertEquals("a", result[1]);
        assertEquals("b", result[2]);
        assertEquals("c", result[3]);
        assertEquals("", result[4]);
    }
    
    @Test
    void testSplitPreserveAllTokens_InputWithNullSeparator_ReturnArrayWithMultipleElementsSeparatedByWhitespace() {
        String[] result = stringUtils.splitPreserveAllTokens("a\tb\nc", null);
        assertEquals(3, result.length);
        assertEquals("a", result[0]);
        assertEquals("b", result[1]);
        assertEquals("c", result[2]);
    }
    
    @Test
    void testSplitPreserveAllTokens_InputWithNullSeparatorChars_ReturnArrayWithMultipleElementsSeparatedByWhitespace() {
        String[] result = stringUtils.splitPreserveAllTokens("abc def", null);
        assertEquals(2, result.length);
        assertEquals("abc", result[0]);
        assertEquals("def", result[1]);
    }
    
    @Test
    void testSplitPreserveAllTokens_InputWithEmptySeparatorChars_ReturnArrayWithMultipleElementsSeparatedByWhitespace() {
        String[] result = stringUtils.splitPreserveAllTokens("abc def", "");
        assertEquals(2, result.length);
        assertEquals("abc", result[0]);
        assertEquals("def", result[1]);
    }
    
    @Test
    void testSplitPreserveAllTokens_InputWithNullSeparatorCharsAndMax_ReturnArrayWithMaxElementsSeparatedByWhitespace() {
        String[] result = stringUtils.splitPreserveAllTokens("a b c", null, 2);
        assertEquals(2, result.length);
        assertEquals("a", result[0]);
        assertEquals("b c", result[1]);
    }
    
    @Test
    void testSplitPreserveAllTokens_InputWithNullSeparatorCharsAndZeroMax_ReturnArrayWithAllElementsSeparatedByWhitespace() {
        String[] result = stringUtils.splitPreserveAllTokens("a b c", null, 0);
        assertEquals(3, result.length);
        assertEquals("a", result[0]);
        assertEquals("b", result[1]);
        assertEquals("c", result[2]);
    }
    
    @Test
    void testSplitPreserveAllTokens_InputWithMultipleSeparatorsAndMax_ReturnArrayWithMaxElements() {
        String[] result = stringUtils.splitPreserveAllTokens("a:b:c", ':', 2);
        assertEquals(2, result.length);
        assertEquals("a", result[0]);
        assertEquals("b:c", result[1]);
    }
    
    @Test
    void testSplitPreserveAllTokens_InputWithWhitespaceSeparatorAndMax_ReturnArrayWithMaxElements() {
        String[] result = stringUtils.splitPreserveAllTokens("a b c", ' ', 2);
        assertEquals(2, result.length);
        assertEquals("a", result[0]);
        assertEquals("b c", result[1]);
    }
    
}
