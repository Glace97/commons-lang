
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NegateTest {

    @Test
    void testNegatePositiveFraction() {
        Fraction fraction = new Fraction(3, 5);
        Fraction result = fraction.negate();
        assertEquals(-3, result.numerator);
        assertEquals(5, result.denominator);
    }

    @Test
    void testNegateNegativeFraction() {
        Fraction fraction = new Fraction(-2, 3);
        Fraction result = fraction.negate();
        assertEquals(2, result.numerator);
        assertEquals(3, result.denominator);
    }

    @Test
    void testNegateZeroFraction() {
        Fraction fraction = Fraction.ZERO;
        Fraction result = fraction.negate();
        assertEquals(0, result.numerator);
        assertEquals(1, result.denominator);
    }

    @Test
    void testNegateMinValueNumerator() {
        Fraction fraction = new Fraction(Integer.MIN_VALUE, 5);
        assertThrows(ArithmeticException.class, () -> fraction.negate());
    }

}
