import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getAndDecrementTest {

    @Test
    void testGetAndDecrement() {
        MutableByte mutableByte = new MutableByte((byte) 10);
        byte result = mutableByte.getAndDecrement();
        Assertions.assertEquals(10, result);
        Assertions.assertEquals(9, mutableByte.getValue());
    }

    @Test
    void testGetAndDecrementZero() {
        MutableByte mutableByte = new MutableByte((byte) 0);
        byte result = mutableByte.getAndDecrement();
        Assertions.assertEquals(0, result);
        Assertions.assertEquals(-1, mutableByte.getValue());
    }

    @Test
    void testGetAndDecrementNegative() {
        MutableByte mutableByte = new MutableByte((byte) -10);
        byte result = mutableByte.getAndDecrement();
        Assertions.assertEquals(-10, result);
        Assertions.assertEquals(-11, mutableByte.getValue());
    }

    @Test
    void testGetAndDecrementMaxValue() {
        MutableByte mutableByte = new MutableByte(Byte.MAX_VALUE);
        byte result = mutableByte.getAndDecrement();
        Assertions.assertEquals(Byte.MAX_VALUE, result);
        Assertions.assertEquals(Byte.MAX_VALUE - 1, mutableByte.getValue());
    }

    @Test
    void testGetAndDecrementMinValue() {
        MutableByte mutableByte = new MutableByte(Byte.MIN_VALUE);
        byte result = mutableByte.getAndDecrement();
        Assertions.assertEquals(Byte.MIN_VALUE, result);
        Assertions.assertEquals(Byte.MIN_VALUE - 1, mutableByte.getValue());
    }
}