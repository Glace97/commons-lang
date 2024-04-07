import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class nextFloatTest {

    @Test
    void testNextFloat() {
        float result = RandomUtils.nextFloat();
        assertTrue(result >= 0 && result < Float.MAX_VALUE);
    }

    @Test
    void testNextFloatInRange() {
        float startInclusive = 10.5f;
        float endExclusive = 20.5f;
        float result = RandomUtils.nextFloat(startInclusive, endExclusive);
        assertTrue(result >= startInclusive && result < endExclusive);
    }

    @Test
    void testNextFloatEqualRange() {
        float startInclusive = 10.5f;
        float endExclusive = 10.5f;
        float result = RandomUtils.nextFloat(startInclusive, endExclusive);
        assertEquals(startInclusive, result);
    }

    @Test
    void testNextFloatNegativeRange() {
        float startInclusive = -5.0f;
        float endExclusive = 10.0f;
        assertThrows(IllegalArgumentException.class, () -> {
            RandomUtils.nextFloat(startInclusive, endExclusive);
        });
    }

    @Test
    void testNextFloatStartGreaterThanEnd() {
        float startInclusive = 10.0f;
        float endExclusive = 5.0f;
        assertThrows(IllegalArgumentException.class, () -> {
            RandomUtils.nextFloat(startInclusive, endExclusive);
        });
    }
}