import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

class equalsTest {

    private Fraction fraction1;
    private Fraction fraction2;

    @BeforeEach
    void setUp() {
        fraction1 = new Fraction(1, 2);
        fraction2 = new Fraction(1, 2);
    }

    @Test
    void testEquals_sameObject_true() {
        assertTrue(fraction1.equals(fraction1));
    }

    @Test
    void testEquals_differentClass_false() {
        assertFalse(fraction1.equals("test"));
    }

    @Test
    void testEquals_null_false() {
        assertFalse(fraction1.equals(null));
    }

    @Test
    void testEquals_equalFractions_true() {
        assertTrue(fraction1.equals(fraction2));
    }

    @Test
    void testEquals_differentNumerators_false() {
        fraction2 = new Fraction(3, 2);
        assertFalse(fraction1.equals(fraction2));
    }

    @Test
    void testEquals_differentDenominators_false() {
        fraction2 = new Fraction(1, 3);
        assertFalse(fraction1.equals(fraction2));
    }
}