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


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class IEEE754rUtilsTest {


    @Test
    @DisplayName("Test for empty array")
    void testMaxEmptyArray1() {
        assertThrows(IllegalArgumentException.class, () -> IEEE754rUtils.max(new double[]{}));
    }

    @Test
    @DisplayName("Test for array with one element")
    void testMaxSingleElementArray1() {
        double result = IEEE754rUtils.max(new double[]{5.0});
        assertEquals(5.0, result);
    }

    @Test
    @DisplayName("Test for array with multiple elements")
    void testMaxMultipleElementsArray1() {
        double result = IEEE754rUtils.max(new double[]{3.5, 7.2, 1.8, 4.6});
        assertEquals(7.2, result);
    }

    @Test
    @DisplayName("Test for array with NaN values")
    void testMaxArrayWithNaN1() {
        double result = IEEE754rUtils.max(new double[]{1.0, Double.NaN, 3.5, Double.NaN});
        assertEquals(3.5, result);
    }


    @Test
    @DisplayName("Test for a = b")
    void testMaxEqualValues1() {
        double result = IEEE754rUtils.max(5.0, 5.0);
        assertEquals(5.0, result);
    }

    @Test
    @DisplayName("Test for a > b")
    void testMaxAGreaterThanB1() {
        double result = IEEE754rUtils.max(7.2, 3.5);
        assertEquals(7.2, result);
    }

    @Test
    @DisplayName("Test for a < b")
    void testMaxALessThanB1() {
        double result = IEEE754rUtils.max(1.8, 4.6);
        assertEquals(4.6, result);
    }

    @Test
    @DisplayName("Test for a = NaN")
    void testMaxANaN1() {
        double result = IEEE754rUtils.max(Double.NaN, 3.5);
        assertEquals(3.5, result);
    }

    @Test
    @DisplayName("Test for b = NaN")
    void testMaxBNaN1() {
        double result = IEEE754rUtils.max(1.8, Double.NaN);
        assertEquals(1.8, result);
    }

    @Test
    @DisplayName("Test for a = NaN and b = NaN")
    void testMaxANaNBNaN1() {
        double result = IEEE754rUtils.max(Double.NaN, Double.NaN);
        assertTrue(Double.isNaN(result));
    }

    @Test
    @DisplayName("Test for a = b = c")
    void testMaxEqualValues3() {
        double result = IEEE754rUtils.max(5.0, 5.0, 5.0);
        assertEquals(5.0, result);
    }

    @Test
    @DisplayName("Test for a > b > c")
    void testMaxAGreaterThanBAndBGreaterThanC1() {
        double result = IEEE754rUtils.max(7.2, 4.6, 1.8);
        assertEquals(7.2, result);
    }

    @Test
    @DisplayName("Test for a < b < c")
    void testMaxALessThanBAndBLessThan1() {
        double result = IEEE754rUtils.max(1.8, 4.6, 7.2);
        assertEquals(7.2, result);
    }

    @Test
    @DisplayName("Test for a = NaN")
    void testMaxANaN3() {
        double result = IEEE754rUtils.max(Double.NaN, 3.5, 1.8);
        assertEquals(3.5, result);
    }

    @Test
    @DisplayName("Test for b = NaN")
    void testMaxBNaN3() {
        double result = IEEE754rUtils.max(1.8, Double.NaN, 3.5);
        assertEquals(3.5, result);
    }

    @Test
    @DisplayName("Test for c = NaN")
    void testMaxCNaN1() {
        double result = IEEE754rUtils.max(1.8, 3.5, Double.NaN);
        assertEquals(3.5, result);
    }

    @Test
    @DisplayName("Test for a = NaN, b = NaN, and c = NaN")
    void testMaxANaBNaNCNaN1() {
        double result = IEEE754rUtils.max(Double.NaN, Double.NaN, Double.NaN);
        assertTrue(Double.isNaN(result));
    }


    @Test
    @DisplayName("Test for empty array")
    void testMaxEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> IEEE754rUtils.max(new float[]{}));
    }

    @Test
    @DisplayName("Test for array with one element")
    void testMaxSingleElementArray() {
        float result = IEEE754rUtils.max(new float[]{5.0f});
        assertEquals(5.0f, result);
    }

    @Test
    @DisplayName("Test for array with multiple elements")
    void testMaxMultipleElementsArray() {
        float result = IEEE754rUtils.max(new float[]{3.5f, 7.2f, 1.8f, 4.6f});
        assertEquals(7.2f, result);
    }

    @Test
    @DisplayName("Test for array with NaN values")
    void testMaxArrayWithNaN() {
        float result = IEEE754rUtils.max(new float[]{1.0f, Float.NaN, 3.5f, Float.NaN});
        assertEquals(3.5f, result);
    }


    @Test
    @DisplayName("Test for a = b")
    void testMaxEqualValues2() {
        float result = IEEE754rUtils.max(5.0f, 5.0f);
        assertEquals(5.0f, result);
    }

    @Test
    @DisplayName("Test for a > b")
    void testMaxAGreaterThanB() {
        float result = IEEE754rUtils.max(7.2f, 3.5f);
        assertEquals(7.2f, result);
    }

    @Test
    @DisplayName("Test for a < b")
    void testMaxALessThanB() {
        float result = IEEE754rUtils.max(1.8f, 4.6f);
        assertEquals(4.6f, result);
    }

    @Test
    @DisplayName("Test for a = NaN")
    void testMaxANaN2() {
        float result = IEEE754rUtils.max(Float.NaN, 3.5f);
        assertEquals(3.5f, result);
    }

    @Test
    @DisplayName("Test for b = NaN")
    void testMaxBNaN2() {
        float result = IEEE754rUtils.max(1.8f, Float.NaN);
        assertEquals(1.8f, result);
    }

    @Test
    @DisplayName("Test for a = NaN and b = NaN")
    void testMaxANaNBNaN() {
        float result = IEEE754rUtils.max(Float.NaN, Float.NaN);
        assertTrue(Float.isNaN(result));
    }


    @Test
    @DisplayName("Test for a = b = c")
    void testMaxEqualValues() {
        float result = IEEE754rUtils.max(5.0f, 5.0f, 5.0f);
        assertEquals(5.0f, result);
    }

    @Test
    @DisplayName("Test for a > b > c")
    void testMaxAGreaterThanBAndBGreaterThanC() {
        float result = IEEE754rUtils.max(7.2f, 4.6f, 1.8f);
        assertEquals(7.2f, result);
    }

    @Test
    @DisplayName("Test for a < b < c")
    void testMaxALessThanBAndBLessThanC() {
        float result = IEEE754rUtils.max(1.8f, 4.6f, 7.2f);
        assertEquals(7.2f, result);
    }

    @Test
    @DisplayName("Test for a = NaN")
    void testMaxANaN() {
        float result = IEEE754rUtils.max(Float.NaN, 3.5f, 1.8f);
        assertEquals(3.5f, result);
    }

    @Test
    @DisplayName("Test for b = NaN")
    void testMaxBNaN() {
        float result = IEEE754rUtils.max(1.8f, Float.NaN, 3.5f);
        assertEquals(3.5f, result);
    }

    @Test
    @DisplayName("Test for c = NaN")
    void testMaxCNaN() {
        float result = IEEE754rUtils.max(1.8f, 3.5f, Float.NaN);
        assertEquals(3.5f, result);
    }

    @Test
    @DisplayName("Test for a = NaN, b = NaN, and c = NaN")
    void testMaxANaBNaNCNaN() {
        float result = IEEE754rUtils.max(Float.NaN, Float.NaN, Float.NaN);
        assertTrue(Float.isNaN(result));
    }
    // Your Java code here

    @Test
    void testMinWithArray() {
        double[] array = {3.5, 2.0, 4.2, 1.7, 5.9};
        double expectedMin = 1.7;
        double actualMin = IEEE754rUtils.min(array);
        assertEquals(expectedMin, actualMin);
    }

    @Test
    void testMinWithArrayEmpty() {
        double[] emptyArray = {};
        assertThrows(IllegalArgumentException.class, () -> IEEE754rUtils.min(emptyArray));
    }

//    @Test
//    void testMinWithArrayNull() {
//        assertThrows(NullPointerException.class, () -> IEEE754rUtils.min(null));
//    }

    @Test
    void testMinWithTwoValues() {
        double a = 3.5;
        double b = 2.0;
        double expectedMin = 2.0;
        double actualMin = IEEE754rUtils.min(a, b);
        assertEquals(expectedMin, actualMin);
    }

    @Test
    void testMinWithTwoValuesNaN() {
        double a = Double.NaN;
        double b = 2.0;
        double expectedMin = 2.0;
        double actualMin = IEEE754rUtils.min(a, b);
        assertEquals(expectedMin, actualMin);
    }

    @Test
    void testMinWithThreeValues() {
        double a = 3.5;
        double b = 2.0;
        double c = 4.2;
        double expectedMin = 2.0;
        double actualMin = IEEE754rUtils.min(a, b, c);
        assertEquals(expectedMin, actualMin);
    }

    @Test
    void testMinWithThreeValuesNaN() {
        double a = Double.NaN;
        double b = 2.0;
        double c = 4.2;
        double expectedMin = 2.0;
        double actualMin = IEEE754rUtils.min(a, b, c);
        assertEquals(expectedMin, actualMin);
    }

    @Test
    void testMinWithFloatArray() {
        float[] array = {3.5f, 2.0f, 4.2f, 1.7f, 5.9f};
        float expectedMin = 1.7f;
        float actualMin = IEEE754rUtils.min(array);
        assertEquals(expectedMin, actualMin);
    }

    @Test
    void testMinWithFloatArrayEmpty() {
        float[] emptyArray = {};
        assertThrows(IllegalArgumentException.class, () -> IEEE754rUtils.min(emptyArray));
    }

//    @Test
//    void testMinWithFloatArrayNull() {
//        assertThrows(NullPointerException.class, () -> IEEE754rUtils.min(null));
//    }

    @Test
    void testMinWithTwoFloatValues() {
        float a = 3.5f;
        float b = 2.0f;
        float expectedMin = 2.0f;
        float actualMin = IEEE754rUtils.min(a, b);
        assertEquals(expectedMin, actualMin);
    }

    @Test
    void testMinWithTwoFloatValuesNaN() {
        float a = Float.NaN;
        float b = 2.0f;
        float expectedMin = 2.0f;
        float actualMin = IEEE754rUtils.min(a, b);
        assertEquals(expectedMin, actualMin);
    }

    @Test
    void testMinWithThreeFloatValues() {
        float a = 3.5f;
        float b = 2.0f;
        float c = 4.2f;
        float expectedMin = 2.0f;
        float actualMin = IEEE754rUtils.min(a, b, c);
        assertEquals(expectedMin, actualMin);
    }

    @Test
    void testMinWithThreeFloatValuesNaN() {
        float a = Float.NaN;
        float b = 2.0f;
        float c = 4.2f;
        float expectedMin = 2.0f;
        float actualMin = IEEE754rUtils.min(a, b, c);
        assertEquals(expectedMin, actualMin);
    }
}
