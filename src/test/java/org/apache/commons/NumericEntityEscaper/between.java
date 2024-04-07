import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class betweenTest {
    
    @Test
    void testConstructor() {
        NumericEntityEscaper escaper = new NumericEntityEscaper();
        assertEquals(0, escaper.below);
        assertEquals(Integer.MAX_VALUE, escaper.above);
        assertTrue(escaper.between);
    }
    
    @Test
    void testConstructorWithParameters() {
        NumericEntityEscaper escaper = new NumericEntityEscaper(10, 20, false);
        assertEquals(10, escaper.below);
        assertEquals(20, escaper.above);
        assertFalse(escaper.between);
    }
    
    @Test
    void testBetweenMethod() {
        NumericEntityEscaper escaper = NumericEntityEscaper.between(10, 20);
        assertEquals(10, escaper.below);
        assertEquals(20, escaper.above);
        assertTrue(escaper.between);
    }
}