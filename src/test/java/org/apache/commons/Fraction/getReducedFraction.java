
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;

class getReducedFractionTest {

    private Fraction fraction;

    @BeforeEach
    void setUp() {
        fraction = new Fraction(0, 1);
    }

    @Test
    void testZeroDenominator() {
        assertThrows(ArithmeticException.class, () -> Fraction.getReducedFraction(2, 0));
    }

    @Test
    void testZeroNumerator() {
        assertEquals(Fraction.ZERO, Fraction.getReducedFraction(0, 3));
    }

    @Test
    void testPositiveFraction() {
        Fraction result = Fraction.getReducedFraction(6, 9);
        assertEquals(new Fraction(2, 3), result);
    }

    @Test
    void testNegativeFraction() {
        Fraction result = Fraction.getReducedFraction(-6, 9);
        assertEquals(new Fraction(-2, 3), result);
    }

    @Test
    void testNegativeDenominator() {
        Fraction result = Fraction.getReducedFraction(6, -9);
        assertEquals(new Fraction(-2, 3), result);
    }

    @Test
    void testNegativeNumeratorAndDenominator() {
        Fraction result = Fraction.getReducedFraction(-6, -9);
        assertEquals(new Fraction(2, 3), result);
    }

    @Test
    void testFractionWithGCDGreaterThan1() {
        Fraction result = Fraction.getReducedFraction(8, 12);
        assertEquals(new Fraction(2, 3), result);
    }

    @Test
    void testFractionWithGCDEquals1() {
        Fraction result = Fraction.getReducedFraction(5, 7);
        assertEquals(new Fraction(5, 7), result);
    }

    @Test
    void testFractionWithLargeNumbers() {
        Fraction result = Fraction.getReducedFraction(Integer.MAX_VALUE, Integer.MAX_VALUE - 1);
        assertEquals(new Fraction(1, Integer.MAX_VALUE - 1), result);
    }

    @Test
    void testFractionWithIntegerMinValue() {
        Fraction result = Fraction.getReducedFraction(Integer.MIN_VALUE, Integer.MIN_VALUE);
        assertEquals(new Fraction(1, 1), result);
    }

}
