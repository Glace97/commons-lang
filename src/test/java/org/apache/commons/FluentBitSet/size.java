import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class sizeTest {
    
    private FluentBitSet bitSet;
    
    @BeforeEach
    void setUp() {
        bitSet = new FluentBitSet();
    }
    
    @Test
    @DisplayName("Test size() method for an empty bit set")
    void testSizeForEmptyBitSet() {
        assertEquals(0, bitSet.size());
    }
    
    @Test
    @DisplayName("Test size() method after adding one element")
    void testSizeAfterAddingOneElement() {
        bitSet.bitSet.set(0);
        assertEquals(1, bitSet.size());
    }
    
    @Test
    @DisplayName("Test size() method after adding multiple elements")
    void testSizeAfterAddingMultipleElements() {
        bitSet.bitSet.set(0);
        bitSet.bitSet.set(2);
        bitSet.bitSet.set(4);
        assertEquals(5, bitSet.size());
    }
    
    @Test
    @DisplayName("Test size() method after removing an element")
    void testSizeAfterRemovingElement() {
        bitSet.bitSet.set(0);
        bitSet.bitSet.set(2);
        bitSet.bitSet.set(4);
        bitSet.bitSet.clear(2);
        assertEquals(4, bitSet.size());
    }
    
    @Test
    @DisplayName("Test size() method for a large bit set")
    void testSizeForLargeBitSet() {
        FluentBitSet largeBitSet = new FluentBitSet(1000);
        assertEquals(1000, largeBitSet.size());
    }
}