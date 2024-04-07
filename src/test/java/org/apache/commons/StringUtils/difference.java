import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class differenceTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    void testDifference_NullStrings_ReturnsNull() {
        String str1 = null;
        String str2 = null;

        String result = stringUtils.difference(str1, str2);

        assertEquals(null, result);
    }

    @Test
    void testDifference_EmptyStrings_ReturnsEmptyString() {
        String str1 = "";
        String str2 = "";

        String result = stringUtils.difference(str1, str2);

        assertEquals("", result);
    }

    @Test
    void testDifference_EmptyStringAndNonEmptyString_ReturnsNonEmptyString() {
        String str1 = "";
        String str2 = "abc";

        String result = stringUtils.difference(str1, str2);

        assertEquals("abc", result);
    }

    @Test
    void testDifference_NonEmptyStringAndEmptyString_ReturnsEmptyString() {
        String str1 = "abc";
        String str2 = "";

        String result = stringUtils.difference(str1, str2);

        assertEquals("", result);
    }

    @Test
    void testDifference_SameStrings_ReturnsEmptyString() {
        String str1 = "abc";
        String str2 = "abc";

        String result = stringUtils.difference(str1, str2);

        assertEquals("", result);
    }

    @Test
    void testDifference_FirstStringShorter_ReturnsDifference() {
        String str1 = "ab";
        String str2 = "abxyz";

        String result = stringUtils.difference(str1, str2);

        assertEquals("xyz", result);
    }

    @Test
    void testDifference_FirstStringLonger_ReturnsDifference() {
        String str1 = "abcde";
        String str2 = "abxyz";

        String result = stringUtils.difference(str1, str2);

        assertEquals("xyz", result);
    }

    @Test
    void testDifference_StringsDifferent_ReturnsDifference() {
        String str1 = "abcde";
        String str2 = "xyz";

        String result = stringUtils.difference(str1, str2);

        assertEquals("xyz", result);
    }
}