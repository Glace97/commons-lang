import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class multiplyByTest {

    private Fraction fraction;

    @BeforeEach
    void setUp() {
        fraction = new Fraction(3, 7);
    }

    @Nested
    @DisplayName("When multiplying by a valid fraction")
    class MultiplyByValidFraction {

        @Test
        @DisplayName("Should return the correct result")
        void shouldReturnCorrectResult() {
            Fraction result = fraction.multiplyBy(new Fraction(2, 5));
            assertEquals(new Fraction(6, 35), result);
        }

        @Test
        @DisplayName("Should handle zero numerator in input fraction")
        void shouldHandleZeroNumerator() {
            Fraction result = fraction.multiplyBy(new Fraction(0, 5));
            assertEquals(Fraction.ZERO, result);
        }

        @Test
        @DisplayName("Should handle zero numerator in current fraction")
        void shouldHandleZeroNumeratorInCurrentFraction() {
            Fraction result = Fraction.ZERO.multiplyBy(new Fraction(2, 5));
            assertEquals(Fraction.ZERO, result);
        }
    }

    @Nested
    @DisplayName("When multiplying by null")
    class MultiplyByNull {

        @Test
        @DisplayName("Should throw NullPointerException")
        void shouldThrowNullPointerException() {
            assertThrows(NullPointerException.class, () -> fraction.multiplyBy(null));
        }
    }

    @Nested
    @DisplayName("When multiplying by a fraction that results in overflow")
    class MultiplyByOverflowFraction {

        @Test
        @DisplayName("Should throw ArithmeticException")
        void shouldThrowArithmeticException() {
            assertThrows(ArithmeticException.class, () -> fraction.multiplyBy(new Fraction(Integer.MAX_VALUE, 2)));
        }
    }

}