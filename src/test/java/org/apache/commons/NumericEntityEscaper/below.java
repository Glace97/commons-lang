import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class NumericEntityEscaperTest {
    
    @ParameterizedTest
    @ValueSource(ints = {0, 10, 100, Integer.MAX_VALUE})
    void testBelow(int codePoint) {
        NumericEntityEscaper escaper = NumericEntityEscaper.below(codePoint);
        
        assertTrue(escaper.below <= codePoint);
        assertTrue(escaper.above > codePoint);
        assertTrue(escaper.between);
    }
    
    @Test
    void testConstructorAllCharacters() {
        NumericEntityEscaper escaper = new NumericEntityEscaper();
        
        assertEquals(0, escaper.below);
        assertEquals(Integer.MAX_VALUE, escaper.above);
        assertTrue(escaper.between);
    }
    
    @Test
    void testConstructorWithRange() {
        int below = 100;
        int above = 1000;
        boolean between = false;
        
        NumericEntityEscaper escaper = new NumericEntityEscaper(below, above, between);
        
        assertEquals(below, escaper.below);
        assertEquals(above, escaper.above);
        assertEquals(between, escaper.between);
    }
}