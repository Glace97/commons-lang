import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class addAndGetTest {
    
    @Test
    void testAddAndGetWithInteger() {
        MutableInt mutableInt = new MutableInt(5);
        int result = mutableInt.addAndGet(3);
        assertEquals(8, result);
    }
    
    @Test
    void testAddAndGetWithNegativeInteger() {
        MutableInt mutableInt = new MutableInt(-5);
        int result = mutableInt.addAndGet(3);
        assertEquals(-2, result);
    }
    
    @Test
    void testAddAndGetWithZero() {
        MutableInt mutableInt = new MutableInt(0);
        int result = mutableInt.addAndGet(3);
        assertEquals(3, result);
    }
    
    @Test
    void testAddAndGetWithLargeInteger() {
        MutableInt mutableInt = new MutableInt(Integer.MAX_VALUE);
        int result = mutableInt.addAndGet(3);
        assertEquals(Integer.MIN_VALUE + 2, result);
    }
    
    @Test
    void testAddAndGetWithNullOperand() {
        MutableInt mutableInt = new MutableInt(5);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            mutableInt.addAndGet(null);
        });
        assertEquals("Operand cannot be null", exception.getMessage());
    }
    
    @Test
    void testAddAndGetWithDoubleOperand() {
        MutableInt mutableInt = new MutableInt(5);
        int result = mutableInt.addAndGet(3.5);
        assertEquals(8, result);
    }
    
    @Test
    void testAddAndGetWithStringOperand() {
        MutableInt mutableInt = new MutableInt(5);
        int result = mutableInt.addAndGet("3");
        assertEquals(8, result);
    }
    
    @Test
    void testAddAndGetWithStringOperandInvalidFormat() {
        MutableInt mutableInt = new MutableInt(5);
        NumberFormatException exception = assertThrows(NumberFormatException.class, () -> {
            mutableInt.addAndGet("abc");
        });
        assertEquals("String cannot be parsed into an int", exception.getMessage());
    }
    
}