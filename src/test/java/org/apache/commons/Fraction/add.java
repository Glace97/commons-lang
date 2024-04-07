import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.math.BigInteger;

class addTest {

    Fraction fraction;

    @BeforeEach
    void setUp() {
        fraction = new Fraction(3, 7);
    }

    @Test
    void testAddPositiveFraction() {
        Fraction result = fraction.add(new Fraction(2, 5));
        assertEquals(new Fraction(29, 35), result);
    }

    @Test
    void testAddNegativeFraction() {
        Fraction result = fraction.add(new Fraction(-1, 4));
        assertEquals(new Fraction(5, 28), result);
    }

    @Test
    void testAddZeroFraction() {
        Fraction result = fraction.add(Fraction.ZERO);
        assertEquals(fraction, result);
    }

    @Test
    void testAddProperFraction() {
        Fraction result = fraction.add(new Fraction(1, 3));
        assertEquals(new Fraction(16, 21), result);
    }

    @Test
    void testAddImproperFraction() {
        Fraction result = fraction.add(new Fraction(4, 3));
        assertEquals(new Fraction(31, 21), result);
    }

    @Test
    void testAddMixedFraction() {
        Fraction result = fraction.add(new Fraction(1, 2));
        assertEquals(new Fraction(17, 14), result);
    }

    @Test
    void testAddMaxValueFraction() {
        Fraction result = fraction.add(new Fraction(Integer.MAX_VALUE, Integer.MAX_VALUE));
        assertEquals(new Fraction(BigInteger.valueOf(Integer.MAX_VALUE).multiply(BigInteger.valueOf(2)), BigInteger.valueOf(Integer.MAX_VALUE))), result);
    }

    @Test
    void testAddMinValueFraction() {
        Fraction result = fraction.add(new Fraction(Integer.MIN_VALUE, Integer.MIN_VALUE));
        assertEquals(new Fraction(BigInteger.valueOf(Integer.MIN_VALUE).multiply(BigInteger.valueOf(2)), BigInteger.valueOf(Integer.MIN_VALUE))), result);
    }
}