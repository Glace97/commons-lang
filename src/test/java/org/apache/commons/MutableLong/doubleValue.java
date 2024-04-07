import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class doubleValueTest {

    @Test
    void testDoubleValue() {
        MutableLong mutableLong = new MutableLong();

        // Test case 1: Default value is zero
        assertEquals(0.0, mutableLong.doubleValue());

        // Test case 2: Test positive value
        mutableLong = new MutableLong(10);
        assertEquals(10.0, mutableLong.doubleValue());

        // Test case 3: Test negative value
        mutableLong = new MutableLong(-5);
        assertEquals(-5.0, mutableLong.doubleValue());

        // Test case 4: Test decimal value
        mutableLong = new MutableLong(3.14);
        assertEquals(3.14, mutableLong.doubleValue());

        // Test case 5: Test large value
        mutableLong = new MutableLong(Long.MAX_VALUE);
        assertEquals((double) Long.MAX_VALUE, mutableLong.doubleValue());

        // Test case 6: Test string representation of a number
        mutableLong = new MutableLong("12345");
        assertEquals(12345.0, mutableLong.doubleValue());

        // Test case 7: Test string representation of a decimal number
        mutableLong = new MutableLong("3.14");
        assertEquals(3.14, mutableLong.doubleValue());

        // Test case 8: Test string representation of a negative number
        mutableLong = new MutableLong("-10");
        assertEquals(-10.0, mutableLong.doubleValue());

        // Test case 9: Test string representation of a large number
        mutableLong = new MutableLong(Long.toString(Long.MAX_VALUE));
        assertEquals((double) Long.MAX_VALUE, mutableLong.doubleValue());

        // Test case 10: Test string representation of a decimal number with leading zeros
        mutableLong = new MutableLong("000015.75");
        assertEquals(15.75, mutableLong.doubleValue());
    }
}