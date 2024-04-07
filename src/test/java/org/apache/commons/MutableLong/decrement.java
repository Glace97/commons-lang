import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class decrementTest {

    @Test
    void testDecrement() {
        MutableLong mutableLong = new MutableLong(5);
        mutableLong.decrement();
        assertEquals(4, mutableLong.value);
    }
    
    @Test
    void testDecrementZero() {
        MutableLong mutableLong = new MutableLong(0);
        mutableLong.decrement();
        assertEquals(-1, mutableLong.value);
    }
    
    @Test
    void testDecrementNegative() {
        MutableLong mutableLong = new MutableLong(-5);
        mutableLong.decrement();
        assertEquals(-6, mutableLong.value);
    }
    
    @Test
    void testDecrementLargeValue() {
        MutableLong mutableLong = new MutableLong(Long.MAX_VALUE);
        mutableLong.decrement();
        assertEquals(Long.MAX_VALUE - 1, mutableLong.value);
    }
    
    @Test
    void testDecrementString() {
        MutableLong mutableLong = new MutableLong("10");
        mutableLong.decrement();
        assertEquals(9, mutableLong.value);
    }
    
    @Test
    void testDecrementNull() {
        assertThrows(NullPointerException.class, () -> {
            MutableLong mutableLong = new MutableLong(null);
            mutableLong.decrement();
        });
    }
    
    @Test
    void testDecrementInvalidString() {
        assertThrows(NumberFormatException.class, () -> {
            MutableLong mutableLong = new MutableLong("abc");
            mutableLong.decrement();
        });
    }
    
}