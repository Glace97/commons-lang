import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class absTest {

    @Test
    void testAbsPositiveNumerator() {
        Fraction fraction = new Fraction(3, 7);
        Fraction result = fraction.abs();
        Assertions.assertEquals(3, result.numerator);
        Assertions.assertEquals(7, result.denominator);
    }

    @Test
    void testAbsNegativeNumerator() {
        Fraction fraction = new Fraction(-3, 7);
        Fraction result = fraction.abs();
        Assertions.assertEquals(3, result.numerator);
        Assertions.assertEquals(7, result.denominator);
    }

    @Test
    void testAbsZeroNumerator() {
        Fraction fraction = new Fraction(0, 7);
        Fraction result = fraction.abs();
        Assertions.assertEquals(0, result.numerator);
        Assertions.assertEquals(7, result.denominator);
    }

    @Test
    void testAbsZeroDenominator() {
        Fraction fraction = new Fraction(3, 0);
        Fraction result = fraction.abs();
        Assertions.assertEquals(3, result.numerator);
        Assertions.assertEquals(0, result.denominator);
    }

    @Test
    void testAbsZeroFraction() {
        Fraction fraction = new Fraction(0, 0);
        Fraction result = fraction.abs();
        Assertions.assertEquals(0, result.numerator);
        Assertions.assertEquals(0, result.denominator);
    }
}