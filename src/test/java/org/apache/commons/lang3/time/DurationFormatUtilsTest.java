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

public class DurationFormatUtilsTest {
    import static org.junit.jupiter.api.Assertions.assertEquals;
    
    import org.junit.jupiter.api.Test;
    
    class DurationFormatUtilsTest {
    
        @Test
        void testFormatPeriod() {
            // test logic here
        }
    
        @Test
        void testFormatPeriodWithInvalidInput() {
            // test logic here
        }
    
        @Test
        void testFormatPeriodWithPaddingZeros() {
            // test logic here
        }
    
        @Test
        void testFormatPeriodWithoutPaddingZeros() {
            // test logic here
        }
    
        @Test
        void testFormatPeriodWithTimeZone() {
            // test logic here
        }
    
        @Test
        void testFormatPeriodWithAllUnits() {
            // test logic here
        }
    
        @Test
        void testFormatPeriodWithMonthsAndDays() {
            // test logic here
        }
    
        @Test
        void testFormatPeriodWithYearsMonthsAndDays() {
            // test logic here
        }
    
        @Test
        void testFormatPeriodWithAllUnitsAndPaddingZeros() {
            // test logic here
        }
    }
    @Test
    void testFormatDuration_ZeroDuration() {
      long durationMillis = 0;
      String format = "HH:mm:ss.SSS";
      String expected = "00:00:00.000";
    
      String result = durationFormatUtils.formatDuration(durationMillis, format);
    
      assertEquals(expected, result);
    }
    
    @Test
    void testFormatDuration_PositiveDuration() {
      long durationMillis = 123456789;
      String format = "HH:mm:ss.SSS";
      String expected = "34:17:36.789";
    
      String result = durationFormatUtils.formatDuration(durationMillis, format);
    
      assertEquals(expected, result);
    }
    
    @Test
    void testFormatDuration_NegativeDuration() {
      long durationMillis = -123456789;
      String format = "HH:mm:ss.SSS";
    
      assertThrows(IllegalArgumentException.class, () -> {
        durationFormatUtils.formatDuration(durationMillis, format);
      });
    }
    
    @Test
    void testFormatDuration_DurationWithDays() {
      long durationMillis = 123456789;
      String format = "d HH:mm:ss.SSS";
      String expected = "1 10:17:36.789";
    
      String result = durationFormatUtils.formatDuration(durationMillis, format);
    
      assertEquals(expected, result);
    }
    
    @Test
    void testFormatDuration_DurationWithHours() {
      long durationMillis = 123456789;
      String format = "HH:mm:ss.SSS";
      String expected = "34:17:36.789";
    
      String result = durationFormatUtils.formatDuration(durationMillis, format);
    
      assertEquals(expected, result);
    }
    
    @Test
    void testFormatDuration_DurationWithMinutes() {
      long durationMillis = 123456789;
      String format = "mm:ss.SSS";
      String expected = "2057:36.789";
    
      String result = durationFormatUtils.formatDuration(durationMillis, format);
    
      assertEquals(expected, result);
    }
    
    @Test
    void testFormatDuration_DurationWithSeconds() {
      long durationMillis = 123456789;
      String format = "ss.SSS";
      String expected = "2057.789";
    
      String result = durationFormatUtils.formatDuration(durationMillis, format);
    
      assertEquals(expected, result);
    }
    
    @Test
    void testFormatDuration_DurationWithMilliseconds() {
      long durationMillis = 123456789;
      String format = "SSS";
      String expected = "789";
    
      String result = durationFormatUtils.formatDuration(durationMillis, format);
    
      assertEquals(expected, result);
    }
    
    @Test
    void testFormatDuration_DurationWithPadding() {
      long durationMillis = 123456789;
      String format = "HH:mm:ss.SSS";
      String expected = "34:17:36.789";
    
      String result = durationFormatUtils.formatDuration(durationMillis, format, true);
    
      assertEquals(expected, result);
    }
    
    @Test
    void testFormatDuration_DurationWithoutPadding() {
      long durationMillis = 123456789;
      String format = "HH:mm:ss.SSS";
      String expected = "34:17:36.789";
    
      String result = durationFormatUtils.formatDuration(durationMillis, format, false);
    
      assertEquals(expected, result);
    }
    
    @Test
    void testFormatDuration_DurationWithInvalidFormat() {
      long durationMillis = 123456789;
      String format = "HH:mm:ss.SS";
    
      assertThrows(IllegalArgumentException.class, () -> {
        durationFormatUtils.formatDuration(durationMillis, format);
      });
    }
    @Test
    void testContainsTokenWithValue_shouldReturnTrueIfTokenWithValueExists() {
        tokens = new DurationFormatUtils.Token[] {
                new DurationFormatUtils.Token("y", false, -1),
                new DurationFormatUtils.Token("M", false, -1),
                new DurationFormatUtils.Token("d", false, -1)
        };
    
        boolean result = DurationFormatUtils.containsTokenWithValue(tokens, "M");
    
        assertTrue(result);
    }
    
    @Test
    void testContainsTokenWithValue_shouldReturnFalseIfTokenWithValueDoesNotExist() {
        tokens = new DurationFormatUtils.Token[] {
                new DurationFormatUtils.Token("y", false, -1),
                new DurationFormatUtils.Token("M", false, -1),
                new DurationFormatUtils.Token("d", false, -1)
        };
    
        boolean result = DurationFormatUtils.containsTokenWithValue(tokens, "H");
    
        assertFalse(result);
    }
    
    @Test
    void testContainsTokenWithValue_shouldReturnFalseIfTokensArrayIsEmpty() {
        tokens = new DurationFormatUtils.Token[]{};
    
        boolean result = DurationFormatUtils.containsTokenWithValue(tokens, "M");
    
        assertFalse(result);
    }
    
    @Test
    void testContainsTokenWithValue_shouldReturnFalseIfValueIsNull() {
        tokens = new DurationFormatUtils.Token[] {
                new DurationFormatUtils.Token("y", false, -1),
                new DurationFormatUtils.Token("M", false, -1),
                new DurationFormatUtils.Token("d", false, -1)
        };
    
        boolean result = DurationFormatUtils.containsTokenWithValue(tokens, null);
    
        assertFalse(result);
    }
    @Test
    @DisplayName("Test formatPeriodISO - valid input")
    void testFormatPeriodISO() {
        String expected = "P1970Y8M3DT2H46M40S";
        String result = DurationFormatUtils.formatPeriodISO(startMillis, endMillis);
        assertEquals(expected, result);
    }
    
    @Test
    @DisplayName("Test formatPeriodISO - startMillis greater than endMillis")
    void testFormatPeriodISO_StartMillisGreaterThanEndMillis() {
        assertThrows(IllegalArgumentException.class, () -> {
            DurationFormatUtils.formatPeriodISO(endMillis, startMillis);
        });
    }
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    import org.junit.jupiter.api.TestInstance.Lifecycle;
    
    @TestInstance(Lifecycle.PER_CLASS)
    class DurationFormatUtilsTest {
    
        @Test
        void testHashCode() {
            Token token1 = new Token("y", false, -1);
            Token token2 = new Token("y", false, -1);
            Token token3 = new Token("M", false, -1);
            Token token4 = new Token("M", true, 0);
    
            Assertions.assertEquals(token1.hashCode(), token2.hashCode());
            Assertions.assertNotEquals(token1.hashCode(), token3.hashCode());
            Assertions.assertNotEquals(token1.hashCode(), token4.hashCode());
        }
    }
    
    @Test
    void testLexxWithEmptyFormat() {
        String format = "";
        Token[] tokens = DurationFormatUtils.lexx(format);
        Assertions.assertEquals(0, tokens.length);
    }
    
    @Test
    void testLexxWithValidFormat() {
        String format = "yyyy-MM-dd'T'HH:mm:ss.SSS";
        Token[] tokens = DurationFormatUtils.lexx(format);
        Assertions.assertEquals(7, tokens.length);
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, "y"));
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, "M"));
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, "d"));
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, "H"));
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, "m"));
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, "s"));
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, "S"));
    }
    
    @Test
    void testLexxWithLiteralQuotes() {
        String format = "'yyyy'-'MM'-'dd'T'HH:mm:ss.SSS";
        Token[] tokens = DurationFormatUtils.lexx(format);
        Assertions.assertEquals(7, tokens.length);
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, "yyyy"));
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, "-"));
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, "MM"));
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, "-"));
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, "dd"));
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, "T"));
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, "HH"));
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, ":"));
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, "mm"));
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, ":"));
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, "ss"));
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, "."));
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, "SSS"));
    }
    
    @Test
    void testLexxWithOptionalBlocks() {
        String format = "[yyyy][MM][dd][HH][mm][ss][SSS]";
        Token[] tokens = DurationFormatUtils.lexx(format);
        Assertions.assertEquals(7, tokens.length);
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, "y"));
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, "M"));
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, "d"));
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, "H"));
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, "m"));
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, "s"));
        Assertions.assertTrue(Token.containsTokenWithValue(tokens, "S"));
        Assertions.assertEquals(0, tokens[0].getCount());
        Assertions.assertEquals(0, tokens[1].getCount());
        Assertions.assertEquals(0, tokens[2].getCount());
        Assertions.assertEquals(0, tokens[3].getCount());
        Assertions.assertEquals(0, tokens[4].getCount());
        Assertions.assertEquals(0, tokens[5].getCount());
        Assertions.assertEquals(0, tokens[6].getCount());
        Assertions.assertEquals(0, tokens[0].optionalIndex);
        Assertions.assertEquals(1, tokens[1].optionalIndex);
        Assertions.assertEquals(2, tokens[2].optionalIndex);
        Assertions.assertEquals(3, tokens[3].optionalIndex);
        Assertions.assertEquals(4, tokens[4].optionalIndex);
        Assertions.assertEquals(5, tokens[5].optionalIndex);
        Assertions.assertEquals(6, tokens[6].optionalIndex);
    }
    
    @Test
    void testLexxWithInvalidOptionalBlocks() {
        String format = "[yyyy[MM][dd][HH]]mm[ss][SSS]";
        Assertions.assertThrows(IllegalArgumentException.class, () -> DurationFormatUtils.lexx(format));
    }
    
    @Test
    void testLexxWithUnmatchedQuotes() {
        String format = "'yyyy'-'MM'-'dd'T'HH:mm:ss.SSS'";
        Assertions.assertThrows(IllegalArgumentException.class, () -> DurationFormatUtils.lexx(format));
    }
    import static org.junit.jupiter.api.Assertions.*;
    
    import org.junit.jupiter.api.BeforeEach;
    import org.junit.jupiter.api.DisplayName;
    import org.junit.jupiter.api.Nested;
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    import org.junit.jupiter.api.TestInstance.Lifecycle;
    
    import java.util.Objects;
    import java.util.stream.Stream;
    
    class DurationFormatUtilsTest {
    
        @Nested
        @DisplayName("Token")
        class TokenTest {
    
            private Token token;
    
            @BeforeEach
            void setUp() {
                token = new Token("value", false, -1);
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
            @DisplayName("Token should be equal to another Token with the same value and count")
            void tokenShouldBeEqualToAnotherTokenWithSameValueAndCount() {
                Token otherToken = new Token("value", false, -1);
                assertTrue(token.equals(otherToken));
            }
    
            @Test
            @DisplayName("Token should not be equal to another Token with a different value")
            void tokenShouldNotBeEqualToAnotherTokenWithDifferentValue() {
                Token otherToken = new Token("different", false, -1);
                assertFalse(token.equals(otherToken));
            }
    
            @Test
            @DisplayName("Token should not be equal to another Token with a different count")
            void tokenShouldNotBeEqualToAnotherTokenWithDifferentCount() {
                Token otherToken = new Token("value", false, -1);
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
        }
    
        @Nested
        @DisplayName("containsTokenWithValue")
        class ContainsTokenWithValueTest {
    
            private Token[] tokens;
    
            @BeforeEach
            void setUp() {
                Token token1 = new Token("value1", false, -1);
                Token token2 = new Token("value2", false, -1);
                tokens = new Token[] {token1, token2};
            }
    
            @Test
            @DisplayName("Should return true if tokens contain value")
            void shouldReturnTrueIfTokensContainValue() {
                assertTrue(Token.containsTokenWithValue(tokens, "value1"));
            }
    
            @Test
            @DisplayName("Should return false if tokens do not contain value")
            void shouldReturnFalseIfTokensDoNotContainValue() {
                assertFalse(Token.containsTokenWithValue(tokens, "value3"));
            }
        }
    
        @Nested
        @DisplayName("equals")
        class EqualsTest {
    
            private Token token;
    
            @BeforeEach
            void setUp() {
                token = new Token("value", false, -1);
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
            @DisplayName("Token should be equal to another Token with the same value and count")
            void tokenShouldBeEqualToAnotherTokenWithSameValueAndCount() {
                Token otherToken = new Token("value", false, -1);
                assertTrue(token.equals(otherToken));
            }
    
            @Test
            @DisplayName("Token should not be equal to another Token with a different value")
            void tokenShouldNotBeEqualToAnotherTokenWithDifferentValue() {
                Token otherToken = new Token("different", false, -1);
                assertFalse(token.equals(otherToken));
            }
    
            @Test
            @DisplayName("Token should not be equal to another Token with a different count")
            void tokenShouldNotBeEqualToAnotherTokenWithDifferentCount() {
                Token otherToken = new Token("value", false, -1);
                otherToken.increment();
                assertFalse(token.equals(otherToken));
            }
        }
    
        @Nested
        @DisplayName("hashCode")
        class HashCodeTest {
    
            private Token token;
    
            @BeforeEach
            void setUp() {
                token = new Token("value", false, -1);
            }
    
            @Test
            @DisplayName("Token should have the same hash code as another Token with the same value")
            void tokenShouldHaveSameHashCodeAsAnotherTokenWithSameValue() {
                Token otherToken = new Token("value", false, -1);
                assertEquals(token.hashCode(), otherToken.hashCode());
            }
        }
    }
    @Test
    @DisplayName("should format duration in ISO format")
    void shouldFormatDurationInISOFormat() {
        long durationMillis = 123456789;
        String expected = "P0Y0M0DT3H25M56.789S";
        assertEquals(expected, durationFormatUtils.formatDurationISO(durationMillis));
    }
    
    @Test
    @DisplayName("should throw IllegalArgumentException for negative duration")
    void shouldThrowIllegalArgumentExceptionForNegativeDuration() {
        long durationMillis = -123456789;
        assertThrows(IllegalArgumentException.class, () -> durationFormatUtils.formatDurationISO(durationMillis));
    }
    
    @Test
    @DisplayName("should format duration with zero values")
    void shouldFormatDurationWithZeroValues() {
        long durationMillis = 0;
        String expected = "P0Y0M0DT0H0M0.000S";
        assertEquals(expected, durationFormatUtils.formatDurationISO(durationMillis));
    }
    import org.junit.jupiter.api.Test;
    import org.junit.jupiter.api.TestInstance;
    import org.junit.jupiter.api.TestInstance.Lifecycle;
    import static org.junit.jupiter.api.Assertions.*;
    
    @TestInstance(Lifecycle.PER_CLASS)
    class DurationFormatUtilsTest {
      
      @Test
      void testFormat() {
        // Test case 1: Formatting with all tokens
        Token[] tokens1 = {new Token("P", false, -1), new Token("y", false, -1), new Token("M", false, -1), new Token("d", false, -1), new Token("T", false, -1), new Token("H", false, -1), new Token("m", false, -1), new Token("s", false, -1), new Token(".", false, -1), new Token("S", false, -1)};
        String result1 = DurationFormatUtils.format(tokens1, 1, 2, 3, 4, 5, 6, 7, true);
        assertEquals("P1Y2M3DT4H5M6.007S", result1);
      }
      
      @Test
      void testContainsTokenWithValue() {
        Token[] tokens = {new Token("y", false, -1), new Token("M", false, -1), new Token("d", false, -1)};
        
        // Test case 1: Token with value "M" exists in tokens
        boolean result1 = Token.containsTokenWithValue(tokens, "M");
        assertTrue(result1);
      }
      
      @Test
      void testEquals() {
        Token token1 = new Token("y", false, -1);
        Token token2 = new Token("y", false, -1);
        Token token3 = new Token("M", false, -1);
        
        // Test case 1: Token 1 and Token 2 are equal
        boolean result1 = token1.equals(token2);
        assertTrue(result1);
      }
      
      @Test
      void testGetCount() {
        Token token = new Token("y", false, -1);
        
        // Test case 1: Token count is 1
        int result1 = token.getCount();
        assertEquals(1, result1);
      }
      
      @Test
      void testGetValue() {
        Token token = new Token("y", false, -1);
        
        // Test case 1: Token value is "y"
        Object result1 = token.getValue();
        assertEquals("y", result1);
      }
      
      @Test
      void testHashCode() {
        Token token1 = new Token("y", false, -1);
        Token token2 = new Token("y", false, -1);
        
        // Test case 1: Token 1 and Token 2 have the same hash code
        int hashCode1 = token1.hashCode();
        int hashCode2 = token2.hashCode();
        assertEquals(hashCode1, hashCode2);
      }
      
      @Test
      void testIncrement() {
        Token token = new Token("y", false, -1);
        
        // Test case 1: Token count is incremented
        token.increment();
        int result1 = token.getCount();
        assertEquals(2, result1);
      }
      
      @Test
      void testToString() {
        Token token = new Token("y", false, -1);
        
        // Test case 1: Token is represented as a string
        String result1 = token.toString();
        assertEquals("y", result1);
      }
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
    @DisplayName("Test toString with optional token")
    void testToStringWithOptionalToken() {
        DurationFormatUtils.Token token = new DurationFormatUtils.Token("M", true, 0);
        assertEquals("M?", token.toString());
    }
    
    @Test
    @DisplayName("Test toString with negative optional index")
    void testToStringWithNegativeOptionalIndex() {
        DurationFormatUtils.Token token = new DurationFormatUtils.Token("M", true, -1);
        assertEquals("M", token.toString());
    }
    
    @Test
    @DisplayName("Test toString with different value types")
    void testToStringWithDifferentValueTypes() {
        DurationFormatUtils.Token token1 = new DurationFormatUtils.Token(new StringBuilder("M"), false, -1);
        DurationFormatUtils.Token token2 = new DurationFormatUtils.Token(1, false, -1);
        DurationFormatUtils.Token token3 = new DurationFormatUtils.Token(1.5, false, -1);
        assertTrue(token1.toString().equals(token2.toString()) && token2.toString().equals(token3.toString()));
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
    import org.junit.jupiter.api.Assertions;
    import org.junit.jupiter.api.Test;
    
    class DurationFormatUtilsTest {
    
        @Test
        void formatDurationWords_shouldFormatDurationWithLeadingZeroElements() {
            long duration = 123456789;
            String expected = "0 days 3 hours 25 minutes 56 seconds";
            String actual = DurationFormatUtils.formatDurationWords(duration, false, false);
            Assertions.assertEquals(expected, actual);
        }
    
        @Test
        void formatDurationWords_shouldFormatDurationWithoutLeadingZeroElements() {
            long duration = 123456789;
            String expected = "3 hours 25 minutes 56 seconds";
            String actual = DurationFormatUtils.formatDurationWords(duration, true, false);
            Assertions.assertEquals(expected, actual);
        }
    
        @Test
        void formatDurationWords_shouldFormatDurationWithTrailingZeroElements() {
            long duration = 123456789;
            String expected = "0 days 3 hours 25 minutes 56 seconds";
            String actual = DurationFormatUtils.formatDurationWords(duration, false, true);
            Assertions.assertEquals(expected, actual);
        }
    
        @Test
        void formatDurationWords_shouldFormatDurationWithoutTrailingZeroElements() {
            long duration = 123456789;
            String expected = "0 days 3 hours 25 minutes 56 seconds";
            String actual = DurationFormatUtils.formatDurationWords(duration, true, true);
            Assertions.assertEquals(expected, actual);
        }
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
    void testFormatDurationHMS_LargeDuration() {
        long duration = Long.MAX_VALUE; // Maximum value of long
        String expected = "9223372036854775807:59:59.999";
        String actual = DurationFormatUtils.formatDurationHMS(duration);
        Assertions.assertEquals(expected, actual);
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