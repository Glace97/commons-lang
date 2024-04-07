import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class ISO8859_1_UNESCAPETest {
    
    private EntityArrays entityArrays;
    
    @BeforeAll
    public void setup() {
        entityArrays = new EntityArrays();
    }
    
    @Test
    public void testUnescape_nonBreakingSpace() {
        String expected = "\u00A0";
        String actual = entityArrays.ISO8859_1_UNESCAPE()[0][0];
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testUnescape_invertedExclamationMark() {
        String expected = "\u00A1";
        String actual = entityArrays.ISO8859_1_UNESCAPE()[1][0];
        
        assertEquals(expected, actual);
    }
    
    // Continue testing for all other escape sequences
    
    @Test
    public void testUnescape_invalidEscapeSequence() {
        String expected = "";
        String actual = entityArrays.ISO8859_1_UNESCAPE()[60][0];
        
        assertEquals(expected, actual);
    }
    
    @Test
    public void testUnescape_emptyEscapeSequence() {
        String expected = "";
        String actual = entityArrays.ISO8859_1_UNESCAPE()[61][0];
        
        assertEquals(expected, actual);
    }
    
    // Continue testing for all other edge cases
    
}