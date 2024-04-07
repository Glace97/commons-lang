import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class trimTest {

    @Test
    void testTrim_NullString_ReturnsNull() {
        String str = null;
        String result = StringUtils.trim(str);
        assertEquals(null, result);
    }

    @Test
    void testTrim_EmptyString_ReturnsEmptyString() {
        String str = "";
        String result = StringUtils.trim(str);
        assertEquals("", result);
    }

    @Test
    void testTrim_WhitespaceString_ReturnsEmptyString() {
        String str = "     ";
        String result = StringUtils.trim(str);
        assertEquals("", result);
    }

    @Test
    void testTrim_NoLeadingOrTrailingWhitespace_ReturnsSameString() {
        String str = "abc";
        String result = StringUtils.trim(str);
        assertEquals("abc", result);
    }

    @Test
    void testTrim_LeadingAndTrailingWhitespace_ReturnsTrimmedString() {
        String str = "    abc    ";
        String result = StringUtils.trim(str);
        assertEquals("abc", result);
    }
}