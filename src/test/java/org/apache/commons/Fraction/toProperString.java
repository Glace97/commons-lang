
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("toProperString Test Suite")
class toProperStringTest {

    private static Fraction fraction;

    @BeforeAll
    static void setup() {
        fraction = new Fraction(3, 7);
    }

    @Nested
    @DisplayName("Positive Test Cases")
    class PositiveTests {
        @Test
        @DisplayName("Test toProperString for fraction with non-zero numerator and denominator")
        void testToProperStringNonZero() {
            assertEquals("3/7", fraction.toProperString());
        }

        @Test
        @DisplayName("Test toProperString for fraction with zero numerator")
        void testToProperStringZeroNumerator() {
            Fraction zeroNumerator = new Fraction(0, 7);
            assertEquals("0", zeroNumerator.toProperString());
        }

        @Test
        @DisplayName("Test toProperString for fraction with numerator equal to denominator")
        void testToProperStringNumeratorEqualsDenominator() {
            Fraction numeratorEqualsDenominator = new Fraction(7, 7);
            assertEquals("1", numeratorEqualsDenominator.toProperString());
        }

        @Test
        @DisplayName("Test toProperString for fraction with numerator equal to negative denominator")
        void testToProperStringNumeratorEqualsNegativeDenominator() {
            Fraction numeratorEqualsNegativeDenominator = new Fraction(7, -7);
            assertEquals("-1", numeratorEqualsNegativeDenominator.toProperString());
        }

        @Test
        @DisplayName("Test toProperString for fraction with numerator greater than denominator")
        void testToProperStringNumeratorGreaterThanDenominator() {
            Fraction numeratorGreaterThanDenominator = new Fraction(9, 7);
            assertEquals("1 2/7", numeratorGreaterThanDenominator.toProperString());
        }
    }

    @Nested
    @DisplayName("Edge Test Cases")
    class EdgeTests {
        @Test
        @DisplayName("Test toProperString for fraction with negative numerator")
        void testToProperStringNegativeNumerator() {
            Fraction negativeNumerator = new Fraction(-3, 7);
            assertEquals("-3/7", negativeNumerator.toProperString());
        }

        @Test
        @DisplayName("Test toProperString for fraction with negative denominator")
        void testToProperStringNegativeDenominator() {
            Fraction negativeDenominator = new Fraction(3, -7);
            assertEquals("-3/7", negativeDenominator.toProperString());
        }

        @Test
        @DisplayName("Test toProperString for fraction with negative numerator and denominator")
        void testToProperStringNegativeNumeratorAndDenominator() {
            Fraction negativeNumeratorAndDenominator = new Fraction(-3, -7);
            assertEquals("3/7", negativeNumeratorAndDenominator.toProperString());
        }
    }
}
