import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class lessThanTest {

    @Test
    void testLessThan() {
        ComparableUtils<Integer> utils = new ComparableUtils<>();
        assertTrue(utils.lessThan(5));
        assertFalse(utils.lessThan(1));
        assertFalse(utils.lessThan(10));
    }

    @Test
    void testLessThanNegative() {
        ComparableUtils<Integer> utils = new ComparableUtils<>();
        assertTrue(utils.lessThan(-5));
        assertFalse(utils.lessThan(-1));
        assertFalse(utils.lessThan(-10));
    }

    @Test
    void testLessThanZero() {
        ComparableUtils<Integer> utils = new ComparableUtils<>();
        assertFalse(utils.lessThan(0));
    }

    @Test
    void testLessThanDecimal() {
        ComparableUtils<Double> utils = new ComparableUtils<>();
        assertTrue(utils.lessThan(3.14));
        assertFalse(utils.lessThan(2.71));
        assertFalse(utils.lessThan(3.14));
    }

    @Test
    void testLessThanNegativeDecimal() {
        ComparableUtils<Double> utils = new ComparableUtils<>();
        assertTrue(utils.lessThan(-3.14));
        assertFalse(utils.lessThan(-2.71));
        assertFalse(utils.lessThan(-3.14));
    }

    @Test
    void testLessThanZeroDecimal() {
        ComparableUtils<Double> utils = new ComparableUtils<>();
        assertFalse(utils.lessThan(0.0));
    }
}