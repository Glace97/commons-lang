import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ofTest {

    @Test
    void testOf_withValidRange() {
        DoubleRange range = DoubleRange.of(1.0, 5.0);
        assertEquals(1.0, range.getMinimum());
        assertEquals(5.0, range.getMaximum());
    }

    @Test
    void testOf_withReversedOrder() {
        DoubleRange range = DoubleRange.of(5.0, 1.0);
        assertEquals(1.0, range.getMinimum());
        assertEquals(5.0, range.getMaximum());
    }

    @Test
    void testOf_withSameValues() {
        DoubleRange range = DoubleRange.of(1.0, 1.0);
        assertEquals(1.0, range.getMinimum());
        assertEquals(1.0, range.getMaximum());
    }

    @Test
    void testOf_withNullValues() {
        assertThrows(IllegalArgumentException.class, () -> {
            DoubleRange.of(null, 5.0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            DoubleRange.of(1.0, null);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            DoubleRange.of(null, null);
        });
    }
}