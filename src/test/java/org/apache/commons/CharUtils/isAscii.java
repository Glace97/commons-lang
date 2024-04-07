import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isAsciiTest {
    
    @Test
    void testIsAsciiLowercase() {
        assertTrue(CharUtils.isAscii('a'));
    }
    
    @Test
    void testIsAsciiUppercase() {
        assertTrue(CharUtils.isAscii('A'));
    }
    
    @Test
    void testIsAsciiDigit() {
        assertTrue(CharUtils.isAscii('3'));
    }
    
    @Test
    void testIsAsciiSpecialCharacter() {
        assertTrue(CharUtils.isAscii('-'));
    }
    
    @Test
    void testIsAsciiNewLine() {
        assertTrue(CharUtils.isAscii('\n'));
    }
    
    @Test
    void testIsAsciiNonAsciiCharacter() {
        assertFalse(CharUtils.isAscii('©'));
    }
    
    @Test
    void testIsAsciiNullCharacter() {
        assertTrue(CharUtils.isAscii('\0'));
    }
    
    @Test
    void testIsAsciiEdgeCaseLowerBound() {
        assertTrue(CharUtils.isAscii((char) 0));
    }
    
    @Test
    void testIsAsciiEdgeCaseUpperBound() {
        assertTrue(CharUtils.isAscii((char) 127));
    }
    
    @Test
    void testIsAsciiBeyondUpperBound() {
        assertFalse(CharUtils.isAscii((char) 128));
    }
    
    @Test
    void testIsAsciiNegativeCharacter() {
        assertFalse(CharUtils.isAscii((char) -1));
    }
    
}