import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isAsciiControlTest {
    
    @Test
    void testIsAsciiControl() {
        // Test for characters less than 32
        for (char ch = 0; ch < 32; ch++) {
            assertTrue(CharUtils.isAsciiControl(ch));
        }
        
        // Test for character 127
        assertTrue(CharUtils.isAsciiControl((char) 127));
        
        // Test for characters greater than 32 and not equal to 127
        for (char ch = 32; ch < 127; ch++) {
            assertFalse(CharUtils.isAsciiControl(ch));
        }
        
        // Test for characters greater than 127
        for (char ch = 128; ch < 256; ch++) {
            assertFalse(CharUtils.isAsciiControl(ch));
        }
    }
}