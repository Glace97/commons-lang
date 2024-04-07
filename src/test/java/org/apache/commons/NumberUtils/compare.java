import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CompareTest {
    
    @Test
    void testCompareByte() {
        byte x = 1;
        byte y = 2;
        
        int result = NumberUtils.compare(x, y);
        
        assertEquals(-1, result);
    }
    
    @Test
    void testCompareInt() {
        int x = 1;
        int y = 2;
        
        int result = NumberUtils.compare(x, y);
        
        assertEquals(-1, result);
    }
    
    @Test
    void testCompareLong() {
        long x = 1L;
        long y = 2L;
        
        int result = NumberUtils.compare(x, y);
        
        assertEquals(-1, result);
    }
    
    @Test
    void testCompareShort() {
        short x = 1;
        short y = 2;
        
        int result = NumberUtils.compare(x, y);
        
        assertEquals(-1, result);
    }
}