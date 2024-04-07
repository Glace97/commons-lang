import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class clearTest {

    private FluentBitSet bitSet;

    @BeforeEach
    void setUp() {
        bitSet = new FluentBitSet();
    }

    @Test
    void testClear() {
        bitSet.set(0, 10);
        bitSet.clear();
        assertFalse(bitSet.get(0));
        assertFalse(bitSet.get(9));
    }

    @Test
    void testClearWithSingleIndex() {
        bitSet.set(0, 10);
        bitSet.clear(5);
        assertFalse(bitSet.get(5));
    }

    @Test
    void testClearWithMultipleIndexes() {
        bitSet.set(0, 10);
        bitSet.clear(2, 6);
        assertFalse(bitSet.get(2));
        assertFalse(bitSet.get(5));
    }

    @Test
    void testClearWithInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> bitSet.clear(-1));
    }

    @Test
    void testClearWithInvalidIndexes() {
        assertThrows(IndexOutOfBoundsException.class, () -> bitSet.clear(2, 1));
    }
}