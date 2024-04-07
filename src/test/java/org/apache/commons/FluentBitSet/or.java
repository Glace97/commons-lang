import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.BitSet;
import static org.junit.jupiter.api.Assertions.*;

class orTest {

    private FluentBitSet fluentBitSet;

    @BeforeEach
    void setUp() {
        fluentBitSet = new FluentBitSet();
    }

    @Test
    void orWithBitSet_ShouldPerformLogicalOrAndModifyBitSet() {
        BitSet bitSet = new BitSet();
        bitSet.set(0);
        bitSet.set(2);

        fluentBitSet.or(bitSet);

        assertTrue(fluentBitSet.bitSet.get(0));
        assertFalse(fluentBitSet.bitSet.get(1));
        assertTrue(fluentBitSet.bitSet.get(2));
    }

    @Test
    void orWithFluentBitSets_ShouldPerformLogicalOrAndModifyBitSet() {
        FluentBitSet fluentBitSet1 = new FluentBitSet();
        fluentBitSet1.bitSet.set(0);
        FluentBitSet fluentBitSet2 = new FluentBitSet();
        fluentBitSet2.bitSet.set(1);

        fluentBitSet.or(fluentBitSet1, fluentBitSet2);

        assertTrue(fluentBitSet.bitSet.get(0));
        assertTrue(fluentBitSet.bitSet.get(1));
    }

    @Test
    void orWithFluentBitSet_ShouldPerformLogicalOrAndModifyBitSet() {
        FluentBitSet fluentBitSet1 = new FluentBitSet();
        fluentBitSet1.bitSet.set(0);

        fluentBitSet.or(fluentBitSet1);

        assertTrue(fluentBitSet.bitSet.get(0));
    }
}