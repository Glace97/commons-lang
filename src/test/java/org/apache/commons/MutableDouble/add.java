import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class addTest {

    @Test
    public void testAddDouble() {
        MutableDouble mutableDouble = new MutableDouble(5.0);
        mutableDouble.add(3.0);
        assertEquals(8.0, mutableDouble.getValue(), 0.0001);
    }

    @Test
    public void testAddNumber() {
        MutableDouble mutableDouble = new MutableDouble(5.0);
        mutableDouble.add(new MutableDouble(3.0));
        assertEquals(8.0, mutableDouble.getValue(), 0.0001);
    }

    @Test
    public void testAddZero() {
        MutableDouble mutableDouble = new MutableDouble(5.0);
        mutableDouble.add(0);
        assertEquals(5.0, mutableDouble.getValue(), 0.0001);
    }

    @Test
    public void testAddNegative() {
        MutableDouble mutableDouble = new MutableDouble(5.0);
        mutableDouble.add(-3.0);
        assertEquals(2.0, mutableDouble.getValue(), 0.0001);
    }

    @Test
    public void testAddLargeNumber() {
        MutableDouble mutableDouble = new MutableDouble(5.0);
        mutableDouble.add(Double.MAX_VALUE);
        assertEquals(Double.POSITIVE_INFINITY, mutableDouble.getValue(), 0.0001);
    }
}