package org.apache.commons.lang3;

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

public class RandomUtilsTest {
    @Test
    void testNextLong() {
        long randomLong = RandomUtils.nextLong();
        assertTrue(randomLong >= 0);
        assertTrue(randomLong < Long.MAX_VALUE);
    }
    
    @Test
    void testNextLongInRange() {
        long startInclusive = 10;
        long endExclusive = 20;
        long randomLong = RandomUtils.nextLong(startInclusive, endExclusive);
        assertTrue(randomLong >= startInclusive);
        assertTrue(randomLong < endExclusive);
    }
    
    @Test
    void testNextLongWithEqualRange() {
        long startInclusive = 10;
        long endExclusive = 10;
        long randomLong = RandomUtils.nextLong(startInclusive, endExclusive);
        assertEquals(startInclusive, randomLong);
    }
    
    @Test
    void testNextLongWithNegativeRange() {
        long startInclusive = -10;
        long endExclusive = 10;
        assertThrows(IllegalArgumentException.class, () -> RandomUtils.nextLong(startInclusive, endExclusive));
    }
    
    @Test
    void testNextLongWithInvalidRange() {
        long startInclusive = 20;
        long endExclusive = 10;
        assertThrows(IllegalArgumentException.class, () -> RandomUtils.nextLong(startInclusive, endExclusive));
    }
    @Test
    void testNextFloat() {
        float result = RandomUtils.nextFloat();
        assertTrue(result >= 0);
        assertTrue(result < Float.MAX_VALUE);
    }
    
    @Test
    void testNextFloatRange() {
        float startInclusive = 10;
        float endExclusive = 20;
        float result = RandomUtils.nextFloat(startInclusive, endExclusive);
        assertTrue(result >= startInclusive);
        assertTrue(result < endExclusive);
    }
    
    @Test
    void testNextFloatRangeEqualValues() {
        float startInclusive = 10;
        float endExclusive = 10;
        float result = RandomUtils.nextFloat(startInclusive, endExclusive);
        assertEquals(startInclusive, result, EPSILON);
    }
    
    @Test
    void testNextFloatRangeNegativeStart() {
        float startInclusive = -10;
        float endExclusive = 10;
        assertThrows(IllegalArgumentException.class, () -> {
            RandomUtils.nextFloat(startInclusive, endExclusive);
        });
    }
    
    @Test
    void testNextFloatRangeEndSmallerThanStart() {
        float startInclusive = 20;
        float endExclusive = 10;
        assertThrows(IllegalArgumentException.class, () -> {
            RandomUtils.nextFloat(startInclusive, endExclusive);
        });
    }
    @Test
    void testNextIntWithinRange() {
        int start = 0;
        int end = 10;
        int result = RandomUtils.nextInt(start, end);
        assertTrue(result >= start && result < end);
    }
    
    @Test
    void testNextIntEqualRange() {
        int start = 5;
        int end = 5;
        int result = RandomUtils.nextInt(start, end);
        assertEquals(start, result);
    }
    
    @Test
    void testNextIntWithNegativeStart() {
        int start = -10;
        int end = 0;
        assertThrows(IllegalArgumentException.class,
                () -> RandomUtils.nextInt(start, end));
    }
    
    @Test
    void testNextIntWithEndSmallerThanStart() {
        int start = 10;
        int end = 5;
        assertThrows(IllegalArgumentException.class,
                () -> RandomUtils.nextInt(start, end));
    }
    
    @Test
    void testNextIntGlobalRange() {
        int result = RandomUtils.nextInt();
        assertTrue(result >= 0 && result < Integer.MAX_VALUE);
    }
    @Test
    void testNextBytesPositiveCount() {
        int count = 10;
        byte[] bytes = RandomUtils.nextBytes(count);
        Assertions.assertEquals(count, bytes.length);
    }
    
    @Test
    void testNextBytesZeroCount() {
        int count = 0;
        byte[] bytes = RandomUtils.nextBytes(count);
        Assertions.assertEquals(count, bytes.length);
    }
    
    @Test
    void testNextBytesNegativeCount() {
        int count = -10;
        Assertions.assertThrows(IllegalArgumentException.class, () -> RandomUtils.nextBytes(count));
    }
    
    @Test
    void testNextBytesRandomness() {
        int count = 100;
        byte[] bytes1 = RandomUtils.nextBytes(count);
        byte[] bytes2 = RandomUtils.nextBytes(count);
        Assertions.assertFalse(Arrays.equals(bytes1, bytes2));
    }
    @Test
    @DisplayName("should return true or false")
    public void shouldReturnTrueOrFalse() {
        boolean result = RandomUtils.nextBoolean();
        Assertions.assertTrue(result || !result);
    }
    
    @Test
    @DisplayName("should return true with 50% probability")
    public void shouldReturnTrueWith50PercentProbability() {
        int trueCount = 0;
        int totalIterations = 100000;
    
        for (int i = 0; i < totalIterations; i++) {
            boolean result = RandomUtils.nextBoolean();
            if (result) {
                trueCount++;
            }
        }
    
        double truePercentage = (double) trueCount / totalIterations * 100;
        Assertions.assertTrue(Math.abs(truePercentage - 50) < 1, "True percentage: " + truePercentage);
    }
    @Test
    void testRandomPositiveInt() {
        int result = random.nextInt(Integer.MAX_VALUE);
        assertTrue(result >= 0);
        assertTrue(result < Integer.MAX_VALUE);
    }
    
    @Test
    void testRandomNegativeInt() {
        int result = random.nextInt(Integer.MIN_VALUE, 0);
        assertTrue(result >= Integer.MIN_VALUE);
        assertTrue(result < 0);
    }
    
    @Test
    void testRandomIntRange() {
        int min = -100;
        int max = 100;
        int result = random.nextInt(min, max);
        assertTrue(result >= min);
        assertTrue(result < max);
    }
    
    @Test
    void testRandomLong() {
        long result = random.nextLong();
        assertNotNull(result);
    }
    
    @Test
    void testRandomPositiveDouble() {
        double result = random.nextDouble();
        assertTrue(result >= 0);
        assertTrue(result < 1);
    }
    
    @Test
    void testRandomNegativeDouble() {
        double result = random.nextDouble(-1, 0);
        assertTrue(result >= -1);
        assertTrue(result < 0);
    }
    
    @Test
    void testRandomDoubleRange() {
        double min = -10.0;
        double max = 10.0;
        double result = random.nextDouble(min, max);
        assertTrue(result >= min);
        assertTrue(result < max);
    }
    
    @Test
    void testRandomBoolean() {
        boolean result = random.nextBoolean();
        assertNotNull(result);
    }
    
    @Test
    void testRandomBytes() {
        byte[] result = new byte[10];
        random.nextBytes(result);
        assertNotNull(result);
    }
    @Test
    void testNextDoubleInRange() {
        double start = 0;
        double end = 10;
        double result = RandomUtils.nextDouble(start, end);
        assertTrue(result >= start && result < end);
    }
    
    @Test
    void testNextDoubleInRangeWithEqualStartAndEnd() {
        double start = 5;
        double end = 5;
        double result = RandomUtils.nextDouble(start, end);
        assertEquals(start, result);
    }
    
    @Test
    void testNextDoubleInRangeWithNegativeStart() {
        double start = -10;
        double end = 10;
        assertThrows(IllegalArgumentException.class, () -> RandomUtils.nextDouble(start, end));
    }
    
    @Test
    void testNextDoubleInRangeWithEndSmallerThanStart() {
        double start = 10;
        double end = 5;
        assertThrows(IllegalArgumentException.class, () -> RandomUtils.nextDouble(start, end));
    }
    
    @Test
    void testNextDouble() {
        double result = RandomUtils.nextDouble();
        assertTrue(result >= 0 && result < Double.MAX_VALUE);
    }

}