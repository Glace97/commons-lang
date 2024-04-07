import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

class maxTest {

    @Nested
    @DisplayName("max method tests")
    class MaxMethodTests {

        @Test
        @DisplayName("When both comparables are null, should return null")
        void testMaxWithNullComparables() {
            assertNull(ComparableUtils.max(null, null));
        }

        @Test
        @DisplayName("When first comparable is null, should return the second comparable")
        void testMaxWithFirstNullComparable() {
            Integer comparable2 = 5;
            assertSame(comparable2, ComparableUtils.max(null, comparable2));
        }

        @Test
        @DisplayName("When second comparable is null, should return the first comparable")
        void testMaxWithSecondNullComparable() {
            Integer comparable1 = 3;
            assertSame(comparable1, ComparableUtils.max(comparable1, null));
        }

        @Test
        @DisplayName("When both comparables are distinct, should return the larger comparable")
        void testMaxWithDistinctComparables() {
            Integer comparable1 = 3;
            Integer comparable2 = 5;
            assertSame(comparable2, ComparableUtils.max(comparable1, comparable2));
        }

        @Test
        @DisplayName("When both comparables are equal, should return any of the comparables")
        void testMaxWithEqualComparables() {
            Integer comparable1 = 5;
            Integer comparable2 = 5;
            assertTrue(comparable1 == ComparableUtils.max(comparable1, comparable2) ||
                    comparable2 == ComparableUtils.max(comparable1, comparable2));
        }
    }
}