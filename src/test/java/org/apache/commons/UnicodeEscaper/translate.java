import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import static org.junit.jupiter.api.Assertions.*;

class TranslateTest {

    private UnicodeEscaper unicodeEscaper;

    @BeforeEach
    void setUp() {
        unicodeEscaper = new UnicodeEscaper();
    }

    @Test
    void testTranslate_shouldEscapeUnicodeCodePointBelowRange_whenBetweenIsTrue() throws IOException {
        int codePoint = -1;
        StringWriter writer = new StringWriter();

        boolean result = unicodeEscaper.translate(codePoint, writer);

        assertTrue(result);
        assertEquals("\\uFFFF", writer.toString());
    }

    @Test
    void testTranslate_shouldNotEscapeUnicodeCodePointBelowRange_whenBetweenIsFalse() throws IOException {
        unicodeEscaper = new UnicodeEscaper(0, Integer.MAX_VALUE, false);
        int codePoint = -1;
        StringWriter writer = new StringWriter();

        boolean result = unicodeEscaper.translate(codePoint, writer);

        assertFalse(result);
        assertEquals("", writer.toString());
    }

    @Test
    void testTranslate_shouldEscapeUnicodeCodePointAboveRange_whenBetweenIsTrue() throws IOException {
        int codePoint = Integer.MAX_VALUE + 1;
        StringWriter writer = new StringWriter();

        boolean result = unicodeEscaper.translate(codePoint, writer);

        assertTrue(result);
        assertEquals("\\uD800\\uDC00", writer.toString());
    }

    @Test
    void testTranslate_shouldNotEscapeUnicodeCodePointAboveRange_whenBetweenIsFalse() throws IOException {
        unicodeEscaper = new UnicodeEscaper(0, Integer.MAX_VALUE, false);
        int codePoint = Integer.MAX_VALUE + 1;
        StringWriter writer = new StringWriter();

        boolean result = unicodeEscaper.translate(codePoint, writer);

        assertFalse(result);
        assertEquals("", writer.toString());
    }

    @Test
    void testTranslate_shouldEscapeUnicodeCodePointWithinRange_whenBetweenIsTrue() throws IOException {
        int codePoint = 100;
        StringWriter writer = new StringWriter();

        boolean result = unicodeEscaper.translate(codePoint, writer);

        assertTrue(result);
        assertEquals("\\u0064", writer.toString());
    }

    @Test
    void testTranslate_shouldNotEscapeUnicodeCodePointWithinRange_whenBetweenIsFalse() throws IOException {
        unicodeEscaper = new UnicodeEscaper(0, Integer.MAX_VALUE, false);
        int codePoint = 100;
        StringWriter writer = new StringWriter();

        boolean result = unicodeEscaper.translate(codePoint, writer);

        assertFalse(result);
        assertEquals("", writer.toString());
    }

    @Test
    void testTranslate_shouldEscapeUnicodeCodePointEqualToLowerBoundary_whenBetweenIsTrue() throws IOException {
        int codePoint = 0;
        StringWriter writer = new StringWriter();

        boolean result = unicodeEscaper.translate(codePoint, writer);

        assertTrue(result);
        assertEquals("\\u0000", writer.toString());
    }

    @Test
    void testTranslate_shouldNotEscapeUnicodeCodePointEqualToLowerBoundary_whenBetweenIsFalse() throws IOException {
        unicodeEscaper = new UnicodeEscaper(0, Integer.MAX_VALUE, false);
        int codePoint = 0;
        StringWriter writer = new StringWriter();

        boolean result = unicodeEscaper.translate(codePoint, writer);

        assertFalse(result);
        assertEquals("", writer.toString());
    }

    @Test
    void testTranslate_shouldEscapeUnicodeCodePointEqualToUpperBoundary_whenBetweenIsTrue() throws IOException {
        int codePoint = Integer.MAX_VALUE;
        StringWriter writer = new StringWriter();

        boolean result = unicodeEscaper.translate(codePoint, writer);

        assertTrue(result);
        assertEquals("\\uFFFF", writer.toString());
    }

    @Test
    void testTranslate_shouldNotEscapeUnicodeCodePointEqualToUpperBoundary_whenBetweenIsFalse() throws IOException {
        unicodeEscaper = new UnicodeEscaper(0, Integer.MAX_VALUE, false);
        int codePoint = Integer.MAX_VALUE;
        StringWriter writer = new StringWriter();

        boolean result = unicodeEscaper.translate(codePoint, writer);

        assertFalse(result);
        assertEquals("", writer.toString());
    }

    @Test
    void testTranslate_shouldEscapeUnicodeCodePointEqualToLowerBoundary_whenBetweenIsFalse() throws IOException {
        unicodeEscaper = new UnicodeEscaper(Integer.MIN_VALUE, Integer.MAX_VALUE, false);
        int codePoint = Integer.MIN_VALUE;
        StringWriter writer = new StringWriter();

        boolean result = unicodeEscaper.translate(codePoint, writer);

        assertTrue(result);
        assertEquals("\\uD800\\uDC00", writer.toString());
    }

    @Test
    void testTranslate_shouldEscapeUnicodeCodePointEqualToUpperBoundary_whenBetweenIsFalse() throws IOException {
        unicodeEscaper = new UnicodeEscaper(Integer.MIN_VALUE, Integer.MAX_VALUE, false);
        int codePoint = Integer.MAX_VALUE;
        StringWriter writer = new StringWriter();

        boolean result = unicodeEscaper.translate(codePoint, writer);

        assertTrue(result);
        assertEquals("\\uD800\\uDC00", writer.toString());
    }
}