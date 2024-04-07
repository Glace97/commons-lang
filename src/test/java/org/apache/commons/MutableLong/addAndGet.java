import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class addAndGetTest {

    @Test
    void testAddAndGetLong() {
        MutableLong mutableLong = new MutableLong(5);
        assertEquals(10, mutableLong.addAndGet(5));
        assertEquals(15, mutableLong.addAndGet(10));
        assertEquals(-5, mutableLong.addAndGet(-20));
    }

    @Test
    void testAddAndGetNumber() {
        MutableLong mutableLong = new MutableLong(5);
        assertEquals(10, mutableLong.addAndGet(NumberUtils.INTEGER_FIVE));
        assertEquals(15, mutableLong.addAndGet(NumberUtils.INTEGER_TEN));
        assertEquals(-5, mutableLong.addAndGet(NumberUtils.INTEGER_MINUS_TWENTY));
    }

    @Test
    void testAddAndGetZeroLong() {
        MutableLong mutableLong = new MutableLong();
        assertEquals(0, mutableLong.addAndGet(0));
    }

    @Test
    void testAddAndGetZeroNumber() {
        MutableLong mutableLong = new MutableLong();
        assertEquals(0, mutableLong.addAndGet(NumberUtils.INTEGER_ZERO));
    }

    @Test
    void testAddAndGetNegativeLong() {
        MutableLong mutableLong = new MutableLong(-5);
        assertEquals(-10, mutableLong.addAndGet(-5));
        assertEquals(-15, mutableLong.addAndGet(-10));
        assertEquals(5, mutableLong.addAndGet(20));
    }

    @Test
    void testAddAndGetNegativeNumber() {
        MutableLong mutableLong = new MutableLong(-5);
        assertEquals(-10, mutableLong.addAndGet(NumberUtils.INTEGER_MINUS_FIVE));
        assertEquals(-15, mutableLong.addAndGet(NumberUtils.INTEGER_MINUS_TEN));
        assertEquals(5, mutableLong.addAndGet(NumberUtils.INTEGER_TWENTY));
    }

    @Test
    void testAddAndGetWithLargeNumbers() {
        MutableLong mutableLong = new MutableLong(Long.MAX_VALUE);
        assertEquals(Long.MIN_VALUE, mutableLong.addAndGet(Long.MAX_VALUE));
        assertEquals(-1, mutableLong.addAndGet(Long.MIN_VALUE));
    }
}