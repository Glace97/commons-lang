import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.BitSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class NextSetBitTest {

    private FluentBitSet fluentBitSet;

    @BeforeEach
    void setUp() {
        fluentBitSet = new FluentBitSet();
    }

    @Nested
    @DisplayName("Tests for nextSetBit method")
    class NextSetBitMethodTests {

        @Test
        @DisplayName("Should return -1 when no set bit exists")
        void shouldReturnMinusOneWhenNoSetBitExists() {
            assertEquals(-1, fluentBitSet.nextSetBit(0));
        }

        @Test
        @DisplayName("Should return -1 when fromIndex is greater than the length of the bit set")
        void shouldReturnMinusOneWhenFromIndexIsGreaterThanBitSetLength() {
            BitSet bitSet = new BitSet(5);
            FluentBitSet fluentBitSet = new FluentBitSet(bitSet);

            assertEquals(-1, fluentBitSet.nextSetBit(10));
        }

        @Test
        @DisplayName("Should return -1 when fromIndex is negative")
        void shouldReturnMinusOneWhenFromIndexIsNegative() {
            assertThrows(IndexOutOfBoundsException.class, () -> fluentBitSet.nextSetBit(-1));
        }

        @Test
        @DisplayName("Should return the index of the next set bit")
        void shouldReturnIndexOfNextSetBit() {
            BitSet bitSet = new BitSet(5);
            bitSet.set(2);
            FluentBitSet fluentBitSet = new FluentBitSet(bitSet);

            assertEquals(2, fluentBitSet.nextSetBit(0));
        }

        @Test
        @DisplayName("Should return -1 when the next set bit index is Integer.MAX_VALUE")
        void shouldReturnMinusOneWhenNextSetBitIndexIsMaxValue() {
            BitSet bitSet = new BitSet(5);
            bitSet.set(Integer.MAX_VALUE);
            FluentBitSet fluentBitSet = new FluentBitSet(bitSet);

            assertEquals(-1, fluentBitSet.nextSetBit(Integer.MAX_VALUE));
        }

    }

}