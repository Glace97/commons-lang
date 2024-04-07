import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class doubleValueTest {
    
    @Test
    void testDoubleValue() {
        MutableFloat mutableFloat = new MutableFloat(5.6f);
        double result = mutableFloat.doubleValue();
        assertEquals(5.6, result, 0.0001);
    }
    
    @Test
    void testDoubleValueWithZero() {
        MutableFloat mutableFloat = new MutableFloat(0);
        double result = mutableFloat.doubleValue();
        assertEquals(0, result, 0.0001);
    }
    
    @Test
    void testDoubleValueWithNegativeValue() {
        MutableFloat mutableFloat = new MutableFloat(-3.2f);
        double result = mutableFloat.doubleValue();
        assertEquals(-3.2, result, 0.0001);
    }
    
    @Test
    void testDoubleValueWithMaxValue() {
        MutableFloat mutableFloat = new MutableFloat(Float.MAX_VALUE);
        double result = mutableFloat.doubleValue();
        assertEquals(Float.MAX_VALUE, result, 0.0001);
    }
    
    @Test
    void testDoubleValueWithMinValue() {
        MutableFloat mutableFloat = new MutableFloat(Float.MIN_VALUE);
        double result = mutableFloat.doubleValue();
        assertEquals(Float.MIN_VALUE, result, 0.0001);
    }
    
    @Test
    void testDoubleValueWithNaN() {
        MutableFloat mutableFloat = new MutableFloat(Float.NaN);
        double result = mutableFloat.doubleValue();
        assertEquals(Double.NaN, result, 0.0001);
    }
    
    @Test
    void testDoubleValueWithPositiveInfinity() {
        MutableFloat mutableFloat = new MutableFloat(Float.POSITIVE_INFINITY);
        double result = mutableFloat.doubleValue();
        assertEquals(Double.POSITIVE_INFINITY, result, 0.0001);
    }
    
    @Test
    void testDoubleValueWithNegativeInfinity() {
        MutableFloat mutableFloat = new MutableFloat(Float.NEGATIVE_INFINITY);
        double result = mutableFloat.doubleValue();
        assertEquals(Double.NEGATIVE_INFINITY, result, 0.0001);
    }
    
    @Test
    void testDoubleValueWithZeroAsString() {
        MutableFloat mutableFloat = new MutableFloat("0");
        double result = mutableFloat.doubleValue();
        assertEquals(0, result, 0.0001);
    }
    
    @Test
    void testDoubleValueWithPositiveValueAsString() {
        MutableFloat mutableFloat = new MutableFloat("3.14");
        double result = mutableFloat.doubleValue();
        assertEquals(3.14, result, 0.0001);
    }
    
    @Test
    void testDoubleValueWithNegativeValueAsString() {
        MutableFloat mutableFloat = new MutableFloat("-2.7");
        double result = mutableFloat.doubleValue();
        assertEquals(-2.7, result, 0.0001);
    }
    
    @Test
    void testDoubleValueWithInvalidString() {
        assertThrows(NumberFormatException.class, () -> {
            MutableFloat mutableFloat = new MutableFloat("abc");
            double result = mutableFloat.doubleValue();
        });
    }
    
}