import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class UnicodeEscaperTest {

    private UnicodeEscaper unicodeEscaper;

    @BeforeEach
    void setUp() {
        unicodeEscaper = new UnicodeEscaper(0, Integer.MAX_VALUE, true);
    }

    @Test
    void testConstructor() {
        assertEquals(0, unicodeEscaper.below);
        assertEquals(Integer.MAX_VALUE, unicodeEscaper.above);
        assertTrue(unicodeEscaper.between);
    }

    @Test
    void testBelow() {
        UnicodeEscaper belowEscaper = UnicodeEscaper.below(100);
        assertEquals(0, belowEscaper.below);
        assertEquals(100, belowEscaper.above);
        assertTrue(belowEscaper.between);
    }
}