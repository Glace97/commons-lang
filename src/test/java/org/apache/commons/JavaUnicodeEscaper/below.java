
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class JavaUnicodeEscaperTest {

    @Test
    void testConstructor() {
        JavaUnicodeEscaper escaper = new JavaUnicodeEscaper(0, 10, true);
        assertNotNull(escaper);
    }

    @Test
    void testBelow() {
        JavaUnicodeEscaper escaper = JavaUnicodeEscaper.below(10);
        assertNotNull(escaper);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 9})
    void testEscape(int codePoint) {
        JavaUnicodeEscaper escaper = new JavaUnicodeEscaper(0, 10, true);
        String escaped = escaper.escape(Character.toString((char) codePoint));
        assertTrue(escaped.startsWith("\\u"));
        assertEquals(6, escaped.length());
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 11, 15, 20})
    void testNonEscape(int codePoint) {
        JavaUnicodeEscaper escaper = new JavaUnicodeEscaper(0, 10, true);
        String escaped = escaper.escape(Character.toString((char) codePoint));
        assertEquals(Character.toString((char) codePoint), escaped);
    }
}
