import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class outsideOfTest {

    @Test
    void testOutsideOf() {
        UnicodeEscaper escaper = UnicodeEscaper.outsideOf(65, 90);
        assertEquals(65, escaper.below);
        assertEquals(90, escaper.above);
        assertFalse(escaper.between);
    }
    
    @Test
    void testOutsideOfLowerBoundary() {
        UnicodeEscaper escaper = UnicodeEscaper.outsideOf(65, 90);
        assertTrue(escaper.below < 65);
    }
    
    @Test
    void testOutsideOfUpperBoundary() {
        UnicodeEscaper escaper = UnicodeEscaper.outsideOf(65, 90);
        assertTrue(escaper.above > 90);
    }
    
    @Test
    void testOutsideOfBetween() {
        UnicodeEscaper escaper = UnicodeEscaper.outsideOf(65, 90);
        assertFalse(escaper.between);
    }
    
    @Test
    void testOutsideOfInvalidRange() {
        assertThrows(IllegalArgumentException.class, () -> {
            UnicodeEscaper.outsideOf(90, 65);
        });
    }
    
    @Test
    void testOutsideOfNegativeRange() {
        assertThrows(IllegalArgumentException.class, () -> {
            UnicodeEscaper.outsideOf(-100, -50);
        });
    }
}