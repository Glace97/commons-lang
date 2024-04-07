import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.StringWriter;

class TranslateTest {

    @Test
    void testTranslateWithValidUnicodeValue() throws IOException {
        UnicodeUnescaper unescaper = new UnicodeUnescaper();
        StringWriter writer = new StringWriter();
        CharSequence input = "\\u0041";
        int index = 0;
        int result = unescaper.translate(input, index, writer);

        assertEquals(6, result);
        assertEquals("A", writer.toString());
    }

    @Test
    void testTranslateWithInvalidUnicodeValue() {
        UnicodeUnescaper unescaper = new UnicodeUnescaper();
        StringWriter writer = new StringWriter();
        CharSequence input = "\\uG123";
        int index = 0;

        assertThrows(IllegalArgumentException.class, () -> {
            unescaper.translate(input, index, writer);
        });
    }

    @Test
    void testTranslateWithLessThan4HexDigits() {
        UnicodeUnescaper unescaper = new UnicodeUnescaper();
        StringWriter writer = new StringWriter();
        CharSequence input = "\\u12";
        int index = 0;

        assertThrows(IllegalArgumentException.class, () -> {
            unescaper.translate(input, index, writer);
        });
    }

    @Test
    void testTranslateWithEndOfCharSequence() {
        UnicodeUnescaper unescaper = new UnicodeUnescaper();
        StringWriter writer = new StringWriter();
        CharSequence input = "\\u1234";
        int index = 0;

        assertThrows(IllegalArgumentException.class, () -> {
            unescaper.translate(input, index, writer);
        });
    }

    @Test
    void testTranslateWithNoUnicodeValue() throws IOException {
        UnicodeUnescaper unescaper = new UnicodeUnescaper();
        StringWriter writer = new StringWriter();
        CharSequence input = "ABC";
        int index = 0;
        int result = unescaper.translate(input, index, writer);

        assertEquals(0, result);
        assertEquals("", writer.toString());
    }
}