
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CenterTest {

    @Test
    void testCenterWithNullStringShouldReturnNull() {
        String result = StringUtils.center(null, 5);
        assertNull(result);
    }

    @Test
    void testCenterWithEmptyStringShouldReturnEmptyString() {
        String result = StringUtils.center("", 5);
        assertEquals("", result);
    }

    @Test
    void testCenterWithNegativeSizeShouldReturnSameString() {
        String input = "abc";
        String result = StringUtils.center(input, -1);
        assertEquals(input, result);
    }

    @Test
    void testCenterWithSizeLessThanStringShouldReturnSameString() {
        String input = "abc";
        String result = StringUtils.center(input, 2);
        assertEquals(input, result);
    }

    @Test
    void testCenterWithEvenSizeShouldCenterStringWithSpaces() {
        String input = "abc";
        String expected = " abc ";
        String result = StringUtils.center(input, 6);
        assertEquals(expected, result);
    }

    @Test
    void testCenterWithOddSizeShouldCenterStringWithSpaces() {
        String input = "abc";
        String expected = " abc  ";
        String result = StringUtils.center(input, 7);
        assertEquals(expected, result);
    }

    @Test
    void testCenterWithEvenSizeAndCustomPadCharShouldCenterStringWithCustomPadChar() {
        String input = "abc";
        String expected = "-abc--";
        String result = StringUtils.center(input, 6, '-');
        assertEquals(expected, result);
    }

    @Test
    void testCenterWithOddSizeAndCustomPadCharShouldCenterStringWithCustomPadChar() {
        String input = "abc";
        String expected = "-abc---";
        String result = StringUtils.center(input, 7, '-');
        assertEquals(expected, result);
    }

    @Test
    void testCenterWithEvenSizeAndEmptyPadStringShouldCenterStringWithSpaces() {
        String input = "abc";
        String expected = " abc ";
        String result = StringUtils.center(input, 6, "");
        assertEquals(expected, result);
    }

    @Test
    void testCenterWithOddSizeAndEmptyPadStringShouldCenterStringWithSpaces() {
        String input = "abc";
        String expected = " abc  ";
        String result = StringUtils.center(input, 7, "");
        assertEquals(expected, result);
    }

    @Test
    void testCenterWithEvenSizeAndNullPadStringShouldCenterStringWithSpaces() {
        String input = "abc";
        String expected = " abc ";
        String result = StringUtils.center(input, 6, null);
        assertEquals(expected, result);
    }

    @Test
    void testCenterWithOddSizeAndNullPadStringShouldCenterStringWithSpaces() {
        String input = "abc";
        String expected = " abc  ";
        String result = StringUtils.center(input, 7, null);
        assertEquals(expected, result);
    }
}
