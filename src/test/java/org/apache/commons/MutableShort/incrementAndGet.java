import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class incrementAndGetTest {

    @Test
    void testIncrementAndGet() {
        MutableShort mutableShort = new MutableShort(0);
        
        // Test initial value
        assertEquals(0, mutableShort.incrementAndGet());
        
        // Test positive increment
        assertEquals(1, mutableShort.incrementAndGet());
        assertEquals(2, mutableShort.incrementAndGet());
        
        // Test negative increment
        mutableShort = new MutableShort(-1);
        assertEquals(0, mutableShort.incrementAndGet());
        assertEquals(1, mutableShort.incrementAndGet());
        
        // Test edge cases
        mutableShort = new MutableShort(Short.MAX_VALUE);
        assertEquals(Short.MIN_VALUE, mutableShort.incrementAndGet());
        
        mutableShort = new MutableShort(Short.MIN_VALUE);
        assertEquals((short)(Short.MIN_VALUE + 1), mutableShort.incrementAndGet());
    }
}