import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class cardinalityTest {

    @Test
    void testCardinalityWithEmptyBitSet() {
        FluentBitSet bitSet = new FluentBitSet();
        assertEquals(0, bitSet.cardinality());
    }

    @Test
    void testCardinalityWithNonEmptyBitSet() {
        FluentBitSet bitSet = new FluentBitSet(10);
        bitSet.bitSet.set(0, 5);
        assertEquals(5, bitSet.cardinality());
    }

    @Test
    void testCardinalityWithAllBitsSet() {
        FluentBitSet bitSet = new FluentBitSet(10);
        bitSet.bitSet.set(0, 10);
        assertEquals(10, bitSet.cardinality());
    }

    @Test
    void testCardinalityWithNegativeIndex() {
        FluentBitSet bitSet = new FluentBitSet(10);
        assertThrows(IndexOutOfBoundsException.class, () -> bitSet.bitSet.set(-1));
    }

    @Test
    void testCardinalityWithOutOfRangeIndex() {
        FluentBitSet bitSet = new FluentBitSet(10);
        assertThrows(IndexOutOfBoundsException.class, () -> bitSet.bitSet.set(11));
    }

    @Test
    void testCardinalityWithNullBitSet() {
        FluentBitSet bitSet = new FluentBitSet();
        bitSet.bitSet = null;
        assertThrows(NullPointerException.class, bitSet::cardinality);
    }
}