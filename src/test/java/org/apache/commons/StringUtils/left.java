import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class leftTest {
    
    @Test
    void testLeftNullString() {
        assertNull(StringUtils.left(null, 5));
    }
    
    @Test
    void testLeftEmptyString() {
        assertEquals("", StringUtils.left("", 5));
    }
    
    @Test
    void testLeftNegativeLength() {
        assertEquals("", StringUtils.left("abc", -1));
    }
    
    @Test
    void testLeftZeroLength() {
        assertEquals("", StringUtils.left("abc", 0));
    }
    
    @Test
    void testLeftLengthLessThanString() {
        assertEquals("ab", StringUtils.left("abc", 2));
    }
    
    @Test
    void testLeftLengthEqualToString() {
        assertEquals("abc", StringUtils.left("abc", 3));
    }
    
    @Test
    void testLeftLengthGreaterThanString() {
        assertEquals("abc", StringUtils.left("abc", 5));
    }
    
}