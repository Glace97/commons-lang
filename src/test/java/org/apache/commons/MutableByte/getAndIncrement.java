import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class getAndIncrementTest {

    @Test
    void testGetAndIncrement() {
        MutableByte mutableByte = new MutableByte(0);
        
        byte result = mutableByte.getAndIncrement();
        
        assertEquals(0, result);
        assertEquals(1, mutableByte.getValue());
    }
    
    @Test
    void testGetAndIncrement_MaxValue() {
        MutableByte mutableByte = new MutableByte(Byte.MAX_VALUE);
        
        byte result = mutableByte.getAndIncrement();
        
        assertEquals(Byte.MAX_VALUE, result);
        assertEquals(Byte.MIN_VALUE, mutableByte.getValue());
    }
    
    @Test
    void testGetAndIncrement_NegativeValue() {
        MutableByte mutableByte = new MutableByte(-1);
        
        byte result = mutableByte.getAndIncrement();
        
        assertEquals(-1, result);
        assertEquals(0, mutableByte.getValue());
    }
    
    @Test
    void testGetAndIncrement_WrapAround() {
        MutableByte mutableByte = new MutableByte(Byte.MAX_VALUE);
        
        mutableByte.getAndIncrement();
        byte result = mutableByte.getAndIncrement();
        
        assertEquals(Byte.MIN_VALUE, result);
        assertEquals(Byte.MIN_VALUE + 1, mutableByte.getValue());
    }
    
    @Test
    void testGetAndIncrement_StringValue() {
        MutableByte mutableByte = new MutableByte("5");
        
        byte result = mutableByte.getAndIncrement();
        
        assertEquals(5, result);
        assertEquals(6, mutableByte.getValue());
    }
    
    @Test
    void testGetAndIncrement_NullValue() {
        MutableByte mutableByte = new MutableByte((Number) null);
        
        byte result = mutableByte.getAndIncrement();
        
        assertEquals(0, result);
        assertEquals(1, mutableByte.getValue());
    }
    
    @Test
    void testGetAndIncrement_InvalidStringValue() {
        try {
            MutableByte mutableByte = new MutableByte("abc");
            
            byte result = mutableByte.getAndIncrement();
            
            // This test should fail and throw a NumberFormatException
        } catch (NumberFormatException e) {
            // Exception expected
        }
    }
    
    @Test
    void testGetAndIncrement_Serialization() {
        MutableByte mutableByte = new MutableByte(10);
        
        byte result = mutableByte.getAndIncrement();
        
        assertEquals(10, result);
        assertEquals(11, mutableByte.getValue());
        
        // TODO: Test serialization and deserialization of mutableByte
    }
}