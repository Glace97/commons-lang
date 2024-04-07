import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class outsideOfTest {
    private JavaUnicodeEscaper unicodeEscaper;

    @BeforeEach
    void setUp() {
        unicodeEscaper = new JavaUnicodeEscaper(0, 10, false);
    }

    @Test
    void testOutsideOfEscaping() {
        String input = "Hello World";
        String expected = "Hello World";
        String actual = unicodeEscaper.escape(input);
        assertEquals(expected, actual);
    }

    @Test
    void testInsideOfEscaping() {
        String input = "Hello😊World";
        String expected = "Hello\\uD83D\\uDE0AWorld";
        String actual = unicodeEscaper.escape(input);
        assertEquals(expected, actual);
    }

    @Test
    void testBoundaryCodePointLow() {
        String input = "ab";
        String expected = "ab";
        String actual = unicodeEscaper.escape(input);
        assertEquals(expected, actual);
    }

    @Test
    void testBoundaryCodePointHigh() {
        String input = "abcdef";
        String expected = "abcdef";
        String actual = unicodeEscaper.escape(input);
        assertEquals(expected, actual);
    }

    @Test
    void testEdgeCaseEmptyString() {
        String input = "";
        String expected = "";
        String actual = unicodeEscaper.escape(input);
        assertEquals(expected, actual);
    }

    @Test
    void testEdgeCaseCodePointLow() {
        String input = "a";
        String expected = "a";
        String actual = unicodeEscaper.escape(input);
        assertEquals(expected, actual);
    }

    @Test
    void testEdgeCaseCodePointHigh() {
        String input = "abcdefghij";
        String expected = "abcdefghij";
        String actual = unicodeEscaper.escape(input);
        assertEquals(expected, actual);
    }
}