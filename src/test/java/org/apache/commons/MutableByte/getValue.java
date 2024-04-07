import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getValueTest {

    private MutableByte mutableByte;

    @BeforeEach
    void setUp() {
        mutableByte = new MutableByte();
    }

    @Test
    void testGetValue() {
        assertEquals(Byte.valueOf((byte) 0), mutableByte.getValue());
    }

    @Test
    void testGetValue_WithPositiveValue() {
        mutableByte = new MutableByte((byte) 5);
        assertEquals(Byte.valueOf((byte) 5), mutableByte.getValue());
    }

    @Test
    void testGetValue_WithNegativeValue() {
        mutableByte = new MutableByte((byte) -5);
        assertEquals(Byte.valueOf((byte) -5), mutableByte.getValue());
    }

    @Test
    void testGetValue_WithNumberValue() {
        mutableByte = new MutableByte((Number) 10);
        assertEquals(Byte.valueOf((byte) 10), mutableByte.getValue());
    }

    @Test
    void testGetValue_WithStringValue() {
        mutableByte = new MutableByte("15");
        assertEquals(Byte.valueOf((byte) 15), mutableByte.getValue());
    }

    @Test
    void testGetValue_WithInvalidStringValue() {
        assertThrows(NumberFormatException.class, () -> {
            mutableByte = new MutableByte("abc");
            mutableByte.getValue();
        });
    }
}