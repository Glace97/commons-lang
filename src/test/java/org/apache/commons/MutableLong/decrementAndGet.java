import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class decrementAndGetTest {
    private MutableLong mutableLong;

    @BeforeEach
    void setUp() {
        mutableLong = new MutableLong(5);
    }

    @Test
    void testDecrementAndGet() {
        assertEquals(4, mutableLong.decrementAndGet());
    }

    @Test
    void testDecrementAndGet_ZeroValue() {
        mutableLong = new MutableLong(0);
        assertEquals(-1, mutableLong.decrementAndGet());
    }

    @Test
    void testDecrementAndGet_NegativeValue() {
        mutableLong = new MutableLong(-5);
        assertEquals(-6, mutableLong.decrementAndGet());
    }

    @Test
    void testDecrementAndGet_MaxValue() {
        mutableLong = new MutableLong(Long.MAX_VALUE);
        assertEquals(Long.MAX_VALUE - 1, mutableLong.decrementAndGet());
    }

    @Test
    void testDecrementAndGet_MinValue() {
        mutableLong = new MutableLong(Long.MIN_VALUE);
        assertEquals(Long.MIN_VALUE + 1, mutableLong.decrementAndGet());
    }
}

Note: The test suite provided covers the edge cases of having a zero value, a negative value, the maximum value, and the minimum value. It also tests the general case of decrementing a positive value.