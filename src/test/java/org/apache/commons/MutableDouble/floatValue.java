import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class floatValueTest {

    @Test
    void testFloatValue() {
        MutableDouble mutableDouble = new MutableDouble(5.6);

        float result = mutableDouble.floatValue();

        Assertions.assertEquals(5.6f, result);
    }

    @Test
    void testFloatValueWithNegativeValue() {
        MutableDouble mutableDouble = new MutableDouble(-3.8);

        float result = mutableDouble.floatValue();

        Assertions.assertEquals(-3.8f, result);
    }

    @Test
    void testFloatValueWithZero() {
        MutableDouble mutableDouble = new MutableDouble(0);

        float result = mutableDouble.floatValue();

        Assertions.assertEquals(0f, result);
    }

    @Test
    void testFloatValueWithMaxValue() {
        MutableDouble mutableDouble = new MutableDouble(Double.MAX_VALUE);

        float result = mutableDouble.floatValue();

        Assertions.assertEquals(Float.POSITIVE_INFINITY, result);
    }

    @Test
    void testFloatValueWithMinValue() {
        MutableDouble mutableDouble = new MutableDouble(Double.MIN_VALUE);

        float result = mutableDouble.floatValue();

        Assertions.assertEquals(0f, result);
    }

    @Test
    void testFloatValueWithString() {
        MutableDouble mutableDouble = new MutableDouble("3.14");

        float result = mutableDouble.floatValue();

        Assertions.assertEquals(3.14f, result);
    }

    @Test
    void testFloatValueWithInvalidString() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            MutableDouble mutableDouble = new MutableDouble("abc");
            mutableDouble.floatValue();
        });
    }
}