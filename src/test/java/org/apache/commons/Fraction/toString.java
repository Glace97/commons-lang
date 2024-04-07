
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ToStringTest {

    @Nested
    @DisplayName("When the fraction is a positive integer")
    class PositiveIntegerFractionToStringTest {

        private Fraction fraction;

        @BeforeEach
        void setUp() {
            fraction = new Fraction(5, 1); // 5/1 = 5
        }

        @Test
        @DisplayName("Should return the correct string representation")
        void shouldReturnCorrectStringRepresentation() {
            assertEquals("5/1", fraction.toString());
        }
    }

    @Nested
    @DisplayName("When the fraction is a negative integer")
    class NegativeIntegerFractionToStringTest {

        private Fraction fraction;

        @BeforeEach
        void setUp() {
            fraction = new Fraction(-7, 1); // -7/1 = -7
        }

        @Test
        @DisplayName("Should return the correct string representation")
        void shouldReturnCorrectStringRepresentation() {
            assertEquals("-7/1", fraction.toString());
        }
    }

    @Nested
    @DisplayName("When the fraction is a positive proper fraction")
    class PositiveProperFractionToStringTest {

        private Fraction fraction;

        @BeforeEach
        void setUp() {
            fraction = new Fraction(3, 5); // 3/5
        }

        @Test
        @DisplayName("Should return the correct string representation")
        void shouldReturnCorrectStringRepresentation() {
            assertEquals("3/5", fraction.toString());
        }
    }

    @Nested
    @DisplayName("When the fraction is a negative proper fraction")
    class NegativeProperFractionToStringTest {

        private Fraction fraction;

        @BeforeEach
        void setUp() {
            fraction = new Fraction(-2, 3); // -2/3
        }

        @Test
        @DisplayName("Should return the correct string representation")
        void shouldReturnCorrectStringRepresentation() {
            assertEquals("-2/3", fraction.toString());
        }
    }

    @Nested
    @DisplayName("When the fraction is zero")
    class ZeroFractionToStringTest {

        private Fraction fraction;

        @BeforeEach
        void setUp() {
            fraction = Fraction.ZERO; // 0/1 = 0
        }

        @Test
        @DisplayName("Should return the correct string representation")
        void shouldReturnCorrectStringRepresentation() {
            assertEquals("0/1", fraction.toString());
        }
    }

    @Nested
    @DisplayName("When the fraction is one")
    class OneFractionToStringTest {

        private Fraction fraction;

        @BeforeEach
        void setUp() {
            fraction = Fraction.ONE; // 1/1 = 1
        }

        @Test
        @DisplayName("Should return the correct string representation")
        void shouldReturnCorrectStringRepresentation() {
            assertEquals("1/1", fraction.toString());
        }
    }
}
