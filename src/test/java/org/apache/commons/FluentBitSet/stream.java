
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.BitSet;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("stream method tests")
class StreamTest {

    private FluentBitSet fluentBitSet;

    @BeforeEach
    void setUp() {
        fluentBitSet = new FluentBitSet();
    }

    @Nested
    @DisplayName("when the bit set is empty")
    class EmptyBitSetTests {

        @Test
        @DisplayName("should return an empty stream")
        void shouldReturnEmptyStream() {
            IntStream stream = fluentBitSet.stream();
            assertTrue(stream.count() == 0);
        }
    }

    @Nested
    @DisplayName("when the bit set contains some bits in the set state")
    class NonEmptyBitSetTests {

        private BitSet bitSet;

        @BeforeEach
        void setUp() {
            bitSet = new BitSet();
            bitSet.set(3);
            bitSet.set(7);
            bitSet.set(10);
            fluentBitSet = new FluentBitSet(bitSet);
        }

        @Test
        @DisplayName("should return a stream with the correct indices")
        void shouldReturnStreamWithCorrectIndices() {
            IntStream stream = fluentBitSet.stream();
            int[] expectedIndices = {3, 7, 10};
            assertArrayEquals(expectedIndices, stream.toArray());
        }

        @Test
        @DisplayName("should return a stream with the same number of bits as the cardinality")
        void shouldReturnStreamWithCorrectSize() {
            IntStream stream = fluentBitSet.stream();
            assertEquals(bitSet.cardinality(), stream.count());
        }
    }

    @Nested
    @DisplayName("when the bit set is initialized with a specific size")
    class SizedBitSetTests {

        private int nbits = 10;

        @BeforeEach
        void setUp() {
            fluentBitSet = new FluentBitSet(nbits);
        }

        @Test
        @DisplayName("should return an empty stream")
        void shouldReturnEmptyStream() {
            IntStream stream = fluentBitSet.stream();
            assertTrue(stream.count() == 0);
        }
    }
}
