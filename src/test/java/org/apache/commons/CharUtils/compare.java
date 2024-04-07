import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompareTest {
    
    @Test
    void testCompareEqualChars() {
        char x = 'a';
        char y = 'a';
        int result = CharUtils.compare(x, y);
        assertEquals(0, result);
    }
    
    @Test
    void testCompareXLessThanY() {
        char x = 'a';
        char y = 'b';
        int result = CharUtils.compare(x, y);
        assertTrue(result < 0);
    }
    
    @Test
    void testCompareXGreaterThanY() {
        char x = 'b';
        char y = 'a';
        int result = CharUtils.compare(x, y);
        assertTrue(result > 0);
    }
    
    @Test
    void testCompareLFAndCR() {
        char x = CharUtils.LF;
        char y = CharUtils.CR;
        int result = CharUtils.compare(x, y);
        assertTrue(result < 0);
    }
    
    @Test
    void testCompareCRAndLF() {
        char x = CharUtils.CR;
        char y = CharUtils.LF;
        int result = CharUtils.compare(x, y);
        assertTrue(result > 0);
    }
    
    @Test
    void testCompareNULAndLF() {
        char x = CharUtils.NUL;
        char y = CharUtils.LF;
        int result = CharUtils.compare(x, y);
        assertTrue(result < 0);
    }
    
    @Test
    void testCompareLFAndNUL() {
        char x = CharUtils.LF;
        char y = CharUtils.NUL;
        int result = CharUtils.compare(x, y);
        assertTrue(result > 0);
    }
    
    @Test
    void testCompareNULAndCR() {
        char x = CharUtils.NUL;
        char y = CharUtils.CR;
        int result = CharUtils.compare(x, y);
        assertTrue(result < 0);
    }
    
    @Test
    void testCompareCRAndNUL() {
        char x = CharUtils.CR;
        char y = CharUtils.NUL;
        int result = CharUtils.compare(x, y);
        assertTrue(result > 0);
    }
    
    @Test
    void testCompareHexDigits() {
        for (int i = 0; i < CharUtils.HEX_DIGITS.length; i++) {
            for (int j = 0; j < CharUtils.HEX_DIGITS.length; j++) {
                char x = CharUtils.HEX_DIGITS[i];
                char y = CharUtils.HEX_DIGITS[j];
                int result = CharUtils.compare(x, y);
                assertEquals(i - j, result);
            }
        }
    }
    
}
