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


import org.junit.jupiter.api.*;

public class DurationFormatUtilsTest {

    private DurationFormatUtils.Token token;
    private DurationFormatUtils.Token[] tokens;

    @BeforeEach
    void setUp() {
       DurationFormatUtils.Token token1 = new DurationFormatUtils.Token("value1", false, -1);
        DurationFormatUtils.Token token2 = new DurationFormatUtils.Token("value2", false, -1);
        tokens = new DurationFormatUtils.Token[]{token1, token2};
        token = new DurationFormatUtils.Token("value", false, -1);
    }

    @Test
    void testFormatDuration_ZeroDuration() {
        long durationMillis = 0;
        String format = "HH:mm:ss.SSS";
        String expected = "00:00:00.000";

        String result = DurationFormatUtils.formatDuration(durationMillis, format);

        assertEquals(expected, result);
    }

    @Test
    void testFormatDuration_PositiveDuration() {
        long durationMillis = 123456789;
        String format = "HH:mm:ss.SSS";
        String expected = "34:17:36.789";

        String result = DurationFormatUtils.formatDuration(durationMillis, format);

        assertEquals(expected, result);
    }

    @Test
    void testFormatDuration_NegativeDuration() {
        long durationMillis = -123456789;
        String format = "HH:mm:ss.SSS";

        assertThrows(IllegalArgumentException.class, () -> {
            DurationFormatUtils.formatDuration(durationMillis, format);
        });
    }

    @Test
    void testFormatDuration_DurationWithDays() {
        long durationMillis = 123456789;
        String format = "d HH:mm:ss.SSS";
        String expected = "1 10:17:36.789";

        String result = DurationFormatUtils.formatDuration(durationMillis, format);

        assertEquals(expected, result);
    }

    @Test
    void testFormatDuration_DurationWithHours() {
        long durationMillis = 123456789;
        String format = "HH:mm:ss.SSS";
        String expected = "34:17:36.789";

        String result = DurationFormatUtils.formatDuration(durationMillis, format);

        assertEquals(expected, result);
    }

    @Test
    void testFormatDuration_DurationWithMinutes() {
        long durationMillis = 123456789;
        String format = "mm:ss.SSS";
        String expected = "2057:36.789";

        String result = DurationFormatUtils.formatDuration(durationMillis, format);

        assertEquals(expected, result);
    }


    @Test
    void testFormatDuration_DurationWithPadding() {
        long durationMillis = 123456789;
        String format = "HH:mm:ss.SSS";
        String expected = "34:17:36.789";

        String result = DurationFormatUtils.formatDuration(durationMillis, format, true);

        assertEquals(expected, result);
    }

    @Test
    void testFormatDuration_DurationWithoutPadding() {
        long durationMillis = 123456789;
        String format = "HH:mm:ss.SSS";
        String expected = "34:17:36.789";

        String result = DurationFormatUtils.formatDuration(durationMillis, format, false);

        assertEquals(expected, result);
    }


    @Test
    void testContainsTokenWithValue_shouldReturnTrueIfTokenWithValueExists() {
        tokens = new DurationFormatUtils.Token[]{
                new DurationFormatUtils.Token("y", false, -1),
                new DurationFormatUtils.Token("M", false, -1),
                new DurationFormatUtils.Token("d", false, -1)
        };

        boolean result = DurationFormatUtils.Token.containsTokenWithValue(tokens, "M");

        assertTrue(result);
    }

    @Test
    void testContainsTokenWithValue_shouldReturnFalseIfTokenWithValueDoesNotExist() {
        tokens = new DurationFormatUtils.Token[]{
                new DurationFormatUtils.Token("y", false, -1),
                new DurationFormatUtils.Token("M", false, -1),
                new DurationFormatUtils.Token("d", false, -1)
        };

        boolean result = DurationFormatUtils.Token.containsTokenWithValue(tokens, "H");

        assertFalse(result);
    }

    @Test
    void testContainsTokenWithValue_shouldReturnFalseIfTokensArrayIsEmpty() {
        tokens = new DurationFormatUtils.Token[]{};
        boolean result = DurationFormatUtils.Token.containsTokenWithValue(tokens, "M");
        assertFalse(result);
    }

    @Test
    void testContainsTokenWithValue_shouldReturnFalseIfValueIsNull() {
        tokens = new DurationFormatUtils.Token[]{
                new DurationFormatUtils.Token("y", false, -1),
                new DurationFormatUtils.Token("M", false, -1),
                new DurationFormatUtils.Token("d", false, -1)
        };

        boolean result = DurationFormatUtils.Token.containsTokenWithValue(tokens, null);

        assertFalse(result);
    }


    @Test
    void testHashCode() {
        DurationFormatUtils.Token token1 = new DurationFormatUtils.Token("y", false, -1);
        DurationFormatUtils.Token token2 = new DurationFormatUtils.Token("y", false, -1);
        DurationFormatUtils.Token token3 = new DurationFormatUtils.Token("M", false, -1);
        DurationFormatUtils.Token token4 = new DurationFormatUtils.Token("M", true, 0);

        Assertions.assertEquals(token1.hashCode(), token2.hashCode());
        Assertions.assertNotEquals(token1.hashCode(), token3.hashCode());
        Assertions.assertNotEquals(token1.hashCode(), token4.hashCode());
    }

    @Test
    void testLexxWithEmptyFormat() {
        String format = "";
        DurationFormatUtils.Token[] tokens = DurationFormatUtils.lexx(format);
        Assertions.assertEquals(0, tokens.length);
    }

    @Test
    void testLexxWithInvalidOptionalBlocks() {
        String format = "[yyyy[MM][dd][HH]]mm[ss][SSS]";
        Assertions.assertThrows(IllegalArgumentException.class, () -> DurationFormatUtils.lexx(format));
    }

    @Test
    @DisplayName("Token should be equal to itself")
    void tokenShouldBeEqualItself() {
        assertTrue(token.equals(token));
    }

    @Test
    @DisplayName("Token should not be equal to null")
    void tokenShouldNotBeEqualToNull() {
        assertFalse(token.equals(null));
    }

    @Test
    @DisplayName("Token should not be equal to a different class")
    void tokenShouldNotBeEqualToDifferentClass() {
        assertFalse(token.equals("value"));
    }

    @Test
    @DisplayName("Token should be equal to another DurationFormatUtils.Token with the same value and count")
    void tokenShouldBeEqualToAnotherTokenWithSameValueAndCount() {
        DurationFormatUtils.Token otherToken = new DurationFormatUtils.Token("value", false, -1);
        assertTrue(token.equals(otherToken));
    }

    @Test
    @DisplayName("Token should not be equal to another DurationFormatUtils.Token with a different value")
    void tokenShouldNotBeEqualToAnotherTokenWithDifferentValue() {
        DurationFormatUtils.Token otherToken = new DurationFormatUtils.Token("different", false, -1);
        assertFalse(token.equals(otherToken));
    }

    @Test
    @DisplayName("Token should not be equal to another DurationFormatUtils.Token with a different count")
    void tokenShouldNotBeEqualToAnotherTokenWithDifferentCount() {
        DurationFormatUtils.Token otherToken = new DurationFormatUtils.Token("value", false, -1);
        otherToken.increment();
        assertFalse(token.equals(otherToken));
    }

    @Test
    @DisplayName("Token should increment count correctly")
    void tokenShouldIncrementCountCorrectly() {
        assertEquals(1, token.getCount());
        token.increment();
        assertEquals(2, token.getCount());
    }

    @Test
    @DisplayName("Token should return correct value")
    void tokenShouldReturnCorrectValue() {
        assertEquals("value", token.getValue());
    }

    @Test
    @DisplayName("Token should return correct string representation")
    void tokenShouldReturnCorrectStringRepresentation() {
        assertEquals("value", token.toString());
    }

    @Test
    @DisplayName("Should return true if tokens contain value")
    void shouldReturnTrueIfTokensContainValue() {
        assertTrue(DurationFormatUtils.Token.containsTokenWithValue(tokens, "value1"));
    }

    @Test
    @DisplayName("Should return false if tokens do not contain value")
    void shouldReturnFalseIfTokensDoNotContainValue() {
        assertFalse(DurationFormatUtils.Token.containsTokenWithValue(tokens, "value3"));
    }

    @Test
    @DisplayName("Token should be equal to itself")
    void tokenShouldBeEqualItself2() {
        assertTrue(token.equals(token));
    }

    @Test
    @DisplayName("Token should not be equal to null")
    void tokenShouldNotBeEqualToNull2() {
        assertFalse(token.equals(null));
    }

    @Test
    @DisplayName("Token should not be equal to a different class")
    void tokenShouldNotBeEqualToDifferentClass2() {
        assertFalse(token.equals("value"));
    }

    @Test
    @DisplayName("Token should be equal to another DurationFormatUtils.Token with the same value and count")
    void tokenShouldBeEqualToAnotherTokenWithSameValueAndCount2() {
        DurationFormatUtils.Token otherToken = new DurationFormatUtils.Token("value", false, -1);
        assertTrue(token.equals(otherToken));
    }

    @Test
    @DisplayName("Token should not be equal to another DurationFormatUtils.Token with a different value")
    void tokenShouldNotBeEqualToAnotherTokenWithDifferentValue2() {
        DurationFormatUtils.Token otherToken = new DurationFormatUtils.Token("different", false, -1);
        assertFalse(token.equals(otherToken));
    }

    @Test
    @DisplayName("Token should not be equal to another DurationFormatUtils.Token with a different count")
    void tokenShouldNotBeEqualToAnotherTokenWithDifferentCount2() {
        DurationFormatUtils.Token otherToken = new DurationFormatUtils.Token("value", false, -1);
        otherToken.increment();
        assertFalse(token.equals(otherToken));
    }


    @Test
    @DisplayName("Token should have the same hash code as another DurationFormatUtils.Token with the same value")
    void tokenShouldHaveSameHashCodeAsAnotherTokenWithSameValue() {
        DurationFormatUtils.Token otherToken = new DurationFormatUtils.Token("value", false, -1);
        assertEquals(token.hashCode(), otherToken.hashCode());
    }


    @Test
    @DisplayName("should throw IllegalArgumentException for negative duration")
    void shouldThrowIllegalArgumentExceptionForNegativeDuration() {
        long durationMillis = -123456789;
        assertThrows(IllegalArgumentException.class, () -> DurationFormatUtils.formatDurationISO(durationMillis));
    }

    @Test
    @DisplayName("should format duration with zero values")
    void shouldFormatDurationWithZeroValues() {
        long durationMillis = 0;
        String expected = "P0Y0M0DT0H0M0.000S";
        assertEquals(expected, DurationFormatUtils.formatDurationISO(durationMillis));
    }


    @Test
    void testContainsTokenWithValue() {
        DurationFormatUtils.Token[] tokens = {new DurationFormatUtils.Token("y", false, -1), new DurationFormatUtils.Token("M", false, -1), new DurationFormatUtils.Token("d", false, -1)};

        // Test case 1: DurationFormatUtils.Token with value "M" exists in tokens
        boolean result1 = DurationFormatUtils.Token.containsTokenWithValue(tokens, "M");
        assertTrue(result1);
    }

    @Test
    void testEquals() {
        DurationFormatUtils.Token token1 = new DurationFormatUtils.Token("y", false, -1);
        DurationFormatUtils.Token token2 = new DurationFormatUtils.Token("y", false, -1);
        DurationFormatUtils.Token token3 = new DurationFormatUtils.Token("M", false, -1);

        // Test case 1: DurationFormatUtils.Token 1 and DurationFormatUtils.Token 2 are equal
        boolean result1 = token1.equals(token2);
        assertTrue(result1);
    }

    @Test
    void testGetCount() {
        DurationFormatUtils.Token token = new DurationFormatUtils.Token("y", false, -1);

        // Test case 1: DurationFormatUtils.Token count is 1
        int result1 = token.getCount();
        assertEquals(1, result1);
    }

    @Test
    void testGetValue() {
        DurationFormatUtils.Token token = new DurationFormatUtils.Token("y", false, -1);

        // Test case 1: DurationFormatUtils.Token value is "y"
        Object result1 = token.getValue();
        assertEquals("y", result1);
    }

    @Test
    void testHashCode2() {
        DurationFormatUtils.Token token1 = new DurationFormatUtils.Token("y", false, -1);
        DurationFormatUtils.Token token2 = new DurationFormatUtils.Token("y", false, -1);

        // Test case 1: DurationFormatUtils.Token 1 and DurationFormatUtils.Token 2 have the same hash code
        int hashCode1 = token1.hashCode();
        int hashCode2 = token2.hashCode();
        assertEquals(hashCode1, hashCode2);
    }

    @Test
    void testIncrement() {
        DurationFormatUtils.Token token = new DurationFormatUtils.Token("y", false, -1);

        // Test case 1: DurationFormatUtils.Token count is incremented
        token.increment();
        int result1 = token.getCount();
        assertEquals(2, result1);
    }

    @Test
    void testToString() {
        DurationFormatUtils.Token token = new DurationFormatUtils.Token("y", false, -1);

        // Test case 1: DurationFormatUtils.Token is represented as a string
        String result1 = token.toString();
        assertEquals("y", result1);
    }

    @Test
    @DisplayName("Test toString with empty token")
    void testToStringWithEmptyToken() {
        DurationFormatUtils.Token token = new DurationFormatUtils.Token("", false, -1);
        assertEquals("", token.toString());
    }

    @Test
    @DisplayName("Test toString with non-empty token")
    void testToStringWithNonEmptyToken() {
        DurationFormatUtils.Token token = new DurationFormatUtils.Token("M", false, -1);
        assertEquals("M", token.toString());
    }

    @Test
    @DisplayName("Test toString with multiple tokens")
    void testToStringWithMultipleTokens() {
        DurationFormatUtils.Token token = new DurationFormatUtils.Token("M", false, -1);
        token.increment();
        token.increment();
        assertEquals("MMM", token.toString());
    }


    @Test
    @DisplayName("Test toString with negative optional index")
    void testToStringWithNegativeOptionalIndex() {
        DurationFormatUtils.Token token = new DurationFormatUtils.Token("M", true, -1);
        assertEquals("M", token.toString());
    }



    @Test
    @DisplayName("Test toString with equal tokens")
    void testToStringWithEqualTokens() {
        DurationFormatUtils.Token token1 = new DurationFormatUtils.Token("M", false, -1);
        DurationFormatUtils.Token token2 = new DurationFormatUtils.Token("M", false, -1);
        assertTrue(token1.toString().equals(token2.toString()));
    }

    @Test
    @DisplayName("Test toString with different count")
    void testToStringWithDifferentCount() {
        DurationFormatUtils.Token token1 = new DurationFormatUtils.Token("M", false, -1);
        token1.increment();
        DurationFormatUtils.Token token2 = new DurationFormatUtils.Token("M", false, -1);
        assertEquals("MM", token1.toString());
        assertEquals("M", token2.toString());
    }

    @Test
    @DisplayName("Test toString with null value")
    void testToStringWithNullValue() {
        assertThrows(NullPointerException.class, () -> new DurationFormatUtils.Token(null, false, -1).toString());
    }


    @Test
    void testFormatDurationHMS_PositiveDuration() {
        long duration = 3661000; // 1 hour, 1 minute, 1 second
        String expected = "01:01:01.000";
        String actual = DurationFormatUtils.formatDurationHMS(duration);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testFormatDurationHMS_ZeroDuration() {
        long duration = 0;
        String expected = "00:00:00.000";
        String actual = DurationFormatUtils.formatDurationHMS(duration);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testFormatDurationHMS_NegativeDuration() {
        long duration = -1000; // -1 second
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            DurationFormatUtils.formatDurationHMS(duration);
        });
    }

    @Test
    void testFormatDurationHMS_MillisecondsOnly() {
        long duration = 500;
        String expected = "00:00:00.500";
        String actual = DurationFormatUtils.formatDurationHMS(duration);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testFormatDurationHMS_SecondsOnly() {
        long duration = 5000; // 5 seconds
        String expected = "00:00:05.000";
        String actual = DurationFormatUtils.formatDurationHMS(duration);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testFormatDurationHMS_MinutesOnly() {
        long duration = 300000; // 5 minutes
        String expected = "00:05:00.000";
        String actual = DurationFormatUtils.formatDurationHMS(duration);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testFormatDurationHMS_HoursOnly() {
        long duration = 7200000; // 2 hours
        String expected = "02:00:00.000";
        String actual = DurationFormatUtils.formatDurationHMS(duration);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testFormatDurationHMS_DaysOnly() {
        long duration = 86400000; // 1 day
        String expected = "24:00:00.000";
        String actual = DurationFormatUtils.formatDurationHMS(duration);
        Assertions.assertEquals(expected, actual);
    }

}