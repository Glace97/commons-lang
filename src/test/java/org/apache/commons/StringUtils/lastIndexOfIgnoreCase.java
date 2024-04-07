import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class lastIndexOfIgnoreCaseTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    void testLastIndexOfIgnoreCase_NullString() {
        int result = stringUtils.lastIndexOfIgnoreCase(null, "abc");
        assertEquals(-1, result);
    }

    @Test
    void testLastIndexOfIgnoreCase_NullSearchStr() {
        int result = stringUtils.lastIndexOfIgnoreCase("abc", null);
        assertEquals(-1, result);
    }

    @Test
    void testLastIndexOfIgnoreCase_EmptyString() {
        int result = stringUtils.lastIndexOfIgnoreCase("", "abc");
        assertEquals(-1, result);
    }

    @Test
    void testLastIndexOfIgnoreCase_EmptySearchStr() {
        int result = stringUtils.lastIndexOfIgnoreCase("abc", "");
        assertEquals(0, result);
    }

    @Test
    void testLastIndexOfIgnoreCase_SearchStrNotFound() {
        int result = stringUtils.lastIndexOfIgnoreCase("abcde", "xyz");
        assertEquals(-1, result);
    }

    @Test
    void testLastIndexOfIgnoreCase_SearchStrFound() {
        int result = stringUtils.lastIndexOfIgnoreCase("abcabc", "ABC");
        assertEquals(3, result);
    }

    @Test
    void testLastIndexOfIgnoreCase_SearchStrFound_StartPos() {
        int result = stringUtils.lastIndexOfIgnoreCase("abcabc", "ABC", 2);
        assertEquals(0, result);
    }

    @Test
    void testLastIndexOfIgnoreCase_SearchStrFound_StartPos_OutOfRange() {
        int result = stringUtils.lastIndexOfIgnoreCase("abcabc", "ABC", 7);
        assertEquals(3, result);
    }

    @Test
    void testLastIndexOfIgnoreCase_SearchStrFound_CaseSensitive() {
        int result = stringUtils.lastIndexOfIgnoreCase("abcabc", "ABC", 2);
        assertEquals(-1, result);
    }
}