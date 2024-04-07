import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class lengthTest {

    private FluentBitSet bitSet;

    @BeforeEach
    void setUp() {
        bitSet = new FluentBitSet();
    }

    @Test
    void testLength_EmptyBitSet() {
        assertEquals(0, bitSet.length());
    }

    @Test
    void testLength_SingleBitSet() {
        bitSet.bitSet.set(0);
        assertEquals(1, bitSet.length());
    }

    @Test
    void testLength_MultipleBitsSet() {
        bitSet.bitSet.set(0);
        bitSet.bitSet.set(2);
        bitSet.bitSet.set(4);
        assertEquals(5, bitSet.length());
    }

    @Test
    void testLength_LargeBitSet() {
        FluentBitSet largeBitSet = new FluentBitSet(100);
        assertEquals(0, largeBitSet.length());

        largeBitSet.bitSet.set(50);
        assertEquals(51, largeBitSet.length());

        IntStream.range(0, 100).forEach(i -> largeBitSet.bitSet.set(i));
        assertEquals(100, largeBitSet.length());
    }
}