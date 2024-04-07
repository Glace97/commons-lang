import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class bitSetTest {

    private FluentBitSet bitSet;

    @BeforeEach
    void setUp() {
        bitSet = new FluentBitSet();
    }

    @Test
    void testBitSetConstructor() {
        assertNotNull(bitSet.bitSet());
    }

    @Test
    void testBitSetConstructorWithBitSet() {
        BitSet set = new BitSet();
        FluentBitSet fluentBitSet = new FluentBitSet(set);
        assertEquals(set, fluentBitSet.bitSet());
    }

    @Test
    void testBitSetConstructorWithNbits() {
        int nbits = 10;
        FluentBitSet fluentBitSet = new FluentBitSet(nbits);
        assertNotNull(fluentBitSet.bitSet());
        assertEquals(nbits, fluentBitSet.bitSet().size());
    }

    @Test
    void testBitSetConstructorWithNegativeNbits() {
        assertThrows(NegativeArraySizeException.class, () -> new FluentBitSet(-1));
    }
}