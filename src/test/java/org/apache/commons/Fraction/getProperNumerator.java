import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getProperNumeratorTest {

    @Test
    void testPositiveProperFraction() {
        Fraction fraction = new Fraction(3, 7);
        assertEquals(3, fraction.getProperNumerator());
    }

    @Test
    void testNegativeProperFraction() {
        Fraction fraction = new Fraction(-3, 7);
        assertEquals(3, fraction.getProperNumerator());
    }

    @Test
    void testZeroNumerator() {
        Fraction fraction = new Fraction(0, 7);
        assertEquals(0, fraction.getProperNumerator());
    }

    @Test
    void testZeroDenominator() {
        Fraction fraction = new Fraction(3, 0);
        assertEquals(0, fraction.getProperNumerator());
    }

    @Test
    void testNegativeDenominator() {
        Fraction fraction = new Fraction(3, -7);
        assertEquals(3, fraction.getProperNumerator());
    }

    @Test
    void testNumeratorEqualsDenominator() {
        Fraction fraction = new Fraction(7, 7);
        assertEquals(0, fraction.getProperNumerator());
    }

    @Test
    void testNumeratorGreaterThanDenominator() {
        Fraction fraction = new Fraction(9, 7);
        assertEquals(2, fraction.getProperNumerator());
    }
}