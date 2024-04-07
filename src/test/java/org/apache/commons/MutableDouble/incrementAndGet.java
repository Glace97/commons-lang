import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class incrementAndGetTest {

    @Test
    void testIncrementAndGet() {
        MutableDouble mutableDouble = new MutableDouble(0.0);
        
        // Test initial value
        assertEquals(0.0, mutableDouble.incrementAndGet());
        
        // Test incrementing by 1
        assertEquals(1.0, mutableDouble.incrementAndGet());
        
        // Test incrementing by a positive value
        mutableDouble = new MutableDouble(2.5);
        assertEquals(3.5, mutableDouble.incrementAndGet());
        
        // Test incrementing by a negative value
        mutableDouble = new MutableDouble(-2.0);
        assertEquals(-1.0, mutableDouble.incrementAndGet());
        
        // Test incrementing by zero
        mutableDouble = new MutableDouble(10.0);
        assertEquals(10.0, mutableDouble.incrementAndGet());
    }
}