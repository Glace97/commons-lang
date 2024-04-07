import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class equalsTest {

    @Test
    void testEquals() {
        MutableDouble d1 = new MutableDouble(5.0);
        MutableDouble d2 = new MutableDouble(5.0);
        MutableDouble d3 = new MutableDouble(10.0);
        MutableDouble d4 = new MutableDouble(0.0);
        MutableDouble d5 = new MutableDouble(-0.0);
        MutableDouble d6 = new MutableDouble(Double.NaN);

        // Test equal objects
        assertTrue(d1.equals(d1)); // Same object
        assertTrue(d1.equals(d2)); // Same value
        assertTrue(d2.equals(d1)); // Same value
        assertFalse(d1.equals(d3)); // Different value
        assertFalse(d3.equals(d1)); // Different value
        assertFalse(d1.equals(null)); // Null object

        // Test special cases
        assertTrue(d4.equals(d5)); // +0.0 = -0.0
        assertFalse(d1.equals(d4)); // Different value
        assertFalse(d4.equals(d1)); // Different value
        assertFalse(d6.equals(d6)); // Double.NaN != Double.NaN
    }
}