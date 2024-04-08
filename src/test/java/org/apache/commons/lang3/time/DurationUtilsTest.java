package org.apache.commons.lang3.time;

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

public class DurationUtilsTest {
    @Test
    void accept_NullConsumer_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> DurationUtils.accept(null, Duration.ofSeconds(1)));
    }
    
    @Test
    void accept_NullDuration_DoesNotThrowException() {
        assertDoesNotThrow(() -> DurationUtils.accept((ms, ns) -> {}, null));
    }
    
    @Test
    void accept_ValidConsumerAndDuration_CallsConsumerWithCorrectValues() {
        Duration duration = Duration.ofSeconds(2).plusMillis(500).plusNanos(300);
        LongRange expectedRange = LongRange.of(0, 2000);
        Integer expectedNanos = 300;
    
        DurationUtils.accept((ms, ns) -> {
            assertEquals(expectedRange, LongRange.of(ms));
            assertEquals(expectedNanos, ns);
        }, duration);
    }
    
    @Test
    void accept_DurationWithZeroMillis_CallsConsumerWithZeroMillisAndNanos() {
        Duration duration = Duration.ofNanos(500);
        LongRange expectedRange = LongRange.of(0);
        Integer expectedNanos = 500;
    
        DurationUtils.accept((ms, ns) -> {
            assertEquals(expectedRange, LongRange.of(ms));
            assertEquals(expectedNanos, ns);
        }, duration);
    }
    
    @Test
    void accept_DurationWithNegativeMillis_CallsConsumerWithNegativeMillisAndNanos() {
        Duration duration = Duration.ofMillis(-200).plusNanos(500);
        LongRange expectedRange = LongRange.of(-200);
        Integer expectedNanos = 500;
    
        DurationUtils.accept((ms, ns) -> {
            assertEquals(expectedRange, LongRange.of(ms));
            assertEquals(expectedNanos, ns);
        }, duration);
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
    
    @Test
    @DisplayName("should throw IllegalArgumentException when timeUnit has an exact duration")
    void testToDurationWithInvalidTimeUnit() {
        // Arrange
        long amount = 10;
        TimeUnit timeUnit = TimeUnit.DAYS;
    
        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> durationUtils.toDuration(amount, timeUnit));
    }
    // Your Java code here
    @Test
    @DisplayName("should return zero duration when start instant is now")
    void shouldReturnZeroDurationWhenStartInstantIsNow() {
        Instant now = Instant.now();
        Duration duration = DurationUtils.since(now);
        Assertions.assertEquals(Duration.ZERO, duration);
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
    @DisplayName("should return the correct duration when start instant is a future instant")
    void shouldReturnCorrectDurationWhenStartInstantIsFutureInstant() {
        Instant start = Instant.now().plus(1, ChronoUnit.SECONDS);
        Instant now = Instant.now();
        Duration expectedDuration = Duration.between(start, now);
        // Mocking Instant.now() to return a fixed value
        InstantUtils instantUtils = mock(InstantUtils.class);
        when(instantUtils.now()).thenReturn(now);
        Duration actualDuration = DurationUtils.since(start, instantUtils);
        Assertions.assertEquals(expectedDuration, actualDuration);
    }
    import static org.junit.jupiter.api.Assertions.*;
    
    import org.junit.jupiter.api.Test;
    
    class DurationUtilsTestSuite {
    
        private DurationUtils durationUtils;
    
        @BeforeAll
        public void setUp() {
            durationUtils = new DurationUtils();
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
    @DisplayName("should return Duration.ZERO if duration is negative")
    void shouldReturnDurationZeroIfNegative() {
        // Arrange
        Duration duration = Duration.ofSeconds(-10);
    
        // Act
        Duration result = DurationUtils.zeroIfNull(duration);
    
        // Assert
        assertNotNull(result);
        assertEquals(Duration.ZERO, result);
    }
    
    @Test
    @DisplayName("should return Duration.ZERO if duration is greater than maximum allowed long value as seconds")
    void shouldReturnDurationZeroIfGreaterThanMaxLongValue() {
        // Arrange
        Duration duration = Duration.ofSeconds(Long.MAX_VALUE);
    
        // Act
        Duration result = DurationUtils.zeroIfNull(duration);
    
        // Assert
        assertNotNull(result);
        assertEquals(Duration.ZERO, result);
    }
    
    @Test
    @DisplayName("should return Duration.ZERO if duration is less than minimum allowed long value as seconds")
    void shouldReturnDurationZeroIfLessThanMinLongValue() {
        // Arrange
        Duration duration = Duration.ofSeconds(Long.MIN_VALUE);
    
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
    import static org.junit.jupiter.api.Assertions.assertEquals;
    import static org.junit.jupiter.api.Assertions.assertThrows;
    import static org.mockito.Mockito.mock;
    import static org.mockito.Mockito.when;
    
    import java.time.temporal.ChronoUnit;
    import java.util.concurrent.TimeUnit;
    
    import org.junit.jupiter.api.Test;
    
    class DurationUtilsTest {
    
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
        void shouldThrowIllegalArgumentException() {
            TimeUnit timeUnit = null;
            DurationUtils durationUtils = new DurationUtils();
            assertThrows(IllegalArgumentException.class, () -> {
                durationUtils.toChronoUnit(timeUnit);
            });
        }
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
    public void testGetNanosOfMilli_withPositiveDuration_shouldReturnCorrectValue() {
        Duration duration = Duration.ofSeconds(5).plusNanos(123456789);
        int result = DurationUtils.getNanosOfMilli(duration);
        assertEquals(123456, result);
    }
    
    @Test
    public void testGetNanosOfMilli_withNegativeDuration_shouldReturnCorrectValue() {
        Duration duration = Duration.ofSeconds(-5).minusNanos(123456789);
        int result = DurationUtils.getNanosOfMilli(duration);
        assertEquals(876544, result);
    }
    
    @Test
    public void testGetNanosOfMilli_withDurationGreaterThanOneSecond_shouldReturnCorrectValue() {
        Duration duration = Duration.ofSeconds(10).plusNanos(987654321);
        int result = DurationUtils.getNanosOfMilli(duration);
        assertEquals(987654, result);
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
    public void testGetNanosOfMilli_withDurationSlightlyGreaterThanOneMillisecond_shouldReturnCorrectValue() {
        Duration duration = Duration.ofMillis(1).plusNanos(1);
        int result = DurationUtils.getNanosOfMilli(duration);
        assertEquals(0, result);
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
    public void testGetNanosOfMilli_withDurationSlightlyGreaterThanOneSecond_shouldReturnCorrectValue() {
        Duration duration = Duration.ofSeconds(1).plusNanos(1);
        int result = DurationUtils.getNanosOfMilli(duration);
        assertEquals(0, result);
    }
    @Test
    void testNow() {
        Instant result = DurationUtils.now((start) -> {
            assertNotNull(start);
        });
    
        assertNotNull(result);
    }
    
    @Test
    void testNowWithDuration() {
        Instant start = Instant.now();
        Instant result = DurationUtils.now((startTime) -> {
            assertNotNull(startTime);
            Duration duration = Duration.between(startTime, Instant.now());
            assertTrue(duration.getSeconds() >= 0);
        });
    
        assertNotNull(result);
        Duration duration = Duration.between(start, result);
        assertTrue(duration.getSeconds() >= 0);
    }
    
    @Test
    void testNowWithException() {
        assertThrows(TestException.class, () -> {
            DurationUtils.now((start) -> {
                throw new TestException();
            });
        });
    }
    
    @Test
    void testNowWithLongRange() {
        Instant result = DurationUtils.now((start) -> {
            LongRange longRange = LongRange.of(0L, 100L);
            assertTrue(longRange.contains(start.toEpochMilli()));
        });
    
        assertNotNull(result);
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
    
    @Test
    void testSince() {
        Instant start = Instant.now();
    
        // Test case 1: End time is after start time
        Instant end1 = start.plusSeconds(5);
        Duration duration1 = DurationUtils.since(end1);
        assertNotNull(duration1);
        assertTrue(duration1.getSeconds() >= 5);
    
        // Test case 2: End time is before start time
        Instant end2 = start.minusSeconds(5);
        Duration duration2 = DurationUtils.since(end2);
        assertNotNull(duration2);
        assertTrue(duration2.getSeconds() <= -5);
    }
    
    @Test
    void testNow() {
        Instant instant = DurationUtils.now();
        assertNotNull(instant);
    }

}