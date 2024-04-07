import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class getAndIncrementTest {

    private MutableShort mutableShort;

    @BeforeEach
    void setUp() {
        mutableShort = new MutableShort((short) 0);
    }

    @Test
    @DisplayName("Test getAndIncrement with initial value 0")
    void testGetAndIncrementWithInitialValue0() {
        short result = mutableShort.getAndIncrement();
        assertEquals(0, result);
        assertEquals(1, mutableShort.get());
    }

    @Test
    @DisplayName("Test getAndIncrement with initial value 100")
    void testGetAndIncrementWithInitialValue100() {
        mutableShort = new MutableShort((short) 100);
        short result = mutableShort.getAndIncrement();
        assertEquals(100, result);
        assertEquals(101, mutableShort.get());
    }

    @Test
    @DisplayName("Test getAndIncrement with negative initial value")
    void testGetAndIncrementWithNegativeInitialValue() {
        mutableShort = new MutableShort((short) -100);
        short result = mutableShort.getAndIncrement();
        assertEquals(-100, result);
        assertEquals(-99, mutableShort.get());
    }

    @Test
    @DisplayName("Test getAndIncrement with maximum value")
    void testGetAndIncrementWithMaxValue() {
        mutableShort = new MutableShort(Short.MAX_VALUE);
        short result = mutableShort.getAndIncrement();
        assertEquals(Short.MAX_VALUE, result);
        assertEquals(Short.MIN_VALUE, mutableShort.get());
    }

    @Test
    @DisplayName("Test getAndIncrement with minimum value")
    void testGetAndIncrementWithMinValue() {
        mutableShort = new MutableShort(Short.MIN_VALUE);
        short result = mutableShort.getAndIncrement();
        assertEquals(Short.MIN_VALUE, result);
        assertEquals((short) (Short.MIN_VALUE + 1), mutableShort.get());
    }
}