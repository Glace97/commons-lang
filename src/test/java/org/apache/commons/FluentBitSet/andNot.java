
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.BitSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@DisplayName("andNot Tests")
class andNotTest {

    private FluentBitSet fluentBitSet;

    @BeforeEach
    void setUp() {
        fluentBitSet = new FluentBitSet();
    }

    @Nested
    @DisplayName("andNot(BitSet) Tests")
    class AndNotBitSetTests {

        @Test
        @DisplayName("Should clear all bits in the bit set that are set in the specified bit set")
        void shouldClearBitsInBitSet() {
            // Arrange
            BitSet bitSet = new BitSet();
            bitSet.set(2);
            bitSet.set(4);

            fluentBitSet.bitSet.set(1);
            fluentBitSet.bitSet.set(2);
            fluentBitSet.bitSet.set(3);

            // Act
            FluentBitSet result = fluentBitSet.andNot(bitSet);

            // Assert
            BitSet expectedBitSet = new BitSet();
            expectedBitSet.set(1);
            expectedBitSet.set(3);
            assertEquals(expectedBitSet, result.bitSet);
        }

        @Test
        @DisplayName("Should return the same FluentBitSet instance")
        void shouldReturnSameInstance() {
            // Arrange
            BitSet bitSet = new BitSet();

            // Act
            FluentBitSet result = fluentBitSet.andNot(bitSet);

            // Assert
            assertSame(fluentBitSet, result);
        }

    }

    @Nested
    @DisplayName("andNot(FluentBitSet) Tests")
    class AndNotFluentBitSetTests {

        @Test
        @DisplayName("Should clear all bits in the bit set that are set in the specified FluentBitSet")
        void shouldClearBitsInBitSet() {
            // Arrange
            FluentBitSet set = new FluentBitSet();
            set.bitSet.set(1);
            set.bitSet.set(3);

            fluentBitSet.bitSet.set(1);
            fluentBitSet.bitSet.set(2);
            fluentBitSet.bitSet.set(3);

            // Act
            FluentBitSet result = fluentBitSet.andNot(set);

            // Assert
            BitSet expectedBitSet = new BitSet();
            expectedBitSet.set(2);
            assertEquals(expectedBitSet, result.bitSet);
        }

        @Test
        @DisplayName("Should return the same FluentBitSet instance")
        void shouldReturnSameInstance() {
            // Arrange
            FluentBitSet set = new FluentBitSet();

            // Act
            FluentBitSet result = fluentBitSet.andNot(set);

            // Assert
            assertSame(fluentBitSet, result);
        }

    }

}
