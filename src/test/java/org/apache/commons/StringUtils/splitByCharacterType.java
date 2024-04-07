import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class splitByCharacterTypeTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    void testSplitByCharacterType_Null_ReturnsNull() {
        String[] result = stringUtils.splitByCharacterType(null);
        assertNull(result);
    }

    @Test
    void testSplitByCharacterType_EmptyString_ReturnsEmptyArray() {
        String[] result = stringUtils.splitByCharacterType("");
        assertEquals(0, result.length);
    }

    @Test
    void testSplitByCharacterType_Whitespace_ReturnsArrayWithWhitespace() {
        String[] result = stringUtils.splitByCharacterType(" ");
        assertEquals(1, result.length);
        assertEquals(" ", result[0]);
    }

    @Test
    void testSplitByCharacterType_SingleCharacter_ReturnsArrayWithSingleCharacter() {
        String[] result = stringUtils.splitByCharacterType("a");
        assertEquals(1, result.length);
        assertEquals("a", result[0]);
    }

    @Test
    void testSplitByCharacterType_MultipleCharacters_ReturnsArrayWithEachCharacter() {
        String[] result = stringUtils.splitByCharacterType("abc");
        assertEquals(3, result.length);
        assertEquals("a", result[0]);
        assertEquals("b", result[1]);
        assertEquals("c", result[2]);
    }

    @Test
    void testSplitByCharacterType_MixedCharacters_ReturnsArrayWithEachCharacterAndWhitespace() {
        String[] result = stringUtils.splitByCharacterType("ab de fg");
        assertEquals(5, result.length);
        assertEquals("ab", result[0]);
        assertEquals(" ", result[1]);
        assertEquals("de", result[2]);
        assertEquals(" ", result[3]);
        assertEquals("fg", result[4]);
    }

    @Test
    void testSplitByCharacterType_SpecialCharacters_ReturnsArrayWithEachCharacterAndSpecialCharacters() {
        String[] result = stringUtils.splitByCharacterType("ab:cd:ef");
        assertEquals(5, result.length);
        assertEquals("ab", result[0]);
        assertEquals(":", result[1]);
        assertEquals("cd", result[2]);
        assertEquals(":", result[3]);
        assertEquals("ef", result[4]);
    }

    @Test
    void testSplitByCharacterType_NumberAndLetters_ReturnsArrayWithNumberAndLetters() {
        String[] result = stringUtils.splitByCharacterType("number5");
        assertEquals(2, result.length);
        assertEquals("number", result[0]);
        assertEquals("5", result[1]);
    }

    @Test
    void testSplitByCharacterType_CamelCase_ReturnsArrayWithWordsSeparatedByCapitalLetters() {
        String[] result = stringUtils.splitByCharacterType("fooBar");
        assertEquals(3, result.length);
        assertEquals("foo", result[0]);
        assertEquals("B", result[1]);
        assertEquals("ar", result[2]);
    }

    @Test
    void testSplitByCharacterType_CamelCaseWithNumbers_ReturnsArrayWithWordsSeparatedByCapitalLettersAndNumbers() {
        String[] result = stringUtils.splitByCharacterType("foo200Bar");
        assertEquals(4, result.length);
        assertEquals("foo", result[0]);
        assertEquals("200", result[1]);
        assertEquals("B", result[2]);
        assertEquals("ar", result[3]);
    }

    @Test
    void testSplitByCharacterType_AllCaps_ReturnsArrayWithWordsSeparatedByCapitalLetters() {
        String[] result = stringUtils.splitByCharacterType("ASFRules");
        assertEquals(2, result.length);
        assertEquals("ASFR", result[0]);
        assertEquals("ules", result[1]);
    }
}