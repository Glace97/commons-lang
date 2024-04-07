import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import org.apache.commons.lang3.function.Suppliers;
import org.apache.commons.lang3.function.ToBooleanBiFunction;
import org.apache.commons.lang3.stream.LangCollectors;
import org.apache.commons.lang3.stream.Streams;

class StringUtilsTest {
    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Nested
    @DisplayName("Tests for getLevenshteinDistance method")
    class GetLevenshteinDistanceTests {
        @Test
        @DisplayName("Should throw IllegalArgumentException when first string is null")
        void shouldThrowIllegalArgumentExceptionWhenFirstStringIsNull() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                stringUtils.getLevenshteinDistance(null, "test");
            });
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException when second string is null")
        void shouldThrowIllegalArgumentExceptionWhenSecondStringIsNull() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                stringUtils.getLevenshteinDistance("test", null);
            });
        }

        @Test
        @DisplayName("Should return 0 when both strings are empty")
        void shouldReturnZeroWhenBothStringsAreEmpty() {
            int distance = stringUtils.getLevenshteinDistance("", "");
            Assertions.assertEquals(0, distance);
        }

        @Test
        @DisplayName("Should return 1 when first string is empty and second string has one character")
        void shouldReturnOneWhenFirstStringIsEmptyAndSecondStringHasOneCharacter() {
            int distance = stringUtils.getLevenshteinDistance("", "a");
            Assertions.assertEquals(1, distance);
        }

        @Test
        @DisplayName("Should return 7 when first string is 'aaapppp' and second string is empty")
        void shouldReturnSevenWhenFirstStringIsAaappppAndSecondStringIsEmpty() {
            int distance = stringUtils.getLevenshteinDistance("aaapppp", "");
            Assertions.assertEquals(7, distance);
        }

        @Test
        @DisplayName("Should return 1 when first string is 'frog' and second string is 'fog'")
        void shouldReturnOneWhenFirstStringIsFrogAndSecondStringIsFog() {
            int distance = stringUtils.getLevenshteinDistance("frog", "fog");
            Assertions.assertEquals(1, distance);
        }

        @Test
        @DisplayName("Should return 3 when first string is 'fly' and second string is 'ant'")
        void shouldReturnThreeWhenFirstStringIsFlyAndSecondStringIsAnt() {
            int distance = stringUtils.getLevenshteinDistance("fly", "ant");
            Assertions.assertEquals(3, distance);
        }

        @Test
        @DisplayName("Should return 7 when first string is 'elephant' and second string is 'hippo'")
        void shouldReturnSevenWhenFirstStringIsElephantAndSecondStringIsHippo() {
            int distance = stringUtils.getLevenshteinDistance("elephant", "hippo");
            Assertions.assertEquals(7, distance);
        }

        @Test
        @DisplayName("Should return 7 when first string is 'hippo' and second string is 'elephant'")
        void shouldReturnSevenWhenFirstStringIsHippoAndSecondStringIsElephant() {
            int distance = stringUtils.getLevenshteinDistance("hippo", "elephant");
            Assertions.assertEquals(7, distance);
        }

        @Test
        @DisplayName("Should return 8 when first string is 'hippo' and second string is 'zzzzzzzz'")
        void shouldReturnEightWhenFirstStringIsHippoAndSecondStringIsZzzzzzzz() {
            int distance = stringUtils.getLevenshteinDistance("hippo", "zzzzzzzz");
            Assertions.assertEquals(8, distance);
        }

        @Test
        @DisplayName("Should return 1 when first string is 'hello' and second string is 'hallo'")
        void shouldReturnOneWhenFirstStringIsHelloAndSecondStringIsHallo() {
            int distance = stringUtils.getLevenshteinDistance("hello", "hallo");
            Assertions.assertEquals(1, distance);
        }
    }

    @Nested
    @DisplayName("Tests for getLevenshteinDistance method with threshold")
    class GetLevenshteinDistanceWithThresholdTests {
        @Test
        @DisplayName("Should throw IllegalArgumentException when first string is null")
        void shouldThrowIllegalArgumentExceptionWhenFirstStringIsNull() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                stringUtils.getLevenshteinDistance(null, "test", 5);
            });
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException when second string is null")
        void shouldThrowIllegalArgumentExceptionWhenSecondStringIsNull() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                stringUtils.getLevenshteinDistance("test", null, 5);
            });
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException when threshold is negative")
        void shouldThrowIllegalArgumentExceptionWhenThresholdIsNegative() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                stringUtils.getLevenshteinDistance("test", "test", -1);
            });
        }

        @Test
        @DisplayName("Should return 0 when both strings are empty and threshold is 0")
        void shouldReturnZeroWhenBothStringsAreEmptyAndThresholdIsZero() {
            int distance = stringUtils.getLevenshteinDistance("", "", 0);
            Assertions.assertEquals(0, distance);
        }

        @Test
        @DisplayName("Should return 7 when first string is 'aaapppp', second string is empty, and threshold is 8")
        void shouldReturnSevenWhenFirstStringIsAaappppSecondStringIsEmptyAndThresholdIsEight() {
            int distance = stringUtils.getLevenshteinDistance("aaapppp", "", 8);
            Assertions.assertEquals(7, distance);
        }

        @Test
        @DisplayName("Should return 7 when first string is 'aaapppp', second string is empty, and threshold is 7")
        void shouldReturnSevenWhenFirstStringIsAaappppSecondStringIsEmptyAndThresholdIsSeven() {
            int distance = stringUtils.getLevenshteinDistance("aaapppp", "", 7);
            Assertions.assertEquals(7, distance);
        }

        @Test
        @DisplayName("Should return -1 when first string is 'aaapppp', second string is empty, and threshold is 6")
        void shouldReturnNegativeOneWhenFirstStringIsAaappppSecondStringIsEmptyAndThresholdIsSix() {
            int distance = stringUtils.getLevenshteinDistance("aaapppp", "", 6);
            Assertions.assertEquals(-1, distance);
        }

        @Test
        @DisplayName("Should return 7 when first string is 'elephant', second string is 'hippo', and threshold is 7")
        void shouldReturnSevenWhenFirstStringIsElephantSecondStringIsHippoAndThresholdIsSeven() {
            int distance = stringUtils.getLevenshteinDistance("elephant", "hippo", 7);
            Assertions.assertEquals(7, distance);
        }

        @Test
        @DisplayName("Should return -1 when first string is 'elephant', second string is 'hippo', and threshold is 6")
        void shouldReturnNegativeOneWhenFirstStringIsElephantSecondStringIsHippoAndThresholdIsSix() {
            int distance = stringUtils.getLevenshteinDistance("elephant", "hippo", 6);
            Assertions.assertEquals(-1, distance);
        }

        @Test
        @DisplayName("Should return 7 when first string is 'hippo', second string is 'elephant', and threshold is 7")
        void shouldReturnSevenWhenFirstStringIsHippoSecondStringIsElephantAndThresholdIsSeven() {
            int distance = stringUtils.getLevenshteinDistance("hippo", "elephant", 7);
            Assertions.assertEquals(7, distance);
        }

        @Test
        @DisplayName("Should return -1 when first string is 'hippo', second string is 'elephant', and threshold is 6")
        void shouldReturnNegativeOneWhenFirstStringIsHippoSecondStringIsElephantAndThresholdIsSix() {
            int distance = stringUtils.getLevenshteinDistance("hippo", "elephant", 6);
            Assertions.assertEquals(-1, distance);
        }
    }
}