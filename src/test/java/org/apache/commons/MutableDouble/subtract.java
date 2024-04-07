import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class subtractTest {

    @Test
    void testSubtractDouble() {
        MutableDouble mutableDouble = new MutableDouble(10.0);
        mutableDouble.subtract(5.0);
        assertEquals(5.0, mutableDouble.getValue());
    }

    @Test
    void testSubtractNegativeDouble() {
        MutableDouble mutableDouble = new MutableDouble(10.0);
        mutableDouble.subtract(-5.0);
        assertEquals(15.0, mutableDouble.getValue());
    }

    @Test
    void testSubtractZeroDouble() {
        MutableDouble mutableDouble = new MutableDouble(10.0);
        mutableDouble.subtract(0.0);
        assertEquals(10.0, mutableDouble.getValue());
    }

    @Test
    void testSubtractNumber() {
        MutableDouble mutableDouble = new MutableDouble(10.0);
        mutableDouble.subtract(new Integer(5));
        assertEquals(5.0, mutableDouble.getValue());
    }

    @Test
    void testSubtractNegativeNumber() {
        MutableDouble mutableDouble = new MutableDouble(10.0);
        mutableDouble.subtract(new Integer(-5));
        assertEquals(15.0, mutableDouble.getValue());
    }

    @Test
    void testSubtractZeroNumber() {
        MutableDouble mutableDouble = new MutableDouble(10.0);
        mutableDouble.subtract(new Integer(0));
        assertEquals(10.0, mutableDouble.getValue());
    }

}