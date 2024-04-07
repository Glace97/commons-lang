import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class incrementAndGetTest {
    
    @Test
    void testIncrementAndGet() {
        // Test case 1: Test incrementAndGet() with initial value 0
        MutableLong mutableLong1 = new MutableLong(0);
        assertEquals(1, mutableLong1.incrementAndGet());
        
        // Test case 2: Test incrementAndGet() with initial value -1
        MutableLong mutableLong2 = new MutableLong(-1);
        assertEquals(0, mutableLong2.incrementAndGet());
        
        // Test case 3: Test incrementAndGet() with initial value Long.MAX_VALUE
        MutableLong mutableLong3 = new MutableLong(Long.MAX_VALUE);
        assertEquals(Long.MIN_VALUE, mutableLong3.incrementAndGet());
        
        // Test case 4: Test incrementAndGet() with initial value Long.MIN_VALUE
        MutableLong mutableLong4 = new MutableLong(Long.MIN_VALUE);
        assertEquals(Long.MIN_VALUE + 1, mutableLong4.incrementAndGet());
        
        // Test case 5: Test incrementAndGet() with initial value Long.MAX_VALUE - 1
        MutableLong mutableLong5 = new MutableLong(Long.MAX_VALUE - 1);
        assertEquals(Long.MAX_VALUE, mutableLong5.incrementAndGet());
    }
}