import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.Writer;

class NumericEntityEscaperTest {
    
    @Test
    void testNumericEntityEscaperConstructor() {
        NumericEntityEscaper escaper = new NumericEntityEscaper();
        assertNotNull(escaper);
        assertEquals(0, escaper.below);
        assertEquals(Integer.MAX_VALUE, escaper.above);
        assertTrue(escaper.between);
    }
    
    @Test
    void testNumericEntityEscaperRangeConstructor() {
        NumericEntityEscaper escaper = new NumericEntityEscaper(10, 20, true);
        assertNotNull(escaper);
        assertEquals(10, escaper.below);
        assertEquals(20, escaper.above);
        assertTrue(escaper.between);
    }
    
    @Test
    void testNumericEntityEscaperAbove() {
        NumericEntityEscaper escaper = NumericEntityEscaper.above(100);
        assertNotNull(escaper);
        assertEquals(0, escaper.below);
        assertEquals(100, escaper.above);
        assertFalse(escaper.between);
    }
}