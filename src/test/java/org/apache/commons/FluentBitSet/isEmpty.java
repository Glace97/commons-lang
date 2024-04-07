import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isEmptyTest {

    @Test
    void testEmptyBitSet() {
        FluentBitSet bitSet = new FluentBitSet();
        assertTrue(bitSet.isEmpty());
    }
    
    @Test
    void testNonEmptyBitSet() {
        FluentBitSet bitSet = new FluentBitSet();
        bitSet.bitSet.set(0);
        assertFalse(bitSet.isEmpty());
    }
    
    @Test
    void testEmptyBitSetWithInitialSizeZero() {
        FluentBitSet bitSet = new FluentBitSet(0);
        assertTrue(bitSet.isEmpty());
    }
    
    @Test
    void testEmptyBitSetWithInitialSizeOne() {
        FluentBitSet bitSet = new FluentBitSet(1);
        assertTrue(bitSet.isEmpty());
    }
    
    @Test
    void testEmptyBitSetWithNegativeInitialSize() {
        assertThrows(NegativeArraySizeException.class, () -> new FluentBitSet(-1));
    }
    
    @Test
    void testEmptyBitSetWithLargeInitialSize() {
        FluentBitSet bitSet = new FluentBitSet(100);
        assertTrue(bitSet.isEmpty());
    }
    
}