import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class checkLaterThan1Test {
    
    @Test
    void testCheckLaterThan1() {
        CharSequence cs = "hello";
        CharSequence searchChar = "lo";
        int len2 = 2;
        int start1 = 1;
        
        assertTrue(CharSequenceUtils.checkLaterThan1(cs, searchChar, len2, start1));
    }
    
    @Test
    void testCheckLaterThan1_Start1OutOfBounds() {
        CharSequence cs = "hello";
        CharSequence searchChar = "lo";
        int len2 = 2;
        int start1 = 10;
        
        assertFalse(CharSequenceUtils.checkLaterThan1(cs, searchChar, len2, start1));
    }
    
    @Test
    void testCheckLaterThan1_SearchCharEmpty() {
        CharSequence cs = "hello";
        CharSequence searchChar = "";
        int len2 = 0;
        int start1 = 0;
        
        assertTrue(CharSequenceUtils.checkLaterThan1(cs, searchChar, len2, start1));
    }
    
    @Test
    void testCheckLaterThan1_SearchCharOutOfBounds() {
        CharSequence cs = "hello";
        CharSequence searchChar = "lo";
        int len2 = 2;
        int start1 = 1;
        
        assertFalse(CharSequenceUtils.checkLaterThan1(cs, searchChar, len2, start1));
    }
    
    @Test
    void testCheckLaterThan1_MismatchedChars() {
        CharSequence cs = "hello";
        CharSequence searchChar = "wo";
        int len2 = 2;
        int start1 = 1;
        
        assertFalse(CharSequenceUtils.checkLaterThan1(cs, searchChar, len2, start1));
    }
    
    @Test
    void testCheckLaterThan1_SingleChar() {
        CharSequence cs = "hello";
        CharSequence searchChar = "e";
        int len2 = 1;
        int start1 = 1;
        
        assertTrue(CharSequenceUtils.checkLaterThan1(cs, searchChar, len2, start1));
    }
    
    @Test
    void testCheckLaterThan1_SingleCharMismatch() {
        CharSequence cs = "hello";
        CharSequence searchChar = "a";
        int len2 = 1;
        int start1 = 1;
        
        assertFalse(CharSequenceUtils.checkLaterThan1(cs, searchChar, len2, start1));
    }
    
    @Test
    void testCheckLaterThan1_EmptyCharSequence() {
        CharSequence cs = "";
        CharSequence searchChar = "lo";
        int len2 = 2;
        int start1 = 1;
        
        assertFalse(CharSequenceUtils.checkLaterThan1(cs, searchChar, len2, start1));
    }
}