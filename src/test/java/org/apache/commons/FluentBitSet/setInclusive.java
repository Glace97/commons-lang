import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class setInclusiveTest {
    private FluentBitSet bitSet;

    @BeforeEach
    void setUp() {
        bitSet = new FluentBitSet();
    }

    @Test
    void testSetInclusive() {
        // Test setInclusive with valid range
        bitSet.setInclusive(0, 5);
        assertTrue(bitSet.bitSet.get(0));
        assertTrue(bitSet.bitSet.get(1));
        assertTrue(bitSet.bitSet.get(2));
        assertTrue(bitSet.bitSet.get(3));
        assertTrue(bitSet.bitSet.get(4));
        assertTrue(bitSet.bitSet.get(5));

        // Test setInclusive with negative fromIndex
        assertThrows(IndexOutOfBoundsException.class, () -> {
            bitSet.setInclusive(-5, 5);
        });

        // Test setInclusive with negative toIndex
        assertThrows(IndexOutOfBoundsException.class, () -> {
            bitSet.setInclusive(0, -5);
        });

        // Test setInclusive with fromIndex larger than toIndex
        assertThrows(IndexOutOfBoundsException.class, () -> {
            bitSet.setInclusive(5, 0);
        });

        // Test setInclusive with fromIndex equal to toIndex
        bitSet.setInclusive(0, 0);
        assertTrue(bitSet.bitSet.get(0));
        assertFalse(bitSet.bitSet.get(1));
    }
}