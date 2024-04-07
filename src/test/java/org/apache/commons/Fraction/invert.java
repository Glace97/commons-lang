import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class invertTest {

    @Test
    void testInvertNonZeroFraction() {
        Fraction fraction = new Fraction(3, 7);
        Fraction result = fraction.invert();
        assertEquals(7, result.getNumerator());
        assertEquals(3, result.getDenominator());
    }

    @Test
    void testInvertZeroFraction() {
        Fraction fraction = new Fraction(0, 1);
        assertThrows(ArithmeticException.class, () -> {
            fraction.invert();
        });
    }

    @Test
    void testInvertNegativeFraction() {
        Fraction fraction = new Fraction(-2, 5);
        Fraction result = fraction.invert();
        assertEquals(-5, result.getNumerator());
        assertEquals(-2, result.getDenominator());
    }

    @Test
    void testInvertNegativeNumeratorOverflow() {
        Fraction fraction = new Fraction(Integer.MIN_VALUE, 1);
        assertThrows(ArithmeticException.class, () -> {
            fraction.invert();
        });
    }
}