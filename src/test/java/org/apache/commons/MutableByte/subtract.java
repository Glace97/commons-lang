import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SubtractTest {
    private MutableByte mutableByte;

    @BeforeEach
    void setup() {
        mutableByte = new MutableByte((byte) 10);
    }

    @Test
    void subtractByte_shouldSubtractByteFromMutableByte() {
        mutableByte.subtract((byte) 5);
        assertEquals((byte) 5, mutableByte.getValue());
    }

    @Test
    void subtractByte_shouldNotChangeValueIfByteIsZero() {
        mutableByte.subtract((byte) 0);
        assertEquals((byte) 10, mutableByte.getValue());
    }

    @Test
    void subtractByte_shouldSubtractNegativeByteFromMutableByte() {
        mutableByte.subtract((byte) -5);
        assertEquals((byte) 15, mutableByte.getValue());
    }

    @Test
    void subtractNumber_shouldSubtractNumberFromMutableByte() {
        mutableByte.subtract((byte) 5);
        assertEquals((byte) 5, mutableByte.getValue());
    }

    @Test
    void subtractNumber_shouldNotChangeValueIfNumberIsZero() {
        mutableByte.subtract((byte) 0);
        assertEquals((byte) 10, mutableByte.getValue());
    }

    @Test
    void subtractNumber_shouldSubtractNegativeNumberFromMutableByte() {
        mutableByte.subtract((byte) -5);
        assertEquals((byte) 15, mutableByte.getValue());
    }
}