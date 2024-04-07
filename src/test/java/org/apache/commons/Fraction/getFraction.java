
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getFractionTest {
    private Fraction fraction;

    @BeforeAll
    void setup() {
        fraction = new Fraction(0, 1);
    }

    @Test
    void testGetFractionWithDoubleValue() {
        double value = 3.14;
        Fraction result = Fraction.getFraction(value);
        assertEquals("157/50", result.toString());
    }

    @Test
    void testGetFractionWithMaxDoubleValue() {
        double value = Double.MAX_VALUE;
        assertThrows(ArithmeticException.class, () -> Fraction.getFraction(value));
    }

    @Test
    void testGetFractionWithNaN() {
        double value = Double.NaN;
        assertThrows(ArithmeticException.class, () -> Fraction.getFraction(value));
    }

    @Test
    void testGetFractionWithZeroDenominator() {
        assertThrows(ArithmeticException.class, () -> Fraction.getFraction(1, 0));
    }

    @Test
    void testGetFractionWithNegativeDenominatorAndMinValueNumerator() {
        int numerator = Integer.MIN_VALUE;
        int denominator = -1;
        assertThrows(ArithmeticException.class, () -> Fraction.getFraction(numerator, denominator));
    }

    @Test
    void testGetFractionWithWholeNumber() {
        int whole = 2;
        int numerator = 1;
        int denominator = 3;
        Fraction result = Fraction.getFraction(whole, numerator, denominator);
        assertEquals("7/3", result.toString());
    }

    @Test
    void testGetFractionWithWholeNumberAndNegativeDenominator() {
        int whole = -2;
        int numerator = 1;
        int denominator = 3;
        assertThrows(ArithmeticException.class, () -> Fraction.getFraction(whole, numerator, denominator));
    }

    @Test
    void testGetFractionWithWholeNumberAndNegativeNumerator() {
        int whole = 2;
        int numerator = -1;
        int denominator = 3;
        assertThrows(ArithmeticException.class, () -> Fraction.getFraction(whole, numerator, denominator));
    }

    @Test
    void testGetFractionWithLargeNumeratorValue() {
        int numerator = Integer.MAX_VALUE;
        int denominator = 1;
        assertThrows(ArithmeticException.class, () -> Fraction.getFraction(numerator, denominator));
    }

    @Test
    void testGetFractionWithStringFormatDouble() {
        String str = "3.14";
        Fraction result = Fraction.getFraction(str);
        assertEquals("157/50", result.toString());
    }

    @Test
    void testGetFractionWithStringFormatWholeNumber() {
        String str = "2";
        Fraction result = Fraction.getFraction(str);
        assertEquals("2/1", result.toString());
    }

    @Test
    void testGetFractionWithStringFormatX_Y_Z() {
        String str = "2 1/3";
        Fraction result = Fraction.getFraction(str);
        assertEquals("7/3", result.toString());
    }

    @Test
    void testGetFractionWithStringFormatY_Z() {
        String str = "1/2";
        Fraction result = Fraction.getFraction(str);
        assertEquals("1/2", result.toString());
    }

    @Test
    void testGetFractionWithStringFormatInvalid() {
        String str = "1/2/3";
        assertThrows(NumberFormatException.class, () -> Fraction.getFraction(str));
    }
}
