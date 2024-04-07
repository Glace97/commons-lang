import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UnicodeEscaperTest {

    @Test
    void testConstructorAllCharacters() {
        UnicodeEscaper escaper = new UnicodeEscaper();
        assertNotNull(escaper);
        assertEquals(0, escaper.below);
        assertEquals(Integer.MAX_VALUE, escaper.above);
        assertTrue(escaper.between);
    }

    @Test
    void testConstructorWithRange() {
        UnicodeEscaper escaper = new UnicodeEscaper(10, 20, true);
        assertNotNull(escaper);
        assertEquals(10, escaper.below);
        assertEquals(20, escaper.above);
        assertTrue(escaper.between);
    }

    @Test
    void testConstructorAbove() {
        UnicodeEscaper escaper = UnicodeEscaper.above(5);
        assertNotNull(escaper);
        assertEquals(0, escaper.below);
        assertEquals(5, escaper.above);
        assertFalse(escaper.between);
    }
}