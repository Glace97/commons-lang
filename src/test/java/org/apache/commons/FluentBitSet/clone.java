import static org.junit.jupiter.api.Assertions.*;

import java.util.BitSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class cloneTest {

    private FluentBitSet bitSet;

    @BeforeEach
    void setUp() {
        bitSet = new FluentBitSet();
    }

    @Test
    void testClone() {
        FluentBitSet clone = (FluentBitSet) bitSet.clone();
        assertNotSame(bitSet, clone);
        assertEquals(bitSet.bitSet, clone.bitSet);
    }

    @Test
    void testCloneWithNonEmptyBitSet() {
        BitSet set = new BitSet();
        set.set(2);
        set.set(4);
        FluentBitSet nonEmptyBitSet = new FluentBitSet(set);

        FluentBitSet clone = (FluentBitSet) nonEmptyBitSet.clone();
        assertNotSame(nonEmptyBitSet, clone);
        assertEquals(nonEmptyBitSet.bitSet, clone.bitSet);
    }

    @Test
    void testCloneWithLargeBitSet() {
        int nbits = 100;
        FluentBitSet largeBitSet = new FluentBitSet(nbits);

        FluentBitSet clone = (FluentBitSet) largeBitSet.clone();
        assertNotSame(largeBitSet, clone);
        assertEquals(largeBitSet.bitSet, clone.bitSet);
    }

    @Test
    void testCloneWithNegativeSize() {
        assertThrows(NegativeArraySizeException.class, () -> {
            FluentBitSet negativeSizeBitSet = new FluentBitSet(-1);
            negativeSizeBitSet.clone();
        });
    }
}