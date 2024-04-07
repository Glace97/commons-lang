import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class incrementAndGetTest {

    private MutableByte mutableByte;

    @BeforeEach
    void setUp() {
        mutableByte = new MutableByte((byte) 0);
    }

    @Test
    void testIncrementAndGet() {
        assertEquals(1, mutableByte.incrementAndGet());
    }

    @Test
    void testIncrementAndGetMultipleTimes() {
        assertEquals(1, mutableByte.incrementAndGet());
        assertEquals(2, mutableByte.incrementAndGet());
        assertEquals(3, mutableByte.incrementAndGet());
    }

    @Test
    void testIncrementAndGetWithMaxValue() {
        mutableByte = new MutableByte((byte) 127);
        assertEquals(-128, mutableByte.incrementAndGet());
    }

    @Test
    void testIncrementAndGetWithMinValue() {
        mutableByte = new MutableByte((byte) -128);
        assertEquals(-127, mutableByte.incrementAndGet());
    }
}