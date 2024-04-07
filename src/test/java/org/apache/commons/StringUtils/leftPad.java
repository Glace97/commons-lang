
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class LeftPadTest {

    @Test
    void testLeftPadWithNullString() {
        String result = StringUtils.leftPad(null, 5);
        assertNull(result);
    }

    @Test
    void testLeftPadWithEmptyString() {
        String result = StringUtils.leftPad("", 5);
        assertEquals("     ", result);
    }

    @Test
    void testLeftPadWithShorterString() {
        String result = StringUtils.leftPad("bat", 5);
        assertEquals("  bat", result);
    }

    @Test
    void testLeftPadWithEqualSizeString() {
        String result = StringUtils.leftPad("bat", 3);
        assertEquals("bat", result);
    }

    @Test
    void testLeftPadWithSmallerSizeString() {
        String result = StringUtils.leftPad("bat", 1);
        assertEquals("bat", result);
    }

    @Test
    void testLeftPadWithNegativeSizeString() {
        String result = StringUtils.leftPad("bat", -1);
        assertEquals("bat", result);
    }

    @Test
    void testLeftPadWithCustomPaddingChar() {
        String result = StringUtils.leftPad("bat", 5, 'z');
        assertEquals("zzbat", result);
    }

    @Test
    void testLeftPadWithCustomPaddingString() {
        String result = StringUtils.leftPad("bat", 5, "yz");
        assertEquals("yzbat", result);
    }

    @Test
    void testLeftPadWithCustomPaddingStringAndLargerSize() {
        String result = StringUtils.leftPad("bat", 8, "yz");
        assertEquals("yzyzybat", result);
    }

    @Test
    void testLeftPadWithCustomPaddingStringAndEqualSize() {
        String result = StringUtils.leftPad("bat", 3, "yz");
        assertEquals("bat", result);
    }

    @Test
    void testLeftPadWithCustomPaddingStringAndSmallerSize() {
        String result = StringUtils.leftPad("bat", 1, "yz");
        assertEquals("bat", result);
    }

    @Test
    void testLeftPadWithCustomPaddingStringAndNegativeSize() {
        String result = StringUtils.leftPad("bat", -1, "yz");
        assertEquals("bat", result);
    }

    @Test
    void testLeftPadWithNullPaddingString() {
        String result = StringUtils.leftPad("bat", 5, null);
        assertEquals("  bat", result);
    }

    @Test
    void testLeftPadWithEmptyPaddingString() {
        String result = StringUtils.leftPad("bat", 5, "");
        assertEquals("  bat", result);
    }

}
