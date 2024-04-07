import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class hashCodeTest {
    private MutableLong mutableLong;

    @BeforeEach
    void setUp() {
        mutableLong = new MutableLong();
    }

    @Test
    void testHashCode() {
        assertEquals(0, mutableLong.hashCode());
    }

    @Test
    void testHashCodeWithValue() {
        mutableLong = new MutableLong(100);
        assertEquals(100, mutableLong.hashCode());
    }

    @Test
    void testHashCodeWithNegativeValue() {
        mutableLong = new MutableLong(-100);
        assertEquals(-100, mutableLong.hashCode());
    }

    @Test
    void testHashCodeWithMaxValue() {
        mutableLong = new MutableLong(Long.MAX_VALUE);
        assertEquals(Long.MAX_VALUE, mutableLong.hashCode());
    }

    @Test
    void testHashCodeWithMinValue() {
        mutableLong = new MutableLong(Long.MIN_VALUE);
        assertEquals(Long.MIN_VALUE, mutableLong.hashCode());
    }

    @Test
    void testHashCodeWithStringValue() {
        mutableLong = new MutableLong("100");
        assertEquals(100, mutableLong.hashCode());
    }

    @Test
    void testHashCodeWithInvalidStringValue() {
        assertThrows(NumberFormatException.class, () -> {
            mutableLong = new MutableLong("abc");
            mutableLong.hashCode();
        });
    }
}
