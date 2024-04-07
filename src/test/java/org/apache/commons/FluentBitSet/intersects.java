import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class IntersectsTest {

    @Test
    void testIntersects_SameBitSet_ShouldReturnTrue() {
        FluentBitSet bitSet1 = new FluentBitSet();
        FluentBitSet bitSet2 = new FluentBitSet();
        bitSet1.set(0);
        bitSet2.set(0);

        assertTrue(bitSet1.intersects(bitSet2));
    }

    @Test
    void testIntersects_DifferentBitSet_ShouldReturnFalse() {
        FluentBitSet bitSet1 = new FluentBitSet();
        FluentBitSet bitSet2 = new FluentBitSet();
        bitSet1.set(0);
        bitSet2.set(1);

        assertFalse(bitSet1.intersects(bitSet2));
    }

    @Test
    void testIntersects_EmptyBitSet_ShouldReturnFalse() {
        FluentBitSet bitSet1 = new FluentBitSet();
        FluentBitSet bitSet2 = new FluentBitSet();

        assertFalse(bitSet1.intersects(bitSet2));
    }

    @Test
    void testIntersects_SameBitSetAsParameter_ShouldReturnTrue() {
        BitSet bitSet1 = new BitSet();
        bitSet1.set(0);

        FluentBitSet fluentBitSet = new FluentBitSet(bitSet1);

        assertTrue(fluentBitSet.intersects(fluentBitSet));
    }

    @Test
    void testIntersects_DifferentBitSetAsParameter_ShouldReturnFalse() {
        BitSet bitSet1 = new BitSet();
        BitSet bitSet2 = new BitSet();
        bitSet1.set(0);
        bitSet2.set(1);

        FluentBitSet fluentBitSet1 = new FluentBitSet(bitSet1);
        FluentBitSet fluentBitSet2 = new FluentBitSet(bitSet2);

        assertFalse(fluentBitSet1.intersects(fluentBitSet2));
    }

    @Test
    void testIntersects_NullBitSet_ShouldThrowNullPointerException() {
        FluentBitSet bitSet = new FluentBitSet();

        assertThrows(NullPointerException.class, () -> bitSet.intersects(null));
    }
}