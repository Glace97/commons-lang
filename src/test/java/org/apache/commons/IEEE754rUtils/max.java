import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class maxTest {

    @Test
    void testMaxWithDoubleArray() {
        double[] array = {1.0, 2.0, 3.0};
        double expected = 3.0;
        double actual = IEEE754rUtils.max(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMaxWithEmptyDoubleArray() {
        double[] array = {};
        Assertions.assertThrows(IllegalArgumentException.class, () -> IEEE754rUtils.max(array));
    }

    @Test
    void testMaxWithNullDoubleArray() {
        double[] array = null;
        Assertions.assertThrows(NullPointerException.class, () -> IEEE754rUtils.max(array));
    }

    @Test
    void testMaxWithTwoDoubles() {
        double a = 2.0;
        double b = 3.0;
        double expected = 3.0;
        double actual = IEEE754rUtils.max(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMaxWithTwoNaN() {
        double a = Double.NaN;
        double b = Double.NaN;
        double expected = Double.NaN;
        double actual = IEEE754rUtils.max(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMaxWithThreeDoubles() {
        double a = 1.0;
        double b = 2.0;
        double c = 3.0;
        double expected = 3.0;
        double actual = IEEE754rUtils.max(a, b, c);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMaxWithFloatArray() {
        float[] array = {1.0f, 2.0f, 3.0f};
        float expected = 3.0f;
        float actual = IEEE754rUtils.max(array);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMaxWithEmptyFloatArray() {
        float[] array = {};
        Assertions.assertThrows(IllegalArgumentException.class, () -> IEEE754rUtils.max(array));
    }

    @Test
    void testMaxWithNullFloatArray() {
        float[] array = null;
        Assertions.assertThrows(NullPointerException.class, () -> IEEE754rUtils.max(array));
    }

    @Test
    void testMaxWithTwoFloats() {
        float a = 2.0f;
        float b = 3.0f;
        float expected = 3.0f;
        float actual = IEEE754rUtils.max(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMaxWithTwoNaNFloats() {
        float a = Float.NaN;
        float b = Float.NaN;
        float expected = Float.NaN;
        float actual = IEEE754rUtils.max(a, b);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMaxWithThreeFloats() {
        float a = 1.0f;
        float b = 2.0f;
        float c = 3.0f;
        float expected = 3.0f;
        float actual = IEEE754rUtils.max(a, b, c);
        Assertions.assertEquals(expected, actual);
    }
}