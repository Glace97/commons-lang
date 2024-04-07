import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class lengthTest {

    @Test
    void testLength_NullString_ReturnZero() {
        String str = null;
        int result = StringUtils.length(str);
        assertEquals(0, result);
    }

    @Test
    void testLength_EmptyString_ReturnZero() {
        String str = "";
        int result = StringUtils.length(str);
        assertEquals(0, result);
    }

    @Test
    void testLength_NonEmptyString_ReturnLength() {
        String str = "Hello";
        int result = StringUtils.length(str);
        assertEquals(5, result);
    }

    @Test
    void testLength_UnicodeString_ReturnLength() {
        String str = "नमस्ते";
        int result = StringUtils.length(str);
        assertEquals(6, result);
    }

    @Test
    void testLength_StringWithLeadingAndTrailingSpaces_ReturnLengthIgnoringSpaces() {
        String str = "  Hello  ";
        int result = StringUtils.length(str);
        assertEquals(5, result);
    }

    @Test
    void testLength_StringWithLinefeed_ReturnLengthIgnoringLinefeed() {
        String str = "Hello\nWorld";
        int result = StringUtils.length(str);
        assertEquals(10, result);
    }

    @Test
    void testLength_StringWithCarriageReturn_ReturnLengthIgnoringCarriageReturn() {
        String str = "Hello\rWorld";
        int result = StringUtils.length(str);
        assertEquals(10, result);
    }
}