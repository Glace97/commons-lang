import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class floatValueTest {

    @Test
    void testFloatValue() {
        // Test 1: Construct MutableShort with default value of zero
        MutableShort ms1 = new MutableShort();
        assertEquals(0.0f, ms1.floatValue());

        // Test 2: Construct MutableShort with positive value
        MutableShort ms2 = new MutableShort(10);
        assertEquals(10.0f, ms2.floatValue());

        // Test 3: Construct MutableShort with negative value
        MutableShort ms3 = new MutableShort(-5);
        assertEquals(-5.0f, ms3.floatValue());

        // Test 4: Construct MutableShort with float value
        MutableShort ms4 = new MutableShort(3.5f);
        assertEquals(3.5f, ms4.floatValue());

        // Test 5: Construct MutableShort with string value
        MutableShort ms5 = new MutableShort("25");
        assertEquals(25.0f, ms5.floatValue());

        // Test 6: Construct MutableShort with invalid string value
        assertThrows(NumberFormatException.class, () -> new MutableShort("abc"));
    }
}