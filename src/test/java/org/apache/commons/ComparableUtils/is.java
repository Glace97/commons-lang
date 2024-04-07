import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class isTest {

    @Test
    void testBetween() {
        ComparableUtils.ComparableCheckBuilder<Integer> builder = ComparableUtils.is(5);
        
        assertTrue(builder.between(3, 7));
        assertTrue(builder.between(7, 3));
        assertFalse(builder.between(1, 3));
        assertFalse(builder.between(7, 9));
        assertFalse(builder.between(3, 5));
    }

    @Test
    void testBetweenExclusive() {
        ComparableUtils.ComparableCheckBuilder<Integer> builder = ComparableUtils.is(5);
        
        assertTrue(builder.betweenExclusive(3, 7));
        assertTrue(builder.betweenExclusive(7, 3));
        assertFalse(builder.betweenExclusive(1, 3));
        assertFalse(builder.betweenExclusive(7, 9));
        assertFalse(builder.betweenExclusive(3, 5));
    }

    @Test
    void testEqualTo() {
        ComparableUtils.ComparableCheckBuilder<Integer> builder = ComparableUtils.is(5);
        
        assertTrue(builder.equalTo(5));
        assertFalse(builder.equalTo(3));
        assertFalse(builder.equalTo(7));
    }

    @Test
    void testGreaterThan() {
        ComparableUtils.ComparableCheckBuilder<Integer> builder = ComparableUtils.is(5);
        
        assertTrue(builder.greaterThan(3));
        assertFalse(builder.greaterThan(5));
        assertFalse(builder.greaterThan(7));
    }

    @Test
    void testGreaterThanOrEqualTo() {
        ComparableUtils.ComparableCheckBuilder<Integer> builder = ComparableUtils.is(5);
        
        assertTrue(builder.greaterThanOrEqualTo(3));
        assertTrue(builder.greaterThanOrEqualTo(5));
        assertFalse(builder.greaterThanOrEqualTo(7));
    }

    @Test
    void testLessThan() {
        ComparableUtils.ComparableCheckBuilder<Integer> builder = ComparableUtils.is(5);
        
        assertTrue(builder.lessThan(7));
        assertFalse(builder.lessThan(5));
        assertFalse(builder.lessThan(3));
    }

    @Test
    void testLessThanOrEqualTo() {
        ComparableUtils.ComparableCheckBuilder<Integer> builder = ComparableUtils.is(5);
        
        assertTrue(builder.lessThanOrEqualTo(7));
        assertTrue(builder.lessThanOrEqualTo(5));
        assertFalse(builder.lessThanOrEqualTo(3));
    }
}