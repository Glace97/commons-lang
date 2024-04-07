import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.function.Predicate;

public class betweenTest {

    @Test
    void testBetween() {
        ComparableUtils util = new ComparableUtils();
        Predicate<Integer> betweenPredicate = ComparableUtils.between(2, 5);

        assertTrue(betweenPredicate.test(3));
        assertTrue(betweenPredicate.test(4));
        assertFalse(betweenPredicate.test(1));
        assertFalse(betweenPredicate.test(6));
    }

    @Test
    void testBetweenNegative() {
        ComparableUtils util = new ComparableUtils();
        Predicate<Integer> betweenPredicate = ComparableUtils.between(-5, -2);

        assertTrue(betweenPredicate.test(-4));
        assertTrue(betweenPredicate.test(-3));
        assertFalse(betweenPredicate.test(-6));
        assertFalse(betweenPredicate.test(-1));
    }

    @Test
    void testBetweenEqual() {
        ComparableUtils util = new ComparableUtils();
        Predicate<Integer> betweenPredicate = ComparableUtils.between(2, 5);

        assertFalse(betweenPredicate.test(2));
        assertFalse(betweenPredicate.test(5));
    }

    @Test
    void testBetweenExclusive() {
        ComparableUtils util = new ComparableUtils();
        Predicate<Integer> betweenExclusivePredicate = ComparableUtils.betweenExclusive(2, 5);

        assertTrue(betweenExclusivePredicate.test(3));
        assertTrue(betweenExclusivePredicate.test(4));
        assertFalse(betweenExclusivePredicate.test(2));
        assertFalse(betweenExclusivePredicate.test(5));
        assertFalse(betweenExclusivePredicate.test(1));
        assertFalse(betweenExclusivePredicate.test(6));
    }

    @Test
    void testBetweenExclusiveNegative() {
        ComparableUtils util = new ComparableUtils();
        Predicate<Integer> betweenExclusivePredicate = ComparableUtils.betweenExclusive(-5, -2);

        assertTrue(betweenExclusivePredicate.test(-4));
        assertTrue(betweenExclusivePredicate.test(-3));
        assertFalse(betweenExclusivePredicate.test(-5));
        assertFalse(betweenExclusivePredicate.test(-2));
        assertFalse(betweenExclusivePredicate.test(-6));
        assertFalse(betweenExclusivePredicate.test(-1));
    }

    @Test
    void testBetweenExclusiveEqual() {
        ComparableUtils util = new ComparableUtils();
        Predicate<Integer> betweenExclusivePredicate = ComparableUtils.betweenExclusive(2, 5);

        assertFalse(betweenExclusivePredicate.test(2));
        assertFalse(betweenExclusivePredicate.test(5));
    }

    @Test
    void testEqualTo() {
        ComparableUtils util = new ComparableUtils();
        Predicate<Integer> equalToPredicate = util.equalTo(3);

        assertTrue(equalToPredicate.test(3));
        assertFalse(equalToPredicate.test(2));
        assertFalse(equalToPredicate.test(4));
    }

    @Test
    void testGreaterThan() {
        ComparableUtils util = new ComparableUtils();
        Predicate<Integer> greaterThanPredicate = util.greaterThan(3);

        assertTrue(greaterThanPredicate.test(4));
        assertFalse(greaterThanPredicate.test(3));
        assertFalse(greaterThanPredicate.test(2));
    }

    @Test
    void testGreaterThanOrEqualTo() {
        ComparableUtils util = new ComparableUtils();
        Predicate<Integer> greaterThanOrEqualToPredicate = util.greaterThanOrEqualTo(3);

        assertTrue(greaterThanOrEqualToPredicate.test(4));
        assertTrue(greaterThanOrEqualToPredicate.test(3));
        assertFalse(greaterThanOrEqualToPredicate.test(2));
    }

    @Test
    void testLessThan() {
        ComparableUtils util = new ComparableUtils();
        Predicate<Integer> lessThanPredicate = util.lessThan(3);

        assertTrue(lessThanPredicate.test(2));
        assertFalse(lessThanPredicate.test(3));
        assertFalse(lessThanPredicate.test(4));
    }

    @Test
    void testLessThanOrEqualTo() {
        ComparableUtils util = new ComparableUtils();
        Predicate<Integer> lessThanOrEqualToPredicate = util.lessThanOrEqualTo(3);

        assertTrue(lessThanOrEqualToPredicate.test(2));
        assertTrue(lessThanOrEqualToPredicate.test(3));
        assertFalse(lessThanOrEqualToPredicate.test(4));
    }
}