import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class divideByTest {

    private Fraction fraction;

    @BeforeEach
    void setUp() {
        fraction = new Fraction(3, 7);
    }

    @Test
    void testDivideBy() {
        Fraction result = fraction.divideBy(new Fraction(2, 5));
        assertEquals(15, result.numerator);
        assertEquals(14, result.denominator);
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> {
            fraction.divideBy(new Fraction(0, 1));
        });
    }

    @Test
    void testDivideByNullFraction() {
        assertThrows(NullPointerException.class, () -> {
            fraction.divideBy(null);
        });
    }
}