package org.apache.commons.lang3.compare;

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

public class ComparableUtilsTest {
    // Your Java code here
    
    import org.junit.jupiter.api.Test;
    
    @Test
    void testGt() {
        Predicate<Integer> gtPredicate = ComparableUtils.gt(5);
    
        assertTrue(gtPredicate.test(10)); // Greater than
        assertFalse(gtPredicate.test(5)); // Equal
        assertFalse(gtPredicate.test(3)); // Less than
    }
    
    @Test
    void testGtEdgeCases() {
        Predicate<Integer> gtNegativeInfinityPredicate = ComparableUtils.gt(NEGATIVE_INFINITY);
        Predicate<Integer> gtPositiveInfinityPredicate = ComparableUtils.gt(POSITIVE_INFINITY);
    
        assertTrue(gtNegativeInfinityPredicate.test(NEGATIVE_INFINITY));
        assertFalse(gtNegativeInfinityPredicate.test(0));
    
        assertFalse(gtPositiveInfinityPredicate.test(POSITIVE_INFINITY));
        assertTrue(gtPositiveInfinityPredicate.test(0));
    }
    
    @Test
    void testGtWithNull() {
        Predicate<Integer> gtPredicate = ComparableUtils.gt(null);
    
        assertFalse(gtPredicate.test(10)); // ObjectUtils.compare(null, 10) returns -1
        assertFalse(gtPredicate.test(0)); // ObjectUtils.compare(null, 0) returns -1
        assertFalse(gtPredicate.test(null)); // ObjectUtils.compare(null, null) returns 0
    }
    @Test
    void testBetween() {
        assertTrue(comparableUtils.between(2, 1, 3));
        assertTrue(comparableUtils.between(2, 3, 1));
        assertFalse(comparableUtils.between(2, 1, 2));
        assertFalse(comparableUtils.between(2, 2, 3));
        assertFalse(comparableUtils.between(2, 3, 2));
    }
    
    @Test
    void testBetweenExclusive() {
        assertTrue(comparableUtils.betweenExclusive(2, 1, 3));
        assertTrue(comparableUtils.betweenExclusive(2, 3, 1));
        assertFalse(comparableUtils.betweenExclusive(2, 1, 2));
        assertFalse(comparableUtils.betweenExclusive(2, 2, 3));
        assertFalse(comparableUtils.betweenExclusive(2, 3, 2));
        assertFalse(comparableUtils.betweenExclusive(2, 2, 2));
    }
    
    @Test
    void testEqualTo() {
        assertTrue(comparableUtils.equalTo(2, 2));
        assertFalse(comparableUtils.equalTo(2, 1));
    }
    
    @Test
    void testGreaterThan() {
        assertTrue(comparableUtils.greaterThan(2, 1));
        assertFalse(comparableUtils.greaterThan(2, 2));
        assertFalse(comparableUtils.greaterThan(2, 3));
    }
    
    @Test
    void testGreaterThanOrEqualTo() {
        assertTrue(comparableUtils.greaterThanOrEqualTo(2, 1));
        assertTrue(comparableUtils.greaterThanOrEqualTo(2, 2));
        assertFalse(comparableUtils.greaterThanOrEqualTo(2, 3));
    }
    
    @Test
    void testLessThan() {
        assertTrue(comparableUtils.lessThan(2, 3));
        assertFalse(comparableUtils.lessThan(2, 2));
        assertFalse(comparableUtils.lessThan(2, 1));
    }
    
    @Test
    void testLessThanOrEqualTo() {
        assertTrue(comparableUtils.lessThanOrEqualTo(2, 3));
        assertTrue(comparableUtils.lessThanOrEqualTo(2, 2));
        assertFalse(comparableUtils.lessThanOrEqualTo(2, 1));
    }
    @Test
    void testGreaterThan() {
        assertTrue(comparableUtils.greaterThan(5));
        assertFalse(comparableUtils.greaterThan(10));
        assertFalse(comparableUtils.greaterThan(0));
        assertFalse(comparableUtils.greaterThan(-5));
    }
    
    @Test
    void testGreaterThanOrEqualTo() {
        assertTrue(comparableUtils.greaterThanOrEqualTo(5));
        assertTrue(comparableUtils.greaterThanOrEqualTo(10));
        assertFalse(comparableUtils.greaterThanOrEqualTo(0));
        assertFalse(comparableUtils.greaterThanOrEqualTo(-5));
    }
    
    @Test
    void testLessThan() {
        assertFalse(comparableUtils.lessThan(5));
        assertFalse(comparableUtils.lessThan(10));
        assertTrue(comparableUtils.lessThan(0));
        assertTrue(comparableUtils.lessThan(-5));
    }
    
    @Test
    void testLessThanOrEqualTo() {
        assertFalse(comparableUtils.lessThanOrEqualTo(5));
        assertFalse(comparableUtils.lessThanOrEqualTo(10));
        assertTrue(comparableUtils.lessThanOrEqualTo(0));
        assertTrue(comparableUtils.lessThanOrEqualTo(-5));
    }
    
    @Test
    void testEqualTo() {
        assertFalse(comparableUtils.equalTo(5));
        assertTrue(comparableUtils.equalTo(10));
        assertFalse(comparableUtils.equalTo(0));
        assertFalse(comparableUtils.equalTo(-5));
    }
    
    @Test
    void testBetween() {
        assertTrue(comparableUtils.between(5, 10));
        assertTrue(comparableUtils.between(5, 5));
        assertTrue(comparableUtils.between(10, 5));
        assertFalse(comparableUtils.between(0, 5));
        assertFalse(comparableUtils.between(10, 15));
        assertFalse(comparableUtils.between(15, 10));
    }
    
    @Test
    void testBetweenExclusive() {
        assertTrue(comparableUtils.betweenExclusive(5, 10));
        assertFalse(comparableUtils.betweenExclusive(5, 5));
        assertFalse(comparableUtils.betweenExclusive(10, 5));
        assertFalse(comparableUtils.betweenExclusive(0, 5));
        assertFalse(comparableUtils.betweenExclusive(10, 15));
        assertFalse(comparableUtils.betweenExclusive(15, 10));
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
    import static org.junit.jupiter.api.Assertions.*;
    
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Nested;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    import org.junit.jupiter.params.ParameterizedTest;
    import org.junit.jupiter.params.provider.ValueSource;
    
    import java.util.function.Predicate;
    
    @DisplayName("ComparableUtils Test Suite")
    class ComparableUtilsTest {
    
        @Nested
        @DisplayName("Between Method Tests")
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        class BetweenMethodTests {
            
            @ParameterizedTest
            @ValueSource(ints = {1, 2, 3, 4, 5})
            @DisplayName("Test between() method with valid inputs")
            void testBetweenValidInputs(int value) {
                ComparableCheckBuilder<Integer> builder = ComparableUtils.is(3);
                assertTrue(builder.between(1, 5));
            }
    
            @Test
            @DisplayName("Test between() method with invalid inputs")
            void testBetweenInvalidInputs() {
                ComparableCheckBuilder<Integer> builder = ComparableUtils.is(3);
                assertFalse(builder.between(5, 1));
            }
        }
    
        @Nested
        @DisplayName("BetweenExclusive Method Tests")
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        class BetweenExclusiveMethodTests {
    
            @ParameterizedTest
            @ValueSource(ints = {1, 2, 3, 4, 5})
            @DisplayName("Test betweenExclusive() method with valid inputs")
            void testBetweenExclusiveValidInputs(int value) {
                ComparableCheckBuilder<Integer> builder = ComparableUtils.is(3);
                assertTrue(builder.betweenExclusive(1, 5));
            }
    
            @Test
            @DisplayName("Test betweenExclusive() method with invalid inputs")
            void testBetweenExclusiveInvalidInputs() {
                ComparableCheckBuilder<Integer> builder = ComparableUtils.is(3);
                assertFalse(builder.betweenExclusive(5, 1));
            }
        }
    
        @Nested
        @DisplayName("EqualTo Method Tests")
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        class EqualToMethodTests {
    
            @Test
            @DisplayName("Test equalTo() method with equal input")
            void testEqualToEqualInput() {
                ComparableCheckBuilder<Integer> builder = ComparableUtils.is(3);
                assertTrue(builder.equalTo(3));
            }
    
            @Test
            @DisplayName("Test equalTo() method with not equal input")
            void testEqualToNotEqualInput() {
                ComparableCheckBuilder<Integer> builder = ComparableUtils.is(3);
                assertFalse(builder.equalTo(5));
            }
        }
    
        @Nested
        @DisplayName("GreaterThan Method Tests")
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        class GreaterThanMethodTests {
    
            @Test
            @DisplayName("Test greaterThan() method with greater input")
            void testGreaterThanGreaterInput() {
                ComparableCheckBuilder<Integer> builder = ComparableUtils.is(3);
                assertTrue(builder.greaterThan(2));
            }
    
            @Test
            @DisplayName("Test greaterThan() method with smaller input")
            void testGreaterThanSmallerInput() {
                ComparableCheckBuilder<Integer> builder = ComparableUtils.is(3);
                assertFalse(builder.greaterThan(5));
            }
        }
    
        @Nested
        @DisplayName("GreaterThanOrEqualTo Method Tests")
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        class GreaterThanOrEqualToMethodTests {
    
            @Test
            @DisplayName("Test greaterThanOrEqualTo() method with greater input")
            void testGreaterThanOrEqualToGreaterInput() {
                ComparableCheckBuilder<Integer> builder = ComparableUtils.is(3);
                assertTrue(builder.greaterThanOrEqualTo(2));
            }
    
            @Test
            @DisplayName("Test greaterThanOrEqualTo() method with equal input")
            void testGreaterThanOrEqualToEqualInput() {
                ComparableCheckBuilder<Integer> builder = ComparableUtils.is(3);
                assertTrue(builder.greaterThanOrEqualTo(3));
            }
    
            @Test
            @DisplayName("Test greaterThanOrEqualTo() method with smaller input")
            void testGreaterThanOrEqualToSmallerInput() {
                ComparableCheckBuilder<Integer> builder = ComparableUtils.is(3);
                assertFalse(builder.greaterThanOrEqualTo(5));
            }
        }
    
        @Nested
        @DisplayName("LessThan Method Tests")
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        class LessThanMethodTests {
    
            @Test
            @DisplayName("Test lessThan() method with smaller input")
            void testLessThanSmallerInput() {
                ComparableCheckBuilder<Integer> builder = ComparableUtils.is(3);
                assertTrue(builder.lessThan(5));
            }
    
            @Test
            @DisplayName("Test lessThan() method with greater input")
            void testLessThanGreaterInput() {
                ComparableCheckBuilder<Integer> builder = ComparableUtils.is(3);
                assertFalse(builder.lessThan(2));
            }
        }
    
        @Nested
        @DisplayName("LessThanOrEqualTo Method Tests")
        @TestInstance(TestInstance.Lifecycle.PER_CLASS)
        class LessThanOrEqualToMethodTests {
    
            @Test
            @DisplayName("Test lessThanOrEqualTo() method with smaller input")
            void testLessThanOrEqualToSmallerInput() {
                ComparableCheckBuilder<Integer> builder = ComparableUtils.is(3);
                assertTrue(builder.lessThanOrEqualTo(5));
            }
    
            @Test
            @DisplayName("Test lessThanOrEqualTo() method with equal input")
            void testLessThanOrEqualToEqualInput() {
                ComparableCheckBuilder<Integer> builder = ComparableUtils.is(3);
                assertTrue(builder.lessThanOrEqualTo(3));
            }
    
            @Test
            @DisplayName("Test lessThanOrEqualTo() method with greater input")
            void testLessThanOrEqualToGreaterInput() {
                ComparableCheckBuilder<Integer> builder = ComparableUtils.is(3);
                assertFalse(builder.lessThanOrEqualTo(2));
            }
        }
    }
    @Test
    void testMax() {
        // Test with two non-null values
        Integer max1 = ComparableUtils.max(5, 10);
        Assertions.assertEquals(10, max1);
    
        // Test with two null values
        Integer max2 = ComparableUtils.max(null, null);
        Assertions.assertNull(max2);
    
        // Test with one null value
        Integer max3 = ComparableUtils.max(null, 5);
        Assertions.assertEquals(5, max3);
    
        // Test with one null value
        Integer max4 = ComparableUtils.max(5, null);
        Assertions.assertEquals(5, max4);
    }
    
    @Test
    void testMaxEqualValues() {
        // Test with two equal values
        Integer max1 = ComparableUtils.max(5, 5);
        Assertions.assertEquals(5, max1);
    }
    
    @Test
    void testMaxWithNegativeValues() {
        // Test with two negative values
        Integer max1 = ComparableUtils.max(-5, -10);
        Assertions.assertEquals(-5, max1);
    
        // Test with one negative value and one positive value
        Integer max2 = ComparableUtils.max(-5, 10);
        Assertions.assertEquals(10, max2);
    
        // Test with one negative value and one null value
        Integer max3 = ComparableUtils.max(-5, null);
        Assertions.assertEquals(-5, max3);
    
        // Test with one negative value and zero
        Integer max4 = ComparableUtils.max(-5, 0);
        Assertions.assertEquals(0, max4);
    }
    
    @Test
    void testMaxWithStrings() {
        // Test with two strings
        String max1 = ComparableUtils.max("apple", "banana");
        Assertions.assertEquals("banana", max1);
    
        // Test with one string and one null value
        String max2 = ComparableUtils.max("apple", null);
        Assertions.assertEquals("apple", max2);
    
        // Test with two null strings
        String max3 = ComparableUtils.max(null, null);
        Assertions.assertNull(max3);
    }
    
    @Test
    void testMaxWithCustomObjects() {
        // Test with two custom objects
        MyObject obj1 = new MyObject(5);
        MyObject obj2 = new MyObject(10);
        MyObject max1 = ComparableUtils.max(obj1, obj2);
        Assertions.assertEquals(obj2, max1);
    
        // Test with one custom object and one null value
        MyObject obj3 = new MyObject(5);
        MyObject max2 = ComparableUtils.max(obj3, null);
        Assertions.assertEquals(obj3, max2);
    
        // Test with two null custom objects
        MyObject max3 = ComparableUtils.max(null, null);
        Assertions.assertNull(max3);
    }
    @Test
    void testBetweenOrdered() {
        assertTrue(comparableUtils.between(1, 2, 3));
        assertTrue(comparableUtils.between(3, 2, 1));
        assertTrue(comparableUtils.between(2, 2, 2));
        assertFalse(comparableUtils.between(1, 3, 2));
        assertFalse(comparableUtils.between(3, 1, 2));
    }
    
    @Test
    void testBetweenOrderedExclusive() {
        assertTrue(comparableUtils.betweenExclusive(1, 2, 3));
        assertTrue(comparableUtils.betweenExclusive(3, 2, 1));
        assertFalse(comparableUtils.betweenExclusive(2, 2, 2));
        assertFalse(comparableUtils.betweenExclusive(1, 3, 2));
        assertFalse(comparableUtils.betweenExclusive(3, 1, 2));
    }
    
    @Test
    void testEqualTo() {
        assertTrue(comparableUtils.equalTo(1, 1));
        assertFalse(comparableUtils.equalTo(1, 2));
    }
    
    @Test
    void testGreaterThan() {
        assertTrue(comparableUtils.greaterThan(2, 1));
        assertFalse(comparableUtils.greaterThan(1, 2));
        assertFalse(comparableUtils.greaterThan(1, 1));
    }
    
    @Test
    void testGreaterThanOrEqualTo() {
        assertTrue(comparableUtils.greaterThanOrEqualTo(2, 1));
        assertFalse(comparableUtils.greaterThanOrEqualTo(1, 2));
        assertTrue(comparableUtils.greaterThanOrEqualTo(1, 1));
    }
    
    @Test
    void testLessThan() {
        assertTrue(comparableUtils.lessThan(1, 2));
        assertFalse(comparableUtils.lessThan(2, 1));
        assertFalse(comparableUtils.lessThan(1, 1));
    }
    
    @Test
    void testLessThanOrEqualTo() {
        assertTrue(comparableUtils.lessThanOrEqualTo(1, 2));
        assertFalse(comparableUtils.lessThanOrEqualTo(2, 1));
        assertTrue(comparableUtils.lessThanOrEqualTo(1, 1));
    }
    import org.junit.jupiter.api.Test;
    
    class ComparableUtilsTest {
    
        @Test
        void betweenExclusive_shouldReturnTrue_whenBetweenExclusive() {
            // Test code here
        }
    
        @Test
        void betweenExclusive_shouldReturnFalse_whenNotBetweenExclusive() {
            // Test code here
        }
    }
    @Test
    @DisplayName("Test ge() method with null input")
    void testGeWithNullInput() {
        Predicate<Object> predicate = ComparableUtils.ge(null);
        assertFalse(predicate.test(null));
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
    @DisplayName("Test ge() method with custom object input")
    void testGeWithCustomObjectInput() {
        CustomObject obj1 = new CustomObject(5);
        CustomObject obj2 = new CustomObject(10);
        CustomObject obj3 = new CustomObject(2);
    
        Predicate<CustomObject> predicate = ComparableUtils.ge(obj2);
        assertTrue(predicate.test(obj1));
        assertTrue(predicate.test(obj2));
        assertFalse(predicate.test(obj3));
    }
    
    @ParameterizedTest
    @DisplayName("Test ge() method with edge cases")
    @ValueSource(doubles = { Double.MIN_VALUE, Double.MAX_VALUE, -1.0, 0.0, 1.0 })
    void testGeWithEdgeCases(double input) {
        Predicate<Double> predicate = ComparableUtils.ge(input);
        assertTrue(predicate.test(input));
        assertTrue(predicate.test(input + DELTA));
        assertFalse(predicate.test(input - DELTA));
    }
    @Test
    @DisplayName("Should return true when the value is less than")
    void shouldReturnTrueWhenValueIsLessThan() {
        assertTrue(builder.lessThan(20));
    }
    
    @Test
    @DisplayName("Should return false when the value is equal")
    void shouldReturnFalseWhenValueIsEqual() {
        assertFalse(builder.lessThan(10));
    }
    
    @Test
    @DisplayName("Should return false when the value is greater than")
    void shouldReturnFalseWhenValueIsGreaterThan() {
        assertFalse(builder.lessThan(5));
    }
    @Test
    @DisplayName("Should return true when the base object is less than the parameter")
    void testLessThan() {
        assertTrue(comparableUtils.lessThanOrEqualTo(2, 5));
    }
    
    @Test
    @DisplayName("Should return true when the base object is equal to the parameter")
    void testEqualTo() {
        assertTrue(comparableUtils.lessThanOrEqualTo(5, 5));
    }
    
    @Test
    @DisplayName("Should return false when the base object is greater than the parameter")
    void testGreaterThan() {
        assertFalse(comparableUtils.lessThanOrEqualTo(8, 5));
    }
    
    @Test
    @DisplayName("Should return true when the base object is null")
    void testNullBaseObject() {
        assertTrue(comparableUtils.lessThanOrEqualTo(null, 5));
    }
    
    @Test
    @DisplayName("Should return true when the parameter is null")
    void testNullParameter() {
        assertTrue(comparableUtils.lessThanOrEqualTo(5, null));
    }
    
    @Test
    @DisplayName("Should return true when both the base object and parameter are null")
    void testBothNull() {
        assertTrue(comparableUtils.lessThanOrEqualTo(null, null));
    }
    // Your Java code here
    
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
    void equalTo_ShouldReturnTrue_WhenObjectsAreEqual() {
        ComparableUtils comparableUtils = new ComparableUtils();
        assertTrue(comparableUtils.equalTo(5));
    }
    
    @Test
    void equalTo_ShouldReturnFalse_WhenObjectsAreNotEqual() {
        ComparableUtils comparableUtils = new ComparableUtils();
        assertFalse(comparableUtils.equalTo(10));
    }
    
    @Test
    void equalTo_ShouldReturnTrue_WhenObjectsAreEqualWithNull() {
        ComparableUtils comparableUtils = new ComparableUtils();
        Integer a = null;
        Integer b = null;
        assertTrue(comparableUtils.equalTo(a));
        assertTrue(comparableUtils.equalTo(b));
    }
    
    @Test
    void equalTo_ShouldReturnFalse_WhenObjectIsNull() {
        ComparableUtils comparableUtils = new ComparableUtils();
        Integer a = null;
        assertFalse(comparableUtils.equalTo(a));
    }
    
    @Test
    void equalTo_ShouldReturnFalse_WhenObjectIsNotNull() {
        ComparableUtils comparableUtils = new ComparableUtils();
        Integer a = 5;
        assertFalse(comparableUtils.equalTo(a));
    }
    
    @Test
    void equalTo_ShouldReturnTrue_WhenObjectsAreEqualWithDifferentTypes() {
        ComparableUtils comparableUtils = new ComparableUtils();
        Integer a = 5;
        Long b = 5L;
        assertTrue(comparableUtils.equalTo(a));
        assertTrue(comparableUtils.equalTo(b));
    }
    
    @Test
    void equalTo_ShouldReturnFalse_WhenObjectsAreNotEqualWithDifferentTypes() {
        ComparableUtils comparableUtils = new ComparableUtils();
        Integer a = 5;
        Long b = 10L;
        assertFalse(comparableUtils.equalTo(a));
        assertFalse(comparableUtils.equalTo(b));
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