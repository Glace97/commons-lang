import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class longValueTest {

    @Test
    void testLongValue() {
        MutableLong mutableLong = new MutableLong();
        assertEquals(0, mutableLong.longValue());

        mutableLong = new MutableLong(10);
        assertEquals(10, mutableLong.longValue());

        mutableLong = new MutableLong(3.14);
        assertEquals(3, mutableLong.longValue());

        mutableLong = new MutableLong("100");
        assertEquals(100, mutableLong.longValue());

        mutableLong = new MutableLong("-50");
        assertEquals(-50, mutableLong.longValue());

        mutableLong = new MutableLong(Long.MAX_VALUE);
        assertEquals(Long.MAX_VALUE, mutableLong.longValue());

        mutableLong = new MutableLong(Long.MIN_VALUE);
        assertEquals(Long.MIN_VALUE, mutableLong.longValue());
    }
}