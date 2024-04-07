import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class RangeTest {

    @Test
    void testRangeWithPositiveEndExclusive() {
        int endExclusive = 5;
        int[] expectedRange = {0, 1, 2, 3, 4};
        assertArrayEquals(expectedRange, IntStreams.range(endExclusive).toArray());
    }

    @Test
    void testRangeWithZeroEndExclusive() {
        int endExclusive = 0;
        int[] expectedRange = {};
        assertArrayEquals(expectedRange, IntStreams.range(endExclusive).toArray());
    }

    @Test
    void testRangeWithNegativeEndExclusive() {
        int endExclusive = -5;
        int[] expectedRange = {};
        assertArrayEquals(expectedRange, IntStreams.range(endExclusive).toArray());
    }

    @Test
    void testRangeWithMaxIntEndExclusive() {
        int endExclusive = Integer.MAX_VALUE;
        int[] expectedRange = new int[endExclusive];
        for (int i = 0; i < endExclusive; i++) {
            expectedRange[i] = i;
        }
        assertArrayEquals(expectedRange, IntStreams.range(endExclusive).toArray());
    }

    @Test
    void testRangeWithMinIntEndExclusive() {
        int endExclusive = Integer.MIN_VALUE;
        int[] expectedRange = {};
        assertArrayEquals(expectedRange, IntStreams.range(endExclusive).toArray());
    }
}