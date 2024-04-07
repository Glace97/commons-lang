import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class betweenTest {

    @Test
    void testBetween() {
        UnicodeEscaper escaper = UnicodeEscaper.between(65, 90);
        assertEquals(65, escaper.below);
        assertEquals(90, escaper.above);
        assertTrue(escaper.between);
    }

    @Test
    void testBelowBoundary() {
        UnicodeEscaper escaper = UnicodeEscaper.between(65, 90);
        assertFalse(escaper.between(64));
        assertTrue(escaper.between(65));
    }

    @Test
    void testAboveBoundary() {
        UnicodeEscaper escaper = UnicodeEscaper.between(65, 90);
        assertTrue(escaper.between(90));
        assertFalse(escaper.between(91));
    }
    
    @Test
    void testWithinBoundary() {
        UnicodeEscaper escaper = UnicodeEscaper.between(65, 90);
        assertTrue(escaper.between(70));
        assertTrue(escaper.between(80));
    }

    @Test
    void testOutsideBoundary() {
        UnicodeEscaper escaper = UnicodeEscaper.between(65, 90);
        assertFalse(escaper.between(64));
        assertFalse(escaper.between(91));
    }
}