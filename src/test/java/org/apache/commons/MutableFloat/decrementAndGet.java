import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class decrementAndGetTest {

    @Test
    void testDecrementAndGet() {
        MutableFloat mutableFloat = new MutableFloat(5.0f);
        
        assertEquals(4.0f, mutableFloat.decrementAndGet());
    }
    
    @Test
    void testDecrementAndGetWithNegativeValue() {
        MutableFloat mutableFloat = new MutableFloat(-2.5f);
        
        assertEquals(-3.5f, mutableFloat.decrementAndGet());
    }
    
    @Test
    void testDecrementAndGetWithZeroValue() {
        MutableFloat mutableFloat = new MutableFloat(0.0f);
        
        assertEquals(-1.0f, mutableFloat.decrementAndGet());
    }
    
    @Test
    void testDecrementAndGetWithMaxValue() {
        MutableFloat mutableFloat = new MutableFloat(Float.MAX_VALUE);
        
        assertEquals(Float.MAX_VALUE - 1.0f, mutableFloat.decrementAndGet());
    }
    
    @Test
    void testDecrementAndGetWithMinValue() {
        MutableFloat mutableFloat = new MutableFloat(Float.MIN_VALUE);
        
        assertEquals(Float.MIN_VALUE - 1.0f, mutableFloat.decrementAndGet());
    }
    
    @Test
    void testDecrementAndGetWithNaNValue() {
        MutableFloat mutableFloat = new MutableFloat(Float.NaN);
        
        assertTrue(Float.isNaN(mutableFloat.decrementAndGet()));
    }
    
    @Test
    void testDecrementAndGetWithInfinityValue() {
        MutableFloat mutableFloat = new MutableFloat(Float.POSITIVE_INFINITY);
        
        assertEquals(Float.POSITIVE_INFINITY, mutableFloat.decrementAndGet());
    }
    
    @Test
    void testDecrementAndGetWithNegativeInfinityValue() {
        MutableFloat mutableFloat = new MutableFloat(Float.NEGATIVE_INFINITY);
        
        assertEquals(Float.NEGATIVE_INFINITY, mutableFloat.decrementAndGet());
    }
    
    @Test
    void testDecrementAndGetMultipleTimes() {
        MutableFloat mutableFloat = new MutableFloat(10.0f);
        
        assertEquals(9.0f, mutableFloat.decrementAndGet());
        assertEquals(8.0f, mutableFloat.decrementAndGet());
        assertEquals(7.0f, mutableFloat.decrementAndGet());
    }
    
}