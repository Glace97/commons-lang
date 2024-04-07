import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class toUtf16EscapeTest {
    private JavaUnicodeEscaper escaper;

    @BeforeEach
    public void setup() {
        escaper = new JavaUnicodeEscaper(0, 0x10FFFF, true);
    }

    @Test
    public void testToUtf16Escape() {
        // Test basic code point
        int codePoint = 65; // 'A'
        String expected = "\\u0041\\u0000";
        String result = escaper.toUtf16Escape(codePoint);
        assertEquals(expected, result);

        // Test supplementary code point
        codePoint = 0x1F603; // 😀
        expected = "\\uD83D\\uDE03";
        result = escaper.toUtf16Escape(codePoint);
        assertEquals(expected, result);

        // Test lowest code point boundary
        codePoint = 0;
        expected = "\\u0000\\u0000";
        result = escaper.toUtf16Escape(codePoint);
        assertEquals(expected, result);

        // Test highest code point boundary
        codePoint = 0x10FFFF;
        expected = "\\uDBFF\\uDFFF";
        result = escaper.toUtf16Escape(codePoint);
        assertEquals(expected, result);
    }
}