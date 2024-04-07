
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class chompTest {

    @Test
    void testChompWithNullString() {
        String str = null;
        assertNull(StringUtils.chomp(str));
    }

    @Test
    void testChompWithEmptyString() {
        String str = "";
        assertEquals("", StringUtils.chomp(str));
    }

    @Test
    void testChompWithSpaceString() {
        String str = " ";
        assertEquals(" ", StringUtils.chomp(str));
    }

    @Test
    void testChompWithNewlineString() {
        String str = "\n";
        assertEquals("", StringUtils.chomp(str));
    }

    @Test
    void testChompWithCarriageReturnString() {
        String str = "\r";
        assertEquals("", StringUtils.chomp(str));
    }

    @Test
    void testChompWithCarriageReturnAndNewlineString() {
        String str = "\r\n";
        assertEquals("", StringUtils.chomp(str));
    }

    @Test
    void testChompWithMultipleCarriageReturnAndNewlineString() {
        String str = "\r\n\r\n";
        assertEquals("\r\n", StringUtils.chomp(str));
    }

    @Test
    void testChompWithNewlineAndCarriageReturnString() {
        String str = "\n\r";
        assertEquals("\n", StringUtils.chomp(str));
    }

    @Test
    void testChompWithNonChompableString() {
        String str = "abc";
        assertEquals("abc", StringUtils.chomp(str));
    }

    @Test
    void testChompWithCarriageReturnAtEndOfString() {
        String str = "abc\r";
        assertEquals("abc", StringUtils.chomp(str));
    }

    @Test
    void testChompWithNewlineAtEndOfString() {
        String str = "abc\n";
        assertEquals("abc", StringUtils.chomp(str));
    }

    @Test
    void testChompWithCarriageReturnAndNewlineAtEndOfString() {
        String str = "abc\r\n";
        assertEquals("abc", StringUtils.chomp(str));
    }

    @Test
    void testChompWithCarriageReturnAndCharAfter() {
        String str = "abc\rX";
        assertEquals("abc\rX", StringUtils.chomp(str));
    }

    @Test
    void testChompWithNewlineAndCharAfter() {
        String str = "abc\nX";
        assertEquals("abc\nX", StringUtils.chomp(str));
    }

    @Test
    void testChompWithCarriageReturnAndNewlineAndCharAfter() {
        String str = "abc\r\nX";
        assertEquals("abc\r\nX", StringUtils.chomp(str));
    }

    @Test
    void testChompWithCarriageReturnAndCharBefore() {
        String str = "X\r";
        assertEquals("X", StringUtils.chomp(str));
    }

    @Test
    void testChompWithNewlineAndCharBefore() {
        String str = "X\n";
        assertEquals("X", StringUtils.chomp(str));
    }

    @Test
    void testChompWithCarriageReturnAndNewlineAndCharBefore() {
        String str = "X\r\n";
        assertEquals("X", StringUtils.chomp(str));
    }
}
