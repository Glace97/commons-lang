import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class minTest {

    @Test
    void testMinWithDoubleArray() {
        double[] array = {1.5, 2.5, 0.5};
        double result = IEEE754rUtils.min(array);
        assertEquals(0.5, result);
    }

    @Test
    void testMinWithEmptyDoubleArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            double[] array = {};
            IEEE754rUtils.min(array);
        });
    }

    @Test
    void testMinWithNullDoubleArray() {
        assertThrows(NullPointerException.class, () -> {
            double[] array = null;
            IEEE754rUtils.min(array);
        });
    }

    @Test
    void testMinWithTwoDoubles() {
        double result = IEEE754rUtils.min(1.5, 2.5);
        assertEquals(1.5, result);
    }

    @Test
    void testMinWithTwoNaNs() {
        double result = IEEE754rUtils.min(Double.NaN, Double.NaN);
        assertTrue(Double.isNaN(result));
    }

    @Test
    void testMinWithFloatArray() {
        float[] array = {1.5f, 2.5f, 0.5f};
        float result = IEEE754rUtils.min(array);
        assertEquals(0.5f, result);
    }

    @Test
    void testMinWithEmptyFloatArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            float[] array = {};
            IEEE754rUtils.min(array);
        });
    }

    @Test
    void testMinWithNullFloatArray() {
        assertThrows(NullPointerException.class, () -> {
            float[] array = null;
            IEEE754rUtils.min(array);
        });
    }

    @Test
    void testMinWithTwoFloats() {
        float result = IEEE754rUtils.min(1.5f, 2.5f);
        assertEquals(1.5f, result);
    }

    @Test
    void testMinWithTwoNaNFloats() {
        float result = IEEE754rUtils.min(Float.NaN, Float.NaN);
        assertTrue(Float.isNaN(result));
    }

}