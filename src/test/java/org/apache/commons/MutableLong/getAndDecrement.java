
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class getAndDecrementTest {

    private MutableLong mutableLong;

    @BeforeEach
    void setUp() {
        mutableLong = new MutableLong(10L);
    }

    @Test
    void testGetAndDecrement() {
        long result = mutableLong.getAndDecrement();
        assertEquals(10L, result);
        assertEquals(9L, mutableLong.value);
    }

    @Test
    void testGetAndDecrementMultipleTimes() {
        long result1 = mutableLong.getAndDecrement();
        long result2 = mutableLong.getAndDecrement();
        long result3 = mutableLong.getAndDecrement();
        assertEquals(10L, result1);
        assertEquals(9L, result2);
        assertEquals(8L, result3);
        assertEquals(7L, mutableLong.value);
    }

    @Test
    void testGetAndDecrementZeroValue() {
        MutableLong zeroMutableLong = new MutableLong(0L);
        long result = zeroMutableLong.getAndDecrement();
        assertEquals(0L, result);
        assertEquals(-1L, zeroMutableLong.value);
    }

    @Test
    void testGetAndDecrementNegativeValue() {
        MutableLong negativeMutableLong = new MutableLong(-5L);
        long result = negativeMutableLong.getAndDecrement();
        assertEquals(-5L, result);
        assertEquals(-6L, negativeMutableLong.value);
    }

}
