import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class splitByWholeSeparatorPreserveAllTokensTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    void testSplitByWholeSeparatorPreserveAllTokens_NullString_ReturnsNull() {
        String[] result = stringUtils.splitByWholeSeparatorPreserveAllTokens(null, ":");
        assertNull(result);
    }

    @Test
    void testSplitByWholeSeparatorPreserveAllTokens_EmptyString_ReturnsEmptyArray() {
        String[] result = stringUtils.splitByWholeSeparatorPreserveAllTokens("", ":");
        assertEquals(0, result.length);
    }

    @Test
    void testSplitByWholeSeparatorPreserveAllTokens_NullSeparator_SplitsOnWhitespace() {
        String[] result = stringUtils.splitByWholeSeparatorPreserveAllTokens("ab   de fg", null);
        assertEquals(5, result.length);
        assertEquals("ab", result[0]);
        assertEquals("", result[1]);
        assertEquals("", result[2]);
        assertEquals("de", result[3]);
        assertEquals("fg", result[4]);
    }

    @Test
    void testSplitByWholeSeparatorPreserveAllTokens_SingleSeparator_SplitsString() {
        String[] result = stringUtils.splitByWholeSeparatorPreserveAllTokens("ab:cd:ef", ":");
        assertEquals(3, result.length);
        assertEquals("ab", result[0]);
        assertEquals("cd", result[1]);
        assertEquals("ef", result[2]);
    }

    @Test
    void testSplitByWholeSeparatorPreserveAllTokens_MultipleSeparators_SplitsString() {
        String[] result = stringUtils.splitByWholeSeparatorPreserveAllTokens("ab-!-cd-!-ef", "-!-");
        assertEquals(3, result.length);
        assertEquals("ab", result[0]);
        assertEquals("cd", result[1]);
        assertEquals("ef", result[2]);
    }

    @Test
    void testSplitByWholeSeparatorPreserveAllTokens_MultipleSeparatorsWithLimit_SplitsStringWithLimit() {
        String[] result = stringUtils.splitByWholeSeparatorPreserveAllTokens("ab-!-cd-!-ef", "-!-", 2);
        assertEquals(2, result.length);
        assertEquals("ab", result[0]);
        assertEquals("cd-!-ef", result[1]);
    }
}