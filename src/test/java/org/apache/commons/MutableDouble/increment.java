import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class incrementTest {

    @Test
    public void testIncrement() {
        MutableDouble mutableDouble = new MutableDouble(0.0);
        mutableDouble.increment();
        assertEquals(1.0, mutableDouble.getValue());
    }

    @Test
    public void testIncrementNegativeValue() {
        MutableDouble mutableDouble = new MutableDouble(-1.0);
        mutableDouble.increment();
        assertEquals(0.0, mutableDouble.getValue());
    }

    @Test
    public void testIncrementDecimalValue() {
        MutableDouble mutableDouble = new MutableDouble(1.5);
        mutableDouble.increment();
        assertEquals(2.5, mutableDouble.getValue());
    }

    @Test
    public void testIncrementLargeValue() {
        MutableDouble mutableDouble = new MutableDouble(Double.MAX_VALUE);
        mutableDouble.increment();
        assertEquals(Double.POSITIVE_INFINITY, mutableDouble.getValue());
    }

    @Test
    public void testIncrementZeroValue() {
        MutableDouble mutableDouble = new MutableDouble(0.0);
        mutableDouble.increment();
        assertEquals(1.0, mutableDouble.getValue());
    }

    @Test
    public void testIncrementStringConstructor() {
        MutableDouble mutableDouble = new MutableDouble("2.0");
        mutableDouble.increment();
        assertEquals(3.0, mutableDouble.getValue());
    }

    @Test
    public void testIncrementNullConstructor() {
        MutableDouble mutableDouble = new MutableDouble((Number) null);
        mutableDouble.increment();
        assertEquals(1.0, mutableDouble.getValue());
    }
}