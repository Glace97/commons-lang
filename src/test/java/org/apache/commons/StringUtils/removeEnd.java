import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

class removeEndTest {
    
    @Test
    void testRemoveEnd_NullString_ReturnNull() {
        String result = StringUtils.removeEnd(null, ".com");
        assertNull(result);
    }
    
    @Test
    void testRemoveEnd_EmptyString_ReturnEmptyString() {
        String result = StringUtils.removeEnd("", ".com");
        assertEquals("", result);
    }
    
    @Test
    void testRemoveEnd_NullRemove_ReturnSameString() {
        String result = StringUtils.removeEnd("www.domain.com", null);
        assertEquals("www.domain.com", result);
    }
    
    @Test
    void testRemoveEnd_RemoveNotFound_ReturnSameString() {
        String result = StringUtils.removeEnd("www.domain.com", "notfound");
        assertEquals("www.domain.com", result);
    }
    
    @Test
    void testRemoveEnd_RemoveAtEnd_ReturnSubstringWithoutRemove() {
        String result = StringUtils.removeEnd("www.domain.com", ".com");
        assertEquals("www.domain", result);
    }
    
    @Test
    void testRemoveEnd_RemoveAtEndMultipleTimes_ReturnSubstringWithoutRemove() {
        String result = StringUtils.removeEnd("www.domain.com", ".com.");
        assertEquals("www.domain.com", result);
    }
    
    @Test
    void testRemoveEnd_RemoveEmptyString_ReturnSameString() {
        String result = StringUtils.removeEnd("abc", "");
        assertEquals("abc", result);
    }
}