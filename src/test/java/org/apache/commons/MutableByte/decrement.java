import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class decrementTest {

    @Test
    void testDecrement() {
        MutableByte mutableByte = new MutableByte((byte) 5);
        mutableByte.decrement();
        assertEquals(4, mutableByte.getValue());
    }

    @Test
    void testDecrementMinValue() {
        MutableByte mutableByte = new MutableByte(Byte.MIN_VALUE);
        mutableByte.decrement();
        assertEquals(Byte.MAX_VALUE, mutableByte.getValue());
    }

    @Test
    void testDecrementMaxValue() {
        MutableByte mutableByte = new MutableByte(Byte.MAX_VALUE);
        mutableByte.decrement();
        assertEquals(Byte.MAX_VALUE - 1, mutableByte.getValue());
    }

    @Test
    void testDecrementZero() {
        MutableByte mutableByte = new MutableByte((byte) 0);
        mutableByte.decrement();
        assertEquals((byte) -1, mutableByte.getValue());
    }

    @Test
    void testDecrementNegativeValue() {
        MutableByte mutableByte = new MutableByte((byte) -10);
        mutableByte.decrement();
        assertEquals((byte) -11, mutableByte.getValue());
    }
}