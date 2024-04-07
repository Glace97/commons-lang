import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class nextDoubleTest {

    @Test
    void testNextDoubleWithinRange() {
        double result = RandomUtils.nextDouble(1.0, 10.0);
        assertTrue(result >= 1.0 && result < 10.0);
    }

    @Test
    void testNextDoubleEdgeCases() {
        double result = RandomUtils.nextDouble(0, Double.MAX_VALUE);
        assertTrue(result >= 0 && result < Double.MAX_VALUE);
    }

    @Test
    void testNextDoubleNegativeRange() {
        assertThrows(IllegalArgumentException.class, () -> RandomUtils.nextDouble(-10.0, 10.0));
    }

    @Test
    void testNextDoubleEqualRange() {
        double startInclusive = 5.0;
        double endExclusive = 5.0;
        double result = RandomUtils.nextDouble(startInclusive, endExclusive);
        assertEquals(startInclusive, result);
    }

    @Test
    void testNextDoubleZeroRange() {
        double startInclusive = 0.0;
        double endExclusive = 0.0;
        double result = RandomUtils.nextDouble(startInclusive, endExclusive);
        assertEquals(startInclusive, result);
    }
}