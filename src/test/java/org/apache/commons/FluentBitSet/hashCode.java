import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class hashCodeTest {

    private FluentBitSet fluentBitSet;

    @BeforeEach
    void setUp() {
        fluentBitSet = new FluentBitSet();
    }

    @Test
    void testHashCodeWithEmptyBitSet() {
        int expectedHashCode = new BitSet().hashCode();
        assertEquals(expectedHashCode, fluentBitSet.hashCode());
    }

    @Test
    void testHashCodeWithNonEmptyBitSet() {
        BitSet bitSet = new BitSet();
        bitSet.set(0);
        fluentBitSet = new FluentBitSet(bitSet);

        int expectedHashCode = bitSet.hashCode();
        assertEquals(expectedHashCode, fluentBitSet.hashCode());
    }

    @Test
    void testHashCodeWithDifferentBitSets() {
        BitSet bitSet1 = new BitSet();
        bitSet1.set(0);
        fluentBitSet = new FluentBitSet(bitSet1);

        BitSet bitSet2 = new BitSet();
        bitSet2.set(1);

        assertNotEquals(bitSet2.hashCode(), fluentBitSet.hashCode());
    }

    @Test
    void testHashCodeWithLargeBitSet() {
        int nbits = 100;
        BitSet bitSet = new BitSet(nbits);
        bitSet.set(0, nbits);
        fluentBitSet = new FluentBitSet(bitSet);

        int expectedHashCode = bitSet.hashCode();
        assertEquals(expectedHashCode, fluentBitSet.hashCode());
    }
}