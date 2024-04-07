import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class previousClearBitTest {

    FluentBitSet bitSet;

    @BeforeEach
    void setUp() {
        bitSet = new FluentBitSet();
    }

    @Test
    @DisplayName("Test when there is a clear bit before the specified index")
    void testPreviousClearBitWithClearBitBeforeIndex() {
        bitSet.bitSet.set(0, 5);
        int result = bitSet.previousClearBit(4);
        assertEquals(3, result);
    }

    @Test
    @DisplayName("Test when there is no clear bit before the specified index")
    void testPreviousClearBitWithNoClearBitBeforeIndex() {
        bitSet.bitSet.set(0, 5);
        int result = bitSet.previousClearBit(5);
        assertEquals(-1, result);
    }

    @Test
    @DisplayName("Test when the specified index is -1")
    void testPreviousClearBitWithNegativeIndex() {
        bitSet.bitSet.set(0, 5);
        int result = bitSet.previousClearBit(-1);
        assertEquals(-1, result);
    }

    @Test
    @DisplayName("Test when the bit set is empty")
    void testPreviousClearBitWithEmptyBitSet() {
        int result = bitSet.previousClearBit(0);
        assertEquals(-1, result);
    }

    @Test
    @DisplayName("Test when the bit set has only one clear bit at index 0")
    void testPreviousClearBitWithSingleClearBit() {
        bitSet.bitSet.set(0);
        int result = bitSet.previousClearBit(0);
        assertEquals(-1, result);
    }

    @Test
    @DisplayName("Test when the bit set has only one clear bit at index 1")
    void testPreviousClearBitWithSingleClearBitAtIndex1() {
        bitSet.bitSet.set(1);
        int result = bitSet.previousClearBit(1);
        assertEquals(0, result);
    }

    @Test
    @DisplayName("Test when the bit set has all bits set")
    void testPreviousClearBitWithAllBitsSet() {
        bitSet.bitSet.set(0, 64);
        int result = bitSet.previousClearBit(63);
        assertEquals(-1, result);
    }
    
    @Test
    @DisplayName("Test when the bit set has a large number of bits set")
    void testPreviousClearBitWithLargeNumberOfBitsSet() {
        IntStream.range(0, 1000000).forEach(bitSet.bitSet::set);
        int result = bitSet.previousClearBit(999999);
        assertEquals(-1, result);
    }
}