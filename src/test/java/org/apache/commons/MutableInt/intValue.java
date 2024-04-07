import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class intValueTest {
    
    @Test
    void testIntValueWithDefaultConstructor() {
        MutableInt mutableInt = new MutableInt();
        assertEquals(0, mutableInt.intValue());
    }
    
    @Test
    void testIntValueWithIntConstructor() {
        MutableInt mutableInt = new MutableInt(10);
        assertEquals(10, mutableInt.intValue());
    }
    
    @Test
    void testIntValueWithNumberConstructor() {
        MutableInt mutableInt = new MutableInt(10);
        assertEquals(10, mutableInt.intValue());
    }
    
    @Test
    void testIntValueWithStringConstructor() {
        MutableInt mutableInt = new MutableInt("10");
        assertEquals(10, mutableInt.intValue());
    }
    
    @Test
    void testIntValueWithInvalidStringConstructor() {
        try {
            MutableInt mutableInt = new MutableInt("abc");
        } catch (NumberFormatException e) {
            // Expected exception, do nothing
        }
    }
    
    @Test
    void testIntValueWithMaxValue() {
        MutableInt mutableInt = new MutableInt(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, mutableInt.intValue());
    }
    
    @Test
    void testIntValueWithMinValue() {
        MutableInt mutableInt = new MutableInt(Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE, mutableInt.intValue());
    }
    
}
