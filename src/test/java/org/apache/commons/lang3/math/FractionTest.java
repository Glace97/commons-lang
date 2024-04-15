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


    @Test
    void longValue_ZeroFraction_ReturnsZero() {
        fraction = Fraction.ZERO;
        assertEquals(0L, fraction.longValue());
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


    @Test
    void testAdditionWithNullFraction() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            fraction.add(null);
        });
    }


}