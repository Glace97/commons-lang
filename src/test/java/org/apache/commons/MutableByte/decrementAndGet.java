import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class decrementAndGetTest {
    
    @Test
    void testDecrementAndGet() {
        MutableByte mutableByte = new MutableByte((byte) 10);
        
        byte result = mutableByte.decrementAndGet();
        
        assertEquals(9, result);
    }
    
    @Test
    void testDecrementAndGetNegativeValue() {
        MutableByte mutableByte = new MutableByte((byte) -5);
        
        byte result = mutableByte.decrementAndGet();
        
        assertEquals(-6, result);
    }
    
    @Test
    void testDecrementAndGetZeroValue() {
        MutableByte mutableByte = new MutableByte((byte) 0);
        
        byte result = mutableByte.decrementAndGet();
        
        assertEquals(-1, result);
    }
    
    @Test
    void testDecrementAndGetMaxValue() {
        MutableByte mutableByte = new MutableByte(Byte.MAX_VALUE);
        
        byte result = mutableByte.decrementAndGet();
        
        assertEquals(Byte.MAX_VALUE - 1, result);
    }
    
    @Test
    void testDecrementAndGetMinValue() {
        MutableByte mutableByte = new MutableByte(Byte.MIN_VALUE);
        
        byte result = mutableByte.decrementAndGet();
        
        assertEquals(Byte.MIN_VALUE, result);
    }
    
    @Test
    void testDecrementAndGetFromString() {
        MutableByte mutableByte = new MutableByte("10");
        
        byte result = mutableByte.decrementAndGet();
        
        assertEquals(9, result);
    }
    
    @Test
    void testDecrementAndGetFromStringNegativeValue() {
        MutableByte mutableByte = new MutableByte("-5");
        
        byte result = mutableByte.decrementAndGet();
        
        assertEquals(-6, result);
    }
    
    @Test
    void testDecrementAndGetFromStringZeroValue() {
        MutableByte mutableByte = new MutableByte("0");
        
        byte result = mutableByte.decrementAndGet();
        
        assertEquals(-1, result);
    }
    
    @Test
    void testDecrementAndGetFromStringMaxValue() {
        MutableByte mutableByte = new MutableByte(Byte.toString(Byte.MAX_VALUE));
        
        byte result = mutableByte.decrementAndGet();
        
        assertEquals(Byte.MAX_VALUE - 1, result);
    }
    
    @Test
    void testDecrementAndGetFromStringMinValue() {
        MutableByte mutableByte = new MutableByte(Byte.toString(Byte.MIN_VALUE));
        
        byte result = mutableByte.decrementAndGet();
        
        assertEquals(Byte.MIN_VALUE, result);
    }
}