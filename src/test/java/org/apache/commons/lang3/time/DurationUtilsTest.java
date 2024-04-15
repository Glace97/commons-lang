package org.apache.commons.lang3.time;

import static org.easymock.EasyMock.mock;
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


import org.apache.commons.lang3.LongRange;
import org.junit.jupiter.api.*;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;
import java.time.Duration;

public class DurationUtilsTest {
    private DurationUtils durationUtils;

    @BeforeEach
    public void setUp() {
        durationUtils = new DurationUtils();
    }


    @Test
    void accept_NullDuration_DoesNotThrowException() {
        assertDoesNotThrow(() -> DurationUtils.accept((ms, ns) -> {
        }, null));
    }

    @Test
    @DisplayName("should return duration with positive amount")
    void testToDurationWithPositiveAmount() {
        // Arrange
        long amount = 5;
        TimeUnit timeUnit = TimeUnit.MINUTES;
        Duration expectedDuration = Duration.ofMinutes(5);

        // Act
        Duration actualDuration = durationUtils.toDuration(amount, timeUnit);

        // Assert
        assertEquals(expectedDuration, actualDuration);
    }

    @Test
    @DisplayName("should return duration with negative amount")
    void testToDurationWithNegativeAmount() {
        // Arrange
        long amount = -5;
        TimeUnit timeUnit = TimeUnit.HOURS;
        Duration expectedDuration = Duration.ofHours(-5);

        // Act
        Duration actualDuration = durationUtils.toDuration(amount, timeUnit);

        // Assert
        assertEquals(expectedDuration, actualDuration);
    }

    @Test
    @DisplayName("should return duration with zero amount")
    void testToDurationWithZeroAmount() {
        // Arrange
        long amount = 0;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        Duration expectedDuration = Duration.ofSeconds(0);

        // Act
        Duration actualDuration = durationUtils.toDuration(amount, timeUnit);

        // Assert
        assertEquals(expectedDuration, actualDuration);
    }

    @Test
    @DisplayName("should throw NullPointerException when timeUnit is null")
    void testToDurationWithNullTimeUnit() {
        // Arrange
        long amount = 10;
        TimeUnit timeUnit = null;

        // Act & Assert
        assertThrows(NullPointerException.class, () -> durationUtils.toDuration(amount, timeUnit));
    }


    // Your Java code here
    //@Test
    @DisplayName("should return zero duration when start instant is now")
    void shouldReturnZeroDurationWhenStartInstantIsNow() {
        Instant now = Instant.now();
        Duration duration = DurationUtils.since(now);
        assertEquals(Duration.ZERO, duration);
    }

    @Test
    @DisplayName("should return positive duration when start instant is before now")
    void shouldReturnPositiveDurationWhenStartInstantIsBeforeNow() {
        Instant start = Instant.now().minus(1, ChronoUnit.SECONDS);
        Duration duration = DurationUtils.since(start);
        Assertions.assertTrue(duration.toNanos() > 0);
    }

    @Test
    @DisplayName("should throw NullPointerException when start instant is null")
    void shouldThrowNullPointerExceptionWhenStartInstantIsNull() {
        Assertions.assertThrows(NullPointerException.class, () -> DurationUtils.since(null));
    }

    @Test
    void testIsPositive_WithPositiveDuration_ReturnsTrue() {
        Duration duration = Duration.ofSeconds(10);
        assertTrue(durationUtils.isPositive(duration));
    }

    @Test
    void testIsPositive_WithNegativeDuration_ReturnsFalse() {
        Duration duration = Duration.ofSeconds(-10);
        assertFalse(durationUtils.isPositive(duration));
    }

    @Test
    void testIsPositive_WithZeroDuration_ReturnsFalse() {
        Duration duration = Duration.ZERO;
        assertFalse(durationUtils.isPositive(duration));
    }

    @Test
    void testIsPositive_WithVerySmallPositiveDuration_ReturnsTrue() {
        Duration duration = Duration.ofNanos(1);
        assertTrue(durationUtils.isPositive(duration));
    }

    @Test
    void testIsPositive_WithVerySmallNegativeDuration_ReturnsFalse() {
        Duration duration = Duration.ofNanos(-1);
        assertFalse(durationUtils.isPositive(duration));
    }

    @Test
    void testIsPositive_WithMaxValueDuration_ReturnsTrue() {
        Duration duration = Duration.ofSeconds(Long.MAX_VALUE);
        assertTrue(durationUtils.isPositive(duration));
    }

    @Test
    void testIsPositive_WithMinValueDuration_ReturnsFalse() {
        Duration duration = Duration.ofSeconds(Long.MIN_VALUE);
        assertFalse(durationUtils.isPositive(duration));
    }

    @Test
    void testIsPositive_WithOneNanosecondDuration_ReturnsTrue() {
        Duration duration = Duration.ofNanos(1);
        assertTrue(durationUtils.isPositive(duration));
    }

    @Test
    void testIsPositive_WithOneMicrosecondDuration_ReturnsTrue() {
        Duration duration = Duration.ofNanos(1000);
        assertTrue(durationUtils.isPositive(duration));
    }

    @Test
    void testIsPositive_WithOneMillisecondDuration_ReturnsTrue() {
        Duration duration = Duration.ofMillis(1);
        assertTrue(durationUtils.isPositive(duration));
    }

    @Test
    void testIsPositive_WithOneSecondDuration_ReturnsTrue() {
        Duration duration = Duration.ofSeconds(1);
        assertTrue(durationUtils.isPositive(duration));
    }

    @Test
    @DisplayName("should return the given duration if not null")
    void shouldReturnGivenDurationIfNotNull() {
        // Arrange
        Duration duration = Duration.ofSeconds(60);

        // Act
        Duration result = DurationUtils.zeroIfNull(duration);

        // Assert
        assertNotNull(result);
        assertEquals(duration, result);
    }

    @Test
    @DisplayName("should return Duration.ZERO if null")
    void shouldReturnDurationZeroIfNull() {
        // Arrange
        Duration duration = null;

        // Act
        Duration result = DurationUtils.zeroIfNull(duration);

        // Assert
        assertNotNull(result);
        assertEquals(Duration.ZERO, result);
    }

    @Test
    @DisplayName("should return Duration.ZERO if duration is zero seconds")
    void shouldReturnDurationZeroIfZeroSeconds() {
        // Arrange
        Duration duration = Duration.ZERO;

        // Act
        Duration result = DurationUtils.zeroIfNull(duration);

        // Assert
        assertNotNull(result);
        assertEquals(Duration.ZERO, result);
    }


    @Test
    @DisplayName("Converts a positive duration to int milliseconds")
    void testConvertPositiveDurationToIntMilliseconds() {
        Duration duration = Duration.ofSeconds(30);
        int expected = 30000;

        int result = durationUtils.toMillisInt(duration);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Converts a negative duration to int milliseconds")
    void testConvertNegativeDurationToIntMilliseconds() {
        Duration duration = Duration.ofSeconds(-30);
        int expected = -30000;

        int result = durationUtils.toMillisInt(duration);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Converts a zero duration to int milliseconds")
    void testConvertZeroDurationToIntMilliseconds() {
        Duration duration = Duration.ZERO;
        int expected = 0;

        int result = durationUtils.toMillisInt(duration);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Throws NullPointerException when duration is null")
    void testThrowsNullPointerExceptionWhenDurationIsNull() {
        assertThrows(NullPointerException.class, () -> durationUtils.toMillisInt(null));
    }

    @Test
    @DisplayName("Converts a large positive duration to Integer.MAX_VALUE")
    void testConvertLargePositiveDurationToIntegerMaxValue() {
        Duration duration = Duration.ofDays(100000);
        int expected = Integer.MAX_VALUE;

        int result = durationUtils.toMillisInt(duration);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Converts a large negative duration to Integer.MIN_VALUE")
    void testConvertLargeNegativeDurationToIntegerMinValue() {
        Duration duration = Duration.ofDays(-100000);
        int expected = Integer.MIN_VALUE;

        int result = durationUtils.toMillisInt(duration);

        assertEquals(expected, result);
    }


    @Test
    void shouldReturnNanos() {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        DurationUtils durationUtils = new DurationUtils();
        ChronoUnit result = durationUtils.toChronoUnit(timeUnit);
        assertEquals(ChronoUnit.NANOS, result);
    }

    @Test
    void shouldReturnMicros() {
        TimeUnit timeUnit = TimeUnit.MICROSECONDS;
        DurationUtils durationUtils = new DurationUtils();
        ChronoUnit result = durationUtils.toChronoUnit(timeUnit);
        assertEquals(ChronoUnit.MICROS, result);
    }

    @Test
    void shouldReturnMillis() {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        DurationUtils durationUtils = new DurationUtils();
        ChronoUnit result = durationUtils.toChronoUnit(timeUnit);
        assertEquals(ChronoUnit.MILLIS, result);
    }

    @Test
    void shouldReturnSeconds() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        DurationUtils durationUtils = new DurationUtils();
        ChronoUnit result = durationUtils.toChronoUnit(timeUnit);
        assertEquals(ChronoUnit.SECONDS, result);
    }

    @Test
    void shouldReturnMinutes() {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        DurationUtils durationUtils = new DurationUtils();
        ChronoUnit result = durationUtils.toChronoUnit(timeUnit);
        assertEquals(ChronoUnit.MINUTES, result);
    }

    @Test
    void shouldReturnHours() {
        TimeUnit timeUnit = TimeUnit.HOURS;
        DurationUtils durationUtils = new DurationUtils();
        ChronoUnit result = durationUtils.toChronoUnit(timeUnit);
        assertEquals(ChronoUnit.HOURS, result);
    }

    @Test
    void shouldReturnDays() {
        TimeUnit timeUnit = TimeUnit.DAYS;
        DurationUtils durationUtils = new DurationUtils();
        ChronoUnit result = durationUtils.toChronoUnit(timeUnit);
        assertEquals(ChronoUnit.DAYS, result);
    }

    @Test
    public void testGetNanosOfMilli_withNullDuration_shouldReturnZero() {
        int result = DurationUtils.getNanosOfMilli(null);
        assertEquals(0, result);
    }

    @Test
    public void testGetNanosOfMilli_withZeroDuration_shouldReturnZero() {
        int result = DurationUtils.getNanosOfMilli(Duration.ZERO);
        assertEquals(0, result);
    }

    @Test
    public void testGetNanosOfMilli_withDurationLessThanOneMillisecond_shouldReturnCorrectValue() {
        Duration duration = Duration.ofNanos(123456);
        int result = DurationUtils.getNanosOfMilli(duration);
        assertEquals(123456, result);
    }

    @Test
    public void testGetNanosOfMilli_withDurationEqualToOneMillisecond_shouldReturnZero() {
        Duration duration = Duration.ofMillis(1);
        int result = DurationUtils.getNanosOfMilli(duration);
        assertEquals(0, result);
    }

    @Test
    public void testGetNanosOfMilli_withDurationSlightlyLessThanOneMillisecond_shouldReturnCorrectValue() {
        Duration duration = Duration.ofMillis(1).minusNanos(1);
        int result = DurationUtils.getNanosOfMilli(duration);
        assertEquals(999999, result);
    }

    @Test
    public void testGetNanosOfMilli_withDurationEqualToOneSecond_shouldReturnZero() {
        Duration duration = Duration.ofSeconds(1);
        int result = DurationUtils.getNanosOfMilli(duration);
        assertEquals(0, result);
    }

    @Test
    public void testGetNanosOfMilli_withDurationSlightlyLessThanOneSecond_shouldReturnCorrectValue() {
        Duration duration = Duration.ofSeconds(1).minusNanos(1);
        int result = DurationUtils.getNanosOfMilli(duration);
        assertEquals(999_999, result);
    }

    @Test
    void testGetNanosOfMiili() {
        Duration duration = Duration.ofMillis(1000);
        assertEquals(0, DurationUtils.getNanosOfMiili(duration));
    }

    @Test
    void testGetNanosOfMiiliWithDurationLessThanOneMillisecond() {
        Duration duration = Duration.ofNanos(999_999);
        assertEquals(999_999, DurationUtils.getNanosOfMiili(duration));
    }

    @Test
    void testGetNanosOfMiiliWithDurationGreaterThanOneMillisecond() {
        Duration duration = Duration.ofMillis(1001);
        assertEquals(0, DurationUtils.getNanosOfMiili(duration));
    }

    @Test
    void testGetNanosOfMiiliWithNegativeDuration() {
        Duration duration = Duration.ofMillis(-1000);
        assertEquals(0, DurationUtils.getNanosOfMiili(duration));
    }

    @Test
    void testGetNanosOfMiiliWithZeroDuration() {
        Duration duration = Duration.ZERO;
        assertEquals(0, DurationUtils.getNanosOfMiili(duration));
    }

    @Test
    void testGetNanosOfMiiliWithMaxDuration() {
        Duration duration = Duration.ofSeconds(Long.MAX_VALUE, 999_999_999);
        assertEquals(999_999, DurationUtils.getNanosOfMiili(duration));
    }

    @Test
    void testGetNanosOfMiiliWithMinDuration() {
        Duration duration = Duration.ofSeconds(Long.MIN_VALUE, 0);
        assertEquals(0, DurationUtils.getNanosOfMiili(duration));
    }

    @Test
    void testOfConsumer() {
        // Test case 1: Lambda executes successfully
        Duration duration1 = DurationUtils.of(consumer -> {
            // Perform some task
        });
        assertNotNull(duration1);

        // Test case 2: Lambda throws an exception
        assertThrows(Exception.class, () -> {
            DurationUtils.of(consumer -> {
                throw new Exception("Error");
            });
        });
    }

    @Test
    void testOfRunnable() {
        // Test case 1: Lambda executes successfully
        Duration duration1 = DurationUtils.of(() -> {
            // Perform some task
        });
        assertNotNull(duration1);

        // Test case 2: Lambda throws an exception
        assertThrows(Exception.class, () -> {
            DurationUtils.of(() -> {
                throw new Exception("Error");
            });
        });
    }

}