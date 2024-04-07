
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CompareToTest {

    @Test
    void testCompareTo() {
        MutableBoolean falseValue = new MutableBoolean(false);
        MutableBoolean trueValue = new MutableBoolean(true);
        MutableBoolean sameValue = new MutableBoolean(false);

        // Test when comparing to a false value
        assertTrue(falseValue.compareTo(falseValue) == 0);
        assertTrue(falseValue.compareTo(trueValue) < 0);

        // Test when comparing to a true value
        assertTrue(trueValue.compareTo(falseValue) > 0);
        assertTrue(trueValue.compareTo(trueValue) == 0);

        // Test when comparing to the same value
        assertTrue(falseValue.compareTo(sameValue) == 0);
        assertTrue(trueValue.compareTo(sameValue) > 0);
    }
}
