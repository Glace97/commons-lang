import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class intValueTest {

    @Test
    void testIntValue() {
        MutableByte mutableByte = new MutableByte((byte) 10);
        assertEquals(10, mutableByte.intValue());
    }

    @Test
    void testIntValueMinValue() {
        MutableByte mutableByte = new MutableByte(Byte.MIN_VALUE);
        assertEquals(Byte.MIN_VALUE, mutableByte.intValue());
    }

    @Test
    void testIntValueMaxValue() {
        MutableByte mutableByte = new MutableByte(Byte.MAX_VALUE);
        assertEquals(Byte.MAX_VALUE, mutableByte.intValue());
    }

    @Test
    void testIntValueZero() {
        MutableByte mutableByte = new MutableByte((byte) 0);
        assertEquals(0, mutableByte.intValue());
    }

    @Test
    void testIntValueNegativeValue() {
        MutableByte mutableByte = new MutableByte((byte) -5);
        assertEquals(-5, mutableByte.intValue());
    }

}