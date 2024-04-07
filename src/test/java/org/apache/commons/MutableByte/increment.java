import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class incrementTest {
    private MutableByte mutableByte;

    @BeforeEach
    void setUp() {
        mutableByte = new MutableByte();
    }

    @Test
    void testIncrement() {
        mutableByte.increment();
        assertEquals(1, mutableByte.getValue());
    }

    @Test
    void testIncrementMultipleTimes() {
        mutableByte.increment();
        mutableByte.increment();
        mutableByte.increment();
        assertEquals(3, mutableByte.getValue());
    }

    @Test
    void testIncrementWithInitialValue() {
        mutableByte = new MutableByte((byte) 5);
        mutableByte.increment();
        assertEquals(6, mutableByte.getValue());
    }

    @Test
    void testIncrementWithNullValue() {
        assertThrows(NullPointerException.class, () -> {
            mutableByte = new MutableByte(null);
            mutableByte.increment();
        });
    }

    @Test
    void testIncrementWithStringValue() {
        mutableByte = new MutableByte("9");
        mutableByte.increment();
        assertEquals(10, mutableByte.getValue());
    }
}