import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class previousSetBitTest {

    private FluentBitSet bitSet;

    @BeforeEach
    void setUp() {
        bitSet = new FluentBitSet();
    }

    @Test
    void testPreviousSetBitWithEmptyBitSet() {
        int result = bitSet.previousSetBit(-1);
        assertEquals(-1, result);
    }

    @Test
    void testPreviousSetBitWithNoSetBits() {
        int result = bitSet.previousSetBit(0);
        assertEquals(-1, result);
    }

    @Test
    void testPreviousSetBitWithSingleSetBit() {
        bitSet = new FluentBitSet(1);
        bitSet.bitSet.set(0);
        int result = bitSet.previousSetBit(0);
        assertEquals(0, result);
    }

    @Test
    void testPreviousSetBitWithMultipleSetBits() {
        bitSet = new FluentBitSet(5);
        bitSet.bitSet.set(0);
        bitSet.bitSet.set(2);
        bitSet.bitSet.set(4);
        int result = bitSet.previousSetBit(6);
        assertEquals(4, result);
    }

    @Test
    void testPreviousSetBitWithNegativeFromIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> bitSet.previousSetBit(-2));
    }

    @Test
    void testPreviousSetBitWithLargeFromIndex() {
        bitSet = new FluentBitSet(10);
        bitSet.bitSet.set(5);
        int result = bitSet.previousSetBit(9);
        assertEquals(5, result);
    }
}