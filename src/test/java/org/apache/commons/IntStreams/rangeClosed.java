import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.stream.IntStream;

class rangeClosedTest {

    @Test
    void testRangeClosed_zeroToZero() {
        IntStream stream = IntStreams.rangeClosed(0);
        assertEquals(1, stream.count());
    }

    @Test
    void testRangeClosed_zeroToOne() {
        IntStream stream = IntStreams.rangeClosed(1);
        assertEquals(2, stream.count());
    }

    @Test
    void testRangeClosed_negativeToZero() {
        IntStream stream = IntStreams.rangeClosed(-1);
        assertEquals(2, stream.count());
    }

    @Test
    void testRangeClosed_negativeToOne() {
        IntStream stream = IntStreams.rangeClosed(-2);
        assertEquals(3, stream.count());
    }

    @Test
    void testRangeClosed_largeNumber() {
        IntStream stream = IntStreams.rangeClosed(1000000);
        assertEquals(1000001, stream.count());
    }

    @Test
    void testRangeClosed_maxValue() {
        IntStream stream = IntStreams.rangeClosed(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE + 1L, stream.count());
    }

    @Test
    void testRangeClosed_minValue() {
        IntStream stream = IntStreams.rangeClosed(Integer.MIN_VALUE);
        assertEquals((long) Math.abs((long) Integer.MIN_VALUE) + 1L, stream.count());
    }

}