package org.apache.commons.lang3.compare;

import static java.lang.Float.NEGATIVE_INFINITY;
import static java.lang.Float.POSITIVE_INFINITY;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.function.Predicate;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class ComparableUtilsTest {
    // Your Java code here

    @Test
    void testGt() {
        Predicate<Integer> gtPredicate = ComparableUtils.gt(5);

        assertTrue(gtPredicate.test(10)); // Greater than
        assertFalse(gtPredicate.test(5)); // Equal
        assertFalse(gtPredicate.test(3)); // Less than
    }


    @Test
    @DisplayName("should return true if the tested object is less than or equal to the given object")
    void shouldBeLessThanOrEqualTo() {
        Predicate<Integer> le5 = ComparableUtils.le(5);
        assertTrue(le5.test(3));
        assertTrue(le5.test(5));
    }

    @Test
    @DisplayName("should return false if the tested object is greater than the given object")
    void shouldBeGreaterThan() {
        Predicate<Integer> le5 = ComparableUtils.le(5);
        assertFalse(le5.test(8));
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("Test between() method with valid inputs")
    void testBetweenValidInputs(int value) {
        ComparableUtils.ComparableCheckBuilder<Integer> builder = ComparableUtils.is(3);
        assertTrue(builder.between(1, 5));
    }


    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("Test betweenExclusive() method with valid inputs")
    void testBetweenExclusiveValidInputs(int value) {
        ComparableUtils.ComparableCheckBuilder<Integer> builder = ComparableUtils.is(3);
        assertTrue(builder.betweenExclusive(1, 5));
    }


    @Test
    @DisplayName("Test equalTo() method with equal input")
    void testEqualToEqualInput() {
        ComparableUtils.ComparableCheckBuilder<Integer> builder = ComparableUtils.is(3);
        assertTrue(builder.equalTo(3));
    }

    @Test
    @DisplayName("Test greaterThan() method with smaller input")
    void testGreaterThanSmallerInput() {
        ComparableUtils.ComparableCheckBuilder<Integer> builder = ComparableUtils.is(3);
        assertFalse(builder.greaterThan(5));
    }

    @Test
    @DisplayName("Test greaterThanOrEqualTo() method with greater input")
    void testGreaterThanOrEqualToGreaterInput() {
        ComparableUtils.ComparableCheckBuilder<Integer> builder = ComparableUtils.is(3);
        assertTrue(builder.greaterThanOrEqualTo(2));
    }

    @Test
    void testMax() {
        // Test with two non-null values
        Integer max1 = ComparableUtils.max(5, 10);
        assertEquals(10, max1);

        // Test with two null values
        Integer max2 = ComparableUtils.max(null, null);
        assertNull(max2);

        // Test with one null value
        Integer max3 = ComparableUtils.max(null, 5);
        assertEquals(5, max3);

        // Test with one null value
        Integer max4 = ComparableUtils.max(5, null);
        assertEquals(5, max4);
    }

    @Test
    void testMaxEqualValues() {
        // Test with two equal values
        Integer max1 = ComparableUtils.max(5, 5);
        assertEquals(5, max1);
    }

    @Test
    void testMaxWithNegativeValues() {
        // Test with two negative values
        Integer max1 = ComparableUtils.max(-5, -10);
        assertEquals(-5, max1);

        // Test with one negative value and one positive value
        Integer max2 = ComparableUtils.max(-5, 10);
        assertEquals(10, max2);

        // Test with one negative value and one null value
        Integer max3 = ComparableUtils.max(-5, null);
        assertEquals(-5, max3);

        // Test with one negative value and zero
        Integer max4 = ComparableUtils.max(-5, 0);
        assertEquals(0, max4);
    }

    @Test
    void testMaxWithStrings() {
        // Test with two strings
        String max1 = ComparableUtils.max("apple", "banana");
        assertEquals("banana", max1);

        // Test with one string and one null value
        String max2 = ComparableUtils.max("apple", null);
        assertEquals("apple", max2);

        // Test with two null strings
        String max3 = ComparableUtils.max(null, null);
        assertNull(max3);
    }

    @Test
    void betweenExclusive_shouldReturnTrue_whenBetweenExclusive() {
        // Test code here
    }

    @Test
    void betweenExclusive_shouldReturnFalse_whenNotBetweenExclusive() {
        // Test code here
    }

    @Test
    @DisplayName("Test ge() method with numeric input")
    void testGeWithNumericInput() {
        Predicate<Integer> predicate = ComparableUtils.ge(5);
        assertTrue(predicate.test(10));
        assertTrue(predicate.test(5));
        assertFalse(predicate.test(2));
    }

    @Test
    @DisplayName("Test ge() method with string input")
    void testGeWithStringInput() {
        Predicate<String> predicate = ComparableUtils.ge("b");
        assertTrue(predicate.test("c"));
        assertTrue(predicate.test("b"));
        assertFalse(predicate.test("a"));
    }

    @Test
    void testLtReturnsTrueWhenLessThan() {
        Predicate<Integer> predicate = ComparableUtils.lt(5);
        assertTrue(predicate.test(4));
    }

    @Test
    void testLtReturnsFalseWhenEqualTo() {
        Predicate<Integer> predicate = ComparableUtils.lt(5);
        assertFalse(predicate.test(5));
    }

    @Test
    void testLtReturnsFalseWhenGreaterThan() {
        Predicate<Integer> predicate = ComparableUtils.lt(5);
        assertFalse(predicate.test(6));
    }

    @Test
    void testLtReturnsTrueWhenLessThanForOtherComparableTypes() {
        Predicate<String> predicate = ComparableUtils.lt("foo");
        assertTrue(predicate.test("bar"));
    }

    @Test
    void testLtReturnsFalseWhenEqualToForOtherComparableTypes() {
        Predicate<String> predicate = ComparableUtils.lt("foo");
        assertFalse(predicate.test("foo"));
    }

    @Test
    void testLtReturnsFalseWhenGreaterThanForOtherComparableTypes() {
        Predicate<String> predicate = ComparableUtils.lt("foo");
        assertFalse(predicate.test("zoo"));
    }

    @Test
    @DisplayName("Returns the lesser of two non-null comparables")
    void testMinWithNonNullComparables() {
        Integer result = ComparableUtils.min(5, 10);
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Returns the non-null comparable when one is null")
    void testMinWithOneNullComparable() {
        Integer result = ComparableUtils.min(null, 10);
        assertEquals(10, result);

        result = ComparableUtils.min(5, null);
        assertEquals(5, result);
    }

    @Test
    @DisplayName("Returns null when both comparables are null")
    void testMinWithBothNullComparables() {
        Integer result = ComparableUtils.min(null, null);
        assertNull(result);
    }

}