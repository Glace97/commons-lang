import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.StringWriter;
import static org.junit.jupiter.api.Assertions.*;

class translateTest {

    @Test
    void testTranslateWithValidOctalEscape() throws IOException {
        OctalUnescaper octalUnescaper = new OctalUnescaper();
        StringWriter writer = new StringWriter();
        int result = octalUnescaper.translate("\\101B", 0, writer);
        assertEquals(3, result);
        assertEquals('A', writer.toString().charAt(0));
    }

    @Test
    void testTranslateWithInvalidOctalEscape() throws IOException {
        OctalUnescaper octalUnescaper = new OctalUnescaper();
        StringWriter writer = new StringWriter();
        int result = octalUnescaper.translate("\\8", 0, writer);
        assertEquals(0, result);
        assertEquals("", writer.toString());
    }

    @Test
    void testTranslateWithMissingOctalDigit() throws IOException {
        OctalUnescaper octalUnescaper = new OctalUnescaper();
        StringWriter writer = new StringWriter();
        int result = octalUnescaper.translate("\\1", 0, writer);
        assertEquals(0, result);
        assertEquals("", writer.toString());
    }

    @Test
    void testTranslateWithZeroToThreeDigit() throws IOException {
        OctalUnescaper octalUnescaper = new OctalUnescaper();
        StringWriter writer = new StringWriter();
        int result = octalUnescaper.translate("\\001", 0, writer);
        assertEquals(4, result);
        assertEquals(1, writer.toString().charAt(0));
    }

    @Test
    void testTranslateWithZeroToThreeDigitAndInvalidOctalDigit() throws IOException {
        OctalUnescaper octalUnescaper = new OctalUnescaper();
        StringWriter writer = new StringWriter();
        int result = octalUnescaper.translate("\\008", 0, writer);
        assertEquals(0, result);
        assertEquals("", writer.toString());
    }

    @Test
    void testTranslateWithZeroToThreeDigitAndMissingOctalDigit() throws IOException {
        OctalUnescaper octalUnescaper = new OctalUnescaper();
        StringWriter writer = new StringWriter();
        int result = octalUnescaper.translate("\\01", 0, writer);
        assertEquals(0, result);
        assertEquals("", writer.toString());
    }

    @Test
    void testTranslateWithInvalidCharacterAfterBackslash() throws IOException {
        OctalUnescaper octalUnescaper = new OctalUnescaper();
        StringWriter writer = new StringWriter();
        int result = octalUnescaper.translate("\\A", 0, writer);
        assertEquals(0, result);
        assertEquals("", writer.toString());
    }

    @Test
    void testTranslateWithInvalidCharacterAfterValidOctalEscape() throws IOException {
        OctalUnescaper octalUnescaper = new OctalUnescaper();
        StringWriter writer = new StringWriter();
        int result = octalUnescaper.translate("\\101C", 0, writer);
        assertEquals(0, result);
        assertEquals("", writer.toString());
    }

}