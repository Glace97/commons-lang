import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class stripTest {
    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    void testStrip_NullInput_ReturnsNull() {
        String result = stringUtils.strip(null);
        assertNull(result);
    }

    @Test
    void testStrip_EmptyStringInput_ReturnsEmptyString() {
        String result = stringUtils.strip("");
        assertEquals("", result);
    }

    @Test
    void testStrip_WhitespaceInput_ReturnsEmptyString() {
        String result = stringUtils.strip("   ");
        assertEquals("", result);
    }

    @Test
    void testStrip_NoWhitespace_ReturnsSameString() {
        String result = stringUtils.strip("abc");
        assertEquals("abc", result);
    }

    @Test
    void testStrip_WhitespaceAtStart_ReturnsStrippedString() {
        String result = stringUtils.strip("  abc");
        assertEquals("abc", result);
    }

    @Test
    void testStrip_WhitespaceAtEnd_ReturnsStrippedString() {
        String result = stringUtils.strip("abc  ");
        assertEquals("abc", result);
    }

    @Test
    void testStrip_WhitespaceAtBothEnds_ReturnsStrippedString() {
        String result = stringUtils.strip(" abc ");
        assertEquals("abc", result);
    }

    @Test
    void testStrip_WhitespaceInMiddle_DoesNotStrip() {
        String result = stringUtils.strip(" ab c ");
        assertEquals("ab c", result);
    }

    @Test
    void testStrip_WhitespaceInStripChars_ReturnsStrippedString() {
        String result = stringUtils.strip("  abcyx", "xyz");
        assertEquals("  abc", result);
    }
}