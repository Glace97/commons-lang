import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.*;

class xorTest {

    private FluentBitSet fluentBitSet;

    @BeforeEach
    void setUp() {
        fluentBitSet = new FluentBitSet();
    }

    @Test
    void testXorWithEmptySet() {
        FluentBitSet result = fluentBitSet.xor(new BitSet());
        assertEquals(fluentBitSet, result);
    }

    @Test
    void testXorWithEmptyFluentBitSet() {
        FluentBitSet emptyFluentBitSet = new FluentBitSet();
        FluentBitSet result = fluentBitSet.xor(emptyFluentBitSet);
        assertEquals(fluentBitSet, result);
    }

    @Test
    void testXorWithNonEmptySet() {
        BitSet set = new BitSet();
        set.set(0);
        FluentBitSet result = fluentBitSet.xor(set);
        assertTrue(result.bitSet.get(0));
    }

    @Test
    void testXorWithNonEmptyFluentBitSet() {
        BitSet set = new BitSet();
        set.set(0);
        FluentBitSet nonEmptyFluentBitSet = new FluentBitSet(set);
        FluentBitSet result = fluentBitSet.xor(nonEmptyFluentBitSet);
        assertTrue(result.bitSet.get(0));
    }

    @Test
    void testXorWithDifferentValues() {
        BitSet set = new BitSet();
        set.set(0);
        set.set(2);
        fluentBitSet.bitSet.set(1);
        fluentBitSet.bitSet.set(3);
        FluentBitSet result = fluentBitSet.xor(set);
        assertTrue(result.bitSet.get(0));
        assertFalse(result.bitSet.get(1));
        assertTrue(result.bitSet.get(2));
        assertFalse(result.bitSet.get(3));
    }
}