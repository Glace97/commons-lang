import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class betweenTest {

    @Test
    @DisplayName("Test when below and above are the same")
    void testBelowAndAboveSame() {
        JavaUnicodeEscaper escaper = JavaUnicodeEscaper.between(65, 65);
        assertEquals("", escaper.escape("A"));
    }

    @Test
    @DisplayName("Test when the character is within the specified range")
    void testWithinRange() {
        JavaUnicodeEscaper escaper = JavaUnicodeEscaper.between(65, 90);
        assertEquals("\\u0041", escaper.escape("A"));
    }

    @Test
    @DisplayName("Test when the character is outside the specified range")
    void testOutsideRange() {
        JavaUnicodeEscaper escaper = JavaUnicodeEscaper.between(65, 90);
        assertEquals("A", escaper.escape("a"));
    }
    
    @Test
    @DisplayName("Test when the character is at the lower bound")
    void testLowerBound() {
        JavaUnicodeEscaper escaper = JavaUnicodeEscaper.between(65, 90);
        assertEquals("\\u0041", escaper.escape("A"));
    }
    
    @Test
    @DisplayName("Test when the character is at the upper bound")
    void testUpperBound() {
        JavaUnicodeEscaper escaper = JavaUnicodeEscaper.between(65, 90);
        assertEquals("\\u005A", escaper.escape("Z"));
    }
}