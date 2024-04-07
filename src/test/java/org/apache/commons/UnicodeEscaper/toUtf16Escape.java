import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class toUtf16EscapeTest {

    private UnicodeEscaper unicodeEscaper;

    @BeforeEach
    void setUp() {
        unicodeEscaper = new UnicodeEscaper();
    }

    @Test
    void testToUtf16Escape() {
        // Test below boundary (0)
        assertEquals("\\u0000", unicodeEscaper.toUtf16Escape(0));

        // Test within boundary (65)
        assertEquals("\\u0041", unicodeEscaper.toUtf16Escape(65));

        // Test above boundary (1234)
        assertEquals("\\u04D2", unicodeEscaper.toUtf16Escape(1234));

        // Test between boundary (1000)
        assertEquals("\\u03E8", unicodeEscaper.toUtf16Escape(1000));
    }
}