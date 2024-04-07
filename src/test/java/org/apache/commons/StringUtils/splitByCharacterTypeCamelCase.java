import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class splitByCharacterTypeCamelCaseTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    void testSplitByCharacterTypeCamelCase_NullString_ReturnNull() {
        String[] result = stringUtils.splitByCharacterTypeCamelCase(null);
        assertNull(result);
    }

    @Test
    void testSplitByCharacterTypeCamelCase_EmptyString_ReturnEmptyArray() {
        String[] result = stringUtils.splitByCharacterTypeCamelCase("");
        assertEquals(0, result.length);
    }

    @Test
    void testSplitByCharacterTypeCamelCase_SingleWordString_ReturnSingleElementArray() {
        String[] result = stringUtils.splitByCharacterTypeCamelCase("word");
        assertEquals(1, result.length);
        assertEquals("word", result[0]);
    }

    @Test
    void testSplitByCharacterTypeCamelCase_SingleWordStringWithNumbers_ReturnSingleElementArray() {
        String[] result = stringUtils.splitByCharacterTypeCamelCase("word123");
        assertEquals(1, result.length);
        assertEquals("word123", result[0]);
    }

    @Test
    void testSplitByCharacterTypeCamelCase_SingleWordStringWithSpecialCharacters_ReturnSingleElementArray() {
        String[] result = stringUtils.splitByCharacterTypeCamelCase("word@#$");
        assertEquals(1, result.length);
        assertEquals("word@#$", result[0]);
    }

    @Test
    void testSplitByCharacterTypeCamelCase_TwoWordsString_ReturnTwoElementArray() {
        String[] result = stringUtils.splitByCharacterTypeCamelCase("twoWords");
        assertEquals(2, result.length);
        assertEquals("two", result[0]);
        assertEquals("Words", result[1]);
    }

    @Test
    void testSplitByCharacterTypeCamelCase_TwoWordsStringWithNumbers_ReturnTwoElementArray() {
        String[] result = stringUtils.splitByCharacterTypeCamelCase("twoWords123");
        assertEquals(2, result.length);
        assertEquals("two", result[0]);
        assertEquals("Words123", result[1]);
    }

    @Test
    void testSplitByCharacterTypeCamelCase_TwoWordsStringWithSpecialCharacters_ReturnTwoElementArray() {
        String[] result = stringUtils.splitByCharacterTypeCamelCase("twoWords@#$");
        assertEquals(2, result.length);
        assertEquals("two", result[0]);
        assertEquals("Words@#$", result[1]);
    }

    @Test
    void testSplitByCharacterTypeCamelCase_MultipleWordsString_ReturnMultipleElementArray() {
        String[] result = stringUtils.splitByCharacterTypeCamelCase("multipleWordsInString");
        assertEquals(4, result.length);
        assertEquals("multiple", result[0]);
        assertEquals("Words", result[1]);
        assertEquals("In", result[2]);
        assertEquals("String", result[3]);
    }

    @Test
    void testSplitByCharacterTypeCamelCase_MultipleWordsStringWithNumbers_ReturnMultipleElementArray() {
        String[] result = stringUtils.splitByCharacterTypeCamelCase("multipleWords123InString");
        assertEquals(4, result.length);
        assertEquals("multiple", result[0]);
        assertEquals("Words123", result[1]);
        assertEquals("In", result[2]);
        assertEquals("String", result[3]);
    }

    @Test
    void testSplitByCharacterTypeCamelCase_MultipleWordsStringWithSpecialCharacters_ReturnMultipleElementArray() {
        String[] result = stringUtils.splitByCharacterTypeCamelCase("multipleWords@#$InString");
        assertEquals(4, result.length);
        assertEquals("multiple", result[0]);
        assertEquals("Words@#$", result[1]);
        assertEquals("In", result[2]);
        assertEquals("String", result[3]);
    }
}