import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class addTest {

    private MutableByte mutableByte;

    @BeforeEach
    void setUp() {
        mutableByte = new MutableByte();
    }

    @Test
    void testAddByte() {
        mutableByte.add((byte) 5);
        assertEquals(5, mutableByte.getValue());
    }

    @Test
    void testAddByteWithNegativeValue() {
        mutableByte.add((byte) -3);
        assertEquals(-3, mutableByte.getValue());
    }

    @Test
    void testAddByteWithMaxValue() {
        mutableByte.add(Byte.MAX_VALUE);
        assertEquals(Byte.MAX_VALUE, mutableByte.getValue());
    }

    @Test
    void testAddByteWithMinValue() {
        mutableByte.add(Byte.MIN_VALUE);
        assertEquals(Byte.MIN_VALUE, mutableByte.getValue());
    }

    @Test
    void testAddByteWithZero() {
        mutableByte.add((byte) 0);
        assertEquals(0, mutableByte.getValue());
    }

    @Test
    void testAddNumber() {
        mutableByte.add(NumberUtils.BYTE_ONE);
        assertEquals(1, mutableByte.getValue());
    }

    @Test
    void testAddNumberWithNegativeValue() {
        mutableByte.add(NumberUtils.BYTE_MINUS_ONE);
        assertEquals(-1, mutableByte.getValue());
    }

    @Test
    void testAddNumberWithMaxValue() {
        mutableByte.add(NumberUtils.BYTE_MAX_VALUE);
        assertEquals(Byte.MAX_VALUE, mutableByte.getValue());
    }

    @Test
    void testAddNumberWithMinValue() {
        mutableByte.add(NumberUtils.BYTE_MIN_VALUE);
        assertEquals(Byte.MIN_VALUE, mutableByte.getValue());
    }

    @Test
    void testAddNumberWithZero() {
        mutableByte.add(NumberUtils.BYTE_ZERO);
        assertEquals(0, mutableByte.getValue());
    }
}