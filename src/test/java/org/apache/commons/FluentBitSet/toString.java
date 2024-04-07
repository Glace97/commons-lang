import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class toStringTest {

    @Test
    void testToStringEmptyBitSet() {
        FluentBitSet bitSet = new FluentBitSet();
        assertEquals("{}", bitSet.toString());
    }

    @Test
    void testToStringBitSetWithOneTrueBit() {
        FluentBitSet bitSet = new FluentBitSet(1);
        bitSet.set(0);
        assertEquals("{0}", bitSet.toString());
    }

    @Test
    void testToStringBitSetWithMultipleTrueBits() {
        FluentBitSet bitSet = new FluentBitSet(5);
        bitSet.set(1);
        bitSet.set(3);
        bitSet.set(4);
        assertEquals("{1, 3, 4}", bitSet.toString());
    }

    @Test
    void testToStringBitSetWithAllTrueBits() {
        FluentBitSet bitSet = new FluentBitSet(8);
        bitSet.set(0, 8);
        assertEquals("{0, 1, 2, 3, 4, 5, 6, 7}", bitSet.toString());
    }

    @Test
    void testToStringBitSetWithNoTrueBits() {
        FluentBitSet bitSet = new FluentBitSet(10);
        assertEquals("{}", bitSet.toString());
    }

    @Test
    void testToStringBitSetWithNegativeSize() {
        assertThrows(NegativeArraySizeException.class, () -> new FluentBitSet(-5).toString());
    }

}