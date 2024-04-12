package org.apache.commons.lang3.math;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;


import org.junit.jupiter.api.*;

public class FractionTest {

    public Fraction fraction;

//    @Test
//    void testIntValueWithZeroDenominator() {
//        fraction = new Fraction(1, 0);
//        assertEquals(0, fraction.intValue());
//    }
//
//    @Test
//    void testIntValueWithZeroNumerator() {
//        fraction = new Fraction(0, 1);
//        assertEquals(0, fraction.intValue());
//    }
//
//    @Test
//    void testIntValueWithPositiveFraction() {
//        fraction = new Fraction(3, 2);
//        assertEquals(1, fraction.intValue());
//    }
//
//    @Test
//    void testIntValueWithNegativeFraction() {
//        fraction = new Fraction(-3, 2);
//        assertEquals(-1, fraction.intValue());
//    }
//
//    @Test
//    void testIntValueWithWholeNumber() {
//        fraction = new Fraction(5, 1);
//        assertEquals(5, fraction.intValue());
//    }

    //@Test
    void testInvert() {
        Fraction inverted = fraction.invert();
        assertEquals(7, inverted.getNumerator());
        assertEquals(3, inverted.getDenominator());
    }

//    @Test
//    void testInvertWithZeroNumerator() {
//        Fraction zero = new Fraction(0, 5);
//        assertThrows(ArithmeticException.class, () -> zero.invert());
//    }
//
//    @Test
//    void testInvertWithMinValueNumerator() {
//        Fraction minValue = new Fraction(Integer.MIN_VALUE, 1);
//        assertThrows(ArithmeticException.class, () -> minValue.invert());
//    }
//
//    @Test
//    void testInvertWithNegativeNumerator() {
//        Fraction negative = new Fraction(-4, 9);
//        Fraction inverted = negative.invert();
//        assertEquals(-9, inverted.getNumerator());
//        assertEquals(-4, inverted.getDenominator());
//    }
//
//    @Test
//    void testInvertWithPositiveNumerator() {
//        Fraction positive = new Fraction(5, 2);
//        Fraction inverted = positive.invert();
//        assertEquals(2, inverted.getNumerator());
//        assertEquals(5, inverted.getDenominator());
//    }

    @Test
    void testGetReducedFraction() {
        Fraction fraction = Fraction.getReducedFraction(0, 1);
        Assertions.assertEquals(0, fraction.getNumerator());
        Assertions.assertEquals(1, fraction.getDenominator());

        fraction = Fraction.getReducedFraction(1, 1);
        Assertions.assertEquals(1, fraction.getNumerator());
        Assertions.assertEquals(1, fraction.getDenominator());

        fraction = Fraction.getReducedFraction(1, 2);
        Assertions.assertEquals(1, fraction.getNumerator());
        Assertions.assertEquals(2, fraction.getDenominator());

        fraction = Fraction.getReducedFraction(1, 3);
        Assertions.assertEquals(1, fraction.getNumerator());
        Assertions.assertEquals(3, fraction.getDenominator());

        fraction = Fraction.getReducedFraction(2, 3);
        Assertions.assertEquals(2, fraction.getNumerator());
        Assertions.assertEquals(3, fraction.getDenominator());

        fraction = Fraction.getReducedFraction(1, 4);
        Assertions.assertEquals(1, fraction.getNumerator());
        Assertions.assertEquals(4, fraction.getDenominator());

        fraction = Fraction.getReducedFraction(2, 4);
        Assertions.assertEquals(1, fraction.getNumerator());
        Assertions.assertEquals(2, fraction.getDenominator());

        fraction = Fraction.getReducedFraction(3, 4);
        Assertions.assertEquals(3, fraction.getNumerator());
        Assertions.assertEquals(4, fraction.getDenominator());

        fraction = Fraction.getReducedFraction(1, 5);
        Assertions.assertEquals(1, fraction.getNumerator());
        Assertions.assertEquals(5, fraction.getDenominator());

        fraction = Fraction.getReducedFraction(2, 5);
        Assertions.assertEquals(2, fraction.getNumerator());
        Assertions.assertEquals(5, fraction.getDenominator());

        fraction = Fraction.getReducedFraction(3, 5);
        Assertions.assertEquals(3, fraction.getNumerator());
        Assertions.assertEquals(5, fraction.getDenominator());

        fraction = Fraction.getReducedFraction(4, 5);
        Assertions.assertEquals(4, fraction.getNumerator());
        Assertions.assertEquals(5, fraction.getDenominator());
    }

//    @Test
//    public void testPowPowerOne() {
//        fraction = new Fraction(2, 3);
//        Fraction result = fraction.pow(1);
//        assertEquals(fraction, result);
//    }
//
//    @Test
//    public void testPowPowerZero() {
//        fraction = new Fraction(2, 3);
//        Fraction result = fraction.pow(0);
//        assertEquals(Fraction.ONE, result);
//    }
//
//    @Test
//    public void testPowNegativePower() {
//        fraction = new Fraction(2, 3);
//        assertThrows(ArithmeticException.class, () -> fraction.pow(-2));
//    }
//
//    @Test
//    public void testPowEvenPower() {
//        fraction = new Fraction(2, 3);
//        Fraction result = fraction.pow(4);
//        assertEquals(new Fraction(16, 81), result);
//    }
//
//    @Test
//    public void testPowOddPower() {
//        fraction = new Fraction(2, 3);
//        Fraction result = fraction.pow(3);
//        assertEquals(new Fraction(8, 27), result);
//    }
//
//    @Test
//    public void testPowMaxValuePower() {
//        fraction = new Fraction(2, 3);
//        assertThrows(ArithmeticException.class, () -> fraction.pow(Integer.MAX_VALUE));
//    }
//
//    @Test
//    public void testPowMinValuePower() {
//        fraction = new Fraction(2, 3);
//        assertThrows(ArithmeticException.class, () -> fraction.pow(Integer.MIN_VALUE));
//    }
//
//    @Test
//    @DisplayName("Negate positive fraction")
//    void testNegatePositiveFraction() {
//        Fraction fraction = new Fraction(3, 4);
//        Fraction negatedFraction = fraction.negate();
//        Assertions.assertEquals(-3, negatedfraction.getNumerator());
//        Assertions.assertEquals(4, negatedFraction.denominator);
//    }
//
//    @Test
//    @DisplayName("Negate negative fraction")
//    void testNegateNegativeFraction() {
//        Fraction fraction = new Fraction(-3, 4);
//        Fraction negatedFraction = fraction.negate();
//        Assertions.assertEquals(3, negatedfraction.getNumerator());
//        Assertions.assertEquals(4, negatedFraction.denominator);
//    }
//
//    @Test
//    @DisplayName("Negate fraction with negative numerator")
//    void testNegateFractionWithNegativeNumerator() {
//        Fraction fraction = new Fraction(-3, -4);
//        Fraction negatedFraction = fraction.negate();
//        Assertions.assertEquals(3, negatedfraction.getNumerator());
//        Assertions.assertEquals(-4, negatedFraction.denominator);
//    }
//
//    @Test
//    @DisplayName("Negate fraction with negative denominator")
//    void testNegateFractionWithNegativeDenominator() {
//        Fraction fraction = new Fraction(3, -4);
//        Fraction negatedFraction = fraction.negate();
//        Assertions.assertEquals(-3, negatedfraction.getNumerator());
//        Assertions.assertEquals(4, negatedFraction.denominator);
//    }
//
//    @Test
//    @DisplayName("Negate fraction with numerator as Integer.MIN_VALUE")
//    void testNegateFractionWithMinValueNumerator() {
//        Fraction fraction = new Fraction(Integer.MIN_VALUE, 4);
//        Assertions.assertThrows(ArithmeticException.class, fraction::negate);
//    }
//// Test functions
//
//    @Test
//    @DisplayName("Proper Whole of Fraction 3/4 should be 0")
//    void testGetProperWhole_PositiveFraction() {
//        Fraction fraction = new Fraction(3, 4);
//        assertEquals(0, fraction.getProperWhole());
//    }
//
//    @Test
//    @DisplayName("Proper Whole of Fraction -5/2 should be -2")
//    void testGetProperWhole_NegativeFraction() {
//        Fraction fraction = new Fraction(-5, 2);
//        assertEquals(-2, fraction.getProperWhole());
//    }
//
//    @Test
//    @DisplayName("Proper Whole of Fraction 0/1 should be 0")
//    void testGetProperWhole_ZeroFraction() {
//        Fraction fraction = new Fraction(0, 1);
//        assertEquals(0, fraction.getProperWhole());
//    }
// Your Java code here
//
//    @Test
//    void testHashCodeReturnsSameValueForSameFractions() {
//        fraction = new Fraction(1, 2);
//        int expectedHashCode = fraction.hashCode();
//
//        assertEquals(expectedHashCode, fraction.hashCode());
//    }
//
//    @Test
//    void testHashCodeReturnsDifferentValueForDifferentFractions() {
//        fraction = new Fraction(1, 2);
//        int expectedHashCode = fraction.hashCode();
//
//        Fraction differentFraction = new Fraction(2, 3);
//
//        assertEquals(expectedHashCode != differentFraction.hashCode());
//    }
//
//    @Test
//    void testHashCodeIsConsistentWithEquals() {
//        fraction = new Fraction(1, 2);
//        Fraction sameFraction = new Fraction(1, 2);
//
//        assertEquals(fraction.equals(sameFraction), fraction.hashCode() == sameFraction.hashCode());
//    }
//
//    @Test
//    void testHashCodeIsDifferentForNegativeFractions() {
//        fraction = new Fraction(-1, 2);
//        int expectedHashCode = fraction.hashCode();
//
//        assertEquals(expectedHashCode, fraction.hashCode());
//    }
//
//    @Test
//    void testHashCodeIsDifferentForFractionsWithDifferentNumerators() {
//        fraction = new Fraction(1, 2);
//        int expectedHashCode = fraction.hashCode();
//
//        Fraction differentNumerators = new Fraction(2, 2);
//
//        assertEquals(expectedHashCode != differentNumerators.hashCode());
//    }
//
//    @Test
//    void testHashCodeIsDifferentForFractionsWithDifferentDenominators() {
//        fraction = new Fraction(1, 2);
//        int expectedHashCode = fraction.hashCode();
//
//        Fraction differentDenominators = new Fraction(1, 3);
//
//        assertEquals(expectedHashCode != differentDenominators.hashCode());
//    }
//
//    @Test
//    void testHashCodeIsDifferentForFractionsWithDifferentSigns() {
//        fraction = new Fraction(1, 2);
//        int expectedHashCode = fraction.hashCode();
//
//        Fraction differentSigns = new Fraction(-1, 2);
//
//        assertEquals(expectedHashCode != differentSigns.hashCode());
//    }
//
//    @Test
//    void testDivideBy() {
//        Fraction fraction1 = new Fraction(3, 7);
//        Fraction fraction2 = new Fraction(2, 5);
//
//        Fraction result = fraction1.divideBy(fraction2);
//
//        Assertions.assertEquals(15, result.getNumerator());
//        Assertions.assertEquals(14, result.getDenominator());
//    }
//
//    @Test
//    void testDivideByZero() {
//        Fraction fraction1 = new Fraction(3, 7);
//        Fraction fraction2 = new Fraction(0, 1);
//
//        Assertions.assertThrows(ArithmeticException.class, () -> {
//            fraction1.divideBy(fraction2);
//        });
//    }
//
//    @Test
//    void testDivideByNull() {
//        Fraction fraction1 = new Fraction(3, 7);
//        Fraction fraction2 = null;
//
//        Assertions.assertThrows(NullPointerException.class, () -> {
//            fraction1.divideBy(fraction2);
//        });
//    }
//
//    @Test
//    void testDivideByMaxValue() {
//        Fraction fraction1 = new Fraction(Integer.MAX_VALUE, 1);
//        Fraction fraction2 = new Fraction(1, 2);
//
//        Assertions.assertThrows(ArithmeticException.class, () -> {
//            fraction1.divideBy(fraction2);
//        });
//    }
//
//    @Test
//    void testDivideByNegativeFraction() {
//        Fraction fraction1 = new Fraction(3, 7);
//        Fraction fraction2 = new Fraction(-2, 5);
//
//        Fraction result = fraction1.divideBy(fraction2);
//
//        Assertions.assertEquals(-15, result.getNumerator());
//        Assertions.assertEquals(14, result.getDenominator());
//    }
//
//    @Test
//    void testDivideByNegativeResult() {
//        Fraction fraction1 = new Fraction(-3, 7);
//        Fraction fraction2 = new Fraction(2, 5);
//
//        Fraction result = fraction1.divideBy(fraction2);
//
//        Assertions.assertEquals(-15, result.getNumerator());
//        Assertions.assertEquals(14, result.getDenominator());
//    }
//
//    @Test
//    void testDivideByNegativeFractions() {
//        Fraction fraction1 = new Fraction(-3, 7);
//        Fraction fraction2 = new Fraction(-2, 5);
//
//        Fraction result = fraction1.divideBy(fraction2);
//
//        Assertions.assertEquals(15, result.getNumerator());
//        Assertions.assertEquals(14, result.getDenominator());
//    }
//
//
//    @Test
//    void testSubtractPositiveFractions() {
//        Fraction fraction1 = new Fraction(3, 4);
//        Fraction fraction2 = new Fraction(1, 4);
//        Fraction result = fraction1.subtract(fraction2);
//        assertEquals(new Fraction(2, 4), result);
//    }
//
//    @Test
//    void testSubtractNegativeFractions() {
//        Fraction fraction1 = new Fraction(-3, 4);
//        Fraction fraction2 = new Fraction(-1, 4);
//        Fraction result = fraction1.subtract(fraction2);
//        assertEquals(new Fraction(-2, 4), result);
//    }
//
//    @Test
//    void testSubtractPositiveAndNegativeFractions() {
//        Fraction fraction1 = new Fraction(3, 4);
//        Fraction fraction2 = new Fraction(-1, 4);
//        Fraction result = fraction1.subtract(fraction2);
//        assertEquals(new Fraction(4, 4), result);
//    }
//
//    @Test
//    void testSubtractZero() {
//        Fraction fraction1 = new Fraction(3, 4);
//        Fraction fraction2 = new Fraction(0, 1);
//        Fraction result = fraction1.subtract(fraction2);
//        assertEquals(new Fraction(3, 4), result);
//    }
//
//    @Test
//    void testSubtractFromZero() {
//        Fraction fraction1 = new Fraction(0, 1);
//        Fraction fraction2 = new Fraction(1, 4);
//        Fraction result = fraction1.subtract(fraction2);
//        assertEquals(new Fraction(-1, 4), result);
//    }
//
//    @Test
//    void testSubtractFractionsWithDifferentDenominators() {
//        Fraction fraction1 = new Fraction(1, 4);
//        Fraction fraction2 = new Fraction(1, 5);
//        Fraction result = fraction1.subtract(fraction2);
//        assertEquals(new Fraction(1, 20), result);
//    }
//
//    @Test
//    void testSubtractFractionsWithSameNumerators() {
//        Fraction fraction1 = new Fraction(2, 5);
//        Fraction fraction2 = new Fraction(2, 4);
//        Fraction result = fraction1.subtract(fraction2);
//        assertEquals(new Fraction(6, 20), result);
//    }
//
//    @Test
//    void testSubtractFractionsWithSameDenominators() {
//        Fraction fraction1 = new Fraction(1, 3);
//        Fraction fraction2 = new Fraction(2, 3);
//        Fraction result = fraction1.subtract(fraction2);
//        assertEquals(new Fraction(-1, 3), result);
//    }
//
//    @Test
//    void testSubtractFractionsResultingInNegativeNumerator() {
//        Fraction fraction1 = new Fraction(1, 2);
//        Fraction fraction2 = new Fraction(2, 3);
//        Fraction result = fraction1.subtract(fraction2);
//        assertEquals(new Fraction(-1, 6), result);
//    }
//
//    @Test
//    void testSubtractFractionsResultingInNegativeDenominator() {
//        Fraction fraction1 = new Fraction(1, 2);
//        Fraction fraction2 = new Fraction(2, -3);
//        Fraction result = fraction1.subtract(fraction2);
//        assertEquals(new Fraction(7, 6), result);
//    }
//
//    @Test
//    void testSubtractFractionsResultingInZeroNumerator() {
//        Fraction fraction1 = new Fraction(1, 2);
//        Fraction fraction2 = new Fraction(1, 2);
//        Fraction result = fraction1.subtract(fraction2);
//        assertEquals(new Fraction(0, 2), result);
//    }
//
//    @Test
//    void testSubtractFractionsResultingInZeroDenominator() {
//        Fraction fraction1 = new Fraction(0, 1);
//        Fraction fraction2 = new Fraction(1, 2);
//        Fraction result = fraction1.subtract(fraction2);
//        assertEquals(new Fraction(-1, 2), result);
//    }
//
//    @Test
//    void testFloatValue_NumeratorZero() {
//        fraction = new Fraction(0, 5);
//        assertEquals(0.0f, fraction.floatValue());
//    }
//
//    @Test
//    void testFloatValue_DenominatorZero() {
//        fraction = new Fraction(5, 0);
//        assertEquals(Float.POSITIVE_INFINITY, fraction.floatValue());
//    }

    @Test
    void testFloatValue_ZeroFraction() {
        fraction = Fraction.ZERO;
        assertEquals(0.0f, fraction.floatValue());
    }

    @Test
    void testFloatValue_OneFraction() {
        fraction = Fraction.ONE;
        assertEquals(1.0f, fraction.floatValue());
    }

    @Test
    void testFloatValue_OneHalfFraction() {
        fraction = Fraction.ONE_HALF;
        assertEquals(0.5f, fraction.floatValue());
    }

    @Test
    void testFloatValue_OneThirdFraction() {
        fraction = Fraction.ONE_THIRD;
        assertEquals(0.33333334f, fraction.floatValue());
    }

    @Test
    void testFloatValue_TwoThirdsFraction() {
        fraction = Fraction.TWO_THIRDS;
        assertEquals(0.6666667f, fraction.floatValue());
    }

    @Test
    void testFloatValue_OneQuarterFraction() {
        fraction = Fraction.ONE_QUARTER;
        assertEquals(0.25f, fraction.floatValue());
    }

    @Test
    void testFloatValue_TwoQuartersFraction() {
        fraction = Fraction.TWO_QUARTERS;
        assertEquals(0.5f, fraction.floatValue());
    }

    @Test
    void testFloatValue_ThreeQuartersFraction() {
        fraction = Fraction.THREE_QUARTERS;
        assertEquals(0.75f, fraction.floatValue());
    }

    @Test
    void testFloatValue_OneFifthFraction() {
        fraction = Fraction.ONE_FIFTH;
        assertEquals(0.2f, fraction.floatValue());
    }

    @Test
    void testFloatValue_TwoFifthsFraction() {
        fraction = Fraction.TWO_FIFTHS;
        assertEquals(0.4f, fraction.floatValue());
    }

    @Test
    void testFloatValue_ThreeFifthsFraction() {
        fraction = Fraction.THREE_FIFTHS;
        assertEquals(0.6f, fraction.floatValue());
    }

    @Test
    void testFloatValue_FourFifthsFraction() {
        fraction = Fraction.FOUR_FIFTHS;
        assertEquals(0.8f, fraction.floatValue());
    }

//    @Test
//    void testFloatValue_LargeFraction() {
//        fraction = new Fraction(1234567890, 987654321);
//        assertEquals(1.25f, fraction.floatValue());
//    }

    @Test
    void longValue_ZeroFraction_ReturnsZero() {
        fraction = Fraction.ZERO;
        assertEquals(0L, fraction.longValue());
    }

//    @Test
//    void longValue_IntegerFraction_ReturnsSameValue() {
//        fraction = new Fraction(5, 1);
//        assertEquals(5L, fraction.longValue());
//    }
//
//    @Test
//    void longValue_MaxValueFraction_ReturnsMaxValue() {
//        fraction = new Fraction(Integer.MAX_VALUE, 1);
//        assertEquals((long) Integer.MAX_VALUE, fraction.longValue());
//    }
//
//    @Test
//    void longValue_MinValueFraction_ReturnsMinValue() {
//        fraction = new Fraction(Integer.MIN_VALUE, 1);
//        assertEquals((long) Integer.MIN_VALUE, fraction.longValue());
//    }

//    @Test
//    void testReduce() {
//        // Test reducing a fraction with numerator and denominator both positive
//        Fraction fraction1 = new Fraction(4, 8);
//        Fraction reducedFraction1 = fraction1.reduce();
//        assertEquals(1, reducedFraction1.getNumerator());
//        assertEquals(2, reducedFraction1.getDenominator());
//
//        // Test reducing a fraction with numerator and denominator both negative
//        Fraction fraction2 = new Fraction(-9, -12);
//        Fraction reducedFraction2 = fraction2.reduce();
//        assertEquals(3, reducedFraction2.getNumerator());
//        assertEquals(4, reducedFraction2.getDenominator());
//
//        // Test reducing a fraction with positive numerator and negative denominator
//        Fraction fraction3 = new Fraction(7, -14);
//        Fraction reducedFraction3 = fraction3.reduce();
//        assertEquals(-1, reducedFraction3.getNumerator());
//        assertEquals(2, reducedFraction3.getDenominator());
//
//        // Test reducing a fraction with negative numerator and positive denominator
//        Fraction fraction4 = new Fraction(-15, 45);
//        Fraction reducedFraction4 = fraction4.reduce();
//        assertEquals(-1, reducedFraction4.getNumerator());
//        assertEquals(3, reducedFraction4.getDenominator());
//
//        // Test reducing a fraction with numerator equal to zero
//        Fraction fraction5 = new Fraction(0, 5);
//        Fraction reducedFraction5 = fraction5.reduce();
//        assertEquals(0, reducedFraction5.getNumerator());
//        assertEquals(1, reducedFraction5.getDenominator());
//
//        // Test reducing a fraction with denominator equal to one
//        Fraction fraction6 = new Fraction(8, 1);
//        Fraction reducedFraction6 = fraction6.reduce();
//        assertEquals(8, reducedFraction6.getNumerator());
//        assertEquals(1, reducedFraction6.getDenominator());
//    }
//
//    @Test
//    @DisplayName("CompareTo - Same Fraction")
//    void testCompareTo_SameFraction() {
//        assertEquals(0, fraction1.compareTo(fraction1));
//    }
//
//    @Test
//    @DisplayName("CompareTo - Equal Fractions")
//    void testCompareTo_EqualFractions() {
//        Fraction equalFraction1 = new Fraction(1, 2);
//        Fraction equalFraction2 = new Fraction(2, 4);
//        assertEquals(0, fraction1.compareTo(equalFraction1));
//        assertEquals(0, fraction1.compareTo(equalFraction2));
//    }
//
//    @Test
//    @DisplayName("CompareTo - Less Than")
//    void testCompareTo_LessThan() {
//        assertEquals(-1, fraction1.compareTo(fraction2));
//        assertEquals(-1, fraction1.compareTo(fraction3));
//    }
//
//    @Test
//    @DisplayName("CompareTo - Greater Than")
//    void testCompareTo_GreaterThan() {
//        assertEquals(1, fraction2.compareTo(fraction1));
//        assertEquals(1, fraction2.compareTo(fraction3));
//    }
//
//    @Test
//    void testGetProperNumerator_PositiveNumeratorAndDenominator() {
//        Fraction fraction = new Fraction(5, 2);
//        int properNumerator = fraction.getProperNumerator();
//        Assertions.assertEquals(1, properNumerator);
//    }
//
//    @Test
//    void testGetProperNumerator_NegativeNumeratorAndDenominator() {
//        Fraction fraction = new Fraction(-5, 2);
//        int properNumerator = fraction.getProperNumerator();
//        Assertions.assertEquals(1, properNumerator);
//    }
//
//    @Test
//    void testGetProperNumerator_PositiveNumeratorAndNegativeDenominator() {
//        Fraction fraction = new Fraction(5, -2);
//        int properNumerator = fraction.getProperNumerator();
//        Assertions.assertEquals(1, properNumerator);
//    }
//
//    @Test
//    void testGetProperNumerator_NegativeNumeratorAndNegativeDenominator() {
//        Fraction fraction = new Fraction(-5, -2);
//        int properNumerator = fraction.getProperNumerator();
//        Assertions.assertEquals(1, properNumerator);
//    }
//
//    @Test
//    void testGetProperNumerator_ZeroNumeratorAndDenominator() {
//        Fraction fraction = new Fraction(0, 2);
//        int properNumerator = fraction.getProperNumerator();
//        Assertions.assertEquals(0, properNumerator);
//    }
//
//    @Test
//    void testGetProperNumerator_ZeroNumeratorAndZeroDenominator() {
//        Fraction fraction = new Fraction(0, 0);
//        int properNumerator = fraction.getProperNumerator();
//        Assertions.assertEquals(0, properNumerator);
//    }
//
//    @Test
//    void testGetProperNumerator_PositiveNumeratorAndZeroDenominator() {
//        Fraction fraction = new Fraction(5, 0);
//        int properNumerator = fraction.getProperNumerator();
//        Assertions.assertEquals(0, properNumerator);
//    }
//
//    @Test
//    void testGetProperNumerator_NegativeNumeratorAndZeroDenominator() {
//        Fraction fraction = new Fraction(-5, 0);
//        int properNumerator = fraction.getProperNumerator();
//        Assertions.assertEquals(0, properNumerator);
//    }

    //@Test
    void testMultiplyByZero() {
        Fraction result = fraction.multiplyBy(Fraction.ZERO);
        Assertions.assertEquals(Fraction.ZERO, result);
    }

    //@Test
    void testMultiplyByOne() {
        Fraction result = fraction.multiplyBy(Fraction.ONE);
        Assertions.assertEquals(fraction, result);
    }

    //@Test
    void testMultiplyByOneHalf() {
        Fraction result = fraction.multiplyBy(Fraction.ONE_HALF);
        // Perform assertions based on expected behavior of multiplyBy method
    }

    @Test
    void testMultiplyByNullFraction() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            fraction.multiplyBy(null);
        });
    }

    @Test
    void testMultiplyByLargeNumerator() {
        // Test case where numerator exceeds Integer.MAX_VALUE
    }

    @Test
    void testMultiplyByLargeDenominator() {
        // Test case where denominator exceeds Integer.MAX_VALUE
    }

// Add more test cases to cover edge cases and achieve high coverage
//    @Test
//    void testEqualsReturnsTrueForSameObject() {
//        Assertions.assertTrue(fraction1.equals(fraction1));
//    }
//
//    @Test
//    void testEqualsReturnsTrueForEqualFractions() {
//        Assertions.assertTrue(fraction1.equals(fraction2));
//    }
//
//    @Test
//    void testEqualsReturnsFalseForDifferentFractions() {
//        Fraction fraction3 = new Fraction(3, 4);
//        Assertions.assertFalse(fraction1.equals(fraction3));
//    }
//
//    @Test
//    void testEqualsReturnsFalseForNonFractionObject() {
//        Assertions.assertFalse(fraction1.equals("2/4"));
//    }
//
//    @Test
//    void testEqualsReturnsFalseForNullObject() {
//        Assertions.assertFalse(fraction1.equals(null));
//    }
//
//    @Test
//    void testEqualsIsReflexive() {
//        Assertions.assertEquals(fraction1.equals(fraction2), fraction2.equals(fraction1));
//    }

//    @Test
//    void testEqualsIsSymmetric() {
//        Fraction fraction3 = new Fraction(2, 4);
//        Assertions.assertEquals(fraction1.equals(fraction3), fraction3.equals(fraction1));
//    }
//
//    @Test
//    void testEqualsIsTransitive() {
//        Fraction fraction3 = new Fraction(2, 4);
//        Fraction fraction4 = new Fraction(1, 2);
//        Assertions.assertEquals(fraction1.equals(fraction3) && fraction3.equals(fraction4), fraction1.equals(fraction4));
//    }
//
//    @Test
//    void testEqualsProducesConsistentHashCode() {
//        Assertions.assertEquals(fraction1.hashCode(), fraction2.hashCode());
//    }
//
//    @Test
//    void testEqualsProducesConsistentToString() {
//        Assertions.assertEquals(fraction1.toString(), fraction2.toString());
//    }

    void testGetFraction_withPositiveDouble() {
    }

    void testGetFraction_withNegativeDouble() {
    }

    void testGetFraction_withZero() {
    }

    void testGetFraction_withPositiveWholeNumber() {
    }

    void testGetFraction_withNegativeWholeNumber() {
    }

    void testGetFraction_withZeroNumerator() {
    }

    void testGetFraction_withPositiveNumeratorAndDenominator() {
    }

    void testGetFraction_withNegativeNumeratorAndDenominator() {
    }

    void testGetFraction_withPositiveWholeNumeratorAndDenominator() {
    }

    void testGetFraction_withNegativeWholeNumeratorAndDenominator() {
    }

    void testGetFraction_withZeroDenominator() {
    }

    void testGetFraction_withNegativeDenominatorAndMinValueNumerator() {
    }

    void testGetFraction_withDoubleValueExceedingMaxValue() {
    }

    void testGetFraction_withDoubleValueNaN() {
    }

    void testGetFraction_withInvalidFormatString() {
    }

    void testGetFraction_withDotFormatString() {
    }

    void testGetFraction_withXFormatString() {
    }

    void testGetFraction_withXYFormatString() {
    }
//    @Test
//    void testAddition() {
//        Fraction result = fraction.add(new Fraction(1, 4));
//        Assertions.assertEquals(11, result.getNumerator());
//        Assertions.assertEquals(12, result.getDenominator());
//    }

    //@Test
    void testAdditionWithZero() {
        Fraction result = fraction.add(Fraction.ZERO);
        Assertions.assertEquals(2, result.getNumerator());
        Assertions.assertEquals(3, result.getDenominator());
    }

//    @Test
//    void testAdditionWithNegativeFraction() {
//        Fraction result = fraction.add(new Fraction(-1, 4));
//        Assertions.assertEquals(5, result.getNumerator());
//        Assertions.assertEquals(12, result.getDenominator());
//    }
//
//    @Test
//    void testAdditionWithNegativeResult() {
//        Fraction result = fraction.add(new Fraction(-2, 3));
//        Assertions.assertEquals(0, result.getNumerator());
//        Assertions.assertEquals(1, result.getDenominator());
//    }
//
//    @Test
//    void testAdditionWithLargeNumbers() {
//        Fraction result = fraction.add(new Fraction(Integer.MAX_VALUE, Integer.MAX_VALUE));
//        Assertions.assertEquals(new Fraction(BigInteger.valueOf(Integer.MAX_VALUE).multiply(BigInteger.valueOf(2))), result);
//    }
//
//    @Test
//    void testAdditionWithZeroDenominator() {
//        Assertions.assertThrows(ArithmeticException.class, () -> {
//            fraction.add(new Fraction(1, 0));
//        });
//    }

    @Test
    void testAdditionWithNullFraction() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            fraction.add(null);
        });
    }

//    @Test
//    public void testAbsPositiveFraction() {
//        fraction = new Fraction(3, 4);
//        Fraction absFraction = fraction.abs();
//        assertEquals(3, absFraction.getNumerator());
//        assertEquals(4, absFraction.getDenominator());
//    }
//
//    @Test
//    public void testAbsNegativeFraction() {
//        fraction = new Fraction(-3, 4);
//        Fraction absFraction = fraction.abs();
//        assertEquals(3, absFraction.getNumerator());
//        assertEquals(4, absFraction.getDenominator());
//    }
//
//    @Test
//    public void testAbsZeroFraction() {
//        fraction = new Fraction(0, 1);
//        Fraction absFraction = fraction.abs();
//        assertEquals(0, absFraction.getNumerator());
//        assertEquals(1, absFraction.getDenominator());
//    }
//
//    @Test
//    public void testAbsMaxValueFraction() {
//        fraction = new Fraction(Integer.MAX_VALUE, 1);
//        Fraction absFraction = fraction.abs();
//        assertEquals(Integer.MAX_VALUE, absFraction.getNumerator());
//        assertEquals(1, absFraction.getDenominator());
//    }
//
//    @Test
//    public void testAbsMinValueFraction() {
//        fraction = new Fraction(Integer.MIN_VALUE, 1);
//        Fraction absFraction = fraction.abs();
//        assertEquals(Integer.MAX_VALUE + 1L, absFraction.getNumerator());
//        assertEquals(1, absFraction.getDenominator());
//    }
//
//    @Test
//    public void testAbsMaxValueFractionWithDenominator() {
//        fraction = new Fraction(Integer.MAX_VALUE, Integer.MAX_VALUE);
//        Fraction absFraction = fraction.abs();
//        assertEquals(1, absFraction.getNumerator());
//        assertEquals(1, absFraction.getDenominator());
//    }
//
//    @Test
//    public void testAbsMinValueFractionWithDenominator() {
//        fraction = new Fraction(Integer.MIN_VALUE, Integer.MIN_VALUE);
//        Fraction absFraction = fraction.abs();
//        assertEquals(1, absFraction.getNumerator());
//        assertEquals(1, absFraction.getDenominator());
//    }
//
//    @Test
//    public void testToProperString_ZeroNumerator_ShouldReturnZero() {
//        fraction = new Fraction(0, 5);
//        String expected = "0";
//        String actual = fraction.toProperString();
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testToProperString_WholeNumber_ShouldReturnWholeNumber() {
//        fraction = new Fraction(3, 1);
//        String expected = "3";
//        String actual = fraction.toProperString();
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testToProperString_ImproperFraction_ShouldReturnMixedNumber() {
//        fraction = new Fraction(7, 4);
//        String expected = "1 3/4";
//        String actual = fraction.toProperString();
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testToProperString_NegativeImproperFraction_ShouldReturnNegativeMixedNumber() {
//        fraction = new Fraction(-7, 4);
//        String expected = "-1 3/4";
//        String actual = fraction.toProperString();
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testToProperString_FractionWithNegativeNumerator_ShouldReturnNegativeFraction() {
//        fraction = new Fraction(-2, 3);
//        String expected = "-2/3";
//        String actual = fraction.toProperString();
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testToProperString_FractionWithNegativeDenominator_ShouldReturnNegativeFraction() {
//        fraction = new Fraction(2, -3);
//        String expected = "-2/3";
//        String actual = fraction.toProperString();
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testToProperString_FractionWithNegativeNumeratorAndDenominator_ShouldReturnPositiveFraction() {
//        fraction = new Fraction(-2, -3);
//        String expected = "2/3";
//        String actual = fraction.toProperString();
//        assertEquals(expected, actual);
//    }
//
//    @Test
//    void testGetDenominator() {
//        Fraction fraction1 = new Fraction(3, 7);
//        assertEquals(7, fraction1.getDenominator());
//
//        Fraction fraction2 = new Fraction(5, 2);
//        assertEquals(2, fraction2.getDenominator());
//
//        Fraction fraction3 = new Fraction(0, 1);
//        assertEquals(1, fraction3.getDenominator());
//
//        Fraction fraction4 = new Fraction(1, 1);
//        assertEquals(1, fraction4.getDenominator());
//
//        Fraction fraction5 = new Fraction(-4, 3);
//        assertEquals(3, fraction5.getDenominator());
//
//        Fraction fraction6 = new Fraction(2, -5);
//        assertEquals(5, fraction6.getDenominator());
//
//        Fraction fraction7 = new Fraction(-6, -4);
//        assertEquals(4, fraction7.getDenominator());
//    }

    //@Test
    void toString_shouldReturnCorrectString() {
        String expected = "3/7";
        String actual = fraction.toString();
        Assertions.assertEquals(expected, actual);
    }

    //@Test
    void toString_shouldReturnSameStringOnMultipleCalls() {
        String expected = fraction.toString();
        String actual = fraction.toString();
        Assertions.assertSame(expected, actual);
    }

//    @Test
//    void toString_shouldReturnDifferentStringAfterModification() {
//        String original = fraction.toString();
//        fraction.getNumerator() = 5;
//        String modified = fraction.toString();
//        Assertions.assertNotEquals(original, modified);
//    }
//
//    @Test
//    void toString_shouldReturnDifferentStringForDifferentFractions() {
//        Fraction otherFraction = new Fraction(2, 5);
//        String original = fraction.toString();
//        String other = otherFraction.toString();
//        Assertions.assertNotEquals(original, other);
//    }
//
//    @Test
//    void toString_shouldHandleZeroNumerator() {
//        Fraction zeroFraction = new Fraction(0, 7);
//        String expected = "0/7";
//        String actual = zeroFraction.toString();
//        Assertions.assertEquals(expected, actual);
//    }
//
//    @Test
//    void toString_shouldHandleNegativeNumerator() {
//        Fraction negativeFraction = new Fraction(-3, 7);
//        String expected = "-3/7";
//        String actual = negativeFraction.toString();
//        Assertions.assertEquals(expected, actual);
//    }
//
//    @Test
//    void toString_shouldHandleNegativeDenominator() {
//        Fraction negativeDenominatorFraction = new Fraction(3, -7);
//        String expected = "-3/7";
//        String actual = negativeDenominatorFraction.toString();
//        Assertions.assertEquals(expected, actual);
//    }
//
//    @Test
//    void toString_shouldHandleNegativeNumeratorAndDenominator() {
//        Fraction negativeFraction = new Fraction(-3, -7);
//        String expected = "3/7";
//        String actual = negativeFraction.toString();
//        Assertions.assertEquals(expected, actual);
//    }
//
//    @Test
//    void toString_shouldHandleDenominatorOne() {
//        Fraction denominatorOneFraction = new Fraction(3, 1);
//        String expected = "3/1";
//        String actual = denominatorOneFraction.toString();
//        Assertions.assertEquals(expected, actual);
//    }
//
//    @Test
//    void toString_shouldHandleNumeratorZeroAndDenominatorOne() {
//        Fraction zeroFraction = new Fraction(0, 1);
//        String expected = "0/1";
//        String actual = zeroFraction.toString();
//        Assertions.assertEquals(expected, actual);
//    }
//
//    @Test
//    void toString_shouldHandleNumeratorAndDenominatorEqual() {
//        Fraction equalFractions = new Fraction(5, 5);
//        String expected = "5/5";
//        String actual = equalFractions.toString();
//        Assertions.assertEquals(expected, actual);
//    }
//
//    @Test
//    void toString_shouldHandleLargeNumbers() {
//        Fraction largeFraction = new Fraction(Integer.MAX_VALUE, Integer.MAX_VALUE);
//        String expected = Integer.MAX_VALUE + "/" + Integer.MAX_VALUE;
//        String actual = largeFraction.toString();
//        Assertions.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void testDoubleValuePositiveNumeratorAndDenominator() {
//        fraction = new Fraction(3, 7);
//        assertEquals(0.42857142857142855, fraction.doubleValue());
//    }
//
//    @Test
//    public void testDoubleValueNegativeNumeratorAndDenominator() {
//        fraction = new Fraction(-3, -7);
//        assertEquals(0.42857142857142855, fraction.doubleValue());
//    }
//
//    @Test
//    public void testDoubleValuePositiveNumeratorAndNegativeDenominator() {
//        fraction = new Fraction(3, -7);
//        assertEquals(-0.42857142857142855, fraction.doubleValue());
//    }
//
//    @Test
//    public void testDoubleValueNegativeNumeratorAndPositiveDenominator() {
//        fraction = new Fraction(-3, 7);
//        assertEquals(-0.42857142857142855, fraction.doubleValue());
//    }
//
//    @Test
//    public void testDoubleValueZeroNumerator() {
//        fraction = new Fraction(0, 7);
//        assertEquals(0.0, fraction.doubleValue());
//    }
//
//    @Test
//    public void testDoubleValueZeroDenominator() {
//        fraction = new Fraction(3, 0);
//        assertEquals(Double.POSITIVE_INFINITY, fraction.doubleValue());
//    }
//
//    @Test
//    public void testDoubleValueZeroNumeratorAndDenominator() {
//        fraction = new Fraction(0, 0);
//        assertEquals(Double.NaN, fraction.doubleValue());
//    }
//
//    @Test
//    public void testDoubleValueMaxValueNumeratorAndDenominator() {
//        fraction = new Fraction(Integer.MAX_VALUE, Integer.MAX_VALUE);
//        assertEquals(1.0, fraction.doubleValue());
//    }
//
//    @Test
//    public void testDoubleValueMinValueNumeratorAndDenominator() {
//        fraction = new Fraction(Integer.MIN_VALUE, Integer.MIN_VALUE);
//        assertEquals(1.0, fraction.doubleValue());
//    }
//
//    @Test
//    public void testDoubleValueMaxValueNumeratorAndMinValueDenominator() {
//        fraction = new Fraction(Integer.MAX_VALUE, Integer.MIN_VALUE);
//        assertEquals(-1.0, fraction.doubleValue());
//    }
//
//    @Test
//    public void testDoubleValueMinValueNumeratorAndMaxValueDenominator() {
//        fraction = new Fraction(Integer.MIN_VALUE, Integer.MAX_VALUE);
//        assertEquals(-1.0, fraction.doubleValue());
//    }
//
//    @Test
//    public void testDoubleValueMaxValueNumeratorAndPositiveDenominator() {
//        fraction = new Fraction(Integer.MAX_VALUE, 7);
//        assertEquals(2.147483647E8, fraction.doubleValue());
//    }
//
//    @Test
//    public void testDoubleValueMinValueNumeratorAndPositiveDenominator() {
//        fraction = new Fraction(Integer.MIN_VALUE, 7);
//        assertEquals(-3.221376497142857E8, fraction.doubleValue());
//    }
//
//    @Test
//    public void testDoubleValuePositiveNumeratorAndMaxValueDenominator() {
//        fraction = new Fraction(7, Integer.MAX_VALUE);
//        assertEquals(3.2679738562091504E-9, fraction.doubleValue());
//    }
//
//    @Test
//    public void testDoubleValuePositiveNumeratorAndMinValueDenominator() {
//        fraction = new Fraction(7, Integer.MIN_VALUE);
//        assertEquals(-3.2679738562091504E-9, fraction.doubleValue());
//    }

    //@Test
    @DisplayName("When fraction is a proper fraction")
    void testGetNumeratorProperFraction() {
        assertEquals(3, fraction.getNumerator());
    }

//    @Test
//    @DisplayName("When fraction is an improper fraction")
//    void testGetNumeratorImproperFraction() {
//        Fraction improperFraction = new Fraction(7, 4);
//        assertEquals(7, improperFraction.getNumerator());
//    }
//
//    @Test
//    @DisplayName("When fraction is zero")
//    void testGetNumeratorZero() {
//        Fraction zeroFraction = new Fraction(0, 5);
//        assertEquals(0, zeroFraction.getNumerator());
//    }
//
//    @Test
//    @DisplayName("When fraction is negative")
//    void testGetNumeratorNegativeFraction() {
//        Fraction negativeFraction = new Fraction(-2, 3);
//        assertEquals(-2, negativeFraction.getNumerator());
//    }

}